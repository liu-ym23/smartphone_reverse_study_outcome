package com.larus.video.impl.douyin;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.douyin.DouYinVideoActivity$tryLoadMoreItemIdList$1", f = "DouYinVideoActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DouYinVideoActivity$tryLoadMoreItemIdList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ pr9.c $callback;
    int label;
    final /* synthetic */ DouYinVideoActivity this$0;

    public DouYinVideoActivity$tryLoadMoreItemIdList$1(DouYinVideoActivity r1, pr9.c r2, Continuation<? super DouYinVideoActivity$tryLoadMoreItemIdList$1> r3) {
        this.this$0 = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DouYinVideoActivity$tryLoadMoreItemIdList$1(this.this$0, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        FLogger r6 = FLogger.a;
        StringBuilder r0 = new StringBuilder("custom load more, recommendType = ");
        DouYinVideoActivity r1 = this.this$0;
        int r2 = DouYinVideoActivity.p;
        r0.append(r1.A1().M);
        r6.i("DouYinVideoActivity", r0.toString());
        if (this.this$0.A1().x == false) goto L9;
        DouYinVideoActivity r7 = this.this$0;
        DouYinActivityVideoModel r3 = r7.a;
        if (r3 == null) goto L11;
        DouYinVideoDataManager r8 = r7.A1();
        final DouYinVideoActivity r4 = this.this$0;
        final pr9.c r9 = this.$callback;
        r3.requestLoadMore(r8, new k(r4, r9), new l(r9));
    L11:
        return Unit.INSTANCE;
    L9:
        r6.i("DouYinVideoActivity", "disable load more, return empty list");
        this.$callback.a(false, CollectionsKt.emptyList());
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
