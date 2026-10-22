package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;

/* JADX INFO: loaded from: classes.dex */
public class DebugTreeAdaptor implements TreeAdaptor {
    protected TreeAdaptor adaptor;
    protected DebugEventListener dbg;

    public DebugTreeAdaptor(DebugEventListener r5, TreeAdaptor r10) {
        this.dbg = r5;
        this.adaptor = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void addChild(Object r5, Object r10) {
        if (r5 == null) goto L7;
        if (r10 == null) goto L8;
        this.adaptor.addChild(r5, r10);
        this.dbg.addChild(r5, r10);
        return;
    L8:
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object becomeRoot(Object r5, Object r10) {
        Object r11 = this.adaptor.becomeRoot(r5, r10);
        this.dbg.becomeRoot(r5, r10);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(Token r5) {
        if (r5.getTokenIndex() < 0) goto L5;
        Object r10 = this.adaptor.create(r5);
        this.dbg.createNode(r10, r5);
        return r10;
    L5:
        return create(r5.getType(), r5.getText());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object deleteChild(Object r5, int r10) {
        return deleteChild(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object dupNode(Object r5) {
        Object r10 = this.adaptor.dupNode(r5);
        this.dbg.createNode(r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object dupTree(Object r5) {
        Object r10 = this.adaptor.dupTree(r5);
        simulateTreeConstruction(r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object errorNode(TokenStream r5, Token r10, Token r11, RecognitionException r12) {
        Object r13 = this.adaptor.errorNode(r5, r10, r11, r12);
        if (r13 == null) goto L5;
        this.dbg.errorNode(r13);
    L5:
        return r13;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object getChild(Object r5, int r10) {
        return this.adaptor.getChild(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getChildCount(Object r5) {
        return this.adaptor.getChildCount(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getChildIndex(Object r5) {
        return this.adaptor.getChildIndex(r5);
    }

    public DebugEventListener getDebugListener() {
        return this.dbg;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object getParent(Object r5) {
        return this.adaptor.getParent(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public String getText(Object r5) {
        return this.adaptor.getText(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Token getToken(Object r5) {
        return this.adaptor.getToken(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getTokenStartIndex(Object r5) {
        return this.adaptor.getTokenStartIndex(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getTokenStopIndex(Object r5) {
        return this.adaptor.getTokenStopIndex(r5);
    }

    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getType(Object r5) {
        return this.adaptor.getType(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getUniqueID(Object r5) {
        return this.adaptor.getUniqueID(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public boolean isNil(Object r5) {
        return this.adaptor.isNil(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object nil() {
        Object r5 = this.adaptor.nil();
        this.dbg.nilNode(r5);
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void replaceChildren(Object r5, int r10, int r11, Object r12) {
        this.adaptor.replaceChildren(r5, r10, r11, r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object rulePostProcessing(Object r5) {
        return this.adaptor.rulePostProcessing(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setChild(Object r5, int r10, Object r11) {
        this.adaptor.setChild(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setChildIndex(Object r5, int r10) {
        this.adaptor.setChildIndex(r5, r10);
    }

    public void setDebugListener(DebugEventListener r5) {
        this.dbg = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setParent(Object r5, Object r10) {
        this.adaptor.setParent(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setText(Object r5, String r10) {
        this.adaptor.setText(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setTokenBoundaries(Object r5, Token r10, Token r11) {
        this.adaptor.setTokenBoundaries(r5, r10, r11);
        if (r5 == null) goto L8;
        if (r10 == null) goto L9;
        if (r11 == null) goto L10;
        this.dbg.setTokenBoundaries(r5, r10.getTokenIndex(), r11.getTokenIndex());
        return;
    L10:
        return;
    L9:
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setType(Object r5, int r10) {
        this.adaptor.setType(r5, r10);
    }

    public void simulateTreeConstruction(Object r5) {
        this.dbg.createNode(r5);
        int r10 = this.adaptor.getChildCount(r5);
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        Object r12 = this.adaptor.getChild(r5, r11);
        simulateTreeConstruction(r12);
        this.dbg.addChild(r5, r12);
        r11 = r11 + 1;
        goto L3
    }

    public void addChild(Object r5, Token r10) {
        addChild(r5, create(r10));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object becomeRoot(Token r5, Object r10) {
        Object r11 = create(r5);
        this.adaptor.becomeRoot(r11, r10);
        this.dbg.becomeRoot(r5, r10);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(int r5, Token r10) {
        Object r11 = this.adaptor.create(r5, r10);
        this.dbg.createNode(r11);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(int r5, Token r10, String r11) {
        Object r12 = this.adaptor.create(r5, r10, r11);
        this.dbg.createNode(r12);
        return r12;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(int r5, String r10) {
        Object r11 = this.adaptor.create(r5, r10);
        this.dbg.createNode(r11);
        return r11;
    }
}
