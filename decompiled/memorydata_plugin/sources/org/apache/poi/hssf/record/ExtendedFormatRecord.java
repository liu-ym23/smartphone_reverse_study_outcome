package org.apache.poi.hssf.record;

import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.MotionEventCompat;
import com.obric.cae.libs.nfc.CaeNfcCardInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ExtendedFormatRecord extends StandardRecord {
    private static final BitField _123_prefix = null;
    private static final BitField _adtl_diag = null;
    private static final BitField _adtl_diag_line_style = null;
    private static final BitField _adtl_fill_pattern = null;
    private static final BitField _alignment = null;
    private static final BitField _border_bottom = null;
    private static final BitField _border_left = null;
    private static final BitField _border_right = null;
    private static final BitField _border_top = null;
    private static final BitField _bottom_border_palette_idx = null;
    private static final BitField _diag = null;
    private static final BitField _fill_background = null;
    private static final BitField _fill_foreground = null;
    private static final BitField _hidden = null;
    private static final BitField _indent = null;
    private static final BitField _indent_not_parent_alignment = null;
    private static final BitField _indent_not_parent_border = null;
    private static final BitField _indent_not_parent_cell_options = null;
    private static final BitField _indent_not_parent_font = null;
    private static final BitField _indent_not_parent_format = null;
    private static final BitField _indent_not_parent_pattern = null;
    private static final BitField _justify_last = null;
    private static final BitField _left_border_palette_idx = null;
    private static final BitField _locked = null;
    private static final BitField _merge_cells = null;
    private static final BitField _parent_index = null;
    private static final BitField _reading_order = null;
    private static final BitField _right_border_palette_idx = null;
    private static final BitField _rotation = null;
    private static final BitField _shrink_to_fit = null;
    private static final BitField _top_border_palette_idx = null;
    private static final BitField _vertical_alignment = null;
    private static final BitField _wrap_text = null;
    private static final BitField _xf_type = null;
    private short field_1_font_index;
    private short field_2_format_index;
    private short field_3_cell_options;
    private short field_4_alignment_options;
    private short field_5_indention_options;
    private short field_6_border_options;
    private short field_7_palette_options;
    private int field_8_adtl_palette_options;
    private short field_9_fill_palette_options;

    static {
        _locked = bf(1);
        _hidden = bf(2);
        _xf_type = bf(4);
        _123_prefix = bf(8);
        _parent_index = bf(65520);
        _alignment = bf(7);
        _wrap_text = bf(8);
        _vertical_alignment = bf(112);
        _justify_last = bf(128);
        _rotation = bf(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        _indent = bf(15);
        _shrink_to_fit = bf(16);
        _merge_cells = bf(32);
        _reading_order = bf(192);
        _indent_not_parent_format = bf(1024);
        _indent_not_parent_font = bf(2048);
        _indent_not_parent_alignment = bf(4096);
        _indent_not_parent_border = bf(8192);
        _indent_not_parent_pattern = bf(16384);
        _indent_not_parent_cell_options = bf(32768);
        _border_left = bf(15);
        _border_right = bf(240);
        _border_top = bf(CaeNfcCardInfo.LIFE_CYCLE_INACTIVE);
        _border_bottom = bf(61440);
        _left_border_palette_idx = bf(127);
        _right_border_palette_idx = bf(16256);
        _diag = bf(49152);
        _top_border_palette_idx = bf(127);
        _bottom_border_palette_idx = bf(16256);
        _adtl_diag = bf(2080768);
        _adtl_diag_line_style = bf(31457280);
        _adtl_fill_pattern = bf(-67108864);
        _fill_foreground = bf(127);
        _fill_background = bf(16256);
    }

    public ExtendedFormatRecord() {
    }

    public ExtendedFormatRecord(RecordInputStream r2) {
        this.field_1_font_index = r2.readShort();
        this.field_2_format_index = r2.readShort();
        this.field_3_cell_options = r2.readShort();
        this.field_4_alignment_options = r2.readShort();
        this.field_5_indention_options = r2.readShort();
        this.field_6_border_options = r2.readShort();
        this.field_7_palette_options = r2.readShort();
        this.field_8_adtl_palette_options = r2.readInt();
        this.field_9_fill_palette_options = r2.readShort();
    }

    private static BitField bf(int r0) {
        return BitFieldFactory.getInstance(r0);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L7;
        return true;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, ExtendedFormatRecord.class) == false) goto L13;
        ExtendedFormatRecord r5 = (ExtendedFormatRecord) ZeusTransformUtils.preCheckCast(r4, ExtendedFormatRecord.class, "com.obric.memorydata.plugin");
        return Arrays.equals(stateSummary(), r5.stateSummary());
    L13:
        return false;
    }

    public short getAdtlDiag() {
        return (short) _adtl_diag.getValue(this.field_8_adtl_palette_options);
    }

    public short getAdtlDiagLineStyle() {
        return (short) _adtl_diag_line_style.getValue(this.field_8_adtl_palette_options);
    }

    public short getAdtlFillPattern() {
        return (short) _adtl_fill_pattern.getValue(this.field_8_adtl_palette_options);
    }

    public int getAdtlPaletteOptions() {
        return this.field_8_adtl_palette_options;
    }

    public short getAlignment() {
        return _alignment.getShortValue(this.field_4_alignment_options);
    }

    public short getAlignmentOptions() {
        return this.field_4_alignment_options;
    }

    public short getBorderBottom() {
        return _border_bottom.getShortValue(this.field_6_border_options);
    }

    public short getBorderLeft() {
        return _border_left.getShortValue(this.field_6_border_options);
    }

    public short getBorderOptions() {
        return this.field_6_border_options;
    }

    public short getBorderRight() {
        return _border_right.getShortValue(this.field_6_border_options);
    }

    public short getBorderTop() {
        return _border_top.getShortValue(this.field_6_border_options);
    }

    public short getBottomBorderPaletteIdx() {
        return (short) _bottom_border_palette_idx.getValue(this.field_8_adtl_palette_options);
    }

    public short getCellOptions() {
        return this.field_3_cell_options;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 20;
    }

    public short getDiag() {
        return _diag.getShortValue(this.field_7_palette_options);
    }

    public short getFillBackground() {
        return _fill_background.getShortValue(this.field_9_fill_palette_options);
    }

    public short getFillForeground() {
        return _fill_foreground.getShortValue(this.field_9_fill_palette_options);
    }

    public short getFillPaletteOptions() {
        return this.field_9_fill_palette_options;
    }

    public short getFontIndex() {
        return this.field_1_font_index;
    }

    public short getFormatIndex() {
        return this.field_2_format_index;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("xfType", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$Ifsj9RjSluvTEiyWlYDyECkkvXk(this), new int[]{0, 1}, new String[]{"CELL", "STYLE"}));
        r0.put("fontIndex", new $$Lambda$DI7rpL_zDgOjA7JqvAowaRAnVA(this));
        r0.put("formatIndex", new $$Lambda$UqdpSAnuZUMNUyUozFVNWyK1IP4(this));
        r0.put("cellOptions", GenericRecordUtil.getBitsAsString(new $$Lambda$HVvyDoIxeA2tqoNJVQdJlZXUUAM(this), new BitField[]{_locked, _hidden, _123_prefix}, new String[]{"LOCKED", "HIDDEN", "LOTUS_123_PREFIX"}));
        r0.put("parentIndex", new $$Lambda$FCZyNGIZ0Jq19Cl5pvkk4rEvhYQ(this));
        r0.put("alignmentOptions", GenericRecordUtil.getBitsAsString(new $$Lambda$NSwWhdhRd9ApD9XuCALgBATCGBA(this), new BitField[]{_wrap_text, _justify_last}, new String[]{"WRAP_TEXT", "JUSTIFY_LAST"}));
        r0.put("alignment", new $$Lambda$TyZ6Sl089nzag0Nbazaa2Gv2a6Y(this));
        r0.put("verticalAlignment", new $$Lambda$cfoZsGtFpBFKUZ_1umEwfa5RC9M(this));
        r0.put(Key.ROTATION, new $$Lambda$0mYsskluXTTaJFfd6O5daHGy5a8(this));
        r0.put("indentionOptions", GenericRecordUtil.getBitsAsString(new $$Lambda$pYTinB6EhUU8Z7LW_4gSEwBT6xU(this), new BitField[]{_shrink_to_fit, _merge_cells, _indent_not_parent_format, _indent_not_parent_font, _indent_not_parent_alignment, _indent_not_parent_border, _indent_not_parent_pattern, _indent_not_parent_cell_options}, new String[]{"SHRINK_TO_FIT", "MERGE_CELLS", "NOT_PARENT_FORMAT", "NOT_PARENT_FONT", "NOT_PARENT_ALIGNMENT", "NOT_PARENT_BORDER", "NOT_PARENT_PATTERN", "NOT_PARENT_CELL_OPTIONS"}));
        r0.put("indent", new $$Lambda$1o9qkwhWMP9vP5xRdaCfKKV5hW0(this));
        r0.put("readingOrder", new $$Lambda$AGnaR7OLb6JVan9MHBsDijdZuQ(this));
        r0.put("borderOptions", new $$Lambda$nnmQhSjlx3QnG3UV25sAO7rrDM8(this));
        r0.put("borderLeft", new $$Lambda$sUE5TdhbknKbtUWWmkIFmcnIsY0(this));
        r0.put("borderRight", new $$Lambda$mj9TXNkNXI5gEcGtYbiQI36NQE(this));
        r0.put("borderTop", new $$Lambda$1PWhwHFdontxuhtKyEOMBmpKjs(this));
        r0.put("borderBottom", new $$Lambda$uD82YchZNjLuyf_xVSAEK72FU(this));
        r0.put("paletteOptions", new $$Lambda$OqCEMxTG9QJUVloIoWYeZKXbgfw(this));
        r0.put("leftBorderPaletteIdx", new $$Lambda$Kkg8liipqJdVArMOIsQXHWKdi4(this));
        r0.put("rightBorderPaletteIdx", new $$Lambda$2624qbCK4PFsWWGwC231HyDKWwU(this));
        r0.put("diag", new $$Lambda$4NjSt0F2POli_zjsJwjvMKVt75g(this));
        r0.put("adtlPaletteOptions", new $$Lambda$X6KEZkr4JUWG2qIC6VE_eAsaqA(this));
        r0.put("topBorderPaletteIdx", new $$Lambda$iAHYepR1DX1alH8rF6f1s8lj0Rc(this));
        r0.put("bottomBorderPaletteIdx", new $$Lambda$303ySE_poU8oUJy0cYky7YTg8(this));
        r0.put("adtlDiag", new $$Lambda$mOcVJWDaXFFSLk78pb8L4zpGMDs(this));
        r0.put("adtlDiagLineStyle", new $$Lambda$6qZw9FhnIq36h9CtKh1CFcsZE(this));
        r0.put("adtlFillPattern", new $$Lambda$yZqkd2NOip5g82agytXRGIKvYTs(this));
        r0.put("fillPaletteOptions", new $$Lambda$smvsrxn6OZ58i5rvTqeYQaz3p7c(this));
        r0.put("fillForeground", new $$Lambda$akGrJ4YDlLdzGQATcPYIILQi3Z4(this));
        r0.put("fillBackground", new $$Lambda$AiPclGd_Hv5dWjYmb2E7dG6VA(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXTENDED_FORMAT;
    }

    public short getIndent() {
        return _indent.getShortValue(this.field_5_indention_options);
    }

    public short getIndentionOptions() {
        return this.field_5_indention_options;
    }

    public short getLeftBorderPaletteIdx() {
        return _left_border_palette_idx.getShortValue(this.field_7_palette_options);
    }

    public short getPaletteOptions() {
        return this.field_7_palette_options;
    }

    public short getParentIndex() {
        return _parent_index.getShortValue(this.field_3_cell_options);
    }

    public short getReadingOrder() {
        return _reading_order.getShortValue(this.field_5_indention_options);
    }

    public short getRightBorderPaletteIdx() {
        return _right_border_palette_idx.getShortValue(this.field_7_palette_options);
    }

    public short getRotation() {
        return _rotation.getShortValue(this.field_4_alignment_options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 224;
    }

    public short getTopBorderPaletteIdx() {
        return (short) _top_border_palette_idx.getValue(this.field_8_adtl_palette_options);
    }

    public short getVerticalAlignment() {
        return _vertical_alignment.getShortValue(this.field_4_alignment_options);
    }

    public short getXFType() {
        return _xf_type.getShortValue(this.field_3_cell_options);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.field_1_font_index), Short.valueOf(this.field_2_format_index), Short.valueOf(this.field_3_cell_options), Short.valueOf(this.field_4_alignment_options), Short.valueOf(this.field_5_indention_options), Short.valueOf(this.field_6_border_options), Short.valueOf(this.field_7_palette_options), Integer.valueOf(this.field_8_adtl_palette_options), Short.valueOf(this.field_9_fill_palette_options)});
    }

    public void setAdtlPaletteOptions(short r1) {
        this.field_8_adtl_palette_options = r1;
    }

    public void setAlignmentOptions(short r1) {
        this.field_4_alignment_options = r1;
    }

    public void setBorderOptions(short r1) {
        this.field_6_border_options = r1;
    }

    public void setCellOptions(short r1) {
        this.field_3_cell_options = r1;
    }

    public void setFillPaletteOptions(short r1) {
        this.field_9_fill_palette_options = r1;
    }

    public void setFontIndex(short r1) {
        this.field_1_font_index = r1;
    }

    public void setFormatIndex(short r1) {
        this.field_2_format_index = r1;
    }

    public void setIndentionOptions(short r1) {
        this.field_5_indention_options = r1;
    }

    public void setPaletteOptions(short r1) {
        this.field_7_palette_options = r1;
    }

    public int[] stateSummary() {
        return new int[]{this.field_1_font_index, this.field_2_format_index, this.field_3_cell_options, this.field_4_alignment_options, this.field_5_indention_options, this.field_6_border_options, this.field_7_palette_options, this.field_8_adtl_palette_options, this.field_9_fill_palette_options};
    }
}
