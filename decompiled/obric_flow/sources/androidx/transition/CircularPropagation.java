package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed;

    public CircularPropagation() {
        this.mPropagationSpeed = 3.0f;
    }

    private static float distance(float r5, float r10, float r11, float r12) {
        float r13 = r11 - r5;
        float r14 = r12 - r10;
        return (float) Math.sqrt((r14 * r14) + (r13 * r13));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(@NonNull ViewGroup r10, @NonNull Transition r11, @Nullable TransitionValues r12, @Nullable TransitionValues r13) {
        if (r12 != null) goto L7;
        if (r13 != null) goto L7;
        return 0;
    L7:
        if (r13 != null) goto L9;
    L12:
        int r14 = -1;
    L13:
        int r5 = getViewX(r12);
        int r15 = getViewY(r12);
        Rect r16 = r11.getEpicenter();
        if (r16 == null) goto L16;
        int r17 = r16.centerX();
        int r18 = r16.centerY();
    L17:
        float r19 = distance(r5, r15, r17, r18) / distance(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
        long r20 = r11.getDuration();
        if (r20 >= 0) goto L21;
        r20 = 300;
    L21:
        return Math.round(((r20 * ((long) r14)) / this.mPropagationSpeed) * r19);
    L16:
        int[] r21 = new int[2];
        r10.getLocationOnScreen(r21);
        int r22 = Math.round(r10.getTranslationX() + ((r10.getWidth() / 2) + r21[0]));
        r18 = Math.round(r10.getTranslationY() + ((r10.getHeight() / 2) + r21[1]));
        r17 = r22;
        goto L17
    L9:
        if (getViewVisibility(r12) == 0) goto L12;
        r12 = r13;
        r14 = 1;
        goto L13
    }

    public void setPropagationSpeed(float r5) {
        if (r5 == 0.0f) goto L7;
        this.mPropagationSpeed = r5;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}
