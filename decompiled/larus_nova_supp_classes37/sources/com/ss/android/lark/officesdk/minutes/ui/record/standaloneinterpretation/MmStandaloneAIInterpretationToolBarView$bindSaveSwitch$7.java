package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/ui/record/standaloneinterpretation/MmStandaloneAIInterpretationVMEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$7", f = "MmStandaloneAIInterpretationToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$7 extends SuspendLambda implements Function2<f, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d $scope;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationToolBarView this$0;

    public MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$7(MmStandaloneAIInterpretationToolBarView r1, com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d r2, Continuation<? super MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$7> r3) {
        this.this$0 = r1;
        this.$scope = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$7 r0 = new MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$7(this.this$0, this.$scope, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(f r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((f) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r8);
        if (Intrinsics.areEqual((f) this.L$0, f.c.a) == false) goto L10;
        ConstraintLayout r9 = this.this$0;
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d r0 = this.$scope;
        int r1 = MmStandaloneAIInterpretationToolBarView.f;
        r9.getClass();
        if (r0.f.u(r9.getContext(), new rub.e(r9.getContext().getString(2131893501), ToastType.WARNING, com.ss.android.lark.officesdk.minutes.ui.style.c.a(r9.getContext()), 10)) == true) goto L10;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.f(2131893501);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
