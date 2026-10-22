package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;

/* JADX INFO: loaded from: classes7.dex */
public class ZipPackagePart extends PackagePart {
    private ZipArchiveEntry zipEntry;

    ZipPackagePart(OPCPackage r2, ZipArchiveEntry r3, PackagePartName r4, String r5, boolean r6) {
        super(r2, r4, new ContentType(r5), r6);
        this.zipEntry = r3;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        return ((ZipPackage) ZeusTransformUtils.preCheckCast(this._container, ZipPackage.class, "com.obric.memorydata.plugin")).getZipArchive().getInputStream(this.zipEntry);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        return null;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        return this.zipEntry.getSize();
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream r2) {
        return new ZipPartMarshaller().marshall(this, r2);
    }
}
