package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ei extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ei> f19637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19638b = null;

    static {
        DocumentFactory<ei> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsheetdata8408type");
        f19637a = r0;
        f19638b = r0.getType();
    }

    dz addNewRow();

    dz[] getRowArray();

    dz insertNewRow(int r1);
}
