package com.bytedance.crash.monitor;

/* JADX INFO: loaded from: classes2.dex */
public class AppVersionModel {
    private long manifestVersionCode;
    private long updateVersionCode;
    private long versionCode;
    private String versionName;

    public AppVersionModel(long r1, long r3, long r5, String r7) {
        this.versionCode = r1;
        this.manifestVersionCode = r5;
        this.versionName = r7;
        this.updateVersionCode = r3;
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
