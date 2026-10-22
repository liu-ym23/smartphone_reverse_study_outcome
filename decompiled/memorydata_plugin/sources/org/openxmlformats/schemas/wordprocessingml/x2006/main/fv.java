package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fv extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fv> f20178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20179b = null;

    static {
        DocumentFactory<fv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "hdra530doctype");
        f20178a = r0;
        f20179b = r0.getType();
    }

    au getHdr();
}
