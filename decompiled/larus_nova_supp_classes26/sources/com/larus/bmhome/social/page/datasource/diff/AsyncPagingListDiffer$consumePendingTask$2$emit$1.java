package com.larus.bmhome.social.page.datasource.diff;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer$consumePendingTask$2", f = "PagingListDiffer.kt", i = {}, l = {282}, m = "emit", n = {}, s = {})
public final class AsyncPagingListDiffer$consumePendingTask$2$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncPagingListDiffer$consumePendingTask$2<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncPagingListDiffer$consumePendingTask$2$emit$1(AsyncPagingListDiffer$consumePendingTask$2<? super T> r1, Continuation<? super AsyncPagingListDiffer$consumePendingTask$2$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        this.this$0.a(null, (Continuation<? super Unit>) this);
        throw null;
    }
}
