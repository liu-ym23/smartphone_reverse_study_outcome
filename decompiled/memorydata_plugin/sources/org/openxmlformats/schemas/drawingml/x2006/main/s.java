package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface s extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<s> f18998a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18999b = null;

    static {
        DocumentFactory<s> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cteffectcontainer2e21type");
        f18998a = r0;
        f18999b = r0.getType();
    }

    STEffectContainerType$Enum getType();
}
