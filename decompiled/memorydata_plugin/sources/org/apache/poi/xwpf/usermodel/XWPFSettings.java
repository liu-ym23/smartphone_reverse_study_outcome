package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dt;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.gq;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFSettings extends POIXMLDocumentPart {
    private dt ctSettings;

    public XWPFSettings() {
        this.ctSettings = (dt) ZeusTransformUtils.preCheckCast(dt.f20082a.newInstance(), dt.class, "com.obric.memorydata.plugin");
    }

    public XWPFSettings(PackagePart r1) {
        super(r1);
    }

    private void readFrom(InputStream r3) {
        this.ctSettings = ((gq) ZeusTransformUtils.preCheckCast(gq.f20216a.parse(r3, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), gq.class, "com.obric.memorydata.plugin")).getSettings();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Failed to read data from input-stream", e);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        if (this.ctSettings == null) goto L19;
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(dt.f20083b.getName().getNamespaceURI(), "settings"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.ctSettings.save(r1, r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L26;
        r1.close();
        return;
    L26:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r1 != null) goto L24;
    L17:
        throw th;
    L24:
        r1.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    L19:
        throw new IllegalStateException("Unable to write out settings that were never read in!");
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        super.onDocumentRead();
        InputStream r0 = getPackagePart().getInputStream();
        readFrom(r0);     // Catch: Throwable -> L7
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
}
