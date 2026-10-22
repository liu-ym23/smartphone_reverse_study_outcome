package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FrescoImageView extends SimpleDraweeView {
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    private boolean mAutoPlay;
    private oo.e mBigImageHelper;
    private com.lynx.tasm.behavior.ui.utils.d mBorderRadii;

    @Nullable
    private final Object mCallerContext;
    private boolean mConsumeHoverEvent;

    @Nullable
    private ControllerListener mControllerForTesting;

    @Nullable
    private ControllerListener mControllerListener;
    private boolean mCoverStart;
    private ImageRequest mCurImageRequest;
    private boolean mDeferInvalidation;
    private boolean mDisableDefaultPlaceholder;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private int mFadeDurationMs;
    private boolean mFixFrescoBug;
    private boolean mFrescoNinePatch;

    @Nullable
    private q mGlobalImageLoadListener;
    private a0 mImageDelegate;
    private int mImageOrigin;
    private c0 mImageRequestBuilderHook;
    protected boolean mIsBorderRadiusDirty;
    protected boolean mIsDirty;
    public boolean mIsFrescoAttach;
    public boolean mIsFrescoVisible;
    private boolean mIsNoSubSampleMode;
    private boolean mIsPixelated;
    private b0 mLoaderCallback;
    private LynxBaseUI mLynxBaseUI;
    private int mOverlayColor;
    private float mPreFetchHeight;
    private float mPreFetchWidth;
    private CloseableReference<?> mRef;
    private boolean mRepeat;
    private ScalingUtils.ScaleType mScaleType;
    private int mShowCnt;
    private int mSourceImageHeight;
    private int mSourceImageWidth;
    private long mStartTimeStamp;
    private CloseableReference<Bitmap> mTempPlaceHolder;
    private boolean mUsePostprocessorScaling;
    private n mWeakImageOriginListener;

    @Keep
    @Deprecated
    public FrescoImageView(Context r10, AbstractDraweeControllerBuilder r11, @Nullable q r12, @Nullable Object r13) {
        this(r10, r11, r12, r13, null);
    }

    public static /* synthetic */ int access$000(FrescoImageView r5) {
        return r5.mImageOrigin;
    }

    public static /* synthetic */ int access$002(FrescoImageView r5, int r10) {
        r5.mImageOrigin = r10;
        return r10;
    }

    public static /* synthetic */ void access$100(FrescoImageView r5) {
        r5.onSourceSetted();
    }

    public static /* synthetic */ long access$1000(FrescoImageView r5) {
        return r5.mStartTimeStamp;
    }

    public static /* synthetic */ a0 access$1100(FrescoImageView r5) {
        return r5.mImageDelegate;
    }

    public static /* synthetic */ LynxBaseUI access$1200(FrescoImageView r5) {
        return r5.mLynxBaseUI;
    }

    public static /* synthetic */ CloseableReference access$200(FrescoImageView r5) {
        return r5.mRef;
    }

    public static /* synthetic */ CloseableReference access$202(FrescoImageView r5, CloseableReference r10) {
        r5.mRef = r10;
        return r10;
    }

    public static /* synthetic */ CloseableReference access$300(FrescoImageView r5) {
        return r5.mTempPlaceHolder;
    }

    public static /* synthetic */ CloseableReference access$302(FrescoImageView r5, CloseableReference r10) {
        r5.mTempPlaceHolder = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$400(FrescoImageView r5) {
        return r5.mUsePostprocessorScaling;
    }

    public static /* synthetic */ b0 access$500(FrescoImageView r5) {
        return r5.mLoaderCallback;
    }

    public static /* synthetic */ void access$600(FrescoImageView r5, int r10, int r11, int r12, int r13, int r14, int r15) {
        r5.tryFetchImageFromFresco(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ boolean access$700(FrescoImageView r5) {
        return r5.mDisableDefaultPlaceholder;
    }

    public static /* synthetic */ ScalingUtils.ScaleType access$800(FrescoImageView r5) {
        return r5.mScaleType;
    }

    public static /* synthetic */ boolean access$900(FrescoImageView r5) {
        return r5.mIsPixelated;
    }

    private float[] adjustBorderRadiusArrayWithPadding(float[] r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length != 8) goto L13;
        float[] r5 = new float[8];
        int r11 = 0;
        r5[0] = getPaddingLeft();
        r5[1] = getPaddingTop();
        r5[2] = getPaddingRight();
        r5[3] = getPaddingTop();
        r5[4] = getPaddingRight();
        r5[5] = getPaddingBottom();
        r5[6] = getPaddingLeft();
        r5[7] = getPaddingBottom();
    L7:
        if (r11 >= 8) goto L9;
        r5[r11] = Math.max(0.0f, r10[r11] - r5[r11]);
        r11 = r11 + 1;
        goto L7
    L9:
        return r5;
    L13:
        return null;
    }

    private static GenericDraweeHierarchy buildHierarchy(Context r5) {
        GenericDraweeHierarchyBuilder r10 = new GenericDraweeHierarchyBuilder(r5.getResources());
        r10.f7926p = null;
        return r10.a();
    }

    private void maybeUpdateViewInternal(int r5, int r10, int r11, int r12, int r13, int r14) {
        a0 r15 = this.mImageDelegate;
        oo.k r16 = r15.f11019w;
        if (r16 == null) goto L5;
    L7:
        ImageResizeMethod r17 = r15.f11014q;
        if (r16 != null) goto L11;
    L24:
        this.mImageOrigin = -1;
        TraceEvent.c("FrescoImageView.maybeUpdateViewInternal");
        a0 r18 = this.mImageDelegate;
        if (r18.s == false) goto L34;
        if (r18.I == true) goto L29;
        r18.f(r5, r10);
        goto L34
    L29:
        if (r18.s(r5, r10) == false) goto L34;
        TraceEvent.a(0, "FrescoImageView.maybeUpdateViewInternal");
        return;
    L34:
        if (this.mImageDelegate.s == false) goto L51;
        CloseableReference<?> r19 = this.mRef;
        if (r19 == null) goto L48;
        monitor-enter(r19);
        boolean r20 = r19.f7670a;     // Catch: Throwable -> L44
        monitor-exit(r19);
        if (r20 == true) goto L48;
        if (this.mRef.c() == null) goto L48;
    L49:
        TraceEvent.a(0, "FrescoImageView.maybeUpdateViewInternal");
        return;
    L44:
        th = move-exception;
        throw th;
    L48:
        if (this.mImageDelegate.f11016t == true) goto L49;
    L51:
        tryFetchImageFromFresco(r5, r10, r11, r12, r13, r14);
        TraceEvent.a(0, "FrescoImageView.maybeUpdateViewInternal");
        return;
    L11:
        if (r17 != ImageResizeMethod.f10988a) goto L18;
        if (UriUtil.a(r16.a()) == true) goto L20;
        if ("file".equals(r16.a().getScheme()) == false) goto L24;
    L20:
        if (this.mImageDelegate.f11009l == true) goto L24;
        if (r5 <= 0) goto L23;
        if (r10 > 0) goto L24;
        return;
    L23:
        return;
    L18:
        if (r17 != ImageResizeMethod.f10989b) goto L24;
    L5:
        if (r15.f11020x != null) goto L7;
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

    private void tryFetchImageFromFresco(int r19, int r20, int r21, int r22, int r23, int r24) {
        TraceEvent.c("LynxImageManager.tryFetchImageFromFresco");
        GenericDraweeHierarchy r5 = getHierarchy();
        if (this.mFixFrescoBug == true) goto L8;
        ScalingUtils.ScaleType r10 = this.mScaleType;
        r5.getClass();
        r10.getClass();
        ScaleTypeDrawable r11 = r5.b(2);
        if (Objects.a(r11.d, r10) == true) goto L8;
        r11.d = r10;
        r11.e();
        r11.invalidateSelf();
    L8:
        ScalingUtils.ScaleType r12 = this.mScaleType;
        ScalingUtils.ScaleType r13 = ScalingUtils.ScaleType.g;
        if (r12 == r13) goto L11;
    L16:
        a0 r14 = this.mImageDelegate;
        boolean r15 = true;
        if (r14.U == true) goto L29;
        ScalingUtils.ScaleType r16 = this.mScaleType;
        if (r16 == r13) goto L29;
        if (r16 == ScalingUtils.ScaleType.f7896h) goto L29;
        if (r14.f11009l == true) goto L29;
        if (this.mIsPixelated == true) goto L29;
        if (r14.f == true) goto L29;
        boolean r17 = true;
    L30:
        this.mUsePostprocessorScaling = r17;
        com.lynx.tasm.behavior.ui.utils.d r18 = this.mBorderRadii;
        RoundingParams r25 = null;
        if (r18 != null) goto L33;
        float[] r110 = null;
    L38:
        if (this.mIsBorderRadiusDirty == true) goto L40;
    L47:
        int r26 = this.mFadeDurationMs;
        if (r26 >= 0) goto L51;
        r26 = 0;
    L51:
        FadeDrawable r27 = r5.f;
        r27.f7840k = r26;
        if (r27.f7839j != 1) goto L54;
        r27.f7839j = 0;
    L54:
        ImageRequest r111 = createImageRequest(this.mImageDelegate.f11019w, r19, r20, 0, 0, 0, 0, r110, this.mScaleType);
        ImageRequest r28 = this.mCurImageRequest;
        this.mCurImageRequest = r111;
        ImageRequest r29 = createImageRequest(this.mImageDelegate.f11020x, r19, r20, 0, 0, 0, 0, r110, this.mScaleType);
        if (this.mDeferInvalidation == false) goto L57;
        r29 = r28;
    L57:
        this.mDraweeControllerBuilder.b();
        WeakReference r30 = new WeakReference(this);
        AbstractDraweeControllerBuilder r31 = this.mDraweeControllerBuilder;
        r31.f = this.mAutoPlay;
        r31.f7796b = this.mCallerContext;
        r31.f7798h = getController();
        r31.f7797c = r111;
        if (r29 != null) goto L61;
        r15 = false;
    L61:
        r31.g = r15;
        r31.d = r29;
        String r32 = this.mImageDelegate.f11017u;
        this.mStartTimeStamp = System.currentTimeMillis();
        this.mControllerListener = new l(this, r30, r32);
        n r33 = new n();
        new WeakReference(this);
        this.mWeakImageOriginListener = r33;
        if (this.mControllerForTesting != null) goto L64;
        this.mDraweeControllerBuilder.e = this.mControllerListener;
    L69:
        AbstractDraweeControllerBuilder r34 = this.mDraweeControllerBuilder;
        if ((r34 instanceof PipelineDraweeControllerBuilder) == false) goto L72;
        ((PipelineDraweeControllerBuilder) r34).f7737n = this.mWeakImageOriginListener;
    L72:
        setController(r34.a());
        this.mIsDirty = false;
        a0 r35 = this.mImageDelegate;
        r35.f10995b = r19;
        r35.f10997c = r20;
        this.mDraweeControllerBuilder.b();
        TraceEvent.a(0, "LynxImageManager.tryFetchImageFromFresco");
        return;
    L64:
        ForwardingControllerListener r36 = new ForwardingControllerListener();
        ControllerListener r37 = this.mControllerListener;
        monitor-enter(r36);
        r36.f7805b.add(r37);     // Catch: Throwable -> L74
        monitor-exit(r36);     // Catch: Throwable -> L74
        r36.a(this.mControllerForTesting);
        this.mDraweeControllerBuilder.e = r36;
    L74:
        th = move-exception;
        throw th;
    L40:
        if (this.mUsePostprocessorScaling == true) goto L46;
        if (r110 == null) goto L46;
        r25 = RoundingParams.a(r110);
        int r38 = this.mOverlayColor;
        if (r38 == 0) goto L45;
        r25.d = r38;
        r25.f7927a = RoundingParams.RoundingMethod.f7930a;
        goto L46
    L45:
        r25.f7927a = RoundingParams.RoundingMethod.f7931b;
    L46:
        r5.a(r25);
        this.mIsBorderRadiusDirty = true;
        goto L47
    L33:
        if (r18.a((r19 + r21) + r23, (r20 + r22) + r24) == false) goto L35;
        this.mIsBorderRadiusDirty = true;
    L35:
        r110 = adjustBorderRadiusArrayWithPadding(this.mBorderRadii.c());
    L29:
        r17 = false;
        goto L30
    L11:
        if (this.mCoverStart == false) goto L16;
        m0 r39 = new m0();
        this.mScaleType = r39;
        r5.getClass();
        ScaleTypeDrawable r40 = r5.b(2);
        if (Objects.a(r40.d, r39) == true) goto L16;
        r40.d = r39;
        r40.e();
        r40.invalidateSelf();
        goto L16
    }

    public int bitmapMemorySize(int r5, int r10) {
        a0 r11 = this.mImageDelegate;
        if (r11 != null) goto L6;
        return 0;
    L6:
        Bitmap.Config r12 = r11.f11012o;
        if (r12 != null) goto L10;
        r12 = Bitmap.Config.ARGB_8888;
    L10:
        return td.b.a(r5, r10, r12);
    }

    public ImageRequest createImageRequest(oo.k r11, int r12, int r13, int r14, int r15, int r16, int r17, float[] r18, ScalingUtils.ScaleType r19) {
        return this.mImageDelegate.b(r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public ImageRequestBuilder createImageRequestBuilder(Uri r5) {
        a0 r10 = this.mImageDelegate;
        Bitmap.Config r11 = r10.f11012o;
        boolean r12 = r10.R;
        ImageRequestBuilder r13 = ImageRequestBuilder.a(r5);
        oo.g.b(r13, r11, r12);
        HashMap r14 = r10.E;
        if (r14.isEmpty() == true) goto L5;
        oo.g.c(r13, r14);
    L5:
        return r13;
    }

    public void destroy() {
        oo.e r5 = this.mBigImageHelper;
        if (r5 == null) goto L5;
        r5.f();
    L5:
        CloseableReference<?> r10 = this.mRef;
        if (r10 == null) goto L8;
        r10.close();
        this.mRef = null;
    L8:
        a0 r11 = this.mImageDelegate;
        r11.d = 0;
        r11.e = 0;
        if (this.mTempPlaceHolder == null) goto L15;
        GenericDraweeHierarchy r12 = getHierarchy();
        if (r12 == null) goto L13;
        r12.a(1, null);
    L13:
        this.mTempPlaceHolder.close();
        this.mTempPlaceHolder = null;
        return;
    }

    public void fixFrescoWebPBug(boolean r5) {
        this.mFixFrescoBug = r5;
    }

    public long getBitmapMemorySizeBytes() {
        a0 r5 = this.mImageDelegate;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.f11013p;
    }

    public ScalingUtils.ScaleType getFrescoScaleType() {
        return this.mScaleType;
    }

    public int getLoopCount() {
        return this.mImageDelegate.L;
    }

    public String getSrc() {
        oo.k r5 = this.mImageDelegate.f11019w;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.a().toString();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    @Keep
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void markDirty() {
        this.mIsDirty = true;
    }

    public void maybeUpdateView() {
        if (this.mIsDirty == false) goto L11;
        if (getWidth() <= 0) goto L9;
        if (getHeight() <= 0) goto L9;
    L16:
        if (getWidth() > 0) goto L18;
    L21:
        tryFetchImage((int) this.mPreFetchWidth, (int) this.mPreFetchHeight, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L18:
        if (getHeight() <= 0) goto L21;
        maybeUpdateViewInternal(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L9:
        if (this.mImageDelegate.f11009l == true) goto L16;
    L11:
        if (this.mPreFetchWidth > 0.0f) goto L16;
        if (this.mPreFetchHeight > 0.0f) goto L16;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void onAttach() {
        this.mStartTimeStamp = System.currentTimeMillis();
        doAttach();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    @Keep
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsFrescoVisible == false) goto L6;
        setFrescoVisible();
    L6:
        if (this.mIsFrescoAttach == false) goto L9;
        setFrescoAttach();
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r22) {
        b0 r5 = this.mLoaderCallback;
        if (r5 == null) goto L7;
        r5.a(getWidth(), getHeight());
        if (this.mLoaderCallback.c() == false) goto L7;
        return;
    L7:
        CloseableReference<?> r10 = this.mRef;
        if (r10 == null) goto L32;
        monitor-enter(r10);
        boolean r11 = r10.f7670a;     // Catch: Throwable -> L27
        monitor-exit(r10);
        if (r11 == true) goto L32;
        if (this.mImageDelegate.s == false) goto L32;
        Object r12 = this.mRef.c();
        if ((r12 instanceof CloseableBitmap) == false) goto L20;
        Bitmap r13 = ((CloseableStaticBitmap) ((CloseableBitmap) r12)).g;
    L18:
        Bitmap r14 = r13;
        if (r14 == null) goto L32;
        LynxLog.b(2, "Lynx Android Image", "draw image from local cache");
        int r15 = r22.getWidth();
        int r16 = r22.getHeight();
        int r17 = r14.getWidth();
        int r18 = r14.getHeight();
        ScalingUtils.ScaleType r19 = this.mScaleType;
        a0 r20 = this.mImageDelegate;
        if (no.a.b(r15, r16, r17, r18, r19, r20.g, r20.f11002h, r22, r14) == false) goto L32;
        return;
    L20:
        if ((r12 instanceof Bitmap) == false) goto L22;
        r13 = (Bitmap) r12;
        goto L18
    L22:
        r13 = null;
    L27:
        th = move-exception;
        throw th;
    L32:
        if (this.mFrescoNinePatch == true) goto L42;
        if (this.mImageDelegate.g == null) goto L42;
        LynxLog.b(2, "Lynx Android Image", "load origin bitmap to draw image with cap-insets");
        if (this.mBigImageHelper != null) goto L38;
        this.mBigImageHelper = new oo.e(new g8.g(this, 6), this.mShowCnt);
    L38:
        int r110 = this.mShowCnt;
        float r111 = getWidth();
        float r112 = getHeight();
        boolean r113 = this.mRepeat;
        ScalingUtils.ScaleType r21 = this.mScaleType;
        String r114 = getSrc();
        Point r115 = oo.e.b(r22);
        a0 r23 = this.mImageDelegate;
        if (this.mBigImageHelper.j(getContext(), r22, this.mCurImageRequest, new oo.b(r110, r111, r112, r113, r21, r114, r115, r23.g, r23.f11002h)) == false) goto L42;
        return;
    L42:
        if (TraceEvent.f10115c == false) goto L50;
        HashMap r24 = new HashMap();
        LynxBaseUI r25 = this.mLynxBaseUI;
        if (r25 != null) goto L46;
    L48:
        TraceEvent.b(0, "FrescoImageView.onDraw", r24);
        goto L50
    L46:
        if (r25.getLynxContext() == null) goto L48;
        r24.put("instance_id", String.valueOf(this.mLynxBaseUI.getLynxContext().A));
    L50:
        if (this.mIsNoSubSampleMode == true) goto L58;
        if (getController() != null) goto L54;
    L104:
        super.onDraw(r22);     // Catch: OutOfMemoryError -> L98
    L100:
        TraceEvent.a(0, "FrescoImageView.onDraw");
        return;
    L98:
        e = move-exception;
        LynxLog.b(4, "FrescoImageView", e.getMessage());
        goto L100
    L54:
        if (((AbstractDraweeController) getController()).a() != null) goto L104;
        if (this.mImageDelegate.g != null) goto L104;
    L58:
        if (this.mBigImageHelper != null) goto L60;
        this.mBigImageHelper = new oo.e(new g8.g(this, 6), this.mShowCnt);
    L60:
        int r26 = this.mShowCnt;
        float r27 = getWidth();
        float r28 = getHeight();
        boolean r29 = this.mRepeat;
        ScalingUtils.ScaleType r30 = this.mScaleType;
        String r116 = getSrc();
        Point r117 = oo.e.b(r22);
        a0 r31 = this.mImageDelegate;
        oo.b r32 = new oo.b(r26, r27, r28, r29, r30, r116, r117, r31.g, r31.f11002h);
        if (this.mIsNoSubSampleMode == false) goto L73;
        oo.e r33 = this.mBigImageHelper;
        Context r34 = getContext();
        ImageRequest r35 = this.mCurImageRequest;
        r33.e = true;
        oo.d r36 = r33.f20800b;
        if (r36 != null) goto L65;
    L70:
        r33.f();
        r33.g(r34, r35, r32);
        r33.h(r22, r33.f20800b);
    L71:
        TraceEvent.a(0, "FrescoImageView.onDraw");
        return;
    L65:
        if (r36.d == null) goto L70;
        if (r36.f.f20791a != r26) goto L70;
        r33.h(r22, r36);
        goto L71
    L73:
        LynxBaseUI r37 = this.mLynxBaseUI;
        if (r37 != null) goto L76;
        DisplayMetrics r38 = DisplayMetricsHolder.b(getContext());
    L77:
        oo.e r118 = this.mBigImageHelper;
        Context r119 = getContext();
        ImageRequest r120 = this.mCurImageRequest;
        r118.getClass();
        if (r38 == null) goto L104;
        if (r27 <= (r38.widthPixels * 3)) goto L82;
    L85:
        r118.e = false;
        LynxLog.b(1, "LynxImageHelper", "drawBigImage: w:" + r27 + ", h:" + r28);
        oo.d r39 = r118.f20800b;
        if (r39 != null) goto L88;
    L93:
        r118.f();
        r118.g(r119, r120, r32);
        r118.h(r22, r118.f20800b);
    L94:
        TraceEvent.a(0, "FrescoImageView.onDraw");
        return;
    L88:
        if (r39.d == null) goto L93;
        if (r39.f.f20791a != r26) goto L93;
        r118.h(r22, r39);
        goto L94
    L82:
        if (r28 > r38.heightPixels) goto L85;
        if (r29 == true) goto L85;
    L76:
        r38 = r37.getLynxContext().f10152u;
        goto L77
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r5) {
        if (super.onHoverEvent(r5) == false) goto L5;
        return true;
    L5:
        if (this.mConsumeHoverEvent == true) goto L11;
        return false;
    L11:
        return true;
    }

    public void onImageRequestLoaded() {
    }

    public void onNodeReady() {
        a0 r5 = this.mImageDelegate;
        if (r5.S == false) goto L8;
        r5.S = false;
        if (r5.f11009l == false) goto L9;
        r5.d();
        return;
    L9:
        return;
    }

    public void onPostprocessorPreparing(List<Postprocessor> r5) {
    }

    @Override // android.view.View
    @Keep
    public void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (r5 <= 0) goto L7;
        if (r10 <= 0) goto L8;
        maybeUpdateView();
        return;
    L8:
        return;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        return super.onTouchEvent(r5);
    L4:
        th = move-exception;
        LynxLog.b(4, "Lynx FrescoImageView", "catch onTouchEvent exception: " + th.toString());
        return false;
    }

    public boolean pauseAnimate() {
        if (getController() != null) goto L5;
        return false;
    L5:
        if (((AbstractDraweeController) getController()).a() == null) goto L12;
        AnimatedDrawable2 r5 = ((AbstractDraweeController) getController()).a();
        if ((r5 instanceof AnimatedDrawable2) == true) goto L9;
        return false;
    L9:
        return oo.g.d(r5);
    L12:
        return false;
    }

    public void setAsyncRedirect(boolean r5) {
        this.mImageDelegate.T = r5;
    }

    public void setAutoPlay(boolean r5) {
        this.mAutoPlay = r5;
    }

    public void setAutoSize(boolean r5) {
        a0 r10 = this.mImageDelegate;
        r10.f11009l = r5;
        if (r5 == true) goto L5;
    L8:
        r10.d();
    L9:
        r10.f11022z.c();
        return;
    L5:
        if (r10.e == 0) goto L9;
        if (r10.d == 0) goto L9;
        goto L8
    }

    public void setAwaitLocalCache(boolean r5) {
        this.mImageDelegate.f11016t = r5;
    }

    public void setBitmapConfig(Bitmap.Config r5) {
        a0 r10 = this.mImageDelegate;
        r10.f11012o = r5;
        r10.f11022z.c();
    }

    public void setBlurRadius(int r5) {
        this.mImageDelegate.e(r5);
    }

    public void setBorderRadius(com.lynx.tasm.behavior.ui.utils.d r5) {
        this.mBorderRadii = r5;
        this.mIsDirty = true;
        this.mIsBorderRadiusDirty = true;
    }

    public void setCapInsets(@Nullable String r5) {
        a0 r10 = this.mImageDelegate;
        r10.g = r5;
        r10.f11022z.c();
    }

    public void setCapInsetsScale(@Nullable String r5) {
        a0 r10 = this.mImageDelegate;
        r10.f11002h = r5;
        r10.f11022z.c();
    }

    public void setConsumeHoverEvent(boolean r5) {
        this.mConsumeHoverEvent = r5;
    }

    public void setControllerListener(ControllerListener r5) {
        this.mControllerForTesting = r5;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    public void setCoverStart(boolean r5) {
        this.mCoverStart = r5;
        this.mIsDirty = true;
    }

    public void setDeferInvalidation(boolean r5) {
        this.mDeferInvalidation = r5;
    }

    public void setDisableDefaultPlaceHolder(boolean r5) {
        this.mDisableDefaultPlaceholder = r5;
    }

    public void setEnableCustomGifDecoder(boolean r5) {
        this.mImageDelegate.R = r5;
    }

    public void setEnableImageSR(boolean r5) {
        a0 r10 = this.mImageDelegate;
        r10.U = r5;
        r10.f11012o = Bitmap.Config.ARGB_8888;
    }

    public void setEnableResourceHint(boolean r5) {
        this.mImageDelegate.f = r5;
    }

    public void setExtraLoadInfo(boolean r5) {
        this.mImageDelegate.M = r5;
    }

    public void setFadeDuration(int r5) {
        this.mFadeDurationMs = r5;
    }

    public void setFrescoAttach() {
        doAttach();
    }

    public void setFrescoNinePatch(boolean r5) {
        this.mFrescoNinePatch = r5;
    }

    public void setFrescoVisible() {
        Drawable r5 = getDrawable();
        if (r5 == null) goto L6;
        r5.setVisible(true, false);
        return;
    }

    public void setHeaders(ReadableMap r5) {
        this.mImageDelegate.B = r5;
    }

    public void setImageCacheChoice(String r5) {
        this.mImageDelegate.f11005j = r5;
    }

    public void setImageCustomParams(ReadableMap r5) {
        a0 r10 = this.mImageDelegate;
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

    public void setImageEvents(Map<String, on.a> r5) {
        this.mImageDelegate.q(r5);
    }

    public void setImageLoaderCallback(b0 r5) {
        this.mLoaderCallback = r5;
    }

    public void setImagePlaceHolderHashConfig(ReadableMap r5) {
        this.mImageDelegate.j(r5);
    }

    public void setImageRedirectListener(r r5) {
        this.mImageDelegate.f11021y = r5;
    }

    public void setImageRequestBuilderHook(c0 r5) {
    }

    public void setImageRequestPriority(String r5) {
        this.mImageDelegate.f11004i = r5;
    }

    public void setImageSRScale(float r5) {
        a0 r10 = this.mImageDelegate;
        if (r5 <= 0.0f) goto L6;
        r10.U = true;
        r10.f11012o = Bitmap.Config.ARGB_8888;
        r10.V = r5;
        return;
    L6:
        r10.U = false;
        r10.V = 0.0f;
    }

    public void setImageTransitionStyle(String r5) {
        if ("fadeIn".equals(r5) == false) goto L6;
        this.mFadeDurationMs = 300;
        return;
    L6:
        this.mFadeDurationMs = 0;
    }

    public void setIsPixelated(boolean r5) {
        this.mIsPixelated = r5;
        this.mIsDirty = true;
    }

    public void setLocalCache(boolean r5) {
        this.mImageDelegate.s = r5;
    }

    public void setLoopCount(int r5) {
        this.mImageDelegate.L = r5;
    }

    public void setLynxBaseUI(LynxBaseUI r5) {
        this.mLynxBaseUI = r5;
        this.mImageDelegate.D = r5;
    }

    public void setNoSubSampleMode(boolean r5) {
        this.mIsNoSubSampleMode = r5;
    }

    public void setOverlayColor(int r5) {
        this.mOverlayColor = r5;
        this.mIsDirty = true;
    }

    public void setPlaceholder(String r5) {
        this.mImageDelegate.n(null, r5);
    }

    public void setPreFetchHeight(float r5) {
        this.mPreFetchHeight = r5;
    }

    public void setPreFetchWidth(float r5) {
        this.mPreFetchWidth = r5;
    }

    public void setProgressiveRenderingEnabled(boolean r5) {
        this.mImageDelegate.f11011n = r5;
    }

    public void setRedirectImageSource(String r5, String r10) {
        this.mImageDelegate.n(r5, r10);
    }

    public void setRepeat(boolean r5) {
        this.mRepeat = r5;
    }

    public void setResizeMethod(ImageResizeMethod r5) {
        a0 r10 = this.mImageDelegate;
        r10.f11014q = r5;
        r10.f11022z.c();
    }

    public void setScaleType(ScalingUtils.ScaleType r5) {
        this.mScaleType = r5;
        this.mIsDirty = true;
    }

    public void setSimpleCacheKey(boolean r5) {
        this.mImageDelegate.f11007k = r5;
    }

    @Deprecated
    public void setSource(@Nullable String r5) {
        this.mImageDelegate.r(r5);
    }

    public void setSrc(String r5) {
        this.mImageDelegate.n(r5, null);
    }

    public void setSrcSkippingRedirection(String r5) {
        a0 r10 = this.mImageDelegate;
        r10.f11017u = r5;
        r10.r(r5);
    }

    public void setTintColor(String r5) {
        if (ColorUtils.a(r5) == true) goto L5;
        PorterDuffColorFilter r10 = null;
    L7:
        if (getHierarchy() == null) goto L10;
        getHierarchy().g.setColorFilter(r10);
        return;
    L10:
        return;
    L5:
        r10 = new PorterDuffColorFilter(ColorUtils.b(r5), PorterDuff.Mode.SRC_IN);
        goto L7
    }

    public void startAnimate() {
        if (getController() != null) goto L5;
        return;
    L5:
        if (((AbstractDraweeController) getController()).a() == null) goto L9;
        ((AbstractDraweeController) getController()).a().start();
        return;
    }

    public void stopAnimate() {
        if (getController() != null) goto L5;
        return;
    L5:
        if (((AbstractDraweeController) getController()).a() == null) goto L9;
        ((AbstractDraweeController) getController()).a().stop();
        return;
    }

    public void tryFetchImage(int r5, int r10, int r11, int r12, int r13, int r14) {
        maybeUpdateViewInternal(r5, r10, r11, r12, r13, r14);
    }

    public void updateRedirectCheckResult(String r5, String r10, boolean r11, boolean r12) {
        this.mImageDelegate.o(r5, r10, r11, r12);
    }

    @Keep
    public FrescoImageView(Context r5, AbstractDraweeControllerBuilder r10, @Nullable q r11, @Nullable Object r12, LynxBaseUI r13) {
        super(r5, buildHierarchy(r5));
        this.mUsePostprocessorScaling = false;
        this.mSourceImageWidth = 0;
        this.mSourceImageHeight = 0;
        this.mPreFetchWidth = -1.0f;
        this.mPreFetchHeight = -1.0f;
        this.mIsFrescoVisible = false;
        this.mIsFrescoAttach = false;
        this.mFrescoNinePatch = false;
        this.mAutoPlay = true;
        this.mIsPixelated = false;
        this.mFadeDurationMs = 0;
        this.mBorderRadii = null;
        this.mIsNoSubSampleMode = false;
        this.mRef = null;
        this.mDisableDefaultPlaceholder = false;
        this.mTempPlaceHolder = null;
        this.mConsumeHoverEvent = false;
        this.mLynxBaseUI = null;
        this.mImageOrigin = -1;
        this.mScaleType = ScalingUtils.ScaleType.f7893a;
        this.mDraweeControllerBuilder = r10;
        this.mCallerContext = r12;
        this.mShowCnt = 0;
        this.mRepeat = false;
        this.mCoverStart = false;
        a0 r14 = new a0(r5, new com.lynx.tasm.behavior.ui.utils.n(this));
        this.mImageDelegate = r14;
        r14.f11000e0 = getHierarchy();
        setLynxBaseUI(r13);
    }

    public void setPlaceholder(String r5, boolean r10) {
        a0 r11 = this.mImageDelegate;
        if (r10 == false) goto L6;
        r11.n(null, r5);
        return;
    L6:
        r11.l(r5);
    }
}
