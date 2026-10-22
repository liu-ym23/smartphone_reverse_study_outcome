package org.apache.poi.hslf.record;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PositionDependentRecordContainer extends RecordContainer implements PositionDependentRecord {
    private int myLastOnDiskOffset;
    private int sheetId;

    public PositionDependentRecordContainer() {
    }

    @Override // org.apache.poi.hslf.record.PositionDependentRecord
    public int getLastOnDiskOffset() {
        return this.myLastOnDiskOffset;
    }

    @Override // org.apache.poi.hslf.record.PositionDependentRecord
    public void setLastOnDiskOffset(int r1) {
        this.myLastOnDiskOffset = r1;
    }

    public void setSheetId(int r1) {
        this.sheetId = r1;
    }
}
