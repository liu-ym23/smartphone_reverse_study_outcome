package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = null;
    private final TextPaint mTextPaint;

    static {
        sStringBuilder = new ThreadLocal();
    }

    DefaultGlyphChecker() {
        TextPaint r0 = new TextPaint();
        this.mTextPaint = r0;
        r0.setTextSize(10.0f);
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> r0 = sStringBuilder;
        if (r0.get() != null) goto L6;
        r0.set(new StringBuilder());
    L6:
        return (StringBuilder) ZeusTransformUtils.preCheckCast(r0.get(), StringBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(CharSequence r4, int r5, int r6, int r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L5;
    L7:
        StringBuilder r9 = getStringBuilder();
        r9.setLength(0);
    L8:
        if (r5 >= r6) goto L11;
        r9.append(r8.charAt(r5));
        r5 = r5 + 1;
        goto L8
    L11:
        return PaintCompat.hasGlyph(this.mTextPaint, r9.toString());
    L5:
        if (r7 <= Build.VERSION.SDK_INT) goto L7;
        return false;
    }
}
