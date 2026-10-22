package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface l extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<l> f18574a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18575b = null;

    static {
        DocumentFactory<l> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctbooleancc3etype");
        f18574a = r0;
        f18575b = r0.getType();
    }

    void setVal(boolean r1);
}
