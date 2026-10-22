package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g;
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
import mwb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "needShow", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView$subscribeData$6", f = "MmRecordingTopBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTopBarView$subscribeData$6 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingViewModel $viewModel;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingTopBarView this$0;

    public MmRecordingTopBarView$subscribeData$6(MmRecordingTopBarView r1, MmRecordingViewModel r2, Continuation<? super MmRecordingTopBarView$subscribeData$6> r3) {
        this.this$0 = r1;
        this.$viewModel = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingTopBarView$subscribeData$6 r0 = new MmRecordingTopBarView$subscribeData$6(this.this$0, this.$viewModel, r5);
        r0.Z$0 = ((Boolean) r4).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView, java.lang.Object] */
    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r25);
        if (this.Z$0 == false) goto L19;
        MmRecordingTopBarView r1 = this.this$0;
        if (r1.c == true) goto L19;
        h r2 = r1.a;
        h r3 = null;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L12:
        if (r2.f.getVisibility() != 0) goto L19;
        ?? r4 = this.this$0;
        MmRecordingViewModel r5 = this.$viewModel;
        r4.getClass();
        int r6 = bwb.b.a;
        bwb.b.g(MmUiLogScene.TOOLBAR, "showAudioSaveBoardingBubble", "show audio save boarding bubble", null, 8);
        MmRecordingViewModel.trackPageView$default(r5, "keep_audio_set_onboarding", null, 2, null);
        r4.c = true;
        int r7 = com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.a;
        Context r8 = r4.getContext();
        h r9 = r4.a;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L17:
        com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.b(r8, r3.f, r4.getContext().getString(2131892906), MmBubbleDirection.TOP, true, true, 3000, false, null, null, null, null, null, r5.getUiLaunchMode(), null, null, 114440);
        r5.dispatchEvent(g.d.a);
        goto L19
    L16:
        r3 = r9;
    L19:
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
