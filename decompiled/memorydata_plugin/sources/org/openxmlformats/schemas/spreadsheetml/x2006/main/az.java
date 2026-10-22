package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface az extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<az> f19457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19458b = null;

    static {
        DocumentFactory<az> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdefinednamesce48type");
        f19457a = r0;
        f19458b = r0.getType();
    }

    ay[] getDefinedNameArray();

    void setDefinedNameArray(ay[] r1);
}
