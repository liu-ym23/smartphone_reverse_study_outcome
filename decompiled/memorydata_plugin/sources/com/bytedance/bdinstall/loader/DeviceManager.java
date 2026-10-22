package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.BDInstall;
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
import com.bytedance.bdinstall.callback.EgdiCallback;
import com.bytedance.bdinstall.callback.RegisterResultListener;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.bytedance.bdinstall.callback.event.RequestDrSuccessEvent;
import com.bytedance.bdinstall.dtrait.DTraitService;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.dtrait.manager.DTraitServiceManager;
import com.bytedance.bdinstall.dtrait.model.DTraitTimeMonitorEvent;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.event.VerifyMonitor;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.storage.DeviceParamProviderCreator;
import com.bytedance.bdinstall.storage.ICache;
import com.bytedance.bdinstall.storage.SPCache;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.DataObserverInstance;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.bdinstall.util.Singleton;
import com.bytedance.bdinstall.util.TicketGuardHelper;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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
    private EgdiCallback egdiCallback;
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
    private final TicketGuardHelper ticketGuardHelper;

    static {
        mNeedMigrate = new AtomicBoolean(true);
        sCommonHeader = new AnonymousClass1();
    }

    public DeviceManager(Context r4, InstallOptions r5, Env r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mLoaders = new LinkedHashMap(32);
        this.mLock = new Object();
        this.hasInitLoader = false;
        this.mDetectedMigrate = false;
        this.mStarted = new AtomicBoolean(false);
        this.mDataObserverInstance = null;
        this.mCountPermission = 0;
        this.mApp = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.mEnv = r6;
        this.mOptions = r5;
        this.mHeader = new JSONObject();
        this.mDrSpecialHeaderLoader = new DRSpecialLoader(r5);
        this.mSpCache = createSpCache(r7, r6);
        this.mDataObserverInstance = BdInstallInstance.getInstance(String.valueOf(r5.getAid())).getDataObserverInstance();
        ExecutorUtil.runOnHandlerThread(r5.getAidString(), new AnonymousClass2(this));
        this.ticketGuardHelper = new TicketGuardHelper();
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

    private ICache createSpCache(Context r5, Env r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        INewUserModeService r0 = (INewUserModeService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(INewUserModeService.class, String.valueOf(this.mOptions.getAid())), INewUserModeService.class, "com.obric.memorydata.plugin");
        SPCache r2 = new SPCache(r7, r6.getEnvIsolateSp(this.mOptions), this.mOptions);
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (ICache) ZeusTransformUtils.preCheckCast(r0.tryReplaceService(ICache.class, r2), ICache.class, "com.obric.memorydata.plugin");
    }

    private boolean detectMigrate(Context r5, Env r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        MigrateDetector r0 = new MigrateDetector(r7, this.mOptions);
        this.detector = r0;
        boolean r1 = r0.isMigrate();
        DrLog.d("is one key migrate：" + r1);
        if (r1 == false) goto L5;
        MigrateDetector.saveOldDid(r7, this.mOptions, getDid(), true);
        MigrateClear.clear(r7, this.mOptions, r6);
    L5:
        this.detector.disableComponent();
        return r1;
    }

    private String getClientUdid() {
        return LocalConstants.getCommonSp(this.mApp, this.mOptions).getString("clientudid", null);
    }

    private String getEgdi() {
        return LocalConstants.getCommonSp(this.mApp, this.mOptions).getString(Api.KEY_KLINK_EGDI, null);
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

    private Pair<String, String> handleTicketData(String r17, String r18, String r19, String r20, boolean r21, boolean r22, TTResponse r23, SharedPreferences.Editor r24) {
        SharedPreferences.Editor r5 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r24, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        if (BDInstall.getBDInstallConfig().isEnableDidGuard() == false) goto L5;
        String r6 = null;
        List<Map<String, String>> r7 = this.ticketGuardHelper.handleProviderResponse(0, Api.KEY_TS_SIGN, r23.getHeaders().toString(), false, r23.getHeaders());     // Catch: Exception -> L39
        VerifyMonitor r8 = EventUtils.getInstance().getVerifyMonitor(this.mOptions.getAid());     // Catch: Exception -> L39
        if (TextUtils.isEmpty(r19) == false) goto L10;
    L16:
        String r9 = null;
    L48:
    L37:
        e = e;
    L41:
        e.printStackTrace();
    L43:
        return new Pair(r6, r9);
    L18:
        if (TextUtils.isEmpty(r17) == true) goto L28;
        if (TextUtils.isEmpty(r18) == true) goto L28;
        boolean r11 = r17.equals(r6);     // Catch: Exception -> L37
        boolean r12 = r18.equals(r9);     // Catch: Exception -> L37
        if (r11 == false) goto L25;
        if (r12 == false) goto L25;
        int r13 = 1;
    L26:
        r8.setDecryptCode(r13);     // Catch: Exception -> L37
        DrLog.d(Constants.TAG_TICKET + String.format("decrypt done: did %s, iid %s, decryptDid %s, decryptIid %s", new Object[]{r17, r18, r6, r9}));     // Catch: Exception -> L37
    L25:
        r13 = 2;
    L28:
        if (r21 == false) goto L33;
        if (r19.equals(this.mHeader.optString(Api.KEY_ENCRYPT_DID)) == true) goto L33;
        this.mHeader.put(Api.KEY_ENCRYPT_DID, r19);     // Catch: Exception -> L37
        this.mSpCache.cacheString(Api.KEY_ENCRYPT_DID, r19);     // Catch: Exception -> L37
        DrLog.d("TicketGuard# update header encrypt did " + this.mHeader.optString(Api.KEY_ENCRYPT_DID));     // Catch: Exception -> L37
    L33:
        if (r22 == false) goto L35;
        this.mHeader.put(Api.KEY_ENCRYPT_IID, r20);     // Catch: Exception -> L37
        this.mSpCache.cacheString(Api.KEY_ENCRYPT_IID, r20);     // Catch: Exception -> L37
        DrLog.d("TicketGuard# update header encrypt iid " + this.mHeader.optString(Api.KEY_ENCRYPT_IID));     // Catch: Exception -> L37
    L35:
        r5.putString(Api.KEY_ENCRYPT_DID, r19);     // Catch: Exception -> L37
        r5.putString(Api.KEY_ENCRYPT_IID, r20);     // Catch: Exception -> L37
        this.ticketGuardHelper.cacheTicketAndTsSign(r23, this.mSpCache, r7);     // Catch: Exception -> L37
        goto L43
    L10:
        if (TextUtils.isEmpty(r20) == true) goto L16;
        String r10 = this.ticketGuardHelper.decryptTicket(Base64.decode(r19, 0));     // Catch: Exception -> L39
        r9 = this.ticketGuardHelper.decryptTicket(Base64.decode(r20, 0));     // Catch: Exception -> L14
        r6 = r10;
    L14:
        e = e;
        r9 = null;
        r6 = r10;
    L39:
        e = e;
        r9 = null;
        goto L41
    L5:
        return new Pair("", "");
    }

    private void monitorDidError(IInstallParameters r4, String r5, String r6) {
        IInstallParameters r7 = (IInstallParameters) ZeusTransformUtils.wrapperContextForParams(r4, IInstallParameters.class, "com.obric.memorydata.plugin");
        String r0 = r7.getClientUDID();
        JSONObject r1 = new JSONObject();
        r1.put("old_id", r6);
        r1.put("new_id", r5);
        if (this.mEnv.isChildMode() == true) goto L5;
        r1.put("openudid", r7.getOpenUdid(true));
    L5:
        r1.put("clientudid", r0);
        IEventDepend r3 = this.mOptions.getEventDepend();
        if (r3 == null) goto L9;
        r3.onEvent("did_change", r1);
        return;
    }

    private boolean needSyncFromSub(BaseLoader r3) {
        if (Utils.isMainProcess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (DrLog.debug() == false) goto L11;
        DrLog.d("needSyncFromSub " + r3 + " " + r2);
    L11:
        return r2;
    L5:
        if (r3.syncFromSub == false) goto L7;
        r2 = true;
        goto L9
    }

    private void resetRequestTime(Env r3) {
        SharedPreferences r2 = r3.getEnvIsolateSp(this.mOptions);
        if (r2 == null) goto L6;
        r2.edit().putLong(Api.KEY_REGISTER_TIME, 0).apply();
        return;
    }

    public void changeEnv(Env r7, boolean r8) {
        this.mEnv = r7;
        this.mSpCache = createSpCache(this.mApp, r7);
        DeviceParamProviderCreator.registerInstallParameterProvider(this.mApp, r7, this.mOptions);
        Map<Class<?>, BaseLoader> r0 = this.mLoaders;
        monitor-enter(r0);
        this.mLoaders.put(ServerIdLoader.class, new ServerIdLoader(this.mOptions, r7));     // Catch: Throwable -> L10
        this.mLoaders.put(DeviceParamsLoader.class, new DeviceParamsLoader(this.mApp, this.mOptions, r7));     // Catch: Throwable -> L10
        this.mLoaders.put(ConfigLoader.class, new ConfigLoader(this.mApp, this.mOptions, r7));     // Catch: Throwable -> L10
        this.mLoaders.put(CdidLoader.class, new CdidLoader(this.mApp, this.mOptions));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        resetRequestTime(r7);
        if (r8 == false) goto L15;
        loadHeaderAndNotify();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void clear() {
        IInstallParameters r0 = (IInstallParameters) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOptions.getAid())), IInstallParameters.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.clearAll();
    L5:
        Cdid.clearCdid(this.mApp, this.mOptions);
        RequestIdGenerator.clearReqId();
    }

    public JSONObject getConstHeader() {
        return this.mHeader;
    }

    public Env getCurEnv() {
        return this.mEnv;
    }

    public String getDid() {
        IInstallParameters r0 = (IInstallParameters) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IInstallParameters.class, this.mOptions.getAidString()), IInstallParameters.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        return r0.getDeviceId();
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
        Object r0 = this.mLock;
        monitor-enter(r0);
        awaitLoadedLocked();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        String r1 = getDid();
        String r2 = getIid();
        String r3 = getOpenUdid();
        String r4 = getClientUdid();
        String r5 = getSsid();
        String r7 = getEgdi();
        InstallInfo r6 = new InstallInfo();
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r1 = "";
    L9:
        r6.setDid(r1);
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r2 = "";
    L12:
        r6.setIid(r2);
        r6.setClientUdid(r4);
        r6.setOpenUdid(r3);
        r6.setSsid(r5);
        r6.setEgdi(r7);
        return r6;
    L14:
        th = move-exception;
        throw th;
    }

    public int getRegisterState() {
        String r0 = getConstHeader().optString("device_id", "");
        String r1 = getConstHeader().optString("install_id", "");
        String r2 = getConstHeader().optString("bd_did", "");
        if (Utils.checkId(r0) == true) goto L7;
        if (Utils.checkId(r2) == true) goto L7;
        return 0;
    L7:
        if (Utils.checkId(r1) == true) goto L9;
        return 0;
    L9:
        if (LocalConstants.getCommonSp(this.mApp, this.mOptions).getLong(KEY_INSTALL_VERSION_CODE, 0) != getConstHeader().optLong("version_code", -1)) goto L11;
        return 1;
    L11:
        return 2;
    }

    public TicketGuardHelper getTicketGuardHelper() {
        return this.ticketGuardHelper;
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
        Map<Class<?>, BaseLoader> r0 = this.mLoaders;
        monitor-enter(r0);
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
        monitor-exit(r0);     // Catch: Throwable -> L65
        monitor-enter(DeviceManager.class);
        JSONObject r1 = getConstHeader();     // Catch: Throwable -> L62
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L62
        Utils.copy(r3, r1);     // Catch: Throwable -> L62
        Singleton<DRCommonHeader> r2 = sCommonHeader;     // Catch: Throwable -> L62
        if (((DRCommonHeader) ZeusTransformUtils.preCheckCast(r2.get(new Object[]{this.mApp, this.mOptions, this.mEnv}), DRCommonHeader.class, "com.obric.memorydata.plugin")).load() == false) goto L13;
        Utils.copy(r3, ((DRCommonHeader) ZeusTransformUtils.preCheckCast(r2.get(new Object[]{this.mApp, this.mOptions, this.mEnv}), DRCommonHeader.class, "com.obric.memorydata.plugin")).getConstHeader());     // Catch: Throwable -> L62
        boolean r4 = false;
    L14:
        Iterator<BaseLoader> r5 = this.mLoaders.values().iterator();     // Catch: Throwable -> L62
        boolean r6 = true;
        int r7 = 0;
        int r8 = 0;
    L16:
        if (r5.hasNext() == false) goto L50;
        BaseLoader r9 = (BaseLoader) ZeusTransformUtils.preCheckCast(r5.next(), BaseLoader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L62
        if (r9.mReady == true) goto L20;
    L72:
        r9.remove(r3);     // Catch: SecurityException -> L25 JSONException -> L33 Throwable -> L62
        r9.mReady = r9.doLoad(r3);     // Catch: SecurityException -> L25 JSONException -> L33 Throwable -> L62
    L36:
        if (r9.mReady == false) goto L38;
    L42:
        if (r9.mReady == false) goto L44;
    L48:
        boolean r10 = true;
    L49:
        r6 = r6 & r10;     // Catch: Throwable -> L62
        goto L16
    L44:
        if (r9.mOptional == true) goto L48;
        if (r4 == false) goto L48;
        r10 = false;
        goto L49
    L38:
        if (r9.mOptional == true) goto L42;
        if (r4 == false) goto L42;
        r8 = r8 + 1;     // Catch: Throwable -> L62
    L33:
        e = move-exception;
        DrLog.ysnp(e);     // Catch: Throwable -> L62
    L25:
        e = move-exception;
        if (r9.mOptional == true) goto L36;
        r7 = r7 + 1;     // Catch: Throwable -> L62
        DrLog.w("loadHeader, " + this.mCountPermission, e);     // Catch: Throwable -> L62
        if (r9.mReady == true) goto L36;
        if (this.mCountPermission <= 10) goto L36;
        r9.mReady = true;     // Catch: Throwable -> L62
        goto L36
    L20:
        if (r9.mShouldUpdate == true) goto L72;
        if (needSyncFromSub(r9) == false) goto L42;
    L50:
        this.mHeader = r3;     // Catch: Throwable -> L62
        this.mAllReady = r6;     // Catch: Throwable -> L62
        if (DrLog.debug() == false) goto L53;
        DrLog.d("loadHeader, " + this.mAllReady + ", " + this.mCountPermission + ", " + this.mHeader);     // Catch: Throwable -> L62
    L54:
        if (r7 <= 0) goto L59;
        if (r7 != r8) goto L59;
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
        r4 = true;
    L62:
        th = move-exception;
        throw th;
    }

    public void loadHeaderAndNotify() {
        load();
        CallbackCenter r0 = this.mCallbackCenter;
        if (r0 == null) goto L5;
        r0.postEvent(new HeaderChangeEvent(getConstHeader()));
    L5:
        notifyDidAndIidLoadSuccessEvent();
    }

    public JSONObject loadOrGetHeader() {
        JSONObject r0 = getHeader();
        if (r0 == null) goto L5;
        return r0;
    L5:
        start();
        load();
        return getHeader();
    }

    public void migrate() {
        Context r0 = this.mApp;
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
        boolean r2 = false;
    L7:
        if (r2 == true) goto L9;
        OldSpMigrater.tryDoSDKMigrate(r0, this.mEnv, this.mOptions);     // Catch: Throwable -> L17
    L9:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mDetectedMigrate = true;     // Catch: Throwable -> L14
        this.mLock.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        r2 = detectMigrate(r0, this.mEnv);     // Catch: Throwable -> L17
        goto L7
    }

    public void notifyBeforeRegister() {
        InstallInfo r0 = getInstallInfo();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getDid();
    L6:
        if (r0 == null) goto L8;
        String r3 = r0.getIid();
    L9:
        if (r0 == null) goto L11;
        r1 = r0.getSsid();
    L11:
        DataObserverInstance r4 = this.mDataObserverInstance;
        if (r4 == null) goto L14;
        r4.onIdLoaded(r2, r3, r1);
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r0.getDid()) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r0.getIid()) == true) goto L27;
        CallbackCenter r5 = this.mCallbackCenter;
        if (r5 == null) goto L26;
        r5.postEvent(new InstallFinishEvent(r0));
        return;
    L26:
        return;
    L27:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public void notifyDidAndIidLoadSuccessEvent() {
        InstallInfo r0 = getInstallInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r0.getDid()) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r0.getIid()) == true) goto L16;
        CallbackCenter r2 = this.mCallbackCenter;
        if (r2 == null) goto L15;
        r2.postEvent(new InstallFinishEvent(r0));
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v76 */
    /* JADX WARN: Type inference failed for: r28v0, types: [com.bytedance.bdinstall.loader.DeviceManager] */
    @Override // com.bytedance.bdinstall.callback.RegisterResultListener
    public boolean onRegisterResult(TTResponse r29, Env r30, IInstallParameters r31) {
        IInstallParameters r11 = (IInstallParameters) ZeusTransformUtils.wrapperContextForParams(r31, IInstallParameters.class, "com.obric.memorydata.plugin");
        DTraitTimeMonitorEvent.setDeviceIDCallbackStart();
        JSONObject r13 = new JSONObject(r29.getBody());     // Catch: JSONException -> L5
    L8:
        if (r13 != null) goto L11;
        DrLog.d("onRegisterResult# response is null");
        return false;
    L11:
        String r0 = r13.optString("device_id_str", "");
        String r15 = r13.optString("install_id_str", "");
        String r9 = r13.optString("device_token", "");
        String r8 = r13.optString(Api.KEY_SSID, "");
        String r1 = r13.optString(Api.KEY_CD, "");
        String r7 = r13.optString(Api.KEY_KLINK_EGDI, "");
        if (r13.optInt(Api.KEY_NEW_USER, 0) <= 0) goto L14;
        boolean r2 = true;
    L15:
        this.mIsNewUser = r2;
        String r4 = r13.optString(Api.KEY_ENCRYPT_DID, "");
        String r5 = r13.optString(Api.KEY_ENCRYPT_IID, "");
        if (DrLog.debug() == false) goto L18;
        DrLog.d("saveRegisterInfo, " + r0 + ", " + r15 + ", " + r8 + ", , " + r1 + ", " + r13);
    L18:
        boolean r16 = Utils.checkId(r0);
        boolean r17 = Utils.checkId(r15);
        Utils.checkId(r1);
        boolean r25 = Utils.checkId(r4);
        boolean r26 = Utils.checkId(r5);
        boolean r18 = Utils.checkId(r7);
        if (BDInstall.getBDInstallConfig().isEnableGetEgdi() == false) goto L25;
        if (r16 == false) goto L25;
        if (r18 == true) goto L25;
        EgdiCallback r3 = this.egdiCallback;
        if (r3 == null) goto L25;
        r3.onEgdiFailed();
    L25:
        SharedPreferences.Editor r6 = this.mOptions.getSp().edit();
        SharedPreferences r10 = LocalConstants.getCommonSp(this.mApp, this.mOptions);
        SharedPreferences.Editor r12 = r10.edit();
        boolean r19 = Utils.checkId(r8);     // Catch: JSONException -> L163
        JSONObject r27 = r13;
        long r14 = r10.getLong(KEY_INSTALL_VERSION_CODE, 0);     // Catch: JSONException -> L161
        long r110 = getConstHeader().optLong("version_code", 0);     // Catch: JSONException -> L159
        if (r14 != r110) goto L189;
    L37:
        r12.putString(KEY_DR_CHANNEL, this.mOptions.getChannel());     // Catch: JSONException -> L159
        r12.putString(KEY_DR_AID, String.valueOf(this.mOptions.getAid()));     // Catch: JSONException -> L159
        Pair<String, String> r20 = handleTicketData(r0, r15, r4, r5, r25, r26, r29, r6);     // Catch: JSONException -> L159
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r20.first, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L40;
    L47:
        boolean r21 = r16;
        boolean r22 = r17;
        String r23 = r0;
        String r24 = r15;
        boolean r28 = false;
        boolean r32 = false;
    L48:
        if (r21 == false) goto L187;
        JSONObject r33 = r27;
    L193:
        String r34 = getDid();     // Catch: JSONException -> L157
        if (DrLog.debug() == false) goto L195;
        DrLog.d("od=" + r34 + " nd=" + r23 + " ck=" + r21);     // Catch: JSONException -> L64
    L64:
        e = e;
    L58:
        r17 = r22;
        ?? r35 = r21;
    L36:
        boolean r111 = false;
        ?? r36 = r35;
    L166:
        DrLog.ysnp(e);
        r22 = r17;
        ?? r37 = r36;
    L167:
        if (r37 == 0) goto L170;
        if (r22 == false) goto L170;
    L171:
        boolean r112 = true;
    L173:
        if (r112 == false) goto L178;
        CallbackCenter r38 = this.mCallbackCenter;
        if (r38 == null) goto L178;
        r38.postEvent(new RequestDrSuccessEvent(r33));
    L178:
        if (DTraitConfig.isEnableDTrait() == false) goto L182;
        DTraitTimeMonitorEvent.setDeviceIDCallbackFinish();
        DTraitTimeMonitorEvent.setDeviceRegisterFinish();
        DTraitService r39 = (DTraitService) ZeusTransformUtils.preCheckCast(DTraitServiceManager.getService(DTraitService.class), DTraitService.class, "com.obric.memorydata.plugin");
        if (r39 == null) goto L182;
        r39.getDTraitManager().parseDTraitInfo(r33, this.mHeader);
    L182:
        return r112;
    L170:
        if ((r25 & r26) == true) goto L171;
        r112 = r111;
    L195:
        if (r21 == true) goto L207;
        boolean r210 = r21 ? 1 : 0;
        boolean r40 = r28;
    L200:
        String r41 = getConstHeader().optString("install_id", "");     // Catch: JSONException -> L154
        if (r22 == true) goto L96;
    L105:
        if (r18 == true) goto L107;
    L110:
        r6.putString("device_id", r23);     // Catch: JSONException -> L154
        r6.putString("install_id", r24);     // Catch: JSONException -> L154
        String r211 = getConstHeader().optString(Api.KEY_SSID, "");     // Catch: JSONException -> L154
        if (r19 == true) goto L113;
    L116:
        boolean r113 = r32;
    L117:
        this.mOptions.saveConfigAfterRegister(r12);     // Catch: JSONException -> L154
        r12.apply();     // Catch: JSONException -> L154
        r6.apply();     // Catch: JSONException -> L154
        ((DeviceTokenService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(DeviceTokenService.class, String.valueOf(this.mOptions.getAid())), DeviceTokenService.class, "com.obric.memorydata.plugin")).updateToken(r9, r30);     // Catch: JSONException -> L154
        if (TextUtils.equals(r23, r34) == false) goto L120;
    L122:
        boolean r42 = false;
    L124:
        if (TextUtils.equals(r24, r41) == false) goto L126;
    L128:
        boolean r43 = false;
    L129:
        if (r40 == false) goto L133;
        CallbackCenter r44 = this.mCallbackCenter;     // Catch: JSONException -> L103
        if (r44 == null) goto L133;
        r44.postEvent(new HeaderChangeEvent(getConstHeader()));     // Catch: JSONException -> L103
    L133:
        if (r42 == true) goto L137;
        if (r43 == true) goto L137;
        r111 = false;
    L140:
        DataObserverInstance r45 = this.mDataObserverInstance;     // Catch: JSONException -> L152
        if (r45 == null) goto L143;
        r45.onRemoteIdGet(r113, r34, r23, r41, r24, r211, r8);     // Catch: JSONException -> L152
    L143:
        RegisterMonitor r46 = EventUtils.getInstance().getRegisterMonitor(this.mOptions.getAid());     // Catch: JSONException -> L152
        if (r46 == null) goto L151;
        if (r42 == true) goto L147;
    L149:
        boolean r47 = r111;
    L150:
        r46.setDidChanged(r47);     // Catch: JSONException -> L152
    L152:
        e = e;
    L156:
        r17 = r22;
        r36 = r210;
        goto L166
    L147:
        if (this.mHeader.optBoolean(Api.KEY_NEW_USER_MODE) == true) goto L149;
        r47 = true;
    L151:
        r37 = r210;
    L137:
        notifyDidAndIidLoadSuccessEvent();     // Catch: JSONException -> L154
        r111 = false;
        MigrateDetector.saveOldDid(this.mApp, this.mOptions, null, false);     // Catch: JSONException -> L152
        goto L140
    L126:
        if (TextUtils.isEmpty(r24) == true) goto L128;
        r43 = true;
        goto L129
    L120:
        if (TextUtils.isEmpty(r23) == true) goto L122;
        r42 = true;
        goto L124
    L113:
        if (updateHeader(Api.KEY_SSID, r8) == false) goto L116;
        this.mSpCache.cacheString(Api.KEY_SSID, r8);     // Catch: JSONException -> L103
        r40 = true;
        r113 = true;
        goto L117
    L107:
        if (updateHeader(Api.KEY_KLINK_EGDI, r7) == false) goto L110;
        this.mSpCache.cacheString(Api.KEY_KLINK_EGDI, r7);     // Catch: JSONException -> L103
        DrLog.d("[egdi] no retry. direct cache egdi");     // Catch: JSONException -> L103
        r40 = true;
        r32 = true;
        goto L110
    L96:
        if (updateHeader("install_id", r24) == false) goto L105;
        this.mSpCache.cacheString("install_id", r24);     // Catch: JSONException -> L103
        if (TextUtils.isEmpty(r41) == true) goto L102;
        JSONObject r48 = new JSONObject();     // Catch: JSONException -> L103
        r48.put("old_id", r41);     // Catch: JSONException -> L103
        r48.put("new_id", r24);     // Catch: JSONException -> L103
        IEventDepend r49 = this.mOptions.getEventDepend();     // Catch: JSONException -> L103
        if (r49 == null) goto L102;
        r49.onEvent("iid_change", r48);     // Catch: JSONException -> L103
    L102:
        r40 = true;
        r32 = true;
    L154:
        e = e;
        r111 = false;
        goto L156
    L207:
    L90:
        e = e;
        boolean r50 = r21 ? 1 : 0;
        goto L58
    L68:
        if (r23.equals(this.mHeader.optString("device_id")) == false) goto L202;
        r40 = r28;
    L84:
        r210 = r21;
        if (r23.equals(r34) == true) goto L200;
        if (TextUtils.isEmpty(r34) == true) goto L89;
        monitorDidError(r11, r23, r34);     // Catch: JSONException -> L103
    L89:
        r32 = true;
        r210 = r21;
        goto L200
    L202:
        monitor-enter(DeviceManager.class);     // Catch: JSONException -> L90
        JSONObject r51 = this.mHeader;     // Catch: Throwable -> L79
        JSONObject r52 = new JSONObject();     // Catch: Throwable -> L77
        Utils.copy(r52, r51);     // Catch: Throwable -> L77
        r52.put("device_id", r23);     // Catch: Throwable -> L77
        this.mHeader = r52;     // Catch: Throwable -> L77
        monitor-exit(DeviceManager.class);     // Catch: Throwable -> L77
        r11.updateDeviceId(r23);     // Catch: JSONException -> L103
        r40 = true;
        r32 = true;
    L79:
        th = th;
        boolean r53 = r21 ? 1 : 0;
    L81:
        monitor-exit(DeviceManager.class);     // Catch: Throwable -> L77
        throw th;     // Catch: JSONException -> L103
    L77:
        th = th;
    L103:
        e = e;
        r17 = r22;
        r35 = r27;
    L157:
        e = e;
        boolean r54 = r21 ? 1 : 0;
        r111 = false;
        r17 = r22;
        r36 = r21;
        goto L166
    L187:
        JSONObject r55 = new JSONObject();     // Catch: JSONException -> L56
        r33 = r27;
        r55.put(ChatMessage.TYPE_RESPONSE, r33);     // Catch: JSONException -> L64
        IEventDepend r56 = this.mOptions.getEventDepend();     // Catch: JSONException -> L64
        if (r56 == null) goto L193;
        r56.onEvent("tt_fetch_did_error", r55);     // Catch: JSONException -> L64
    L56:
        e = e;
        r33 = r27;
        goto L58
    L40:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r20.second, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L47;
        if (r16 == true) goto L45;
        if (r17 == true) goto L45;
        String r57 = (String) ZeusTransformUtils.preCheckCast(r20.first, String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L34
        String r58 = (String) ZeusTransformUtils.preCheckCast(r20.second, String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L34
        r16 = Utils.checkId(r57);     // Catch: JSONException -> L34
        r17 = Utils.checkId(r58);     // Catch: JSONException -> L34
    L46:
        r24 = r58;
        r23 = r57;
        r21 = r16;
        r22 = r17;
        r28 = true;
        r32 = true;
    L34:
        e = e;
        r33 = r27;
        r35 = 0;
    L45:
        r57 = r0;
        r58 = r15;
        goto L46
    L189:
        r12.putLong(KEY_INSTALL_VERSION_CODE, r110);     // Catch: JSONException -> L34
    L159:
        e = e;
        r33 = r27;
        r111 = false;
    L165:
        r36 = r111;
    L161:
        e = e;
        r111 = false;
        r33 = r27;
    L163:
        e = e;
        r33 = r13;
        r111 = false;
        goto L165
    L14:
        r2 = false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r13 = null;
        goto L8
    }

    public void setCallbackCenter(CallbackCenter r1) {
        this.mCallbackCenter = r1;
    }

    public void setEgdiCallback(EgdiCallback r3) {
        this.egdiCallback = (EgdiCallback) ZeusTransformUtils.wrapperContextForParams(r3, EgdiCallback.class, "com.obric.memorydata.plugin");
    }

    public void start() {
        if (this.mStarted.getAndSet(true) == true) goto L6;
        DeviceParamProviderCreator.registerInstallParameterProvider(this.mApp, this.mEnv, this.mOptions);
        return;
    }

    public void updateDrSpecialHeader(JSONObject r1, Env r2) {
        this.mDrSpecialHeaderLoader.doLoad(r1, r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean updateHeader(String r5, Object r6) {
        Object r0 = getConstHeader().opt(r5);
        if (r6 != null) goto L5;
    L6:
        if (r6 != null) goto L20;
        if (r0 == null) goto L20;
    L9:
        monitor-enter(DeviceManager.class);
        JSONObject r2 = this.mHeader;     // Catch: Throwable -> L12 JSONException -> L14
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L12 JSONException -> L14
        Utils.copy(r3, r2);     // Catch: Throwable -> L12 JSONException -> L14
        r3.put(r5, r6);     // Catch: Throwable -> L12 JSONException -> L14
        this.mHeader = r3;     // Catch: Throwable -> L12 JSONException -> L14
    L16:
        monitor-exit(DeviceManager.class);     // Catch: Throwable -> L12
        boolean r4 = true;
    L22:
        if (DrLog.debug() == false) goto L24;
        DrLog.d("updateHeader, " + r5 + ", " + r0 + ", " + r6);
    L24:
        return r4;
    L12:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        DrLog.ysnp(e);     // Catch: Throwable -> L12
    L20:
        r4 = false;
        goto L22
    L5:
        if (r6.equals(r0) == false) goto L9;
        goto L6
    }
}
