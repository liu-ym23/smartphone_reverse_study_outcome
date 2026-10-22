package o19;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import p19.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final Bitmap a(String r3, int r4, int r5, int r6, Map r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "url");
        FLogger.a.i("PicShareUtils", "generateQRCodeBitmap useCustomQrcode " + r8);
        if (r8 == false) goto L6;
        return b.a(r3, r4, r5, r6);
    L6:
        if (r3 != null) goto L33;
    L13:
        boolean r0 = true;
    L14:
        if (r0 == true) goto L31;
        if (r4 <= 0) goto L31;
        if (r5 <= 0) goto L31;
        nv7.b r9 = vv7.b.a(r3, BarcodeFormat.QR_CODE, r4, r5, r7);     // Catch: Exception -> L11
        Bitmap r10 = Bitmap.createBitmap(r4, r5, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L11
        int r1 = 0;
    L19:
        if (r1 >= r4) goto L38;
        int r2 = 0;
    L21:
        if (r2 >= r5) goto L28;
        if (r9.b(r1, r2) == false) goto L25;
        int r11 = r6;
    L26:
        r10.setPixel(r1, r2, r11);     // Catch: Exception -> L11
        r2 = r2 + 1;
        goto L21
    L25:
        r11 = 0;
    L11:
        e = move-exception;
        FLogger.a.e("generateQRCodeBitmap", "generateQRCodeBitmap: error ", e);
        goto L31
    L28:
        r1 = r1 + 1;
        goto L19
    L38:
        return r10;
    L31:
        return null;
    L33:
        if (r3.length() == 0) goto L13;
        r0 = false;
        goto L14
    }
}
