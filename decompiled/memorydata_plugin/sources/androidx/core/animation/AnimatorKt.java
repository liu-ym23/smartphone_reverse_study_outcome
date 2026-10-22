package androidx.core.animation;

import android.animation.Animator;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aV\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0002\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a/\u0010\u0013\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a/\u0010\u0015\u001a\u00020\r*\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0007\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0017"}, d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator r2, Function1<? super Animator, Unit> r3, Function1<? super Animator, Unit> r4, Function1<? super Animator, Unit> r5, Function1<? super Animator, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        AnimatorKt$addListener$listener$1 r0 = new AnimatorKt$addListener$listener$1((Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin"), r7, r9, r8);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator r1, Function1 r2, Function1 r3, Function1 r4, Function1 r5, int r6, Object r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 2) == 0) goto L9;
        r9 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L9:
        if ((r6 & 4) == 0) goto L12;
        r10 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass3.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L12:
        if ((r6 & 8) == 0) goto L14;
        r11 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass4.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L14:
        AnimatorKt$addListener$listener$1 r12 = new AnimatorKt$addListener$listener$1(r11, r8, r10, r9);
        r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r12, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r12, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
    }

    public static final Animator.AnimatorPauseListener addPauseListener(Animator r2, Function1<? super Animator, Unit> r3, Function1<? super Animator, Unit> r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Animator.AnimatorPauseListener r0 = new AnimatorKt$addPauseListener$listener$1(r6, r5);
        Api19Impl.addPauseListener(r2, (Animator.AnimatorPauseListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorPauseListener.class, "com.obric.memorydata.plugin"));
        return (Animator.AnimatorPauseListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorPauseListener.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator r1, Function1 r2, Function1 r3, int r4, Object r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = (Function1) ZeusTransformUtils.preCheckCast(C09181.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = (Function1) ZeusTransformUtils.preCheckCast(C09192.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L9:
        return addPauseListener(r1, r6, r7);
    }

    public static final Animator.AnimatorListener doOnCancel(Animator r2, Function1<? super Animator, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(r4);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
    }

    public static final Animator.AnimatorListener doOnEnd(Animator r2, Function1<? super Animator, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(r4);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
    }

    public static final Animator.AnimatorPauseListener doOnPause(Animator r2, Function1<? super Animator, Unit> r3) {
        return addPauseListener$default(r2, null, (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin"), 1, null);
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator r2, Function1<? super Animator, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(r4);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
    }

    public static final Animator.AnimatorPauseListener doOnResume(Animator r2, Function1<? super Animator, Unit> r3) {
        return addPauseListener$default(r2, (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin"), null, 2, null);
    }

    public static final Animator.AnimatorListener doOnStart(Animator r2, Function1<? super Animator, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Animator.AnimatorListener r0 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(r4);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
    }
}
