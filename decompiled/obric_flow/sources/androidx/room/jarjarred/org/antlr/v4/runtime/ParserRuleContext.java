package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ErrorNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ErrorNodeImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeListener;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNode;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.TerminalNodeImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParserRuleContext extends RuleContext {
    public List<ParseTree> children;
    public RecognitionException exception;
    public Token start;
    public Token stop;

    public ParserRuleContext() {
    }

    public <T extends ParseTree> T addAnyChild(T r5) {
        if (this.children != null) goto L5;
        this.children = new ArrayList();
    L5:
        this.children.add(r5);
        return r5;
    }

    public RuleContext addChild(RuleContext r5) {
        return (RuleContext) addAnyChild(r5);
    }

    public ErrorNode addErrorNode(ErrorNode r5) {
        r5.setParent(this);
        return (ErrorNode) addAnyChild(r5);
    }

    public void copyFrom(ParserRuleContext r5) {
        this.parent = r5.parent;
        this.invokingState = r5.invokingState;
        this.start = r5.start;
        this.stop = r5.stop;
        if (r5.children == null) goto L10;
        this.children = new ArrayList();
        Iterator<ParseTree> r10 = r5.children.iterator();
    L6:
        if (r10.hasNext() == false) goto L16;
        ParseTree r11 = r10.next();
        if ((r11 instanceof ErrorNode) == false) goto L6;
        addChild((ErrorNode) r11);
        goto L6
    L16:
        return;
    }

    public void enterRule(ParseTreeListener r5) {
    }

    public void exitRule(ParseTreeListener r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree getChild(int r5) {
        return getChild(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public int getChildCount() {
        List<ParseTree> r5 = this.children;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.size();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ RuleContext getParent() {
        return getParent();
    }

    public <T extends ParserRuleContext> T getRuleContext(Class<? extends T> r5, int r10) {
        return (T) getChild(r5, r10);
    }

    public <T extends ParserRuleContext> List<T> getRuleContexts(Class<? extends T> r5) {
        List<ParseTree> r10 = this.children;
        if (r10 == null) goto L5;
        Iterator<ParseTree> r11 = r10.iterator();
        ArrayList r12 = null;
    L8:
        if (r11.hasNext() == false) goto L14;
        ParseTree r13 = r11.next();
        if (r5.isInstance(r13) == false) goto L8;
        if (r12 != null) goto L13;
        r12 = new ArrayList();
    L13:
        r12.add(r5.cast(r13));
        goto L8
    L14:
        if (r12 == null) goto L16;
        return r12;
    L16:
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.SyntaxTree
    public Interval getSourceInterval() {
        if (this.start == null) goto L5;
        Token r5 = this.stop;
        if (r5 == null) goto L14;
        if (r5.getTokenIndex() < this.start.getTokenIndex()) goto L14;
        return Interval.of(this.start.getTokenIndex(), this.stop.getTokenIndex());
    L14:
        return Interval.of(this.start.getTokenIndex(), this.start.getTokenIndex() - 1);
    L5:
        return Interval.INVALID;
    }

    public Token getStart() {
        return this.start;
    }

    public Token getStop() {
        return this.stop;
    }

    public TerminalNode getToken(int r5, int r10) {
        List<ParseTree> r11 = this.children;
        if (r11 == null) goto L18;
        if (r10 < 0) goto L18;
        if (r10 >= r11.size()) goto L18;
        Iterator<ParseTree> r12 = this.children.iterator();
        int r13 = -1;
    L10:
        if (r12.hasNext() == false) goto L18;
        ParseTree r14 = r12.next();
        if ((r14 instanceof TerminalNode) == false) goto L10;
        TerminalNode r15 = (TerminalNode) r14;
        if (r15.getSymbol().getType() != r5) goto L10;
        r13 = r13 + 1;
        if (r13 != r10) goto L10;
        return r15;
    L18:
        return null;
    }

    public List<TerminalNode> getTokens(int r5) {
        List<ParseTree> r10 = this.children;
        if (r10 == null) goto L5;
        Iterator<ParseTree> r11 = r10.iterator();
        ArrayList r12 = null;
    L8:
        if (r11.hasNext() == false) goto L16;
        ParseTree r13 = r11.next();
        if ((r13 instanceof TerminalNode) == false) goto L8;
        TerminalNode r14 = (TerminalNode) r13;
        if (r14.getSymbol().getType() != r5) goto L8;
        if (r12 != null) goto L15;
        r12 = new ArrayList();
    L15:
        r12.add(r14);
        goto L8
    L16:
        if (r12 == null) goto L18;
        return r12;
    L18:
        return Collections.emptyList();
    L5:
        return Collections.emptyList();
    }

    public void removeLastChild() {
        List<ParseTree> r5 = this.children;
        if (r5 == null) goto L6;
        r5.remove(r5.size() - 1);
        return;
    }

    public String toInfoString(Parser r5) {
        List<String> r10 = r5.getRuleInvocationStack(this);
        Collections.reverse(r10);
        return "ParserRuleContext" + r10 + "{start=" + this.start + ", stop=" + this.stop + '}';
    }

    public ParserRuleContext(ParserRuleContext r5, int r10) {
        super(r5, r10);
    }

    public TerminalNode addChild(TerminalNode r5) {
        r5.setParent(this);
        return (TerminalNode) addAnyChild(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public ParseTree getChild(int r5) {
        List<ParseTree> r10 = this.children;
        if (r10 == null) goto L8;
        if (r5 < 0) goto L8;
        if (r5 >= r10.size()) goto L8;
        return this.children.get(r5);
    L8:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ ParseTree getParent() {
        return getParent();
    }

    @Deprecated
    public ErrorNode addErrorNode(Token r5) {
        ErrorNodeImpl r10 = new ErrorNodeImpl(r5);
        addAnyChild(r10);
        r10.setParent(this);
        return r10;
    }

    public <T extends ParseTree> T getChild(Class<? extends T> r5, int r10) {
        List<ParseTree> r11 = this.children;
        if (r11 == null) goto L17;
        if (r10 < 0) goto L17;
        if (r10 >= r11.size()) goto L17;
        Iterator<ParseTree> r12 = this.children.iterator();
        int r13 = -1;
    L10:
        if (r12.hasNext() == false) goto L17;
        ParseTree r14 = r12.next();
        if (r5.isInstance(r14) == false) goto L10;
        r13 = r13 + 1;
        if (r13 != r10) goto L10;
        return r5.cast(r14);
    L17:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree getParent() {
        return getParent();
    }

    @Deprecated
    public TerminalNode addChild(Token r5) {
        TerminalNodeImpl r10 = new TerminalNodeImpl(r5);
        addAnyChild(r10);
        r10.setParent(this);
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext, androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTree, androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    public ParserRuleContext getParent() {
        return (ParserRuleContext) super.getParent();
    }
}
