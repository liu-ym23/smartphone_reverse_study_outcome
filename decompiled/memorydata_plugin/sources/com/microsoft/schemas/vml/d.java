package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<d> f5781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5782b = null;

    static {
        DocumentFactory<d> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctformulas808btype");
        f5781a = r0;
        f5782b = r0.getType();
    }
}
