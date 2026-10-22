package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.livesdk.config.ge;
import com.bytedance.android.livesdk.model.s0;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Interceptor {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    public final SsResponse<?> intercept(Interceptor.Chain r13) {
        Intrinsics.checkNotNullParameter(r13, "chain");
        Request r0 = r13.request();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(r13.proceed(r0));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r2) == true) goto L65;
        int r3 = com.bytedance.android.live.network.impl.utils.c.a(Result.exceptionOrNull-impl(r2));
        int r4 = com.bytedance.android.live.network.impl.utils.b.c;
        com.bytedance.android.live.network.impl.utils.b.a.a("error_code is " + r3);
        Integer r5 = Integer.valueOf(r3);
        String r6 = r0.getPath();
        ge r7 = ge.a;
        boolean r8 = false;
        String r9 = null;
        if (((com.bytedance.android.livesdk.model.i) r7.getValue()).a() == false) goto L43;
        if (r5 == null) goto L43;
        if (r6 != null) goto L16;
    L19:
        boolean r10 = true;
    L20:
        if (r10 == true) goto L43;
        List r11 = CollectionsKt.emptyList();
        ArrayList r12 = ((com.bytedance.android.livesdk.model.i) r7.getValue()).c();
        if (r12 == null) goto L38;
        Iterator r14 = r12.iterator();
    L26:
        if (r14.hasNext() == false) goto L38;
        s0 r15 = (s0) r14.next();
        if (Intrinsics.areEqual(r15.a(), r6) == false) goto L26;
        List r16 = r15.b();
        if (r16 != null) goto L32;
    L37:
        boolean r17 = true;
    L39:
        if (r17 == false) goto L43;
        if (r11.contains(r5) == false) goto L43;
        r8 = true;
        goto L43
    L32:
        if ((!r16.isEmpty()) == true) goto L35;
        r16 = null;
    L35:
        if (r16 == null) goto L37;
        r11 = r16;
    L38:
        r17 = false;
        goto L39
    L16:
        if (r6.length() == 0) goto L19;
        r10 = false;
    L43:
        if (r8 == false) goto L63;
        Iterator r18 = r0.getHeaders().iterator();
    L46:
        if (r18.hasNext() == false) goto L50;
        Object r19 = r18.next();
        if (Intrinsics.areEqual("x-retry-type", ((Header) r19).getName()) == false) goto L46;
    L51:
        Header r20 = (Header) r19;
        if (r20 == null) goto L54;
        r9 = r20.getValue();
    L54:
        if (r9 != null) goto L63;
        int r21 = com.bytedance.android.live.network.impl.utils.b.c;
        com.bytedance.android.live.network.impl.utils.b.a.a(r0.getPath() + " auto retry. error_code is " + r3);
        ArrayList r22 = new ArrayList(r0.getHeaders());
        Header r23 = new Header("x-retry-type", "1");
        Iterator r24 = r22.iterator();
    L57:
        if (r24.hasNext() == false) goto L61;
        if (Intrinsics.areEqual(((Header) r24.next()).getName(), r23.getName()) == false) goto L57;
        r24.remove();
        goto L57
    L61:
        r22.add(r23);
        return r13.proceed(r0.newBuilder().headers(r22).build());
    L50:
        r19 = null;
    L63:
        ResultKt.throwOnFailure(r2);
        return (SsResponse) r2;
    L65:
        ResultKt.throwOnFailure(r2);
        return (SsResponse) r2;
    L5:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
