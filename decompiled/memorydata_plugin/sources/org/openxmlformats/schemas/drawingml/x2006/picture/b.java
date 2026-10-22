package org.openxmlformats.schemas.drawingml.x2006.picture;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ba;

/* JADX INFO: loaded from: classes8.dex */
public interface b extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<b> f19016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19017b = null;

    static {
        DocumentFactory<b> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpicturenonvisual05adtype");
        f19016a = r0;
        f19017b = r0.getType();
    }

    ba getCNvPr();
}
