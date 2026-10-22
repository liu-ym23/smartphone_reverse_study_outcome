package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleAltInfo;
import androidx.room.jarjarred.org.antlr.v4.parse.ANTLRParser;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GrammarAST extends CommonTree {
    public ATNState atnState;
    public Grammar g;
    public String textOverride;

    public GrammarAST() {
    }

    public boolean deleteChild(Tree r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.children.size()) goto L10;
        if (this.children.get(r10) == r5) goto L7;
        r10 = r10 + 1;
        goto L4
    L7:
        deleteChild(r5.getChildIndex());
        return true;
    L10:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree dupNode() {
        return dupNode();
    }

    public GrammarAST dupTree() {
        return (GrammarAST) new GrammarASTAdaptor(this.token.getInputStream()).dupTree(this);
    }

    public List<GrammarAST> getAllChildrenWithType(int r5) {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L3:
        List<Object> r12 = this.children;
        if (r12 == null) goto L11;
        if (r11 >= r12.size()) goto L11;
        Tree r13 = (Tree) this.children.get(r11);
        if (r13.getType() != r5) goto L10;
        r10.add((GrammarAST) r13);
    L10:
        r11 = r11 + 1;
    L11:
        return r10;
    }

    public String getAltLabel() {
        List<? extends Tree> r5 = getAncestors();
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = r5.size() - 1;
    L6:
        if (r10 < 0) goto L18;
        GrammarAST r11 = (GrammarAST) r5.get(r10);
        if (r11.getType() != 74) goto L17;
        AltAST r12 = (AltAST) r11;
        GrammarAST r13 = r12.altLabel;
        if (r13 != null) goto L12;
        LeftRecursiveRuleAltInfo r14 = r12.leftRecursiveAltInfo;
        if (r14 == null) goto L17;
        return r14.altLabel;
    L12:
        return r13.getText();
    L17:
        r10 = r10 - 1;
        goto L6
    L18:
        return null;
    }

    public GrammarAST[] getChildrenAsArray() {
        List<Object> r5 = this.children;
        return (GrammarAST[]) r5.toArray(new GrammarAST[r5.size()]);
    }

    public CommonTree getFirstDescendantWithType(int r5) {
        if (getType() != r5) goto L5;
        return this;
    L5:
        List<Object> r10 = this.children;
        if (r10 != null) goto L8;
        return null;
    L8:
        Iterator<Object> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        GrammarAST r12 = (GrammarAST) r11.next();
        if (r12.getType() == r5) goto L13;
        CommonTree r13 = r12.getFirstDescendantWithType(r5);
        if (r13 == null) goto L10;
        return r13;
    L13:
        return r12;
    L17:
        return null;
    }

    public GrammarAST getNodeWithTokenIndex(int r5) {
        if (getToken() != null) goto L5;
    L7:
        int r10 = 0;
    L9:
        if (r10 >= getChildCount()) goto L14;
        GrammarAST r11 = ((GrammarAST) getChild(r10)).getNodeWithTokenIndex(r5);
        if (r11 != null) goto L12;
        r10 = r10 + 1;
        goto L9
    L12:
        return r11;
    L14:
        return null;
    L5:
        if (getToken().getTokenIndex() != r5) goto L7;
        return this;
    }

    public List<GrammarAST> getNodesWithType(int r5) {
        return getNodesWithType(IntervalSet.of(r5));
    }

    public List<GrammarAST> getNodesWithTypePreorderDFS(IntervalSet r5) {
        ArrayList r10 = new ArrayList();
        getNodesWithTypePreorderDFS_(r10, r5);
        return r10;
    }

    public void getNodesWithTypePreorderDFS_(List<GrammarAST> r5, IntervalSet r10) {
        if (r10.contains(getType()) == false) goto L5;
        r5.add(this);
    L5:
        int r11 = 0;
    L7:
        if (r11 >= getChildCount()) goto L9;
        ((GrammarAST) getChild(r11)).getNodesWithTypePreorderDFS_(r5, r10);
        r11 = r11 + 1;
        goto L7
    }

    public AltAST getOutermostAltNode() {
        if ((this instanceof AltAST) == true) goto L5;
    L8:
        CommonTree r5 = this.parent;
        if (r5 != null) goto L11;
        return null;
    L11:
        return ((GrammarAST) r5).getOutermostAltNode();
    L5:
        if ((this.parent.parent instanceof RuleAST) == false) goto L8;
        return (AltAST) this;
    }

    public void setText(String r5) {
        this.token.setText(r5);
    }

    public void setType(int r5) {
        this.token.setType(r5);
    }

    public String toTokenString() {
        GrammarASTAdaptor r5 = new GrammarASTAdaptor(this.token.getInputStream());
        CommonTreeNodeStream r10 = new CommonTreeNodeStream(r5, this);
        StringBuilder r11 = new StringBuilder();
        GrammarAST r12 = (GrammarAST) r10.LT(1);
        int r13 = r5.getType(r12);
    L4:
        if (r13 == (-1)) goto L7;
        r11.append(" ");
        r11.append(r12.getText());
        r10.consume();
        r12 = (GrammarAST) r10.LT(1);
        r13 = r5.getType(r12);
        goto L4
    L7:
        return r11.toString();
    }

    public Object visit(GrammarASTVisitor r5) {
        return r5.visit(this);
    }

    public GrammarAST(Token r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public GrammarAST dupNode() {
        return new GrammarAST(this);
    }

    public List<GrammarAST> getNodesWithType(IntervalSet r5) {
        ArrayList r10 = new ArrayList();
        LinkedList r11 = new LinkedList();
        r11.add(this);
    L4:
        if (r11.isEmpty() == true) goto L13;
        GrammarAST r12 = (GrammarAST) r11.remove(0);
        if (r5 != null) goto L8;
    L9:
        r10.add(r12);
    L11:
        if (r12.children == null) goto L4;
        r11.addAll(Arrays.asList(r12.getChildrenAsArray()));
        goto L4
    L8:
        if (r5.contains(r12.getType()) == false) goto L11;
    L13:
        return r10;
    }

    public GrammarAST(GrammarAST r5) {
        super(r5);
        this.g = r5.g;
        this.atnState = r5.atnState;
        this.textOverride = r5.textOverride;
    }

    public GrammarAST(int r5) {
        super(new CommonToken(r5, ANTLRParser.tokenNames[r5]));
    }

    public CommonTree getFirstDescendantWithType(BitSet r5) {
        if (r5.member(getType()) == false) goto L5;
        return this;
    L5:
        List<Object> r10 = this.children;
        if (r10 != null) goto L8;
        return null;
    L8:
        Iterator<Object> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        GrammarAST r12 = (GrammarAST) r11.next();
        if (r5.member(r12.getType()) == true) goto L13;
        CommonTree r13 = r12.getFirstDescendantWithType(r5);
        if (r13 == null) goto L10;
        return r13;
    L13:
        return r12;
    L17:
        return null;
    }

    public GrammarAST(int r5, Token r10) {
        this(new CommonToken(r10));
        this.token.setType(r5);
    }

    public GrammarAST(int r5, Token r10, String r11) {
        this(new CommonToken(r10));
        this.token.setType(r5);
        this.token.setText(r11);
    }
}
