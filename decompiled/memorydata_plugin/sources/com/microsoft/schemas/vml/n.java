package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface n extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<n> f5801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5802b = null;

    static {
        DocumentFactory<n> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshadowdfdetype");
        f5801a = r0;
        f5802b = r0.getType();
    }

    STShadowType.Enum getType();
}
