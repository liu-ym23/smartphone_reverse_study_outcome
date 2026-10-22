package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bh extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bh> f19473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19474b = null;

    static {
        DocumentFactory<bh> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternalcell5dd6type");
        f19473a = r0;
        f19474b = r0.getType();
    }

    String getR();

    void setR(String r1);

    void setV(String r1);
}
