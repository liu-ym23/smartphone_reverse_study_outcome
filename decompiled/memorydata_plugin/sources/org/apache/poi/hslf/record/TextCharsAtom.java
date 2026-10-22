package org.apache.poi.hslf.record;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.StringUtil;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public final class TextCharsAtom extends RecordAtom {
    public static final long _type = 0;
    private byte[] _header;
    private byte[] _text;

    static {
        _type = RecordTypes.TextCharsAtom.typeID;
    }

    public TextCharsAtom() {
        this._header = new byte[]{0, 0, MessagePack.Code.FIXSTR_PREFIX, 15, 0, 0, 0, 0};
        this._text = new byte[0];
    }

    public TextCharsAtom(byte[] r3, int r4, int r5) {
        if (r5 >= 8) goto L5;
        r5 = 8;
    L5:
        int r1 = r4 + 8;
        this._header = Arrays.copyOfRange(r3, r4, r1);
        this._text = IOUtils.safelyClone(r3, r1, r5 - 8, getMaxRecordLength());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, new $$Lambda$kaHzI0kBIueztfrNvFFfMxlDL4s(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public String getText() {
        return StringUtil.getFromUnicodeLE(this._text);
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
