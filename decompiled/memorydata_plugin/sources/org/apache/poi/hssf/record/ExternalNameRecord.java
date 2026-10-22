package org.apache.poi.hssf.record;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ExternalNameRecord extends StandardRecord {
    private static final int[] OPTION_FLAGS = null;
    private static final String[] OPTION_NAMES = null;
    private Object[] _ddeValues;
    private int _nColumns;
    private int _nRows;
    private short field_1_option_flag;
    private short field_2_ixals;
    private short field_3_not_used;
    private String field_4_name;
    private Formula field_5_name_definition;

    static {
        OPTION_FLAGS = new int[]{1, 2, 4, 8, 16, 32768};
        OPTION_NAMES = new String[]{"BUILTIN_NAME", "AUTOMATIC_LINK", "PICTURE_LINK", "STD_DOCUMENT_NAME", "OLE_LINK", "ICONIFIED_PICTURE_LINK"};
    }

    public ExternalNameRecord() {
        this.field_2_ixals = 0;
    }

    public ExternalNameRecord(RecordInputStream r4) {
        this.field_1_option_flag = r4.readShort();
        this.field_2_ixals = r4.readShort();
        this.field_3_not_used = r4.readShort();
        this.field_4_name = StringUtil.readUnicodeString(r4, r4.readUByte());
        if (isOLELink() == false) goto L5;
        return;
    L5:
        if (isStdDocumentNameIdentifier() == false) goto L7;
        return;
    L7:
        if (isAutomaticLink() == true) goto L9;
        this.field_5_name_definition = Formula.read(r4.readUShort(), r4);
        return;
    L9:
        if (r4.available() <= 0) goto L15;
        int r0 = r4.readUByte() + 1;
        int r1 = r4.readShort() + 1;
        this._ddeValues = ConstantValueParser.parse(r4, r1 * r0);
        this._nColumns = r0;
        this._nRows = r1;
        return;
    }

    static /* synthetic */ Object lambda$getGenericProperties$1() {
        return null;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int r0 = (StringUtil.getEncodedSize(this.field_4_name) - 1) + 6;
        if (isOLELink() == false) goto L5;
        return r0;
    L5:
        if (isStdDocumentNameIdentifier() == false) goto L7;
        return r0;
    L7:
        if (isAutomaticLink() == false) goto L11;
        Object[] r2 = this._ddeValues;
        if (r2 == null) goto L16;
        r0 = r0 + 3;
        int r3 = ConstantValueParser.getEncodedSize(r2);
    L13:
        return r0 + r3;
    L16:
        return r0;
    L11:
        r3 = this.field_5_name_definition.getEncodedSize();
        goto L13
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        Supplier<GenericRecordUtil.AnnotatedFlag> r4 = GenericRecordUtil.getBitsAsString(new $$Lambda$ExternalNameRecord$xVmCtYhu9U26CR9DxIOMXdgAF7E(this), OPTION_FLAGS, OPTION_NAMES);
        Supplier r6 = new $$Lambda$UqX_qKoJAzFES7eEZukzpCapdk(this);
        Supplier r8 = new $$Lambda$XHMAAIwA5VBxV7xL5mQsJlDKj8(this);
        final Formula r11 = this.field_5_name_definition;
        if (r11 != null) goto L5;
        Supplier r10 = $$Lambda$ExternalNameRecord$DEeYvA_84QxzAx4DPTwlcxEijtg.INSTANCE;
    L7:
        return GenericRecordUtil.getGenericProperties("options", r4, "ix", r6, ActivityLifecycle.NAME, r8, "nameDefinition", r10);
    L5:
        r11.getClass();
        r10 = new $$Lambda$jJdZKyRse0KT9yuP3blrS24QSEY(r11);
        goto L7
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXTERNAL_NAME;
    }

    public short getIx() {
        return this.field_2_ixals;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 35;
    }

    public String getText() {
        return this.field_4_name;
    }

    public boolean isAutomaticLink() {
        if ((this.field_1_option_flag & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOLELink() {
        if ((this.field_1_option_flag & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStdDocumentNameIdentifier() {
        if ((this.field_1_option_flag & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ Number lambda$getGenericProperties$0$ExternalNameRecord() {
        return Short.valueOf(this.field_1_option_flag);
    }

    public void setParsedExpression(Ptg[] r1) {
        this.field_5_name_definition = Formula.create(r1);
    }

    public void setText(String r1) {
        this.field_4_name = r1;
    }
}
