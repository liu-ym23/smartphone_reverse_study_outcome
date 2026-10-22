package org.apache.poi.hemf.record.emf;

/* JADX INFO: loaded from: classes7.dex */
public class UnimplementedHemfRecord implements HemfRecordWithoutProperties {
    private HemfRecordType recordType;

    public UnimplementedHemfRecord() {
    }

    @Override // org.apache.poi.hemf.record.emf.HemfRecord
    public HemfRecordType getEmfRecordType() {
        return this.recordType;
    }
}
