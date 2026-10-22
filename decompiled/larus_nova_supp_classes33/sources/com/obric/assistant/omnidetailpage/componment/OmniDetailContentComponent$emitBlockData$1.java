package com.obric.assistant.omnidetailpage.componment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent", f = "OmniDetailContentComponent.kt", i = {0, 0, 1}, l = {1532, 871}, m = "emitBlockData", n = {"items", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
final class OmniDetailContentComponent$emitBlockData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$emitBlockData$1(OmniDetailContentComponent r1, Continuation<? super OmniDetailContentComponent$emitBlockData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return OmniDetailContentComponent.m3(this.this$0, null, this);
    }
}
