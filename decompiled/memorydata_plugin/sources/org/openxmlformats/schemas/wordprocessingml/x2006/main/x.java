package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface x extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<x> f20248a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20249b = null;

    static {
        DocumentFactory<x> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdocgride8b4type");
        f20248a = r0;
        f20249b = r0.getType();
    }

    STDocGrid.Enum getType();
}
