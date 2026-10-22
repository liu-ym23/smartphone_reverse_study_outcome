package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFPictureData extends POIXMLDocumentPart implements PictureData {
    private static int MAX_IMAGE_SIZE = 100000000;
    protected static final POIXMLRelation[] RELATIONS = null;

    static {
        POIXMLRelation[] r0 = new POIXMLRelation[13];
        RELATIONS = r0;
        r0[2] = XSSFRelation.IMAGE_EMF;
        r0[3] = XSSFRelation.IMAGE_WMF;
        r0[4] = XSSFRelation.IMAGE_PICT;
        r0[5] = XSSFRelation.IMAGE_JPEG;
        r0[6] = XSSFRelation.IMAGE_PNG;
        r0[7] = XSSFRelation.IMAGE_DIB;
        r0[8] = XSSFRelation.IMAGE_GIF;
        r0[9] = XSSFRelation.IMAGE_TIFF;
        r0[10] = XSSFRelation.IMAGE_EPS;
        r0[11] = XSSFRelation.IMAGE_BMP;
        r0[12] = XSSFRelation.IMAGE_WPG;
    }

    public XSSFPictureData() {
    }

    public XSSFPictureData(PackagePart r1) {
        super(r1);
    }

    public static int getMaxImageSize() {
        return MAX_IMAGE_SIZE;
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public byte[] getData() {
        InputStream r2 = getPackagePart().getInputStream();     // Catch: IOException -> L16
        byte[] r0 = IOUtils.toByteArrayWithMaxLength(r2, getMaxImageSize());     // Catch: Throwable -> L7
        if (r2 == null) goto L6;
        r2.close();     // Catch: IOException -> L16
    L6:
        return r0;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r2 != null) goto L24;
    L15:
        throw th;     // Catch: IOException -> L16
    L24:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        throw new POIXMLException(e);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void prepareForCommit() {
    }

    @Override // org.apache.poi.ss.usermodel.PictureData
    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }
}
