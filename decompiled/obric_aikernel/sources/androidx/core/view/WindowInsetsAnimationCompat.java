package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
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

        @RequiresApi(30)
        private BoundsCompat(@NonNull WindowInsetsAnimation.Bounds r10) {
            this.mLowerBound = Impl30.getLowerBounds(r10);
            this.mUpperBound = Impl30.getHigherBounds(r10);
        }

        public BoundsCompat(@NonNull Insets r10, @NonNull Insets r11) {
            this.mLowerBound = r10;
            this.mUpperBound = r11;
        }

        @NonNull
        @RequiresApi(30)
        public static BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation.Bounds r10) {
            return new BoundsCompat(r10);
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

        public Callback(int r10) {
            this.mDispatchMode = r10;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(@NonNull WindowInsetsAnimationCompat r10) {
        }

        public void onPrepare(@NonNull WindowInsetsAnimationCompat r10) {
        }

        @NonNull
        public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat r10, @NonNull List<WindowInsetsAnimationCompat> r11);

        @NonNull
        public BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat r10, @NonNull BoundsCompat r11) {
            return r11;
        }
    }

    private static class Impl {
        private float mAlpha;
        private final long mDurationMillis;
        private float mFraction;

        @Nullable
        private final Interpolator mInterpolator;
        private final int mTypeMask;

        Impl(int r10, @Nullable Interpolator r11, long r12) {
            this.mTypeMask = r10;
            this.mInterpolator = r11;
            this.mDurationMillis = r12;
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
            Interpolator r10 = this.mInterpolator;
            float r11 = this.mFraction;
            if (r10 != null) goto L5;
            return r11;
        L5:
            return r10.getInterpolation(r11);
        }

        @Nullable
        public Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float r10) {
            this.mAlpha = r10;
        }

        public void setFraction(float r10) {
            this.mFraction = r10;
        }
    }

    @RequiresApi(21)
    private static class Impl21 extends Impl {
        private static final Interpolator DEFAULT_INSET_INTERPOLATOR = null;
        private static final Interpolator HIDE_IME_INTERPOLATOR = null;
        private static final Interpolator SHOW_IME_INTERPOLATOR = null;

        @RequiresApi(21)
        private static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION = 160;
            final Callback mCallback;
            private WindowInsetsCompat mLastInsets;

            Impl21OnApplyWindowInsetsListener(@NonNull View r10, @NonNull Callback r11) {
                this.mCallback = r11;
                WindowInsetsCompat r12 = ViewCompat.getRootWindowInsets(r10);
                if (r12 == null) goto L5;
                WindowInsetsCompat r13 = new WindowInsetsCompat.Builder(r12).build();
            L6:
                this.mLastInsets = r13;
                return;
            L5:
                r13 = null;
                goto L6
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View r16, WindowInsets r17) {
                if (r16.isLaidOut() == true) goto L7;
                this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(r17, r16);
            L6:
                return Impl21.forwardToViewIfNeeded(r16, r17);
            L7:
                final WindowInsetsCompat r10 = WindowInsetsCompat.toWindowInsetsCompat(r17, r16);
                if (this.mLastInsets != null) goto L11;
                this.mLastInsets = ViewCompat.getRootWindowInsets(r16);
            L11:
                if (this.mLastInsets != null) goto L13;
            L12:
                this.mLastInsets = r10;
                goto L6
            L13:
                Callback r11 = Impl21.getCallback(r16);
                if (r11 != null) goto L16;
            L19:
                final int r12 = Impl21.buildAnimationMask(r10, this.mLastInsets);
                if (r12 == 0) goto L22;
                final WindowInsetsCompat r13 = this.mLastInsets;
                final WindowInsetsAnimationCompat r14 = new WindowInsetsAnimationCompat(r12, Impl21.createInsetInterpolator(r12, r10, r13), 160);
                r14.setFraction(0.0f);
                final ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r14.getDurationMillis());
                final BoundsCompat r18 = Impl21.computeAnimationBounds(r10, r13, r12);
                Impl21.dispatchOnPrepare(r16, r14, r17, false);
                r15.addUpdateListener(new AnonymousClass1(this, r14, r10, r13, r12, r16));
                r15.addListener(new AnonymousClass2(this, r14, r16));
                OneShotPreDrawListener.add(r16, new AnonymousClass3(this, r16, r14, r18, r15));
                goto L12
            L22:
                return Impl21.forwardToViewIfNeeded(r16, r17);
            L16:
                if (Objects.equals(r11.mDispachedInsets, r17) == false) goto L19;
                return Impl21.forwardToViewIfNeeded(r16, r17);
            }
        }

        static {
            SHOW_IME_INTERPOLATOR = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
            HIDE_IME_INTERPOLATOR = new FastOutLinearInInterpolator();
            DEFAULT_INSET_INTERPOLATOR = new DecelerateInterpolator();
        }

        Impl21(int r10, @Nullable Interpolator r11, long r12) {
            super(r10, r11, r12);
        }

        @SuppressLint({"WrongConstant"})
        static int buildAnimationMask(@NonNull WindowInsetsCompat r10, @NonNull WindowInsetsCompat r11) {
            int r12 = 1;
            int r13 = 0;
        L4:
            if (r12 > 256) goto L9;
            if (r10.getInsets(r12).equals(r11.getInsets(r12)) == true) goto L8;
            r13 = r13 | r12;
        L8:
            r12 = r12 << 1;
            goto L4
        L9:
            return r13;
        }

        @NonNull
        static BoundsCompat computeAnimationBounds(@NonNull WindowInsetsCompat r10, @NonNull WindowInsetsCompat r11, int r12) {
            Insets r13 = r10.getInsets(r12);
            Insets r14 = r11.getInsets(r12);
            return new BoundsCompat(Insets.of(Math.min(r13.left, r14.left), Math.min(r13.top, r14.top), Math.min(r13.right, r14.right), Math.min(r13.bottom, r14.bottom)), Insets.of(Math.max(r13.left, r14.left), Math.max(r13.top, r14.top), Math.max(r13.right, r14.right), Math.max(r13.bottom, r14.bottom)));
        }

        static Interpolator createInsetInterpolator(int r10, WindowInsetsCompat r11, WindowInsetsCompat r12) {
            if ((r10 & 8) == 0) goto L11;
            if (r11.getInsets(WindowInsetsCompat.Type.ime()).bottom <= r12.getInsets(WindowInsetsCompat.Type.ime()).bottom) goto L9;
            return SHOW_IME_INTERPOLATOR;
        L9:
            return HIDE_IME_INTERPOLATOR;
        L11:
            return DEFAULT_INSET_INTERPOLATOR;
        }

        @NonNull
        private static View.OnApplyWindowInsetsListener createProxyListener(@NonNull View r10, @NonNull Callback r11) {
            return new Impl21OnApplyWindowInsetsListener(r10, r11);
        }

        static void dispatchOnEnd(@NonNull View r10, @NonNull WindowInsetsAnimationCompat r11) {
            Callback r12 = getCallback(r10);
            if (r12 == null) goto L8;
            r12.onEnd(r11);
            if (r12.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r10 instanceof ViewGroup) == false) goto L13;
            ViewGroup r13 = (ViewGroup) r10;
            int r14 = 0;
        L11:
            if (r14 >= r13.getChildCount()) goto L15;
            dispatchOnEnd(r13.getChildAt(r14), r11);
            r14 = r14 + 1;
            goto L11
        L15:
            return;
        }

        static void dispatchOnPrepare(View r10, WindowInsetsAnimationCompat r11, WindowInsets r12, boolean r13) {
            Callback r14 = getCallback(r10);
            int r15 = 0;
            if (r14 == null) goto L11;
            r14.mDispachedInsets = r12;
            if (r13 == true) goto L11;
            r14.onPrepare(r11);
            if (r14.getDispatchMode() != 0) goto L9;
            r13 = true;
            goto L11
        L9:
            r13 = false;
        L11:
            if ((r10 instanceof ViewGroup) == false) goto L16;
            ViewGroup r16 = (ViewGroup) r10;
        L14:
            if (r15 >= r16.getChildCount()) goto L18;
            dispatchOnPrepare(r16.getChildAt(r15), r11, r12, r13);
            r15 = r15 + 1;
            goto L14
        L18:
            return;
        }

        static void dispatchOnProgress(@NonNull View r10, @NonNull WindowInsetsCompat r11, @NonNull List<WindowInsetsAnimationCompat> r12) {
            Callback r13 = getCallback(r10);
            if (r13 == null) goto L8;
            r11 = r13.onProgress(r11, r12);
            if (r13.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r10 instanceof ViewGroup) == false) goto L13;
            ViewGroup r14 = (ViewGroup) r10;
            int r15 = 0;
        L11:
            if (r15 >= r14.getChildCount()) goto L15;
            dispatchOnProgress(r14.getChildAt(r15), r11, r12);
            r15 = r15 + 1;
            goto L11
        L15:
            return;
        }

        static void dispatchOnStart(View r10, WindowInsetsAnimationCompat r11, BoundsCompat r12) {
            Callback r13 = getCallback(r10);
            if (r13 == null) goto L8;
            r13.onStart(r11, r12);
            if (r13.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r10 instanceof ViewGroup) == false) goto L13;
            ViewGroup r14 = (ViewGroup) r10;
            int r15 = 0;
        L11:
            if (r15 >= r14.getChildCount()) goto L15;
            dispatchOnStart(r14.getChildAt(r15), r11, r12);
            r15 = r15 + 1;
            goto L11
        L15:
            return;
        }

        @NonNull
        static WindowInsets forwardToViewIfNeeded(@NonNull View r10, @NonNull WindowInsets r11) {
            if (r10.getTag(R.id.tag_on_apply_window_listener) == null) goto L6;
            return r11;
        L6:
            return r10.onApplyWindowInsets(r11);
        }

        @Nullable
        static Callback getCallback(View r10) {
            Object r11 = r10.getTag(R.id.tag_window_insets_animation_callback);
            if ((r11 instanceof Impl21OnApplyWindowInsetsListener) == true) goto L7;
            return null;
        L7:
            return ((Impl21OnApplyWindowInsetsListener) r11).mCallback;
        }

        @SuppressLint({"WrongConstant"})
        static WindowInsetsCompat interpolateInsets(WindowInsetsCompat r12, WindowInsetsCompat r13, float r14, int r15) {
            WindowInsetsCompat.Builder r10 = new WindowInsetsCompat.Builder(r12);
            int r11 = 1;
        L4:
            if (r11 > 256) goto L11;
            if ((r15 & r11) != 0) goto L8;
            Insets r16 = r12.getInsets(r11);
        L9:
            r10.setInsets(r11, r16);
            r11 = r11 << 1;
            goto L4
        L8:
            Insets r17 = r12.getInsets(r11);
            Insets r18 = r13.getInsets(r11);
            float r19 = 1.0f - r14;
            r16 = WindowInsetsCompat.insetInsets(r17, (int) (((double) ((r17.left - r18.left) * r19)) + 0.5d), (int) (((double) ((r17.top - r18.top) * r19)) + 0.5d), (int) (((double) ((r17.right - r18.right) * r19)) + 0.5d), (int) (((double) ((r17.bottom - r18.bottom) * r19)) + 0.5d));
            goto L9
        L11:
            return r10.build();
        }

        static void setCallback(@NonNull View r10, @Nullable Callback r11) {
            Object r12 = r10.getTag(R.id.tag_on_apply_window_listener);
            if (r11 != null) goto L7;
            r10.setTag(R.id.tag_window_insets_animation_callback, null);
            if (r12 != null) goto L11;
            r10.setOnApplyWindowInsetsListener(null);
            return;
        L11:
            return;
        L7:
            View.OnApplyWindowInsetsListener r13 = createProxyListener(r10, r11);
            r10.setTag(R.id.tag_window_insets_animation_callback, r13);
            if (r12 != null) goto L13;
            r10.setOnApplyWindowInsetsListener(r13);
            return;
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {

        @NonNull
        private final WindowInsetsAnimation mWrapped;

        @RequiresApi(30)
        private static class ProxyCallback extends WindowInsetsAnimation.Callback {
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations;
            private final Callback mCompat;
            private List<WindowInsetsAnimationCompat> mRORunningAnimations;
            private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            ProxyCallback(@NonNull Callback r10) {
                super(r10.getDispatchMode());
                this.mAnimations = new HashMap();
                this.mCompat = r10;
            }

            @NonNull
            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation r10) {
                WindowInsetsAnimationCompat r11 = this.mAnimations.get(r10);
                if (r11 != null) goto L6;
                WindowInsetsAnimationCompat r12 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(r10);
                this.mAnimations.put(r10, r12);
                return r12;
            L6:
                return r11;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(@NonNull WindowInsetsAnimation r10) {
                this.mCompat.onEnd(getWindowInsetsAnimationCompat(r10));
                this.mAnimations.remove(r10);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(@NonNull WindowInsetsAnimation r10) {
                this.mCompat.onPrepare(getWindowInsetsAnimationCompat(r10));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets r10, @NonNull List<WindowInsetsAnimation> r11) {
                ArrayList<WindowInsetsAnimationCompat> r12 = this.mTmpRunningAnimations;
                if (r12 != null) goto L5;
                ArrayList<WindowInsetsAnimationCompat> r13 = new ArrayList(r11.size());
                this.mTmpRunningAnimations = r13;
                this.mRORunningAnimations = Collections.unmodifiableList(r13);
            L6:
                int r14 = r11.size() - 1;
            L7:
                if (r14 < 0) goto L10;
                WindowInsetsAnimation r15 = r11.get(r14);
                WindowInsetsAnimationCompat r16 = getWindowInsetsAnimationCompat(r15);
                r16.setFraction(r15.getFraction());
                this.mTmpRunningAnimations.add(r16);
                r14 = r14 - 1;
                goto L7
            L10:
                return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(r10), this.mRORunningAnimations).toWindowInsets();
            L5:
                r12.clear();
                goto L6
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation r10, @NonNull WindowInsetsAnimation.Bounds r11) {
                return this.mCompat.onStart(getWindowInsetsAnimationCompat(r10), BoundsCompat.toBoundsCompat(r11)).toBounds();
            }
        }

        Impl30(int r10, Interpolator r11, long r12) {
            this(new WindowInsetsAnimation(r10, r11, r12));
        }

        Impl30(@NonNull WindowInsetsAnimation r10) {
            super(0, null, 0);
            this.mWrapped = r10;
        }

        @NonNull
        public static WindowInsetsAnimation.Bounds createPlatformBounds(@NonNull BoundsCompat r10) {
            return new WindowInsetsAnimation.Bounds(r10.getLowerBound().toPlatformInsets(), r10.getUpperBound().toPlatformInsets());
        }

        @NonNull
        public static Insets getHigherBounds(@NonNull WindowInsetsAnimation.Bounds r10) {
            return Insets.toCompatInsets(r10.getUpperBound());
        }

        @NonNull
        public static Insets getLowerBounds(@NonNull WindowInsetsAnimation.Bounds r10) {
            return Insets.toCompatInsets(r10.getLowerBound());
        }

        public static void setCallback(@NonNull View r10, @Nullable Callback r11) {
            if (r11 == null) goto L4;
            ProxyCallback r12 = new ProxyCallback(r11);
        L5:
            r10.setWindowInsetsAnimationCallback(r12);
            return;
        L4:
            r12 = null;
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
        public void setFraction(float r10) {
            this.mWrapped.setFraction(r10);
        }
    }

    public WindowInsetsAnimationCompat(int r10, @Nullable Interpolator r11, long r12) {
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 30) goto L7;
        Impl r14 = new Impl30(r10, r11, r12);
    L5:
        this.mImpl = r14;
        return;
    L7:
        if (r13 < 21) goto L9;
        r14 = new Impl21(r10, r11, r12);
        goto L5
    L9:
        this.mImpl = new Impl(0, r11, r12);
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation r10) {
        this(0, null, 0);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.mImpl = new Impl30(r10);
        return;
    }

    static void setCallback(@NonNull View r10, @Nullable Callback r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 30) goto L6;
        Impl30.setCallback(r10, r11);
        return;
    L6:
        if (r12 < 21) goto L10;
        Impl21.setCallback(r10, r11);
        return;
    }

    @RequiresApi(30)
    static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation r10) {
        return new WindowInsetsAnimationCompat(r10);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
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

    public void setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.mImpl.setAlpha(r10);
    }

    public void setFraction(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        this.mImpl.setFraction(r10);
    }
}
