package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.Rect;
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
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static boolean hasGlyph(Paint r5, String r10) {
            return r5.hasGlyph(r10);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void setBlendMode(Paint r5, Object r10) {
            r5.setBlendMode((BlendMode) r10);
        }
    }

    static {
        sRectThreadLocal = new ThreadLocal();
    }

    private PaintCompat() {
    }

    public static boolean hasGlyph(@NonNull Paint r5, @NonNull String r10) {
        return Api23Impl.hasGlyph(r5, r10);
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        ThreadLocal<Pair<Rect, Rect>> r5 = sRectThreadLocal;
        Pair<Rect, Rect> r10 = r5.get();
        if (r10 != null) goto L5;
        Pair<Rect, Rect> r11 = new Pair(new Rect(), new Rect());
        r5.set(r11);
        return r11;
    L5:
        r10.first.setEmpty();
        r10.second.setEmpty();
        return r10;
    }

    public static boolean setBlendMode(@NonNull Paint r5, @Nullable BlendModeCompat r10) {
        if (r10 == null) goto L4;
        Object r11 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r10);
    L5:
        Api29Impl.setBlendMode(r5, r11);
        return true;
    L4:
        r11 = null;
        goto L5
    }
}
