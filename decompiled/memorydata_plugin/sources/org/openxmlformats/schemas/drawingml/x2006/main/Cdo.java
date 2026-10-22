package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: renamed from: org.openxmlformats.schemas.drawingml.x2006.main.do, reason: invalid class name */
/* JADX INFO: loaded from: classes7.dex */
public interface Cdo extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<Cdo> f18868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18869b = null;

    static {
        DocumentFactory<Cdo> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttextfield187etype");
        f18868a = r0;
        f18869b = r0.getType();
    }

    dn getRPr();

    String getT();

    String getType();
}
