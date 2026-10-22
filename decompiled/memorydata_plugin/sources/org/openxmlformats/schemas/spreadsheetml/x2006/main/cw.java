package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cw> f19557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19558b = null;

    static {
        DocumentFactory<cw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctnumfmtsb58btype");
        f19557a = r0;
        f19558b = r0.getType();
    }

    cv addNewNumFmt();

    cv[] getNumFmtArray();

    void setCount(long r1);
}
