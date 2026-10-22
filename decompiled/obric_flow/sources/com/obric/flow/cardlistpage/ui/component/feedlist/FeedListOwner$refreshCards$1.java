package com.obric.flow.cardlistpage.ui.component.feedlist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListOwner", f = "FeedListOwner.kt", i = {}, l = {36, 38}, m = "refreshCards", n = {}, s = {})
final class FeedListOwner$refreshCards$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u this$0;

    public FeedListOwner$refreshCards$1(u r5, Continuation<? super FeedListOwner$refreshCards$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(false, null, this);
    }
}
