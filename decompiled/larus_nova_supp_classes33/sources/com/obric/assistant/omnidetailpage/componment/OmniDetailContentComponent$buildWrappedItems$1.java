package com.obric.assistant.omnidetailpage.componment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent", f = "OmniDetailContentComponent.kt", i = {0, 0}, l = {926}, m = "buildWrappedItems", n = {"blocks", "taskFinished"}, s = {"L$0", "Z$0"})
final class OmniDetailContentComponent$buildWrappedItems$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$buildWrappedItems$1(OmniDetailContentComponent r1, Continuation<? super OmniDetailContentComponent$buildWrappedItems$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return OmniDetailContentComponent.h3(this.this$0, null, false, this);
    }
}
