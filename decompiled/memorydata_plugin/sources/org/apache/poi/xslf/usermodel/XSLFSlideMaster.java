package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.presentationml.x2006.main.an;
import org.openxmlformats.schemas.presentationml.x2006.main.bq;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFSlideMaster extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private an _slide;

    public XSLFSlideMaster(PackagePart r4) {
        super(r4);
        InputStream r5 = getPackagePart().getInputStream();
        this._slide = ((bq) ZeusTransformUtils.preCheckCast(bq.f19283a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), bq.class, "com.obric.memorydata.plugin")).getSldMaster();     // Catch: Throwable -> L7
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

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "sldMaster";
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public /* bridge */ /* synthetic */ XmlObject getXmlObject() {
        return getXmlObject();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public an getXmlObject() {
        return this._slide;
    }
}
