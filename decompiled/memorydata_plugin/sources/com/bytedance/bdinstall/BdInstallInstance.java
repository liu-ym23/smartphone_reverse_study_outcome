package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BdInstallInstance implements IBDInstallApi {
    private static final AtomicInteger sInstId = null;
    private static Map<String, BdInstallInstance> sInstanceMap;
    private final AtomicBoolean autoActiveAfterInit;
    private final BDInstallConfig bdInstallConfig;
    private final AtomicBoolean hasInit;
    private ApiParamsUtil mApiParamsUtil;
    public final CallbackCenter mCallbackCenter;
    private DataObserverInstance mDataObserverInstance;
    private volatile IAdIdConfig sAdIdConfig;
    private volatile AppContext sAppContext;
    private volatile IParamFilter sFilter;
    private final Singleton<InstallInfo> sInstallInfoBeforeInit;
    private final InstallWaitingLock sInstallLock;
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
        this.hasInit = new AtomicBoolean(false);
        this.autoActiveAfterInit = new AtomicBoolean(false);
        this.bdInstallConfig = new BDInstallConfig();
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
        int r1 = this.sOptions.getAid();
    L6:
        return Integer.valueOf(r1);
    L8:
        if (this.sAppContext == null) goto L10;
        r1 = this.sAppContext.getAid();
        goto L6
    L10:
        return null;
    }

    private Context getContext() {
        if (this.sOptions == null) goto L10;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L10;
        Context r3 = this.sOptions.getContext();
    L8:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L10:
        if (this.sAppContext != null) goto L12;
    L14:
        r3 = BDInstallProvider.getFallbackContext();
        goto L8
    L12:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sAppContext.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L14;
        r3 = this.sAppContext.getContext();
        goto L8
    }

    public static BdInstallInstance getInstance(String r2) {
        return (BdInstallInstance) ZeusTransformUtils.preCheckCast(sInstanceMap.get(r2), BdInstallInstance.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean activeManually() {
        if (this.hasInit.get() == true) goto L6;
        this.autoActiveAfterInit.set(true);
        return false;
    L6:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        return false;
    L10:
        return ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).activeManually();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addCustomParamsWithLevel(String r2, String r3, Level r4) {
        if (checkInit() == false) goto L6;
        this.mApiParamsUtil.addCustomParamsWithLevel(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addHeaderChangeListener(boolean r3, HeaderUpdateListener r4) {
        HeaderUpdateListener r5 = (HeaderUpdateListener) ZeusTransformUtils.wrapperContextForParams(r4, HeaderUpdateListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.mCallbackCenter.register(r3, new HeaderUpdateCallback(r5));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addInstallListener(boolean r3, IInstallListener r4) {
        IInstallListener r5 = (IInstallListener) ZeusTransformUtils.wrapperContextForParams(r4, IInstallListener.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.mCallbackCenter.register(r3, new InstallFinishCallback(r5));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context r3, String r4, boolean r5, Level r6) {
        return addNetCommonParams((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), new StringBuilder(r4), r5, r6);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context r7, StringBuilder r8, String r9, boolean r10, Level r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (checkInit() == true) goto L5;
        return null;
    L5:
        return this.mApiParamsUtil.appendNetParams(r1, r8, r9, r10, r11);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public String addNetCommonParams(Context r7, StringBuilder r8, boolean r9, Level r10) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (checkInit() == true) goto L5;
        return null;
    L5:
        return this.mApiParamsUtil.appendNetParams(r1, r8, null, r9, r10);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addOaidObserver(boolean r3, IOaidObserver r4) {
        IOaidObserver r5 = (IOaidObserver) ZeusTransformUtils.wrapperContextForParams(r4, IOaidObserver.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.mCallbackCenter.register(r3, new OaidCallback(r5));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addOnDataObserver(IDataObserver r3) {
        IDataObserver r4 = (IDataObserver) ZeusTransformUtils.wrapperContextForParams(r3, IDataObserver.class, "com.obric.memorydata.plugin");
        this.mDataObserverInstance.addDataObserver(r4);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void addRegisterCustomHeader(Context r4, JSONObject r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        r0.put(Api.KEY_REGISTER_CUSTOM, r5);
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r6}), IInstallService.class, "com.obric.memorydata.plugin")).updateMemoryHeader(r6, r0);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void changeUriRuntimeAndReInstall(Env r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).changeUriRuntimeAndReInstall(r5);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void clearAndSetEnv(Env r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).clearAndSetEnv(r5);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void clearInstallInfoWhenSwitchChildMode(Env r1) {
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
    public BDInstallConfig getBDInstallConfig() {
        return this.bdInstallConfig;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public Env getCurrentEnv() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).getCurEnv();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean getCurrentHeader(JSONObject r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        return false;
    L10:
        return ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).getHeader(r5);
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
        InstallInfo r5 = tryGetFallbackInstallInfo(getAppContext());
        if (r5 != null) goto L13;
        return null;
    L13:
        return r5.getDid();
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L9;
        return ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")}), IInstallService.class, "com.obric.memorydata.plugin")).getDid();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo getInstallInfo() {
        if (this.sOptions != null) goto L5;
    L9:
        DrLog.e("BDInstall#getInstallInfo error, not init yet!");
        return tryGetFallbackInstallInfo(getAppContext());
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L9;
        return ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")}), IInstallService.class, "com.obric.memorydata.plugin")).getInstallInfo();
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
        DeviceTokenService r2 = (DeviceTokenService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(DeviceTokenService.class, String.valueOf(this.sOptions.getAid())), DeviceTokenService.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.getRequestHeader();
    L12:
        return null;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void getSSIDs(Map<String, String> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        InstallInfo r2 = getInstallInfo();
        if (r2 != null) goto L8;
        return;
    L8:
        String r0 = r2.getDid();
        if (TextUtils.isEmpty(r0) == true) goto L11;
        r4.put("device_id", r0);
    L11:
        String r1 = r2.getIid();
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r4.put("install_id", r1);
    L14:
        String r5 = r2.getOpenUdid();
        if (TextUtils.isEmpty(r5) == true) goto L17;
        r4.put("openudid", r5);
    L17:
        String r6 = r2.getClientUdid();
        if (TextUtils.isEmpty(r6) == true) goto L21;
        r4.put("clientudid", r6);
        return;
    }

    public InstallWaitingLock getsInstallLock() {
        return this.sInstallLock;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void init(InstallOptions r4) {
        init(r4, new Env(InstallUrl.createUriByDomain("https://log.snssdk.com"), false, false));
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void init(InstallOptions r8, Env r9) {
        monitor-enter(this);
        if (r8 == null) goto L26;
        if (sInstanceMap.containsKey(String.valueOf(r8.getAid())) == true) goto L21;
        DrLog.d("instance init " + r8.getAid());     // Catch: Throwable -> L23
        sInstanceMap.put(String.valueOf(r8.getAid()), this);     // Catch: Throwable -> L23
        r8.setIsMainInstance(BDInstall.isMainInstance(this));     // Catch: Throwable -> L23
        this.sOptions = r8;     // Catch: Throwable -> L23
        this.mCallbackCenter.init(this.sOptions.getAidString());     // Catch: Throwable -> L23
        IParamFilter r0 = r8.getParamFilter();     // Catch: Throwable -> L23
        if (r0 == null) goto L10;
        this.sFilter = r0;     // Catch: Throwable -> L23
    L10:
        if (r8.getAdIdConfig() == null) goto L12;
        this.sAdIdConfig = r8.getAdIdConfig();     // Catch: Throwable -> L23
    L12:
        ISstInfoProvider r1 = r8.getSstInfoProvider();     // Catch: Throwable -> L23
        if (r1 == null) goto L16;
        SstInfoCompat.setSstInfoProvider(String.valueOf(r8.getAid()), r1);     // Catch: Throwable -> L23
    L16:
        if (r8.isEnableNetCommOpt() == false) goto L18;
        this.mApiParamsUtil.setNetworkProvider(NetworkStatusProvider.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L23
        NetworkStatusProvider.incrementReferenceCount();     // Catch: Throwable -> L23
    L18:
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")}), IInstallService.class, "com.obric.memorydata.plugin")).init(r8, r9);     // Catch: Throwable -> L23
        this.hasInit.set(true);     // Catch: Throwable -> L23
        if (this.autoActiveAfterInit.get() == false) goto L21;
        activeManually();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L26:
        throw new IllegalStateException("options must not be null!");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserFirstLaunch() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return false;
    L6:
        return ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).isNewUserFirstLaunch();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserMode() {
        Integer r3 = getAid();
        if (r3 != null) goto L5;
        return false;
    L5:
        INewUserModeService r4 = (INewUserModeService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(INewUserModeService.class, String.valueOf(r3)), INewUserModeService.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        return false;
    L8:
        return r4.isNewUserMode();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public boolean isNewUserModeAvailable() {
        if (ZeusTransformUtils.forName(Constants.NAME_NEW_USER_IMPL, "com.obric.memorydata.plugin") == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public JSONObject loadOrGetHeader() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).loadOrGetHeader();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public NUApi newUserMode() {
        Integer r3 = getAid();
        if (r3 != null) goto L5;
        return null;
    L5:
        INewUserModeService r4 = (INewUserModeService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(INewUserModeService.class, String.valueOf(r3)), INewUserModeService.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.getApi();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void putCommonParams(Context r9, Map<String, String> r10, boolean r11, Level r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        if (checkInit() == false) goto L6;
        this.mApiParamsUtil.appendParamsToMap(r3, r11, null, r6, r12);
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void registerLifeCycleListener(Application r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r4, Application.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        Log.e("bdinstall# ", "application is null when registerLifeCycleListener");
        return;
    L6:
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r5}), IInstallService.class, "com.obric.memorydata.plugin")).registerLifeCycleListener(r5);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeCustomParamsWithLevel(String r2, Level r3) {
        if (checkInit() == false) goto L6;
        this.mApiParamsUtil.removeCustomParamsWithLevel(r2, r3);
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeHeaderChangeListener(HeaderUpdateListener r3) {
        HeaderUpdateListener r4 = (HeaderUpdateListener) ZeusTransformUtils.wrapperContextForParams(r3, HeaderUpdateListener.class, "com.obric.memorydata.plugin");
        this.mCallbackCenter.unregister(r4);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeInstallListener(IInstallListener r3) {
        IInstallListener r4 = (IInstallListener) ZeusTransformUtils.wrapperContextForParams(r3, IInstallListener.class, "com.obric.memorydata.plugin");
        this.mCallbackCenter.unregister(r4);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeOaidObserver(IOaidObserver r3) {
        IOaidObserver r4 = (IOaidObserver) ZeusTransformUtils.wrapperContextForParams(r3, IOaidObserver.class, "com.obric.memorydata.plugin");
        this.mCallbackCenter.unregister(r4);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void removeOnDataObserver(IDataObserver r3) {
        IDataObserver r4 = (IDataObserver) ZeusTransformUtils.wrapperContextForParams(r3, IDataObserver.class, "com.obric.memorydata.plugin");
        this.mDataObserverInstance.removeDataObserver(r4);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void resetAndReInstall(Context r9, Env r10, long r11, OnResetListener r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r7 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r13, OnResetListener.class, "com.obric.memorydata.plugin");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r12}), IInstallService.class, "com.obric.memorydata.plugin")).resetAndReInstall(r3, r10, r11, r7);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void resetInstallInfoWhenSwitchChildMode(Context r1, Env r2, long r3, OnResetListener r5) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r4 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r5, OnResetListener.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAccount(Account r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).setAccount(r5);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAdIdConfig(IAdIdConfig r3) {
        IAdIdConfig r4 = (IAdIdConfig) ZeusTransformUtils.wrapperContextForParams(r3, IAdIdConfig.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.sAdIdConfig = r4;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAppContext(AppContext r3) {
        this.sAppContext = (AppContext) ZeusTransformUtils.wrapperContextForParams(r3, AppContext.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setAppTrack(Context r5, JSONObject r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        DrLog.e("context is null when setAppTrack");
        return;
    L6:
        HashMap r0 = new HashMap();
        if (r6 != null) goto L9;
        String r8 = null;
    L10:
        r0.put(Api.KEY_APP_TRACK, r8);
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r7}), IInstallService.class, "com.obric.memorydata.plugin")).updateHeader(r7, r0, true, false);
        return;
    L9:
        r8 = r6.toString();
        goto L10
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setCommonExtraParam(IExtraParams r3) {
        IExtraParams r4 = (IExtraParams) ZeusTransformUtils.wrapperContextForParams(r3, IExtraParams.class, "com.obric.memorydata.plugin");
        if (checkInit() == false) goto L6;
        this.mApiParamsUtil.setExtraParams(r4);
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setCustomHeader(Context r4, JSONObject r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        r0.put("custom", r5);
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r6}), IInstallService.class, "com.obric.memorydata.plugin")).updateMemoryHeader(r6, r0);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setExecutor(ExecutorOptions r1, String r2) {
        ExecutorUtil.setExecutor(r2, r1);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setInstallInfo(InstallInfo r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r0}), IInstallService.class, "com.obric.memorydata.plugin")).setInstallInfo(r5);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setParamsFilter(IParamFilter r3) {
        this.sFilter = (IParamFilter) ZeusTransformUtils.wrapperContextForParams(r3, IParamFilter.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setUserAgent(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        DrLog.e("context is null when setUserAgent");
        return;
    L6:
        HashMap r0 = new HashMap();
        r0.put(Api.KEY_USER_AGENT, r6);
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r7}), IInstallService.class, "com.obric.memorydata.plugin")).updateHeader(r7, r0, true, false);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void setUserUniqueId(Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        r0.put(Api.KEY_USER_UNIQUE_ID, r6);
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r7}), IInstallService.class, "com.obric.memorydata.plugin")).updateHeader(r7, r0, true, true);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void start() {
        if (this.sOptions != null) goto L5;
        return;
    L5:
        Oaid.instance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).setInstallOptions(this.sOptions);
        Oaid.instance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).setCallbackCenter(this.mCallbackCenter);
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")}), IInstallService.class, "com.obric.memorydata.plugin")).start();
        Oaid.instance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).startNotify();
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void stopNetCommOpt(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (NetworkStatusProvider.instance() == null) goto L6;
        NetworkStatusProvider.instance().stop();
        return;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo tryGetFallbackInstallInfo(AppContext r4) {
        AppContext r5 = (AppContext) ZeusTransformUtils.wrapperContextForParams(r4, AppContext.class, "com.obric.memorydata.plugin");
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        return null;
    L7:
        return (InstallInfo) ZeusTransformUtils.preCheckCast(this.sInstallInfoBeforeInit.get(new Object[]{r6}), InstallInfo.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public void updateLanguageAndRegion(Context r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        r0.put(Api.KEY_APP_LANGUAGE, r5);
        r0.put(Api.KEY_APP_REGION, r6);
        ((IInstallService) ZeusTransformUtils.preCheckCast(this.service.get(new Object[]{r7}), IInstallService.class, "com.obric.memorydata.plugin")).updateHeader(r7, r0, true, true);
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo waitingForInstallFinish(long r4) {
        Integer r0 = getAid();
        InstallInfo r1 = getInstallInfo();
        if (r0 == null) goto L11;
        if (r1 != null) goto L6;
    L9:
        this.sInstallLock.tryWaitingForInstallFinish(r4, r0);
        return getInstallInfo();
    L6:
        if (TextUtils.isEmpty(r1.getDid()) == true) goto L9;
        if (TextUtils.isEmpty(r1.getIid()) == true) goto L9;
    L11:
        return r1;
    }

    @Override // com.bytedance.bdinstall.IBDInstallApi
    public InstallInfo waitingForInstallFinishWithOldWay() {
        Integer r0 = getAid();
        InstallInfo r1 = getInstallInfo();
        if (r0 == null) goto L11;
        if (r1 != null) goto L6;
    L9:
        this.sInstallLock.tryWaitingForInstallFinishInOldWay(r0);
        return getInstallInfo();
    L6:
        if (TextUtils.isEmpty(r1.getDid()) == true) goto L9;
        if (TextUtils.isEmpty(r1.getIid()) == true) goto L9;
    L11:
        return r1;
    }
}
