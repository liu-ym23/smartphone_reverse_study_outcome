package io.noties.markwon.inlineparser;

import org.commonmark.internal.Bracket;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes6.dex */
public class o extends i {
    public o() {
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return '[';
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        int r0 = this.d;
        this.d++;
        Text r1 = a("[");
        a(Bracket.link(r1, r0, c(), d()));
        return r1;
    }
}
