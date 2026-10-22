package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {

    @RequiresApi(27)
    public static class Api27Impl {
        private Api27Impl() {
        }

        @DoNotInline
        public static Bitmap copyBitmapIfHardware(Bitmap r5) {
            if (r5.getConfig() != Bitmap.Config.HARDWARE) goto L6;
            Bitmap.Config r10 = Bitmap.Config.ARGB_8888;
            return r5.copy(Api31Impl.getHardwareBitmapConfig(r5), true);
        L6:
            return r5;
        }

        @DoNotInline
        public static Bitmap createBitmapWithSourceColorspace(int r5, int r10, Bitmap r11, boolean r12) {
            Bitmap.Config r13 = r11.getConfig();
            ColorSpace r14 = r11.getColorSpace();
            ColorSpace r15 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r12 == false) goto L8;
            if (r11.getColorSpace().equals(r15) == true) goto L8;
            r13 = Bitmap.Config.RGBA_F16;
            r14 = r15;
        L11:
            return Bitmap.createBitmap(r5, r10, r13, r11.hasAlpha(), r14);
        L8:
            if (r11.getConfig() != Bitmap.Config.HARDWARE) goto L11;
            Bitmap.Config r16 = Bitmap.Config.ARGB_8888;
            r13 = Api31Impl.getHardwareBitmapConfig(r11);
            goto L11
        }

        @DoNotInline
        public static boolean isAlreadyF16AndLinear(Bitmap r5) {
            ColorSpace r10 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r5.getConfig() == Bitmap.Config.RGBA_F16) goto L5;
        L7:
            return false;
        L5:
            if (r5.getColorSpace().equals(r10) == false) goto L7;
            return true;
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setPaintBlendMode(Paint r5) {
            r5.setBlendMode(BlendMode.SRC);
        }
    }

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static Bitmap.Config getHardwareBitmapConfig(Bitmap r5) {
            if (r5.getHardwareBuffer().getFormat() != 22) goto L7;
            return Bitmap.Config.RGBA_F16;
        L7:
            return Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    @NonNull
    public static Bitmap createScaledBitmap(@NonNull Bitmap r20, int r21, int r22, @Nullable Rect r23, boolean r24) {
        if (r21 <= 0) goto L128;
        if (r22 <= 0) goto L128;
        if (r23 != null) goto L7;
    L19:
        Bitmap r5 = Api27Impl.copyBitmapIfHardware(r20);
        if (r23 == null) goto L22;
        int r10 = r23.width();
    L23:
        if (r23 == null) goto L25;
        int r11 = r23.height();
    L26:
        float r12 = r21 / r10;
        float r13 = r22 / r11;
        if (r23 == null) goto L29;
        int r14 = r23.left;
    L30:
        if (r23 == null) goto L32;
        int r15 = r23.top;
    L34:
        if (r14 != 0) goto L46;
        if (r15 != 0) goto L46;
        if (r21 != r20.getWidth()) goto L46;
        if (r22 != r20.getHeight()) goto L46;
        if (r20.isMutable() == false) goto L45;
        if (r20 != r5) goto L45;
        return r20.copy(r20.getConfig(), true);
    L45:
        return r5;
    L46:
        Paint r16 = new Paint(1);
        r16.setFilterBitmap(true);
        Api29Impl.setPaintBlendMode(r16);
        if (r10 != r21) goto L51;
        if (r11 != r22) goto L51;
        Bitmap r17 = Bitmap.createBitmap(r21, r22, r5.getConfig());
        new Canvas(r17).drawBitmap(r5, -r14, -r15, r16);
        return r17;
    L51:
        double r18 = Math.log(2.0d);
        if (r12 <= 1.0f) goto L55;
        double r19 = Math.ceil(Math.log(r12) / r18);
    L54:
        int r25 = (int) r19;
        if (r13 <= 1.0f) goto L60;
        double r26 = Math.ceil(Math.log(r13) / r18);
    L59:
        int r27 = (int) r26;
        if (r24 == true) goto L63;
    L71:
        Bitmap r28 = null;
        int r110 = r14;
        int r111 = 0;
    L72:
        Rect r112 = new Rect(r110, r15, r10, r11);
        Rect r29 = new Rect();
        int r113 = r25;
        int r114 = r27;
    L73:
        if (r113 != 0) goto L80;
        if (r114 != 0) goto L80;
        if (r28 == r20) goto L79;
        if (r28 == null) goto L79;
        r28.recycle();
    L79:
        return r5;
    L80:
        if (r113 >= 0) goto L82;
        r113 = r113 + 1;
    L84:
        if (r114 >= 0) goto L86;
        r114 = r114 + 1;
    L88:
        Bitmap r115 = r5;
        Paint r116 = r16;
        r29.set(0, 0, sizeAtStep(r10, r21, r113, r25), sizeAtStep(r11, r22, r114, r27));
        if (r113 != 0) goto L92;
        if (r114 != 0) goto L92;
        boolean r30 = true;
    L93:
        if (r28 != null) goto L95;
    L99:
        boolean r117 = false;
    L100:
        if (r28 == null) goto L110;
        if (r28 == r20) goto L110;
        if (r24 == true) goto L104;
    L105:
        if (r30 == false) goto L109;
        if (r117 == false) goto L110;
        if (r111 != 0) goto L110;
    L109:
        r5 = r28;
    L126:
        new Canvas(r5).drawBitmap(r115, r112, r29, r116);
        r112.set(r29);
        r28 = r115;
        r16 = r116;
        goto L73
    L104:
        if (Api27Impl.isAlreadyF16AndLinear(r28) == true) goto L105;
    L110:
        if (r28 == r20) goto L113;
        if (r28 == null) goto L113;
        r28.recycle();
    L113:
        if (r113 <= 0) goto L115;
        int r31 = r111;
    L116:
        int r32 = sizeAtStep(r10, r21, r31, r25);
        if (r114 <= 0) goto L119;
        int r118 = r111;
    L120:
        int r119 = sizeAtStep(r11, r22, r118, r27);
        if (r24 == false) goto L124;
        if (r30 == true) goto L124;
        boolean r33 = true;
    L125:
        r5 = Api27Impl.createBitmapWithSourceColorspace(r32, r119, r20, r33);
    L124:
        r33 = false;
        goto L125
    L119:
        r118 = r114;
        goto L120
    L115:
        r31 = r113;
        goto L116
    L95:
        if (r28.getWidth() != r21) goto L99;
        if (r28.getHeight() != r22) goto L99;
        r117 = true;
    L92:
        r30 = false;
        goto L93
    L86:
        if (r114 <= 0) goto L88;
        r114 = r114 - 1;
        goto L88
    L82:
        if (r113 <= 0) goto L84;
        r113 = r113 - 1;
        goto L84
    L63:
        if (Api27Impl.isAlreadyF16AndLinear(r20) == true) goto L71;
        if (r25 <= 0) goto L66;
        int r34 = sizeAtStep(r10, r21, 1, r25);
    L67:
        if (r27 <= 0) goto L69;
        int r120 = sizeAtStep(r11, r22, 1, r27);
    L70:
        Bitmap r35 = Api27Impl.createBitmapWithSourceColorspace(r34, r120, r20, true);
        new Canvas(r35).drawBitmap(r5, -r14, -r15, r16);
        r111 = 1;
        r15 = 0;
        r110 = 0;
        r28 = r5;
        r5 = r35;
        goto L72
    L69:
        r120 = r11;
        goto L70
    L66:
        r34 = r10;
        goto L67
    L60:
        r26 = Math.floor(Math.log(r13) / r18);
        goto L59
    L55:
        r19 = Math.floor(Math.log(r12) / r18);
        goto L54
    L32:
        r15 = 0;
        goto L34
    L29:
        r14 = 0;
        goto L30
    L25:
        r11 = r20.getHeight();
        goto L26
    L22:
        r10 = r20.getWidth();
        goto L23
    L7:
        if (r23.isEmpty() == true) goto L18;
        if (r23.left < 0) goto L18;
        if (r23.right > r20.getWidth()) goto L18;
        if (r23.top < 0) goto L18;
        if (r23.bottom <= r20.getHeight()) goto L19;
    L18:
        throw new IllegalArgumentException("srcRect must be contained by srcBm!");
    L128:
        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }

    public static int getAllocationByteCount(@NonNull Bitmap r5) {
        return r5.getAllocationByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap r5) {
        return r5.hasMipMap();
    }

    public static void setHasMipMap(@NonNull Bitmap r5, boolean r10) {
        r5.setHasMipMap(r10);
    }

    @VisibleForTesting
    public static int sizeAtStep(int r5, int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        return r10;
    L5:
        if (r11 <= 0) goto L9;
        return r5 * (1 << (r12 - r11));
    L9:
        return r10 << ((-r11) - 1);
    }
}
