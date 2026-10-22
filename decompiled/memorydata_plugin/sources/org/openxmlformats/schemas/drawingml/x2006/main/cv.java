package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface cv extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cv> f18828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18829b = null;

    static {
        DocumentFactory<cv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablegrid69a5type");
        f18828a = r0;
        f18829b = r0.getType();
    }

    int sizeOfGridColArray();
}
