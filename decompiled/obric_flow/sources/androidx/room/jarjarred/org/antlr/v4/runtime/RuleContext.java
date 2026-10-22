package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.RuleNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Trees;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RuleContext implements RuleNode {
    public static final ParserRuleContext EMPTY = null;
    public int invokingState;
    public RuleContext parent;

    static {
        EMPTY = new ParserRuleContext();
    }

    public RuleContext() {
        this.invokingState = -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public <T> T accept(ParseTreeVisitor<? extends T> r5) {
        return r5.visitChildren(this);
    }

    public int depth() {
        int r5 = 0;
    L3:
        if (this == null) goto L5;
        RuleContext this = this.parent;
        r5 = r5 + 1;
        goto L3
    L5:
        return r5;
    }

    public int getAltNumber() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public ParseTree getChild(int r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public int getChildCount() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ ParseTree getParent() {
        return getParent();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public RuleContext getPayload() {
        return this;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.RuleNode
    public RuleContext getRuleContext() {
        return this;
    }

    public int getRuleIndex() {
        return -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.SyntaxTree
    public Interval getSourceInterval() {
        return Interval.INVALID;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public String getText() {
        if (getChildCount() != 0) goto L6;
        return "";
    L6:
        StringBuilder r5 = new StringBuilder();
        int r10 = 0;
    L8:
        if (r10 >= getChildCount()) goto L11;
        r5.append(getChild(r10).getText());
        r10 = r10 + 1;
        goto L8
    L11:
        return r5.toString();
    }

    public boolean isEmpty() {
        if (this.invokingState != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void setAltNumber(int r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public void setParent(RuleContext r5) {
        this.parent = r5;
    }

    public String toString() {
        return toString(null, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree
    public String toStringTree(Parser r5) {
        return Trees.toStringTree(this, r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree getChild(int r5) {
        return getChild(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree getParent() {
        return getParent();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Object getPayload() {
        return getPayload();
    }

    public final String toString(Recognizer<?, ?> r5) {
        return toString(r5, EMPTY);
    }

    public String toStringTree(List<String> r5) {
        return Trees.toStringTree(this, r5);
    }

    public RuleContext(RuleContext r5, int r10) {
        this.parent = r5;
        this.invokingState = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public RuleContext getParent() {
        return this.parent;
    }

    public final String toString(List<String> r5) {
        return toString(r5, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public String toStringTree() {
        return toStringTree(null);
    }

    public String toString(Recognizer<?, ?> r5, RuleContext r10) {
        List<String> r11 = null;
        if (r5 == null) goto L5;
        String[] r12 = r5.getRuleNames();
    L6:
        if (r12 == null) goto L9;
        r11 = Arrays.asList(r12);
    L9:
        return toString(r11, r10);
    L5:
        r12 = null;
        goto L6
    }

    public String toString(List<String> r5, RuleContext r10) {
        StringBuilder r11 = new StringBuilder("[");
    L3:
        if (this == null) goto L23;
        if (this == r10) goto L23;
        if (r5 == null) goto L7;
        int r12 = this.getRuleIndex();
        if (r12 >= 0) goto L12;
    L14:
        String r13 = Integer.toString(r12);
    L15:
        r11.append(r13);
    L16:
        RuleContext r14 = this.parent;
        if (r14 == null) goto L22;
        if (r5 == null) goto L20;
    L21:
        r11.append(" ");
        goto L22
    L20:
        if (r14.isEmpty() == false) goto L21;
    L22:
        RuleContext this = this.parent;
        goto L3
    L12:
        if (r12 >= r5.size()) goto L14;
        r13 = r5.get(r12);
        goto L15
    L7:
        if (this.isEmpty() == true) goto L16;
        r11.append(this.invokingState);
    L23:
        r11.append("]");
        return r11.toString();
    }
}
