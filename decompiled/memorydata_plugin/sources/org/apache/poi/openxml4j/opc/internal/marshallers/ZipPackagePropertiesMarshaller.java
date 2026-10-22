package org.apache.poi.openxml4j.opc.internal.marshallers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;

/* JADX INFO: loaded from: classes7.dex */
public final class ZipPackagePropertiesMarshaller extends PackagePropertiesMarshaller {
    public ZipPackagePropertiesMarshaller() {
    }

    @Override // org.apache.poi.openxml4j.opc.internal.marshallers.PackagePropertiesMarshaller, org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart r4, OutputStream r5) {
        if (ZeusTransformUtils.instanceOf(r5, ZipArchiveOutputStream.class) == false) goto L16;
        ZipArchiveOutputStream r0 = (ZipArchiveOutputStream) ZeusTransformUtils.preCheckCast(r5, ZipArchiveOutputStream.class, "com.obric.memorydata.plugin");
        r0.putArchiveEntry(new ZipArchiveEntry(ZipHelper.getZipItemNameFromOPCName(r4.getPartName().getURI().toString())));     // Catch: IOException -> L12
        super.marshall(r4, r5);     // Catch: Throwable -> L9
        boolean r3 = StreamHelper.saveXmlInStream(this.xmlDoc, r5);     // Catch: Throwable -> L9
        r0.closeArchiveEntry();     // Catch: IOException -> L12
        return r3;
    L9:
        th = move-exception;
        r0.closeArchiveEntry();     // Catch: IOException -> L12
        throw th;     // Catch: IOException -> L12
    L12:
        e = move-exception;
        throw new OpenXML4JException(e.getLocalizedMessage(), e);
    L16:
        throw new IllegalArgumentException("ZipOutputStream expected!");
    }
}
