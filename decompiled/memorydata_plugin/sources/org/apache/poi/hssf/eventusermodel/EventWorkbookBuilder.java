package org.apache.poi.hssf.eventusermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.ExternSheetRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.hssf.record.SupBookRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/* JADX INFO: loaded from: classes7.dex */
public class EventWorkbookBuilder {

    public static class SheetRecordCollectingListener implements HSSFListener {
        private final List<BoundSheetRecord> boundSheetRecords;
        private final HSSFListener childListener;
        private final List<ExternSheetRecord> externSheetRecords;
        private SSTRecord sstRecord;

        public SheetRecordCollectingListener(HSSFListener r3) {
            HSSFListener r4 = (HSSFListener) ZeusTransformUtils.wrapperContextForParams(r3, HSSFListener.class, "com.obric.memorydata.plugin");
            this.boundSheetRecords = new ArrayList();
            this.externSheetRecords = new ArrayList();
            this.childListener = r4;
        }

        public BoundSheetRecord[] getBoundSheetRecords() {
            return (BoundSheetRecord[]) ZeusTransformUtils.preCheckCast(this.boundSheetRecords.toArray(new BoundSheetRecord[0]), BoundSheetRecord[].class, "com.obric.memorydata.plugin");
        }

        public ExternSheetRecord[] getExternSheetRecords() {
            return (ExternSheetRecord[]) ZeusTransformUtils.preCheckCast(this.externSheetRecords.toArray(new ExternSheetRecord[0]), ExternSheetRecord[].class, "com.obric.memorydata.plugin");
        }

        public SSTRecord getSSTRecord() {
            return this.sstRecord;
        }

        public HSSFWorkbook getStubHSSFWorkbook() {
            HSSFWorkbook r0 = HSSFWorkbook.create(getStubWorkbook());
            Iterator<BoundSheetRecord> r4 = this.boundSheetRecords.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.createSheet(((BoundSheetRecord) ZeusTransformUtils.preCheckCast(r4.next(), BoundSheetRecord.class, "com.obric.memorydata.plugin")).getSheetname());
            goto L4
        L6:
            return r0;
        }

        public InternalWorkbook getStubWorkbook() {
            return EventWorkbookBuilder.createStubWorkbook(getExternSheetRecords(), getBoundSheetRecords(), getSSTRecord());
        }

        @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
        public void processRecord(Record r1) {
            processRecordInternally(r1);
            this.childListener.processRecord(r1);
        }

        public void processRecordInternally(Record r3) {
            if (ZeusTransformUtils.instanceOf(r3, BoundSheetRecord.class) == false) goto L7;
            List r2 = this.boundSheetRecords;
            StandardRecord r4 = (BoundSheetRecord) ZeusTransformUtils.preCheckCast(r3, BoundSheetRecord.class, "com.obric.memorydata.plugin");
        L5:
            r2.add(r4);
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, ExternSheetRecord.class) == false) goto L10;
            r2 = this.externSheetRecords;
            r4 = (ExternSheetRecord) ZeusTransformUtils.preCheckCast(r3, ExternSheetRecord.class, "com.obric.memorydata.plugin");
            goto L5
        L10:
            if (ZeusTransformUtils.instanceOf(r3, SSTRecord.class) == false) goto L14;
            this.sstRecord = (SSTRecord) ZeusTransformUtils.preCheckCast(r3, SSTRecord.class, "com.obric.memorydata.plugin");
            return;
        }
    }

    public static InternalWorkbook createStubWorkbook(ExternSheetRecord[] r1, BoundSheetRecord[] r2, SSTRecord r3) {
        ArrayList r0 = new ArrayList();
        if (r2 == null) goto L5;
        Collections.addAll(r0, r2);
    L5:
        if (r3 == null) goto L7;
        r0.add(r3);
    L7:
        if (r1 == null) goto L9;
        r0.add(SupBookRecord.createInternalReferences((short) r1.length));
        Collections.addAll(r0, r1);
    L9:
        r0.add(EOFRecord.instance);
        return InternalWorkbook.createWorkbook(r0);
    }
}
