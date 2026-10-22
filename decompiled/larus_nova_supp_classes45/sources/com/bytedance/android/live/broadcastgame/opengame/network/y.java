package com.bytedance.android.live.broadcastgame.opengame.network;

import android.net.Uri;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements Interceptor {
    public y() {
    }

    public final SsResponse<?> intercept(Interceptor.Chain r13) {
        Intrinsics.checkNotNullParameter(r13, "chain");
        Request r0 = r13.request();
        long r1 = System.currentTimeMillis();
        String r3 = r0.getUrl();
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        Uri r5 = UriProtector.parse(r3);
        String r6 = r5.buildUpon().clearQuery().toString();
        String r7 = r0.getMethod();
        if (r7 == null) goto L22;
        String r8 = r7.toUpperCase();
        int r9 = r8.hashCode();
        if (r9 == 70454) goto L14;
        if (r9 != 2461856) goto L23;
        r8.equals("POST");
    L23:
        SsResponse<?> r14 = r13.proceed(r0);     // Catch: Exception -> L18
        String r11 = r4;
        k10.a.a(r6, "0", "", r11, System.currentTimeMillis() - r1);     // Catch: Exception -> L18
        return r14;
    L18:
        e = move-exception;
        long r12 = System.currentTimeMillis() - r1;
        int r2 = k10.a.a;
        k10.a.a(r6, "-1", e.getMessage(), r4, r12);
        throw e;
    L14:
        if (r8.equals("GET") == false) goto L23;
        r4 = UriProtector.getQueryParameter(r5, OpenPlatformBaseDebugger.APP_ID);
        goto L23
    L22:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
