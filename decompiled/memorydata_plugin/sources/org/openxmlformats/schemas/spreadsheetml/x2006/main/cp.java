package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cp extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cp> f19543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19544b = null;

    static {
        DocumentFactory<cp> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctlegacydrawing49f4type");
        f19543a = r0;
        f19544b = r0.getType();
    }

    String getId();

    void setId(String r1);
}
