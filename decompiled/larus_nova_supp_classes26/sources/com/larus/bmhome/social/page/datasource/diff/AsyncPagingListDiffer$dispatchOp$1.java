package com.larus.bmhome.social.page.datasource.diff;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer", f = "PagingListDiffer.kt", i = {0, 0}, l = {463}, m = "dispatchOp", n = {"op", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class AsyncPagingListDiffer$dispatchOp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncPagingListDiffer<Object> this$0;

    public AsyncPagingListDiffer$dispatchOp$1(AsyncPagingListDiffer<Object> r1, Continuation<? super AsyncPagingListDiffer$dispatchOp$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AsyncPagingListDiffer<Object> r3 = this.this$0;
        int r0 = AsyncPagingListDiffer.e;
        r3.l(null, this);
        throw null;
    }
}
