package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.BdInstallInstance;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.DeviceTokenService;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.IEventDepend;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.RegisterResultListener;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.bytedance.bdinstall.callback.event.RequestDrSuccessEvent;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.storage.DeviceParamProviderCreator;
import com.bytedance.bdinstall.storage.ICache;
import com.bytedance.bdinstall.storage.SPCache;
import com.bytedance.bdinstall.util.DataObserverInstance;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.bdinstall.util.Singleton;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceManager implements RegisterResultListener {
    private static final String KEY_DR_AID = "dr_aid";
    private static final String KEY_DR_CHANNEL = "dr_channel";
    private static final String KEY_INSTALL_VERSION_CODE = "dr_install_vc";
    private static final int MAX_PERMISSION = 10;
    public static final int STATE_DIFF = 2;
    public static final int STATE_EMPTY = 0;
    public static final int STATE_SAME = 1;
    private static final AtomicBoolean mNeedMigrate = null;
    private static final Singleton<DRCommonHeader> sCommonHeader = null;
    private MigrateDetector detector;
    private boolean hasInitLoader;
    private boolean mAllReady;
    protected final Context mApp;
    private CallbackCenter mCallbackCenter;
    private int mCountPermission;
    private DataObserverInstance mDataObserverInstance;
    private volatile boolean mDetectedMigrate;
    private final DRSpecialLoader mDrSpecialHeaderLoader;
    private Env mEnv;
    private JSONObject mHeader;
    private boolean mIsNewUser;
    private final Map<Class<?>, BaseLoader> mLoaders;
    private final Object mLock;
    protected final InstallOptions mOptions;
    private ICache mSpCache;
    private final AtomicBoolean mStarted;

    static {
        mNeedMigrate = new AtomicBoolean(true);
        sCommonHeader = new AnonymousClass1();
    }

    public DeviceManager(Context r10, InstallOptions r11, Env r12) {
        this.mLoaders = new LinkedHashMap(32);
        this.mLock = new Object();
        this.hasInitLoader = false;
        this.mDetectedMigrate = false;
        this.mStarted = new AtomicBoolean(false);
        this.mDataObserverInstance = null;
        this.mCountPermission = 0;
        this.mApp = r10;
        this.mEnv = r12;
        this.mOptions = r11;
        this.mHeader = new JSONObject();
        this.mDrSpecialHeaderLoader = new DRSpecialLoader(r11);
        this.mSpCache = createSpCache(r10, r12);
        this.mDataObserverInstance = BdInstallInstance.getInstance(String.valueOf(r11.getAid())).getDataObserverInstance();
        ExecutorUtil.runOnHandlerThread(r11.getAidString(), new AnonymousClass2(this));
    }

    private void awaitLoadedLocked() {
    L3:
        if (this.mDetectedMigrate == true) goto L8;
        this.mLock.wait();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        DrLog.ysnp(e);
        goto L3
    }

    private ICache createSpCache(Context r10, Env r11) {
        INewUserModeService r12 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(this.mOptions.getAid()));
        SPCache r13 = new SPCache(r10, r11.getEnvIsolateSp(this.mOptions), this.mOptions);
        if (r12 != null) goto L5;
        return r13;
    L5:
        return (ICache) r12.tryReplaceService(ICache.class, r13);
    }

    @WorkerThread
    private boolean detectMigrate(Context r10, Env r11) {
        MigrateDetector r12 = new MigrateDetector(r10, this.mOptions);
        this.detector = r12;
        boolean r13 = r12.isMigrate();
        DrLog.d("is one key migrate：" + r13);
        if (r13 == false) goto L5;
        MigrateDetector.saveOldDid(r10, this.mOptions, getDid(), true);
        MigrateClear.clear(r10, this.mOptions, r11);
    L5:
        this.detector.disableComponent();
        return r13;
    }

    private String getClientUdid() {
        return LocalConstants.getCommonSp(this.mApp, this.mOptions).getString("clientudid", null);
    }

    private String getIid() {
        return this.mSpCache.getCachedString("install_id");
    }

    private String getOpenUdid() {
        return LocalConstants.getCommonSp(this.mApp, this.mOptions).getString("openudid", null);
    }

    private String getSsid() {
        return this.mSpCache.getCachedString(Api.KEY_SSID);
    }

    private void monitorDidError(IInstallParameters r10, String r11, String r12) {
        String r13 = r10.getClientUDID();
        JSONObject r14 = new JSONObject();
        r14.put("old_id", r12);
        r14.put("new_id", r11);
        if (this.mEnv.isChildMode() == true) goto L5;
        r14.put("openudid", r10.getOpenUdid(true));
    L5:
        r14.put("clientudid", r13);
        IEventDepend r15 = this.mOptions.getEventDepend();
        if (r15 == null) goto L9;
        r15.onEvent("did_change", r14);
        return;
    }

    private boolean needSyncFromSub(BaseLoader r10) {
        if (Utils.isMainProcess(this.mOptions.getContext()) == false) goto L5;
    L7:
        boolean r11 = false;
    L9:
        if (DrLog.debug() == false) goto L11;
        DrLog.d("needSyncFromSub " + r10 + " " + r11);
    L11:
        return r11;
    L5:
        if (r10.syncFromSub == false) goto L7;
        r11 = true;
        goto L9
    }

    private void resetRequestTime(Env r10) {
        SharedPreferences r11 = r10.getEnvIsolateSp(this.mOptions);
        if (r11 == null) goto L6;
        r11.edit().putLong(Api.KEY_REGISTER_TIME, 0).apply();
        return;
    }

    public void changeEnv(Env r10, boolean r11) {
        this.mEnv = r10;
        this.mSpCache = createSpCache(this.mApp, r10);
        DeviceParamProviderCreator.registerInstallParameterProvider(this.mApp, r10, this.mOptions);
        Map<Class<?>, BaseLoader> r12 = this.mLoaders;
        monitor-enter(r12);
        this.mLoaders.put(ServerIdLoader.class, new ServerIdLoader(this.mOptions, r10));     // Catch: Throwable -> L10
        this.mLoaders.put(DeviceParamsLoader.class, new DeviceParamsLoader(this.mApp, this.mOptions, r10));     // Catch: Throwable -> L10
        this.mLoaders.put(ConfigLoader.class, new ConfigLoader(this.mApp, this.mOptions, r10));     // Catch: Throwable -> L10
        this.mLoaders.put(CdidLoader.class, new CdidLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        resetRequestTime(r10);
        if (r11 == false) goto L15;
        loadHeaderAndNotify();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void clear() {
        IInstallParameters r10 = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOptions.getAid()));
        if (r10 == null) goto L5;
        r10.clearAll();
    L5:
        Cdid.clearCdid(this.mApp, this.mOptions);
        RequestIdGenerator.clearReqId();
    }

    @NonNull
    public JSONObject getConstHeader() {
        return this.mHeader;
    }

    public Env getCurEnv() {
        return this.mEnv;
    }

    public String getDid() {
        IInstallParameters r10 = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, this.mOptions.getAidString());
        if (r10 == null) goto L7;
        return r10.getDeviceId();
    L7:
        return this.mSpCache.loadDeviceId("", "");
    }

    public JSONObject getHeader() {
        if (this.mAllReady == true) goto L7;
        return null;
    L7:
        return getConstHeader();
    }

    public InstallInfo getInstallInfo() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        awaitLoadedLocked();     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        String r11 = getDid();
        String r12 = getIid();
        String r13 = getOpenUdid();
        String r14 = getClientUdid();
        String r15 = getSsid();
        InstallInfo r16 = new InstallInfo();
        if (TextUtils.isEmpty(r11) == false) goto L9;
        r11 = "";
    L9:
        r16.setDid(r11);
        if (TextUtils.isEmpty(r12) == false) goto L12;
        r12 = "";
    L12:
        r16.setIid(r12);
        r16.setClientUdid(r14);
        r16.setOpenUdid(r13);
        r16.setSsid(r15);
        return r16;
    L14:
        th = move-exception;
        throw th;
    }

    public int getRegisterState() {
        String r10 = getConstHeader().optString("device_id", "");
        String r11 = getConstHeader().optString("install_id", "");
        String r12 = getConstHeader().optString("bd_did", "");
        if (Utils.checkId(r10) == true) goto L7;
        if (Utils.checkId(r12) == true) goto L7;
        return 0;
    L7:
        if (Utils.checkId(r11) == true) goto L9;
        return 0;
    L9:
        if (LocalConstants.getCommonSp(this.mApp, this.mOptions).getLong(KEY_INSTALL_VERSION_CODE, 0) != getConstHeader().optLong("version_code", -1)) goto L11;
        return 1;
    L11:
        return 2;
    }

    public boolean isDiffAid() {
        return !TextUtils.equals(LocalConstants.getCommonSp(this.mApp, this.mOptions).getString(KEY_DR_AID, null), String.valueOf(this.mOptions.getAid()));
    }

    public boolean isDiffChannel() {
        return !TextUtils.equals(LocalConstants.getCommonSp(this.mApp, this.mOptions).getString(KEY_DR_CHANNEL, null), this.mOptions.getChannel());
    }

    @Deprecated
    public boolean isNewUser() {
        return this.mIsNewUser;
    }

    public boolean isUpgrade() {
        if (LocalConstants.getCommonSp(this.mApp, this.mOptions).getLong(KEY_INSTALL_VERSION_CODE, 0) == getConstHeader().optLong("version_code", 0)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean load() {
        Map<Class<?>, BaseLoader> r10 = this.mLoaders;
        monitor-enter(r10);
    L65:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInitLoader == true) goto L7;
        this.hasInitLoader = true;     // Catch: Throwable -> L65
        this.mLoaders.put(ConfigLoader.class, new ConfigLoader(this.mApp, this.mOptions, this.mEnv));     // Catch: Throwable -> L65
        this.mLoaders.put(PackageLoader.class, new PackageLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L65
        this.mLoaders.put(ServerIdLoader.class, new ServerIdLoader(this.mOptions, this.mEnv));     // Catch: Throwable -> L65
        this.mLoaders.put(SigHashLoader.class, new SigHashLoader(this.mApp));     // Catch: Throwable -> L65
        this.mLoaders.put(CdidLoader.class, new CdidLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L65
        this.mLoaders.put(AppTraitLoader.class, new AppTraitLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L65
        this.mLoaders.put(AppKeyLoader.class, new AppKeyLoader(this.mApp));     // Catch: Throwable -> L65
        this.mLoaders.put(CustomLoader.class, new CustomLoader(this.mOptions));     // Catch: Throwable -> L65
        this.mLoaders.put(SstLoader.class, new SstLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L65
        this.mLoaders.put(DeviceCategoryLoader.class, new DeviceCategoryLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L65
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L65
        monitor-enter(DeviceManager.class);
        JSONObject r11 = getConstHeader();     // Catch: Throwable -> L62
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L62
        Utils.copy(r12, r11);     // Catch: Throwable -> L62
        Singleton<DRCommonHeader> r13 = sCommonHeader;     // Catch: Throwable -> L62
        if (r13.get(new Object[]{this.mApp, this.mOptions, this.mEnv}).load() == false) goto L13;
        Utils.copy(r12, r13.get(new Object[]{this.mApp, this.mOptions, this.mEnv}).getConstHeader());     // Catch: Throwable -> L62
        boolean r14 = false;
    L14:
        Iterator<BaseLoader> r15 = this.mLoaders.values().iterator();     // Catch: Throwable -> L62
        boolean r16 = true;
        int r17 = 0;
        int r18 = 0;
    L16:
        if (r15.hasNext() == false) goto L50;
        BaseLoader r19 = r15.next();     // Catch: Throwable -> L62
        if (r19.mReady == true) goto L20;
    L72:
        r19.remove(r12);     // Catch: SecurityException -> L25 JSONException -> L33 Throwable -> L62
        r19.mReady = r19.doLoad(r12);     // Catch: SecurityException -> L25 JSONException -> L33 Throwable -> L62
    L36:
        if (r19.mReady == false) goto L38;
    L42:
        if (r19.mReady == false) goto L44;
    L48:
        boolean r20 = true;
    L49:
        r16 = r16 & r20;     // Catch: Throwable -> L62
        goto L16
    L44:
        if (r19.mOptional == true) goto L48;
        if (r14 == false) goto L48;
        r20 = false;
        goto L49
    L38:
        if (r19.mOptional == true) goto L42;
        if (r14 == false) goto L42;
        r18 = r18 + 1;     // Catch: Throwable -> L62
    L25:
        e = move-exception;
        if (r19.mOptional == true) goto L36;
        r17 = r17 + 1;     // Catch: Throwable -> L62
        DrLog.w("loadHeader, " + this.mCountPermission, e);     // Catch: Throwable -> L62
        if (r19.mReady == true) goto L36;
        if (this.mCountPermission <= 10) goto L36;
        r19.mReady = true;     // Catch: Throwable -> L62
    L33:
        e = move-exception;
        DrLog.ysnp(e);     // Catch: Throwable -> L62
        goto L36
    L20:
        if (r19.mShouldUpdate == true) goto L72;
        if (needSyncFromSub(r19) == false) goto L42;
    L50:
        this.mHeader = r12;     // Catch: Throwable -> L62
        this.mAllReady = r16;     // Catch: Throwable -> L62
        if (DrLog.debug() == false) goto L53;
        DrLog.d("loadHeader, " + this.mAllReady + ", " + this.mCountPermission + ", " + this.mHeader);     // Catch: Throwable -> L62
    L54:
        if (r17 <= 0) goto L59;
        if (r17 != r18) goto L59;
        this.mCountPermission++;     // Catch: Throwable -> L62
        if (getRegisterState() == 0) goto L59;
        this.mCountPermission += 10;     // Catch: Throwable -> L62
    L59:
        monitor-exit(DeviceManager.class);     // Catch: Throwable -> L62
        return this.mAllReady;
    L53:
        DrLog.i("loadHeader, " + this.mAllReady + ", " + this.mCountPermission, null);     // Catch: Throwable -> L62
        goto L54
    L13:
        r14 = true;
    L62:
        th = move-exception;
        throw th;
    }

    public void loadHeaderAndNotify() {
        load();
        CallbackCenter r10 = this.mCallbackCenter;
        if (r10 == null) goto L5;
        r10.postEvent(new HeaderChangeEvent(getConstHeader()));
    L5:
        notifyDidAndIidLoadSuccessEvent();
    }

    public JSONObject loadOrGetHeader() {
        JSONObject r10 = getHeader();
        if (r10 == null) goto L5;
        return r10;
    L5:
        start();
        load();
        return getHeader();
    }

    protected void migrate() {
        Context r10 = this.mApp;
    L17:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mDetectedMigrate = true;     // Catch: Throwable -> L23
        this.mLock.notifyAll();     // Catch: Throwable -> L23
        throw th;
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.mOptions.enableOneKeyMigrateDetect() == true) goto L6;
        DrLog.d("disable OneKeyMigrateDetect");     // Catch: Throwable -> L17
        boolean r11 = false;
    L7:
        if (r11 == true) goto L9;
        OldSpMigrater.tryDoSDKMigrate(r10, this.mEnv, this.mOptions);     // Catch: Throwable -> L17
    L9:
        Object r12 = this.mLock;
        monitor-enter(r12);
        this.mDetectedMigrate = true;     // Catch: Throwable -> L14
        this.mLock.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        r11 = detectMigrate(r10, this.mEnv);     // Catch: Throwable -> L17
        goto L7
    }

    public void notifyBeforeRegister() {
        InstallInfo r10 = getInstallInfo();
        String r11 = null;
        if (r10 == null) goto L5;
        String r12 = r10.getDid();
    L6:
        if (r10 == null) goto L8;
        String r13 = r10.getIid();
    L9:
        if (r10 == null) goto L11;
        r11 = r10.getSsid();
    L11:
        DataObserverInstance r14 = this.mDataObserverInstance;
        if (r14 == null) goto L14;
        r14.onIdLoaded(r12, r13, r11);
    L14:
        if (r10 != null) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r10.getDid()) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r10.getIid()) == true) goto L27;
        CallbackCenter r15 = this.mCallbackCenter;
        if (r15 == null) goto L26;
        r15.postEvent(new InstallFinishEvent(r10));
        return;
    L26:
        return;
    L27:
        return;
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }

    public void notifyDidAndIidLoadSuccessEvent() {
        InstallInfo r10 = getInstallInfo();
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10.getDid()) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10.getIid()) == true) goto L16;
        CallbackCenter r11 = this.mCallbackCenter;
        if (r11 == null) goto L15;
        r11.postEvent(new InstallFinishEvent(r10));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.bdinstall.callback.RegisterResultListener
    public boolean onRegisterResult(JSONObject r20, Env r21, IInstallParameters r22) {
        if (r20 != null) goto L5;
        return false;
    L5:
        String r10 = r20.optString("device_id_str", "");
        String r11 = r20.optString("install_id_str", "");
        String r12 = r20.optString("device_token", "");
        String r13 = r20.optString(Api.KEY_SSID, "");
        String r14 = r20.optString(Api.KEY_CD, "");
        if (r20.optInt(Api.KEY_NEW_USER, 0) <= 0) goto L8;
        boolean r15 = true;
    L9:
        this.mIsNewUser = r15;
        if (DrLog.debug() == false) goto L12;
        DrLog.d("saveRegisterInfo, " + r10 + ", " + r11 + ", " + r13 + ", , " + r14 + ", " + r20);
    L12:
        boolean r16 = Utils.checkId(r10);
        boolean r17 = Utils.checkId(r11);
        Utils.checkId(r14);
        SharedPreferences.Editor r18 = this.mOptions.getSp().edit();
        SharedPreferences r19 = LocalConstants.getCommonSp(this.mApp, this.mOptions);
        SharedPreferences.Editor r23 = r19.edit();
        boolean r24 = Utils.checkId(r13);     // Catch: JSONException -> L107
        long r110 = r19.getLong(KEY_INSTALL_VERSION_CODE, 0);     // Catch: JSONException -> L105
        long r25 = getConstHeader().optLong("version_code", 0);     // Catch: JSONException -> L105
        if (r110 != r25) goto L127;
    L22:
        r23.putString(KEY_DR_CHANNEL, this.mOptions.getChannel());     // Catch: JSONException -> L105
        r23.putString(KEY_DR_AID, String.valueOf(this.mOptions.getAid()));     // Catch: JSONException -> L105
        if (r16 == false) goto L122;
    L27:
        String r26 = getDid();     // Catch: JSONException -> L103
        if (DrLog.debug() == false) goto L30;
        DrLog.d("od=" + r26 + " nd=" + r10 + " ck=" + r16);     // Catch: JSONException -> L103
    L30:
        if (r16 == true) goto L32;
        boolean r27 = false;
        boolean r28 = false;
    L50:
        String r111 = getConstHeader().optString("install_id", "");     // Catch: JSONException -> L103
        if (r17 == true) goto L53;
    L60:
        r18.putString("device_id", r10);     // Catch: JSONException -> L103
        r18.putString("install_id", r11);     // Catch: JSONException -> L103
        boolean r29 = r27;
        String r30 = getConstHeader().optString(Api.KEY_SSID, "");     // Catch: JSONException -> L103
        if (r24 == true) goto L63;
    L65:
        boolean r31 = r29;
        boolean r32 = r28;
    L66:
        this.mOptions.saveConfigAfterRegister(r23);     // Catch: JSONException -> L103
        r23.apply();     // Catch: JSONException -> L103
        r18.apply();     // Catch: JSONException -> L103
        ((DeviceTokenService) ServiceManager.getService(DeviceTokenService.class, String.valueOf(this.mOptions.getAid()))).updateToken(r12, r21);     // Catch: JSONException -> L103
        if (TextUtils.equals(r10, r26) == false) goto L69;
    L71:
        boolean r33 = false;
    L73:
        if (TextUtils.equals(r11, r111) == false) goto L75;
    L77:
        boolean r34 = false;
    L78:
        if (r31 == false) goto L82;
        CallbackCenter r35 = this.mCallbackCenter;     // Catch: JSONException -> L103
        if (r35 == null) goto L82;
        r35.postEvent(new HeaderChangeEvent(getConstHeader()));     // Catch: JSONException -> L103
    L82:
        if (r33 == true) goto L86;
        if (r34 == true) goto L86;
        boolean r112 = false;
    L89:
        DataObserverInstance r36 = this.mDataObserverInstance;     // Catch: JSONException -> L101
        if (r36 == null) goto L92;
        r36.onRemoteIdGet(r32, r26, r10, r111, r11, r30, r13);     // Catch: JSONException -> L101
    L92:
        RegisterMonitor r37 = EventUtils.getInstance().getRegisterMonitor(this.mOptions.getAid());     // Catch: JSONException -> L101
        if (r37 == null) goto L111;
        if (r33 == true) goto L96;
    L98:
        boolean r38 = r112;
    L99:
        r37.setDidChanged(r38);     // Catch: JSONException -> L101
    L101:
        e = e;
    L110:
        DrLog.ysnp(e);
        goto L111
    L96:
        if (this.mHeader.optBoolean(Api.KEY_NEW_USER_MODE) == true) goto L98;
        r38 = true;
    L111:
        if (r16 == false) goto L114;
        if (r17 == false) goto L114;
        boolean r39 = true;
    L115:
        if (r39 == false) goto L119;
        CallbackCenter r40 = this.mCallbackCenter;
        if (r40 == null) goto L119;
        r40.postEvent(new RequestDrSuccessEvent(r20));
    L119:
        return r39;
    L114:
        r39 = r112;
    L86:
        notifyDidAndIidLoadSuccessEvent();     // Catch: JSONException -> L103
        r112 = false;
        MigrateDetector.saveOldDid(this.mApp, this.mOptions, null, false);     // Catch: JSONException -> L101
        goto L89
    L75:
        if (TextUtils.isEmpty(r11) == true) goto L77;
        r34 = true;
        goto L78
    L69:
        if (TextUtils.isEmpty(r10) == true) goto L71;
        r33 = true;
        goto L73
    L63:
        if (updateHeader(Api.KEY_SSID, r13) == false) goto L65;
        this.mSpCache.cacheString(Api.KEY_SSID, r13);     // Catch: JSONException -> L103
        r31 = true;
        r32 = true;
        goto L66
    L53:
        if (updateHeader("install_id", r11) == false) goto L60;
        this.mSpCache.cacheString("install_id", r11);     // Catch: JSONException -> L103
        if (TextUtils.isEmpty(r111) == true) goto L59;
        JSONObject r41 = new JSONObject();     // Catch: JSONException -> L103
        r41.put("old_id", r111);     // Catch: JSONException -> L103
        r41.put("new_id", r11);     // Catch: JSONException -> L103
        IEventDepend r42 = this.mOptions.getEventDepend();     // Catch: JSONException -> L103
        if (r42 == null) goto L59;
        r42.onEvent("iid_change", r41);     // Catch: JSONException -> L103
    L59:
        r27 = true;
        r28 = true;
        goto L60
    L32:
        if (r10.equals(this.mHeader.optString("device_id")) == false) goto L34;
        r27 = false;
        r28 = false;
    L44:
        if (r10.equals(r26) == true) goto L50;
        if (TextUtils.isEmpty(r26) == true) goto L48;
        monitorDidError(r22, r10, r26);     // Catch: JSONException -> L103
    L48:
        r28 = true;
        goto L50
    L34:
        monitor-enter(DeviceManager.class);     // Catch: JSONException -> L103
        JSONObject r113 = this.mHeader;     // Catch: Throwable -> L39
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L39
        Utils.copy(r114, r113);     // Catch: Throwable -> L39
        r114.put("device_id", r10);     // Catch: Throwable -> L39
        this.mHeader = r114;     // Catch: Throwable -> L39
        monitor-exit(DeviceManager.class);     // Catch: Throwable -> L39
        r22.updateDeviceId(r10);     // Catch: JSONException -> L103
        r27 = true;
        r28 = true;
        goto L44
    L39:
        th = move-exception;
        throw th;     // Catch: JSONException -> L103
    L103:
        e = e;
        r112 = false;
        goto L110
    L122:
        JSONObject r43 = new JSONObject();     // Catch: JSONException -> L103
        r43.put("response", r20);     // Catch: JSONException -> L103
        IEventDepend r44 = this.mOptions.getEventDepend();     // Catch: JSONException -> L103
        if (r44 == null) goto L27;
        r44.onEvent("tt_fetch_did_error", r43);     // Catch: JSONException -> L103
        goto L27
    L127:
        r23.putLong(KEY_INSTALL_VERSION_CODE, r25);     // Catch: JSONException -> L20
    L20:
        e = e;
        r112 = false;
        r16 = false;
    L105:
        e = e;
        r112 = false;
    L109:
        r16 = r112;
    L107:
        e = e;
        r112 = false;
        goto L109
    L8:
        r15 = false;
        goto L9
    }

    public void setCallbackCenter(CallbackCenter r10) {
        this.mCallbackCenter = r10;
    }

    public void start() {
        if (this.mStarted.getAndSet(true) == true) goto L6;
        DeviceParamProviderCreator.registerInstallParameterProvider(this.mApp, this.mEnv, this.mOptions);
        return;
    }

    public void updateDrSpecialHeader(JSONObject r10, Env r11) {
        this.mDrSpecialHeaderLoader.doLoad(r10, r11);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean updateHeader(String r10, @Nullable Object r11) {
        Object r12 = getConstHeader().opt(r10);
        if (r11 != null) goto L5;
    L6:
        if (r11 != null) goto L20;
        if (r12 == null) goto L20;
    L9:
        monitor-enter(DeviceManager.class);
        JSONObject r13 = this.mHeader;     // Catch: Throwable -> L12 JSONException -> L14
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L12 JSONException -> L14
        Utils.copy(r14, r13);     // Catch: Throwable -> L12 JSONException -> L14
        r14.put(r10, r11);     // Catch: Throwable -> L12 JSONException -> L14
        this.mHeader = r14;     // Catch: Throwable -> L12 JSONException -> L14
    L16:
        monitor-exit(DeviceManager.class);     // Catch: Throwable -> L12
        boolean r15 = true;
    L22:
        if (DrLog.debug() == false) goto L24;
        DrLog.d("updateHeader, " + r10 + ", " + r12 + ", " + r11);
    L24:
        return r15;
    L12:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        DrLog.ysnp(e);     // Catch: Throwable -> L12
    L20:
        r15 = false;
        goto L22
    L5:
        if (r11.equals(r12) == false) goto L9;
        goto L6
    }
}
