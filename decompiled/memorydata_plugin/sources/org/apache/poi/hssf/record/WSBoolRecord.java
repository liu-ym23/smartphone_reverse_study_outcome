package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class WSBoolRecord extends StandardRecord {
    private static final BitField alternateexpression = null;
    private static final BitField alternateformula = null;
    private static final BitField applystyles = null;
    private static final BitField autobreaks = null;
    private static final BitField dialog = null;
    private static final BitField displayguts = null;
    private static final BitField fittopage = null;
    private static final BitField rowsumsbelow = null;
    private static final BitField rowsumsright = null;
    private byte field_1_wsbool;
    private byte field_2_wsbool;

    static {
        autobreaks = BitFieldFactory.getInstance(1);
        dialog = BitFieldFactory.getInstance(16);
        applystyles = BitFieldFactory.getInstance(32);
        rowsumsbelow = BitFieldFactory.getInstance(64);
        rowsumsright = BitFieldFactory.getInstance(128);
        fittopage = BitFieldFactory.getInstance(1);
        displayguts = BitFieldFactory.getInstance(6);
        alternateexpression = BitFieldFactory.getInstance(64);
        alternateformula = BitFieldFactory.getInstance(128);
    }

    public WSBoolRecord() {
    }

    public WSBoolRecord(RecordInputStream r2) {
        byte[] r3 = r2.readRemainder();
        this.field_1_wsbool = r3[1];
        this.field_2_wsbool = r3[0];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("wsbool1", GenericRecordUtil.getBitsAsString(new $$Lambda$N9o81cRfgjYjn5jcopoXRVip838(this), new BitField[]{autobreaks, dialog, applystyles, rowsumsbelow, rowsumsright}, new String[]{"AUTO_BREAKS", "DIALOG", "APPLY_STYLES", "ROW_SUMS_BELOW", "ROW_SUMS_RIGHT"}), "wsbool2", GenericRecordUtil.getBitsAsString(new $$Lambda$8zVoIxxpJcGZ8z32cwbfodfUsCY(this), new BitField[]{fittopage, displayguts, alternateexpression, alternateformula}, new String[]{"FIT_TO_PAGE", "DISPLAY_GUTS", "ALTERNATE_EXPRESSION", "ALTERNATE_FORMULA"}));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WS_BOOL;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 129;
    }

    public byte getWSBool1() {
        return this.field_1_wsbool;
    }

    public byte getWSBool2() {
        return this.field_2_wsbool;
    }

    public void setWSBool1(byte r1) {
        this.field_1_wsbool = r1;
    }

    public void setWSBool2(byte r1) {
        this.field_2_wsbool = r1;
    }
}
