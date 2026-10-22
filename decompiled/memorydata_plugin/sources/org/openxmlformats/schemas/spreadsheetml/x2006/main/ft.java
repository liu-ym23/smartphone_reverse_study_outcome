package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ft extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ft> f19711a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19712b = null;

    static {
        DocumentFactory<ft> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "chartsheet99dedoctype");
        f19711a = r0;
        f19712b = r0.getType();
    }

    z getChartsheet();
}
