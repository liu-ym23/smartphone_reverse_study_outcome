package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface cf extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cf> f18796a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18797b = null;

    static {
        DocumentFactory<cf> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsrgbcolor5bdatype");
        f18796a = r0;
        f18797b = r0.getType();
    }

    byte[] getVal();
}
