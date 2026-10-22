package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface w extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<w> f20246a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20247b = null;

    static {
        DocumentFactory<w> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdocdefaults2ea8type");
        f20246a = r0;
        f20247b = r0.getType();
    }

    bz getPPrDefault();

    ct getRPrDefault();

    boolean isSetPPrDefault();

    boolean isSetRPrDefault();
}
