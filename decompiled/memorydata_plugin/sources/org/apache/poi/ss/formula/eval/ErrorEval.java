package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.FormulaError;

/* JADX INFO: loaded from: classes7.dex */
public final class ErrorEval implements ValueEval {
    public static final ErrorEval CIRCULAR_REF_ERROR = null;
    public static final ErrorEval DIV_ZERO = null;
    public static final ErrorEval FUNCTION_NOT_IMPLEMENTED = null;
    public static final ErrorEval NA = null;
    public static final ErrorEval NAME_INVALID = null;
    public static final ErrorEval NULL_INTERSECTION = null;
    public static final ErrorEval NUM_ERROR = null;
    public static final ErrorEval REF_INVALID = null;
    public static final ErrorEval VALUE_INVALID = null;
    private static final Map<FormulaError, ErrorEval> evals = null;
    private final FormulaError _error;

    static {
        evals = new HashMap();
        NULL_INTERSECTION = new ErrorEval(FormulaError.NULL);
        DIV_ZERO = new ErrorEval(FormulaError.DIV0);
        VALUE_INVALID = new ErrorEval(FormulaError.VALUE);
        REF_INVALID = new ErrorEval(FormulaError.REF);
        NAME_INVALID = new ErrorEval(FormulaError.NAME);
        NUM_ERROR = new ErrorEval(FormulaError.NUM);
        NA = new ErrorEval(FormulaError.NA);
        FUNCTION_NOT_IMPLEMENTED = new ErrorEval(FormulaError.FUNCTION_NOT_IMPLEMENTED);
        CIRCULAR_REF_ERROR = new ErrorEval(FormulaError.CIRCULAR_REF);
    }

    private ErrorEval(FormulaError r2) {
        this._error = r2;
        evals.put(r2, this);
    }

    public static String getText(int r2) {
        if (FormulaError.isValidCode(r2) == false) goto L7;
        return FormulaError.forInt(r2).getString();
    L7:
        return "~non~std~err(" + r2 + ")~";
    }

    public static ErrorEval valueOf(int r3) {
        ErrorEval r0 = (ErrorEval) ZeusTransformUtils.preCheckCast(evals.get(FormulaError.forInt(r3)), ErrorEval.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new RuntimeException("Unhandled error type for code " + r3);
    }

    public int getErrorCode() {
        return this._error.getLongCode();
    }

    public String toString() {
        return getClass().getName() + " [" + this._error.getString() + "]";
    }
}
