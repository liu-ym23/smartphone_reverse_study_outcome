package org.apache.poi.ss.formula.ptg;

import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.function.FunctionMetadata;
import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractFunctionPtg extends OperationPtg {
    private final short _functionIndex;
    private final int _numberOfArgs;
    private final byte[] paramClass;
    private final byte returnClass;

    public AbstractFunctionPtg(int r1, int r2, byte[] r3, int r4) {
        this._numberOfArgs = r4;
        if (r1 < (-32768)) goto L15;
        if (r1 > 32767) goto L15;
        this._functionIndex = (short) r1;
        if (r2 < (-128)) goto L13;
        if (r2 > 127) goto L13;
        this.returnClass = (byte) r2;
        this.paramClass = r3;
        return;
    L13:
        throw new RuntimeException("pReturnClass " + r2 + " cannot be cast to byte");
    L15:
        throw new RuntimeException("functionIndex " + r1 + " cannot be cast to short");
    }

    private static void appendArgs(StringBuilder r2, int r3, String[] r4) {
        r2.append('(');
        int r0 = r3;
    L4:
        if (r0 >= r4.length) goto L8;
        if (r0 <= r3) goto L7;
        r2.append(',');
    L7:
        r2.append(r4[r0]);
        r0 = r0 + 1;
        goto L4
    L8:
        r2.append(")");
    }

    public static boolean isBuiltInFunctionName(String r1) {
        if (FunctionMetadataRegistry.lookupIndexByName(r1.toUpperCase(Locale.ROOT)) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static short lookupIndex(String r1) {
        short r2 = FunctionMetadataRegistry.lookupIndexByName(r1.toUpperCase(Locale.ROOT));
        if (r2 >= 0) goto L6;
        return 255;
    L6:
        return r2;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public byte getDefaultOperandClass() {
        return this.returnClass;
    }

    public final short getFunctionIndex() {
        return this._functionIndex;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("functionIndex", new $$Lambda$QrHNpKuU3OVM7iTBksF6ekYWBe0(this), "functionName", new $$Lambda$61B8ASIDqQC4MqvwX7KM8VuACM(this), "numberOfOperands", new $$Lambda$9GXeJshOsyVKjS65mMTl6Ct8a68(this), "externalFunction", new $$Lambda$zqzynqSsQXN4McH2GUIe8WtPL6I(this), "defaultOperandClass", new $$Lambda$PKvahC3c8htPTyDQOkMwTHjoszQ(this));
    }

    public final String getName() {
        return lookupName(this._functionIndex);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public final int getNumberOfOperands() {
        return this._numberOfArgs;
    }

    public final byte getParameterClass(int r2) {
        byte[] r1 = this.paramClass;
        if (r2 < r1.length) goto L7;
        return r1[r1.length - 1];
    L7:
        return r1[r2];
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return false;
    }

    public final boolean isExternalFunction() {
        if (this._functionIndex != 255) goto L5;
        return true;
    L5:
        return false;
    }

    public String lookupName(short r2) {
        return lookupName(r2, false);
    }

    public final String lookupName(short r3, boolean r4) {
        if (r3 != 255) goto L6;
        return "#external#";
    L6:
        if (r4 == false) goto L8;
        FunctionMetadata r2 = FunctionMetadataRegistry.getCetabFunctionByIndex(r3);
    L9:
        if (r2 == null) goto L13;
        return r2.getName();
    L13:
        throw new RuntimeException("bad function index (" + r3 + ", " + r4 + ")");
    L8:
        r2 = FunctionMetadataRegistry.getFunctionByIndex(r3);
        goto L9
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toFormulaString() {
        return getName();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] r4) {
        StringBuilder r0 = new StringBuilder();
        if (isExternalFunction() == false) goto L5;
        r0.append(r4[0]);
        appendArgs(r0, 1, r4);
    L7:
        return r0.toString();
    L5:
        r0.append(getName());
        appendArgs(r0, 0, r4);
        goto L7
    }
}
