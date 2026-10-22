package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.loader.LocaleDeviceManager;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.TimeoutInstallListener;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class InstallServiceImpl implements IInstallService {
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

    InstallServiceImpl(IBDInstallApi r10) {
        this.sStarted = new AtomicBoolean(false);
        this.mBDInstallApi = r10;
    }

    static /* synthetic */ void access$000(InstallServiceImpl r10, boolean r11) {
        r10.doStart(r11);
    }

    static /* synthetic */ InstallDispatcher access$100(InstallServiceImpl r10) {
        return r10.mInstallDispatcher;
    }

    static /* synthetic */ DeviceManager access$200(InstallServiceImpl r10) {
        return r10.mDeviceManager;
    }

    static /* synthetic */ AtomicBoolean access$300(InstallServiceImpl r10) {
        return r10.sStarted;
    }

    static /* synthetic */ void access$400(InstallServiceImpl r10) {
        r10.setStarted();
    }

    static /* synthetic */ InstallOptions access$500(InstallServiceImpl r10) {
        return r10.sOptions;
    }

    private void doStart(boolean r10) {
        if (hasInit() == false) goto L15;
        if (this.sOptions == null) goto L15;
        if (this.sStarted.getAndSet(true) == false) goto L9;
        return;
    L9:
        INewUserModeService r11 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, this.sOptions.getAidString());
        if (r11 == null) goto L12;
        r11.start();
    L12:
        this.mDeviceManager.start();
        this.mInstallDispatcher.start(r10);
        OpInstallOptionsHelper r12 = new OpInstallOptionsHelper(this.sOptions.getContext());
        r12.setInstallOptions(this.sOptions);
        r12.trySync();
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

    private void setStarted() {
        if (LocalConstants.getCommonSp(this.sOptions.getContext(), this.sOptions).getBoolean(Api.KEY_STARTED, false) == true) goto L6;
        LocalConstants.getCommonSp(this.sOptions.getContext(), this.sOptions).edit().putBoolean(Api.KEY_STARTED, true).apply();
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean activeManually() {
        DrLog.d("install#activeManually");
        if (hasInit() == true) goto L5;
        return false;
    L5:
        if (this.sOptions == null) goto L10;
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass5(this));
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void changeUriRuntimeAndReInstall(final Env r10) {
        DrLog.d("install#changeUriRuntimeAndReInstall");
        if (this.mInstallDispatcher != null) goto L5;
    L7:
        DrLog.ysnp(new RuntimeException("not init yet"));
        return;
    L5:
        if (this.sOptions == null) goto L7;
        DrLog.d("changeUriRuntimeAndReInstall " + r10);
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass4(this, r10));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void clearAndSetEnv(final Env r10) {
        DrLog.d("install#clearInstallInfoWhenSwitchChildMode");
        if (this.mInstallDispatcher != null) goto L5;
    L9:
        DrLog.ysnp(new RuntimeException("not init yet"));
        return;
    L5:
        if (this.sOptions == null) goto L9;
        if (this.mDeviceManager == null) goto L9;
        DrLog.d("clearInstallInfoWhenSwitchChildMode " + r10);
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass2(this, r10));
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
    public boolean getHeader(JSONObject r10) {
        if (this.mDeviceManager == null) goto L8;
        JSONObject r11 = this.mDeviceManager.getHeader();
        if (r11 == null) goto L10;
        Utils.copy(r10, r11);
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
    public void init(InstallOptions r10, Env r11) {
        long r12 = System.currentTimeMillis();
        DrLog.d("main process install#init：aid: " + r10.getAid());
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mInstallDispatcher != null) goto L12;
        this.sOptions = r10;     // Catch: Throwable -> L15
        if (TextUtils.equals(r10.getChannel(), "local_test") == true) goto L20;
    L11:
        this.mDeviceManager = new LocaleDeviceManager(r10.getContext(), r10, r11);     // Catch: Throwable -> L15
        this.mDeviceManager.setCallbackCenter(this.mCallbackCenter);     // Catch: Throwable -> L15
        this.mInstallDispatcher = new InstallDispatcher(r10, this.mDeviceManager, BDInstall.getAppLifeCycleListener(), r11);     // Catch: Throwable -> L15
        this.mInstallDispatcher.setCallbackCenter(this.mCallbackCenter);     // Catch: Throwable -> L15
        ServiceManager.registerService(DeviceTokenService.class, new DeviceTokenServiceImpl(r10, r11), String.valueOf(r10.getAid()));     // Catch: Throwable -> L15
        goto L12
    L20:
        ServiceManager.registerService(INewUserModeService.class, (INewUserModeService) Class.forName(Constants.NAME_NEW_USER_IMPL).getConstructor(new Class[]{InstallOptions.class}).newInstance(new Object[]{r10}), String.valueOf(r10.getAid()));     // Catch: Throwable -> L10
    L10:
        DrLog.e("not find new user mode impl ,ignore");     // Catch: Throwable -> L15
    L12:
        monitor-exit(this);     // Catch: Throwable -> L15
        DrLog.d("init ：" + (System.currentTimeMillis() - r12));
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
        JSONObject r10 = this.mDeviceManager.loadOrGetHeader();
        JSONObject r11 = new JSONObject();
        Utils.copy(r11, r10);
        return r11;
    L11:
        return null;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void registerLifeCycleListener(Application r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (mRegistered.compareAndSet(false, true) == false) goto L8;
        BDInstall.registerLifeCycleListener(r10);
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void resetAndReInstall(Context r10, final Env r11, long r12, OnResetListener r13) {
        DrLog.d("install#resetInstallInfoWhenSwitchChildMode");
        if (this.mInstallDispatcher == null) goto L7;
        DrLog.d("resetInstallInfoWhenSwitchChildMode " + r11);
        TimeoutInstallListener r14 = new TimeoutInstallListener(r12, r13, this.sOptions);
        this.mBDInstallApi.addInstallListener(false, r14);
        r14.startTiming();
        if (this.sOptions == null) goto L9;
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass3(this, r11));
        return;
    L9:
        return;
    L7:
        DrLog.ysnp(new RuntimeException("not init yet"));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setAccount(final Account r10) {
        if (this.sOptions != null) goto L5;
        return;
    L5:
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass6(this, r10));
    }

    public void setCallbackCenter(CallbackCenter r10) {
        this.mCallbackCenter = r10;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setInstallInfo(InstallInfo r10) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void start() {
        if (hasInit() == false) goto L9;
        if (this.sOptions == null) goto L9;
        DrLog.d("install#start aid : " + this.sOptions.getAid());
        ExecutorUtil.runOnHandlerThread(this.sOptions.getAidString(), new AnonymousClass1(this));
        setStarted();
        return;
    L9:
        throw new RuntimeException("please init first");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateHeader(Context r10, Map<String, String> r11, boolean r12, boolean r13) {
        SharedPreferences r14 = LocalConstants.getCommonSp(r10, this.sOptions);
        if (r12 == false) goto L5;
        SharedPreferences.Editor r15 = r14.edit();
    L6:
        boolean r16 = false;
        if (this.mDeviceManager == null) goto L22;
        Iterator<Map.Entry<String, String>> r17 = r11.entrySet().iterator();
        boolean r18 = false;
    L10:
        if (r17.hasNext() == false) goto L19;
        Map.Entry<String, String> r19 = r17.next();
        String r20 = r19.getKey();
        String r21 = r19.getValue();
        if (this.mDeviceManager.updateHeader(r20, r21) == true) goto L16;
        if (r18 == true) goto L16;
        r18 = false;
    L17:
        if (r15 == null) goto L10;
        r15.putString(r20, r21);
    L16:
        r18 = true;
        goto L17
    L19:
        if (r15 == null) goto L21;
        r15.apply();
    L21:
        r16 = r18;
    L22:
        if (r16 == false) goto L27;
        if (r13 == false) goto L27;
        if (this.mInstallDispatcher == null) goto L27;
        this.mInstallDispatcher.redoRegister();
    L27:
        if (r16 == true) goto L29;
        return;
    L29:
        if (this.mCallbackCenter == null) goto L38;
        this.mCallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
        return;
    L38:
        return;
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateMemoryHeader(Context r10, Map<String, Object> r11) {
        if (this.mDeviceManager == null) goto L21;
        Iterator<Map.Entry<String, Object>> r12 = r11.entrySet().iterator();
    L5:
        boolean r13 = false;
    L7:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, Object> r14 = r12.next();
        if (this.mDeviceManager.updateHeader(r14.getKey(), r14.getValue()) == true) goto L11;
        if (r13 == false) goto L5;
    L11:
        r13 = true;
        goto L7
    L12:
        if (r13 == true) goto L14;
        return;
    L14:
        if (this.mCallbackCenter == null) goto L23;
        this.mCallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
        return;
    L23:
        return;
    }
}
