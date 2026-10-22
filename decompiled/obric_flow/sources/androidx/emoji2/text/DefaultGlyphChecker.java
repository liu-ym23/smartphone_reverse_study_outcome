package androidx.emoji2.text;

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

    public DefaultGlyphChecker() {
        TextPaint r5 = new TextPaint();
        this.mTextPaint = r5;
        r5.setTextSize(10.0f);
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> r5 = sStringBuilder;
        if (r5.get() != null) goto L6;
        r5.set(new StringBuilder());
    L6:
        return r5.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(@NonNull CharSequence r5, int r10, int r11, int r12) {
        StringBuilder r13 = getStringBuilder();
        r13.setLength(0);
    L3:
        if (r10 >= r11) goto L6;
        r13.append(r5.charAt(r10));
        r10 = r10 + 1;
        goto L3
    L6:
        return PaintCompat.hasGlyph(this.mTextPaint, r13.toString());
    }
}
