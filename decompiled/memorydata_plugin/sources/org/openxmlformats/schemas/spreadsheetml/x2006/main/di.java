package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface di extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<di> f19583a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19584b = null;

    static {
        DocumentFactory<di> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpatternfill7452type");
        f19583a = r0;
        f19584b = r0.getType();
    }

    ac getBgColor();

    ac getFgColor();

    STPatternType.Enum getPatternType();

    void setPatternType(STPatternType.Enum r1);
}
