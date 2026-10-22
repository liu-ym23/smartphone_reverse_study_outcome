package com.larus.dora.obric.onboarding;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1<T> implements FlowCollector {
    public final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment a;

    public ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1(ObricDoraGOnboardingUiStateBaseFragment r1) {
        this.a = r1;
    }

    public final Object a(g r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1) == false) goto L7;
        ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1 r0 = (ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r11 = (g) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L101:
        if (((g.a) r11).a == LLMCallEvent.REPLY) goto L104;
        this.a.ga0().forceWaitingState();
    L104:
        return Unit.INSTANCE;
    L18:
        r11 = (g) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L88:
        g.a r14 = (g.a) r11;
        if (r14.a == LLMCallEvent.FINISH) goto L101;
        if (CollectionsKt.listOf(new LLMCallEvent[]{LLMCallEvent.WEAR, LLMCallEvent.LINK, LLMCallEvent.INVALID}).contains(r14.a) == false) goto L96;
        r0.L$0 = r11;
        r0.label = 3;
        if (DelayKt.delay(600, r0) != r2) goto L101;
        return r2;
    L96:
        if (r14.a != LLMCallEvent.NEXT) goto L101;
        r0.L$0 = r11;
        r0.label = 4;
        if (DelayKt.delay(100, r0) != r2) goto L101;
        return r2;
    L19:
        r11 = (g) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L82:
        ObricDoraGOnboardingUiStateBaseFragment r15 = this.a;
        r0.L$0 = r11;
        r0.label = 2;
        r15.pa0();
        if (Unit.INSTANCE != r2) goto L88;
        return r2;
    L20:
        ResultKt.throwOnFailure(r13);
        if ((this.a.pa0() instanceof x) == true) goto L23;
    L35:
        p r16 = this.a.pa0();
        if ((r16 instanceof t) == false) goto L38;
        t r17 = (t) r16;
    L39:
        if (r17 == null) goto L47;
        if ((r11 instanceof g.a) == false) goto L47;
        if (((g.a) r11).a != LLMCallEvent.FINISH) goto L47;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "ignore llm finish in long press wakeup state");
        return Unit.INSTANCE;
    L47:
        if ((this.a.pa0() instanceof q) == true) goto L49;
    L58:
        p r18 = this.a.pa0();
        if (r18 != null) goto L61;
    L63:
        boolean r110 = false;
    L64:
        if (r110 == false) goto L68;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "cur state don't handle llm");
        return Unit.INSTANCE;
    L68:
        if ((r11 instanceof g.a) == true) goto L71;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "event is not LLMCallEventState.State");
        return Unit.INSTANCE;
    L71:
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "llm call event shared " + r11);
        g.a r111 = (g.a) r11;
        LLMCallEvent r4 = r111.a;
        LLMCallEvent r8 = LLMCallEvent.NET;
        if (r4 != r8) goto L75;
        t19.s r5 = t19.s.a;
        Context r9 = this.a.getContext();
        r5.getClass();
        t19.s.b(r9, 2131899658, false);
    L75:
        if (CollectionsKt.listOf(new LLMCallEvent[]{r8, LLMCallEvent.INVALID, LLMCallEvent.WEAR, LLMCallEvent.LINK}).contains(r111.a) == false) goto L77;
        this.a.pa0();
        goto L88
    L77:
        LLMCallEvent r112 = r111.a;
        if (r112 != LLMCallEvent.REPLY) goto L86;
        r0.L$0 = r11;
        r0.label = 1;
        if (DelayKt.delay(2000, r0) != r2) goto L82;
        return r2;
    L86:
        if (r112 != LLMCallEvent.FINISH) goto L88;
        this.a.ra0();
        goto L88
    L61:
        if (r18.d() == true) goto L63;
        r110 = true;
        goto L64
    L49:
        if ((r11 instanceof g.a) == false) goto L58;
        LLMCallEvent r113 = ((g.a) r11).a;
        if (r113 != LLMCallEvent.WEAR) goto L55;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "llm call interrupted by wear state in click stop state, goto next");
        this.a.ra0();
        this.a.ga0().forceWaitingState();
        return Unit.INSTANCE;
    L55:
        if (r113 != LLMCallEvent.FINISH) goto L58;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "llm call finished in click stop state, goto next");
        this.a.ra0();
        this.a.ga0().forceWaitingState();
        return Unit.INSTANCE;
    L38:
        r17 = null;
        goto L39
    L23:
        if ((r11 instanceof g.a) == false) goto L35;
        if (((g.a) r11).a != LLMCallEvent.QUERY_END) goto L35;
        ObricDoraGOnboardingUiStateBaseFragment r114 = this.a;
        if (r114.t == true) goto L29;
    L32:
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "ignore video query query end, isLlmCallStarted=" + r114.t + ", current=" + ObricDoraGOnboardingUiStateBaseFragment.na0(r114.pa0()));
    L34:
        return Unit.INSTANCE;
    L29:
        if ((r114.pa0() instanceof x) == false) goto L32;
        g49.d.d("ObricDoraGOnboardingUiStateBaseFragment", "query end in video query state, goto next");
        r114.ra0();
    L7:
        r0 = new ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1(this, r12);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
        return a((g) r1, r2);
    }
}
