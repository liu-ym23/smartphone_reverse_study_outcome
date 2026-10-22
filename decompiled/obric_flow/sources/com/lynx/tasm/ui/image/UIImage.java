package com.lynx.tasm.ui.image;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.ui.image.AbsUIImage;
import com.lynx.tasm.ui.image.FrescoImageView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class UIImage<T extends FrescoImageView> extends AbsUIImage<T> {
    public static final String EVENT_ERROR = "error";

    @Nullable
    protected AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private boolean mEnableImageAsyncRedirectOnCreate;
    private boolean mHasPendingPlaceholder;
    private boolean mHasPendingSource;
    private int mImageDstHeight;
    private int mImageDstWidth;
    private boolean mIsNoSubSampleMode;
    private String mOriginPlaceholder;
    private boolean mPendingLoad;
    private int mScrollState;
    private com.lynx.tasm.behavior.ui.q mScrollStateChangeListener;
    private boolean mSkipRedirection;

    @Keep
    private String mSources;
    private boolean mSuspendable;

    @Deprecated
    public UIImage(Context r5) {
        this((LynxContext) r5);
    }

    public static /* synthetic */ Map access$000(UIImage r5) {
        return r5.mEvents;
    }

    public static /* synthetic */ Map access$100(UIImage r5) {
        return r5.mEvents;
    }

    public static /* synthetic */ String access$200(UIImage r5) {
        return r5.mSources;
    }

    public static /* synthetic */ int access$302(UIImage r5, int r10) {
        r5.mImageDstWidth = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(UIImage r5, int r10) {
        r5.mImageDstHeight = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$500(UIImage r5) {
        return r5.mPendingLoad;
    }

    public static /* synthetic */ boolean access$502(UIImage r5, boolean r10) {
        r5.mPendingLoad = r10;
        return r10;
    }

    public static /* synthetic */ void access$600(UIImage r5) {
        r5.reloadImage();
    }

    public static /* synthetic */ int access$702(UIImage r5, int r10) {
        r5.mScrollState = r10;
        return r10;
    }

    private void reloadImage() {
        if (this.mSuspendable == true) goto L5;
    L8:
        ((FrescoImageView) this.mView).maybeUpdateView();
        return;
    L5:
        if (this.mScrollState == 0) goto L8;
        this.mPendingLoad = true;
    }

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

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r5) {
        return createView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        ((FrescoImageView) this.mView).destroy();
    }

    @com.lynx.tasm.behavior.c0(name = "fix-fresco-bug")
    public void fixFrescoWebPBug(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).fixFrescoWebPBug(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public long getMemoryUsageBytes() {
        long r5 = super.getMemoryUsageBytes();
        T r10 = this.mView;
        if (r10 != 0) goto L6;
        return r5;
    L6:
        return ((FrescoImageView) r10).getBitmapMemorySizeBytes() + r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public Map<String, String> getMemoryUsageDetail() {
        long r5 = getMemoryUsageBytes();
        String r10 = this.mSources;
        if (r5 == 0) goto L13;
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

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        T r5 = this.mView;
        if (r5 == 0) goto L6;
        ViewCompat.setAccessibilityDelegate(r5, new CustomAccessibilityDelegateCompat(this));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onBeforeAnimation(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        if (r12 <= this.mImageDstWidth) goto L5;
    L8:
        ((FrescoImageView) this.mView).tryFetchImage(r12, r13, r14, r15, r16, r17);
        return;
    L5:
        if (r13 > this.mImageDstHeight) goto L8;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onBorderRadiusUpdated(int r5) {
        ((FrescoImageView) this.mView).setBorderRadius(getLynxBackground().n());
    }

    public T onCreateView(Context r10, AbstractDraweeControllerBuilder r11, @Nullable q r12, @Nullable Object r13, LynxBaseUI r14) {
        AbstractDraweeControllerBuilder r5 = this.mDraweeControllerBuilder;
        getLynxContext().getClass();
        return (T) new FrescoImageView(r10, r5, null, null, this);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        ((FrescoImageView) this.mView).destroy();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r5 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r10 = this.mPaddingRight + this.mBorderRightWidth;
        int r11 = this.mPaddingTop + this.mBorderTopWidth;
        int r12 = this.mPaddingBottom + this.mBorderBottomWidth;
        if ((getWidth() - this.mImageDstWidth) > 1) goto L7;
        if ((getHeight() - this.mImageDstHeight) > 1) goto L7;
    L9:
        ((FrescoImageView) this.mView).setPadding(r5, r11, r10, r12);
        return;
    L7:
        if (hasAnimationRunning() == true) goto L9;
        ((FrescoImageView) this.mView).markDirty();
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        T r5 = this.mView;
        if (r5 == 0) goto L6;
        ((FrescoImageView) r5).onNodeReady();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.mEnableImageAsyncRedirectOnCreate == true) goto L5;
        updateImageSource();
    L5:
        ((FrescoImageView) this.mView).setConsumeHoverEvent(this.mConsumeHoverEvent);
        reloadImage();
    }

    @com.lynx.tasm.behavior.f0
    public void pauseAnimation(ReadableMap r5, Callback r10) {
        T r11 = this.mView;
        if (r11 != 0) goto L5;
        return;
    L5:
        if (((FrescoImageView) r11).pauseAnimate() == false) goto L8;
        r10.invoke(new Object[]{0, "Animation paused."});
        return;
    L8:
        r10.invoke(new Object[]{4, "Not support pause yet"});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void renderIfNeeded() {
        reloadImage();
    }

    @com.lynx.tasm.behavior.f0
    public void resumeAnimation(ReadableMap r5, Callback r10) {
        T r11 = this.mView;
        if (r11 == 0) goto L6;
        ((FrescoImageView) r11).startAnimate();
        r10.invoke(new Object[]{0, "Animation resumed."});
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "async-redirect")
    public void setAsyncRedirect(boolean r5) {
        ((FrescoImageView) this.mView).setAsyncRedirect(r5);
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = true, name = "autoplay")
    public void setAutoPlay(boolean r5) {
        ((FrescoImageView) this.mView).setAutoPlay(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setAutoSize(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setAutoSize(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setBlurRadius(String r10) {
        UIBody r5 = this.mContext.f10145m;
        ((FrescoImageView) this.mView).setBlurRadius(Math.round(com.lynx.tasm.utils.k.c(r10, r5.getFontSize(), this.mFontSize, r5.getWidth(), r5.getHeight(), 0.0f, this.mContext.f10152u)));
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setCapInsets(String r5) {
        if (r5 != null) goto L4;
    L8:
        ((FrescoImageView) this.mView).setCapInsets(null);
        return;
    L4:
        if (r5.equalsIgnoreCase("") == true) goto L8;
        ((FrescoImageView) this.mView).setCapInsets(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    @com.lynx.tasm.behavior.c0(name = "cap-insets")
    public void setCapInsetsBackUp(String r5) {
        setCapInsets(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    @com.lynx.tasm.behavior.c0(name = "cap-insets-scale")
    public void setCapInsetsScale(String r5) {
        if (r5 != null) goto L4;
    L8:
        ((FrescoImageView) this.mView).setCapInsetsScale(null);
        return;
    L4:
        if (r5.equalsIgnoreCase("") == true) goto L8;
        ((FrescoImageView) this.mView).setCapInsetsScale(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setCoverStart(boolean r5) {
        ((FrescoImageView) this.mView).setCoverStart(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "additional-custom-info")
    public void setCustomParams(ReadableMap r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setImageCustomParams(r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "defer-src-invalidation")
    public void setDeferInvalidation(boolean r5) {
        ((FrescoImageView) this.mView).setDeferInvalidation(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setDisableDefaultPlaceholder(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setDisableDefaultPlaceHolder(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setDisableDefaultResize(boolean r5) {
        T r10 = this.mView;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (r5 == false) goto L8;
        ((FrescoImageView) r10).setResizeMethod(ImageResizeMethod.f10990c);
        return;
    L8:
        ((FrescoImageView) r10).setResizeMethod(ImageResizeMethod.f10989b);
    }

    @com.lynx.tasm.behavior.c0(name = "enable-custom-gif-decoder")
    public void setEnableCustomGifDecoder(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setEnableCustomGifDecoder(r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "enable-resource-hint")
    public void setEnableResourceHint(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setEnableResourceHint(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, on.a> r5) {
        super.setEvents(r5);
        if (r5 == null) goto L10;
        T r10 = this.mView;
        if (r10 == 0) goto L9;
        ((FrescoImageView) r10).setImageEvents(r5);
        return;
    L9:
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "extra-load-info")
    public void setExtraLoadInfo(boolean r5) {
        ((FrescoImageView) this.mView).setExtraLoadInfo(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "fresco-attach")
    public void setFrescoAttach(@Nullable String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.equalsIgnoreCase("true") == false) goto L6;
    L7:
        FrescoImageView r10 = (FrescoImageView) this.mView;
        r10.mIsFrescoAttach = true;
        r10.setFrescoAttach();
        return;
    L6:
        if (r5.equalsIgnoreCase("yes") == true) goto L7;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "fresco-nine-patch")
    public void setFrescoNinePatch(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setFrescoNinePatch(r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "fresco-visible")
    public void setFrescoVisible(@Nullable String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.equalsIgnoreCase("true") == false) goto L6;
    L7:
        FrescoImageView r10 = (FrescoImageView) this.mView;
        r10.mIsFrescoVisible = true;
        r10.setFrescoVisible();
        return;
    L6:
        if (r5.equalsIgnoreCase("yes") == true) goto L7;
    }

    @com.lynx.tasm.behavior.c0(name = "cache-choice")
    public void setImageCacheChoice(String r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setImageCacheChoice(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(name = "image-config")
    public void setImageConfig(String r5) {
        super.setImageConfig(r5);
        ((FrescoImageView) this.mView).setBitmapConfig(this.mBitmapConfig);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "placeholder-hash-config")
    public void setImagePlaceHolderHashConfig(ReadableMap r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setImagePlaceHolderHashConfig(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setImageRendering(int r5) {
        super.setImageRendering(r5);
        T r10 = this.mView;
        if (r10 == 0) goto L10;
        FrescoImageView r11 = (FrescoImageView) r10;
        if (r5 != 2) goto L7;
        boolean r12 = true;
    L8:
        r11.setIsPixelated(r12);
        return;
    L7:
        r12 = false;
        goto L8
    }

    @com.lynx.tasm.behavior.c0(name = "fetch-priority")
    public void setImageRequestPriority(String r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setImageRequestPriority(r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "enable-super-resolution")
    public void setImageSR(boolean r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setEnableImageSR(r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "super-resolution-scale")
    public void setImageSRScale(float r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setImageSRScale(r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "image-transition-style")
    public void setImageTransitionStyle(String r5) {
        ((FrescoImageView) this.mView).setImageTransitionStyle(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setLocalCache(@Nullable pm.a r5) {
        super.setLocalCache(r5);
        if (this.mView != 0) goto L5;
        return;
    L5:
        wn.c r10 = com.bytedance.apm.util.a.f(r5);
        boolean r11 = r10.f22882a;
        boolean r12 = r10.f22883b;
        ((FrescoImageView) this.mView).setLocalCache(r11);
        ((FrescoImageView) this.mView).setAwaitLocalCache(r12);
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setLoopCount(int r5) {
        if (r5 > 0) goto L4;
        r5 = 0;
    L4:
        ((FrescoImageView) this.mView).setLoopCount(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setObjectFit(@Nullable String r5) {
        ((FrescoImageView) this.mView).setScaleType(e0.a(r5));
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setPlaceholder(String r5) {
        this.mHasPendingPlaceholder = true;
        this.mOriginPlaceholder = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setPreFetchHeight(String r10) {
        ((FrescoImageView) this.mView).setPreFetchHeight(com.lynx.tasm.utils.k.c(r10, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.f10152u));
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setPreFetchWidth(String r10) {
        ((FrescoImageView) this.mView).setPreFetchWidth(com.lynx.tasm.utils.k.c(r10, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.mContext.f10152u));
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setRepeat(boolean r5) {
        ((FrescoImageView) this.mView).setRepeat(r5);
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = true, name = "android-simple-cache-key")
    public void setSimpleCacheKey(boolean r5) {
        ((FrescoImageView) this.mView).setSimpleCacheKey(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "skip-redirection")
    public void setSkipRedirection(boolean r5) {
        this.mSkipRedirection = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.image.AbsUIImage
    public void setSource(String r5) {
        if (r5 != null) goto L4;
        r5 = "";
    L4:
        String r10 = this.mSources;
        if (r10 != null) goto L7;
    L9:
        this.mSources = r5;
        this.mHasPendingSource = true;
        return;
    L7:
        if (r10.equals(r5) == true) goto L9;
        this.mImageDstWidth = 0;
        this.mImageDstHeight = 0;
        goto L9
    }

    @com.lynx.tasm.behavior.c0(name = "subsample")
    public void setSubSample(@Nullable String r5) {
        if (r5 != null) goto L4;
    L8:
        this.mIsNoSubSampleMode = false;
    L9:
        T r10 = this.mView;
        if (r10 == 0) goto L13;
        ((FrescoImageView) r10).setNoSubSampleMode(this.mIsNoSubSampleMode);
        return;
    L13:
        return;
    L4:
        if (r5.equalsIgnoreCase("false") == false) goto L6;
    L7:
        this.mIsNoSubSampleMode = true;
        goto L9
    L6:
        if (r5.equalsIgnoreCase("no") == false) goto L8;
        goto L7
    }

    @com.lynx.tasm.behavior.c0(name = "suspendable")
    public void setSuspendable(pm.a r5) {
        this.mSuspendable = false;
        if (r5 == null) goto L12;
        int r10 = c1.f11033a[r5.getType().ordinal()];
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
        this.mScrollStateChangeListener = new e(this, 1);
    L18:
        registerScrollStateListener(this.mScrollStateChangeListener);
    }

    @com.lynx.tasm.behavior.c0(name = "tint-color")
    public void setTintColor(String r5) {
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((FrescoImageView) r10).setTintColor(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    @com.lynx.tasm.behavior.c0(defaultInt = 1, name = "visibility")
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        FrescoImageView r10 = (FrescoImageView) this.mView;
        if (r10.mIsFrescoVisible == false) goto L6;
        r10.setFrescoVisible();
        return;
    }

    @com.lynx.tasm.behavior.f0
    public void startAnimate() {
        T r5 = this.mView;
        if (r5 == 0) goto L6;
        ((FrescoImageView) r5).stopAnimate();
        ((FrescoImageView) this.mView).startAnimate();
        return;
    }

    @com.lynx.tasm.behavior.f0
    public void stopAnimation(ReadableMap r5, Callback r10) {
        T r11 = this.mView;
        if (r11 == 0) goto L6;
        ((FrescoImageView) r11).stopAnimate();
        r10.invoke(new Object[]{0, "Animation stopped."});
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updatePropertiesInterval(com.lynx.tasm.behavior.y0 r5) {
        super.updatePropertiesInterval(r5);
        if (this.mSkipRedirection == true) goto L9;
        T r10 = this.mView;
        if (r10 == 0) goto L9;
        ((FrescoImageView) r10).updateRedirectCheckResult(this.mSources, this.mOriginPlaceholder, this.mHasPendingSource, this.mHasPendingPlaceholder);
    L9:
        if (this.mEnableImageAsyncRedirectOnCreate == false) goto L12;
        updateImageSource();
        return;
    }

    public UIImage(LynxContext r5, Object r10) {
        super(r5, r10);
        this.mImageDstHeight = 0;
        this.mImageDstWidth = 0;
        this.mIsNoSubSampleMode = false;
        this.mSources = null;
        this.mOriginPlaceholder = null;
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
        this.mSkipRedirection = false;
        this.mScrollState = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public T createView(Context r10) {
        PipelineDraweeControllerBuilder r5 = ((PipelineDraweeControllerBuilderSupplier) Fresco.f7726a.a()).a();
        this.mDraweeControllerBuilder = r5;
        getLynxContext().getClass();
        T r11 = (T) onCreateView(r10, r5, null, null, this);
        r11.setNoSubSampleMode(this.mIsNoSubSampleMode);
        r11.setImageLoaderCallback(new c(this, 2));
        r11.setImageRedirectListener(new k6.a(this));
        this.mEnableImageAsyncRedirectOnCreate = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
        return r11;
    }

    @Deprecated
    public void setLocalCache(Boolean r5) {
        T r10 = this.mView;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        ((FrescoImageView) r10).setLocalCache(false);
    L7:
        ((FrescoImageView) this.mView).setLocalCache(r5.booleanValue());
    }

    public UIImage(LynxContext r5) {
        super(r5, null);
        this.mImageDstHeight = 0;
        this.mImageDstWidth = 0;
        this.mIsNoSubSampleMode = false;
        this.mSources = null;
        this.mOriginPlaceholder = null;
        this.mHasPendingSource = false;
        this.mHasPendingPlaceholder = false;
        this.mSkipRedirection = false;
        this.mScrollState = 0;
    }
}
