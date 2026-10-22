package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bq extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bq> f19491a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19492b = null;

    static {
        DocumentFactory<bq> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternalsheetnamefcdetype");
        f19491a = r0;
        f19492b = r0.getType();
    }

    String getVal();

    void setVal(String r1);
}
