package com.ss.android.deviceregister.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class g implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.ss.android.deviceregister.d.f<Boolean> f15135a = null;

    static {
        f15135a = new AnonymousClass1();
    }

    g() {
    }

    static boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(f15135a.c(new Object[]{r5}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static int d(Context r2) {
        PackageInfo r3 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo("com.huawei.hwid", 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r3 == null) goto L12;
        return r3.versionCode;
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    private static Pair<String, Boolean> e(Context r4) {
        return (Pair) ZeusTransformUtils.preCheckCast(new w((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new AnonymousClass2()).a(), Pair.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.deviceregister.a.n
    public boolean b(Context r2) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ss.android.deviceregister.a.n
    public n.a c(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        n.a r6 = new n.a();
        if (Build.VERSION.SDK_INT >= 24) goto L14;
    L10:
        Pair<String, Boolean> r1 = e(r4);
        if (r1 == null) goto L13;
        r6.f15141a = (String) ZeusTransformUtils.preCheckCast(r1.first, String.class, "com.obric.memorydata.plugin");
        r6.f15142b = ((Boolean) ZeusTransformUtils.preCheckCast(r1.second, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        r6.c = d(r4);
    L13:
        return r6;
    L14:
        String r2 = Settings.Global.getString(r4.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L8
        String r3 = Settings.Global.getString(r4.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r6.f15141a = r2;     // Catch: Throwable -> L8
        r6.f15142b = Boolean.parseBoolean(r3);     // Catch: Throwable -> L8
        r6.c = 202003021704L;     // Catch: Throwable -> L8
        return r6;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }
}
