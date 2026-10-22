package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public class b extends i {
    private static final Pattern e = null;

    static {
        e = j.f16628a;
    }

    public b() {
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return '\\';
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        this.d++;
        if (j() != '\n') goto L7;
        Node r0 = new HardLineBreak();
    L5:
        this.d++;
        return r0;
    L7:
        if (this.d >= this.c.length()) goto L12;
        if (e.matcher(this.c.substring(this.d, this.d + 1)).matches() == false) goto L12;
        r0 = a(this.c, this.d, this.d + 1);
    L12:
        return a("\\");
    }
}
