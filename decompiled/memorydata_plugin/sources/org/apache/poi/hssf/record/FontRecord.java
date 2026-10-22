package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FontRecord extends StandardRecord {
    private static final BitField italic = null;
    private static final BitField macoutline = null;
    private static final BitField macshadow = null;
    private static final BitField strikeout = null;
    private String field_11_font_name;
    private short field_1_font_height;
    private short field_2_attributes;
    private short field_3_color_palette_index;
    private short field_4_bold_weight;
    private short field_5_super_sub_script;
    private byte field_6_underline;
    private byte field_7_family;
    private byte field_8_charset;
    private byte field_9_zero;

    static {
        italic = BitFieldFactory.getInstance(2);
        strikeout = BitFieldFactory.getInstance(8);
        macoutline = BitFieldFactory.getInstance(16);
        macshadow = BitFieldFactory.getInstance(32);
    }

    public FontRecord() {
    }

    public FontRecord(RecordInputStream r3) {
        this.field_1_font_height = r3.readShort();
        this.field_2_attributes = r3.readShort();
        this.field_3_color_palette_index = r3.readShort();
        this.field_4_bold_weight = r3.readShort();
        this.field_5_super_sub_script = r3.readShort();
        this.field_6_underline = r3.readByte();
        this.field_7_family = r3.readByte();
        this.field_8_charset = r3.readByte();
        this.field_9_zero = r3.readByte();
        int r0 = r3.readUByte();
        int r1 = r3.readUByte();
        if (r0 <= 0) goto L7;
        if (r1 != 0) goto L6;
        String r4 = r3.readCompressedUnicode(r0);
    L8:
        this.field_11_font_name = r4;
        return;
    L6:
        r4 = r3.readUnicodeLEString(r0);
        goto L8
    L7:
        r4 = "";
        goto L8
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, FontRecord.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (sameProperties((FontRecord) ZeusTransformUtils.preCheckCast(r3, FontRecord.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return true;
    }

    public short getAttributes() {
        return this.field_2_attributes;
    }

    public short getBoldWeight() {
        return this.field_4_bold_weight;
    }

    public byte getCharset() {
        return this.field_8_charset;
    }

    public short getColorPaletteIndex() {
        return this.field_3_color_palette_index;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int r0 = this.field_11_font_name.length();
        int r1 = 1;
        if (r0 >= 1) goto L6;
        return 16;
    L6:
        if (StringUtil.hasMultibyte(this.field_11_font_name) == false) goto L9;
        r1 = 2;
    L9:
        return (r0 * r1) + 16;
    }

    public byte getFamily() {
        return this.field_7_family;
    }

    public short getFontHeight() {
        return this.field_1_font_height;
    }

    public String getFontName() {
        return this.field_11_font_name;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("fontHeight", new $$Lambda$NjORHo7aOu2xtceyF1B9awQ1_Kw(this), "attributes", GenericRecordUtil.getBitsAsString(new $$Lambda$tJeKIkPl9EeImadj86T6cnTnjWU(this), new BitField[]{italic, strikeout, macoutline, macshadow}, new String[]{"ITALIC", "STRIKEOUT", "MACOUTLINE", "MACSHADOW"}), "colorPalette", new $$Lambda$QjkERh8ItYwN2dAYImkIYvYN0XM(this), "boldWeight", new $$Lambda$0WHdr4WSKaUd2B2oVXhWevckQv4(this), "superSubScript", new $$Lambda$bEsAB2uKQPrNpmbIahkKOtBj4hE(this), "underline", new $$Lambda$8MrSizpckaNWqsnoKhoppkSYrE(this), "family", new $$Lambda$yrLH7lSYa_pQ1VS7gNs4Pxz6Y(this), "charset", new $$Lambda$JVb8p7e_P05j8Ogpw7LrvddIDu0(this), "fontName", new $$Lambda$D_YxAonYMaNymRtbjDoTNtm5L88(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FONT;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 49;
    }

    public short getSuperSubScript() {
        return this.field_5_super_sub_script;
    }

    public byte getUnderline() {
        return this.field_6_underline;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.field_1_font_height), Short.valueOf(this.field_2_attributes), Short.valueOf(this.field_3_color_palette_index), Short.valueOf(this.field_4_bold_weight), Short.valueOf(this.field_5_super_sub_script), Byte.valueOf(this.field_6_underline), Byte.valueOf(this.field_7_family), Byte.valueOf(this.field_8_charset), Byte.valueOf(this.field_9_zero), this.field_11_font_name});
    }

    public boolean isItalic() {
        return italic.isSet(this.field_2_attributes);
    }

    public boolean sameProperties(FontRecord r3) {
        if (this.field_1_font_height == r3.field_1_font_height) goto L5;
    L23:
        return false;
    L5:
        if (this.field_2_attributes != r3.field_2_attributes) goto L23;
        if (this.field_3_color_palette_index != r3.field_3_color_palette_index) goto L23;
        if (this.field_4_bold_weight != r3.field_4_bold_weight) goto L23;
        if (this.field_5_super_sub_script != r3.field_5_super_sub_script) goto L23;
        if (this.field_6_underline != r3.field_6_underline) goto L23;
        if (this.field_7_family != r3.field_7_family) goto L23;
        if (this.field_8_charset != r3.field_8_charset) goto L23;
        if (this.field_9_zero != r3.field_9_zero) goto L23;
        if (Objects.equals(this.field_11_font_name, r3.field_11_font_name) == false) goto L23;
        return true;
    }

    public void setAttributes(short r1) {
        this.field_2_attributes = r1;
    }

    public void setBoldWeight(short r1) {
        this.field_4_bold_weight = r1;
    }

    public void setColorPaletteIndex(short r1) {
        this.field_3_color_palette_index = r1;
    }

    public void setFontHeight(short r1) {
        this.field_1_font_height = r1;
    }

    public void setFontName(String r1) {
        this.field_11_font_name = r1;
    }
}
