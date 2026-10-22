package org.apache.poi.hslf.record;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CString extends RecordAtom {
    private byte[] _header;
    private byte[] _text;

    public CString() {
        this._header = new byte[]{0, 0, -70, 15, 0, 0, 0, 0};
        this._text = new byte[0];
    }

    public CString(byte[] r3, int r4, int r5) {
        if (r5 >= 8) goto L5;
        r5 = 8;
    L5:
        int r1 = r4 + 8;
        this._header = Arrays.copyOfRange(r3, r4, r1);
        this._text = IOUtils.safelyClone(r3, r1, r5 - 8, getMaxRecordLength());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, new $$Lambda$QI3y2NankkIJn_puM41ZZoLT4nY(this));
    }

    public int getOptions() {
        return LittleEndian.getShort(this._header);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.CString.typeID;
    }

    public String getText() {
        return StringUtil.getFromUnicodeLE(this._text);
    }

    public void setOptions(int r2) {
        LittleEndian.putShort(this._header, 0, (short) r2);
    }

    public String toString() {
        return getText();
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._text);
    }
}
