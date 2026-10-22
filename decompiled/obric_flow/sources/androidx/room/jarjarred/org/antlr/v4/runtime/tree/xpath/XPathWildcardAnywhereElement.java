package androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Trees;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class XPathWildcardAnywhereElement extends XPathElement {
    public XPathWildcardAnywhereElement() {
        super(XPath.WILDCARD);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<ParseTree> evaluate(ParseTree r5) {
        if (this.invert == false) goto L7;
        return new ArrayList();
    L7:
        return Trees.getDescendants(r5);
    }
}
