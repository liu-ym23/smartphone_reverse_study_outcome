package org.openxmlformats.schemas.drawingml.x2006.diagram;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface a extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<a> f18604a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18605b = null;

    static {
        DocumentFactory<a> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrelidsfef2type");
        f18604a = r0;
        f18605b = r0.getType();
    }

    String getDm();
}
