package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dd extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dd> f20050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20051b = null;

    static {
        DocumentFactory<dd> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsdtcell626dtype");
        f20050a = r0;
        f20051b = r0.getType();
    }

    dg getSdtContent();

    Cdo getSdtPr();
}
