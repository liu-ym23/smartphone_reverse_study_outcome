package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface ai extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ai> f18400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18401b = null;

    static {
        DocumentFactory<ai> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternaldata2e07type");
        f18400a = r0;
        f18401b = r0.getType();
    }

    void setId(String r1);
}
