package org.apache.poi.hssf.record;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class StyleRecord extends StandardRecord {
    private static final BitField isBuiltinFlag = null;
    private static final BitField styleIndexMask = null;
    private int field_1_xf_index;
    private int field_2_builtin_style;
    private int field_3_outline_style_level;
    private boolean field_3_stringHasMultibyte;
    private String field_4_name;

    static {
        styleIndexMask = BitFieldFactory.getInstance(4095);
        isBuiltinFlag = BitFieldFactory.getInstance(32768);
    }

    public StyleRecord() {
        this.field_1_xf_index = isBuiltinFlag.set(0);
    }

    public StyleRecord(RecordInputStream r4) {
        this.field_1_xf_index = r4.readShort();
        if (isBuiltin() == false) goto L5;
        this.field_2_builtin_style = r4.readByte();
        this.field_3_outline_style_level = r4.readByte();
        return;
    L5:
        short r0 = r4.readShort();
        boolean r2 = true;
        if (r4.remaining() >= 1) goto L13;
        if (r0 != 0) goto L11;
        String r5 = "";
    L9:
        this.field_4_name = r5;
        return;
    L11:
        throw new RecordFormatException("Ran out of data reading style record");
    L13:
        if (r4.readByte() != 0) goto L16;
        r2 = false;
    L16:
        this.field_3_stringHasMultibyte = r2;
        if (r2 == false) goto L19;
        r5 = StringUtil.readUnicodeLE(r4, r0);
        goto L9
    L19:
        r5 = StringUtil.readCompressedUnicode(r4, r0);
        goto L9
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        if (isBuiltin() == false) goto L6;
        return 4;
    L6:
        int r0 = this.field_4_name.length();
        if (this.field_3_stringHasMultibyte == false) goto L9;
        int r1 = 2;
    L11:
        return (r0 * r1) + 5;
    L9:
        r1 = 1;
        goto L11
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("xfIndex", new $$Lambda$xlSz32EFHD2kqXaCSktK4RvT6I(this), "type", new $$Lambda$StyleRecord$bFzf4UZoQXLncqJyxos6hJXiwCU(this), "builtin_style", new $$Lambda$StyleRecord$lG1lq3aLHUwwBYY7GbK23ZhFzd0(this), "outline_level", new $$Lambda$StyleRecord$pcGsYOdnsmPha8c17RncsjcwJe0(this), ActivityLifecycle.NAME, new $$Lambda$Jj4XFWGpmi5P49MvnsTjxECnpI(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.STYLE;
    }

    public String getName() {
        return this.field_4_name;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 659;
    }

    public int getXFIndex() {
        return styleIndexMask.getValue(this.field_1_xf_index);
    }

    public boolean isBuiltin() {
        return isBuiltinFlag.isSet(this.field_1_xf_index);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$StyleRecord() {
        if (isBuiltin() == false) goto L5;
        return "built-in";
    L5:
        return "user-defined";
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$StyleRecord() {
        return Integer.valueOf(this.field_2_builtin_style);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$StyleRecord() {
        return Integer.valueOf(this.field_3_outline_style_level);
    }

    public void setBuiltinStyle(int r3) {
        this.field_1_xf_index = isBuiltinFlag.set(this.field_1_xf_index);
        this.field_2_builtin_style = r3;
    }

    public void setOutlineStyleLevel(int r1) {
        this.field_3_outline_style_level = r1 & 255;
    }

    public void setXFIndex(int r3) {
        this.field_1_xf_index = styleIndexMask.setValue(this.field_1_xf_index, r3);
    }
}
