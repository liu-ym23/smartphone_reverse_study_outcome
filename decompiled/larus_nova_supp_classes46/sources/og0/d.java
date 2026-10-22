package og0;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, (ImageInfo) r2, r3);
        if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
        AnimatedDrawable2 r4 = (AnimatedDrawable2) r3;
        r4.setAnimationListener(new c(this, r4.getFrameCount()));
        return;
    }
}
