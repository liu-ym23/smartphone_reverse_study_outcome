package androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath;

import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Trees;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class XPathRuleElement extends XPathElement {
    protected int ruleIndex;

    public XPathRuleElement(String r5, int r10) {
        super(r5);
        this.ruleIndex = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<ParseTree> evaluate(ParseTree r5) {
        ArrayList r10 = new ArrayList();
        Iterator<Tree> r11 = Trees.getChildren(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        Tree r12 = r11.next();
        if ((r12 instanceof ParserRuleContext) == false) goto L4;
        ParserRuleContext r13 = (ParserRuleContext) r12;
        if (r13.getRuleIndex() != this.ruleIndex) goto L12;
        if (this.invert == true) goto L12;
    L15:
        r10.add(r13);
    L12:
        if (r13.getRuleIndex() == this.ruleIndex) goto L4;
        if (this.invert == false) goto L4;
    L16:
        return r10;
    }
}
