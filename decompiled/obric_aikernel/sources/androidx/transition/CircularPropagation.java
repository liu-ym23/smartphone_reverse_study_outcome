package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed;

    public CircularPropagation() {
        this.mPropagationSpeed = 3.0f;
    }

    private static float distance(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        return (float) Math.sqrt((r14 * r14) + (r15 * r15));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup r10, Transition r11, TransitionValues r12, TransitionValues r13) {
        if (r12 != null) goto L7;
        if (r13 != null) goto L7;
        return 0;
    L7:
        if (r13 != null) goto L9;
    L12:
        int r14 = -1;
    L13:
        int r15 = getViewX(r12);
        int r16 = getViewY(r12);
        Rect r17 = r11.getEpicenter();
        if (r17 == null) goto L16;
        int r18 = r17.centerX();
        int r19 = r17.centerY();
    L17:
        float r110 = distance(r15, r16, r18, r19) / distance(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
        long r20 = r11.getDuration();
        if (r20 >= 0) goto L21;
        r20 = 300;
    L21:
        return Math.round(((r20 * ((long) r14)) / this.mPropagationSpeed) * r110);
    L16:
        int[] r21 = new int[2];
        r10.getLocationOnScreen(r21);
        int r22 = Math.round((r21[0] + (r10.getWidth() / 2)) + r10.getTranslationX());
        r19 = Math.round((r21[1] + (r10.getHeight() / 2)) + r10.getTranslationY());
        r18 = r22;
        goto L17
    L9:
        if (getViewVisibility(r12) == 0) goto L12;
        r12 = r13;
        r14 = 1;
        goto L13
    }

    public void setPropagationSpeed(float r10) {
        if (r10 == 0.0f) goto L7;
        this.mPropagationSpeed = r10;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}
