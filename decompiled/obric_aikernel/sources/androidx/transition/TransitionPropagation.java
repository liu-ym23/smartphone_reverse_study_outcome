package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionPropagation {
    public TransitionPropagation() {
    }

    public abstract void captureValues(TransitionValues r10);

    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(ViewGroup r10, Transition r11, TransitionValues r12, TransitionValues r13);
}
