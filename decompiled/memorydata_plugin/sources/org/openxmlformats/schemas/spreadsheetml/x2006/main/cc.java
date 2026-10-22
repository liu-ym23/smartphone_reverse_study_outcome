package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cc extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cc> f19517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19518b = null;

    static {
        DocumentFactory<cc> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfontsizeb3b9type");
        f19517a = r0;
        f19518b = r0.getType();
    }

    double getVal();

    void setVal(double r1);
}
