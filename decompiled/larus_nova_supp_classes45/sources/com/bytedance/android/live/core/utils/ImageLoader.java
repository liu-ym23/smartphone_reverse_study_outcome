package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ImageLoader {
    public static final int FADE_DURATION = 300;
    private static final Handler HANDLER_MAIN = null;
    private static final String TAG = "ImageLoader";

    public class a implements p0 {
        public final /* synthetic */ p0 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ SimpleDraweeView c;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r1) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void e(py.k r5) {
            om0.c.c().i(ImageLoader.TAG, "[loadAntiFlink] load image stated " + r5.getUri() + " time " + System.currentTimeMillis());
            p0 r0 = this.a;
            if (r0 == null) goto L6;
            r0.e(r5);
            return;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(py.k r3, Exception r4) {
            ALogger.i(ImageLoader.TAG, "[loadAntiFlink] load image fail " + r3.getUri() + " Exception info" + r4.getMessage());
            p0 r0 = this.a;
            if (r0 == null) goto L6;
            r0.b(r3, r4);
            return;
        }

        public a(p0 r1, boolean r2, SimpleDraweeView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(py.k r6, int r7, int r8, boolean r9) {
            long r0 = System.currentTimeMillis();
            if (this.b == false) goto L5;
            this.c.setTag(2131389794, new Pair(r6, Long.valueOf(r0)));
        L5:
            ALogger.i(ImageLoader.TAG, "[loadAntiFlink] load image success " + r6.getUri() + " time " + r0);
            p0 r1 = this.a;
            if (r1 == null) goto L9;
            r1.c(r6, r7, r8, r9);
            return;
        }
    }

    public class b implements DataSubscriber<CloseableReference<PooledByteBuffer>> {
        public final /* synthetic */ PipedOutputStream a;

        public final void onProgressUpdate(DataSource<CloseableReference<PooledByteBuffer>> r1) {
        }

        public b(PipedOutputStream r1) {
            this.a = r1;
        }

        public final void onCancellation(DataSource<CloseableReference<PooledByteBuffer>> r2) {
            this.a.close();     // Catch: Throwable -> L4 IOException -> L9
        L4:
            th = move-exception;
            r2.close();
            throw th;
        L7:
            r2.close();
        }

        public final void onFailure(DataSource<CloseableReference<PooledByteBuffer>> r2) {
            this.a.close();     // Catch: Throwable -> L4 IOException -> L9
        L4:
            th = move-exception;
            r2.close();
            throw th;
        L7:
            r2.close();
        }

        public final void onNewResult(DataSource<CloseableReference<PooledByteBuffer>> r5) {
            CloseableReference r0 = (CloseableReference) r5.getResult();
            if (r0 == null) goto L15;
            PooledByteBuffer r1 = (PooledByteBuffer) r0.get();
            byte[] r2 = new byte[r1.size()];
            r1.read(0, r2, 0, r1.size());
            this.a.write(r2);     // Catch: Throwable -> L7 IOException -> L12
            this.a.close();     // Catch: Throwable -> L7 IOException -> L12
        L7:
            th = move-exception;
            r5.close();
            throw th;
        L10:
            r5.close();
            return;
        }
    }

    public class c extends BaseBitmapDataSubscriber {
        public final /* synthetic */ DataSource a;
        public final /* synthetic */ ImageUtil.LoadImageCallback b;

        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r2) {
            if (r2 == null) goto L4;
            r2.close();
        L4:
            final ImageUtil.LoadImageCallback r3 = this.b;
            if (r3 == null) goto L8;
            ImageLoader.access$000(new r0(r3));
            return;
        }

        public final void onNewResultImpl(Bitmap r3) {
            if (this.a.isFinished() == false) goto L6;
            if (r3 == null) goto L6;
            final Bitmap r4 = r3.copy(Bitmap.Config.ARGB_8888, true);
            final ImageUtil.LoadImageCallback r0 = this.b;
            ImageLoader.access$000(new s0(r0, r4));
        L9:
            this.a.close();
            return;
        L6:
            final ImageUtil.LoadImageCallback r5 = this.b;
            if (r5 == null) goto L9;
            ImageLoader.access$000(new t0(r5));
            goto L9
        }

        public c(DataSource r1, ImageUtil.LoadImageCallback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class d {
        public final py.k a;
        public int b;
        public int c;
        public Postprocessor d;
        public p0 e;
        public boolean f;
        public boolean g;

        public d(py.k r2) {
            this.b = -1;
            this.c = -1;
            this.d = null;
            this.e = null;
            this.f = false;
            this.g = true;
            this.a = r2;
        }

        public final void a(HSImageView r12) {
            ImageLoader.bindImage(r12, this.a, null, 300, this.b, this.c, this.d, this.e, this.f, this.g, true);
        }
    }

    public static class e implements ControllerListener<ImageInfo> {
        public final py.k a;
        public final p0 b;
        public final boolean c;

        public final void onIntermediateImageFailed(String r1, Throwable r2) {
        }

        public final void onRelease(String r1) {
        }

        public final void onFailure(String r3, Throwable r4) {
            p0 r5 = this.b;
            if (r5 == null) goto L6;
            r5.b(this.a, new RuntimeException(r4));
            return;
        }

        public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r2) {
            ImageInfo r3 = (ImageInfo) r2;
        }

        public final void onSubmit(String r1, Object r2) {
            p0 r3 = this.b;
            if (r3 == null) goto L6;
            r3.e(this.a);
            return;
        }

        public e(py.k r1, p0 r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onFinalImageSet(String r8, Object r9, Animatable r11) {
            ImageInfo r12 = (ImageInfo) r9;
            v0 r13 = v0.e;
            py.k r0 = this.a;
            if (r13.d != null) goto L6;
            r13.d = j40.p.a.getValue();
        L6:
            if (r13.d == Boolean.TRUE) goto L26;
            if (r0 == null) goto L26;
            if (Lists.isEmpty(r0.getUrls()) == true) goto L26;
            Object r1 = r13.c;
            monitor-enter(r1);
            Iterator<String> r2 = r0.getUrls().iterator();     // Catch: Throwable -> L23
        L16:
            if (r2.hasNext() == false) goto L21;
            String r3 = r2.next();     // Catch: Throwable -> L23
            if (((LinkedList) r13.b).contains(r3) == false) goto L16;
            monitor-exit(r1);     // Catch: Throwable -> L23
            boolean r14 = true;
        L27:
            int r4 = -1;
            if (r12 == null) goto L30;
            int r5 = r12.getWidth();
        L31:
            if (r12 == null) goto L34;
            r4 = r12.getHeight();
        L34:
            if ((r11 instanceof AnimatedDrawable2) == true) goto L36;
        L38:
            py.k r6 = this.a;
            if (r6 == null) goto L52;
            final v0 r7 = v0.e;
            Boolean r15 = r7.d;
            if (r15 != null) goto L43;
        L45:
            final List<String> r16 = r6.getUrls();
            if (r16 != null) goto L48;
        L51:
            this.a.setLoaded(true);
            goto L52
        L48:
            if (r16.isEmpty() == true) goto L51;
            r7.a.execute(new u0(r7, r16));
            goto L51
        L43:
            if (r15.booleanValue() == false) goto L45;
        L52:
            p0 r17 = this.b;
            if (r17 == null) goto L60;
            r17.d(r12);
            this.b.c(this.a, r5, r4, r14);
            this.b.a(r12, r11);
            return;
        L60:
            return;
        L36:
            if (this.c == false) goto L38;
            ((AnimatedDrawable2) r11).setPrivateFrameSchedulerFactory(new com.bytedance.android.live.j());
            goto L38
        L30:
            r5 = -1;
            goto L31
        L21:
            monitor-exit(r1);     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            throw th;
        L26:
            r14 = false;
            goto L27
        }
    }

    static {
        HANDLER_MAIN = new Handler(Looper.getMainLooper());
    }

    private ImageLoader() {
    }

    public static /* synthetic */ void access$000(Runnable r0) {
        runOnUiThread(r0);
    }

    public static InputStream getEncodedImageStream(Uri r4) {
        PipedOutputStream r0 = new PipedOutputStream();
        PipedInputStream r2 = new PipedInputStream(r0);     // Catch: IOException -> L6
        ImageRequest r5 = ImageRequestBuilder.newBuilderWithSource(r4).build();
        Fresco.getImagePipeline().fetchEncodedImage(r5, null).subscribe(new b(r0), AsyncTask.THREAD_POOL_EXECUTOR);
        return r2;
    L6:
        return null;
    }

    public static d load(String r1) {
        py.k r0 = (py.k) vh7.f.c(py.k.class);
        r0.setUri(r1);
        return load(r0);
    }

    private static void runOnUiThread(Runnable r1) {
        HANDLER_MAIN.post(r1);
    }

    private static Drawable toDrawable(int r1) {
        if (r1 > 0) goto L6;
        return null;
    L6:
        return s1.getContext().getResources().getDrawable(r1);
    }

    public static d load(py.k r1) {
        return new d(r1);
    }

    public static void bindDrawableResource(SimpleDraweeView r0, int r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.setImageURI(ImageRequestBuilder.newBuilderWithResourceId(r1).build().getSourceUri());
    }

    public static void bindGifImage(HSImageView r2, py.k r3) {
        if (r2 == null) goto L16;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getUrls() != null) goto L7;
        return;
    L7:
        if (r3.getUrls().size() == 0) goto L20;
        ImageRequest[] r4 = createImageRequests(r3, null, null);
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.length == 0) goto L21;
        r2.setController(Fresco.newDraweeControllerBuilder().setOldController(r2.getController()).setFirstAvailableImageRequests(r4).setAutoPlayAnimations(true).build());
        return;
    L21:
        return;
    L20:
        return;
    }

    public static void bindImage(HSImageView r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r1.setImageURI(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r2)).build().getSourceUri());
        return;
    }

    private static ImageRequest createImageRequestWithUri(Uri r0, ResizeOptions r1) {
        if (r0 != null) goto L5;
        return null;
    L5:
        ImageRequestBuilder r2 = ImageRequestBuilder.newBuilderWithSource(r0);
        if (r1 == null) goto L9;
        r2.setResizeOptions(r1);
    L9:
        return r2.build();
    }

    public static void downloadBitmap(Uri r2, BaseBitmapDataSubscriber r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        ImageRequest r4 = ImageRequestBuilder.newBuilderWithSource(r2).setProgressiveRenderingEnabled(true).build();
        DataSource r5 = Fresco.getImagePipeline().fetchDecodedImage(r4, null);
        if (r3 == null) goto L8;
        r5.subscribe(r3, CallerThreadExecutor.getInstance());
        return;
    }

    private static void loadBitmapSynchronized(ImageRequest[] r2, ImageUtil.LoadImageCallback r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.length == 0) goto L9;
        DataSource r4 = ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(r2[0], null);
        r4.subscribe(new c(r4, r3), CallerThreadExecutor.getInstance());
        return;
    }

    public static void loadSdcardImage(HSImageView r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (r3.startsWith("file://") == true) goto L10;
        r3 = "file://".concat(r3);
    L10:
        r2.setImageURI(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3)).build().getSourceUri());
    }

    public static void preload(Context r2, py.k r3) {
        if (r2 == null) goto L9;
        if (r3 != null) goto L5;
        return;
    L5:
        if (Lists.isEmpty(r3.getUrls()) == true) goto L11;
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequest.fromUri((String) ListProtector.get(r3.getUrls(), 0)), r2);
        return;
    L11:
        return;
    }

    public static void bindDrawableResource(HSImageView r0, int r1) {
        bindDrawableResource(r0, r1);
    }

    public static void bindImage(SimpleDraweeView r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r1.setImageURI(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r2)).build().getSourceUri());
        return;
    }

    public static void downloadBitmap(String r0, BaseBitmapDataSubscriber r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        downloadBitmap(UriProtector.parse(r0), r1);
    }

    public static void preload(Context r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequest.fromUri(r2), r1);
        return;
    }

    public static void bindImage(HSImageView r8, py.k r9) {
        bindImage(r8, r9, null, -1, -1, null, null, false);
    }

    public static void bindImage(SimpleDraweeView r8, py.k r9) {
        bindImage(r8, r9, null, -1, -1, null, null, false);
    }

    public static void bindGifImage(SimpleDraweeView r2, py.k r3, ControllerListener r4) {
        if (r2 == null) goto L14;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getUrls() != null) goto L7;
        return;
    L7:
        if (r3.getUrls().size() == 0) goto L17;
        ImageRequest[] r5 = createImageRequests(r3, null, null);
        if (r5.length != 0) goto L12;
        return;
    L12:
        r2.setController(Fresco.newDraweeControllerBuilder().setOldController(r2.getController()).setFirstAvailableImageRequests(r5).setControllerListener(r4).build());
        return;
    L17:
        return;
    }

    public static void bindImage(HSImageView r2, String r3, Postprocessor r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        if (r4 == null) goto L11;
        ImageRequest r5 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3)).setPostprocessor(r4).build();
        PipelineDraweeControllerBuilder r6 = Fresco.newDraweeControllerBuilder().setOldController(r2.getController()).setFirstAvailableImageRequests(new ImageRequest[]{r5});
        r2.setImageURI(r5.getSourceUri());
        r2.setController(r6.build());
        return;
    L11:
        return;
    }

    public static ImageRequest[] createImageRequests(py.k r1, int r2, int r3) {
        if (r1 != null) goto L6;
        return new ImageRequest[0];
    L6:
        return createImageRequests(r1, new ResizeOptions(r2, r3), null);
    }

    public static void bindImage(HSImageView r11, py.k r12, boolean r13) {
        bindImage(r11, r12, null, 300, -1, -1, null, null, false, false, r13);
    }

    public static ImageRequest[] createImageRequests(py.k r1, ResizeOptions r2, Postprocessor r3) {
        return createImageRequests(r1, r2, r3, false);
    }

    public static void bindImage(HSImageView r8, py.k r9, int r11) {
        bindImage(r8, r9, toDrawable(r11), -1, -1, null, null, false);
    }

    public static void bindImage(HSImageView r8, py.k r9, p0 r11) {
        bindImage(r8, r9, null, -1, -1, null, r11, false);
    }

    public static void bindImage(HSImageView r8, py.k r9, Postprocessor r11) {
        bindImage(r8, r9, null, -1, -1, r11, null, false);
    }

    public static void bindAvatar(HSImageView r8, py.k r9, int r11, int r12) {
        bindImage(r8, r9, null, r11, r12, null, null, false);
    }

    public static void bindDrawableResource(HSImageView r1, int r2, int r3, int r4) {
        if (r1 != null) goto L4;
        return;
    L4:
        ImageRequestBuilder r5 = ImageRequestBuilder.newBuilderWithResourceId(r2);
        if (r3 <= 0) goto L8;
        if (r4 <= 0) goto L8;
        r5.setResizeOptions(new ResizeOptions(r3, r4));
    L8:
        r1.setImageRequest(r5.build());
    }

    public static void bindImage(HSImageView r1, String r2, int r3, int r4) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        ImageRequestBuilder r5 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r2));
        if (r3 <= 0) goto L10;
        if (r4 <= 0) goto L10;
        r5.setResizeOptions(new ResizeOptions(r3, r4));
    L10:
        r1.setImageURI(r5.build().getSourceUri());
        return;
    }

    public static void bindImageWithAnimation(HSImageView r8, py.k r9, p0 r11, boolean r12) {
        bindImage(r8, r9, null, -1, -1, null, r11, r12);
    }

    private static ImageRequest[] createImageRequests(py.k r6, ResizeOptions r7, Postprocessor r8, boolean r9) {
        if (r6 == null) goto L32;
        if (r6.getUrls() == null) goto L32;
        if (r6.getUrls().size() == 0) goto L32;
        ArrayList r1 = new ArrayList();
        ImageNetworkRequestsMonitor r2 = new ImageNetworkRequestsMonitor();
        Iterator<String> r11 = r6.getUrls().iterator();
    L11:
        if (r11.hasNext() == false) goto L26;
        String r3 = r11.next();
        if (StringUtils.isEmpty(r3) == true) goto L11;
        ImageRequestBuilder r4 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3));
        if (r8 == null) goto L18;
        r4.setPostprocessor(r8);
    L18:
        if (r7 == null) goto L20;
        r4.setResizeOptions(r7);
    L20:
        r2.monitor(r4);
        if (LiveInfraSettingKeys.LIVE_BLUR_CACHE_KEY_OPT.getValue().booleanValue() == false) goto L24;
        if (r9 == false) goto L24;
        ImageDecodeOptionsBuilder r5 = new ImageDecodeOptionsBuilder();
        r5.setBitmapConfig(Bitmap.Config.RGB_565);
        r4.setImageDecodeOptions(r5.build());
    L24:
        r1.add(r4.build());
        goto L11
    L26:
        if (r1.size() != 0) goto L30;
        return new ImageRequest[0];
    L30:
        return (ImageRequest[]) r1.toArray(new ImageRequest[r1.size()]);
    L32:
        return new ImageRequest[0];
    }

    public static void loadBitmapSynchronized(String r1, int r2, int r3, ImageUtil.LoadImageCallback r4) {
        if (r2 <= 0) goto L5;
        if (r3 <= 0) goto L5;
        ResizeOptions r0 = new ResizeOptions(r2, r3);
    L6:
        ArrayList r5 = new ArrayList();
        ImageRequest r6 = createImageRequestWithUri(UriProtector.parse(r1), r0);
        if (r6 == null) goto L9;
        r5.add(r6);
    L9:
        loadBitmapSynchronized((ImageRequest[]) r5.toArray(new ImageRequest[r5.size()]), r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static void loadSdcardImage(HSImageView r2, String r3, int r4, int r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (r3.startsWith("file://") == true) goto L10;
        r3 = "file://".concat(r3);
    L10:
        if (r4 <= 0) goto L13;
        if (r5 <= 0) goto L13;
        ResizeOptions r0 = new ResizeOptions(r4, r5);
    L14:
        ImageRequestBuilder r6 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3));
        if (r0 == null) goto L17;
        r6.setResizeOptions(r0);
    L17:
        r2.setImageURI(r6.build().getSourceUri());
        return;
    L13:
        r0 = null;
        goto L14
    }

    public static void bindImage(HSImageView r9, py.k r11, p0 r12, boolean r13) {
        bindImage(r9, r11, null, -1, -1, null, r12, false, r13);
    }

    public static ImageRequest[] createImageRequests(py.k r1, int r2, int r3, long r4) {
        if (r1 != null) goto L6;
        return new ImageRequest[0];
    L6:
        return createImageRequests(r1, new ResizeOptions(r2, r3, r4), null);
    }

    public static void bindImage(HSImageView r8, py.k r9, int r11, int r12) {
        bindImage(r8, r9, null, r11, r12, null, null, false);
    }

    public static void bindImage(HSImageView r8, py.k r9, Postprocessor r11, p0 r12) {
        bindImage(r8, r9, null, -1, -1, r11, r12, false);
    }

    public static void bindImage(HSImageView r8, py.k r9, int r11, int r12, int r13) {
        bindImage(r8, r9, toDrawable(r11), r12, r13, null, null, false);
    }

    public static void bindImageWithAnimation(HSImageView r12, py.k r13, p0 r14, boolean r15, boolean r16) {
        bindImage(r12, r13, null, 300, -1, -1, null, r14, r15, false, true, r16);
    }

    public static void bindImageWithFocusCrop(SimpleDraweeView r3, py.k r4, int r5, int r6, PointF r7) {
        if (r3 == null) goto L33;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getUrls() != null) goto L7;
        return;
    L7:
        if (r4.getUrls().size() == 0) goto L38;
        if (r5 < 0) goto L11;
        if (r6 < 0) goto L11;
    L13:
        if (r5 <= 0) goto L16;
        if (r6 <= 0) goto L16;
        ResizeOptions r1 = new ResizeOptions(r5, r6);
    L17:
        ImageRequest[] r8 = createImageRequests(r4, r1, null, false);
        if (r8 != null) goto L20;
        return;
    L20:
        if (r8.length == 0) goto L39;
        PipelineDraweeControllerBuilder r9 = Fresco.newDraweeControllerBuilder().setOldController(r3.getController()).setFirstAvailableImageRequests(r8);
        if (r3.getHierarchy() != null) goto L25;
        r3.setHierarchy(new GenericDraweeHierarchyBuilder(r3.getContext().getResources()).setActualImageFocusPoint(r7).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP).build());
    L26:
        r9.setControllerListener(new e(r4, null, false));
        r3.setController(r9.build());
        if (r4.getImageContent() != null) goto L29;
    L31:
        r3.setImportantForAccessibility(2);
        return;
    L29:
        if (TextUtils.isEmpty(r4.getImageContent().getAccessibilityText()) == true) goto L31;
        r3.setFocusable(true);
        r3.setImportantForAccessibility(1);
        r3.a(r3, r4.getImageContent().getAccessibilityText());
        return;
    L25:
        GenericDraweeHierarchy r2 = r3.getHierarchy();
        r2.setActualImageFocusPoint(r7);
        r3.setHierarchy(r2);
        goto L26
    L39:
        return;
    L16:
        r1 = null;
    L11:
        r5 = r3.getMeasuredWidth();
        r6 = r3.getMeasuredHeight();
        goto L13
    L38:
        return;
    }

    public static void loadBitmapSynchronized(py.k r2, int r3, int r4, boolean r5, ImageUtil.LoadImageCallback r6) {
        if (r3 <= 0) goto L6;
        if (r4 <= 0) goto L6;
        ResizeOptions r1 = new ResizeOptions(r3, r4);
    L7:
        loadBitmapSynchronized(createImageRequests(r2, r1, null, r5), r6);
        return;
    L6:
        r1 = null;
        goto L7
    }

    public static void bindImage(HSImageView r8, py.k r9, int r11, int r12, p0 r13) {
        bindImage(r8, r9, null, r11, r12, null, r13, false);
    }

    public static void bindImage(HSImageView r8, py.k r9, int r11, int r12, Postprocessor r13) {
        bindImage(r8, r9, null, r11, r12, r13, null, false);
    }

    public static void bindImage(HSImageView r8, py.k r9, int r11, int r12, int r13, p0 r14) {
        bindImage(r8, r9, toDrawable(r11), r12, r13, null, r14, false);
    }

    public static void bindImage(SimpleDraweeView r11, py.k r12, Drawable r13, int r14, int r15, Postprocessor r16, p0 r17, boolean r18) {
        bindImage(r11, r12, r13, 300, r14, r15, r16, r17, r18, false, true);
    }

    public static void bindImage(SimpleDraweeView r11, py.k r12, Drawable r13, int r14, int r15, Postprocessor r16, p0 r17, boolean r18, boolean r19) {
        bindImage(r11, r12, r13, 300, r14, r15, r16, r17, r18, false, r19);
    }

    public static void bindImage(SimpleDraweeView r12, py.k r13, Drawable r14, int r15, int r16, int r17, Postprocessor r18, p0 r19, boolean r21, boolean r22, boolean r23) {
        bindImage(r12, r13, r14, r15, r16, r17, r18, r19, r21, r22, r23, false);
    }

    public static void bindImageAntiFlink(SimpleDraweeView r11, py.k r12, Drawable r13, int r14, int r15, int r16, Postprocessor r17, p0 r18, boolean r19, boolean r21, boolean r22) {
        if (r11 == null) goto L26;
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.getUrls() != null) goto L8;
        return;
    L8:
        if (r12.getUrls().size() == 0) goto L29;
        j40.x1 r2 = j40.x1.a;
        boolean r3 = r2.getValue().isAvatarLoadAntiFlink();
        long r4 = r2.getValue().getAntiFlinkDebounce();
        if (r3 == false) goto L24;
        Object r5 = r11.getTag(2131389794);
        if ((r5 instanceof Pair) == false) goto L24;
        Pair r6 = (Pair) r5;
        Object r7 = r6.first;
        Object r8 = r6.second;
        if ((r7 instanceof py.k) == false) goto L24;
        if ((r8 instanceof Long) == false) goto L24;
        long r9 = System.currentTimeMillis() - ((Long) r8).longValue();
        ALogger.i(TAG, "[loadAntiFlink] try load image " + r12.getUri() + " old " + ((py.k) r7).getUri() + " duration " + r9);
        if (r9 >= r4) goto L24;
        boolean r23 = r12.equalsOnlyUri(r7);
        ALogger.i(TAG, "[loadAntiFlink] try load image equals " + r23);
        if (r23 == false) goto L24;
        ALogger.e(TAG, "[loadAntiFlink] skip load image " + r12.getUri());
        return;
    L24:
        bindImage(r11, r12, r13, r14, r15, r16, r17, new a(r18, r3, r11), r19, r21, r22);
        return;
    L29:
        return;
    }

    public static void bindImage(SimpleDraweeView r1, py.k r2, Drawable r3, int r4, int r5, int r6, Postprocessor r7, p0 r8, boolean r9, boolean r11, boolean r12, boolean r13) {
        if (r1 == null) goto L41;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getUrls() != null) goto L7;
        return;
    L7:
        if (r2.getUrls().size() == 0) goto L46;
        if (r12 == false) goto L13;
        if (r5 < 0) goto L12;
        if (r6 >= 0) goto L13;
    L12:
        r5 = r1.getMeasuredWidth();
        r6 = r1.getMeasuredHeight();
    L13:
        if (r5 <= 0) goto L16;
        if (r6 <= 0) goto L16;
        ResizeOptions r14 = new ResizeOptions(r5, r6);
    L17:
        ImageRequest[] r15 = createImageRequests(r2, r14, r7, r11);
        if (r15 != null) goto L20;
        return;
    L20:
        if (r15.length == 0) goto L47;
        PipelineDraweeControllerBuilder r16 = Fresco.newDraweeControllerBuilder().setOldController(r1.getController()).setFirstAvailableImageRequests(r15);
        if (r9 == false) goto L25;
        r16.setAutoPlayAnimations(true);
    L25:
        if (r3 == null) goto L31;
        if (r1.getHierarchy() != null) goto L29;
        r1.setHierarchy(new GenericDraweeHierarchyBuilder(r1.getContext().getResources()).setFadeDuration(r4).setPlaceholderImage(r3).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
    L34:
        r16.setControllerListener(new e(r2, r8, r13));
        r1.setController(r16.build());
        if (r2.getImageContent() != null) goto L37;
    L39:
        r1.setImportantForAccessibility(2);
        return;
    L37:
        if (TextUtils.isEmpty(r2.getImageContent().getAccessibilityText()) == true) goto L39;
        r1.setFocusable(true);
        r1.setImportantForAccessibility(1);
        r3.a(r1, r2.getImageContent().getAccessibilityText());
        return;
    L29:
        GenericDraweeHierarchy r17 = r1.getHierarchy();
        r17.setFadeDuration(r4);
        r17.setPlaceholderImage(r3);
        r1.setHierarchy(r17);
        goto L34
    L31:
        if (r1.getHierarchy() != null) goto L33;
        r1.setHierarchy(new GenericDraweeHierarchyBuilder(r1.getContext().getResources()).setFadeDuration(r4).build());
        goto L34
    L33:
        GenericDraweeHierarchy r18 = r1.getHierarchy();
        r18.setFadeDuration(r4);
        r1.setHierarchy(r18);
        goto L34
    L47:
        return;
    L16:
        r14 = null;
        goto L17
    L46:
        return;
    }
}
