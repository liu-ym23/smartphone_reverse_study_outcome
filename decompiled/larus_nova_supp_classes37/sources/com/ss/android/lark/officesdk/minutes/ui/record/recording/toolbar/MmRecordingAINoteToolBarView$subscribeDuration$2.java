package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteUIEvent;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "duration", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView$subscribeDuration$2", f = "MmRecordingAINoteToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAINoteToolBarView$subscribeDuration$2 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<l, Boolean> $onNavigateToSubtitle;
    final /* synthetic */ MmRecordingViewModel $viewModel;
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ MmRecordingAINoteToolBarView this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingAINoteToolBarView$subscribeDuration$2(MmRecordingAINoteToolBarView r1, MmRecordingViewModel r2, Function1<? super l, Boolean> r3, Continuation<? super MmRecordingAINoteToolBarView$subscribeDuration$2> r4) {
        this.this$0 = r1;
        this.$viewModel = r2;
        this.$onNavigateToSubtitle = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        MmRecordingAINoteToolBarView$subscribeDuration$2 r0 = new MmRecordingAINoteToolBarView$subscribeDuration$2(this.this$0, this.$viewModel, this.$onNavigateToSubtitle, r6);
        r0.J$0 = ((Number) r5).longValue();
        return r0;
    }

    public final Object invoke(long r1, Continuation<? super Unit> r3) {
        return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (Continuation) r4);
    }

    /* JADX WARN: Type inference failed for: r6v6, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView] */
    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r6);
        long r0 = this.J$0;
        mwb.c r7 = this.this$0.a;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L7:
        r7.b.setText(com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a(r0));
        ?? r8 = this.this$0;
        if (MmRecordingAINoteToolBarView.R5(r8, r8.getContext()) == null) goto L10;
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.a r9 = this.this$0.Y5(this.$viewModel, this.$onNavigateToSubtitle);
        long r2 = this.$viewModel.getState().c;
        long r1 = r9.c(r0);
        r9.f = r1;
        MmAINoteFragment r10 = r9.i;
        if (r10 == null) goto L15;
        r10.fa0().dispatchEvent(new MmAINoteUIEvent.l(r1, r2));
    L15:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
