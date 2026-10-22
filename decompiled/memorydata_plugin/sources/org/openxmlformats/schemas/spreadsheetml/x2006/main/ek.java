package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ek extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ek> f19641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19642b = null;

    static {
        DocumentFactory<ek> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsheetformatprdef7type");
        f19641a = r0;
        f19642b = r0.getType();
    }

    long getBaseColWidth();

    double getDefaultRowHeight();

    void setDefaultRowHeight(double r1);
}
