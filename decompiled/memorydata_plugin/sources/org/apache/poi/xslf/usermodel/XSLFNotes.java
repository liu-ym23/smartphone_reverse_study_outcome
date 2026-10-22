package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.Notes;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.presentationml.x2006.main.aa;
import org.openxmlformats.schemas.presentationml.x2006.main.bf;

/* JADX INFO: loaded from: classes7.dex */
public final class XSLFNotes extends XSLFSheet implements Notes<XSLFShape, XSLFTextParagraph> {
    private aa _notes;

    XSLFNotes() {
        this._notes = prototype();
    }

    XSLFNotes(PackagePart r4) {
        super(r4);
        InputStream r5 = getPackagePart().getInputStream();
        this._notes = ((bf) ZeusTransformUtils.preCheckCast(bf.f19263a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), bf.class, "com.obric.memorydata.plugin")).getNotes();     // Catch: Throwable -> L7
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

    private static aa prototype() {
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(aa.f19199a.newInstance(), aa.class, "com.obric.memorydata.plugin");
        r0.addNewCSld().addNewSpTree();
        return r0;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "notes";
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public /* bridge */ /* synthetic */ XmlObject getXmlObject() {
        return getXmlObject();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public aa getXmlObject() {
        return this._notes;
    }
}
