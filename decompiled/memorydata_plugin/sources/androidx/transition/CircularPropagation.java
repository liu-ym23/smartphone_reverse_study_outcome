package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed;

    public CircularPropagation() {
        this.mPropagationSpeed = 3.0f;
    }

    private static float distance(float r0, float r1, float r2, float r3) {
        float r4 = r2 - r0;
        float r5 = r3 - r1;
        return (float) Math.sqrt((r4 * r4) + (r5 * r5));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup r9, Transition r10, TransitionValues r11, TransitionValues r12) {
        if (r11 != null) goto L7;
        if (r12 != null) goto L7;
        return 0;
    L7:
        if (r12 != null) goto L9;
    L12:
        int r13 = -1;
    L13:
        int r3 = getViewX(r11);
        int r14 = getViewY(r11);
        Rect r4 = r10.getEpicenter();
        if (r4 == null) goto L16;
        int r2 = r4.centerX();
        int r5 = r4.centerY();
    L17:
        float r15 = distance(r3, r14, r2, r5) / distance(0.0f, 0.0f, r9.getWidth(), r9.getHeight());
        long r16 = r10.getDuration();
        if (r16 >= 0) goto L21;
        r16 = 300;
    L21:
        return Math.round(((r16 * ((long) r13)) / this.mPropagationSpeed) * r15);
    L16:
        int[] r6 = new int[2];
        r9.getLocationOnScreen(r6);
        int r7 = Math.round((r6[0] + (r9.getWidth() / 2)) + r9.getTranslationX());
        r5 = Math.round((r6[1] + (r9.getHeight() / 2)) + r9.getTranslationY());
        r2 = r7;
        goto L17
    L9:
        if (getViewVisibility(r11) == 0) goto L12;
        r11 = r12;
        r13 = 1;
        goto L13
    }

    public void setPropagationSpeed(float r2) {
        if (r2 == 0.0f) goto L7;
        this.mPropagationSpeed = r2;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}
