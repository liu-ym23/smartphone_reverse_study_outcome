package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$onFishBoneContentReady$1", f = "MmRecordingSummaryRepo.kt", i = {1}, l = {350, 355}, m = "invokeSuspend", n = {"currentTab"}, s = {"L$0"})
public final class MmRecordingSummaryRepo$opt$2$1$onFishBoneContentReady$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSummaryRepo this$1;

    public MmRecordingSummaryRepo$opt$2$1$onFishBoneContentReady$1(MmRecordingSummaryRepo$opt$2.AnonymousClass1 r1, MmRecordingSummaryRepo r2, Continuation<? super MmRecordingSummaryRepo$opt$2$1$onFishBoneContentReady$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmRecordingSummaryRepo$opt$2$1$onFishBoneContentReady$1(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        MmRecordingUITab r3 = (MmRecordingUITab) this.L$0;
        ResultKt.throwOnFailure(r20);
    L21:
        lvb.a.e(this.this$1.l, "[onNewSummaryReceived] mark hasUnviewedSummary=true, currentTab=" + r3);
    L23:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r20);
    L13:
        MmRecordingUITab r4 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b) this.this$1.j.w().l().b().getValue()).e;
        if (r4.isInSummary() == true) goto L23;
        if (((c) this.this$0.m()).m != null) goto L23;
        MmRecordingSummaryRepo r5 = this.this$1;
        c r6 = c.a((c) this.this$0.m(), null, null, null, null, null, null, false, false, false, Boxing.boxBoolean(true), 4095);
        this.L$0 = r4;
        this.label = 2;
        if (r5.b(r6, this) != r1) goto L20;
        return r1;
    L20:
        r3 = r4;
        goto L21
    L10:
        ResultKt.throwOnFailure(r20);
        c r7 = (c) this.this$0.m();
        MmRecordingSummaryRepo r8 = this.this$1;
        c r9 = c.a(r7, null, null, MmSummaryStatus.HasContent, null, null, null, false, false, false, null, 8159);
        this.label = 1;
        if (r8.b(r9, this) != r1) goto L13;
        return r1;
    }
}
