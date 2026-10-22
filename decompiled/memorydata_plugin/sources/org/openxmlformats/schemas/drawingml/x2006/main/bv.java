package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface bv extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bv> f18774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18775b = null;

    static {
        DocumentFactory<bv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpoint2d8193type");
        f18774a = r0;
        f18775b = r0.getType();
    }

    void setX(Object r1);

    void setY(Object r1);

    el xgetX();

    el xgetY();
}
