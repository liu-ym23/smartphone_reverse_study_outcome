package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: loaded from: classes8.dex */
public interface by extends XmlObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentFactory<by> f19507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SchemaType f19508b = null;

    static {
        DocumentFactory<by> r0 = new DocumentFactory(TypeSystemHolder.typeSystem, "ctfont14d8type");
        f19507a = r0;
        f19508b = r0.getType();
    }

    ac addNewColor();

    bz addNewFamily();

    ca addNewName();

    cb addNewScheme();

    cc addNewSz();

    e getBArray(int r1);

    cm getCharsetArray(int r1);

    ac getColorArray(int r1);

    e getCondenseArray(int r1);

    e getExtendArray(int r1);

    bz getFamilyArray(int r1);

    e getIArray(int r1);

    ca getNameArray(int r1);

    e getOutlineArray(int r1);

    cb getSchemeArray(int r1);

    e getShadowArray(int r1);

    e getStrikeArray(int r1);

    cc getSzArray(int r1);

    fg getUArray(int r1);

    fh getVertAlignArray(int r1);

    int sizeOfBArray();

    int sizeOfCharsetArray();

    int sizeOfColorArray();

    int sizeOfCondenseArray();

    int sizeOfExtendArray();

    int sizeOfFamilyArray();

    int sizeOfIArray();

    int sizeOfNameArray();

    int sizeOfOutlineArray();

    int sizeOfSchemeArray();

    int sizeOfShadowArray();

    int sizeOfStrikeArray();

    int sizeOfSzArray();

    int sizeOfUArray();

    int sizeOfVertAlignArray();
}
