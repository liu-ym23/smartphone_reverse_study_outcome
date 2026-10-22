package com.bytedance.android.live.core.utils.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.livesdk.config.InteractCustomDiskConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FrescoLoader {
    public static final String DEFAULT_CALLER_ID = "ttlive_fresco_loader";
    private static final float FLOAT_0_5 = 0.5f;
    private static final int SDK_VERSION_19 = 19;
    private py.k imageModel;
    private ColorFilter mActualImageColorFilter;
    private PointF mActualImageFocusPoint;
    private ScalingUtils.ScaleType mActualImageScaleType;
    private boolean mAutoPlayAnimations;
    private Drawable mBackgroundDrawable;
    private boolean mBmp565;
    private boolean mCompatTemporaryDetach;
    private Context mContext;
    private ControllerListener mControllerListener;
    private String mCustomCacheName;
    private float mDesiredAspectRatio;
    private DraweeHolder<DraweeHierarchy> mDraweeHolder;
    private b mDraweeHolderDispatcher;
    private int mFadeDuration;
    private Drawable mFailureDrawable;
    private ScalingUtils.ScaleType mFailureScaleType;
    private boolean mLocalThumbnailPreviewsEnabled;
    private Uri mLowerUri;
    private List<Drawable> mOverlays;
    private Drawable mPlaceholderDrawable;
    private ScalingUtils.ScaleType mPlaceholderScaleType;
    private Postprocessor mPostprocessor;
    private Drawable mPressedStateOverlay;
    private Drawable mProgressBarDrawable;
    private ScalingUtils.ScaleType mProgressScaleType;
    private boolean mProgressiveRenderingEnabled;
    private ResizeOptions mResizeOptions;
    private boolean mRetainImageOnFailure;
    private Drawable mRetryDrawable;
    private ScalingUtils.ScaleType mRetryScaleType;
    private RoundingParams mRoundingParams;
    private boolean mTapToRetryEnabled;
    private Uri mUri;
    private boolean mUseFixedWidth;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageView.ScaleType.values().length];
            a = r0;
            r0[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            a[ImageView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            a[ImageView.ScaleType.FIT_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            a[ImageView.ScaleType.MATRIX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public class b implements View.OnAttachStateChangeListener, View.OnTouchListener, c {
        public final /* synthetic */ FrescoLoader a;

        @Override // com.bytedance.android.live.core.utils.fresco.FrescoLoader.c
        public final void a() {
        }

        public b(FrescoLoader r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
            if (FrescoLoader.access$100(this.a) == null) goto L6;
            FrescoLoader.access$100(this.a).onAttach();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
            if (FrescoLoader.access$100(this.a) == null) goto L6;
            FrescoLoader.access$100(this.a).onDetach();
            return;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            if (FrescoLoader.access$100(this.a) != null) goto L5;
            return false;
        L5:
            if (FrescoLoader.access$100(this.a).onTouchEvent(r2) == false) goto L10;
            return true;
        L10:
            return false;
        }
    }

    public interface c {
        void a();
    }

    public FrescoLoader roundAsCircle() {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setRoundAsCircle(true);
        return this;
    }

    private FrescoLoader(Context r3) {
        this.mBmp565 = false;
        this.mContext = r3.getApplicationContext();
        this.mDraweeHolderDispatcher = null;
        this.mDesiredAspectRatio = 0.0f;
        this.mUseFixedWidth = true;
        this.mFadeDuration = 300;
        this.mPlaceholderDrawable = null;
        ScalingUtils.ScaleType r1 = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
        this.mPlaceholderScaleType = r1;
        this.mRetryDrawable = null;
        this.mRetryScaleType = r1;
        this.mFailureDrawable = null;
        this.mFailureScaleType = r1;
        this.mProgressBarDrawable = null;
        this.mProgressScaleType = r1;
        this.mActualImageScaleType = GenericDraweeHierarchyBuilder.DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.mActualImageFocusPoint = null;
        this.mActualImageColorFilter = null;
        this.mBackgroundDrawable = null;
        this.mOverlays = null;
        this.mPressedStateOverlay = null;
        this.mRoundingParams = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mRetainImageOnFailure = false;
        this.mProgressiveRenderingEnabled = false;
        this.mLocalThumbnailPreviewsEnabled = false;
        this.mPostprocessor = null;
        this.mControllerListener = null;
        this.mDraweeHolder = null;
    }

    public static /* synthetic */ DraweeHolder access$100(FrescoLoader r0) {
        return r0.mDraweeHolder;
    }

    private static boolean isAttachedToWindow(View r0) {
        return r0.isAttachedToWindow();
    }

    public static FrescoLoader with(Context r1) {
        if (r1 == null) goto L6;
        return new FrescoLoader(r1);
    L6:
        throw new IllegalArgumentException("appContext == null");
    }

    public FrescoLoader actualScaleType(ImageView.ScaleType r2) {
        this.mActualImageScaleType = convertToFrescoScaleType(r2, GenericDraweeHierarchyBuilder.DEFAULT_ACTUAL_IMAGE_SCALE_TYPE);
        return this;
    }

    public FrescoLoader autoPlayAnimations(boolean r1) {
        this.mAutoPlayAnimations = r1;
        return this;
    }

    public FrescoLoader controllerListener(ControllerListener r1) {
        this.mControllerListener = r1;
        return this;
    }

    public FrescoLoader cornersRadii(float[] r2) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setCornersRadii(r2);
        return this;
    }

    public FrescoLoader cornersRadius(int r2) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setCornersRadius(r2);
        return this;
    }

    public FrescoLoader customCacheName(String r1) {
        this.mCustomCacheName = r1;
        return this;
    }

    public FrescoLoader fadeDuration(int r1) {
        this.mFadeDuration = r1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void into(ImageView r11) {
        if (r11 != 0) goto L5;
        return;
    L5:
        if (this.mUri != null) goto L10;
        if (this.imageModel != null) goto L10;
        return;
    L10:
        if (this.mDraweeHolder != null) goto L15;
        Object r0 = TagCompat.getTag(r11);
        if ((r0 instanceof DraweeHolder) == false) goto L15;
        this.mDraweeHolder = (DraweeHolder) r0;
    L15:
        if (this.mResizeOptions == null) goto L17;
    L21:
        DraweeHolder<DraweeHierarchy> r1 = this.mDraweeHolder;
        if (r1 != null) goto L50;
        this.mDraweeHolder = DraweeHolder.create(null, r11.getContext());
        if (this.mDraweeHolderDispatcher != null) goto L26;
        this.mDraweeHolderDispatcher = new b(this);
    L26:
        this.mDraweeHolder.setHierarchy(new GenericDraweeHierarchyBuilder(r11.getResources()).setPlaceholderImage(this.mPlaceholderDrawable).setPlaceholderImageScaleType(this.mPlaceholderScaleType).setFailureImage(this.mFailureDrawable).setFailureImageScaleType(this.mFailureScaleType).setProgressBarImage(this.mProgressBarDrawable).setProgressBarImageScaleType(this.mProgressScaleType).setRetryImage(this.mRetryDrawable).setRetryImageScaleType(this.mRetryScaleType).setFadeDuration(this.mFadeDuration).setActualImageFocusPoint(this.mActualImageFocusPoint).setActualImageColorFilter(this.mActualImageColorFilter).setActualImageScaleType(this.mActualImageScaleType).setBackground(this.mBackgroundDrawable).setOverlays(this.mOverlays).setPressedStateOverlay(this.mPressedStateOverlay).setRoundingParams(this.mRoundingParams).build());
        ImageRequest[] r2 = createImageRequests(this.mUri, this.imageModel, this.mResizeOptions, this.mPostprocessor, this.mBmp565, this.mCustomCacheName);
        if (r2 != null) goto L29;
        return;
    L29:
        if (r2.length == 0) goto L81;
        PipelineDraweeControllerBuilder r3 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(this.mAutoPlayAnimations).setControllerListener(this.mControllerListener).setOldController(this.mDraweeHolder.getController()).setFirstAvailableImageRequests(r2).setRetainImageOnFailure(this.mRetainImageOnFailure).setTapToRetryEnabled(this.mTapToRetryEnabled);
        if (TextUtils.isEmpty(this.mCustomCacheName) == true) goto L34;
        r3.setCallerContext(this.mCustomCacheName);
    L35:
        Uri r4 = this.mLowerUri;
        if (r4 == null) goto L38;
        r3.setLowResImageRequest(ImageRequest.fromUri(r4));
    L38:
        this.mDraweeHolder.setController(r3.build());
        if (this.mCompatTemporaryDetach == false) goto L42;
        new h(r11, this.mDraweeHolderDispatcher);
    L48:
        r11.setOnTouchListener(this.mDraweeHolderDispatcher);
        TagCompat.setTag(r11, this.mDraweeHolder);
    L64:
        if (this.mDesiredAspectRatio == 0.0f) goto L79;
        ViewGroup.LayoutParams r5 = r11.getLayoutParams();
        if (r5 == null) goto L79;
        int r6 = r5.width;
        int r7 = r5.height;
        if (this.mUseFixedWidth == false) goto L72;
        if (r6 <= 0) goto L75;
        if (r7 != 0) goto L75;
        r7 = (int) (((((double) r6) * 1.0d) / ((double) this.mDesiredAspectRatio)) + 0.5d);
    L76:
        if (r6 == (-1)) goto L79;
        if (r7 == (-1)) goto L79;
        r5.width = r6;
        r5.height = r7;
        r11.requestLayout();
    L75:
        r6 = -1;
        r7 = -1;
        goto L76
    L72:
        if (r7 <= 0) goto L75;
        if (r6 != 0) goto L75;
        r6 = (int) ((r7 * this.mDesiredAspectRatio) + FLOAT_0_5);
    L79:
        r11.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
        return;
    L42:
        if ((r11 instanceof c) == false) goto L45;
        ((c) r11).a();
    L45:
        if (isAttachedToWindow(r11) == false) goto L47;
        this.mDraweeHolderDispatcher.onViewAttachedToWindow(r11);
    L47:
        r11.addOnAttachStateChangeListener(this.mDraweeHolderDispatcher);
        goto L48
    L34:
        r3.setCallerContext(DEFAULT_CALLER_ID);
        goto L35
    L81:
        return;
    L50:
        r1.onDetach();
        this.mDraweeHolder.setHierarchy(new GenericDraweeHierarchyBuilder(r11.getResources()).setPlaceholderImage(this.mPlaceholderDrawable).setPlaceholderImageScaleType(this.mPlaceholderScaleType).setFailureImage(this.mFailureDrawable).setFailureImageScaleType(this.mFailureScaleType).setProgressBarImage(this.mProgressBarDrawable).setProgressBarImageScaleType(this.mProgressScaleType).setRetryImage(this.mRetryDrawable).setRetryImageScaleType(this.mRetryScaleType).setFadeDuration(this.mFadeDuration).setActualImageFocusPoint(this.mActualImageFocusPoint).setActualImageColorFilter(this.mActualImageColorFilter).setActualImageScaleType(this.mActualImageScaleType).setBackground(this.mBackgroundDrawable).setOverlays(this.mOverlays).setPressedStateOverlay(this.mPressedStateOverlay).setRoundingParams(this.mRoundingParams).build());
        ImageRequest[] r8 = createImageRequests(this.mUri, this.imageModel, this.mResizeOptions, this.mPostprocessor, this.mBmp565, this.mCustomCacheName);
        if (r8 != null) goto L53;
        return;
    L53:
        if (r8.length == 0) goto L83;
        PipelineDraweeControllerBuilder r9 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(this.mAutoPlayAnimations).setControllerListener(this.mControllerListener).setFirstAvailableImageRequests(r8).setOldController(this.mDraweeHolder.getController()).setRetainImageOnFailure(this.mRetainImageOnFailure).setTapToRetryEnabled(this.mTapToRetryEnabled);
        if (TextUtils.isEmpty(this.mCustomCacheName) == true) goto L58;
        r9.setCallerContext(this.mCustomCacheName);
    L59:
        Uri r12 = this.mLowerUri;
        if (r12 == null) goto L62;
        r9.setLowResImageRequest(ImageRequest.fromUri(r12));
    L62:
        this.mDraweeHolder.setController(r9.build());
        this.mDraweeHolder.onAttach();
        goto L64
    L58:
        r9.setCallerContext(DEFAULT_CALLER_ID);
        goto L59
    L83:
        return;
    L17:
        if (r11.getMeasuredWidth() <= 0) goto L21;
        if (r11.getMeasuredHeight() <= 0) goto L21;
        resize(r11.getMeasuredWidth(), r11.getMeasuredHeight());
        goto L21
    }

    public FrescoLoader load(int r3) {
        return load(new Uri.Builder().scheme("res").path(String.valueOf(r3)).build());
    }

    public FrescoLoader placeholder(int r2) {
        return placeholder(this.mContext.getResources().getDrawable(r2));
    }

    public FrescoLoader placeholderScaleType(ImageView.ScaleType r2) {
        this.mPlaceholderScaleType = convertToFrescoScaleType(r2, GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE);
        return this;
    }

    public FrescoLoader postProcessor(Postprocessor r1) {
        this.mPostprocessor = r1;
        return this;
    }

    public FrescoLoader load(String r1) {
        return load(UriProtector.parse(r1));
    }

    public FrescoLoader placeholder(Drawable r1) {
        this.mPlaceholderDrawable = r1;
        return this;
    }

    public FrescoLoader load(Uri r1) {
        this.mUri = r1;
        return this;
    }

    public FrescoLoader load(py.k r1) {
        this.imageModel = r1;
        return this;
    }

    private static ScalingUtils.ScaleType convertToFrescoScaleType(ImageView.ScaleType r1, ScalingUtils.ScaleType r2) {
        switch(a.a[r1.ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        return r2;
    L6:
        return ScalingUtils.ScaleType.FOCUS_CROP;
    L8:
        return ScalingUtils.ScaleType.FIT_XY;
    L10:
        return ScalingUtils.ScaleType.FIT_END;
    L12:
        return ScalingUtils.ScaleType.FIT_START;
    L14:
        return ScalingUtils.ScaleType.FIT_CENTER;
    L16:
        return ScalingUtils.ScaleType.CENTER_INSIDE;
    L18:
        return ScalingUtils.ScaleType.CENTER_CROP;
    L20:
        return ScalingUtils.ScaleType.CENTER;
    }

    public FrescoLoader border(int r2, float r3) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setBorder(r2, r3);
        return this;
    }

    public FrescoLoader resize(int r2, int r3) {
        this.mResizeOptions = new ResizeOptions(r2, r3);
        return this;
    }

    private static ImageRequest createImageRequestWithUri(Uri r0, ResizeOptions r1, String r2) {
        if (r0 != null) goto L5;
        return null;
    L5:
        ImageRequestBuilder r3 = ImageRequestBuilder.newBuilderWithSource(r0);
        if (r1 == null) goto L9;
        r3.setResizeOptions(r1);
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        if (((Boolean) InteractCustomDiskConfig.a.getValue()).booleanValue() == false) goto L14;
        r3.setCacheChoice(ImageRequest.CacheChoice.CUSTOM).setCustomCacheName(r2);
    L14:
        return r3.build();
    }

    public FrescoLoader border(int r2, float r3, boolean r4) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setBorder(r2, r3);
        this.mRoundingParams.setScaleDownInsideBorders(r4);
        return this;
    }

    public FrescoLoader cornersRadii(float r2, float r3, float r4, float r5) {
        if (this.mRoundingParams != null) goto L5;
        this.mRoundingParams = new RoundingParams();
    L5:
        this.mRoundingParams.setCornersRadii(r2, r3, r4, r5);
        return this;
    }

    private static ImageRequest[] createImageRequests(Uri r5, py.k r6, ResizeOptions r7, Postprocessor r8, boolean r9, String r11) {
        if (r5 != null) goto L9;
        if (r6 == null) goto L8;
        if (Lists.isEmpty(r6.getUrls()) == false) goto L9;
    L8:
        return new ImageRequest[0];
    L9:
        ArrayList r1 = new ArrayList();
        ImageRequest r12 = createImageRequestWithUri(r5, r7, r11);
        if (r12 == null) goto L12;
        r1.add(r12);
    L12:
        if (r6 == null) goto L35;
        if (Lists.isEmpty(r6.getUrls()) == true) goto L35;
        ImageNetworkRequestsMonitor r13 = new ImageNetworkRequestsMonitor();
        Iterator<String> r14 = r6.getUrls().iterator();
    L17:
        if (r14.hasNext() == false) goto L35;
        String r2 = r14.next();
        if (StringUtils.isEmpty(r2) == true) goto L17;
        ImageRequestBuilder r3 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r2));
        if (r8 == null) goto L24;
        r3.setPostprocessor(r8);
    L24:
        if (r7 == null) goto L26;
        r3.setResizeOptions(r7);
    L26:
        if (r9 == false) goto L29;
        ImageDecodeOptionsBuilder r4 = ImageDecodeOptions.newBuilder();
        r4.setBitmapConfig(Bitmap.Config.RGB_565);
        r3.setImageDecodeOptions(r4.build());
    L29:
        if (TextUtils.isEmpty(r11) == false) goto L31;
    L33:
        r13.monitor(r3);
        r1.add(r3.build());
        goto L17
    L31:
        if (((Boolean) InteractCustomDiskConfig.a.getValue()).booleanValue() == false) goto L33;
        r3.setCacheChoice(ImageRequest.CacheChoice.CUSTOM).setCustomCacheName(r11);
    L35:
        if (r1.size() != 0) goto L39;
        return new ImageRequest[0];
    L39:
        return (ImageRequest[]) r1.toArray(new ImageRequest[r1.size()]);
    }
}
