package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ec extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ec> f20102a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20103b = null;

    static {
        DocumentFactory<ec> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctstyle41c1type");
        f20102a = r0;
        f20103b = r0.getType();
    }

    STStyleType.Enum getType();
}
