package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface i extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<i> f20220a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20221b = null;

    static {
        DocumentFactory<i> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctbordercdfctype");
        f20220a = r0;
        f20221b = r0.getType();
    }

    void setVal(STBorder.Enum r1);
}
