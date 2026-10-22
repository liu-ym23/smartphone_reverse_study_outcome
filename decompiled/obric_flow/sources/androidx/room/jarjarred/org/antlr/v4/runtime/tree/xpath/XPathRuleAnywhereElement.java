package androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath;

import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Trees;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class XPathRuleAnywhereElement extends XPathElement {
    protected int ruleIndex;

    public XPathRuleAnywhereElement(String r5, int r10) {
        super(r5);
        this.ruleIndex = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPathElement
    public Collection<ParseTree> evaluate(ParseTree r5) {
        return Trees.findAllRuleNodes(r5, this.ruleIndex);
    }
}
