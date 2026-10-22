package com.facebook.imagepipeline.transcoder;

import android.util.Log;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DownsampleUtil {
    public static int a(RotationOptions r17, ResizeOptions r18, EncodedImage r19, int r20) {
        int r5 = r19.f8179c;
        int r10 = 1;
        if (r5 < 0) goto L75;
        int r11 = r19.e;
        if (r11 < 0) goto L75;
        int r12 = r19.f;
        if (r12 < 0) goto L75;
        if (r5 < 0) goto L74;
        if (r11 < 0) goto L74;
        if (r12 < 0) goto L74;
        int r13 = 2;
        if (r18 != null) goto L14;
    L46:
        float r14 = 1.0f;
    L47:
        r19.g();
        if (r19.f8178b != DefaultImageFormats.f7962a) goto L56;
        if (r14 > 0.6666667f) goto L61;
    L52:
        r10 = r13;
        r13 = r10 * 2;
        double r15 = 1.0d / ((double) r13);
        if (((r15 * 0.3333333432674408d) + r15) > r14) goto L52;
    L61:
        r19.g();
        int r16 = r19.f;
        r19.g();
        int r21 = Math.max(r16, r19.e);
        if (r18 == null) goto L64;
        float r22 = r18.f8053c;
    L66:
        if ((r21 / r10) <= r22) goto L71;
        r19.g();
        if (r19.f8178b == DefaultImageFormats.f7962a) goto L69;
        r10 = r10 + 1;
        goto L66
    L69:
        r10 = r10 * 2;
        goto L66
    L71:
        return r10;
    L64:
        r22 = r20;
        goto L66
    L56:
        if (r14 > 0.6666667f) goto L61;
    L58:
        double r23 = r13;
        if ((((1.0d / (Math.pow(r23, 2.0d) - r23)) * 0.3333333432674408d) + (1.0d / r23)) <= r14) goto L60;
        r13 = r13 + 1;
        goto L58
    L60:
        r10 = r13 - 1;
        goto L61
    L14:
        if (r18.f8052b <= 0) goto L46;
        if (r18.f8051a <= 0) goto L46;
        r19.g();
        if (r19.e == 0) goto L46;
        r19.g();
        if (r19.f == 0) goto L46;
        boolean r24 = false;
        if (r17.f8055a != (-1)) goto L33;
        r19.g();
        int r25 = r19.f8179c;
        if (r25 == 0) goto L34;
        if (r25 == 90) goto L34;
        if (r25 == 180) goto L34;
        if (r25 == 270) goto L34;
        throw new IllegalArgumentException();
    L34:
        if (r25 == 90) goto L36;
        if (r25 == 270) goto L36;
    L37:
        if (r24 == false) goto L39;
        r19.g();
        int r26 = r19.f;
    L40:
        if (r24 == false) goto L42;
        r19.g();
        int r27 = r19.e;
    L43:
        float r28 = r18.f8051a / r26;
        float r29 = r18.f8052b / r27;
        r14 = Math.max(r28, r29);
        Object[] r30 = {Integer.valueOf(r18.f8051a), Integer.valueOf(r18.f8052b), Integer.valueOf(r26), Integer.valueOf(r27), Float.valueOf(r28), Float.valueOf(r29), Float.valueOf(r14)};
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L47;
        Log.println(2, FLogDefaultLoggingDelegate.a("DownsampleUtil"), String.format(null, "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", r30));
        goto L47
    L42:
        r19.g();
        r27 = r19.f;
        goto L43
    L39:
        r19.g();
        r26 = r19.e;
    L36:
        r24 = true;
        goto L37
    L33:
        r25 = 0;
    L74:
        throw new IllegalArgumentException();
    L75:
        return 1;
    }
}
