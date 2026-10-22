package com.obric.assistant.component;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.tips.GuideTipsDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.trace.IObricTraceParam;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricChatPageStateComponent$init$5", f = "ObricChatPageStateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricChatPageStateComponent$init$5 extends SuspendLambda implements Function2<ObricFloatChatPageState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricChatPageStateComponent this$0;

    public ObricChatPageStateComponent$init$5(ObricChatPageStateComponent r1, Continuation<? super ObricChatPageStateComponent$init$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricChatPageStateComponent$init$5 r0 = new ObricChatPageStateComponent$init$5(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ObricFloatChatPageState r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ObricFloatChatPageState) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L118;
        ResultKt.throwOnFailure(r11);
        ObricFloatChatPageState r12 = (ObricFloatChatPageState) this.L$0;
        FLogger r0 = FLogger.a;
        r0.i("OrionChatPageStateComponent", "onPageStateChange: " + r12);
        ObricFloatChatPageData.Companion.getClass();
        if (ObricFloatChatPageData.a.c(r12) == true) goto L7;
        ObricChatPageStateComponent r1 = this.this$0;
        com.larus.bmhome.view.b r3 = ObricChatPageStateComponent.v2;
        r1.getClass();
        boolean r4 = r12 instanceof vda.c;
        if (r4 == true) goto L20;
        int r5 = com.larus.utils.m0.a;
        int r6 = com.larus.utils.m0.a(s1a.a.getActivity(r1));
        IObricTraceParam r7 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r7 == null) goto L20;
        if ((r12 instanceof vda.a) == false) goto L16;
        r6 = 0;
    L19:
        r7.setWindowHeight(r6);
        goto L20
    L16:
        if ((r12 instanceof vda.d) == true) goto L19;
        r6 = r6 - r12.getHeight();
    L20:
        boolean r8 = r12 instanceof vda.a;
        if (r8 == false) goto L23;
    L24:
        r1.G3().w("onPageStateChange");
    L25:
        com.obric.assistant.util.j0 r9 = r1.G3();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r12, "pageState");
        r9.d.o(r12);
        boolean r10 = r12 instanceof vda.b;
        if (r10 == false) goto L33;
        ViewGroup r13 = r1.V3();
        if (r13 == null) goto L30;
        Float r14 = Float.valueOf(r13.getAlpha());
    L32:
        if (Intrinsics.areEqual(r14, 1.0f) == true) goto L33;
    L37:
        if (Intrinsics.areEqual(r1.g2.getClass(), r12.getClass()) == false) goto L44;
        if (r1.g2.getHeight() != r12.getHeight()) goto L44;
        if (r1.G1() != r12.getHeight()) goto L44;
        r0.i("OrionChatPageStateComponent", "ignore this change " + r1.g2 + ' ' + r12);
    L116:
        return Unit.INSTANCE;
    L44:
        if (ObricFloatChatPageData.a.d(r12) == false) goto L50;
        r1.X = false;
        Iterator r2 = ((ArrayList) r1.T).iterator();
    L47:
        if (r2.hasNext() == false) goto L49;
        ((hca.b) r2.next()).r2(r8);
        goto L47
    L49:
        r1.h3();
    L50:
        Iterator r15 = ((ArrayList) r1.T).iterator();
    L52:
        if (r15.hasNext() == false) goto L54;
        ((hca.b) r15.next()).x1(r12);
        goto L52
    L54:
        ObricFloatChatPageData.Companion.getClass();
        if (r8 == false) goto L58;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateChatWindow");
        r1.F4((vda.a) r12);
    L114:
        GuideTipsDelegate.b.e(r12 instanceof vda.d);
        r1.g2 = r12;
        goto L116
    L58:
        if ((r12 instanceof vda.e) == false) goto L61;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateHalfWindow");
        r1.B4((vda.e) r12);
        goto L114
    L61:
        if ((r12 instanceof vda.d) == false) goto L63;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateFullScreen");
        r1.v4((vda.d) r12);
        goto L114
    L63:
        if (r10 == false) goto L103;
        r12.getHeight();
        r1.h5(false);
        IObricBannerService r16 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r16 == null) goto L67;
        r16.g();
    L67:
        ICoreInputAbility r17 = r1.W3();
        if (r17 == null) goto L70;
        r17.qp(false);
    L70:
        r1.E3().a();
        ObricFloatChatPageState r18 = r1.getPageState().getPreviousState();
        boolean r19 = true;
        if (r18 != null) goto L73;
    L75:
        boolean r20 = false;
    L76:
        if (r20 == false) goto L86;
        FrameLayout r21 = r1.X3();
        if (r21 == null) goto L80;
        int r22 = r21.getHeight();
    L81:
        com.larus.utils.i0.a.getClass();
        int r23 = r22 + com.larus.utils.i0.e();
        FrameLayout r24 = r1.Q3();
        if (r24 == null) goto L84;
        int r25 = r24.getHeight();
    L85:
        int r26 = (r23 + r25) + i5.s0();
    L98:
        if (r26 > 0) goto L100;
        r26 = i5.d();
    L100:
        r1.E3().g(r26);
        r1.E3().f(false, false);
        sea.e.c(false);
        if (ObricFloatChatPageData.a.e(r12) == false) goto L114;
        ObricInteractDelegate.b.notifyWakeupEvent(false);
        goto L114
    L84:
        r25 = 0;
        goto L85
    L80:
        r22 = i5.d();
        goto L81
    L86:
        ObricFloatChatPageState r27 = r1.getPageState().getPreviousState();
        if (r27 != null) goto L89;
    L91:
        r19 = false;
    L92:
        if (r19 == false) goto L97;
        FrameLayout r28 = r1.i4();
        if (r28 == null) goto L96;
        r26 = (int) r28.getTranslationY();
        goto L98
    L96:
        r26 = i5.d();
        goto L98
    L97:
        int r29 = com.larus.utils.m0.a;
        r26 = com.larus.utils.m0.a(r1.getContext()) - r1.G1();
        goto L98
    L89:
        if ((r27 instanceof vda.b) != true) goto L91;
    L73:
        if ((r18 instanceof vda.a) != true) goto L75;
        r20 = true;
        goto L76
    L103:
        if (r4 == false) goto L114;
        int r30 = r12.getHeight();
        int r31 = r1.G1();
        com.obric.assistant.util.s0 r32 = r1.E3();
        float r33 = r30;
        Integer r34 = Integer.valueOf(r31);
        r32.getClass();
        if (r33 < 0.0f) goto L111;
        FLogger.a.i("ChatPageStateAnimationHelper", "startDragAnim, startValue = " + r34 + ", finalPosition = " + r33);
        r32.c().getSpring().setStiffness(10000.0f);
        r32.c().getSpring().setDampingRatio(1.0f);
        if (r34 == null) goto L110;
        SpringAnimation r35 = r32.c().setStartValue(r34.intValue());
    L110:
        r32.c().animateToFinalPosition(r33);
    L111:
        IObricBannerService r36 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r36 == null) goto L114;
        r36.g();
        goto L114
    L30:
        r14 = null;
    L33:
        ViewGroup r37 = r1.V3();
        if (r37 == null) goto L37;
        r37.setAlpha(1.0f);
        goto L37
    L23:
        if ((r12 instanceof vda.d) == false) goto L25;
    L7:
        return Unit.INSTANCE;
    L118:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
