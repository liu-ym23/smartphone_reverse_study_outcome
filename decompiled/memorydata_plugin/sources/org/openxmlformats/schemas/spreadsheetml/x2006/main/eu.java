package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface eu extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<eu> f19661a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19662b = null;

    static {
        DocumentFactory<eu> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctsst44f3type");
        f19661a = r0;
        f19662b = r0.getType();
    }

    eb addNewSi();

    long getCount();

    eb[] getSiArray();

    long getUniqueCount();

    void setCount(long r1);

    void setUniqueCount(long r1);
}
