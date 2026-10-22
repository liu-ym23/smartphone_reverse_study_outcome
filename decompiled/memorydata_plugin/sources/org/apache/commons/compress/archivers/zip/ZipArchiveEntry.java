package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ZipArchiveEntry extends ZipEntry implements ArchiveEntry {
    static final ZipArchiveEntry[] EMPTY_ZIP_ARCHIVE_ENTRY_ARRAY = null;
    private int alignment;
    private CommentSource commentSource;
    private long dataOffset;
    private long diskNumberStart;
    private long externalAttributes;
    private ZipExtraField[] extraFields;
    private GeneralPurposeBit gpb;
    private int internalAttributes;
    private boolean isStreamContiguous;
    private long localHeaderOffset;
    private int method;
    private String name;
    private NameSource nameSource;
    private int platform;
    private int rawFlag;
    private byte[] rawName;
    private long size;
    private UnparseableExtraFieldData unparseableExtra;
    private int versionMadeBy;
    private int versionRequired;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final enum CommentSource extends Enum<CommentSource> {
        private static final /* synthetic */ CommentSource[] $VALUES = null;
        public static final CommentSource COMMENT = null;
        public static final CommentSource UNICODE_EXTRA_FIELD = null;

        static {
            CommentSource r0 = new CommentSource("COMMENT", 0);
            COMMENT = r0;
            CommentSource r1 = new CommentSource("UNICODE_EXTRA_FIELD", 1);
            UNICODE_EXTRA_FIELD = r1;
            $VALUES = new CommentSource[]{r0, r1};
        }

        private CommentSource(String r1, int r2) {
            super(r1, r2);
        }

        public static CommentSource valueOf(String r2) {
            return (CommentSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(CommentSource.class, r2), CommentSource.class, "com.obric.memorydata.plugin");
        }

        public static CommentSource[] values() {
            return (CommentSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CommentSource[].class, "com.obric.memorydata.plugin");
        }
    }

    public static enum ExtraFieldParsingMode extends Enum<ExtraFieldParsingMode> implements ExtraFieldParsingBehavior {
        private static final /* synthetic */ ExtraFieldParsingMode[] $VALUES = null;
        public static final ExtraFieldParsingMode BEST_EFFORT = null;
        public static final ExtraFieldParsingMode DRACONIC = null;
        public static final ExtraFieldParsingMode ONLY_PARSEABLE_LENIENT = null;
        public static final ExtraFieldParsingMode ONLY_PARSEABLE_STRICT = null;
        public static final ExtraFieldParsingMode STRICT_FOR_KNOW_EXTRA_FIELDS = null;
        private final ExtraFieldUtils.UnparseableExtraField onUnparseableData;

        static {
            final ExtraFieldUtils.UnparseableExtraField r1 = ExtraFieldUtils.UnparseableExtraField.READ;
            final String r2 = "BEST_EFFORT";
            final int r3 = 0;
            ExtraFieldParsingMode r0 = new AnonymousClass1(r2, r3, r1);
            BEST_EFFORT = r0;
            ExtraFieldParsingMode r4 = new ExtraFieldParsingMode("STRICT_FOR_KNOW_EXTRA_FIELDS", 1, ExtraFieldUtils.UnparseableExtraField.READ);
            STRICT_FOR_KNOW_EXTRA_FIELDS = r4;
            final ExtraFieldUtils.UnparseableExtraField r5 = ExtraFieldUtils.UnparseableExtraField.SKIP;
            final String r6 = "ONLY_PARSEABLE_LENIENT";
            final int r7 = 2;
            ExtraFieldParsingMode r8 = new AnonymousClass2(r6, r7, r5);
            ONLY_PARSEABLE_LENIENT = r8;
            ExtraFieldParsingMode r9 = new ExtraFieldParsingMode("ONLY_PARSEABLE_STRICT", 3, ExtraFieldUtils.UnparseableExtraField.SKIP);
            ONLY_PARSEABLE_STRICT = r9;
            ExtraFieldParsingMode r10 = new ExtraFieldParsingMode("DRACONIC", 4, ExtraFieldUtils.UnparseableExtraField.THROW);
            DRACONIC = r10;
            $VALUES = new ExtraFieldParsingMode[]{r0, r4, r8, r9, r10};
        }

        private ExtraFieldParsingMode(String r1, int r2, ExtraFieldUtils.UnparseableExtraField r3) {
            super(r1, r2);
            this.onUnparseableData = r3;
        }

        /* synthetic */ ExtraFieldParsingMode(String r1, int r2, ExtraFieldUtils.UnparseableExtraField r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static /* synthetic */ ZipExtraField access$100(ZipExtraField r2, byte[] r3, int r4, int r5, boolean r6) {
            return fillAndMakeUnrecognizedOnError((ZipExtraField) ZeusTransformUtils.wrapperContextForParams(r2, ZipExtraField.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        private static ZipExtraField fillAndMakeUnrecognizedOnError(ZipExtraField r2, byte[] r3, int r4, int r5, boolean r6) {
            ZipExtraField r7 = (ZipExtraField) ZeusTransformUtils.wrapperContextForParams(r2, ZipExtraField.class, "com.obric.memorydata.plugin");
            return ExtraFieldUtils.fillExtraField(r7, r3, r4, r5, r6);
        L5:
            UnrecognizedExtraField r0 = new UnrecognizedExtraField();
            r0.setHeaderId(r7.getHeaderId());
            byte[] r8 = Arrays.copyOfRange(r3, r4, r5 + r4);
            if (r6 == false) goto L8;
            r0.setLocalFileDataData(r8);
        L9:
            return r0;
        L8:
            r0.setCentralDirectoryData(r8);
            goto L9
        }

        public static ExtraFieldParsingMode valueOf(String r2) {
            return (ExtraFieldParsingMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExtraFieldParsingMode.class, r2), ExtraFieldParsingMode.class, "com.obric.memorydata.plugin");
        }

        public static ExtraFieldParsingMode[] values() {
            return (ExtraFieldParsingMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExtraFieldParsingMode[].class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.commons.compress.archivers.zip.ExtraFieldParsingBehavior
        public ZipExtraField createExtraField(ZipShort r1) {
            return ExtraFieldUtils.createExtraField(r1);
        }

        @Override // org.apache.commons.compress.archivers.zip.ExtraFieldParsingBehavior
        public ZipExtraField fill(ZipExtraField r2, byte[] r3, int r4, int r5, boolean r6) {
            return ExtraFieldUtils.fillExtraField((ZipExtraField) ZeusTransformUtils.wrapperContextForParams(r2, ZipExtraField.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        @Override // org.apache.commons.compress.archivers.zip.UnparseableExtraFieldBehavior
        public ZipExtraField onUnparseableExtraField(byte[] r7, int r8, int r9, boolean r10, int r11) {
            return this.onUnparseableData.onUnparseableExtraField(r7, r8, r9, r10, r11);
        }
    }

    public static final enum NameSource extends Enum<NameSource> {
        private static final /* synthetic */ NameSource[] $VALUES = null;
        public static final NameSource NAME = null;
        public static final NameSource NAME_WITH_EFS_FLAG = null;
        public static final NameSource UNICODE_EXTRA_FIELD = null;

        static {
            NameSource r0 = new NameSource("NAME", 0);
            NAME = r0;
            NameSource r1 = new NameSource("NAME_WITH_EFS_FLAG", 1);
            NAME_WITH_EFS_FLAG = r1;
            NameSource r3 = new NameSource("UNICODE_EXTRA_FIELD", 2);
            UNICODE_EXTRA_FIELD = r3;
            $VALUES = new NameSource[]{r0, r1, r3};
        }

        private NameSource(String r1, int r2) {
            super(r1, r2);
        }

        public static NameSource valueOf(String r2) {
            return (NameSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(NameSource.class, r2), NameSource.class, "com.obric.memorydata.plugin");
        }

        public static NameSource[] values() {
            return (NameSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NameSource[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        EMPTY_ZIP_ARCHIVE_ENTRY_ARRAY = new ZipArchiveEntry[0];
    }

    public ZipArchiveEntry() {
        this("");
    }

    public ZipArchiveEntry(String r4) {
        super(r4);
        this.method = -1;
        this.size = -1;
        this.platform = 0;
        this.gpb = new GeneralPurposeBit();
        this.localHeaderOffset = -1;
        this.dataOffset = -1;
        this.nameSource = NameSource.NAME;
        this.commentSource = CommentSource.COMMENT;
        setName(r4);
    }

    private ZipExtraField[] copyOf(ZipExtraField[] r2, int r3) {
        ZipExtraField[] r1 = new ZipExtraField[r3];
        System.arraycopy(r2, 0, r1, 0, Math.min(r2.length, r3));
        return r1;
    }

    private ZipExtraField[] getAllExtraFieldsNoCopy() {
        ZipExtraField[] r0 = this.extraFields;
        if (r0 != null) goto L7;
        return getUnparseableOnly();
    L7:
        if (this.unparseableExtra != null) goto L9;
        return r0;
    L9:
        return getMergedFields();
    }

    private ZipExtraField[] getMergedFields() {
        ZipExtraField[] r0 = this.extraFields;
        ZipExtraField[] r1 = copyOf(r0, r0.length + 1);
        r1[this.extraFields.length] = this.unparseableExtra;
        return r1;
    }

    private ZipExtraField[] getUnparseableOnly() {
        UnparseableExtraFieldData r2 = this.unparseableExtra;
        if (r2 != null) goto L6;
        return ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY;
    L6:
        return new ZipExtraField[]{r2};
    }

    private void mergeExtraFields(ZipExtraField[] r8, boolean r9) {
        if (this.extraFields != null) goto L5;
        setExtraFields(r8);
        return;
    L5:
        int r0 = r8.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L26;
        ZipExtraField r3 = r8[r2];
        if (ZeusTransformUtils.instanceOf(r3, UnparseableExtraFieldData.class) == false) goto L10;
        ZipExtraField r4 = this.unparseableExtra;
    L11:
        if (r4 != null) goto L13;
        addExtraField(r3);
    L25:
        r2 = r2 + 1;
        goto L6
    L13:
        if (r9 == false) goto L15;
        byte[] r5 = r3.getLocalFileDataData();
    L16:
        if (r9 == true) goto L28;
        r4.parseFromCentralDirectoryData(r5, 0, r5.length);     // Catch: ZipException -> L20
        goto L25
    L28:
        r4.parseFromLocalFileData(r5, 0, r5.length);     // Catch: ZipException -> L20
    L20:
        UnrecognizedExtraField r6 = new UnrecognizedExtraField();
        r6.setHeaderId(r4.getHeaderId());
        if (r9 == false) goto L23;
        r6.setLocalFileDataData(r5);
        r6.setCentralDirectoryData(r4.getCentralDirectoryData());
    L24:
        removeExtraField(r4.getHeaderId());
        addExtraField(r6);
        goto L25
    L23:
        r6.setLocalFileDataData(r4.getLocalFileDataData());
        r6.setCentralDirectoryData(r5);
        goto L24
    L15:
        r5 = r3.getCentralDirectoryData();
        goto L16
    L10:
        r4 = getExtraField(r3.getHeaderId());
        goto L11
    L26:
        setExtra();
    }

    public void addAsFirstExtraField(ZipExtraField r5) {
        ZipExtraField r6 = (ZipExtraField) ZeusTransformUtils.wrapperContextForParams(r5, ZipExtraField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, UnparseableExtraFieldData.class) == false) goto L6;
        this.unparseableExtra = (UnparseableExtraFieldData) ZeusTransformUtils.preCheckCast(r6, UnparseableExtraFieldData.class, "com.obric.memorydata.plugin");
    L15:
        setExtra();
        return;
    L6:
        if (getExtraField(r6.getHeaderId()) == null) goto L8;
        removeExtraField(r6.getHeaderId());
    L8:
        ZipExtraField[] r0 = this.extraFields;
        if (r0 == null) goto L11;
        int r2 = r0.length + 1;
    L12:
        ZipExtraField[] r3 = new ZipExtraField[r2];
        this.extraFields = r3;
        r3[0] = r6;
        if (r0 == null) goto L15;
        System.arraycopy(r0, 0, r3, 1, r3.length - 1);
        goto L15
    L11:
        r2 = 1;
        goto L12
    }

    public void addExtraField(ZipExtraField r4) {
        ZipExtraField r5 = (ZipExtraField) ZeusTransformUtils.wrapperContextForParams(r4, ZipExtraField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, UnparseableExtraFieldData.class) == false) goto L6;
        this.unparseableExtra = (UnparseableExtraFieldData) ZeusTransformUtils.preCheckCast(r5, UnparseableExtraFieldData.class, "com.obric.memorydata.plugin");
    L12:
        setExtra();
        return;
    L6:
        if (this.extraFields != null) goto L9;
        this.extraFields = new ZipExtraField[]{r5};
        goto L12
    L9:
        if (getExtraField(r5.getHeaderId()) == null) goto L11;
        removeExtraField(r5.getHeaderId());
    L11:
        ZipExtraField[] r0 = this.extraFields;
        ZipExtraField[] r1 = copyOf(r0, r0.length + 1);
        r1[r1.length - 1] = r5;
        this.extraFields = r1;
        goto L12
    }

    @Override // java.util.zip.ZipEntry
    public Object clone() {
        ZipArchiveEntry r0 = (ZipArchiveEntry) ZeusTransformUtils.preCheckCast(super.clone(), ZipArchiveEntry.class, "com.obric.memorydata.plugin");
        r0.setInternalAttributes(getInternalAttributes());
        r0.setExternalAttributes(getExternalAttributes());
        r0.setExtraFields(getAllExtraFieldsNoCopy());
        return r0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (r9 != null) goto L8;
    L49:
        return false;
    L8:
        if (getClass() != r9.getClass()) goto L49;
        ZipArchiveEntry r10 = (ZipArchiveEntry) ZeusTransformUtils.preCheckCast(r9, ZipArchiveEntry.class, "com.obric.memorydata.plugin");
        if (Objects.equals(getName(), r10.getName()) == true) goto L13;
        return false;
    L13:
        String r2 = getComment();
        String r3 = r10.getComment();
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        if (r3 != null) goto L19;
        r3 = "";
    L19:
        if (getTime() != r10.getTime()) goto L48;
        if (r2.equals(r3) == false) goto L48;
        if (getInternalAttributes() != r10.getInternalAttributes()) goto L48;
        if (getPlatform() != r10.getPlatform()) goto L48;
        if (getExternalAttributes() != r10.getExternalAttributes()) goto L48;
        if (getMethod() != r10.getMethod()) goto L48;
        if (getSize() != r10.getSize()) goto L48;
        if (getCrc() != r10.getCrc()) goto L48;
        if (getCompressedSize() != r10.getCompressedSize()) goto L48;
        if (Arrays.equals(getCentralDirectoryExtra(), r10.getCentralDirectoryExtra()) == false) goto L48;
        if (Arrays.equals(getLocalFileDataExtra(), r10.getLocalFileDataExtra()) == false) goto L48;
        if (this.localHeaderOffset != r10.localHeaderOffset) goto L48;
        if (this.dataOffset != r10.dataOffset) goto L48;
        if (this.gpb.equals(r10.gpb) == false) goto L48;
        return true;
    L48:
        return false;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public byte[] getCentralDirectoryExtra() {
        return ExtraFieldUtils.mergeCentralDirectoryData(getAllExtraFieldsNoCopy());
    }

    public long getDataOffset() {
        return this.dataOffset;
    }

    public long getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public long getExternalAttributes() {
        return this.externalAttributes;
    }

    public ZipExtraField getExtraField(ZipShort r5) {
        ZipExtraField[] r4 = this.extraFields;
        if (r4 == null) goto L10;
        int r0 = r4.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        ZipExtraField r2 = r4[r1];
        if (r5.equals(r2.getHeaderId()) == true) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return r2;
    L14:
        return null;
    L10:
        return null;
    }

    public GeneralPurposeBit getGeneralPurposeBit() {
        return this.gpb;
    }

    public int getInternalAttributes() {
        return this.internalAttributes;
    }

    public byte[] getLocalFileDataExtra() {
        byte[] r0 = getExtra();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    public long getLocalHeaderOffset() {
        return this.localHeaderOffset;
    }

    @Override // java.util.zip.ZipEntry
    public int getMethod() {
        return this.method;
    }

    @Override // java.util.zip.ZipEntry
    public String getName() {
        String r0 = this.name;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return super.getName();
    }

    public int getPlatform() {
        return this.platform;
    }

    @Override // java.util.zip.ZipEntry
    public long getSize() {
        return this.size;
    }

    @Override // java.util.zip.ZipEntry
    public int hashCode() {
        String r0 = getName();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return r0.hashCode();
    }

    @Override // java.util.zip.ZipEntry
    public boolean isDirectory() {
        String r1 = getName();
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.endsWith("/") == false) goto L7;
        return true;
    }

    public void removeExtraField(ZipShort r7) {
        if (this.extraFields == null) goto L17;
        ArrayList r0 = new ArrayList();
        ZipExtraField[] r1 = this.extraFields;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        ZipExtraField r4 = r1[r3];
        if (r7.equals(r4.getHeaderId()) == true) goto L9;
        r0.add(r4);
    L9:
        r3 = r3 + 1;
        goto L5
    L11:
        if (this.extraFields.length == r0.size()) goto L15;
        this.extraFields = (ZipExtraField[]) ZeusTransformUtils.preCheckCast(r0.toArray(ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY), ZipExtraField[].class, "com.obric.memorydata.plugin");
        setExtra();
        return;
    L15:
        throw new NoSuchElementException();
    L17:
        throw new NoSuchElementException();
    }

    public void setCentralDirectoryExtra(byte[] r3) {
        mergeExtraFields(ExtraFieldUtils.parse(r3, false, ExtraFieldParsingMode.BEST_EFFORT), false);     // Catch: ZipException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public void setCommentSource(CommentSource r1) {
        this.commentSource = r1;
    }

    public void setDataOffset(long r1) {
        this.dataOffset = r1;
    }

    public void setDiskNumberStart(long r1) {
        this.diskNumberStart = r1;
    }

    public void setExternalAttributes(long r1) {
        this.externalAttributes = r1;
    }

    public void setExtra() {
        super.setExtra(ExtraFieldUtils.mergeLocalFileDataData(getAllExtraFieldsNoCopy()));
    }

    @Override // java.util.zip.ZipEntry
    public void setExtra(byte[] r4) {
        mergeExtraFields(ExtraFieldUtils.parse(r4, true, ExtraFieldParsingMode.BEST_EFFORT), true);     // Catch: ZipException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("Error parsing extra fields for entry: " + getName() + " - " + e.getMessage(), e);
    }

    public void setExtraFields(ZipExtraField[] r7) {
        this.unparseableExtra = null;
        ArrayList r0 = new ArrayList();
        if (r7 == null) goto L11;
        int r2 = r7.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        ZipExtraField r4 = r7[r3];
        if (ZeusTransformUtils.instanceOf(r4, UnparseableExtraFieldData.class) == false) goto L9;
        this.unparseableExtra = (UnparseableExtraFieldData) ZeusTransformUtils.preCheckCast(r4, UnparseableExtraFieldData.class, "com.obric.memorydata.plugin");
    L10:
        r3 = r3 + 1;
        goto L5
    L9:
        r0.add(r4);
    L11:
        this.extraFields = (ZipExtraField[]) ZeusTransformUtils.preCheckCast(r0.toArray(ExtraFieldUtils.EMPTY_ZIP_EXTRA_FIELD_ARRAY), ZipExtraField[].class, "com.obric.memorydata.plugin");
        setExtra();
    }

    public void setGeneralPurposeBit(GeneralPurposeBit r1) {
        this.gpb = r1;
    }

    public void setInternalAttributes(int r1) {
        this.internalAttributes = r1;
    }

    public void setLocalHeaderOffset(long r1) {
        this.localHeaderOffset = r1;
    }

    @Override // java.util.zip.ZipEntry
    public void setMethod(int r3) {
        if (r3 < 0) goto L6;
        this.method = r3;
        return;
    L6:
        throw new IllegalArgumentException("ZIP compression method can not be negative: " + r3);
    }

    public void setName(String r3) {
        if (r3 != null) goto L4;
    L8:
        this.name = r3;
        return;
    L4:
        if (getPlatform() != 0) goto L8;
        if (r3.contains("/") == true) goto L8;
        r3 = r3.replace('\\', '/');
        goto L8
    }

    public void setName(String r1, byte[] r2) {
        setName(r1);
        this.rawName = r2;
    }

    public void setNameSource(NameSource r1) {
        this.nameSource = r1;
    }

    public void setPlatform(int r1) {
        this.platform = r1;
    }

    public void setRawFlag(int r1) {
        this.rawFlag = r1;
    }

    @Override // java.util.zip.ZipEntry
    public void setSize(long r3) {
        if (r3 < 0) goto L7;
        this.size = r3;
        return;
    L7:
        throw new IllegalArgumentException("Invalid entry size");
    }

    public void setStreamContiguous(boolean r1) {
        this.isStreamContiguous = r1;
    }

    public void setVersionMadeBy(int r1) {
        this.versionMadeBy = r1;
    }

    public void setVersionRequired(int r1) {
        this.versionRequired = r1;
    }
}
