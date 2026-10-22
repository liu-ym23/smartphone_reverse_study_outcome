package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public class g extends i {
    private static final Pattern e = null;

    static {
        e = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-_]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-_]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    }

    public g() {
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return Typography.less;
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        String r1 = a(e);
        if (r1 == null) goto L6;
        HtmlInline r0 = new HtmlInline();
        r0.setLiteral(r1);
        return r0;
    L6:
        return null;
    }
}
