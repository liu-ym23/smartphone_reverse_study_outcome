package org.apache.poi.hssf.record;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.cont.ContinuableRecord;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class StringRecord extends ContinuableRecord {
    private boolean _is16bitUnicode;
    private String _text;

    public StringRecord() {
    }

    public StringRecord(RecordInputStream r3) {
        int r0 = r3.readUShort();
        if (r3.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this._is16bitUnicode = r1;
        if (r1 == false) goto L9;
        String r4 = r3.readUnicodeLEString(r0);
    L10:
        this._text = r4;
        return;
    L9:
        r4 = r3.readCompressedUnicode(r0);
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("is16bitUnicode", new $$Lambda$StringRecord$v09X4T3ZzURNINJSI0pfvIMHBhA(this), IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, new $$Lambda$717QuYkYDnKLvdDjgwWtzyJoCk(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.STRING;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 519;
    }

    public String getString() {
        return this._text;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$StringRecord() {
        return Boolean.valueOf(this._is16bitUnicode);
    }

    @Override // org.apache.poi.hssf.record.cont.ContinuableRecord
    public void serialize(ContinuableRecordOutput r2) {
        r2.writeShort(this._text.length());
        r2.writeStringData(this._text);
    }

    public void setString(String r1) {
        this._text = r1;
        this._is16bitUnicode = StringUtil.hasMultibyte(r1);
    }
}
