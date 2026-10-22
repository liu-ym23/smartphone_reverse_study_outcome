package org.apache.poi.hssf.record;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PrintSetupRecord extends StandardRecord {
    private static final BitField draft = null;
    private static final BitField landscape = null;
    private static final BitField lefttoright = null;
    private static final BitField noOrientation = null;
    private static final BitField nocolor = null;
    private static final BitField notes = null;
    private static final BitField usepage = null;
    private static final BitField validsettings = null;
    private double field_10_footermargin;
    private short field_11_copies;
    private short field_1_paper_size;
    private short field_2_scale;
    private short field_3_page_start;
    private short field_4_fit_width;
    private short field_5_fit_height;
    private short field_6_options;
    private short field_7_hresolution;
    private short field_8_vresolution;
    private double field_9_headermargin;

    static {
        lefttoright = BitFieldFactory.getInstance(1);
        landscape = BitFieldFactory.getInstance(2);
        validsettings = BitFieldFactory.getInstance(4);
        nocolor = BitFieldFactory.getInstance(8);
        draft = BitFieldFactory.getInstance(16);
        notes = BitFieldFactory.getInstance(32);
        noOrientation = BitFieldFactory.getInstance(64);
        usepage = BitFieldFactory.getInstance(128);
    }

    public PrintSetupRecord() {
    }

    public PrintSetupRecord(RecordInputStream r3) {
        this.field_1_paper_size = r3.readShort();
        this.field_2_scale = r3.readShort();
        this.field_3_page_start = r3.readShort();
        this.field_4_fit_width = r3.readShort();
        this.field_5_fit_height = r3.readShort();
        this.field_6_options = r3.readShort();
        this.field_7_hresolution = r3.readShort();
        this.field_8_vresolution = r3.readShort();
        this.field_9_headermargin = r3.readDouble();
        this.field_10_footermargin = r3.readDouble();
        this.field_11_copies = r3.readShort();
    }

    public short getCopies() {
        return this.field_11_copies;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 34;
    }

    public short getFitHeight() {
        return this.field_5_fit_height;
    }

    public short getFitWidth() {
        return this.field_4_fit_width;
    }

    public double getFooterMargin() {
        return this.field_10_footermargin;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("paperSize", new $$Lambda$U68jY7yGFQmP9USeOCv6ziCfO4(this));
        r0.put("scale", new $$Lambda$mpNZ9LzZFnu2u7aztcpGiNMm1kk(this));
        r0.put("pageStart", new $$Lambda$T0r806H40q4OxrEPlkF9SoEMKN8(this));
        r0.put("fitWidth", new $$Lambda$TCBkbFaUaYd6NmoGtRY94OwOIMs(this));
        r0.put("fitHeight", new $$Lambda$Ufw2w96qstp9Eskgxr7O_mB9rE(this));
        r0.put("options", GenericRecordUtil.getBitsAsString(new $$Lambda$16p_u5WpE49SYEUT4Llz1F8pzeY(this), new BitField[]{lefttoright, landscape, validsettings, nocolor, draft, notes, noOrientation, usepage}, new String[]{"lefttoright", "landscape", "validsettings", "nocolor", "draft", "notes", "noOrientation", "usepage"}));
        r0.put("hResolution", new $$Lambda$lTI79FtGN_9fLnJ4Is9sb4e6Ris(this));
        r0.put("vResolution", new $$Lambda$oUKHNVblDWsuFKR7rSsshcuW6PM(this));
        r0.put("headerMargin", new $$Lambda$f8OoAhTK7ngZbBwZKzJUTl7hyE(this));
        r0.put("footerMargin", new $$Lambda$L8UQxIZF2AUATATrTr93nJ5IOo(this));
        r0.put("copies", new $$Lambda$CKsvL9mAFYhkHdTYsMz9iDNuI(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PRINT_SETUP;
    }

    public short getHResolution() {
        return this.field_7_hresolution;
    }

    public double getHeaderMargin() {
        return this.field_9_headermargin;
    }

    public short getOptions() {
        return this.field_6_options;
    }

    public short getPageStart() {
        return this.field_3_page_start;
    }

    public short getPaperSize() {
        return this.field_1_paper_size;
    }

    public short getScale() {
        return this.field_2_scale;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 161;
    }

    public short getVResolution() {
        return this.field_8_vresolution;
    }

    public void setCopies(short r1) {
        this.field_11_copies = r1;
    }

    public void setFitHeight(short r1) {
        this.field_5_fit_height = r1;
    }

    public void setFitWidth(short r1) {
        this.field_4_fit_width = r1;
    }

    public void setFooterMargin(double r1) {
        this.field_10_footermargin = r1;
    }

    public void setHResolution(short r1) {
        this.field_7_hresolution = r1;
    }

    public void setHeaderMargin(double r1) {
        this.field_9_headermargin = r1;
    }

    public void setOptions(short r1) {
        this.field_6_options = r1;
    }

    public void setPageStart(short r1) {
        this.field_3_page_start = r1;
    }

    public void setPaperSize(short r1) {
        this.field_1_paper_size = r1;
    }

    public void setScale(short r1) {
        this.field_2_scale = r1;
    }

    public void setVResolution(short r1) {
        this.field_8_vresolution = r1;
    }
}
