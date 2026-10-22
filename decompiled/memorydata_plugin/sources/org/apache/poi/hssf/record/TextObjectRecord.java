package org.apache.poi.hssf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class TextObjectRecord extends ContinuableRecord {
    private static final BitField HorizontalTextAlignment = null;
    private static final BitField VerticalTextAlignment = null;
    private static final BitField textLocked = null;
    private OperandPtg _linkRefPtg;
    private HSSFRichTextString _text;
    private Byte _unknownPostFormulaByte;
    private int _unknownPreFormulaInt;
    private int field_1_options;
    private int field_2_textOrientation;
    private int field_3_reserved4;
    private int field_4_reserved5;
    private int field_5_reserved6;
    private int field_8_reserved7;

    static {
        HorizontalTextAlignment = BitFieldFactory.getInstance(14);
        VerticalTextAlignment = BitFieldFactory.getInstance(112);
        textLocked = BitFieldFactory.getInstance(512);
    }

    public TextObjectRecord() {
    }

    public TextObjectRecord(RecordInputStream r7) {
        this.field_1_options = r7.readUShort();
        this.field_2_textOrientation = r7.readUShort();
        this.field_3_reserved4 = r7.readUShort();
        this.field_4_reserved5 = r7.readUShort();
        this.field_5_reserved6 = r7.readUShort();
        int r0 = r7.readUShort();
        int r1 = r7.readUShort();
        this.field_8_reserved7 = r7.readInt();
        Byte r3 = null;
        if (r7.remaining() > 0) goto L5;
        this._linkRefPtg = null;
    L18:
        if (r7.remaining() > 0) goto L27;
        if (r0 <= 0) goto L21;
        String r2 = readRawString(r7, r0);
    L22:
        HSSFRichTextString r4 = new HSSFRichTextString(r2);
        this._text = r4;
        if (r1 <= 0) goto L28;
        processFontRuns(r7, r4, r1);
        return;
    L28:
        return;
    L21:
        r2 = "";
        goto L22
    L27:
        throw new RecordFormatException("Unused " + r7.remaining() + " bytes at end of record");
    L5:
        if (r7.remaining() < 11) goto L15;
        int r5 = r7.readUShort();
        this._unknownPreFormulaInt = r7.readInt();
        Ptg[] r6 = Ptg.readTokens(r5, r7);
        if (r6.length != 1) goto L13;
        this._linkRefPtg = (OperandPtg) ZeusTransformUtils.preCheckCast(r6[0], OperandPtg.class, "com.obric.memorydata.plugin");
        if (r7.remaining() <= 0) goto L11;
        r3 = Byte.valueOf(r7.readByte());
    L11:
        this._unknownPostFormulaByte = r3;
        goto L18
    L13:
        throw new RecordFormatException("Read " + r6.length + " tokens but expected exactly 1");
    L15:
        throw new RecordFormatException("Not enough remaining data for a link formula");
    }

    private int getFormattingDataLength() {
        if (this._text.length() >= 1) goto L7;
        return 0;
    L7:
        return (this._text.numFormattingRuns() + 1) * 8;
    }

    private static void processFontRuns(RecordInputStream r4, HSSFRichTextString r5, int r6) {
        if ((r6 % 8) != 0) goto L9;
        int r7 = r6 / 8;
        int r0 = 0;
    L5:
        if (r0 >= r7) goto L7;
        short r1 = r4.readShort();
        short r2 = r4.readShort();
        r4.readInt();
        r5.applyFont(r1, r5.length(), r2);
        r0 = r0 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new RecordFormatException("Bad format run data length " + r6 + ")");
    }

    private static String readRawString(RecordInputStream r2, int r3) {
        boolean r1 = true;
        if ((r2.readByte() & 1) == 0) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L10;
        return r2.readCompressedUnicode(r3);
    L10:
        return r2.readUnicodeLEString(r3);
    }

    private void serializeTXORecord(ContinuableRecordOutput r2) {
        r2.writeShort(this.field_1_options);
        r2.writeShort(this.field_2_textOrientation);
        r2.writeShort(this.field_3_reserved4);
        r2.writeShort(this.field_4_reserved5);
        r2.writeShort(this.field_5_reserved6);
        r2.writeShort(this._text.length());
        r2.writeShort(getFormattingDataLength());
        r2.writeInt(this.field_8_reserved7);
        OperandPtg r0 = this._linkRefPtg;
        if (r0 == null) goto L8;
        r2.writeShort(r0.getSize());
        r2.writeInt(this._unknownPreFormulaInt);
        this._linkRefPtg.write(r2);
        Byte r1 = this._unknownPostFormulaByte;
        if (r1 == null) goto L9;
        r2.writeByte(r1.byteValue());
        return;
    L9:
        return;
    }

    private void serializeTrailingRecords(ContinuableRecordOutput r2) {
        r2.writeContinue();
        r2.writeStringData(this._text.getString());
        r2.writeContinue();
        writeFormatData(r2, this._text);
    }

    private static void writeFormatData(ContinuableRecordOutput r4, HSSFRichTextString r5) {
        int r0 = r5.numFormattingRuns();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        r4.writeShort(r5.getIndexOfFormattingRun(r2));
        short r3 = r5.getFontOfFormattingRun(r2);
        if (r3 != 0) goto L7;
        r3 = 0;
    L7:
        r4.writeShort(r3);
        r4.writeInt(0);
        r2 = r2 + 1;
        goto L3
    L8:
        r4.writeShort(r5.length());
        r4.writeShort(0);
        r4.writeInt(0);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("isHorizontal", new $$Lambda$tB7eJnPLCGID00QvRaPuIecNT4A(this));
        r0.put("isVertical", new $$Lambda$HY11hPmx79rXbvPvWkeONqrZ10A(this));
        r0.put("textLocked", new $$Lambda$vQHtUmoGyli3iKhFUtRmrS5Ewo(this));
        r0.put("textOrientation", new $$Lambda$4k5e9bYonPNlKXQvLPildnHj9mY(this));
        r0.put(TypedValues.Custom.S_STRING, new $$Lambda$5Q9SGod98pu5GbRDhVDqIzQK320(this));
        r0.put("reserved4", new $$Lambda$TextObjectRecord$puzKW9gQseB0ZkaHe2_CvQbTiE(this));
        r0.put("reserved5", new $$Lambda$TextObjectRecord$yJB5QiLbvT80dfx__AtMU2jb7Lw(this));
        r0.put("reserved6", new $$Lambda$TextObjectRecord$m1orAr4V_dxgBADeOfvAzvttfSs(this));
        r0.put("reserved7", new $$Lambda$TextObjectRecord$t_EVNai83_35MLfLeSUTijF9gyU(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.TEXT_OBJECT;
    }

    public int getHorizontalTextAlignment() {
        return HorizontalTextAlignment.getValue(this.field_1_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 438;
    }

    public HSSFRichTextString getStr() {
        return this._text;
    }

    public int getTextOrientation() {
        return this.field_2_textOrientation;
    }

    public int getVerticalTextAlignment() {
        return VerticalTextAlignment.getValue(this.field_1_options);
    }

    public boolean isTextLocked() {
        return textLocked.isSet(this.field_1_options);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$TextObjectRecord() {
        return Integer.valueOf(this.field_3_reserved4);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$TextObjectRecord() {
        return Integer.valueOf(this.field_4_reserved5);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$TextObjectRecord() {
        return Integer.valueOf(this.field_5_reserved6);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$TextObjectRecord() {
        return Integer.valueOf(this.field_8_reserved7);
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput r2) {
        serializeTXORecord(r2);
        if (this._text.getString().length() <= 0) goto L6;
        serializeTrailingRecords(r2);
        return;
    }
}
