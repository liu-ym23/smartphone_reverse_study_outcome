package com.lynx.canvas.capi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LoaderServiceHelper {
    public LoaderServiceHelper() {
    }

    public static BitmapDecodeResult decodeImageSync(byte[] r3) {
        Bitmap r4 = BitmapFactory.decodeByteArray(r3, 0, r3.length);
        if (r4 == null) goto L6;
        ByteBuffer r0 = ByteBuffer.allocateDirect(r4.getByteCount());
        r4.copyPixelsToBuffer(r0);
        return new BitmapDecodeResult(r0, r4.getWidth(), r4.getHeight());
    L6:
        return null;
    }

    public static byte[] encodeBitmapSync(ByteBuffer r2, int r3, int r4, int r5, float r6) {
        if (r5 != 0) goto L6;
        Bitmap.CompressFormat r7 = Bitmap.CompressFormat.PNG;
    L8:
        Bitmap r1 = Bitmap.createBitmap(r3, r4, Bitmap.Config.ARGB_8888);
        r1.copyPixelsFromBuffer(r2);
        ByteArrayOutputStream r8 = new ByteArrayOutputStream(((r3 * r4) / 4) + 256);
        if (r1.compress(r7, Math.round(r6 * 100.0f), r8) == true) goto L11;
    L12:
        return null;
    L11:
        return r8.toByteArray();
    L6:
        if (r5 != 1) goto L12;
        r7 = Bitmap.CompressFormat.JPEG;
        goto L8
    }
}
