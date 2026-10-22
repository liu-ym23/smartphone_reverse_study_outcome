package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ac extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ac> f19203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19204b = null;

    static {
        DocumentFactory<ac> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpicture4f11type");
        f19203a = r0;
        f19204b = r0.getType();
    }

    org.openxmlformats.schemas.drawingml.x2006.main.g getBlipFill();
}
