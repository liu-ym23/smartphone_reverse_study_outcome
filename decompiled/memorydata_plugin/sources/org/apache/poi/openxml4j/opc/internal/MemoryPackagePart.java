package org.apache.poi.openxml4j.opc.internal;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;

/* JADX INFO: loaded from: classes7.dex */
public final class MemoryPackagePart extends PackagePart {
    protected byte[] data;

    public MemoryPackagePart(OPCPackage r2, PackagePartName r3, String r4, boolean r5) {
        super(r2, r3, new ContentType(r4), r5);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void clear() {
        this.data = null;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        if (this.data != null) goto L6;
        this.data = new byte[0];
    L6:
        return new UnsynchronizedByteArrayInputStream(this.data);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        return new MemoryPackagePartOutputStream(this);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        byte[] r2 = this.data;
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.length;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream r2) {
        return new ZipPartMarshaller().marshall(this, r2);
    }
}
