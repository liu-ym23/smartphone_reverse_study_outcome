package org.apache.poi.openxml4j.opc.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.w3c.dom.Document;

/* JADX INFO: loaded from: classes7.dex */
public class ZipContentTypeManager extends ContentTypeManager {
    private static final c LOG = null;

    static {
        LOG = b.a(ZipContentTypeManager.class);
    }

    public ZipContentTypeManager(InputStream r1, OPCPackage r2) {
        super(r1, r2);
    }

    @Override // org.apache.poi.openxml4j.opc.internal.ContentTypeManager
    public boolean saveImpl(Document r2, OutputStream r3) {
        Document r1 = (Document) ZeusTransformUtils.wrapperContextForParams(r2, Document.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ZipArchiveOutputStream.class) == false) goto L5;
        ZipArchiveOutputStream r4 = (ZipArchiveOutputStream) ZeusTransformUtils.preCheckCast(r3, ZipArchiveOutputStream.class, "com.obric.memorydata.plugin");
    L19:
        r4.putArchiveEntry(new ZipArchiveEntry("[Content_Types].xml"));     // Catch: IOException -> L14
        boolean r5 = StreamHelper.saveXmlInStream(r1, r4);     // Catch: Throwable -> L11
        r4.closeArchiveEntry();     // Catch: IOException -> L14
        return r5;
    L11:
        th = move-exception;
        r4.closeArchiveEntry();     // Catch: IOException -> L14
        throw th;     // Catch: IOException -> L14
    L14:
        e = move-exception;
        LOG.atError().a(e).a("Cannot write: [Content_Types].xml in Zip !");
        return false;
    L5:
        r4 = new ZipArchiveOutputStream(r3);
        goto L19
    }
}
