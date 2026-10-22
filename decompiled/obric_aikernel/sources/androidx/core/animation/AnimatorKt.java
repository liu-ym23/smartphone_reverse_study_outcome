package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,136:1\n95#1,14:137\n95#1,14:151\n95#1,14:165\n95#1,14:179\n*S KotlinDebug\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n32#1:137,14\n43#1:151,14\n54#1:165,14\n64#1:179,14\n*E\n"})
public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator r10, Function1<? super Animator, Unit> r11, Function1<? super Animator, Unit> r12, Function1<? super Animator, Unit> r13, Function1<? super Animator, Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "onEnd");
        Intrinsics.checkNotNullParameter(r12, "onStart");
        Intrinsics.checkNotNullParameter(r13, "onCancel");
        Intrinsics.checkNotNullParameter(r14, "onRepeat");
        AnimatorKt$addListener$listener$1 r15 = new AnimatorKt$addListener$listener$1(r14, r11, r13, r12);
        r10.addListener(r15);
        return r15;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator r10, Function1 r11, Function1 r12, Function1 r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = AnonymousClass1.INSTANCE;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = AnonymousClass2.INSTANCE;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = AnonymousClass3.INSTANCE;
    L12:
        if ((r15 & 8) == 0) goto L14;
        r14 = AnonymousClass4.INSTANCE;
    L14:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "onEnd");
        Intrinsics.checkNotNullParameter(r12, "onStart");
        Intrinsics.checkNotNullParameter(r13, "onCancel");
        Intrinsics.checkNotNullParameter(r14, "onRepeat");
        AnimatorKt$addListener$listener$1 r17 = new AnimatorKt$addListener$listener$1(r14, r11, r13, r12);
        r10.addListener(r17);
        return r17;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator r10, final Function1<? super Animator, Unit> r11, final Function1<? super Animator, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "onResume");
        Intrinsics.checkNotNullParameter(r12, "onPause");
        Animator.AnimatorPauseListener r13 = new AnimatorKt$addPauseListener$listener$1(r12, r11);
        Api19Impl.addPauseListener(r10, r13);
        return r13;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator r10, Function1 r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = C03251.INSTANCE;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = C03262.INSTANCE;
    L9:
        return addPauseListener(r10, r11, r12);
    }

    public static final Animator.AnimatorListener doOnCancel(Animator r10, final Function1<? super Animator, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Animator.AnimatorListener r12 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator r10, final Function1<? super Animator, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Animator.AnimatorListener r12 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator r10, Function1<? super Animator, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        return addPauseListener$default(r10, null, r11, 1, null);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator r10, final Function1<? super Animator, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Animator.AnimatorListener r12 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator r10, Function1<? super Animator, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        return addPauseListener$default(r10, r11, null, 2, null);
    }

    public static final Animator.AnimatorListener doOnStart(Animator r10, final Function1<? super Animator, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Animator.AnimatorListener r12 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }
}
