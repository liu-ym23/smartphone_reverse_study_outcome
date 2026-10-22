package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ch extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ch> f19527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19528b = null;

    static {
        DocumentFactory<ch> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cthyperlinks6416type");
        f19527a = r0;
        f19528b = r0.getType();
    }

    cg[] getHyperlinkArray();

    void removeHyperlink(int r1);

    void setHyperlinkArray(cg[] r1);

    int sizeOfHyperlinkArray();
}
