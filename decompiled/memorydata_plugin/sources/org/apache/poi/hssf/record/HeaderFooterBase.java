package org.apache.poi.hssf.record;

import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HeaderFooterBase extends StandardRecord {
    private boolean field_2_hasMultibyte;
    private String field_3_text;

    public HeaderFooterBase(String r1) {
        setText(r1);
    }

    public HeaderFooterBase(RecordInputStream r3) {
        if (r3.remaining() <= 0) goto L18;
        short r0 = r3.readShort();
        if (r0 != 0) goto L10;
        this.field_3_text = "";
        if (r3.remaining() != 0) goto L10;
        return;
    L10:
        if (r3.readByte() == 0) goto L12;
        boolean r1 = true;
    L13:
        this.field_2_hasMultibyte = r1;
        if (r1 == false) goto L16;
        String r4 = r3.readUnicodeLEString(r0);
    L17:
        this.field_3_text = r4;
        return;
    L16:
        r4 = r3.readCompressedUnicode(r0);
        goto L17
    L12:
        r1 = false;
        goto L13
    L18:
        this.field_3_text = "";
    }

    private int getTextLength() {
        return this.field_3_text.length();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final int getDataSize() {
        int r1 = 1;
        if (getTextLength() >= 1) goto L6;
        return 0;
    L6:
        int r0 = getTextLength();
        if (this.field_2_hasMultibyte == false) goto L10;
        r1 = 2;
    L10:
        return (r0 * r1) + 3;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, new $$Lambda$NqGXr1cwBadffTpikgfCPABE3oM(this));
    }

    public final String getText() {
        return this.field_3_text;
    }

    public final void setText(String r2) {
        if (r2 == null) goto L9;
        this.field_2_hasMultibyte = StringUtil.hasMultibyte(r2);
        this.field_3_text = r2;
        if (getDataSize() > 8224) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Header/Footer string too long (limit is 8224 bytes)");
    L9:
        throw new IllegalArgumentException("text must not be null");
    }
}
