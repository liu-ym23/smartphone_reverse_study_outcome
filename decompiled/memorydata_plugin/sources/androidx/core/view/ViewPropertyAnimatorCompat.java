package androidx.core.view;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    Runnable mEndAction;
    int mOldLayerType;
    Runnable mStartAction;
    private final WeakReference<View> mView;

    static class Api16Impl {
        private Api16Impl() {
        }

        static ViewPropertyAnimator withEndAction(ViewPropertyAnimator r2, Runnable r3) {
            return r2.withEndAction((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
        }

        static ViewPropertyAnimator withLayer(ViewPropertyAnimator r0) {
            return r0.withLayer();
        }

        static ViewPropertyAnimator withStartAction(ViewPropertyAnimator r2, Runnable r3) {
            return r2.withStartAction((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
        }
    }

    static class Api18Impl {
        private Api18Impl() {
        }

        static Interpolator getInterpolator(ViewPropertyAnimator r2) {
            return (Interpolator) ZeusTransformUtils.preCheckCast(r2.getInterpolator(), Interpolator.class, "com.obric.memorydata.plugin");
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static ViewPropertyAnimator setUpdateListener(ViewPropertyAnimator r2, ValueAnimator.AnimatorUpdateListener r3) {
            return r2.setUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.wrapperContextForParams(r3, ValueAnimator.AnimatorUpdateListener.class, "com.obric.memorydata.plugin"));
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static ViewPropertyAnimator translationZ(ViewPropertyAnimator r0, float r1) {
            return r0.translationZ(r1);
        }

        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator r0, float r1) {
            return r0.translationZBy(r1);
        }

        static ViewPropertyAnimator z(ViewPropertyAnimator r0, float r1) {
            return r0.z(r1);
        }

        static ViewPropertyAnimator zBy(ViewPropertyAnimator r0, float r1) {
            return r0.zBy(r1);
        }
    }

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat r1) {
            this.mVpa = r1;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r3) {
            Object r2 = r3.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if (ZeusTransformUtils.instanceOf(r2, ViewPropertyAnimatorListener.class) == false) goto L5;
            ViewPropertyAnimatorListener r4 = (ViewPropertyAnimatorListener) ZeusTransformUtils.preCheckCast(r2, ViewPropertyAnimatorListener.class, "com.obric.memorydata.plugin");
        L6:
            if (r4 == null) goto L9;
            r4.onAnimationCancel(r3);
            return;
        L9:
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View r4) {
            ViewPropertyAnimatorListener r2 = null;
            if (this.mVpa.mOldLayerType <= (-1)) goto L6;
            r4.setLayerType(this.mVpa.mOldLayerType, null);
            this.mVpa.mOldLayerType = -1;
        L6:
            if (Build.VERSION.SDK_INT >= 16) goto L10;
            if (this.mAnimEndCalled == false) goto L10;
            return;
        L10:
            if (this.mVpa.mEndAction == null) goto L12;
            Runnable r0 = this.mVpa.mEndAction;
            this.mVpa.mEndAction = null;
            r0.run();
        L12:
            Object r1 = r4.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if (ZeusTransformUtils.instanceOf(r1, ViewPropertyAnimatorListener.class) == false) goto L15;
            r2 = (ViewPropertyAnimatorListener) ZeusTransformUtils.preCheckCast(r1, ViewPropertyAnimatorListener.class, "com.obric.memorydata.plugin");
        L15:
            if (r2 == null) goto L17;
            r2.onAnimationEnd(r4);
        L17:
            this.mAnimEndCalled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r4) {
            this.mAnimEndCalled = false;
            ViewPropertyAnimatorListener r1 = null;
            if (this.mVpa.mOldLayerType <= (-1)) goto L6;
            r4.setLayerType(2, null);
        L6:
            if (this.mVpa.mStartAction == null) goto L8;
            Runnable r0 = this.mVpa.mStartAction;
            this.mVpa.mStartAction = null;
            r0.run();
        L8:
            Object r3 = r4.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if (ZeusTransformUtils.instanceOf(r3, ViewPropertyAnimatorListener.class) == false) goto L11;
            r1 = (ViewPropertyAnimatorListener) ZeusTransformUtils.preCheckCast(r3, ViewPropertyAnimatorListener.class, "com.obric.memorydata.plugin");
        L11:
            if (r1 == null) goto L14;
            r1.onAnimationStart(r4);
            return;
        }
    }

    ViewPropertyAnimatorCompat(View r2) {
        this.mStartAction = null;
        this.mEndAction = null;
        this.mOldLayerType = -1;
        this.mView = new WeakReference(r2);
    }

    static /* synthetic */ void lambda$setUpdateListener$0(ViewPropertyAnimatorUpdateListener r1, View r2, ValueAnimator r3) {
        ((ViewPropertyAnimatorUpdateListener) ZeusTransformUtils.wrapperContextForParams(r1, ViewPropertyAnimatorUpdateListener.class, "com.obric.memorydata.plugin")).onAnimationUpdate(r2);
    }

    private void setListenerInternal(final View r3, ViewPropertyAnimatorListener r4) {
        final ViewPropertyAnimatorListener r5 = (ViewPropertyAnimatorListener) ZeusTransformUtils.wrapperContextForParams(r4, ViewPropertyAnimatorListener.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        r3.animate().setListener(new AnonymousClass1(this, r5, r3));
        return;
    L5:
        r3.animate().setListener(null);
    }

    public ViewPropertyAnimatorCompat alpha(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().alpha(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().alphaBy(r4);
    L5:
        return this;
    }

    public void cancel() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.animate().cancel();
        return;
    }

    public long getDuration() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.animate().getDuration();
    }

    public Interpolator getInterpolator() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT >= 18) goto L7;
        return null;
    L7:
        return Api18Impl.getInterpolator(r2.animate());
    }

    public long getStartDelay() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.animate().getStartDelay();
    }

    public ViewPropertyAnimatorCompat rotation(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().rotation(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().rotationBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().rotationX(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().rotationXBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().rotationY(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().rotationYBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().scaleX(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().scaleXBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().scaleY(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().scaleYBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().setDuration(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator r4) {
        Interpolator r5 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r4, Interpolator.class, "com.obric.memorydata.plugin");
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().setInterpolator(r5);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener r4) {
        ViewPropertyAnimatorListener r5 = (ViewPropertyAnimatorListener) ZeusTransformUtils.wrapperContextForParams(r4, ViewPropertyAnimatorListener.class, "com.obric.memorydata.plugin");
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L9:
        return this;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        r0.setTag(LISTENER_TAG_ID, r5);
        r5 = new ViewPropertyAnimatorListenerApi14(this);
    L8:
        setListenerInternal(r0, r5);
        goto L9
    }

    public ViewPropertyAnimatorCompat setStartDelay(long r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().setStartDelay(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener r4) {
        final ViewPropertyAnimatorUpdateListener r5 = (ViewPropertyAnimatorUpdateListener) ZeusTransformUtils.wrapperContextForParams(r4, ViewPropertyAnimatorUpdateListener.class, "com.obric.memorydata.plugin");
        final View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L10:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        ValueAnimator.AnimatorUpdateListener r1 = null;
        if (r5 == null) goto L9;
        r1 = new $$Lambda$ViewPropertyAnimatorCompat$XOeeZ3zgiQP_YgNCy4Y7jVqc(r5, r0);
    L9:
        Api19Impl.setUpdateListener(r0.animate(), r1);
        goto L10
    }

    public void start() {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.animate().start();
        return;
    }

    public ViewPropertyAnimatorCompat translationX(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().translationX(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().translationXBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().translationY(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().translationYBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.translationZ(r0.animate(), r4);
        goto L7
    }

    public ViewPropertyAnimatorCompat translationZBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.translationZBy(r0.animate(), r4);
        goto L7
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withEndAction(r0.animate(), r5);
        goto L8
    L7:
        setListenerInternal(r0, new ViewPropertyAnimatorListenerApi14(this));
        this.mEndAction = r5;
        goto L8
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withLayer(r0.animate());
        goto L8
    L7:
        this.mOldLayerType = r0.getLayerType();
        setListenerInternal(r0, new ViewPropertyAnimatorListenerApi14(this));
        goto L8
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withStartAction(r0.animate(), r5);
        goto L8
    L7:
        setListenerInternal(r0, new ViewPropertyAnimatorListenerApi14(this));
        this.mStartAction = r5;
        goto L8
    }

    public ViewPropertyAnimatorCompat x(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().x(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().xBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat y(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().y(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r0.animate().yBy(r4);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat z(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.z(r0.animate(), r4);
        goto L7
    }

    public ViewPropertyAnimatorCompat zBy(float r4) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mView.get(), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.zBy(r0.animate(), r4);
        goto L7
    }
}
