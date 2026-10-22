package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ec;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ed;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.gr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.w;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFStyles extends POIXMLDocumentPart {
    private ed ctStyles;
    private XWPFDefaultParagraphStyle defaultParaStyle;
    private XWPFDefaultRunStyle defaultRunStyle;
    private XWPFLatentStyles latentStyles;
    private final List<XWPFStyle> listStyle;

    public XWPFStyles() {
        this.listStyle = new ArrayList();
    }

    public XWPFStyles(PackagePart r1) {
        super(r1);
        this.listStyle = new ArrayList();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        if (this.ctStyles == null) goto L19;
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(ed.f20105b.getName().getNamespaceURI(), "styles"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.ctStyles.save(r1, r0);     // Catch: Throwable -> L9
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
        throw new IllegalStateException("Unable to write out styles that were never read in!");
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r0 = getPackagePart().getInputStream();     // Catch: XmlException -> L16
        setStyles(((gr) ZeusTransformUtils.preCheckCast(gr.f20218a.parse(r0, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), gr.class, "com.obric.memorydata.plugin")).getStyles());     // Catch: Throwable -> L7
        this.latentStyles = new XWPFLatentStyles(this.ctStyles.getLatentStyles(), this);     // Catch: Throwable -> L7
        if (r0 == null) goto L26;
        r0.close();     // Catch: XmlException -> L16
        return;
    L26:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L24;
    L15:
        throw th;     // Catch: XmlException -> L16
    L24:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlException -> L16
    L16:
        e = move-exception;
        throw new POIXMLException("Unable to read styles", e);
    }

    public void setStyles(ed r6) {
        ed r7 = (ed) ZeusTransformUtils.wrapperContextForParams(r6, ed.class, "com.obric.memorydata.plugin");
        this.ctStyles = r7;
        ec[] r8 = r7.getStyleArray();
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        ec r2 = r8[r1];
        this.listStyle.add(new XWPFStyle(r2, this));
        r1 = r1 + 1;
        goto L3
    L6:
        if (this.ctStyles.isSetDocDefaults() == false) goto L19;
        w r9 = this.ctStyles.getDocDefaults();
        if (r9.isSetRPrDefault() == false) goto L13;
        if (r9.getRPrDefault().isSetRPr() == false) goto L13;
        this.defaultRunStyle = new XWPFDefaultRunStyle(r9.getRPrDefault().getRPr());
    L13:
        if (r9.isSetPPrDefault() == true) goto L15;
        return;
    L15:
        if (r9.getPPrDefault().isSetPPr() == false) goto L21;
        this.defaultParaStyle = new XWPFDefaultParagraphStyle(r9.getPPrDefault().getPPr());
        return;
    L21:
        return;
    }
}
