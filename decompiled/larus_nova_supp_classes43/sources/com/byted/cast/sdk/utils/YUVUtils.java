package com.byted.cast.sdk.utils;

import android.graphics.Bitmap;
import android.media.Image;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class YUVUtils {
    public YUVUtils() {
    }

    public static byte[] convertToNV21(Image r10) {
        int r0 = r10.getWidth();
        int r1 = r10.getHeight();
        Image.Plane[] r11 = r10.getPlanes();
        ByteBuffer r12 = r11[0].getBuffer();
        int r13 = r11[0].getPixelStride();
        Bitmap r14 = Bitmap.createBitmap((int) (r0 + ((r11[0].getRowStride() - (r13 * r0)) / r13)), r1, Bitmap.Config.ARGB_8888);
        r14.copyPixelsFromBuffer(r12);
        byte[] r15 = getNV21(r0, r1, r14);
        r14.recycle();
        r10.close();
        return r15;
    }

    public static byte[] getNV21(int r10, int r11, Bitmap r12) {
        int r0 = r10 * r11;
        int[] r13 = new int[r0];
        r12.getPixels(r13, 0, r10, 0, 0, r10, r11);
        byte[] r1 = new byte[r0 + ((((int) Math.ceil(((double) r11) / 2.0d)) * 2) * ((int) Math.ceil(((double) r10) / 2.0d)))];
        encodeYUV420SP(r1, r13, r10, r11);
        r12.recycle();
        return r1;
    }

    public static void encodeYUV420SP(byte[] r15, int[] r16, int r17, int r18) {
        int r10 = r17 * r18;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r11 >= r18) goto L29;
        int r14 = 0;
    L5:
        if (r14 >= r17) goto L28;
        int r19 = r16[r13];
        int r20 = (16711680 & r19) >> 16;
        int r110 = (65280 & r19) >> 8;
        int r111 = 255;
        int r21 = r19 & 255;
        int r112 = (((((r20 * 66) + (r110 * 129)) + (r21 * 25)) + 128) >> 8) + 16;
        int r113 = (((((r20 * (-38)) - (r110 * 74)) + (r21 * 112)) + 128) >> 8) + 128;
        int r22 = (((((r20 * 112) - (r110 * 94)) - (r21 * 18)) + 128) >> 8) + 128;
        int r23 = r12 + 1;
        if (r112 >= 0) goto L9;
        r112 = 0;
    L11:
        r15[r12] = (byte) r112;
        if ((r11 % 2) != 0) goto L27;
        if ((r13 % 2) != 0) goto L27;
        int r24 = r10 + 1;
        if (r22 >= 0) goto L18;
        r22 = 0;
    L20:
        r15[r10] = (byte) r22;
        r10 = r24 + 1;
        if (r113 >= 0) goto L23;
        r111 = 0;
    L26:
        r15[r24] = (byte) r111;
        goto L27
    L23:
        if (r113 > 255) goto L26;
        r111 = r113;
        goto L26
    L18:
        if (r22 <= 255) goto L20;
        r22 = 255;
    L27:
        r13 = r13 + 1;
        r14 = r14 + 1;
        r12 = r23;
        goto L5
    L9:
        if (r112 <= 255) goto L11;
        r112 = 255;
        goto L11
    L28:
        r11 = r11 + 1;
        goto L3
    }
}
