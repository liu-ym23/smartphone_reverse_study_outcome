package com.obric.assistant.live.gr.island.island.impl;

import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$1$1", f = "GRIslandImpl.kt", i = {0, 0, 1}, l = {WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS, 75}, m = "emit", n = {"it", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
public final class GRIslandImpl$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GRIslandImpl.AnonymousClass1.C00091<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public GRIslandImpl$1$1$emit$1(GRIslandImpl.AnonymousClass1.C00091<? super T> r1, Continuation<? super GRIslandImpl$1$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
