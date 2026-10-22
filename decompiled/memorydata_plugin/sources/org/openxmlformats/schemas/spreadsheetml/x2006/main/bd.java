package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bd extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bd> f19465a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19466b = null;

    static {
        DocumentFactory<bd> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdxfsb26atype");
        f19465a = r0;
        f19466b = r0.getType();
    }

    bc[] getDxfArray();

    void setCount(long r1);

    void setDxfArray(bc[] r1);
}
