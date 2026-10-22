package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ev extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ev> f20134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20135b = null;

    static {
        DocumentFactory<ev> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttblwidthec40type");
        f20134a = r0;
        f20135b = r0.getType();
    }

    STTblWidth.Enum getType();

    void setType(STTblWidth.Enum r1);

    void setW(Object r1);
}
