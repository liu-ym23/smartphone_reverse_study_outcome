package com.obric.assistant.state.impl.multitask.consumer;

import aha.l;
import aha.t;
import java.util.Map;
import jha.o;
import jha.q;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ o a;

    public /* synthetic */ c(o r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        o r0 = this.a;
        Map.Entry r5 = (Map.Entry) r4;
        int r1 = InteractionProjectionServiceImpl.f;
        Intrinsics.checkNotNullParameter(r5, "<destruct>");
        S r6 = ((q) r5.getValue()).a().b;
        String r2 = null;
        if ((r6 instanceof t) == false) goto L5;
        t r7 = (t) r6;
    L6:
        if (r7 == null) goto L9;
        r2 = r7.c();
    L9:
        return Boolean.valueOf(Intrinsics.areEqual(r2, ((l.b) r0).j));
    L5:
        r7 = null;
        goto L6
    }
}
