package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class AttrPtg extends ControlPtg {
    public static final AttrPtg SUM = null;
    private static final BitField baxcel = null;
    private static final BitField optiChoose = null;
    private static final BitField optiIf = null;
    private static final BitField optiSkip = null;
    private static final BitField optiSum = null;
    private static final BitField semiVolatile = null;
    private static final BitField space = null;
    private final int _chooseFuncOffset;
    private final short _data;
    private final int[] _jumpTable;
    private final byte _options;

    static {
        semiVolatile = BitFieldFactory.getInstance(1);
        optiIf = BitFieldFactory.getInstance(2);
        optiChoose = BitFieldFactory.getInstance(4);
        optiSkip = BitFieldFactory.getInstance(8);
        optiSum = BitFieldFactory.getInstance(16);
        baxcel = BitFieldFactory.getInstance(32);
        space = BitFieldFactory.getInstance(64);
        SUM = new AttrPtg(16, 0, null, -1);
    }

    private AttrPtg(int r1, int r2, int[] r3, int r4) {
        this._options = (byte) r1;
        this._data = (short) r2;
        this._jumpTable = r3;
        this._chooseFuncOffset = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttrPtg(LittleEndianInput r5) {
        LittleEndianInput r6 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r5, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this._options = r6.readByte();
        int r0 = r6.readShort();
        this._data = r0;
        if (isOptimizedChoose() == false) goto L8;
        int[] r1 = new int[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        r1[r2] = r6.readUShort();
        r2 = r2 + 1;
        goto L5
    L7:
        this._jumpTable = r1;
        int r7 = r6.readUShort();
    L9:
        this._chooseFuncOffset = r7;
        return;
    L8:
        this._jumpTable = null;
        r7 = -1;
        goto L9
    }

    public static AttrPtg createIf(int r4) {
        return new AttrPtg(optiIf.set(0), r4, null, -1);
    }

    public static AttrPtg createSkip(int r4) {
        return new AttrPtg(optiSkip.set(0), r4, null, -1);
    }

    public static AttrPtg getSumSingle() {
        return new AttrPtg(optiSum.set(0), 0, null, -1);
    }

    public int getChooseFuncOffset() {
        if (this._jumpTable == null) goto L7;
        return this._chooseFuncOffset;
    L7:
        throw new IllegalStateException("Not tAttrChoose");
    }

    public short getData() {
        return this._data;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("volatile", new $$Lambda$kqXLoRdLrMO00hlGz9PvWg2Ygo(this), "options", GenericRecordUtil.getBitsAsString(new $$Lambda$AttrPtg$XtdW8ofMLD10DOUAOC4P9rgHl_0(this), new BitField[]{semiVolatile, optiIf, optiChoose, optiSkip, optiSum, baxcel, space}, new String[]{"SEMI_VOLATILE", "OPTI_IF", "OPTI_CHOOSE", "OPTI_SKIP", "OPTI_SUM", "BAXCEL", "SPACE"}), "space_count", new $$Lambda$AttrPtg$GBK1R_yS8oP7dFAnNXG3h0HCBEs(this), "space_type", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$AttrPtg$yAnE6GLzs57s_2P_U5xq6ho5o0(this), new int[]{0, 1, 2, 3, 4, 5, 6}, new String[]{"SPACE_BEFORE", "CR_BEFORE", "SPACE_BEFORE_OPEN_PAREN", "CR_BEFORE_OPEN_PAREN", "SPACE_BEFORE_CLOSE_PAREN", "CR_BEFORE_CLOSE_PAREN", "SPACE_AFTER_EQUALITY"}));
    }

    public int[] getJumpTable() {
        return (int[]) ZeusTransformUtils.preCheckCast(this._jumpTable.clone(), int[].class, "com.obric.memorydata.plugin");
    }

    public int getNumberOfOperands() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 25;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        int[] r1 = this._jumpTable;
        if (r1 != null) goto L5;
        return 4;
    L5:
        return ((r1.length + 1) * 2) + 4;
    }

    public int getType() {
        return -1;
    }

    public boolean isOptimizedChoose() {
        return optiChoose.isSet(this._options);
    }

    public boolean isOptimizedIf() {
        return optiIf.isSet(this._options);
    }

    public boolean isSemiVolatile() {
        return semiVolatile.isSet(this._options);
    }

    public boolean isSkip() {
        return optiSkip.isSet(this._options);
    }

    public boolean isSpace() {
        return space.isSet(this._options);
    }

    public boolean isSum() {
        return optiSum.isSet(this._options);
    }

    public /* synthetic */ Number lambda$getGenericProperties$0$AttrPtg() {
        return Byte.valueOf(this._options);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$AttrPtg() {
        return Integer.valueOf((this._data >> 8) & 255);
    }

    public /* synthetic */ Number lambda$getGenericProperties$2$AttrPtg() {
        return Integer.valueOf(this._data & 255);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        if (semiVolatile.isSet(this._options) == false) goto L7;
        return "ATTR(semiVolatile)";
    L7:
        if (optiIf.isSet(this._options) == false) goto L11;
        return "IF";
    L11:
        if (optiChoose.isSet(this._options) == false) goto L15;
        return "CHOOSE";
    L15:
        if (optiSkip.isSet(this._options) == false) goto L18;
        return "";
    L18:
        if (optiSum.isSet(this._options) == false) goto L22;
        return "SUM";
    L22:
        if (baxcel.isSet(this._options) == false) goto L26;
        return "ATTR(baxcel)";
    L26:
        if (space.isSet(this._options) == false) goto L28;
        return "";
    L28:
        return "UNKNOWN ATTRIBUTE";
    }

    public String toFormulaString(String[] r6) {
        if (space.isSet(this._options) == false) goto L7;
        return r6[0];
    L7:
        if (optiIf.isSet(this._options) == false) goto L13;
        StringBuilder r5 = new StringBuilder().append(toFormulaString()).append("(");
        String r7 = r6[0];
    L9:
        StringBuilder r8 = r5.append(r7).append(")");
    L11:
        return r8.toString();
    L13:
        if (optiSkip.isSet(this._options) == false) goto L15;
        r8 = new StringBuilder().append(toFormulaString()).append(r6[0]);
        goto L11
    L15:
        r5 = new StringBuilder().append(toFormulaString()).append("(");
        r7 = r6[0];
        goto L9
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r5) {
        LittleEndianOutput r6 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r5, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r6.writeByte(getPtgClass() + 25);
        r6.writeByte(this._options);
        r6.writeShort(this._data);
        int[] r0 = this._jumpTable;
        if (r0 == null) goto L10;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r6.writeShort(r0[r2]);
        r2 = r2 + 1;
        goto L5
    L7:
        r6.writeShort(this._chooseFuncOffset);
        return;
    }
}
