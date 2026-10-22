package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.c;
import com.google.zxing.qrcode.encoder.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public b() {
    }

    private static com.google.zxing.common.b a(f r9, int r10, int r11, int r12) {
        com.google.zxing.qrcode.encoder.b r13 = r9.a();
        if (r13 == null) goto L15;
        int r0 = r13.b();
        int r1 = r13.a();
        int r14 = r12 * 2;
        int r2 = r0 + r14;
        int r15 = r14 + r1;
        int r16 = Math.max(r10, r2);
        int r17 = Math.max(r11, r15);
        int r18 = Math.min(r16 / r2, r17 / r15);
        int r3 = (r16 - (r0 * r18)) / 2;
        int r4 = (r17 - (r1 * r18)) / 2;
        com.google.zxing.common.b r5 = new com.google.zxing.common.b(r16, r17);
        int r19 = 0;
    L5:
        if (r19 >= r1) goto L13;
        int r6 = 0;
        int r7 = r3;
    L7:
        if (r6 >= r0) goto L12;
        if (r13.a(r6, r19) != 1) goto L11;
        r5.a(r7, r4, r18, r18);
    L11:
        r6 = r6 + 1;
        r7 = r7 + r18;
        goto L7
    L12:
        r19 = r19 + 1;
        r4 = r4 + r18;
        goto L5
    L13:
        return r5;
    L15:
        throw new IllegalStateException();
    }

    public com.google.zxing.common.b a(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == true) goto L23;
        if (r3 != BarcodeFormat.QR_CODE) goto L21;
        if (r4 < 0) goto L19;
        if (r5 < 0) goto L19;
        ErrorCorrectionLevel r7 = ErrorCorrectionLevel.L;
        int r8 = 4;
        if (r1 == null) goto L17;
        if (r1.containsKey(EncodeHintType.ERROR_CORRECTION) == false) goto L14;
        r7 = ErrorCorrectionLevel.valueOf(r1.get(EncodeHintType.ERROR_CORRECTION).toString());
    L14:
        if (r1.containsKey(EncodeHintType.MARGIN) == false) goto L17;
        r8 = Integer.parseInt(r1.get(EncodeHintType.MARGIN).toString());
    L17:
        return a(c.a(r2, r7, r1), r4, r5, r8);
    L19:
        throw new IllegalArgumentException("Requested dimensions are too small: " + r4 + 'x' + r5);
    L21:
        throw new IllegalArgumentException("Can only encode QR_CODE, but got " + r3);
    L23:
        throw new IllegalArgumentException("Found empty contents");
    }
}
