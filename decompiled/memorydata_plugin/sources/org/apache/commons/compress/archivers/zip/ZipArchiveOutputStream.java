package org.apache.commons.compress.archivers.zip;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ZipArchiveOutputStream extends ArchiveOutputStream {
    static final byte[] CFH_SIG = null;
    static final byte[] DD_SIG = null;
    static final byte[] EOCD_SIG = null;
    static final byte[] LFH_SIG = null;
    private static final byte[] LZERO = null;
    private static final byte[] ONE = null;
    private static final byte[] ZERO = null;
    static final byte[] ZIP64_EOCD_LOC_SIG = null;
    static final byte[] ZIP64_EOCD_SIG = null;
    private final Calendar calendarInstance;
    private long cdDiskNumberStart;
    private long cdLength;
    private long cdOffset;
    private final SeekableByteChannel channel;
    private String comment;
    private final byte[] copyBuffer;
    private UnicodeExtraFieldPolicy createUnicodeExtraFields;
    protected final Deflater def;
    private String encoding;
    private final List<ZipArchiveEntry> entries;
    private CurrentEntry entry;
    private long eocdLength;
    private boolean fallbackToUTF8;
    protected boolean finished;
    private boolean hasCompressionLevelChanged;
    private boolean hasUsedZip64;
    private final boolean isSplitZip;
    private int level;
    private final Map<ZipArchiveEntry, EntryMetaData> metaData;
    private int method;
    private final Map<Integer, Integer> numberOfCDInDiskData;
    private final OutputStream out;
    private final StreamCompressor streamCompressor;
    private boolean useUTF8Flag;
    private Zip64Mode zip64Mode;
    private ZipEncoding zipEncoding;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class CurrentEntry {
        private long bytesRead;
        private boolean causedUseOfZip64;
        private long dataStart;
        private final ZipArchiveEntry entry;
        private boolean hasWritten;
        private long localDataStart;

        private CurrentEntry(ZipArchiveEntry r1) {
            this.entry = r1;
        }

        /* synthetic */ CurrentEntry(ZipArchiveEntry r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ long access$000(CurrentEntry r2) {
            return r2.dataStart;
        }

        static /* synthetic */ long access$002(CurrentEntry r0, long r1) {
            r0.dataStart = r1;
            return r1;
        }

        static /* synthetic */ long access$100(CurrentEntry r2) {
            return r2.bytesRead;
        }

        static /* synthetic */ long access$102(CurrentEntry r0, long r1) {
            r0.bytesRead = r1;
            return r1;
        }

        static /* synthetic */ ZipArchiveEntry access$200(CurrentEntry r0) {
            return r0.entry;
        }

        static /* synthetic */ boolean access$300(CurrentEntry r0) {
            return r0.hasWritten;
        }

        static /* synthetic */ long access$400(CurrentEntry r2) {
            return r2.localDataStart;
        }

        static /* synthetic */ long access$402(CurrentEntry r0, long r1) {
            r0.localDataStart = r1;
            return r1;
        }

        static /* synthetic */ boolean access$500(CurrentEntry r0) {
            return r0.causedUseOfZip64;
        }

        static /* synthetic */ boolean access$502(CurrentEntry r0, boolean r1) {
            r0.causedUseOfZip64 = r1;
            return r1;
        }
    }

    private static final class EntryMetaData {
        private final long offset;
        private final boolean usesDataDescriptor;

        private EntryMetaData(long r1, boolean r3) {
            this.offset = r1;
            this.usesDataDescriptor = r3;
        }

        /* synthetic */ EntryMetaData(long r1, boolean r3, AnonymousClass1 r4) {
            this(r1, r3);
        }

        static /* synthetic */ long access$800(EntryMetaData r2) {
            return r2.offset;
        }

        static /* synthetic */ boolean access$900(EntryMetaData r0) {
            return r0.usesDataDescriptor;
        }
    }

    public static final class UnicodeExtraFieldPolicy {
        public static final UnicodeExtraFieldPolicy ALWAYS = null;
        public static final UnicodeExtraFieldPolicy NEVER = null;
        public static final UnicodeExtraFieldPolicy NOT_ENCODEABLE = null;
        private final String name;

        static {
            ALWAYS = new UnicodeExtraFieldPolicy(ObricSecurityGuardStub.PermissionLevel.PERMISSION_LEVEL_ALWAYS);
            NEVER = new UnicodeExtraFieldPolicy("never");
            NOT_ENCODEABLE = new UnicodeExtraFieldPolicy("not encodeable");
        }

        private UnicodeExtraFieldPolicy(String r1) {
            this.name = r1;
        }

        public String toString() {
            return this.name;
        }
    }

    static {
        ZERO = new byte[]{0, 0};
        LZERO = new byte[]{0, 0, 0, 0};
        ONE = ZipLong.getBytes(1);
        LFH_SIG = ZipLong.LFH_SIG.getBytes();
        DD_SIG = ZipLong.DD_SIG.getBytes();
        CFH_SIG = ZipLong.CFH_SIG.getBytes();
        EOCD_SIG = ZipLong.getBytes(101010256);
        ZIP64_EOCD_SIG = ZipLong.getBytes(101075792);
        ZIP64_EOCD_LOC_SIG = ZipLong.getBytes(117853008);
    }

    public ZipArchiveOutputStream(OutputStream r4) {
        this.comment = "";
        this.level = -1;
        this.method = 8;
        this.entries = new LinkedList();
        this.metaData = new HashMap();
        this.encoding = "UTF8";
        this.zipEncoding = ZipEncodingHelper.getZipEncoding("UTF8");
        this.useUTF8Flag = true;
        this.createUnicodeExtraFields = UnicodeExtraFieldPolicy.NEVER;
        this.zip64Mode = Zip64Mode.AsNeeded;
        this.copyBuffer = new byte[32768];
        this.calendarInstance = Calendar.getInstance();
        this.numberOfCDInDiskData = new HashMap();
        this.out = r4;
        this.channel = null;
        Deflater r1 = new Deflater(this.level, true);
        this.def = r1;
        this.streamCompressor = StreamCompressor.create(r4, r1);
        this.isSplitZip = false;
    }

    private void addUnicodeExtraFields(ZipArchiveEntry r5, boolean r6, ByteBuffer r7) {
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS) goto L5;
        if (r6 == false) goto L5;
    L6:
        String r8 = r5.getComment();
        if (r8 != null) goto L9;
        return;
    L9:
        if ("".equals(r8) == true) goto L16;
        boolean r9 = this.zipEncoding.canEncode(r8);
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.ALWAYS) goto L13;
        if (r9 == false) goto L13;
        return;
    L13:
        ByteBuffer r4 = getEntryEncoding(r5).encode(r8);
        r5.addExtraField(new UnicodeCommentExtraField(r8, r4.array(), r4.arrayOffset(), r4.limit() - r4.position()));
        return;
    L16:
        return;
    L5:
        r5.addExtraField(new UnicodePathExtraField(r5.getName(), r7.array(), r7.arrayOffset(), r7.limit() - r7.position()));
        goto L6
    }

    private boolean checkIfNeedsZip64(Zip64Mode r3) {
        boolean r0 = isZip64Required(CurrentEntry.access$200(this.entry), r3);
        if (r0 == true) goto L5;
    L9:
        return r0;
    L5:
        if (r3 != Zip64Mode.Never) goto L9;
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(CurrentEntry.access$200(this.entry)));
    }

    private void closeEntry(boolean r2, boolean r3) {
        if (r3 == false) goto L4;
    L6:
        if (r3 == true) goto L8;
        writeDataDescriptor(CurrentEntry.access$200(this.entry));
    L8:
        this.entry = null;
        return;
    L4:
        if (this.channel == null) goto L6;
        rewriteSizesAndCrc(r2);
        goto L6
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry r6) {
        EntryMetaData r0 = (EntryMetaData) ZeusTransformUtils.preCheckCast(this.metaData.get(r6), EntryMetaData.class, "com.obric.memorydata.plugin");
        if (hasZip64Extra(r6) == false) goto L5;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == true) goto L21;
    L25:
        handleZip64Extra(r6, EntryMetaData.access$800(r0), r1);
        return createCentralFileHeader(r6, getName(r6), r0, r1);
    L21:
        if (this.zip64Mode != Zip64Mode.Never) goto L25;
        throw new Zip64RequiredException("Archive's size exceeds the limit of 4GByte.");
    L5:
        if (r6.getCompressedSize() >= 4294967295L) goto L18;
        if (r6.getSize() >= 4294967295L) goto L18;
        if (EntryMetaData.access$800(r0) >= 4294967295L) goto L18;
        if (r6.getDiskNumberStart() >= WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L18;
        if (this.zip64Mode == Zip64Mode.Always) goto L18;
        if (this.zip64Mode == Zip64Mode.AlwaysWithCompatibility) goto L18;
        r1 = false;
        goto L19
    }

    private byte[] createCentralFileHeader(ZipArchiveEntry r19, ByteBuffer r20, EntryMetaData r21, boolean r22) {
        if (this.isSplitZip == false) goto L8;
        int r1 = ((ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin")).getCurrentSplitSegmentIndex();
        if (this.numberOfCDInDiskData.get(Integer.valueOf(r1)) != null) goto L7;
        this.numberOfCDInDiskData.put(Integer.valueOf(r1), 1);
        goto L8
    L7:
        this.numberOfCDInDiskData.put(Integer.valueOf(r1), Integer.valueOf(((Integer) ZeusTransformUtils.preCheckCast(this.numberOfCDInDiskData.get(Integer.valueOf(r1)), Integer.class, "com.obric.memorydata.plugin")).intValue() + 1));
    L8:
        byte[] r2 = r19.getCentralDirectoryExtra();
        int r3 = r2.length;
        String r4 = r19.getComment();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        ByteBuffer r5 = getEntryEncoding(r19).encode(r4);
        int r6 = r20.limit() - r20.position();
        int r7 = r5.limit() - r5.position();
        int r8 = r6 + 46;
        int r9 = r8 + r3;
        byte[] r10 = new byte[r9 + r7];
        System.arraycopy(CFH_SIG, 0, r10, 0, 4);
        int r11 = r19.getPlatform() << 8;
        if (this.hasUsedZip64 == true) goto L14;
        int r14 = 20;
    L15:
        ZipShort.putShort(r11 | r14, r10, 4);
        int r12 = r19.getMethod();
        boolean r13 = this.zipEncoding.canEncode(r19.getName());
        ZipShort.putShort(versionNeededToExtract(r12, r22, EntryMetaData.access$900(r21)), r10, 6);
        if (r13 == false) goto L18;
    L20:
        boolean r15 = false;
    L21:
        getGeneralPurposeBits(r15, EntryMetaData.access$900(r21)).encode(r10, 8);
        ZipShort.putShort(r12, r10, 10);
        ZipUtil.toDosTime(this.calendarInstance, r19.getTime(), r10, 12);
        ZipLong.putLong(r19.getCrc(), r10, 16);
        if (r19.getCompressedSize() < 4294967295L) goto L24;
    L31:
        ZipLong.ZIP64_MAGIC.putLong(r10, 20);
        ZipLong.ZIP64_MAGIC.putLong(r10, 24);
    L32:
        ZipShort.putShort(r6, r10, 28);
        ZipShort.putShort(r3, r10, 30);
        ZipShort.putShort(r7, r10, 32);
        if (this.isSplitZip == true) goto L35;
        System.arraycopy(ZERO, 0, r10, 34, 2);
    L43:
        ZipShort.putShort(r19.getInternalAttributes(), r10, 36);
        ZipLong.putLong(r19.getExternalAttributes(), r10, 38);
        if (EntryMetaData.access$800(r21) < 4294967295L) goto L46;
    L49:
        ZipLong.putLong(4294967295L, r10, 42);
    L50:
        System.arraycopy(r20.array(), r20.arrayOffset(), r10, 46, r6);
        System.arraycopy(r2, 0, r10, r8, r3);
        System.arraycopy(r5.array(), r5.arrayOffset(), r10, r9, r7);
        return r10;
    L46:
        if (this.zip64Mode == Zip64Mode.Always) goto L49;
        ZipLong.putLong(Math.min(EntryMetaData.access$800(r21), 4294967295L), r10, 42);
        goto L50
    L35:
        if (r19.getDiskNumberStart() < WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L37;
    L40:
        int r16 = 65535;
    L41:
        ZipShort.putShort(r16, r10, 34);
        goto L43
    L37:
        if (this.zip64Mode == Zip64Mode.Always) goto L40;
        r16 = (int) r19.getDiskNumberStart();
        goto L41
    L24:
        if (r19.getSize() >= 4294967295L) goto L31;
        if (this.zip64Mode == Zip64Mode.Always) goto L31;
        if (this.zip64Mode == Zip64Mode.AlwaysWithCompatibility) goto L31;
        ZipLong.putLong(r19.getCompressedSize(), r10, 20);
        ZipLong.putLong(r19.getSize(), r10, 24);
        goto L32
    L18:
        if (this.fallbackToUTF8 == false) goto L20;
        r15 = true;
        goto L21
    L14:
        r14 = 45;
        goto L15
    }

    private byte[] createLocalFileHeader(ZipArchiveEntry r17, ByteBuffer r18, boolean r19, boolean r20, long r21) {
        ZipExtraField r3 = r17.getExtraField(ResourceAlignmentExtraField.ID);
        if (r3 == null) goto L6;
        r17.removeExtraField(ResourceAlignmentExtraField.ID);
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ResourceAlignmentExtraField.class) == false) goto L8;
        ResourceAlignmentExtraField r4 = (ResourceAlignmentExtraField) ZeusTransformUtils.preCheckCast(r3, ResourceAlignmentExtraField.class, "com.obric.memorydata.plugin");
    L9:
        int r5 = r17.getAlignment();
        if (r5 > 0) goto L13;
        if (r4 == null) goto L13;
        r5 = r4.getAlignment();
    L13:
        boolean r6 = true;
        if (r5 > 1) goto L18;
        if (r4 != null) goto L17;
    L25:
        byte[] r7 = r17.getLocalFileDataExtra();
        int r8 = r18.limit() - r18.position();
        int r9 = r8 + 30;
        byte[] r10 = new byte[r7.length + r9];
        System.arraycopy(LFH_SIG, 0, r10, 0, 4);
        int r11 = r17.getMethod();
        boolean r12 = usesDataDescriptor(r11, r20);
        ZipShort.putShort(versionNeededToExtract(r11, hasZip64Extra(r17), r12), r10, 4);
        if (r19 == false) goto L28;
    L30:
        r6 = false;
    L31:
        getGeneralPurposeBits(r6, r12).encode(r10, 6);
        ZipShort.putShort(r11, r10, 8);
        ZipUtil.toDosTime(this.calendarInstance, r17.getTime(), r10, 10);
        if (r20 == true) goto L38;
        if (r11 != 8) goto L35;
    L37:
        System.arraycopy(LZERO, 0, r10, 14, 4);
    L40:
        if (hasZip64Extra(CurrentEntry.access$200(this.entry)) == false) goto L42;
        ZipLong.ZIP64_MAGIC.putLong(r10, 18);
        ZipLong.ZIP64_MAGIC.putLong(r10, 22);
    L51:
        ZipShort.putShort(r8, r10, 26);
        ZipShort.putShort(r7.length, r10, 28);
        System.arraycopy(r18.array(), r18.arrayOffset(), r10, 30, r8);
        System.arraycopy(r7, 0, r10, r9, r7.length);
        return r10;
    L42:
        if (r20 == false) goto L45;
        long r13 = r17.getCompressedSize();
    L44:
        ZipLong.putLong(r13, r10, 18);
        ZipLong.putLong(r17.getSize(), r10, 22);
        goto L51
    L45:
        if (r11 != 8) goto L47;
    L50:
        byte[] r0 = LZERO;
        System.arraycopy(r0, 0, r10, 18, 4);
        System.arraycopy(r0, 0, r10, 22, 4);
        goto L51
    L47:
        if (this.channel != null) goto L50;
        r13 = r17.getSize();
        goto L44
    L35:
        if (this.channel != null) goto L37;
    L38:
        ZipLong.putLong(r17.getCrc(), r10, 14);
        goto L40
    L28:
        if (this.fallbackToUTF8 == false) goto L30;
    L17:
        if (r4.allowMethodChange() == true) goto L25;
    L18:
        int r14 = (int) (((((-r21) - ((long) (((r18.limit() + 30) - r18.position()) + r17.getLocalFileDataExtra().length))) - 4) - 2) & ((long) (r5 - 1)));
        if (r4 != null) goto L21;
    L23:
        boolean r15 = false;
    L24:
        r17.addExtraField(new ResourceAlignmentExtraField(r5, r15, r14));
        goto L25
    L21:
        if (r4.allowMethodChange() == false) goto L23;
        r15 = true;
        goto L24
    L8:
        r4 = null;
        goto L9
    }

    private void flushDeflater() {
        if (CurrentEntry.access$200(this.entry).getMethod() != 8) goto L6;
        this.streamCompressor.flushDeflater();
        return;
    }

    private Zip64Mode getEffectiveZip64Mode(ZipArchiveEntry r5) {
        if (this.zip64Mode != Zip64Mode.AsNeeded) goto L14;
        if (this.channel != null) goto L14;
        if (r5.getMethod() != 8) goto L14;
        if (r5.getSize() != (-1)) goto L14;
        return Zip64Mode.Never;
    L14:
        return this.zip64Mode;
    }

    private ZipEncoding getEntryEncoding(ZipArchiveEntry r2) {
        if (this.zipEncoding.canEncode(r2.getName()) == true) goto L8;
        if (this.fallbackToUTF8 == false) goto L8;
        return ZipEncodingHelper.UTF8_ZIP_ENCODING;
    L8:
        return this.zipEncoding;
    }

    private GeneralPurposeBit getGeneralPurposeBits(boolean r3, boolean r4) {
        GeneralPurposeBit r0 = new GeneralPurposeBit();
        if (this.useUTF8Flag == true) goto L7;
        if (r3 == true) goto L7;
        boolean r2 = false;
    L8:
        r0.useUTF8ForNames(r2);
        if (r4 == false) goto L11;
        r0.useDataDescriptor(true);
    L11:
        return r0;
    L7:
        r2 = true;
        goto L8
    }

    private ByteBuffer getName(ZipArchiveEntry r1) {
        return getEntryEncoding(r1).encode(r1.getName());
    }

    private Zip64ExtendedInformationExtraField getZip64Extra(ZipArchiveEntry r4) {
        CurrentEntry r0 = this.entry;
        if (r0 == null) goto L5;
        CurrentEntry.access$502(r0, !this.hasUsedZip64);
    L5:
        this.hasUsedZip64 = true;
        ZipExtraField r3 = r4.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (ZeusTransformUtils.instanceOf(r3, Zip64ExtendedInformationExtraField.class) == false) goto L8;
        Zip64ExtendedInformationExtraField r5 = (Zip64ExtendedInformationExtraField) ZeusTransformUtils.preCheckCast(r3, Zip64ExtendedInformationExtraField.class, "com.obric.memorydata.plugin");
    L9:
        if (r5 != null) goto L11;
        r5 = new Zip64ExtendedInformationExtraField();
    L11:
        r4.addAsFirstExtraField(r5);
        return r5;
    L8:
        r5 = null;
        goto L9
    }

    private boolean handleSizesAndCrc(long r5, long r7, Zip64Mode r9) {
        if (CurrentEntry.access$200(this.entry).getMethod() != 8) goto L7;
        CurrentEntry.access$200(this.entry).setSize(CurrentEntry.access$100(this.entry));
    L5:
        CurrentEntry.access$200(this.entry).setCompressedSize(r5);
        CurrentEntry.access$200(this.entry).setCrc(r7);
    L19:
        return checkIfNeedsZip64(r9);
    L7:
        if (this.channel == null) goto L9;
        CurrentEntry.access$200(this.entry).setSize(r5);
        goto L5
    L9:
        if (CurrentEntry.access$200(this.entry).getCrc() != r7) goto L16;
        if (CurrentEntry.access$200(this.entry).getSize() == r5) goto L19;
        throw new ZipException("Bad size for entry " + CurrentEntry.access$200(this.entry).getName() + ": " + CurrentEntry.access$200(this.entry).getSize() + " instead of " + r5);
    L16:
        throw new ZipException("Bad CRC checksum for entry " + CurrentEntry.access$200(this.entry).getName() + ": " + Long.toHexString(CurrentEntry.access$200(this.entry).getCrc()) + " instead of " + Long.toHexString(r7));
    }

    private void handleZip64Extra(ZipArchiveEntry r8, long r9, boolean r11) {
        if (r11 == false) goto L33;
        Zip64ExtendedInformationExtraField r12 = getZip64Extra(r8);
        if (r8.getCompressedSize() < 4294967295L) goto L6;
    L13:
        r12.setCompressedSize(new ZipEightByteInteger(r8.getCompressedSize()));
        ZipEightByteInteger r0 = new ZipEightByteInteger(r8.getSize());
    L14:
        r12.setSize(r0);
        boolean r1 = false;
        if (r9 < 4294967295L) goto L17;
    L20:
        boolean r2 = true;
    L22:
        if (r8.getDiskNumberStart() < WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L24;
    L25:
        r1 = true;
    L26:
        if (r2 == true) goto L28;
        if (r1 == true) goto L28;
    L29:
        if (r1 == false) goto L31;
        r12.setDiskStartNumber(new ZipLong(r8.getDiskNumberStart()));
    L31:
        r8.setExtra();
        return;
    L28:
        r12.setRelativeHeaderOffset(new ZipEightByteInteger(r9));
        goto L29
    L24:
        if (this.zip64Mode != Zip64Mode.Always) goto L26;
    L17:
        if (this.zip64Mode == Zip64Mode.Always) goto L20;
        r2 = false;
        goto L22
    L6:
        if (r8.getSize() >= 4294967295L) goto L13;
        if (this.zip64Mode == Zip64Mode.Always) goto L13;
        if (this.zip64Mode == Zip64Mode.AlwaysWithCompatibility) goto L13;
        r0 = null;
        r12.setCompressedSize(null);
        goto L14
    }

    private boolean hasZip64Extra(ZipArchiveEntry r1) {
        return ZeusTransformUtils.instanceOf(r1.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID), Zip64ExtendedInformationExtraField.class);
    }

    private boolean isTooLargeForZip32(ZipArchiveEntry r5) {
        if (r5.getSize() < 4294967295L) goto L5;
    L8:
        return true;
    L5:
        if (r5.getCompressedSize() >= 4294967295L) goto L8;
        return false;
    }

    private boolean isZip64Required(ZipArchiveEntry r2, Zip64Mode r3) {
        if (r3 != Zip64Mode.Always) goto L5;
    L10:
        return true;
    L5:
        if (r3 == Zip64Mode.AlwaysWithCompatibility) goto L10;
        if (isTooLargeForZip32(r2) == true) goto L10;
        return false;
    }

    private void preClose() {
        if (this.finished == true) goto L13;
        CurrentEntry r0 = this.entry;
        if (r0 == null) goto L11;
        if (CurrentEntry.access$300(r0) == true) goto L14;
        write(ByteUtils.EMPTY_BYTE_ARRAY, 0, 0);
        return;
    L14:
        return;
    L11:
        throw new IOException("No current entry to close");
    L13:
        throw new IOException("Stream has already been finished");
    }

    private void putArchiveEntry(ArchiveEntry r7, boolean r8) {
        ArchiveEntry r9 = (ArchiveEntry) ZeusTransformUtils.wrapperContextForParams(r7, ArchiveEntry.class, "com.obric.memorydata.plugin");
        if (this.finished == true) goto L28;
        if (this.entry == null) goto L7;
        closeArchiveEntry();
    L7:
        CurrentEntry r0 = new CurrentEntry((ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r9, ZipArchiveEntry.class, "com.obric.memorydata.plugin"), null);
        this.entry = r0;
        this.entries.add(CurrentEntry.access$200(r0));
        setDefaults(CurrentEntry.access$200(this.entry));
        Zip64Mode r1 = getEffectiveZip64Mode(CurrentEntry.access$200(this.entry));
        validateSizeInformation(r1);
        if (shouldAddZip64Extra(CurrentEntry.access$200(this.entry), r1) == false) goto L21;
        Zip64ExtendedInformationExtraField r2 = getZip64Extra(CurrentEntry.access$200(this.entry));
        if (r8 == false) goto L13;
        ZipEightByteInteger r3 = new ZipEightByteInteger(CurrentEntry.access$200(this.entry).getSize());
        ZipEightByteInteger r4 = new ZipEightByteInteger(CurrentEntry.access$200(this.entry).getCompressedSize());
    L19:
        r2.setSize(r3);
        r2.setCompressedSize(r4);
        CurrentEntry.access$200(this.entry).setExtra();
        goto L21
    L13:
        if (CurrentEntry.access$200(this.entry).getMethod() == 0) goto L15;
    L17:
        r3 = ZipEightByteInteger.ZERO;
    L18:
        r4 = r3;
        goto L19
    L15:
        if (CurrentEntry.access$200(this.entry).getSize() == (-1)) goto L17;
        r3 = new ZipEightByteInteger(CurrentEntry.access$200(this.entry).getSize());
    L21:
        if (CurrentEntry.access$200(this.entry).getMethod() == 8) goto L23;
    L25:
        writeLocalFileHeader((ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r9, ZipArchiveEntry.class, "com.obric.memorydata.plugin"), r8);
        return;
    L23:
        if (this.hasCompressionLevelChanged == false) goto L25;
        this.def.setLevel(this.level);
        this.hasCompressionLevelChanged = false;
        goto L25
    L28:
        throw new IOException("Stream has already been finished");
    }

    private void rewriteSizesAndCrc(boolean r11) {
        long r0 = this.channel.position();
        this.channel.position(CurrentEntry.access$400(this.entry));
        writeOut(ZipLong.getBytes(CurrentEntry.access$200(this.entry).getCrc()));
        if (hasZip64Extra(CurrentEntry.access$200(this.entry)) == false) goto L7;
        if (r11 == false) goto L7;
        writeOut(ZipLong.ZIP64_MAGIC.getBytes());
        writeOut(ZipLong.ZIP64_MAGIC.getBytes());
    L9:
        if (hasZip64Extra(CurrentEntry.access$200(this.entry)) == false) goto L15;
        ByteBuffer r2 = getName(CurrentEntry.access$200(this.entry));
        int r3 = r2.limit() - r2.position();
        this.channel.position((((CurrentEntry.access$400(this.entry) + 12) + 4) + ((long) r3)) + 4);
        writeOut(ZipEightByteInteger.getBytes(CurrentEntry.access$200(this.entry).getSize()));
        writeOut(ZipEightByteInteger.getBytes(CurrentEntry.access$200(this.entry).getCompressedSize()));
        if (r11 == true) goto L15;
        this.channel.position(CurrentEntry.access$400(this.entry) - 10);
        writeOut(ZipShort.getBytes(versionNeededToExtract(CurrentEntry.access$200(this.entry).getMethod(), false, false)));
        CurrentEntry.access$200(this.entry).removeExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        CurrentEntry.access$200(this.entry).setExtra();
        if (CurrentEntry.access$500(this.entry) == false) goto L15;
        this.hasUsedZip64 = false;
    L15:
        this.channel.position(r0);
        return;
    L7:
        writeOut(ZipLong.getBytes(CurrentEntry.access$200(this.entry).getCompressedSize()));
        writeOut(ZipLong.getBytes(CurrentEntry.access$200(this.entry).getSize()));
        goto L9
    }

    private void setDefaults(ZipArchiveEntry r5) {
        if (r5.getMethod() != (-1)) goto L6;
        r5.setMethod(this.method);
    L6:
        if (r5.getTime() != (-1)) goto L9;
        r5.setTime(System.currentTimeMillis());
        return;
    }

    private boolean shouldAddZip64Extra(ZipArchiveEntry r5, Zip64Mode r6) {
        if (r6 != Zip64Mode.Always) goto L5;
    L18:
        return true;
    L5:
        if (r6 == Zip64Mode.AlwaysWithCompatibility) goto L18;
        if (r5.getSize() >= 4294967295L) goto L18;
        if (r5.getCompressedSize() >= 4294967295L) goto L18;
        if (r5.getSize() == (-1)) goto L13;
    L17:
        return false;
    L13:
        if (this.channel == null) goto L17;
        if (r6 == Zip64Mode.Never) goto L17;
        goto L17
    }

    private boolean shouldUseZip64EOCD() {
        if (this.isSplitZip == false) goto L5;
        int r0 = ((ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin")).getCurrentSplitSegmentIndex();
    L7:
        if (this.numberOfCDInDiskData.get(Integer.valueOf(r0)) != null) goto L9;
        int r1 = 0;
    L11:
        if (r0 < 65535) goto L13;
    L21:
        return true;
    L13:
        if (this.cdDiskNumberStart >= WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L21;
        if (r1 >= 65535) goto L21;
        if (this.entries.size() >= 65535) goto L21;
        if (this.cdLength >= 4294967295L) goto L21;
        if (this.cdOffset >= 4294967295L) goto L21;
        return false;
    L9:
        r1 = ((Integer) ZeusTransformUtils.preCheckCast(this.numberOfCDInDiskData.get(Integer.valueOf(r0)), Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L11
    L5:
        r0 = 0;
        goto L7
    }

    private boolean usesDataDescriptor(int r1, boolean r2) {
        if (r2 == false) goto L4;
    L8:
        return false;
    L4:
        if (r1 != 8) goto L8;
        if (this.channel != null) goto L8;
        return true;
    }

    private void validateIfZip64IsNeededInEOCD() {
        if (this.zip64Mode == Zip64Mode.Never) goto L5;
        return;
    L5:
        int r2 = 0;
        if (this.isSplitZip == false) goto L8;
        int r0 = ((ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin")).getCurrentSplitSegmentIndex();
    L10:
        if (r0 >= 65535) goto L36;
        if (this.cdDiskNumberStart >= WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L34;
        if (this.numberOfCDInDiskData.get(Integer.valueOf(r0)) == null) goto L17;
        r2 = ((Integer) ZeusTransformUtils.preCheckCast(this.numberOfCDInDiskData.get(Integer.valueOf(r0)), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L17:
        if (r2 >= 65535) goto L32;
        if (this.entries.size() >= 65535) goto L30;
        if (this.cdLength >= 4294967295L) goto L28;
        if (this.cdOffset >= 4294967295L) goto L26;
        return;
    L26:
        throw new Zip64RequiredException("Archive's size exceeds the limit of 4GByte.");
    L28:
        throw new Zip64RequiredException("The size of the entire central directory exceeds the limit of 4GByte.");
    L30:
        throw new Zip64RequiredException("Archive contains more than 65535 entries.");
    L32:
        throw new Zip64RequiredException("Number of entries on this disk exceeds the limit of 65535.");
    L34:
        throw new Zip64RequiredException("Number of the disk with the start of Central Directory exceeds the limit of 65535.");
    L36:
        throw new Zip64RequiredException("Number of the disk of End Of Central Directory exceeds the limit of 65535.");
    L8:
        r0 = 0;
        goto L10
    }

    private void validateSizeInformation(Zip64Mode r5) {
        if (CurrentEntry.access$200(this.entry).getMethod() != 0) goto L16;
        if (this.channel != null) goto L16;
        if (CurrentEntry.access$200(this.entry).getSize() == (-1)) goto L14;
        if (CurrentEntry.access$200(this.entry).getCrc() == (-1)) goto L12;
        CurrentEntry.access$200(this.entry).setCompressedSize(CurrentEntry.access$200(this.entry).getSize());
        goto L16
    L12:
        throw new ZipException("CRC checksum is required for STORED method when not writing to a file");
    L14:
        throw new ZipException("Uncompressed size is required for STORED method when not writing to a file");
    L16:
        if (CurrentEntry.access$200(this.entry).getSize() >= 4294967295L) goto L20;
        if (CurrentEntry.access$200(this.entry).getCompressedSize() >= 4294967295L) goto L20;
        return;
    L20:
        if (r5 == Zip64Mode.Never) goto L23;
        return;
    L23:
        throw new Zip64RequiredException(Zip64RequiredException.getEntryTooBigMessage(CurrentEntry.access$200(this.entry)));
    }

    private int versionNeededToExtract(int r1, boolean r2, boolean r3) {
        if (r2 == false) goto L5;
        return 45;
    L5:
        if (r3 == false) goto L9;
        return 20;
    L9:
        return versionNeededToExtractMethod(r1);
    }

    private int versionNeededToExtractMethod(int r1) {
        if (r1 != 8) goto L5;
        return 20;
    L5:
        return 10;
    }

    private void writeCentralDirectoryInChunks() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(70000);
        Iterator<ZipArchiveEntry> r1 = this.entries.iterator();
    L3:
        int r3 = 0;
    L5:
        if (r1.hasNext() == false) goto L9;
        r0.write(createCentralFileHeader((ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r1.next(), ZipArchiveEntry.class, "com.obric.memorydata.plugin")));
        r3 = r3 + 1;
        if (r3 <= 1000) goto L5;
        writeCounted(r0.toByteArray());
        r0.reset();
        goto L3
    L9:
        writeCounted(r0.toByteArray());
    }

    private void writeCounted(byte[] r1) {
        this.streamCompressor.writeCounted(r1);
    }

    private void writeLocalFileHeader(ZipArchiveEntry r10, boolean r11) {
        boolean r5 = this.zipEncoding.canEncode(r10.getName());
        ByteBuffer r4 = getName(r10);
        if (this.createUnicodeExtraFields == UnicodeExtraFieldPolicy.NEVER) goto L5;
        addUnicodeExtraFields(r10, r5, r4);
    L5:
        long r0 = this.streamCompressor.getTotalBytesWritten();
        if (this.isSplitZip == false) goto L8;
        ZipSplitOutputStream r1 = (ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin");
        r10.setDiskNumberStart(r1.getCurrentSplitSegmentIndex());
        r0 = r1.getCurrentSplitSegmentBytesWritten();
    L8:
        byte[] r2 = createLocalFileHeader(r10, r4, r5, r11, r0);
        this.metaData.put(r10, new EntryMetaData(r0, usesDataDescriptor(r10.getMethod(), r11), null));
        CurrentEntry.access$402(this.entry, r0 + 14);
        writeCounted(r2);
        CurrentEntry.access$002(this.entry, this.streamCompressor.getTotalBytesWritten());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    L7:
        th = move-exception;
        destroy();
        throw th;
    L3:
        if (this.finished == true) goto L5;
        finish();     // Catch: Throwable -> L7
    L5:
        destroy();
    }

    public void closeArchiveEntry() {
        preClose();
        flushDeflater();
        long r5 = this.streamCompressor.getTotalBytesWritten() - CurrentEntry.access$000(this.entry);
        long r7 = this.streamCompressor.getCrc32();
        CurrentEntry.access$102(this.entry, this.streamCompressor.getBytesRead());
        closeEntry(handleSizesAndCrc(r5, r7, getEffectiveZip64Mode(CurrentEntry.access$200(this.entry))), false);
        this.streamCompressor.reset();
    }

    void destroy() {
        SeekableByteChannel r0 = this.channel;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.close();     // Catch: Throwable -> L9
    L5:
        OutputStream r1 = this.out;
        if (r1 == null) goto L16;
        r1.close();
        return;
    L16:
        return;
    L9:
        th = move-exception;
        OutputStream r2 = this.out;
        if (r2 == null) goto L13;
        r2.close();
    L13:
        throw th;
    }

    public void finish() {
        if (this.finished == true) goto L17;
        if (this.entry != null) goto L15;
        long r0 = this.streamCompressor.getTotalBytesWritten();
        this.cdOffset = r0;
        if (this.isSplitZip == false) goto L9;
        ZipSplitOutputStream r2 = (ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin");
        this.cdOffset = r2.getCurrentSplitSegmentBytesWritten();
        this.cdDiskNumberStart = r2.getCurrentSplitSegmentIndex();
    L9:
        writeCentralDirectoryInChunks();
        this.cdLength = this.streamCompressor.getTotalBytesWritten() - r0;
        ByteBuffer r1 = this.zipEncoding.encode(this.comment);
        this.eocdLength = (((long) r1.limit()) - ((long) r1.position())) + 22;
        writeZip64CentralDirectory();
        writeCentralDirectoryEnd();
        this.metaData.clear();
        this.entries.clear();
        this.streamCompressor.close();
        if (this.isSplitZip == false) goto L12;
        this.out.close();
    L12:
        this.finished = true;
        return;
    L15:
        throw new IOException("This archive contains unclosed entries.");
    L17:
        throw new IOException("This archive has already been finished");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        OutputStream r0 = this.out;
        if (r0 == null) goto L6;
        r0.flush();
        return;
    }

    public void putArchiveEntry(ArchiveEntry r3) {
        putArchiveEntry((ArchiveEntry) ZeusTransformUtils.wrapperContextForParams(r3, ArchiveEntry.class, "com.obric.memorydata.plugin"), false);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) {
        CurrentEntry r0 = this.entry;
        if (r0 == null) goto L7;
        ZipUtil.checkRequestedFeatures(CurrentEntry.access$200(r0));
        count(this.streamCompressor.write(r3, r4, r5, CurrentEntry.access$200(this.entry).getMethod()));
        return;
    L7:
        throw new IllegalStateException("No current entry");
    }

    public void writeCentralDirectoryEnd() {
        if (this.hasUsedZip64 == false) goto L5;
    L7:
        validateIfZip64IsNeededInEOCD();
        writeCounted(EOCD_SIG);
        int r2 = 0;
        if (this.isSplitZip == false) goto L10;
        int r0 = ((ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin")).getCurrentSplitSegmentIndex();
    L11:
        writeCounted(ZipShort.getBytes(r0));
        writeCounted(ZipShort.getBytes((int) this.cdDiskNumberStart));
        int r3 = this.entries.size();
        if (this.isSplitZip == true) goto L14;
        r2 = r3;
    L18:
        writeCounted(ZipShort.getBytes(Math.min(r2, 65535)));
        writeCounted(ZipShort.getBytes(Math.min(r3, 65535)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdLength, 4294967295L)));
        writeCounted(ZipLong.getBytes(Math.min(this.cdOffset, 4294967295L)));
        ByteBuffer r1 = this.zipEncoding.encode(this.comment);
        int r4 = r1.limit() - r1.position();
        writeCounted(ZipShort.getBytes(r4));
        this.streamCompressor.writeCounted(r1.array(), r1.arrayOffset(), r4);
        return;
    L14:
        if (this.numberOfCDInDiskData.get(Integer.valueOf(r0)) == null) goto L18;
        r2 = ((Integer) ZeusTransformUtils.preCheckCast(this.numberOfCDInDiskData.get(Integer.valueOf(r0)), Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L18
    L10:
        r0 = 0;
        goto L11
    L5:
        if (this.isSplitZip == false) goto L7;
        ((ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin")).prepareToWriteUnsplittableContent(this.eocdLength);
        goto L7
    }

    public void writeDataDescriptor(ZipArchiveEntry r3) {
        if (usesDataDescriptor(r3.getMethod(), false) == true) goto L5;
        return;
    L5:
        writeCounted(DD_SIG);
        writeCounted(ZipLong.getBytes(r3.getCrc()));
        if (hasZip64Extra(r3) == true) goto L8;
        writeCounted(ZipLong.getBytes(r3.getCompressedSize()));
        writeCounted(ZipLong.getBytes(r3.getSize()));
        return;
    L8:
        writeCounted(ZipEightByteInteger.getBytes(r3.getCompressedSize()));
        writeCounted(ZipEightByteInteger.getBytes(r3.getSize()));
    }

    public final void writeOut(byte[] r3) {
        this.streamCompressor.writeOut(r3, 0, r3.length);
    }

    public void writeZip64CentralDirectory() {
        if (this.zip64Mode != Zip64Mode.Never) goto L6;
        return;
    L6:
        if (this.hasUsedZip64 == true) goto L11;
        if (shouldUseZip64EOCD() == false) goto L11;
        this.hasUsedZip64 = true;
    L11:
        if (this.hasUsedZip64 == true) goto L13;
        return;
    L13:
        long r2 = this.streamCompressor.getTotalBytesWritten();
        long r4 = 0;
        if (this.isSplitZip == false) goto L16;
        ZipSplitOutputStream r0 = (ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin");
        r2 = r0.getCurrentSplitSegmentBytesWritten();
        r4 = r0.getCurrentSplitSegmentIndex();
    L16:
        writeOut(ZIP64_EOCD_SIG);
        writeOut(ZipEightByteInteger.getBytes(44));
        writeOut(ZipShort.getBytes(45));
        writeOut(ZipShort.getBytes(45));
        int r7 = 0;
        if (this.isSplitZip == false) goto L19;
        int r1 = ((ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin")).getCurrentSplitSegmentIndex();
    L20:
        writeOut(ZipLong.getBytes(r1));
        writeOut(ZipLong.getBytes(this.cdDiskNumberStart));
        if (this.isSplitZip == true) goto L23;
        r7 = this.entries.size();
    L27:
        writeOut(ZipEightByteInteger.getBytes(r7));
        writeOut(ZipEightByteInteger.getBytes(this.entries.size()));
        writeOut(ZipEightByteInteger.getBytes(this.cdLength));
        writeOut(ZipEightByteInteger.getBytes(this.cdOffset));
        if (this.isSplitZip == false) goto L30;
        ((ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin")).prepareToWriteUnsplittableContent(this.eocdLength + 20);
    L30:
        writeOut(ZIP64_EOCD_LOC_SIG);
        writeOut(ZipLong.getBytes(r4));
        writeOut(ZipEightByteInteger.getBytes(r2));
        if (this.isSplitZip == false) goto L33;
        writeOut(ZipLong.getBytes(((ZipSplitOutputStream) ZeusTransformUtils.preCheckCast(this.out, ZipSplitOutputStream.class, "com.obric.memorydata.plugin")).getCurrentSplitSegmentIndex() + 1));
        return;
    L33:
        writeOut(ONE);
        return;
    L23:
        if (this.numberOfCDInDiskData.get(Integer.valueOf(r1)) == null) goto L27;
        r7 = ((Integer) ZeusTransformUtils.preCheckCast(this.numberOfCDInDiskData.get(Integer.valueOf(r1)), Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L27
    L19:
        r1 = 0;
        goto L20
    }
}
