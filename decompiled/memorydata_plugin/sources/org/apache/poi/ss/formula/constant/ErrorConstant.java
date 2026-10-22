package org.apache.poi.ss.formula.constant;

import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ss.usermodel.FormulaError;

/* JADX INFO: loaded from: classes7.dex */
public final class ErrorConstant {
    private static final ErrorConstant DIV_0 = null;
    private static final c LOG = null;
    private static final ErrorConstant NA = null;
    private static final ErrorConstant NAME = null;
    private static final ErrorConstant NULL = null;
    private static final ErrorConstant NUM = null;
    private static final ErrorConstant REF = null;
    private static final ErrorConstant VALUE = null;
    private final int _errorCode;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.constant.ErrorConstant$1, reason: invalid class name */
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

    static {
        LOG = b.a(ErrorConstant.class);
        NULL = new ErrorConstant(FormulaError.NULL.getCode());
        DIV_0 = new ErrorConstant(FormulaError.DIV0.getCode());
        VALUE = new ErrorConstant(FormulaError.VALUE.getCode());
        REF = new ErrorConstant(FormulaError.REF.getCode());
        NAME = new ErrorConstant(FormulaError.NAME.getCode());
        NUM = new ErrorConstant(FormulaError.NUM.getCode());
        NA = new ErrorConstant(FormulaError.NA.getCode());
    }

    private ErrorConstant(int r1) {
        this._errorCode = r1;
    }

    public static ErrorConstant valueOf(int r3) {
        if (FormulaError.isValidCode(r3) == true) goto L5;
    L21:
        LOG.atWarn().a("Warning - unexpected error code ({})", v.a(r3));
        return new ErrorConstant(r3);
    L5:
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.forInt(r3).ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            default: goto L21;
        };
    L8:
        return NA;
    L10:
        return NUM;
    L12:
        return NAME;
    L14:
        return REF;
    L16:
        return VALUE;
    L18:
        return DIV_0;
    L20:
        return NULL;
    }

    public int getErrorCode() {
        return this._errorCode;
    }

    public String getText() {
        if (FormulaError.isValidCode(this._errorCode) == false) goto L7;
        return FormulaError.forInt(this._errorCode).getString();
    L7:
        return "unknown error code (" + this._errorCode + ")";
    }

    public String toString() {
        return getClass().getName() + " [" + getText() + "]";
    }
}
