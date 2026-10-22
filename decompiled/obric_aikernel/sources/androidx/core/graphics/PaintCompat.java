package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udfffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = null;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static boolean hasGlyph(Paint r10, String r11) {
            return r10.hasGlyph(r11);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setBlendMode(Paint r10, Object r11) {
            r10.setBlendMode((BlendMode) r11);
        }
    }

    static {
        sRectThreadLocal = new ThreadLocal();
    }

    private PaintCompat() {
    }

    public static boolean hasGlyph(@NonNull Paint r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        int r12 = r11.length();
        if (r12 == 1) goto L9;
    L11:
        float r13 = r10.measureText(TOFU_STRING);
        float r14 = r10.measureText(EM_STRING);
        float r15 = r10.measureText(r11);
        float r16 = 0.0f;
        if (r15 != 0.0f) goto L15;
        return false;
    L15:
        if (r11.codePointCount(0, r11.length()) <= 1) goto L26;
        if (r15 <= (r14 * 2.0f)) goto L19;
        return false;
    L19:
        int r17 = 0;
    L20:
        if (r17 >= r12) goto L23;
        int r18 = Character.charCount(r11.codePointAt(r17)) + r17;
        r16 = r16 + r10.measureText(r11, r17, r18);
        r17 = r18;
        goto L20
    L23:
        if (r15 < r16) goto L26;
        return false;
    L26:
        if (r15 == r13) goto L28;
        return true;
    L28:
        Pair<Rect, Rect> r19 = obtainEmptyRects();
        r10.getTextBounds(TOFU_STRING, 0, 2, r19.first);
        r10.getTextBounds(r11, 0, r12, r19.second);
        return !r19.first.equals(r19.second);
    L9:
        if (Character.isWhitespace(r11.charAt(0)) == false) goto L11;
        return true;
    L5:
        return Api23Impl.hasGlyph(r10, r11);
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        ThreadLocal<Pair<Rect, Rect>> r10 = sRectThreadLocal;
        Pair<Rect, Rect> r11 = r10.get();
        if (r11 != null) goto L5;
        Pair<Rect, Rect> r12 = new Pair(new Rect(), new Rect());
        r10.set(r12);
        return r12;
    L5:
        r11.first.setEmpty();
        r11.second.setEmpty();
        return r11;
    }

    public static boolean setBlendMode(@NonNull Paint r10, @Nullable BlendModeCompat r11) {
        PorterDuffXfermode r12 = null;
        Object r13 = null;
        if (Build.VERSION.SDK_INT < 29) goto L8;
        if (r11 == null) goto L6;
        r13 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r11);
    L6:
        Api29Impl.setBlendMode(r10, r13);
        return true;
    L8:
        if (r11 == null) goto L17;
        PorterDuff.Mode r14 = BlendModeUtils.obtainPorterDuffFromCompat(r11);
        if (r14 == null) goto L12;
        r12 = new PorterDuffXfermode(r14);
    L12:
        r10.setXfermode(r12);
        if (r14 != null) goto L19;
        return false;
    L19:
        return true;
    L17:
        r10.setXfermode(null);
        return true;
    }
}
