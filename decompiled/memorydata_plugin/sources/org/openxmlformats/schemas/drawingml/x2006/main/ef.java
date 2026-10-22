package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface ef extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ef> f18904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18905b = null;

    static {
        DocumentFactory<ef> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttransform2d5deftype");
        f18904a = r0;
        f18905b = r0.getType();
    }

    bz getExt();

    bv getOff();

    int getRot();

    void setRot(int r1);
}
