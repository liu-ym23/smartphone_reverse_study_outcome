package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class LbsDataSubRecord extends SubRecord {
    private boolean[] _bsels;
    private int _cLines;
    private int _cbFContinued;
    private LbsDropData _dropData;
    private int _flags;
    private int _iSel;
    private int _idEdit;
    private Ptg _linkPtg;
    private String[] _rgLines;
    private Byte _unknownPostFormulaByte;
    private int _unknownPreFormulaInt;

    public static class LbsDropData implements GenericRecord {
        private int _cLine;
        private int _dxMin;
        private final String _str;
        private Byte _unused;
        private int _wStyle;

        public LbsDropData() {
            this._str = "";
            this._unused = (byte) 0;
        }

        public LbsDropData(LittleEndianInput r3) {
            LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
            this._wStyle = r4.readUShort();
            this._cLine = r4.readUShort();
            this._dxMin = r4.readUShort();
            String r0 = StringUtil.readUnicodeString(r4);
            this._str = r0;
            if ((StringUtil.getEncodedSize(r0) % 2) == 0) goto L6;
            this._unused = Byte.valueOf(r4.readByte());
            return;
        }

        public int getDataSize() {
            int r0 = StringUtil.getEncodedSize(this._str) + 6;
            if (this._unused != null) goto L5;
            return r0;
        L5:
            return r0 + 1;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("wStyle", new $$Lambda$LbsDataSubRecord$LbsDropData$q7KdMQrDO2rjIhRBbjItit0oCg(this), "cLine", new $$Lambda$LbsDataSubRecord$LbsDropData$o18VYZ5uhcWgfWgo2juvKOkjsA(this), "dxMin", new $$Lambda$LbsDataSubRecord$LbsDropData$71cAGPxp865hdQleyLGANnc6P8A(this), "str", new $$Lambda$LbsDataSubRecord$LbsDropData$R6KDZ1OVr5OVxc2DR1XAJeYQpU(this), "unused", new $$Lambda$LbsDataSubRecord$LbsDropData$fFBOGhURTK3bWLkVaWIeCwnnB0k(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$LbsDataSubRecord$LbsDropData() {
            return Integer.valueOf(this._wStyle);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$LbsDataSubRecord$LbsDropData() {
            return Integer.valueOf(this._cLine);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$LbsDataSubRecord$LbsDropData() {
            return Integer.valueOf(this._dxMin);
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$LbsDataSubRecord$LbsDropData() {
            return this._str;
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$LbsDataSubRecord$LbsDropData() {
            return this._unused;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public LbsDataSubRecord(LittleEndianInput r6, int r7, int r8) {
        LittleEndianInput r9 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r6, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this._cbFContinued = r7;
        int r10 = r9.readUShort();
        if (r10 <= 0) goto L16;
        int r2 = r9.readUShort();
        this._unknownPreFormulaInt = r9.readInt();
        Ptg[] r3 = Ptg.readTokens(r2, r9);
        if (r3.length != 1) goto L15;
        this._linkPtg = r3[0];
        int r11 = (r10 - r2) - 6;
        if (r11 == 0) goto L12;
        if (r11 != 1) goto L11;
        Byte r12 = Byte.valueOf(r9.readByte());
    L13:
        this._unknownPostFormulaByte = r12;
        goto L16
    L11:
        throw new RecordFormatException("Unexpected leftover bytes");
    L12:
        r12 = null;
        goto L13
    L15:
        throw new RecordFormatException("Read " + r3.length + " tokens but expected exactly 1");
    L16:
        this._cLines = r9.readUShort();
        this._iSel = r9.readUShort();
        this._flags = r9.readUShort();
        this._idEdit = r9.readUShort();
        if (r8 != 20) goto L20;
        this._dropData = new LbsDropData(r9);
    L20:
        if ((this._flags & 2) == 0) goto L25;
        this._rgLines = new String[this._cLines];
        int r13 = 0;
    L23:
        if (r13 >= this._cLines) goto L25;
        this._rgLines[r13] = StringUtil.readUnicodeString(r9);
        r13 = r13 + 1;
    L25:
        int r14 = this._flags;
        if ((((r14 >> 4) & 1) + ((r14 >> 5) & 1)) == 0) goto L35;
        this._bsels = new boolean[this._cLines];
        int r15 = 0;
    L29:
        if (r15 >= this._cLines) goto L40;
        boolean[] r16 = this._bsels;
        if (r9.readByte() != 1) goto L33;
        boolean r4 = true;
    L34:
        r16[r15] = r4;
        r15 = r15 + 1;
        goto L29
    L33:
        r4 = false;
        goto L34
    L40:
        return;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        Ptg r0 = this._linkPtg;
        if (r0 == null) goto L7;
        int r1 = r0.getSize() + 8;
        if (this._unknownPostFormulaByte == null) goto L8;
        r1 = r1 + 1;
    L8:
        int r2 = r1 + 8;
        LbsDropData r3 = this._dropData;
        if (r3 == null) goto L11;
        r2 = r2 + r3.getDataSize();
    L11:
        String[] r4 = this._rgLines;
        if (r4 == null) goto L16;
        int r5 = r4.length;
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L16;
        r2 = r2 + StringUtil.getEncodedSize(r4[r6]);
        r6 = r6 + 1;
    L16:
        boolean[] r7 = this._bsels;
        if (r7 != null) goto L19;
        return r2;
    L19:
        return r2 + r7.length;
    L7:
        r1 = 2;
        goto L8
    }

    public Ptg getFormula() {
        return this._linkPtg;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("unknownShort1", new $$Lambda$LbsDataSubRecord$tDqceMitkb0tWIFlD1DgrpSmG1M(this));
        r0.put("unknownPreFormulaInt", new $$Lambda$LbsDataSubRecord$oSbRf8gOSfL9juD5H8Rd_XJKsLM(this));
        r0.put("formula", new $$Lambda$S6xCbGDjh4VVYG5kNwmD_Zf6dr4(this));
        r0.put("unknownPostFormulaByte", new $$Lambda$LbsDataSubRecord$zfQHV70P1r9PM8OtvQDiPQNdJyo(this));
        r0.put("numberOfItems", new $$Lambda$Cnavfr6FSlH61Hwo2sdV8yUxtc4(this));
        r0.put("selEntryIx", new $$Lambda$LbsDataSubRecord$hu3KL7x20hEWDLWY6DRv2g8Im28(this));
        r0.put("style", new $$Lambda$LbsDataSubRecord$rvNiBe7duRUeRDS3n9CSe2LSrHo(this));
        r0.put("unknownShort10", new $$Lambda$LbsDataSubRecord$mI1j5GgwrlDxhzY8_ya5WMSxDPI(this));
        r0.put("dropData", new $$Lambda$LbsDataSubRecord$trsKKdZWkxPOpSiAsszqcCHg_B4(this));
        r0.put("rgLines", new $$Lambda$LbsDataSubRecord$MNWHmO5RaqAJpDev8elDWq8mRuI(this));
        r0.put("bsels", new $$Lambda$LbsDataSubRecord$kWjojzIe4xKzShHbJpWOb7Xu9sc(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.LBS_DATA;
    }

    public int getNumberOfItems() {
        return this._cLines;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public boolean isTerminating() {
        return true;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$LbsDataSubRecord() {
        return Integer.valueOf(this._cbFContinued);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$LbsDataSubRecord() {
        return Integer.valueOf(this._unknownPreFormulaInt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$LbsDataSubRecord() {
        return this._unknownPostFormulaByte;
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$LbsDataSubRecord() {
        return Integer.valueOf(this._iSel);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$LbsDataSubRecord() {
        return Integer.valueOf(this._flags);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$LbsDataSubRecord() {
        return Integer.valueOf(this._idEdit);
    }

    public /* synthetic */ Object lambda$getGenericProperties$6$LbsDataSubRecord() {
        return this._dropData;
    }

    public /* synthetic */ Object lambda$getGenericProperties$7$LbsDataSubRecord() {
        return this._rgLines;
    }

    public /* synthetic */ Object lambda$getGenericProperties$8$LbsDataSubRecord() {
        return this._bsels;
    }
}
