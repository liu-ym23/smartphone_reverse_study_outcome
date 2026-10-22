package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import org.commonmark.node.HtmlInline;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g extends i {
    public static final Pattern e = null;

    @Override // zsc.i
    public final char d() {
        return '<';
    }

    static {
        e = PatternProtector.compile("^(?:<[A-Za-z][A-Za-z0-9-_]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-_]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    }

    @Override // zsc.i
    public final uvc.b b() {
        String r0 = a(e);
        if (r0 == null) goto L6;
        HtmlInline r1 = new HtmlInline();
        r1.h = r0;
        return r1;
    L6:
        return null;
    }

    public g() {
    }
}
