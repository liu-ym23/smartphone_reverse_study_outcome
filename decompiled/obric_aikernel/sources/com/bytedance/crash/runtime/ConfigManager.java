package com.bytedance.crash.runtime;

import com.bytedance.crash.IEncrypt;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.App;

/* JADX INFO: loaded from: classes.dex */
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
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if (r10 != null) goto L8;
        return false;
    L8:
        return r10.getEnsureDeliver().isEnsureEnable();
    }

    public boolean isReportErrorEnable() {
        return RuntimeConfig.isReportErrorEnable();
    }

    public void setAlogUploadUrl(String r10) {
        NetConfig.get().setAlogUploadUrl(r10);
    }

    public void setConfigGetUrl(String r10) {
        NetConfig.get().setConfigGetUrl(r10);
    }

    public void setCurrentProcessName(String r10) {
        App.setCurProcessName(r10);
    }

    public void setDebugMode(boolean r10) {
        RuntimeConfig.setDebugMode(r10);
    }

    public void setDefaultAnrCheckInterval(long r10) {
        RuntimeConfig.setAnrCheckInterval(r10);
    }

    public void setEncryptImpl(IEncrypt r10) {
        if (r10 == null) goto L5;
        RuntimeConfig.setEncryptImpl(r10);
        return;
    }

    public void setEnsureEnable(boolean r10) {
        RuntimeConfig.setEnsureEnable(r10);
    }

    public void setJavaCrashUploadUrl(String r10) {
        NetConfig.get().setJavaCrashUploadUrl(r10);
    }

    public void setLaunchCrashInterval(long r10) {
        RuntimeConfig.setLaunchCrashInterval(r10);
    }

    public void setLaunchCrashUrl(String r10) {
        NetConfig.get().setLaunchCrashUrl(r10);
    }

    public void setNativeCrashUrl(String r10) {
        NetConfig.get().setNativeCrashUrl(r10);
    }

    public void setReportErrorEnable(boolean r10) {
        RuntimeConfig.setReportErrorEnable(r10);
    }
}
