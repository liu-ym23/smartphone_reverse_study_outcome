package com.obric.aikernel.utils;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Binder;
import android.telephony.TelephonyManager;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class AppUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppUtils f5573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f5574b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f5575c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f5576d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lazy f5577e = null;

    static {
        f5573a = new AppUtils();
        f5574b = LazyKt.lazy(AppUtils$activityManager$2.INSTANCE);
        f5575c = LazyKt.lazy(AppUtils$packageManager$2.INSTANCE);
        f5576d = LazyKt.lazy(AppUtils$connectivityManager$2.INSTANCE);
        f5577e = LazyKt.lazy(AppUtils$notificationManager$2.INSTANCE);
    }

    private AppUtils() {
    }

    public final ConnectivityManager a() {
        return (ConnectivityManager) f5576d.getValue();
    }

    @SuppressLint({"MissingPermission"})
    public final String b() {
        Network r10 = a().getActiveNetwork();     // Catch: RuntimeException -> L25
        if (r10 != null) goto L7;
        return "No Internet Connection";
    L7:
        NetworkCapabilities r11 = a().getNetworkCapabilities(r10);     // Catch: RuntimeException -> L25
        if (r11 != null) goto L11;
        return "Unknown";
    L11:
        if (r11.hasTransport(1) == false) goto L14;
        return "Wi-Fi";
    L14:
        if (r11.hasTransport(0) == false) goto L23;
        Object r12 = AppContext.INSTANCE.getContext().getSystemService("phone");     // Catch: RuntimeException -> L25
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: RuntimeException -> L25
        int r13 = ((TelephonyManager) r12).getDataNetworkType();     // Catch: RuntimeException -> L25
        if (r13 == 20) goto L35;
        switch(r13) {
            case 1: goto L34;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L33;
            case 7: goto L34;
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L33;
            case 15: goto L33;
            default: goto L31;
        };     // Catch: RuntimeException -> L25
    L31:
        return "Unknown";
    L32:
        return "4G";
    L33:
        return "3G";
    L34:
        return "2G";
    L35:
        return "5G";
    L23:
        return "Not Connected";
    L25:
        e = move-exception;
        AIKLog.INSTANCE.e("AppUtils", "getNetworkType error: " + e);
        return "Unknown";
    }

    public final PackageManager c() {
        return (PackageManager) f5575c.getValue();
    }

    public final String d(int r10) {
        String[] r11 = c().getPackagesForUid(r10);
        if (r11 != null) goto L6;
        r11 = new String[0];
    L6:
        if (r11.length <= 1) goto L8;
        AIKLog.INSTANCE.w("AppUtils", "uid " + Binder.getCallingUid() + " has multi packages: " + r11);
    L8:
        String r12 = (String) ArraysKt.firstOrNull(r11);
        if (r12 != null) goto L12;
        r12 = "";
    L12:
        if (AppContext.INSTANCE.isDebug() == false) goto L14;
        AIKLog.INSTANCE.d("AppUtils", "query packageName = " + r12);
    L14:
        return r12;
    }

    public final boolean e() {
        AppContext r10 = AppContext.INSTANCE;
        if (Intrinsics.areEqual(r10.getContext().getPackageName(), IAIKernelManager.PACKAGE_NAME_AIK) == true) goto L6;
        AIKLog.INSTANCE.d("AppUtils", "package " + r10.getContext().getPackageName() + " is not expected");
        return false;
    L6:
        return true;
    }
}
