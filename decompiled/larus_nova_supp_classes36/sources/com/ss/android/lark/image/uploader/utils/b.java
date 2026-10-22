package com.ss.android.lark.image.uploader.utils;

import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.tool.image.JPEGTool;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static void a(Closeable r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static int b(String r2) {
        return new ExifInterface(r2).getAttributeInt("Orientation", 1);
    L4:
        e = move-exception;
        int r0 = c.a;
        c.c("ImageReader", "orientation not found, " + e.getMessage());
        return -1;
    }

    public static ImageInfo c(InputStream r2) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        r0.inSampleSize = 1;
        BitmapFactory.decodeStream(r2, null, r0);
        a(r2);
        HashMap<String, ImageUtils.ImageType> r3 = ImageInfo.j;
        ImageInfo.a r4 = new ImageInfo.a();
        r4.a = r0.outWidth;
        r4.b = r0.outHeight;
        r4.e = r0.outMimeType;
        return new ImageInfo(r4);
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00e7: MOVE (r4 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:50331879), block:B:50:0x00e7 */
    public static ImageInfo d(String r18, boolean r19, boolean r20) {
        Closeable r4 = null;
        VFSFiles r5 = VFSFiles.b;     // Catch: Throwable -> L42 IOException -> L44
        VFSPath r6 = r5.z(r18);     // Catch: Throwable -> L42 IOException -> L44
        long r7 = com.suite.lark.component.storage.ext.b.e(r6);     // Catch: Throwable -> L42 IOException -> L44
        Intrinsics.checkNotNullParameter(r6, "<this>");     // Catch: Throwable -> L42 IOException -> L44
        r5.getClass();     // Catch: Throwable -> L42 IOException -> L44
        InputStream r9 = VFSFiles.a(r6).l(r6);     // Catch: Throwable -> L42 IOException -> L44
        ImageInfo r10 = c(r9);     // Catch: IOException -> L9 Throwable -> L49
        String r8 = r5.r(r6, r20).getAbsolutePath();     // Catch: IOException -> L9 Throwable -> L49
        if (r10.a > 0) goto L7;
    L11:
        boolean r11 = false;
    L12:
        if (r11 == false) goto L40;
        int r0 = b(r8);     // Catch: IOException -> L9 Throwable -> L49
        if (r0 < 0) goto L16;
        boolean r2 = true;
    L17:
        if (r19 == true) goto L19;
        int r12 = -1;
    L24:
        d r13 = d.a;     // Catch: IOException -> L9 Throwable -> L49
        int r14 = r10.a;     // Catch: IOException -> L9 Throwable -> L49
        int r15 = r10.b;     // Catch: IOException -> L9 Throwable -> L49
        switch(r0) {
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L27;
            default: goto L26;
        };     // Catch: IOException -> L9 Throwable -> L49
    L26:
        char r16 = 0;
    L30:
        if (r16 == 'Z') goto L34;
        if (r16 == 270) goto L34;
        boolean r17 = false;
    L35:
        if (r17 == false) goto L37;
        r15 = r14;
        r14 = r15;
    L37:
        Pair r110 = new Pair(Integer.valueOf(r14), Integer.valueOf(r15));     // Catch: IOException -> L9 Throwable -> L49
        int r111 = ((Integer) r110.getFirst()).intValue();     // Catch: IOException -> L9 Throwable -> L49
        int r112 = ((Integer) r110.getSecond()).intValue();     // Catch: IOException -> L9 Throwable -> L49
        ImageInfo.a r113 = ImageInfo.a(r10);     // Catch: IOException -> L9 Throwable -> L49
        r113.a = r111;     // Catch: IOException -> L9 Throwable -> L49
        r113.b = r112;     // Catch: IOException -> L9 Throwable -> L49
        r113.f = r0;     // Catch: IOException -> L9 Throwable -> L49
        r113.g = r2;     // Catch: IOException -> L9 Throwable -> L49
        r113.c = r7;     // Catch: IOException -> L9 Throwable -> L49
        r113.d = r12;     // Catch: IOException -> L9 Throwable -> L49
        r113.h = ImageUtils.e(r6.toFile());     // Catch: IOException -> L9 Throwable -> L49
        ImageInfo r1 = new ImageInfo(r113);     // Catch: IOException -> L9 Throwable -> L49
        a(r9);
        return r1;
    L34:
        r17 = true;
        goto L35
    L27:
        r16 = 270;
        goto L30
    L28:
        r16 = 'Z';
        goto L30
    L29:
        r16 = 180;
        goto L30
    L19:
        if (ykb.b.a.c() == true) goto L21;
        boolean r114 = true;
    L22:
        r12 = JPEGTool.a(r8, r114);     // Catch: IOException -> L9 Throwable -> L49
        goto L24
    L21:
        r114 = false;
        goto L22
    L16:
        r2 = false;
        goto L17
    L40:
        int r21 = c.a;     // Catch: IOException -> L9 Throwable -> L49
        c.c("ImageReader", "decode image file fail, invalid size, ".concat(r18));     // Catch: IOException -> L9 Throwable -> L49
    L47:
        a(r9);
        return null;
    L7:
        if (r10.b <= 0) goto L11;
        r11 = true;
    L9:
        e = e;
    L46:
        int r3 = c.a;     // Catch: Throwable -> L49
        c.b("ImageReader", "read image info fail", e, true);     // Catch: Throwable -> L49
        e.printStackTrace();     // Catch: Throwable -> L49
        goto L47
    L49:
        th = th;
        r4 = r9;
    L51:
        a(r4);
        throw th;
    L44:
        e = e;
        r9 = null;
    L42:
        th = th;
        goto L51
    }
}
