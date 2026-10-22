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
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    public Explode(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float r0, float r1) {
        return (float) Math.sqrt((r0 * r0) + (r1 * r1));
    }

    private static float calculateMaxDistance(View r1, int r2, int r3) {
        return calculateDistance(Math.max(r2, r1.getWidth() - r2), Math.max(r3, r1.getHeight() - r3));
    }

    private void calculateOut(View r13, Rect r14, int[] r15) {
        r13.getLocationOnScreen(this.mTempLoc);
        int[] r0 = this.mTempLoc;
        int r2 = r0[0];
        int r1 = r0[1];
        Rect r12 = getEpicenter();
        if (r12 != null) goto L5;
        int r16 = ((r13.getWidth() / 2) + r2) + Math.round(r13.getTranslationX());
        int r4 = ((r13.getHeight() / 2) + r1) + Math.round(r13.getTranslationY());
    L6:
        float r5 = r14.centerX() - r16;
        float r17 = r14.centerY() - r4;
        if (r5 == 0.0f) goto L9;
    L11:
        float r6 = calculateDistance(r5, r17);
        float r18 = calculateMaxDistance(r13, r16 - r2, r4 - r1);
        r15[0] = Math.round((r5 / r6) * r18);
        r15[1] = Math.round(r18 * (r17 / r6));
        return;
    L9:
        if (r17 != 0.0f) goto L11;
        r5 = ((float) (Math.random() * 2.0d)) - 1.0f;
        r17 = ((float) (Math.random() * 2.0d)) - 1.0f;
        goto L11
    L5:
        int r7 = r12.centerX();
        r4 = r12.centerY();
        r16 = r7;
        goto L6
    }

    private void captureValues(TransitionValues r5) {
        View r0 = r5.view;
        r0.getLocationOnScreen(this.mTempLoc);
        int[] r4 = this.mTempLoc;
        int r1 = r4[0];
        int r6 = r4[1];
        int r2 = r0.getWidth() + r1;
        int r3 = r0.getHeight() + r6;
        r5.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(r1, r6, r2, r3));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(TransitionValues r1) {
        super.captureEndValues(r1);
        captureValues(r1);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues r1) {
        super.captureStartValues(r1);
        captureValues(r1);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r11, View r12, TransitionValues r13, TransitionValues r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        Rect r15 = (Rect) ZeusTransformUtils.preCheckCast(r14.values.get(PROPNAME_SCREEN_BOUNDS), Rect.class, "com.obric.memorydata.plugin");
        float r6 = r12.getTranslationX();
        float r7 = r12.getTranslationY();
        calculateOut(r11, r15, this.mTempLoc);
        int[] r16 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r12, r14, r15.left, r15.top, r6 + r16[0], r7 + r16[1], r6, r7, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r14, View r15, TransitionValues r16, TransitionValues r17) {
        if (r16 != null) goto L6;
        return null;
    L6:
        Rect r2 = (Rect) ZeusTransformUtils.preCheckCast(r16.values.get(PROPNAME_SCREEN_BOUNDS), Rect.class, "com.obric.memorydata.plugin");
        int r3 = r2.left;
        int r5 = r2.top;
        float r6 = r15.getTranslationX();
        float r7 = r15.getTranslationY();
        int[] r0 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r16.view.getTag(ZeusTransformUtils.mapRes(R.id.transition_position, OaidModel.KEY_ID, "transition_position")), int[].class, "com.obric.memorydata.plugin"), int[].class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        float r10 = (r0[0] - r2.left) + r6;
        float r11 = (r0[1] - r2.top) + r7;
        r2.offsetTo(r0[0], r0[1]);
    L10:
        calculateOut(r14, r2, this.mTempLoc);
        int[] r1 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r15, r16, r3, r5, r6, r7, r10 + r1[0], r11 + r1[1], sAccelerate, this);
    L9:
        r10 = r6;
        r11 = r7;
        goto L10
    }
}
