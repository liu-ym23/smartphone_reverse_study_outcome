package com.bytedance.bdinstall;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class AppVersionCompat {
    private final Context context;
    private final Singleton<PackageInfo> mPackageInfo;
    private final long manifestVersionCode;
    private final long updateVersionCode;
    private final String version;
    private final long versionCode;
    private final String versionMinor;

    AppVersionCompat(Builder r3) {
        this.mPackageInfo = new AnonymousClass1(this);
        this.context = ZeusTransformUtils.wrapperContext(r3.context, "com.obric.memorydata.plugin");
        this.version = r3.version;
        if (TextUtils.isEmpty(r3.versionMinor) == false) goto L5;
        String r0 = "";
    L6:
        this.versionMinor = r0;
        this.versionCode = r3.versionCode;
        this.updateVersionCode = r3.updateVersionCode;
        this.manifestVersionCode = r3.manifestVersionCode;
        return;
    L5:
        r0 = r3.versionMinor;
        goto L6
    }

    static /* synthetic */ Context access$000(AppVersionCompat r0) {
        return r0.context;
    }

    public long getManifestVersionCode() {
        if (this.manifestVersionCode != 0) goto L9;
        PackageInfo r0 = (PackageInfo) ZeusTransformUtils.preCheckCast(this.mPackageInfo.get(new Object[0]), PackageInfo.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.manifestVersionCode;
    }

    public long getUpdateVersionCode() {
        if (this.updateVersionCode != 0) goto L9;
        PackageInfo r0 = (PackageInfo) ZeusTransformUtils.preCheckCast(this.mPackageInfo.get(new Object[0]), PackageInfo.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.updateVersionCode;
    }

    public String getVersion() {
        if (TextUtils.isEmpty(this.version) == false) goto L9;
        PackageInfo r0 = (PackageInfo) ZeusTransformUtils.preCheckCast(this.mPackageInfo.get(new Object[0]), PackageInfo.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        return r0.versionName;
    L9:
        return this.version;
    }

    public long getVersionCode() {
        if (this.versionCode != 0) goto L9;
        PackageInfo r0 = (PackageInfo) ZeusTransformUtils.preCheckCast(this.mPackageInfo.get(new Object[0]), PackageInfo.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        return r0.versionCode;
    L9:
        return this.versionCode;
    }

    public String getVersionMinor() {
        return this.versionMinor;
    }
}
