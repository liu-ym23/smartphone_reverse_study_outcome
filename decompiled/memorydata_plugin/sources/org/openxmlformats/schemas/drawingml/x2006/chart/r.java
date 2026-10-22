package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface r extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<r> f18586a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18587b = null;

    static {
        DocumentFactory<r> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctchartspacef9b4type");
        f18586a = r0;
        f18587b = r0.getType();
    }

    p addNewChart();

    ai addNewExternalData();

    bu addNewPrintSettings();

    p getChart();

    ai getExternalData();

    boolean isSetExternalData();
}
