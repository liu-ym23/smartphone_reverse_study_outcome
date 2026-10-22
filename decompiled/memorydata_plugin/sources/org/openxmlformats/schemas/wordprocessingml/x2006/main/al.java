package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface al extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<al> f19918a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19919b = null;

    static {
        DocumentFactory<al> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfldchare83etype");
        f19918a = r0;
        f19919b = r0.getType();
    }

    ah getFfData();

    STFldCharType.Enum getFldCharType();
}
