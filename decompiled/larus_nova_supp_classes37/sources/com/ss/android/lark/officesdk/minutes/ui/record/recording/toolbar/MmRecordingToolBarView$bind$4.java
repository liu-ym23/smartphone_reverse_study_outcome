package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

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
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MMRecordingState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingToolBarView$bind$4", f = "MmRecordingToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingToolBarView$bind$4 extends SuspendLambda implements Function2<MMRecordingState, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingToolBarView this$0;

    public MmRecordingToolBarView$bind$4(MmRecordingToolBarView r1, MmRecordingViewModel r2, Continuation<? super MmRecordingToolBarView$bind$4> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingToolBarView$bind$4 r0 = new MmRecordingToolBarView$bind$4(this.this$0, this.$viewModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(MMRecordingState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MMRecordingState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        MMRecordingState r3 = (MMRecordingState) this.L$0;
        MmRecordingToolBarView r0 = this.this$0;
        r0.c = r3;
        MmRecordingToolBarView.R5(r0, this.$viewModel);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
