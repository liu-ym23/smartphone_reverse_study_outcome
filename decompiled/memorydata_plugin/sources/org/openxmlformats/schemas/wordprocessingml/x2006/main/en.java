package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface en extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<en> f20122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20123b = null;

    static {
        DocumentFactory<en> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "cttbllayouttype6830type");
        f20122a = r0;
        f20123b = r0.getType();
    }

    STTblLayoutType.Enum getType();
}
