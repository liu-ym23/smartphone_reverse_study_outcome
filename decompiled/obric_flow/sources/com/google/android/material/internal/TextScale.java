package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public TextScale() {
    }

    private void captureValues(@NonNull TransitionValues r5) {
        View r10 = r5.view;
        if ((r10 instanceof TextView) == false) goto L6;
        r5.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) r10).getScaleX()));
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        captureValues(r5);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        captureValues(r5);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup r5, @Nullable TransitionValues r10, @Nullable TransitionValues r11) {
        if (r10 == null) goto L22;
        if (r11 != null) goto L6;
        return null;
    L6:
        if ((r10.view instanceof TextView) == false) goto L24;
        View r12 = r11.view;
        if ((r12 instanceof TextView) == false) goto L25;
        final TextView r13 = (TextView) r12;
        Map<String, Object> r14 = r10.values;
        Map<String, Object> r15 = r11.values;
        float r16 = 1.0f;
        if (r14.get(PROPNAME_SCALE) == null) goto L13;
        float r17 = ((Float) r14.get(PROPNAME_SCALE)).floatValue();
    L15:
        if (r15.get(PROPNAME_SCALE) == null) goto L18;
        r16 = ((Float) r15.get(PROPNAME_SCALE)).floatValue();
    L18:
        if (r17 != r16) goto L20;
        return null;
    L20:
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{r17, r16});
        r18.addUpdateListener(new AnonymousClass1(this, r13));
        return r18;
    L13:
        r17 = 1.0f;
        goto L15
    L25:
        return null;
    L24:
        return null;
    L22:
        return null;
    }
}
