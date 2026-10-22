package com.obric.flow.cardlistpage.ui.component.feedlist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent", f = "FeedListComponent.kt", i = {0, 0, 0}, l = {566}, m = "renderCards", n = {"this", "newCards", "shouldSuppressVisibilitySync"}, s = {"L$0", "L$1", "Z$0"})
final class FeedListComponent$renderCards$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ s this$0;

    public FeedListComponent$renderCards$1(s r5, Continuation<? super FeedListComponent$renderCards$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return s.n(null, this.this$0, this);
    }
}
