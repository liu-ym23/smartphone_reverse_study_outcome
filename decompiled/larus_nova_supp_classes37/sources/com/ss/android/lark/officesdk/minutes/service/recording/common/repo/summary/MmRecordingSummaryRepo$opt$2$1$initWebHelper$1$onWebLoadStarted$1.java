package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$initWebHelper$1$onWebLoadStarted$1", f = "MmRecordingSummaryRepo.kt", i = {}, l = {410}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSummaryRepo$opt$2$1$initWebHelper$1$onWebLoadStarted$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingSummaryRepo this$0;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingSummaryRepo$opt$2$1$initWebHelper$1$onWebLoadStarted$1(MmRecordingSummaryRepo r1, MmRecordingSummaryRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingSummaryRepo$opt$2$1$initWebHelper$1$onWebLoadStarted$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmRecordingSummaryRepo$opt$2$1$initWebHelper$1$onWebLoadStarted$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        MmRecordingSummaryRepo r3 = this.this$0;
        c r4 = c.a((c) this.this$1.m(), null, null, null, null, null, null, false, true, false, null, 4607);
        this.label = 1;
        if (r3.b(r4, this) != r1) goto L12;
        return r1;
    }
}
