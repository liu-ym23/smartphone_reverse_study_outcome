package org.apache.poi.poifs.filesystem;

import org.apache.poi.poifs.property.Property;

/* JADX INFO: loaded from: classes7.dex */
public abstract class EntryNode implements Entry {
    private DirectoryNode _parent;
    private Property _property;

    public EntryNode(Property r1, DirectoryNode r2) {
        this._property = r1;
        this._parent = r2;
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean delete() {
        if (isRoot() == false) goto L5;
    L7:
        return false;
    L5:
        if (isDeleteOK() == false) goto L7;
        return this._parent.deleteEntry(this);
    }

    @Override // org.apache.poi.poifs.filesystem.Entry
    public String getName() {
        return this._property.getName();
    }

    public DirectoryEntry getParent() {
        return this._parent;
    }

    public Property getProperty() {
        return this._property;
    }

    public abstract boolean isDeleteOK();

    @Override // org.apache.poi.poifs.filesystem.Entry
    public boolean isDocumentEntry() {
        return false;
    }

    public boolean isRoot() {
        if (this._parent != null) goto L5;
        return true;
    L5:
        return false;
    }
}
