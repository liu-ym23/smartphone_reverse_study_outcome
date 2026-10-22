package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RecordAggregate extends RecordBase {

    public static final class PositionTrackingVisitor implements RecordVisitor {
        private int _position;
        private final RecordVisitor _rv;

        public PositionTrackingVisitor(RecordVisitor r3, int r4) {
            this._rv = (RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RecordVisitor.class, "com.obric.memorydata.plugin");
            this._position = r4;
        }

        public int getPosition() {
            return this._position;
        }

        public void setPosition(int r1) {
            this._position = r1;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record r3) {
            this._position += r3.getRecordSize();
            this._rv.visitRecord(r3);
        }
    }

    private static final class RecordSizingVisitor implements RecordVisitor {
        private int _totalSize;

        public RecordSizingVisitor() {
            this._totalSize = 0;
        }

        public int getTotalSize() {
            return this._totalSize;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
        public void visitRecord(Record r2) {
            this._totalSize += r2.getRecordSize();
        }
    }

    public interface RecordVisitor {
        void visitRecord(Record r1);
    }

    public RecordAggregate() {
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        RecordSizingVisitor r0 = new RecordSizingVisitor();
        visitContainedRecords(r0);
        return r0.getTotalSize();
    }

    public abstract void visitContainedRecords(RecordVisitor r1);
}
