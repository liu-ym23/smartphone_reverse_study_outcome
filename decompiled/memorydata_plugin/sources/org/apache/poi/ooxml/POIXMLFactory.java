package org.apache.poi.ooxml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;

/* JADX INFO: loaded from: classes7.dex */
public abstract class POIXMLFactory {
    private static final c LOGGER = null;

    static {
        LOGGER = b.a(POIXMLFactory.class);
    }

    public POIXMLFactory() {
    }

    public POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart r4, PackagePart r5) {
        PackageRelationship r0 = getPackageRelationship(r4, r5);
        String r1 = r0.getRelationshipType();
        POIXMLRelation r3 = getDescriptor(r1);
        if (r3 != null) goto L19;
    L14:
        LOGGER.atDebug().a("using default POIXMLDocumentPart for {}", r0.getRelationshipType());     // Catch: Throwable -> L16
        return new POIXMLDocumentPart(r4, r5);
    L19:
    L16:
        e = move-exception;
        throw new POIXMLException(e.getMessage(), e);
    L5:
        if ("http://schemas.openxmlformats.org/officeDocument/2006/relationships/package".equals(r1) == true) goto L14;
        POIXMLRelation.ParentPartConstructor r2 = r3.getParentPartConstructor();     // Catch: Throwable -> L16
        if (r2 != null) goto L9;
        POIXMLRelation.PackagePartConstructor r6 = r3.getPackagePartConstructor();     // Catch: Throwable -> L16
        if (r6 == null) goto L14;
        return r6.init(r5);
    L9:
        return r2.init(r4, r5);
    }

    public abstract POIXMLRelation getDescriptor(String r1);

    public PackageRelationship getPackageRelationship(POIXMLDocumentPart r3, PackagePart r4) {
        String r2 = r4.getPartName().getName();     // Catch: InvalidFormatException -> L10
        Iterator<PackageRelationship> r5 = r3.getPackagePart().getRelationships().iterator();     // Catch: InvalidFormatException -> L10
    L4:
        if (r5.hasNext() == false) goto L9;
        PackageRelationship r6 = (PackageRelationship) ZeusTransformUtils.preCheckCast(r5.next(), PackageRelationship.class, "com.obric.memorydata.plugin");     // Catch: InvalidFormatException -> L10
        if (r6.getTargetURI().toASCIIString().equalsIgnoreCase(r2) == false) goto L4;
        return r6;
    L9:
        throw new POIXMLException("package part isn't a child of the parent document.");
    L10:
        e = move-exception;
        throw new POIXMLException("error while determining package relations", e);
    }

    public POIXMLDocumentPart newDocumentPart(POIXMLRelation r1) {
        if (r1 == null) goto L8;
        if (r1.getNoArgConstructor() == null) goto L8;
        return r1.getNoArgConstructor().init();
    L8:
        throw new POIXMLException("can't initialize POIXMLDocumentPart");
    }
}
