package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.view.View;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.ss.android.lark.foundation.widget.FlowSwitch;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "saveArtifactType", "", "saveArtifactReady", "saveArtifactSyncing"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6", f = "MmStandaloneAIInterpretationToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6 extends SuspendLambda implements Function4<Boolean, Boolean, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    /* synthetic */ boolean Z$2;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationToolBarView this$0;

    public MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6(MmStandaloneAIInterpretationToolBarView r1, Continuation<? super MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6> r2) {
        this.this$0 = r1;
        super(4, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke(((Boolean) r1).booleanValue(), ((Boolean) r2).booleanValue(), ((Boolean) r3).booleanValue(), (Continuation) r4);
    }

    public final Object invoke(boolean r3, boolean r4, boolean r5, Continuation<? super Unit> r6) {
        MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6 r0 = new MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6(this.this$0, r6);
        r0.Z$0 = r3;
        r0.Z$1 = r4;
        r0.Z$2 = r5;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        boolean r6 = this.Z$0;
        boolean r0 = this.Z$1;
        boolean r1 = this.Z$2;
        FlowSwitch r2 = this.this$0.b;
        if ((r2 instanceof FlowSwitch) == false) goto L8;
        r2.setChecked(r6);
    L10:
        View r7 = this.this$0.b;
        if (r0 == false) goto L14;
        if (r1 == true) goto L14;
        boolean r3 = true;
    L15:
        r7.setEnabled(r3);
        MmStandaloneAIInterpretationToolBarView r8 = this.this$0;
        r8.c.setEnabled(r8.b.isEnabled());
        return Unit.INSTANCE;
    L14:
        r3 = false;
        goto L15
    L8:
        if ((r2 instanceof UDSwitch) == false) goto L10;
        ((UDSwitch) r2).setCheckedIgnoreEvent(r6);
        goto L10
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
