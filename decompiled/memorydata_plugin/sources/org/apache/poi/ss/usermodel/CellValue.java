package org.apache.poi.ss.usermodel;

import kotlin.text.Typography;
import org.apache.poi.ss.formula.eval.ErrorEval;

/* JADX INFO: loaded from: classes7.dex */
public final class CellValue {
    public static final CellValue FALSE = null;
    public static final CellValue TRUE = null;
    private final boolean _booleanValue;
    private final CellType _cellType;
    private final int _errorCode;
    private final double _numberValue;
    private final String _textValue;

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.CellValue$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;

        static {
            int[] r0 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r0;
            r0[CellType.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        TRUE = new CellValue(CellType.BOOLEAN, 0.0d, true, null, 0);
        FALSE = new CellValue(CellType.BOOLEAN, 0.0d, false, null, 0);
    }

    public CellValue(double r8) {
        this(CellType.NUMERIC, r8, false, null, 0);
    }

    public CellValue(String r8) {
        this(CellType.STRING, 0.0d, false, r8, 0);
    }

    private CellValue(CellType r1, double r2, boolean r4, String r5, int r6) {
        this._cellType = r1;
        this._numberValue = r2;
        this._booleanValue = r4;
        this._textValue = r5;
        this._errorCode = r6;
    }

    public static CellValue getError(int r8) {
        return new CellValue(CellType.ERROR, 0.0d, false, null, r8);
    }

    public static CellValue valueOf(boolean r0) {
        if (r0 == false) goto L5;
        return TRUE;
    L5:
        return FALSE;
    }

    public String formatAsString() {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (r0 == 1) goto L22;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L15;
        if (r0 == 4) goto L13;
        return "<error unexpected cell type " + this._cellType + ">";
    L13:
        return ErrorEval.getText(this._errorCode);
    L15:
        if (this._booleanValue == false) goto L17;
        return "TRUE";
    L17:
        return "FALSE";
    L20:
        return Typography.quote + this._textValue + Typography.quote;
    L22:
        return String.valueOf(this._numberValue);
    }

    public boolean getBooleanValue() {
        return this._booleanValue;
    }

    public CellType getCellType() {
        return this._cellType;
    }

    public byte getErrorValue() {
        return (byte) this._errorCode;
    }

    public double getNumberValue() {
        return this._numberValue;
    }

    public String getStringValue() {
        return this._textValue;
    }

    public String toString() {
        return getClass().getName() + " [" + formatAsString() + "]";
    }
}
