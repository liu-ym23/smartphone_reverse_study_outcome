package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface eb extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<eb> f20100a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20101b = null;

    static {
        DocumentFactory<eb> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctstring9c37type");
        f20100a = r0;
        f20101b = r0.getType();
    }

    String getVal();
}
