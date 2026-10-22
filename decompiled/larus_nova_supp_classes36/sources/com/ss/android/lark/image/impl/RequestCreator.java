package com.ss.android.lark.image.impl;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.transform.CropTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import me.ele.lancet.base.annotations.Skip;
import rkb.c;
import rkb.g;
import xkb.a;
import xkb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class RequestCreator implements IRequestCreator {
    private boolean asBitmap;
    private boolean asDrawable;
    private boolean asFile;
    private boolean asGif;
    private boolean centerCrop;
    private DecodeFormat decodeFormat;
    private Drawable errorDrawable;
    private int errorResId;
    private ImageView.ScaleType errorScaleType;
    private boolean fitCenter;
    private a mBitmapTransformation;
    private b mBlurTransformation;
    protected Context mContext;
    private DiskCacheStrategy mDiskCacheStrategy;
    private boolean mDontAnimate;
    protected Fragment mFragment;
    private int mGifFileSize;
    private int mGifMaxHeight;
    private int mGifMaxWidth;
    protected c mImageLoader;
    private ImageView mImageView;
    private boolean mIsAsync;
    private Object mLoadModel;
    private boolean mOnlyRetrieveFromCache;
    private Key mSignature;
    private boolean mSkipMemoryCache;
    private GlideExecutor mSourceExecutor;
    protected androidx.fragment.app.Fragment mSupportFragment;
    private Target mTarget;
    private List<Transformation<Bitmap>> mTransformationList;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private int targetHeight;
    private int targetWidth;
    private float thumbnail;
    private IRequestCreator thumbnailRequest;
    private WrapperRequestListener wrapperListener;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.RequestCreator$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ RequestCreator this$0;
        final /* synthetic */ ImageView val$target;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_android_lark_image_impl_RequestCreator$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_android_lark_image_impl_RequestCreator$1__run$___twin___() {
            SimpleTarget<Drawable> r0 = new C00951(this);
            r0.setOriginRequest(ImageLoader.getRequest(this.val$target));
            RequestCreator r1 = this.this$0;
            r1.mImageLoader.into(r0, r1);
            ImageLoader.setRequest(this.val$target, r0.getOriginRequest());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_android_lark_image_impl_RequestCreator$1_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass1 r1) {
            r1.com_ss_android_lark_image_impl_RequestCreator$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public AnonymousClass1(RequestCreator r1, ImageView r2) {
            this.this$0 = r1;
            this.val$target = r2;
        }
    }

    public class WrapperRequestListener implements g {
        private volatile g listener;
        final /* synthetic */ RequestCreator this$0;

        private WrapperRequestListener(RequestCreator r1) {
            this.this$0 = r1;
        }

        private void setRequestListener(g r1) {
            this.listener = r1;
        }

        public /* synthetic */ WrapperRequestListener(RequestCreator r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static /* synthetic */ void access$100(WrapperRequestListener r0, g r1) {
            r0.setRequestListener(r1);
        }

        @Override // rkb.g
        public boolean onLoadFailed(Exception r3, Object r4, Target r5, boolean r6) {
            ImageView r0 = this.this$0.getImageView();
            if (r0 != null) goto L14;
        L8:
            g r1 = this.listener;
            if (r1 != null) goto L11;
            return false;
        L11:
            return r1.onLoadFailed(r3, r4, r5, r6);
        L14:
            r0.setScaleType(RequestCreator.access$200(this.this$0));     // Catch: Exception -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }

        @Override // rkb.g
        public boolean onResourceReady(Object r7, Object r8, Target r9, DataSource r10, boolean r11) {
            g r0 = this.listener;
            if (r0 != null) goto L5;
            return false;
        L5:
            return r0.onResourceReady(r7, r8, r9, r10, r11);
        }
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator asBitmap() {
        this.asBitmap = true;
        this.asFile = false;
        this.asDrawable = false;
        this.asGif = false;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator asDrawable() {
        this.asDrawable = true;
        this.asGif = false;
        this.asFile = false;
        this.asBitmap = false;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator asFile() {
        this.asFile = true;
        this.asBitmap = false;
        this.asDrawable = false;
        this.asGif = false;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator asGif() {
        this.asGif = true;
        this.asFile = false;
        this.asBitmap = false;
        this.asDrawable = false;
        return this;
    }

    public CropTransformation getCropTransformation() {
        return null;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator transform(CropTransformation r1) {
        return this;
    }

    private void init() {
        this.wrapperListener = new WrapperRequestListener(this, null);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public void pauseRequests() {
        this.mImageLoader.pauseRequests(this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public void resumeRequests() {
        this.mImageLoader.resumeRequests(this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator centerCrop() {
        return centerCrop();
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator fitCenter() {
        return fitCenter();
    }

    public a getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    public b getBlurTransformation() {
        return this.mBlurTransformation;
    }

    public Context getContext() {
        return this.mContext;
    }

    public DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.mDiskCacheStrategy;
    }

    public Drawable getErrorDrawable() {
        return this.errorDrawable;
    }

    public int getErrorResId() {
        return this.errorResId;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public int getGifFileSize() {
        return this.mGifFileSize;
    }

    public int getGifMaxHeight() {
        return this.mGifMaxHeight;
    }

    public int getGifMaxWidth() {
        return this.mGifMaxWidth;
    }

    public ImageView getImageView() {
        return this.mImageView;
    }

    public Object getLoadModel() {
        return this.mLoadModel;
    }

    public Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public int getPlaceholderResId() {
        return this.placeholderResId;
    }

    public g getRequestListener() {
        return this.wrapperListener;
    }

    public Key getSignature() {
        return this.mSignature;
    }

    public GlideExecutor getSourceExecutor() {
        return this.mSourceExecutor;
    }

    public androidx.fragment.app.Fragment getSupportFragment() {
        return this.mSupportFragment;
    }

    public int getTargetHeight() {
        return this.targetHeight;
    }

    public int getTargetWidth() {
        return this.targetWidth;
    }

    public float getThumbnail() {
        return this.thumbnail;
    }

    public IRequestCreator getThumbnailRequest() {
        return this.thumbnailRequest;
    }

    public List<Transformation<Bitmap>> getTransformationList() {
        return this.mTransformationList;
    }

    public boolean isAsBitmap() {
        return this.asBitmap;
    }

    public boolean isAsFile() {
        return this.asFile;
    }

    public boolean isAsGif() {
        return this.asGif;
    }

    public boolean isCenterCrop() {
        return this.centerCrop;
    }

    public boolean isDontAnimate() {
        return this.mDontAnimate;
    }

    public boolean isFitCenter() {
        return this.fitCenter;
    }

    public boolean isOnlyRetrieveFromCache() {
        return this.mOnlyRetrieveFromCache;
    }

    public boolean isSkipMemoryCache() {
        return this.mSkipMemoryCache;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator asBitmap() {
        return asBitmap();
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator centerCrop() {
        this.centerCrop = true;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator fitCenter() {
        this.fitCenter = true;
        return this;
    }

    public static /* synthetic */ ImageView.ScaleType access$200(RequestCreator r0) {
        return r0.errorScaleType;
    }

    public static /* synthetic */ ImageView access$300(RequestCreator r0) {
        return r0.mImageView;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator decodeFormat(DecodeFormat r1) {
        return decodeFormat(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator diskCacheStrategy(DiskCacheStrategy r1) {
        return diskCacheStrategy(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator dontAnimate(boolean r1) {
        this.mDontAnimate = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public <R> void downloadOnly(Target<R> r2) {
        this.mTarget = r2;
        this.mImageLoader.downloadOnly(r2, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator error(int r1) {
        return error(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator gifFileSize(int r1) {
        this.mGifFileSize = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator gifMaxHeight(int r1) {
        this.mGifMaxHeight = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator gifMaxWidth(int r1) {
        this.mGifMaxWidth = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public void into(ImageView r3) {
        this.mImageView = r3;
        if (this.mIsAsync == false) goto L5;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AnonymousClass1(this, r3));
        return;
    L5:
        this.mImageLoader.into(r3, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator isAsync(boolean r1) {
        this.mIsAsync = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator listener(g r2) {
        WrapperRequestListener.access$100(this.wrapperListener, r2);
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator load(Object r1) {
        return load(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator onlyRetrieveFromCache(boolean r1) {
        this.mOnlyRetrieveFromCache = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator placeholder(int r1) {
        return placeholder(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator setErrorScaleType(ImageView.ScaleType r1) {
        this.errorScaleType = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator signature(Key r1) {
        this.mSignature = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator skipMemoryCache(boolean r1) {
        this.mSkipMemoryCache = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator sourceExecutor(GlideExecutor r1) {
        this.mSourceExecutor = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator thumbnail(float r1) {
        return thumbnail(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator transform(Transformation<Bitmap> r2) {
        this.mTransformationList.add(r2);
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public IRequestCreator transforms(List<Transformation<Bitmap>> r2) {
        if (CollectionUtils.isNotEmpty(r2) == false) goto L5;
        this.mTransformationList.addAll(r2);
    L5:
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator decodeFormat(DecodeFormat r1) {
        this.decodeFormat = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator diskCacheStrategy(DiskCacheStrategy r1) {
        this.mDiskCacheStrategy = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator error(Drawable r1) {
        return error(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public <R> void into(Target<R> r2) {
        this.mTarget = r2;
        this.mImageLoader.into(r2, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator listener(g r1) {
        return listener(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator load(Object r1) {
        this.mLoadModel = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator placeholder(Drawable r1) {
        return placeholder(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator thumbnail(IRequestCreator r1) {
        return thumbnail(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator transform(CropTransformation r1) {
        return transform(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator error(int r1) {
        this.errorResId = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator placeholder(int r1) {
        this.placeholderResId = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator thumbnail(float r1) {
        this.thumbnail = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator transform(a r1) {
        return transform(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator error(Drawable r1) {
        this.errorDrawable = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator placeholder(Drawable r1) {
        this.placeholderDrawable = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator thumbnail(IRequestCreator r1) {
        this.thumbnailRequest = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator transform(b r1) {
        return transform(r1);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator transform(a r1) {
        this.mBitmapTransformation = r1;
        return this;
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator transform(b r1) {
        this.mBlurTransformation = r1;
        return this;
    }

    public RequestCreator(c r2, Fragment r3) {
        this.targetWidth = -1;
        this.targetHeight = -1;
        this.placeholderResId = -1;
        this.errorResId = -1;
        this.errorScaleType = ImageView.ScaleType.CENTER;
        this.thumbnail = -1.0f;
        this.mDontAnimate = true;
        this.mSkipMemoryCache = false;
        this.mIsAsync = false;
        this.mTransformationList = new ArrayList();
        this.mSourceExecutor = null;
        this.decodeFormat = DecodeFormat.DEFAULT;
        this.mImageLoader = r2;
        this.mFragment = r3;
        init();
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public File downloadOnly(int r2, int r3) throws InterruptedException, ExecutionException {
        return this.mImageLoader.downloadOnly(r2, r3, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public Bitmap getBitmap(int r2, int r3) throws InterruptedException, ExecutionException {
        return this.mImageLoader.getBitmap(r2, r3, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public String getCacheFile(int r2, int r3) {
        return this.mImageLoader.getCacheFile(r2, r3, this);
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public /* bridge */ /* synthetic */ IRequestCreator override(int r1, int r2) {
        return override(r1, r2);
    }

    public RequestCreator(c r2, Context r3) {
        this.targetWidth = -1;
        this.targetHeight = -1;
        this.placeholderResId = -1;
        this.errorResId = -1;
        this.errorScaleType = ImageView.ScaleType.CENTER;
        this.thumbnail = -1.0f;
        this.mDontAnimate = true;
        this.mSkipMemoryCache = false;
        this.mIsAsync = false;
        this.mTransformationList = new ArrayList();
        this.mSourceExecutor = null;
        this.decodeFormat = DecodeFormat.DEFAULT;
        this.mImageLoader = r2;
        this.mContext = r3;
        init();
    }

    @Override // com.ss.android.lark.image.api.IRequestCreator
    public RequestCreator override(int r1, int r2) {
        this.targetWidth = r1;
        this.targetHeight = r2;
        return this;
    }

    public RequestCreator(c r2, androidx.fragment.app.Fragment r3) {
        this.targetWidth = -1;
        this.targetHeight = -1;
        this.placeholderResId = -1;
        this.errorResId = -1;
        this.errorScaleType = ImageView.ScaleType.CENTER;
        this.thumbnail = -1.0f;
        this.mDontAnimate = true;
        this.mSkipMemoryCache = false;
        this.mIsAsync = false;
        this.mTransformationList = new ArrayList();
        this.mSourceExecutor = null;
        this.decodeFormat = DecodeFormat.DEFAULT;
        this.mImageLoader = r2;
        this.mSupportFragment = r3;
        init();
    }
}
