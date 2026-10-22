package com.bytedance.apm.util;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f1158a = -1;

    static {
    }

    public static boolean a() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 > 22) goto L5;
    L9:
        return false;
    L5:
        if (r10 >= 28) goto L9;
        if (ContextCompat.checkSelfPermission(com.bytedance.apm.d.g(), "android.permission.READ_PHONE_STATE") != 0) goto L9;
        return true;
    }

    private static int b(@NonNull Context r10) {
        if (f1158a != (-1)) goto L12;
        PackageManager r11 = r10.getApplicationContext().getPackageManager();
        PackageInfo r12 = r11.getPackageInfo(r10.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r12 == null) goto L12;
        f1158a = r12.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return f1158a;
    }

    public static long c(@NonNull Context r12, long r13, long r15, int r17) {
        long r10 = 0;
        if (a() == true) goto L5;
        return 0;
    L5:
        NetworkStatsManager r11 = (NetworkStatsManager) r12.getApplicationContext().getSystemService("netstats");
        if (r11 != null) goto L8;
        return 0;
    L8:
        NetworkStats r14 = null;
        NetworkStats.Bucket r16 = new NetworkStats.Bucket();
        r14 = r11.querySummary(r17, null, r13, r15);     // Catch: Exception -> L11
    L10:
        long r18 = 0;
    L13:
        if (r14 == null) goto L19;
        if (r14.hasNextBucket() == false) goto L19;
        r14.getNextBucket(r16);
        if (b(r12) != r16.getUid()) goto L13;
        r10 = r10 + r16.getRxBytes();
        r18 = r18 + r16.getTxBytes();
    L19:
        if (r14 == null) goto L22;
        r14.close();
    L22:
        return r10 + r18;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
