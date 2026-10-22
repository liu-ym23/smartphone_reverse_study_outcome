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
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapCompat {

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static boolean hasMipMap(Bitmap r10) {
            return r10.hasMipMap();
        }

        @DoNotInline
        static void setHasMipMap(Bitmap r10, boolean r11) {
            r10.setHasMipMap(r11);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int getAllocationByteCount(Bitmap r10) {
            return r10.getAllocationByteCount();
        }
    }

    @RequiresApi(27)
    static class Api27Impl {
        private Api27Impl() {
        }

        @DoNotInline
        static Bitmap copyBitmapIfHardware(Bitmap r10) {
            if (r10.getConfig() != Bitmap.Config.HARDWARE) goto L9;
            Bitmap.Config r11 = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT < 31) goto L8;
            r11 = Api31Impl.getHardwareBitmapConfig(r10);
        L8:
            return r10.copy(r11, true);
        L9:
            return r10;
        }

        @DoNotInline
        static Bitmap createBitmapWithSourceColorspace(int r10, int r11, Bitmap r12, boolean r13) {
            Bitmap.Config r14 = r12.getConfig();
            ColorSpace r15 = r12.getColorSpace();
            ColorSpace r16 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r13 == false) goto L8;
            if (r12.getColorSpace().equals(r16) == true) goto L8;
            r14 = Bitmap.Config.RGBA_F16;
            r15 = r16;
        L13:
            return Bitmap.createBitmap(r10, r11, r14, r12.hasAlpha(), r15);
        L8:
            if (r12.getConfig() != Bitmap.Config.HARDWARE) goto L13;
            r14 = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT < 31) goto L13;
            r14 = Api31Impl.getHardwareBitmapConfig(r12);
            goto L13
        }

        @DoNotInline
        static boolean isAlreadyF16AndLinear(Bitmap r10) {
            ColorSpace r11 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r10.getConfig() == Bitmap.Config.RGBA_F16) goto L5;
        L7:
            return false;
        L5:
            if (r10.getColorSpace().equals(r11) == false) goto L7;
            return true;
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setPaintBlendMode(Paint r10) {
            r10.setBlendMode(BlendMode.SRC);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static Bitmap.Config getHardwareBitmapConfig(Bitmap r10) {
            if (r10.getHardwareBuffer().getFormat() != 22) goto L7;
            return Bitmap.Config.RGBA_F16;
        L7:
            return Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    @NonNull
    public static Bitmap createScaledBitmap(@NonNull Bitmap r21, int r22, int r23, @Nullable Rect r24, boolean r25) {
        if (r22 <= 0) goto L142;
        if (r23 <= 0) goto L142;
        if (r24 != null) goto L7;
    L19:
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 27) goto L22;
        Bitmap r11 = Api27Impl.copyBitmapIfHardware(r21);
    L23:
        if (r24 == null) goto L25;
        int r12 = r24.width();
    L26:
        if (r24 == null) goto L28;
        int r13 = r24.height();
    L29:
        float r14 = r22 / r12;
        float r15 = r23 / r13;
        if (r24 == null) goto L32;
        int r16 = r24.left;
    L33:
        if (r24 == null) goto L35;
        int r17 = r24.top;
    L37:
        if (r16 != 0) goto L49;
        if (r17 != 0) goto L49;
        if (r22 != r21.getWidth()) goto L49;
        if (r23 != r21.getHeight()) goto L49;
        if (r21.isMutable() == false) goto L48;
        if (r21 != r11) goto L48;
        return r21.copy(r21.getConfig(), true);
    L48:
        return r11;
    L49:
        Paint r18 = new Paint(1);
        r18.setFilterBitmap(true);
        if (r10 < 29) goto L52;
        Api29Impl.setPaintBlendMode(r18);
    L53:
        if (r12 != r22) goto L57;
        if (r13 != r23) goto L57;
        Bitmap r19 = Bitmap.createBitmap(r22, r23, r11.getConfig());
        new Canvas(r19).drawBitmap(r11, -r16, -r17, r18);
        return r19;
    L57:
        double r110 = Math.log(2.0d);
        double r111 = Math.log(r14) / r110;
        if (r14 <= 1.0f) goto L60;
        double r112 = Math.ceil(r111);
    L61:
        int r20 = (int) r112;
        if (r15 <= 1.0f) goto L64;
        double r113 = Math.ceil(Math.log(r15) / r110);
    L65:
        int r114 = (int) r113;
        Bitmap r115 = null;
        if (r25 == false) goto L78;
        if (r10 < 27) goto L78;
        if (Api27Impl.isAlreadyF16AndLinear(r21) == true) goto L78;
        if (r20 <= 0) goto L73;
        int r116 = sizeAtStep(r12, r22, 1, r20);
    L74:
        if (r114 <= 0) goto L76;
        int r117 = sizeAtStep(r13, r23, 1, r114);
    L77:
        Bitmap r118 = Api27Impl.createBitmapWithSourceColorspace(r116, r117, r21, true);
        Paint r119 = r18;
        new Canvas(r118).drawBitmap(r11, -r16, -r17, r119);
        int r120 = 1;
        r17 = 0;
        r16 = 0;
        r115 = r11;
        r11 = r118;
    L79:
        Rect r121 = new Rect(r16, r17, r12, r13);
        Rect r26 = new Rect();
        int r122 = r20;
        int r123 = r114;
    L80:
        if (r122 != 0) goto L87;
        if (r123 != 0) goto L87;
        if (r115 == r21) goto L86;
        if (r115 == null) goto L86;
        r115.recycle();
    L86:
        return r11;
    L87:
        if (r122 >= 0) goto L89;
        r122 = r122 + 1;
    L91:
        if (r123 >= 0) goto L93;
        r123 = r123 + 1;
    L95:
        int r27 = r123;
        Paint r28 = r119;
        Rect r124 = r121;
        r26.set(0, 0, sizeAtStep(r12, r22, r122, r20), sizeAtStep(r13, r23, r27, r114));
        if (r122 != 0) goto L99;
        if (r27 != 0) goto L99;
        boolean r29 = true;
    L100:
        if (r115 != null) goto L102;
    L106:
        boolean r125 = false;
    L107:
        if (r115 == null) goto L121;
        if (r115 == r21) goto L121;
        if (r25 == false) goto L115;
        Rect r126 = r26;
        if (Build.VERSION.SDK_INT >= 27) goto L113;
    L116:
        if (r29 == false) goto L120;
        if (r125 == false) goto L122;
        if (r120 == 0) goto L120;
    L122:
        if (r115 == r21) goto L125;
        if (r115 == null) goto L125;
        r115.recycle();
    L125:
        if (r122 <= 0) goto L127;
        int r30 = r120;
    L128:
        int r31 = sizeAtStep(r12, r22, r30, r20);
        if (r27 <= 0) goto L131;
        int r127 = r120;
    L132:
        int r128 = sizeAtStep(r13, r23, r127, r114);
        if (Build.VERSION.SDK_INT < 27) goto L139;
        if (r25 == false) goto L137;
        if (r29 == true) goto L137;
        boolean r32 = true;
    L138:
        Bitmap r33 = Api27Impl.createBitmapWithSourceColorspace(r31, r128, r21, r32);
    L140:
        Rect r129 = r126;
        new Canvas(r33).drawBitmap(r11, r124, r129, r28);
        r124.set(r129);
        r123 = r27;
        Bitmap r210 = r11;
        r11 = r33;
        r26 = r129;
        r121 = r124;
        r119 = r28;
        r115 = r210;
    L137:
        r32 = false;
        goto L138
    L139:
        r33 = Bitmap.createBitmap(r31, r128, r11.getConfig());
        goto L140
    L131:
        r127 = r27;
        goto L132
    L127:
        r30 = r122;
    L120:
        r33 = r115;
        goto L140
    L113:
        if (Api27Impl.isAlreadyF16AndLinear(r115) == false) goto L122;
    L115:
        r126 = r26;
    L121:
        r126 = r26;
        goto L122
    L102:
        if (r115.getWidth() != r22) goto L106;
        if (r115.getHeight() != r23) goto L106;
        r125 = true;
    L99:
        r29 = false;
        goto L100
    L93:
        if (r123 <= 0) goto L95;
        r123 = r123 - 1;
        goto L95
    L89:
        if (r122 <= 0) goto L91;
        r122 = r122 - 1;
        goto L91
    L76:
        r117 = r13;
        goto L77
    L73:
        r116 = r12;
    L78:
        r119 = r18;
        r120 = 0;
        goto L79
    L64:
        r113 = Math.floor(Math.log(r15) / r110);
        goto L65
    L60:
        r112 = Math.floor(r111);
        goto L61
    L52:
        r18.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        goto L53
    L35:
        r17 = 0;
        goto L37
    L32:
        r16 = 0;
        goto L33
    L28:
        r13 = r21.getHeight();
        goto L29
    L25:
        r12 = r21.getWidth();
        goto L26
    L22:
        r11 = r21;
        goto L23
    L7:
        if (r24.isEmpty() == true) goto L18;
        if (r24.left < 0) goto L18;
        if (r24.right > r21.getWidth()) goto L18;
        if (r24.top < 0) goto L18;
        if (r24.bottom <= r21.getHeight()) goto L19;
    L18:
        throw new IllegalArgumentException("srcRect must be contained by srcBm!");
    L142:
        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }

    public static int getAllocationByteCount(@NonNull Bitmap r10) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getAllocationByteCount(r10);
    L7:
        return r10.getByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap r10) {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        return Api17Impl.hasMipMap(r10);
    }

    public static void setHasMipMap(@NonNull Bitmap r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 17) goto L6;
        Api17Impl.setHasMipMap(r10, r11);
        return;
    }

    @VisibleForTesting
    public static int sizeAtStep(int r10, int r11, int r12, int r13) {
        if (r12 != 0) goto L5;
        return r11;
    L5:
        if (r12 <= 0) goto L9;
        return r10 * (1 << (r13 - r12));
    L9:
        return r11 << ((-r12) - 1);
    }
}
