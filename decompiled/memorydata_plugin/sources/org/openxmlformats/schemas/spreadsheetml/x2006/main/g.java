package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface g extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<g> f19725a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19726b = null;

    static {
        DocumentFactory<g> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctborderpre497type");
        f19725a = r0;
        f19726b = r0.getType();
    }

    ac getColor();

    STBorderStyle.Enum getStyle();

    boolean isSetColor();
}
