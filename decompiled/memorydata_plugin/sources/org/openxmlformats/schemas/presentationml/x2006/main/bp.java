package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bp extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bp> f19281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19282b = null;

    static {
        DocumentFactory<bp> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "sldlayout638edoctype");
        f19281a = r0;
        f19282b = r0.getType();
    }

    am getSldLayout();
}
