package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.ODFNotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.openxml4j.opc.internal.ContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.EncryptedTempFilePackagePart;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.apache.poi.openxml4j.opc.internal.MemoryPackagePart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.TempFilePackagePart;
import org.apache.poi.openxml4j.opc.internal.ZipContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.openxml4j.util.ZipArchiveThresholdInputStream;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.openxml4j.util.ZipFileZipEntrySource;
import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.TempFile;

/* JADX INFO: loaded from: classes7.dex */
public final class ZipPackage extends OPCPackage {
    private static final c LOG = null;
    private static boolean encryptTempFilePackageParts = false;
    private static boolean useTempFilePackageParts = false;
    private final ZipEntrySource zipArchive;

    private class EntryTriple implements Comparable<EntryTriple> {
        final String contentType;
        final PackagePartName partName;
        final /* synthetic */ ZipPackage this$0;
        final ZipArchiveEntry zipArchiveEntry;

        EntryTriple(ZipPackage r3, ZipArchiveEntry r4, ContentTypeManager r5) {
            this.this$0 = r3;
            this.zipArchiveEntry = r4;
            String r6 = r4.getName();
            String r0 = null;
            if (ZipPackage.access$000(r4) == false) goto L18;
        L11:
            PackagePartName r7 = null;
        L12:
            this.partName = r7;
            if (r7 == null) goto L16;
            r0 = r5.getContentType(r7);
        L16:
            this.contentType = r0;
            return;
        L18:
        L9:
            e = move-exception;
            ZipPackage.access$100().atWarn().a(e).a("Entry {} is not valid, so this part won't be added to the package.", r6);
            goto L11
        L5:
            if ("[Content_Types].xml".equalsIgnoreCase(r6) == true) goto L11;
            r7 = PackagingURIHelper.createPartName(ZipHelper.getOPCNameFromZipItemName(r6));     // Catch: Exception -> L9
            goto L12
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(EntryTriple r3) {
            return compareTo2((EntryTriple) ZeusTransformUtils.preCheckCast(r3, EntryTriple.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(EntryTriple r6) {
            int r2 = -1;
            if ("application/vnd.openxmlformats-package.relationships+xml".equals(this.contentType) == false) goto L5;
            int r0 = -1;
        L7:
            if ("application/vnd.openxmlformats-package.relationships+xml".equals(r6.contentType) == true) goto L10;
            r2 = 1;
        L10:
            int r1 = Integer.compare(r0, r2);
            if (r1 == 0) goto L14;
            return r1;
        L14:
            return this.partName.compareTo2(r6.partName);
        L5:
            r0 = 1;
            goto L7
        }

        void register(PackagePartCollection r9) {
            if (this.contentType == null) goto L14;
            if (r9.containsKey(this.partName) == true) goto L12;
            r9.put(this.partName, new ZipPackagePart(this.this$0, this.zipArchiveEntry, this.partName, this.contentType, false));     // Catch: InvalidOperationException -> L8
            return;
        L8:
            e = move-exception;
            throw new InvalidFormatException(e.getMessage(), e);
        L12:
            throw new InvalidFormatException("A part with the name '" + this.partName + "' already exists : Packages shall not contain equivalent part names and package implementers shall neither create nor recognize packages with equivalent part names. [M1.12]");
        L14:
            throw new InvalidFormatException("The part " + this.partName.getURI().getPath() + " does not have any content type ! Rule: Package require content types when retrieving a part from a package. [M.1.14]");
        }
    }

    static {
        LOG = b.a(ZipPackage.class);
    }

    public ZipPackage() {
        super(defaultPackageAccess);
        this.zipArchive = null;
        this.contentTypeManager = new ZipContentTypeManager(null, this);     // Catch: InvalidFormatException -> L5
        return;
    L5:
        e = move-exception;
        LOG.atWarn().a(e).a("Could not parse ZipPackage");
    }

    ZipPackage(File r3, PackageAccess r4) {
        super(r4);
        ZipEntrySource r1 = new ZipFileZipEntrySource(ZipHelper.openZipFile(r3));     // Catch: IOException -> L5
    L9:
        this.zipArchive = r1;
        return;
    L5:
        e = move-exception;
        if (r4 == PackageAccess.WRITE) goto L12;
        LOG.atWarn().a("Error in zip file {} - falling back to stream processing (i.e. ignoring zip central directory)", r3);
        r1 = openZipEntrySourceStream(r3);
        goto L9
    L12:
        throw new InvalidOperationException("Can't open the specified file: '" + r3 + "'", e);
    }

    ZipPackage(InputStream r1, PackageAccess r2) {
        super(r2);
        ZipArchiveThresholdInputStream r3 = ZipHelper.openZipStream(r1);
        this.zipArchive = new ZipInputStreamZipEntrySource(r3);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        IOUtils.closeQuietly(r3);
        throw e;
    }

    static /* synthetic */ boolean access$000(ZipArchiveEntry r0) {
        return ignoreEntry(r0);
    }

    static /* synthetic */ c access$100() {
        return LOG;
    }

    private synchronized String generateTempFileName(File r5) {
        monitor-enter(this);
    L11:
        File r0 = new File(r5.getAbsoluteFile() + File.separator + "OpenXML4J" + System.nanoTime());     // Catch: Throwable -> L8
        if (r0.exists() == true) goto L11;
        String r6 = FileHelper.getFilename(r0.getAbsoluteFile());     // Catch: Throwable -> L8
        monitor-exit(this);
        return r6;
    L8:
        th = move-exception;
        throw th;
    }

    private static boolean ignoreEntry(ZipArchiveEntry r1) {
        String r2 = r1.getName();
        if (r2.startsWith("[trash]") == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.endsWith("/") == true) goto L8;
        return false;
    }

    static /* synthetic */ boolean lambda$getPartsImpl$0(ZipArchiveEntry r0) {
        return !ignoreEntry(r0);
    }

    static /* synthetic */ boolean lambda$getPartsImpl$2(EntryTriple r0) {
        if (r0.partName == null) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ Message lambda$saveImpl$3(PackagePartName r3) {
        return new SimpleMessage("Save part '" + ZipHelper.getZipItemNameFromOPCName(r3.getName()) + "'");
    }

    private static ZipEntrySource openZipEntrySourceStream(File r5) {
        FileInputStream r1 = new FileInputStream(r5);     // Catch: FileNotFoundException -> L12
        return openZipEntrySourceStream(r1);
    L9:
        e = move-exception;
        IOUtils.closeQuietly(r1);
        throw e;
    L6:
        e = move-exception;
        IOUtils.closeQuietly(r1);
        throw new InvalidOperationException("Failed to read the file input stream from file: '" + r5 + "'", e);
    L12:
        e = move-exception;
        throw new InvalidOperationException("Can't open the specified file input stream from file: '" + r5 + "'", e);
    }

    private static ZipEntrySource openZipEntrySourceStream(FileInputStream r2) {
        ZipArchiveThresholdInputStream r3 = ZipHelper.openZipStream(r2);     // Catch: IOException -> L11
        return openZipEntrySourceStream(r3);
    L8:
        e = move-exception;
        IOUtils.closeQuietly(r3);
        throw e;
    L5:
        e = move-exception;
        IOUtils.closeQuietly(r3);
        throw new InvalidOperationException("Failed to read the zip entry source stream", e);
    L11:
        e = move-exception;
        throw new InvalidOperationException("Could not open the file input stream", e);
    }

    private static ZipEntrySource openZipEntrySourceStream(ZipArchiveThresholdInputStream r2) {
        return new ZipInputStreamZipEntrySource(r2);
    L4:
        e = move-exception;
        throw new InvalidOperationException("Could not open the specified zip entry source stream", e);
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void closeImpl() {
        flush();
        if (this.originalPackagePath != null) goto L5;
        return;
    L5:
        if (this.originalPackagePath.isEmpty() == true) goto L35;
        File r1 = new File(this.originalPackagePath);
        if (r1.exists() == false) goto L28;
        File r2 = TempFile.createTempFile(generateTempFileName(FileHelper.getDirectory(r1)), ".tmp");
        save(r2);     // Catch: Throwable -> L22
        IOUtils.closeQuietly(this.zipArchive);
        FileHelper.copyFile(r2, r1);     // Catch: Throwable -> L17
        if (r2.delete() == true) goto L34;
        LOG.atWarn().a("The temporary file: '{}' cannot be deleted ! Make sure that no other application use it.", r1.getAbsolutePath());
        return;
    L34:
        return;
    L17:
        th = move-exception;
        if (r2.delete() == true) goto L21;
        LOG.atWarn().a("The temporary file: '{}' cannot be deleted ! Make sure that no other application use it.", r1.getAbsolutePath());
    L21:
        throw th;
    L22:
        th = move-exception;
        IOUtils.closeQuietly(this.zipArchive);
        if (r2.delete() == true) goto L26;
        LOG.atWarn().a("The temporary file: '{}' cannot be deleted ! Make sure that no other application use it.", r1.getAbsolutePath());
    L26:
        throw th;
    L28:
        throw new InvalidOperationException("Can't close a package not previously open with the open() method !");
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public PackagePart createPartImpl(PackagePartName r2, String r3, boolean r4) {
        if (r3 == null) goto L20;
        if (r2 == null) goto L18;
    L14:
        e = move-exception;
        LOG.atWarn().a(e).a("Failed to create part {}", r2);
        return null;
    L5:
        if (useTempFilePackageParts == false) goto L13;
        if (encryptTempFilePackageParts == false) goto L11;
        return new EncryptedTempFilePackagePart(this, r2, r3, r4);
    L11:
        return new TempFilePackagePart(this, r2, r3, r4);
    L13:
        return new MemoryPackagePart(this, r2, r3, r4);
    L18:
        throw new IllegalArgumentException("partName");
    L20:
        throw new IllegalArgumentException("contentType");
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void flushImpl() {
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public PackagePartCollection getPartsImpl() {
        PackagePartCollection r0 = new PackagePartCollection();
        ZipEntrySource r1 = this.zipArchive;
        if (r1 != null) goto L5;
        return r0;
    L5:
        ZipArchiveEntry r2 = r1.getEntry("[Content_Types].xml");
        if (r2 != null) goto L8;
        boolean r3 = true;
        if (this.zipArchive.getEntry("mimetype") == null) goto L23;
        boolean r4 = true;
    L25:
        if (this.zipArchive.getEntry("settings.xml") != null) goto L28;
        r3 = false;
    L28:
        if (r4 == false) goto L34;
        if (r3 == false) goto L34;
        throw new ODFNotOfficeXmlFileException("The supplied data appears to be in ODF (Open Document) Format. Formats like these (eg ODS, ODP) are not supported, try Apache ODFToolkit");
    L34:
        if (this.zipArchive.getEntries().hasMoreElements() == true) goto L38;
        throw new NotOfficeXmlFileException("No valid entries or contents found, this is not a valid OOXML (Office Open XML) file");
    L38:
        throw new InvalidFormatException("Package should contain a content type part [M1.13]");
    L23:
        r4 = false;
        goto L25
    L8:
        if (this.contentTypeManager != null) goto L19;
        this.contentTypeManager = new ZipContentTypeManager(this.zipArchive.getInputStream(r2), this);     // Catch: IOException -> L15
        Iterator r5 = ((List) ZeusTransformUtils.preCheckCast(Collections.list(this.zipArchive.getEntries()).stream().filter($$Lambda$ZipPackage$4j6XqLWILMRGfGTbtPAqPy7j5zg.INSTANCE).map(new $$Lambda$ZipPackage$3qZQgpM5JKnbhEewvZjH7PZr1Y4(this)).filter($$Lambda$ZipPackage$BqDawZzP8o6fR4RLNHM5tliAdw.INSTANCE).sorted().collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        ((EntryTriple) ZeusTransformUtils.preCheckCast(r5.next(), EntryTriple.class, "com.obric.memorydata.plugin")).register(r0);
        goto L12
    L14:
        return r0;
    L15:
        e = move-exception;
        throw new InvalidFormatException(e.getMessage(), e);
    L19:
        throw new InvalidFormatException("ContentTypeManager can only be created once. This must be a cyclic relation?");
    }

    public ZipEntrySource getZipArchive() {
        return this.zipArchive;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public boolean isClosed() {
        ZipEntrySource r0 = this.zipArchive;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isClosed() == false) goto L7;
        return true;
    }

    public /* synthetic */ EntryTriple lambda$getPartsImpl$1$ZipPackage(ZipArchiveEntry r3) {
        return new EntryTriple(this, r3, this.contentTypeManager);
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void removePartImpl(PackagePartName r1) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("partUri");
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void revertImpl() {
        ZipEntrySource r0 = this.zipArchive;     // Catch: IOException -> L6
        if (r0 == null) goto L9;
        r0.close();     // Catch: IOException -> L6
        return;
    L9:
        return;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void saveImpl(OutputStream r8) {
        throwExceptionIfReadOnly();
        if (ZeusTransformUtils.instanceOf(r8, ZipArchiveOutputStream.class) == false) goto L5;
        ZipArchiveOutputStream r9 = (ZipArchiveOutputStream) ZeusTransformUtils.preCheckCast(r8, ZipArchiveOutputStream.class, "com.obric.memorydata.plugin");
    L35:
    L33:
        e = move-exception;
        throw e;
    L30:
        e = move-exception;
        throw new OpenXML4JRuntimeException("Fail to save: an error occurs while saving the package : " + e.getMessage(), e);
    L7:
        if (getPartsByRelationshipType("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties").isEmpty() == true) goto L9;
    L13:
        c r0 = LOG;     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        r0.atDebug().a("Save content types part");     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        this.contentTypeManager.save(r9);     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        r0.atDebug().a("Save package relationships");     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        ZipPartMarshaller.marshallRelationshipPart(getRelationships(), PackagingURIHelper.PACKAGE_RELATIONSHIPS_ROOT_PART_NAME, r9);     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        Iterator<PackagePart> r1 = getParts().iterator();     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
    L15:
        if (r1.hasNext() == false) goto L28;
        PackagePart r2 = (PackagePart) ZeusTransformUtils.preCheckCast(r1.next(), PackagePart.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        if (r2.isRelationshipPart() == true) goto L15;
        final PackagePartName r3 = r2.getPartName();     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        LOG.atDebug().a(new $$Lambda$ZipPackage$KQpMWORR_iMoqyPxw47W0qEaUVE(r3));     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        PartMarshaller r4 = (PartMarshaller) ZeusTransformUtils.preCheckCast(this.partMarshallers.get(r2._contentType), PartMarshaller.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        if (r4 != null) goto L24;
        r4 = this.defaultPartMarshaller;     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
    L24:
        if (r4.marshall(r2, r9) == true) goto L15;
        throw new OpenXML4JException("The part " + r3.getURI() + " failed to be saved in the stream with marshaller " + r4 + ". Enable logging via Log4j 2 for more details.");     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
    L28:
        r9.finish();     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        return;
    L9:
        if (getPartsByRelationshipType("http://schemas.openxmlformats.org/officedocument/2006/relationships/metadata/core-properties").isEmpty() == false) goto L13;
        LOG.atDebug().a("Save core properties part");     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        getPackageProperties();     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        addPackagePart(this.packageProperties);     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        this.relationships.addRelationship(this.packageProperties.getPartName().getURI(), TargetMode.INTERNAL, "http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties", null);     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        if (this.contentTypeManager.isContentTypeRegister("application/vnd.openxmlformats-package.core-properties+xml") == true) goto L13;
        this.contentTypeManager.addContentType(this.packageProperties.getPartName(), "application/vnd.openxmlformats-package.core-properties+xml");     // Catch: Exception -> L30 OpenXML4JRuntimeException -> L33
        goto L13
    L5:
        r9 = new ZipArchiveOutputStream(r8);
        goto L35
    }
}
