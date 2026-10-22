package com.obric.assistant.authenticationsession;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ QueryAuthenticationServiceImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Job c;

    public /* synthetic */ f(QueryAuthenticationServiceImpl r1, String r2, Job r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r4) {
        QueryAuthenticationServiceImpl r0 = this.a;
        String r1 = this.b;
        Job r2 = this.c;
        Throwable r5 = (Throwable) r4;
        if (Intrinsics.areEqual(r0.e.get(r1), r2) == false) goto L6;
        r0.e.remove(r1);
    L6:
        return Unit.INSTANCE;
    }
}
