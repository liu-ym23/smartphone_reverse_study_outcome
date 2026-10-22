package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cb extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cb> f19515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19516b = null;

    static {
        DocumentFactory<cb> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfontschemebf5dtype");
        f19515a = r0;
        f19516b = r0.getType();
    }

    STFontScheme.Enum getVal();

    void setVal(STFontScheme.Enum r1);
}
