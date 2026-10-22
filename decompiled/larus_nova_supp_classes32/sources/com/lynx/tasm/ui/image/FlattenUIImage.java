package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.ILynxUIMeaningfulContent$MeaningfulContentStatus;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlattenUIImage extends LynxFlattenUI implements Drawable.Callback, e0.c {
    public static final String EVENT_ERROR = "error";
    private m8a.d mBigImageHelper;
    String mCapInsets;
    String mCapInsetsScale;
    private boolean mDeferInvalidation;
    private boolean mEnableImageAsyncRedirectOnCreate;
    private boolean mFrescoNinePatch;
    private final Handler mHandler;
    private boolean mHasPendingPlaceholder;
    private boolean mHasPendingSource;
    private Drawable mImageDrawable;
    protected final e0 mLynxImageManager;
    private String mOriginPlaceholder;
    private boolean mPendingLoad;
    private float mPreFetchHeight;
    private float mPreFetchWidth;
    private CloseableReference<?> mRef;
    private boolean mRepeat;
    private ScalingUtils.ScaleType mScaleType;
    private int mScrollState;
    private com.lynx.tasm.behavior.ui.f mScrollStateChangeListener;
    private int mShowCnt;
    private boolean mSkipRedirection;
    private String mSources;
    private boolean mSuspendable;
    private boolean mUseLocalCache;

    public class a extends l {
        public final /* synthetic */ FlattenUIImage a;

        public a(FlattenUIImage r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.ui.image.l
        public final void onImageLoadSuccess(int r4, int r5) {
            if (FlattenUIImage.access$100(this.a) != null) goto L5;
            return;
        L5:
            if (FlattenUIImage.access$200(this.a).containsKey("load") == false) goto L9;
            m7a.a r0 = new m7a.a(this.a.getSign(), "load");
            r0.a("height", Integer.valueOf(r5));
            r0.a("width", Integer.valueOf(r4));
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(r0);
            return;
        }

        @Override // com.lynx.tasm.ui.image.l
        public final void onImageLoadFailed(LynxError r4, int r5, int r6) {
            if (r4 != null) goto L4;
            return;
        L4:
            m7a.a r0 = new m7a.a(this.a.getSign(), "error");
            r0.a("errMsg", r4.getSummaryMessage() + ": " + r4.getRootCause());
            r0.a("lynx_categorized_code", Integer.valueOf(r5));
            r0.a("error_code", Integer.valueOf(r6));
            this.a.getLynxContext().getEventEmitter().sendCustomEvent(r0);
            this.a.getLynxContext().reportResourceError(FlattenUIImage.access$300(this.a), "image", r4);
        }
    }

    public class b implements com.lynx.tasm.ui.image.f {
        public final /* synthetic */ FlattenUIImage a;

        @Override // com.lynx.tasm.ui.image.f
        public final void a() {
            FlattenUIImage.access$400(this.a);
        }

        public b(FlattenUIImage r1) {
            this.a = r1;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ FlattenUIImage a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(FlattenUIImage r1) {
            this.a = r1;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ FlattenUIImage a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(FlattenUIImage r1) {
            this.a = r1;
        }
    }

    public class e implements com.lynx.tasm.behavior.ui.f {
        public final /* synthetic */ FlattenUIImage a;

        public e(FlattenUIImage r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.behavior.ui.f
        public final void onScrollStateChanged(int r2) {
            FlattenUIImage.access$502(this.a, r2);
            if (FlattenUIImage.access$600(this.a) == false) goto L7;
            if (r2 != 0) goto L8;
            FlattenUIImage.access$602(this.a, false);
            FlattenUIImage.access$400(this.a);
            return;
        L8:
            return;
        }
    }

    public static /* synthetic */ class f {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            a = r0;
            r0[ReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[ReadableType.String.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class g implements m8a.d.b {
        public final /* synthetic */ FlattenUIImage a;

        @Override // m8a.d.b
        public final void onImageLoadFailed(String r1) {
        }

        public g(FlattenUIImage r1) {
            this.a = r1;
        }

        @Override // m8a.d.b
        public final void onImageLoadSuccess(m8a.d.c r2) {
            if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
            this.a.invalidate();
            return;
        L5:
            FlattenUIImage.access$000(this.a);
        }
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI, x6a.e
    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    private void attachWhenSetPrefetchSize() {
        if (this.mPreFetchWidth > 0.0f) goto L5;
        return;
    L5:
        if (this.mPreFetchHeight <= 0.0f) goto L13;
        e0 r0 = this.mLynxImageManager;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.U == false) goto L15;
        r0.h();
        return;
    L15:
        return;
    }

    private void configureBounds() {
        Drawable r0 = this.mImageDrawable;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBounds(0, 0, getWidth(), getHeight());
    }

    private void maybeUpdateView() {
        if (this.mSuspendable == false) goto L9;
        if (this.mScrollState == 0) goto L9;
        this.mPendingLoad = true;
        return;
    L9:
        if (getWidth() <= 0) goto L11;
    L17:
        this.mLynxImageManager.g(getWidth(), getHeight(), this.mPaddingLeft + this.mBorderLeftWidth, this.mPaddingTop + this.mBorderTopWidth, this.mPaddingRight + this.mBorderRightWidth, this.mPaddingBottom + this.mBorderBottomWidth);
        return;
    L11:
        if (getHeight() > 0) goto L17;
        float r1 = this.mPreFetchWidth;
        if (r1 <= 0.0f) goto L17;
        float r3 = this.mPreFetchHeight;
        if (r3 <= 0.0f) goto L17;
        this.mLynxImageManager.g((int) r1, (int) r3, this.mPaddingLeft + this.mBorderLeftWidth, this.mPaddingTop + this.mBorderTopWidth, this.mPaddingRight + this.mBorderRightWidth, this.mPaddingBottom + this.mBorderBottomWidth);
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

    private void postInvalidate() {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L6;
        r0.post(new d(this));
        return;
    }

    private void updateImageSource() {
        if (this.mSkipRedirection == true) goto L10;
        if (this.mHasPendingPlaceholder == false) goto L10;
        if (this.mHasPendingSource == false) goto L10;
        e0 r0 = this.mLynxImageManager;
        String r2 = this.mSources;
        String r3 = this.mOriginPlaceholder;
        r0.F.u(r2, r3);
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
    L10:
        if (this.mHasPendingSource == false) goto L17;
        if (this.mSkipRedirection == false) goto L14;
        e0 r1 = this.mLynxImageManager;
        String r4 = this.mSources;
        r1.F.v(r4, false);
    L15:
        this.mHasPendingSource = false;
        goto L17
    L14:
        e0 r5 = this.mLynxImageManager;
        String r6 = this.mSources;
        r5.F.v(r6, true);
    L17:
        if (this.mHasPendingPlaceholder == false) goto L23;
        this.mHasPendingPlaceholder = false;
        e0 r7 = this.mLynxImageManager;
        String r8 = this.mOriginPlaceholder;
        boolean r9 = true ^ this.mSkipRedirection;
        h r10 = r7.F;
        if (r9 == false) goto L21;
        r10.u(null, r8);
        return;
    L21:
        r10.t(r8);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        e0 r0 = this.mLynxImageManager;
        if (r0 == null) goto L15;
        if (r0.l == null) goto L15;
        h r1 = r0.F;
        if (r1 != null) goto L9;
        long r3 = 0;
    L11:
        if (r3 <= 0) goto L15;
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
    L9:
        r3 = r1.q;
    L15:
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    }

    @LynxUIMethod
    public void startAnimate() {
        e0 r0 = this.mLynxImageManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.e() == true) goto L8;
        return;
    L8:
        if (r0.U == false) goto L10;
        r0.Y.stop();
        r0.Y.start();
        return;
    L10:
        r0.l.getController().getAnimatable().stop();
        r0.l.getController().getAnimatable().start();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        this.mLynxImageManager.i();
        m8a.d r0 = this.mBigImageHelper;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        CloseableReference<?> r1 = this.mRef;
        if (r1 == null) goto L9;
        r1.close();
        this.mRef = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public long getMemoryUsageBytes() {
        long r0 = super.getMemoryUsageBytes();
        e0 r2 = this.mLynxImageManager;
        if (r2 == null) goto L10;
        h r3 = r2.F;
        if (r3 != null) goto L7;
        long r4 = 0;
    L9:
        return r4 + r0;
    L7:
        r4 = r3.q;
        goto L9
    L10:
        return r0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public Map<String, String> getMemoryUsageDetail() {
        float r0 = getMemoryUsageBytes();
        String r1 = this.mSources;
        if (r0 == 0.0f) goto L13;
        if (r1 == null) goto L13;
        if (r1.isEmpty() == true) goto L13;
        if (r1.startsWith("data:image") == false) goto L11;
        return null;
    L11:
        HashMap r2 = new HashMap();
        r2.put(r1, String.valueOf(r0));
        return r2;
    L13:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        this.mLynxImageManager.h();
        this.mLynxImageManager.i = true;
        maybeUpdateView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        this.mLynxImageManager.i();
        m8a.d r0 = this.mBigImageHelper;
        if (r0 == null) goto L5;
        r0.f();
    L5:
        this.mImageDrawable = null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        e0 r0 = this.mLynxImageManager;
        if (r0 == null) goto L7;
        int r1 = getLeft();
        int r2 = getTop();
        int r3 = getLeft() + getWidth();
        int r4 = getTop() + getHeight();
        View r5 = r0.h0;
        if (r5 == null) goto L7;
        r5.setLeft(r1);
        r0.h0.setTop(r2);
        r0.h0.setRight(r3);
        r0.h0.setBottom(r4);
    L7:
        configureBounds();
        maybeUpdateView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        h r0 = this.mLynxImageManager.F;
        if (r0.W == false) goto L8;
        r0.W = false;
        if (r0.m == false) goto L9;
        r0.i();
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

    public Drawable getImageDrawable() {
        return this.mImageDrawable;
    }

    public String getSource() {
        return this.mSources;
    }

    public void onImageLoaded() {
        configureBounds();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void renderIfNeeded() {
        maybeUpdateView();
    }

    public FlattenUIImage(Context r1) {
        this((LynxContext) r1);
    }

    public static /* synthetic */ void access$000(FlattenUIImage r0) {
        r0.postInvalidate();
    }

    public static /* synthetic */ Map access$100(FlattenUIImage r0) {
        return r0.mEvents;
    }

    public static /* synthetic */ Map access$200(FlattenUIImage r0) {
        return r0.mEvents;
    }

    public static /* synthetic */ String access$300(FlattenUIImage r0) {
        return r0.mSources;
    }

    public static /* synthetic */ void access$400(FlattenUIImage r0) {
        r0.maybeUpdateView();
    }

    public static /* synthetic */ boolean access$600(FlattenUIImage r0) {
        return r0.mPendingLoad;
    }

    public e0 createImageManager(Context r8) {
        return new e0(r8, Fresco.newDraweeControllerBuilder(), getLynxContext().getFrescoCallerContext(), this, false);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r1) {
        UIThreadUtils.runOnUiThreadImmediately(new c(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onBorderRadiusUpdated(int r4) {
        e0 r5 = this.mLynxImageManager;
        BorderRadius r0 = getLynxBackground().m();
        if (r5.j != r0) goto L11;
        if (r0 != null) goto L6;
    L10:
        r5.i = true;
    L12:
        r5.W = true;
        return;
    L6:
        if (r0.d == null) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
    L8:
        r1 = false;
        goto L9
    L11:
        r5.j = r0;
        r5.i = true;
        goto L12
    }

    @Override // com.lynx.tasm.ui.image.e0.c
    public void onCloseableRefReady(CloseableReference<?> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mUseLocalCache == false) goto L9;
        this.mRef = r2.clone();
        invalidate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxFlattenUI
    public void onDraw(Canvas r25) {
        super.onDraw(r25);
        if (this.mPendingLoad == false) goto L6;
        return;
    L6:
        if (this.mImageDrawable != null) goto L11;
        if (this.mRef != null) goto L11;
        return;
    L11:
        if (TraceEvent.isTracingStarted() == false) goto L21;
        HashMap r2 = new HashMap();
        String r3 = this.mLynxImageManager.F.v;
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L20;
        r2.put(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, this.mSources);
    L20:
        TraceEvent.beginSection("FlattenUIImage.onDraw", r2);
        goto L21
    L15:
        if (r3.startsWith("http") == false) goto L17;
        r4 = true;
    L21:
        CloseableReference<?> r5 = this.mRef;
        String r13 = null;
        if (r5 == null) goto L43;
        if (r5.isValid() == false) goto L43;
        if (this.mUseLocalCache == false) goto L43;
        Object r6 = this.mRef.get();
        if ((r6 instanceof CloseableBitmap) == false) goto L31;
        Bitmap r7 = ((CloseableBitmap) r6).getUnderlyingBitmap();
    L33:
        Bitmap r10 = r7;
    L35:
        if (r10 == null) goto L43;
        LLog.i("Lynx Android Flatten Image", "draw image from local cache");
        if (l8a.a.customDraw(getWidth(), getHeight(), r10.getWidth(), r10.getHeight(), this.mScaleType, this.mCapInsets, this.mCapInsetsScale, r25, r10) == false) goto L43;
        if (TraceEvent.isTracingStarted() == false) goto L78;
        TraceEvent.endSection("FlattenUIImage.onDraw");
        return;
    L78:
        return;
    L31:
        if ((r6 instanceof Bitmap) == false) goto L34;
        r7 = (Bitmap) r6;
        goto L33
    L34:
        r10 = null;
    L43:
        if (this.mFrescoNinePatch == false) goto L45;
    L60:
        e0 r8 = this.mLynxImageManager;
        if (r8.U == true) goto L63;
    L76:
        this.mImageDrawable.draw(r25);     // Catch: Throwable -> L70
    L73:
        if (TraceEvent.isTracingStarted() == false) goto L81;
        TraceEvent.endSection("FlattenUIImage.onDraw");
        return;
    L81:
        return;
    L70:
        th = move-exception;
        LLog.e("Lynx-Image", th.getMessage() + ", view sie:" + getWidth() + "x" + getHeight() + ", url:" + this.mSources);
        goto L73
    L63:
        if (r8.f() == false) goto L76;
        if (TraceEvent.isTracingStarted() == false) goto L80;
        TraceEvent.endSection("FlattenUIImage.onDraw");
        return;
    L80:
        return;
    L45:
        if (this.mCapInsets == null) goto L60;
        if (LynxEnv.inst().disableBigImageHelper() == true) goto L60;
        LLog.i("Lynx Android Flatten Image", "load origin bitmap to draw image with cap-insets");
        if (this.mBigImageHelper != null) goto L51;
        this.mBigImageHelper = new m8a.d(new g(this), this.mShowCnt);
    L51:
        int r15 = this.mShowCnt;
        float r9 = getWidth();
        float r11 = getHeight();
        boolean r12 = this.mRepeat;
        ScalingUtils.ScaleType r14 = this.mScaleType;
        m8a.g r16 = this.mLynxImageManager.F.x;
        if (r16 == null) goto L55;
        r13 = r16.b().toString();
    L55:
        if (this.mBigImageHelper.i(getLynxContext(), r25, this.mLynxImageManager.r, new m8a.d.a(r15, r9, r11, r12, r14, r13, m8a.d.l(r25), this.mCapInsets, this.mCapInsetsScale)) == false) goto L60;
        if (TraceEvent.isTracingStarted() == false) goto L79;
        TraceEvent.endSection("FlattenUIImage.onDraw");
        return;
    }

    @Override // com.lynx.tasm.ui.image.e0.c
    public void onDrawableReady(Drawable r2) {
        this.mImageDrawable = r2;
        if (r2 == null) goto L11;
        r2.setCallback(this);
        int r3 = this.mImageRendering;
        if (r3 != 2) goto L8;
        this.mImageDrawable.setFilterBitmap(false);
        goto L11
    L8:
        if (r3 == 1) goto L10;
        if (r3 != 0) goto L11;
    L10:
        this.mImageDrawable.setFilterBitmap(true);
    L11:
        configureBounds();
        invalidate();
    }

    @LynxProp(name = "async-redirect")
    public void setAsyncRedirect(boolean r2) {
        this.mLynxImageManager.F.X = r2;
    }

    @LynxProp(defaultBoolean = false, name = "async-request")
    public void setAsyncRequest(boolean r5) {
        e0 r0 = this.mLynxImageManager;
        r0.U = r5;
        r0.F.H = r5;
        if (r5 == false) goto L10;
        r0.c();
        if (r0.M != null) goto L8;
        r0.d();
    L8:
        if (r0.i0 != null) goto L25;
        r0.i0 = new WeakReference((FlattenUIImage) r0.G);
    L25:
        r0.i = true;
        return;
    L10:
        CloseableReference<CloseableImage> r6 = r0.P;
        if (r6 == null) goto L13;
        CloseableReference.closeSafely(r6);
        r0.P = null;
    L13:
        y<GenericDraweeHierarchy> r7 = r0.M;
        if (r7 == null) goto L22;
        r7.b = false;
        if (r7.a == false) goto L22;
        r7.a = false;
        x r2 = new x(r7);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L21;
        r2.run();
        goto L22
    L21:
        LynxThreadPool.d().execute(r2);
    L22:
        r0.d0 = null;
        CloseableReference<?> r8 = r0.Z;
        if (r8 == null) goto L25;
        CloseableReference.closeSafely(r8);
        r0.Z = null;
        goto L25
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public void setAutoPlay(boolean r2) {
        this.mLynxImageManager.I = r2;
    }

    @LynxProp(name = "auto-size")
    public void setAutoSize(boolean r4) {
        e0 r0 = this.mLynxImageManager;
        h r1 = r0.F;
        r1.m = r4;
        if (r4 == true) goto L5;
    L8:
        r1.i();
    L9:
        r1.A.markDirty();
        r0.B = !r4;
        return;
    L5:
        if (r1.e == 0) goto L9;
        if (r1.d == 0) goto L9;
        goto L8
    }

    @LynxProp(name = "blur-radius")
    public void setBlurRadius(String r9) {
        UIBody r0 = this.mContext.getUIBody();
        e0 r1 = this.mLynxImageManager;
        r1.F.p(Math.round(com.lynx.tasm.utils.n.c(r9, r0.getFontSize(), this.mFontSize, r0.getWidth(), r0.getHeight(), this.mContext.getScreenMetrics())));
    }

    @LynxProp(name = "android-cache-key-path-only")
    public void setCacheKeyPathOnly(boolean r2) {
        this.mLynxImageManager.F.l = r2;
    }

    @LynxProp(name = "capInsets")
    public void setCapInsets(String r2) {
        if (r2 != null) goto L4;
    L7:
        this.mCapInsets = null;
    L8:
        e0 r3 = this.mLynxImageManager;
        String r0 = this.mCapInsets;
        h r4 = r3.F;
        r4.g = r0;
        r4.A.markDirty();
        return;
    L4:
        if (r2.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L7;
        this.mCapInsets = r2;
        goto L8
    }

    @LynxProp(name = "cap-insets")
    public void setCapInsetsBackUp(String r1) {
        setCapInsets(r1);
    }

    @LynxProp(name = "cap-insets-scale")
    public void setCapInsetsScale(String r2) {
        if (r2 != null) goto L4;
    L7:
        this.mCapInsetsScale = null;
    L8:
        e0 r3 = this.mLynxImageManager;
        String r0 = this.mCapInsetsScale;
        h r4 = r3.F;
        r4.h = r0;
        r4.A.markDirty();
        return;
    L4:
        if (r2.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L7;
        this.mCapInsetsScale = r2;
        goto L8
    }

    @LynxProp(name = "additional-custom-info")
    public void setCustomParams(ReadableMap r2) {
        this.mLynxImageManager.F.q(r2);
    }

    @LynxProp(defaultBoolean = false, name = "defer-src-invalidation")
    public void setDeferInvalidation(boolean r2) {
        this.mDeferInvalidation = r2;
        this.mLynxImageManager.z = r2;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "disable-default-resize")
    public void setDisableDefaultResize(boolean r2) {
        e0 r0 = this.mLynxImageManager;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        ImageResizeMethod r3 = ImageResizeMethod.SCALE;
        h r1 = r0.F;
        r1.r = r3;
        r1.A.markDirty();
        return;
    L7:
        ImageResizeMethod r4 = ImageResizeMethod.RESIZE;
        h r5 = r0.F;
        r5.r = r4;
        r5.A.markDirty();
    }

    @LynxProp(name = "enable-custom-gif-decoder")
    public void setEnableCustomGifDecoder(boolean r2) {
        this.mLynxImageManager.F.V = r2;
    }

    @LynxProp(defaultBoolean = false, name = "enable-report-info")
    public void setEnableReportInfo(boolean r2) {
        e0 r0 = this.mLynxImageManager;
        r0.L = r2;
        r0.F.Q = r2;
    }

    @LynxProp(defaultBoolean = false, name = "enable-resource-hint")
    public void setEnableResourceHint(boolean r2) {
        this.mLynxImageManager.F.f = r2;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-smooth-animation")
    public void setEnableSmoothAnimation(boolean r2) {
        this.mLynxImageManager.F.O = r2;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> r2) {
        super.setEvents(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        this.mLynxImageManager.F.r(r2);
    }

    @LynxProp(defaultBoolean = false, name = "extra-load-info")
    public void setExtraLoadInfo(boolean r2) {
        e0 r0 = this.mLynxImageManager;
        r0.K = r2;
        r0.F.P = r2;
    }

    @LynxProp(defaultBoolean = false, name = "fresco-nine-patch")
    public void setFrescoNinePatch(boolean r1) {
        this.mFrescoNinePatch = r1;
    }

    @LynxProp(name = "cache-choice")
    public void setImageCacheChoice(String r2) {
        this.mLynxImageManager.F.j = r2;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "image-config")
    public void setImageConfig(String r2) {
        super.setImageConfig(r2);
        e0 r3 = this.mLynxImageManager;
        Bitmap.Config r0 = this.mBitmapConfig;
        h r4 = r3.F;
        r4.p = r0;
        r4.A.markDirty();
    }

    @LynxProp(name = "placeholder-hash-config")
    public void setImagePlaceHolderHashConfig(ReadableMap r2) {
        this.mLynxImageManager.F.s(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setImageRendering(int r4) {
        super.setImageRendering(r4);
        e0 r0 = this.mLynxImageManager;
        if (r4 != 2) goto L5;
        boolean r5 = true;
    L6:
        r0.b0 = r5;
        r0.i = true;
        return;
    L5:
        r5 = false;
        goto L6
    }

    @LynxProp(name = "fetch-priority")
    public void setImageRequestPriority(String r2) {
        this.mLynxImageManager.F.i = r2;
    }

    @LynxProp(name = "enable-super-resolution")
    public void setImageSR(boolean r4) {
        e0 r0 = this.mLynxImageManager;
        if (r4 == true) goto L5;
    L7:
        h r1 = r0.F;
        r1.Y = r4;
        r1.p = Bitmap.Config.ARGB_8888;
        return;
    L5:
        if (r0.h0 != null) goto L7;
        r0.h0 = new View(r0.a);
        goto L7
    }

    @LynxProp(name = "super-resolution-scale")
    public void setImageSRScale(float r4) {
        h r0 = this.mLynxImageManager.F;
        if (r4 <= 0.0f) goto L5;
        r0.Y = true;
        r0.p = Bitmap.Config.ARGB_8888;
        r0.Z = r4;
        return;
    L5:
        r0.Y = false;
        r0.Z = 0.0f;
    }

    @LynxProp(name = "image-transition-style")
    public void setImageTransitionStyle(String r3) {
        e0 r0 = this.mLynxImageManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.getClass();
        if ("fadeIn".equals(r3) == false) goto L8;
        r0.V = 300;
    L9:
        GenericDraweeHierarchy r4 = r0.E;
        if (r4 == null) goto L13;
        r4.setFadeDuration(r0.V);
        return;
    L13:
        return;
    L8:
        r0.V = 0;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setLocalCache(f6a.a r3) {
        super.setLocalCache(r3);
        if (this.mLynxImageManager != null) goto L5;
        return;
    L5:
        u7a.g.b r4 = u7a.g.b(r3);
        boolean r0 = r4.a;
        this.mUseLocalCache = r0;
        boolean r5 = r4.b;
        h r1 = this.mLynxImageManager.F;
        r1.t = r0;
        r1.u = r5;
    }

    @LynxProp(name = "loop-count")
    public void setLoopCount(int r2) {
        if (r2 > 0) goto L4;
        r2 = 0;
    L4:
        this.mLynxImageManager.F.N = r2;
    }

    @LynxProp(name = "mode")
    public void setObjectFit(String r2) {
        ScalingUtils.ScaleType r3 = o.b(r2);
        this.mScaleType = r3;
        e0 r0 = this.mLynxImageManager;
        r0.h = r3;
        r0.X = true;
        r0.i = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setParent(com.lynx.tasm.behavior.ui.k r1) {
        super.setParent(r1);
        this.mLynxImageManager.h();
    }

    @LynxProp(name = "placeholder")
    public void setPlaceholder(String r2) {
        this.mHasPendingPlaceholder = true;
        this.mOriginPlaceholder = r2;
    }

    @LynxProp(name = "prefetch-height")
    public void setPreFetchHeight(String r8) {
        this.mPreFetchHeight = com.lynx.tasm.utils.n.b(r8, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics());
        attachWhenSetPrefetchSize();
    }

    @LynxProp(name = "prefetch-width")
    public void setPreFetchWidth(String r8) {
        this.mPreFetchWidth = com.lynx.tasm.utils.n.b(r8, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics());
        attachWhenSetPrefetchSize();
    }

    @LynxProp(defaultBoolean = false, name = "progressive-rendering")
    public void setProgressiveRendering(boolean r2) {
        this.mLynxImageManager.F.l0 = r2;
    }

    @LynxProp(name = "region-to-decode")
    public void setRegionToDecode(ReadableMap r4) {
        e0 r0 = this.mLynxImageManager;
        Rect r5 = u7a.g.c(r4);
        h r1 = r0.F;
        if (r5 != null) goto L5;
        r1.m0 = null;
    L6:
        r0.i = true;
        return;
    L5:
        r1.getClass();
        r1.m0 = new Rect(r5);
        goto L6
    }

    @LynxProp(defaultBoolean = false, name = "repeat")
    public void setRepeat(boolean r1) {
        this.mRepeat = r1;
    }

    @LynxProp(name = "android-simple-cache-key")
    public void setSimpleCacheKey(boolean r2) {
        e0 r0 = this.mLynxImageManager;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.F.k = r2;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(defaultBoolean = false, name = "skip-redirection")
    public void setSkipRedirection(boolean r1) {
        this.mSkipRedirection = r1;
    }

    @LynxProp(name = LynxError.LYNX_ERROR_KEY_RESOURCE_URL)
    public void setSource(String r3) {
        if (r3 != null) goto L5;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        if (TextUtils.equals(r3, this.mLynxImageManager.F.v) == false) goto L7;
    L12:
        this.mSources = r3;
        this.mHasPendingSource = true;
        onSourceSetted();
        invalidate();
        return;
    L7:
        if (this.mDeferInvalidation == true) goto L9;
        this.mImageDrawable = null;
    L9:
        CloseableReference<?> r0 = this.mRef;
        if (r0 == null) goto L12;
        r0.close();
        this.mRef = null;
        goto L12
    }

    @LynxProp(name = "subsample")
    public void setSubSample(boolean r2) {
        this.mLynxImageManager.F.n0 = !r2;
    }

    @LynxProp(name = "suspendable")
    public void setSuspendable(f6a.a r3) {
        this.mSuspendable = false;
        if (r3 == null) goto L12;
        int r0 = f.a[r3.getType().ordinal()];
        if (r0 != 1) goto L7;
        this.mSuspendable = r3.asBoolean();
        goto L12
    L7:
        if (r0 != 2) goto L12;
        this.mSuspendable = TextUtils.equals("true", r3.asString());
    L12:
        if (this.mSuspendable == true) goto L16;
        unRegisterScrollStateListener(this.mScrollStateChangeListener);
        return;
    L16:
        if (this.mScrollStateChangeListener != null) goto L18;
        this.mScrollStateChangeListener = new e(this);
    L18:
        registerScrollStateListener(this.mScrollStateChangeListener);
    }

    @LynxProp(name = "tint-color")
    public void setTintColor(String r4) {
        e0 r0 = this.mLynxImageManager;
        r0.getClass();
        if (ColorUtils.a(r4) == true) goto L5;
        r0.J = null;
    L7:
        if (r0.U == false) goto L9;
        r0.E.setActualImageColorFilter(r0.J);
        return;
    L9:
        n0 r5 = r0.o;
        if (r5 == null) goto L14;
        ColorFilter r1 = r0.J;
        Drawable r6 = r5.b;
        if (r6 == null) goto L14;
        r6.setColorFilter(r1);
    L14:
        DraweeHolder<GenericDraweeHierarchy> r7 = r0.l;
        if (r7 != null) goto L17;
        return;
    L17:
        if (r7.getHierarchy() == null) goto L22;
        r0.l.getHierarchy().setActualImageColorFilter(r0.J);
        return;
    L22:
        return;
    L5:
        r0.J = new PorterDuffColorFilter(ColorUtils.b(r4), PorterDuff.Mode.SRC_IN);
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updatePropertiesInterval(x0 r5) {
        super.updatePropertiesInterval(r5);
        if (this.mSkipRedirection == false) goto L8;
        LynxContext r6 = this.mContext;
        if (r6 == null) goto L12;
        if (r6.isPrefetchImageOnCreate() == true) goto L8;
    L12:
        if (this.mEnableImageAsyncRedirectOnCreate == false) goto L15;
        updateImageSource();
        return;
    L15:
        return;
    L8:
        e0 r7 = this.mLynxImageManager;
        if (r7 == null) goto L12;
        String r0 = this.mSources;
        String r1 = this.mOriginPlaceholder;
        boolean r2 = this.mHasPendingSource;
        boolean r3 = this.mHasPendingPlaceholder;
        r7.F.z(r0, r1, r2, r3);
        goto L12
    }

    public FlattenUIImage(LynxContext r2) {
        this(r2, null);
    }

    public void setLocalCache(Boolean r2) {
        if (this.mLynxImageManager != null) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        this.mUseLocalCache = false;
    L7:
        boolean r3 = r2.booleanValue();
        this.mUseLocalCache = r3;
        this.mLynxImageManager.F.t = r3;
    }

    public FlattenUIImage(LynxContext r3, Object r4) {
        super(r3, r4);
        this.mImageDrawable = null;
        this.mPreFetchWidth = -1.0f;
        this.mPreFetchHeight = -1.0f;
        this.mUseLocalCache = false;
        this.mRef = null;
        this.mScaleType = ScalingUtils.ScaleType.FIT_XY;
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
        e0 r5 = createImageManager(r3);
        this.mLynxImageManager = r5;
        r5.G = this;
        if (r5.U == false) goto L5;
        r5.i0 = new WeakReference((FlattenUIImage) r5.G);
    L5:
        r5.F.E = this;
        r5.s = new a(this);
        r5.F.z = new b(this);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mShowCnt = 0;
        this.mRepeat = false;
        this.mEnableImageAsyncRedirectOnCreate = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
    }

    public static /* synthetic */ int access$502(FlattenUIImage r0, int r1) {
        r0.mScrollState = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$602(FlattenUIImage r0, boolean r1) {
        r0.mPendingLoad = r1;
        return r1;
    }

    @LynxUIMethod
    public void pauseAnimation(ReadableMap r4, Callback r5) {
        e0 r6 = this.mLynxImageManager;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.e() == true) goto L8;
        return;
    L8:
        if (r6.U == false) goto L10;
        Animatable r7 = r6.Y;
    L12:
        if ((r7 instanceof AnimatedDrawable2) == true) goto L14;
        return;
    L14:
        if (m8a.e.d((AnimatedDrawable2) r7) == false) goto L16;
        r5.invoke(new Object[]{0, "Animation paused."});
        return;
    L16:
        r5.invoke(new Object[]{4, "Not support pause yet"});
        return;
    L10:
        r7 = r6.l.getController().getAnimatable();
        goto L12
    }

    @LynxUIMethod
    public void resumeAnimation(ReadableMap r3, Callback r4) {
        e0 r5 = this.mLynxImageManager;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.e() == true) goto L8;
        return;
    L8:
        if (r5.U == false) goto L10;
        Animatable r6 = r5.Y;
    L11:
        r6.start();
        r4.invoke(new Object[]{0, "Animation resumed."});
        return;
    L10:
        r6 = r5.l.getController().getAnimatable();
        goto L11
    }

    @LynxUIMethod
    public void stopAnimation(ReadableMap r3, Callback r4) {
        e0 r5 = this.mLynxImageManager;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.e() == true) goto L8;
        return;
    L8:
        if (r5.U == false) goto L10;
        Animatable r6 = r5.Y;
    L11:
        r6.stop();
        r4.invoke(new Object[]{0, "Animation stopped."});
        return;
    L10:
        r6 = r5.l.getController().getAnimatable();
        goto L11
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r1, Runnable r2) {
        UIThreadUtils.removeCallbacks(r2, r1);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        UIThreadUtils.runOnUiThreadAtTime(r2, r1, r3);
    }
}
