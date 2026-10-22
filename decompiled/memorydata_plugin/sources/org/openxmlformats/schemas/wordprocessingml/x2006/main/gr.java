package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface gr extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<gr> f20218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20219b = null;

    static {
        DocumentFactory<gr> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "styles2732doctype");
        f20218a = r0;
        f20219b = r0.getType();
    }

    ed getStyles();
}
