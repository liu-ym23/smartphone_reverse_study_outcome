package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.ao;
import org.openxmlformats.schemas.drawingml.x2006.main.ba;
import org.openxmlformats.schemas.drawingml.x2006.main.bv;
import org.openxmlformats.schemas.drawingml.x2006.main.bz;
import org.openxmlformats.schemas.presentationml.x2006.main.aj;
import org.openxmlformats.schemas.presentationml.x2006.main.bo;
import org.openxmlformats.schemas.presentationml.x2006.main.s;
import org.openxmlformats.schemas.presentationml.x2006.main.t;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes7.dex */
public final class XSLFSlide extends XSLFSheet implements Slide<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final aj _slide;

    static {
    }

    XSLFSlide() {
        this._slide = prototype();
    }

    XSLFSlide(PackagePart r3) {
        super(r3);
        InputStream r4 = getPackagePart().getInputStream();     // Catch: SAXException -> L18
        Document r0 = DocumentHelper.readDocument(r4);     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        r4.close();     // Catch: SAXException -> L18
    L7:
        this._slide = ((bo) ZeusTransformUtils.preCheckCast(bo.f19279a.parse(r0, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), bo.class, "com.obric.memorydata.plugin")).getSld();
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r4 != null) goto L21;
    L17:
        throw th;     // Catch: SAXException -> L18
    L21:
        r4.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: SAXException -> L18
    L18:
        e = move-exception;
        throw new IOException(e);
    }

    private static aj prototype() {
        aj r0 = (aj) ZeusTransformUtils.preCheckCast(aj.f19217a.newInstance(), aj.class, "com.obric.memorydata.plugin");
        s r1 = r0.addNewCSld().addNewSpTree();
        t r2 = r1.addNewNvGrpSpPr();
        ba r3 = r2.addNewCNvPr();
        r3.setId(1);
        r3.setName("");
        r2.addNewCNvGrpSpPr();
        r2.addNewNvPr();
        ao r4 = r1.addNewGrpSpPr().addNewXfrm();
        bv r5 = r4.addNewOff();
        r5.setX(0);
        r5.setY(0);
        bz r6 = r4.addNewExt();
        r6.setCx(0);
        r6.setCy(0);
        bv r7 = r4.addNewChOff();
        r7.setX(0);
        r7.setY(0);
        bz r8 = r4.addNewChExt();
        r8.setCx(0);
        r8.setCy(0);
        r0.addNewClrMapOvr().addNewMasterClrMapping();
        return r0;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "sld";
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public int getSlideNumber() {
        int r1 = getSlideShow().getSlides().indexOf(this);
        if (r1 != (-1)) goto L6;
        return r1;
    L6:
        return r1 + 1;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public String getTitle() {
        XSLFTextShape r1 = getTextShapeByType(Placeholder.TITLE);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getText();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public /* bridge */ /* synthetic */ XmlObject getXmlObject() {
        return getXmlObject();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public aj getXmlObject() {
        return this._slide;
    }
}
