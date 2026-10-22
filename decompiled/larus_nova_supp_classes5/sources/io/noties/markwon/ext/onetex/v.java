package io.noties.markwon.ext.onetex;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.regex.Pattern;
import uvc.b;
import zsc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v extends i {
    public final Pattern e;

    public static final class a {
    }

    static {
    }

    @Override // zsc.i
    public final char d() {
        return '\\';
    }

    @Override // zsc.i
    public final b b() {
        boolean r1 = true;
        if ((this.d + 1) < this.c.length()) goto L6;
    L4:
        r1 = false;
    L11:
        if (r1 == true) goto L13;
        return null;
    L13:
        int r2 = this.d;
        String r3 = a(this.e);
        if (r3 != null) goto L19;
        com.larus.business.markdown.api.depend.d r4 = IMarkdownLoggerKt.a();
        if (r4 == null) goto L18;
        r4.e("md_parse", "NewLatexMathInlineProcessor error parse latex: raw: " + this.c + "; context: " + this.a + "; index: " + this.d + "; oldIndex: " + r2);
    L18:
        return null;
    L19:
        LatexMathNode r0 = new LatexMathNode();
        com.larus.business.markdown.api.depend.d r6 = IMarkdownLoggerKt.a();
        if (r6 == null) goto L22;
        r6.i("md_parse", "NewLatexMathInlineProcessor latex: " + r3 + "; index: " + this.d + "; oldIndex: " + r2);
    L22:
        r0.h = r3.substring(2, r3.length() - 2);
        return r0;
    L6:
        if (this.c.charAt(this.d + 1) == '(') goto L11;
        if (this.c.charAt(this.d + 1) == '[') goto L11;
        goto L4
    }

    public v() {
        this.e = PatternProtector.compile("^\\\\\\(([\\s\\S]*?)\\\\\\)|\\\\\\[([\\s\\S]*?)\\\\\\]");
    }
}
