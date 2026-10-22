package org.apache.poi.hssf.record.cf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class PatternFormatting implements GenericRecord {
    private static final BitField fillPatternStyle = null;
    private static final BitField patternBackgroundColorIndex = null;
    private static final BitField patternColorIndex = null;
    private int field_15_pattern_style;
    private int field_16_pattern_color_indexes;

    static {
        fillPatternStyle = BitFieldFactory.getInstance(64512);
        patternColorIndex = BitFieldFactory.getInstance(127);
        patternBackgroundColorIndex = BitFieldFactory.getInstance(16256);
    }

    public PatternFormatting() {
        this.field_15_pattern_style = 0;
        this.field_16_pattern_color_indexes = 0;
    }

    public PatternFormatting(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_15_pattern_style = r4.readUShort();
        this.field_16_pattern_color_indexes = r4.readUShort();
    }

    public int getDataLength() {
        return 4;
    }

    public int getFillForegroundColor() {
        return patternColorIndex.getValue(this.field_16_pattern_color_indexes);
    }

    public int getFillPattern() {
        return fillPatternStyle.getValue(this.field_15_pattern_style);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("fillPattern", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$KltMeAblr20trlI0YemhcdWtwJQ(this), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, new String[]{"NO_FILL", "SOLID_FOREGROUND", "FINE_DOTS", "ALT_BARS", "SPARSE_DOTS", "THICK_HORZ_BANDS", "THICK_VERT_BANDS", "THICK_BACKWARD_DIAG", "THICK_FORWARD_DIAG", "BIG_SPOTS", "BRICKS", "THIN_HORZ_BANDS", "THIN_VERT_BANDS", "THIN_BACKWARD_DIAG", "THIN_FORWARD_DIAG", "SQUARES", "DIAMONDS", "LESS_DOTS", "LEAST_DOTS"}), "fillForegroundColor", new $$Lambda$9tBjH5GytfU4LYez2zVi2Bn7ukw(this), "fillBackgroundColor", new $$Lambda$9tBjH5GytfU4LYez2zVi2Bn7ukw(this));
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
