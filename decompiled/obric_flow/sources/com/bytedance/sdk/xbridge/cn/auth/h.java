package com.bytedance.sdk.xbridge.cn.auth;

import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import l9.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f7346a = null;

    static {
        f7346a = SetsKt.setOf(new String[]{"__prefetch", "downloadFile", "fetch", "downloadFileWithMetaData", "pda.awemeRequest", "request", "ttcjpay.request", "uploadFile"});
    }

    public static void a(cj.a r5, final bj.a r10) {
        Intrinsics.checkNotNullParameter(r5, "containerContext");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Lazy r11 = com.bytedance.ies.argus.repository.a.d;
        o.c().getClass();
        List r12 = CollectionsKt.emptyList();
        if (SetsKt.plus(f7346a, r12).contains(r10.f932a) == false) goto L13;
        rb.b r13 = (rb.b) r5.a(rb.b.class);
        if (r13 == null) goto L12;
        Function0<g> r14 = new SecurityContextUtils$registerSecurityContext$1(r10);
        Intrinsics.checkNotNullParameter(g.class, "clazz");
        Intrinsics.checkNotNullParameter(r14, "provider");
        ConcurrentHashMap r15 = r13.f21717a;
        rb.a r16 = (rb.a) r15.get(g.class);
        if (r16 == null) goto L10;
        r16.release();
    L10:
        r15.put(g.class, new rb.a(r14, 1));
        return;
    L12:
        return;
    }
}
