package com.bytedance.ai.applet.douyinAuth;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Function3<String, String, String, Unit> {
    public final /* synthetic */ i<f> a;

    public b(j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10, Object r11, Object r12) {
        String r13 = (String) r10;
        String r14 = (String) r11;
        String r15 = (String) r12;
        if (this.a.isActive() == false) goto L6;
        this.a.resumeWith(Result.constructor-impl(new f(r13, r14, r15)));
    L6:
        return Unit.INSTANCE;
    }
}
