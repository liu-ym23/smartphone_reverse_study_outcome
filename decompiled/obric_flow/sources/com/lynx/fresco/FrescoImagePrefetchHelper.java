package com.lynx.fresco;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.Keep;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import oo.g;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class FrescoImagePrefetchHelper {
    public static final String PRIORITY_HIGH = "high";
    public static final String PRIORITY_LOW = "low";

    public FrescoImagePrefetchHelper() {
    }

    public static DataSource<Void> prefetchImageToBitmapCache(String r5, Bitmap.Config r10, Object r11) {
        if (r5 != null) goto L5;
    L12:
        return null;
    L5:
        if (r5.isEmpty() == true) goto L12;
        Uri r12 = Uri.parse(r5);
        if (r12.getScheme() != null) goto L10;
        return null;
    L10:
        ImageRequestBuilder r13 = ImageRequestBuilder.a(r12);
        g.b(r13, r10, false);
        return Fresco.a().e().a(r13.a(), r11);
    }
}
