package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface e extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<e> f19619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19620b = null;

    static {
        DocumentFactory<e> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctbooleanproperty1f3ctype");
        f19619a = r0;
        f19620b = r0.getType();
    }

    boolean getVal();

    void setVal(boolean r1);
}
