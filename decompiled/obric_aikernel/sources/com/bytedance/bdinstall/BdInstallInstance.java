package com.bytedance.bdinstall;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.HeaderUpdateCallback;
import com.bytedance.bdinstall.callback.InstallFinishCallback;
import com.bytedance.bdinstall.callback.OaidCallback;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.DataObserverInstance;
import com.bytedance.bdinstall.util.InstanceHolder;
import com.bytedance.bdinstall.util.NetworkStatusProvider;
import com.bytedance.bdinstall.util.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BdInstallInstance implements IBDInstallApi {
    private static final AtomicInteger sInstId = null;
    private static Map<String, BdInstallInstance> sInstanceMap;
    private ApiParamsUtil mApiParamsUtil;
    public final CallbackCenter mCallbackCenter;
    private DataObserverInstance mDataObserverInstance;
    private volatile IAdIdConfig sAdIdConfig;
    private volatile AppContext sAppContext;
    private volatile IParamFilter sFilter;
    private final Singleton<InstallInfo> sInstallInfoBeforeInit;
    private final InstallWaitingLock sInstallLock;

    @SuppressLint({"CI_StaticFieldLeak", "StaticFieldLeak"})
    private volatile InstallOptions sOptions;
    private final InstanceHolder<IInstallService> service;

    static {
        sInstanceMap = new ConcurrentHashMap();
        sInstId = new AtomicInteger(0);
    }

    public BdInstallInstance() {
        this.sOptions = null;
        this.sAdIdConfig = new IAdIdConfig.AdIdConfig();
        this.sInstallLock = new InstallWaitingLock();
        this.service = new AnonymousClass1(this);
        this.sInstallInfoBeforeInit = new AnonymousClass2(this);
        sInstId.incrementAndGet();
        this.mApiParamsUtil = new ApiParamsUtil(this);
        this.mDataObserverInstance = new DataObserverInstance();
        this.mCallbackCenter = new CallbackCenter();
    }

    private boolean checkInit() {
        if (BDInstall.isMainInstance(this) == false) goto L6;
        return true;
    L6:
        if (this.sOptions != null) goto L10;
        return false;
    L10:
        return true;
    }

    private Integer getAid() {
        if (this.sOptions == null) goto L8;
        int r10 = this.sOptions.getAid();
    L6:
        return Integer.valueOf(r10);
    L8:
        if (this.sAppContext == null) goto L10;
        r10 = this.sAppContext.getAid();
        goto L6
    L10:
        return null;
    }

    private Context getContext() {
        if (this.sOptions == null) goto L9;
        if (this.sOptions.getContext() == null) goto L9;
        return this.sOptions.getContext();
    L9:
        if (this.sAppContext == null) goto L15;
        if (this.sAppContext.getContext() == null) goto L15;
        return this.sAppContext.getContext();
    L15:
        return BDInstallProvider.getFallbackContext();
    }

    public static BdInstallInstance getInstance(String r10) {
        return sInstanceMap.get(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean activeManually() {
        Context r10 = getContext();
        if (r10 != null) goto L6;
        return false;
    L6:
        return this.service.get(new Object[]{r10}).activeManually();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addCustomParamsWithLevel(String r10, String r11, Level r12) {
        if (checkInit() == false) goto L6;
        this.mApiParamsUtil.addCustomParamsWithLevel(r10, r11, r12);
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    @AnyThread
    public void addHeaderChangeListener(boolean r10, HeaderUpdateListener r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        this.mCallbackCenter.register(r10, new HeaderUpdateCallback(r11));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    @AnyThread
    public void addInstallListener(boolean r10, IInstallListener r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        this.mCallbackCenter.register(r10, new InstallFinishCallback(r11));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context r10, String r11, boolean r12, Level r13) {
        return addNetCommonParams(r10, new StringBuilder(r11), r12, r13);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context r10, StringBuilder r11, String r12, boolean r13, Level r14) {
        if (checkInit() == true) goto L5;
        return null;
    L5:
        return this.mApiParamsUtil.appendNetParams(r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context r10, StringBuilder r11, boolean r12, Level r13) {
        if (checkInit() == true) goto L5;
        return null;
    L5:
        return this.mApiParamsUtil.appendNetParams(r10, r11, null, r12, r13);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    @AnyThread
    public void addOaidObserver(boolean r10, IOaidObserver r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        this.mCallbackCenter.register(r10, new OaidCallback(r11));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addOnDataObserver(IDataObserver r10) {
        this.mDataObserverInstance.addDataObserver(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void changeUriRuntimeAndReInstall(Env r10) {
        Context r11 = getContext();
        if (r11 != null) goto L5;
        return;
    L5:
        this.service.get(new Object[]{r11}).changeUriRuntimeAndReInstall(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void clearAndSetEnv(Env r10) {
        Context r11 = getContext();
        if (r11 != null) goto L5;
        return;
    L5:
        this.service.get(new Object[]{r11}).clearAndSetEnv(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void clearInstallInfoWhenSwitchChildMode(Env r10) {
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public IAdIdConfig getAdIdConfig() {
        return this.sAdIdConfig;
    }

    public ApiParamsUtil getApiParamsUtil() {
        return this.mApiParamsUtil;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public AppContext getAppContext() {
        return this.sAppContext;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public Env getCurrentEnv() {
        Context r10 = getContext();
        if (r10 != null) goto L7;
        return null;
    L7:
        return this.service.get(new Object[]{r10}).getCurEnv();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean getCurrentHeader(JSONObject r10) {
        Context r11 = getContext();
        if (r11 != null) goto L10;
        return false;
    L10:
        return this.service.get(new Object[]{r11}).getHeader(r10);
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public DataObserverInstance getDataObserverInstance() {
        return this.mDataObserverInstance;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String getDid() {
        if (this.sOptions != null) goto L5;
    L9:
        DrLog.e("BDInstall#getDid error, not init yet!");
        InstallInfo r10 = tryGetFallbackInstallInfo(getAppContext());
        if (r10 != null) goto L13;
        return null;
    L13:
        return r10.getDid();
    L5:
        if (this.sOptions.getContext() == null) goto L9;
        return this.service.get(new Object[]{this.sOptions.getContext()}).getDid();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo getInstallInfo() {
        if (this.sOptions != null) goto L5;
    L9:
        DrLog.e("BDInstall#getInstallInfo error, not init yet!");
        return tryGetFallbackInstallInfo(getAppContext());
    L5:
        if (this.sOptions.getContext() == null) goto L9;
        return this.service.get(new Object[]{this.sOptions.getContext()}).getInstallInfo();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallOptions getInstallOptions() {
        return this.sOptions;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public IParamFilter getParamsFilter() {
        return this.sFilter;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public Map<String, String> getRequestHeader() {
        if (checkInit() == true) goto L5;
        return null;
    L5:
        if (this.sOptions == null) goto L12;
        DeviceTokenService r10 = (DeviceTokenService) ServiceManager.getService(DeviceTokenService.class, String.valueOf(this.sOptions.getAid()));
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.getRequestHeader();
    L12:
        return null;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void getSSIDs(Map<String, String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        InstallInfo r11 = getInstallInfo();
        if (r11 != null) goto L7;
        return;
    L7:
        String r12 = r11.getDid();
        if (TextUtils.isEmpty(r12) == true) goto L10;
        r10.put("device_id", r12);
    L10:
        String r13 = r11.getIid();
        if (TextUtils.isEmpty(r13) == true) goto L13;
        r10.put("install_id", r13);
    L13:
        String r14 = r11.getOpenUdid();
        if (TextUtils.isEmpty(r14) == true) goto L16;
        r10.put("openudid", r14);
    L16:
        String r15 = r11.getClientUdid();
        if (TextUtils.isEmpty(r15) == true) goto L20;
        r10.put("clientudid", r15);
        return;
    }

    public InstallWaitingLock getsInstallLock() {
        return this.sInstallLock;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void init(InstallOptions r10) {
        init(r10, new Env(InstallUrl.createUriByDomain("https://log.snssdk.com"), false, false));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void init(InstallOptions r10, Env r11) {
        monitor-enter(this);
        if (r10 == null) goto L24;
        if (sInstanceMap.containsKey(String.valueOf(r10.getAid())) == true) goto L19;
        DrLog.d("instance init " + r10.getAid());     // Catch: Throwable -> L21
        sInstanceMap.put(String.valueOf(r10.getAid()), this);     // Catch: Throwable -> L21
        r10.setIsMainInstance(BDInstall.isMainInstance(this));     // Catch: Throwable -> L21
        this.sOptions = r10;     // Catch: Throwable -> L21
        this.mCallbackCenter.init(this.sOptions.getAidString());     // Catch: Throwable -> L21
        IParamFilter r12 = r10.getParamFilter();     // Catch: Throwable -> L21
        if (r12 == null) goto L10;
        this.sFilter = r12;     // Catch: Throwable -> L21
    L10:
        if (r10.getAdIdConfig() == null) goto L12;
        this.sAdIdConfig = r10.getAdIdConfig();     // Catch: Throwable -> L21
    L12:
        ISstInfoProvider r13 = r10.getSstInfoProvider();     // Catch: Throwable -> L21
        if (r13 == null) goto L16;
        SstInfoCompat.setSstInfoProvider(String.valueOf(r10.getAid()), r13);     // Catch: Throwable -> L21
    L16:
        if (r10.isEnableNetCommOpt() == false) goto L18;
        this.mApiParamsUtil.setNetworkProvider(NetworkStatusProvider.getInstance(r10.getContext()));     // Catch: Throwable -> L21
        NetworkStatusProvider.incrementReferenceCount();     // Catch: Throwable -> L21
    L18:
        this.service.get(new Object[]{r10.getContext()}).init(r10, r11);     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L24:
        throw new IllegalStateException("options must not be null!");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserFirstLaunch() {
        Context r10 = getContext();
        if (r10 != null) goto L6;
        return false;
    L6:
        return this.service.get(new Object[]{r10}).isNewUserFirstLaunch();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserMode() {
        Integer r10 = getAid();
        if (r10 != null) goto L5;
        return false;
    L5:
        INewUserModeService r11 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(r10));
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.isNewUserMode();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserModeAvailable() {
        Class.forName(Constants.NAME_NEW_USER_IMPL);     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public JSONObject loadOrGetHeader() {
        Context r10 = getContext();
        if (r10 != null) goto L7;
        return null;
    L7:
        return this.service.get(new Object[]{r10}).loadOrGetHeader();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public NUApi newUserMode() {
        Integer r10 = getAid();
        if (r10 != null) goto L5;
        return null;
    L5:
        INewUserModeService r11 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(r10));
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.getApi();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void putCommonParams(Context r10, Map<String, String> r11, boolean r12, Level r13) {
        if (checkInit() == false) goto L6;
        this.mApiParamsUtil.appendParamsToMap(r10, r12, null, r11, r13);
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void registerLifeCycleListener(Application r10) {
        if (r10 != null) goto L5;
        Log.e("DrLog", "application is null when registerLifeCycleListener");
        return;
    L5:
        this.service.get(new Object[]{r10}).registerLifeCycleListener(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeCustomParamsWithLevel(String r10, Level r11) {
        if (checkInit() == false) goto L6;
        this.mApiParamsUtil.removeCustomParamsWithLevel(r10, r11);
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    @AnyThread
    public void removeHeaderChangeListener(HeaderUpdateListener r10) {
        this.mCallbackCenter.unregister(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    @AnyThread
    public void removeInstallListener(IInstallListener r10) {
        this.mCallbackCenter.unregister(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeOaidObserver(IOaidObserver r10) {
        this.mCallbackCenter.unregister(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeOnDataObserver(IDataObserver r10) {
        this.mDataObserverInstance.removeDataObserver(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void resetAndReInstall(Context r10, Env r11, long r12, OnResetListener r13) {
        Context r14 = getContext();
        if (r14 != null) goto L5;
        return;
    L5:
        this.service.get(new Object[]{r14}).resetAndReInstall(r10, r11, r12, r13);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void resetInstallInfoWhenSwitchChildMode(Context r10, Env r11, long r12, OnResetListener r13) {
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAccount(Account r10) {
        Context r11 = getContext();
        if (r11 != null) goto L5;
        return;
    L5:
        this.service.get(new Object[]{r11}).setAccount(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAdIdConfig(IAdIdConfig r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.sAdIdConfig = r10;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAppContext(AppContext r10) {
        this.sAppContext = r10;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAppTrack(Context r10, JSONObject r11) {
        if (r10 != null) goto L5;
        DrLog.e("context is null when setAppTrack");
        return;
    L5:
        HashMap r12 = new HashMap();
        if (r11 != null) goto L8;
        String r13 = null;
    L9:
        r12.put(Api.KEY_APP_TRACK, r13);
        this.service.get(new Object[]{r10}).updateHeader(r10, r12, true, false);
        return;
    L8:
        r13 = r11.toString();
        goto L9
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setCommonExtraParam(IExtraParams r10) {
        if (checkInit() == false) goto L6;
        this.mApiParamsUtil.setExtraParams(r10);
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setCustomHeader(Context r10, JSONObject r11) {
        HashMap r12 = new HashMap();
        r12.put("custom", r11);
        this.service.get(new Object[]{r10}).updateMemoryHeader(r10, r12);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setExecutor(ExecutorOptions r10, String r11) {
        ExecutorUtil.setExecutor(r11, r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setInstallInfo(InstallInfo r10) {
        Context r11 = getContext();
        if (r11 != null) goto L5;
        return;
    L5:
        this.service.get(new Object[]{r11}).setInstallInfo(r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setParamsFilter(IParamFilter r10) {
        this.sFilter = r10;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setUserAgent(Context r10, String r11) {
        if (r10 != null) goto L5;
        DrLog.e("context is null when setUserAgent");
        return;
    L5:
        HashMap r12 = new HashMap();
        r12.put(Api.KEY_USER_AGENT, r11);
        this.service.get(new Object[]{r10}).updateHeader(r10, r12, true, false);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setUserUniqueId(Context r10, String r11) {
        HashMap r12 = new HashMap();
        r12.put(Api.KEY_USER_UNIQUE_ID, r11);
        this.service.get(new Object[]{r10}).updateHeader(r10, r12, true, true);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void start() {
        if (this.sOptions != null) goto L5;
        return;
    L5:
        this.service.get(new Object[]{this.sOptions.getContext()}).start();
        Oaid.instance(this.sOptions.getContext()).setInstallOptions(this.sOptions);
        Oaid.instance(this.sOptions.getContext()).setCallbackCenter(this.mCallbackCenter);
        Oaid.instance(this.sOptions.getContext()).startNotify();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void stopNetCommOpt(Context r10) {
        if (NetworkStatusProvider.instance() == null) goto L6;
        NetworkStatusProvider.instance().stop();
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo tryGetFallbackInstallInfo(AppContext r10) {
        Context r11 = getContext();
        if (r11 != null) goto L7;
        return null;
    L7:
        return this.sInstallInfoBeforeInit.get(new Object[]{r11});
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void updateLanguageAndRegion(Context r10, String r11, String r12) {
        HashMap r13 = new HashMap();
        r13.put(Api.KEY_APP_LANGUAGE, r11);
        r13.put(Api.KEY_APP_REGION, r12);
        this.service.get(new Object[]{r10}).updateHeader(r10, r13, true, true);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    @Nullable
    public InstallInfo waitingForInstallFinish(long r10) {
        Integer r11 = getAid();
        InstallInfo r12 = getInstallInfo();
        if (r11 == null) goto L11;
        if (r12 != null) goto L6;
    L9:
        this.sInstallLock.tryWaitingForInstallFinish(r10, r11);
        return getInstallInfo();
    L6:
        if (TextUtils.isEmpty(r12.getDid()) == true) goto L9;
        if (TextUtils.isEmpty(r12.getIid()) == true) goto L9;
    L11:
        return r12;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    @Nullable
    public InstallInfo waitingForInstallFinishWithOldWay() {
        Integer r10 = getAid();
        InstallInfo r11 = getInstallInfo();
        if (r10 == null) goto L11;
        if (r11 != null) goto L6;
    L9:
        this.sInstallLock.tryWaitingForInstallFinishInOldWay(r10);
        return getInstallInfo();
    L6:
        if (TextUtils.isEmpty(r11.getDid()) == true) goto L9;
        if (TextUtils.isEmpty(r11.getIid()) == true) goto L9;
    L11:
        return r11;
    }
}
