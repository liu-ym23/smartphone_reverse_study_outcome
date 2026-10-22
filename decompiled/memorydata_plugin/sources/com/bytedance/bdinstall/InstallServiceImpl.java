package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.dtrait.DTLog;
import com.bytedance.bdinstall.dtrait.DTraitService;
import com.bytedance.bdinstall.dtrait.config.DTraitConfig;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.loader.LocaleDeviceManager;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.TimeoutInstallListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class InstallServiceImpl implements IInstallService {
    private static volatile boolean hasLocalDeviceId;
    private static final AtomicBoolean mRegistered = null;
    private IBDInstallApi mBDInstallApi;
    private volatile CallbackCenter mCallbackCenter;
    private volatile DeviceManager mDeviceManager;
    private volatile InstallDispatcher mInstallDispatcher;
    private volatile InstallOptions sOptions;
    private final AtomicBoolean sStarted;

    static {
        mRegistered = new AtomicBoolean(false);
    }

    InstallServiceImpl(IBDInstallApi r3) {
        IBDInstallApi r4 = (IBDInstallApi) ZeusTransformUtils.wrapperContextForParams(r3, IBDInstallApi.class, "com.obric.memorydata.plugin");
        this.sStarted = new AtomicBoolean(false);
        this.mBDInstallApi = r4;
    }

    static /* synthetic */ DeviceManager access$000(InstallServiceImpl r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ void access$100(InstallServiceImpl r0, boolean r1) {
        r0.doStart(r1);
    }

    static /* synthetic */ InstallDispatcher access$200(InstallServiceImpl r0) {
        return r0.mInstallDispatcher;
    }

    static /* synthetic */ AtomicBoolean access$300(InstallServiceImpl r0) {
        return r0.sStarted;
    }

    static /* synthetic */ void access$400(InstallServiceImpl r0) {
        r0.setStarted();
    }

    static /* synthetic */ InstallOptions access$500(InstallServiceImpl r0) {
        return r0.sOptions;
    }

    private void doStart(boolean r4) {
        if (hasInit() == false) goto L15;
        if (this.sOptions == null) goto L15;
        if (this.sStarted.getAndSet(true) == false) goto L9;
        return;
    L9:
        INewUserModeService r0 = (INewUserModeService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(INewUserModeService.class, this.sOptions.getAidString()), INewUserModeService.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        r0.start();
    L12:
        this.mDeviceManager.start();
        this.mInstallDispatcher.start(r4);
        OpInstallOptionsHelper r5 = new OpInstallOptionsHelper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r5.setInstallOptions(this.sOptions);
        r5.trySync();
        return;
    L15:
        throw new RuntimeException("please init first");
    }

    private boolean hasInit() {
        if (this.mInstallDispatcher == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasLocalDeviceId() {
        return hasLocalDeviceId;
    }

    private void initDtrait(final InstallOptions r3) {
        if (DTraitConfig.isEnableDTrait() == false) goto L6;
        DTLog.setLogger(new AnonymousClass1(this));
        DrLog.d("[dt] DTRAIT开启，初始化并执行预加载逻辑......");
        DTraitConfig.setDtraitNetworkConfig(new AnonymousClass2(this, r3));
        DTraitConfig.setDtraitInitConfig(new AnonymousClass3(this, r3));
        new DTraitService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), hasLocalDeviceId).getDTraitManager().preHandleConfigForDTrait();
        return;
    }

    private void setStarted() {
        if (LocalConstants.getCommonSp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.sOptions).getBoolean(Api.KEY_STARTED, false) == true) goto L6;
        LocalConstants.getCommonSp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.sOptions.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.sOptions).edit().putBoolean(Api.KEY_STARTED, true).apply();
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean activeManually() {
        DrLog.d("install#activeManually");
        if (hasInit() == true) goto L5;
        return false;
    L5:
        if (this.sOptions == null) goto L10;
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass8(this));
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void changeUriRuntimeAndReInstall(final Env r3) {
        DrLog.d("install#changeUriRuntimeAndReInstall");
        if (this.mInstallDispatcher != null) goto L5;
    L7:
        DrLog.ysnp(new RuntimeException("not init yet"));
        return;
    L5:
        if (this.sOptions == null) goto L7;
        DrLog.d("changeUriRuntimeAndReInstall " + r3);
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass7(this, r3));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void clearAndSetEnv(final Env r3) {
        DrLog.d("install#clearInstallInfoWhenSwitchChildMode");
        if (this.mInstallDispatcher != null) goto L5;
    L9:
        DrLog.ysnp(new RuntimeException("not init yet"));
        return;
    L5:
        if (this.sOptions == null) goto L9;
        if (this.mDeviceManager == null) goto L9;
        DrLog.d("clearInstallInfoWhenSwitchChildMode " + r3);
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass5(this, r3));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public Env getCurEnv() {
        if (this.mDeviceManager != null) goto L7;
        return null;
    L7:
        return this.mDeviceManager.getCurEnv();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public String getDid() {
        if (this.mDeviceManager != null) goto L7;
        return null;
    L7:
        return this.mDeviceManager.getDid();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean getHeader(JSONObject r2) {
        if (this.mDeviceManager == null) goto L8;
        JSONObject r1 = this.mDeviceManager.getHeader();
        if (r1 == null) goto L10;
        Utils.copy(r2, r1);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public InstallInfo getInstallInfo() {
        if (this.mDeviceManager != null) goto L7;
        return null;
    L7:
        return this.mDeviceManager.getInstallInfo();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void init(InstallOptions r9, Env r10) {
        long r0 = System.currentTimeMillis();
        DrLog.d("main process install#init：aid: " + r9.getAid());
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mInstallDispatcher != null) goto L12;
        this.sOptions = r9;     // Catch: Throwable -> L15
        if (TextUtils.equals(r9.getChannel(), "local_test") == true) goto L18;
    L11:
        this.mDeviceManager = new LocaleDeviceManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9, r10);     // Catch: Throwable -> L15
        this.mDeviceManager.setCallbackCenter(this.mCallbackCenter);     // Catch: Throwable -> L15
        this.mInstallDispatcher = new InstallDispatcher(r9, this.mDeviceManager, BDInstall.getAppLifeCycleListener(), r10);     // Catch: Throwable -> L15
        this.mInstallDispatcher.setCallbackCenter(this.mCallbackCenter);     // Catch: Throwable -> L15
        this.mDeviceManager.setEgdiCallback(this.mInstallDispatcher);     // Catch: Throwable -> L15
        ServiceManager.registerService(DeviceTokenService.class, new DeviceTokenServiceImpl(r9, r10), String.valueOf(r9.getAid()));     // Catch: Throwable -> L15
        hasLocalDeviceId = r9.getSp().contains("device_id");     // Catch: Throwable -> L15
        initDtrait(r9);     // Catch: Throwable -> L15
        goto L12
    L18:
        ServiceManager.registerService(INewUserModeService.class, (INewUserModeService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(Constants.NAME_NEW_USER_IMPL, "com.obric.memorydata.plugin").getConstructor(new Class[]{InstallOptions.class}).newInstance(new Object[]{r9}), INewUserModeService.class, "com.obric.memorydata.plugin"), String.valueOf(r9.getAid()));     // Catch: Throwable -> L10
    L10:
        DrLog.e("not find new user mode impl ,ignore");     // Catch: Throwable -> L15
    L12:
        monitor-exit(this);     // Catch: Throwable -> L15
        DrLog.d("init ：" + (System.currentTimeMillis() - r0));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean isNewUserFirstLaunch() {
        if (this.mDeviceManager != null) goto L5;
        return false;
    L5:
        return this.mDeviceManager.isNewUser();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public JSONObject loadOrGetHeader() {
        if (hasInit() == true) goto L5;
        return null;
    L5:
        if (this.mDeviceManager == null) goto L11;
        JSONObject r1 = this.mDeviceManager.loadOrGetHeader();
        JSONObject r0 = new JSONObject();
        Utils.copy(r0, r1);
        return r0;
    L11:
        return null;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void registerLifeCycleListener(Application r3) {
        Application r2 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return;
    L6:
        if (mRegistered.compareAndSet(false, true) == false) goto L9;
        BDInstall.registerLifeCycleListener(r2);
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void resetAndReInstall(Context r3, final Env r4, long r5, OnResetListener r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r8 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r7, OnResetListener.class, "com.obric.memorydata.plugin");
        DrLog.d("install#resetInstallInfoWhenSwitchChildMode");
        if (this.mInstallDispatcher == null) goto L7;
        DrLog.d("resetInstallInfoWhenSwitchChildMode " + r4);
        TimeoutInstallListener r9 = new TimeoutInstallListener(r5, r8, this.sOptions);
        this.mBDInstallApi.addInstallListener(false, r9);
        r9.startTiming();
        if (this.sOptions == null) goto L9;
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass6(this, r4));
        return;
    L9:
        return;
    L7:
        DrLog.ysnp(new RuntimeException("not init yet"));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setAccount(final Account r3) {
        if (this.sOptions != null) goto L5;
        return;
    L5:
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass9(this, r3));
    }

    public void setCallbackCenter(CallbackCenter r1) {
        this.mCallbackCenter = r1;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setInstallInfo(InstallInfo r1) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void start() {
        if (hasInit() == false) goto L9;
        if (this.sOptions == null) goto L9;
        DrLog.d("install#start aid : " + this.sOptions.getAid());
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass4(this));
        setStarted();
        return;
    L9:
        throw new RuntimeException("please init first");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateHeader(Context r6, Map<String, String> r7, boolean r8, boolean r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        SharedPreferences r12 = LocalConstants.getCommonSp(r10, this.sOptions);
        if (r8 == false) goto L5;
        SharedPreferences.Editor r13 = r12.edit();
    L6:
        boolean r0 = false;
        if (this.mDeviceManager == null) goto L22;
        Iterator r14 = r11.entrySet().iterator();
        boolean r15 = false;
    L10:
        if (r14.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin");
        if (this.mDeviceManager.updateHeader(r3, r4) == true) goto L16;
        if (r15 == true) goto L16;
        r15 = false;
    L17:
        if (r13 == null) goto L10;
        r13.putString(r3, r4);
    L16:
        r15 = true;
        goto L17
    L19:
        if (r13 == null) goto L21;
        r13.apply();
    L21:
        r0 = r15;
    L22:
        if (r0 == false) goto L27;
        if (r9 == false) goto L27;
        if (this.mInstallDispatcher == null) goto L27;
        this.mInstallDispatcher.redoRegister();
    L27:
        if (r0 == true) goto L29;
        return;
    L29:
        if (this.mCallbackCenter == null) goto L38;
        this.mCallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
        return;
    L38:
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateMemoryHeader(Context r6, Map<String, Object> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (this.mDeviceManager == null) goto L21;
        Iterator r10 = new ConcurrentHashMap(r9).entrySet().iterator();
    L5:
        boolean r0 = false;
    L7:
        if (r10.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (this.mDeviceManager.updateHeader((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r2.getValue()) == true) goto L11;
        if (r0 == false) goto L5;
    L11:
        r0 = true;
        goto L7
    L12:
        if (r0 == true) goto L14;
        return;
    L14:
        if (this.mCallbackCenter == null) goto L23;
        this.mCallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
        return;
    L23:
        return;
    }
}
