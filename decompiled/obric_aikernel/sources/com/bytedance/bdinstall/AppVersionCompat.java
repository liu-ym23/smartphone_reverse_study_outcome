package com.bytedance.bdinstall;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes.dex */
final class AppVersionCompat {
    private final Context context;
    private final Singleton<PackageInfo> mPackageInfo;
    private final long manifestVersionCode;
    private final long updateVersionCode;
    private final String version;
    private final long versionCode;
    private final String versionMinor;

    AppVersionCompat(Builder r10) {
        this.mPackageInfo = new AnonymousClass1(this);
        this.context = r10.context;
        this.version = r10.version;
        if (TextUtils.isEmpty(r10.versionMinor) == false) goto L5;
        String r11 = "";
    L6:
        this.versionMinor = r11;
        this.versionCode = r10.versionCode;
        this.updateVersionCode = r10.updateVersionCode;
        this.manifestVersionCode = r10.manifestVersionCode;
        return;
    L5:
        r11 = r10.versionMinor;
        goto L6
    }

    static /* synthetic */ Context access$000(AppVersionCompat r10) {
        return r10.context;
    }

    public long getManifestVersionCode() {
        if (this.manifestVersionCode != 0) goto L9;
        PackageInfo r10 = this.mPackageInfo.get(new Object[0]);
        if (r10 == null) goto L9;
        return r10.versionCode;
    L9:
        return this.manifestVersionCode;
    }

    public long getUpdateVersionCode() {
        if (this.updateVersionCode != 0) goto L9;
        PackageInfo r10 = this.mPackageInfo.get(new Object[0]);
        if (r10 == null) goto L9;
        return r10.versionCode;
    L9:
        return this.updateVersionCode;
    }

    public String getVersion() {
        if (TextUtils.isEmpty(this.version) == false) goto L9;
        PackageInfo r10 = this.mPackageInfo.get(new Object[0]);
        if (r10 == null) goto L9;
        return r10.versionName;
    L9:
        return this.version;
    }

    public long getVersionCode() {
        if (this.versionCode != 0) goto L9;
        PackageInfo r10 = this.mPackageInfo.get(new Object[0]);
        if (r10 == null) goto L9;
        return r10.versionCode;
    L9:
        return this.versionCode;
    }

    public String getVersionMinor() {
        return this.versionMinor;
    }
}
