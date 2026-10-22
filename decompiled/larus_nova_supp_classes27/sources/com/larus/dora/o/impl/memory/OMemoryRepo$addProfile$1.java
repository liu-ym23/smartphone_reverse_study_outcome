package com.larus.dora.o.impl.memory;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.memory.OMemoryRepo", f = "OMemoryRepo.kt", i = {}, l = {72}, m = "addProfile", n = {}, s = {})
public final class OMemoryRepo$addProfile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OMemoryRepo this$0;

    public OMemoryRepo$addProfile$1(OMemoryRepo r1, Continuation<? super OMemoryRepo$addProfile$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, null, this);
    }
}
