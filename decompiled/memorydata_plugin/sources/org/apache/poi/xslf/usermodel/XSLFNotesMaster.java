package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.MasterSheet;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.presentationml.x2006.main.bg;
import org.openxmlformats.schemas.presentationml.x2006.main.x;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFNotesMaster extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private x _slide;

    XSLFNotesMaster() {
        this._slide = prototype();
    }

    public XSLFNotesMaster(PackagePart r4) {
        super(r4);
        InputStream r5 = getPackagePart().getInputStream();
        this._slide = ((bg) ZeusTransformUtils.preCheckCast(bg.f19265a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), bg.class, "com.obric.memorydata.plugin")).getNotesMaster();     // Catch: Throwable -> L7
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

    private static x prototype() {
        InputStream r0 = XSLFNotesMaster.class.getResourceAsStream("notesMaster.xml");
        if (r0 == null) goto L14;
        x r1 = ((bg) ZeusTransformUtils.preCheckCast(bg.f19265a.parse(r0, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), bg.class, "com.obric.memorydata.plugin")).getNotesMaster();     // Catch: Throwable -> L7
        r0.close();     // Catch: Exception -> L10
        return r1;
    L7:
        th = move-exception;
        r0.close();     // Catch: Exception -> L10
        throw th;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        throw new POIXMLException("Can't initialize NotesMaster", e);
    L14:
        throw new POIXMLException("Missing resource 'notesMaster.xml'");
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "notesMaster";
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public /* bridge */ /* synthetic */ XmlObject getXmlObject() {
        return getXmlObject();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public x getXmlObject() {
        return this._slide;
    }
}
