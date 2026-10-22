package org.apache.poi.ss.formula.ptg;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import kotlin.text.Typography;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class StringPtg extends ScalarConstantPtg {
    private final boolean _is16bitUnicode;
    private final String field_3_string;

    public StringPtg(String r3) {
        if (r3.length() > 255) goto L7;
        this._is16bitUnicode = StringUtil.hasMultibyte(r3);
        this.field_3_string = r3;
        return;
    L7:
        throw new IllegalArgumentException("String literals in formulas can't be bigger than 255 characters ASCII");
    }

    public StringPtg(LittleEndianInput r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r0 = r5.readUByte();
        boolean r2 = true;
        if ((r5.readByte() & 1) != 0) goto L6;
        r2 = false;
    L6:
        this._is16bitUnicode = r2;
        if (r2 == false) goto L9;
        String r6 = StringUtil.readUnicodeLE(r5, r0);
    L10:
        this.field_3_string = r6;
        return;
    L9:
        r6 = StringUtil.readCompressedUnicode(r5, r0);
        goto L10
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(EventBody.KEY_VALUE, new $$Lambda$Tegs8FmWYGPnh2fZzFSCHslcKYA(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 23;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        int r0 = this.field_3_string.length();
        if (this._is16bitUnicode == false) goto L5;
        int r1 = 2;
    L7:
        return (r0 * r1) + 3;
    L5:
        r1 = 1;
        goto L7
    }

    public String getValue() {
        return this.field_3_string;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        String r5 = this.field_3_string;
        int r0 = r5.length();
        StringBuilder r1 = new StringBuilder(r0 + 4);
        r1.append(Typography.quote);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        char r4 = r5.charAt(r3);
        if (r4 != '\"') goto L7;
        r1.append(Typography.quote);
    L7:
        r1.append(r4);
        r3 = r3 + 1;
        goto L3
    L8:
        r1.append(Typography.quote);
        return r1.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 23);
        r4.writeByte(this.field_3_string.length());
        r4.writeByte(this._is16bitUnicode ? 1 : 0);
        boolean r0 = this._is16bitUnicode;
        String r2 = this.field_3_string;
        if (r0 == false) goto L5;
        StringUtil.putUnicodeLE(r2, r4);
        return;
    L5:
        StringUtil.putCompressedUnicode(r2, r4);
    }
}
