package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import io.noties.markwon.core.spans.k;
import io.noties.markwon.core.spans.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends Prism4jThemeBase {
    public final int b;

    @Override // etc.d
    public final void c() {
    }

    public a() {
        this.b = 0;
    }

    @Override // etc.d
    public final int a() {
        return this.b;
    }

    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    public final void d(String r3, String r4, String r5, int r6, SpannableStringBuilder r7, int r8, int r9) {
        if ("css".equals(r3) == false) goto L9;
        if (Prism4jThemeBase.e("string", r4, r5) == false) goto L9;
        r7.setSpan(new ForegroundColorSpan(-6656454), r8, r9, 33);
        r7.setSpan(new BackgroundColorSpan(-2130706433), r8, r9, 33);
        return;
    L9:
        if (Prism4jThemeBase.e("namespace", r4, r5) == false) goto L11;
        r6 = (r6 & 16777215) | (((int) 179.0f) << 24);
    L11:
        r7.setSpan(new ForegroundColorSpan(r6), r8, r9, 33);
        if (Prism4jThemeBase.e("important", r4, r5) == false) goto L14;
    L15:
        r7.setSpan(new t(), r8, r9, 33);
    L17:
        if (Prism4jThemeBase.e("italic", r4, r5) == false) goto L20;
        r7.setSpan(new k(), r8, r9, 33);
        return;
    L20:
        return;
    L14:
        if (Prism4jThemeBase.e("bold", r4, r5) == false) goto L17;
        goto L15
    }
}
