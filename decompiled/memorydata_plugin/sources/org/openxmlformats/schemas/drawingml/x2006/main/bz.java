package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface bz extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<bz> f18782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f18783b = null;

    static {
        DocumentFactory<bz> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctpositivesize2d0147type");
        f18782a = r0;
        f18783b = r0.getType();
    }

    long getCx();

    long getCy();

    void setCx(long r1);

    void setCy(long r1);
}
