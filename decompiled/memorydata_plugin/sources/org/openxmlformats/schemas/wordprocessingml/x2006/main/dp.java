package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dp extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dp> f20074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20075b = null;

    static {
        DocumentFactory<dp> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsdtrun5c60type");
        f20074a = r0;
        f20075b = r0.getType();
    }

    dh getSdtContent();

    Cdo getSdtPr();
}
