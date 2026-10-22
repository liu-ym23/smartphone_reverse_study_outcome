package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ct extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ct> f20030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f20031b = null;

    static {
        DocumentFactory<ct> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrprdefault5ebbtype");
        f20030a = r0;
        f20031b = r0.getType();
    }

    cr getRPr();

    boolean isSetRPr();
}
