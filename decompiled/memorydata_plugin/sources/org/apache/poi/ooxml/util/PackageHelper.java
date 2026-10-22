package org.apache.poi.ooxml.util;

import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;

/* JADX INFO: loaded from: classes7.dex */
public final class PackageHelper {
    public static OPCPackage open(InputStream r1) {
        return open(r1, false);
    }

    public static OPCPackage open(InputStream r2, boolean r3) {
        OPCPackage r0 = OPCPackage.open(r2);     // Catch: Throwable -> L6 InvalidFormatException -> L8
        if (r3 == false) goto L5;
        r2.close();
    L5:
        return r0;
    L6:
        th = move-exception;
        if (r3 == false) goto L13;
        r2.close();
    L13:
        throw th;
    L8:
        e = move-exception;
        throw new POIXMLException(e);     // Catch: Throwable -> L6
    }
}
