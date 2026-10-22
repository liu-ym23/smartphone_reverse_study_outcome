package com.obric.oui.panel.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimProcessType f6969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimProcessType f6970b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "DOING", "DONE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AnimProcessType extends Enum<AnimProcessType> {
        private static final /* synthetic */ AnimProcessType[] $VALUES = null;
        public static final AnimProcessType DOING = null;
        public static final AnimProcessType DONE = null;
        public static final AnimProcessType NONE = null;

        static {
            AnimProcessType r10 = new AnimProcessType("NONE", 0);
            NONE = r10;
            AnimProcessType r11 = new AnimProcessType("DOING", 1);
            DOING = r11;
            AnimProcessType r12 = new AnimProcessType("DONE", 2);
            DONE = r12;
            $VALUES = new AnimProcessType[]{r10, r11, r12};
        }

        private AnimProcessType(String r10, int r11) {
            super(r10, r11);
        }

        public static AnimProcessType valueOf(String r10) {
            return (AnimProcessType) Enum.valueOf(AnimProcessType.class, r10);
        }

        public static AnimProcessType[] values() {
            return (AnimProcessType[]) $VALUES.clone();
        }
    }

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AnimController f6971c;

        a(AnimController r10) {
            this.f6971c = r10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.f6971c.e(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.f6971c.e(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.f6971c.e(AnimProcessType.DOING);
        }
    }

    static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f6972c;

        b(Function1 r10) {
            this.f6972c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
            this.f6972c.invoke(Float.valueOf(r10.getAnimatedFraction()));     // Catch: Throwable -> L5
            Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            Result.m32constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AnimController f6973c;

        c(AnimController r10) {
            this.f6973c = r10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.f6973c.f(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.f6973c.f(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.f6973c.f(AnimProcessType.DOING);
        }
    }

    static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f6974c;

        d(Function1 r10) {
            this.f6974c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
            Result.m32constructorimpl((Unit) this.f6974c.invoke(Float.valueOf(r10.getAnimatedFraction())));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            Result.m32constructorimpl(ResultKt.createFailure(th));
        }
    }

    public AnimController() {
        AnimProcessType r10 = AnimProcessType.NONE;
        this.f6969a = r10;
        this.f6970b = r10;
    }

    private final ObjectAnimator c(ObjectAnimator r10, Function1<? super Float, Unit> r11) {
        r10.addListener(new a(this));
        r10.addUpdateListener(new b(r11));
        return r10;
    }

    private final ObjectAnimator d(ObjectAnimator r10, Function1<? super Float, Unit> r11) {
        r10.addListener(new c(this));
        r10.addUpdateListener(new d(r11));
        return r10;
    }

    public final void a(ObjectAnimator r10, Function1<? super Float, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "animProgressListener");
        if (this.f6969a == AnimProcessType.NONE) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        c(r10, r11).start();
    }

    public final void b(ObjectAnimator r10, Function1<? super Float, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "animProgressListener");
        if (this.f6970b == AnimProcessType.NONE) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        d(r10, r11).start();
    }

    public final void e(AnimProcessType r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6969a = r10;
    }

    public final void f(AnimProcessType r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6970b = r10;
    }
}
