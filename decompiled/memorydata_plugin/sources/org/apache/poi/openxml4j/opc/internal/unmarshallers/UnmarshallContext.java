package org.apache.poi.openxml4j.opc.internal.unmarshallers;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;

/* JADX INFO: loaded from: classes7.dex */
public final class UnmarshallContext {
    private OPCPackage _package;
    private PackagePartName partName;
    private ZipArchiveEntry zipEntry;

    public UnmarshallContext(OPCPackage r1, PackagePartName r2) {
        this._package = r1;
        this.partName = r2;
    }

    OPCPackage getPackage() {
        return this._package;
    }

    PackagePartName getPartName() {
        return this.partName;
    }

    ZipArchiveEntry getZipEntry() {
        return this.zipEntry;
    }
}
