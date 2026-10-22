package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements SingleOnSubscribe {
    public final /* synthetic */ String a;

    public static final class a extends BaseBitmapDataSubscriber {
        public final /* synthetic */ SingleEmitter a;

        public a(SingleEmitter r1) {
            this.a = r1;
        }

        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r3) {
            ALogger.e("MicseatMixer", "trySetStreamBackground error ,");
            this.a.onError(new Throwable("loadBitmapFromUrlSingle onFailureImpl error"));
        }

        public final void onNewResultImpl(Bitmap r3) {
            if (r3 == null) goto L4;
            this.a.onSuccess(r3);
            return;
        L4:
            this.a.onError(new Throwable("loadBitmapFromUrlSingle onNewResultImpl null"));
        }
    }

    public f(String r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Bitmap> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        ImagePipeline r0 = ImagePipelineFactory.getInstance().getImagePipeline();
        String r1 = this.a;
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        r1 = e.a;
    L8:
        r0.fetchDecodedImage(ImageRequest.fromUri(r1), null).subscribe(new a(r4), CallerThreadExecutor.getInstance());
        return;
    L5:
        r2 = false;
        goto L6
    }
}
