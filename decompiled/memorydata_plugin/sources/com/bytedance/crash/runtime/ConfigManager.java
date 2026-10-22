package com.bytedance.crash.runtime;

import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.App;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ConfigManager {
    private boolean mEnsureEnable;

    public ConfigManager() {
        this.mEnsureEnable = true;
    }

    public String getAlogUploadUrl() {
        NetConfig.get();
        return NetConfig.getAlogUploadUrl();
    }

    public long getDefaultAnrCheckInterval() {
        return RuntimeConfig.getAnrCheckInterval();
    }

    public String getNativeCrashUploadUrl() {
        return NetConfig.getNativeCrashUploadUrl();
    }

    public boolean isDebugMode() {
        return RuntimeConfig.isDebugMode();
    }

    public boolean isEnsureEnable() {
        if (RuntimeConfig.isEnsureEnable() == true) goto L5;
        return false;
    L5:
        AppMonitor r1 = MonitorManager.getAppMonitor();
        if (r1 != null) goto L8;
        return false;
    L8:
        return r1.getEnsureDeliver().isEnsureEnable();
    }

    public boolean isReportErrorEnable() {
        return RuntimeConfig.isReportErrorEnable();
    }

    public void setAlogUploadUrl(String r1) {
        NetConfig.get().setAlogUploadUrl(r1);
    }

    public void setConfigGetUrl(String r1) {
        NetConfig.get().setConfigGetUrl(r1);
    }

    public void setCurrentProcessName(String r1) {
        App.setCurProcessName(r1);
    }

    public void setDebugMode(boolean r1) {
        RuntimeConfig.setDebugMode(r1);
    }

    public void setDefaultAnrCheckInterval(long r1) {
        RuntimeConfig.setAnrCheckInterval(r1);
    }

    public void setEncryptImpl(IEncrypt r2) {
        IEncrypt r1 = (IEncrypt) ZeusTransformUtils.wrapperContextForParams(r2, IEncrypt.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        RuntimeConfig.setEncryptImpl(r1);
        return;
    }

    public void setEnsureEnable(boolean r1) {
        RuntimeConfig.setEnsureEnable(r1);
    }

    public void setJavaCrashUploadUrl(String r1) {
        NetConfig.get().setJavaCrashUploadUrl(r1);
    }

    public void setLaunchCrashInterval(long r1) {
        RuntimeConfig.setLaunchCrashInterval(r1);
    }

    public void setLaunchCrashUrl(String r1) {
        NetConfig.get().setLaunchCrashUrl(r1);
    }

    public void setNativeCrashUrl(String r1) {
        NetConfig.get().setNativeCrashUrl(r1);
    }

    public void setReportErrorEnable(boolean r1) {
        RuntimeConfig.setReportErrorEnable(r1);
    }
}
