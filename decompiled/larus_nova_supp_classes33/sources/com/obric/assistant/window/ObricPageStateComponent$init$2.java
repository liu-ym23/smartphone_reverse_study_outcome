package com.obric.assistant.window;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.tips.GuideTipsDelegate;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.util.m2;
import com.obric.assistant.view.ObricIconSwipeUpView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/assistant/data/ObricFloatChatPageData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.window.ObricPageStateComponent$init$2", f = "ObricPageStateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricPageStateComponent$init$2 extends SuspendLambda implements Function2<ObricFloatChatPageData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricPageStateComponent this$0;

    public ObricPageStateComponent$init$2(ObricPageStateComponent r1, Continuation<? super ObricPageStateComponent$init$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricPageStateComponent$init$2 r0 = new ObricPageStateComponent$init$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ObricFloatChatPageData r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ObricFloatChatPageData) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r28) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L232;
        ResultKt.throwOnFailure(r28);
        ObricFloatChatPageData r1 = (ObricFloatChatPageData) this.L$0;
        ObricPageStateComponent r2 = this.this$0;
        int r3 = ObricPageStateComponent.Z;
        ObricFloatChatPageState r4 = ((ObricFloatChatPageData) r2.a4().getState()).getPageState();
        FLogger r5 = FLogger.a;
        r5.i("ObricPageStateComponent", "onPageStateChanged, lifecycle=" + ((BaseComponentFeatureInternal) this.this$0).a.getCurrentState() + ", callbackStateId=" + System.identityHashCode(r1.getPageState()) + ", callback=" + r1 + ", currentStateId=" + System.identityHashCode(r4) + ", current=" + r4);
        ObricFloatChatPageData.a r6 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r7 = r1.getPageState();
        r6.getClass();
        if (ObricFloatChatPageData.a.c(r7) == true) goto L7;
        final ObricPageStateComponent r8 = this.this$0;
        ObricFloatChatPageState r9 = r1.getPageState();
        u7 r10 = (u7) r8.v.getValue();
        if (r10 == null) goto L11;
        r10.U1();
    L11:
        IAssistantChatWindow r11 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r12 = true;
        if (r11 != null) goto L14;
    L16:
        boolean r13 = false;
    L17:
        Integer r14 = null;
        if ((r9 instanceof vda.b) == true) goto L29;
        ViewGroup r15 = r8.G3();
        if (r15 == null) goto L22;
        Float r16 = Float.valueOf(r15.getAlpha());
    L24:
        if (Intrinsics.areEqual(r16, 1.0f) == true) goto L29;
        if (r13 == true) goto L29;
        ViewGroup r17 = r8.G3();
        if (r17 == null) goto L29;
        r17.setAlpha(1.0f);
        goto L29
    L22:
        r16 = null;
    L29:
        ObricFloatChatPageState r18 = r9.getPreviousState();
        if (r18 == null) goto L32;
        Class<?> r19 = r18.getClass();
    L34:
        if (Intrinsics.areEqual(r19, r9.getClass()) == false) goto L67;
        ObricFloatChatPageState r20 = r9.getPreviousState();
        if (r20 != null) goto L38;
    L40:
        boolean r21 = false;
    L41:
        if (r21 == false) goto L67;
        xha.c r22 = r8.Z3();
        if (r22 == null) goto L50;
        Integer r23 = r22.w40();
        int r24 = r9.getHeight();
        if (r23 == null) goto L50;
        if (r23.intValue() != r24) goto L50;
        boolean r25 = true;
    L51:
        if (r25 == false) goto L67;
        ObricFloatChatPageState r26 = r9.getPreviousState();
        if (r26 != null) goto L55;
    L57:
        boolean r27 = false;
    L58:
        if (r27 == false) goto L67;
        ObricFloatChatPageState r29 = r9.getPreviousState();
        if (r29 != null) goto L62;
    L64:
        boolean r30 = false;
    L65:
        if (r30 == false) goto L67;
        r5.i("ObricPageStateComponent", "ignore this change previous is " + r9.getPreviousState() + " current is " + r9);
    L230:
        return Unit.INSTANCE;
    L62:
        if (ObricFloatChatPageData.a.e(r9) != ObricFloatChatPageData.a.e(r29)) goto L64;
        r30 = true;
        goto L65
    L55:
        if (ObricFloatChatPageData.a.b(r9) != ObricFloatChatPageData.a.b(r26)) goto L57;
        r27 = true;
    L50:
        r25 = false;
        goto L51
    L38:
        if (r20.getHeight() != r9.getHeight()) goto L40;
        r21 = true;
    L67:
        xha.e r31 = (xha.e) r8.x.getValue();
        if (r31 == null) goto L96;
        ObricIconSwipeUpView r32 = r31.qR();
        if (r32 == null) goto L96;
        if ((r9 instanceof vda.e) == false) goto L74;
    L93:
        boolean r33 = false;
    L94:
        r32.setEnabled(r33);
        goto L96
    L74:
        if ((r9 instanceof vda.b) == true) goto L93;
        r6.getClass();
        if ((r9 instanceof vda.f) == false) goto L78;
    L90:
        boolean r34 = true;
    L91:
        if (r34 == true) goto L93;
        r33 = true;
        goto L94
    L78:
        if (s1a.a.e(r8) == false) goto L89;
        Resources r35 = r8.getContext().getResources();
        if (r35 == null) goto L86;
        Configuration r36 = r35.getConfiguration();
        if (r36 == null) goto L86;
        if (r36.orientation != 2) goto L86;
        boolean r37 = true;
    L87:
        if (r37 == false) goto L89;
    L86:
        r37 = false;
    L89:
        r34 = false;
    L96:
        if (ObricFloatChatPageData.a.d(r9) == false) goto L122;
        boolean r38 = r9 instanceof vda.a;
        Iterator r39 = ((ArrayList) r8.N).iterator();
    L99:
        if (r39.hasNext() == false) goto L101;
        ((hca.b) r39.next()).r2(r38);
        goto L99
    L101:
        ObricFloatChatPageState r40 = r8.getPageState();
        ObricFloatChatPageData.a r41 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r42 = r40.getPreviousState();
        r41.getClass();
        if ((r42 instanceof vda.f) == true) goto L104;
    L106:
        boolean r43 = false;
    L107:
        if (r43 == false) goto L109;
    L117:
        boolean r44 = true;
    L118:
        if (r44 == false) goto L122;
        xha.c r45 = (xha.c) r8.w.getValue();
        if (r45 == null) goto L122;
        r45.sk();
        goto L122
    L109:
        if ((r40.getPreviousState() instanceof vda.f) == false) goto L111;
    L113:
        boolean r46 = false;
    L114:
        if (r46 == true) goto L117;
        r44 = false;
        goto L118
    L111:
        if ((r40 instanceof vda.f) == false) goto L113;
        r46 = true;
        goto L114
    L104:
        if ((r40 instanceof vda.f) == true) goto L106;
        r43 = true;
    L122:
        Iterator r47 = ((ArrayList) r8.N).iterator();
    L124:
        if (r47.hasNext() == false) goto L126;
        ((hca.b) r47.next()).x1(r9);
        goto L124
    L126:
        ObricFloatChatPageData.Companion.getClass();
        if ((r9 instanceof vda.a) == false) goto L155;
        if (r9.getOnlyChangeState() == true) goto L155;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateChatWindow");
        vda.a r48 = (vda.a) r9;
        FLogger r49 = FLogger.a;
        r49.i("ObricPageStateComponent", "onChangeToWindow, pageState is " + r48);
        IObricBannerService r50 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r50 == null) goto L133;
        r50.g();
    L133:
        r8.P.storeBoolean("is_dismiss_from_half_screen", false);
        r8.P.storeBoolean("obric_first_open_in_keyguard_locked", false);
        int r51 = yha.w.c;
        int r52 = yha.w.a.a(r8.G3(), r8.Q3(), r8.D3(), r8.B3());
        yha.w r110 = r8.M;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r48, "pageState");
        boolean r111 = r110.a.G0();
        ObricInteractDelegate r112 = ObricInteractDelegate.b;
        r49.i("ObricPageStateAnimationHelper", "changeToWindow, pageState = " + r48 + ", height = " + r52 + ", isWakeUpSpeaking = " + r111 + ", isAiKeyPressing = " + Intrinsics.areEqual(r112.isAiKeyPressing(), Boolean.TRUE));
        ObricFloatChatPageState r53 = r48.getPreviousState();
        if (r53 != null) goto L136;
    L138:
        boolean r54 = false;
    L139:
        if (r54 == true) goto L149;
        ObricFloatChatPageState r55 = r48.getPreviousState();
        if (r55 == null) goto L145;
        Intrinsics.checkNotNullParameter(r55, "<this>");
        if ((r55 instanceof com.obric.assistant.data.a) != true) goto L145;
        boolean r56 = true;
    L146:
        if (r56 == true) goto L149;
        boolean r57 = false;
    L150:
        if (r57 == false) goto L152;
        r110.a.B1(r52);
    L153:
        r112.notifyChangeWindowEvent(false);
        r8.i4();
    L222:
        GuideTipsDelegate r58 = GuideTipsDelegate.b;
        if ((r9 instanceof vda.d) == false) goto L225;
    L228:
        r58.e(r12);
        goto L230
    L225:
        if ((r9 instanceof vda.f) == true) goto L228;
        r12 = false;
        goto L228
    L152:
        r110.b.b();
        yha.d.a(r110.b, r52, true, null, 4);
    L145:
        r56 = false;
    L149:
        r57 = true;
        goto L150
    L136:
        if ((r53 instanceof vda.b) != true) goto L138;
        r54 = true;
    L155:
        if ((r9 instanceof vda.e) == false) goto L188;
        if (r9.getOnlyChangeState() == true) goto L188;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateHalfWindow");
        final vda.e r59 = (vda.e) r9;
        FLogger r60 = FLogger.a;
        StringBuilder r113 = new StringBuilder("onChangeToHalf, getTopEmptyHeight is ");
        xha.c r114 = r8.Z3();
        if (r114 == null) goto L161;
        r14 = r114.w40();
    L161:
        r113.append(r14);
        r113.append(", pageState is ");
        r113.append(r59);
        r60.i("ObricPageStateComponent", r113.toString());
        r8.P.storeBoolean("is_dismiss_from_half_screen", false);
        yha.w r61 = r8.M;
        Function0 r115 = new d0(r8, r59);
        r61.getClass();
        Intrinsics.checkNotNullParameter(r59, "pageState");
        r60.i("ObricPageStateAnimationHelper", "changeToHalf, pageState = " + r59);
        int r62 = r59.b;
        ObricFloatChatPageState r63 = r59.getPreviousState();
        if (r63 != null) goto L164;
    L166:
        boolean r64 = false;
    L167:
        if (r64 == true) goto L175;
        ObricFloatChatPageState r65 = r59.getPreviousState();
        if (r65 == null) goto L173;
        Intrinsics.checkNotNullParameter(r65, "<this>");
        if ((r65 instanceof com.obric.assistant.data.a) != true) goto L173;
        boolean r66 = true;
    L174:
        if (r66 == true) goto L175;
    L176:
        yha.d r67 = r61.b;
        r67.b();
        if (r59.a == false) goto L179;
        yha.d.a(r67, r62, false, r115, 2);
    L181:
        if (r59.a == true) goto L183;
        ObricPageStateComponent.d4(r59, "change_to_half_no_animation");
    L183:
        xha.c r68 = r8.Z3();
        if (r68 == null) goto L186;
        r68.em(1.0f);
    L186:
        ObricInteractDelegate.b.notifyChangeWindowEvent(false);
        goto L222
    L179:
        r61.a.B1(r62);
    L173:
        r66 = false;
    L175:
        r61.a.B1(r62);
        goto L176
    L164:
        if ((r63 instanceof vda.b) != true) goto L166;
        r64 = true;
    L188:
        if ((r9 instanceof vda.f) == false) goto L194;
        if (r9.getOnlyChangeState() == true) goto L194;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateLandscapeFullWindow");
        FLogger.a.i("ObricPageStateComponent", "onChangeToLandscapeFullWindow, pageState is " + ((vda.f) r9));
        r8.Y2();
    L194:
        if ((r9 instanceof vda.d) == false) goto L199;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateFullScreen");
        vda.d r69 = (vda.d) r9;
        FLogger r70 = FLogger.a;
        r70.i("ObricPageStateComponent", "onChangeToFull, pageState is " + r69);
        yha.d.a(r8.M.b, 0, false, new j0(), 2);
        r70.i("ObricPageStateComponent", "onChangeToFull, open chat activity");
        IAssistantChatWindow r116 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r116 == null) goto L198;
        Bundle r71 = new Bundle();
        r71.putBoolean("do_not_interrupt", true);
        r71.putString("obric_enter_full_screen", r69.c);
        r8.p4(r71);
        r8.l4(r71);
        IAssistantChatWindow$DefaultImpls.openChatWindow$default(r116, null, false, null, r71, false, false, null, null, false, true, 503, null);
    L198:
        r8.P.storeBoolean("is_dismiss_from_half_screen", false);
        ObricInteractDelegate.b.notifyChangeWindowEvent(true);
        goto L222
    L199:
        boolean r72 = r9 instanceof vda.b;
        if (r72 == false) goto L211;
        if (r9.getOnlyChangeState() == true) goto L211;
        if (r72 == true) goto L205;
    L207:
        r9.getHeight();
        r8.h4();
        if (ObricFloatChatPageData.a.e(r9) == false) goto L222;
        ObricInteractDelegate.b.notifyWakeupEvent(false);
        goto L222
    L205:
        if (r9.getOnlyChangeState() == false) goto L207;
        FLogger.a.i("ObricPageStateComponent", "onlyChangeState, ignore next step");
    L211:
        if ((r9 instanceof vda.c) == false) goto L222;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateDragging");
        vda.c r73 = (vda.c) r9;
        r8.v4(r73.a);
        if (r73.a > m2.e) goto L215;
        boolean r74 = true;
    L216:
        if (r74 == true) goto L218;
    L220:
        if (r74 == true) goto L222;
        r8.S = false;
        goto L222
    L218:
        if (r8.S == true) goto L220;
        r8.S = true;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
        goto L222
    L215:
        r74 = false;
        goto L216
    L32:
        r19 = null;
        goto L34
    L14:
        if (r11.isWindowAnimationRunning() != true) goto L16;
        r13 = true;
        goto L17
    L7:
        return Unit.INSTANCE;
    L232:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
