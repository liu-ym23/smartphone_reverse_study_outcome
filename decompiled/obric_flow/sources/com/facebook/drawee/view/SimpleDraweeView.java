package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.Lazy;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.IAbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweePlaceHolderConfig;
import com.facebook.imagepipeline.blurhash.BlurDecodeProducer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.obric.launcher.widget.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleDraweeView extends GenericDraweeView {
    private static DraweePlaceHolderConfig sDefaultDraweePlaceHolderConfig = null;
    private static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier = null;
    private static boolean sEnableLazySize = false;
    private static boolean sEnableVisibleOpt = true;
    private static IAbstractDraweeControllerBuilder sIDraweecontrollerbuildersupplier;
    private Lazy<AbstractDraweeControllerBuilder> mControllerBuilder;

    /* JADX INFO: renamed from: com.facebook.drawee.view.SimpleDraweeView$3, reason: invalid class name */
    class AnonymousClass3 implements BlurDecodeProducer.BlurDecodeCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleDraweeView f7948a;

        public AnonymousClass3(SimpleDraweeView r5) {
            this.f7948a = r5;
        }

        @Override // com.facebook.imagepipeline.blurhash.BlurDecodeProducer.BlurDecodeCallBack
        public final void a(Bitmap r5) {
            if (r5 == null) goto L7;
            final BitmapDrawable r10 = new BitmapDrawable(r5);
            if (this.f7948a.getRootView() == null) goto L8;
            this.f7948a.post(new AnonymousClass1(this, r10));
            return;
        L8:
            return;
        }
    }

    public SimpleDraweeView(Context r5, GenericDraweeHierarchy r10) {
        super(r5, r10);
        this.mControllerBuilder = new AnonymousClass1(this);
        a(r5, null);
    }

    public static /* synthetic */ Supplier access$000() {
        return sDraweecontrollerbuildersupplier;
    }

    public static /* synthetic */ Supplier access$002(Supplier r5) {
        sDraweecontrollerbuildersupplier = r5;
        return r5;
    }

    public static /* synthetic */ IAbstractDraweeControllerBuilder access$100() {
        return sIDraweecontrollerbuildersupplier;
    }

    public static /* synthetic */ void access$201(SimpleDraweeView r5, boolean r10) {
        super.onVisibilityAggregated(r10);
    }

    public static /* synthetic */ boolean access$300() {
        return sEnableVisibleOpt;
    }

    public static void enableLazySize(boolean r5) {
        sEnableLazySize = r5;
    }

    public static void enableVisibleOpt(boolean r5) {
        sEnableVisibleOpt = r5;
    }

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> r5) {
        sDraweecontrollerbuildersupplier = r5;
        ((AbstractDraweeControllerBuilder) r5.get()).getClass();
    }

    private void setDefaultPlaceHolder(TypedArray r5) {
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    public final void a(Context r5, AttributeSet r10) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L5
        if (isInEditMode() == false) goto L7;
        getTopLevelDrawable().setVisible(true, false);     // Catch: Throwable -> L5
        getTopLevelDrawable().invalidateSelf();     // Catch: Throwable -> L5
    L7:
        if (r10 == null) goto L26;
        TypedArray r11 = r5.obtainStyledAttributes(r10, R$styleable.SimpleDraweeView);     // Catch: Throwable -> L5
    L12:
        th = move-exception;
        r11.recycle();     // Catch: Throwable -> L5
        throw th;     // Catch: Throwable -> L5
    L10:
        if (r11.hasValue(R$styleable.SimpleDraweeView_actualImageUri) == false) goto L15;
        setImageURI(Uri.parse(r11.getString(R$styleable.SimpleDraweeView_actualImageUri)), null);     // Catch: Throwable -> L12
    L22:
        setDefaultPlaceHolder(r11);     // Catch: Throwable -> L12
        r11.recycle();     // Catch: Throwable -> L5
        goto L26
    L15:
        if (r11.hasValue(R$styleable.SimpleDraweeView_actualImageResource) == false) goto L22;
        int r12 = r11.getResourceId(R$styleable.SimpleDraweeView_actualImageResource, -1);     // Catch: Throwable -> L12
        if (r12 == (-1)) goto L22;
        if (isInEditMode() == false) goto L21;
        setImageResource(r12);     // Catch: Throwable -> L12
        goto L22
    L21:
        setActualImageResource(r12);     // Catch: Throwable -> L12
    L26:
        FrescoSystrace.a().getClass();
        return;
    L5:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return (AbstractDraweeControllerBuilder) this.mControllerBuilder.a();
    }

    public Uri getImageUri() {
        DraweeController r5 = getController();
        if ((r5 instanceof AbstractDraweeController) == false) goto L8;
        ImageRequest r10 = (ImageRequest) ((AbstractDraweeController) r5).f7788r;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f8415b;
    L8:
        return null;
    }

    public boolean isSameImageRequest(ImageRequest r5) {
        DraweeController r10 = getController();
        if ((r10 instanceof AbstractDraweeController) == false) goto L27;
        ImageRequest r11 = (ImageRequest) ((AbstractDraweeController) r10).f7788r;
        if (r11 == null) goto L23;
        if (r5 == null) goto L23;
        DefaultCacheKeyFactory r12 = ((ImagePipelineFactory) Preconditions.a(ImagePipelineFactory.f8097u, "ImagePipelineFactory was not initialized!")).e().f;
        BitmapMemoryCacheKey r13 = null;
        if (r12 == null) goto L14;
        if (r11 == null) goto L14;
        if (r11.f8422m == null) goto L13;
        BitmapMemoryCacheKey r14 = r12.b(r11, null);
    L15:
        DefaultCacheKeyFactory r15 = ((ImagePipelineFactory) Preconditions.a(ImagePipelineFactory.f8097u, "ImagePipelineFactory was not initialized!")).e().f;
        if (r15 == null) goto L22;
        if (r5.f8422m == null) goto L20;
        r13 = r15.b(r5, null);
        goto L22
    L20:
        r13 = r15.a(r5, null);
    L22:
        return Objects.a(r14, r13);
    L13:
        r14 = r12.a(r11, null);
    L14:
        r14 = null;
    L23:
        if (r11 != null) goto L29;
        if (r5 != null) goto L30;
        return true;
    L30:
        return false;
    L29:
        return false;
    L27:
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onVisibilityAggregated(final boolean r5) {
        UiThreadImmediateExecutorService.b().execute(new AnonymousClass2(this, r5));
    }

    public void setActualImageResource(@DrawableRes int r5) {
        setActualImageResource(r5, null);
    }

    public void setController(DraweeController r5, String r10, BlurHashConfig r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L11:
        setController(r5);
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        FLog.a("SimpleDraweeView", "setBlurHashImage, blurHash is null!");
    L9:
        if ((r5 instanceof AbstractDraweeController) == false) goto L11;
        ((AbstractDraweeController) r5).getClass();
        goto L11
    L7:
        new BlurDecodeProducer(r10, r11, new AnonymousClass3(this));
        goto L9
    }

    public void setImageRequest(ImageRequest r5) {
        AbstractDraweeControllerBuilder r10 = (AbstractDraweeControllerBuilder) this.mControllerBuilder.a();
        r10.f7797c = r5;
        r10.f7798h = getController();
        setController(r10.a());
    }

    @Override // com.facebook.drawee.view.DraweeView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r5) {
        super.setImageResource(r5);
    }

    @Override // com.facebook.drawee.view.DraweeView, androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri r5) {
        setImageURI(r5, null);
    }

    public void setActualImageResource(@DrawableRes int r5, Object r10) {
        Uri r11 = UriUtil.f7699a;
        setImageURI(new Uri.Builder().scheme("res").path(String.valueOf(r5)).build(), r10);
    }

    public void setImageURI(String r5) {
        setImageURI(r5, null);
    }

    public static void initialize(IAbstractDraweeControllerBuilder r5) {
        sIDraweecontrollerbuildersupplier = r5;
        r5.getClass();
    }

    public void setImageURI(String r5, String r10, BlurHashConfig r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L8:
        setImageURI(r5, null);
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        FLog.a("SimpleDraweeView", "setBlurHashImage, blurHash is null!");
        goto L8
    L7:
        new BlurDecodeProducer(r10, r11, new AnonymousClass3(this));
        goto L8
    }

    public SimpleDraweeView(Context r5) {
        super(r5);
        this.mControllerBuilder = new AnonymousClass1(this);
        a(r5, null);
    }

    public SimpleDraweeView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mControllerBuilder = new AnonymousClass1(this);
        a(r5, r10);
    }

    public void setImageURI(Uri r5, String r10, BlurHashConfig r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L8:
        setImageURI(r5, null, false);
        return;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        FLog.a("SimpleDraweeView", "setBlurHashImage, blurHash is null!");
        goto L8
    L7:
        new BlurDecodeProducer(r10, r11, new AnonymousClass3(this));
        goto L8
    }

    public SimpleDraweeView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mControllerBuilder = new AnonymousClass1(this);
        a(r5, r10);
    }

    @TargetApi(21)
    public SimpleDraweeView(Context r5, AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11, 0);
        this.mControllerBuilder = new AnonymousClass1(this);
        a(r5, r10);
    }

    public void setImageURI(Uri r5, Object r10, boolean r11) {
        if (sEnableLazySize == false) goto L7;
        if (r5 == null) goto L7;
        AbstractDraweeControllerBuilder r12 = (AbstractDraweeControllerBuilder) this.mControllerBuilder.a();
        r12.f7796b = r10;
        r12.f7798h = getController();
        setLazySizeAttach(new LazySizeAttach(ImageRequestBuilder.a(r5), r12, this));
        return;
    L7:
        AbstractDraweeControllerBuilder r13 = (AbstractDraweeControllerBuilder) this.mControllerBuilder.a();
        r13.f7796b = r10;
        PipelineDraweeControllerBuilder r14 = (PipelineDraweeControllerBuilder) r13;
        if (r5 != null) goto L10;
        r14.f7797c = null;
    L11:
        r14.f7798h = getController();
        setController(r14.a());
        return;
    L10:
        ImageRequestBuilder r15 = ImageRequestBuilder.a(r5);
        r15.d = RotationOptions.d;
        r14.f7797c = r15.a();
        goto L11
    }

    public boolean isSameImageRequest(Uri r5) {
        ImageRequestBuilder r10 = ImageRequestBuilder.a(r5);
        r10.d = RotationOptions.d;
        return isSameImageRequest(r10.a());
    }

    public void setImageURI(Uri r5, Object r10) {
        if (sEnableLazySize == false) goto L7;
        if (r5 == null) goto L7;
        AbstractDraweeControllerBuilder r11 = (AbstractDraweeControllerBuilder) this.mControllerBuilder.a();
        r11.f7796b = r10;
        r11.f7798h = getController();
        setLazySizeAttach(new LazySizeAttach(ImageRequestBuilder.a(r5), r11, this));
        return;
    L7:
        AbstractDraweeControllerBuilder r12 = (AbstractDraweeControllerBuilder) this.mControllerBuilder.a();
        r12.f7796b = r10;
        PipelineDraweeControllerBuilder r13 = (PipelineDraweeControllerBuilder) r12;
        if (r5 != null) goto L10;
        r13.f7797c = null;
    L11:
        r13.f7798h = getController();
        setController(r13.a());
        return;
    L10:
        ImageRequestBuilder r14 = ImageRequestBuilder.a(r5);
        r14.d = RotationOptions.d;
        r13.f7797c = r14.a();
        goto L11
    }

    public void setImageURI(String r5, Object r10) {
        if (r5 == null) goto L4;
        Uri r11 = Uri.parse(r5);
    L5:
        setImageURI(r11, r10);
        return;
    L4:
        r11 = null;
        goto L5
    }
}
