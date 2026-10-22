package com.bytedance.crash.monitor;

/* JADX INFO: loaded from: classes.dex */
public class AppVersionModel {
    private long manifestVersionCode;
    private long updateVersionCode;
    private long versionCode;
    private String versionName;

    public AppVersionModel(long r10, long r11, long r12, String r13) {
        this.versionCode = r10;
        this.manifestVersionCode = r12;
        this.versionName = r13;
        this.updateVersionCode = r11;
    }

    public long getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    public long getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public long getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }
}
