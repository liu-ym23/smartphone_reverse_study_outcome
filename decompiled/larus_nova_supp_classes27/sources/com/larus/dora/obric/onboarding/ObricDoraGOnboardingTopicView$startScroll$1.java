package com.larus.dora.obric.onboarding;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingTopicView$startScroll$1", f = "ObricDoraGOnboardingTopicView.kt", i = {0}, l = {188}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ObricDoraGOnboardingTopicView$startScroll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricDoraGOnboardingTopicView this$0;

    public ObricDoraGOnboardingTopicView$startScroll$1(ObricDoraGOnboardingTopicView r1, Continuation<? super ObricDoraGOnboardingTopicView$startScroll$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricDoraGOnboardingTopicView$startScroll$1 r0 = new ObricDoraGOnboardingTopicView$startScroll$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0035 -> B:14:0x0038). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        final int r2 = 1;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
        ObricDoraGOnboardingTopicView$startScroll$1 r12 = this;
    L14:
        final ObricDoraGOnboardingTopicView r4 = r12.this$0;
        if (r4.n == false) goto L17;
    L10:
        if (CoroutineScopeKt.isActive(r3) == false) goto L24;
        r12.L$0 = r3;
        r12.label = 1;
        if (DelayKt.delay(4000, r12) != r0) goto L14;
        return r0;
    L24:
        return Unit.INSTANCE;
    L17:
        if (r4.b.isEmpty() == true) goto L10;
        r4.n = true;
        int r5 = ((r4.m + 1) + r4.b.size()) % r4.b.size();
        r4.m = r5;
        Function2<? super Integer, ? super Boolean, Unit> r6 = r4.y;
        if (r6 == null) goto L22;
        r6.invoke(Integer.valueOf(r5), Boolean.TRUE);
    L22:
        float r7 = r4.v;
        float r8 = r7 - (r4.i(60) * 1);
        int r9 = r4.m - 1;
        int r10 = r4.b.size();
        final ObricDoraGOnboardingTopicView.b r13 = r4.k(((r9 % r10) + r10) % r10, r4.m);
        r4.c(r13.a, 1);
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{r7, r8});
        r15.setDuration(360);
        r15.setInterpolator(new AccelerateDecelerateInterpolator());
        r15.addUpdateListener(new a0(r4, r13, r2));
        r15.addListener(new d0(r14, r4));
        r15.start();
        r4.t = r15;
        goto L10
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r3 = (CoroutineScope) this.L$0;
        r12 = this;
        goto L10
    }
}
