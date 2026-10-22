package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
    private final WeakReference<View> mView;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static ViewPropertyAnimator translationZ(ViewPropertyAnimator r5, float r10) {
            return r5.translationZ(r10);
        }

        @DoNotInline
        public static ViewPropertyAnimator translationZBy(ViewPropertyAnimator r5, float r10) {
            return r5.translationZBy(r10);
        }

        @DoNotInline
        public static ViewPropertyAnimator z(ViewPropertyAnimator r5, float r10) {
            return r5.z(r10);
        }

        @DoNotInline
        public static ViewPropertyAnimator zBy(ViewPropertyAnimator r5, float r10) {
            return r5.zBy(r10);
        }
    }

    public ViewPropertyAnimatorCompat(View r5) {
        this.mView = new WeakReference(r5);
    }

    public static /* synthetic */ void a(ViewPropertyAnimatorUpdateListener r5, View r10, ValueAnimator r11) {
        lambda$setUpdateListener$0(r5, r10, r11);
    }

    private static /* synthetic */ void lambda$setUpdateListener$0(ViewPropertyAnimatorUpdateListener r5, View r10, ValueAnimator r11) {
        r5.onAnimationUpdate(r10);
    }

    private void setListenerInternal(final View r5, final ViewPropertyAnimatorListener r10) {
        if (r10 == null) goto L4;
        r5.animate().setListener(new AnonymousClass1(this, r10, r5));
        return;
    L4:
        r5.animate().setListener(null);
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().alpha(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat alphaBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().alphaBy(r5);
    L5:
        return this;
    }

    public void cancel() {
        View r5 = this.mView.get();
        if (r5 == null) goto L6;
        r5.animate().cancel();
        return;
    }

    public long getDuration() {
        View r5 = this.mView.get();
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.animate().getDuration();
    }

    @Nullable
    public Interpolator getInterpolator() {
        View r5 = this.mView.get();
        if (r5 != null) goto L5;
        return null;
    L5:
        return (Interpolator) r5.animate().getInterpolator();
    }

    public long getStartDelay() {
        View r5 = this.mView.get();
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.animate().getStartDelay();
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().rotation(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().rotationBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().rotationX(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().rotationXBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().rotationY(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().rotationYBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().scaleX(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().scaleXBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().scaleY(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().scaleYBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().setDuration(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().setInterpolator(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        setListenerInternal(r10, r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().setStartDelay(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable final ViewPropertyAnimatorUpdateListener r5) {
        final View r10 = this.mView.get();
        if (r10 == null) goto L8;
        if (r5 == null) goto L6;
        ValueAnimator.AnimatorUpdateListener r11 = new l(r5, r10);
    L7:
        r10.animate().setUpdateListener(r11);
        goto L8
    L6:
        r11 = null;
    L8:
        return this;
    }

    public void start() {
        View r5 = this.mView.get();
        if (r5 == null) goto L6;
        r5.animate().start();
        return;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().translationX(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().translationXBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().translationY(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().translationYBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        Api21Impl.translationZ(r10.animate(), r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        Api21Impl.translationZBy(r10.animate(), r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().withEndAction(r5);
    L5:
        return this;
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View r5 = this.mView.get();
        if (r5 == null) goto L5;
        r5.animate().withLayer();
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().withStartAction(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().x(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().xBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat y(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().y(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        r10.animate().yBy(r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        Api21Impl.z(r10.animate(), r5);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float r5) {
        View r10 = this.mView.get();
        if (r10 == null) goto L5;
        Api21Impl.zBy(r10.animate(), r5);
    L5:
        return this;
    }
}
