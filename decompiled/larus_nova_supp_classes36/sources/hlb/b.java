package hlb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements d {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // hlb.d
    public final String getName() {
        return "HeicToJpgTransform";
    }

    @Override // hlb.d
    public final boolean a(com.ss.android.lark.image.uploader.entity.b r4, ImageUploadTask r5) {
        Intrinsics.checkNotNullParameter(r4, LoadParams.ImageFormat.IMAGE);
        Intrinsics.checkNotNullParameter(r5, "imageUploadTask");
        ImageInfo r0 = r4.k;
        if (r0 != null) goto L5;
        r0 = com.ss.android.lark.image.uploader.utils.b.d(r4.a, true, false);
    L5:
        flb.a r6 = r5.d;
        if (r6 == null) goto L8;
        boolean r7 = r6.a;
    L9:
        if (r7 == true) goto L11;
    L16:
        return false;
    L11:
        if (r4.b == false) goto L16;
        if (r0 == null) goto L16;
        if (ImageUtils.f(r0.h) == false) goto L16;
        return true;
    L8:
        r7 = false;
        goto L9
    }

    @Override // hlb.d
    public final String b(com.ss.android.lark.image.uploader.entity.b r10, ImageUploadTask r11) {
        Intrinsics.checkNotNullParameter(r10, LoadParams.ImageFormat.IMAGE);
        Intrinsics.checkNotNullParameter(r11, "imageUploadTask");
        String r2 = r10.a;
        PolarisFileWrapper r3 = new PolarisFileWrapper(com.ss.android.lark.diskmanage.storage.d.g(r11.getContext()), new PolarisFileWrapper(r10.a).getName());
        ImageInfo r12 = com.ss.android.lark.image.uploader.utils.b.d(r2, true, false);
        PolarisFileOutputStreamWrapper r5 = null;
        if (r12 != null) goto L34;
        com.ss.android.lark.image.uploader.utils.c.b("HeicToJpgTransform", "read image info failed, skip transform", null, false);
        return r2;
    L34:
        PolarisFileOutputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r10.a);     // Catch: Throwable -> L22 Exception -> L24
    L36:
        Bitmap r13 = BitmapFactory.decodeStream(r4, null, new BitmapFactory.Options());     // Catch: Throwable -> L18 Exception -> L20
        if (r13 == null) goto L16;
        PolarisFileOutputStreamWrapper r7 = new PolarisFileOutputStreamWrapper(r3);     // Catch: Throwable -> L18 Exception -> L20
        com.ss.android.lark.image.uploader.utils.d.a.a(r13, r12.f).compress(Bitmap.CompressFormat.JPEG, 80, r7);     // Catch: Throwable -> L12 Exception -> L14
        r2 = r3.getAbsolutePath();     // Catch: Throwable -> L12 Exception -> L14
        r13.recycle();     // Catch: Throwable -> L12 Exception -> L14
        Log.i("HeicToJpgTransform", "transcode success, " + r2);     // Catch: Throwable -> L12 Exception -> L14
        r5 = r7;
    L17:
        IOUtils.close(r4);
        IOUtils.close(r5);
    L28:
        return r2;
    L14:
        e = e;
        r5 = r7;
    L21:
        PolarisFileOutputStreamWrapper r14 = r5;
        r5 = r4;
    L32:
        Log.e("HeicToJpgTransform", "transcode error, " + e.getMessage());     // Catch: Throwable -> L29
        IOUtils.close(r5);
        IOUtils.close(r14);
    L29:
        th = th;
    L30:
        IOUtils.close(r5);
        IOUtils.close(r14);
        throw th;
    L12:
        th = th;
        r5 = r7;
    L19:
        r14 = r5;
        r5 = r4;
        goto L30
    L16:
        Log.e("HeicToJpgTransform", "decodeStream failed");     // Catch: Throwable -> L18 Exception -> L20
    L20:
        e = e;
    L18:
        th = th;
    L24:
        e = e;
        r14 = null;
    L22:
        th = th;
        r14 = null;
        goto L30
    }
}
