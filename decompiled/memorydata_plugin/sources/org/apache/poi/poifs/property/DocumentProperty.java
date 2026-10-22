package org.apache.poi.poifs.property;

import org.apache.poi.poifs.filesystem.POIFSDocument;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentProperty extends Property {
    private POIFSDocument _document;

    public DocumentProperty(int r1, byte[] r2, int r3) {
        super(r1, r2, r3);
        this._document = null;
    }

    public DocumentProperty(String r2, int r3) {
        this._document = null;
        setName(r2);
        setSize(r3);
        setNodeColor((byte) 1);
        setPropertyType((byte) 2);
    }

    public POIFSDocument getDocument() {
        return this._document;
    }

    @Override // org.apache.poi.poifs.property.Property
    public boolean isDirectory() {
        return false;
    }

    public void setDocument(POIFSDocument r1) {
        this._document = r1;
    }

    public void updateSize(int r1) {
        setSize(r1);
    }
}
