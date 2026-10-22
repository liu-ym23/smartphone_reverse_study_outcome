package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface aj extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<aj> f18696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18697b = null;

    static {
        DocumentFactory<aj> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgraphicalobject1ce3type");
        f18696a = r0;
        f18697b = r0.getType();
    }

    ak getGraphicData();
}
