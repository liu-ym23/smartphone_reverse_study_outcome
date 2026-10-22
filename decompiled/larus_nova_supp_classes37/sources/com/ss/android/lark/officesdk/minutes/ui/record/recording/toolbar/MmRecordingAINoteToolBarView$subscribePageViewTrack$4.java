package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView$subscribePageViewTrack$4", f = "MmRecordingAINoteToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAINoteToolBarView$subscribePageViewTrack$4 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingViewModel $viewModel;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingAINoteToolBarView this$0;

    public MmRecordingAINoteToolBarView$subscribePageViewTrack$4(MmRecordingAINoteToolBarView r1, MmRecordingViewModel r2, Continuation<? super MmRecordingAINoteToolBarView$subscribePageViewTrack$4> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingAINoteToolBarView$subscribePageViewTrack$4 r0 = new MmRecordingAINoteToolBarView$subscribePageViewTrack$4(this.this$0, this.$viewModel, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        if (((String) this.L$0).length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L11;
        MmRecordingAINoteToolBarView r5 = this.this$0;
        MmRecordingViewModel r0 = this.$viewModel;
        int r1 = MmRecordingAINoteToolBarView.k;
        r5.getClass();
        r0.trackAINoteEntryViewIfNeeded();
        this.$viewModel.refreshAINoteTooltipIfNeeded();
    L11:
        return Unit.INSTANCE;
    L7:
        r4 = false;
        goto L8
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
