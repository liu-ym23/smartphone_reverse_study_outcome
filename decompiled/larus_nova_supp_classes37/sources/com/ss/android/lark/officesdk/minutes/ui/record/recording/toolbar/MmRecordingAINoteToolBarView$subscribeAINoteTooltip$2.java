package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.view.View;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "needShow", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView$subscribeAINoteTooltip$2", f = "MmRecordingAINoteToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAINoteToolBarView$subscribeAINoteTooltip$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingViewModel $viewModel;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingAINoteToolBarView this$0;

    public MmRecordingAINoteToolBarView$subscribeAINoteTooltip$2(MmRecordingAINoteToolBarView r1, MmRecordingViewModel r2, Continuation<? super MmRecordingAINoteToolBarView$subscribeAINoteTooltip$2> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingAINoteToolBarView$subscribeAINoteTooltip$2 r0 = new MmRecordingAINoteToolBarView$subscribeAINoteTooltip$2(this.this$0, this.$viewModel, r5);
        r0.Z$0 = ((Boolean) r4).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView] */
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r5);
        mwb.c r0 = null;
        if (this.Z$0 == false) goto L19;
        final ?? r6 = this.this$0;
        final MmRecordingViewModel r1 = this.$viewModel;
        mwb.c r2 = r6.a;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L10:
        final View r3 = r0.g;
        qub.a r4 = r6.i;
        if (r4 == null) goto L15;
        boolean r7 = true;
        if (r4.isShowing() != true) goto L15;
    L16:
        if (r7 == true) goto L23;
        r6.post(new MmRecordingAINoteToolBarView$showAINoteTooltipAfterToolbarLayout$1(r6, r3, r1));
    L23:
        return Unit.INSTANCE;
    L15:
        r7 = false;
        goto L16
    L9:
        r0 = r2;
        goto L10
    L19:
        MmRecordingAINoteToolBarView r8 = this.this$0;
        int r9 = MmRecordingAINoteToolBarView.k;
        qub.a r10 = r8.i;
        r8.i = null;
        if (r10 == null) goto L23;
        r10.hide();
        goto L23
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
