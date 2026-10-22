package com.lynx.fresco;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import m8a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrescoImagePrefetchHelper {
    public static final String PRIORITY_HIGH = "high";
    public static final String PRIORITY_LOW = "low";

    public FrescoImagePrefetchHelper() {
    }

    public static DataSource<Void> prefetchImageToBitmapCache(String r2, Bitmap.Config r3, Object r4) {
        if (r2 != null) goto L5;
    L12:
        return null;
    L5:
        if (r2.isEmpty() == true) goto L12;
        Uri r5 = UriProtector.parse(r2);
        if (r5.getScheme() != null) goto L10;
        return null;
    L10:
        ImageRequestBuilder r6 = ImageRequestBuilder.newBuilderWithSource(r5);
        e.b(r6, r3, false);
        return Fresco.getImagePipeline().prefetchToBitmapCache(r6.build(), r4);
    }
}
