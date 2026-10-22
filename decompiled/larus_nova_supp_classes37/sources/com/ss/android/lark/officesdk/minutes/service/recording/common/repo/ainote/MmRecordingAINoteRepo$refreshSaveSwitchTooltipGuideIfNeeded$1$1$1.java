package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1$1$1", f = "MmRecordingAINoteRepo.kt", i = {}, l = {1146, 1151}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needShow;
    final /* synthetic */ MmRecordingSource $source;
    int label;
    final /* synthetic */ MmRecordingAINoteRepo this$0;

    public MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1$1$1(MmRecordingAINoteRepo r1, boolean r2, MmRecordingSource r3, Continuation<? super MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1$1$1> r4) {
        this.this$0 = r1;
        this.$needShow = r2;
        this.$source = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MmRecordingAINoteRepo$refreshSaveSwitchTooltipGuideIfNeeded$1$1$1(this.this$0, this.$needShow, this.$source, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r25);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r25);
    L13:
        lvb.a.e(this.this$0.w, "[refreshSaveSwitchTooltipGuideIfNeeded] needShow=" + this.$needShow + " source=" + this.$source + ' ' + this.this$0.r());
        MmRecordingAINoteRepo r3 = this.this$0;
        this.label = 2;
        if (r3.A("guide_fetch", this) != r1) goto L17;
        return r1;
    L10:
        ResultKt.throwOnFailure(r25);
        c r5 = this.this$0.h();
        MmRecordingAINoteRepo r4 = this.this$0;
        c r6 = c.a(r5, false, 0, null, false, false, false, false, false, false, this.$needShow, false, false, false, false, false, false, 65023);
        this.label = 1;
        if (r4.b(r6, this) != r1) goto L13;
        return r1;
    }
}
