package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface an extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<an> f18704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18705b = null;

    static {
        DocumentFactory<an> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgroupshapeproperties8690type");
        f18704a = r0;
        f18705b = r0.getType();
    }

    ao addNewXfrm();

    ao getXfrm();
}
