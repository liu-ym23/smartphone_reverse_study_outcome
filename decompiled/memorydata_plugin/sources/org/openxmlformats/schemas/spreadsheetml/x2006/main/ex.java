package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ex extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ex> f19667a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19668b = null;

    static {
        DocumentFactory<ex> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablecolumn08a3type");
        f19667a = r0;
        f19668b = r0.getType();
    }

    String getName();

    void setName(String r1);
}
