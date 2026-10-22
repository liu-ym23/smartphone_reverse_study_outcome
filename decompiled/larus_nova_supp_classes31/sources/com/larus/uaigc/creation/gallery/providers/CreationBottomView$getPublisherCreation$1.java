package com.larus.uaigc.creation.gallery.providers;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView", f = "CreationBottomView.kt", i = {}, l = {554}, m = "getPublisherCreation", n = {}, s = {})
public final class CreationBottomView$getPublisherCreation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationBottomView this$0;

    public CreationBottomView$getPublisherCreation$1(CreationBottomView r1, Continuation<? super CreationBottomView$getPublisherCreation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        CreationBottomView r3 = this.this$0;
        int r0 = CreationBottomView.i;
        return r3.Z5(this);
    }
}
