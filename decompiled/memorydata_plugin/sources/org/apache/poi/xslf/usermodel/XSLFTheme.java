package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.main.bh;
import org.openxmlformats.schemas.drawingml.x2006.main.fw;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTheme extends POIXMLDocumentPart {
    private bh _theme;

    XSLFTheme() {
        this._theme = (bh) ZeusTransformUtils.preCheckCast(bh.f18746a.newInstance(), bh.class, "com.obric.memorydata.plugin");
    }

    public XSLFTheme(PackagePart r4) {
        super(r4);
        InputStream r5 = getPackagePart().getInputStream();
        this._theme = ((fw) ZeusTransformUtils.preCheckCast(fw.f18972a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), fw.class, "com.obric.memorydata.plugin")).getTheme();     // Catch: Throwable -> L7
        if (r5 == null) goto L22;
        r5.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r5 != null) goto L16;
    L15:
        throw th;
    L16:
        r5.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public final void commit() {
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "theme"));
        OutputStream r1 = getPackagePart().getOutputStream();
        getXmlObject().save(r1, r0);     // Catch: Throwable -> L7
        if (r1 == null) goto L22;
        r1.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L16;
    L15:
        throw th;
    L16:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public bh getXmlObject() {
        return this._theme;
    }
}
