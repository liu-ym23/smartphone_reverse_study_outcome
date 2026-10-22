package com.larus.bmhome.social.page.datasource.diff;

import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer$executeOp$17", f = "PagingListDiffer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AsyncPagingListDiffer$executeOp$17 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $end;
    final /* synthetic */ List<Object> $payloads;
    final /* synthetic */ int $start;
    int label;
    final /* synthetic */ AsyncPagingListDiffer<Object> this$0;

    public AsyncPagingListDiffer$executeOp$17(List<Object> r1, AsyncPagingListDiffer<Object> r2, int r3, int r4, Continuation<? super AsyncPagingListDiffer$executeOp$17> r5) {
        this.$payloads = r1;
        this.this$0 = r2;
        this.$start = r3;
        this.$end = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AsyncPagingListDiffer$executeOp$17(this.$payloads, this.this$0, this.$start, this.$end, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        if (this.$payloads.isEmpty() == false) goto L7;
        List<Object> r5 = null;
    L8:
        ListUpdateCallback r0 = this.this$0.b;
        int r1 = this.$start;
        r0.onChanged(r1, this.$end - r1, r5);
        return Unit.INSTANCE;
    L7:
        r5 = this.$payloads;
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
