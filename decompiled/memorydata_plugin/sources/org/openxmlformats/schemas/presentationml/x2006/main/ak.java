package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ak extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ak> f19219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19220b = null;

    static {
        DocumentFactory<ak> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctslideidlist70a5type");
        f19219a = r0;
        f19220b = r0.getType();
    }

    List<al> getSldIdList();
}
