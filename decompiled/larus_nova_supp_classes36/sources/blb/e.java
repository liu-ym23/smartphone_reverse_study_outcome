package blb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    static {
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x009e: MOVE (r2 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:50331806), block:B:32:0x009e */
    public static Bitmap a(String r12, ImageInfo r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "filePath");
        Intrinsics.checkNotNullParameter(r13, "sourceImageInfo");
        int r1 = Math.min(r13.a, r13.b);
        boolean r3 = true;
        if ((r1 % 2) != 1) goto L5;
        r1 = r1 + 1;
    L5:
        if (r1 <= r14) goto L10;
        int r2 = 1;
    L7:
        int r4 = r2 << 1;
        if (r4 > (r1 / r14)) goto L11;
        r2 = r4;
    L11:
        int r5 = RangesKt.coerceAtLeast(r2, 1);
        Closeable r6 = null;
        Bitmap r7 = null;
        r7 = null;
        PolarisFileInputStreamWrapper r8 = new PolarisFileInputStreamWrapper(r12);     // Catch: Throwable -> L37 Exception -> L39 OutOfMemoryError -> L47
        BitmapFactory.Options r15 = new BitmapFactory.Options();     // Catch: Throwable -> L31 Exception -> L33 OutOfMemoryError -> L35
        r15.inSampleSize = r5;     // Catch: Throwable -> L31 Exception -> L33 OutOfMemoryError -> L35
        Bitmap r16 = BitmapFactory.decodeStream(r8, null, r15);     // Catch: Throwable -> L31 Exception -> L33 OutOfMemoryError -> L35
    L63:
        com.ss.android.lark.image.uploader.utils.a.a(r8);     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        com.ss.android.lark.image.uploader.utils.d r9 = com.ss.android.lark.image.uploader.utils.d.a;     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        Bitmap r17 = r9.a(r16, r13.f);     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        if (Intrinsics.areEqual(r16, r17) == true) goto L61;
        r16.recycle();     // Catch: Exception -> L27 OutOfMemoryError -> L29 Throwable -> L31
        r16 = r17;
        goto L61
    L61:
    L23:
        Exception e = e;
    L42:
        int r18 = com.ss.android.lark.image.uploader.utils.c.a;     // Catch: Throwable -> L31
        com.ss.android.lark.image.uploader.utils.c.b("SampleSizeCompressor", "image compress failed:" + e, null, false);     // Catch: Throwable -> L31
        if (r3 == true) goto L46;
        if (r16 == null) goto L46;
        r16.recycle();     // Catch: Throwable -> L31
    L54:
        com.ss.android.lark.image.uploader.utils.a.a(r8);
        return r7;
    L46:
        r7 = r16;
    L25:
        OutOfMemoryError e2 = e;
    L50:
        int r19 = com.ss.android.lark.image.uploader.utils.c.a;     // Catch: Throwable -> L31
        com.ss.android.lark.image.uploader.utils.c.b("SampleSizeCompressor", "image compress out of memory :" + e2.getMessage(), null, false);     // Catch: Throwable -> L31
        if (r3 == true) goto L46;
        if (r16 == null) goto L46;
        r16.recycle();     // Catch: Throwable -> L31
        goto L54
    L19:
        if (RangesKt.coerceAtMost(r16.getWidth(), r16.getHeight()) <= (((double) r14) * 1.1d)) goto L22;
        int r110 = r16.getWidth();     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        int r10 = r16.getHeight();     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        float r111 = (r14 * 1.0f) / RangesKt.coerceAtMost(r110, r10);     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        Bitmap r112 = Bitmap.createScaledBitmap(r16, (int) (r110 * r111), (int) (r10 * r111), false);     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        r16.recycle();     // Catch: Exception -> L23 OutOfMemoryError -> L25 Throwable -> L31
        r16 = r112;
        goto L22
    L22:
        com.ss.android.lark.image.uploader.utils.a.a(r8);
        return r16;
    L27:
        e = e;
    L41:
        r3 = false;
    L29:
        e2 = e;
    L49:
        r3 = false;
    L33:
        e = move-exception;
        e = e;
        r16 = null;
    L35:
        e = move-exception;
        e2 = e;
        r16 = null;
        goto L49
    L31:
        th = th;
        r6 = r5;
    L56:
        com.ss.android.lark.image.uploader.utils.a.a(r6);
        throw th;
    L39:
        e = move-exception;
        e = e;
        r16 = null;
        r8 = null;
    L47:
        e = move-exception;
        e2 = e;
        r16 = null;
        r8 = null;
    L37:
        th = th;
        goto L56
    L10:
        r2 = 1;
        goto L11
    }
}
