package com.obric.flow.cardlistpage.ui.component.feedlist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListOwner", f = "FeedListOwner.kt", i = {0, 0}, l = {47}, m = "updateCard", n = {"currentCards", "card"}, s = {"L$0", "L$1"})
final class FeedListOwner$updateCard$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u this$0;

    public FeedListOwner$updateCard$1(u r5, Continuation<? super FeedListOwner$updateCard$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, this);
    }
}
