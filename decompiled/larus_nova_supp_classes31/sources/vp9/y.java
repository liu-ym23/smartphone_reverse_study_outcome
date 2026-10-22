package vp9;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.ui.ClickType;
import com.larus.photopicker.v2.impl.ui.MediaViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ int a;
    public final /* synthetic */ MediaViewHolder b;
    public final /* synthetic */ op9.d c;

    public final void onFailure(String r4, Throwable r5) {
        int r0 = e0.a;
        e0.c(this.b.d, "onFailure: " + r4 + ", " + r5);
        int r6 = this.a;
        if (r6 != 0) goto L6;
        this.b.c.invoke(this.c, Integer.valueOf(r6), ClickType.ON_FIRST_IMAGE_LOAD_FAILURE);
        return;
    }

    public y(int r1, MediaViewHolder r2, op9.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        ImageInfo r5 = (ImageInfo) r3;
        int r6 = this.a;
        if (r6 != 0) goto L6;
        this.b.c.invoke(this.c, Integer.valueOf(r6), ClickType.ON_FIRST_IMAGE_LOAD_SUCCESS);
        return;
    }
}
