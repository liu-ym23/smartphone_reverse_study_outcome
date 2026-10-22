package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {

    static class Api17Impl {
        private Api17Impl() {
        }

        static boolean hasMipMap(Bitmap r0) {
            return r0.hasMipMap();
        }

        static void setHasMipMap(Bitmap r0, boolean r1) {
            r0.setHasMipMap(r1);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static int getAllocationByteCount(Bitmap r0) {
            return r0.getAllocationByteCount();
        }
    }

    static class Api27Impl {
        private Api27Impl() {
        }

        static Bitmap copyBitmapIfHardware(Bitmap r3) {
            if (r3.getConfig() != Bitmap.Config.HARDWARE) goto L9;
            Bitmap.Config r0 = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT < 31) goto L8;
            r0 = Api31Impl.getHardwareBitmapConfig(r3);
        L8:
            return r3.copy(r0, true);
        L9:
            return r3;
        }

        static Bitmap createBitmapWithSourceColorspace(int r3, int r4, Bitmap r5, boolean r6) {
            Bitmap.Config r0 = r5.getConfig();
            ColorSpace r1 = r5.getColorSpace();
            ColorSpace r2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r6 == false) goto L8;
            if (r5.getColorSpace().equals(r2) == true) goto L8;
            r0 = Bitmap.Config.RGBA_F16;
            r1 = r2;
        L13:
            return Bitmap.createBitmap(r3, r4, r0, r5.hasAlpha(), r1);
        L8:
            if (r5.getConfig() != Bitmap.Config.HARDWARE) goto L13;
            r0 = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT < 31) goto L13;
            r0 = Api31Impl.getHardwareBitmapConfig(r5);
            goto L13
        }

        static boolean isAlreadyF16AndLinear(Bitmap r3) {
            ColorSpace r0 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r3.getConfig() == Bitmap.Config.RGBA_F16) goto L5;
        L7:
            return false;
        L5:
            if (r3.getColorSpace().equals(r0) == false) goto L7;
            return true;
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setPaintBlendMode(Paint r1) {
            r1.setBlendMode(BlendMode.SRC);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Bitmap.Config getHardwareBitmapConfig(Bitmap r1) {
            if (r1.getHardwareBuffer().getFormat() != 22) goto L7;
            return Bitmap.Config.RGBA_F16;
        L7:
            return Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    public static Bitmap createScaledBitmap(Bitmap r22, int r23, int r24, Rect r25, boolean r26) {
        if (r23 <= 0) goto L142;
        if (r24 <= 0) goto L142;
        if (r25 == null) goto L20;
        if (r25.isEmpty() == true) goto L18;
        if (r25.left < 0) goto L18;
        if (r25.right > r22.getWidth()) goto L18;
        if (r25.top < 0) goto L18;
        if (r25.bottom <= r22.getHeight()) goto L20;
    L18:
        throw new IllegalArgumentException("srcRect must be contained by srcBm!");
    L20:
        if (Build.VERSION.SDK_INT < 27) goto L22;
        Bitmap r4 = Api27Impl.copyBitmapIfHardware(r22);
    L23:
        if (r25 == null) goto L25;
        int r6 = r25.width();
    L26:
        if (r25 == null) goto L28;
        int r7 = r25.height();
    L29:
        float r8 = r23 / r6;
        float r9 = r24 / r7;
        if (r25 == null) goto L32;
        int r11 = r25.left;
    L33:
        if (r25 == null) goto L35;
        int r3 = r25.top;
    L37:
        if (r11 != 0) goto L49;
        if (r3 != 0) goto L49;
        if (r23 != r22.getWidth()) goto L49;
        if (r24 != r22.getHeight()) goto L49;
        if (r22.isMutable() == false) goto L48;
        if (r22 != r4) goto L48;
        return r22.copy(r22.getConfig(), true);
    L48:
        return r4;
    L49:
        Paint r13 = new Paint(1);
        r13.setFilterBitmap(true);
        if (Build.VERSION.SDK_INT < 29) goto L52;
        Api29Impl.setPaintBlendMode(r13);
    L53:
        if (r6 != r23) goto L57;
        if (r7 != r24) goto L57;
        Bitmap r0 = Bitmap.createBitmap(r23, r24, r4.getConfig());
        new Canvas(r0).drawBitmap(r4, -r11, -r3, r13);
        return r0;
    L57:
        double r14 = Math.log(2.0d);
        int r18 = r11;
        double r10 = Math.log(r8) / r14;
        if (r8 <= 1.0f) goto L60;
        double r12 = Math.ceil(r10);
    L61:
        int r15 = (int) r12;
        if (r9 <= 1.0f) goto L64;
        double r16 = Math.ceil(Math.log(r9) / r14);
    L65:
        int r17 = (int) r16;
        Bitmap r19 = null;
        if (r26 == true) goto L68;
    L78:
        int r110 = r18;
        int r111 = 0;
    L79:
        Rect r112 = new Rect(r110, r3, r6, r7);
        Rect r5 = new Rect();
        int r113 = r15;
        int r114 = r17;
    L80:
        if (r113 != 0) goto L87;
        if (r114 != 0) goto L87;
        if (r19 == r22) goto L86;
        if (r19 == null) goto L86;
        r19.recycle();
    L86:
        return r4;
    L87:
        if (r113 >= 0) goto L89;
        r113 = r113 + 1;
    L91:
        if (r114 >= 0) goto L93;
        r114 = r114 + 1;
    L95:
        int r115 = r114;
        Paint r116 = r13;
        Rect r117 = r112;
        r5.set(0, 0, sizeAtStep(r6, r23, r113, r15), sizeAtStep(r7, r24, r115, r17));
        if (r113 != 0) goto L99;
        if (r115 != 0) goto L99;
        boolean r20 = true;
    L100:
        if (r19 != null) goto L102;
    L106:
        boolean r118 = false;
    L107:
        if (r19 == null) goto L121;
        if (r19 == r22) goto L121;
        if (r26 == false) goto L115;
        Rect r21 = r5;
        if (Build.VERSION.SDK_INT >= 27) goto L113;
    L116:
        if (r20 == false) goto L120;
        if (r118 == false) goto L122;
        if (r111 == 0) goto L120;
    L122:
        if (r19 == r22) goto L125;
        if (r19 == null) goto L125;
        r19.recycle();
    L125:
        if (r113 <= 0) goto L127;
        int r27 = r111;
    L128:
        int r28 = sizeAtStep(r6, r23, r27, r15);
        if (r115 <= 0) goto L131;
        int r119 = r111;
    L132:
        int r120 = sizeAtStep(r7, r24, r119, r17);
        if (Build.VERSION.SDK_INT < 27) goto L139;
        if (r26 == false) goto L137;
        if (r20 == true) goto L137;
        boolean r29 = true;
    L138:
        Bitmap r30 = Api27Impl.createBitmapWithSourceColorspace(r28, r120, r22, r29);
    L140:
        Rect r121 = r21;
        new Canvas(r30).drawBitmap(r4, r117, r121, r116);
        r117.set(r121);
        r114 = r115;
        Bitmap r210 = r4;
        r4 = r30;
        r5 = r121;
        r112 = r117;
        r13 = r116;
        r19 = r210;
    L137:
        r29 = false;
        goto L138
    L139:
        r30 = Bitmap.createBitmap(r28, r120, r4.getConfig());
        goto L140
    L131:
        r119 = r115;
        goto L132
    L127:
        r27 = r113;
    L120:
        r30 = r19;
        goto L140
    L113:
        if (Api27Impl.isAlreadyF16AndLinear(r19) == false) goto L122;
    L115:
        r21 = r5;
    L121:
        r21 = r5;
        goto L122
    L102:
        if (r19.getWidth() != r23) goto L106;
        if (r19.getHeight() != r24) goto L106;
        r118 = true;
    L99:
        r20 = false;
        goto L100
    L93:
        if (r114 <= 0) goto L95;
        r114 = r114 - 1;
        goto L95
    L89:
        if (r113 <= 0) goto L91;
        r113 = r113 - 1;
        goto L91
    L68:
        if (Build.VERSION.SDK_INT < 27) goto L78;
        if (Api27Impl.isAlreadyF16AndLinear(r22) == true) goto L78;
        if (r15 <= 0) goto L73;
        int r122 = sizeAtStep(r6, r23, 1, r15);
    L74:
        if (r17 <= 0) goto L76;
        int r123 = sizeAtStep(r7, r24, 1, r17);
    L77:
        Bitmap r124 = Api27Impl.createBitmapWithSourceColorspace(r122, r123, r22, true);
        new Canvas(r124).drawBitmap(r4, -r18, -r3, r13);
        r111 = 1;
        r3 = 0;
        r110 = 0;
        r19 = r4;
        r4 = r124;
        goto L79
    L76:
        r123 = r7;
        goto L77
    L73:
        r122 = r6;
        goto L74
    L64:
        r16 = Math.floor(Math.log(r9) / r14);
        goto L65
    L60:
        r12 = Math.floor(r10);
        goto L61
    L52:
        r13.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        goto L53
    L35:
        r3 = 0;
        goto L37
    L32:
        r11 = 0;
        goto L33
    L28:
        r7 = r22.getHeight();
        goto L29
    L25:
        r6 = r22.getWidth();
        goto L26
    L22:
        r4 = r22;
    L142:
        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }

    public static int getAllocationByteCount(Bitmap r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getAllocationByteCount(r2);
    L7:
        return r2.getByteCount();
    }

    public static boolean hasMipMap(Bitmap r2) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return Api17Impl.hasMipMap(r2);
    }

    public static void setHasMipMap(Bitmap r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setHasMipMap(r2, r3);
        return;
    }

    static int sizeAtStep(int r1, int r2, int r3, int r4) {
        if (r3 != 0) goto L5;
        return r2;
    L5:
        if (r3 <= 0) goto L9;
        return r1 * (1 << (r4 - r3));
    L9:
        return r2 << ((-r3) - 1);
    }
}
