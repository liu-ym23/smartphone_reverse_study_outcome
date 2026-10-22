package com.obric.assistant.state.impl.multitask.consumer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ zga.c a;

    public /* synthetic */ a(zga.c r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        zga.c r0 = this.a;
        int r1 = InteractionProjectionServiceImpl.f;
        return Boolean.valueOf(Intrinsics.areEqual(((InteractionProjectionServiceImpl.b) r3).b, r0));
    }
}
