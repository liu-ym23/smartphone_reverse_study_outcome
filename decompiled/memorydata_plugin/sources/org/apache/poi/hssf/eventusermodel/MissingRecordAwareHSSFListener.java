package org.apache.poi.hssf.eventusermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingRowDummyRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.MulRKRecord;
import org.apache.poi.hssf.record.NoteRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.StringRecord;

/* JADX INFO: loaded from: classes7.dex */
public final class MissingRecordAwareHSSFListener implements HSSFListener {
    private HSSFListener childListener;
    private int lastCellColumn;
    private int lastCellRow;
    private int lastRowRow;

    public MissingRecordAwareHSSFListener(HSSFListener r3) {
        HSSFListener r4 = (HSSFListener) ZeusTransformUtils.wrapperContextForParams(r3, HSSFListener.class, "com.obric.memorydata.plugin");
        resetCounts();
        this.childListener = r4;
    }

    private void resetCounts() {
        this.lastRowRow = -1;
        this.lastCellRow = -1;
        this.lastCellColumn = -1;
    }

    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record r11) {
        CellValueRecordInterface[] r3 = null;
        if (ZeusTransformUtils.instanceOf(r11, CellValueRecordInterface.class) == false) goto L6;
        CellValueRecordInterface r0 = (CellValueRecordInterface) ZeusTransformUtils.preCheckCast(r11, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        int r4 = r0.getRow();
        int r1 = r0.getColumn();
    L38:
        int r5 = 0;
        if (r3 != null) goto L41;
    L43:
        int r6 = this.lastCellRow;
        if (r4 == r6) goto L56;
        if (r4 <= 0) goto L56;
        if (r6 != (-1)) goto L48;
        this.lastCellRow = 0;
    L48:
        int r7 = this.lastCellRow;
    L49:
        if (r7 >= r4) goto L56;
        if (r7 != this.lastCellRow) goto L53;
        int r8 = this.lastCellColumn;
    L54:
        this.childListener.processRecord(new LastCellOfRowDummyRecord(r7, r8));
        r7 = r7 + 1;
        goto L49
    L53:
        r8 = -1;
    L56:
        if (this.lastCellRow == (-1)) goto L62;
        if (this.lastCellColumn == (-1)) goto L62;
        if (r4 != (-1)) goto L62;
        this.childListener.processRecord(new LastCellOfRowDummyRecord(this.lastCellRow, this.lastCellColumn));
        this.lastCellRow = -1;
        this.lastCellColumn = -1;
    L62:
        if (r4 == this.lastCellRow) goto L64;
        this.lastCellColumn = -1;
    L64:
        int r9 = this.lastCellColumn;
        if (r9 == (r1 - 1)) goto L69;
    L66:
        r9 = r9 + 1;
        if (r9 >= r1) goto L69;
        this.childListener.processRecord(new MissingCellDummyRecord(r4, r9));
    L69:
        if (r3 != null) goto L71;
    L73:
        if (r1 == (-1)) goto L75;
        this.lastCellColumn = r1;
        this.lastCellRow = r4;
    L75:
        if (r3 != null) goto L77;
    L81:
        this.childListener.processRecord(r11);
        return;
    L77:
        if (r3.length <= 0) goto L81;
        int r12 = r3.length;
    L79:
        if (r5 >= r12) goto L89;
        this.childListener.processRecord((Record) ZeusTransformUtils.preCheckCast(r3[r5], Record.class, "com.obric.memorydata.plugin"));
        r5 = r5 + 1;
        goto L79
    L89:
        return;
    L71:
        if (r3.length <= 0) goto L73;
        r1 = r3[r3.length - 1].getColumn();
        goto L73
    L41:
        if (r3.length <= 0) goto L43;
        r4 = r3[0].getRow();
        r1 = r3[0].getColumn();
        goto L43
    L6:
        if (ZeusTransformUtils.instanceOf(r11, StringRecord.class) == false) goto L9;
    L7:
        this.childListener.processRecord(r11);
        return;
    L9:
        short r2 = r11.getSid();
        if (r2 != 28) goto L12;
        NoteRecord r10 = (NoteRecord) ZeusTransformUtils.preCheckCast(r11, NoteRecord.class, "com.obric.memorydata.plugin");
        r4 = r10.getRow();
        r1 = r10.getColumn();
        goto L38
    L12:
        if (r2 != 520) goto L14;
        RowRecord r13 = (RowRecord) ZeusTransformUtils.preCheckCast(r11, RowRecord.class, "com.obric.memorydata.plugin");
        if ((this.lastRowRow + 1) >= r13.getRowNumber()) goto L35;
        int r14 = this.lastRowRow;
    L32:
        r14 = r14 + 1;
        if (r14 >= r13.getRowNumber()) goto L35;
        this.childListener.processRecord(new MissingRowDummyRecord(r14));
    L35:
        this.lastRowRow = r13.getRowNumber();
        this.lastCellColumn = -1;
    L36:
        r1 = -1;
        r4 = -1;
        goto L38
    L14:
        if (r2 == 1212) goto L7;
        if (r2 != 2057) goto L18;
        BOFRecord r15 = (BOFRecord) ZeusTransformUtils.preCheckCast(r11, BOFRecord.class, "com.obric.memorydata.plugin");
        if (r15.getType() != 5) goto L27;
    L28:
        resetCounts();
        goto L36
    L27:
        if (r15.getType() != 16) goto L36;
    L18:
        if (r2 != 189) goto L20;
        r3 = RecordFactory.convertRKRecords((MulRKRecord) ZeusTransformUtils.preCheckCast(r11, MulRKRecord.class, "com.obric.memorydata.plugin"));
        goto L36
    L20:
        if (r2 != 190) goto L36;
        r3 = RecordFactory.convertBlankRecords((MulBlankRecord) ZeusTransformUtils.preCheckCast(r11, MulBlankRecord.class, "com.obric.memorydata.plugin"));
        goto L36
    }
}
