package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ ImagePagerAdapter.PageVH a;

    public p(ImagePagerAdapter.PageVH r1) {
        this.a = r1;
    }

    public final void onFailure(String r2, ImageRequest r3, Throwable r4) {
        super.onFailure(r2, r3, r4);
        this.a.r = true;
        FLogger.a.e("ImagePagerViewHolder", "load compare image failed", r4);
    }

    public final /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
    }
}
