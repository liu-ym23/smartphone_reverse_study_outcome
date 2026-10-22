package org.apache.poi.openxml4j.opc.internal.marshallers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Iterator;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.StreamHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes7.dex */
public final class ZipPartMarshaller implements PartMarshaller {
    private static final c LOG = null;

    static {
        LOG = b.a(ZipPartMarshaller.class);
    }

    public ZipPartMarshaller() {
    }

    public static boolean marshallRelationshipPart(PackageRelationshipCollection r9, PackagePartName r10, ZipArchiveOutputStream r11) {
        Document r0 = DocumentHelper.createDocument();
        Element r2 = r0.createElementNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationships");
        r0.appendChild(r2);
        URI r3 = PackagingURIHelper.getSourcePartUriFromRelationshipPartUri(r10.getURI());
        Iterator<PackageRelationship> r12 = r9.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        PackageRelationship r4 = (PackageRelationship) ZeusTransformUtils.preCheckCast(r12.next(), PackageRelationship.class, "com.obric.memorydata.plugin");
        Element r5 = r0.createElementNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");
        r2.appendChild(r5);
        r5.setAttribute("Id", r4.getId());
        r5.setAttribute("Type", r4.getRelationshipType());
        URI r6 = r4.getTargetURI();
        if (r4.getTargetMode() != TargetMode.EXTERNAL) goto L8;
        String r7 = r6.toString();
        r5.setAttribute("TargetMode", "External");
    L9:
        r5.setAttribute("Target", r7);
        goto L4
    L8:
        r7 = PackagingURIHelper.relativizeURI(r3, r4.getTargetURI(), true).toString();
        goto L9
    L10:
        r0.normalize();
        r11.putArchiveEntry(new ZipArchiveEntry(ZipHelper.getZipURIFromOPCName(r10.getURI().toASCIIString()).getPath()));     // Catch: IOException -> L18
        boolean r13 = StreamHelper.saveXmlInStream(r0, r11);     // Catch: Throwable -> L15
        r11.closeArchiveEntry();     // Catch: IOException -> L18
        return r13;
    L15:
        th = move-exception;
        r11.closeArchiveEntry();     // Catch: IOException -> L18
        throw th;     // Catch: IOException -> L18
    L18:
        e = move-exception;
        LOG.atError().a(e).a("Cannot create zip entry {}", r10);
        return false;
    }

    @Override // org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart r5, OutputStream r6) {
        if (ZeusTransformUtils.instanceOf(r6, ZipArchiveOutputStream.class) == true) goto L5;
        LOG.atError().a("Unexpected class {}", r6.getClass().getName());
        throw new OpenXML4JException("ZipOutputStream expected !");
    L5:
        if (r5.getSize() == 0) goto L7;
    L9:
        ZipArchiveOutputStream r4 = (ZipArchiveOutputStream) ZeusTransformUtils.preCheckCast(r6, ZipArchiveOutputStream.class, "com.obric.memorydata.plugin");
        r4.putArchiveEntry(new ZipArchiveEntry(ZipHelper.getZipItemNameFromOPCName(r5.getPartName().getURI().getPath())));     // Catch: IOException -> L32
        InputStream r7 = r5.getInputStream();     // Catch: Throwable -> L29
        IOUtils.copy(r7, r4);     // Catch: Throwable -> L20
        if (r7 == null) goto L15;
        r7.close();     // Catch: Throwable -> L29
    L15:
        r4.closeArchiveEntry();     // Catch: IOException -> L32
        if (r5.hasRelationships() == false) goto L19;
        PackagePartName r8 = PackagingURIHelper.getRelationshipPartName(r5.getPartName());
        marshallRelationshipPart(r5.getRelationships(), r8, r4);
    L19:
        return true;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r7 != null) goto L39;
    L28:
        throw th;     // Catch: Throwable -> L29
    L39:
        r7.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r4.closeArchiveEntry();     // Catch: IOException -> L32
        throw th;     // Catch: IOException -> L32
    L32:
        e = move-exception;
        LOG.atError().a(e).a("Cannot write: {}: in ZIP", r5.getPartName());
        return false;
    L7:
        if (r5.getPartName().getName().equals(XSSFRelation.SHARED_STRINGS.getDefaultFileName()) == false) goto L9;
        return true;
    }
}
