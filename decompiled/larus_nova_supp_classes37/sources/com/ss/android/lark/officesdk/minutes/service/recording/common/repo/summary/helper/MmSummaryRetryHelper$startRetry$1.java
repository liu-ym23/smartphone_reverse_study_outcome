package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.helper;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lvb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.helper.MmSummaryRetryHelper$startRetry$1", f = "MmSummaryRetryHelper.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_AI_KNOWLEDGE, ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CHAT}, m = "invokeSuspend", n = {}, s = {})
public final class MmSummaryRetryHelper$startRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $currentCount;
    int label;
    final /* synthetic */ MmSummaryRetryHelper this$0;

    public MmSummaryRetryHelper$startRetry$1(int r1, MmSummaryRetryHelper r2, Continuation<? super MmSummaryRetryHelper$startRetry$1> r3) {
        this.$currentCount = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmSummaryRetryHelper$startRetry$1(this.$currentCount, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L21:
        this.this$0.d.incrementAndGet();
        Function1<Continuation<? super Unit>, Object> r8 = this.this$0.b;
        this.label = 2;
        if (r8.invoke(this) != r0) goto L25;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        List<Long> r9 = MmSummaryRetryHelper.e;
        int r2 = this.$currentCount;
        boolean r4 = false;
        if (r2 >= 0) goto L13;
    L15:
        if (r4 == false) goto L17;
        Object r10 = ListProtector.get(r9, r2);
    L18:
        long r5 = ((Number) r10).longValue();
        a.e("MmSummaryRetryHelper", "startRetry, delay: " + r5 + " ms, retryCount: " + this.$currentCount);
        this.label = 1;
        if (DelayKt.delay(r5, this) != r0) goto L21;
        return r0;
    L17:
        r10 = Boxing.boxLong(((Number) CollectionsKt.last(r9)).longValue());
        goto L18
    L13:
        if (r2 >= r9.size()) goto L15;
        r4 = true;
        goto L15
    }
}
