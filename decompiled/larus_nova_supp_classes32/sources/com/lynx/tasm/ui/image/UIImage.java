package com.lynx.tasm.ui.image;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.ILynxUIMeaningfulContent$MeaningfulContentStatus;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.ui.image.AbsUIImage;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.ui.image.FrescoImageView;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIImage<T extends FrescoImageView> extends AbsUIImage<T> {
    public static final String EVENT_ERROR = "error";
    protected AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private boolean mEnableImageAsyncRedirectOnCreate;
    private boolean mHasPendingPlaceholder;
    private boolean mHasPendingSource;
    private int mImageDstHeight;
    private int mImageDstWidth;
    private String mOriginPlaceholder;
    private boolean mPendingLoad;
    private int mScrollState;
    private com.lynx.tasm.behavior.ui.f mScrollStateChangeListener;
    private boolean mSkipRedirection;
    private String mSources;
    private boolean mSuspendable;

    public class a extends l {
        public final /* synthetic */ UIImage a;

        @Override // com.lynx.tasm.ui.image.l
        public final boolean isPendingLoad() {
            return UIImage.access$500(this.a);
        }

        public a(UIImage r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.ui.image.l
        public final void onImageDstSize(int r2, int r3) {
            UIImage.access$302(this.a, r2);
            UIImage.access$402(this.a, r3);
        }

        @Override // com.lynx.tasm.ui.image.l
        public final void onImageLoadSuccess(int r4, int r5) {
            if (UIImage.access$000(this.a) != null) goto L5;
            return;
        L5:
            if (UIImage.access$100(this.a).containsKey("load") == false) goto L9;
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
            this.a.getLynxContext().reportResourceError(UIImage.access$200(this.a), "image", r4);
        }
    }

    public class b implements f {
        public final /* synthetic */ UIImage a;

        @Override // com.lynx.tasm.ui.image.f
        public final void a() {
            UIImage.access$600(this.a);
        }

        public b(UIImage r1) {
            this.a = r1;
        }
    }

    public class c implements com.lynx.tasm.behavior.ui.f {
        public final /* synthetic */ UIImage a;

        public c(UIImage r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.behavior.ui.f
        public final void onScrollStateChanged(int r2) {
            UIImage.access$702(this.a, r2);
            if (UIImage.access$500(this.a) == false) goto L7;
            if (r2 != 0) goto L8;
            UIImage.access$502(this.a, false);
            UIImage.access$600(this.a);
            return;
        L8:
            return;
        }
    }

    public static /* synthetic */ class d {
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

    /* JADX WARN: Multi-variable type inference failed */
    private void reloadImage() {
        if (this.mSuspendable == true) goto L5;
    L8:
        ((FrescoImageView) this.mView).maybeUpdateView();
        return;
    L5:
        if (this.mScrollState == 0) goto L8;
        this.mPendingLoad = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateImageSource() {
        if (this.mSkipRedirection == true) goto L10;
        if (this.mHasPendingPlaceholder == false) goto L10;
        if (this.mHasPendingSource == false) goto L10;
        ((FrescoImageView) this.mView).setRedirectImageSource(this.mSources, this.mOriginPlaceholder);
        ((FrescoImageView) this.mView).invalidate();
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
    L10:
        if (this.mHasPendingSource == false) goto L17;
        if (this.mSkipRedirection == false) goto L14;
        ((FrescoImageView) this.mView).setSrcSkippingRedirection(this.mSources);
    L15:
        this.mHasPendingSource = false;
        goto L17
    L14:
        ((FrescoImageView) this.mView).setSrc(this.mSources);
        ((FrescoImageView) this.mView).invalidate();
    L17:
        if (this.mHasPendingPlaceholder == false) goto L20;
        this.mHasPendingPlaceholder = false;
        ((FrescoImageView) this.mView).setPlaceholder(this.mOriginPlaceholder, !this.mSkipRedirection);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        T r0 = this.mView;
        if (r0 == 0) goto L9;
        if (((FrescoImageView) r0).getBitmapMemorySizeBytes() <= 0) goto L9;
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
    L9:
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void startAnimate() {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).stopAnimate();
        ((FrescoImageView) this.mView).startAnimate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        ((FrescoImageView) this.mView).destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public long getMemoryUsageBytes() {
        long r0 = super.getMemoryUsageBytes();
        T r2 = this.mView;
        if (r2 != 0) goto L6;
        return r0;
    L6:
        return ((FrescoImageView) r2).getBitmapMemorySizeBytes() + r0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public Map<String, String> getMemoryUsageDetail() {
        long r0 = getMemoryUsageBytes();
        String r2 = this.mSources;
        if (r0 == 0) goto L13;
        if (r2 == null) goto L13;
        if (r2.isEmpty() == true) goto L13;
        if (r2.startsWith("data:image") == false) goto L11;
        return null;
    L11:
        HashMap r3 = new HashMap();
        r3.put(r2, String.valueOf(r0));
        return r3;
    L13:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ViewCompat.setAccessibilityDelegate(r0, new CustomAccessibilityDelegateCompat(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        ((FrescoImageView) this.mView).destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r0 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r1 = this.mPaddingRight + this.mBorderRightWidth;
        int r2 = this.mPaddingTop + this.mBorderTopWidth;
        int r3 = this.mPaddingBottom + this.mBorderBottomWidth;
        if ((getWidth() - this.mImageDstWidth) > 1) goto L7;
        if ((getHeight() - this.mImageDstHeight) > 1) goto L7;
    L9:
        ((FrescoImageView) this.mView).setPadding(r0, r2, r1, r3);
        return;
    L7:
        if (hasAnimationRunning() == true) goto L9;
        ((FrescoImageView) this.mView).markDirty();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).onNodeReady();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.mEnableImageAsyncRedirectOnCreate == true) goto L5;
        updateImageSource();
    L5:
        ((FrescoImageView) this.mView).setConsumeHoverEvent(this.mConsumeHoverEvent);
        reloadImage();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void renderIfNeeded() {
        reloadImage();
    }

    public UIImage(LynxContext r2) {
        super(r2);
        this.mImageDstHeight = 0;
        this.mImageDstWidth = 0;
        this.mSources = null;
        this.mOriginPlaceholder = null;
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
        this.mSkipRedirection = false;
        this.mScrollState = 0;
    }

    public static /* synthetic */ Map access$000(UIImage r0) {
        return r0.mEvents;
    }

    public static /* synthetic */ Map access$100(UIImage r0) {
        return r0.mEvents;
    }

    public static /* synthetic */ String access$200(UIImage r0) {
        return r0.mSources;
    }

    public static /* synthetic */ boolean access$500(UIImage r0) {
        return r0.mPendingLoad;
    }

    public static /* synthetic */ void access$600(UIImage r0) {
        r0.reloadImage();
    }

    /* JADX INFO: renamed from: createView */
    public T mo28createView(Context r7) {
        PipelineDraweeControllerBuilder r2 = Fresco.newDraweeControllerBuilder();
        this.mDraweeControllerBuilder = r2;
        T r8 = (T) onCreateView(r7, r2, null, getLynxContext().getFrescoCallerContext(), this);
        r8.setImageLoaderCallback(new a(this));
        r8.setImageRedirectListener(new b(this));
        this.mEnableImageAsyncRedirectOnCreate = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
        return r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "fix-fresco-bug")
    public void fixFrescoWebPBug(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).fixFrescoWebPBug(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onBorderRadiusUpdated(int r2) {
        ((FrescoImageView) this.mView).setBorderRadius(getLynxBackground().m());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "async-redirect")
    public void setAsyncRedirect(boolean r2) {
        ((FrescoImageView) this.mView).setAsyncRedirect(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "autoplay")
    public void setAutoPlay(boolean r2) {
        ((FrescoImageView) this.mView).setAutoPlay(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setAutoSize(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setAutoSize(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setBlurRadius(String r9) {
        UIBody r0 = this.mContext.getUIBody();
        ((FrescoImageView) this.mView).setBlurRadius(Math.round(com.lynx.tasm.utils.n.c(r9, r0.getFontSize(), this.mFontSize, r0.getWidth(), r0.getHeight(), this.mContext.getScreenMetrics())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "android-cache-key-path-only")
    public void setCacheKeyPathOnly(boolean r2) {
        ((FrescoImageView) this.mView).setCacheKeyPathOnly(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setCapInsets(String r2) {
        if (r2 != null) goto L4;
    L8:
        ((FrescoImageView) this.mView).setCapInsets(null);
        return;
    L4:
        if (r2.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L8;
        ((FrescoImageView) this.mView).setCapInsets(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    @LynxProp(name = "cap-insets")
    public void setCapInsetsBackUp(String r1) {
        setCapInsets(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    @LynxProp(name = "cap-insets-scale")
    public void setCapInsetsScale(String r2) {
        if (r2 != null) goto L4;
    L8:
        ((FrescoImageView) this.mView).setCapInsetsScale(null);
        return;
    L4:
        if (r2.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L8;
        ((FrescoImageView) this.mView).setCapInsetsScale(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setCoverStart(boolean r2) {
        ((FrescoImageView) this.mView).setCoverStart(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "additional-custom-info")
    public void setCustomParams(ReadableMap r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setImageCustomParams(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "defer-src-invalidation")
    public void setDeferInvalidation(boolean r2) {
        ((FrescoImageView) this.mView).setDeferInvalidation(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setDisableDefaultPlaceholder(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setDisableDefaultPlaceHolder(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setDisableDefaultResize(boolean r2) {
        T r0 = this.mView;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        ((FrescoImageView) r0).setResizeMethod(ImageResizeMethod.SCALE);
        return;
    L7:
        ((FrescoImageView) r0).setResizeMethod(ImageResizeMethod.RESIZE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "enable-custom-gif-decoder")
    public void setEnableCustomGifDecoder(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setEnableCustomGifDecoder(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "enable-report-info")
    public void setEnableReportInfo(boolean r2) {
        ((FrescoImageView) this.mView).setEnableReportInfo(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "enable-resource-hint")
    public void setEnableResourceHint(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setEnableResourceHint(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "android-enable-smooth-animation")
    public void setEnableSmoothAnimation(boolean r2) {
        ((FrescoImageView) this.mView).setSmoothAnimation(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> r2) {
        super.setEvents(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        T r0 = this.mView;
        if (r0 == 0) goto L9;
        ((FrescoImageView) r0).setImageEvents(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "extra-load-info")
    public void setExtraLoadInfo(boolean r2) {
        ((FrescoImageView) this.mView).setExtraLoadInfo(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "fresco-attach")
    public void setFrescoAttach(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.equalsIgnoreCase("true") == false) goto L6;
    L7:
        T r4 = this.mView;
        ((FrescoImageView) r4).mIsFrescoAttach = true;
        ((FrescoImageView) r4).setFrescoAttach();
        return;
    L6:
        if (r3.equalsIgnoreCase("yes") == true) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "fresco-nine-patch")
    public void setFrescoNinePatch(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setFrescoNinePatch(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "fresco-visible")
    public void setFrescoVisible(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.equalsIgnoreCase("true") == false) goto L6;
    L7:
        T r4 = this.mView;
        ((FrescoImageView) r4).mIsFrescoVisible = true;
        ((FrescoImageView) r4).setFrescoVisible();
        return;
    L6:
        if (r3.equalsIgnoreCase("yes") == true) goto L7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "cache-choice")
    public void setImageCacheChoice(String r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setImageCacheChoice(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "image-config")
    public void setImageConfig(String r2) {
        super.setImageConfig(r2);
        ((FrescoImageView) this.mView).setBitmapConfig(this.mBitmapConfig);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "placeholder-hash-config")
    public void setImagePlaceHolderHashConfig(ReadableMap r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setImagePlaceHolderHashConfig(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setImageRendering(int r3) {
        super.setImageRendering(r3);
        T r0 = this.mView;
        if (r0 == 0) goto L10;
        FrescoImageView r1 = (FrescoImageView) r0;
        if (r3 != 2) goto L7;
        boolean r4 = true;
    L8:
        r1.setIsPixelated(r4);
        return;
    L7:
        r4 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "fetch-priority")
    public void setImageRequestPriority(String r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setImageRequestPriority(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "enable-super-resolution")
    public void setImageSR(boolean r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setEnableImageSR(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "super-resolution-scale")
    public void setImageSRScale(float r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setImageSRScale(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "image-transition-style")
    public void setImageTransitionStyle(String r2) {
        ((FrescoImageView) this.mView).setImageTransitionStyle(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setLocalCache(f6a.a r3) {
        super.setLocalCache(r3);
        if (this.mView != 0) goto L5;
        return;
    L5:
        u7a.g.b r4 = u7a.g.b(r3);
        boolean r0 = r4.a;
        boolean r5 = r4.b;
        ((FrescoImageView) this.mView).setLocalCache(r0);
        ((FrescoImageView) this.mView).setAwaitLocalCache(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setLoopCount(int r2) {
        if (r2 > 0) goto L4;
        r2 = 0;
    L4:
        ((FrescoImageView) this.mView).setLoopCount(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setObjectFit(String r2) {
        ((FrescoImageView) this.mView).setScaleType(o.b(r2));
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setPlaceholder(String r2) {
        this.mHasPendingPlaceholder = true;
        this.mOriginPlaceholder = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setPreFetchHeight(String r9) {
        ((FrescoImageView) this.mView).setPreFetchHeight(com.lynx.tasm.utils.n.b(r9, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setPreFetchWidth(String r9) {
        ((FrescoImageView) this.mView).setPreFetchWidth(com.lynx.tasm.utils.n.b(r9, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.getScreenMetrics()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "progressive-rendering")
    public void setProgressiveRendering(boolean r2) {
        ((FrescoImageView) this.mView).setProgressiveRendering(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "region-to-decode")
    public void setRegionToDecode(ReadableMap r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setRegionToDecode(u7a.g.c(r2));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setRepeat(boolean r2) {
        ((FrescoImageView) this.mView).setRepeat(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "android-simple-cache-key")
    public void setSimpleCacheKey(boolean r2) {
        ((FrescoImageView) this.mView).setSimpleCacheKey(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(defaultBoolean = false, name = "skip-redirection")
    public void setSkipRedirection(boolean r1) {
        this.mSkipRedirection = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setSource(String r2) {
        if (r2 != null) goto L4;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L4:
        String r0 = this.mSources;
        if (r0 != null) goto L7;
    L9:
        this.mSources = r2;
        this.mHasPendingSource = true;
        return;
    L7:
        if (r0.equals(r2) == true) goto L9;
        this.mImageDstWidth = 0;
        this.mImageDstHeight = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "subsample")
    public void setSubSample(String r2) {
        if (r2 != null) goto L4;
    L8:
        boolean r3 = false;
    L9:
        T r0 = this.mView;
        if (r0 == 0) goto L13;
        ((FrescoImageView) r0).setNoSubSampleMode(r3);
        return;
    L13:
        return;
    L4:
        if (r2.equalsIgnoreCase("false") == false) goto L6;
    L7:
        r3 = true;
        goto L9
    L6:
        if (r2.equalsIgnoreCase("no") == false) goto L8;
        goto L7
    }

    @LynxProp(name = "suspendable")
    public void setSuspendable(f6a.a r3) {
        this.mSuspendable = false;
        if (r3 == null) goto L12;
        int r0 = d.a[r3.getType().ordinal()];
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
        this.mScrollStateChangeListener = new c(this);
    L18:
        registerScrollStateListener(this.mScrollStateChangeListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "tint-color")
    public void setTintColor(String r2) {
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((FrescoImageView) r0).setTintColor(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxUI
    @LynxProp(defaultInt = 1, name = "visibility")
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        T r3 = this.mView;
        if (((FrescoImageView) r3).mIsFrescoVisible == false) goto L6;
        ((FrescoImageView) r3).setFrescoVisible();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        T r7 = this.mView;
        if (r7 == 0) goto L12;
        ((FrescoImageView) r7).updateRedirectCheckResult(this.mSources, this.mOriginPlaceholder, this.mHasPendingSource, this.mHasPendingPlaceholder);
        goto L12
    }

    public UIImage(Context r1) {
        this((LynxContext) r1);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return mo28createView(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLocalCache(Boolean r3) {
        T r0 = this.mView;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        ((FrescoImageView) r0).setLocalCache(false);
    L7:
        ((FrescoImageView) this.mView).setLocalCache(r3.booleanValue());
    }

    public UIImage(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mImageDstHeight = 0;
        this.mImageDstWidth = 0;
        this.mSources = null;
        this.mOriginPlaceholder = null;
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
        this.mSkipRedirection = false;
        this.mScrollState = 0;
    }

    public static /* synthetic */ int access$302(UIImage r0, int r1) {
        r0.mImageDstWidth = r1;
        return r1;
    }

    public static /* synthetic */ int access$402(UIImage r0, int r1) {
        r0.mImageDstHeight = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(UIImage r0, boolean r1) {
        r0.mPendingLoad = r1;
        return r1;
    }

    public static /* synthetic */ int access$702(UIImage r0, int r1) {
        r0.mScrollState = r1;
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void pauseAnimation(ReadableMap r4, Callback r5) {
        T r6 = this.mView;
        if (r6 != 0) goto L5;
        return;
    L5:
        if (((FrescoImageView) r6).pauseAnimate() == false) goto L7;
        r5.invoke(new Object[]{0, "Animation paused."});
        return;
    L7:
        r5.invoke(new Object[]{4, "Not support pause yet"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void resumeAnimation(ReadableMap r3, Callback r4) {
        T r5 = this.mView;
        if (r5 == 0) goto L6;
        ((FrescoImageView) r5).startAnimate();
        r4.invoke(new Object[]{0, "Animation resumed."});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void stopAnimation(ReadableMap r3, Callback r4) {
        T r5 = this.mView;
        if (r5 == 0) goto L6;
        ((FrescoImageView) r5).stopAnimate();
        r4.invoke(new Object[]{0, "Animation stopped."});
        return;
    }

    public T onCreateView(Context r7, AbstractDraweeControllerBuilder r8, e r9, Object r10, LynxBaseUI r11) {
        return (T) new FrescoImageView(r7, this.mDraweeControllerBuilder, null, getLynxContext().getFrescoCallerContext(), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onBeforeAnimation(int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        if (r10 <= this.mImageDstWidth) goto L5;
    L6:
        ((FrescoImageView) this.mView).tryFetchImage(r10, r11, r12, r13, r14, r15);
        return;
    L5:
        if (r11 > this.mImageDstHeight) goto L6;
    }
}
