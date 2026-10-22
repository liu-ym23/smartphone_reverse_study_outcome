package org.apache.poi.hslf.record;

/* JADX INFO: loaded from: classes7.dex */
public final class ExControl extends ExEmbed {
    public ExControl(byte[] r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // org.apache.poi.hslf.record.ExEmbed, org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExControl.typeID;
    }
}
