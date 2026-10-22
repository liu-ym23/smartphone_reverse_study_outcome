package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cm extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cm> f19537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19538b = null;

    static {
        DocumentFactory<cm> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctintproperty32c3type");
        f19537a = r0;
        f19538b = r0.getType();
    }

    int getVal();

    void setVal(int r1);
}
