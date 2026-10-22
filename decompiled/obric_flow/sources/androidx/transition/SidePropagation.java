package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed;
    private int mSide;

    public SidePropagation() {
        this.mPropagationSpeed = 3.0f;
        this.mSide = 80;
    }

    private int distance(View r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        int r18 = this.mSide;
        if (r18 != 8388611) goto L9;
        if (r5.getLayoutDirection() != 1) goto L7;
    L6:
        r18 = 5;
    L13:
        if (r18 == 3) goto L24;
        if (r18 == 5) goto L28;
        if (r18 == 48) goto L27;
        if (r18 == 80) goto L26;
        return 0;
    L26:
        return Math.abs(r12 - r10) + (r11 - r15);
    L27:
        return Math.abs(r12 - r10) + (r17 - r11);
    L28:
        return Math.abs(r13 - r11) + (r10 - r14);
    L24:
        return Math.abs(r13 - r11) + (r16 - r10);
    L7:
        r18 = 3;
        goto L13
    L9:
        if (r18 != 8388613) goto L13;
        if (r5.getLayoutDirection() != 1) goto L6;
        goto L6
    }

    private int getMaxDistance(ViewGroup r5) {
        int r10 = this.mSide;
        if (r10 == 3) goto L13;
        if (r10 == 5) goto L13;
        if (r10 == 8388611) goto L13;
        if (r10 == 8388613) goto L13;
        return r5.getHeight();
    L13:
        return r5.getWidth();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(@NonNull ViewGroup r17, @NonNull Transition r18, @Nullable TransitionValues r19, @Nullable TransitionValues r20) {
        TransitionValues r5 = r19;
        if (r5 != null) goto L6;
        if (r20 != null) goto L6;
        return 0;
    L6:
        Rect r10 = r18.getEpicenter();
        if (r20 != null) goto L9;
    L12:
        int r13 = -1;
    L13:
        int r11 = getViewX(r5);
        int r12 = getViewY(r5);
        int[] r14 = new int[2];
        r17.getLocationOnScreen(r14);
        int r15 = r14[0] + Math.round(r17.getTranslationX());
        int r16 = Math.round(r17.getTranslationY()) + r14[1];
        int r21 = r17.getWidth() + r15;
        int r22 = r17.getHeight() + r16;
        if (r10 == null) goto L16;
        int r23 = r10.centerX();
        int r110 = r10.centerY();
    L17:
        float r24 = distance(r17, r11, r12, r23, r110, r15, r16, r21, r22) / getMaxDistance(r17);
        long r25 = r18.getDuration();
        if (r25 >= 0) goto L21;
        r25 = 300;
    L21:
        return Math.round(((r25 * ((long) r13)) / this.mPropagationSpeed) * r24);
    L16:
        r23 = (r15 + r21) / 2;
        r110 = (r16 + r22) / 2;
        goto L17
    L9:
        if (getViewVisibility(r5) == 0) goto L12;
        r5 = r20;
        r13 = 1;
        goto L13
    }

    public void setPropagationSpeed(float r5) {
        if (r5 == 0.0f) goto L7;
        this.mPropagationSpeed = r5;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void setSide(int r5) {
        this.mSide = r5;
    }
}
