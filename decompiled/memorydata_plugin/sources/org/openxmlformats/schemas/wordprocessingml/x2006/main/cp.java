package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cp extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cp> f20022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20023b = null;

    static {
        DocumentFactory<cp> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctprooferr1e07type");
        f20022a = r0;
        f20023b = r0.getType();
    }

    STProofErr.Enum getType();
}
