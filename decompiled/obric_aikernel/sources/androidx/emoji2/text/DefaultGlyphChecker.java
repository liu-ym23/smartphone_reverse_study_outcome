package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PaintCompat;

/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RestrictTo({RestrictTo.Scope.LIBRARY})
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = null;
    private final TextPaint mTextPaint;

    static {
        sStringBuilder = new ThreadLocal();
    }

    DefaultGlyphChecker() {
        TextPaint r10 = new TextPaint();
        this.mTextPaint = r10;
        r10.setTextSize(10.0f);
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> r10 = sStringBuilder;
        if (r10.get() != null) goto L6;
        r10.set(new StringBuilder());
    L6:
        return r10.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(@NonNull CharSequence r10, int r11, int r12, int r13) {
        int r14 = Build.VERSION.SDK_INT;
        if (r14 >= 23) goto L6;
        if (r13 <= r14) goto L6;
        return false;
    L6:
        StringBuilder r15 = getStringBuilder();
        r15.setLength(0);
    L7:
        if (r11 >= r12) goto L10;
        r15.append(r10.charAt(r11));
        r11 = r11 + 1;
        goto L7
    L10:
        return PaintCompat.hasGlyph(this.mTextPaint, r15.toString());
    }
}
