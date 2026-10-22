package org.apache.poi.openxml4j.opc.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.openxml4j.util.ZipArchiveThresholdInputStream;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.poifs.filesystem.FileMagic;

/* JADX INFO: loaded from: classes7.dex */
public final class ZipHelper {

    /* JADX INFO: renamed from: org.apache.poi.openxml4j.opc.internal.ZipHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = null;

        static {
            int[] r0 = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = r0;
            r0[FileMagic.OLE2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.XML.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static ZipArchiveEntry getCorePropertiesZipEntry(ZipPackage r1) {
        PackageRelationship r2 = r1.getRelationshipsByType("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties").getRelationship(0);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new ZipArchiveEntry(r2.getTargetURI().getPath());
    }

    public static String getOPCNameFromZipItemName(String r2) {
        if (r2 == null) goto L9;
        if (r2.startsWith("/") == false) goto L7;
        return r2;
    L7:
        return "/" + r2;
    L9:
        throw new IllegalArgumentException("zipItemName cannot be null");
    }

    public static String getZipItemNameFromOPCName(String r1) {
        if (r1 == null) goto L8;
    L4:
        if (r1.startsWith("/") == false) goto L6;
        r1 = r1.substring(1);
        goto L4
    L6:
        return r1;
    L8:
        throw new IllegalArgumentException("opcItemName cannot be null");
    }

    public static URI getZipURIFromOPCName(String r1) {
        if (r1 == null) goto L11;
    L4:
        if (r1.startsWith("/") == false) goto L12;
        r1 = r1.substring(1);
        goto L4
    L12:
        return new URI(r1);
    L8:
        return null;
    L11:
        throw new IllegalArgumentException("opcItemName");
    }

    public static ZipSecureFile openZipFile(File r2) {
        if (r2.exists() == false) goto L21;
        if (r2.isDirectory() == true) goto L19;
        FileInputStream r0 = new FileInputStream(r2);
        verifyZipHeader(r0);     // Catch: Throwable -> L10
        r0.close();
        return new ZipSecureFile(r2);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    L19:
        throw new IOException("File is a directory");
    L21:
        throw new FileNotFoundException("File does not exist");
    }

    public static ZipArchiveThresholdInputStream openZipStream(InputStream r2) {
        InputStream r3 = FileMagic.prepareToCheckMagic(r2);
        verifyZipHeader(r3);
        return new ZipArchiveThresholdInputStream(new ZipArchiveInputStream(r3));
    }

    private static void verifyZipHeader(InputStream r1) {
        FileMagic r2 = FileMagic.valueOf(FileMagic.prepareToCheckMagic(r1));
        int r3 = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 == 2) goto L8;
        return;
    L8:
        throw new NotOfficeXmlFileException("The supplied data appears to be a raw XML file. Formats such as Office 2003 XML are not supported");
    L10:
        throw new OLE2NotOfficeXmlFileException("The supplied data appears to be in the OLE2 Format. You are calling the part of POI that deals with OOXML (Office Open XML) Documents. You need to call a different part of POI to process this data (eg HSSF instead of XSSF)");
    }
}
