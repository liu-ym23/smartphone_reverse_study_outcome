package com.obric.flow.cardlistpage.ui.component.feedlist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent", f = "FeedListComponent.kt", i = {0}, l = {805}, m = "refreshStepCounterWidgetIfNeeded", n = {"this"}, s = {"L$0"})
final class FeedListComponent$refreshStepCounterWidgetIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ s this$0;

    public FeedListComponent$refreshStepCounterWidgetIfNeeded$1(s r5, Continuation<? super FeedListComponent$refreshStepCounterWidgetIfNeeded$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return s.m(this.this$0, null, this);
    }
}
