package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aT\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a-\u0010\u0013\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a-\u0010\u0015\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0017"}, d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,123:1\n91#1,14:124\n91#1,14:138\n91#1,14:152\n91#1,14:166\n*S KotlinDebug\n*F\n+ 1 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n30#1:124,14\n41#1:138,14\n52#1:152,14\n62#1:166,14\n*E\n"})
public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator r5, Function1<? super Animator, Unit> r10, Function1<? super Animator, Unit> r11, Function1<? super Animator, Unit> r12, Function1<? super Animator, Unit> r13) {
        AnimatorKt$addListener$listener$1 r14 = new AnimatorKt$addListener$listener$1(r13, r10, r12, r11);
        r5.addListener(r14);
        return r14;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator r5, Function1 r10, Function1 r11, Function1 r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = AnonymousClass1.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = AnonymousClass2.INSTANCE;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = AnonymousClass3.INSTANCE;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = AnonymousClass4.INSTANCE;
    L14:
        AnimatorKt$addListener$listener$1 r16 = new AnimatorKt$addListener$listener$1(r13, r10, r12, r11);
        r5.addListener(r16);
        return r16;
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator r5, final Function1<? super Animator, Unit> r10, final Function1<? super Animator, Unit> r11) {
        Animator.AnimatorPauseListener r12 = new AnimatorKt$addPauseListener$listener$1(r11, r10);
        r5.addPauseListener(r12);
        return r12;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator r5, Function1 r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = C00711.INSTANCE;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = C00722.INSTANCE;
    L9:
        return addPauseListener(r5, r10, r11);
    }

    public static final Animator.AnimatorListener doOnCancel(Animator r5, final Function1<? super Animator, Unit> r10) {
        Animator.AnimatorListener r11 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator r5, final Function1<? super Animator, Unit> r10) {
        Animator.AnimatorListener r11 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator r5, Function1<? super Animator, Unit> r10) {
        return addPauseListener$default(r5, null, r10, 1, null);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator r5, final Function1<? super Animator, Unit> r10) {
        Animator.AnimatorListener r11 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }

    public static final Animator.AnimatorPauseListener doOnResume(Animator r5, Function1<? super Animator, Unit> r10) {
        return addPauseListener$default(r5, r10, null, 2, null);
    }

    public static final Animator.AnimatorListener doOnStart(Animator r5, final Function1<? super Animator, Unit> r10) {
        Animator.AnimatorListener r11 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }
}
