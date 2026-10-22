package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface n extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<n> f19775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19776b = null;

    static {
        DocumentFactory<n> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcalcchain5a0btype");
        f19775a = r0;
        f19776b = r0.getType();
    }

    m[] getCArray();

    void removeC(int r1);

    int sizeOfCArray();
}
