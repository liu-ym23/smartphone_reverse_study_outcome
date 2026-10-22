package com.obric.assistant.omnidetailpage.componment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent", f = "OmniDetailContentComponent.kt", i = {0, 1}, l = {1532, 864}, m = "emitHeaderUpdate", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class OmniDetailContentComponent$emitHeaderUpdate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$emitHeaderUpdate$1(OmniDetailContentComponent r1, Continuation<? super OmniDetailContentComponent$emitHeaderUpdate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        OmniDetailContentComponent r3 = this.this$0;
        int r0 = OmniDetailContentComponent.I;
        return r3.H3(this);
    }
}
