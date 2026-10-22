package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ChangeScroll extends Transition {
    private static final String[] PROPERTIES = null;
    private static final String PROPNAME_SCROLL_X = "android:changeScroll:x";
    private static final String PROPNAME_SCROLL_Y = "android:changeScroll:y";

    static {
        PROPERTIES = new String[]{PROPNAME_SCROLL_X, PROPNAME_SCROLL_Y};
    }

    public ChangeScroll() {
    }

    private void captureValues(TransitionValues r5) {
        r5.values.put(PROPNAME_SCROLL_X, Integer.valueOf(r5.view.getScrollX()));
        r5.values.put(PROPNAME_SCROLL_Y, Integer.valueOf(r5.view.getScrollY()));
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
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r5, @Nullable TransitionValues r10, @Nullable TransitionValues r11) {
        ObjectAnimator r12 = null;
        if (r10 == null) goto L14;
        if (r11 == null) goto L15;
        View r13 = r11.view;
        int r14 = ((Integer) r10.values.get(PROPNAME_SCROLL_X)).intValue();
        int r15 = ((Integer) r11.values.get(PROPNAME_SCROLL_X)).intValue();
        int r16 = ((Integer) r10.values.get(PROPNAME_SCROLL_Y)).intValue();
        int r17 = ((Integer) r11.values.get(PROPNAME_SCROLL_Y)).intValue();
        if (r14 == r15) goto L9;
        r13.setScrollX(r14);
        ObjectAnimator r18 = ObjectAnimator.ofInt(r13, "scrollX", new int[]{r14, r15});
    L10:
        if (r16 == r17) goto L13;
        r13.setScrollY(r16);
        r12 = ObjectAnimator.ofInt(r13, "scrollY", new int[]{r16, r17});
    L13:
        return TransitionUtils.mergeAnimators(r18, r12);
    L9:
        r18 = null;
        goto L10
    L15:
        return null;
    L14:
        return null;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return PROPERTIES;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeScroll(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
    }
}
