package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface dm extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dm> f18864a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18865b = null;

    static {
        DocumentFactory<dm> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttextcharbullet3c20type");
        f18864a = r0;
        f18865b = r0.getType();
    }

    String getChar();
}
