package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cg extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cg> f19525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19526b = null;

    static {
        DocumentFactory<cg> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cthyperlink0c85type");
        f19525a = r0;
        f19526b = r0.getType();
    }

    String getId();

    String getLocation();

    String getRef();

    void setId(String r1);
}
