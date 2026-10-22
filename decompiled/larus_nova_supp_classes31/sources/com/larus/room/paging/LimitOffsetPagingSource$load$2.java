package com.larus.room.paging;

import com.larus.paging.PagingSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "Value", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larus/paging/PagingSource$b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.room.paging.LimitOffsetPagingSource$load$2", f = "LimitOffsetPagingSource.kt", i = {}, l = {76, 79}, m = "invokeSuspend", n = {}, s = {})
final class LimitOffsetPagingSource$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.b<Integer, Object>>, Object> {
    final /* synthetic */ PagingSource.a<Integer> $params;
    int label;
    final /* synthetic */ a<Object> this$0;

    public LimitOffsetPagingSource$load$2(a<Object> r1, PagingSource.a<Integer> r2, Continuation<? super LimitOffsetPagingSource$load$2> r3) {
        this.$params = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LimitOffsetPagingSource$load$2(null, this.$params, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super PagingSource.b<Integer, Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r4);
        throw null;
    L5:
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        return (PagingSource.b) r4;
    L7:
        if (r0 != 2) goto L9;
        ResultKt.throwOnFailure(r4);
        PagingSource.b r5 = (PagingSource.b) r4;
        throw null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
