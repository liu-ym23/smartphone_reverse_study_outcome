package org.apache.poi.hssf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class NameRecord extends ContinuableRecord {
    private boolean field_11_nameIsMultibyte;
    private byte field_12_built_in_code;
    private String field_12_name_text;
    private Formula field_13_name_definition;
    private String field_14_custom_menu_text;
    private String field_15_description_text;
    private String field_16_help_topic_text;
    private String field_17_status_bar_text;
    private short field_1_option_flag;
    private byte field_2_keyboard_shortcut;
    private short field_5_externSheetIndex_plus1;
    private int field_6_sheetNumber;

    private static final class Option {
        public static boolean isFormula(int r0) {
            if ((r0 & 15) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public NameRecord() {
        this.field_13_name_definition = Formula.create(Ptg.EMPTY_PTG_ARRAY);
        this.field_12_name_text = "";
        this.field_14_custom_menu_text = "";
        this.field_15_description_text = "";
        this.field_16_help_topic_text = "";
        this.field_17_status_bar_text = "";
    }

    public NameRecord(RecordInputStream r8) {
        LittleEndianByteArrayInputStream r0 = new LittleEndianByteArrayInputStream(r8.readAllContinuedRemainder());
        this.field_1_option_flag = r0.readShort();
        this.field_2_keyboard_shortcut = r0.readByte();
        int r9 = r0.readUByte();
        short r1 = r0.readShort();
        this.field_5_externSheetIndex_plus1 = r0.readShort();
        this.field_6_sheetNumber = r0.readUShort();
        int r2 = r0.readUByte();
        int r3 = r0.readUByte();
        int r4 = r0.readUByte();
        int r5 = r0.readUByte();
        if (r0.readByte() == 0) goto L5;
        boolean r6 = true;
    L6:
        this.field_11_nameIsMultibyte = r6;
        if (isBuiltInName() == false) goto L10;
        this.field_12_built_in_code = r0.readByte();
    L14:
        this.field_13_name_definition = Formula.read(r1, r0, r0.available() - (((r2 + r3) + r4) + r5));
        this.field_14_custom_menu_text = StringUtil.readCompressedUnicode(r0, r2);
        this.field_15_description_text = StringUtil.readCompressedUnicode(r0, r3);
        this.field_16_help_topic_text = StringUtil.readCompressedUnicode(r0, r4);
        this.field_17_status_bar_text = StringUtil.readCompressedUnicode(r0, r5);
        return;
    L10:
        if (this.field_11_nameIsMultibyte == false) goto L12;
        String r10 = StringUtil.readUnicodeLE(r0, r9);
    L13:
        this.field_12_name_text = r10;
        goto L14
    L12:
        r10 = StringUtil.readCompressedUnicode(r0, r9);
        goto L13
    L5:
        r6 = false;
        goto L6
    }

    private int getNameRawSize() {
        if (isBuiltInName() == false) goto L6;
        return 1;
    L6:
        int r0 = this.field_12_name_text.length();
        if (this.field_11_nameIsMultibyte == true) goto L9;
        return r0;
    L9:
        return r0 * 2;
    }

    private int getNameTextLength() {
        if (isBuiltInName() == false) goto L7;
        return 1;
    L7:
        return this.field_12_name_text.length();
    }

    /* JADX INFO: renamed from: lambda$Rz1KOHFcx0mJFsT_X4-oHf7Sf_M, reason: not valid java name */
    public static /* synthetic */ int m3160lambda$Rz1KOHFcx0mJFsT_X4oHf7Sf_M(NameRecord r0) {
        return r0.getNameTextLength();
    }

    private static String translateBuiltInName(byte r0) {
        switch(r0) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L21;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L13;
            case 10: goto L11;
            case 11: goto L9;
            case 12: goto L7;
            case 13: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "_FilterDatabase";
    L7:
        return "Sheet_Title";
    L9:
        return "Auto_Deactivate";
    L11:
        return "Auto_Activate";
    L13:
        return "Data_Form";
    L15:
        return "Recorder";
    L17:
        return "Print_Titles";
    L19:
        return "Print_Area";
    L21:
        return "Criteria";
    L23:
        return "Database";
    L25:
        return "Auto_Close";
    L27:
        return "Auto_Open";
    L29:
        return "Consolidate_Area";
    }

    public byte getBuiltInName() {
        return this.field_12_built_in_code;
    }

    public String getCustomMenuText() {
        return this.field_14_custom_menu_text;
    }

    int getDataSize() {
        return (((((getNameRawSize() + 13) + this.field_14_custom_menu_text.length()) + this.field_15_description_text.length()) + this.field_16_help_topic_text.length()) + this.field_17_status_bar_text.length()) + this.field_13_name_definition.getEncodedSize();
    }

    public String getDescriptionText() {
        return this.field_15_description_text;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("dataSize", new $$Lambda$yG0_tFID8qbdhdEKmUFjbtNYO44(this));
        r0.put("optionFlag", new $$Lambda$mGd40yxYhFZeDzgHcoUybWNR1Xs(this));
        r0.put("keyboardShortcut", new $$Lambda$_FElV6DnNOiar6kuhRI63N1SLY(this));
        r0.put("externSheetIndex", new $$Lambda$NameRecord$AojSlbwMeeYbDUdHczwU5hRdPho(this));
        r0.put("sheetNumber", new $$Lambda$_tZdXTZZ1ACwXMIEZoHuvKs48o(this));
        r0.put("nameIsMultibyte", new $$Lambda$NameRecord$SLllmR5CINXpVE31DF4NPqW7wE(this));
        r0.put("builtInName", new $$Lambda$n3Y03GrtMFZAIbL2ruunmmOyPZQ(this));
        r0.put("nameLength", new $$Lambda$NameRecord$Rz1KOHFcx0mJFsT_X4oHf7Sf_M(this));
        r0.put("nameText", new $$Lambda$xXckGpzNSINu56jcgGMjZHBVj4s(this));
        r0.put("formula", new $$Lambda$4dZV3tR0M4jrhN8WvDazuIqSQ(this));
        r0.put("customMenuText", new $$Lambda$f7WTafTG2vaAE2rzPChkuTRN0wI(this));
        r0.put("descriptionText", new $$Lambda$t37Ju4ASS_6onj7z_DOvFuNZEA(this));
        r0.put("helpTopicText", new $$Lambda$dvR7K0FcLv6GK2AkkUpmAocRrn8(this));
        r0.put("statusBarText", new $$Lambda$Tj2dGwE_oen3gWNo7dfAAQnTM9s(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.NAME;
    }

    public String getHelpTopicText() {
        return this.field_16_help_topic_text;
    }

    public byte getKeyboardShortcut() {
        return this.field_2_keyboard_shortcut;
    }

    public Ptg[] getNameDefinition() {
        return this.field_13_name_definition.getTokens();
    }

    public String getNameText() {
        if (isBuiltInName() == false) goto L6;
        return translateBuiltInName(getBuiltInName());
    L6:
        return this.field_12_name_text;
    }

    public short getOptionFlag() {
        return this.field_1_option_flag;
    }

    public int getSheetNumber() {
        return this.field_6_sheetNumber;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 24;
    }

    public String getStatusBarText() {
        return this.field_17_status_bar_text;
    }

    public boolean hasFormula() {
        if (Option.isFormula(this.field_1_option_flag) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.field_13_name_definition.getEncodedTokenSize() <= 0) goto L7;
        return true;
    }

    public boolean isBuiltInName() {
        if ((this.field_1_option_flag & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFunctionName() {
        if ((this.field_1_option_flag & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$NameRecord() {
        return Short.valueOf(this.field_5_externSheetIndex_plus1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$NameRecord() {
        return Boolean.valueOf(this.field_11_nameIsMultibyte);
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput r6) {
        int r0 = this.field_14_custom_menu_text.length();
        int r1 = this.field_15_description_text.length();
        int r2 = this.field_16_help_topic_text.length();
        int r3 = this.field_17_status_bar_text.length();
        r6.writeShort(getOptionFlag());
        r6.writeByte(getKeyboardShortcut());
        r6.writeByte(getNameTextLength());
        r6.writeShort(this.field_13_name_definition.getEncodedTokenSize());
        r6.writeShort(this.field_5_externSheetIndex_plus1);
        r6.writeShort(this.field_6_sheetNumber);
        r6.writeByte(r0);
        r6.writeByte(r1);
        r6.writeByte(r2);
        r6.writeByte(r3);
        r6.writeByte(this.field_11_nameIsMultibyte ? 1 : 0);
        if (isBuiltInName() == false) goto L5;
        r6.writeByte(this.field_12_built_in_code);
    L9:
        this.field_13_name_definition.serializeTokens(r6);
        this.field_13_name_definition.serializeArrayConstantData(r6);
        StringUtil.putCompressedUnicode(getCustomMenuText(), r6);
        StringUtil.putCompressedUnicode(getDescriptionText(), r6);
        StringUtil.putCompressedUnicode(getHelpTopicText(), r6);
        StringUtil.putCompressedUnicode(getStatusBarText(), r6);
        return;
    L5:
        String r4 = this.field_12_name_text;
        if (this.field_11_nameIsMultibyte == false) goto L8;
        StringUtil.putUnicodeLE(r4, r6);
        goto L9
    L8:
        StringUtil.putCompressedUnicode(r4, r6);
        goto L9
    }

    public void setFunction(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = this.field_1_option_flag | 2;
    L5:
        this.field_1_option_flag = (short) r2;
        return;
    L4:
        r2 = this.field_1_option_flag & (-3);
        goto L5
    }

    public void setNameText(String r1) {
        this.field_12_name_text = r1;
        this.field_11_nameIsMultibyte = StringUtil.hasMultibyte(r1);
    }

    public void setSheetNumber(int r1) {
        this.field_6_sheetNumber = r1;
    }
}
