package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {
    private static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    private static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    private static final String[] VISIBILITY_PROPAGATION_VALUES = null;

    static {
        VISIBILITY_PROPAGATION_VALUES = new String[]{PROPNAME_VISIBILITY, PROPNAME_VIEW_CENTER};
    }

    public VisibilityPropagation() {
    }

    private static int getViewCoordinate(@Nullable TransitionValues r5, int r10) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        int[] r11 = (int[]) r5.values.get(PROPNAME_VIEW_CENTER);
        if (r11 != null) goto L9;
        return -1;
    L9:
        return r11[r10];
    }

    @Override // androidx.transition.TransitionPropagation
    public void captureValues(@NonNull TransitionValues r10) {
        View r5 = r10.view;
        Integer r11 = (Integer) r10.values.get("android:visibility:visibility");
        if (r11 != null) goto L5;
        r11 = Integer.valueOf(r5.getVisibility());
    L5:
        r10.values.put(PROPNAME_VISIBILITY, r11);
        int[] r12 = {r4, 0};
        r5.getLocationOnScreen(r12);
        int r13 = Math.round(r5.getTranslationX()) + r12[0];
        r12[0] = (r5.getWidth() / 2) + r13;
        int r14 = Math.round(r5.getTranslationY()) + r12[1];
        r12[1] = r14;
        r12[1] = (r5.getHeight() / 2) + r14;
        r10.values.put(PROPNAME_VIEW_CENTER, r12);
    }

    @Override // androidx.transition.TransitionPropagation
    @Nullable
    public String[] getPropagationProperties() {
        return VISIBILITY_PROPAGATION_VALUES;
    }

    public int getViewVisibility(@Nullable TransitionValues r5) {
        if (r5 != null) goto L5;
        return 8;
    L5:
        Integer r10 = (Integer) r5.values.get(PROPNAME_VISIBILITY);
        if (r10 != null) goto L9;
        return 8;
    L9:
        return r10.intValue();
    }

    public int getViewX(@Nullable TransitionValues r5) {
        return getViewCoordinate(r5, 0);
    }

    public int getViewY(@Nullable TransitionValues r5) {
        return getViewCoordinate(r5, 1);
    }
}
