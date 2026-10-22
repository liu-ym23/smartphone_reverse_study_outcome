package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class OpInstallServiceImpl implements OpInstallOptionsHelper.OnDataChangedListener, IInstallService {
    private IBDInstallApi mBDInstallApi;
    private CallbackCenter mCallbackCenter;
    private InstallInfo mInstallInfo;

    OpInstallServiceImpl(IBDInstallApi r3) {
        this.mBDInstallApi = (IBDInstallApi) ZeusTransformUtils.wrapperContextForParams(r3, IBDInstallApi.class, "com.obric.memorydata.plugin");
        DrLog.d("OTHER PROCESS IMPL");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean activeManually() {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void changeUriRuntimeAndReInstall(Env r1) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void clearAndSetEnv(Env r1) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public Env getCurEnv() {
        return null;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public String getDid() {
        InstallInfo r0 = this.mInstallInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDid();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean getHeader(JSONObject r1) {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public InstallInfo getInstallInfo() {
        InstallInfo r0 = this.mInstallInfo;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.clone();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void init(InstallOptions r4, Env r5) {
        OpInstallOptionsHelper r6 = new OpInstallOptionsHelper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r6.setInstallOptions(r4);
        r6.startObserver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this);
        Cdid.get(r4);
        ServiceManager.registerService(DeviceTokenService.class, new CpDeviceTokenServiceImpl(r4), String.valueOf(r4.getAid()));
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean isNewUserFirstLaunch() {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public JSONObject loadOrGetHeader() {
        return null;
    }

    @Override // com.bytedance.bdinstall.OpInstallOptionsHelper.OnDataChangedListener
    public void onInstallInfoChanged(InstallInfo r2, String r3) {
        DrLog.d("install info changed : " + r2);
        this.mBDInstallApi.setInstallInfo(r2);
        CallbackCenter r1 = this.mCallbackCenter;
        if (r1 == null) goto L6;
        r1.postEvent(new InstallFinishEvent(r2));
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void registerLifeCycleListener(Application r2) {
        Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        throw new IllegalStateException("BdInstall process is wrong");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void resetAndReInstall(Context r1, Env r2, long r3, OnResetListener r5) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        OnResetListener r4 = (OnResetListener) ZeusTransformUtils.wrapperContextForParams(r5, OnResetListener.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setAccount(Account r1) {
    }

    public void setCallbackCenter(CallbackCenter r1) {
        this.mCallbackCenter = r1;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setInstallInfo(InstallInfo r1) {
        this.mInstallInfo = r1;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void start() {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateHeader(Context r1, Map<String, String> r2, boolean r3, boolean r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateMemoryHeader(Context r2, Map<String, Object> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }
}
