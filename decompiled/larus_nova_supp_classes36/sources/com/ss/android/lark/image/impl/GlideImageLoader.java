package com.ss.android.lark.image.impl;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.SourceExecutorOptions;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.transform.CropTransformation;
import com.ss.android.lark.image.utils.ImageFGUtils;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import jp.wasabeef.glide.transformations.BlurTransformation;
import rkb.b;
import rkb.c;
import rkb.f;
import rkb.g;
import ukb.d;
import ukb.e;
import xkb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class GlideImageLoader implements c {

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.GlideImageLoader$10, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$lark$image$api$DiskCacheStrategy = null;
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$lark$image$transform$CropTransformation$CropType = null;

        static {
            int[] r0 = new int[CropTransformation.CropType.values().length];
            $SwitchMap$com$ss$android$lark$image$transform$CropTransformation$CropType = r0;
            r0[CropTransformation.CropType.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$ss$android$lark$image$transform$CropTransformation$CropType[CropTransformation.CropType.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            $SwitchMap$com$ss$android$lark$image$transform$CropTransformation$CropType[CropTransformation.CropType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r3 = new int[DiskCacheStrategy.values().length];
            $SwitchMap$com$ss$android$lark$image$api$DiskCacheStrategy = r3;
            r3[DiskCacheStrategy.SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$com$ss$android$lark$image$api$DiskCacheStrategy[DiskCacheStrategy.RESULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            $SwitchMap$com$ss$android$lark$image$api$DiskCacheStrategy[DiskCacheStrategy.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            $SwitchMap$com$ss$android$lark$image$api$DiskCacheStrategy[DiskCacheStrategy.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public GlideImageLoader() {
    }

    public static /* synthetic */ f access$000(Request r0) {
        return getImageRequest(r0);
    }

    public static /* synthetic */ Request access$100(f r0) {
        return getGlideRequest(r0);
    }

    public static /* synthetic */ Target access$200(com.bumptech.glide.request.target.Target r0) {
        return getTarget(r0);
    }

    private boolean checkContextValidation(Context r3) {
        if ((r3 instanceof Activity) == false) goto L12;
        Activity r4 = (Activity) r3;
        if (r4.isDestroyed() == false) goto L7;
    L9:
        return false;
    L7:
        if (r4.isFinishing() == true) goto L9;
        return true;
    L12:
        if ((r3 instanceof ContextWrapper) == false) goto L17;
        ContextWrapper r5 = (ContextWrapper) r3;
        if (r5.getBaseContext().getApplicationContext() == null) goto L17;
        Log.d("GlideImageLoader", "context is ContextWrapper, base context is:" + r5.getBaseContext());
        return checkContextValidation(r5.getBaseContext());
    L17:
        return true;
    }

    private boolean checkFragmentValidation(Fragment r2) {
        Activity r3 = r2.getActivity();
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (r3.isDestroyed() == true) goto L9;
        if (r3.isFinishing() == true) goto L9;
        return true;
    }

    private boolean checkSupportFragmentValidation(androidx.fragment.app.Fragment r2) {
        FragmentActivity r3 = r2.getActivity();
        if (r3 != null) goto L5;
    L9:
        return false;
    L5:
        if (r3.isDestroyed() == true) goto L9;
        if (r3.isFinishing() == true) goto L9;
        return true;
    }

    private static Request getGlideRequest(final f r1) {
        return new AnonymousClass3(r1);
    }

    private static f getImageRequest(final Request r1) {
        return new AnonymousClass2(r1);
    }

    private RequestBuilder getRequest(RequestCreator r3) {
        RequestBuilder r0 = getTypeRequestBuilder(r3);
        if (r0 != null) goto L6;
        Log.e("GlideImageLoader", "getRequest is null, model is:" + r3.getLoadModel());
        return null;
    L6:
        bindRequestThumbnail(r3, r0);
        bindRequestListener(r3, r0);
        bindRequestOptions(r3, r0);
        bindRequestTransformation(r3, r0);
        r0.load(r3.getLoadModel());
        return r0;
    }

    private RequestManager getRequestManager(RequestCreator r5) {
        Context r0 = r5.getContext();
        androidx.fragment.app.Fragment r1 = r5.getSupportFragment();
        Fragment r6 = r5.getFragment();
        if (r0 != null) goto L5;
        if (r1 != null) goto L10;
        if (r6 != null) goto L18;
        Log.e("GlideImageLoader", "context && fragment is null, request manager is null");
        return null;
    L18:
        if (checkFragmentValidation(r6) == true) goto L28;
        Log.e("GlideImageLoader", "fragment context invalidate, request manager is null");
        return null;
    L28:
        return Glide.with(r6);
    L10:
        if (checkSupportFragmentValidation(r1) == false) goto L15;
        FragmentActivity r7 = r1.getActivity();
        if (r7 != null) goto L25;
        Log.e("GlideImageLoader", "fragment activity is null, request manager is null");
        return null;
    L25:
        return Glide.with(r7);
    L15:
        Log.e("GlideImageLoader", "support fragment context invalidate, request manager is null");
        return null;
    L5:
        if (checkContextValidation(r0) == true) goto L23;
        Log.e("GlideImageLoader", "check context invalidate, request manager is null");
        return null;
    L23:
        return Glide.with(r0);
    }

    private RequestOptions getRequestOptions(RequestCreator r6) {
        RequestOptions r0 = new RequestOptions();
        if (r6.getTargetWidth() < 0) goto L7;
        if (r6.getTargetHeight() < 0) goto L7;
    L10:
        r0.override(r6.getTargetWidth(), r6.getTargetHeight());
    L12:
        if (r6.isCenterCrop() == false) goto L15;
        r0.centerCrop();
    L15:
        if (r6.isFitCenter() == false) goto L17;
        r0.fitCenter();
    L17:
        Drawable r1 = r6.getPlaceholderDrawable();
        if (r1 == null) goto L20;
        r0.placeholder(r1);
    L20:
        int r2 = r6.getPlaceholderResId();
        if (r2 < 0) goto L23;
        r0.placeholder(r2);
    L23:
        Drawable r3 = r6.getErrorDrawable();
        if (r3 == null) goto L26;
        r0.error(r3);
    L26:
        int r4 = r6.getErrorResId();
        if (r4 < 0) goto L30;
        r0.error(r4);
    L30:
        if (r6.isDontAnimate() == false) goto L32;
        r0.dontAnimate();
    L32:
        r0.skipMemoryCache(r6.isSkipMemoryCache());
        r0.frame(0);
        if (r6.isOnlyRetrieveFromCache() == false) goto L36;
        r0 = r0.onlyRetrieveFromCache(true);
    L36:
        if (r6.getSignature() == null) goto L38;
        r0.signature(r6.getSignature());
    L38:
        r0.format(r6.getDecodeFormat());
        DiskCacheStrategy r5 = r6.getDiskCacheStrategy();
        if (r5 == null) goto L54;
        com.bumptech.glide.load.engine.DiskCacheStrategy r7 = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL;
        int r8 = AnonymousClass10.$SwitchMap$com$ss$android$lark$image$api$DiskCacheStrategy[r5.ordinal()];
        if (r8 != 1) goto L43;
        r7 = com.bumptech.glide.load.engine.DiskCacheStrategy.DATA;
    L52:
        r0.diskCacheStrategy(r7);
        goto L54
    L43:
        if (r8 != 2) goto L45;
        r7 = com.bumptech.glide.load.engine.DiskCacheStrategy.RESOURCE;
        goto L52
    L45:
        if (r8 == 3) goto L52;
        if (r8 != 4) goto L52;
        r7 = com.bumptech.glide.load.engine.DiskCacheStrategy.NONE;
    L54:
        if (r6.getGifFileSize() > 0) goto L56;
    L60:
        GlideExecutor r9 = r6.getSourceExecutor();
        if (r9 != null) goto L63;
        r9 = ImageLoader.getDependency().getCustomSourceExecutor(r6.getLoadModel());
    L63:
        if (r9 == null) goto L65;
        r0.set(SourceExecutorOptions.SOURCE_EXECUTOR, r9);
    L65:
        return r0;
    L56:
        if (r6.getGifMaxWidth() <= 0) goto L60;
        if (r6.getGifMaxHeight() <= 0) goto L60;
        r0.gifLimit(r6.getGifMaxWidth(), r6.getGifMaxHeight(), r6.getGifFileSize());
    L7:
        if (r6.getTargetWidth() != Integer.MIN_VALUE) goto L12;
        if (r6.getTargetHeight() != Integer.MIN_VALUE) goto L12;
        goto L10
    }

    private static Target getTarget(final com.bumptech.glide.request.target.Target r1) {
        return new AnonymousClass1(r1);
    }

    private RequestBuilder getTypeRequestBuilder(RequestCreator r3) {
        RequestManager r0 = getRequestManager(r3);
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r3.isAsBitmap() == false) goto L11;
        return r0.asBitmap();
    L11:
        if (r3.isAsFile() == false) goto L15;
        return r0.asFile();
    L15:
        if (r3.isAsGif() == false) goto L19;
        return r0.asGif();
    L19:
        return r0.asDrawable();
    }

    @Override // rkb.c
    public void clear(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Context r0 = r3.getContext();
        if ((r0 instanceof Activity) == true) goto L7;
    L9:
        Glide.with(r3).clear(r3);
        return;
    L7:
        if (((Activity) r0).isDestroyed() == false) goto L9;
    }

    @Override // rkb.c
    public void clearMemoryCache(Context r1) {
        Glide.get(r1).clearMemory();
    }

    @Override // rkb.c
    public void pauseRequests(RequestCreator r1) {
        RequestManager r2 = getRequestManager(r1);
        if (r2 == null) goto L6;
        r2.pauseRequests();
        return;
    }

    @Override // rkb.c
    public void resumeRequests(RequestCreator r1) {
        RequestManager r2 = getRequestManager(r1);
        if (r2 == null) goto L6;
        r2.resumeRequests();
        return;
    }

    private void bindRequestListener(RequestCreator r2, RequestBuilder r3) {
        final g r4 = r2.getRequestListener();
        if (r4 == null) goto L6;
        r3.listener(new AnonymousClass9(this, r4));
        return;
    }

    private void bindRequestOptions(RequestCreator r1, RequestBuilder r2) {
        r2.apply(getRequestOptions(r1));
    }

    private void bindRequestThumbnail(RequestCreator r2, RequestBuilder r3) {
        r2.getThumbnail();
        if (r2.getThumbnailRequest() == null) goto L6;
        r3.thumbnail(getRequest((RequestCreator) r2.getThumbnailRequest()));
        return;
    }

    private void bindRequestTransformation(RequestCreator r6, RequestBuilder r7) {
        ArrayList r0 = new ArrayList();
        r6.getCropTransformation();
        if (r6.getBlurTransformation() == null) goto L5;
        r0.add(new BlurTransformation(40, 1, ((Boolean) ImageFGUtils.c.getValue()).booleanValue()));
    L5:
        final a r1 = r6.getBitmapTransformation();
        if (r1 == null) goto L8;
        r0.add(new AnonymousClass8(this, r1));
    L8:
        Iterator<Transformation<Bitmap>> r8 = r6.getTransformationList().iterator();
    L10:
        if (r8.hasNext() == false) goto L13;
        r0.add(r8.next());
        goto L10
    L13:
        if (r0.isEmpty() == true) goto L17;
        r7.transform(new MultiTransformation(r0));
        return;
    }

    @Override // rkb.c
    public void downloadOnly(final Target r2, RequestCreator r3) {
        r3.asFile();
        RequestBuilder r4 = getRequest(r3);
        SimpleTarget r0 = new AnonymousClass7(this, r2);
        if (r4 == null) goto L6;
        r4.downloadOnly(r0);
        return;
    }

    @Override // rkb.c
    public void into(final Target r4, RequestCreator r5) {
        e.a(r5.getContext());
        Context r0 = r5.getContext();
        if (e.b == true) goto L7;
        Glide r1 = Glide.get(r0);
        d r2 = new d();
        r1.getRegistry().prepend(GifDrawable.class, r2);
        e.b = true;
    L7:
        if (r5.getFragment() == null) goto L13;
        if (r5.getFragment().getActivity() != null) goto L13;
        Log.e("GlideImageLoader", "getFragment activity is null");
        return;
    L13:
        if (r5.getSupportFragment() != null) goto L15;
    L18:
        RequestBuilder r6 = getRequest(r5);
        if (r6 != null) goto L23;
        Log.e("GlideImageLoader", "async into , request is null, return");
        return;
    L23:
        if ((r4 instanceof b) == false) goto L26;
        final b r7 = (b) r4;
        final ImageView r3 = r7.a;
        r6.into(new AnonymousClass5(this, r3, r7));
        return;
    L26:
        SimpleTarget r8 = new AnonymousClass6(this, r4);
        r8.setRequest(r4.getOriginRequest());
        r6.into(r8);
        r4.setOriginRequest(r8.getRequest());
        return;
    L15:
        if (r5.getSupportFragment().getActivity() != null) goto L18;
        Log.e("GlideImageLoader", "getSupportFragment activity is null");
    }

    @Override // rkb.c
    public void into(ImageView r4, RequestCreator r5) {
        e.a(r4.getContext());
        Context r0 = r4.getContext();
        if (e.b == true) goto L6;
        Glide r1 = Glide.get(r0);
        d r2 = new d();
        r1.getRegistry().prepend(GifDrawable.class, r2);
        e.b = true;
    L6:
        RequestBuilder r3 = getRequest(r5);
        if (r3 == null) goto L9;
        r3.into(r4);
        return;
    L9:
        StringBuilder r6 = new StringBuilder("requestBuilder is null, return, request model is:");
        if (r5 != null) goto L12;
        Object r7 = "null";
    L13:
        r6.append(r7);
        Log.e("GlideImageLoader", r6.toString());
        return;
    L12:
        r7 = r5.getLoadModel();
        goto L13
    }

    @Override // rkb.c
    public File downloadOnly(int r4, int r5, RequestCreator r6) {
        RequestBuilder r7 = getRequest(r6);     // Catch: ExecutionException -> L8 InterruptedException -> L9
        if (r7 == null) goto L7;
        return (File) r7.downloadOnly(r4, r5).get();
    L7:
        return null;
    L9:
        Log.e("GlideImageLoader", "download image failed, ");
    L10:
        return null;
    L8:
        Log.e("GlideImageLoader", "download image failed, ");
        goto L10
    }

    @Override // rkb.c
    public Bitmap getBitmap(int r4, int r5, RequestCreator r6) {
        r6.asBitmap();     // Catch: ExecutionException -> L10 InterruptedException -> L12
        RequestBuilder r7 = getRequest(r6);     // Catch: ExecutionException -> L10 InterruptedException -> L12
        if (r7 == null) goto L9;
        Object r8 = r7.submit(r4, r5).get();     // Catch: ExecutionException -> L10 InterruptedException -> L12
        if ((r8 instanceof Bitmap) == false) goto L9;
        return (Bitmap) r8;
    L9:
        return null;
    L12:
        e = move-exception;
        Log.d("GlideImageLoader", "getBitmap failed", e);
    L14:
        return null;
    L10:
        e = move-exception;
        Log.d("GlideImageLoader", "getBitmap failed", e);
        goto L14
    }

    @Override // rkb.c
    public String getCacheFile(int r7, int r8, RequestCreator r9) {
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L15
        r9.diskCacheStrategy(DiskCacheStrategy.ALL).onlyRetrieveFromCache(true);     // Catch: Exception -> L15
        Object r4 = r9.getLoadModel();     // Catch: Exception -> L15
        RequestBuilder r10 = getTypeRequestBuilder(r9);     // Catch: Exception -> L15
        if (r4 == null) goto L17;
        if (r10 == null) goto L17;
        RequestFutureTarget r11 = r10.load(r4).downloadOnly(r7, r7);     // Catch: Exception -> L15
        r11.setAssertBackgroundThread(false);     // Catch: Exception -> L15
        File r12 = (File) r11.get();     // Catch: Exception -> L15
        if (r12 != null) goto L9;
    L13:
        Log.i("GlideImageLoader", "getCacheFile is null");     // Catch: Exception -> L15
        return null;
    L9:
        if (r12.exists() == false) goto L13;
        String r13 = r12.getPath();     // Catch: Exception -> L15
        Log.i("GlideImageLoader", "getCacheFile:" + r13 + ", costTime:" + (System.currentTimeMillis() - r2));     // Catch: Exception -> L15
        return r13;
    L17:
        return null;
    L15:
        e = move-exception;
        Log.e("GlideImageLoader", "getCacheFile failed:" + e.getMessage());
        goto L17
    }

    @Override // rkb.c
    public <T extends Key, Y> void registerLoadModelHook(Context r2, Class<T> r3, Class<Y> r4, final rkb.e<T, Y> r5) {
        Glide.get(r2).getRegistry().replace(r3, r4, new AnonymousClass4(this, r5));
    }
}
