package com.tom_roush.pdfbox.pdmodel.graphics.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import com.tom_roush.pdfbox.a.k;
import com.tom_roush.pdfbox.filter.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
final class c {
    private static Bitmap a(a r22, Rect r23, int r24, int r25, int r26) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r22, a.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.pdmodel.graphics.b.b r3 = r2.f();
        float[] r4 = a(r2);
        int r6 = r25;
        Bitmap r5 = Bitmap.createBitmap(r6, r26, Bitmap.Config.ALPHA_8);
        ByteBuffer r7 = ByteBuffer.allocate(r5.getRowBytes() * r26);
        r5.copyPixelsToBuffer(r7);
        int r9 = r24;
        h r8 = new h(r9);
        r8.a(r23);
        InputStream r10 = r2.a(r8);     // Catch: Throwable -> L49
        int r11 = 0;
        if (r8.a() == false) goto L7;
        int r0 = r26;
        int r1 = r6;
        int r12 = 0;
        int r13 = 0;
        r9 = 1;
    L8:
        byte[] r14 = r7.array();     // Catch: Throwable -> L47
        if (r9 != 1) goto L11;
        boolean r15 = true;
    L12:
        int r16 = (r1 + 7) / 8;     // Catch: Throwable -> L47
        if (r4[0] >= r4[1]) goto L15;
        byte r17 = 0;
    L16:
        int r18 = r6 + r12;     // Catch: Throwable -> L47
        byte[] r19 = new byte[r16];     // Catch: Throwable -> L47
        int r110 = 0;
    L18:
        if (r11 >= (r13 + r0)) goto L43;
        byte[] r27 = r14;
        int r111 = (int) com.tom_roush.pdfbox.io.a.a(r10, r19);     // Catch: Throwable -> L47
        if (r11 >= r13) goto L22;
    L39:
        int r28 = r0;
        int r29 = r12;
        if (r111 != r16) goto L41;
        r11 = r11 + 1;     // Catch: Throwable -> L47
        r14 = r27;
        r0 = r28;
        r12 = r29;
        goto L18
    L41:
        Log.w("PdfBox-Android", "premature EOF, image will be incomplete");     // Catch: Throwable -> L47
        goto L43
    L22:
        if ((r11 % r9) != 0) goto L39;
        int r112 = r12 / 8;     // Catch: Throwable -> L47
        int r113 = r12;
    L24:
        if (r112 >= r16) goto L39;
        if (r112 >= r111) goto L39;
        int r114 = r113 & 7;     // Catch: Throwable -> L47
        int r115 = (r19[r112] ^ r17) << (r114 + 24);     // Catch: Throwable -> L47
        int r210 = r0;
        int r211 = r12;
        int r20 = Math.min(8 - r114, r18 - r113);     // Catch: Throwable -> L47
    L27:
        if (r20 <= 0) goto L38;
        if (r15 == false) goto L30;
    L33:
        if (r115 >= 0) goto L36;
        r27[r110] = -1;     // Catch: Throwable -> L47
    L36:
        r110 = r110 + 1;     // Catch: Throwable -> L47
    L37:
        r115 = r115 << 1;     // Catch: Throwable -> L47
        r113 = r113 + 1;     // Catch: Throwable -> L47
        r20 = r20 - 1;     // Catch: Throwable -> L47
        goto L27
    L30:
        if ((r113 % r9) != 0) goto L37;
    L38:
        r112 = r112 + 1;     // Catch: Throwable -> L47
        r0 = r210;
        r12 = r211;
    L43:
        r7.rewind();     // Catch: Throwable -> L47
        r5.copyPixelsFromBuffer(r7);     // Catch: Throwable -> L47
        Bitmap r21 = r3.a(r5);     // Catch: Throwable -> L47
        if (r10 == null) goto L46;
        r10.close();
    L46:
        return r21;
    L15:
        r17 = -1;
        goto L16
    L11:
        r15 = false;
        goto L12
    L7:
        r1 = r2.h();     // Catch: Throwable -> L47
        r12 = r23.left;     // Catch: Throwable -> L47
        int r30 = r23.top;     // Catch: Throwable -> L47
        int r31 = r23.width();     // Catch: Throwable -> L47
        r0 = r23.height();     // Catch: Throwable -> L47
        r13 = r30;
        r6 = r31;
    L47:
        th = th;
    L51:
        if (r10 == null) goto L53;
        r10.close();
    L53:
        throw th;
    L49:
        th = th;
        r10 = null;
        goto L51
    }

    public static Bitmap a(a r9, Rect r10, int r11, com.tom_roush.pdfbox.a.a r12) {
        a r13 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
        if (r13.b() == true) goto L38;
        Rect r14 = a(r13, r10);
        int r0 = r13.f().b();
        int r1 = (int) Math.ceil(r14.width() / r11);
        int r2 = (int) Math.ceil(r14.height() / r11);
        int r3 = r13.d();
        if (r1 <= 0) goto L36;
        if (r2 <= 0) goto L36;
        if (r13.h() <= 0) goto L36;
        if (r13.g() <= 0) goto L36;
        if (r3 != 1) goto L17;
        if (r12 != null) goto L17;
        if (r0 != 1) goto L17;
        return a(r13, r14, r11, r1, r2);
    L17:
        float[] r4 = r13.f().a(8);     // Catch: NegativeArraySizeException -> L32
        float[] r6 = a(r13);     // Catch: NegativeArraySizeException -> L32
        if (r13.j() != null) goto L20;
    L24:
        if (r3 != 8) goto L30;
        if (r12 != null) goto L30;
        if (Arrays.equals(r6, r4) == false) goto L30;
        return b(r13, r14, r11, r1, r2);
    L30:
        Log.e("PdfBox-Android", "Trying to create other-bit image not supported");     // Catch: NegativeArraySizeException -> L32
        return b(r13, r14, r11, r1, r2);
    L20:
        if (r13.j().equals("jpg") == false) goto L24;
        if (r11 != 1) goto L24;
        return BitmapFactory.decodeStream(r13.a());
    L32:
        e = move-exception;
        throw new IOException(e);
    L36:
        throw new IOException("image width and height must be positive");
    L38:
        throw new IOException("Image stream is empty");
    }

    public static Bitmap a(a r2, com.tom_roush.pdfbox.a.a r3) {
        return a((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"), null, 1, r3);
    }

    private static Bitmap a(InputStream r7, int r8, int r9, int r10) {
        byte[] r11 = com.tom_roush.pdfbox.io.a.a(r7);
        int r0 = (r11.length / r9) / r8;
        if (r9 != 1) goto L9;
        int r12 = r8 * r0;
        byte[] r2 = new byte[r12 * 4];
        int r13 = r12 - 1;
    L5:
        if (r13 < 0) goto L7;
        int r3 = r13 * 4;
        r2[r3 + 3] = r11[r13];
        r2[r3] = r11[r13];
        r2[r3 + 1] = r11[r13];
        r2[r3 + 2] = r11[r13];
        r13 = r13 - 1;
    L7:
        r11 = r2;
    L13:
        Bitmap r14 = Bitmap.createBitmap(r8, r0, Bitmap.Config.ARGB_8888);
        r14.copyPixelsFromBuffer(ByteBuffer.wrap(r11));
        if (r10 > 1) goto L16;
        return r14;
    L16:
        return Bitmap.createScaledBitmap(r14, r8 / r10, r0 / r10, true);
    L9:
        if (r9 != 3) goto L13;
        int r15 = r8 * r0;
        r2 = new byte[r15 * 4];
        int r16 = r15 - 1;
    L11:
        if (r16 < 0) goto L7;
        int r4 = r16 * 4;
        int r5 = r16 * 3;
        r2[r4 + 3] = -1;
        r2[r4] = r11[r5];
        r2[r4 + 1] = r11[r5 + 1];
        r2[r4 + 2] = r11[r5 + 2];
        r16 = r16 - 1;
        goto L11
    }

    private static Rect a(a r4, Rect r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        int r1 = Math.max(0, r5.left);
        int r0 = Math.max(0, r5.top);
        return new Rect(r1, r0, Math.min(r5.width(), r6.h() - r1), Math.min(r5.height(), r6.g() - r0));
    L5:
        return new Rect(0, 0, r6.h(), r6.g());
    }

    private static float[] a(a r11) {
        a r12 = (a) ZeusTransformUtils.wrapperContextForParams(r11, a.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.a r0 = r12.i();
        if (r0 != null) goto L5;
    L26:
        float[] r1 = null;
    L27:
        if (r1 == null) goto L29;
        return r1;
    L29:
        return r12.f().a(r12.d());
    L5:
        if (r0.b() != (r12.f().b() * 2)) goto L7;
        r1 = r0.c();
        goto L27
    L7:
        if (r12.c() == true) goto L9;
    L24:
        Log.e("PdfBox-Android", "decode array " + r0 + " not compatible with color space, using default");
        goto L26
    L9:
        if (r0.b() < 2) goto L24;
        if (ZeusTransformUtils.instanceOf(r0.b(0), k.class) == false) goto L24;
        if (ZeusTransformUtils.instanceOf(r0.b(1), k.class) == false) goto L24;
        float r7 = ((k) ZeusTransformUtils.preCheckCast(r0.b(0), k.class, "com.obric.memorydata.plugin")).a();
        float r2 = ((k) ZeusTransformUtils.preCheckCast(r0.b(1), k.class, "com.obric.memorydata.plugin")).a();
        if (r7 < 0.0f) goto L24;
        if (r7 > 1.0f) goto L24;
        if (r2 < 0.0f) goto L24;
        if (r2 > 1.0f) goto L24;
        Log.w("PdfBox-Android", "decode array " + r0 + " not compatible with color space, using the first two entries");
        return new float[]{r7, r2};
    }

    private static Bitmap b(a r6, Rect r7, int r8, int r9, int r10) {
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        h r0 = new h(r8);
        r0.a(r7);
        InputStream r1 = r11.a(r0);
        int r3 = 0;
        if (r0.a() == false) goto L6;
        int r2 = r9;
        int r5 = r2;
        int r12 = r10;
        r8 = 1;
        int r4 = 0;
    L7:
        int r13 = r11.f().b();     // Catch: Throwable -> L21
        if (r3 != 0) goto L15;
        if (r4 != 0) goto L15;
        if (r5 != r9) goto L15;
        if (r12 != r10) goto L15;
        Bitmap r14 = a(r1, r2, r13, r8);     // Catch: Throwable -> L21
        com.tom_roush.pdfbox.io.a.a(r1);
        return r14;
    L15:
        Bitmap r15 = a(r1, r2, r13, r8);     // Catch: Throwable -> L21
        if (r8 <= 1) goto L18;
        r3 = r3 / r8;     // Catch: Throwable -> L21
        r4 = r4 / r8;     // Catch: Throwable -> L21
    L18:
        Bitmap r16 = Bitmap.createBitmap(r15, r3, r4, r9, r10);     // Catch: Throwable -> L21
        com.tom_roush.pdfbox.io.a.a(r1);
        return r16;
    L6:
        r2 = r11.h();     // Catch: Throwable -> L21
        r3 = r7.left;     // Catch: Throwable -> L21
        r4 = r7.top;     // Catch: Throwable -> L21
        r5 = r7.width();     // Catch: Throwable -> L21
        r12 = r7.height();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        com.tom_roush.pdfbox.io.a.a(r1);
        throw th;
    }
}
