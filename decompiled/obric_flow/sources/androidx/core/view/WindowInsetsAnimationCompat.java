package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.google.android.material.color.utilities.Contrast;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private Impl mImpl;

    public static final class BoundsCompat {
        private final Insets mLowerBound;
        private final Insets mUpperBound;

        public BoundsCompat(@NonNull Insets r5, @NonNull Insets r10) {
            this.mLowerBound = r5;
            this.mUpperBound = r10;
        }

        @NonNull
        @RequiresApi(30)
        public static BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation.Bounds r5) {
            return new BoundsCompat(r5);
        }

        @NonNull
        public Insets getLowerBound() {
            return this.mLowerBound;
        }

        @NonNull
        public Insets getUpperBound() {
            return this.mUpperBound;
        }

        @NonNull
        public BoundsCompat inset(@NonNull Insets r10) {
            return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, r10.left, r10.top, r10.right, r10.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, r10.left, r10.top, r10.right, r10.bottom));
        }

        @NonNull
        @RequiresApi(30)
        public WindowInsetsAnimation.Bounds toBounds() {
            return Impl30.createPlatformBounds(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }

        @RequiresApi(30)
        private BoundsCompat(@NonNull WindowInsetsAnimation.Bounds r5) {
            this.mLowerBound = Impl30.getLowerBounds(r5);
            this.mUpperBound = Impl30.getHigherBounds(r5);
        }
    }

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DispatchMode {
        }

        public Callback(int r5) {
            this.mDispatchMode = r5;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(@NonNull WindowInsetsAnimationCompat r5) {
        }

        public void onPrepare(@NonNull WindowInsetsAnimationCompat r5) {
        }

        @NonNull
        public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat r5, @NonNull List<WindowInsetsAnimationCompat> r10);

        @NonNull
        public BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat r5, @NonNull BoundsCompat r10) {
            return r10;
        }
    }

    public static class Impl {
        private float mAlpha;
        private final long mDurationMillis;
        private float mFraction;

        @Nullable
        private final Interpolator mInterpolator;
        private final int mTypeMask;

        public Impl(int r5, @Nullable Interpolator r10, long r11) {
            this.mTypeMask = r5;
            this.mInterpolator = r10;
            this.mDurationMillis = r11;
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public float getInterpolatedFraction() {
            Interpolator r5 = this.mInterpolator;
            if (r5 == null) goto L7;
            return r5.getInterpolation(this.mFraction);
        L7:
            return this.mFraction;
        }

        @Nullable
        public Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float r5) {
            this.mAlpha = r5;
        }

        public void setFraction(float r5) {
            this.mFraction = r5;
        }
    }

    @RequiresApi(21)
    public static class Impl21 extends Impl {
        private static final Interpolator DEFAULT_INSET_INTERPOLATOR = null;
        private static final Interpolator HIDE_IME_INTERPOLATOR = null;
        private static final Interpolator SHOW_IME_INTERPOLATOR = null;

        @RequiresApi(21)
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION = 160;
            final Callback mCallback;
            private WindowInsetsCompat mLastInsets;

            public Impl21OnApplyWindowInsetsListener(@NonNull View r5, @NonNull Callback r10) {
                this.mCallback = r10;
                WindowInsetsCompat r11 = ViewCompat.getRootWindowInsets(r5);
                if (r11 == null) goto L5;
                WindowInsetsCompat r12 = new WindowInsetsCompat.Builder(r11).build();
            L6:
                this.mLastInsets = r12;
                return;
            L5:
                r12 = null;
                goto L6
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View r16, WindowInsets r17) {
                if (r16.isLaidOut() == true) goto L6;
                this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(r17, r16);
                return Impl21.forwardToViewIfNeeded(r16, r17);
            L6:
                final WindowInsetsCompat r10 = WindowInsetsCompat.toWindowInsetsCompat(r17, r16);
                if (this.mLastInsets != null) goto L10;
                this.mLastInsets = ViewCompat.getRootWindowInsets(r16);
            L10:
                if (this.mLastInsets != null) goto L13;
                this.mLastInsets = r10;
                return Impl21.forwardToViewIfNeeded(r16, r17);
            L13:
                Callback r5 = Impl21.getCallback(r16);
                if (r5 != null) goto L16;
            L19:
                final int r11 = Impl21.buildAnimationMask(r10, this.mLastInsets);
                if (r11 == 0) goto L22;
                final WindowInsetsCompat r12 = this.mLastInsets;
                final WindowInsetsAnimationCompat r13 = new WindowInsetsAnimationCompat(r11, Impl21.createInsetInterpolator(r11, r10, r12), 160);
                r13.setFraction(0.0f);
                final ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r13.getDurationMillis());
                final BoundsCompat r15 = Impl21.computeAnimationBounds(r10, r12, r11);
                Impl21.dispatchOnPrepare(r16, r13, r17, false);
                r14.addUpdateListener(new AnonymousClass1(this, r13, r10, r12, r11, r16));
                r14.addListener(new AnonymousClass2(this, r13, r16));
                OneShotPreDrawListener.add(r16, new AnonymousClass3(this, r16, r13, r15, r14));
                this.mLastInsets = r10;
                return Impl21.forwardToViewIfNeeded(r16, r17);
            L22:
                return Impl21.forwardToViewIfNeeded(r16, r17);
            L16:
                if (Objects.equals(r5.mDispachedInsets, r17) == false) goto L19;
                return Impl21.forwardToViewIfNeeded(r16, r17);
            }
        }

        static {
            SHOW_IME_INTERPOLATOR = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
            HIDE_IME_INTERPOLATOR = new FastOutLinearInInterpolator();
            DEFAULT_INSET_INTERPOLATOR = new DecelerateInterpolator();
        }

        public Impl21(int r5, @Nullable Interpolator r10, long r11) {
            super(r5, r10, r11);
        }

        @SuppressLint({"WrongConstant"})
        public static int buildAnimationMask(@NonNull WindowInsetsCompat r5, @NonNull WindowInsetsCompat r10) {
            int r11 = 0;
            int r12 = 1;
        L4:
            if (r12 > 256) goto L9;
            if (r5.getInsets(r12).equals(r10.getInsets(r12)) == true) goto L8;
            r11 = r11 | r12;
        L8:
            r12 = r12 << 1;
            goto L4
        L9:
            return r11;
        }

        @NonNull
        public static BoundsCompat computeAnimationBounds(@NonNull WindowInsetsCompat r5, @NonNull WindowInsetsCompat r10, int r11) {
            Insets r12 = r5.getInsets(r11);
            Insets r13 = r10.getInsets(r11);
            return new BoundsCompat(Insets.of(Math.min(r12.left, r13.left), Math.min(r12.top, r13.top), Math.min(r12.right, r13.right), Math.min(r12.bottom, r13.bottom)), Insets.of(Math.max(r12.left, r13.left), Math.max(r12.top, r13.top), Math.max(r12.right, r13.right), Math.max(r12.bottom, r13.bottom)));
        }

        public static Interpolator createInsetInterpolator(int r5, WindowInsetsCompat r10, WindowInsetsCompat r11) {
            if ((r5 & 8) == 0) goto L11;
            if (r10.getInsets(WindowInsetsCompat.Type.ime()).bottom <= r11.getInsets(WindowInsetsCompat.Type.ime()).bottom) goto L9;
            return SHOW_IME_INTERPOLATOR;
        L9:
            return HIDE_IME_INTERPOLATOR;
        L11:
            return DEFAULT_INSET_INTERPOLATOR;
        }

        @NonNull
        private static View.OnApplyWindowInsetsListener createProxyListener(@NonNull View r5, @NonNull Callback r10) {
            return new Impl21OnApplyWindowInsetsListener(r5, r10);
        }

        public static void dispatchOnEnd(@NonNull View r5, @NonNull WindowInsetsAnimationCompat r10) {
            Callback r11 = getCallback(r5);
            if (r11 == null) goto L8;
            r11.onEnd(r10);
            if (r11.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r5 instanceof ViewGroup) == false) goto L13;
            ViewGroup r12 = (ViewGroup) r5;
            int r13 = 0;
        L11:
            if (r13 >= r12.getChildCount()) goto L15;
            dispatchOnEnd(r12.getChildAt(r13), r10);
            r13 = r13 + 1;
            goto L11
        L15:
            return;
        }

        public static void dispatchOnPrepare(View r5, WindowInsetsAnimationCompat r10, WindowInsets r11, boolean r12) {
            Callback r13 = getCallback(r5);
            int r14 = 0;
            if (r13 == null) goto L11;
            r13.mDispachedInsets = r11;
            if (r12 == true) goto L11;
            r13.onPrepare(r10);
            if (r13.getDispatchMode() != 0) goto L9;
            r12 = true;
            goto L11
        L9:
            r12 = false;
        L11:
            if ((r5 instanceof ViewGroup) == false) goto L16;
            ViewGroup r15 = (ViewGroup) r5;
        L14:
            if (r14 >= r15.getChildCount()) goto L18;
            dispatchOnPrepare(r15.getChildAt(r14), r10, r11, r12);
            r14 = r14 + 1;
            goto L14
        L18:
            return;
        }

        public static void dispatchOnProgress(@NonNull View r5, @NonNull WindowInsetsCompat r10, @NonNull List<WindowInsetsAnimationCompat> r11) {
            Callback r12 = getCallback(r5);
            if (r12 == null) goto L8;
            r10 = r12.onProgress(r10, r11);
            if (r12.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r5 instanceof ViewGroup) == false) goto L13;
            ViewGroup r13 = (ViewGroup) r5;
            int r14 = 0;
        L11:
            if (r14 >= r13.getChildCount()) goto L15;
            dispatchOnProgress(r13.getChildAt(r14), r10, r11);
            r14 = r14 + 1;
            goto L11
        L15:
            return;
        }

        public static void dispatchOnStart(View r5, WindowInsetsAnimationCompat r10, BoundsCompat r11) {
            Callback r12 = getCallback(r5);
            if (r12 == null) goto L8;
            r12.onStart(r10, r11);
            if (r12.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r5 instanceof ViewGroup) == false) goto L13;
            ViewGroup r13 = (ViewGroup) r5;
            int r14 = 0;
        L11:
            if (r14 >= r13.getChildCount()) goto L15;
            dispatchOnStart(r13.getChildAt(r14), r10, r11);
            r14 = r14 + 1;
            goto L11
        L15:
            return;
        }

        @NonNull
        public static WindowInsets forwardToViewIfNeeded(@NonNull View r5, @NonNull WindowInsets r10) {
            if (r5.getTag(R.id.tag_on_apply_window_listener) == null) goto L6;
            return r10;
        L6:
            return r5.onApplyWindowInsets(r10);
        }

        @Nullable
        public static Callback getCallback(View r5) {
            Object r10 = r5.getTag(R.id.tag_window_insets_animation_callback);
            if ((r10 instanceof Impl21OnApplyWindowInsetsListener) == true) goto L7;
            return null;
        L7:
            return ((Impl21OnApplyWindowInsetsListener) r10).mCallback;
        }

        @SuppressLint({"WrongConstant"})
        public static WindowInsetsCompat interpolateInsets(WindowInsetsCompat r12, WindowInsetsCompat r13, float r14, int r15) {
            WindowInsetsCompat.Builder r5 = new WindowInsetsCompat.Builder(r12);
            int r10 = 1;
        L4:
            if (r10 > 256) goto L11;
            if ((r15 & r10) != 0) goto L8;
            r5.setInsets(r10, r12.getInsets(r10));
        L9:
            r10 = r10 << 1;
            goto L4
        L8:
            Insets r11 = r12.getInsets(r10);
            Insets r16 = r13.getInsets(r10);
            float r17 = 1.0f - r14;
            r5.setInsets(r10, WindowInsetsCompat.insetInsets(r11, (int) (((double) ((r11.left - r16.left) * r17)) + 0.5d), (int) (((double) ((r11.top - r16.top) * r17)) + 0.5d), (int) (((double) ((r11.right - r16.right) * r17)) + 0.5d), (int) (((double) ((r11.bottom - r16.bottom) * r17)) + 0.5d)));
            goto L9
        L11:
            return r5.build();
        }

        public static void setCallback(@NonNull View r5, @Nullable Callback r10) {
            Object r11 = r5.getTag(R.id.tag_on_apply_window_listener);
            if (r10 != null) goto L7;
            r5.setTag(R.id.tag_window_insets_animation_callback, null);
            if (r11 != null) goto L11;
            r5.setOnApplyWindowInsetsListener(null);
            return;
        L11:
            return;
        L7:
            View.OnApplyWindowInsetsListener r12 = createProxyListener(r5, r10);
            r5.setTag(R.id.tag_window_insets_animation_callback, r12);
            if (r11 != null) goto L13;
            r5.setOnApplyWindowInsetsListener(r12);
            return;
        }
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl {

        @NonNull
        private final WindowInsetsAnimation mWrapped;

        @RequiresApi(30)
        public static class ProxyCallback extends WindowInsetsAnimation.Callback {
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations;
            private final Callback mCompat;
            private List<WindowInsetsAnimationCompat> mRORunningAnimations;
            private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            public ProxyCallback(@NonNull Callback r5) {
                super(r5.getDispatchMode());
                this.mAnimations = new HashMap();
                this.mCompat = r5;
            }

            @NonNull
            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation r5) {
                WindowInsetsAnimationCompat r10 = this.mAnimations.get(r5);
                if (r10 != null) goto L6;
                WindowInsetsAnimationCompat r11 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(r5);
                this.mAnimations.put(r5, r11);
                return r11;
            L6:
                return r10;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(@NonNull WindowInsetsAnimation r5) {
                this.mCompat.onEnd(getWindowInsetsAnimationCompat(r5));
                this.mAnimations.remove(r5);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(@NonNull WindowInsetsAnimation r5) {
                this.mCompat.onPrepare(getWindowInsetsAnimationCompat(r5));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets r5, @NonNull List<WindowInsetsAnimation> r10) {
                ArrayList<WindowInsetsAnimationCompat> r11 = this.mTmpRunningAnimations;
                if (r11 != null) goto L5;
                ArrayList<WindowInsetsAnimationCompat> r12 = new ArrayList(r10.size());
                this.mTmpRunningAnimations = r12;
                this.mRORunningAnimations = Collections.unmodifiableList(r12);
            L6:
                int r13 = r10.size() - 1;
            L7:
                if (r13 < 0) goto L10;
                WindowInsetsAnimation r14 = r10.get(r13);
                WindowInsetsAnimationCompat r15 = getWindowInsetsAnimationCompat(r14);
                r15.setFraction(r14.getFraction());
                this.mTmpRunningAnimations.add(r15);
                r13 = r13 - 1;
                goto L7
            L10:
                return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(r5), this.mRORunningAnimations).toWindowInsets();
            L5:
                r11.clear();
                goto L6
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation r5, @NonNull WindowInsetsAnimation.Bounds r10) {
                return this.mCompat.onStart(getWindowInsetsAnimationCompat(r5), BoundsCompat.toBoundsCompat(r10)).toBounds();
            }
        }

        public Impl30(@NonNull WindowInsetsAnimation r5) {
            super(0, null, 0);
            this.mWrapped = r5;
        }

        @NonNull
        public static WindowInsetsAnimation.Bounds createPlatformBounds(@NonNull BoundsCompat r5) {
            return new WindowInsetsAnimation.Bounds(r5.getLowerBound().toPlatformInsets(), r5.getUpperBound().toPlatformInsets());
        }

        @NonNull
        public static Insets getHigherBounds(@NonNull WindowInsetsAnimation.Bounds r5) {
            return Insets.toCompatInsets(r5.getUpperBound());
        }

        @NonNull
        public static Insets getLowerBounds(@NonNull WindowInsetsAnimation.Bounds r5) {
            return Insets.toCompatInsets(r5.getLowerBound());
        }

        public static void setCallback(@NonNull View r5, @Nullable Callback r10) {
            if (r10 == null) goto L4;
            ProxyCallback r11 = new ProxyCallback(r10);
        L5:
            r5.setWindowInsetsAnimationCallback(r11);
            return;
        L4:
            r11 = null;
            goto L5
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getFraction() {
            return this.mWrapped.getFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        @Nullable
        public Interpolator getInterpolator() {
            return this.mWrapped.getInterpolator();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public void setFraction(float r5) {
            this.mWrapped.setFraction(r5);
        }

        public Impl30(int r5, Interpolator r10, long r11) {
            this(new WindowInsetsAnimation(r5, r10, r11));
        }
    }

    public WindowInsetsAnimationCompat(int r5, @Nullable Interpolator r10, long r11) {
        this.mImpl = new Impl30(r5, r10, r11);
    }

    public static void setCallback(@NonNull View r5, @Nullable Callback r10) {
        Impl30.setCallback(r5, r10);
    }

    @RequiresApi(30)
    public static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation r5) {
        return new WindowInsetsAnimationCompat(r5);
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        this.mImpl.setAlpha(r5);
    }

    public void setFraction(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        this.mImpl.setFraction(r5);
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation r5) {
        this(0, null, 0);
        this.mImpl = new Impl30(r5);
    }
}
