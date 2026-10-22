package org.apache.poi.hslf.blip;

import java.io.IOException;
import java.util.zip.InflaterInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.sl.image.ImageHeaderWMF;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class WMF extends Metafile {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    @Deprecated
    public WMF() {
        this(new EscherContainerRecord(), new EscherBSERecord());
    }

    public WMF(EscherContainerRecord r1, EscherBSERecord r2) {
        super(r1, r2);
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public byte[] getData() {
        byte[] r0 = getRawData();
        UnsynchronizedByteArrayInputStream r1 = new UnsynchronizedByteArrayInputStream(r0);     // Catch: IOException -> L25
        Metafile.Header r2 = new Metafile.Header();     // Catch: Throwable -> L17
        r2.read(r0, getUIDInstanceCount() * 16);     // Catch: Throwable -> L17
        IOUtils.skipFully(r1, ((long) r2.getSize()) + (((long) getUIDInstanceCount()) * 16));     // Catch: Throwable -> L17
        ImageHeaderWMF r9 = new ImageHeaderWMF(r2.getBounds());     // Catch: Throwable -> L17
        UnsynchronizedByteArrayOutputStream r3 = new UnsynchronizedByteArrayOutputStream();     // Catch: Throwable -> L17
        r9.write(r3);     // Catch: Throwable -> L17
        InflaterInputStream r10 = new InflaterInputStream(r1);     // Catch: Throwable -> L17
        IOUtils.copy(r10, r3);     // Catch: Throwable -> L9
        r10.close();     // Catch: Throwable -> L17
        byte[] r11 = r3.toByteArray();     // Catch: Throwable -> L17
        r1.close();     // Catch: IOException -> L25
        return r11;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Throwable -> L17
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L25
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L25
    L25:
        e = move-exception;
        throw new HSLFException(e);
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public int getSignature() {
        if (getUIDInstanceCount() != 1) goto L5;
        return 8544;
    L5:
        return 8560;
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public PictureData.PictureType getType() {
        return PictureData.PictureType.WMF;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public void setSignature(int r2) {
        if (r2 != 8544) goto L5;
        int r3 = 1;
    L10:
        setUIDInstanceCount(r3);
        return;
    L5:
        if (r2 != 8560) goto L8;
        r3 = 2;
        goto L10
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid instance/signature value for WMF");
    }
}
