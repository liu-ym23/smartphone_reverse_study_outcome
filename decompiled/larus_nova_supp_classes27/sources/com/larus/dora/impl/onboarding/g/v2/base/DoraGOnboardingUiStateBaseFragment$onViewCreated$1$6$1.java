package com.larus.dora.impl.onboarding.g.v2.base;

import android.content.Context;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.LLMCallEvent;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.z;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1<T> implements FlowCollector {
    public final /* synthetic */ DoraGOnboardingUiStateBaseFragment a;

    public DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1(DoraGOnboardingUiStateBaseFragment r1) {
        this.a = r1;
    }

    public final Object a(z r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1$emit$1) == false) goto L7;
        DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1$emit$1 r0 = (DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1$emit$1) r12;
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
        r11 = (z) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L74:
        if (((z.a) r11).a == LLMCallEvent.REPLY) goto L77;
        this.a.ga0().forceWaitingState();
    L77:
        return Unit.INSTANCE;
    L18:
        r11 = (z) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L61:
        z.a r14 = (z.a) r11;
        if (r14.a == LLMCallEvent.FINISH) goto L74;
        if (CollectionsKt.listOf(new LLMCallEvent[]{LLMCallEvent.WEAR, LLMCallEvent.LINK, LLMCallEvent.INVALID}).contains(r14.a) == false) goto L69;
        r0.L$0 = r11;
        r0.label = 3;
        if (DelayKt.delay(600, r0) != r2) goto L74;
        return r2;
    L69:
        if (r14.a != LLMCallEvent.NEXT) goto L74;
        r0.L$0 = r11;
        r0.label = 4;
        if (DelayKt.delay(100, r0) != r2) goto L74;
        return r2;
    L19:
        r11 = (z) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L49:
        DoraGOnboardingUiStateBaseFragment r15 = this.a;
        r0.L$0 = r11;
        r0.label = 2;
        r15.ma0();
        if (Unit.INSTANCE != r2) goto L61;
        return r2;
    L20:
        ResultKt.throwOnFailure(r13);
        com.larus.dora.impl.onboarding.g.v2.f r16 = this.a.ma0();
        if (r16 != null) goto L23;
    L25:
        boolean r17 = false;
    L27:
        if (r17 == false) goto L31;
        g49.d.d("DoraGOnboardingUiStateBaseFragment", "cur state don't handle llm");
        return Unit.INSTANCE;
    L31:
        if ((r11 instanceof z.a) == true) goto L34;
        g49.d.d("DoraGOnboardingUiStateBaseFragment", "event is not LLMCallEventState.State");
        return Unit.INSTANCE;
    L34:
        g49.d.d("DoraGOnboardingUiStateBaseFragment", "llm call event shared " + r11);
        z.a r18 = (z.a) r11;
        LLMCallEvent r4 = r18.a;
        LLMCallEvent r8 = LLMCallEvent.NET;
        if (r4 != r8) goto L38;
        s r5 = s.a;
        Context r9 = this.a.getContext();
        r5.getClass();
        s.b(r9, 2131899658, false);
    L38:
        if (CollectionsKt.listOf(new LLMCallEvent[]{r8, LLMCallEvent.INVALID, LLMCallEvent.WEAR, LLMCallEvent.LINK}).contains(r18.a) == false) goto L44;
        DoraGOnboardingUiStateBaseFragment r110 = this.a;
        com.larus.dora.impl.onboarding.g.v2.f r6 = r110.ma0();
        if (r6 == null) goto L61;
        com.larus.dora.impl.onboarding.g.v2.f r7 = r6.d();
        if (r7 == null) goto L61;
        r7.b();
        r110.pa0(r7);
        goto L61
    L44:
        LLMCallEvent r111 = r18.a;
        if (r111 != LLMCallEvent.REPLY) goto L53;
        r0.L$0 = r11;
        r0.label = 1;
        if (DelayKt.delay(2000, r0) != r2) goto L49;
        return r2;
    L53:
        if (r111 != LLMCallEvent.FINISH) goto L61;
        DoraGOnboardingUiStateBaseFragment r112 = this.a;
        com.larus.dora.impl.onboarding.g.v2.f r10 = r112.ma0();
        if (r10 == null) goto L57;
        com.larus.dora.impl.onboarding.g.v2.f r20 = r10.g();
    L58:
        if (r20 == null) goto L60;
        r20.b();
    L60:
        r112.pa0(r20);
        goto L61
    L57:
        r20 = null;
        goto L58
    L23:
        if (r16.f() == true) goto L25;
        r17 = true;
    L7:
        r0 = new DoraGOnboardingUiStateBaseFragment$onViewCreated$1$6$1$emit$1(this, r12);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
        return a((z) r1, r2);
    }
}
