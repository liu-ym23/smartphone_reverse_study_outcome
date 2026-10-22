package u4a;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.animax.loader.AnimaXLoaderRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {

    public interface a {
    }

    public static boolean a(m r5, l r6) {
        AnimaXLoaderRequest r7 = (AnimaXLoaderRequest) r5;
        e r0 = r7.a();
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r8 = r7.b();
        if (r8 != null) goto L8;
        Uri r9 = null;
    L9:
        int r2 = ((Integer) r0.a).intValue();
        int r3 = ((Integer) r0.b).intValue();
        g r4 = new g(r6);
        ImageRequestBuilder r10 = ImageRequestBuilder.newBuilderWithSource(r9).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.ARGB_8888).setForceStaticImage(true).build()).setRequestPriority(Priority.HIGH);
        String r11 = y4a.a.a;
        if (r2 < 32) goto L18;
        if (r3 < 32) goto L18;
        if (y4a.a.c() == false) goto L16;
    L17:
        r1 = true;
        goto L18
    L16:
        if (y4a.a.g == true) goto L17;
    L18:
        if (r1 == false) goto L20;
        r10.setResizeOptions(new ResizeOptions(r2 / 2, r3 / 2));
    L20:
        ImageRequest r12 = r10.build();
        DataSource r13 = Fresco.getImagePipeline().fetchDecodedImage(r12, "FrescoUtil");
        r13.subscribe(new h(r4, r13), CallerThreadExecutor.getInstance());
        return true;
    L8:
        r9 = UriProtector.parse(r8);
        goto L9
    }
}
