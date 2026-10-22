package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface aj extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<aj> f19914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19915b = null;

    static {
        DocumentFactory<aj> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfftextinput3155type");
        f19914a = r0;
        f19915b = r0.getType();
    }

    CTFFTextType getType();
}
