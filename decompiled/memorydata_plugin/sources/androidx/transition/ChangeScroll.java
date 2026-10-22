package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public ChangeScroll(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    private void captureValues(TransitionValues r3) {
        r3.values.put(PROPNAME_SCROLL_X, Integer.valueOf(r3.view.getScrollX()));
        r3.values.put(PROPNAME_SCROLL_Y, Integer.valueOf(r3.view.getScrollY()));
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
    public Animator createAnimator(ViewGroup r7, TransitionValues r8, TransitionValues r9) {
        ObjectAnimator r6 = null;
        if (r8 == null) goto L14;
        if (r9 == null) goto L15;
        View r10 = r9.view;
        int r0 = ((Integer) ZeusTransformUtils.preCheckCast(r8.values.get(PROPNAME_SCROLL_X), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r9.values.get(PROPNAME_SCROLL_X), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r11 = ((Integer) ZeusTransformUtils.preCheckCast(r8.values.get(PROPNAME_SCROLL_Y), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r12 = ((Integer) ZeusTransformUtils.preCheckCast(r9.values.get(PROPNAME_SCROLL_Y), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r0 == r1) goto L9;
        r10.setScrollX(r0);
        ObjectAnimator r2 = ObjectAnimator.ofInt(r10, "scrollX", new int[]{r0, r1});
    L10:
        if (r11 == r12) goto L13;
        r10.setScrollY(r11);
        r6 = ObjectAnimator.ofInt(r10, "scrollY", new int[]{r11, r12});
    L13:
        return TransitionUtils.mergeAnimators(r2, r6);
    L9:
        r2 = null;
        goto L10
    L15:
        return null;
    L14:
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return PROPERTIES;
    }
}
