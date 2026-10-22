package org.apache.poi.openxml4j.opc.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.util.TempFile;

/* JADX INFO: loaded from: classes7.dex */
public final class TempFilePackagePart extends PackagePart {
    private static final c LOG = null;
    private File tempFile;

    static {
        LOG = b.a(TempFilePackagePart.class);
    }

    public TempFilePackagePart(OPCPackage r2, PackagePartName r3, String r4, boolean r5) {
        super(r2, r3, new ContentType(r4), r5);
        this.tempFile = TempFile.createTempFile("poi-package-part", ".tmp");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void clear() {
        OutputStream r2 = getOutputStreamImpl();     // Catch: IOException -> L17
        r2.write(new byte[0]);     // Catch: Throwable -> L8
        if (r2 == null) goto L27;
        r2.close();     // Catch: IOException -> L17
        return;
    L27:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r2 != null) goto L24;
    L16:
        throw th;     // Catch: IOException -> L17
    L24:
        r2.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L17
    L17:
        e = move-exception;
        LOG.atWarn().a("Failed to clear data in temp file", e);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        return new FileInputStream(this.tempFile);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        return new FileOutputStream(this.tempFile);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        return this.tempFile.length();
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream r2) {
        return new ZipPartMarshaller().marshall(this, r2);
    }
}
