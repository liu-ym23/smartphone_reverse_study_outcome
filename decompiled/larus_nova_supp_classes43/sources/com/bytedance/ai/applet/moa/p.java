package com.bytedance.ai.applet.moa;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    public static Object a(u2.f r10, Class r11) {
        String r0 = r10.e();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L24;
        return null;
    L24:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L14
        Object r13 = Result.constructor-impl(com.bytedance.ai.applet.base.gson.e.a(r0, r11));     // Catch: Throwable -> L14
    L16:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L20;
        com.bytedance.ai.utils.g.a.e("MoaGrantingStepFactory", "Failed to parse " + r10.b() + " relatedData", r14);
    L20:
        if (Result.isFailure-impl(r13) == false) goto L23;
        return null;
    L23:
        return r13;
    L14:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
