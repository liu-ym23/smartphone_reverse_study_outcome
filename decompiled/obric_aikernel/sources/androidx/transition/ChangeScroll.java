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

    public ChangeScroll(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    private void captureValues(TransitionValues r10) {
        r10.values.put(PROPNAME_SCROLL_X, Integer.valueOf(r10.view.getScrollX()));
        r10.values.put(PROPNAME_SCROLL_Y, Integer.valueOf(r10.view.getScrollY()));
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
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r10, @Nullable TransitionValues r11, @Nullable TransitionValues r12) {
        ObjectAnimator r13 = null;
        if (r11 == null) goto L14;
        if (r12 == null) goto L15;
        View r14 = r12.view;
        int r15 = ((Integer) r11.values.get(PROPNAME_SCROLL_X)).intValue();
        int r16 = ((Integer) r12.values.get(PROPNAME_SCROLL_X)).intValue();
        int r17 = ((Integer) r11.values.get(PROPNAME_SCROLL_Y)).intValue();
        int r18 = ((Integer) r12.values.get(PROPNAME_SCROLL_Y)).intValue();
        if (r15 == r16) goto L9;
        r14.setScrollX(r15);
        ObjectAnimator r19 = ObjectAnimator.ofInt(r14, "scrollX", new int[]{r15, r16});
    L10:
        if (r17 == r18) goto L13;
        r14.setScrollY(r17);
        r13 = ObjectAnimator.ofInt(r14, "scrollY", new int[]{r17, r18});
    L13:
        return TransitionUtils.mergeAnimators(r19, r13);
    L9:
        r19 = null;
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
}
