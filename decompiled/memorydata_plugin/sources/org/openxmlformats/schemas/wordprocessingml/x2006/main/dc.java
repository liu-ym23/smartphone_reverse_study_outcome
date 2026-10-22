package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dc extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dc> f20048a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20049b = null;

    static {
        DocumentFactory<dc> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsdtblock221etype");
        f20048a = r0;
        f20049b = r0.getType();
    }

    df getSdtContent();

    Cdo getSdtPr();
}
