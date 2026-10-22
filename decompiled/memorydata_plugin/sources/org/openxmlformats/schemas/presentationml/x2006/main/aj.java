package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface aj extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<aj> f19217a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19218b = null;

    static {
        DocumentFactory<aj> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctslided7betype");
        f19217a = r0;
        f19218b = r0.getType();
    }

    h addNewCSld();

    org.openxmlformats.schemas.drawingml.x2006.main.j addNewClrMapOvr();
}
