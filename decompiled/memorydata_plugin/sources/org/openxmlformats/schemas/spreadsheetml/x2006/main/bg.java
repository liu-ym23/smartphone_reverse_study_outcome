package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bg extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bg> f19471a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19472b = null;

    static {
        DocumentFactory<bg> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternalbookc89dtype");
        f19471a = r0;
        f19472b = r0.getType();
    }

    bp addNewSheetDataSet();

    br addNewSheetNames();

    bj getDefinedNames();

    String getId();

    bp getSheetDataSet();

    br getSheetNames();
}
