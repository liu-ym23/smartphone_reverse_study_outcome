package androidx.core.animation;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt$addListener$listener$1\n*L\n1#1,136:1\n*E\n"})
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1<Animator, Unit> $onCancel;
    final /* synthetic */ Function1<Animator, Unit> $onEnd;
    final /* synthetic */ Function1<Animator, Unit> $onRepeat;
    final /* synthetic */ Function1<Animator, Unit> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addListener$listener$1(Function1<? super Animator, Unit> r10, Function1<? super Animator, Unit> r11, Function1<? super Animator, Unit> r12, Function1<? super Animator, Unit> r13) {
        this.$onRepeat = r10;
        this.$onEnd = r11;
        this.$onCancel = r12;
        this.$onStart = r13;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animator");
        this.$onCancel.invoke(r10);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animator");
        this.$onEnd.invoke(r10);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animator");
        this.$onRepeat.invoke(r10);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animator");
        this.$onStart.invoke(r10);
    }
}
