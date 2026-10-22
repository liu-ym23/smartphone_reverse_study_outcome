package com.tom_roush.pdfbox.filter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import com.gemalto.jp2.JP2Decoder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class n extends j {
    public n() {
    }

    private Bitmap a(InputStream r2, h r3, i r4) {
        ZeusTransformUtils.forName("com.gemalto.jp2.JP2Decoder", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L12
        Bitmap r1 = new JP2Decoder(r2).decode();
        com.tom_roush.pdfbox.a.d r5 = r4.a();
        if (r5.b(com.tom_roush.pdfbox.a.i.dS, false) == true) goto L6;
        r5.a(com.tom_roush.pdfbox.a.i.bx, null);
    L6:
        r5.a(com.tom_roush.pdfbox.a.i.jc, r1.getWidth());
        r5.a(com.tom_roush.pdfbox.a.i.dA, r1.getHeight());
        if (r5.m(com.tom_roush.pdfbox.a.i.bd) == false) goto L9;
    L11:
        return r1;
    L9:
        if (Build.VERSION.SDK_INT <= 26) goto L11;
        r4.a(new com.tom_roush.pdfbox.pdmodel.graphics.b.g(r1.getColorSpace()));
    L13:
        throw new MissingImageReaderException("Cannot read JPX image: JP2Android is not installed.");
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r7, OutputStream r8, com.tom_roush.pdfbox.a.d r9, int r10) {
        return a(r7, r8, r9, r10, h.f16105a);
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r10, OutputStream r11, com.tom_roush.pdfbox.a.d r12, int r13, h r14) {
        i r15 = new i(new com.tom_roush.pdfbox.a.d());
        r15.a().a(r12);
        Bitmap r1 = a(r10, r14, r15);
        int r9 = r1.getWidth() * r1.getHeight();
        int[] r16 = new int[r9];
        r1.getPixels(r16, 0, r1.getWidth(), 0, 0, r1.getWidth(), r1.getHeight());
        byte[] r17 = new byte[3072];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r9) goto L8;
        if ((r3 + 3) < 3072) goto L7;
        r11.write(r17, 0, r3);
        r3 = 0;
    L7:
        int r4 = r16[r2];
        r17[r3] = (byte) Color.red(r4);
        r17[r3 + 1] = (byte) Color.green(r4);
        r17[r3 + 2] = (byte) Color.blue(r4);
        r3 = r3 + 3;
        r2 = r2 + 1;
        goto L3
    L8:
        r11.write(r17, 0, r3);
        return r15;
    }
}
