package com.obric.assistant.special_input;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.common.apphost.AppHost;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.SpecialInputAutoShowComponent$canAutoShowInputPanel$2", f = "SpecialInputAutoShowComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpecialInputAutoShowComponent$canAutoShowInputPanel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $allowIgnoreInputState;
    final /* synthetic */ boolean $allowIgnoreSpeakingState;
    final /* synthetic */ boolean $allowOnUIPaused;
    int label;
    final /* synthetic */ SpecialInputAutoShowComponent this$0;

    public SpecialInputAutoShowComponent$canAutoShowInputPanel$2(SpecialInputAutoShowComponent r1, boolean r2, boolean r3, boolean r4, Continuation<? super SpecialInputAutoShowComponent$canAutoShowInputPanel$2> r5) {
        this.this$0 = r1;
        this.$allowOnUIPaused = r2;
        this.$allowIgnoreSpeakingState = r3;
        this.$allowIgnoreInputState = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SpecialInputAutoShowComponent$canAutoShowInputPanel$2(this.this$0, this.$allowOnUIPaused, this.$allowIgnoreSpeakingState, this.$allowIgnoreInputState, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L99;
        ResultKt.throwOnFailure(r6);
        if (((BaseComponentFeatureInternal) this.this$0).a.getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L9;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: already destroyed or not create");
        return Boxing.boxBoolean(false);
    L9:
        if (this.$allowOnUIPaused == true) goto L15;
        if (this.this$0.r == false) goto L15;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: ui is paused");
        return Boxing.boxBoolean(false);
    L15:
        if (AppHost.a.a().isAppBackground() == false) goto L19;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: app is background");
        return Boxing.boxBoolean(false);
    L19:
        if (s1a.a.e(this.this$0) == true) goto L24;
        int r7 = com.obric.assistant.chat.p.a;
        FragmentActivity r8 = s1a.a.getActivity(this.this$0);
        SpecialInputAutoShowComponent r2 = this.this$0;
        int r3 = SpecialInputAutoShowComponent.v;
        if (com.obric.assistant.chat.p.f(r8, (com.larus.bmhome.chat.component.cvs.y) r2.h.getValue()) == true) goto L24;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: component is not the current chat page");
        return Boxing.boxBoolean(false);
    L24:
        SpecialInputAutoShowComponent r9 = this.this$0;
        int r4 = SpecialInputAutoShowComponent.v;
        com.larus.bmhome.chat.component.cvs.y r10 = (com.larus.bmhome.chat.component.cvs.y) r9.h.getValue();
        if (r10 == null) goto L31;
        wc9.e r11 = r10.h();
        if (r11 == null) goto L31;
        if (ic8.n.v(r11) != true) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == true) goto L35;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: is not main conversation");
        return Boxing.boxBoolean(false);
    L35:
        AssistantActivityExpandState r13 = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState();
        if (r13 == AssistantActivityExpandState.FULL_SCREEN) goto L42;
        if (r13 == AssistantActivityExpandState.HALF_WINDOW) goto L42;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: is not full screen or half window. chatPageState is " + r13);
        return Boxing.boxBoolean(false);
    L42:
        if (this.$allowIgnoreSpeakingState == true) goto L48;
        if (this.this$0.q == false) goto L48;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: is speaking");
        return Boxing.boxBoolean(false);
    L48:
        if (this.$allowIgnoreInputState == true) goto L97;
        va8.o r14 = (va8.o) this.this$0.j.getValue();
        if (r14 == null) goto L56;
        String r15 = r14.u7();
        if (r15 == null) goto L56;
        if (com.larus.utils.o0.d(r15) != true) goto L56;
        boolean r16 = true;
    L57:
        if (r16 == false) goto L60;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: has input text");
        return Boxing.boxBoolean(false);
    L60:
        va8.o r17 = (va8.o) this.this$0.j.getValue();
        if (r17 != null) goto L63;
    L65:
        boolean r18 = false;
    L66:
        if (r18 == false) goto L69;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: is ime showing");
        return Boxing.boxBoolean(false);
    L69:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r19 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.this$0.k.getValue();
        if (r19 != null) goto L72;
    L74:
        boolean r20 = false;
    L75:
        if (r20 == false) goto L78;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: is showing attach panel");
        return Boxing.boxBoolean(false);
    L78:
        com.larus.bmhome.instruction.g r21 = (com.larus.bmhome.instruction.g) this.this$0.l.getValue();
        if (r21 != null) goto L81;
    L83:
        boolean r22 = false;
    L84:
        if (r22 == false) goto L87;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: is instruction open");
        return Boxing.boxBoolean(false);
    L87:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r23 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) this.this$0.m.getValue();
        if (r23 != null) goto L90;
    L92:
        boolean r24 = false;
    L93:
        if (r24 == false) goto L97;
        FLogger.a.i("SpecialInputAutoShowComponent", "canAutoShowInputPanel: is bottom menu show");
        return Boxing.boxBoolean(false);
    L90:
        if (r23.sL() != true) goto L92;
        r24 = true;
        goto L93
    L81:
        if (r21.z0() != true) goto L83;
        r22 = true;
        goto L84
    L72:
        if (r19.isVisible() != true) goto L74;
        r20 = true;
        goto L75
    L63:
        if (r17.w() != true) goto L65;
        r18 = true;
    L56:
        r16 = false;
    L97:
        return Boxing.boxBoolean(true);
    L31:
        r12 = false;
        goto L32
    L99:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
