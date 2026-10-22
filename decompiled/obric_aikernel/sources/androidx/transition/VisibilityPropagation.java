package androidx.transition;

import android.view.View;

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

    private static int getViewCoordinate(TransitionValues r10, int r11) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        int[] r12 = (int[]) r10.values.get(PROPNAME_VIEW_CENTER);
        if (r12 != null) goto L9;
        return -1;
    L9:
        return r12[r11];
    }

    @Override // androidx.transition.TransitionPropagation
    public void captureValues(TransitionValues r10) {
        View r11 = r10.view;
        Integer r12 = (Integer) r10.values.get("android:visibility:visibility");
        if (r12 != null) goto L5;
        r12 = Integer.valueOf(r11.getVisibility());
    L5:
        r10.values.put(PROPNAME_VISIBILITY, r12);
        int[] r13 = new int[2];
        r11.getLocationOnScreen(r13);
        r13[0] = r13[0] + Math.round(r11.getTranslationX());
        r13[0] = r13[0] + (r11.getWidth() / 2);
        r13[1] = r13[1] + Math.round(r11.getTranslationY());
        r13[1] = r13[1] + (r11.getHeight() / 2);
        r10.values.put(PROPNAME_VIEW_CENTER, r13);
    }

    @Override // androidx.transition.TransitionPropagation
    public String[] getPropagationProperties() {
        return VISIBILITY_PROPAGATION_VALUES;
    }

    public int getViewVisibility(TransitionValues r10) {
        if (r10 != null) goto L5;
        return 8;
    L5:
        Integer r11 = (Integer) r10.values.get(PROPNAME_VISIBILITY);
        if (r11 != null) goto L9;
        return 8;
    L9:
        return r11.intValue();
    }

    public int getViewX(TransitionValues r10) {
        return getViewCoordinate(r10, 0);
    }

    public int getViewY(TransitionValues r10) {
        return getViewCoordinate(r10, 1);
    }
}
