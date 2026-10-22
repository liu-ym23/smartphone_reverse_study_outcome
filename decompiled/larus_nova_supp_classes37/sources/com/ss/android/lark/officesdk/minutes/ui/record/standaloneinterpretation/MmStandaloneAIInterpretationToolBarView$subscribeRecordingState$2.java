package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MMRecordingState;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2", f = "MmStandaloneAIInterpretationToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2 extends SuspendLambda implements Function2<MMRecordingState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationToolBarView this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MMRecordingState.values().length];
            r0[MMRecordingState.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MMRecordingState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2(MmStandaloneAIInterpretationToolBarView r1, Continuation<? super MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2 r0 = new MmStandaloneAIInterpretationToolBarView$subscribeRecordingState$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(MMRecordingState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MMRecordingState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        MMRecordingState r6 = (MMRecordingState) this.L$0;
        int r7 = a.a[r6.ordinal()];
        if (r7 != 1) goto L7;
        MmStandaloneAIInterpretationToolBarView r8 = this.this$0;
        int r1 = MmStandaloneAIInterpretationToolBarView.f;
        r8.S5(r8.T5().b(), this.this$0.T5().d(), this.this$0.T5().h());
        this.this$0.a.h.setEnabled(true);
        this.this$0.d.setEnabled(true);
        this.this$0.a.c.g();
    L12:
        return Unit.INSTANCE;
    L7:
        if (r7 == 2) goto L9;
        MmStandaloneAIInterpretationToolBarView r9 = this.this$0;
        int r0 = MmStandaloneAIInterpretationToolBarView.f;
        r9.S5(r9.T5().j(), this.this$0.T5().i(), this.this$0.T5().g());
        this.this$0.a.h.setEnabled(false);
        this.this$0.d.setEnabled(false);
        this.this$0.a.c.b();
        goto L12
    L9:
        MmStandaloneAIInterpretationToolBarView r10 = this.this$0;
        int r2 = MmStandaloneAIInterpretationToolBarView.f;
        r10.S5(r10.T5().j(), this.this$0.T5().d(), this.this$0.T5().h());
        this.this$0.a.h.setEnabled(true);
        this.this$0.d.setEnabled(true);
        this.this$0.a.c.b();
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
