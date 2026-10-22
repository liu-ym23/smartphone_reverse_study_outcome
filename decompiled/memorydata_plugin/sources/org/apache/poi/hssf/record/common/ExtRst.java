package org.apache.poi.hssf.record.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class ExtRst implements Comparable<ExtRst>, GenericRecord {
    private static final c LOG = null;
    private byte[] extraData;
    private short formattingFontIndex;
    private short formattingOptions;
    private int numberOfRuns;
    private PhRun[] phRuns;
    private String phoneticText;
    private short reserved;

    static {
        LOG = b.a(ExtRst.class);
    }

    public ExtRst() {
        populateEmpty();
    }

    public ExtRst(ExtRst r3) {
        this();
        this.reserved = r3.reserved;
        this.formattingFontIndex = r3.formattingFontIndex;
        this.formattingOptions = r3.formattingOptions;
        this.numberOfRuns = r3.numberOfRuns;
        this.phoneticText = r3.phoneticText;
        PhRun[] r4 = r3.phRuns;
        if (r4 != null) goto L5;
        PhRun[] r5 = null;
    L6:
        this.phRuns = r5;
        return;
    L5:
        r5 = (PhRun[]) ZeusTransformUtils.preCheckCast(Stream.of(r4).map($$Lambda$h79GkELCnL9K2qZMoAnU7dmuA8.INSTANCE).toArray($$Lambda$ExtRst$Q3tRzHkR0PeCinFzsj8oCszrdpQ.INSTANCE), PhRun[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    public ExtRst(LittleEndianInput r6, int r7) {
        LittleEndianInput r8 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r6, LittleEndianInput.class, "com.obric.memorydata.plugin");
        short r0 = r8.readShort();
        this.reserved = r0;
        if (r0 != (-1)) goto L6;
        populateEmpty();
        return;
    L6:
        int r2 = 0;
        if (r0 == 1) goto L14;
        LOG.atWarn().a("ExtRst has wrong magic marker, expecting 1 but found {} - ignoring", v.a(this.reserved));
    L10:
        if (r2 >= (r7 - 2)) goto L12;
        r8.readByte();
        r2 = r2 + 1;
        goto L10
    L12:
        populateEmpty();
        return;
    L14:
        short r9 = r8.readShort();
        this.formattingFontIndex = r8.readShort();
        this.formattingOptions = r8.readShort();
        this.numberOfRuns = r8.readUShort();
        short r1 = r8.readShort();
        short r3 = r8.readShort();
        if (r1 != 0) goto L18;
        if (r3 <= 0) goto L18;
        r3 = 0;
    L18:
        if (r1 != r3) goto L32;
        String r4 = StringUtil.readUnicodeLE(r8, r1);
        this.phoneticText = r4;
        int r10 = ((r9 - 4) - 6) - (r4.length() * 2);
        int r5 = r10 / 6;
        this.phRuns = new PhRun[r5];
        int r11 = 0;
    L20:
        PhRun[] r12 = this.phRuns;
        if (r11 >= r12.length) goto L23;
        r12[r11] = new PhRun(r8);
        r11 = r11 + 1;
        goto L20
    L23:
        int r13 = r10 - (r5 * 6);
        if (r13 >= 0) goto L26;
        LOG.atWarn().a("ExtRst overran by {} bytes", v.a(-r13));
        r13 = 0;
    L26:
        this.extraData = IOUtils.safelyAllocate(r13, HSSFWorkbook.getMaxRecordLength());
    L27:
        byte[] r14 = this.extraData;
        if (r2 >= r14.length) goto L30;
        r14[r2] = r8.readByte();
        r2 = r2 + 1;
        goto L27
    L30:
        return;
    L32:
        throw new IllegalStateException("The two length fields of the Phonetic Text don't agree! " + r1 + " vs " + r3);
    }

    static /* synthetic */ PhRun[] lambda$new$0(int r0) {
        return new PhRun[r0];
    }

    private void populateEmpty() {
        this.reserved = 1;
        this.phoneticText = "";
        this.phRuns = new PhRun[0];
        this.extraData = new byte[0];
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ExtRst r3) {
        return compareTo2((ExtRst) ZeusTransformUtils.preCheckCast(r3, ExtRst.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ExtRst r4) {
        int r0 = this.reserved - r4.reserved;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = this.formattingFontIndex - r4.formattingFontIndex;
        if (r1 == 0) goto L8;
        return r1;
    L8:
        int r2 = this.formattingOptions - r4.formattingOptions;
        if (r2 == 0) goto L11;
        return r2;
    L11:
        int r3 = this.numberOfRuns - r4.numberOfRuns;
        if (r3 == 0) goto L14;
        return r3;
    L14:
        int r5 = this.phoneticText.compareTo(r4.phoneticText);
        if (r5 == 0) goto L17;
        return r5;
    L17:
        int r6 = this.phRuns.length - r4.phRuns.length;
        if (r6 == 0) goto L20;
        return r6;
    L20:
        int r7 = 0;
    L21:
        PhRun[] r8 = this.phRuns;
        if (r7 >= r8.length) goto L34;
        int r9 = r8[r7].phoneticTextFirstCharacterOffset - r4.phRuns[r7].phoneticTextFirstCharacterOffset;
        if (r9 != 0) goto L25;
        int r10 = this.phRuns[r7].realTextFirstCharacterOffset - r4.phRuns[r7].realTextFirstCharacterOffset;
        if (r10 != 0) goto L28;
        int r11 = this.phRuns[r7].realTextLength - r4.phRuns[r7].realTextLength;
        if (r11 != 0) goto L31;
        r7 = r7 + 1;
        goto L21
    L31:
        return r11;
    L28:
        return r10;
    L25:
        return r9;
    L34:
        return Arrays.hashCode(this.extraData) - Arrays.hashCode(r4.extraData);
    }

    public ExtRst copy() {
        return new ExtRst(this);
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ExtRst.class) == true) goto L6;
        return false;
    L6:
        if (compareTo2((ExtRst) ZeusTransformUtils.preCheckCast(r4, ExtRst.class, "com.obric.memorydata.plugin")) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public int getDataSize() {
        return (((this.phoneticText.length() * 2) + 10) + (this.phRuns.length * 6)) + this.extraData.length;
    }

    public short getFormattingFontIndex() {
        return this.formattingFontIndex;
    }

    public short getFormattingOptions() {
        return this.formattingOptions;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("reserved", new $$Lambda$ExtRst$O4XLCJhzacQSIPPc1iQebjrBx9M(this), "formattingFontIndex", new $$Lambda$BJfkTQFu975DWNQZ0L_N0cSN4dw(this), "formattingOptions", new $$Lambda$2NFr3Xb2MKbIYUppLpb718VyoHs(this), "numberOfRuns", new $$Lambda$ebRvvkMwqF1YbGY4YKVEXaE5d9E(this), "phoneticText", new $$Lambda$fKurcgn5uKsb0LYw4jdme3j7c7Y(this), "phRuns", new $$Lambda$LFncoCngylE14QKfhrekEogzwY(this), "extraData", new $$Lambda$ExtRst$Lnpi_aZYEeyRxiL4o3yyD455eI(this));
    }

    public int getNumberOfRuns() {
        return this.numberOfRuns;
    }

    public PhRun[] getPhRuns() {
        return this.phRuns;
    }

    public String getPhoneticText() {
        return this.phoneticText;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{Short.valueOf(this.reserved), Short.valueOf(this.formattingFontIndex), Short.valueOf(this.formattingOptions), Integer.valueOf(this.numberOfRuns), this.phoneticText, this.phRuns});
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ExtRst() {
        return Short.valueOf(this.reserved);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ExtRst() {
        return this.extraData;
    }

    public void serialize(ContinuableRecordOutput r5) {
        int r0 = getDataSize();
        r5.writeContinueIfRequired(8);
        r5.writeShort(this.reserved);
        r5.writeShort(r0);
        r5.writeShort(this.formattingFontIndex);
        r5.writeShort(this.formattingOptions);
        r5.writeContinueIfRequired(6);
        r5.writeShort(this.numberOfRuns);
        r5.writeShort(this.phoneticText.length());
        r5.writeShort(this.phoneticText.length());
        r5.writeContinueIfRequired(this.phoneticText.length() * 2);
        StringUtil.putUnicodeLE(this.phoneticText, r5);
        PhRun[] r1 = this.phRuns;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1[r3].serialize(r5);
        r3 = r3 + 1;
        goto L3
    L5:
        r5.write(this.extraData);
    }
}
