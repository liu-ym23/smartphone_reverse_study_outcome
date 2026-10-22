package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface af extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<af> f19209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19210b = null;

    static {
        DocumentFactory<af> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpresentation56cbtype");
        f19209a = r0;
        f19210b = r0.getType();
    }

    ak getSldIdLst();

    ao getSldMasterIdLst();

    boolean isSetSldIdLst();

    boolean isSetSldMasterIdLst();
}
