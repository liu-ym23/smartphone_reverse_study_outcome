package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fs extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fs> f19709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19710b = null;

    static {
        DocumentFactory<fs> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "calcchainfc37doctype");
        f19709a = r0;
        f19710b = r0.getType();
    }

    n getCalcChain();

    void setCalcChain(n r1);
}
