package androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Trees;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class XPathWildcardElement extends XPathElement {
    public XPathWildcardElement() {
        super(XPath.WILDCARD);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<ParseTree> evaluate(ParseTree r5) {
        if (this.invert == true) goto L5;
        ArrayList r10 = new ArrayList();
        Iterator<Tree> r11 = Trees.getChildren(r5).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        r10.add((ParseTree) r11.next());
        goto L8
    L10:
        return r10;
    L5:
        return new ArrayList();
    }
}
