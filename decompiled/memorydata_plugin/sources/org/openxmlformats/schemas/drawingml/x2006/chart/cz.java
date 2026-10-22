package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface cz extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cz> f18542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18543b = null;

    static {
        DocumentFactory<cz> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "chartspace36e0doctype");
        f18542a = r0;
        f18543b = r0.getType();
    }

    r getChartSpace();
}
