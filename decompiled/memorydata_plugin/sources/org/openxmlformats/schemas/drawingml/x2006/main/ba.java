package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface ba extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ba> f18732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18733b = null;

    static {
        DocumentFactory<ba> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctnonvisualdrawingprops8fb0type");
        f18732a = r0;
        f18733b = r0.getType();
    }

    String getDescr();

    long getId();

    String getName();

    void setId(long r1);

    void setName(String r1);
}
