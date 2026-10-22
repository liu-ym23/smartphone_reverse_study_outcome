package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTreeAdaptor implements TreeAdaptor {
    protected Map<Object, Integer> treeToUniqueIDMap;
    protected int uniqueNodeID;

    public BaseTreeAdaptor() {
        this.uniqueNodeID = 1;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void addChild(Object r5, Object r10) {
        if (r5 == null) goto L6;
        if (r10 == null) goto L7;
        ((Tree) r5).addChild((Tree) r10);
        return;
    L7:
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object becomeRoot(Object r5, Object r10) {
        Tree r11 = (Tree) r5;
        Tree r12 = (Tree) r10;
        if (r10 != null) goto L6;
        return r5;
    L6:
        if (r11.isNil() == false) goto L14;
        int r13 = r11.getChildCount();
        if (r13 != 1) goto L10;
        r11 = r11.getChild(0);
        goto L14
    L10:
        if (r13 <= 1) goto L14;
        throw new RuntimeException("more than one node as root (TODO: make exception hierarchy)");
    L14:
        r11.addChild(r12);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(int r5, Token r10) {
        Token r11 = createToken(r10);
        r11.setType(r5);
        return (Tree) create(r11);
    }

    public abstract Token createToken(int r5, String r10);

    public abstract Token createToken(Token r5);

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object deleteChild(Object r5, int r10) {
        return ((Tree) r5).deleteChild(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object dupTree(Object r5) {
        return dupTree(r5, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object errorNode(TokenStream r5, Token r10, Token r11, RecognitionException r12) {
        return new CommonErrorNode(r5, r10, r11, r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object getChild(Object r5, int r10) {
        return ((Tree) r5).getChild(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getChildCount(Object r5) {
        return ((Tree) r5).getChildCount();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public String getText(Object r5) {
        return ((Tree) r5).getText();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getType(Object r5) {
        return ((Tree) r5).getType();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public int getUniqueID(Object r5) {
        if (this.treeToUniqueIDMap != null) goto L5;
        this.treeToUniqueIDMap = new HashMap();
    L5:
        Integer r10 = this.treeToUniqueIDMap.get(r5);
        if (r10 != null) goto L8;
        int r11 = this.uniqueNodeID;
        this.treeToUniqueIDMap.put(r5, Integer.valueOf(r11));
        this.uniqueNodeID++;
        return r11;
    L8:
        return r10.intValue();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public boolean isNil(Object r5) {
        return ((Tree) r5).isNil();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object nil() {
        return create(null);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object rulePostProcessing(Object r5) {
        Tree r10 = (Tree) r5;
        if (r10 != null) goto L5;
        return r10;
    L5:
        if (r10.isNil() == true) goto L7;
        return r10;
    L7:
        if (r10.getChildCount() != 0) goto L10;
        return null;
    L10:
        if (r10.getChildCount() != 1) goto L16;
        Tree r11 = r10.getChild(0);
        r11.setParent(null);
        r11.setChildIndex(-1);
        return r11;
    L16:
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setChild(Object r5, int r10, Object r11) {
        ((Tree) r5).setChild(r10, (Tree) r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setText(Object r5, String r10) {
        throw new NoSuchMethodError("don't know enough about Tree node");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public void setType(Object r5, int r10) {
        throw new NoSuchMethodError("don't know enough about Tree node");
    }

    public Object dupTree(Object r5, Object r10) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Object r11 = dupNode(r5);
        setChildIndex(r11, getChildIndex(r5));
        setParent(r11, r10);
        int r12 = getChildCount(r5);
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L8;
        addChild(r11, dupTree(getChild(r5, r13), r5));
        r13 = r13 + 1;
        goto L6
    L8:
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(int r5, Token r10, String r11) {
        if (r10 == null) goto L4;
        Token r12 = createToken(r10);
        r12.setType(r5);
        r12.setText(r11);
        return (Tree) create(r12);
    L4:
        return create(r5, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object becomeRoot(Token r5, Object r10) {
        return becomeRoot(create(r5), r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(int r5, String r10) {
        return (Tree) create(createToken(r5, r10));
    }
}
