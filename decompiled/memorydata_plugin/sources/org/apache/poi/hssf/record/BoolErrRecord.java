package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class BoolErrRecord extends CellRecord {
    private boolean _isError;
    private int _value;

    /* JADX INFO: renamed from: org.apache.poi.hssf.record.BoolErrRecord$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$FormulaError = null;

        static {
            int[] r0 = new int[FormulaError.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError = r0;
            r0[FormulaError.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.DIV0.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.VALUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.REF.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NUM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public BoolErrRecord() {
    }

    public BoolErrRecord(RecordInputStream r4) {
        super(r4);
        int r0 = r4.remaining();
        if (r0 != 2) goto L5;
        int r1 = r4.readByte();
    L10:
        this._value = r1;
        int r5 = r4.readUByte();
        if (r5 != 0) goto L13;
        this._isError = false;
        return;
    L13:
        if (r5 != 1) goto L16;
        this._isError = true;
        return;
    L16:
        throw new RecordFormatException("Unexpected isError flag (" + r5 + ") for BOOLERR record.");
    L5:
        if (r0 != 3) goto L8;
        r1 = r4.readUShort();
        goto L10
    L8:
        throw new RecordFormatException("Unexpected size (" + r4.remaining() + ") for BOOLERR record.");
    }

    public boolean getBooleanValue() {
        if (this._value == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte getErrorValue() {
        return (byte) this._value;
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$BoolErrRecord$sdIpdFJI3enEoRboXysjZD_Fkj0(this), "isBoolean", new $$Lambda$yPl7qTbCEwR7MDVxNY19M3zknU(this), "booleanVal", new $$Lambda$Hj8mcM9t_S3GaAo2jfOk9G6D0jU(this), "isError", new $$Lambda$stFZ1KVLup38x7U1CgWlNwSfitg(this), "errorVal", new $$Lambda$XEIaY9ELWWxrf9HY5OozCsIrU0Y(this), "errorTxt", new $$Lambda$BoolErrRecord$MBEpwFBKGn5tmAnvDysmPPaTM0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BOOL_ERR;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 517;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return 2;
    }

    public boolean isBoolean() {
        return !this._isError;
    }

    public boolean isError() {
        return this._isError;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$BoolErrRecord() {
        return super.getGenericProperties();
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$BoolErrRecord() {
        if (isError() == true) goto L7;
        return null;
    L7:
        return FormulaError.forInt(getErrorValue()).getString();
    }

    public void setValue(byte r1) {
        setValue(FormulaError.forInt(r1));
    }

    public void setValue(FormulaError r3) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FormulaError[r3.ordinal()]) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        this._value = r3.getCode();
        this._isError = true;
        return;
    L5:
        throw new IllegalArgumentException("Error Value can only be 0,7,15,23,29,36 or 42. It cannot be " + r3.getCode() + " (" + r3 + ")");
    }

    public void setValue(boolean r1) {
        this._value = r1 ? 1 : 0;
        this._isError = false;
    }
}
