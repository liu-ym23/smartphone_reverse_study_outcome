package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public TextScale() {
    }

    private void captureValues(TransitionValues r3) {
        if (ZeusTransformUtils.instanceOf(r3.view, TextView.class) == false) goto L6;
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r3.view, TextView.class, "com.obric.memorydata.plugin");
        r3.values.put(PROPNAME_SCALE, Float.valueOf(r2.getScaleX()));
        return;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r6, TransitionValues r7, TransitionValues r8) {
        if (r7 == null) goto L22;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r7.view, TextView.class) == true) goto L8;
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r8.view, TextView.class) == false) goto L25;
        final TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(r8.view, TextView.class, "com.obric.memorydata.plugin");
        Map<String, Object> r9 = r7.values;
        Map<String, Object> r10 = r8.values;
        float r4 = 1.0f;
        if (r9.get(PROPNAME_SCALE) == null) goto L13;
        float r11 = ((Float) ZeusTransformUtils.preCheckCast(r9.get(PROPNAME_SCALE), Float.class, "com.obric.memorydata.plugin")).floatValue();
    L15:
        if (r10.get(PROPNAME_SCALE) == null) goto L18;
        r4 = ((Float) ZeusTransformUtils.preCheckCast(r10.get(PROPNAME_SCALE), Float.class, "com.obric.memorydata.plugin")).floatValue();
    L18:
        if (r11 != r4) goto L20;
        return null;
    L20:
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{r11, r4});
        r12.addUpdateListener(new AnonymousClass1(this, r0));
        return r12;
    L13:
        r11 = 1.0f;
        goto L15
    L25:
        return null;
    L22:
        return null;
    }
}
