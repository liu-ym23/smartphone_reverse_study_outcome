package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface h extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<h> f19763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19764b = null;

    static {
        DocumentFactory<h> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctborders0d66type");
        f19763a = r0;
        f19764b = r0.getType();
    }

    f[] getBorderArray();

    void setBorderArray(f[] r1);

    void setCount(long r1);
}
