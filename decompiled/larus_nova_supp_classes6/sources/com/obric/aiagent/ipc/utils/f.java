package com.obric.aiagent.ipc.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ g.b a;

    public /* synthetic */ f(g.b r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        g.b r0 = this.a;
        return Boolean.valueOf(Intrinsics.areEqual(((g.a) r2).a, r0));
    }
}
