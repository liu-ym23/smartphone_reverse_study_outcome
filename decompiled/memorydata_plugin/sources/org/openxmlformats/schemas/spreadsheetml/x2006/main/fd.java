package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface fd extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<fd> f19679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19680b = null;

    static {
        DocumentFactory<fd> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablestyleelementa658type");
        f19679a = r0;
        f19680b = r0.getType();
    }

    long getDxfId();

    long getSize();

    STTableStyleType.Enum getType();

    boolean isSetDxfId();

    boolean isSetSize();
}
