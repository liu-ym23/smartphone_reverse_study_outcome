package com.bytedance.apm.util;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f1505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f1506b = -1;

    static {
    }

    private static int a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (f1506b != (-1)) goto L12;
        PackageManager r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        PackageInfo r5 = r0.getPackageInfo(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r5 == null) goto L12;
        f1506b = r5.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return f1506b;
    }

    public static long a(Context r13, long r14, long r16, int r18) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        long r3 = 0;
        if (a() == true) goto L5;
        return 0;
    L5:
        NetworkStatsManager r5 = (NetworkStatsManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("netstats"), NetworkStatsManager.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        return 0;
    L8:
        NetworkStats r1 = null;
        NetworkStats.Bucket r12 = new NetworkStats.Bucket();
        r1 = r5.querySummary(r18, null, r14, r16);     // Catch: Exception -> L11
    L10:
        long r6 = 0;
    L13:
        if (r1 == null) goto L19;
        if (r1.hasNextBucket() == false) goto L19;
        r1.getNextBucket(r12);
        if (a(r2) != r12.getUid()) goto L13;
        r3 = r3 + r12.getRxBytes();
        r6 = r6 + r12.getTxBytes();
    L19:
        if (r1 == null) goto L22;
        r1.close();
    L22:
        return r3 + r6;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT > 22) goto L5;
    L9:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.READ_PHONE_STATE") != 0) goto L9;
        return true;
    }
}
