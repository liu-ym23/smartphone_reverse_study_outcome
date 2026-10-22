package com.obric.oui.texteffects.runtime;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.oui.texteffects.core.r;
import com.obric.oui.texteffects.core.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\u0006\u0010\u0012\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/texteffects/runtime/TextEffectPlayer;", "", "logTag", "", "(Ljava/lang/String;)V", "animator", "Landroid/animation/ValueAnimator;", CommonConsts.APM_INNER_EVENT_COST_START, "", "spec", "Lcom/obric/oui/texteffects/core/TextEffectSpec;", "durationScale", "", "onFrame", "Lkotlin/Function1;", "", "onFinished", "Lkotlin/Function0;", "stop", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ValueAnimator f14702b;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/oui/texteffects/runtime/TextEffectPlayer$start$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f14703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f14704b;
        final /* synthetic */ u c;
        final /* synthetic */ Function0<Unit> d;

        a(Ref.BooleanRef r3, j r4, u r5, Function0<Unit> r6) {
            Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
            this.f14703a = r3;
            this.f14704b = r4;
            this.c = r5;
            this.d = r7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f14703a.element = true;
            com.obric.oui.texteffects.a r3 = com.obric.oui.texteffects.a.f14578a;
            String r4 = j.a(this.f14704b);
            u r1 = this.c;
            if (com.obric.oui.texteffects.a.a() == false) goto L6;
            Log.d(Intrinsics.stringPlus("OTextEff/", r4), Intrinsics.stringPlus("player cancel spec=", r1.a()));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            com.obric.oui.texteffects.a r6 = com.obric.oui.texteffects.a.f14578a;
            String r7 = j.a(this.f14704b);
            u r0 = this.c;
            Ref.BooleanRef r1 = this.f14703a;
            if (com.obric.oui.texteffects.a.a() == false) goto L6;
            Log.d(Intrinsics.stringPlus("OTextEff/", r7), "player end spec=" + r0.a() + ", canceled=" + r1.element);
        L6:
            if (this.f14703a.element == false) goto L8;
            return;
        L8:
            if (Intrinsics.areEqual(this.c.c(), r.b.f14634a) == true) goto L12;
            this.d.invoke();
            return;
        }
    }

    public j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logTag");
        this.f14701a = r2;
    }

    public static final /* synthetic */ String a(j r0) {
        return r0.f14701a;
    }

    private static final void a(Function1 r2, u r3, ValueAnimator r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$onFrame");
        Intrinsics.checkNotNullParameter(r3, "$spec");
        Intrinsics.checkNotNullParameter(r4, "valueAnimator");
        r5.invoke(Long.valueOf((long) (r4.getAnimatedFraction() * r3.b())));
    }

    /* JADX INFO: renamed from: lambda$-jMcF0-7_DwcWe4buwMzWNAsy6A, reason: not valid java name */
    public static /* synthetic */ void m1378lambda$jMcF07_DwcWe4buwMzWNAsy6A(Function1 r0, u r1, ValueAnimator r2) {
        a(r0, r1, r2);
    }

    public final void a() {
        ValueAnimator r0 = this.f14702b;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        this.f14702b = null;
    }

    public final void a(final u r7, float r8, Function1<? super Long, Unit> r9, Function0<Unit> r10) {
        final Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "spec");
        Intrinsics.checkNotNullParameter(r11, "onFrame");
        Intrinsics.checkNotNullParameter(r12, "onFinished");
        a();
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r2.setDuration(RangesKt.coerceAtLeast(MathKt.roundToInt(r7.b() * r8), 1));
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r r13 = r7.c();
        if (Intrinsics.areEqual(r13, r.c.f14635a) == false) goto L6;
        int r14 = 0;
    L11:
        r2.setRepeatCount(r14);
        r2.setRepeatMode(1);
        r2.addUpdateListener(new $$Lambda$j$jMcF07_DwcWe4buwMzWNAsy6A(r11, r7));
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new a(r0, this, r7, r12), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r2.start();
        this.f14702b = r2;
        return;
    L6:
        if (Intrinsics.areEqual(r13, r.b.f14634a) == false) goto L9;
        r14 = -1;
        goto L11
    L9:
        if (ZeusTransformUtils.instanceOf(r13, r.a.class) == false) goto L14;
        r14 = RangesKt.coerceAtLeast(((r.a) ZeusTransformUtils.preCheckCast(r13, r.a.class, "com.obric.memorydata.plugin")).a(), 1) - 1;
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
