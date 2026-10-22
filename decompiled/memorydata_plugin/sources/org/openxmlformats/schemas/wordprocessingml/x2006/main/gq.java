package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface gq extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<gq> f20216a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20217b = null;

    static {
        DocumentFactory<gq> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "settings9dd1doctype");
        f20216a = r0;
        f20217b = r0.getType();
    }

    dt getSettings();
}
