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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo$opt$2$1$onTabSwitched$1", f = "MmRecordingSummaryRepo.kt", i = {}, l = {380}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSummaryRepo$opt$2$1$onTabSwitched$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingUITab $newTab;
    int label;
    final /* synthetic */ MmRecordingSummaryRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingSummaryRepo this$1;

    public MmRecordingSummaryRepo$opt$2$1$onTabSwitched$1(MmRecordingSummaryRepo$opt$2.AnonymousClass1 r1, MmRecordingUITab r2, MmRecordingSummaryRepo r3, Continuation<? super MmRecordingSummaryRepo$opt$2$1$onTabSwitched$1> r4) {
        this.this$0 = r1;
        this.$newTab = r2;
        this.this$1 = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingSummaryRepo$opt$2$1$onTabSwitched$1(this.this$0, this.$newTab, this.this$1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L15:
        lvb.a.e(this.this$1.l, "[onTabSwitched] consume hasUnviewedSummary, switched to summary tab");
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        c r4 = (c) this.this$0.m();
        if (this.$newTab.isInSummary() == false) goto L17;
        if (Intrinsics.areEqual(r4.m, Boxing.boxBoolean(true)) == false) goto L17;
        MmRecordingSummaryRepo r3 = this.this$1;
        c r5 = c.a(r4, null, null, null, null, null, null, false, false, false, Boxing.boxBoolean(false), 4095);
        this.label = 1;
        if (r3.b(r5, this) != r1) goto L15;
        return r1;
    }
}
