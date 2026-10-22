package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ef;

/* JADX INFO: loaded from: classes8.dex */
public interface q extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<q> f19313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19314b = null;

    static {
        DocumentFactory<q> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctgraphicalobjectframebfeatype");
        f19313a = r0;
        f19314b = r0.getType();
    }

    org.openxmlformats.schemas.drawingml.x2006.main.aj getGraphic();

    ef getXfrm();
}
