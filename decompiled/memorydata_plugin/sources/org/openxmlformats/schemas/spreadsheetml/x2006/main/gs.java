package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface gs extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<gs> f19757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19758b = null;

    static {
        DocumentFactory<gs> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "table0b99doctype");
        f19757a = r0;
        f19758b = r0.getType();
    }

    ew getTable();

    void setTable(ew r1);
}
