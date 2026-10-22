package org.apache.poi.ss.formula.functions;

import androidx.exifinterface.media.ExifInterface;
import com.tom_roush.pdfbox.pdmodel.a.c.a;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Roman extends Fixed2ArgFunction {
    private static final String[][] REPLACEMENTS = null;
    private static final String[] ROMAN = null;
    private static final int[] VALUES = null;

    static {
        VALUES = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        ROMAN = new String[]{"M", "CM", a.f16161b, "CD", "C", "XC", i.u, "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
        REPLACEMENTS = new String[][]{new String[]{"XLV", "VL", "XCV", "VC", "CDL", "LD", "CML", "LM", "CMVC", "LMVL"}, new String[]{"CDXC", "LDXL", "CDVC", "LDVL", "CMXC", "LMXL", "XCIX", "VCIV", "XLIX", "VLIV"}, new String[]{"XLIX", "IL", "XCIX", "IC", "CDXC", "XD", "CDVC", "XDV", "CDIC", "XDIX", "LMVL", "XMV", "CMIC", "XMIX", "CMXC", "XM"}, new String[]{"XDV", "VD", "XDIX", "VDIV", "XMV", "VM", "XMIX", "VMIV"}, new String[]{"VDIV", "ID", "VMIV", "IM"}};
    }

    public Roman() {
    }

    private String integerToRoman(int r4) {
        StringBuilder r3 = new StringBuilder();
        int r0 = 0;
    L4:
        if (r0 >= 13) goto L10;
    L5:
        int[] r1 = VALUES;
        if (r4 < r1[r0]) goto L8;
        r4 = r4 - r1[r0];
        r3.append(ROMAN[r0]);
        goto L5
    L8:
        r0 = r0 + 1;
        goto L4
    L10:
        return r3.toString();
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        int r9 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r7, r3, r4));     // Catch: EvaluationException -> L29
        if (r9 >= 0) goto L8;
        return ErrorEval.VALUE_INVALID;
    L8:
        if (r9 > 3999) goto L10;
        if (r9 == 0) goto L13;
        int r10 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r8, r3, r4));     // Catch: EvaluationException -> L27
        if (r10 > 4) goto L26;
        if (r10 < 0) goto L26;
        String r11 = integerToRoman(r9);
        if (r10 != 0) goto L24;
        return new StringEval(r11);
    L24:
        return new StringEval(makeConcise(r11, r10));
    L26:
        return ErrorEval.VALUE_INVALID;
    L28:
        return ErrorEval.NUM_ERROR;
    L13:
        return new StringEval("");
    L10:
        return ErrorEval.VALUE_INVALID;
    L30:
        return ErrorEval.VALUE_INVALID;
    }

    public String makeConcise(String r6, int r7) {
        int r0 = 0;
    L3:
        if (r0 > r7) goto L16;
        if (r0 > 4) goto L16;
        if (r7 <= 0) goto L16;
        if (r0 != 1) goto L11;
        if (r7 <= 1) goto L11;
    L15:
        r0 = r0 + 1;
    L11:
        String[] r1 = REPLACEMENTS[r0];
        int r2 = 0;
    L13:
        if (r2 >= r1.length) goto L15;
        r6 = r6.replace(r1[r2], r1[r2 + 1]);
        r2 = r2 + 2;
    L16:
        return r6;
    }
}
