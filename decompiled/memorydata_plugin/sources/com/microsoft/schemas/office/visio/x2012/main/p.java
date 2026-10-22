package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface p extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<p> f5731a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5732b = null;

    static {
        DocumentFactory<p> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "rowtype03d1type");
        f5731a = r0;
        f5732b = r0.getType();
    }

    a[] getCellArray();

    boolean getDel();

    long getIX();

    String getT();

    boolean isSetDel();
}
