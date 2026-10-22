package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bo extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bo> f19279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19280b = null;

    static {
        DocumentFactory<bo> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "sld1b98doctype");
        f19279a = r0;
        f19280b = r0.getType();
    }

    aj getSld();
}
