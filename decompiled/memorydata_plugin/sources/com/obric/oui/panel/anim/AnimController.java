package com.obric.oui.panel.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011J&\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011J$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011H\u0002J&\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011H\u0002J\u0006\u0010\u0016\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/panel/anim/AnimController;", "", "()V", "enterAnimProcessType", "Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "getEnterAnimProcessType", "()Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "setEnterAnimProcessType", "(Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;)V", "exitAnimProcessType", "getExitAnimProcessType", "setExitAnimProcessType", "doEnterAnim", "", "anim", "Landroid/animation/ObjectAnimator;", "animProgressListener", "Lkotlin/Function1;", "", "doExitAnim", "getContainerEnterAnim", "getContainerExitAnim", "refresh", "AnimProcessType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimProcessType f14270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimProcessType f14271b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "", "(Ljava/lang/String;I)V", "NONE", "DOING", "DONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AnimProcessType extends Enum<AnimProcessType> {
        private static final /* synthetic */ AnimProcessType[] $VALUES = null;
        public static final AnimProcessType DOING = null;
        public static final AnimProcessType DONE = null;
        public static final AnimProcessType NONE = null;

        private static final /* synthetic */ AnimProcessType[] $values() {
            return new AnimProcessType[]{NONE, DOING, DONE};
        }

        static {
            NONE = new AnimProcessType("NONE", 0);
            DOING = new AnimProcessType("DOING", 1);
            DONE = new AnimProcessType("DONE", 2);
            $VALUES = $values();
        }

        private AnimProcessType(String r1, int r2) {
            super(r1, r2);
        }

        public static AnimProcessType valueOf(String r2) {
            return (AnimProcessType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AnimProcessType.class, r2), AnimProcessType.class, "com.obric.memorydata.plugin");
        }

        public static AnimProcessType[] values() {
            return (AnimProcessType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AnimProcessType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/panel/anim/AnimController$getContainerEnterAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnimController f14272a;

        a(AnimController r1) {
            this.f14272a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f14272a.a(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f14272a.a(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
            Intrinsics.checkNotNullParameter(r1, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f14272a.a(AnimProcessType.DOING);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/panel/anim/AnimController$getContainerExitAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnimController f14273a;

        b(AnimController r1) {
            this.f14273a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f14273a.b(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f14273a.b(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
            Intrinsics.checkNotNullParameter(r1, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.f14273a.b(AnimProcessType.DOING);
        }
    }

    public AnimController() {
        this.f14270a = AnimProcessType.NONE;
        this.f14271b = AnimProcessType.NONE;
    }

    private static final void a(Function1 r2, ValueAnimator r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$animProgressListener");
        Intrinsics.checkNotNullParameter(r3, "animation");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r4.invoke(Float.valueOf(r3.getAnimatedFraction()));     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    private static final void b(Function1 r2, ValueAnimator r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$animProgressListener");
        Intrinsics.checkNotNullParameter(r3, "animation");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.m1421constructorimpl((Unit) ZeusTransformUtils.preCheckCast(r4.invoke(Float.valueOf(r3.getAnimatedFraction())), Unit.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    private final ObjectAnimator c(ObjectAnimator r3, Function1<? super Float, Unit> r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        r3.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new a(this), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r3.addUpdateListener(new $$Lambda$AnimController$SzHGEgefA9sLQRTrRuiTcJMk9gY(r5));
        return r3;
    }

    private final ObjectAnimator d(ObjectAnimator r3, Function1<? super Float, Unit> r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        r3.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new b(this), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        r3.addUpdateListener(new $$Lambda$AnimController$PF1i7ymeD_fhJP57l1DJjuDWydQ(r5));
        return r3;
    }

    public static /* synthetic */ void lambda$PF1i7ymeD_fhJP57l1DJjuDWydQ(Function1 r0, ValueAnimator r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$SzHGEgefA9sLQRTrRuiTcJMk9gY(Function1 r0, ValueAnimator r1) {
        a(r0, r1);
    }

    public final void a(ObjectAnimator r3, Function1<? super Float, Unit> r4) {
        Function1<? super Float, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "animProgressListener");
        if (this.f14270a == AnimProcessType.NONE) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        c(r3, r5).start();
    }

    public final void a(AnimProcessType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14270a = r2;
    }

    public final void b(ObjectAnimator r3, Function1<? super Float, Unit> r4) {
        Function1<? super Float, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "animProgressListener");
        if (this.f14271b == AnimProcessType.NONE) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        d(r3, r5).start();
    }

    public final void b(AnimProcessType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14271b = r2;
    }
}
