package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
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

    public static class MassState {
        float mValue;
        float mVelocity;

        public MassState() {
        }
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation r5, boolean r10, float r11, float r12);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation r5, float r10, float r11);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        public /* synthetic */ ViewProperty(String r5, AnonymousClass1 r10) {
            this(r5);
        }

        private ViewProperty(String r5) {
            super(r5);
        }
    }

    static {
        final String r5 = "translationX";
        TRANSLATION_X = new AnonymousClass1(r5);
        final String r10 = "translationY";
        TRANSLATION_Y = new AnonymousClass2(r10);
        final String r11 = "translationZ";
        TRANSLATION_Z = new AnonymousClass3(r11);
        final String r12 = "scaleX";
        SCALE_X = new AnonymousClass4(r12);
        final String r13 = "scaleY";
        SCALE_Y = new AnonymousClass5(r13);
        final String r14 = "rotation";
        ROTATION = new AnonymousClass6(r14);
        final String r15 = "rotationX";
        ROTATION_X = new AnonymousClass7(r15);
        final String r16 = "rotationY";
        ROTATION_Y = new AnonymousClass8(r16);
        final String r17 = "x";
        X = new AnonymousClass9(r17);
        final String r18 = "y";
        Y = new AnonymousClass10(r18);
        final String r19 = "z";
        Z = new AnonymousClass11(r19);
        final String r20 = "alpha";
        ALPHA = new AnonymousClass12(r20);
        final String r21 = "scrollX";
        SCROLL_X = new AnonymousClass13(r21);
        final String r22 = "scrollY";
        SCROLL_Y = new AnonymousClass14(r22);
    }

    public DynamicAnimation(final FloatValueHolder r5) {
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
        final String r10 = "FloatValueHolder";
        this.mProperty = new AnonymousClass15(this, r10, r5);
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean r5) {
        int r10 = 0;
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0;
        this.mStartValueIsSet = false;
    L4:
        if (r10 >= this.mEndListeners.size()) goto L9;
        if (this.mEndListeners.get(r10) == null) goto L8;
        this.mEndListeners.get(r10).onAnimationEnd(this, r5, this.mValue, this.mVelocity);
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> r5, T r10) {
        int r11 = r5.indexOf(r10);
        if (r11 < 0) goto L6;
        r5.set(r11, null);
        return;
    }

    private static <T> void removeNullEntries(ArrayList<T> r5) {
        int r10 = r5.size() - 1;
    L3:
        if (r10 < 0) goto L8;
        if (r5.get(r10) != null) goto L7;
        r5.remove(r10);
    L7:
        r10 = r10 - 1;
        goto L3
    }

    private void startAnimationInternal() {
        if (this.mRunning == true) goto L14;
        this.mRunning = true;
        if (this.mStartValueIsSet == true) goto L7;
        this.mValue = getPropertyValue();
    L7:
        float r5 = this.mValue;
        if (r5 > this.mMaxValue) goto L13;
        if (r5 < this.mMinValue) goto L13;
        AnimationHandler.getInstance().addAnimationFrameCallback(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public T addEndListener(OnAnimationEndListener r5) {
        if (this.mEndListeners.contains(r5) == true) goto L5;
        this.mEndListeners.add(r5);
    L5:
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener r5) {
        if (isRunning() == true) goto L9;
        if (this.mUpdateListeners.contains(r5) == true) goto L7;
        this.mUpdateListeners.add(r5);
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
    public boolean doAnimationFrame(long r5) {
        long r10 = this.mLastFrameTime;
        if (r10 != 0) goto L6;
        this.mLastFrameTime = r5;
        setPropertyValue(this.mValue);
        return false;
    L6:
        this.mLastFrameTime = r5;
        boolean r11 = updateValueAndVelocity(r5 - r10);
        float r12 = Math.min(this.mValue, this.mMaxValue);
        this.mValue = r12;
        float r13 = Math.max(r12, this.mMinValue);
        this.mValue = r13;
        setPropertyValue(r13);
        if (r11 == false) goto L9;
        endAnimationInternal(false);
    L9:
        return r11;
    }

    public abstract float getAcceleration(float r5, float r10);

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public abstract boolean isAtEquilibrium(float r5, float r10);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener r5) {
        removeEntry(this.mEndListeners, r5);
    }

    public void removeUpdateListener(OnAnimationUpdateListener r5) {
        removeEntry(this.mUpdateListeners, r5);
    }

    public T setMaxValue(float r5) {
        this.mMaxValue = r5;
        return this;
    }

    public T setMinValue(float r5) {
        this.mMinValue = r5;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float r5) {
        if (r5 <= 0.0f) goto L7;
        this.mMinVisibleChange = r5;
        setValueThreshold(r5 * 0.75f);
        return this;
    L7:
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public void setPropertyValue(float r5) {
        this.mProperty.setValue(this.mTarget, r5);
        int r10 = 0;
    L4:
        if (r10 >= this.mUpdateListeners.size()) goto L9;
        if (this.mUpdateListeners.get(r10) == null) goto L8;
        this.mUpdateListeners.get(r10).onAnimationUpdate(this, this.mValue, this.mVelocity);
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        removeNullEntries(this.mUpdateListeners);
    }

    public T setStartValue(float r5) {
        this.mValue = r5;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float r5) {
        this.mVelocity = r5;
        return this;
    }

    public abstract void setValueThreshold(float r5);

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

    public abstract boolean updateValueAndVelocity(long r5);

    public <K> DynamicAnimation(K r5, FloatPropertyCompat<K> r10) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = r5;
        this.mProperty = r10;
        if (r10 != ROTATION) goto L5;
    L19:
        this.mMinVisibleChange = 0.1f;
        return;
    L5:
        if (r10 == ROTATION_X) goto L19;
        if (r10 == ROTATION_Y) goto L19;
        if (r10 != ALPHA) goto L13;
        this.mMinVisibleChange = 0.00390625f;
        return;
    L13:
        if (r10 != SCALE_X) goto L15;
    L18:
        this.mMinVisibleChange = 0.00390625f;
        return;
    L15:
        if (r10 == SCALE_Y) goto L18;
        this.mMinVisibleChange = 1.0f;
    }
}
