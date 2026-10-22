package com.ss.android.lark.diskmanage.monitor.settings;

import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DiskMonitorConfig {
    private MonitorExceptionConfig exceptionConfig;
    private String extraConfig;
    private MonitorGlobalConfig globalConfig;

    public String toString() {
        return "DiskMonitorConfig{globalConfig=" + this.globalConfig + ", exceptionConfig=" + this.exceptionConfig + ", extraConfig='" + this.extraConfig + "'}";
    }

    public DiskMonitorConfig() {
        this.globalConfig = new MonitorGlobalConfig();
        this.exceptionConfig = new MonitorExceptionConfig();
        this.extraConfig = BuildConfig.FLAVOR;
    }

    public MonitorExceptionConfig getExceptionConfig() {
        return this.exceptionConfig;
    }

    public String getExtraConfig() {
        return this.extraConfig;
    }

    public MonitorGlobalConfig getGlobalConfig() {
        return this.globalConfig;
    }

    public void setExceptionConfig(MonitorExceptionConfig r1) {
        this.exceptionConfig = r1;
    }

    public void setExtraConfig(String r1) {
        this.extraConfig = r1;
    }

    public void setGlobalConfig(MonitorGlobalConfig r1) {
        this.globalConfig = r1;
    }
}
