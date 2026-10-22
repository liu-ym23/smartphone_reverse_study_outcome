package com.larus.canvas.service.internal.sse;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.service.internal.sse.CanvasChunkParser", f = "CanvasChunkParser.kt", i = {0, 0, 1, 1, 1}, l = {34, 62}, m = "parseStream", n = {"buffer", "onDataParsed", "buffer", "onDataParsed", "chunk"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class CanvasChunkParser$parseStream$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CanvasChunkParser this$0;

    public CanvasChunkParser$parseStream$1(CanvasChunkParser r1, Continuation<? super CanvasChunkParser$parseStream$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
