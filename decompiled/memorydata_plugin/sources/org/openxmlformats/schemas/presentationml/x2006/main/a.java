package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface a extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<a> f19197a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19198b = null;

    static {
        DocumentFactory<a> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctapplicationnonvisualdrawingprops2fb6type");
        f19197a = r0;
        f19198b = r0.getType();
    }

    ae addNewPh();

    ae getPh();

    boolean isSetPh();
}
