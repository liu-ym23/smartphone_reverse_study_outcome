package org.apache.poi.hslf.blip;

import java.io.IOException;
import java.util.zip.InflaterInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class EMF extends Metafile {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    @Deprecated
    public EMF() {
        this(new EscherContainerRecord(), new EscherBSERecord());
    }

    public EMF(EscherContainerRecord r1, EscherBSERecord r2) {
        super(r1, r2);
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public byte[] getData() {
        byte[] r7 = getRawData();
        Metafile.Header r0 = new Metafile.Header();
        r0.read(r7, 16);
        UnsynchronizedByteArrayInputStream r1 = new UnsynchronizedByteArrayInputStream(r7);     // Catch: IOException -> L35
        InflaterInputStream r8 = new InflaterInputStream(r1);     // Catch: Throwable -> L27
        UnsynchronizedByteArrayOutputStream r2 = new UnsynchronizedByteArrayOutputStream();     // Catch: Throwable -> L19
        IOUtils.skipFully(r1, ((long) r0.getSize()) + 16);     // Catch: Throwable -> L11
        IOUtils.copy(r8, r2);     // Catch: Throwable -> L11
        byte[] r3 = r2.toByteArray();     // Catch: Throwable -> L11
        r2.close();     // Catch: Throwable -> L19
        r8.close();     // Catch: Throwable -> L27
        r1.close();     // Catch: IOException -> L35
        return r3;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: IOException -> L35
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L35
    L35:
        e = move-exception;
        throw new HSLFException(e);
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public int getSignature() {
        if (getUIDInstanceCount() != 1) goto L5;
        return 15680;
    L5:
        return 15696;
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public PictureData.PictureType getType() {
        return PictureData.PictureType.EMF;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public void setSignature(int r2) {
        if (r2 != 15680) goto L5;
        int r3 = 1;
    L10:
        setUIDInstanceCount(r3);
        return;
    L5:
        if (r2 != 15696) goto L8;
        r3 = 2;
        goto L10
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid instance/signature value for EMF");
    }
}
