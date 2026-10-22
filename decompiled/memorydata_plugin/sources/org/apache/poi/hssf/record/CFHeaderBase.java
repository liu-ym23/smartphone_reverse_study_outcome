package org.apache.poi.hssf.record;

import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CFHeaderBase extends StandardRecord {
    private int field_1_numcf;
    private int field_2_need_recalculation_and_id;
    private CellRangeAddress field_3_enclosing_cell_range;
    private CellRangeAddressList field_4_cell_ranges;

    public CFHeaderBase() {
    }

    public void createEmpty() {
        this.field_3_enclosing_cell_range = new CellRangeAddress(0, 0, 0, 0);
        this.field_4_cell_ranges = new CellRangeAddressList();
    }

    public CellRangeAddress[] getCellRanges() {
        return this.field_4_cell_ranges.getCellRangeAddresses();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.field_4_cell_ranges.getSize() + 12;
    }

    public CellRangeAddress getEnclosingCellRange() {
        return this.field_3_enclosing_cell_range;
    }

    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(OaidModel.KEY_ID, new $$Lambda$KzbXyW4sCTqFvPxK1bp86g5eJs(this), "numCF", new $$Lambda$anHuqPsQRInJ7jE3d0KcaaZy5Wg(this), "needRecalculationAndId", new $$Lambda$6QupzenmzY3T7bOmxmMvqm25VM(this), "enclosingCellRange", new $$Lambda$kF5WtRNzypWmB9vxcRaXq8CwOfo(this), "cfRanges", new $$Lambda$L4m1qztRaM2aYUfW9aWxrjifiJg(this));
    }

    public int getID() {
        return this.field_2_need_recalculation_and_id >> 1;
    }

    public boolean getNeedRecalculation() {
        if ((this.field_2_need_recalculation_and_id & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getNumberOfConditionalFormats() {
        return this.field_1_numcf;
    }

    public void read(RecordInputStream r2) {
        this.field_1_numcf = r2.readShort();
        this.field_2_need_recalculation_and_id = r2.readShort();
        this.field_3_enclosing_cell_range = new CellRangeAddress(r2);
        this.field_4_cell_ranges = new CellRangeAddressList(r2);
    }
}
