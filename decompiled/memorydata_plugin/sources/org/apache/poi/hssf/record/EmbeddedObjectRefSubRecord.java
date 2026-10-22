package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class EmbeddedObjectRefSubRecord extends SubRecord {
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private static final c LOG = null;
    private int field_1_unknown_int;
    private Ptg field_2_refPtg;
    private byte[] field_2_unknownFormulaData;
    private boolean field_3_unicode_flag;
    private String field_4_ole_classname;
    private Byte field_4_unknownByte;
    private Integer field_5_stream_id;
    private byte[] field_6_unknown;

    static {
        LOG = b.a(EmbeddedObjectRefSubRecord.class);
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    public EmbeddedObjectRefSubRecord() {
        this.field_2_unknownFormulaData = new byte[]{2, 108, 106, 22, 1};
        this.field_6_unknown = EMPTY_BYTE_ARRAY;
        this.field_4_ole_classname = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    EmbeddedObjectRefSubRecord(LittleEndianInput r8, int r9, int r10) {
        LittleEndianInput r11 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r8, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r12 = r9 - 2;
        int r13 = r12 - r11.readShort();
        int r0 = r11.readUShort();
        this.field_1_unknown_int = r11.readInt();
        byte[] r1 = readRawData(r11, r0);
        int r14 = ((r12 - 2) - 4) - r0;
        Ptg r2 = readRefPtg(r1);
        this.field_2_refPtg = r2;
        if (r2 != null) goto L5;
        this.field_2_unknownFormulaData = r1;
    L6:
        int r4 = 0;
        boolean r5 = false;
        if (r14 >= (r13 + 3)) goto L9;
        this.field_4_ole_classname = null;
    L24:
        int r15 = r14 - r4;
        if (((r4 + r0) % 2) == 0) goto L31;
        byte r3 = r11.readByte();
        r15 = r15 - 1;
        if (this.field_2_refPtg == null) goto L31;
        if (this.field_4_ole_classname != null) goto L31;
        this.field_4_unknownByte = Byte.valueOf(r3);
    L31:
        int r6 = r15 - r13;
        if (r6 <= 0) goto L34;
        LOG.atError().a("Discarding {} unexpected padding bytes", v.a(r6));
        readRawData(r11, r6);
        r15 = r15 - r6;
    L34:
        if (r13 < 4) goto L36;
        this.field_5_stream_id = Integer.valueOf(r11.readInt());
        r15 = r15 - 4;
    L37:
        this.field_6_unknown = readRawData(r11, r15);
        return;
    L36:
        this.field_5_stream_id = null;
        goto L37
    L9:
        if (r11.readByte() != 3) goto L22;
        int r7 = r11.readUShort();
        if (r7 > 0) goto L13;
        this.field_4_ole_classname = "";
        r4 = 3;
        goto L24
    L13:
        if ((r11.readByte() & 1) == 0) goto L15;
        r5 = true;
    L15:
        this.field_3_unicode_flag = r5;
        if (r5 == false) goto L18;
        this.field_4_ole_classname = StringUtil.readUnicodeLE(r11, r7);
        r7 = r7 * 2;
    L19:
        r4 = r7 + 4;
        goto L24
    L18:
        this.field_4_ole_classname = StringUtil.readCompressedUnicode(r11, r7);
        goto L19
    L22:
        throw new RecordFormatException("Expected byte 0x03 here");
    L5:
        this.field_2_unknownFormulaData = null;
        goto L6
    }

    private int getDataSize(int r2) {
        int r3 = r2 + 2;
        if (this.field_5_stream_id == null) goto L6;
        r3 = r3 + 4;
    L6:
        return r3 + this.field_6_unknown.length;
    }

    private int getStreamIDOffset(int r2) {
        int r3 = r2 + 6;
        String r0 = this.field_4_ole_classname;
        if (r0 == null) goto L11;
        r3 = r3 + 3;
        int r1 = r0.length();
        if (r1 <= 0) goto L11;
        int r4 = r3 + 1;
        if (this.field_3_unicode_flag == false) goto L9;
        r1 = r1 * 2;
    L9:
        r3 = r4 + r1;
    L11:
        if ((r3 % 2) != 0) goto L13;
        return r3;
    L13:
        return r3 + 1;
    }

    private static byte[] readRawData(LittleEndianInput r2, int r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
        if (r3 < 0) goto L10;
        if (r3 == 0) goto L6;
        byte[] r5 = IOUtils.safelyAllocate(r3, HSSFWorkbook.getMaxRecordLength());
        r4.readFully(r5);
        return r5;
    L6:
        return EMPTY_BYTE_ARRAY;
    L10:
        throw new IllegalArgumentException("Negative size (" + r3 + ")");
    }

    private static Ptg readRefPtg(byte[] r2) {
        LittleEndianInputStream r0 = new LittleEndianInputStream(new UnsynchronizedByteArrayInputStream(r2));     // Catch: IOException -> L35
        byte r3 = r0.readByte();     // Catch: Throwable -> L27
        if (r3 != 36) goto L7;
        RefPtg r4 = new RefPtg(r0);     // Catch: Throwable -> L27
        r0.close();     // Catch: IOException -> L35
        return r4;
    L7:
        if (r3 != 37) goto L9;
        AreaPtg r5 = new AreaPtg(r0);     // Catch: Throwable -> L27
        r0.close();     // Catch: IOException -> L35
        return r5;
    L9:
        if (r3 != 58) goto L11;
        Ref3DPtg r6 = new Ref3DPtg(r0);     // Catch: Throwable -> L27
        r0.close();     // Catch: IOException -> L35
        return r6;
    L11:
        if (r3 != 59) goto L13;
        Area3DPtg r7 = new Area3DPtg(r0);     // Catch: Throwable -> L27
        r0.close();     // Catch: IOException -> L35
        return r7;
    L13:
        r0.close();     // Catch: IOException -> L35
        return null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: IOException -> L35
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L35
    L35:
        e = move-exception;
        throw new RuntimeException("Unexpected exception in readRefPtg", e);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        Ptg r0 = this.field_2_refPtg;
        if (r0 != null) goto L5;
        int r1 = this.field_2_unknownFormulaData.length;
    L7:
        return getDataSize(getStreamIDOffset(r1));
    L5:
        r1 = r0.getSize();
        goto L7
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("f2unknown", new $$Lambda$EmbeddedObjectRefSubRecord$e02Oxg3M1VSbRJ5g0WI728SEz8(this), "f3unknown", new $$Lambda$EmbeddedObjectRefSubRecord$9twD6EttcaA7Gknc5mh6PzOyovQ(this), "formula", new $$Lambda$EmbeddedObjectRefSubRecord$3U3gXMIwfa4vKkNQp1jLM13VgA(this), "unicodeFlag", new $$Lambda$EmbeddedObjectRefSubRecord$uVbx_cCBAYA9FVXTGGLMWfZY9MQ(this), "oleClassname", new $$Lambda$EmbeddedObjectRefSubRecord$bUOSF7LGEY6GZVkcOQ1u86EHsd4(this), "f4unknown", new $$Lambda$EmbeddedObjectRefSubRecord$0C57nUTDPrWc90idssotGSvASRM(this), "streamId", new $$Lambda$EmbeddedObjectRefSubRecord$SV07ryJ5SptbTxjrjsY5B3ybqo(this), "f7unknown", new $$Lambda$EmbeddedObjectRefSubRecord$PE6Yt09Vy9vH6UU37EXZqeHmAo(this));
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.EMBEDDED_OBJECT_REF;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EmbeddedObjectRefSubRecord() {
        return Integer.valueOf(this.field_1_unknown_int);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$EmbeddedObjectRefSubRecord() {
        return this.field_2_unknownFormulaData;
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$EmbeddedObjectRefSubRecord() {
        return this.field_2_refPtg;
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$EmbeddedObjectRefSubRecord() {
        return Boolean.valueOf(this.field_3_unicode_flag);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$EmbeddedObjectRefSubRecord() {
        return this.field_4_ole_classname;
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$EmbeddedObjectRefSubRecord() {
        return this.field_4_unknownByte;
    }

    public /* synthetic */ Object lambda$getGenericProperties$6$EmbeddedObjectRefSubRecord() {
        return this.field_5_stream_id;
    }

    public /* synthetic */ Object lambda$getGenericProperties$7$EmbeddedObjectRefSubRecord() {
        return this.field_6_unknown;
    }
}
