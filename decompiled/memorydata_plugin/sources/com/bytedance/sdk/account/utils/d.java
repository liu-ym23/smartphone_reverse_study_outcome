package com.bytedance.sdk.account.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static int a(Context r6, Throwable r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.sdk.account.d r0 = com.ss.android.account.d.a().c();
        if (r0 == null) goto L8;
        int r1 = r0.a(r8, r7);
        if (r1 >= 0) goto L8;
        return r1;
    L8:
        if (ZeusTransformUtils.instanceOf(r7, ConnectTimeoutException.class) == false) goto L11;
        int r9 = -13;
    L25:
        if (r8 == null) goto L32;
        if (r9 == (-15)) goto L29;
        if (r9 == (-14)) goto L29;
        return r9;
    L29:
        if (a(r8) == true) goto L34;
        return -12;
    L34:
        return r9;
    L32:
        return r9;
    L11:
        if (ZeusTransformUtils.instanceOf(r7, SocketTimeoutException.class) == false) goto L14;
        r9 = -14;
        goto L25
    L14:
        if (ZeusTransformUtils.instanceOf(r7, SocketException.class) == false) goto L18;
        StringBuilder r2 = new StringBuilder();
        String r4 = "api socket exception: ";
    L16:
        Logger.v("NetUtils", r2.append(r4).append(r7).toString());
        r9 = -15;
        goto L25
    L18:
        if (ZeusTransformUtils.instanceOf(r7, SSLPeerUnverifiedException.class) == false) goto L22;
        int r3 = -21;
        Logger.v("NetUtils", "api ssl exception: " + r7);
    L20:
        r9 = r3;
        goto L25
    L22:
        if (ZeusTransformUtils.instanceOf(r7, IOException.class) == false) goto L24;
        r2 = new StringBuilder();
        r4 = "api io exception: ";
        goto L16
    L24:
        r3 = -18;
        Logger.w("NetUtils", "api exception: " + r7);
        goto L20
    }

    public static boolean a(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L14;
        if (r4.isAvailable() == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
