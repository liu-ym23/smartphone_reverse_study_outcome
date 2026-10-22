package com.bytedance.android.live.hostadapter.image;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class FrescoHelper {
    private static final Executor EXECUTOR = null;

    public interface Callback {
        void onFailure(Exception r1);

        void onSuccess(DataSource<CloseableReference<CloseableImage>> r1);
    }

    public static /* synthetic */ void a(k r0, ObservableEmitter r1) {
        lambda$loadFirstAvailableImageBitmap$0(r0, r1);
    }

    static {
        EXECUTOR = PThreadExecutorsUtils.newSingleThreadExecutor(new SimpleThreadFactory("fresco_download_image"));
    }

    private FrescoHelper() {
    }

    public static String getImageFilePath(k r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        if (r6.getUrls() != null) goto L7;
        return "";
    L7:
        if (r6.getUrls().size() != 0) goto L10;
        return "";
    L10:
        if (isDownloaded(r6) == false) goto L27;
        ImageRequest[] r7 = createImageRequests(r6, null, null);
        int r2 = r7.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L29;
        ImageRequest r4 = r7[r3];
        CacheKey r5 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r4, null);
        FileBinaryResource r8 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r5);
        if (r8 == null) goto L18;
        File r9 = r8.getFile();
        if (r9 == null) goto L18;
        return r9.getAbsolutePath();
    L18:
        r3 = r3 + 1;
        goto L12
    L29:
        return "";
    L27:
        return "";
    }

    public static String getImageUrl(ImageModel r4) {
        if (r4 != null) goto L23;
    L22:
        return "";
    L23:
    L20:
        e = move-exception;
        e.fillInStackTrace();
        goto L22
    L5:
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L22;
        List<String> r5 = r4.getUrls();     // Catch: NullPointerException -> L20
        if (r5 != null) goto L10;
    L19:
        return "";
    L10:
        if (r5.isEmpty() == true) goto L19;
        int r1 = r5.size();     // Catch: NullPointerException -> L20
        int r2 = 0;
    L13:
        if (r2 >= r1) goto L22;
        if (isDownloaded(UriProtector.parse((String) ListProtector.get(r5, r2))) == true) goto L16;
        r2 = r2 + 1;
        goto L13
    L16:
        return (String) ListProtector.get(r5, r2);
    }

    public static boolean isDownloaded(k r6) {
        ImageRequest[] r7 = createImageRequests(r6, null, null);
        int r1 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        ImageRequest r4 = r7[r3];
        CacheKey r5 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r4, null);
        if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r5) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static Observable<Bitmap> loadFirstAvailableImageBitmap(final k r1) {
        return Observable.create(new a(r1));
    }

    public static void tryDownloadImage(String r1) {
        tryDownloadImage(r1, null);
    }

    public static String getImageFilePath(String r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        if (r3.isEmpty() == true) goto L19;
        Uri r4 = UriProtector.parse(r3);
        if (isDownloaded(r4) == false) goto L17;
        ImageRequest r5 = ImageRequest.fromUri(r4);
        CacheKey r6 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r5, null);
        FileBinaryResource r7 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r6);
        if (r7 != null) goto L12;
        return "";
    L12:
        File r8 = r7.getFile();
        if (r8 != null) goto L15;
        return "";
    L15:
        return r8.getAbsolutePath();
    L17:
        return "";
    L19:
        return "";
    }

    public static boolean isDownloaded(Uri r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        ImageRequest r3 = ImageRequest.fromUri(r2);
        CacheKey r4 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r3, null);
        return ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r4);
    }

    public static ImageRequest createImageRequestWithUri(Uri r0, ResizeOptions r1) {
        if (r0 != null) goto L5;
        return null;
    L5:
        ImageRequestBuilder r2 = ImageRequestBuilder.newBuilderWithSource(r0);
        if (r1 == null) goto L9;
        r2.setResizeOptions(r1);
    L9:
        return r2.build();
    }

    private static void lambda$loadFirstAvailableImageBitmap$0(final k r3, final ObservableEmitter r4) throws Exception {
        DataSource r0 = a1.a(r3, 0, 0, false, null);
        if (r0 != null) goto L10;
        StringBuilder r1 = new StringBuilder("Cannot build requests from imageModel: ");
        if (r3 == null) goto L7;
        String r5 = r3.toString();
    L8:
        r1.append(r5);
        r4.onError(new IllegalArgumentException(r1.toString()));
        return;
    L7:
        r5 = "";
        goto L8
    L10:
        r0.subscribe(new AnonymousClass1(r4, r3), UiThreadImmediateExecutorService.getInstance());
    }

    public static void requestImage(ImageModel r2, final Callback r3) {
        final ImageRequest[] r4 = createImageRequests(r2, null, null);
        final ImagePipeline r0 = Fresco.getImagePipeline();
        fetchDataImpl(r0, r4, 0, new AnonymousClass3(r3, r0, r4));
    }

    public static void tryDownloadImage(String r3, BaseDataSubscriber<Void> r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == false) goto L7;
        return;
    L7:
        if (isDownloaded(UriProtector.parse(r3)) == false) goto L9;
        return;
    L9:
        ImageRequest r5 = ImageRequest.fromUri(r3);
        CacheKey r0 = DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r5, null);
        InstrumentedMemoryCache r2 = ImagePipelineFactory.getInstance().getEncodedMemoryCache();
        if (r2.get(r0) == null) goto L12;
        r2.removeAll(new AnonymousClass2());
    L12:
        ImagePipeline r1 = ImagePipelineFactory.getInstance().getImagePipeline();
        if (r4 == null) goto L15;
        r1.prefetchToDiskCache(r5, null).subscribe(r4, EXECUTOR);
        return;
    L15:
        r1.prefetchToDiskCache(r5, null);
    }

    private static ImageRequest[] createImageRequests(k r5, ResizeOptions r6, Postprocessor r7) {
        if (r5 == null) goto L28;
        if (r5.getUrls() == null) goto L28;
        if (r5.getUrls().size() == 0) goto L28;
        ArrayList r1 = new ArrayList();
        ImageNetworkRequestsMonitor r2 = new ImageNetworkRequestsMonitor();
        Iterator<String> r8 = r5.getUrls().iterator();
    L11:
        if (r8.hasNext() == false) goto L22;
        String r3 = r8.next();
        if (StringUtils.isEmpty(r3) == true) goto L11;
        ImageRequestBuilder r4 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r3));
        if (r7 == null) goto L18;
        r4.setPostprocessor(r7);
    L18:
        if (r6 == null) goto L20;
        r4.setResizeOptions(r6);
    L20:
        r2.monitor(r4);
        r1.add(r4.build());
        goto L11
    L22:
        if (r1.size() != 0) goto L26;
        return new ImageRequest[0];
    L26:
        return (ImageRequest[]) r1.toArray(new ImageRequest[r1.size()]);
    L28:
        return new ImageRequest[0];
    }

    public static /* synthetic */ boolean access$000(ImagePipeline r0, ImageRequest[] r1, int r2, DataSubscriber r3) {
        return fetchDataImpl(r0, r1, r2, r3);
    }

    private static boolean fetchDataImpl(ImagePipeline r1, ImageRequest[] r2, int r3, DataSubscriber<CloseableReference<CloseableImage>> r4) {
        if (r3 < r2.length) goto L6;
        return false;
    L6:
        r1.fetchDecodedImage(r2[r3], null).subscribe(r4, UiThreadImmediateExecutorService.getInstance());
        return true;
    }
}
