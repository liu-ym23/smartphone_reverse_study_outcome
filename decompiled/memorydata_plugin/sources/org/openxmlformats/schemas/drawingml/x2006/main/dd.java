package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface dd extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dd> f18846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18847b = null;

    static {
        DocumentFactory<dd> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttextautonumberbulletd602type");
        f18846a = r0;
        f18847b = r0.getType();
    }

    int getStartAt();

    STTextAutonumberScheme.Enum getType();

    boolean isSetStartAt();
}
