package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fe extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fe> f19681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19682b = null;

    static {
        DocumentFactory<fe> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablestyleinfo499atype");
        f19681a = r0;
        f19682b = r0.getType();
    }

    String getName();

    boolean getShowColumnStripes();

    boolean getShowFirstColumn();

    boolean getShowLastColumn();

    boolean getShowRowStripes();
}
