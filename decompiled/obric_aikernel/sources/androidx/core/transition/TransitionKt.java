package androidx.core.transition;

import android.annotation.SuppressLint;
import android.transition.Transition;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n1#1,86:1\n69#1,16:87\n69#1,16:103\n69#1,16:119\n69#1,16:135\n69#1,16:151\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n31#1:87,16\n39#1:103,16\n47#1:119,16\n55#1:135,16\n63#1:151,16\n*E\n"})
public final class TransitionKt {
    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition r10, Function1<? super Transition, Unit> r11, Function1<? super Transition, Unit> r12, Function1<? super Transition, Unit> r13, Function1<? super Transition, Unit> r14, Function1<? super Transition, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "onEnd");
        Intrinsics.checkNotNullParameter(r12, "onStart");
        Intrinsics.checkNotNullParameter(r13, "onCancel");
        Intrinsics.checkNotNullParameter(r14, "onResume");
        Intrinsics.checkNotNullParameter(r15, "onPause");
        TransitionKt$addListener$listener$1 r16 = new TransitionKt$addListener$listener$1(r11, r14, r15, r13, r12);
        r10.addListener(r16);
        return r16;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition r10, Function1 r11, Function1 r12, Function1 r13, Function1 r14, Function1 r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = AnonymousClass1.INSTANCE;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = AnonymousClass2.INSTANCE;
    L8:
        Function1 r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = AnonymousClass3.INSTANCE;
    L11:
        Function1 r19 = r13;
        if ((r16 & 8) == 0) goto L15;
        r14 = AnonymousClass4.INSTANCE;
    L15:
        if ((r16 & 16) == 0) goto L17;
        r15 = AnonymousClass5.INSTANCE;
    L17:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "onEnd");
        Intrinsics.checkNotNullParameter(r18, "onStart");
        Intrinsics.checkNotNullParameter(r19, "onCancel");
        Intrinsics.checkNotNullParameter(r14, "onResume");
        Intrinsics.checkNotNullParameter(r15, "onPause");
        TransitionKt$addListener$listener$1 r20 = new TransitionKt$addListener$listener$1(r11, r14, r15, r19, r18);
        r10.addListener(r20);
        return r20;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition r10, final Function1<? super Transition, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Transition.TransitionListener r12 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition r10, final Function1<? super Transition, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Transition.TransitionListener r12 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition r10, final Function1<? super Transition, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Transition.TransitionListener r12 = new TransitionKt$doOnPause$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition r10, final Function1<? super Transition, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Transition.TransitionListener r12 = new TransitionKt$doOnResume$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition r10, final Function1<? super Transition, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Transition.TransitionListener r12 = new TransitionKt$doOnStart$$inlined$addListener$default$1(r11);
        r10.addListener(r12);
        return r12;
    }
}
