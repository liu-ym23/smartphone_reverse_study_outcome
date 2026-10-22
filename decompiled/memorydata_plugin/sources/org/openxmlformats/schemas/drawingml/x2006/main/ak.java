package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface ak extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ak> f18698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18699b = null;

    static {
        DocumentFactory<ak> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgraphicalobjectdata66adtype");
        f18698a = r0;
        f18699b = r0.getType();
    }

    String getUri();
}
