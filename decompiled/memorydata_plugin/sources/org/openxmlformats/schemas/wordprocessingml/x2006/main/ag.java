package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ag extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ag> f19908a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19909b = null;

    static {
        DocumentFactory<ag> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctffcheckboxf3a5type");
        f19908a = r0;
        f19909b = r0.getType();
    }

    bu getDefault();
}
