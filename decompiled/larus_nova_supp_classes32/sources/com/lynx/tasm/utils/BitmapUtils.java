package com.lynx.tasm.utils;

import android.graphics.Bitmap;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BitmapUtils {
    public BitmapUtils() {
    }

    public static String bitmapToBase64WithQuality(Bitmap r2, int r3) {
        return bitmapToBase64(r2, Bitmap.CompressFormat.JPEG, r3, 2);
    }

    public static String bitmapToFormattedBase64(Bitmap r4, int r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r0 = r4.getWidth();
        int r1 = r4.getHeight();
        if (r0 > 600) goto L10;
        if (r1 > 600) goto L10;
        Bitmap r2 = r4;
    L11:
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();
        r2.compress(Bitmap.CompressFormat.JPEG, Math.max(r5, 30), r3);
        byte[] r6 = r3.toByteArray();
        r3.close();     // Catch: Exception -> L14
    L16:
        if (r2 == r4) goto L19;
        r2.recycle();
    L19:
        return "data:image/jpeg;base64," + Base64.encodeToString(r6, 2);
    L14:
        e = move-exception;
        e.printStackTrace();
    L10:
        float r7 = 600;
        float r8 = r0;
        float r9 = r1;
        float r10 = Math.min(r7 / r8, r7 / r9);
        r2 = Bitmap.createScaledBitmap(r4, Math.round(r8 * r10), Math.round(r9 * r10), true);
        goto L11
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:67108915), block:B:20:0x0033 */
    public static String bitmapToBase64(Bitmap r2, Bitmap.CompressFormat r3, int r4, int r5) {
        ByteArrayOutputStream r0 = null;
        if (r2 != null) goto L44;
        String r6 = null;
    L28:
        if (r0 == null) goto L34;
        r0.flush();     // Catch: IOException -> L31
        r0.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L34:
        return r6;
    L44:
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L9 IOException -> L11
        r2.compress(r3, r4, r1);     // Catch: IOException -> L7 Throwable -> L19
        r1.flush();     // Catch: IOException -> L7 Throwable -> L19
        r1.close();     // Catch: IOException -> L7 Throwable -> L19
        r6 = Base64.encodeToString(r1.toByteArray(), r5);     // Catch: IOException -> L7 Throwable -> L19
        r0 = r1;
    L7:
        e = e;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r1 == null) goto L46;
        r1.flush();     // Catch: IOException -> L17
        r1.close();     // Catch: IOException -> L17
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L46:
        return null;
    L11:
        e = e;
        r1 = null;
    L9:
        th = th;
    L21:
        if (r0 != null) goto L36;
    L26:
        throw th;
    L36:
        r0.flush();     // Catch: IOException -> L24
        r0.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r0 = r1;
        goto L21
    }
}
