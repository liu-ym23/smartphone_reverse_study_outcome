package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bp extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bp> f19489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19490b = null;

    static {
        DocumentFactory<bp> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternalsheetdataset07adtype");
        f19489a = r0;
        f19490b = r0.getType();
    }

    bo addNewSheetData();

    bo[] getSheetDataArray();
}
