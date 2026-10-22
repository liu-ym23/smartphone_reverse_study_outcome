package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.ColorUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FlattenUIImage extends LynxFlattenUI implements Drawable.Callback, t0 {
    public static final String EVENT_ERROR = "error";
    private oo.e mBigImageHelper;
    String mCapInsets;
    String mCapInsetsScale;
    private boolean mDeferInvalidation;
    private boolean mEnableImageAsyncRedirectOnCreate;
    private boolean mFrescoNinePatch;
    private final Handler mHandler;
    private boolean mHasPendingPlaceholder;
    private boolean mHasPendingSource;
    private Drawable mImageDrawable;
    protected final v0 mLynxImageManager;
    private String mOriginPlaceholder;
    private boolean mPendingLoad;
    private float mPreFetchHeight;
    private float mPreFetchWidth;
    private CloseableReference<?> mRef;
    private boolean mRepeat;
    private ScalingUtils.ScaleType mScaleType;
    private int mScrollState;
    private com.lynx.tasm.behavior.ui.q mScrollStateChangeListener;
    private int mShowCnt;
    private boolean mSkipRedirection;

    @Keep
    private String mSources;
    private boolean mSuspendable;
    private boolean mUseLocalCache;

    @Deprecated
    public FlattenUIImage(Context r5) {
        this((LynxContext) r5);
    }

    public static /* synthetic */ void access$000(FlattenUIImage r5) {
        r5.postInvalidate();
    }

    public static /* synthetic */ Map access$100(FlattenUIImage r5) {
        return r5.mEvents;
    }

    public static /* synthetic */ Map access$200(FlattenUIImage r5) {
        return r5.mEvents;
    }

    public static /* synthetic */ String access$300(FlattenUIImage r5) {
        return r5.mSources;
    }

    public static /* synthetic */ void access$400(FlattenUIImage r5) {
        r5.maybeUpdateView();
    }

    public static /* synthetic */ int access$502(FlattenUIImage r5, int r10) {
        r5.mScrollState = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$600(FlattenUIImage r5) {
        return r5.mPendingLoad;
    }

    public static /* synthetic */ boolean access$602(FlattenUIImage r5, boolean r10) {
        r5.mPendingLoad = r10;
        return r10;
    }

    private void attachWhenSetPrefetchSize() {
        if (this.mPreFetchWidth > 0.0f) goto L5;
        return;
    L5:
        if (this.mPreFetchHeight <= 0.0f) goto L13;
        v0 r5 = this.mLynxImageManager;
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.S == false) goto L15;
        r5.j();
        return;
    L15:
        return;
    }

    private void configureBounds() {
        Drawable r5 = this.mImageDrawable;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.setBounds(0, 0, getWidth(), getHeight());
    }

    private void maybeUpdateView() {
        if (this.mSuspendable == false) goto L9;
        if (this.mScrollState == 0) goto L9;
        this.mPendingLoad = true;
        return;
    L9:
        if (getWidth() <= 0) goto L11;
    L18:
        this.mLynxImageManager.b(getWidth(), getHeight(), this.mPaddingLeft + this.mBorderLeftWidth, this.mPaddingTop + this.mBorderTopWidth, this.mPaddingRight + this.mBorderRightWidth, this.mPaddingBottom + this.mBorderBottomWidth);
        return;
    L11:
        if (getHeight() > 0) goto L18;
        float r5 = this.mPreFetchWidth;
        if (r5 <= 0.0f) goto L18;
        float r10 = this.mPreFetchHeight;
        if (r10 <= 0.0f) goto L18;
        this.mLynxImageManager.b((int) r5, (int) r10, this.mPaddingLeft + this.mBorderLeftWidth, this.mPaddingTop + this.mBorderTopWidth, this.mPaddingRight + this.mBorderRightWidth, this.mPaddingBottom + this.mBorderBottomWidth);
    }

    private void onSourceSetted() {
        int r5 = this.mShowCnt + 1;
        this.mShowCnt = r5;
        oo.e r10 = this.mBigImageHelper;
        if (r10 == null) goto L6;
        r10.d = r5;
        r10.f();
        return;
    }

    private void postInvalidate() {
        Handler r5 = this.mHandler;
        if (r5 == null) goto L6;
        r5.post(new d(this, 1));
        return;
    }

    private void updateImageSource() {
        if (this.mSkipRedirection == true) goto L10;
        if (this.mHasPendingPlaceholder == false) goto L10;
        if (this.mHasPendingSource == false) goto L10;
        v0 r5 = this.mLynxImageManager;
        String r10 = this.mSources;
        String r11 = this.mOriginPlaceholder;
        r5.E.n(r10, r11);
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
    L10:
        if (this.mHasPendingSource == false) goto L17;
        if (this.mSkipRedirection == false) goto L14;
        v0 r12 = this.mLynxImageManager;
        String r13 = this.mSources;
        a0 r14 = r12.E;
        r14.f11017u = r13;
        r14.r(r13);
    L15:
        this.mHasPendingSource = false;
        goto L17
    L14:
        v0 r15 = this.mLynxImageManager;
        String r16 = this.mSources;
        r15.E.n(r16, null);
    L17:
        if (this.mHasPendingPlaceholder == false) goto L24;
        this.mHasPendingPlaceholder = false;
        v0 r17 = this.mLynxImageManager;
        String r18 = this.mOriginPlaceholder;
        boolean r19 = this.mSkipRedirection;
        a0 r20 = r17.E;
        if (r19 == true) goto L22;
        r20.n(null, r18);
        return;
    L22:
        r20.l(r18);
        return;
    }

    public v0 createImageManager(Context r5) {
        PipelineDraweeControllerBuilder r10 = ((PipelineDraweeControllerBuilderSupplier) Fresco.f7726a.a()).a();
        getLynxContext().getClass();
        return new v0(r5, r10, this, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        this.mLynxImageManager.k();
        oo.e r5 = this.mBigImageHelper;
        if (r5 == null) goto L5;
        r5.f();
    L5:
        CloseableReference<?> r10 = this.mRef;
        if (r10 == null) goto L9;
        r10.close();
        this.mRef = null;
        return;
    }

    public Drawable getImageDrawable() {
        return this.mImageDrawable;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public long getMemoryUsageBytes() {
        long r5 = super.getMemoryUsageBytes();
        v0 r10 = this.mLynxImageManager;
        if (r10 == null) goto L10;
        a0 r11 = r10.E;
        if (r11 != null) goto L7;
        long r12 = 0;
    L9:
        return r12 + r5;
    L7:
        r12 = r11.f11013p;
        goto L9
    L10:
        return r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public Map<String, String> getMemoryUsageDetail() {
        float r5 = getMemoryUsageBytes();
        String r10 = this.mSources;
        if (r5 == 0.0f) goto L13;
        if (r10 == null) goto L13;
        if (r10.isEmpty() == true) goto L13;
        if (r10.startsWith("data:image") == false) goto L11;
        return null;
    L11:
        HashMap r11 = new HashMap();
        r11.put(r10, String.valueOf(r5));
        return r11;
    L13:
        return null;
    }

    public String getSource() {
        return this.mSources;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable r5) {
        com.lynx.tasm.utils.j.f(new d(this, 0));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        this.mLynxImageManager.j();
        this.mLynxImageManager.f11121h = true;
        maybeUpdateView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onBorderRadiusUpdated(int r5) {
        v0 r10 = this.mLynxImageManager;
        com.lynx.tasm.behavior.ui.utils.d r11 = getLynxBackground().n();
        if (r10.f11123i != r11) goto L9;
        if (r11 != null) goto L6;
    L8:
        r10.f11121h = true;
    L10:
        r10.U = true;
        return;
    L6:
        if (r11.d == null) goto L8;
    L9:
        r10.f11123i = r11;
        r10.f11121h = true;
        goto L10
    }

    @Override // com.lynx.tasm.ui.image.t0
    public void onCloseableRefReady(CloseableReference<?> r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.mUseLocalCache == false) goto L9;
        this.mRef = r5.clone();
        invalidate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        this.mLynxImageManager.k();
        oo.e r5 = this.mBigImageHelper;
        if (r5 == null) goto L6;
        r5.f();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI
    public void onDraw(Canvas r15) {
        super.onDraw(r15);
        if (this.mPendingLoad == false) goto L6;
        return;
    L6:
        if (this.mImageDrawable == null) goto L8;
    L10:
        CloseableReference<?> r5 = this.mRef;
        String r10 = null;
        if (r5 == null) goto L34;
        monitor-enter(r5);
        boolean r11 = r5.f7670a;     // Catch: Throwable -> L30
        monitor-exit(r5);
        if (r11 == true) goto L34;
        if (this.mUseLocalCache == false) goto L34;
        Object r12 = this.mRef.c();
        if ((r12 instanceof CloseableBitmap) == false) goto L23;
        Bitmap r13 = ((CloseableStaticBitmap) ((CloseableBitmap) r12)).g;
    L21:
        Bitmap r14 = r13;
    L26:
        if (r14 == null) goto L34;
        LynxLog.b(2, "Lynx Android Flatten Image", "draw image from local cache");
        if (no.a.b(getWidth(), getHeight(), r14.getWidth(), r14.getHeight(), this.mScaleType, this.mCapInsets, this.mCapInsetsScale, r15, r14) == false) goto L34;
        return;
    L23:
        if ((r12 instanceof Bitmap) == false) goto L25;
        r13 = (Bitmap) r12;
        goto L21
    L25:
        r14 = null;
    L30:
        th = move-exception;
        throw th;
    L34:
        if (this.mFrescoNinePatch == false) goto L36;
    L46:
        v0 r16 = this.mLynxImageManager;
        if (r16.S == false) goto L61;
        Bitmap r17 = r16.f11113a0;
        if (r17 == null) goto L61;
        if (r17.isRecycled() == false) goto L61;
        LynxLog.b(4, "Lynx-Image", "bitmap has recycled and bitmap from cache is " + r16.f11115b0);
        return;
    L61:
        this.mImageDrawable.draw(r15);     // Catch: Throwable -> L56
        return;
    L56:
        th = move-exception;
        StringBuilder r18 = new StringBuilder();
        r18.append(th.getMessage());
        r18.append(", view sie:");
        r18.append(getWidth());
        r18.append("x");
        r18.append(getHeight());
        r18.append(", url:");
        com.lynx.tasm.behavior.ui.utils.e.i(r18, this.mSources, 4, "Lynx-Image");
        return;
    L36:
        if (this.mCapInsets == null) goto L46;
        LynxLog.b(2, "Lynx Android Flatten Image", "load origin bitmap to draw image with cap-insets");
        if (this.mBigImageHelper != null) goto L40;
        this.mBigImageHelper = new oo.e(new zm.z(this), this.mShowCnt);
    L40:
        int r19 = this.mShowCnt;
        float r20 = getWidth();
        float r21 = getHeight();
        boolean r22 = this.mRepeat;
        ScalingUtils.ScaleType r23 = this.mScaleType;
        oo.k r24 = this.mLynxImageManager.E.f11019w;
        if (r24 == null) goto L44;
        r10 = r24.a().toString();
    L44:
        if (this.mBigImageHelper.j(getLynxContext(), r15, this.mLynxImageManager.f11131q, new oo.b(r19, r20, r21, r22, r23, r10, oo.e.b(r15), this.mCapInsets, this.mCapInsetsScale)) == false) goto L46;
        return;
    L8:
        if (this.mRef != null) goto L10;
    }

    @Override // com.lynx.tasm.ui.image.t0
    public void onDrawableReady(Drawable r5) {
        this.mImageDrawable = r5;
        if (r5 == null) goto L11;
        r5.setCallback(this);
        int r10 = this.mImageRendering;
        if (r10 != 2) goto L8;
        this.mImageDrawable.setFilterBitmap(false);
        goto L11
    L8:
        if (r10 == 1) goto L10;
        if (r10 != 0) goto L11;
    L10:
        this.mImageDrawable.setFilterBitmap(true);
    L11:
        configureBounds();
        invalidate();
    }

    public void onImageLoaded() {
        configureBounds();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        v0 r5 = this.mLynxImageManager;
        if (r5 == null) goto L7;
        int r10 = getLeft();
        int r11 = getTop();
        int r12 = getLeft();
        int r13 = getWidth() + r12;
        int r14 = getTop();
        int r15 = getHeight() + r14;
        View r16 = r5.f11122h0;
        if (r16 == null) goto L7;
        r16.setLeft(r10);
        r5.f11122h0.setTop(r11);
        r5.f11122h0.setRight(r13);
        r5.f11122h0.setBottom(r15);
    L7:
        configureBounds();
        maybeUpdateView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        a0 r5 = this.mLynxImageManager.E;
        if (r5.S == false) goto L8;
        r5.S = false;
        if (r5.f11009l == false) goto L9;
        r5.d();
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.mEnableImageAsyncRedirectOnCreate == true) goto L5;
        updateImageSource();
    L5:
        maybeUpdateView();
    }

    @com.lynx.tasm.behavior.f0
    public void pauseAnimation(ReadableMap r5, Callback r10) {
        v0 r11 = this.mLynxImageManager;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.d(r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void renderIfNeeded() {
        maybeUpdateView();
    }

    @com.lynx.tasm.behavior.f0
    public void resumeAnimation(ReadableMap r5, Callback r10) {
        v0 r11 = this.mLynxImageManager;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.i() == true) goto L8;
        return;
    L8:
        if (r11.S == false) goto L10;
        Animatable r12 = r11.W;
    L11:
        r12.start();
        r10.invoke(new Object[]{0, "Animation resumed."});
        return;
    L10:
        r12 = ((AbstractDraweeController) r11.f11125k.e).a();
        goto L11
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10, long r11) {
        com.lynx.tasm.utils.j.a().postAtTime(r10, r5, r11);
    }

    @com.lynx.tasm.behavior.c0(name = "async-redirect")
    public void setAsyncRedirect(boolean r5) {
        this.mLynxImageManager.E.T = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "async-request")
    public void setAsyncRequest(boolean r5) {
        v0 r10 = this.mLynxImageManager;
        r10.S = r5;
        r10.E.F = r5;
        if (r5 == false) goto L10;
        r10.a();
        if (r10.K != null) goto L8;
        r10.f();
    L8:
        if (r10.i0 != null) goto L19;
        r10.i0 = new WeakReference(r10.F);
    L19:
        r10.f11121h = true;
        return;
    L10:
        CloseableReference r11 = r10.N;
        if (r11 == null) goto L13;
        r11.close();
        r10.N = null;
    L13:
        q0 r12 = r10.K;
        if (r12 == null) goto L16;
        r12.f11097b = false;
        r12.a();
    L16:
        r10.f11113a0 = null;
        CloseableReference r13 = r10.X;
        if (r13 == null) goto L19;
        r13.close();
        r10.X = null;
        goto L19
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = true, name = "autoplay")
    public void setAutoPlay(boolean r5) {
        this.mLynxImageManager.H = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "auto-size")
    public void setAutoSize(boolean r5) {
        v0 r10 = this.mLynxImageManager;
        a0 r11 = r10.E;
        r11.f11009l = r5;
        if (r5 == true) goto L5;
    L8:
        r11.d();
    L9:
        r11.f11022z.c();
        r10.A = !r5;
        return;
    L5:
        if (r11.e == 0) goto L9;
        if (r11.d == 0) goto L9;
        goto L8
    }

    @com.lynx.tasm.behavior.c0(name = "blur-radius")
    public void setBlurRadius(String r10) {
        UIBody r5 = this.mContext.f10145m;
        v0 r11 = this.mLynxImageManager;
        r11.E.e(Math.round(com.lynx.tasm.utils.k.c(r10, r5.getFontSize(), this.mFontSize, r5.getWidth(), r5.getHeight(), 0.0f, this.mContext.f10152u)));
    }

    @com.lynx.tasm.behavior.c0(name = "capInsets")
    public void setCapInsets(String r5) {
        if (r5 != null) goto L4;
    L7:
        this.mCapInsets = null;
    L8:
        v0 r10 = this.mLynxImageManager;
        String r11 = this.mCapInsets;
        a0 r12 = r10.E;
        r12.g = r11;
        r12.f11022z.c();
        return;
    L4:
        if (r5.equalsIgnoreCase("") == true) goto L7;
        this.mCapInsets = r5;
        goto L8
    }

    @com.lynx.tasm.behavior.c0(name = "cap-insets")
    public void setCapInsetsBackUp(String r5) {
        setCapInsets(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "cap-insets-scale")
    public void setCapInsetsScale(String r5) {
        if (r5 != null) goto L4;
    L7:
        this.mCapInsetsScale = null;
    L8:
        v0 r10 = this.mLynxImageManager;
        String r11 = this.mCapInsetsScale;
        a0 r12 = r10.E;
        r12.f11002h = r11;
        r12.f11022z.c();
        return;
    L4:
        if (r5.equalsIgnoreCase("") == true) goto L7;
        this.mCapInsetsScale = r5;
        goto L8
    }

    @com.lynx.tasm.behavior.c0(name = "additional-custom-info")
    public void setCustomParams(ReadableMap r5) {
        a0 r10 = this.mLynxImageManager.E;
        boolean r11 = r10.E.isEmpty();
        HashMap r12 = r10.E;
        if (r11 == true) goto L5;
        r12.clear();
    L5:
        if (r5 == null) goto L10;
        ReadableMapKeySetIterator r13 = r5.keySetIterator();
    L8:
        if (r13.hasNextKey() == false) goto L12;
        String r14 = r13.nextKey();
        r12.put(r14, r5.getString(r14, ""));
        goto L8
    L12:
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "defer-src-invalidation")
    public void setDeferInvalidation(boolean r5) {
        this.mDeferInvalidation = r5;
        this.mLynxImageManager.f11138y = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "disable-default-resize")
    public void setDisableDefaultResize(boolean r5) {
        v0 r10 = this.mLynxImageManager;
        if (r10 != null) goto L5;
        return;
    L5:
        a0 r11 = r10.E;
        if (r5 == false) goto L9;
        r11.f11014q = ImageResizeMethod.f10990c;
        r11.f11022z.c();
        return;
    L9:
        r11.f11014q = ImageResizeMethod.f10989b;
        r11.f11022z.c();
    }

    @com.lynx.tasm.behavior.c0(name = "enable-custom-gif-decoder")
    public void setEnableCustomGifDecoder(boolean r5) {
        this.mLynxImageManager.E.R = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "enable-resource-hint")
    public void setEnableResourceHint(boolean r5) {
        this.mLynxImageManager.E.f = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, on.a> r5) {
        super.setEvents(r5);
        if (r5 != null) goto L5;
        return;
    L5:
        this.mLynxImageManager.E.q(r5);
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "extra-load-info")
    public void setExtraLoadInfo(boolean r5) {
        v0 r10 = this.mLynxImageManager;
        r10.J = r5;
        r10.E.M = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "fresco-nine-patch")
    public void setFrescoNinePatch(boolean r5) {
        this.mFrescoNinePatch = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "cache-choice")
    public void setImageCacheChoice(String r5) {
        this.mLynxImageManager.E.f11005j = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(name = "image-config")
    public void setImageConfig(String r5) {
        super.setImageConfig(r5);
        v0 r10 = this.mLynxImageManager;
        Bitmap.Config r11 = this.mBitmapConfig;
        a0 r12 = r10.E;
        r12.f11012o = r11;
        r12.f11022z.c();
    }

    @com.lynx.tasm.behavior.c0(name = "placeholder-hash-config")
    public void setImagePlaceHolderHashConfig(ReadableMap r5) {
        this.mLynxImageManager.E.j(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setImageRendering(int r5) {
        super.setImageRendering(r5);
        v0 r10 = this.mLynxImageManager;
        if (r5 != 2) goto L5;
        boolean r11 = true;
    L6:
        r10.Z = r11;
        r10.f11121h = true;
        return;
    L5:
        r11 = false;
        goto L6
    }

    @com.lynx.tasm.behavior.c0(name = "fetch-priority")
    public void setImageRequestPriority(String r5) {
        this.mLynxImageManager.E.f11004i = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "enable-super-resolution")
    public void setImageSR(boolean r5) {
        v0 r10 = this.mLynxImageManager;
        if (r5 == true) goto L5;
    L7:
        a0 r11 = r10.E;
        r11.U = r5;
        r11.f11012o = Bitmap.Config.ARGB_8888;
        return;
    L5:
        if (r10.f11122h0 != null) goto L7;
        r10.f11122h0 = new View(r10.f11112a);
        goto L7
    }

    @com.lynx.tasm.behavior.c0(name = "super-resolution-scale")
    public void setImageSRScale(float r5) {
        a0 r10 = this.mLynxImageManager.E;
        if (r5 <= 0.0f) goto L6;
        r10.U = true;
        r10.f11012o = Bitmap.Config.ARGB_8888;
        r10.V = r5;
        return;
    L6:
        r10.U = false;
        r10.V = 0.0f;
    }

    @com.lynx.tasm.behavior.c0(name = "image-transition-style")
    public void setImageTransitionStyle(String r5) {
        v0 r10 = this.mLynxImageManager;
        if (r10 != null) goto L6;
        return;
    L6:
        if ("fadeIn".equals(r5) == false) goto L8;
        r10.T = 300;
    L9:
        GenericDraweeHierarchy r11 = r10.D;
        if (r11 == null) goto L15;
        int r12 = r10.T;
        FadeDrawable r13 = r11.f;
        r13.f7840k = r12;
        if (r13.f7839j != 1) goto L16;
        r13.f7839j = 0;
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r10.T = 0;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setLocalCache(pm.a r5) {
        super.setLocalCache(r5);
        if (this.mLynxImageManager != null) goto L5;
        return;
    L5:
        wn.c r10 = com.bytedance.apm.util.a.f(r5);
        boolean r11 = r10.f22882a;
        this.mUseLocalCache = r11;
        boolean r12 = r10.f22883b;
        a0 r13 = this.mLynxImageManager.E;
        r13.s = r11;
        r13.f11016t = r12;
    }

    @com.lynx.tasm.behavior.c0(name = "loop-count")
    public void setLoopCount(int r5) {
        if (r5 > 0) goto L4;
        r5 = 0;
    L4:
        this.mLynxImageManager.E.L = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "mode")
    public void setObjectFit(@Nullable String r5) {
        ScalingUtils.AbstractScaleType r10 = e0.a(r5);
        this.mScaleType = r10;
        v0 r11 = this.mLynxImageManager;
        r11.g = r10;
        r11.V = true;
        r11.f11121h = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setParent(com.lynx.tasm.behavior.ui.a0 r5) {
        super.setParent(r5);
        this.mLynxImageManager.j();
    }

    @com.lynx.tasm.behavior.c0(name = "placeholder")
    public void setPlaceholder(String r5) {
        this.mHasPendingPlaceholder = true;
        this.mOriginPlaceholder = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "prefetch-height")
    public void setPreFetchHeight(String r10) {
        this.mPreFetchHeight = com.lynx.tasm.utils.k.c(r10, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.f10152u);
        attachWhenSetPrefetchSize();
    }

    @com.lynx.tasm.behavior.c0(name = "prefetch-width")
    public void setPreFetchWidth(String r10) {
        this.mPreFetchWidth = com.lynx.tasm.utils.k.c(r10, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.f10152u);
        attachWhenSetPrefetchSize();
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "repeat")
    public void setRepeat(boolean r5) {
        this.mRepeat = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "android-simple-cache-key")
    public void setSimpleCacheKey(boolean r5) {
        v0 r10 = this.mLynxImageManager;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.E.f11007k = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "skip-redirection")
    public void setSkipRedirection(boolean r5) {
        this.mSkipRedirection = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "src")
    public void setSource(String r5) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        if (TextUtils.equals(r5, this.mLynxImageManager.E.f11017u) == false) goto L7;
    L13:
        this.mSources = r5;
        this.mHasPendingSource = true;
        onSourceSetted();
        invalidate();
        return;
    L7:
        if (this.mDeferInvalidation == true) goto L9;
        this.mImageDrawable = null;
    L9:
        CloseableReference<?> r10 = this.mRef;
        if (r10 == null) goto L12;
        r10.close();
        this.mRef = null;
    L12:
        v0 r11 = this.mLynxImageManager;
        r11.f11118d0 = 0;
        r11.f11119e0 = 0;
        goto L13
    }

    @com.lynx.tasm.behavior.c0(name = "suspendable")
    public void setSuspendable(pm.a r5) {
        this.mSuspendable = false;
        if (r5 == null) goto L12;
        int r10 = f.f11041a[r5.getType().ordinal()];
        if (r10 != 1) goto L7;
        this.mSuspendable = r5.asBoolean();
        goto L12
    L7:
        if (r10 != 2) goto L12;
        this.mSuspendable = TextUtils.equals("true", r5.asString());
    L12:
        if (this.mSuspendable == true) goto L16;
        unRegisterScrollStateListener(this.mScrollStateChangeListener);
        return;
    L16:
        if (this.mScrollStateChangeListener != null) goto L18;
        this.mScrollStateChangeListener = new e(this, 0);
    L18:
        registerScrollStateListener(this.mScrollStateChangeListener);
    }

    @com.lynx.tasm.behavior.c0(name = "tint-color")
    public void setTintColor(String r5) {
        v0 r10 = this.mLynxImageManager;
        r10.getClass();
        if (ColorUtils.a(r5) == true) goto L5;
        r10.I = null;
    L7:
        if (r10.S == false) goto L10;
        GenericDraweeHierarchy r11 = r10.D;
        PorterDuffColorFilter r12 = r10.I;
        r11.g.setColorFilter(r12);
        return;
    L10:
        b1 r13 = r10.f11128n;
        if (r13 == null) goto L15;
        PorterDuffColorFilter r14 = r10.I;
        BitmapDrawable r15 = r13.f11028h;
        if (r15 == null) goto L15;
        r15.setColorFilter(r14);
    L15:
        DraweeHolder r16 = r10.f11125k;
        if (r16 == null) goto L19;
        r16.d.getClass();
        DraweeHierarchy r17 = r10.f11125k.d;
        r17.getClass();
        PorterDuffColorFilter r18 = r10.I;
        ((GenericDraweeHierarchy) r17).g.setColorFilter(r18);
        return;
    L19:
        return;
    L5:
        r10.I = new PorterDuffColorFilter(ColorUtils.b(r5), PorterDuff.Mode.SRC_IN);
        goto L7
    }

    @com.lynx.tasm.behavior.f0
    public void startAnimate() {
        v0 r5 = this.mLynxImageManager;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.i() == true) goto L8;
        return;
    L8:
        if (r5.S == false) goto L10;
        r5.W.stop();
        r5.W.start();
        return;
    L10:
        ((AbstractDraweeController) r5.f11125k.e).a().stop();
        ((AbstractDraweeController) r5.f11125k.e).a().start();
    }

    @com.lynx.tasm.behavior.f0
    public void stopAnimation(ReadableMap r5, Callback r10) {
        v0 r11 = this.mLynxImageManager;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.i() == true) goto L8;
        return;
    L8:
        if (r11.S == false) goto L10;
        Animatable r12 = r11.W;
    L11:
        r12.stop();
        r10.invoke(new Object[]{0, "Animation stopped."});
        return;
    L10:
        r12 = ((AbstractDraweeController) r11.f11125k.e).a();
        goto L11
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable r5, @NonNull Runnable r10) {
        com.lynx.tasm.utils.j.a().removeCallbacks(r10, r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updatePropertiesInterval(com.lynx.tasm.behavior.y0 r5) {
        super.updatePropertiesInterval(r5);
        if (this.mSkipRedirection == true) goto L9;
        v0 r10 = this.mLynxImageManager;
        if (r10 == null) goto L9;
        String r11 = this.mSources;
        String r12 = this.mOriginPlaceholder;
        boolean r13 = this.mHasPendingSource;
        boolean r14 = this.mHasPendingPlaceholder;
        r10.E.o(r11, r12, r13, r14);
    L9:
        if (this.mEnableImageAsyncRedirectOnCreate == false) goto L12;
        updateImageSource();
        return;
    }

    public FlattenUIImage(LynxContext r5) {
        this(r5, null);
    }

    public FlattenUIImage(LynxContext r5, Object r10) {
        super(r5, r10);
        this.mImageDrawable = null;
        this.mPreFetchWidth = -1.0f;
        this.mPreFetchHeight = -1.0f;
        this.mUseLocalCache = false;
        this.mRef = null;
        this.mScaleType = ScalingUtils.ScaleType.f7893a;
        this.mCapInsets = null;
        this.mCapInsetsScale = null;
        this.mFrescoNinePatch = false;
        this.mSources = null;
        this.mOriginPlaceholder = null;
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
        this.mSkipRedirection = false;
        this.mDeferInvalidation = false;
        this.mScrollState = 0;
        v0 r11 = createImageManager(r5);
        this.mLynxImageManager = r11;
        r11.F = this;
        if (r11.S == false) goto L5;
        r11.i0 = new WeakReference(r11.F);
    L5:
        a0 r12 = r11.E;
        r12.D = this;
        r11.f11132r = new c(this, 0);
        r12.f11021y = new zm.c(this, 5);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mShowCnt = 0;
        this.mRepeat = false;
        this.mEnableImageAsyncRedirectOnCreate = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
    }

    @Deprecated
    public void setLocalCache(Boolean r5) {
        if (this.mLynxImageManager != null) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        this.mUseLocalCache = false;
    L7:
        boolean r10 = r5.booleanValue();
        this.mUseLocalCache = r10;
        this.mLynxImageManager.E.s = r10;
    }
}
