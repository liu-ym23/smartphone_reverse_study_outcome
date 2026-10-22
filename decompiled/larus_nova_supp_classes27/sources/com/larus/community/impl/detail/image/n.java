package com.larus.community.impl.detail.image;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n extends BaseControllerListener<ImageInfo> {
    public n() {
    }

    public final void onFailure(String r3, Throwable r4) {
        super.onFailure(r3, r4);
        FLogger r5 = FLogger.a;
        StringBuilder r0 = new StringBuilder("load fail ,");
        if (r4 == null) goto L5;
        String r6 = r4.getMessage();
    L6:
        r0.append(r6);
        r5.e("CreationDetailImageView", r0.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onIntermediateImageSet(String r4, Object r5) {
        ImageInfo r6 = (ImageInfo) r5;
        super.onIntermediateImageSet(r4, r6);
        FLogger r7 = FLogger.a;
        StringBuilder r0 = new StringBuilder("load onIntermediateImageSet imageInfo is ");
        Integer r1 = null;
        if (r6 == null) goto L5;
        Integer r2 = Integer.valueOf(r6.getWidth());
    L6:
        r0.append(r2);
        r0.append(' ');
        if (r6 == null) goto L9;
        r1 = Integer.valueOf(r6.getHeight());
    L9:
        r0.append(r1);
        r7.i("CreationDetailImageView", r0.toString());
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onSubmit(String r2, Object r3) {
        super.onSubmit(r2, r3);
        FLogger.a.i("CreationDetailImageView", "load success");
    }

    public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
        ImageInfo r6 = (ImageInfo) r4;
        super.onFinalImageSet(r3, r6, r5);
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("load onFinalImageSet imageInfo is ");
        Integer r0 = null;
        if (r6 == null) goto L5;
        Integer r1 = Integer.valueOf(r6.getWidth());
    L6:
        r8.append(r1);
        r8.append(' ');
        if (r6 == null) goto L9;
        r0 = Integer.valueOf(r6.getHeight());
    L9:
        r8.append(r0);
        r7.i("CreationDetailImageView", r8.toString());
        return;
    L5:
        r1 = null;
        goto L6
    }
}
