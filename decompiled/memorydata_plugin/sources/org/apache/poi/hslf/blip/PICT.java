package org.apache.poi.hslf.blip;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class PICT extends Metafile {
    private static final c LOG = null;

    static {
        LOG = b.a(PICT.class);
    }

    @Deprecated
    public PICT() {
        this(new EscherContainerRecord(), new EscherBSERecord());
    }

    public PICT(EscherContainerRecord r1, EscherBSERecord r2) {
        super(r1, r2);
    }

    private byte[] read(byte[] r7, int r8) {
        Metafile.Header r6 = new Metafile.Header();
        r6.read(r7, r8);
        long r0 = ((long) r8) + ((long) r6.getSize());
        UnsynchronizedByteArrayInputStream r9 = new UnsynchronizedByteArrayInputStream(r7);
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        r9.close();     // Catch: Throwable -> L55
    L57:
        throw th;
    L55:
        th = move-exception;
        th.addSuppressed(th);
        goto L57
    L4:
        if (r0 != IOUtils.skipFully(r9, r0)) goto L49;
        byte[] r10 = new byte[4096];     // Catch: Throwable -> L50
        UnsynchronizedByteArrayOutputStream r1 = new UnsynchronizedByteArrayOutputStream(r6.getWmfSize());     // Catch: Throwable -> L50
        InflaterInputStream r2 = new InflaterInputStream(r9);     // Catch: Throwable -> L22 Exception -> L24
    L58:
        int r3 = r2.read(r10);     // Catch: Throwable -> L14
        if (r3 < 0) goto L12;
        r1.write(r10, 0, r3);     // Catch: Throwable -> L14
        Arrays.fill(r10, (byte) 0);     // Catch: Throwable -> L14
        goto L58
    L12:
        r2.close();     // Catch: Throwable -> L22 Exception -> L24
    L37:
        byte[] r11 = r1.toByteArray();     // Catch: Throwable -> L22
        r1.close();     // Catch: Throwable -> L50
        r9.close();
        return r11;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: Throwable -> L22 Exception -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22 Exception -> L24
    L24:
        e = move-exception;
        int r4 = 4095;
    L26:
        if (r4 < 0) goto L30;
        if (r10[r4] != 0) goto L30;
        r4 = r4 - 1;     // Catch: Throwable -> L22
    L30:
        int r5 = r4 + 1;     // Catch: Throwable -> L22
        if (r5 > 0) goto L33;
    L36:
        LOG.atError().a(e).a("PICT zip-stream is invalid, read as much as possible. Uncompressed length of header: {} / Read bytes: {}", v.a(r6.getWmfSize()), v.a(r1.size()));     // Catch: Throwable -> L22
        goto L37
    L33:
        if (r6.getWmfSize() <= r1.size()) goto L35;
        r5 = Math.min(r5, r6.getWmfSize() - r1.size());     // Catch: Throwable -> L22
    L35:
        r1.write(r10, 0, r5);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L45
    L47:
        throw th;     // Catch: Throwable -> L50
    L45:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L50
        goto L47
    L49:
        throw new EOFException();     // Catch: Throwable -> L50
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public byte[] getData() {
        byte[] r0 = getRawData();
        UnsynchronizedByteArrayOutputStream r1 = new UnsynchronizedByteArrayOutputStream();     // Catch: IOException -> L16
        r1.write(new byte[512]);     // Catch: Throwable -> L8
        r1.write(read(r0, getUIDInstanceCount() * 16));     // Catch: Throwable -> L8
        byte[] r3 = r1.toByteArray();     // Catch: Throwable -> L8
        r1.close();     // Catch: IOException -> L16
        return r3;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: IOException -> L16
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        throw new HSLFException(e);
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public int getSignature() {
        if (getUIDInstanceCount() != 1) goto L5;
        return 21536;
    L5:
        return 21552;
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public PictureData.PictureType getType() {
        return PictureData.PictureType.PICT;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public void setSignature(int r2) {
        if (r2 != 21536) goto L5;
        int r3 = 1;
    L10:
        setUIDInstanceCount(r3);
        return;
    L5:
        if (r2 != 21552) goto L8;
        r3 = 2;
        goto L10
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid instance/signature value for PICT");
    }
}
