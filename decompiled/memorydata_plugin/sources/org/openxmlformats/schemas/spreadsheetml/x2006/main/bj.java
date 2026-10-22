package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface bj extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bj> f19477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19478b = null;

    static {
        DocumentFactory<bj> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctexternaldefinednamesccf3type");
        f19477a = r0;
        f19478b = r0.getType();
    }

    bi[] getDefinedNameArray();
}
