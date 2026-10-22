package com.bytedance.ai.applet.permission;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Function1<Boolean, Unit> {
    public final /* synthetic */ i<Boolean> a;

    public d(j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        boolean r11 = ((Boolean) r10).booleanValue();
        if (this.a.isActive() == false) goto L6;
        Boolean r12 = Boolean.valueOf(r11);
        this.a.resumeWith(Result.constructor-impl(r12));
    L6:
        return Unit.INSTANCE;
    }
}
