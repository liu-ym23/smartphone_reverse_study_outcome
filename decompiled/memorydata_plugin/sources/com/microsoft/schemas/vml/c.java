package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<c> f5779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f5780b = null;

    static {
        DocumentFactory<c> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfillb241type");
        f5779a = r0;
        f5780b = r0.getType();
    }

    STFillType.Enum getType();
}
