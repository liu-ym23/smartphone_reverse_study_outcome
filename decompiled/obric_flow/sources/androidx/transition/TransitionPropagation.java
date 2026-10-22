package androidx.transition;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionPropagation {
    public TransitionPropagation() {
    }

    public abstract void captureValues(@NonNull TransitionValues r5);

    @Nullable
    @SuppressLint({"NullableCollection"})
    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(@NonNull ViewGroup r5, @NonNull Transition r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12);
}
