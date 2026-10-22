package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface aw extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<aw> f19453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19454b = null;

    static {
        DocumentFactory<aw> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctdatavalidation9d0ctype");
        f19453a = r0;
        f19454b = r0.getType();
    }

    STDataValidationType.Enum getType();
}
