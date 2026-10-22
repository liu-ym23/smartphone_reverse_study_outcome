package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dx extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dx> f20090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20091b = null;

    static {
        DocumentFactory<dx> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsimplefieldacaatype");
        f20090a = r0;
        f20091b = r0.getType();
    }

    cq[] getRArray();
}
