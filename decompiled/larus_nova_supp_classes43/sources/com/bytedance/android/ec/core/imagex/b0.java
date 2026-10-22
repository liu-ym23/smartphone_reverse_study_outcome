package com.bytedance.android.ec.core.imagex;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0 implements ControllerListener {
    public final /* synthetic */ GenericDraweeView a;
    public final /* synthetic */ DraweeController b;

    public final void onFailure(String r1, Throwable r10) {
    }

    public final void onIntermediateImageFailed(String r1, Throwable r10) {
    }

    public final void onRelease(String r1) {
    }

    public final void onSubmit(String r1, Object r10) {
    }

    public b0(GenericDraweeView r1, AbstractDraweeController r10) {
        this.a = r1;
        this.b = r10;
    }

    public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r10) {
        ImageInfo r11 = (ImageInfo) r10;
    }

    public final void onFinalImageSet(String r1, Object r10, Animatable r11) {
        ImageInfo r12 = (ImageInfo) r10;
        ImageRequest r13 = this.b.getImageRequest();
        if (r13 == null) goto L6;
        this.a.setTag(2131376167, r13);
        return;
    }
}
