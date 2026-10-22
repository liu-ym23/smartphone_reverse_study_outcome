package io.noties.markwon.ext.onetex;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.regex.Pattern;
import kotlin.text.StringsKt;
import uvc.b;
import zsc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n extends i {
    public final boolean e;
    public final Pattern f;

    @Override // zsc.i
    public final char d() {
        return '$';
    }

    @Override // zsc.i
    public final b b() {
        int r0 = this.d;
        String r1 = a(this.f);
        if (r1 != null) goto L8;
        com.larus.business.markdown.api.depend.d r2 = IMarkdownLoggerKt.a();
        if (r2 == null) goto L7;
        r2.e("md_parse", "error parse latex: raw: " + this.c + "; context: " + this.a + "; index: " + this.d + "; oldIndex: " + r0);
    L7:
        return null;
    L8:
        LatexMathNode r6 = new LatexMathNode();
        int r8 = 2;
        if (this.e == true) goto L11;
        int r5 = r1.length();
    L17:
        String r3 = r1.substring(r8, r5 - r8);
        com.larus.business.markdown.api.depend.d r7 = IMarkdownLoggerKt.a();
        if (r7 == null) goto L20;
        r7.i("md_parse", "latex: " + r3 + "; index: " + this.d + "; oldIndex: " + r0);
    L20:
        r6.h = r3;
        return r6;
    L11:
        if (StringsKt.startsWith$default(r1, "$$", false, 2, null) == true) goto L13;
    L15:
        r5 = r1.length();
        r8 = 1;
        goto L17
    L13:
        if (StringsKt.endsWith$default(r1, "$$", false, 2, null) == false) goto L15;
        r5 = r1.length();
        goto L17
    }

    public n(boolean r3, String r4) {
        this.e = r3;
        if (r4 == null) goto L7;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r4)) != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        Pattern r5 = PatternProtector.compile(r4);
    L13:
        this.f = r5;
        return;
    L10:
        if (r3 == false) goto L12;
        r5 = PatternProtector.compile("^(\\${1,2})[^\\s\\$](([^\\r\\n\\$]*?)[^\\s\\$])?\\1(?!\\d)");
        goto L13
    L12:
        r5 = PatternProtector.compile("^(\\${2})[^\\s\\$](([^\\r\\n\\$]*?)[^\\s\\$])?\\1(?!\\d)");
    L7:
        r1 = false;
        goto L8
    }
}
