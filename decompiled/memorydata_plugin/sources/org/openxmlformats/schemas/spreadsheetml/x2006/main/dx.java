package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface dx extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<dx> f19613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19614b = null;

    static {
        DocumentFactory<dx> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctrpreltecc2type");
        f19613a = r0;
        f19614b = r0.getType();
    }

    e addNewB();

    cm addNewCharset();

    ac addNewColor();

    e addNewCondense();

    e addNewExtend();

    cm addNewFamily();

    e addNewI();

    e addNewOutline();

    ca addNewRFont();

    cb addNewScheme();

    e addNewShadow();

    e addNewStrike();

    cc addNewSz();

    fg addNewU();

    fh addNewVertAlign();

    ca getRFontArray(int r1);

    void removeRFont(int r1);

    int sizeOfRFontArray();
}
