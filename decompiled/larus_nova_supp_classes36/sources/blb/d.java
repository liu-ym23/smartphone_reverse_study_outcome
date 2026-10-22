package blb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.image.uploader.config.ConfigManager;
import com.ss.android.lark.image.uploader.config.g;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageUtils.ImageType.values().length];
            r0[ImageUtils.ImageType.TYPE_WEBP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v5 */
    public static b a(Bitmap r11, com.ss.android.lark.image.uploader.entity.b r12, ImageInfo r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "uploadImage");
        Intrinsics.checkNotNullParameter(r13, "imageInfo");
        Intrinsics.checkNotNullParameter(r15, "outPath");
        ?? r0 = 0;
        if (r11 == null) goto L96;
        r11.getWidth();
        r11.getHeight();
        PolarisFileWrapper r1 = new PolarisFileWrapper(r15);
        if (r12.i == false) goto L7;
        int r2 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.a("QualityCompressor", "enableConvertToWebp");
        Bitmap.CompressFormat r3 = Bitmap.CompressFormat.WEBP;
    L49:
        ImageUtils.ImageType r16 = r13.h;
        if (r16 != ImageUtils.ImageType.TYPE_PNG) goto L52;
    L55:
        Log.i("QualityCompressor", "png or webp, add white bg");
        Bitmap r17 = r11.copy(Bitmap.Config.ARGB_8888, true);
        Canvas r7 = new Canvas(r17);
        r7.drawColor(-1);
        r7.drawBitmap(r11, 0.0f, 0.0f, null);
        r11.recycle();
        Bitmap r18 = r17;
        ?? r19 = r17;
    L97:
        OutputStream r110 = com.ss.android.lark.vfs.d.a().E(r1);     // Catch: Throwable -> L81 Exception -> L83
        if (r18 == null) goto L60;
        r18.compress(r3, r14, r110);     // Catch: Exception -> L74 Throwable -> L90
    L74:
        e = e;
    L85:
        int r111 = com.ss.android.lark.image.uploader.utils.c.a;     // Catch: Throwable -> L90
        com.ss.android.lark.image.uploader.utils.c.b("QualityCompressor", "compress failed", e, true);     // Catch: Throwable -> L90
        if (r18 == null) goto L88;
    L87:
        r18.recycle();
    L88:
        com.ss.android.lark.image.uploader.utils.a.a(r110);
        return null;
    L60:
        if (r12.i == false) goto L76;
        PolarisFileWrapper r112 = new PolarisFileWrapper(r12.a);     // Catch: Exception -> L74 Throwable -> L90
        if (r1.exists() == true) goto L64;
    L69:
        boolean r113 = true;
    L70:
        if (r113 == true) goto L76;
        com.ss.android.lark.image.uploader.utils.c.b("QualityCompressor", "webp compress size large then origin size", null, false);     // Catch: Exception -> L74 Throwable -> L90
        if (r18 == null) goto L88;
    L64:
        if (r112.exists() == false) goto L69;
        if (r1.length() < r112.length()) goto L69;
        r113 = false;
    L76:
        int r114 = b.b;     // Catch: Exception -> L74 Throwable -> L90
        r1.length();     // Catch: Exception -> L74 Throwable -> L90
        Intrinsics.checkNotNullParameter(r15, "path");     // Catch: Exception -> L74 Throwable -> L90
        b r115 = new b(r15);     // Catch: Exception -> L74 Throwable -> L90
        if (r18 == null) goto L79;
        r18.recycle();
    L79:
        com.ss.android.lark.image.uploader.utils.a.a(r110);
        return r115;
    L90:
        th = th;
        r0 = r19;
    L92:
        if (r18 == null) goto L94;
        r18.recycle();
    L94:
        com.ss.android.lark.image.uploader.utils.a.a(r0);
        throw th;
    L83:
        e = e;
        r110 = null;
    L81:
        th = th;
        goto L92
    L52:
        if (r16 == ImageUtils.ImageType.TYPE_WEBP) goto L55;
        boolean r116 = ImageUtils.f(r16);
        r18 = r11;
        r19 = r116;
        if (r116 == false) goto L97;
    L7:
        g r4 = ConfigManager.a().getTranscodeConfig();
        if (r4 != null) goto L12;
        r4 = ConfigManager.b.getTranscodeConfig();
        if (r4 != null) goto L12;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L22;
        int r6 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("QualityCompressor", "transcode config close, use default rule");
        ImageUtils.ImageType r8 = r13.h;
        if (r8 != null) goto L18;
        int r9 = -1;
    L19:
        if (r9 != 1) goto L21;
        r3 = Bitmap.CompressFormat.WEBP;
        goto L49
    L21:
        r3 = Bitmap.CompressFormat.JPEG;
        goto L49
    L18:
        r9 = a.a[r8.ordinal()];
        goto L19
    L22:
        g r10 = ConfigManager.a().getTranscodeConfig();
        if (r10 == null) goto L27;
        ArrayList<String> r20 = r10.b();
        if (r20 == null) goto L27;
        List r21 = CollectionsKt.filterNotNull(r20);
    L28:
        if (r21 != null) goto L30;
        r21 = CollectionsKt.emptyList();
    L30:
        ImageUtils.ImageType r22 = r13.h;
        if (r22 == null) goto L33;
        String r23 = r22.getValue();
    L35:
        if (CollectionUtils.isNotEmpty(r21) == true) goto L37;
    L39:
        boolean r24 = false;
    L40:
        if (r24 == false) goto L48;
        ImageUtils.ImageType r25 = r13.h;
        if (r25 != null) goto L44;
        int r26 = -1;
    L45:
        if (r26 != 1) goto L47;
        r3 = Bitmap.CompressFormat.WEBP;
        goto L49
    L47:
        r3 = Bitmap.CompressFormat.JPEG;
        goto L49
    L44:
        r26 = a.a[r25.ordinal()];
        goto L45
    L48:
        r3 = Bitmap.CompressFormat.JPEG;
        goto L49
    L37:
        if (CollectionsKt.contains(r21, r23) == false) goto L39;
        r24 = true;
        goto L40
    L33:
        r23 = null;
    L27:
        r21 = null;
    L12:
        r5 = r4.a();
        goto L14
    L96:
        return null;
    }
}
