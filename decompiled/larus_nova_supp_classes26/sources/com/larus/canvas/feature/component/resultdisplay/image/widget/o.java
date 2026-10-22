package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ ImagePagerAdapter.PageVH a;

    public o(ImagePagerAdapter.PageVH r1) {
        this.a = r1;
    }

    public final void onIntermediateImageSet(String r1, Object r2) {
        super.onIntermediateImageSet(r1, (ImageInfo) r2);
        ImagePagerAdapter.PageVH r3 = this.a;
        int r4 = ImagePagerAdapter.PageVH.u;
        r3.W3();
    }

    public final void onFailure(String r1, ImageRequest r2, Throwable r3) {
        super.onFailure(r1, r2, r3);
        ImagePagerAdapter.PageVH r4 = this.a;
        int r5 = ImagePagerAdapter.PageVH.u;
        r4.W3();
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        ImagePagerAdapter.PageVH r5 = this.a;
        int r6 = ImagePagerAdapter.PageVH.u;
        r5.W3();
    }
}
