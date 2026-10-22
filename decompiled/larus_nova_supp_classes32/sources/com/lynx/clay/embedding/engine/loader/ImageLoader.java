package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ImageLoader {
    private static ImageLoader sInstance;
    private Context context;

    public class a extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        public final /* synthetic */ ImageLoaderCallback a;

        public a(ImageLoaderCallback r1) {
            this.a = r1;
        }

        public final void onFailureImpl(DataSource r2) {
            Throwable r3 = r2.getFailureCause();
            this.a.onFailed(r3.getMessage());
            this.a.destroy();
        }

        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r2) {
            if (r2.isFinished() == true) goto L5;
            return;
        L5:
            CloseableReference<CloseableImage> r0 = (CloseableReference) r2.getResult();
            if (r0 != null) goto L9;
            r2.close();
            return;
        L9:
            this.a.onSucceeded(r0);
            this.a.destroy();
        }
    }

    public static ImageLoader getInstance() {
        return sInstance;
    }

    public Context getContext() {
        return this.context;
    }

    private ImageLoader(Context r1) {
        this.context = r1;
    }

    public static void Initialize(Context r1) {
        if (sInstance != null) goto L6;
        sInstance = new ImageLoader(r1.getApplicationContext());
        return;
    }

    public void load(String r4, ImageLoaderCallback r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (Fresco.hasBeenInitialized() == true) goto L8;
        r5.onFailed("Fresco has not been initialized!");
        r5.destroy();
        return;
    L8:
        ImagePipeline r0 = Fresco.getImagePipeline();
        ImageDecodeOptions r1 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.ARGB_8888).setDecodeAllFrames(false).build();
        ImageRequest r6 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r4)).setImageDecodeOptions(r1).build();
        a r2 = new a(r5);
        r0.fetchDecodedImage(r6, this).subscribe(r2, UiThreadImmediateExecutorService.getInstance());
    }

    public void load(String r2, long r3) {
        load(r2, new ImageLoaderCallback(r3));
    }
}
