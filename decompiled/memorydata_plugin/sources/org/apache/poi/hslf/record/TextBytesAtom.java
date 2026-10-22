package org.apache.poi.hslf.record;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class TextBytesAtom extends RecordAtom {
    public static final long _type = 0;
    private byte[] _header;
    private byte[] _text;

    static {
        _type = RecordTypes.TextBytesAtom.typeID;
    }

    public TextBytesAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUShort(r0, 0, 0);
        LittleEndian.putUShort(this._header, 2, (int) _type);
        LittleEndian.putInt(this._header, 4, 0);
        this._text = new byte[0];
    }

    public TextBytesAtom(byte[] r3, int r4, int r5) {
        if (r5 >= 8) goto L5;
        r5 = 8;
    L5:
        int r1 = r4 + 8;
        this._header = Arrays.copyOfRange(r3, r4, r1);
        this._text = IOUtils.safelyClone(r3, r1, r5 - 8, getMaxRecordLength());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, new $$Lambda$lGR9jVCuALhDp5QHhxm0gYG3ldQ(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public String getText() {
        byte[] r2 = this._text;
        return StringUtil.getFromCompressedUnicode(r2, 0, r2.length);
    }

    public void setText(byte[] r3) {
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        this._text = r4;
        LittleEndian.putInt(this._header, 4, r4.length);
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._text);
    }
}
