package androidx.core.transition;

import android.transition.Transition;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionKt {
    public static final Transition.TransitionListener addListener(Transition r8, Function1<? super Transition, Unit> r9, Function1<? super Transition, Unit> r10, Function1<? super Transition, Unit> r11, Function1<? super Transition, Unit> r12, Function1<? super Transition, Unit> r13) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        TransitionKt$addListener$listener$1 r14 = new TransitionKt$addListener$listener$1(r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin"), r6, r7);
        r8.addListener((Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r14, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        return (Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r14, Transition.TransitionListener.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition r7, Function1 r8, Function1 r9, Function1 r10, Function1 r11, Function1 r12, int r13, Object r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Function1 r18 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Function1 r19 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L5;
        r15 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L5:
        Function1 r2 = r15;
        if ((r13 & 2) == 0) goto L8;
        r16 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L8:
        Function1 r6 = r16;
        if ((r13 & 4) == 0) goto L11;
        r17 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass3.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L11:
        Function1 r5 = r17;
        if ((r13 & 8) == 0) goto L14;
        r18 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass4.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L14:
        Function1 r3 = r18;
        if ((r13 & 16) == 0) goto L17;
        r19 = (Function1) ZeusTransformUtils.preCheckCast(AnonymousClass5.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L17:
        TransitionKt$addListener$listener$1 r20 = new TransitionKt$addListener$listener$1(r2, r3, r19, r5, r6);
        r7.addListener((Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r20, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        return (Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r20, Transition.TransitionListener.class, "com.obric.memorydata.plugin");
    }

    public static final Transition.TransitionListener doOnCancel(Transition r2, Function1<? super Transition, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Transition.TransitionListener r0 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(r4);
        r2.addListener((Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        return (Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin");
    }

    public static final Transition.TransitionListener doOnEnd(Transition r2, Function1<? super Transition, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Transition.TransitionListener r0 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(r4);
        r2.addListener((Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        return (Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin");
    }

    public static final Transition.TransitionListener doOnPause(Transition r2, Function1<? super Transition, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Transition.TransitionListener r0 = new TransitionKt$doOnPause$$inlined$addListener$default$1(r4);
        r2.addListener((Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        return (Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin");
    }

    public static final Transition.TransitionListener doOnResume(Transition r2, Function1<? super Transition, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Transition.TransitionListener r0 = new TransitionKt$doOnResume$$inlined$addListener$default$1(r4);
        r2.addListener((Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        return (Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin");
    }

    public static final Transition.TransitionListener doOnStart(Transition r2, Function1<? super Transition, Unit> r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Transition.TransitionListener r0 = new TransitionKt$doOnStart$$inlined$addListener$default$1(r4);
        r2.addListener((Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin"));
        return (Transition.TransitionListener) ZeusTransformUtils.preCheckCast(r0, Transition.TransitionListener.class, "com.obric.memorydata.plugin");
    }
}
