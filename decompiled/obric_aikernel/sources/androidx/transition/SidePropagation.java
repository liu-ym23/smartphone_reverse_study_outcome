package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed;
    private int mSide;

    public SidePropagation() {
        this.mPropagationSpeed = 3.0f;
        this.mSide = 80;
    }

    private int distance(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        int r19 = this.mSide;
        boolean r20 = true;
        if (r19 != 8388611) goto L12;
        if (ViewCompat.getLayoutDirection(r10) == 1) goto L8;
        r20 = false;
    L8:
        if (r20 == false) goto L10;
    L9:
        r19 = 5;
    L19:
        if (r19 == 3) goto L30;
        if (r19 == 5) goto L33;
        if (r19 == 48) goto L32;
        if (r19 == 80) goto L31;
        return 0;
    L31:
        return (r12 - r16) + Math.abs(r13 - r11);
    L32:
        return (r18 - r12) + Math.abs(r13 - r11);
    L33:
        return (r11 - r15) + Math.abs(r14 - r12);
    L30:
        return (r17 - r11) + Math.abs(r14 - r12);
    L10:
        r19 = 3;
        goto L19
    L12:
        if (r19 != 8388613) goto L19;
        if (ViewCompat.getLayoutDirection(r10) == 1) goto L17;
        r20 = false;
    L17:
        if (r20 == false) goto L9;
        goto L9
    }

    private int getMaxDistance(ViewGroup r10) {
        int r11 = this.mSide;
        if (r11 == 3) goto L13;
        if (r11 == 5) goto L13;
        if (r11 == 8388611) goto L13;
        if (r11 == 8388613) goto L13;
        return r10.getHeight();
    L13:
        return r10.getWidth();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup r17, Transition r18, TransitionValues r19, TransitionValues r20) {
        TransitionValues r10 = r19;
        if (r10 != null) goto L6;
        if (r20 != null) goto L6;
        return 0;
    L6:
        Rect r11 = r18.getEpicenter();
        if (r20 != null) goto L9;
    L12:
        int r13 = -1;
    L13:
        int r12 = getViewX(r10);
        int r14 = getViewY(r10);
        int[] r15 = new int[2];
        r17.getLocationOnScreen(r15);
        int r16 = r15[0] + Math.round(r17.getTranslationX());
        int r21 = r15[1] + Math.round(r17.getTranslationY());
        int r22 = r16 + r17.getWidth();
        int r23 = r21 + r17.getHeight();
        if (r11 == null) goto L16;
        int r24 = r11.centerX();
        int r110 = r11.centerY();
    L17:
        float r25 = distance(r17, r12, r14, r24, r110, r16, r21, r22, r23) / getMaxDistance(r17);
        long r26 = r18.getDuration();
        if (r26 >= 0) goto L21;
        r26 = 300;
    L21:
        return Math.round(((r26 * ((long) r13)) / this.mPropagationSpeed) * r25);
    L16:
        r24 = (r16 + r22) / 2;
        r110 = (r21 + r23) / 2;
        goto L17
    L9:
        if (getViewVisibility(r10) == 0) goto L12;
        r10 = r20;
        r13 = 1;
        goto L13
    }

    public void setPropagationSpeed(float r10) {
        if (r10 == 0.0f) goto L7;
        this.mPropagationSpeed = r10;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void setSide(int r10) {
        this.mSide = r10;
    }
}
