package org.apache.poi.hssf.record.pivottable;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ViewFieldsRecord extends StandardRecord {
    private final int _cItm;
    private final int _cSub;
    private final int _grbitSub;
    private String _name;
    private final int _sxaxis;

    private static final enum Axis extends Enum<Axis> {
        private static final /* synthetic */ Axis[] $VALUES = null;
        public static final Axis COLUMN = null;
        public static final Axis DATA = null;
        public static final Axis NO_AXIS = null;
        public static final Axis PAGE = null;
        public static final Axis ROW = null;
        final int id;

        static {
            Axis r0 = new Axis("NO_AXIS", 0, 0);
            NO_AXIS = r0;
            Axis r1 = new Axis("ROW", 1, 1);
            ROW = r1;
            Axis r3 = new Axis("COLUMN", 2, 2);
            COLUMN = r3;
            Axis r5 = new Axis("PAGE", 3, 4);
            PAGE = r5;
            Axis r7 = new Axis("DATA", 4, 8);
            DATA = r7;
            $VALUES = new Axis[]{r0, r1, r3, r5, r7};
        }

        private Axis(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static Axis valueOf(String r2) {
            return (Axis) ZeusTransformUtils.preCheckCast(Enum.valueOf(Axis.class, r2), Axis.class, "com.obric.memorydata.plugin");
        }

        public static Axis[] values() {
            return (Axis[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Axis[].class, "com.obric.memorydata.plugin");
        }
    }

    public ViewFieldsRecord(RecordInputStream r3) {
        this._sxaxis = r3.readShort();
        this._cSub = r3.readShort();
        this._grbitSub = r3.readShort();
        this._cItm = r3.readShort();
        int r0 = r3.readUShort();
        if (r0 != 65535) goto L5;
        return;
    L5:
        if ((r3.readByte() & 1) == 0) goto L7;
        String r4 = r3.readUnicodeLEString(r0);
    L8:
        this._name = r4;
        return;
    L7:
        r4 = r3.readCompressedUnicode(r0);
        goto L8
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        String r0 = this._name;
        if (r0 != null) goto L6;
        return 10;
    L6:
        int r1 = r0.length();
        if (StringUtil.hasMultibyte(this._name) == false) goto L9;
        int r2 = 2;
    L11:
        return (r1 * r2) + 11;
    L9:
        r2 = 1;
        goto L11
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("sxaxis", new $$Lambda$ViewFieldsRecord$jttQLpTcxApkvx_575uITNlK9Vc(this), "cSub", new $$Lambda$ViewFieldsRecord$AX8nxbN4ly2oxth6OQAYbf8cxzw(this), "grbitSub", new $$Lambda$ViewFieldsRecord$JNrDcw1QbjCGPxVkavPFruxVkM(this), "cItm", new $$Lambda$ViewFieldsRecord$kCL94zp4fe5Yo_XuqkP8WmowT4(this), ActivityLifecycle.NAME, new $$Lambda$ViewFieldsRecord$DuTzwztCySj6IyVWxNcMxKWV6P0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.VIEW_FIELDS;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 177;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ViewFieldsRecord() {
        return Integer.valueOf(this._sxaxis);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ViewFieldsRecord() {
        return Integer.valueOf(this._cSub);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ViewFieldsRecord() {
        return Integer.valueOf(this._grbitSub);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ViewFieldsRecord() {
        return Integer.valueOf(this._cItm);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$ViewFieldsRecord() {
        return this._name;
    }
}
