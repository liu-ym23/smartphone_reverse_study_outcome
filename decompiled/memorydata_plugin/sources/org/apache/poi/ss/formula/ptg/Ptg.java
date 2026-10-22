package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Ptg implements GenericRecord {
    public static final Ptg[] EMPTY_PTG_ARRAY = null;
    private byte ptgClass;

    static {
        EMPTY_PTG_ARRAY = new Ptg[0];
    }

    public Ptg() {
        this.ptgClass = 0;
    }

    public Ptg(Ptg r2) {
        this.ptgClass = 0;
        this.ptgClass = r2.ptgClass;
    }

    private static Ptg createBasePtg(byte r2, LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        switch(r2) {
            case 0: goto L63;
            case 1: goto L61;
            case 2: goto L59;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L53;
            case 6: goto L51;
            case 7: goto L49;
            case 8: goto L47;
            case 9: goto L45;
            case 10: goto L43;
            case 11: goto L41;
            case 12: goto L39;
            case 13: goto L37;
            case 14: goto L35;
            case 15: goto L33;
            case 16: goto L31;
            case 17: goto L29;
            case 18: goto L27;
            case 19: goto L25;
            case 20: goto L23;
            case 21: goto L21;
            case 22: goto L19;
            case 23: goto L17;
            case 24: goto L5;
            case 25: goto L15;
            case 26: goto L5;
            case 27: goto L5;
            case 28: goto L13;
            case 29: goto L11;
            case 30: goto L9;
            case 31: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Unexpected base token id (" + r2 + ")");
    L7:
        return new NumberPtg(r4);
    L9:
        return new IntPtg(r4);
    L11:
        return BoolPtg.read(r4);
    L13:
        return ErrPtg.read(r4);
    L15:
        return new AttrPtg(r4);
    L17:
        return new StringPtg(r4);
    L19:
        return MissingArgPtg.instance;
    L21:
        return ParenthesisPtg.instance;
    L23:
        return PercentPtg.instance;
    L25:
        return UnaryMinusPtg.instance;
    L27:
        return UnaryPlusPtg.instance;
    L29:
        return RangePtg.instance;
    L31:
        return UnionPtg.instance;
    L33:
        return IntersectionPtg.instance;
    L35:
        return NotEqualPtg.instance;
    L37:
        return GreaterThanPtg.instance;
    L39:
        return GreaterEqualPtg.instance;
    L41:
        return EqualPtg.instance;
    L43:
        return LessEqualPtg.instance;
    L45:
        return LessThanPtg.instance;
    L47:
        return ConcatPtg.instance;
    L49:
        return PowerPtg.instance;
    L51:
        return DividePtg.instance;
    L53:
        return MultiplyPtg.instance;
    L55:
        return SubtractPtg.instance;
    L57:
        return AddPtg.instance;
    L59:
        return new TblPtg(r4);
    L61:
        return new ExpPtg(r4);
    L63:
        return new UnknownPtg(r2);
    }

    private static Ptg createClassifiedPtg(byte r2, LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r0 = (r2 & 31) | 32;
        switch(r0) {
            case 32: goto L43;
            case 33: goto L41;
            case 34: goto L39;
            case 35: goto L37;
            case 36: goto L35;
            case 37: goto L33;
            case 38: goto L31;
            case 39: goto L29;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 41: goto L27;
            case 42: goto L25;
            case 43: goto L23;
            case 44: goto L21;
            case 45: goto L19;
            default: goto L5;
        };
    L5:
        switch(r0) {
            case 57: goto L17;
            case 58: goto L15;
            case 59: goto L13;
            case 60: goto L11;
            case 61: goto L9;
            default: goto L7;
        };
    L7:
        throw new UnsupportedOperationException(" Unknown Ptg in Formula: 0x" + Integer.toHexString(r2) + " (" + r2 + ")");
    L9:
        return new DeletedArea3DPtg(r4);
    L11:
        return new DeletedRef3DPtg(r4);
    L13:
        return new Area3DPtg(r4);
    L15:
        return new Ref3DPtg(r4);
    L17:
        return new NameXPtg(r4);
    L19:
        return new AreaNPtg(r4);
    L21:
        return new RefNPtg(r4);
    L23:
        return new AreaErrPtg(r4);
    L25:
        return new RefErrorPtg(r4);
    L27:
        return new MemFuncPtg(r4);
    L29:
        return new MemErrPtg(r4);
    L31:
        return new MemAreaPtg(r4);
    L33:
        return new AreaPtg(r4);
    L35:
        return new RefPtg(r4);
    L37:
        return new NamePtg(r4);
    L39:
        return FuncVarPtg.create(r4);
    L41:
        return FuncPtg.create(r4);
    L43:
        return new ArrayInitialPtg(r4);
    }

    public static Ptg createPtg(LittleEndianInput r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte r0 = r5.readByte();
        if (r0 < 32) goto L5;
        Ptg r6 = createClassifiedPtg(r0, r5);
        if (r0 < 96) goto L9;
        r6.setClass((byte) 64);
    L12:
        return r6;
    L9:
        if (r0 < 64) goto L11;
        r6.setClass((byte) 32);
        goto L12
    L11:
        r6.setClass((byte) 0);
        goto L12
    L5:
        return createBasePtg(r0, r5);
    }

    public static int getEncodedSize(Ptg[] r4) {
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + r4[r1].getSize();
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    public static int getEncodedSizeWithoutArrayData(Ptg[] r5) {
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L9;
        Ptg r3 = r5[r1];
        if (ZeusTransformUtils.instanceOf(r3, ArrayPtg.class) == false) goto L7;
        r2 = r2 + 8;
    L8:
        r1 = r1 + 1;
        goto L3
    L7:
        r2 = r2 + r3.getSize();
        goto L8
    L9:
        return r2;
    }

    public static Ptg[] readTokens(int r7, LittleEndianInput r8) {
        LittleEndianInput r9 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r8, LittleEndianInput.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList((r7 / 2) + 4);
        int r2 = 0;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r7) goto L8;
        Ptg r5 = createPtg(r9);
        if (ZeusTransformUtils.instanceOf(r5, ArrayInitialPtg.class) == false) goto L7;
        r4 = true;
    L7:
        r3 = r3 + r5.getSize();
        r0.add(r5);
        goto L3
    L8:
        if (r3 != r7) goto L19;
        Ptg[] r10 = toPtgArray(r0);
        if (r4 == true) goto L12;
    L17:
        return r10;
    L12:
        if (r2 >= r10.length) goto L17;
        if (ZeusTransformUtils.instanceOf(r10[r2], ArrayInitialPtg.class) == false) goto L16;
        r10[r2] = ((ArrayInitialPtg) ZeusTransformUtils.preCheckCast(r10[r2], ArrayInitialPtg.class, "com.obric.memorydata.plugin")).finishReading(r9);
    L16:
        r2 = r2 + 1;
        goto L12
    L19:
        throw new IllegalArgumentException("Ptg array size mismatch");
    }

    public static int serializePtgs(Ptg[] r5, byte[] r6, int r7) {
        LittleEndianByteArrayOutputStream r0 = new LittleEndianByteArrayOutputStream(r6, r7);
        int r8 = r5.length;
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r8) goto L10;
        Ptg r3 = r5[r2];
        r3.write(r0);
        if (ZeusTransformUtils.instanceOf(r3, ArrayPtg.class) == false) goto L9;
        if (r1 != null) goto L8;
        r1 = new ArrayList(5);
    L8:
        r1.add(r3);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r1 == null) goto L16;
        Iterator r9 = r1.iterator();
    L13:
        if (r9.hasNext() == false) goto L16;
        ((ArrayPtg) ZeusTransformUtils.preCheckCast((Ptg) ZeusTransformUtils.preCheckCast(r9.next(), Ptg.class, "com.obric.memorydata.plugin"), ArrayPtg.class, "com.obric.memorydata.plugin")).writeTokenValueBytes(r0);
    L16:
        return r0.getWriteIndex() - r7;
    }

    private static Ptg[] toPtgArray(List<Ptg> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == true) goto L5;
        Ptg[] r0 = new Ptg[r3.size()];
        r3.toArray(r0);
        return r0;
    L5:
        return EMPTY_PTG_ARRAY;
    }

    public final byte getPtgClass() {
        return this.ptgClass;
    }

    public abstract byte getSid();

    public abstract int getSize();

    public abstract boolean isBaseToken();

    public final void setClass(byte r2) {
        if (isBaseToken() == true) goto L7;
        this.ptgClass = r2;
        return;
    L7:
        throw new IllegalStateException("setClass should not be called on a base token");
    }

    public abstract String toFormulaString();

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    public abstract void write(LittleEndianOutput r1);
}
