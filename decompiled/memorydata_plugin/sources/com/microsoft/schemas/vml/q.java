package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface q extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<q> f5807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5808b = null;

    static {
        DocumentFactory<q> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctstrokee2f6type");
        f5807a = r0;
        f5808b = r0.getType();
    }

    void setJoinstyle(STStrokeJoinStyle.Enum r1);
}
