package org.apache.poi.xssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.er;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.gp;

/* JADX INFO: loaded from: classes7.dex */
public class SingleXmlCells extends POIXMLDocumentPart {
    private er singleXMLCells;

    public SingleXmlCells() {
        this.singleXMLCells = (er) ZeusTransformUtils.preCheckCast(er.f19655a.newInstance(), er.class, "com.obric.memorydata.plugin");
    }

    public SingleXmlCells(PackagePart r2) {
        super(r2);
        InputStream r3 = r2.getInputStream();
        readFrom(r3);     // Catch: Throwable -> L7
        if (r3 == null) goto L22;
        r3.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r3 != null) goto L20;
    L15:
        throw th;
    L20:
        r3.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        OutputStream r0 = getPackagePart().getOutputStream();
        writeTo(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public void readFrom(InputStream r3) {
        this.singleXMLCells = ((gp) ZeusTransformUtils.preCheckCast(gp.f19751a.parse(r3, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), gp.class, "com.obric.memorydata.plugin")).getSingleXmlCells();     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }

    public void writeTo(OutputStream r4) {
        gp r0 = (gp) ZeusTransformUtils.preCheckCast(gp.f19751a.newInstance(), gp.class, "com.obric.memorydata.plugin");
        r0.setSingleXmlCells(this.singleXMLCells);
        r0.save(r4, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }
}
