package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
public class ZipFile implements Closeable {
    private static final long CFH_SIG = 0;
    private static final byte[] ONE_ZERO_BYTE = null;
    private final SeekableByteChannel archive;
    private final String archiveName;
    private long centralDirectoryStartDiskNumber;
    private long centralDirectoryStartOffset;
    private long centralDirectoryStartRelativeOffset;
    private final ByteBuffer cfhBbuf;
    private final byte[] cfhBuf;
    private volatile boolean closed;
    private final ByteBuffer dwordBbuf;
    private final byte[] dwordBuf;
    private final String encoding;
    private final List<ZipArchiveEntry> entries;
    private final boolean isSplitZipArchive;
    private final Map<String, LinkedList<ZipArchiveEntry>> nameMap;
    private final Comparator<ZipArchiveEntry> offsetComparator;
    private final ByteBuffer shortBbuf;
    private final byte[] shortBuf;
    private final boolean useUnicodeExtraFields;
    private final ByteBuffer wordBbuf;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipFile$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = null;

        static {
            int[] r0 = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = r0;
            r0[ZipMethod.STORED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L64:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.UNSHRINKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L48:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L60:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.DEFLATED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L66:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L50:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L54:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.AES_ENCRYPTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L78:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_1.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L44:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_2.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_3.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L74:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.EXPANDING_LEVEL_4.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L56:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.JPEG.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L62:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.LZMA.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L46:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.PKWARE_IMPLODING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L52:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.PPMD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L76:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.TOKENIZATION.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L42:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.UNKNOWN.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L68:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.WAVPACK.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L72:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.XZ.ordinal()] = 19;     // Catch: NoSuchFieldError -> L41
            return;
        }
    }

    private class BoundedFileChannelInputStream extends BoundedArchiveInputStream {
        private final FileChannel archive;
        final /* synthetic */ ZipFile this$0;

        BoundedFileChannelInputStream(ZipFile r1, long r2, long r4) {
            this.this$0 = r1;
            super(r2, r4);
            this.archive = (FileChannel) ZeusTransformUtils.preCheckCast(ZipFile.access$300(r1), FileChannel.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.commons.compress.utils.BoundedArchiveInputStream
        public int read(long r1, ByteBuffer r3) {
            int r0 = this.archive.read(r3, r1);
            r3.flip();
            return r0;
        }
    }

    private static class Entry extends ZipArchiveEntry {
        Entry() {
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry
        public boolean equals(Object r7) {
            if (super.equals(r7) == false) goto L12;
            Entry r8 = (Entry) ZeusTransformUtils.preCheckCast(r7, Entry.class, "com.obric.memorydata.plugin");
            if (getLocalHeaderOffset() == r8.getLocalHeaderOffset()) goto L7;
            return false;
        L7:
            if (super.getDataOffset() == r8.getDataOffset()) goto L9;
            return false;
        L9:
            if (super.getDiskNumberStart() != r8.getDiskNumberStart()) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipArchiveEntry, java.util.zip.ZipEntry
        public int hashCode() {
            return ((super.hashCode() * 3) + ((int) getLocalHeaderOffset())) + ((int) (getLocalHeaderOffset() >> 32));
        }
    }

    private static final class NameAndComment {
        private final byte[] comment;
        private final byte[] name;

        private NameAndComment(byte[] r1, byte[] r2) {
            this.name = r1;
            this.comment = r2;
        }

        /* synthetic */ NameAndComment(byte[] r1, byte[] r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ byte[] access$100(NameAndComment r0) {
            return r0.name;
        }

        static /* synthetic */ byte[] access$200(NameAndComment r0) {
            return r0.comment;
        }
    }

    private static class StoredStatisticsStream extends CountingInputStream implements InputStreamStatistics {
        StoredStatisticsStream(InputStream r1) {
            super(r1);
        }

        @Override // org.apache.commons.compress.utils.InputStreamStatistics
        public long getCompressedCount() {
            return super.getBytesRead();
        }

        @Override // org.apache.commons.compress.utils.InputStreamStatistics
        public long getUncompressedCount() {
            return getCompressedCount();
        }
    }

    static {
        ONE_ZERO_BYTE = new byte[1];
        CFH_SIG = ZipLong.getValue(ZipArchiveOutputStream.CFH_SIG);
    }

    public ZipFile(File r2) {
        this(r2, "UTF8");
    }

    public ZipFile(File r2, String r3) {
        this(r2, r3, true);
    }

    public ZipFile(File r2, String r3, boolean r4) {
        this(r2, r3, r4, false);
    }

    public ZipFile(File r11, String r12, boolean r13, boolean r14) {
        this(Files.newByteChannel(r11.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), r11.getAbsolutePath(), r12, r13, true, r14);
    }

    private ZipFile(SeekableByteChannel r6, String r7, String r8, boolean r9, boolean r10, boolean r11) {
        SeekableByteChannel r12 = (SeekableByteChannel) ZeusTransformUtils.wrapperContextForParams(r6, SeekableByteChannel.class, "com.obric.memorydata.plugin");
        this.entries = new LinkedList();
        this.nameMap = new HashMap(509);
        this.closed = true;
        byte[] r1 = new byte[8];
        this.dwordBuf = r1;
        byte[] r2 = new byte[4];
        this.wordBuf = r2;
        byte[] r3 = new byte[42];
        this.cfhBuf = r3;
        byte[] r4 = new byte[2];
        this.shortBuf = r4;
        this.dwordBbuf = ByteBuffer.wrap(r1);
        this.wordBbuf = ByteBuffer.wrap(r2);
        this.cfhBbuf = ByteBuffer.wrap(r3);
        this.shortBbuf = ByteBuffer.wrap(r4);
        this.offsetComparator = Comparator.comparingLong($$Lambda$mNoNRouEneyspHE7nFcUO2qlXpo.INSTANCE).thenComparingLong($$Lambda$PPIugWfZ7qhYLGn4aouUHpr3Qs.INSTANCE);
        this.isSplitZipArchive = ZeusTransformUtils.instanceOf(r12, ZipSplitReadOnlySeekableByteChannel.class);
        this.archiveName = r7;
        this.encoding = r8;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(r8);
        this.useUnicodeExtraFields = r9;
        this.archive = r12;
        Map<ZipArchiveEntry, NameAndComment> r13 = populateFromCentralDirectory();     // Catch: Throwable -> L9 IOException -> L11
        if (r11 == true) goto L6;
        resolveLocalFileHeaderData(r13);     // Catch: Throwable -> L9 IOException -> L11
    L6:
        fillNameMap();     // Catch: Throwable -> L9 IOException -> L11
        this.closed = false;
        return;
    L9:
        th = move-exception;
        this.closed = true;
        if (r10 == false) goto L17;
        IOUtils.closeQuietly(this.archive);
    L17:
        throw th;
    L11:
        e = move-exception;
        throw new IOException("Error on ZipFile " + r7, e);     // Catch: Throwable -> L9
    }

    static /* synthetic */ SeekableByteChannel access$300(ZipFile r0) {
        return r0.archive;
    }

    private BoundedArchiveInputStream createBoundedInputStream(long r8, long r10) {
        if (r8 < 0) goto L14;
        if (r10 < 0) goto L14;
        if ((r8 + r10) < r8) goto L14;
        if (ZeusTransformUtils.instanceOf(this.archive, FileChannel.class) == false) goto L12;
        return new BoundedFileChannelInputStream(this, r8, r10);
    L12:
        return new BoundedSeekableByteChannelInputStream(r8, r10, this.archive);
    L14:
        throw new IllegalArgumentException("Corrupted archive, stream boundaries are out of range");
    }

    private void fillNameMap() {
        Iterator<ZipArchiveEntry> r0 = this.entries.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ZipArchiveEntry r1 = (ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r0.next(), ZipArchiveEntry.class, "com.obric.memorydata.plugin");
        String r2 = r1.getName();
        ((LinkedList) ZeusTransformUtils.preCheckCast(this.nameMap.computeIfAbsent(r2, $$Lambda$ZipFile$aUnlwYrVWVvr41QQmuQUgCcv_80.INSTANCE), LinkedList.class, "com.obric.memorydata.plugin")).addLast(r1);
        goto L4
    }

    private long getDataOffset(ZipArchiveEntry r5) {
        long r0 = r5.getDataOffset();
        if (r0 != (-1)) goto L6;
        setDataOffset(r5);
        return r5.getDataOffset();
    L6:
        return r0;
    }

    static /* synthetic */ LinkedList lambda$fillNameMap$0(String r0) {
        return new LinkedList();
    }

    private Map<ZipArchiveEntry, NameAndComment> populateFromCentralDirectory() {
        HashMap r0 = new HashMap();
        positionAtCentralDirectory();
        this.centralDirectoryStartOffset = this.archive.position();
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        long r1 = ZipLong.getValue(this.wordBuf);
        if (r1 == CFH_SIG) goto L10;
        if (startsWithLocalFileHeader() == false) goto L10;
        throw new IOException("Central directory is empty, can't expand corrupt archive.");
    L10:
        if (r1 != CFH_SIG) goto L12;
        readCentralDirectoryEntry(r0);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        r1 = ZipLong.getValue(this.wordBuf);
        goto L10
    L12:
        return r0;
    }

    private void positionAtCentralDirectory() {
        positionAtEndOfCentralDirectoryRecord();
        boolean r1 = false;
        if (this.archive.position() <= 20) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        SeekableByteChannel r2 = this.archive;
        r2.position(r2.position() - 20);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        r1 = Arrays.equals(ZipArchiveOutputStream.ZIP64_EOCD_LOC_SIG, this.wordBuf);
    L8:
        if (r1 == true) goto L12;
        if (r0 == false) goto L11;
        skipBytes(16);
    L11:
        positionAtCentralDirectory32();
        return;
    L12:
        positionAtCentralDirectory64();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void positionAtCentralDirectory32() {
        if (this.isSplitZipArchive == false) goto L5;
        skipBytes(6);
        this.shortBbuf.rewind();
        IOUtils.readFully(this.archive, this.shortBbuf);
        this.centralDirectoryStartDiskNumber = ZipShort.getValue(this.shortBuf);
        skipBytes(8);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        this.centralDirectoryStartRelativeOffset = ZipLong.getValue(this.wordBuf);
        ((ZipSplitReadOnlySeekableByteChannel) ZeusTransformUtils.preCheckCast(this.archive, ZipSplitReadOnlySeekableByteChannel.class, "com.obric.memorydata.plugin")).position(this.centralDirectoryStartDiskNumber, this.centralDirectoryStartRelativeOffset);
        return;
    L5:
        skipBytes(16);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        this.centralDirectoryStartDiskNumber = 0;
        long r0 = ZipLong.getValue(this.wordBuf);
        this.centralDirectoryStartRelativeOffset = r0;
        this.archive.position(r0);
    }

    private void positionAtCentralDirectory64() {
        if (this.isSplitZipArchive == false) goto L5;
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        long r2 = ZipLong.getValue(this.wordBuf);
        this.dwordBbuf.rewind();
        IOUtils.readFully(this.archive, this.dwordBbuf);
        long r4 = ZipEightByteInteger.getLongValue(this.dwordBuf);
        ((ZipSplitReadOnlySeekableByteChannel) ZeusTransformUtils.preCheckCast(this.archive, ZipSplitReadOnlySeekableByteChannel.class, "com.obric.memorydata.plugin")).position(r2, r4);
    L6:
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        if (Arrays.equals(this.wordBuf, ZipArchiveOutputStream.ZIP64_EOCD_SIG) == false) goto L14;
        if (this.isSplitZipArchive == false) goto L11;
        skipBytes(16);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        this.centralDirectoryStartDiskNumber = ZipLong.getValue(this.wordBuf);
        skipBytes(24);
        this.dwordBbuf.rewind();
        IOUtils.readFully(this.archive, this.dwordBbuf);
        this.centralDirectoryStartRelativeOffset = ZipEightByteInteger.getLongValue(this.dwordBuf);
        ((ZipSplitReadOnlySeekableByteChannel) ZeusTransformUtils.preCheckCast(this.archive, ZipSplitReadOnlySeekableByteChannel.class, "com.obric.memorydata.plugin")).position(this.centralDirectoryStartDiskNumber, this.centralDirectoryStartRelativeOffset);
        return;
    L11:
        skipBytes(44);
        this.dwordBbuf.rewind();
        IOUtils.readFully(this.archive, this.dwordBbuf);
        this.centralDirectoryStartDiskNumber = 0;
        long r0 = ZipEightByteInteger.getLongValue(this.dwordBuf);
        this.centralDirectoryStartRelativeOffset = r0;
        this.archive.position(r0);
        return;
    L14:
        throw new ZipException("Archive's ZIP64 end of central directory locator is corrupt.");
    L5:
        skipBytes(4);
        this.dwordBbuf.rewind();
        IOUtils.readFully(this.archive, this.dwordBbuf);
        this.archive.position(ZipEightByteInteger.getLongValue(this.dwordBuf));
        goto L6
    }

    private void positionAtEndOfCentralDirectoryRecord() {
        if (tryToLocateSignature(22, 65557, ZipArchiveOutputStream.EOCD_SIG) == false) goto L6;
        return;
    L6:
        throw new ZipException("Archive is not a ZIP archive");
    }

    private void readCentralDirectoryEntry(Map<ZipArchiveEntry, NameAndComment> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        this.cfhBbuf.rewind();
        IOUtils.readFully(this.archive, this.cfhBbuf);
        Entry r0 = new Entry();
        int r1 = ZipShort.getValue(this.cfhBuf, 0);
        r0.setVersionMadeBy(r1);
        r0.setPlatform((r1 >> 8) & 15);
        r0.setVersionRequired(ZipShort.getValue(this.cfhBuf, 2));
        GeneralPurposeBit r2 = GeneralPurposeBit.parse(this.cfhBuf, 4);
        boolean r4 = r2.usesUTF8ForNames();
        if (r4 == false) goto L5;
        ZipEncoding r5 = ZipEncodingHelper.UTF8_ZIP_ENCODING;
    L6:
        if (r4 == false) goto L8;
        r0.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
    L8:
        r0.setGeneralPurposeBit(r2);
        r0.setRawFlag(ZipShort.getValue(this.cfhBuf, 4));
        r0.setMethod(ZipShort.getValue(this.cfhBuf, 6));
        r0.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.cfhBuf, 8)));
        r0.setCrc(ZipLong.getValue(this.cfhBuf, 12));
        long r3 = ZipLong.getValue(this.cfhBuf, 16);
        if (r3 < 0) goto L50;
        r0.setCompressedSize(r3);
        long r6 = ZipLong.getValue(this.cfhBuf, 20);
        if (r6 < 0) goto L48;
        r0.setSize(r6);
        int r7 = ZipShort.getValue(this.cfhBuf, 24);
        if (r7 < 0) goto L46;
        int r8 = ZipShort.getValue(this.cfhBuf, 26);
        if (r8 < 0) goto L44;
        int r9 = ZipShort.getValue(this.cfhBuf, 28);
        if (r9 < 0) goto L42;
        r0.setDiskNumberStart(ZipShort.getValue(this.cfhBuf, 30));
        r0.setInternalAttributes(ZipShort.getValue(this.cfhBuf, 32));
        r0.setExternalAttributes(ZipLong.getValue(this.cfhBuf, 34));
        byte[] r10 = IOUtils.readRange(this.archive, r7);
        if (r10.length < r7) goto L40;
        r0.setName(r5.decode(r10), r10);
        r0.setLocalHeaderOffset(ZipLong.getValue(this.cfhBuf, 38));
        this.entries.add(r0);
        byte[] r13 = IOUtils.readRange(this.archive, r8);
        if (r13.length < r8) goto L38;
        r0.setCentralDirectoryExtra(r13);     // Catch: RuntimeException -> L34
        setSizesAndOffsetFromZip64Extra(r0);
        sanityCheckLFHOffset(r0);
        byte[] r14 = IOUtils.readRange(this.archive, r9);
        if (r14.length < r9) goto L33;
        r0.setComment(r5.decode(r14));
        if (r4 == false) goto L28;
    L30:
        r0.setStreamContiguous(true);
        return;
    L28:
        if (this.useUnicodeExtraFields == false) goto L30;
        r12.put(r0, new NameAndComment(r10, r14, null));
        goto L30
    L33:
        throw new EOFException();
    L34:
        e = move-exception;
        ZipException r15 = new ZipException("Invalid extra data in entry " + r0.getName());
        r15.initCause(e);
        throw r15;
    L38:
        throw new EOFException();
    L40:
        throw new EOFException();
    L42:
        throw new IOException("broken archive, entry with negative commentLen");
    L44:
        throw new IOException("broken archive, entry with negative extraLen");
    L46:
        throw new IOException("broken archive, entry with negative fileNameLen");
    L48:
        throw new IOException("broken archive, entry with negative size");
    L50:
        throw new IOException("broken archive, entry with negative compressed size");
    L5:
        r5 = this.zipEncoding;
        goto L6
    }

    private void resolveLocalFileHeaderData(Map<ZipArchiveEntry, NameAndComment> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Iterator<ZipArchiveEntry> r0 = this.entries.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        Entry r2 = (Entry) ZeusTransformUtils.preCheckCast((ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r0.next(), ZipArchiveEntry.class, "com.obric.memorydata.plugin"), Entry.class, "com.obric.memorydata.plugin");
        int[] r3 = setDataOffset(r2);
        int r4 = r3[0];
        int r5 = r3[1];
        skipBytes(r4);
        byte[] r6 = IOUtils.readRange(this.archive, r5);
        if (r6.length < r5) goto L15;
        r2.setExtra(r6);     // Catch: RuntimeException -> L11
        if (r8.containsKey(r2) == false) goto L4;
        NameAndComment r9 = (NameAndComment) ZeusTransformUtils.preCheckCast(r8.get(r2), NameAndComment.class, "com.obric.memorydata.plugin");
        ZipUtil.setNameAndCommentFromExtraFields(r2, NameAndComment.access$100(r9), NameAndComment.access$200(r9));
    L11:
        e = move-exception;
        ZipException r10 = new ZipException("Invalid extra data in entry " + r2.getName());
        r10.initCause(e);
        throw r10;
    L15:
        throw new EOFException();
    }

    private void sanityCheckLFHOffset(ZipArchiveEntry r8) {
        if (r8.getDiskNumberStart() < 0) goto L27;
        if (r8.getLocalHeaderOffset() < 0) goto L25;
        if (this.isSplitZipArchive == false) goto L20;
        if (r8.getDiskNumberStart() > this.centralDirectoryStartDiskNumber) goto L18;
        if (r8.getDiskNumberStart() == this.centralDirectoryStartDiskNumber) goto L13;
        return;
    L13:
        if (r8.getLocalHeaderOffset() > this.centralDirectoryStartRelativeOffset) goto L16;
        return;
    L16:
        throw new IOException("local file header for " + r8.getName() + " starts after central directory");
    L18:
        throw new IOException("local file header for " + r8.getName() + " starts on a later disk than central directory");
    L20:
        if (r8.getLocalHeaderOffset() > this.centralDirectoryStartOffset) goto L23;
        return;
    L23:
        throw new IOException("local file header for " + r8.getName() + " starts after central directory");
    L25:
        throw new IOException("broken archive, entry with negative local file header offset");
    L27:
        throw new IOException("broken archive, entry with negative disk number");
    }

    private int[] setDataOffset(ZipArchiveEntry r8) {
        long r0 = r8.getLocalHeaderOffset();
        if (this.isSplitZipArchive == false) goto L5;
        ((ZipSplitReadOnlySeekableByteChannel) ZeusTransformUtils.preCheckCast(this.archive, ZipSplitReadOnlySeekableByteChannel.class, "com.obric.memorydata.plugin")).position(r8.getDiskNumberStart(), r0 + 26);
        r0 = this.archive.position() - 26;
    L6:
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        this.wordBbuf.flip();
        this.wordBbuf.get(this.shortBuf);
        int r2 = ZipShort.getValue(this.shortBuf);
        this.wordBbuf.get(this.shortBuf);
        int r5 = ZipShort.getValue(this.shortBuf);
        r8.setDataOffset(((((r0 + 26) + 2) + 2) + ((long) r2)) + ((long) r5));
        if ((r8.getDataOffset() + r8.getCompressedSize()) > this.centralDirectoryStartOffset) goto L11;
        return new int[]{r2, r5};
    L11:
        throw new IOException("data for " + r8.getName() + " overlaps with central directory.");
    L5:
        this.archive.position(r0 + 26);
        goto L6
    }

    private void setSizesAndOffsetFromZip64Extra(ZipArchiveEntry r11) {
        ZipExtraField r10 = r11.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (r10 != null) goto L5;
    L9:
        Zip64ExtendedInformationExtraField r12 = (Zip64ExtendedInformationExtraField) ZeusTransformUtils.preCheckCast(r10, Zip64ExtendedInformationExtraField.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L49;
        boolean r1 = true;
        if (r11.getSize() != 4294967295L) goto L14;
        boolean r0 = true;
    L16:
        if (r11.getCompressedSize() != 4294967295L) goto L18;
        boolean r5 = true;
    L20:
        if (r11.getLocalHeaderOffset() != 4294967295L) goto L22;
        boolean r2 = true;
    L24:
        if (r11.getDiskNumberStart() == WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L27;
        r1 = false;
    L27:
        r12.reparseCentralDirectoryData(r0, r5, r2, r1);
        if (r0 == false) goto L34;
        long r6 = r12.getSize().getLongValue();
        if (r6 < 0) goto L33;
        r11.setSize(r6);
    L36:
        if (r5 == false) goto L42;
        long r7 = r12.getCompressedSize().getLongValue();
        if (r7 < 0) goto L41;
        r11.setCompressedSize(r7);
    L44:
        if (r2 == false) goto L46;
        r11.setLocalHeaderOffset(r12.getRelativeHeaderOffset().getLongValue());
    L46:
        if (r1 == false) goto L50;
        r11.setDiskNumberStart(r12.getDiskStartNumber().getValue());
        return;
    L50:
        return;
    L41:
        throw new IOException("broken archive, entry with negative compressed size");
    L42:
        if (r0 == false) goto L44;
        r12.setCompressedSize(new ZipEightByteInteger(r11.getCompressedSize()));
        goto L44
    L33:
        throw new IOException("broken archive, entry with negative size");
    L34:
        if (r5 == false) goto L36;
        r12.setSize(new ZipEightByteInteger(r11.getSize()));
        goto L36
    L22:
        r2 = false;
        goto L24
    L18:
        r5 = false;
        goto L20
    L14:
        r0 = false;
        goto L16
    L49:
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r10, Zip64ExtendedInformationExtraField.class) == true) goto L9;
        throw new ZipException("archive contains unparseable zip64 extra field");
    }

    private void skipBytes(int r5) {
        long r0 = this.archive.position() + ((long) r5);
        if (r0 > this.archive.size()) goto L7;
        this.archive.position(r0);
        return;
    L7:
        throw new EOFException();
    }

    private boolean startsWithLocalFileHeader() {
        this.archive.position(0);
        this.wordBbuf.rewind();
        IOUtils.readFully(this.archive, this.wordBbuf);
        return Arrays.equals(this.wordBuf, ZipArchiveOutputStream.LFH_SIG);
    }

    private boolean tryToLocateSignature(long r6, long r8, byte[] r10) {
        long r0 = this.archive.size() - r6;
        long r7 = Math.max(0, this.archive.size() - r8);
        boolean r9 = true;
        if (r0 >= 0) goto L5;
    L18:
        r9 = false;
    L19:
        if (r9 == false) goto L21;
        this.archive.position(r0);
    L21:
        return r9;
    L5:
        if (r0 < r7) goto L18;
        this.archive.position(r0);
        this.wordBbuf.rewind();     // Catch: EOFException -> L22
        IOUtils.readFully(this.archive, this.wordBbuf);     // Catch: EOFException -> L22
        this.wordBbuf.flip();     // Catch: EOFException -> L22
        if (this.wordBbuf.get() != r10[0]) goto L17;
        if (this.wordBbuf.get() != r10[1]) goto L17;
        if (this.wordBbuf.get() != r10[2]) goto L17;
        if (this.wordBbuf.get() == r10[3]) goto L19;
    L17:
        r0 = r0 - 1;
        goto L5
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        this.archive.close();
    }

    public void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.closed == true) goto L5;
        System.err.println("Cleaning up unclosed ZipFile for archive " + this.archiveName);     // Catch: Throwable -> L7
        close();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    public Enumeration<ZipArchiveEntry> getEntries() {
        return Collections.enumeration(this.entries);
    }

    public ZipArchiveEntry getEntry(String r2) {
        LinkedList r1 = (LinkedList) ZeusTransformUtils.preCheckCast(this.nameMap.get(r2), LinkedList.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return (ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r1.getFirst(), ZipArchiveEntry.class, "com.obric.memorydata.plugin");
    }

    public InputStream getInputStream(ZipArchiveEntry r6) {
        if (ZeusTransformUtils.instanceOf(r6, Entry.class) == true) goto L6;
        return null;
    L6:
        ZipUtil.checkRequestedFeatures(r6);
        BufferedInputStream r2 = new BufferedInputStream(createBoundedInputStream(getDataOffset(r6), r6.getCompressedSize()));
        switch(AnonymousClass2.$SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.getMethodByCode(r6.getMethod()).ordinal()]) {
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L25;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L11;
            default: goto L9;
        };
    L14:
        final Inflater r7 = new Inflater(true);
        final SequenceInputStream r1 = new SequenceInputStream(r2, new ByteArrayInputStream(ONE_ZERO_BYTE));
        return new AnonymousClass1(this, r1, r7, r7);
    L25:
        return new ExplodingInputStream(r6.getGeneralPurposeBit().getSlidingDictionarySize(), r6.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), r2);
    L18:
        e = move-exception;
        throw new IOException("bad IMPLODE data", e);
    L9:
        throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(r6.getMethod()), r6);
    L11:
        return new Deflate64CompressorInputStream(r2);
    L13:
        return new BZip2CompressorInputStream(r2);
    L22:
        return new UnshrinkingInputStream(r2);
    L24:
        return new StoredStatisticsStream(r2);
    }
}
