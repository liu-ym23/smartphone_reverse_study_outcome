package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt", f = "DoraAdapterExt.kt", i = {0, 0, 0}, l = {172}, m = "handleBindSuccessConnectResult", n = {"$this$handleBindSuccessConnectResult", "device", "userId"}, s = {"L$0", "L$1", "L$2"})
public final class DoraAdapterExtKt$handleBindSuccessConnectResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public DoraAdapterExtKt$handleBindSuccessConnectResult$1(Continuation<? super DoraAdapterExtKt$handleBindSuccessConnectResult$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraAdapterExtKt.q(null, null, null, this);
    }
}
