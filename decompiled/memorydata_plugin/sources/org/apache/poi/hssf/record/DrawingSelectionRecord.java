package org.apache.poi.hssf.record;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class DrawingSelectionRecord extends StandardRecord {
    private int _cpsp;
    private int _dgslk;
    private OfficeArtRecordHeader _header;
    private int[] _shapeIds;
    private int _spidFocus;

    private static final class OfficeArtRecordHeader implements GenericRecord {
        private final int _length;
        private final int _type;
        private final int _verAndInstance;

        public OfficeArtRecordHeader(LittleEndianInput r3) {
            LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
            this._verAndInstance = r4.readUShort();
            this._type = r4.readUShort();
            this._length = r4.readInt();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("verAndInstance", new $$Lambda$DrawingSelectionRecord$OfficeArtRecordHeader$GtFYyeiGFEuWs0nKZK80RCcQSzY(this), "type", new $$Lambda$DrawingSelectionRecord$OfficeArtRecordHeader$W8oLdGgPtnClbBDOieJnQ4O1wQ(this), XSDatatype.FACET_LENGTH, new $$Lambda$DrawingSelectionRecord$OfficeArtRecordHeader$Gmca4b47m4LxgjgjN7j0r8GiXMA(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$DrawingSelectionRecord$OfficeArtRecordHeader() {
            return Integer.valueOf(this._verAndInstance);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$DrawingSelectionRecord$OfficeArtRecordHeader() {
            return Integer.valueOf(this._type);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$DrawingSelectionRecord$OfficeArtRecordHeader() {
            return Integer.valueOf(this._length);
        }
    }

    public DrawingSelectionRecord(RecordInputStream r5) {
        this._header = new OfficeArtRecordHeader(r5);
        this._cpsp = r5.readInt();
        this._dgslk = r5.readInt();
        this._spidFocus = r5.readInt();
        int r0 = r5.available() / 4;
        int[] r1 = new int[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = r5.readInt();
        r2 = r2 + 1;
        goto L3
    L5:
        this._shapeIds = r1;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._shapeIds.length * 4) + 20;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rh", new $$Lambda$DrawingSelectionRecord$LSk_WsnVltZTvNV8VtUZ7QRtop8(this), "cpsp", new $$Lambda$DrawingSelectionRecord$29QO7HY3ifOdMcapIe595RpEqDo(this), "dgslk", new $$Lambda$DrawingSelectionRecord$3COukA927dENwa81DTYdmuYzkw(this), "spidFocus", new $$Lambda$DrawingSelectionRecord$IRRLtH8Kgaw5EcZbywsyOHq2z6M(this), "shapeIds", new $$Lambda$DrawingSelectionRecord$R1m6hSpbTasNNNZHlHc67qKeWTg(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DRAWING_SELECTION;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 237;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DrawingSelectionRecord() {
        return this._header;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$DrawingSelectionRecord() {
        return Integer.valueOf(this._cpsp);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$DrawingSelectionRecord() {
        return Integer.valueOf(this._dgslk);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$DrawingSelectionRecord() {
        return Integer.valueOf(this._spidFocus);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$DrawingSelectionRecord() {
        return this._shapeIds;
    }
}
