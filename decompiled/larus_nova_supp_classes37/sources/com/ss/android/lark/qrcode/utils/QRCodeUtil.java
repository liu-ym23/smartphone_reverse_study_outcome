package com.ss.android.lark.qrcode.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.ss.android.lark.biz.core.api.ErrorCorrectionLevel;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.qrcode.zxing.BarcodeFormat;
import com.ss.android.lark.qrcode.zxing.EncodeHintType;
import d2c.b;
import f2c.a;
import java.util.EnumMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class QRCodeUtil {
    public QRCodeUtil() {
    }

    public static Point getScreenResolution(Context r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        Display r2 = ((WindowManager) r1.getSystemService("window")).getDefaultDisplay();
        Point r0 = new Point();
        r2.getSize(r0);
        return r0;
    }

    private static b updateBitMatrix(b r12, int r13) {
        int r0 = r13 * 2;
        int r1 = r12.a;
        int r2 = r12.b;
        int r3 = -1;
        int r5 = -1;
        int r6 = 0;
    L4:
        if (r6 >= r12.b) goto L35;
        int r7 = 0;
    L6:
        int r8 = r12.c;
        if (r7 >= r8) goto L33;
        int r9 = r12.d[(r8 * r6) + r7];
        if (r9 == 0) goto L32;
        if (r6 >= r2) goto L12;
        r2 = r6;
    L12:
        if (r6 <= r5) goto L14;
        r5 = r6;
    L14:
        int r10 = r7 * 32;
        if (r10 >= r1) goto L24;
        int r11 = 0;
    L18:
        if ((r9 << (31 - r11)) != 0) goto L20;
        r11 = r11 + 1;
        goto L18
    L20:
        int r14 = r11 + r10;
        if (r14 >= r1) goto L24;
        r1 = r14;
    L24:
        if ((r10 + 31) <= r3) goto L32;
        int r15 = 31;
    L27:
        if ((r9 >>> r15) != 0) goto L29;
        r15 = r15 - 1;
        goto L27
    L29:
        int r16 = r10 + r15;
        if (r16 <= r3) goto L32;
        r3 = r16;
    L32:
        r7 = r7 + 1;
        goto L6
    L33:
        r6 = r6 + 1;
        goto L4
    L35:
        if (r3 < r1) goto L39;
        if (r5 < r2) goto L39;
        int[] r17 = {r1, r2, (r3 - r1) + 1, (r5 - r2) + 1};
    L40:
        int r4 = r17[2] + r0;
        int r18 = r17[3] + r0;
        b r19 = new b(r4, r18);
        int r20 = r19.d.length;
        int r21 = 0;
    L41:
        if (r21 >= r20) goto L43;
        r19.d[r21] = 0;
        r21 = r21 + 1;
        goto L41
    L43:
        int r22 = r13;
    L45:
        if (r22 >= (r4 - r13)) goto L54;
        int r23 = r13;
    L48:
        if (r23 >= (r18 - r13)) goto L53;
        if (r12.a((r22 - r13) + r17[0], (r23 - r13) + r17[1]) == false) goto L52;
        int r24 = (r19.c * r23) + (r22 / 32);
        int[] r25 = r19.d;
        r25[r24] = r25[r24] | (1 << (r22 & 31));
    L52:
        r23 = r23 + 1;
        goto L48
    L53:
        r22 = r22 + 1;
        goto L45
    L54:
        return r19;
    L39:
        r17 = null;
        goto L40
    }

    private static Bitmap createBitmap(int r9, int r10, int[] r11) {
        Bitmap r0 = Bitmap.createBitmap(r9, r10, Bitmap.Config.ARGB_8888);
        r0.setPixels(r11, 0, r9, 0, 0, r9, r10);
        return r0;
    }

    private static Bitmap parseBitmapFromBitMatrix(b r9, int r10, int r11) {
        int r0 = r9.a;
        int r1 = r9.b;
        int[] r2 = new int[r0 * r1];
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L13;
        int r5 = r4 * r0;
        int r6 = 0;
    L5:
        if (r6 >= r0) goto L11;
        int r7 = r5 + r6;
        if (r9.a(r6, r4) == false) goto L9;
        int r8 = r10;
    L10:
        r2[r7] = r8;
        r6 = r6 + 1;
        goto L5
    L9:
        r8 = r11;
        goto L10
    L11:
        r4 = r4 + 1;
        goto L3
    L13:
        return createBitmap(r0, r1, r2);
    }

    public static Bitmap encode(String r1, int r2, int r3, int r4) {
        return encode(r1, r2, r3, r4, ErrorCorrectionLevel.L);
    }

    public static Bitmap encode(String r3, int r4, int r5, int r6, ErrorCorrectionLevel r7) {
        EnumMap r0 = new EnumMap(EncodeHintType.class);
        r0.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        r0.put(EncodeHintType.ERROR_CORRECTION, r7);
        return parseBitmapFromBitMatrix(updateBitMatrix(a.a(r3, BarcodeFormat.QR_CODE, r4, r5, r0), r6), FakePickerAvatarCreator.BLACK, -1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
