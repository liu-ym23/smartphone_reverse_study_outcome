package p8a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lynx.xelement.markdown.LynxUIMarkdownShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ q a;

    public p(q r1) {
        this.a = r1;
    }

    public final void onFailure(String r2, Throwable r3) {
        q r4 = this.a;
        s r0 = r4.b;
        LynxUIMarkdownShadowNode r1 = (LynxUIMarkdownShadowNode) r0;
        r1.E(r4.a, r3);
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        ImageInfo r5 = (ImageInfo) r3;
        if (this.a.e == null) goto L10;
        if (r5 == null) goto L10;
        if (r5.getWidth() <= 0) goto L10;
        if (r5.getHeight() <= 0) goto L10;
        this.a.e.setBounds(0, 0, r5.getWidth(), r5.getHeight());
    L10:
        q r6 = this.a;
        s r7 = r6.b;
        String r8 = r6.a;
        LynxUIMarkdownShadowNode r9 = (LynxUIMarkdownShadowNode) r7;
        if (r9.o == true) goto L18;
        d r10 = r9.D();
        if (r10 == null) goto L17;
        r10.onImageLoaded(r8);
        return;
    L17:
        return;
    }
}
