package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class ObjRecord extends Record {
    private static int MAX_PAD_ALIGNMENT = 4;
    private boolean _isPaddedToQuadByteMultiple;
    private final byte[] _uninterpretedData;
    private final List<SubRecord> subrecords;

    static {
    }

    public ObjRecord() {
        this.subrecords = new ArrayList();
        this._uninterpretedData = null;
    }

    public ObjRecord(RecordInputStream r7) {
        ArrayList r0 = new ArrayList();
        this.subrecords = r0;
        byte[] r8 = r7.readRemainder();
        if (LittleEndian.getUShort(r8, 0) == 21) goto L6;
        this._uninterpretedData = r8;
        return;
    L6:
        LittleEndianByteArrayInputStream r2 = new LittleEndianByteArrayInputStream(r8);
        CommonObjectDataSubRecord r3 = (CommonObjectDataSubRecord) ZeusTransformUtils.preCheckCast(SubRecord.createSubRecord(r2, 0), CommonObjectDataSubRecord.class, "com.obric.memorydata.plugin");
        r0.add(r3);
    L7:
        SubRecord r1 = SubRecord.createSubRecord(r2, r3.getObjectType());
        this.subrecords.add(r1);
        if (r1.isTerminating() == false) goto L7;
        int r4 = r8.length - r2.getReadIndex();
        if (r4 <= 0) goto L25;
        int r5 = r8.length;
        int r6 = MAX_PAD_ALIGNMENT;
        if ((r5 % r6) != 0) goto L14;
        boolean r9 = true;
    L15:
        this._isPaddedToQuadByteMultiple = r9;
        if (r9 == true) goto L19;
        r6 = 2;
    L19:
        if (r4 >= r6) goto L21;
    L26:
        this._uninterpretedData = null;
        return;
    L21:
        if (canPaddingBeDiscarded(r8, r4) == true) goto L25;
        throw new RecordFormatException("Leftover " + r4 + " bytes in subrecord data " + HexDump.toHex(r8));
    L14:
        r9 = false;
    L25:
        this._isPaddedToQuadByteMultiple = false;
        goto L26
    }

    private static boolean canPaddingBeDiscarded(byte[] r1, int r2) {
        int r0 = r1.length - r2;
    L4:
        if (r0 >= r1.length) goto L10;
        if (r1[r0] != 0) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<SubRecord> getGenericChildren() {
        return getSubRecords();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("uninterpretedData", new $$Lambda$ObjRecord$slhDxZnTT5UU27vaU2d4eAgtk9Q(this), "paddedToQuadByteMultiple", new $$Lambda$ObjRecord$mG75IuwqIAcxZ7c_7tEB9lVBCY(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.OBJ;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] r0 = this._uninterpretedData;
        if (r0 != null) goto L5;
        int r1 = 0;
        Iterator<SubRecord> r2 = this.subrecords.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        r1 = r1 + (((SubRecord) ZeusTransformUtils.preCheckCast(r2.next(), SubRecord.class, "com.obric.memorydata.plugin")).getDataSize() + 4);
        goto L8
    L11:
        if (this._isPaddedToQuadByteMultiple == false) goto L16;
    L13:
        if ((r1 % MAX_PAD_ALIGNMENT) == 0) goto L19;
        r1 = r1 + 1;
    L19:
        return r1 + 4;
    L16:
        if ((r1 % 2) == 0) goto L19;
        r1 = r1 + 1;
        goto L16
    L5:
        return r0.length + 4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 93;
    }

    public List<SubRecord> getSubRecords() {
        return this.subrecords;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ObjRecord() {
        return this._uninterpretedData;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ObjRecord() {
        return Boolean.valueOf(this._isPaddedToQuadByteMultiple);
    }
}
