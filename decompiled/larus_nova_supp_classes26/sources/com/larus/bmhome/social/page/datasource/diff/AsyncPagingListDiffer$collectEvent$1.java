package com.larus.bmhome.social.page.datasource.diff;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer", f = "PagingListDiffer.kt", i = {0}, l = {289, 294}, m = "collectEvent", n = {"event"}, s = {"L$0"})
public final class AsyncPagingListDiffer$collectEvent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncPagingListDiffer<DATA> this$0;

    public AsyncPagingListDiffer$collectEvent$1(AsyncPagingListDiffer<DATA> r1, Continuation<? super AsyncPagingListDiffer$collectEvent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, (Continuation<? super Unit>) this);
    }
}
