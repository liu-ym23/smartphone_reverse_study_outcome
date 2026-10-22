package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface w extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<w> f19791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19792b = null;

    static {
        DocumentFactory<w> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcellxfs1322type");
        f19791a = r0;
        f19792b = r0.getType();
    }

    fo[] getXfArray();

    void setCount(long r1);

    void setXfArray(fo[] r1);
}
