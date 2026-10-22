package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface bn extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bn> f18464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18465b = null;

    static {
        DocumentFactory<bn> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpagemarginsb730type");
        f18464a = r0;
        f18465b = r0.getType();
    }

    void setB(double r1);

    void setFooter(double r1);

    void setHeader(double r1);

    void setL(double r1);

    void setR(double r1);

    void setT(double r1);
}
