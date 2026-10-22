package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fg extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fg> f19685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19686b = null;

    static {
        DocumentFactory<fg> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctunderlineproperty8e20type");
        f19685a = r0;
        f19686b = r0.getType();
    }

    STUnderlineValues.Enum getVal();

    void setVal(STUnderlineValues.Enum r1);
}
