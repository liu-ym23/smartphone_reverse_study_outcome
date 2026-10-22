package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate = null;
    private static final TimeInterpolator sDecelerate = null;
    private int[] mTempLoc;

    static {
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
    }

    public Explode() {
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float r5, float r10) {
        return (float) Math.sqrt((r10 * r10) + (r5 * r5));
    }

    private static float calculateMaxDistance(View r5, int r10, int r11) {
        return calculateDistance(Math.max(r10, r5.getWidth() - r10), Math.max(r11, r5.getHeight() - r11));
    }

    private void calculateOut(View r11, Rect r12, int[] r13) {
        r11.getLocationOnScreen(this.mTempLoc);
        int[] r5 = this.mTempLoc;
        int r10 = r5[0];
        int r14 = r5[1];
        Rect r15 = getEpicenter();
        if (r15 != null) goto L5;
        int r16 = Math.round(r11.getTranslationX()) + ((r11.getWidth() / 2) + r10);
        int r17 = Math.round(r11.getTranslationY()) + ((r11.getHeight() / 2) + r14);
    L6:
        float r18 = r12.centerX() - r16;
        float r19 = r12.centerY() - r17;
        if (r18 == 0.0f) goto L9;
    L11:
        float r20 = calculateDistance(r18, r19);
        float r110 = calculateMaxDistance(r11, r16 - r10, r17 - r14);
        r13[0] = Math.round((r18 / r20) * r110);
        r13[1] = Math.round(r110 * (r19 / r20));
        return;
    L9:
        if (r19 != 0.0f) goto L11;
        r18 = ((float) (Math.random() * 2.0d)) - 1.0f;
        r19 = ((float) (Math.random() * 2.0d)) - 1.0f;
        goto L11
    L5:
        r16 = r15.centerX();
        r17 = r15.centerY();
        goto L6
    }

    private void captureValues(TransitionValues r5) {
        View r10 = r5.view;
        r10.getLocationOnScreen(this.mTempLoc);
        int[] r11 = this.mTempLoc;
        int r12 = r11[0];
        int r13 = r11[1];
        int r14 = r10.getWidth() + r12;
        int r15 = r10.getHeight() + r13;
        r5.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(r12, r13, r14, r15));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r5) {
        super.captureEndValues(r5);
        captureValues(r5);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r5) {
        super.captureStartValues(r5);
        captureValues(r5);
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    @Override // androidx.transition.Visibility
    @Nullable
    public Animator onAppear(@NonNull ViewGroup r11, @NonNull View r12, @Nullable TransitionValues r13, @Nullable TransitionValues r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        Rect r15 = (Rect) r14.values.get(PROPNAME_SCREEN_BOUNDS);
        float r10 = r12.getTranslationX();
        float r16 = r12.getTranslationY();
        calculateOut(r11, r15, this.mTempLoc);
        int[] r17 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r12, r14, r15.left, r15.top, r10 + r17[0], r16 + r17[1], r10, r16, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    @Nullable
    public Animator onDisappear(@NonNull ViewGroup r11, @NonNull View r12, @Nullable TransitionValues r13, @Nullable TransitionValues r14) {
        if (r13 != null) goto L5;
        return null;
    L5:
        Rect r15 = (Rect) r13.values.get(PROPNAME_SCREEN_BOUNDS);
        int r5 = r15.left;
        int r10 = r15.top;
        float r16 = r12.getTranslationX();
        float r17 = r12.getTranslationY();
        int[] r18 = (int[]) r13.view.getTag(R.id.transition_position);
        if (r18 == null) goto L8;
        int r19 = r18[0];
        float r20 = (r19 - r15.left) + r16;
        int r21 = r18[1];
        float r22 = (r21 - r15.top) + r17;
        r15.offsetTo(r19, r21);
    L9:
        calculateOut(r11, r15, this.mTempLoc);
        int[] r110 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r12, r13, r5, r10, r16, r17, r20 + r110[0], r22 + r110[1], sAccelerate, this);
    L8:
        r20 = r16;
        r22 = r17;
        goto L9
    }

    public Explode(@NonNull Context r5, @NonNull AttributeSet r10) {
        super(r5, r10);
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }
}
