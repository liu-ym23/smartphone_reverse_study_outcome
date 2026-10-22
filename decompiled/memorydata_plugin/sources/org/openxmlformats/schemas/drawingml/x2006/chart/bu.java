package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface bu extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bu> f18478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18479b = null;

    static {
        DocumentFactory<bu> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctprintsettings61b6type");
        f18478a = r0;
        f18479b = r0.getType();
    }

    an addNewHeaderFooter();

    bn addNewPageMargins();

    bo addNewPageSetup();
}
