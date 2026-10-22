package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt", f = "DoraAdapterExt.kt", i = {0, 0, 1, 1}, l = {264, 265}, m = "onlyLocalUnbindAndReset", n = {"$this$onlyLocalUnbindAndReset", "device", "device", "unbindBudsResult"}, s = {"L$0", "L$1", "L$0", "Z$0"})
public final class DoraAdapterExtKt$onlyLocalUnbindAndReset$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public DoraAdapterExtKt$onlyLocalUnbindAndReset$1(Continuation<? super DoraAdapterExtKt$onlyLocalUnbindAndReset$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraAdapterExtKt.B(null, null, this);
    }
}
