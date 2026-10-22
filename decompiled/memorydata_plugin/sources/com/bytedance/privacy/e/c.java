package com.bytedance.privacy.e;

import android.os.Build;
import android.util.Log;
import com.bytedance.privacy.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3015a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.privacy.a.d f3016b;

    static {
        f3015a = e.a();
    }

    private static String a(String r4) {
        if (c(r4) == false) goto L5;
        String r5 = "Unknown";
    L6:
        String r0 = "PrivacySDK-1.2.8-" + r5;
        if (Build.VERSION.SDK_INT < 26) goto L9;
    L24:
        return r0;
    L9:
        if (r0.length() <= 23) goto L24;
        String r1 = "PSDK-" + b(BuildConfig.PRIVACY_SDK_VERSION);
        if (r1.length() >= 23) goto L14;
        int r2 = (23 - r1.length()) - 1;
        if (r2 > 0) goto L19;
        return r1;
    L19:
        if (r5.length() <= r2) goto L23;
        r5 = r5.substring(r5.length() - r2);
    L23:
        return r1 + "-" + r5;
    L14:
        return r1.substring(0, 23);
    L5:
        r5 = r4.trim();
        goto L6
    }

    public static void a(com.bytedance.privacy.a.d r2) {
        f3016b = (com.bytedance.privacy.a.d) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.privacy.a.d.class, "com.obric.memorydata.plugin");
    }

    public static void a(String r1, String r2) {
        if (f3015a == false) goto L8;
        String r3 = a(r1);
        Log.d(r3, r2);
        com.bytedance.privacy.a.d r0 = f3016b;
        if (r0 == null) goto L9;
        r0.a(r3, r2);
        return;
    L9:
        return;
    }

    public static void a(String r0, String r1, Throwable r2) {
        String r3 = a(r0);
        Log.e(r3, r1, r2);
        com.bytedance.privacy.a.d r4 = f3016b;
        if (r4 == null) goto L6;
        r4.d(r3, r1);
        return;
    }

    private static String b(String r3) {
        if (c(r3) == false) goto L5;
        return "unknown";
    L5:
        String r4 = r3.trim().replace("-SNAPSHOT", "S").replaceAll("[^0-9A-Za-z.]", "");
        if (r4.isEmpty() == false) goto L9;
        return "unknown";
    L9:
        return r4;
    }

    public static void b(String r1, String r2) {
        String r3 = a(r1);
        Log.i(r3, r2);
        com.bytedance.privacy.a.d r0 = f3016b;
        if (r0 == null) goto L6;
        r0.b(r3, r2);
        return;
    }

    public static void c(String r1, String r2) {
        String r3 = a(r1);
        Log.w(r3, r2);
        com.bytedance.privacy.a.d r0 = f3016b;
        if (r0 == null) goto L6;
        r0.c(r3, r2);
        return;
    }

    private static boolean c(String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.trim().isEmpty() == true) goto L7;
        return false;
    }

    public static void d(String r1, String r2) {
        String r3 = a(r1);
        Log.e(r3, r2);
        com.bytedance.privacy.a.d r0 = f3016b;
        if (r0 == null) goto L6;
        r0.d(r3, r2);
        return;
    }
}
