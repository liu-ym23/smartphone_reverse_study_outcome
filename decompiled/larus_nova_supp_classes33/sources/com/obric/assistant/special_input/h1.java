package com.obric.assistant.special_input;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h1 implements Function1 {
    public final /* synthetic */ SpecialInputTaskImpl a;
    public final /* synthetic */ Job b;

    public /* synthetic */ h1(SpecialInputTaskImpl r1, Job r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        SpecialInputTaskImpl r0 = this.a;
        Job r1 = this.b;
        Throwable r4 = (Throwable) r3;
        int r5 = SpecialInputTaskImpl.j;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r1, r0.d) == false) goto L7;
        r0.d = null;     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);
        return Unit.INSTANCE;
    }
}
