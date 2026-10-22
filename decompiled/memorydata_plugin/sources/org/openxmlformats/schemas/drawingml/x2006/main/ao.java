package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface ao extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ao> f18706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18707b = null;

    static {
        DocumentFactory<ao> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgrouptransform2d411atype");
        f18706a = r0;
        f18707b = r0.getType();
    }

    bz addNewChExt();

    bv addNewChOff();

    bz addNewExt();

    bv addNewOff();

    bz getChExt();

    bv getChOff();

    bz getExt();

    bv getOff();

    boolean isSetChExt();

    boolean isSetChOff();

    boolean isSetExt();

    boolean isSetOff();

    void setRot(int r1);
}
