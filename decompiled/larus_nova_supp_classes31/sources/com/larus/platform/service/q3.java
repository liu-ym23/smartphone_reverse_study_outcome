package com.larus.platform.service;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.z3;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q3 {
    public static final Lazy a = null;

    public q3() {
    }

    static {
        a = LazyKt.lazy(new p3());
    }

    public static z3 a() {
        return (z3) a.getValue();
    }

    public static IVideoController b(String r1, Integer r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 4) == 0) goto L8;
        r2 = null;
    L8:
        Intrinsics.checkNotNullParameter(r1, "tag");
        z3 r4 = a();
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.m(r1, false, r2);
    }
}
