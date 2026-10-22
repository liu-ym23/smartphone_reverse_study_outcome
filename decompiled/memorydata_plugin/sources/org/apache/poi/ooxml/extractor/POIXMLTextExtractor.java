package org.apache.poi.ooxml.extractor;

import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;

/* JADX INFO: loaded from: classes7.dex */
public interface POIXMLTextExtractor extends POITextExtractor {
    @Override // org.apache.poi.extractor.POITextExtractor, java.io.Closeable, java.lang.AutoCloseable
    default void close() {
        if (isCloseFilesystem() == false) goto L8;
        OPCPackage r1 = getPackage();
        if (r1 == null) goto L9;
        r1.revert();
        return;
    L9:
        return;
    }

    POIXMLDocument getDocument();

    default OPCPackage getPackage() {
        POIXMLDocument r0 = getDocument();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPackage();
    }
}
