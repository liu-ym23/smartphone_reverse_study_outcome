package com.larus.canvas.core.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.CanvasSSEService$start$1$2", f = "CanvasSSEService.kt", i = {}, l = {90, 92, 95}, m = "emit", n = {}, s = {})
public final class CanvasSSEService$start$1$2$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CanvasSSEService$start$1.AnonymousClass2<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasSSEService$start$1$2$emit$1(CanvasSSEService$start$1.AnonymousClass2<? super T> r1, Continuation<? super CanvasSSEService$start$1$2$emit$1> r2) {
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
