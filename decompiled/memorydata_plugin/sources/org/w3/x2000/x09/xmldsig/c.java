package org.w3.x2000.x09.xmldsig;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface c extends XmlBase64Binary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleTypeFactory<c> f20299a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20300b = null;

    static {
        SimpleTypeFactory<c> r0 = new SimpleTypeFactory(TypeSystemHolder.typeSystem, "digestvaluetype010atype");
        f20299a = r0;
        f20300b = r0.getType();
    }
}
