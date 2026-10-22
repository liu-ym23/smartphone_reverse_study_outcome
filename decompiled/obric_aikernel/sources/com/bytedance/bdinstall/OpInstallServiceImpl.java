package com.bytedance.bdinstall;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.bytedance.bdinstall.service.IInstallService;
import com.bytedance.bdinstall.service.ServiceManager;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class OpInstallServiceImpl implements IInstallService, OpInstallOptionsHelper.OnDataChangedListener {
    private IBDInstallApi mBDInstallApi;
    private CallbackCenter mCallbackCenter;
    private InstallInfo mInstallInfo;

    OpInstallServiceImpl(IBDInstallApi r10) {
        this.mBDInstallApi = r10;
        DrLog.d("OTHER PROCESS IMPL");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean activeManually() {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void changeUriRuntimeAndReInstall(Env r10) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void clearAndSetEnv(Env r10) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public Env getCurEnv() {
        return null;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public String getDid() {
        InstallInfo r10 = this.mInstallInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getDid();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public boolean getHeader(JSONObject r10) {
        return false;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public InstallInfo getInstallInfo() {
        InstallInfo r10 = this.mInstallInfo;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.clone();
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void init(InstallOptions r10, Env r11) {
        OpInstallOptionsHelper r12 = new OpInstallOptionsHelper(r10.getContext());
        r12.setInstallOptions(r10);
        r12.startObserver(r10.getContext(), this);
        Cdid.get(r10);
        ServiceManager.registerService(DeviceTokenService.class, new CpDeviceTokenServiceImpl(r10), String.valueOf(r10.getAid()));
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
    public void onInstallInfoChanged(InstallInfo r10, String r11) {
        DrLog.d("install info changed : " + r10);
        this.mBDInstallApi.setInstallInfo(r10);
        CallbackCenter r12 = this.mCallbackCenter;
        if (r12 == null) goto L6;
        r12.postEvent(new InstallFinishEvent(r10));
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void registerLifeCycleListener(Application r10) {
        throw new IllegalStateException("BdInstall process is wrong");
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void resetAndReInstall(Context r10, Env r11, long r12, OnResetListener r13) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setAccount(Account r10) {
    }

    public void setCallbackCenter(CallbackCenter r10) {
        this.mCallbackCenter = r10;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void setInstallInfo(InstallInfo r10) {
        this.mInstallInfo = r10;
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void start() {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateHeader(Context r10, Map<String, String> r11, boolean r12, boolean r13) {
    }

    @Override // com.bytedance.bdinstall.service.IInstallService
    public void updateMemoryHeader(Context r10, Map<String, Object> r11) {
    }
}
