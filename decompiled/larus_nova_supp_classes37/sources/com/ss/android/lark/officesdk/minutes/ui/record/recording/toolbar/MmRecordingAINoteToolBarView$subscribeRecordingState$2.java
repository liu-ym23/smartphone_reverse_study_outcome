package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteUIEvent;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView$subscribeRecordingState$2", f = "MmRecordingAINoteToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAINoteToolBarView$subscribeRecordingState$2 extends SuspendLambda implements Function2<MMRecordingState, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<l, Boolean> $onNavigateToSubtitle;
    final /* synthetic */ MmRecordingViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingAINoteToolBarView this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingAINoteToolBarView$subscribeRecordingState$2(MmRecordingAINoteToolBarView r1, MmRecordingViewModel r2, Function1<? super l, Boolean> r3, Continuation<? super MmRecordingAINoteToolBarView$subscribeRecordingState$2> r4) {
        this.this$0 = r1;
        this.$viewModel = r2;
        this.$onNavigateToSubtitle = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        MmRecordingAINoteToolBarView$subscribeRecordingState$2 r0 = new MmRecordingAINoteToolBarView$subscribeRecordingState$2(this.this$0, this.$viewModel, this.$onNavigateToSubtitle, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(MMRecordingState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MMRecordingState) r1, (Continuation) r2);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView] */
    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r6);
        MMRecordingState r7 = (MMRecordingState) this.L$0;
        this.this$0.g = r7;
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmRecordingAINoteToolBarView#recordingState", "state=" + r7 + " aiNoteShowing=" + this.this$0.f, null, 8);
        if (r7 != MMRecordingState.RECORDING) goto L7;
        boolean r8 = true;
    L8:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r1 = this.this$0.Y5(this.$viewModel, this.$onNavigateToSubtitle);
        ?? r2 = this.this$0;
        MmRecordingAINoteToolBarView.R5(r2, r2.getContext());
        r1.g = r8;
        MmAINoteFragment r3 = r1.i;
        if (r3 == null) goto L11;
        r3.fa0().dispatchEvent(new MmAINoteUIEvent.m(r8));
    L11:
        MmRecordingAINoteToolBarView.S5(this.this$0, this.$viewModel);
        MmRecordingAINoteToolBarView.T5(this.this$0);
        return Unit.INSTANCE;
    L7:
        r8 = false;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
