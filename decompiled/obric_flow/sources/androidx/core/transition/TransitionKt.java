package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n1#1,76:1\n59#1,16:77\n59#1,16:93\n59#1,16:109\n59#1,16:125\n59#1,16:141\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n26#1:77,16\n33#1:93,16\n40#1:109,16\n47#1:125,16\n54#1:141,16\n*E\n"})
public final class TransitionKt {
    public static final Transition.TransitionListener addListener(Transition r10, Function1<? super Transition, Unit> r11, Function1<? super Transition, Unit> r12, Function1<? super Transition, Unit> r13, Function1<? super Transition, Unit> r14, Function1<? super Transition, Unit> r15) {
        TransitionKt$addListener$listener$1 r16 = new TransitionKt$addListener$listener$1(r11, r14, r15, r13, r12);
        r10.addListener(r16);
        return r16;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition r5, Function1 r10, Function1 r11, Function1 r12, Function1 r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = AnonymousClass1.INSTANCE;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = AnonymousClass2.INSTANCE;
    L8:
        Function1 r17 = r11;
        if ((r15 & 4) == 0) goto L11;
        r12 = AnonymousClass3.INSTANCE;
    L11:
        Function1 r18 = r12;
        if ((r15 & 8) == 0) goto L15;
        r13 = AnonymousClass4.INSTANCE;
    L15:
        if ((r15 & 16) == 0) goto L17;
        r14 = AnonymousClass5.INSTANCE;
    L17:
        TransitionKt$addListener$listener$1 r19 = new TransitionKt$addListener$listener$1(r10, r13, r14, r18, r17);
        r5.addListener(r19);
        return r19;
    }

    public static final Transition.TransitionListener doOnCancel(Transition r5, final Function1<? super Transition, Unit> r10) {
        Transition.TransitionListener r11 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }

    public static final Transition.TransitionListener doOnEnd(Transition r5, final Function1<? super Transition, Unit> r10) {
        Transition.TransitionListener r11 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }

    public static final Transition.TransitionListener doOnPause(Transition r5, final Function1<? super Transition, Unit> r10) {
        Transition.TransitionListener r11 = new TransitionKt$doOnPause$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }

    public static final Transition.TransitionListener doOnResume(Transition r5, final Function1<? super Transition, Unit> r10) {
        Transition.TransitionListener r11 = new TransitionKt$doOnResume$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }

    public static final Transition.TransitionListener doOnStart(Transition r5, final Function1<? super Transition, Unit> r10) {
        Transition.TransitionListener r11 = new TransitionKt$doOnStart$$inlined$addListener$default$1(r10);
        r5.addListener(r11);
        return r11;
    }
}
