package com.larus.avlink.gallery.thumbnail;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u0 extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ ThumbnailMetadata a;

    public u0(ThumbnailMetadata r1) {
        this.a = r1;
    }

    public final void onFailure(String r3, Throwable r4) {
        FLogger.a.e("ThumbnailViewHolder", "Image load failed for thumbnail: " + this.a.getFilePath(), r4);
    }

    public final void onSubmit(String r1, Object r2) {
        super.onSubmit(r1, r2);
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, (ImageInfo) r2, r3);
    }
}
