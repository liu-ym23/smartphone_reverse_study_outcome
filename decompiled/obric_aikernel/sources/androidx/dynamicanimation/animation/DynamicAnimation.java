package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.Key;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final ViewProperty ALPHA = null;
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION = null;
    public static final ViewProperty ROTATION_X = null;
    public static final ViewProperty ROTATION_Y = null;
    public static final ViewProperty SCALE_X = null;
    public static final ViewProperty SCALE_Y = null;
    public static final ViewProperty SCROLL_X = null;
    public static final ViewProperty SCROLL_Y = null;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final ViewProperty TRANSLATION_X = null;
    public static final ViewProperty TRANSLATION_Y = null;
    public static final ViewProperty TRANSLATION_Z = null;
    private static final float UNSET = Float.MAX_VALUE;
    public static final ViewProperty X = null;
    public static final ViewProperty Y = null;
    public static final ViewProperty Z = null;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;

    static class MassState {
        float mValue;
        float mVelocity;

        MassState() {
        }
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation r10, boolean r11, float r12, float r13);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation r10, float r11, float r12);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String r10) {
            super(r10);
        }

        /* synthetic */ ViewProperty(String r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    static {
        final String r10 = "translationX";
        TRANSLATION_X = new AnonymousClass1(r10);
        final String r11 = "translationY";
        TRANSLATION_Y = new AnonymousClass2(r11);
        final String r12 = "translationZ";
        TRANSLATION_Z = new AnonymousClass3(r12);
        final String r13 = "scaleX";
        SCALE_X = new AnonymousClass4(r13);
        final String r14 = "scaleY";
        SCALE_Y = new AnonymousClass5(r14);
        final String r15 = Key.ROTATION;
        ROTATION = new AnonymousClass6(r15);
        final String r16 = "rotationX";
        ROTATION_X = new AnonymousClass7(r16);
        final String r17 = "rotationY";
        ROTATION_Y = new AnonymousClass8(r17);
        final String r18 = "x";
        X = new AnonymousClass9(r18);
        final String r19 = "y";
        Y = new AnonymousClass10(r19);
        final String r20 = "z";
        Z = new AnonymousClass11(r20);
        final String r21 = "alpha";
        ALPHA = new AnonymousClass12(r21);
        final String r22 = "scrollX";
        SCROLL_X = new AnonymousClass13(r22);
        final String r23 = "scrollY";
        SCROLL_Y = new AnonymousClass14(r23);
    }

    DynamicAnimation(final FloatValueHolder r10) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = null;
        final String r11 = "FloatValueHolder";
        this.mProperty = new AnonymousClass15(this, r11, r10);
        this.mMinVisibleChange = 1.0f;
    }

    <K> DynamicAnimation(K r10, FloatPropertyCompat<K> r11) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = r10;
        this.mProperty = r11;
        if (r11 != ROTATION) goto L5;
    L18:
        float r12 = 0.1f;
    L19:
        this.mMinVisibleChange = r12;
        return;
    L5:
        if (r11 == ROTATION_X) goto L18;
        if (r11 == ROTATION_Y) goto L18;
        if (r11 != ALPHA) goto L13;
    L11:
        this.mMinVisibleChange = 0.00390625f;
        return;
    L13:
        if (r11 == SCALE_X) goto L11;
        if (r11 == SCALE_Y) goto L11;
        r12 = 1.0f;
        goto L19
    }

    private void endAnimationInternal(boolean r10) {
        int r11 = 0;
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0;
        this.mStartValueIsSet = false;
    L4:
        if (r11 >= this.mEndListeners.size()) goto L9;
        if (this.mEndListeners.get(r11) == null) goto L8;
        this.mEndListeners.get(r11).onAnimationEnd(this, r10, this.mValue, this.mVelocity);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> r10, T r11) {
        int r12 = r10.indexOf(r11);
        if (r12 < 0) goto L6;
        r10.set(r12, null);
        return;
    }

    private static <T> void removeNullEntries(ArrayList<T> r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r10.get(r11) != null) goto L7;
        r10.remove(r11);
    L7:
        r11 = r11 - 1;
        goto L3
    }

    private void startAnimationInternal() {
        if (this.mRunning == true) goto L14;
        this.mRunning = true;
        if (this.mStartValueIsSet == true) goto L7;
        this.mValue = getPropertyValue();
    L7:
        float r10 = this.mValue;
        if (r10 > this.mMaxValue) goto L13;
        if (r10 < this.mMinValue) goto L13;
        AnimationHandler.getInstance().addAnimationFrameCallback(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public T addEndListener(OnAnimationEndListener r10) {
        if (this.mEndListeners.contains(r10) == true) goto L5;
        this.mEndListeners.add(r10);
    L5:
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener r10) {
        if (isRunning() == true) goto L9;
        if (this.mUpdateListeners.contains(r10) == true) goto L7;
        this.mUpdateListeners.add(r10);
    L7:
        return this;
    L9:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.mRunning == false) goto L10;
        endAnimationInternal(true);
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long r10) {
        long r11 = this.mLastFrameTime;
        if (r11 != 0) goto L6;
        this.mLastFrameTime = r10;
        setPropertyValue(this.mValue);
        return false;
    L6:
        this.mLastFrameTime = r10;
        boolean r12 = updateValueAndVelocity(r10 - r11);
        float r13 = Math.min(this.mValue, this.mMaxValue);
        this.mValue = r13;
        float r14 = Math.max(r13, this.mMinValue);
        this.mValue = r14;
        setPropertyValue(r14);
        if (r12 == false) goto L9;
        endAnimationInternal(false);
    L9:
        return r12;
    }

    abstract float getAcceleration(float r10, float r11);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    abstract boolean isAtEquilibrium(float r10, float r11);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener r10) {
        removeEntry(this.mEndListeners, r10);
    }

    public void removeUpdateListener(OnAnimationUpdateListener r10) {
        removeEntry(this.mUpdateListeners, r10);
    }

    public T setMaxValue(float r10) {
        this.mMaxValue = r10;
        return this;
    }

    public T setMinValue(float r10) {
        this.mMinValue = r10;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float r10) {
        if (r10 <= 0.0f) goto L7;
        this.mMinVisibleChange = r10;
        setValueThreshold(r10 * 0.75f);
        return this;
    L7:
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    void setPropertyValue(float r10) {
        this.mProperty.setValue(this.mTarget, r10);
        int r11 = 0;
    L4:
        if (r11 >= this.mUpdateListeners.size()) goto L9;
        if (this.mUpdateListeners.get(r11) == null) goto L8;
        this.mUpdateListeners.get(r11).onAnimationUpdate(this, this.mValue, this.mVelocity);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float r10) {
        this.mValue = r10;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float r10) {
        this.mVelocity = r10;
        return this;
    }

    abstract void setValueThreshold(float r10);

    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.mRunning == true) goto L10;
        startAnimationInternal();
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    abstract boolean updateValueAndVelocity(long r10);
}
