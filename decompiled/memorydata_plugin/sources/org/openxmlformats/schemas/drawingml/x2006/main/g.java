package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface g extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<g> f18974a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18975b = null;

    static {
        DocumentFactory<g> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctblipfillproperties0382type");
        f18974a = r0;
        f18975b = r0.getType();
    }

    f getBlip();

    boolean isSetBlip();
}
