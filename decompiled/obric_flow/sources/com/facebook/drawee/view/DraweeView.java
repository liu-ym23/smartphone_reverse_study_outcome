package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Objects;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DraweeView<DH extends DraweeHierarchy> extends AppCompatImageView {
    private static boolean sGlobalLegacyVisibilityHandlingEnabled = false;
    private float mAspectRatio;
    private DraweeHolder<DH> mDraweeHolder;
    private boolean mInitialised;
    private LazySizeAttach mLazySizeAttach;
    private boolean mLegacyVisibilityHandlingEnabled;
    private final AspectRatioMeasure$Spec mMeasureSpec;
    private SizeDeterminer mSizeDeterminer;

    public DraweeView(Context r5) {
        super(r5);
        this.mMeasureSpec = new AspectRatioMeasure$Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        a(r5);
    }

    public static /* synthetic */ void access$001(DraweeView r5, View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
    }

    public static /* synthetic */ void access$100(DraweeView r5) {
        r5.a();
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean r5) {
        sGlobalLegacyVisibilityHandlingEnabled = r5;
    }

    public final void a(Context r5) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L16
        if (this.mInitialised == false) goto L6;
        FrescoSystrace.a().getClass();
        return;
    L6:
        boolean r10 = true;
        this.mInitialised = true;     // Catch: Throwable -> L16
        this.mDraweeHolder = new DraweeHolder(null);     // Catch: Throwable -> L16
        this.mSizeDeterminer = new SizeDeterminer(this);     // Catch: Throwable -> L16
        ColorStateList r11 = getImageTintList();     // Catch: Throwable -> L16
        if (r11 != null) goto L11;
        FrescoSystrace.a().getClass();
        return;
    L11:
        setColorFilter(r11.getDefaultColor());     // Catch: Throwable -> L16
        if (sGlobalLegacyVisibilityHandlingEnabled == true) goto L14;
    L18:
        r10 = false;
    L19:
        this.mLegacyVisibilityHandlingEnabled = r10;     // Catch: Throwable -> L16
        FrescoSystrace.a().getClass();
        return;
    L14:
        if (r5.getApplicationInfo().targetSdkVersion < 24) goto L18;
    L16:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public void cancelLazySizeAttach() {
        LazySizeAttach r5 = this.mLazySizeAttach;
        if (r5 == null) goto L6;
        this.mSizeDeterminer.f7978b.remove(r5);
        this.mLazySizeAttach = null;
        return;
    }

    public void controllerAttachSizeDeterminer(DraweeController r5) {
        if ((r5 instanceof AbstractDraweeController) == false) goto L11;
        AbstractDraweeController r10 = (AbstractDraweeController) r5;
        ImageRequest r11 = (ImageRequest) r10.f7788r;
        if (r11 == null) goto L7;
        r11.getClass();
    L7:
        ImageRequest r12 = r10.s;
        if (r12 == null) goto L12;
        r12.getClass();
        return;
    L12:
        return;
    }

    public void doAttach() {
        this.mDraweeHolder.f();
    }

    public void doDetach() {
        this.mDraweeHolder.g();
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public DraweeController getController() {
        return this.mDraweeHolder.e;
    }

    public DH getHierarchy() {
        DH r5 = (DH) this.mDraweeHolder.d;
        r5.getClass();
        return r5;
    }

    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.d();
    }

    public boolean hasController() {
        if (this.mDraweeHolder.e == null) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean hasHierarchy() {
        if (this.mDraweeHolder.d == null) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean hasLazySizeAttached() {
        if (this.mLazySizeAttach == null) goto L6;
        return true;
    L6:
        return false;
    }

    public void onAttach() {
        doAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        onAttach();
    }

    public void onDetach() {
        doDetach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
        SizeDeterminer r5 = this.mSizeDeterminer;
        View r10 = (View) r5.f7977a.get();
        if (r10 == null) goto L7;
        ViewTreeObserver r11 = r10.getViewTreeObserver();
        if (r11.isAlive() == false) goto L7;
        r11.removeOnPreDrawListener(r5.f7979c);
    L7:
        r5.f7979c = null;
        r5.f7978b.clear();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        a();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r10, int r11) {
        AspectRatioMeasure$Spec r5 = this.mMeasureSpec;
        r5.f7934a = r10;
        r5.f7935b = r11;
        float r12 = this.mAspectRatio;
        ViewGroup.LayoutParams r13 = getLayoutParams();
        int r14 = getPaddingRight() + getPaddingLeft();
        int r15 = getPaddingBottom() + getPaddingTop();
        if (r12 <= 0.0f) goto L16;
        if (r13 == null) goto L16;
        int r16 = r13.height;
        if (r16 != 0) goto L9;
    L15:
        r5.f7935b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(r5.f7934a) - r14) / r12) + r15), r5.f7935b), BasicMeasure.EXACTLY);
        goto L16
    L9:
        if (r16 == (-2)) goto L15;
        int r17 = r13.width;
        if (r17 == 0) goto L14;
        if (r17 != (-2)) goto L16;
    L14:
        r5.f7934a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(r5.f7935b) - r15) * r12) + r14), r5.f7934a), BasicMeasure.EXACTLY);
    L16:
        AspectRatioMeasure$Spec r18 = this.mMeasureSpec;
        super.onMeasure(r18.f7934a, r18.f7935b);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        a();
        onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        DraweeHolder<DH> r10 = this.mDraweeHolder;
        if (r10.e() == false) goto L9;
        AbstractDraweeController r11 = (AbstractDraweeController) r10.e;
        r11.getClass();
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L9;
        FLog.a(AbstractDraweeController.f7774v, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(r11)), r11.f7778h, r5);
    L9:
        return super.onTouchEvent(r5);
    }

    @Override // android.view.View
    public void onVisibilityChanged(final View r5, final int r10) {
        UiThreadImmediateExecutorService.b().execute(new AnonymousClass1(this, r5, r10));
    }

    public void setAspectRatio(float r5) {
        if (r5 != this.mAspectRatio) goto L5;
        return;
    L5:
        this.mAspectRatio = r5;
        requestLayout();
    }

    public void setController(DraweeController r5) {
        cancelLazySizeAttach();
        controllerAttachSizeDeterminer(r5);
        this.mDraweeHolder.a(r5);
        super.setImageDrawable(this.mDraweeHolder.d());
    }

    public void setHierarchy(DH r5) {
        this.mDraweeHolder.a(r5);
        super.setImageDrawable(this.mDraweeHolder.d());
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap r5) {
        a(getContext());
        cancelLazySizeAttach();
        this.mDraweeHolder.a(null);
        super.setImageBitmap(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable r5) {
        a(getContext());
        cancelLazySizeAttach();
        this.mDraweeHolder.a(null);
        super.setImageDrawable(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    @Deprecated
    public void setImageResource(int r5) {
        a(getContext());
        cancelLazySizeAttach();
        this.mDraweeHolder.a(null);
        super.setImageResource(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri r5) {
        a(getContext());
        cancelLazySizeAttach();
        this.mDraweeHolder.a(null);
        super.setImageURI(r5);
    }

    public void setLazySizeAttach(LazySizeAttach r5) {
        if (this.mLazySizeAttach == null) goto L5;
        cancelLazySizeAttach();
    L5:
        this.mLazySizeAttach = r5;
        this.mSizeDeterminer.a(r5);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean r5) {
        this.mLegacyVisibilityHandlingEnabled = r5;
    }

    @Override // android.view.View
    public String toString() {
        Objects.ToStringHelper r5 = new Objects.ToStringHelper(getClass().getSimpleName());
        DraweeHolder<DH> r10 = this.mDraweeHolder;
        if (r10 == null) goto L5;
        String r11 = r10.toString();
    L7:
        return r5.a("holder", r11).toString();
    L5:
        r11 = "<no holder set>";
        goto L7
    }

    public DraweeView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mMeasureSpec = new AspectRatioMeasure$Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        a(r5);
    }

    public DraweeView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mMeasureSpec = new AspectRatioMeasure$Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        a(r5);
    }

    public final void a() {
        if (this.mLegacyVisibilityHandlingEnabled == false) goto L12;
        Drawable r5 = getDrawable();
        if (r5 != null) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L9;
        boolean r10 = true;
    L10:
        r5.setVisible(r10, false);
        return;
    L9:
        r10 = false;
        goto L10
    }

    public DraweeView(Context r5, AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11);
        this.mMeasureSpec = new AspectRatioMeasure$Spec();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        this.mLegacyVisibilityHandlingEnabled = false;
        a(r5);
    }
}
