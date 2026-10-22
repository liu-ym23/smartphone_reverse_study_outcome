package org.apache.poi.hslf.record;

/* JADX INFO: loaded from: classes7.dex */
public final class ExAviMovie extends ExMCIMovie {
    public ExAviMovie(byte[] r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // org.apache.poi.hslf.record.ExMCIMovie, org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExAviMovie.typeID;
    }
}
