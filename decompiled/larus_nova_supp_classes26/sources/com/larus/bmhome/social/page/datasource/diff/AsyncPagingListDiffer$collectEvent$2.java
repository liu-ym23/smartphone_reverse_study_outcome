package com.larus.bmhome.social.page.datasource.diff;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer$collectEvent$2", f = "PagingListDiffer.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
public final class AsyncPagingListDiffer$collectEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AsyncPagingListDiffer<DATA> this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer$collectEvent$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer$collectEvent$2$1", f = "PagingListDiffer.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AsyncPagingListDiffer<DATA> this$0;

        public AnonymousClass1(AsyncPagingListDiffer<DATA> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            AsyncPagingListDiffer<DATA> r5 = this.this$0;
            this.label = 1;
            int r2 = AsyncPagingListDiffer.e;
            r5.getClass();
            Object r6 = kotlinx.coroutines.flow.e.l(null).collect(new AsyncPagingListDiffer$consumePendingTask$2(r5), this);
            if (r6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r6 = Unit.INSTANCE;
        L12:
            if (r6 != r0) goto L15;
            return r0;
        }
    }

    public AsyncPagingListDiffer$collectEvent$2(AsyncPagingListDiffer<DATA> r1, Continuation<? super AsyncPagingListDiffer$collectEvent$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AsyncPagingListDiffer$collectEvent$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        PagingListDiffer r6 = this.this$0;
        int r2 = AsyncPagingListDiffer.e;
        r6.getClass();
        AnonymousClass1 r7 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(null, r7, this) != r0) goto L12;
        return r0;
    }
}
