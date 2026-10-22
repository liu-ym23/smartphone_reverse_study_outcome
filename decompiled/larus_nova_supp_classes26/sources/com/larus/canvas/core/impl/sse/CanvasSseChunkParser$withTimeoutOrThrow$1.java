package com.larus.canvas.core.impl.sse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasSseChunkParser", f = "CanvasSseChunkParser.kt", i = {0}, l = {53}, m = "withTimeoutOrThrow", n = {"buffer"}, s = {"L$0"})
public final class CanvasSseChunkParser$withTimeoutOrThrow$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CanvasSseChunkParser this$0;

    public CanvasSseChunkParser$withTimeoutOrThrow$1(CanvasSseChunkParser r1, Continuation<? super CanvasSseChunkParser$withTimeoutOrThrow$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        CanvasSseChunkParser r0 = this.this$0;
        int r8 = CanvasSseChunkParser.b;
        return r0.b(0, null, null, this);
    }
}
