package com.bytedance.sdk.xbridge.cn.auth;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthMode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import li.n;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements aj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7338b;

    public c(j r5) {
        this.f7337a = 1;
        Intrinsics.checkNotNullParameter(r5, "authVerifier");
        this.f7338b = r5;
    }

    @Override // aj.a
    public final li.c a(bj.a r10, IDLXBridgeMethod r11) {
        Object r5 = this.f7338b;
        switch(this.f7337a) {
            case 0: goto L31;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "method");
        if (r10.c() != PlatformType.f7288b) goto L30;
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "method");
        li.e r12 = new li.e(r11.getName(), com.bytedance.apm.util.a.b(r11.getAccess().f7466a), r10.a());     // Catch: Exception -> L10
        r12.d = r10.d();     // Catch: Exception -> L10
        AuthConfigType r13 = AuthConfigType.f7305b;     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r13, "<set-?>");     // Catch: Exception -> L10
        r12.e = r13;     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r10.f942o, "<set-?>");     // Catch: Exception -> L10
        n r14 = pi.a.f21355b;     // Catch: Exception -> L10
        if (r14 != null) goto L12;
        r14 = pi.a.f21354a;     // Catch: Exception -> L10
    L12:
        boolean r15 = r14.f19675a;     // Catch: Exception -> L10
        i r16 = ((j) r5).f7350a;
        if (r15 == false) goto L16;
        ki.a.a("WebAuthVerifierWrapper.doAuth: use V3");     // Catch: Exception -> L10
        li.c r17 = r16.c(String.valueOf(r10.f944q), r12, r10.d);     // Catch: Exception -> L10
    L27:
        if (r17.f19640a == true) goto L41;
        r10.f938k = -1;
        String r18 = "not authorized by WebAuthenticator, reason: ".concat(r17.a());
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r10.f939l = r18;
        return r17;
    L41:
        return r17;
    L16:
        Integer r19 = r10.f944q;     // Catch: Exception -> L10
        String r20 = r10.d;     // Catch: Exception -> L10
        r16.getClass();     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r20, "namespace");     // Catch: Exception -> L10
        if (r19 != null) goto L19;
    L23:
        ki.a.a("WebAuthVerifierWrapper.doAuth: use V1");     // Catch: Exception -> L10
        r17 = j.a(r10, r11);     // Catch: Exception -> L10
        r17.f19647l = AuthMode.f7318c;     // Catch: Exception -> L10
        r17.f19645j = "-1";     // Catch: Exception -> L10
        ConcurrentHashMap r21 = e.f7342a;     // Catch: Exception -> L10
        r17.f = e.a(r10.d);     // Catch: Exception -> L10
        goto L27
    L19:
        if (r19.intValue() == (-1)) goto L23;
        String r22 = String.valueOf(r10.f944q);     // Catch: Exception -> L10
        ConcurrentHashMap r23 = e.f7342a;     // Catch: Exception -> L10
        if (e.c(r22, r10.d) == null) goto L23;
        ki.a.a("WebAuthVerifierWrapper.doAuth: use V2");     // Catch: Exception -> L10
        r17 = r16.a(r22, r12, r10.d);     // Catch: Exception -> L10
        r17.f19647l = AuthMode.f7317b;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ki.a.a("WebAuthVerifierWrapper.doAuth error: " + e.getMessage());
        e.printStackTrace();
        r17 = new li.c(true, androidx.room.jarjarred.org.antlr.runtime.a.o(e, new StringBuilder("unexpected error: ")), null, AuthSuccessCode.f7322i, 42);
        goto L27
    L30:
        return new li.c(true, null, null, null, 62);
    L31:
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r11, "method");
        if (r10.c() != PlatformType.f7288b) goto L39;
        Iterator r24 = ((ArrayList) r5).iterator();
        if (r24.hasNext() == false) goto L39;
        throw mn.h.c(r24);
    L39:
        return new li.c(true, null, null, null, 62);
    }

    public c(rb.b r5, ArrayList r10) {
        this.f7337a = 0;
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.f7338b = r10;
    }
}
