package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public class c extends i {
    private static final Pattern e = null;
    private static final Pattern f = null;

    static {
        e = Pattern.compile("`+");
        f = Pattern.compile("^`+");
    }

    public c() {
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return '`';
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        String r0 = a(f);
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = this.d;
    L7:
        String r2 = a(e);
        if (r2 == null) goto L22;
        if (r2.equals(r0) == false) goto L7;
        Code r3 = new Code();
        String r4 = this.c.substring(r1, this.d - r0.length()).replace('\n', ' ');
        if (r4.length() >= 3) goto L14;
    L20:
        r3.setLiteral(r4);
        return r3;
    L14:
        if (r4.charAt(0) != ' ') goto L20;
        if (r4.charAt(r4.length() - 1) != ' ') goto L20;
        if (Parsing.hasNonSpace(r4) == false) goto L20;
        r4 = r4.substring(1, r4.length() - 1);
        goto L20
    L22:
        this.d = r1;
        return a(r0);
    }
}
