package com.larus.canvas.core.impl.sse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasGetInfoCompensator", f = "CanvasGetInfoCompensator.kt", i = {0, 0}, l = {28}, m = "compensate", n = {"event", "snapshot"}, s = {"L$0", "L$1"})
public final class CanvasGetInfoCompensator$compensate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CanvasGetInfoCompensator this$0;

    public CanvasGetInfoCompensator$compensate$1(CanvasGetInfoCompensator r1, Continuation<? super CanvasGetInfoCompensator$compensate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
