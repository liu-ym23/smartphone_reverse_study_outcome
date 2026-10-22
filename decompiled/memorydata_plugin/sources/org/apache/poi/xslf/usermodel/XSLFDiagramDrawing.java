package org.apache.poi.xslf.usermodel;

import com.microsoft.schemas.office.drawing.x2008.diagram.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFDiagramDrawing extends POIXMLDocumentPart {
    private final f _drawingDoc;

    XSLFDiagramDrawing() {
        this._drawingDoc = (f) ZeusTransformUtils.preCheckCast(f.f5675a.newInstance(), f.class, "com.obric.memorydata.plugin");
    }

    XSLFDiagramDrawing(PackagePart r1) {
        super(r1);
        this._drawingDoc = readPackagePart(r1);
    }

    private static f readPackagePart(PackagePart r3) {
        InputStream r4 = r3.getInputStream();
        f r0 = (f) ZeusTransformUtils.preCheckCast(f.f5675a.parse(r4), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        if (r4 == null) goto L6;
        r4.close();
    L6:
        return r0;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r4 != null) goto L16;
    L15:
        throw th;
    L16:
        r4.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public f getDrawingDocument() {
        return this._drawingDoc;
    }
}
