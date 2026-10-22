package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Comment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes7.dex */
class CommentXobj extends NodeXobj implements Comment {
    CommentXobj(Locale r3) {
        super(r3, 4, 8);
    }

    @Override // org.w3c.dom.CharacterData
    public void appendData(String r1) {
        DomImpl._characterData_appendData(this, r1);
    }

    @Override // org.w3c.dom.CharacterData
    public void deleteData(int r1, int r2) {
        DomImpl._characterData_deleteData(this, r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public NodeList getChildNodes() {
        return DomImpl._emptyNodeList;
    }

    @Override // org.w3c.dom.CharacterData
    public String getData() {
        return DomImpl._characterData_getData(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public Node getFirstChild() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.NodeList, org.w3c.dom.CharacterData
    public int getLength() {
        return DomImpl._characterData_getLength(this);
    }

    @Override // org.w3c.dom.CharacterData
    public void insertData(int r1, String r2) {
        DomImpl._characterData_insertData(this, r1, r2);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    Xobj newNode(Locale r1) {
        return new CommentXobj(r1);
    }

    @Override // org.w3c.dom.CharacterData
    public void replaceData(int r1, int r2, String r3) {
        DomImpl._characterData_replaceData(this, r1, r2, r3);
    }

    @Override // org.w3c.dom.CharacterData
    public void setData(String r1) {
        DomImpl._characterData_setData(this, r1);
    }

    @Override // org.w3c.dom.CharacterData
    public String substringData(int r1, int r2) {
        return DomImpl._characterData_substringData(this, r1, r2);
    }
}
