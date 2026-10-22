package com.larus.bmhome.social.page.datasource.diff;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AsyncPagingListDiffer$consumePendingTask$2<T> implements FlowCollector {
    public final /* synthetic */ AsyncPagingListDiffer<Object> a;

    public AsyncPagingListDiffer$consumePendingTask$2(AsyncPagingListDiffer<Object> r1) {
        this.a = r1;
    }

    public final Object a(Unit r4, Continuation<? super Unit> r5) {
        if ((r5 instanceof AsyncPagingListDiffer$consumePendingTask$2$emit$1) == false) goto L7;
        AsyncPagingListDiffer$consumePendingTask$2$emit$1 r6 = (AsyncPagingListDiffer$consumePendingTask$2$emit$1) r5;
        int r0 = r6.label;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r0 - Integer.MIN_VALUE;
    L8:
        Object r7 = r6.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r6.label;
        if (r8 != 0) goto L11;
    L14:
        ResultKt.throwOnFailure(r7);
        this.a.getClass();
        throw null;
    L11:
        if (r8 == 1) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r6 = new AsyncPagingListDiffer$consumePendingTask$2$emit$1(this, r5);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
        a((Unit) r1, r2);
        throw null;
    }
}
