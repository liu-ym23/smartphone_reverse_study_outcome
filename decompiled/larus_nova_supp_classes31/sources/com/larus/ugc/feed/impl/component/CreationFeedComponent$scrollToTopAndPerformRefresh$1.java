package com.larus.ugc.feed.impl.component;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.component.CreationFeedComponent", f = "CreationFeedComponent.kt", i = {}, l = {1059, 1061}, m = "scrollToTopAndPerformRefresh", n = {}, s = {})
final class CreationFeedComponent$scrollToTopAndPerformRefresh$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$scrollToTopAndPerformRefresh$1(CreationFeedComponent r1, Continuation<? super CreationFeedComponent$scrollToTopAndPerformRefresh$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationFeedComponent.p3(this.this$0, null, this);
    }
}
