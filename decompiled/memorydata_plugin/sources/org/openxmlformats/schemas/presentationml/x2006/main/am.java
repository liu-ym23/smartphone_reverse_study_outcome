package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface am extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<am> f19223a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19224b = null;

    static {
        DocumentFactory<am> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctslidelayouteb34type");
        f19223a = r0;
        f19224b = r0.getType();
    }

    STSlideLayoutType.Enum getType();
}
