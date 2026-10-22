package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface ck extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ck> f18806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18807b = null;

    static {
        DocumentFactory<ck> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshapeproperties30e5type");
        f18806a = r0;
        f18807b = r0.getType();
    }

    ef getXfrm();

    boolean isSetCustGeom();

    void setXfrm(ef r1);
}
