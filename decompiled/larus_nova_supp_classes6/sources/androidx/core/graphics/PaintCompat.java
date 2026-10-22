package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udfffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = null;

    static {
        sRectThreadLocal = new ThreadLocal();
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        ThreadLocal<Pair<Rect, Rect>> r0 = sRectThreadLocal;
        Pair<Rect, Rect> r1 = r0.get();
        if (r1 != null) goto L5;
        Pair<Rect, Rect> r2 = new Pair(new Rect(), new Rect());
        r0.set(r2);
        return r2;
    L5:
        ((Rect) r1.first).setEmpty();
        ((Rect) r1.second).setEmpty();
        return r1;
    }

    private PaintCompat() {
    }

    public static boolean hasGlyph(Paint r9, String r10) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        int r0 = r10.length();
        if (r0 == 1) goto L9;
    L11:
        float r4 = r9.measureText(TOFU_STRING);
        float r5 = r9.measureText(EM_STRING);
        float r6 = r9.measureText(r10);
        float r7 = 0.0f;
        if (r6 != 0.0f) goto L15;
        return false;
    L15:
        if (r10.codePointCount(0, r10.length()) <= 1) goto L26;
        if (r6 <= (r5 * 2.0f)) goto L19;
        return false;
    L19:
        int r8 = 0;
    L20:
        if (r8 >= r0) goto L23;
        int r11 = Character.charCount(r10.codePointAt(r8)) + r8;
        r7 = r7 + r9.measureText(r10, r8, r11);
        r8 = r11;
        goto L20
    L23:
        if (r6 < r7) goto L26;
        return false;
    L26:
        if (r6 == r4) goto L28;
        return true;
    L28:
        Pair<Rect, Rect> r12 = obtainEmptyRects();
        r9.getTextBounds(TOFU_STRING, 0, 2, (Rect) r12.first);
        r9.getTextBounds(r10, 0, r0, (Rect) r12.second);
        return !((Rect) r12.first).equals(r12.second);
    L9:
        if (Character.isWhitespace(r10.charAt(0)) == false) goto L11;
        return true;
    L5:
        return Api23Impl.hasGlyph(r9, r10);
    }

    public static boolean setBlendMode(Paint r4, BlendModeCompat r5) {
        PorterDuffXfermode r3 = null;
        Object r6 = null;
        if (Build.VERSION.SDK_INT < 29) goto L8;
        if (r5 == null) goto L6;
        r6 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r5);
    L6:
        Api29Impl.setBlendMode(r4, r6);
        return true;
    L8:
        if (r5 == null) goto L17;
        PorterDuff.Mode r7 = BlendModeUtils.obtainPorterDuffFromCompat(r5);
        if (r7 == null) goto L12;
        r3 = new PorterDuffXfermode(r7);
    L12:
        r4.setXfermode(r3);
        if (r7 != null) goto L19;
        return false;
    L19:
        return true;
    L17:
        r4.setXfermode(null);
        return true;
    }
}
