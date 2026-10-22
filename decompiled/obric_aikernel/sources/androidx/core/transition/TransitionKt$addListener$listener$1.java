package androidx.core.transition;

import android.transition.Transition;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n*L\n1#1,86:1\n*E\n"})
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1<Transition, Unit> $onCancel;
    final /* synthetic */ Function1<Transition, Unit> $onEnd;
    final /* synthetic */ Function1<Transition, Unit> $onPause;
    final /* synthetic */ Function1<Transition, Unit> $onResume;
    final /* synthetic */ Function1<Transition, Unit> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> r10, Function1<? super Transition, Unit> r11, Function1<? super Transition, Unit> r12, Function1<? super Transition, Unit> r13, Function1<? super Transition, Unit> r14) {
        this.$onEnd = r10;
        this.$onResume = r11;
        this.$onPause = r12;
        this.$onCancel = r13;
        this.$onStart = r14;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition r10) {
        Intrinsics.checkNotNullParameter(r10, "transition");
        this.$onCancel.invoke(r10);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition r10) {
        Intrinsics.checkNotNullParameter(r10, "transition");
        this.$onEnd.invoke(r10);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition r10) {
        Intrinsics.checkNotNullParameter(r10, "transition");
        this.$onPause.invoke(r10);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition r10) {
        Intrinsics.checkNotNullParameter(r10, "transition");
        this.$onResume.invoke(r10);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition r10) {
        Intrinsics.checkNotNullParameter(r10, "transition");
        this.$onStart.invoke(r10);
    }
}
