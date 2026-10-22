package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrescoImageView extends SimpleDraweeView implements x6a.e {
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    private boolean mAutoPlay;
    private m8a.d mBigImageHelper;
    private BorderRadius mBorderRadii;
    private final Object mCallerContext;
    private boolean mConsumeHoverEvent;
    private ControllerListener mControllerForTesting;
    private ControllerListener mControllerListener;
    private boolean mCoverStart;
    private ImageRequest mCurImageRequest;
    private boolean mDeferInvalidation;
    private boolean mDisableDefaultPlaceholder;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private int mFadeDurationMs;
    private boolean mFixFrescoBug;
    private boolean mFrescoNinePatch;
    private e mGlobalImageLoadListener;
    private h mImageDelegate;
    private int mImageOrigin;
    private m mImageRequestBuilderHook;
    protected boolean mIsBorderRadiusDirty;
    protected boolean mIsDirty;
    public boolean mIsFrescoAttach;
    public boolean mIsFrescoVisible;
    private boolean mIsNoSubSampleMode;
    private boolean mIsPixelated;
    private l mLoaderCallback;
    private LynxBaseUI mLynxBaseUI;
    private int mOverlayColor;
    private float mPreFetchHeight;
    private float mPreFetchWidth;
    private CloseableReference<?> mRef;
    private x6a.i mRenderer;
    private boolean mRepeat;
    private ScalingUtils.ScaleType mScaleType;
    private int mShowCnt;
    private int mSourceImageHeight;
    private int mSourceImageWidth;
    private long mStartTimeStamp;
    private CloseableReference<Bitmap> mTempPlaceHolder;
    private boolean mUsePostprocessorScaling;

    public class a implements h.c {
        public final /* synthetic */ FrescoImageView a;

        @Override // com.lynx.tasm.ui.image.h.c
        public final void a() {
            this.a.maybeUpdateView();
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void clear() {
            this.a.setController(null);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.ImageView, com.lynx.tasm.ui.image.FrescoImageView] */
        @Override // com.lynx.tasm.ui.image.h.c
        public final void d() {
            ?? r0 = this.a;
            FrescoImageView.access$500(r0, r0.getWidth(), this.a.getHeight(), this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final boolean e() {
            return FrescoImageView.access$300(this.a);
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void g() {
            FrescoImageView.access$000(this.a);
            if (FrescoImageView.access$100(this.a) == null) goto L6;
            FrescoImageView.access$100(this.a).close();
            FrescoImageView.access$102(this.a, null);
        L6:
            if (FrescoImageView.access$200(this.a) == null) goto L12;
            GenericDraweeHierarchy r0 = this.a.getHierarchy();
            if (r0 == null) goto L10;
            r0.setPlaceholderImage(null);
        L10:
            FrescoImageView.access$200(this.a).close();
            FrescoImageView.access$202(this.a, null);
            return;
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void markDirty() {
            this.a.markDirty();
        }

        public a(FrescoImageView r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void b(List<Postprocessor> r2) {
            this.a.onPostprocessorPreparing(r2);
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final ImageRequestBuilder c(Uri r2) {
            return this.a.createImageRequestBuilder(r2);
        }

        @Override // com.lynx.tasm.ui.image.h.c
        public final void f(CloseableReference<?> r3) {
            Bitmap r1 = null;
            if (FrescoImageView.access$100(this.a) == null) goto L5;
            FrescoImageView.access$100(this.a).close();
            FrescoImageView.access$102(this.a, null);
        L5:
            FrescoImageView.access$102(this.a, r3.clone());
            if (FrescoImageView.access$400(this.a) != null) goto L8;
        L20:
            this.a.postInvalidate();
            return;
        L8:
            if (FrescoImageView.access$100(this.a) == null) goto L20;
            Object r4 = FrescoImageView.access$100(this.a).get();
            if ((r4 instanceof CloseableBitmap) == false) goto L13;
            r1 = ((CloseableBitmap) r4).getUnderlyingBitmap();
        L15:
            if (r1 != null) goto L17;
        L19:
            LLog.e("FrescoImageView", "onLocalCacheGet error bitmap is null or recycled");
            goto L20
        L17:
            if (r1.isRecycled() == true) goto L19;
            FrescoImageView.access$400(this.a).onImageLoadSuccess(r1.getWidth(), r1.getHeight());
            goto L20
        L13:
            if ((r4 instanceof Bitmap) == false) goto L15;
            r1 = (Bitmap) r4;
            goto L15
        }
    }

    public class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ String b;
        public final /* synthetic */ FrescoImageView c;

        public final void onSubmit(String r1, Object r2) {
        }

        public final void onFailure(String r17, Throwable r18) {
            if (FrescoImageView.access$900(this.c).m(this.b) == false) goto L5;
            return;
        L5:
            this.c.mIsDirty = true;
            int r1 = u7a.b.a(r18);
            int r2 = u7a.b.b(r1);
            if (FrescoImageView.access$400(this.c) == null) goto L15;
            LynxError r3 = new LynxError(r2, "Android FrescoImageView loading image failed", NameKeys.UnloadStrategy_No_Strategy, "error");
            if (r18 == null) goto L11;
            r3.setRootCause(r18.getMessage());
        L11:
            if (FrescoImageView.access$1200(this.c) == null) goto L13;
            int r4 = FrescoImageView.access$1200(this.c).getNodeIndex();
        L14:
            r3.addCustomInfo("node_index", Integer.toString(r4));
            FrescoImageView.access$400(this.c).onImageLoadFailed(r3, r2, r1);
            goto L15
        L13:
            r4 = 0;
        L15:
            FrescoImageView.access$1002(this.c, -1);
            long r13 = System.currentTimeMillis();
            FrescoImageView.access$900(this.c).j(FrescoImageView.access$900(this.c).v, false, FrescoImageView.access$1100(this.c), r13, 0, null);
            FrescoImageView.access$900(this.c).l(FrescoImageView.access$900(this.c).v, false, false, FrescoImageView.access$1100(this.c), r13, r1, 0);
            FrescoImageView.access$900(this.c).k(FrescoImageView.access$900(this.c).v, r1, false, FrescoImageView.access$1000(this.c), FrescoImageView.access$1100(this.c), r13, false, 0, 0);
            h r5 = FrescoImageView.access$900(this.c);
            FrescoImageView.access$1100(this.c);
            FrescoImageView.access$1000(this.c);
            r18.getMessage();
            r5.getClass();
            LLog.e("FrescoImageView", "onFailed src:" + this.b + "with reason" + r18.getMessage());
        }

        public b(FrescoImageView r1, WeakReference r2, String r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }

        public final void onFinalImageSet(String r11, Object r12, Animatable r13) {
            CloseableStaticBitmap r3 = (ImageInfo) r12;
            if (this.a.get() == null) goto L6;
            ((FrescoImageView) this.a.get()).onImageRequestLoaded();
        L6:
            if (FrescoImageView.access$600(this.c) == false) goto L20;
            if ((r3 instanceof CloseableStaticBitmap) == false) goto L20;
            if (FrescoImageView.access$200(this.c) == null) goto L12;
            FrescoImageView.access$200(this.c).close();
            FrescoImageView.access$202(this.c, null);
        L12:
            FrescoImageView.access$202(this.c, r3.cloneUnderlyingBitmapReference());
            GenericDraweeHierarchy r14 = this.c.getHierarchy();
            if (r14 == null) goto L20;
            if (FrescoImageView.access$200(this.c) == null) goto L20;
            if (FrescoImageView.access$200(this.c).get() == null) goto L20;
            r14.setPlaceholderImage(new ScaleTypeDrawable(new BitmapDrawable(this.c.getResources(), (Bitmap) FrescoImageView.access$200(this.c).get()), FrescoImageView.access$700(this.c)));
        L20:
            if (FrescoImageView.access$800(this.c) == false) goto L25;
            if (this.c.getTopLevelDrawable() == null) goto L25;
            this.c.getTopLevelDrawable().setFilterBitmap(false);
        L25:
            if (FrescoImageView.access$900(this.c).r0 == null) goto L28;
            if (r3 == null) goto L28;
            FrescoImageView r15 = this.c;
            FrescoImageView.access$1002(r15, FrescoImageView.access$900(r15).r0.getImageOrigin(r3));
        L28:
            FrescoImageView.access$900(this.c).h(this.c.getWidth(), this.c.getHeight(), r3, r13, FrescoImageView.access$1100(this.c), false, FrescoImageView.access$1000(this.c), FrescoImageView.access$400(this.c));
        }
    }

    public class c implements m8a.d.b {
        public final /* synthetic */ FrescoImageView a;

        @Override // m8a.d.b
        public final void onImageLoadFailed(String r1) {
        }

        public c(FrescoImageView r1) {
            this.a = r1;
        }

        @Override // m8a.d.b
        public final void onImageLoadSuccess(m8a.d.c r2) {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            this.a.invalidate();
            return;
        L5:
            this.a.postInvalidate();
        }
    }

    public static class d {
        public final int a;
        public final int b;

        public d(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        x6a.d.a(this, r1, r2);
    }

    public /* bridge */ /* synthetic */ void applyRendererOpacity(float r1) {
        x6a.d.b(this, r1);
    }

    public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r1) {
        x6a.d.c(this, r1);
    }

    public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return x6a.d.d(this, r1);
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x6a.e
    public View getView() {
        return this;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public /* bridge */ /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    public void markDirty() {
        this.mIsDirty = true;
    }

    public void onImageRequestLoaded() {
    }

    public void onPostprocessorPreparing(List<Postprocessor> r1) {
    }

    public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public void setImageRequestBuilderHook(m r1) {
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    private void onSourceSetted() {
        int r0 = this.mShowCnt + 1;
        this.mShowCnt = r0;
        m8a.d r1 = this.mBigImageHelper;
        if (r1 == null) goto L6;
        r1.d = r0;
        r1.f();
        return;
    }

    public void destroy() {
        m8a.d r0 = this.mBigImageHelper;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        CloseableReference<?> r1 = this.mRef;
        if (r1 == null) goto L8;
        r1.close();
        this.mRef = null;
    L8:
        h r2 = this.mImageDelegate;
        r2.d = 0;
        r2.e = 0;
        if (this.mTempPlaceHolder == null) goto L15;
        GenericDraweeHierarchy r3 = getHierarchy();
        if (r3 == null) goto L13;
        r3.setPlaceholderImage(null);
    L13:
        this.mTempPlaceHolder.close();
        this.mTempPlaceHolder = null;
        return;
    }

    public long getBitmapMemorySizeBytes() {
        h r0 = this.mImageDelegate;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.q;
    }

    public int getLoopCount() {
        return this.mImageDelegate.N;
    }

    public String getSrc() {
        m8a.g r0 = this.mImageDelegate.x;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void maybeUpdateView() {
        if (this.mIsDirty == false) goto L11;
        if (getWidth() <= 0) goto L9;
        if (getHeight() <= 0) goto L9;
    L16:
        if (getWidth() > 0) goto L18;
    L20:
        tryFetchImage((int) this.mPreFetchWidth, (int) this.mPreFetchHeight, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L18:
        if (getHeight() <= 0) goto L20;
        maybeUpdateViewInternal(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L9:
        if (this.mImageDelegate.m == true) goto L16;
    L11:
        if (this.mPreFetchWidth > 0.0f) goto L16;
        if (this.mPreFetchHeight > 0.0f) goto L16;
    }

    public void onNodeReady() {
        h r0 = this.mImageDelegate;
        if (r0.W == false) goto L8;
        r0.W = false;
        if (r0.m == false) goto L9;
        r0.i();
        return;
    L9:
        return;
    }

    public void onAttach() {
        this.mStartTimeStamp = System.currentTimeMillis();
        super/*com.facebook.drawee.view.DraweeView*/.onAttach();
    }

    public void onDetachedFromWindow() {
        super/*com.facebook.drawee.view.DraweeView*/.onDetachedFromWindow();
        if (this.mIsFrescoVisible == false) goto L6;
        setFrescoVisible();
    L6:
        if (this.mIsFrescoAttach == false) goto L9;
        setFrescoAttach();
        return;
    }

    public boolean pauseAnimate() {
        if (getController() != null) goto L5;
        return false;
    L5:
        if (getController().getAnimatable() == null) goto L12;
        AnimatedDrawable2 r0 = getController().getAnimatable();
        if ((r0 instanceof AnimatedDrawable2) == true) goto L9;
        return false;
    L9:
        return m8a.e.d(r0);
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFrescoVisible() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L6;
        r0.setVisible(true, false);
        return;
    }

    public void startAnimate() {
        if (getController() != null) goto L5;
        return;
    L5:
        if (getController().getAnimatable() == null) goto L9;
        getController().getAnimatable().start();
        return;
    }

    public void stopAnimate() {
        if (getController() != null) goto L5;
        return;
    L5:
        if (getController().getAnimatable() == null) goto L9;
        getController().getAnimatable().stop();
        return;
    }

    public ScalingUtils.ScaleType getFrescoScaleType() {
        return this.mScaleType;
    }

    @Override // x6a.e
    public x6a.i getRenderer() {
        return this.mRenderer;
    }

    public void setFrescoAttach() {
        doAttach();
    }

    public static /* synthetic */ void access$000(FrescoImageView r0) {
        r0.onSourceSetted();
    }

    public static /* synthetic */ CloseableReference access$100(FrescoImageView r0) {
        return r0.mRef;
    }

    public static /* synthetic */ int access$1000(FrescoImageView r0) {
        return r0.mImageOrigin;
    }

    public static /* synthetic */ long access$1100(FrescoImageView r2) {
        return r2.mStartTimeStamp;
    }

    public static /* synthetic */ LynxBaseUI access$1200(FrescoImageView r0) {
        return r0.mLynxBaseUI;
    }

    public static /* synthetic */ CloseableReference access$200(FrescoImageView r0) {
        return r0.mTempPlaceHolder;
    }

    public static /* synthetic */ boolean access$300(FrescoImageView r0) {
        return r0.mUsePostprocessorScaling;
    }

    public static /* synthetic */ l access$400(FrescoImageView r0) {
        return r0.mLoaderCallback;
    }

    public static /* synthetic */ boolean access$600(FrescoImageView r0) {
        return r0.mDisableDefaultPlaceholder;
    }

    public static /* synthetic */ ScalingUtils.ScaleType access$700(FrescoImageView r0) {
        return r0.mScaleType;
    }

    public static /* synthetic */ boolean access$800(FrescoImageView r0) {
        return r0.mIsPixelated;
    }

    public static /* synthetic */ h access$900(FrescoImageView r0) {
        return r0.mImageDelegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private float[] adjustBorderRadiusArrayWithPadding(float[] r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.length != 8) goto L13;
        float[] r0 = new float[8];
        int r3 = 0;
        r0[0] = getPaddingLeft();
        r0[1] = getPaddingTop();
        r0[2] = getPaddingRight();
        r0[3] = getPaddingTop();
        r0[4] = getPaddingRight();
        r0[5] = getPaddingBottom();
        r0[6] = getPaddingLeft();
        r0[7] = getPaddingBottom();
    L7:
        if (r3 >= 8) goto L9;
        r0[r3] = Math.max(0.0f, r6[r3] - r0[r3]);
        r3 = r3 + 1;
        goto L7
    L9:
        return r0;
    L13:
        return null;
    }

    private static GenericDraweeHierarchy buildHierarchy(Context r1) {
        return new GenericDraweeHierarchyBuilder(r1.getResources()).setRoundingParams(null).build();
    }

    public ImageRequestBuilder createImageRequestBuilder(Uri r2) {
        return this.mImageDelegate.e(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchDraw(Canvas r2) {
        super/*android.widget.ImageView*/.dispatchDraw(r2);
        x6a.i r0 = this.mRenderer;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public void fixFrescoWebPBug(boolean r1) {
        this.mFixFrescoBug = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r15) {
        prepareRendererForDraw(r15);
        l r0 = this.mLoaderCallback;
        if (r0 == null) goto L7;
        r0.onImageDstSize(getWidth(), getHeight());
        if (this.mLoaderCallback.isPendingLoad() == false) goto L7;
        return;
    L7:
        CloseableReference<?> r1 = this.mRef;
        if (r1 == null) goto L26;
        if (r1.isValid() == false) goto L26;
        if (this.mImageDelegate.t == false) goto L26;
        Object r2 = this.mRef.get();
        if ((r2 instanceof CloseableBitmap) == false) goto L18;
        Bitmap r3 = ((CloseableBitmap) r2).getUnderlyingBitmap();
    L16:
        Bitmap r10 = r3;
        if (r10 == null) goto L26;
        LLog.i("Lynx Android Image", "draw image from local cache");
        int r4 = r15.getWidth();
        int r5 = r15.getHeight();
        int r6 = r10.getWidth();
        int r7 = r10.getHeight();
        ScalingUtils.ScaleType r8 = this.mScaleType;
        h r9 = this.mImageDelegate;
        if (l8a.a.customDraw(r4, r5, r6, r7, r8, r9.g, r9.h, r15, r10) == false) goto L26;
        return;
    L18:
        if ((r2 instanceof Bitmap) == false) goto L20;
        r3 = (Bitmap) r2;
        goto L16
    L20:
        r3 = null;
    L26:
        if (this.mFrescoNinePatch == true) goto L38;
        if (this.mImageDelegate.g == null) goto L38;
        if (LynxEnv.inst().disableBigImageHelper() == true) goto L38;
        LLog.i("Lynx Android Image", "load origin bitmap to draw image with cap-insets");
        if (this.mBigImageHelper != null) goto L34;
        this.mBigImageHelper = new m8a.d(new c(this), this.mShowCnt);
    L34:
        int r11 = this.mShowCnt;
        float r12 = getWidth();
        float r13 = getHeight();
        boolean r14 = this.mRepeat;
        ScalingUtils.ScaleType r16 = this.mScaleType;
        String r17 = getSrc();
        Point r18 = m8a.d.l(r15);
        h r19 = this.mImageDelegate;
        if (this.mBigImageHelper.i(getContext(), r15, this.mCurImageRequest, new m8a.d.a(r11, r12, r13, r14, r16, r17, r18, r19.g, r19.h)) == false) goto L38;
        return;
    L38:
        if (TraceEvent.isTracingStarted() == false) goto L54;
        HashMap r20 = new HashMap();
        LynxBaseUI r21 = this.mLynxBaseUI;
        if (r21 != null) goto L42;
    L44:
        String r22 = this.mImageDelegate.v;
        if (r22 != null) goto L47;
    L49:
        boolean r23 = false;
    L50:
        if (r23 == false) goto L52;
        r20.put(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, this.mImageDelegate.v);
    L52:
        TraceEvent.beginSection("FrescoImageView.onDraw", r20);
        goto L54
    L47:
        if (r22.startsWith("http") == false) goto L49;
        r23 = true;
        goto L50
    L42:
        if (r21.getLynxContext() == null) goto L44;
        r20.put("instance_id", String.valueOf(this.mLynxBaseUI.getLynxContext().getInstanceId()));
    L54:
        if (LynxEnv.inst().disableBigImageHelper() == false) goto L56;
    L90:
        super/*android.widget.ImageView*/.onDraw(r15);     // Catch: OutOfMemoryError -> L84
    L87:
        if (TraceEvent.isTracingStarted() == false) goto L94;
        TraceEvent.endSection("FrescoImageView.onDraw");
        return;
    L94:
        return;
    L84:
        e = move-exception;
        LLog.e("FrescoImageView", e.getMessage());
        goto L87
    L56:
        if (this.mIsNoSubSampleMode == true) goto L64;
        if (getController() == null) goto L90;
        if (getController().getAnimatable() != null) goto L90;
        if (this.mImageDelegate.g != null) goto L90;
    L64:
        if (this.mBigImageHelper != null) goto L66;
        this.mBigImageHelper = new m8a.d(new c(this), this.mShowCnt);
    L66:
        int r24 = this.mShowCnt;
        float r25 = getWidth();
        float r26 = getHeight();
        boolean r27 = this.mRepeat;
        ScalingUtils.ScaleType r28 = this.mScaleType;
        String r110 = getSrc();
        Point r111 = m8a.d.l(r15);
        h r29 = this.mImageDelegate;
        m8a.d.a r30 = new m8a.d.a(r24, r25, r26, r27, r28, r110, r111, r29.g, r29.h);
        if (this.mIsNoSubSampleMode == false) goto L72;
        this.mBigImageHelper.j(getContext(), r15, this.mCurImageRequest, r30);
        if (TraceEvent.isTracingStarted() == false) goto L92;
        TraceEvent.endSection("FrescoImageView.onDraw");
        return;
    L92:
        return;
    L72:
        LynxBaseUI r31 = this.mLynxBaseUI;
        if (r31 != null) goto L75;
        DisplayMetrics r32 = DisplayMetricsHolder.getRealScreenDisplayMetrics(getContext());
    L77:
        if (this.mBigImageHelper.h(getContext(), r15, this.mCurImageRequest, r30, r32) == false) goto L90;
        if (TraceEvent.isTracingStarted() == false) goto L93;
        TraceEvent.endSection("FrescoImageView.onDraw");
        return;
    L93:
        return;
    L75:
        r32 = r31.getLynxContext().getScreenMetrics();
        goto L77
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onHoverEvent(MotionEvent r1) {
        if (super/*android.widget.ImageView*/.onHoverEvent(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mConsumeHoverEvent == true) goto L8;
        return false;
    }

    public boolean onTouchEvent(MotionEvent r3) {
        return super/*com.facebook.drawee.view.DraweeView*/.onTouchEvent(r3);
    L4:
        th = move-exception;
        LLog.e("Lynx FrescoImageView", "catch onTouchEvent exception: " + th.toString());
        return false;
    }

    public void prepareRendererForDraw(Canvas r2) {
        if (this.mRenderer == null) goto L6;
        this.mRenderer.g(r2);
        this.mRenderer.c(r2);
        return;
    }

    public void setAsyncRedirect(boolean r2) {
        this.mImageDelegate.X = r2;
    }

    public void setAutoPlay(boolean r1) {
        this.mAutoPlay = r1;
    }

    public void setAutoSize(boolean r2) {
        h r0 = this.mImageDelegate;
        r0.m = r2;
        if (r2 == true) goto L5;
    L8:
        r0.i();
    L9:
        r0.A.markDirty();
        return;
    L5:
        if (r0.e == 0) goto L9;
        if (r0.d == 0) goto L9;
        goto L8
    }

    public void setAwaitLocalCache(boolean r2) {
        this.mImageDelegate.u = r2;
    }

    public void setBitmapConfig(Bitmap.Config r2) {
        h r0 = this.mImageDelegate;
        r0.p = r2;
        r0.A.markDirty();
    }

    public void setBlurRadius(int r2) {
        this.mImageDelegate.p(r2);
    }

    public void setBorderRadius(BorderRadius r1) {
        this.mBorderRadii = r1;
        this.mIsDirty = true;
        this.mIsBorderRadiusDirty = true;
    }

    public void setCacheKeyPathOnly(boolean r2) {
        this.mImageDelegate.l = r2;
    }

    public void setCapInsets(String r2) {
        h r0 = this.mImageDelegate;
        r0.g = r2;
        r0.A.markDirty();
    }

    public void setCapInsetsScale(String r2) {
        h r0 = this.mImageDelegate;
        r0.h = r2;
        r0.A.markDirty();
    }

    public void setConsumeHoverEvent(boolean r1) {
        this.mConsumeHoverEvent = r1;
    }

    public void setControllerListener(ControllerListener r1) {
        this.mControllerForTesting = r1;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    public void setCoverStart(boolean r1) {
        this.mCoverStart = r1;
        this.mIsDirty = true;
    }

    public void setDeferInvalidation(boolean r1) {
        this.mDeferInvalidation = r1;
    }

    public void setDisableDefaultPlaceHolder(boolean r1) {
        this.mDisableDefaultPlaceholder = r1;
    }

    public void setEnableCustomGifDecoder(boolean r2) {
        this.mImageDelegate.V = r2;
    }

    public void setEnableImageSR(boolean r2) {
        h r0 = this.mImageDelegate;
        r0.Y = r2;
        r0.p = Bitmap.Config.ARGB_8888;
    }

    public void setEnableReportInfo(boolean r2) {
        this.mImageDelegate.Q = r2;
    }

    public void setEnableResourceHint(boolean r2) {
        this.mImageDelegate.f = r2;
    }

    public void setExtraLoadInfo(boolean r2) {
        this.mImageDelegate.P = r2;
    }

    public void setFadeDuration(int r1) {
        this.mFadeDurationMs = r1;
    }

    public void setFrescoNinePatch(boolean r1) {
        this.mFrescoNinePatch = r1;
    }

    public void setHeaders(ReadableMap r2) {
        this.mImageDelegate.C = r2;
    }

    public void setImageCacheChoice(String r2) {
        this.mImageDelegate.j = r2;
    }

    public void setImageCustomParams(ReadableMap r2) {
        this.mImageDelegate.q(r2);
    }

    public void setImageEvents(Map<String, EventsListener> r2) {
        this.mImageDelegate.r(r2);
    }

    public void setImageLoaderCallback(l r1) {
        this.mLoaderCallback = r1;
    }

    public void setImagePlaceHolderHashConfig(ReadableMap r2) {
        this.mImageDelegate.s(r2);
    }

    public void setImageRedirectListener(f r2) {
        this.mImageDelegate.z = r2;
    }

    public void setImageRequestPriority(String r2) {
        this.mImageDelegate.i = r2;
    }

    public void setImageSRScale(float r4) {
        h r0 = this.mImageDelegate;
        if (r4 <= 0.0f) goto L5;
        r0.Y = true;
        r0.p = Bitmap.Config.ARGB_8888;
        r0.Z = r4;
        return;
    L5:
        r0.Y = false;
        r0.Z = 0.0f;
    }

    public void setImageTransitionStyle(String r2) {
        if ("fadeIn".equals(r2) == false) goto L5;
        this.mFadeDurationMs = 300;
        return;
    L5:
        this.mFadeDurationMs = 0;
    }

    public void setIsPixelated(boolean r1) {
        this.mIsPixelated = r1;
        this.mIsDirty = true;
    }

    public void setLocalCache(boolean r2) {
        this.mImageDelegate.t = r2;
    }

    public void setLoopCount(int r2) {
        this.mImageDelegate.N = r2;
    }

    public void setLynxBaseUI(LynxBaseUI r2) {
        this.mLynxBaseUI = r2;
        this.mImageDelegate.E = r2;
    }

    public void setNoSubSampleMode(boolean r2) {
        this.mIsNoSubSampleMode = r2;
        this.mImageDelegate.n0 = r2;
    }

    public void setOverlayColor(int r1) {
        this.mOverlayColor = r1;
        this.mIsDirty = true;
    }

    public void setPlaceholder(String r3) {
        this.mImageDelegate.u(null, r3);
    }

    public void setPreFetchHeight(float r1) {
        this.mPreFetchHeight = r1;
    }

    public void setPreFetchWidth(float r1) {
        this.mPreFetchWidth = r1;
    }

    public void setProgressiveRendering(boolean r2) {
        this.mImageDelegate.l0 = r2;
    }

    public void setProgressiveRenderingEnabled(boolean r2) {
        this.mImageDelegate.o = r2;
    }

    public void setRegionToDecode(Rect r3) {
        h r0 = this.mImageDelegate;
        if (r3 != null) goto L5;
        r0.m0 = null;
    L6:
        this.mIsDirty = true;
        return;
    L5:
        r0.getClass();
        r0.m0 = new Rect(r3);
        goto L6
    }

    @Override // x6a.e
    public void setRenderer(x6a.i r1) {
        this.mRenderer = r1;
    }

    public void setRepeat(boolean r1) {
        this.mRepeat = r1;
    }

    public void setResizeMethod(ImageResizeMethod r2) {
        h r0 = this.mImageDelegate;
        r0.r = r2;
        r0.A.markDirty();
    }

    public void setScaleType(ScalingUtils.ScaleType r1) {
        this.mScaleType = r1;
        this.mIsDirty = true;
    }

    public void setSimpleCacheKey(boolean r2) {
        this.mImageDelegate.k = r2;
    }

    public void setSmoothAnimation(boolean r2) {
        this.mImageDelegate.O = r2;
    }

    public void setSource(String r2) {
        this.mImageDelegate.w(r2);
    }

    public void setSrc(String r3) {
        this.mImageDelegate.v(r3, true);
    }

    public void setSrcSkippingRedirection(String r3) {
        this.mImageDelegate.v(r3, false);
    }

    public void setTintColor(String r3) {
        if (ColorUtils.a(r3) == true) goto L5;
        PorterDuffColorFilter r4 = null;
    L7:
        if (getHierarchy() == null) goto L10;
        getHierarchy().setActualImageColorFilter(r4);
        return;
    L10:
        return;
    L5:
        r4 = new PorterDuffColorFilter(ColorUtils.b(r3), PorterDuff.Mode.SRC_IN);
        goto L7
    }

    public static /* synthetic */ int access$1002(FrescoImageView r0, int r1) {
        r0.mImageOrigin = r1;
        return r1;
    }

    public static /* synthetic */ CloseableReference access$102(FrescoImageView r0, CloseableReference r1) {
        r0.mRef = r1;
        return r1;
    }

    public static /* synthetic */ CloseableReference access$202(FrescoImageView r0, CloseableReference r1) {
        r0.mTempPlaceHolder = r1;
        return r1;
    }

    public int bitmapMemorySize(int r2, int r3) {
        h r0 = this.mImageDelegate;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c(r2, r3);
    }

    @Override // x6a.e
    public x6a.i createRenderer(PlatformRendererContext r2, int r3) {
        return new x6a.i(r2, r3);
    }

    public void setPlaceholder(String r2, boolean r3) {
        h r0 = this.mImageDelegate;
        if (r3 == false) goto L5;
        r0.u(null, r2);
        return;
    L5:
        r0.t(r2);
    }

    public void setRedirectImageSource(String r2, String r3) {
        this.mImageDelegate.u(r2, r3);
    }

    public FrescoImageView(Context r7, AbstractDraweeControllerBuilder r8, e r9, Object r10) {
        this(r7, r8, r9, r10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L7;
        if (r2 <= 0) goto L8;
        maybeUpdateView();
        return;
    L8:
        return;
    }

    public void updateRedirectCheckResult(String r2, String r3, boolean r4, boolean r5) {
        this.mImageDelegate.z(r2, r3, r4, r5);
    }

    public FrescoImageView(Context r2, AbstractDraweeControllerBuilder r3, e r4, Object r5, LynxBaseUI r6) {
        super(r2, buildHierarchy(r2));
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
        this.mScaleType = ScalingUtils.ScaleType.FIT_XY;
        this.mDraweeControllerBuilder = r3;
        this.mCallerContext = r5;
        this.mShowCnt = 0;
        this.mRepeat = false;
        this.mCoverStart = false;
        h r7 = new h(r2, new a(this));
        this.mImageDelegate = r7;
        r7.i0 = getHierarchy();
        setLynxBaseUI(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        if (r2 == false) goto L8;
        x6a.i r0 = this.mRenderer;
        if (r0 == null) goto L8;
        LynxBaseUI r1 = r0.h;
        if (r1 == null) goto L8;
        r1.measure();
    L8:
        super/*android.widget.ImageView*/.onLayout(r2, r3, r4, r5, r6);
    }

    private void maybeUpdateViewInternal(int r4, int r5, int r6, int r7, int r8, int r9) {
        h r0 = this.mImageDelegate;
        m8a.g r1 = r0.x;
        if (r1 != null) goto L8;
        if (r0.y != null) goto L8;
        return;
    L8:
        if (m8a.f.a(r1, r0.r) == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L17;
        if (r4 <= 0) goto L16;
        if (r5 > 0) goto L17;
        return;
    L16:
        return;
    L17:
        this.mImageOrigin = -1;
        l r3 = this.mLoaderCallback;
        if (r3 == null) goto L20;
        r3.onImageStartLoad();
    L20:
        TraceEvent.beginSection("FrescoImageView.maybeUpdateViewInternal");
        h r10 = this.mImageDelegate;
        if (r10.t == false) goto L30;
        if (r10.K == true) goto L25;
        r10.x(r4, r5);
        goto L30
    L25:
        if (r10.y(r4, r5) == false) goto L30;
        TraceEvent.endSection("FrescoImageView.maybeUpdateViewInternal");
        return;
    L30:
        if (this.mImageDelegate.t == false) goto L41;
        CloseableReference<?> r11 = this.mRef;
        if (r11 == null) goto L38;
        if (r11.isValid() == false) goto L38;
        if (this.mRef.get() == null) goto L38;
    L39:
        TraceEvent.endSection("FrescoImageView.maybeUpdateViewInternal");
        return;
    L38:
        if (this.mImageDelegate.u == true) goto L39;
    L41:
        tryFetchImageFromFresco(r4, r5, r6, r7, r8, r9);
        TraceEvent.endSection("FrescoImageView.maybeUpdateViewInternal");
        return;
    L10:
        if (this.mImageDelegate.m == true) goto L12;
        r2 = true;
        goto L13
    }

    private void tryFetchImageFromFresco(int r20, int r21, int r22, int r23, int r24, int r25) {
        if (TraceEvent.isTracingStarted() == false) goto L13;
        HashMap r0 = new HashMap();
        String r1 = this.mImageDelegate.v;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L12;
        r0.put(LynxEventReporter.PROP_NAME_URL, this.mImageDelegate.v);
    L12:
        TraceEvent.beginSection("LynxImageManager.tryFetchImageFromFresco", r0);
        goto L13
    L7:
        if (r1.startsWith("http") == false) goto L9;
        r2 = true;
    L13:
        GenericDraweeHierarchy r3 = getHierarchy();
        if (this.mFixFrescoBug == true) goto L16;
        r3.setActualImageScaleType(this.mScaleType);
    L16:
        ScalingUtils.ScaleType r4 = this.mScaleType;
        ScalingUtils.ScaleType r5 = ScalingUtils.ScaleType.CENTER_CROP;
        if (r4 == r5) goto L19;
    L21:
        h r6 = this.mImageDelegate;
        if (r6.Y == true) goto L34;
        ScalingUtils.ScaleType r7 = this.mScaleType;
        if (r7 == r5) goto L34;
        if (r7 == ScalingUtils.ScaleType.FOCUS_CROP) goto L34;
        if (r6.m == true) goto L34;
        if (this.mIsPixelated == true) goto L34;
        if (r6.f == true) goto L34;
        boolean r8 = true;
    L35:
        this.mUsePostprocessorScaling = r8;
        BorderRadius r9 = this.mBorderRadii;
        RoundingParams r10 = null;
        if (r9 != null) goto L38;
        float[] r16 = null;
    L43:
        if (this.mIsBorderRadiusDirty == true) goto L45;
    L52:
        int r11 = this.mFadeDurationMs;
        if (r11 >= 0) goto L56;
        r11 = 0;
    L56:
        r3.setFadeDuration(r11);
        ImageRequest r12 = createImageRequest(this.mImageDelegate.x, r20, r21, 0, 0, 0, 0, r16, this.mScaleType);
        ImageRequest r13 = this.mCurImageRequest;
        this.mCurImageRequest = r12;
        ImageRequest r14 = createImageRequest(this.mImageDelegate.y, r20, r21, 0, 0, 0, 0, r16, this.mScaleType);
        if (this.mDeferInvalidation == false) goto L59;
        r14 = r13;
    L59:
        this.mDraweeControllerBuilder.reset();
        WeakReference r15 = new WeakReference(this);
        AbstractDraweeControllerBuilder r17 = this.mDraweeControllerBuilder.setAutoPlayAnimations(this.mAutoPlay).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(r12);
        if (r14 == null) goto L62;
        boolean r18 = true;
    L63:
        r17.setRetainImageOnFailure(r18).setLowResImageRequest(r14);
        String r19 = this.mImageDelegate.v;
        this.mStartTimeStamp = System.currentTimeMillis();
        b r26 = new b(this, r15, r19);
        this.mControllerListener = r26;
        if (this.mControllerForTesting != null) goto L66;
        this.mDraweeControllerBuilder.setControllerListener(r26);
    L67:
        setController(this.mDraweeControllerBuilder.build());
        this.mIsDirty = false;
        h r27 = this.mImageDelegate;
        r27.b = r20;
        r27.c = r21;
        this.mDraweeControllerBuilder.reset();
        if (TraceEvent.isTracingStarted() == false) goto L71;
        TraceEvent.endSection("LynxImageManager.tryFetchImageFromFresco");
        return;
    L71:
        return;
    L66:
        ForwardingControllerListener r28 = new ForwardingControllerListener();
        r28.addListener(this.mControllerListener);
        r28.addListener(this.mControllerForTesting);
        this.mDraweeControllerBuilder.setControllerListener(r28);
        goto L67
    L62:
        r18 = false;
        goto L63
    L45:
        if (this.mUsePostprocessorScaling == true) goto L51;
        if (r16 == null) goto L51;
        r10 = RoundingParams.fromCornersRadii(r16);
        int r29 = this.mOverlayColor;
        if (r29 == 0) goto L50;
        r10.setOverlayColor(r29);
        goto L51
    L50:
        r10.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
    L51:
        r3.setRoundingParams(r10);
        this.mIsBorderRadiusDirty = true;
        goto L52
    L38:
        if (r9.d((r20 + r22) + r24, (r21 + r23) + r25) == false) goto L40;
        this.mIsBorderRadiusDirty = true;
    L40:
        r16 = adjustBorderRadiusArrayWithPadding(this.mBorderRadii.a());
    L34:
        r8 = false;
        goto L35
    L19:
        if (this.mCoverStart == false) goto L21;
        t r30 = new t();
        this.mScaleType = r30;
        r3.setActualImageScaleType(r30);
        goto L21
    }

    public void tryFetchImage(int r1, int r2, int r3, int r4, int r5, int r6) {
        maybeUpdateViewInternal(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void access$500(FrescoImageView r0, int r1, int r2, int r3, int r4, int r5, int r6) {
        r0.tryFetchImageFromFresco(r1, r2, r3, r4, r5, r6);
    }

    public ImageRequest createImageRequest(m8a.g r12, int r13, int r14, int r15, int r16, int r17, int r18, float[] r19, ScalingUtils.ScaleType r20) {
        return this.mImageDelegate.d(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }
}
