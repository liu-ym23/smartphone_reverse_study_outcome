package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface t extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<t> f19785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19786b = null;

    static {
        DocumentFactory<t> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcellstylexfsa81ftype");
        f19785a = r0;
        f19786b = r0.getType();
    }

    fo[] getXfArray();

    void setCount(long r1);

    void setXfArray(fo[] r1);
}
