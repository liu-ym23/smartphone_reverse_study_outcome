package androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class XPathElement {
    protected boolean invert;
    protected String nodeName;

    public XPathElement(String r5) {
        this.nodeName = r5;
    }

    public abstract Collection<ParseTree> evaluate(ParseTree r5);

    public String toString() {
        if (this.invert == false) goto L5;
        String r5 = XPath.NOT;
    L6:
        StringBuilder r10 = new StringBuilder();
        r10.append(getClass().getSimpleName());
        r10.append("[");
        r10.append(r5);
        return j0.q(r10, this.nodeName, "]");
    L5:
        r5 = "";
        goto L6
    }
}
