package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SupBookRecord extends StandardRecord {
    private static final c LOG = null;
    static final String PATH_SEPERATOR = null;
    private final boolean _isAddInFunctions;
    private short field_1_number_of_sheets;
    private String field_2_encoded_url;
    private final String[] field_3_sheet_names;

    static {
        LOG = b.a(SupBookRecord.class);
        PATH_SEPERATOR = System.getProperty("file.separator");
    }

    public SupBookRecord(RecordInputStream r5) {
        int r0 = r5.remaining();
        this.field_1_number_of_sheets = r5.readShort();
        int r1 = 0;
        if (r0 <= 4) goto L9;
        this._isAddInFunctions = false;
        this.field_2_encoded_url = r5.readString();
        int r2 = this.field_1_number_of_sheets;
        String[] r3 = new String[r2];
    L5:
        if (r1 >= r2) goto L7;
        r3[r1] = r5.readString();
        r1 = r1 + 1;
        goto L5
    L7:
        this.field_3_sheet_names = r3;
        return;
    L9:
        this.field_2_encoded_url = null;
        this.field_3_sheet_names = null;
        short r6 = r5.readShort();
        if (r6 != 1025) goto L13;
        this._isAddInFunctions = false;
        return;
    L13:
        if (r6 != 14849) goto L20;
        this._isAddInFunctions = true;
        if (this.field_1_number_of_sheets != 1) goto L18;
        return;
    L18:
        throw new IllegalArgumentException("Expected 0x0001 for number of sheets field in 'Add-In Functions' but got (" + this.field_1_number_of_sheets + ")");
    L20:
        throw new IllegalArgumentException("invalid EXTERNALBOOK code (" + Integer.toHexString(r6) + ")");
    }

    private SupBookRecord(boolean r1, short r2) {
        this.field_1_number_of_sheets = r2;
        this.field_2_encoded_url = null;
        this.field_3_sheet_names = null;
        this._isAddInFunctions = r1;
    }

    public static SupBookRecord createAddInFunctions() {
        return new SupBookRecord(true, 1);
    }

    public static SupBookRecord createInternalReferences(short r2) {
        return new SupBookRecord(false, r2);
    }

    private static String decodeFileName(String r5) {
        StringBuilder r0 = new StringBuilder();
        int r2 = 1;
    L4:
        if (r2 >= r5.length()) goto L21;
        char r3 = r5.charAt(r2);
        switch(r3) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        r0.append(r3);
    L19:
        r2 = r2 + 1;
        goto L4
    L8:
        LOG.atWarn().a("EXCEL.EXE path unknown - using this directory instead: .");
        StringBuilder r4 = r0.append('.');
    L11:
        String r6 = PATH_SEPERATOR;
    L18:
        r4.append(r6);
        goto L19
    L9:
        LOG.atWarn().a("Found unexpected key: ChLongVolume - IGNORING");
        goto L19
    L10:
        r4 = r0.append("..");
        goto L11
    L12:
        String r7 = PATH_SEPERATOR;
    L16:
        r0.append(r7);
        goto L19
    L13:
        r2 = r2 + 1;
        char r8 = r5.charAt(r2);
        if (r8 != '@') goto L17;
        r7 = "\\\\";
        goto L16
    L17:
        r4 = r0.append(r8);
        r6 = ParameterizedMessage.ERROR_MSG_SEPARATOR;
        goto L18
    L21:
        return r0.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        if (isExternalReferences() == true) goto L6;
        return 4;
    L6:
        int r0 = StringUtil.getEncodedSize(this.field_2_encoded_url) + 2;
        String[] r4 = this.field_3_sheet_names;
        int r1 = r4.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r0 = r0 + StringUtil.getEncodedSize(r4[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        return r0;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("externalReferences", new $$Lambda$QeqELqGHYnmTIXxjMqKGl9H77NA(this), "internalReferences", new $$Lambda$TdFtVMGoMgAnSsRPT_UenEgebrQ(this), "url", new $$Lambda$Imo9ZIqmoBFJpI3PeuFANQpVtmw(this), "numberOfSheets", new $$Lambda$CJdXBDzYWUjbqOfBxM6TlEuIIlg(this), "sheetNames", new $$Lambda$tBoB6FEkh7uPBR4Rf4FxnLNhxn4(this), "addInFunctions", new $$Lambda$OXdZeDCjExgELmGWtmoHheAFI(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SUP_BOOK;
    }

    public short getNumberOfSheets() {
        return this.field_1_number_of_sheets;
    }

    public String[] getSheetNames() {
        String[] r2 = this.field_3_sheet_names;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (String[]) ZeusTransformUtils.preCheckCast(r2.clone(), String[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 430;
    }

    public String getURL() {
        String r3 = this.field_2_encoded_url;
        if (r3 != null) goto L5;
        return r3;
    L5:
        if (r3.length() < 2) goto L16;
        char r0 = r3.charAt(0);
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L14;
        return r3;
    L12:
        return decodeFileName(r3);
    L14:
        return r3.substring(1);
    L16:
        return r3;
    }

    public boolean isAddInFunctions() {
        if (this.field_3_sheet_names == null) goto L5;
    L7:
        return false;
    L5:
        if (this._isAddInFunctions == false) goto L7;
        return true;
    }

    public boolean isExternalReferences() {
        if (this.field_3_sheet_names == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInternalReferences() {
        if (this.field_3_sheet_names == null) goto L5;
    L7:
        return false;
    L5:
        if (this._isAddInFunctions == true) goto L7;
        return true;
    }
}
