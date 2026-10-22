package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cu extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cu> f19553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19554b = null;

    static {
        DocumentFactory<cu> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctmergecells1242type");
        f19553a = r0;
        f19554b = r0.getType();
    }

    ct[] getMergeCellArray();

    int sizeOfMergeCellArray();
}
