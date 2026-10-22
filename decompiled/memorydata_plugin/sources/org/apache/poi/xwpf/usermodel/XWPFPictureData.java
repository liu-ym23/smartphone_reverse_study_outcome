package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFPictureData extends POIXMLDocumentPart {
    private static int MAX_IMAGE_SIZE = 100000000;
    protected static final POIXMLRelation[] RELATIONS = null;
    private Long checksum;

    static {
        POIXMLRelation[] r0 = new POIXMLRelation[14];
        RELATIONS = r0;
        r0[PictureType.EMF.ooxmlId] = XWPFRelation.IMAGE_EMF;
        r0[PictureType.WMF.ooxmlId] = XWPFRelation.IMAGE_WMF;
        r0[PictureType.PICT.ooxmlId] = XWPFRelation.IMAGE_PICT;
        r0[PictureType.JPEG.ooxmlId] = XWPFRelation.IMAGE_JPEG;
        r0[PictureType.PNG.ooxmlId] = XWPFRelation.IMAGE_PNG;
        r0[PictureType.DIB.ooxmlId] = XWPFRelation.IMAGE_DIB;
        r0[PictureType.GIF.ooxmlId] = XWPFRelation.IMAGE_GIF;
        r0[PictureType.TIFF.ooxmlId] = XWPFRelation.IMAGE_TIFF;
        r0[PictureType.EPS.ooxmlId] = XWPFRelation.IMAGE_EPS;
        r0[PictureType.BMP.ooxmlId] = XWPFRelation.IMAGE_BMP;
        r0[PictureType.WPG.ooxmlId] = XWPFRelation.IMAGE_WPG;
        r0[PictureType.WDP.ooxmlId] = XWPFRelation.HDPHOTO_WDP;
    }

    public XWPFPictureData() {
    }

    public XWPFPictureData(PackagePart r1) {
        super(r1);
    }

    public static int getMaxImageSize() {
        return MAX_IMAGE_SIZE;
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, XWPFPictureData.class) == true) goto L12;
        return false;
    L12:
        XWPFPictureData r5 = (XWPFPictureData) ZeusTransformUtils.preCheckCast(r4, XWPFPictureData.class, "com.obric.memorydata.plugin");
        PackagePart r0 = r5.getPackagePart();
        PackagePart r2 = getPackagePart();
        if (r0 == null) goto L15;
        if (r2 != null) goto L15;
    L17:
        return false;
    L15:
        if (r0 != null) goto L18;
        if (r2 != null) goto L17;
    L18:
        if (r2 == null) goto L29;
        OPCPackage r1 = r0.getPackage();
        OPCPackage r3 = r2.getPackage();
        if (r1 == null) goto L22;
        if (r3 != null) goto L22;
    L24:
        return false;
    L22:
        if (r1 != null) goto L25;
        if (r3 != null) goto L24;
    L25:
        if (r3 == null) goto L29;
        if (r3.equals(r1) == true) goto L29;
        return false;
    L29:
        Long r6 = r5.getChecksum();
        Long r7 = getChecksum();
        if (r7 != null) goto L34;
        if (r6 == null) goto L37;
        return false;
    L37:
        return Arrays.equals(getData(), r5.getData());
    L34:
        if (r7.equals(r6) == true) goto L37;
        return false;
    }

    public Long getChecksum() {
        if (this.checksum != null) goto L22;
        InputStream r0 = getPackagePart().getInputStream();     // Catch: IOException -> L18
        this.checksum = Long.valueOf(IOUtils.calculateChecksum(r0));     // Catch: Throwable -> L9
        if (r0 == null) goto L22;
        r0.close();     // Catch: IOException -> L18
        goto L22
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r0 != null) goto L24;
    L17:
        throw th;     // Catch: IOException -> L18
    L24:
        r0.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L18
    L18:
        e = move-exception;
        throw new POIXMLException(e);
    L22:
        return this.checksum;
    }

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

    public int hashCode() {
        Long r0 = getChecksum();
        if (r0 != null) goto L6;
        return super.hashCode();
    L6:
        return r0.hashCode();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        super.onDocumentRead();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void prepareForCommit() {
    }

    public String suggestFileExtension() {
        return getPackagePart().getPartName().getExtension();
    }
}
