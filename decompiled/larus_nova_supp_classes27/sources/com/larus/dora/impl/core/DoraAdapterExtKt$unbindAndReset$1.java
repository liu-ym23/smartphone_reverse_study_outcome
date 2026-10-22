package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt", f = "DoraAdapterExt.kt", i = {0, 0, 1, 1, 2}, l = {283, 289, 292}, m = "unbindAndReset", n = {"$this$unbindAndReset", "device", "$this$unbindAndReset", "device", "device"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
public final class DoraAdapterExtKt$unbindAndReset$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public DoraAdapterExtKt$unbindAndReset$1(Continuation<? super DoraAdapterExtKt$unbindAndReset$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraAdapterExtKt.Q(null, null, this);
    }
}
