package com.obric.assistant.network.impl;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m implements Interceptor {
    public volatile String a;

    public static final class a {
    }

    static {
    }

    public m() {
    }

    public final SsResponse<?> intercept(Interceptor.Chain r7) {
        Intrinsics.checkNotNullParameter(r7, "chain");
        SsResponse<?> r8 = r7.proceed(r7.request());
        String r0 = null;
        if (r8 == null) goto L26;
        List r1 = r8.headers();
        if (r1 == null) goto L26;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if ((r4 instanceof Header) == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        Iterator r5 = r2.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        if (StringsKt.equals(((Header) r6).getName(), "x-tt-logid", true) == false) goto L14;
    L19:
        Header r9 = (Header) r6;
        if (r9 == null) goto L26;
        String r10 = r9.getValue();
        if (r10 == null) goto L26;
        if (Boolean.valueOf(!StringsKt.isBlank(r10)).booleanValue() == false) goto L26;
        r0 = r10;
        goto L26
    L18:
        r6 = null;
    L26:
        this.a = r0;
        return r8;
    }
}
