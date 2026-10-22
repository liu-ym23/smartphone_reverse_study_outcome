package j22;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.nf;
import com.bytedance.android.livesdk.config.uj1;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ISpeakingImageDef;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.ImageInfo;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static uj1 g;
    public final HSImageView a;
    public k b;
    public String c;
    public boolean d;
    public boolean e;
    public Bitmap f;

    public class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ k a;
        public final /* synthetic */ c b;

        public a(c r1, k r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, (ImageInfo) r2, r3);
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            ((AnimatedDrawable2) r3).setAnimationListener(new j22.b(this, r3));
            return;
        }
    }

    public class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ String a;
        public final /* synthetic */ c b;

        public b(c r1, String r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onFinalImageSet(String r4, Object r5, Animatable r6) {
            CloseableAnimatedImage r7 = (ImageInfo) r5;
            super.onFinalImageSet(r4, r7, r6);
            if ((r7 instanceof CloseableAnimatedImage) == false) goto L10;
            AnimatedImageResult r8 = r7.getImageResult();
            if (r8 == null) goto L10;
            if (r8.getImage().getFrameCount() <= 0) goto L10;
            AnimatedImageFrame r9 = r8.getImage().getFrame(0);
            c r10 = this.b;
            r10.f = Bitmap.createBitmap(r10.a.getWidth(), this.b.a.getHeight(), Bitmap.Config.ARGB_8888);
            r9.renderFrame(this.b.a.getWidth(), this.b.a.getHeight(), this.b.f);
        L10:
            if ((r6 instanceof AnimatedDrawable2) == false) goto L13;
            ((AnimatedDrawable2) r6).setAnimationListener(new d(this));
            return;
        }
    }

    static {
        g = (uj1) nf.a.getValue();
    }

    public c(HSImageView r2) {
        this.d = false;
        this.e = false;
        this.a = r2;
        g = (uj1) nf.a.getValue();
    }

    public final void a(String r4) {
        if (this.a != null) goto L5;
        return;
    L5:
        AbstractDraweeController r5 = Fresco.newDraweeControllerBuilder().setOldController(this.a.getController()).setUri(r4).setControllerListener(new b(this, r4)).setAutoPlayAnimations(true).build();
        if (this.f == null) goto L8;
        this.a.getHierarchy().setPlaceholderImage(new BitmapDrawable(this.f));
    L8:
        this.a.setController(r5);
    }

    public final void b(k r4) {
        if (this.a != null) goto L5;
        return;
    L5:
        AbstractDraweeController r5 = Fresco.newDraweeControllerBuilder().setOldController(this.a.getController()).setFirstAvailableImageRequests(a1.b(r4, -1)).setControllerListener(new a(this, r4)).setAutoPlayAnimations(true).build();
        if (this.f == null) goto L8;
        this.a.getHierarchy().setPlaceholderImage(new BitmapDrawable(this.f));
    L8:
        this.a.setController(r5);
    }

    public final void d(String r2) {
        this.d = false;
        if (TextUtils.equals(r2, this.c) == true) goto L5;
        this.c = r2;
    L5:
        HSImageView r0 = this.a;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.getController() == null) goto L11;
        return;
    L11:
        a(r2);
    }

    public final void e(k r2) {
        this.d = false;
        this.e = false;
        if (r2 != null) goto L5;
    L7:
        HSImageView r3 = this.a;
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.getController() == null) goto L13;
        return;
    L13:
        b(this.b);
        return;
    L5:
        if (r2.equals(this.b) == true) goto L7;
        this.b = r2;
        goto L7
    }

    public final void f(k r2) {
        this.d = false;
        this.e = true;
        if (r2 != null) goto L5;
    L7:
        HSImageView r3 = this.a;
        if (r3 != null) goto L10;
    L14:
        b(this.b);
        return;
    L10:
        if (r3.getController() == null) goto L14;
        if (this.a.isAnimating() == false) goto L14;
        return;
    L5:
        if (r2.equals(this.b) == true) goto L7;
        this.b = r2;
        goto L7
    }

    @ISpeakingImageDef.VoiceVolume
    public static int c(int r1, boolean r2) {
        if (r2 == false) goto L4;
        uj1 r3 = g;
    L6:
        if (r1 > 30) goto L9;
        return 0;
    L9:
        if (r1 <= 30) goto L15;
        if (r1 > r3.low) goto L15;
        return 1;
    L15:
        if (r1 > r3.low) goto L17;
        return 3;
    L17:
        if (r1 > r3.media) goto L22;
        return 2;
    L22:
        return 3;
    L4:
        r3 = (uj1) nf.a.getValue();
        goto L6
    }
}
