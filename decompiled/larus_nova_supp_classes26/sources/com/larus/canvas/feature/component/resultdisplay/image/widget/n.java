package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.canvas.feature.component.resultdisplay.image.v;
import com.larus.canvas.feature.component.resultdisplay.image.y;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ ImagePagerAdapter.PageVH a;
    public final /* synthetic */ v b;

    public n(ImagePagerAdapter.PageVH r1, v r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onIntermediateImageSet(String r6, Object r7) {
        super.onIntermediateImageSet(r6, (ImageInfo) r7);
        ImagePagerAdapter.PageVH r8 = this.a;
        int r9 = ImagePagerAdapter.PageVH.u;
        r8.W3();
        y r10 = this.a.q;
        if (r10 == null) goto L6;
        ImagePagerAdapter.PageVH r11 = this.a;
        v r0 = this.b;
        r11.g.a(r10.d, r10.e);
        s r1 = r11.V3();
        String r2 = r10.a;
        int r3 = s.f;
        r1.a(false, r2, "");
        r11.X3(r10, r0);
        r11.f.invoke(r10, Boolean.TRUE);
        return;
    }

    public final void onFailure(String r5, ImageRequest r6, Throwable r7) {
        super.onFailure(r5, r6, r7);
        ImagePagerAdapter.PageVH r8 = this.a;
        int r9 = ImagePagerAdapter.PageVH.u;
        r8.W3();
        ImagePagerAdapter.PageVH r10 = this.a;
        y r11 = r10.q;
        if (r11 == null) goto L6;
        r10.r = true;
        r10.g.a(r11.d, r11.e);
        s r0 = r10.V3();
        String r1 = r11.a;
        int r2 = s.f;
        r0.a(false, r1, "");
        r10.f.invoke(r11, Boolean.FALSE);
        FLogger.a.e("ImagePagerViewHolder", "load image failed", r7);
        return;
    }

    public final void onFinalImageSet(String r5, Object r6, Animatable r7) {
        ImageInfo r8 = (ImageInfo) r6;
        ImagePagerAdapter.PageVH r9 = this.a;
        int r10 = ImagePagerAdapter.PageVH.u;
        r9.W3();
        y r11 = this.a.q;
        if (r11 == null) goto L6;
        ImagePagerAdapter.PageVH r12 = this.a;
        v r13 = this.b;
        r12.g.a(r11.d, r11.e);
        s r0 = r12.V3();
        String r1 = r11.a;
        int r2 = s.f;
        r0.a(false, r1, "");
        r12.X3(r11, r13);
        r12.f.invoke(r11, Boolean.TRUE);
        return;
    }
}
