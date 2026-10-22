package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ck;
import org.openxmlformats.schemas.drawingml.x2006.main.cl;
import org.openxmlformats.schemas.drawingml.x2006.main.df;

/* JADX INFO: loaded from: classes8.dex */
public interface ah extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ah> f19213a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19214b = null;

    static {
        DocumentFactory<ah> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctshapecfcetype");
        f19213a = r0;
        f19214b = r0.getType();
    }

    ai addNewNvSpPr();

    ck addNewSpPr();

    ai getNvSpPr();

    ck getSpPr();

    df getTxBody();

    void setNvSpPr(ai r1);

    void setSpPr(ck r1);

    void setStyle(cl r1);

    void setTxBody(df r1);
}
