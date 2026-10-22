package org.apache.poi.hssf.record.chart;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class ChartTitleFormatRecord extends StandardRecord {
    private final CTFormat[] _formats;

    private static final class CTFormat implements GenericRecord {
        private int _fontIndex;
        private int _offset;

        public CTFormat(RecordInputStream r2) {
            this._offset = r2.readShort();
            this._fontIndex = r2.readShort();
        }

        public int getFontIndex() {
            return this._fontIndex;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties(TypedValues.CycleType.S_WAVE_OFFSET, new $$Lambda$cqUqSJVlDfc2aUb8AQDb1O_7oU8(this), "fontIndex", new $$Lambda$I0ogjAESiPFjQlyElPHltxI7Rw(this));
        }

        public int getOffset() {
            return this._offset;
        }
    }

    public ChartTitleFormatRecord(RecordInputStream r5) {
        int r0 = r5.readUShort();
        this._formats = new CTFormat[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this._formats[r1] = new CTFormat(r5);
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._formats.length * 4) + 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("formats", new $$Lambda$ChartTitleFormatRecord$5uaaIjwLZrVuEKTxwgpLHkvcgQ(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_TITLE_FORMAT;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4176;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ChartTitleFormatRecord() {
        return this._formats;
    }
}
