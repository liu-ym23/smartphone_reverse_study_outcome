package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class ErrPtg extends ScalarConstantPtg {
    public static final ErrPtg DIV_ZERO = null;
    public static final ErrPtg NAME_INVALID = null;
    public static final ErrPtg NULL_INTERSECTION = null;
    public static final ErrPtg NUM_ERROR = null;
    public static final ErrPtg N_A = null;
    public static final ErrPtg REF_INVALID = null;
    public static final ErrPtg VALUE_INVALID = null;
    private final int field_1_error_code;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.ptg.ErrPtg$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$FormulaError = null;

        static {
            int[] r0 = new int[FormulaError.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError = r0;
            r0[FormulaError.DIV0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.NUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.REF.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.VALUE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        NULL_INTERSECTION = new ErrPtg(FormulaError.NULL.getCode());
        DIV_ZERO = new ErrPtg(FormulaError.DIV0.getCode());
        VALUE_INVALID = new ErrPtg(FormulaError.VALUE.getCode());
        REF_INVALID = new ErrPtg(FormulaError.REF.getCode());
        NAME_INVALID = new ErrPtg(FormulaError.NAME.getCode());
        NUM_ERROR = new ErrPtg(FormulaError.NUM.getCode());
        N_A = new ErrPtg(FormulaError.NA.getCode());
    }

    private ErrPtg(int r3) {
        if (FormulaError.isValidCode(r3) == false) goto L7;
        this.field_1_error_code = r3;
        return;
    L7:
        throw new IllegalArgumentException("Invalid error code (" + r3 + ")");
    }

    public static ErrPtg read(LittleEndianInput r2) {
        return valueOf(((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin")).readByte());
    }

    public static ErrPtg valueOf(int r3) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FormulaError[FormulaError.forInt(r3).ordinal()]) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("Unexpected error code (" + r3 + ")");
    L7:
        return VALUE_INVALID;
    L9:
        return REF_INVALID;
    L11:
        return NUM_ERROR;
    L13:
        return NULL_INTERSECTION;
    L15:
        return NAME_INVALID;
    L17:
        return N_A;
    L19:
        return DIV_ZERO;
    }

    public int getErrorCode() {
        return this.field_1_error_code;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("errorCode", new $$Lambda$I5KKZz9G2g_VH1ixa_SfxsQn8(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 28;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return FormulaError.forInt(this.field_1_error_code).getString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 28);
        r4.writeByte(this.field_1_error_code);
    }
}
