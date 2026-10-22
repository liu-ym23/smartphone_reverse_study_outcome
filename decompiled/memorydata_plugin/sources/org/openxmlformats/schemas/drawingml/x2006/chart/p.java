package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface p extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<p> f18582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18583b = null;

    static {
        DocumentFactory<p> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctchartc108type");
        f18582a = r0;
        f18583b = r0.getType();
    }

    bt addNewPlotArea();

    l addNewPlotVisOnly();

    bt getPlotArea();
}
