package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.openxmlformats.schemas.presentationml.x2006.main.bd;
import org.openxmlformats.schemas.presentationml.x2006.main.f;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFCommentAuthors extends POIXMLDocumentPart {
    private final f _authors;

    XSLFCommentAuthors() {
        this._authors = ((bd) ZeusTransformUtils.preCheckCast(bd.f19259a.newInstance(), bd.class, "com.obric.memorydata.plugin")).addNewCmAuthorLst();
    }

    XSLFCommentAuthors(PackagePart r4) {
        super(r4);
        InputStream r5 = getPackagePart().getInputStream();
        this._authors = ((bd) ZeusTransformUtils.preCheckCast(bd.f19259a.parse(r5, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), bd.class, "com.obric.memorydata.plugin")).getCmAuthorLst();     // Catch: Throwable -> L7
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
}
