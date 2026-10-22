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

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TextView f3367c;

        a(TextScale r10, TextView r11) {
            this.f3367c = r11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f3367c.setScaleX(r11);
            this.f3367c.setScaleY(r11);
        }
    }

    public TextScale() {
    }

    private void captureValues(@NonNull TransitionValues r10) {
        View r11 = r10.view;
        if ((r11 instanceof TextView) == false) goto L6;
        r10.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) r11).getScaleX()));
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        if (r11 == null) goto L22;
        if (r12 != null) goto L6;
        return null;
    L6:
        if ((r11.view instanceof TextView) == false) goto L24;
        View r13 = r12.view;
        if ((r13 instanceof TextView) == false) goto L25;
        TextView r14 = (TextView) r13;
        Map<String, Object> r15 = r11.values;
        Map<String, Object> r16 = r12.values;
        float r17 = 1.0f;
        if (r15.get(PROPNAME_SCALE) == null) goto L13;
        float r18 = ((Float) r15.get(PROPNAME_SCALE)).floatValue();
    L15:
        if (r16.get(PROPNAME_SCALE) == null) goto L18;
        r17 = ((Float) r16.get(PROPNAME_SCALE)).floatValue();
    L18:
        if (r18 != r17) goto L20;
        return null;
    L20:
        ValueAnimator r19 = ValueAnimator.ofFloat(new float[]{r18, r17});
        r19.addUpdateListener(new a(this, r14));
        return r19;
    L13:
        r18 = 1.0f;
        goto L15
    L25:
        return null;
    L24:
        return null;
    L22:
        return null;
    }
}
