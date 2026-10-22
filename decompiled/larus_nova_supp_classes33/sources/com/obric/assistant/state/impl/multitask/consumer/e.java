package com.obric.assistant.state.impl.multitask.consumer;

import aha.l;
import java.util.Map;
import jha.o;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ o a;

    public /* synthetic */ e(o r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        o r0 = this.a;
        Map.Entry r4 = (Map.Entry) r3;
        int r1 = InteractionProjectionServiceImpl.f;
        Intrinsics.checkNotNullParameter(r4, "<destruct>");
        return Boolean.valueOf(Intrinsics.areEqual(((InteractionProjectionServiceImpl$c) r4.getValue()).b, ((l.b) r0).j));
    }
}
