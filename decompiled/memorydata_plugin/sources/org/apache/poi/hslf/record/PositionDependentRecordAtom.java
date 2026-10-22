package org.apache.poi.hslf.record;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PositionDependentRecordAtom extends RecordAtom implements PositionDependentRecord {
    private int myLastOnDiskOffset;

    public PositionDependentRecordAtom() {
    }

    @Override // org.apache.poi.hslf.record.PositionDependentRecord
    public int getLastOnDiskOffset() {
        return this.myLastOnDiskOffset;
    }

    @Override // org.apache.poi.hslf.record.PositionDependentRecord
    public void setLastOnDiskOffset(int r1) {
        this.myLastOnDiskOffset = r1;
    }
}
