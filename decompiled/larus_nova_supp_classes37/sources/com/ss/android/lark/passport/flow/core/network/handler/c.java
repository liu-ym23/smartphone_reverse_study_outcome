package com.ss.android.lark.passport.flow.core.network.handler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    static {
    }

    public static Integer a(e r1) {
        Intrinsics.checkNotNullParameter(r1, "handler");
        CodeHandlerAnno r2 = (CodeHandlerAnno) r1.getClass().getAnnotation(CodeHandlerAnno.class);
        if (r2 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r2.code());
    }
}
