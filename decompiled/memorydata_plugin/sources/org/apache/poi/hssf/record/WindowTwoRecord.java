package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class WindowTwoRecord extends StandardRecord {
    private static final BitField active = null;
    private static final BitField arabic = null;
    private static final BitField defaultHeader = null;
    private static final BitField displayFormulas = null;
    private static final BitField displayGridlines = null;
    private static final BitField displayGuts = null;
    private static final BitField displayRowColHeadings = null;
    private static final BitField displayZeros = null;
    private static final BitField freezePanes = null;
    private static final BitField freezePanesNoSplit = null;
    private static final BitField savedInPageBreakPreview = null;
    private static final BitField selected = null;
    private short field_1_options;
    private short field_2_top_row;
    private short field_3_left_col;
    private int field_4_header_color;
    private short field_5_page_break_zoom;
    private short field_6_normal_zoom;
    private int field_7_reserved;

    static {
        displayFormulas = BitFieldFactory.getInstance(1);
        displayGridlines = BitFieldFactory.getInstance(2);
        displayRowColHeadings = BitFieldFactory.getInstance(4);
        freezePanes = BitFieldFactory.getInstance(8);
        displayZeros = BitFieldFactory.getInstance(16);
        defaultHeader = BitFieldFactory.getInstance(32);
        arabic = BitFieldFactory.getInstance(64);
        displayGuts = BitFieldFactory.getInstance(128);
        freezePanesNoSplit = BitFieldFactory.getInstance(256);
        selected = BitFieldFactory.getInstance(512);
        active = BitFieldFactory.getInstance(1024);
        savedInPageBreakPreview = BitFieldFactory.getInstance(2048);
    }

    public WindowTwoRecord() {
    }

    public WindowTwoRecord(RecordInputStream r3) {
        int r0 = r3.remaining();
        this.field_1_options = r3.readShort();
        this.field_2_top_row = r3.readShort();
        this.field_3_left_col = r3.readShort();
        this.field_4_header_color = r3.readInt();
        if (r0 <= 10) goto L6;
        this.field_5_page_break_zoom = r3.readShort();
        this.field_6_normal_zoom = r3.readShort();
    L6:
        if (r0 <= 14) goto L9;
        this.field_7_reserved = r3.readInt();
        return;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", GenericRecordUtil.getBitsAsString(new $$Lambda$16wNUtS82V8SMpXfhTXtpQ1IU8(this), new BitField[]{displayFormulas, displayGridlines, displayRowColHeadings, freezePanes, displayZeros, defaultHeader, arabic, displayGuts, freezePanesNoSplit, selected, active, savedInPageBreakPreview}, new String[]{"DISPLAY_FORMULAS", "DISPLAY_GRIDLINES", "DISPLAY_ROW_COL_HEADINGS", "FREEZE_PANES", "DISPLAY_ZEROS", "DEFAULT_HEADER", "ARABIC", "DISPLAY_GUTS", "FREEZE_PANES_NO_SPLIT", "SELECTED", "ACTIVE", "SAVED_IN_PAGE_BREAK_PREVIEW"}), "topRow", new $$Lambda$PT74_CcrN3UN8fhrGyiX5ukFbLk(this), "leftCol", new $$Lambda$1S0NonEal9Hf33kwDWCCSMGFw(this), "headerColor", new $$Lambda$DB4Kkuk9YsiKaxQKm58QgADxrmw(this), "pageBreakZoom", new $$Lambda$v42ZJbyYYXPwHdsuZe2h9DLUFas(this), "normalZoom", new $$Lambda$osdA13UyhYabDlD0SNBIhIhpy4(this), "reserved", new $$Lambda$fvVENJ95UHTE947qJ9IMEZ5FZU(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WINDOW_TWO;
    }

    public int getHeaderColor() {
        return this.field_4_header_color;
    }

    public short getLeftCol() {
        return this.field_3_left_col;
    }

    public short getNormalZoom() {
        return this.field_6_normal_zoom;
    }

    public short getOptions() {
        return this.field_1_options;
    }

    public short getPageBreakZoom() {
        return this.field_5_page_break_zoom;
    }

    public int getReserved() {
        return this.field_7_reserved;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 574;
    }

    public short getTopRow() {
        return this.field_2_top_row;
    }

    public void setActive(boolean r3) {
        this.field_1_options = active.setShortBoolean(this.field_1_options, r3);
    }

    public void setHeaderColor(int r1) {
        this.field_4_header_color = r1;
    }

    public void setLeftCol(short r1) {
        this.field_3_left_col = r1;
    }

    public void setNormalZoom(short r1) {
        this.field_6_normal_zoom = r1;
    }

    public void setOptions(short r1) {
        this.field_1_options = r1;
    }

    public void setPageBreakZoom(short r1) {
        this.field_5_page_break_zoom = r1;
    }

    public void setSelected(boolean r3) {
        this.field_1_options = selected.setShortBoolean(this.field_1_options, r3);
    }

    public void setTopRow(short r1) {
        this.field_2_top_row = r1;
    }
}
