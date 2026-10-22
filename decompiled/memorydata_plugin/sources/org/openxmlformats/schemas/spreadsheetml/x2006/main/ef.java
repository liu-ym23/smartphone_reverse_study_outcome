package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ef extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ef> f19631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19632b = null;

    static {
        DocumentFactory<ef> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsheet4dbetype");
        f19631a = r0;
        f19632b = r0.getType();
    }

    String getId();

    String getName();

    long getSheetId();

    void setId(String r1);

    void setName(String r1);

    void setSheetId(long r1);
}
