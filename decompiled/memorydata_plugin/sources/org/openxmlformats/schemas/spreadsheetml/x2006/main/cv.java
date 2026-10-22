package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface cv extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<cv> f19555a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19556b = null;

    static {
        DocumentFactory<cv> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctnumfmt3870type");
        f19555a = r0;
        f19556b = r0.getType();
    }

    String getFormatCode();

    long getNumFmtId();

    void setFormatCode(String r1);

    void setNumFmtId(long r1);
}
