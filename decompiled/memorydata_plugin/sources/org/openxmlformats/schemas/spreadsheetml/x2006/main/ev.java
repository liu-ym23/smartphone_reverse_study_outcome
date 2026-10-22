package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface ev extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<ev> f19663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19664b = null;

    static {
        DocumentFactory<ev> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctstylesheet4257type");
        f19663a = r0;
        f19664b = r0.getType();
    }

    h getBorders();

    t getCellStyleXfs();

    w getCellXfs();

    ae getColors();

    bd getDxfs();

    bx getFills();

    cd getFonts();

    cw getNumFmts();

    ff getTableStyles();

    void setBorders(h r1);

    void setCellStyleXfs(t r1);

    void setCellXfs(w r1);

    void setDxfs(bd r1);

    void setFills(bx r1);

    void setFonts(cd r1);

    void setNumFmts(cw r1);
}
