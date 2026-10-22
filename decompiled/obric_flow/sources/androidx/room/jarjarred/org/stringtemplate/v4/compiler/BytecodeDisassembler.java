package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Interval;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.util.ArrayList;
import kotlin.UByte;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class BytecodeDisassembler {
    CompiledST code;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.stringtemplate.v4.compiler.BytecodeDisassembler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$stringtemplate$v4$compiler$Bytecode$OperandType = null;

        static {
            int[] r5 = new int[Bytecode.OperandType.values().length];
            $SwitchMap$org$stringtemplate$v4$compiler$Bytecode$OperandType = r5;
            r5[Bytecode.OperandType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$stringtemplate$v4$compiler$Bytecode$OperandType[Bytecode.OperandType.ADDR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$stringtemplate$v4$compiler$Bytecode$OperandType[Bytecode.OperandType.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public BytecodeDisassembler(CompiledST r5) {
        this.code = r5;
    }

    public static int getShort(byte[] r5, int r10) {
        int r11 = r5[r10] & UByte.MAX_VALUE;
        return (r5[r10 + 1] & UByte.MAX_VALUE) | (r11 << 8);
    }

    private String showConstPoolOperand(int r5) {
        StringBuilder r10 = new StringBuilder("#");
        r10.append(r5);
        String[] r11 = this.code.strings;
        if (r5 >= r11.length) goto L11;
        String r12 = r11[r5];
        if (r12 != null) goto L7;
        String r13 = "null";
    L13:
        return j0.q(r10, ":", r13);
    L7:
        String r14 = r12.toString();
        if (this.code.strings[r5] == null) goto L10;
        r13 = a.p("\"", Typography.quote, Misc.replaceEscapes(r14));
        goto L13
    L10:
        r13 = r14;
        goto L13
    L11:
        r13 = "<bad string index>";
        goto L13
    }

    public String disassemble() {
        StringBuilder r5 = new StringBuilder();
        int r10 = 0;
    L4:
        if (r10 >= this.code.codeSize) goto L7;
        r10 = disassembleInstruction(r5, r10);
        r5.append('\n');
        goto L4
    L7:
        return r5.toString();
    }

    public int disassembleInstruction(StringBuilder r10, int r11) {
        CompiledST r5 = this.code;
        byte r12 = r5.instrs[r11];
        if (r11 >= r5.codeSize) goto L33;
        Bytecode.Instruction r13 = Bytecode.instructions[r12];
        if (r13 == null) goto L31;
        r10.append(String.format("%04d:\t%-14s", new Object[]{Integer.valueOf(r11), r13.name}));
        int r14 = r11 + 1;
        if (r13.nopnds != 0) goto L10;
        r10.append("  ");
        return r14;
    L10:
        ArrayList r15 = new ArrayList();
        int r16 = 0;
        int r17 = 0;
    L12:
        if (r17 >= r13.nopnds) goto L24;
        int r18 = getShort(this.code.instrs, r14);
        r14 = r14 + 2;
        int r19 = AnonymousClass1.$SwitchMap$org$stringtemplate$v4$compiler$Bytecode$OperandType[r13.type[r17].ordinal()];
        if (r19 != 1) goto L16;
        r15.add(showConstPoolOperand(r18));
    L22:
        r17 = r17 + 1;
        goto L12
    L16:
        if (r19 != 2) goto L18;
    L20:
        r15.add(String.valueOf(r18));
        goto L22
    L18:
        if (r19 == 3) goto L20;
        r15.add(String.valueOf(r18));
    L24:
        if (r16 >= r15.size()) goto L29;
        String r20 = (String) r15.get(r16);
        if (r16 <= 0) goto L28;
        r10.append(", ");
    L28:
        r10.append(r20);
        r16 = r16 + 1;
        goto L24
    L29:
        return r14;
    L31:
        throw new IllegalArgumentException(j0.f(r12, r11, "no such instruction ", " at address "));
    L33:
        throw new IllegalArgumentException(j0.g(r11, "ip out of range: "));
    }

    public String instrs() {
        StringBuilder r5 = new StringBuilder();
        int r10 = 0;
    L4:
        if (r10 >= this.code.codeSize) goto L12;
        if (r10 <= 0) goto L7;
        r5.append(", ");
    L7:
        Bytecode.Instruction r11 = Bytecode.instructions[this.code.instrs[r10]];
        r5.append(r11.name);
        r10 = r10 + 1;
        int r12 = 0;
    L9:
        if (r12 >= r11.nopnds) goto L4;
        r5.append(' ');
        r5.append(getShort(this.code.instrs, r10));
        r10 = r10 + 2;
        r12 = r12 + 1;
        goto L9
    L12:
        return r5.toString();
    }

    public String sourceMap() {
        StringBuilder r5 = new StringBuilder();
        Interval[] r10 = this.code.sourceMap;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Interval r14 = r10[r12];
        if (r14 == null) goto L7;
        r5.append(String.format("%04d: %s\t\"%s\"\n", new Object[]{Integer.valueOf(r13), r14, this.code.template.substring(r14.f683a, r14.f684b + 1)}));
    L7:
        r13 = r13 + 1;
        r12 = r12 + 1;
        goto L3
    L9:
        return r5.toString();
    }

    public String strings() {
        StringBuilder r5 = new StringBuilder();
        String[] r10 = this.code.strings;
        if (r10 == null) goto L12;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r12 >= r11) goto L12;
        String r14 = r10[r12];
        if (r14 == null) goto L9;
        r5.append(String.format("%04d: \"%s\"\n", new Object[]{Integer.valueOf(r13), Misc.replaceEscapes(r14)}));
    L10:
        r13 = r13 + 1;
        r12 = r12 + 1;
        goto L5
    L9:
        r5.append(String.format("%04d: %s\n", new Object[]{Integer.valueOf(r13), r14}));
    L12:
        return r5.toString();
    }
}
