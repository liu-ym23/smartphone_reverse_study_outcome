package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bx extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bx> f19505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19506b = null;

    static {
        DocumentFactory<bx> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfills2c6ftype");
        f19505a = r0;
        f19506b = r0.getType();
    }

    bw[] getFillArray();

    void setCount(long r1);

    void setFillArray(bw[] r1);
}
