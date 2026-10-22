package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ao extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ao> f19227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19228b = null;

    static {
        DocumentFactory<ao> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctslidemasteridlist0b63type");
        f19227a = r0;
        f19228b = r0.getType();
    }

    List<ap> getSldMasterIdList();
}
