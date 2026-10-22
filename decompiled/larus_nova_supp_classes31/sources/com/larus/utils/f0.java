package com.larus.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (NetworkUtils.isNetworkAvailable(r6) == true) goto L6;
        FLogger.a.i("NetworkUtilsExt", "isNetworkAvailableAndValid false, NetworkUtils unavailable");
        return false;
    L6:
        boolean r5 = true;
        if (Build.VERSION.SDK_INT >= 23) goto L41;
        FLogger.a.i("NetworkUtilsExt", "isNetworkAvailableAndValid true, skip validated capability below M");
        return true;
    L41:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L33
        Object r7 = r6.getSystemService("connectivity");     // Catch: Throwable -> L33
        if ((r7 instanceof ConnectivityManager) == false) goto L13;
        ConnectivityManager r8 = (ConnectivityManager) r7;     // Catch: Throwable -> L33
    L14:
        if (r8 != null) goto L16;
        return false;
    L16:
        NetworkInfo r2 = r8.getActiveNetworkInfo();     // Catch: Throwable -> L33
        if (r2 != null) goto L19;
    L21:
        r5 = false;
    L22:
        if (r5 == true) goto L25;
        FLogger.a.i("NetworkUtilsExt", "isNetworkAvailableAndValid false, activeNetworkInfo not connected");     // Catch: Throwable -> L33
        return false;
    L25:
        Network r3 = r8.getActiveNetwork();     // Catch: Throwable -> L33
        if (r3 != null) goto L28;
        return false;
    L28:
        NetworkCapabilities r9 = r8.getNetworkCapabilities(r3);     // Catch: Throwable -> L33
        if (r9 != null) goto L31;
        return false;
    L31:
        boolean r10 = r9.hasCapability(16);     // Catch: Throwable -> L33
        FLogger.a.i("NetworkUtilsExt", "isNetworkAvailableAndValid valid:" + r10);     // Catch: Throwable -> L33
        Object r11 = Result.constructor-impl(Boolean.valueOf(r10));     // Catch: Throwable -> L33
    L35:
        Throwable r0 = Result.exceptionOrNull-impl(r11);
        if (r0 == null) goto L40;
        FLogger.a.e("NetworkUtilsExt", "isNetworkAvailableAndValid error", r0);
        r11 = Boolean.FALSE;
    L40:
        return ((Boolean) r11).booleanValue();
    L19:
        if (r2.isConnected() != true) goto L21;
    L13:
        r8 = null;
    L33:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }
}
