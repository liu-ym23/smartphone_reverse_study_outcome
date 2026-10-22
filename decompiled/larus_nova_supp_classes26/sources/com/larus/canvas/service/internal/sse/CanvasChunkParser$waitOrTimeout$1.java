package com.larus.canvas.service.internal.sse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.sse.CanvasChunkParser", f = "CanvasChunkParser.kt", i = {0}, l = {134, 138}, m = "waitOrTimeout", n = {"onError"}, s = {"L$0"})
final class CanvasChunkParser$waitOrTimeout$1<R> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CanvasChunkParser this$0;

    public CanvasChunkParser$waitOrTimeout$1(CanvasChunkParser r1, Continuation<? super CanvasChunkParser$waitOrTimeout$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        CanvasChunkParser r0 = this.this$0;
        CanvasChunkParser r8 = CanvasChunkParser.a;
        return r0.c(0, null, null, this);
    }
}
