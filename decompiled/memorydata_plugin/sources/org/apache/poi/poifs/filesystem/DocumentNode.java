package org.apache.poi.poifs.filesystem;

import org.apache.poi.poifs.property.DocumentProperty;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentNode extends EntryNode implements DocumentEntry {
    private POIFSDocument _document;

    DocumentNode(DocumentProperty r1, DirectoryNode r2) {
        super(r1, r2);
        this._document = r1.getDocument();
    }

    @Override // org.apache.poi.poifs.filesystem.DocumentEntry
    public int getSize() {
        return getProperty().getSize();
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode
    public boolean isDeleteOK() {
        return true;
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode, org.apache.poi.poifs.filesystem.Entry
    public boolean isDocumentEntry() {
        return true;
    }
}
