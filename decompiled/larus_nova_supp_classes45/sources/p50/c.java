package p50;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final Handler a;

    public c() {
        this.a = new Handler(Looper.getMainLooper());
    }

    public final void b(Uri r4, Function4<? super Uri, ? super Bitmap, ? super Integer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(r4), "animatedImage").subscribe(new a(this, r5, r4), TTExecutors.getCPUThreadPool());
    }

    public static final void a(c r9, CloseableAnimatedImage r11, Function4 r12, Uri r13, int r14, int r15) {
        r9.getClass();
        if (r11.getImageResult() == null) goto L7;
        AnimatedDrawableBackendFrameRenderer r2 = new AnimatedDrawableBackendFrameRenderer(new NoOpCache(), new AnimatedDrawableBackendImpl(new AnimatedDrawableUtil(), r11.getImageResult(), new Rect(0, 0, r11.getWidth(), r11.getHeight())));
        Bitmap r6 = Bitmap.createBitmap(r11.getWidth(), r11.getHeight(), Bitmap.Config.ARGB_8888);
        r2.renderFrame(r15, r6);
        r9.a.post(new b(r12, r13, r6, r14, r15));
        return;
    }
}
