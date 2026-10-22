package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = null;

    static {
        sTransitionProperties = new String[]{PROPNAME_CLIP};
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    private void captureValues(TransitionValues r10) {
        View r11 = r10.view;
        if (r11.getVisibility() != 8) goto L5;
        return;
    L5:
        Rect r12 = ViewCompat.getClipBounds(r11);
        r10.values.put(PROPNAME_CLIP, r12);
        if (r12 != null) goto L9;
        Rect r13 = new Rect(0, 0, r11.getWidth(), r11.getHeight());
        r10.values.put(PROPNAME_BOUNDS, r13);
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
    public Animator createAnimator(@NonNull ViewGroup r10, TransitionValues r11, TransitionValues r12) {
        ObjectAnimator r13 = null;
        if (r11 == null) goto L28;
        if (r12 == null) goto L28;
        if (r11.values.containsKey(PROPNAME_CLIP) == false) goto L28;
        if (r12.values.containsKey(PROPNAME_CLIP) == false) goto L28;
        Rect r14 = (Rect) r11.values.get(PROPNAME_CLIP);
        Rect r15 = (Rect) r12.values.get(PROPNAME_CLIP);
        if (r15 != null) goto L13;
        boolean r16 = true;
    L14:
        if (r14 != null) goto L18;
        if (r15 != null) goto L18;
        return null;
    L18:
        if (r14 != null) goto L20;
        r14 = (Rect) r11.values.get(PROPNAME_BOUNDS);
    L23:
        if (r14.equals(r15) == false) goto L25;
        return null;
    L25:
        ViewCompat.setClipBounds(r12.view, r14);
        r13 = ObjectAnimator.ofObject(r12.view, ViewUtils.CLIP_BOUNDS, new RectEvaluator(new Rect()), new Rect[]{r14, r15});
        if (r16 == false) goto L28;
        final View r17 = r12.view;
        r13.addListener(new AnonymousClass1(this, r17));
        goto L28
    L20:
        if (r15 != null) goto L23;
        r15 = (Rect) r12.values.get(PROPNAME_BOUNDS);
        goto L23
    L13:
        r16 = false;
    L28:
        return r13;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
