package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.openxmlformats.schemas.presentationml.x2006.main.be;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFComments extends POIXMLDocumentPart {
    private final be doc;

    XSLFComments() {
        this.doc = (be) ZeusTransformUtils.preCheckCast(be.f19261a.newInstance(), be.class, "com.obric.memorydata.plugin");
    }

    XSLFComments(PackagePart r4) {
        super(r4);
        InputStream r5 = getPackagePart().getInputStream();
        this.doc = (be) ZeusTransformUtils.preCheckCast(be.f19261a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), be.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
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
        if (r5 != null) goto L20;
    L15:
        throw th;
    L20:
        r5.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }
}
