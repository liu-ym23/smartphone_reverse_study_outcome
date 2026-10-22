package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    Runnable mEndAction;
    int mOldLayerType;
    Runnable mStartAction;
    private final WeakReference<View> mView;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator withEndAction(ViewPropertyAnimator r10, Runnable r11) {
            return r10.withEndAction(r11);
        }

        @DoNotInline
        static ViewPropertyAnimator withLayer(ViewPropertyAnimator r10) {
            return r10.withLayer();
        }

        @DoNotInline
        static ViewPropertyAnimator withStartAction(ViewPropertyAnimator r10, Runnable r11) {
            return r10.withStartAction(r11);
        }
    }

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static Interpolator getInterpolator(ViewPropertyAnimator r10) {
            return (Interpolator) r10.getInterpolator();
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator setUpdateListener(ViewPropertyAnimator r10, ValueAnimator.AnimatorUpdateListener r11) {
            return r10.setUpdateListener(r11);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator translationZ(ViewPropertyAnimator r10, float r11) {
            return r10.translationZ(r11);
        }

        @DoNotInline
        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator r10, float r11) {
            return r10.translationZBy(r11);
        }

        @DoNotInline
        static ViewPropertyAnimator z(ViewPropertyAnimator r10, float r11) {
            return r10.z(r11);
        }

        @DoNotInline
        static ViewPropertyAnimator zBy(ViewPropertyAnimator r10, float r11) {
            return r10.zBy(r11);
        }
    }

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat r10) {
            this.mVpa = r10;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(@NonNull View r10) {
            Object r11 = r10.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if ((r11 instanceof ViewPropertyAnimatorListener) == false) goto L5;
            ViewPropertyAnimatorListener r12 = (ViewPropertyAnimatorListener) r11;
        L6:
            if (r12 == null) goto L9;
            r12.onAnimationCancel(r10);
            return;
        L9:
            return;
        L5:
            r12 = null;
            goto L6
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        @SuppressLint({"WrongConstant"})
        public void onAnimationEnd(@NonNull View r10) {
            int r11 = this.mVpa.mOldLayerType;
            ViewPropertyAnimatorListener r12 = null;
            if (r11 <= (-1)) goto L6;
            r10.setLayerType(r11, null);
            this.mVpa.mOldLayerType = -1;
        L6:
            if (Build.VERSION.SDK_INT < 16) goto L8;
        L9:
            ViewPropertyAnimatorCompat r13 = this.mVpa;
            Runnable r14 = r13.mEndAction;
            if (r14 == null) goto L12;
            r13.mEndAction = null;
            r14.run();
        L12:
            Object r15 = r10.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if ((r15 instanceof ViewPropertyAnimatorListener) == false) goto L15;
            r12 = (ViewPropertyAnimatorListener) r15;
        L15:
            if (r12 == null) goto L17;
            r12.onAnimationEnd(r10);
        L17:
            this.mAnimEndCalled = true;
            return;
        L8:
            if (this.mAnimEndCalled == false) goto L9;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(@NonNull View r10) {
            this.mAnimEndCalled = false;
            ViewPropertyAnimatorListener r11 = null;
            if (this.mVpa.mOldLayerType <= (-1)) goto L5;
            r10.setLayerType(2, null);
        L5:
            ViewPropertyAnimatorCompat r12 = this.mVpa;
            Runnable r13 = r12.mStartAction;
            if (r13 == null) goto L8;
            r12.mStartAction = null;
            r13.run();
        L8:
            Object r14 = r10.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if ((r14 instanceof ViewPropertyAnimatorListener) == false) goto L11;
            r11 = (ViewPropertyAnimatorListener) r14;
        L11:
            if (r11 == null) goto L14;
            r11.onAnimationStart(r10);
            return;
        }
    }

    ViewPropertyAnimatorCompat(View r10) {
        this.mStartAction = null;
        this.mEndAction = null;
        this.mOldLayerType = -1;
        this.mView = new WeakReference(r10);
    }

    public static /* synthetic */ void a(ViewPropertyAnimatorUpdateListener r10, View r11, ValueAnimator r12) {
        lambda$setUpdateListener$0(r10, r11, r12);
    }

    private static /* synthetic */ void lambda$setUpdateListener$0(ViewPropertyAnimatorUpdateListener r10, View r11, ValueAnimator r12) {
        r10.onAnimationUpdate(r11);
    }

    private void setListenerInternal(final View r10, final ViewPropertyAnimatorListener r11) {
        if (r11 == null) goto L4;
        r10.animate().setListener(new AnonymousClass1(this, r11, r10));
        return;
    L4:
        r10.animate().setListener(null);
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().alpha(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alphaBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().alphaBy(r10);
    L5:
        return this;
    }

    public void cancel() {
        View r10 = this.mView.get();
        if (r10 == null) goto L6;
        r10.animate().cancel();
        return;
    }

    public long getDuration() {
        View r10 = this.mView.get();
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.animate().getDuration();
    }

    @Nullable
    public Interpolator getInterpolator() {
        View r10 = this.mView.get();
        if (r10 != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT >= 18) goto L7;
        return null;
    L7:
        return Api18Impl.getInterpolator(r10.animate());
    }

    public long getStartDelay() {
        View r10 = this.mView.get();
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.animate().getStartDelay();
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().rotation(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().rotationBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().rotationX(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().rotationXBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().rotationY(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().rotationYBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().scaleX(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().scaleXBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().scaleY(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().scaleYBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().setDuration(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().setInterpolator(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener r10) {
        View r11 = this.mView.get();
        if (r11 != null) goto L5;
    L9:
        return this;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        r11.setTag(LISTENER_TAG_ID, r10);
        r10 = new ViewPropertyAnimatorListenerApi14(this);
    L8:
        setListenerInternal(r11, r10);
        goto L9
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().setStartDelay(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable final ViewPropertyAnimatorUpdateListener r10) {
        final View r11 = this.mView.get();
        if (r11 != null) goto L5;
    L10:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        ValueAnimator.AnimatorUpdateListener r12 = null;
        if (r10 == null) goto L9;
        r12 = new i(r10, r11);
    L9:
        Api19Impl.setUpdateListener(r11.animate(), r12);
        goto L10
    }

    public void start() {
        View r10 = this.mView.get();
        if (r10 == null) goto L6;
        r10.animate().start();
        return;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().translationX(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().translationXBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().translationY(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().translationYBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float r10) {
        View r11 = this.mView.get();
        if (r11 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.translationZ(r11.animate(), r10);
        goto L7
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float r10) {
        View r11 = this.mView.get();
        if (r11 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.translationZBy(r11.animate(), r10);
        goto L7
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable r10) {
        View r11 = this.mView.get();
        if (r11 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withEndAction(r11.animate(), r10);
        goto L8
    L7:
        setListenerInternal(r11, new ViewPropertyAnimatorListenerApi14(this));
        this.mEndAction = r10;
        goto L8
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View r10 = this.mView.get();
        if (r10 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withLayer(r10.animate());
        goto L8
    L7:
        this.mOldLayerType = r10.getLayerType();
        setListenerInternal(r10, new ViewPropertyAnimatorListenerApi14(this));
        goto L8
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable r10) {
        View r11 = this.mView.get();
        if (r11 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withStartAction(r11.animate(), r10);
        goto L8
    L7:
        setListenerInternal(r11, new ViewPropertyAnimatorListenerApi14(this));
        this.mStartAction = r10;
        goto L8
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().x(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().xBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat y(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().y(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float r10) {
        View r11 = this.mView.get();
        if (r11 == null) goto L5;
        r11.animate().yBy(r10);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float r10) {
        View r11 = this.mView.get();
        if (r11 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.z(r11.animate(), r10);
        goto L7
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float r10) {
        View r11 = this.mView.get();
        if (r11 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.zBy(r11.animate(), r10);
        goto L7
    }
}
