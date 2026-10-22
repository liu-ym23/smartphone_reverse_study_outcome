package com.microsoft.schemas.office.word;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<b> f5753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5754b = null;

    static {
        DocumentFactory<b> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctwrapbc3btype");
        f5753a = r0;
        f5754b = r0.getType();
    }

    STWrapType.Enum getType();
}
