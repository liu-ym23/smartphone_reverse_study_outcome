package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface j extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<j> f18980a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18981b = null;

    static {
        DocumentFactory<j> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctcolormappingoverridea2b2type");
        f18980a = r0;
        f18981b = r0.getType();
    }

    w addNewMasterClrMapping();
}
