package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ar extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ar> f19233a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19234b = null;

    static {
        DocumentFactory<ar> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctslidesizeb0fdtype");
        f19233a = r0;
        f19234b = r0.getType();
    }

    STSlideSizeType.Enum getType();
}
