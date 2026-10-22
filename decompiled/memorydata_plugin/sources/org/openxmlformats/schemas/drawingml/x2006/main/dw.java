package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface dw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dw> f18884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18885b = null;

    static {
        DocumentFactory<dw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttextparagraphpropertiesdd05type");
        f18884a = r0;
        f18885b = r0.getType();
    }

    dd getBuAutoNum();

    dm getBuChar();

    int getLvl();

    boolean isSetBuAutoNum();

    boolean isSetBuChar();

    boolean isSetBuFont();

    boolean isSetBuNone();
}
