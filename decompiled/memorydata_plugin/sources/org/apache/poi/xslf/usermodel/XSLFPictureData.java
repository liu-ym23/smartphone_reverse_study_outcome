package org.apache.poi.xslf.usermodel;

import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.image.ImageHeaderBitmap;
import org.apache.poi.sl.image.ImageHeaderEMF;
import org.apache.poi.sl.image.ImageHeaderPICT;
import org.apache.poi.sl.image.ImageHeaderWMF;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class XSLFPictureData extends POIXMLDocumentPart implements PictureData {
    private static int MAX_IMAGE_SIZE = 100000000;
    private Long checksum;
    private int index;
    private Dimension origSize;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFPictureData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType = null;

        static {
            int[] r0 = new int[PictureData.PictureType.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType = r0;
            r0[PictureData.PictureType.EMF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.WMF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.PICT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.JPEG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.PNG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.DIB.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.GIF.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.EPS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.BMP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.WPG.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.WDP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.TIFF.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[PictureData.PictureType.SVG.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    static {
    }

    public XSLFPictureData() {
        this.index = -1;
    }

    public XSLFPictureData(PackagePart r1) {
        super(r1);
        this.index = -1;
    }

    public static int getMaxImageSize() {
        return MAX_IMAGE_SIZE;
    }

    public void cacheProperties() {
        if (this.origSize != null) goto L5;
    L6:
        byte[] r0 = getData();
        this.checksum = Long.valueOf(IOUtils.calculateChecksum(r0));
        PictureData.PictureType r1 = getType();
        if (r1 != null) goto L10;
        this.origSize = new Dimension(1, 1);
        return;
    L10:
        int r2 = AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$PictureData$PictureType[r1.ordinal()];
        if (r2 != 1) goto L13;
        Dimension r3 = new ImageHeaderEMF(r0, 0).getSize();
    L20:
        this.origSize = r3;
        return;
    L13:
        if (r2 != 2) goto L15;
        r3 = new ImageHeaderWMF(r0, 0).getSize();
        goto L20
    L15:
        if (r2 == 3) goto L17;
        r3 = new ImageHeaderBitmap(r0, 0).getSize();
        goto L20
    L17:
        r3 = new ImageHeaderPICT(r0, 0).getSize();
        goto L20
    L5:
        if (this.checksum == null) goto L6;
    }

    public String getContentType() {
        return getPackagePart().getContentType();
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public byte[] getData() {
        InputStream r2 = getInputStream();     // Catch: IOException -> L16
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
        if (r2 != null) goto L23;
    L15:
        throw th;     // Catch: IOException -> L16
    L23:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        throw new POIXMLException(e);
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public Dimension getImageDimension() {
        cacheProperties();
        return this.origSize;
    }

    public InputStream getInputStream() {
        return getPackagePart().getInputStream();
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public PictureData.PictureType getType() {
        String r1 = getContentType();
        if (XSLFRelation.IMAGE_EMF.getContentType().equals(r1) == false) goto L7;
        return PictureData.PictureType.EMF;
    L7:
        if (XSLFRelation.IMAGE_WMF.getContentType().equals(r1) == false) goto L11;
        return PictureData.PictureType.WMF;
    L11:
        if (XSLFRelation.IMAGE_PICT.getContentType().equals(r1) == false) goto L15;
        return PictureData.PictureType.PICT;
    L15:
        if (XSLFRelation.IMAGE_JPEG.getContentType().equals(r1) == false) goto L19;
        return PictureData.PictureType.JPEG;
    L19:
        if (XSLFRelation.IMAGE_PNG.getContentType().equals(r1) == false) goto L23;
        return PictureData.PictureType.PNG;
    L23:
        if (XSLFRelation.IMAGE_DIB.getContentType().equals(r1) == false) goto L27;
        return PictureData.PictureType.DIB;
    L27:
        if (XSLFRelation.IMAGE_GIF.getContentType().equals(r1) == false) goto L31;
        return PictureData.PictureType.GIF;
    L31:
        if (XSLFRelation.IMAGE_EPS.getContentType().equals(r1) == false) goto L35;
        return PictureData.PictureType.EPS;
    L35:
        if (XSLFRelation.IMAGE_BMP.getContentType().equals(r1) == false) goto L39;
        return PictureData.PictureType.BMP;
    L39:
        if (XSLFRelation.IMAGE_WPG.getContentType().equals(r1) == false) goto L43;
        return PictureData.PictureType.WPG;
    L43:
        if (XSLFRelation.IMAGE_WDP.getContentType().equals(r1) == false) goto L47;
        return PictureData.PictureType.WDP;
    L47:
        if (XSLFRelation.IMAGE_TIFF.getContentType().equals(r1) == false) goto L51;
        return PictureData.PictureType.TIFF;
    L51:
        if (XSLFRelation.IMAGE_SVG.getContentType().equals(r1) == true) goto L53;
        return null;
    L53:
        return PictureData.PictureType.SVG;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void prepareForCommit() {
    }
}
