package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface c extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<c> f19511a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19512b = null;

    static {
        DocumentFactory<c> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctbookviewf677type");
        f19511a = r0;
        f19512b = r0.getType();
    }

    long getActiveTab();

    void setActiveTab(long r1);
}
