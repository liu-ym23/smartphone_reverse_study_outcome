package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class WindowOneRecord extends StandardRecord {
    private static final BitField hidden = null;
    private static final BitField hscroll = null;
    private static final BitField iconic = null;
    private static final BitField reserved = null;
    private static final BitField tabs = null;
    private static final BitField vscroll = null;
    private short field_1_h_hold;
    private short field_2_v_hold;
    private short field_3_width;
    private short field_4_height;
    private short field_5_options;
    private int field_6_active_sheet;
    private int field_7_first_visible_tab;
    private short field_8_num_selected_tabs;
    private short field_9_tab_width_ratio;

    static {
        hidden = BitFieldFactory.getInstance(1);
        iconic = BitFieldFactory.getInstance(2);
        reserved = BitFieldFactory.getInstance(4);
        hscroll = BitFieldFactory.getInstance(8);
        vscroll = BitFieldFactory.getInstance(16);
        tabs = BitFieldFactory.getInstance(32);
    }

    public WindowOneRecord() {
    }

    public WindowOneRecord(RecordInputStream r2) {
        this.field_1_h_hold = r2.readShort();
        this.field_2_v_hold = r2.readShort();
        this.field_3_width = r2.readShort();
        this.field_4_height = r2.readShort();
        this.field_5_options = r2.readShort();
        this.field_6_active_sheet = r2.readShort();
        this.field_7_first_visible_tab = r2.readShort();
        this.field_8_num_selected_tabs = r2.readShort();
        this.field_9_tab_width_ratio = r2.readShort();
    }

    public int getActiveSheetIndex() {
        return this.field_6_active_sheet;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    public int getFirstVisibleTab() {
        return this.field_7_first_visible_tab;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("horizontalHold", new $$Lambda$gKw8rVNJClHKN8CZml4Vm7OGKA(this), "verticalHold", new $$Lambda$vlRmfv5whL6cXNALmuDnKvVGk0k(this), "width", new $$Lambda$IU8tPMbbALS8f6AAekNnRmRkUE(this), "options", GenericRecordUtil.getBitsAsString(new $$Lambda$17NbBbqlKWkbD8391pmTpuN1P0(this), new BitField[]{hidden, iconic, reserved, hscroll, vscroll, tabs}, new String[]{"HIDDEN", "ICONIC", "RESERVED", "HSCROLL", "VSCROLL", "TABS"}), "activeSheetIndex", new $$Lambda$dTM6wBCLUrYx80S4oJ3spwqUZUU(this), "firstVisibleTab", new $$Lambda$UJAQE3s3rxfIbdxXlBpyK1v9Yfc(this), "numSelectedTabs", new $$Lambda$enaXOOx1dfrVO6p63yxiMKCpk(this), "tabWidthRatio", new $$Lambda$CCq2eV37c6ReEoSFY4zZDJxzqFM(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WINDOW_ONE;
    }

    public short getHorizontalHold() {
        return this.field_1_h_hold;
    }

    public short getNumSelectedTabs() {
        return this.field_8_num_selected_tabs;
    }

    public short getOptions() {
        return this.field_5_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 61;
    }

    public short getTabWidthRatio() {
        return this.field_9_tab_width_ratio;
    }

    public short getVerticalHold() {
        return this.field_2_v_hold;
    }

    public short getWidth() {
        return this.field_3_width;
    }

    public void setActiveSheetIndex(int r1) {
        this.field_6_active_sheet = r1;
    }

    public void setFirstVisibleTab(int r1) {
        this.field_7_first_visible_tab = r1;
    }

    public void setHeight(short r1) {
        this.field_4_height = r1;
    }

    public void setHorizontalHold(short r1) {
        this.field_1_h_hold = r1;
    }

    public void setNumSelectedTabs(short r1) {
        this.field_8_num_selected_tabs = r1;
    }

    public void setOptions(short r1) {
        this.field_5_options = r1;
    }

    public void setTabWidthRatio(short r1) {
        this.field_9_tab_width_ratio = r1;
    }

    public void setVerticalHold(short r1) {
        this.field_2_v_hold = r1;
    }

    public void setWidth(short r1) {
        this.field_3_width = r1;
    }
}
