package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.BitField;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DVRecord extends StandardRecord {
    private static final int[] FLAG_MASKS = null;
    private static final String[] FLAG_NAMES = null;
    private static final UnicodeString NULL_TEXT_STRING = null;
    private static final BitField opt_condition_operator = null;
    private static final BitField opt_data_type = null;
    private static final BitField opt_empty_cell_allowed = null;
    private static final BitField opt_error_style = null;
    private static final BitField opt_show_error_on_invalid_value = null;
    private static final BitField opt_show_prompt_on_cell_selected = null;
    private static final BitField opt_string_list_formula = null;
    private static final BitField opt_suppress_dropdown_arrow = null;
    private final UnicodeString _errorText;
    private final UnicodeString _errorTitle;
    private final Formula _formula1;
    private final Formula _formula2;
    private short _not_used_1;
    private short _not_used_2;
    private int _option_flags;
    private final UnicodeString _promptText;
    private final UnicodeString _promptTitle;
    private final CellRangeAddressList _regions;

    static {
        NULL_TEXT_STRING = new UnicodeString("\u0000");
        opt_data_type = new BitField(15);
        opt_error_style = new BitField(112);
        opt_string_list_formula = new BitField(128);
        opt_empty_cell_allowed = new BitField(256);
        opt_suppress_dropdown_arrow = new BitField(512);
        opt_show_prompt_on_cell_selected = new BitField(262144);
        opt_show_error_on_invalid_value = new BitField(524288);
        opt_condition_operator = new BitField(7340032);
        FLAG_MASKS = new int[]{15, 112, 128, 256, 512, 262144, 524288, 7340032};
        FLAG_NAMES = new String[]{"DATA_TYPE", "ERROR_STYLE", "STRING_LIST_FORMULA", "EMPTY_CELL_ALLOWED", "SUPPRESS_DROPDOWN_ARROW", "SHOW_PROMPT_ON_CELL_SELECTED", "SHOW_ERROR_ON_INVALID_VALUE", "CONDITION_OPERATOR"};
    }

    public DVRecord(RecordInputStream r3) {
        this._not_used_1 = 16352;
        this._not_used_2 = 0;
        this._option_flags = r3.readInt();
        this._promptTitle = readUnicodeString(r3);
        this._errorTitle = readUnicodeString(r3);
        this._promptText = readUnicodeString(r3);
        this._errorText = readUnicodeString(r3);
        int r0 = r3.readUShort();
        this._not_used_1 = r3.readShort();
        this._formula1 = Formula.read(r0, r3);
        int r1 = r3.readUShort();
        this._not_used_2 = r3.readShort();
        this._formula2 = Formula.read(r1, r3);
        this._regions = new CellRangeAddressList(r3);
    }

    private static int getUnicodeStringSize(UnicodeString r1) {
        String r2 = r1.getString();
        int r0 = r2.length();
        if (StringUtil.hasMultibyte(r2) == false) goto L5;
        int r3 = 2;
    L7:
        return (r0 * r3) + 3;
    L5:
        r3 = 1;
        goto L7
    }

    private static UnicodeString readUnicodeString(RecordInputStream r1) {
        return new UnicodeString(r1);
    }

    private static String resolveTitleString(UnicodeString r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.equals(NULL_TEXT_STRING) == false) goto L7;
        return null;
    L7:
        return r1.getString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return ((((((getUnicodeStringSize(this._promptTitle) + 12) + getUnicodeStringSize(this._errorTitle)) + getUnicodeStringSize(this._promptText)) + getUnicodeStringSize(this._errorText)) + this._formula1.getEncodedTokenSize()) + this._formula2.getEncodedTokenSize()) + this._regions.getSize();
    }

    public String getErrorText() {
        return resolveTitleString(this._errorText);
    }

    public String getErrorTitle() {
        return resolveTitleString(this._errorTitle);
    }

    public Ptg[] getFormula1() {
        return Formula.getTokens(this._formula1);
    }

    public Ptg[] getFormula2() {
        return Formula.getTokens(this._formula2);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("optionFlags", GenericRecordUtil.getBitsAsString(new $$Lambda$DVRecord$qMErm1Wv0qA8PxuNTJRhWfJGS0(this), FLAG_MASKS, FLAG_NAMES), "promptTitle", new $$Lambda$c9YzI6yQFr8evlNTlA0MfOjEKZ0(this), "errorTitle", new $$Lambda$kyZq7vfQW_5VzGQRucOvupScNLo(this), "promptText", new $$Lambda$qh8aOIPngUNGqy_o0gZKJ9ik4(this), "errorText", new $$Lambda$0C9RukGsOKL7iyzP11yKOh4SHlw(this), "formula1", new $$Lambda$SzwSscTdknFXc7uaUU5XAbKDkyE(this), "formula2", new $$Lambda$OvXBkiyqYJNsRJrLffaAqh4drhE(this), "regions", new $$Lambda$DVRecord$wvP4eKcOBbWx4PTBVZRiyaRRaA(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DV;
    }

    public String getPromptText() {
        return resolveTitleString(this._promptText);
    }

    public String getPromptTitle() {
        return resolveTitleString(this._promptTitle);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 446;
    }

    public /* synthetic */ Number lambda$getGenericProperties$0$DVRecord() {
        return Integer.valueOf(this._option_flags);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$DVRecord() {
        return this._regions;
    }
}
