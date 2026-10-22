package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface db extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<db> f18842a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18843b = null;

    static {
        DocumentFactory<db> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttablestylelist4bdctype");
        f18842a = r0;
        f18843b = r0.getType();
    }

    List<cz> getTblStyleList();
}
