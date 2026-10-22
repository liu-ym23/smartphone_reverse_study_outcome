package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface eb extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<eb> f19623a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19624b = null;

    static {
        DocumentFactory<eb> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrsta472type");
        f19623a = r0;
        f19624b = r0.getType();
    }

    dw[] getRArray();

    String getT();

    void setT(String r1);

    int sizeOfRArray();

    org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.q xgetT();
}
