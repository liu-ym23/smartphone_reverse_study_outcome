package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes6.dex */
public class ZipArchiveInputStream extends ArchiveInputStream implements InputStreamStatistics {
    private static final byte[] APK_SIGNING_BLOCK_MAGIC = null;
    private static final byte[] CFH = null;
    private static final byte[] DD = null;
    private static final byte[] LFH = null;
    private static final BigInteger LONG_MAX = null;
    private boolean allowStoredEntriesWithDataDescriptor;
    private final ByteBuffer buf;
    private boolean closed;
    private CurrentEntry current;
    final String encoding;
    private int entriesRead;
    private boolean hitCentralDirectory;
    private final InputStream in;
    private final Inflater inf;
    private ByteArrayInputStream lastStoredEntry;
    private final byte[] lfhBuf;
    private final byte[] shortBuf;
    private final byte[] skipBuf;
    private final boolean skipSplitSig;
    private final byte[] twoDwordBuf;
    private long uncompressedCount;
    private final boolean useUnicodeExtraFields;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = null;

        static {
            int[] r0 = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = r0;
            r0[ZipMethod.UNSHRINKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private class BoundedInputStream extends InputStream {
        private final InputStream in;
        private final long max;
        private long pos;
        final /* synthetic */ ZipArchiveInputStream this$0;

        public BoundedInputStream(ZipArchiveInputStream r1, InputStream r2, long r3) {
            this.this$0 = r1;
            this.max = r3;
            this.in = r2;
        }

        @Override // java.io.InputStream
        public int available() {
            long r0 = this.max;
            if (r0 < 0) goto L9;
            if (this.pos < r0) goto L9;
            return 0;
        L9:
            return this.in.available();
        }

        @Override // java.io.InputStream
        public int read() {
            long r0 = this.max;
            if (r0 >= 0) goto L5;
        L8:
            int r1 = this.in.read();
            this.pos++;
            ZipArchiveInputStream.access$800(this.this$0, 1);
            CurrentEntry.access$708(ZipArchiveInputStream.access$900(this.this$0));
            return r1;
        L5:
            if (this.pos < r0) goto L8;
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] r3) {
            return read(r3, 0, r3.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] r9, int r10, int r11) {
            if (r11 != 0) goto L5;
            return 0;
        L5:
            long r0 = this.max;
            if (r0 < 0) goto L11;
            if (this.pos < r0) goto L11;
            return -1;
        L11:
            if (r0 < 0) goto L13;
            long r1 = Math.min(r11, r0 - this.pos);
        L14:
            int r12 = this.in.read(r9, r10, (int) r1);
            if (r12 != (-1)) goto L17;
            return -1;
        L17:
            long r2 = r12;
            this.pos += r2;
            ZipArchiveInputStream.access$1000(this.this$0, r12);
            CurrentEntry r8 = ZipArchiveInputStream.access$900(this.this$0);
            CurrentEntry.access$702(r8, CurrentEntry.access$700(r8) + r2);
            return r12;
        L13:
            r1 = r11;
            goto L14
        }

        @Override // java.io.InputStream
        public long skip(long r5) {
            long r0 = this.max;
            if (r0 < 0) goto L5;
            r5 = Math.min(r5, r0 - this.pos);
        L5:
            long r6 = IOUtils.skip(this.in, r5);
            this.pos += r6;
            return r6;
        }
    }

    private static final class CurrentEntry {
        private long bytesRead;
        private long bytesReadFromStream;
        private final CRC32 crc;
        private final ZipArchiveEntry entry;
        private boolean hasDataDescriptor;
        private InputStream in;
        private boolean usesZip64;

        private CurrentEntry() {
            this.entry = new ZipArchiveEntry();
            this.crc = new CRC32();
        }

        /* synthetic */ CurrentEntry(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ ZipArchiveEntry access$100(CurrentEntry r0) {
            return r0.entry;
        }

        static /* synthetic */ boolean access$200(CurrentEntry r0) {
            return r0.hasDataDescriptor;
        }

        static /* synthetic */ boolean access$202(CurrentEntry r0, boolean r1) {
            r0.hasDataDescriptor = r1;
            return r1;
        }

        static /* synthetic */ InputStream access$300(CurrentEntry r0) {
            return r0.in;
        }

        static /* synthetic */ InputStream access$302(CurrentEntry r0, InputStream r1) {
            r0.in = r1;
            return r1;
        }

        static /* synthetic */ boolean access$400(CurrentEntry r0) {
            return r0.usesZip64;
        }

        static /* synthetic */ boolean access$402(CurrentEntry r0, boolean r1) {
            r0.usesZip64 = r1;
            return r1;
        }

        static /* synthetic */ CRC32 access$500(CurrentEntry r0) {
            return r0.crc;
        }

        static /* synthetic */ long access$600(CurrentEntry r2) {
            return r2.bytesRead;
        }

        static /* synthetic */ long access$602(CurrentEntry r0, long r1) {
            r0.bytesRead = r1;
            return r1;
        }

        static /* synthetic */ long access$700(CurrentEntry r2) {
            return r2.bytesReadFromStream;
        }

        static /* synthetic */ long access$702(CurrentEntry r0, long r1) {
            r0.bytesReadFromStream = r1;
            return r1;
        }

        static /* synthetic */ long access$708(CurrentEntry r4) {
            long r0 = r4.bytesReadFromStream;
            r4.bytesReadFromStream = 1 + r0;
            return r0;
        }
    }

    static {
        LFH = ZipLong.LFH_SIG.getBytes();
        CFH = ZipLong.CFH_SIG.getBytes();
        DD = ZipLong.DD_SIG.getBytes();
        APK_SIGNING_BLOCK_MAGIC = new byte[]{65, 80, 75, 32, 83, 105, 103, 32, 66, 108, 111, 99, 107, 32, 52, 50};
        LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    }

    public ZipArchiveInputStream(InputStream r2) {
        this(r2, "UTF8");
    }

    public ZipArchiveInputStream(InputStream r2, String r3) {
        this(r2, r3, true);
    }

    public ZipArchiveInputStream(InputStream r2, String r3, boolean r4) {
        this(r2, r3, r4, false);
    }

    public ZipArchiveInputStream(InputStream r7, String r8, boolean r9, boolean r10) {
        this(r7, r8, r9, r10, false);
    }

    public ZipArchiveInputStream(InputStream r3, String r4, boolean r5, boolean r6, boolean r7) {
        this.inf = new Inflater(true);
        ByteBuffer r0 = ByteBuffer.allocate(512);
        this.buf = r0;
        this.lfhBuf = new byte[30];
        this.skipBuf = new byte[1024];
        this.shortBuf = new byte[2];
        this.wordBuf = new byte[4];
        this.twoDwordBuf = new byte[16];
        this.encoding = r4;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(r4);
        this.useUnicodeExtraFields = r5;
        this.in = new PushbackInputStream(r3, r0.capacity());
        this.allowStoredEntriesWithDataDescriptor = r6;
        this.skipSplitSig = r7;
        r0.limit(0);
    }

    static /* synthetic */ void access$1000(ZipArchiveInputStream r0, int r1) {
        r0.count(r1);
    }

    static /* synthetic */ void access$800(ZipArchiveInputStream r0, int r1) {
        r0.count(r1);
    }

    static /* synthetic */ CurrentEntry access$900(ZipArchiveInputStream r0) {
        return r0.current;
    }

    private boolean bufferContainsSignature(ByteArrayOutputStream r12, int r13, int r14, int r15) {
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r1 == true) goto L31;
        int r3 = r13 + r14;
        if (r2 >= (r3 - 4)) goto L31;
        byte r4 = this.buf.array()[r2];
        byte[] r5 = LFH;
        if (r4 != r5[0]) goto L30;
        if (this.buf.array()[r2 + 1] != r5[1]) goto L30;
        if (r2 >= r15) goto L13;
    L16:
        int r8 = r2 + 2;
        byte r6 = this.buf.array()[r8];
        byte[] r9 = CFH;
        if (r6 == r9[2]) goto L19;
    L22:
        byte r7 = this.buf.array()[r8];
        byte[] r10 = DD;
        if (r7 == r10[2]) goto L25;
    L27:
        int r11 = r2;
    L28:
        if (r1 == false) goto L30;
        pushback(this.buf.array(), r11, r3 - r11);
        r12.write(this.buf.array(), 0, r11);
        readDataDescriptor();
        goto L30
    L25:
        if (this.buf.array()[r2 + 3] != r10[3]) goto L27;
        r11 = r2;
    L21:
        r1 = true;
        goto L28
    L19:
        if (this.buf.array()[r2 + 3] != r9[3]) goto L22;
    L20:
        r11 = r2 - r15;
        goto L21
    L13:
        if (this.buf.array()[r2 + 2] != r5[2]) goto L16;
        if (this.buf.array()[r2 + 3] == r5[3]) goto L20;
    L30:
        r2 = r2 + 1;
    L31:
        return r1;
    }

    private int cacheBytesRead(ByteArrayOutputStream r2, int r3, int r4, int r5) {
        int r6 = r3 + r4;
        int r7 = (r6 - r5) - 3;
        if (r7 <= 0) goto L6;
        r2.write(this.buf.array(), 0, r7);
        int r8 = r5 + 3;
        System.arraycopy(this.buf.array(), r7, this.buf.array(), 0, r8);
        return r8;
    L6:
        return r6;
    }

    private void closeEntry() {
        if (this.closed == true) goto L28;
        if (this.current != null) goto L8;
        return;
    L8:
        if (currentEntryHasOutstandingBytes() == false) goto L10;
    L9:
        drainCurrentEntryData();
    L21:
        if (this.lastStoredEntry == null) goto L23;
    L25:
        this.inf.reset();
        this.buf.clear().flip();
        this.current = null;
        this.lastStoredEntry = null;
        return;
    L23:
        if (CurrentEntry.access$200(this.current) == false) goto L25;
        readDataDescriptor();
        goto L25
    L10:
        skip(Long.MAX_VALUE);
        if (CurrentEntry.access$100(this.current).getMethod() != 8) goto L13;
        long r0 = getBytesInflated();
    L14:
        int r1 = (int) (CurrentEntry.access$700(this.current) - r0);
        if (r1 <= 0) goto L18;
        pushback(this.buf.array(), this.buf.limit() - r1, r1);
        CurrentEntry r2 = this.current;
        CurrentEntry.access$702(r2, CurrentEntry.access$700(r2) - ((long) r1));
    L18:
        if (currentEntryHasOutstandingBytes() == false) goto L21;
    L13:
        r0 = CurrentEntry.access$600(this.current);
        goto L14
    L28:
        throw new IOException("The stream is closed");
    }

    private boolean currentEntryHasOutstandingBytes() {
        if (CurrentEntry.access$700(this.current) <= CurrentEntry.access$100(this.current).getCompressedSize()) goto L5;
    L7:
        return false;
    L5:
        if (CurrentEntry.access$200(this.current) == true) goto L7;
        return true;
    }

    private void drainCurrentEntryData() {
        long r0 = CurrentEntry.access$100(this.current).getCompressedSize() - CurrentEntry.access$700(this.current);
    L4:
        if (r0 <= 0) goto L10;
        long r4 = this.in.read(this.buf.array(), 0, (int) Math.min(this.buf.capacity(), r0));
        if (r4 < 0) goto L9;
        count(r4);
        r0 = r0 - r4;
        goto L4
    L9:
        throw new EOFException("Truncated ZIP entry: " + ArchiveUtils.sanitize(CurrentEntry.access$100(this.current).getName()));
    }

    private int fill() {
        if (this.closed == true) goto L9;
        int r0 = this.in.read(this.buf.array());
        if (r0 <= 0) goto L7;
        this.buf.limit(r0);
        count(this.buf.limit());
        this.inf.setInput(this.buf.array(), 0, this.buf.limit());
    L7:
        return r0;
    L9:
        throw new IOException("The stream is closed");
    }

    private boolean findEocdRecord() {
        boolean r2 = false;
        int r3 = -1;
    L3:
        if (r2 == true) goto L7;
        r3 = readOneByte();
        if (r3 > (-1)) goto L7;
    L20:
        return false;
    L7:
        if (isFirstByteOfEocdSig(r3) == false) goto L8;
        r3 = readOneByte();
        if (r3 == ZipArchiveOutputStream.EOCD_SIG[1]) goto L14;
        if (r3 == (-1)) goto L20;
    L13:
        r2 = isFirstByteOfEocdSig(r3);
        goto L3
    L14:
        r3 = readOneByte();
        if (r3 == ZipArchiveOutputStream.EOCD_SIG[2]) goto L18;
        if (r3 != (-1)) goto L13;
    L18:
        r3 = readOneByte();
        if (r3 == (-1)) goto L20;
        if (r3 != ZipArchiveOutputStream.EOCD_SIG[3]) goto L13;
        return true;
    L8:
        r2 = false;
        goto L3
    }

    private long getBytesInflated() {
        long r0 = this.inf.getBytesRead();
        if (CurrentEntry.access$700(this.current) < 4294967296L) goto L7;
    L4:
        long r2 = r0 + 4294967296L;
        if (r2 > CurrentEntry.access$700(this.current)) goto L7;
        r0 = r2;
    L7:
        return r0;
    }

    private boolean isApkSigningBlock(byte[] r8) {
        BigInteger r0 = ZipEightByteInteger.getValue(r8);
        long r3 = 8 - r8.length;
        byte[] r1 = APK_SIGNING_BLOCK_MAGIC;
        BigInteger r2 = r0.add(BigInteger.valueOf(r3 - ((long) r1.length)));
        int r4 = r1.length;
        byte[] r5 = new byte[r4];
    L17:
        return false;
    L4:
        if (r2.signum() >= 0) goto L11;
        int r6 = r8.length + r2.intValue();     // Catch: EOFException -> L17
        if (r6 >= 8) goto L8;
        return false;
    L8:
        int r7 = Math.abs(r2.intValue());     // Catch: EOFException -> L17
        System.arraycopy(r8, r6, r5, 0, Math.min(r7, r4));     // Catch: EOFException -> L17
        if (r7 >= r4) goto L16;
        readFully(r5, r7);     // Catch: EOFException -> L17
    L16:
        return Arrays.equals(r5, APK_SIGNING_BLOCK_MAGIC);
    L11:
        BigInteger r9 = LONG_MAX;     // Catch: EOFException -> L17
        if (r2.compareTo(r9) <= 0) goto L14;
        realSkip(Long.MAX_VALUE);     // Catch: EOFException -> L17
        r2 = r2.add(r9.negate());     // Catch: EOFException -> L17
        goto L11
    L14:
        realSkip(r2.longValue());     // Catch: EOFException -> L17
        readFully(r5);     // Catch: EOFException -> L17
        goto L16
    }

    private boolean isFirstByteOfEocdSig(int r2) {
        if (r2 != ZipArchiveOutputStream.EOCD_SIG[0]) goto L6;
        return true;
    L6:
        return false;
    }

    private void processZip64Extra(ZipLong r8, ZipLong r9) {
        ZipExtraField r0 = CurrentEntry.access$100(this.current).getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (r0 != null) goto L5;
    L9:
        Zip64ExtendedInformationExtraField r1 = (Zip64ExtendedInformationExtraField) ZeusTransformUtils.preCheckCast(r0, Zip64ExtendedInformationExtraField.class, "com.obric.memorydata.plugin");
        CurrentEntry r2 = this.current;
        if (r1 == null) goto L12;
        boolean r3 = true;
    L13:
        CurrentEntry.access$402(r2, r3);
        if (CurrentEntry.access$200(this.current) == false) goto L16;
        return;
    L16:
        if (r1 != null) goto L18;
    L36:
        if (r9 == null) goto L49;
        if (r8 != null) goto L39;
        return;
    L39:
        if (r9.getValue() < 0) goto L47;
        CurrentEntry.access$100(this.current).setCompressedSize(r9.getValue());
        if (r8.getValue() < 0) goto L45;
        ZipArchiveEntry r7 = CurrentEntry.access$100(this.current);
        long r10 = r8.getValue();
    L43:
        r7.setSize(r10);
        return;
    L45:
        throw new ZipException("broken archive, entry with negative size");
    L47:
        throw new ZipException("broken archive, entry with negative compressed size");
    L49:
        return;
    L18:
        if (ZipLong.ZIP64_MAGIC.equals(r9) == true) goto L22;
        if (ZipLong.ZIP64_MAGIC.equals(r8) == false) goto L36;
    L22:
        if (r1.getCompressedSize() == null) goto L35;
        if (r1.getSize() == null) goto L35;
        long r11 = r1.getCompressedSize().getLongValue();
        if (r11 < 0) goto L33;
        CurrentEntry.access$100(this.current).setCompressedSize(r11);
        r10 = r1.getSize().getLongValue();
        if (r10 < 0) goto L31;
        r7 = CurrentEntry.access$100(this.current);
        goto L43
    L31:
        throw new ZipException("broken archive, entry with negative size");
    L33:
        throw new ZipException("broken archive, entry with negative compressed size");
    L35:
        throw new ZipException("archive contains corrupted zip64 extra field");
    L12:
        r3 = false;
        goto L13
    L5:
        if (ZeusTransformUtils.instanceOf(r0, Zip64ExtendedInformationExtraField.class) == true) goto L9;
        throw new ZipException("archive contains unparseable zip64 extra field");
    }

    private void pushback(byte[] r4, int r5, int r6) {
        ((PushbackInputStream) ZeusTransformUtils.preCheckCast(this.in, PushbackInputStream.class, "com.obric.memorydata.plugin")).unread(r4, r5, r6);
        pushedBackBytes(r6);
    }

    private void readDataDescriptor() {
        readFully(this.wordBuf);
        ZipLong r0 = new ZipLong(this.wordBuf);
        if (ZipLong.DD_SIG.equals(r0) == false) goto L5;
        readFully(this.wordBuf);
        r0 = new ZipLong(this.wordBuf);
    L5:
        CurrentEntry.access$100(this.current).setCrc(r0.getValue());
        readFully(this.twoDwordBuf);
        ZipLong r1 = new ZipLong(this.twoDwordBuf, 8);
        if (r1.equals(ZipLong.CFH_SIG) == false) goto L8;
    L19:
        pushback(this.twoDwordBuf, 8, 8);
        long r2 = ZipLong.getValue(this.twoDwordBuf);
        if (r2 < 0) goto L28;
        CurrentEntry.access$100(this.current).setCompressedSize(r2);
        long r3 = ZipLong.getValue(this.twoDwordBuf, 4);
        if (r3 < 0) goto L26;
    L23:
        CurrentEntry.access$100(this.current).setSize(r3);
        return;
    L26:
        throw new ZipException("broken archive, entry with negative size");
    L28:
        throw new ZipException("broken archive, entry with negative compressed size");
    L8:
        if (r1.equals(ZipLong.LFH_SIG) == true) goto L19;
        long r4 = ZipEightByteInteger.getLongValue(this.twoDwordBuf);
        if (r4 < 0) goto L18;
        CurrentEntry.access$100(this.current).setCompressedSize(r4);
        r3 = ZipEightByteInteger.getLongValue(this.twoDwordBuf, 8);
        if (r3 >= 0) goto L23;
        throw new ZipException("broken archive, entry with negative size");
    L18:
        throw new ZipException("broken archive, entry with negative compressed size");
    }

    private int readDeflated(byte[] r1, int r2, int r3) {
        int r4 = readFromInflater(r1, r2, r3);
        if (r4 <= 0) goto L5;
    L15:
        return r4;
    L5:
        if (this.inf.finished() == false) goto L8;
        return -1;
    L8:
        if (this.inf.needsDictionary() == true) goto L14;
        if (r4 != (-1)) goto L15;
        throw new IOException("Truncated ZIP file");
    L14:
        throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress.");
    }

    private void readFirstLocalFileHeader() {
        readFully(this.lfhBuf);
        ZipLong r0 = new ZipLong(this.lfhBuf);
        if (this.skipSplitSig == true) goto L10;
        if (r0.equals(ZipLong.DD_SIG) == false) goto L10;
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.SPLITTING);
    L10:
        if (r0.equals(ZipLong.SINGLE_SEGMENT_SPLIT_MARKER) == false) goto L12;
    L13:
        byte[] r1 = new byte[4];
        readFully(r1);
        byte[] r2 = this.lfhBuf;
        System.arraycopy(r2, 4, r2, 0, 26);
        System.arraycopy(r1, 0, this.lfhBuf, 26, 4);
        return;
    L12:
        if (r0.equals(ZipLong.DD_SIG) == true) goto L13;
    }

    private int readFromInflater(byte[] r6, int r7, int r8) {
        int r0 = 0;
    L4:
        if (this.inf.needsInput() == false) goto L19;
        int r1 = fill();
        if (r1 <= 0) goto L9;
        CurrentEntry r2 = this.current;
        CurrentEntry.access$702(r2, CurrentEntry.access$700(r2) + ((long) this.buf.limit()));
        goto L19
    L9:
        if (r1 != (-1)) goto L15;
        return -1;
    L15:
        return r0;
    L19:
        r0 = this.inf.inflate(r6, r7, r8);     // Catch: DataFormatException -> L16
        if (r0 != 0) goto L15;
        if (this.inf.needsInput() == true) goto L4;
    L16:
        e = move-exception;
        throw ((IOException) ZeusTransformUtils.preCheckCast(new ZipException(e.getMessage()).initCause(e), IOException.class, "com.obric.memorydata.plugin"));
    }

    private void readFully(byte[] r2) {
        readFully(r2, 0);
    }

    private void readFully(byte[] r3, int r4) {
        int r0 = r3.length - r4;
        int r5 = IOUtils.readFully(this.in, r3, r4, r0);
        count(r5);
        if (r5 < r0) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    private int readOneByte() {
        int r0 = this.in.read();
        if (r0 == (-1)) goto L5;
        count(1);
    L5:
        return r0;
    }

    private byte[] readRange(int r3) {
        byte[] r0 = IOUtils.readRange(this.in, r3);
        count(r0.length);
        if (r0.length < r3) goto L6;
        return r0;
    L6:
        throw new EOFException();
    }

    private int readStored(byte[] r9, int r10, int r11) {
        if (CurrentEntry.access$200(this.current) == true) goto L5;
        long r0 = CurrentEntry.access$100(this.current).getSize();
        if (CurrentEntry.access$600(this.current) < r0) goto L13;
        return -1;
    L13:
        if (this.buf.position() < this.buf.limit()) goto L19;
        this.buf.position(0);
        int r2 = this.in.read(this.buf.array());
        if (r2 == (-1)) goto L17;
        this.buf.limit(r2);
        count(r2);
        CurrentEntry r3 = this.current;
        CurrentEntry.access$702(r3, CurrentEntry.access$700(r3) + ((long) r2));
        goto L19
    L17:
        this.buf.limit(0);
        throw new IOException("Truncated ZIP file");
    L19:
        int r12 = Math.min(this.buf.remaining(), r11);
        if ((r0 - CurrentEntry.access$600(this.current)) >= r12) goto L22;
        r12 = (int) (r0 - CurrentEntry.access$600(this.current));
    L22:
        this.buf.get(r9, r10, r12);
        CurrentEntry r8 = this.current;
        CurrentEntry.access$602(r8, CurrentEntry.access$600(r8) + ((long) r12));
        return r12;
    L5:
        if (this.lastStoredEntry != null) goto L8;
        readStoredEntry();
    L8:
        return this.lastStoredEntry.read(r9, r10, r11);
    }

    private void readStoredEntry() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        if (CurrentEntry.access$400(this.current) == false) goto L5;
        int r1 = 20;
    L6:
        boolean r2 = false;
        int r3 = 0;
    L7:
        if (r2 == true) goto L19;
        int r4 = this.in.read(this.buf.array(), r3, 512 - r3);
        if (r4 <= 0) goto L17;
        int r5 = r4 + r3;
        if (r5 < 4) goto L12;
        r2 = bufferContainsSignature(r0, r3, r4, r1);
        if (r2 == true) goto L7;
        r3 = cacheBytesRead(r0, r3, r4, r1);
        goto L7
    L12:
        r3 = r5;
        goto L7
    L17:
        throw new IOException("Truncated ZIP file");
    L19:
        if (CurrentEntry.access$100(this.current).getCompressedSize() != CurrentEntry.access$100(this.current).getSize()) goto L27;
        byte[] r6 = r0.toByteArray();
        if (r6.length != CurrentEntry.access$100(this.current).getSize()) goto L25;
        this.lastStoredEntry = new ByteArrayInputStream(r6);
        return;
    L25:
        throw new ZipException("actual and claimed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
    L27:
        throw new ZipException("compressed and uncompressed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
    L5:
        r1 = 12;
        goto L6
    }

    private void realSkip(long r10) {
        long r0 = 0;
        if (r10 < 0) goto L16;
    L5:
        if (r0 >= r10) goto L14;
        long r2 = r10 - r0;
        InputStream r4 = this.in;
        byte[] r5 = this.skipBuf;
        if (r5.length > r2) goto L10;
        r2 = r5.length;
    L10:
        int r3 = r4.read(r5, 0, (int) r2);
        if (r3 == (-1)) goto L12;
        count(r3);
        r0 = r0 + ((long) r3);
        goto L5
    L12:
        return;
    L14:
        return;
    L16:
        throw new IllegalArgumentException();
    }

    private void skipRemainderOfArchive() {
        int r0 = this.entriesRead;
        if (r0 <= 0) goto L11;
        realSkip((((long) r0) * 46) - 30);
        if (findEocdRecord() == false) goto L11;
        realSkip(16);
        readFully(this.shortBuf);
        int r1 = ZipShort.getValue(this.shortBuf);
        if (r1 < 0) goto L11;
        realSkip(r1);
        return;
    L11:
        throw new IOException("Truncated ZIP file");
    }

    private boolean supportsCompressedSizeFor(ZipArchiveEntry r5) {
        if (r5.getCompressedSize() == (-1)) goto L5;
    L16:
        return true;
    L5:
        if (r5.getMethod() == 8) goto L16;
        if (r5.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) goto L16;
        if (r5.getGeneralPurposeBit().usesDataDescriptor() == true) goto L11;
    L15:
        return false;
    L11:
        if (this.allowStoredEntriesWithDataDescriptor == false) goto L15;
        if (r5.getMethod() != 0) goto L15;
        goto L15
    }

    private boolean supportsDataDescriptorFor(ZipArchiveEntry r2) {
        if (r2.getGeneralPurposeBit().usesDataDescriptor() == true) goto L5;
    L14:
        return true;
    L5:
        if (this.allowStoredEntriesWithDataDescriptor == false) goto L9;
        if (r2.getMethod() == 0) goto L14;
    L9:
        if (r2.getMethod() == 8) goto L14;
        if (r2.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) goto L14;
        return false;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == true) goto L10;
        this.closed = true;
        this.in.close();     // Catch: Throwable -> L7
        this.inf.end();
        return;
    L7:
        th = move-exception;
        this.inf.end();
        throw th;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        if (CurrentEntry.access$100(this.current).getMethod() != 0) goto L7;
        return CurrentEntry.access$600(this.current);
    L7:
        if (CurrentEntry.access$100(this.current).getMethod() != 8) goto L11;
        return getBytesInflated();
    L11:
        if (CurrentEntry.access$100(this.current).getMethod() != ZipMethod.UNSHRINKING.getCode()) goto L15;
        return ((UnshrinkingInputStream) ZeusTransformUtils.preCheckCast(CurrentEntry.access$300(this.current), UnshrinkingInputStream.class, "com.obric.memorydata.plugin")).getCompressedCount();
    L15:
        if (CurrentEntry.access$100(this.current).getMethod() != ZipMethod.IMPLODING.getCode()) goto L19;
        return ((ExplodingInputStream) ZeusTransformUtils.preCheckCast(CurrentEntry.access$300(this.current), ExplodingInputStream.class, "com.obric.memorydata.plugin")).getCompressedCount();
    L19:
        if (CurrentEntry.access$100(this.current).getMethod() != ZipMethod.ENHANCED_DEFLATED.getCode()) goto L23;
        return ((Deflate64CompressorInputStream) ZeusTransformUtils.preCheckCast(CurrentEntry.access$300(this.current), Deflate64CompressorInputStream.class, "com.obric.memorydata.plugin")).getCompressedCount();
    L23:
        if (CurrentEntry.access$100(this.current).getMethod() == ZipMethod.BZIP2.getCode()) goto L25;
        return -1;
    L25:
        return ((BZip2CompressorInputStream) ZeusTransformUtils.preCheckCast(CurrentEntry.access$300(this.current), BZip2CompressorInputStream.class, "com.obric.memorydata.plugin")).getCompressedCount();
    }

    public ZipArchiveEntry getNextZipEntry() {
        this.uncompressedCount = 0;
        AnonymousClass1 r1 = null;
        if (this.closed == false) goto L5;
    L78:
        return null;
    L5:
        if (this.hitCentralDirectory == true) goto L78;
        if (this.current == null) goto L10;
        closeEntry();
        boolean r0 = false;
    L11:
        long r4 = getBytesRead();
        if (r0 == false) goto L14;
        readFirstLocalFileHeader();     // Catch: EOFException -> L79
    L15:
        ZipLong r2 = new ZipLong(this.lfhBuf);
        if (r2.equals(ZipLong.LFH_SIG) == false) goto L18;
        this.current = new CurrentEntry(r1);
        CurrentEntry.access$100(this.current).setPlatform((ZipShort.getValue(this.lfhBuf, 4) >> 8) & 15);
        GeneralPurposeBit r3 = GeneralPurposeBit.parse(this.lfhBuf, 6);
        boolean r6 = r3.usesUTF8ForNames();
        if (r6 == false) goto L31;
        ZipEncoding r7 = ZipEncodingHelper.UTF8_ZIP_ENCODING;
    L32:
        CurrentEntry.access$202(this.current, r3.usesDataDescriptor());
        CurrentEntry.access$100(this.current).setGeneralPurposeBit(r3);
        CurrentEntry.access$100(this.current).setMethod(ZipShort.getValue(this.lfhBuf, 8));
        CurrentEntry.access$100(this.current).setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.lfhBuf, 10)));
        if (CurrentEntry.access$200(this.current) == true) goto L35;
        CurrentEntry.access$100(this.current).setCrc(ZipLong.getValue(this.lfhBuf, 14));
        ZipLong r8 = new ZipLong(this.lfhBuf, 18);
        ZipLong r9 = new ZipLong(this.lfhBuf, 22);
    L36:
        int r5 = ZipShort.getValue(this.lfhBuf, 26);
        int r10 = ZipShort.getValue(this.lfhBuf, 28);
        byte[] r11 = readRange(r5);
        CurrentEntry.access$100(this.current).setName(r7.decode(r11), r11);
        if (r6 == false) goto L84;
        CurrentEntry.access$100(this.current).setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
    L84:
        CurrentEntry.access$100(this.current).setExtra(readRange(r10));     // Catch: RuntimeException -> L75
        if (r6 == false) goto L43;
    L45:
        processZip64Extra(r9, r8);
        CurrentEntry.access$100(this.current).setLocalHeaderOffset(r4);
        CurrentEntry.access$100(this.current).setDataOffset(getBytesRead());
        CurrentEntry.access$100(this.current).setStreamContiguous(true);
        ZipMethod r12 = ZipMethod.getMethodByCode(CurrentEntry.access$100(this.current).getMethod());
        if (CurrentEntry.access$100(this.current).getCompressedSize() == (-1)) goto L71;
        if (ZipUtil.canHandleEntryData(CurrentEntry.access$100(this.current)) == true) goto L50;
    L73:
        this.entriesRead++;
        return CurrentEntry.access$100(this.current);
    L50:
        if (r12 == ZipMethod.STORED) goto L73;
        if (r12 == ZipMethod.DEFLATED) goto L73;
        BoundedInputStream r13 = new BoundedInputStream(this, this.in, CurrentEntry.access$100(this.current).getCompressedSize());
        int r14 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[r12.ordinal()];
        if (r14 != 1) goto L56;
        CurrentEntry r15 = this.current;
        InputStream r16 = new UnshrinkingInputStream(r13);
    L69:
        CurrentEntry.access$302(r15, r16);
        goto L73
    L56:
        if (r14 != 2) goto L58;
        CurrentEntry.access$302(this.current, new ExplodingInputStream(CurrentEntry.access$100(this.current).getGeneralPurposeBit().getSlidingDictionarySize(), CurrentEntry.access$100(this.current).getGeneralPurposeBit().getNumberOfShannonFanoTrees(), r13));     // Catch: IllegalArgumentException -> L65
    L65:
        e = move-exception;
        throw new IOException("bad IMPLODE data", e);
    L58:
        if (r14 == 3) goto L62;
        if (r14 != 4) goto L73;
        r15 = this.current;
        r16 = new Deflate64CompressorInputStream(r13);
        goto L69
    L62:
        r15 = this.current;
        r16 = new BZip2CompressorInputStream(r13);
        goto L69
    L71:
        if (r12 != ZipMethod.ENHANCED_DEFLATED) goto L73;
        CurrentEntry.access$302(this.current, new Deflate64CompressorInputStream(this.in));
        goto L73
    L43:
        if (this.useUnicodeExtraFields == false) goto L45;
        ZipUtil.setNameAndCommentFromExtraFields(CurrentEntry.access$100(this.current), r11, null);
    L75:
        e = move-exception;
        ZipException r17 = new ZipException("Invalid extra data in entry " + CurrentEntry.access$100(this.current).getName());
        r17.initCause(e);
        throw r17;
    L35:
        r8 = null;
        r9 = null;
        goto L36
    L31:
        r7 = this.zipEncoding;
        goto L32
    L18:
        if (r2.equals(ZipLong.CFH_SIG) == false) goto L20;
    L26:
        this.hitCentralDirectory = true;
        skipRemainderOfArchive();
        return null;
    L20:
        if (r2.equals(ZipLong.AED_SIG) == true) goto L26;
        if (isApkSigningBlock(this.lfhBuf) == true) goto L26;
        throw new ZipException(String.format("Unexpected record signature: 0X%X", new Object[]{Long.valueOf(r2.getValue())}));
    L14:
        readFully(this.lfhBuf);     // Catch: EOFException -> L79
        goto L15
    L10:
        r0 = true;
        goto L11
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (this.closed == true) goto L49;
        CurrentEntry r0 = this.current;
        if (r0 != null) goto L12;
        return -1;
    L12:
        if (r4 > r3.length) goto L47;
        if (r5 < 0) goto L47;
        if (r4 < 0) goto L47;
        if ((r3.length - r4) < r5) goto L47;
        ZipUtil.checkRequestedFeatures(CurrentEntry.access$100(r0));
        if (supportsDataDescriptorFor(CurrentEntry.access$100(this.current)) == false) goto L45;
        if (supportsCompressedSizeFor(CurrentEntry.access$100(this.current)) == false) goto L43;
        if (CurrentEntry.access$100(this.current).getMethod() != 0) goto L25;
        int r6 = readStored(r3, r4, r5);
    L39:
        if (r6 < 0) goto L41;
        CurrentEntry.access$500(this.current).update(r3, r4, r6);
        this.uncompressedCount += (long) r6;
    L41:
        return r6;
    L25:
        if (CurrentEntry.access$100(this.current).getMethod() != 8) goto L28;
        r6 = readDeflated(r3, r4, r5);
        goto L39
    L28:
        if (CurrentEntry.access$100(this.current).getMethod() != ZipMethod.UNSHRINKING.getCode()) goto L30;
    L38:
        r6 = CurrentEntry.access$300(this.current).read(r3, r4, r5);
        goto L39
    L30:
        if (CurrentEntry.access$100(this.current).getMethod() == ZipMethod.IMPLODING.getCode()) goto L38;
        if (CurrentEntry.access$100(this.current).getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) goto L38;
        if (CurrentEntry.access$100(this.current).getMethod() == ZipMethod.BZIP2.getCode()) goto L38;
        throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(CurrentEntry.access$100(this.current).getMethod()), CurrentEntry.access$100(this.current));
    L43:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.UNKNOWN_COMPRESSED_SIZE, CurrentEntry.access$100(this.current));
    L45:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.DATA_DESCRIPTOR, CurrentEntry.access$100(this.current));
    L47:
        throw new ArrayIndexOutOfBoundsException();
    L49:
        throw new IOException("The stream is closed");
    }

    @Override // java.io.InputStream
    public long skip(long r9) {
        long r0 = 0;
        if (r9 < 0) goto L16;
    L5:
        if (r0 >= r9) goto L14;
        long r2 = r9 - r0;
        byte[] r4 = this.skipBuf;
        if (r4.length > r2) goto L10;
        r2 = r4.length;
    L10:
        int r3 = read(r4, 0, (int) r2);
        if (r3 == (-1)) goto L12;
        r0 = r0 + ((long) r3);
        goto L5
    L12:
        return r0;
    L14:
        return r0;
    L16:
        throw new IllegalArgumentException();
    }
}
