package com.larus.bmhome.chat.layout.item;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.view.RoundAvatarImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements ControllerListener<ImageInfo> {
    public final /* synthetic */ n a;

    public final void onIntermediateImageFailed(String r1, Throwable r2) {
    }

    public final void onRelease(String r1) {
    }

    public final void onSubmit(String r1, Object r2) {
    }

    public o(n r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        RoundAvatarImageView r3 = this.a.q;
        if (r3 == null) goto L7;
        GenericDraweeHierarchy r4 = r3.getHierarchy();
        if (r4 == null) goto L7;
        r4.setPlaceholderImage(2131240119);
    L7:
        RoundAvatarImageView r5 = this.a.q;
        if (r5 == null) goto L10;
        r5.setActualImageResource(2131240119);
    L10:
        this.a.n();
    }

    public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r2) {
        ImageInfo r3 = (ImageInfo) r2;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        this.a.n();
    }
}
