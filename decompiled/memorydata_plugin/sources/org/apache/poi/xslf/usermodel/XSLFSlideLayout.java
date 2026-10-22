package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.presentationml.x2006.main.am;
import org.openxmlformats.schemas.presentationml.x2006.main.bp;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFSlideLayout extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private final am _layout;

    public XSLFSlideLayout(PackagePart r4) {
        super(r4);
        InputStream r5 = getPackagePart().getInputStream();
        this._layout = ((bp) ZeusTransformUtils.preCheckCast(bp.f19281a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), bp.class, "com.obric.memorydata.plugin")).getSldLayout();     // Catch: Throwable -> L7
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
        return "sldLayout";
    }

    public SlideLayout getType() {
        return SlideLayout.values()[this._layout.getType().intValue() - 1];
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public /* bridge */ /* synthetic */ XmlObject getXmlObject() {
        return getXmlObject();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public am getXmlObject() {
        return this._layout;
    }
}
