package com.larus.utils;

import android.transition.Transition;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements Transition.TransitionListener {
    public final /* synthetic */ Function0 a;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition r1) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition r1) {
    }

    public c(Function0 r1) {
        this.a = r1;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition r1) {
        this.a.invoke();
    }
}
