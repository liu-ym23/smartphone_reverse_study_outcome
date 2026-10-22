package com.bytedance.android.livesdk.gift.util;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements SingleOnSubscribe {
    public final /* synthetic */ k a;
    public final /* synthetic */ ResizeOptions b;
    public final /* synthetic */ String c;

    public static final class a extends BaseBitmapDataSubscriber {
        public final /* synthetic */ e a;
        public final /* synthetic */ SingleEmitter b;

        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r3) {
            Intrinsics.checkNotNullParameter(r3, "dataSource");
            if (this.b.isDisposed() == true) goto L9;
            SingleEmitter r0 = this.b;
            Throwable r4 = r3.getFailureCause();
            if (r4 != null) goto L7;
            r4 = new IllegalStateException("load failed");
        L7:
            r0.onError(r4);
            return;
        }

        public final void onNewResultImpl(Bitmap r4) {
            if (this.b.isDisposed() == true) goto L12;
            if (r4 != null) goto L7;
            this.b.onError(new IllegalStateException("No bitmap loaded for imageModel: ".concat(String.valueOf(this.a.a))));
            return;
        L7:
            Bitmap.Config r0 = r4.getConfig();
            if (r0 != null) goto L10;
            r0 = Bitmap.Config.ARGB_8888;
        L10:
            this.b.onSuccess(r4.copy(r0, false));
            return;
        }

        public final void onProgressUpdate(DataSource<CloseableReference<CloseableImage>> r3) {
            StringBuilder r0 = new StringBuilder("loadFirstAvailableImageBitmap onProgressUpdate, progress=");
            if (r3 == null) goto L5;
            Float r4 = Float.valueOf(r3.getProgress());
        L6:
            r0.append(r4);
            ALogger.d("GiftImageLoader", r0.toString());
            return;
        L5:
            r4 = null;
            goto L6
        }

        public a(e r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public e(k r1, ResizeOptions r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<Bitmap> r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        GiftImageLoader r0 = GiftImageLoader.k;
        k r1 = this.a;
        ResizeOptions r2 = this.b;
        String r3 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "callerContext");
        DataSource r4 = null;
        List r5 = GiftImageLoader.c(r1, r2, null, null);
        if (r5.isEmpty() == true) goto L13;
        List r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r9 = r6.iterator();
    L7:
        if (r9.hasNext() == false) goto L10;
        ImageRequest r10 = (ImageRequest) r9.next();
        r7.add(Fresco.getImagePipeline().getDataSourceSupplier(r10, r3, ImageRequest.RequestLevel.FULL_FETCH));
        goto L7
    L10:
        if (r7.isEmpty() == true) goto L13;
        r4 = FirstAvailableDataSourceSupplier.create(r7).get();
    L13:
        if (r4 != null) goto L16;
        r8.onError(new IllegalArgumentException("Cannot build requests from imageModel: ".concat(String.valueOf(this.a))));
        return;
    L16:
        r4.subscribe(new a(this, r8), TTExecutors.getNormalExecutor());
        ALogger.d("GiftImageLoader", "loadFirstAvailableImageBitmap subscribe");
    }
}
