package org.apache.poi.ooxml;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.impl.common.SystemCache;

/* JADX INFO: loaded from: classes7.dex */
public abstract class POIXMLDocument extends POIXMLDocumentPart implements Closeable {
    private OPCPackage pkg;
    private POIXMLProperties properties;

    public POIXMLDocument(OPCPackage r1) {
        super(r1);
        init(r1);
    }

    private void init(OPCPackage r1) {
        this.pkg = r1;
        SystemCache.get().setSaxLoader(null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OPCPackage r0 = this.pkg;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getPackageAccess() != PackageAccess.READ) goto L7;
        this.pkg.revert();
    L8:
        this.pkg = null;
        return;
    L7:
        this.pkg.close();
        goto L8
    }

    public PackagePart getCorePart() {
        return getPackagePart();
    }

    public OPCPackage getPackage() {
        return this.pkg;
    }

    public POIXMLProperties getProperties() {
        if (this.properties != null) goto L10;
        this.properties = new POIXMLProperties(this.pkg);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        throw new POIXMLException(e);
    L10:
        return this.properties;
    }

    public final void load(POIXMLFactory r2) {
        HashMap r0 = new HashMap();
        read(r2, r0);     // Catch: OpenXML4JException -> L6
        onDocumentRead();
        r0.clear();
        return;
    L6:
        e = move-exception;
        throw new POIXMLException(e);
    }

    public final void write(OutputStream r3) {
        OPCPackage r0 = getPackage();
        if (r0 == null) goto L7;
        HashSet r1 = new HashSet();
        onSave(r1);
        r1.clear();
        getProperties().commit();
        r0.save(r3);
        return;
    L7:
        throw new IOException("Cannot write data, document seems to have been closed already");
    }
}
