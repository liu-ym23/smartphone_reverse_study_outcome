package org.apache.poi.xssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fs;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.m;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.n;

/* JADX INFO: loaded from: classes7.dex */
public class CalculationChain extends POIXMLDocumentPart {
    private n chain;

    public CalculationChain() {
        this.chain = (n) ZeusTransformUtils.preCheckCast(n.f19775a.newInstance(), n.class, "com.obric.memorydata.plugin");
    }

    public CalculationChain(PackagePart r2) {
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

    public n getCTCalcChain() {
        return this.chain;
    }

    public void readFrom(InputStream r3) {
        this.chain = ((fs) ZeusTransformUtils.preCheckCast(fs.f19709a.parse(r3, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fs.class, "com.obric.memorydata.plugin")).getCalcChain();     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }

    public void removeItem(int r5, String r6) {
        m[] r0 = this.chain.getCArray();
        int r1 = -1;
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L25;
        if (r0[r2].isSetI() == false) goto L8;
        r1 = r0[r2].getI();
    L8:
        if (r1 != r5) goto L19;
        if (r0[r2].getR().equals(r6) == false) goto L19;
        if (r0[r2].isSetI() == true) goto L14;
    L18:
        this.chain.removeC(r2);
        return;
    L14:
        if (r2 >= (r0.length - 1)) goto L18;
        int r7 = r2 + 1;
        if (r0[r7].isSetI() == true) goto L18;
        r0[r7].setI(r1);
    L19:
        r2 = r2 + 1;
        goto L4
    }

    public void writeTo(OutputStream r4) {
        fs r0 = (fs) ZeusTransformUtils.preCheckCast(fs.f19709a.newInstance(), fs.class, "com.obric.memorydata.plugin");
        r0.setCalcChain(this.chain);
        r0.save(r4, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }
}
