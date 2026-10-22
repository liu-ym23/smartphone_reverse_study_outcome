package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bh extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bh> f19267a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19268b = null;

    static {
        DocumentFactory<bh> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "presentation02f7doctype");
        f19267a = r0;
        f19268b = r0.getType();
    }

    af getPresentation();
}
