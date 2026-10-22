package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface de extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<de> f19575a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19576b = null;

    static {
        DocumentFactory<de> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpagemargins5455type");
        f19575a = r0;
        f19576b = r0.getType();
    }

    void setBottom(double r1);

    void setFooter(double r1);

    void setHeader(double r1);

    void setLeft(double r1);

    void setRight(double r1);

    void setTop(double r1);
}
