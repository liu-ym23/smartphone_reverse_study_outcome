package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Interval;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CompilationState {
    ErrorManager errMgr;
    CompiledST impl;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    int f678ip;
    StringTable stringtable;
    TokenStream tokens;

    public CompilationState(ErrorManager r5, String r10, TokenStream r11) {
        this.impl = new CompiledST();
        this.stringtable = new StringTable();
        this.f678ip = 0;
        this.errMgr = r5;
        this.tokens = r11;
        CompiledST r12 = this.impl;
        r12.name = r10;
        r12.prefix = Misc.getPrefix(r10);
    }

    public static void writeShort(byte[] r5, int r10, short r11) {
        r5[r10] = (byte) ((r11 >> 8) & 255);
        r5[r10 + 1] = (byte) (r11 & 255);
    }

    public int defineString(String r5) {
        return this.stringtable.add(r5);
    }

    public void emit(short r5) {
        emit(null, r5);
    }

    public void emit1(CommonTree r5, short r10, int r11) {
        emit(r5, r10);
        ensureCapacity(2);
        writeShort(this.impl.instrs, this.f678ip, (short) r11);
        this.f678ip += 2;
    }

    public void emit2(CommonTree r5, short r10, int r11, int r12) {
        emit(r5, r10);
        ensureCapacity(4);
        writeShort(this.impl.instrs, this.f678ip, (short) r11);
        int r13 = this.f678ip + 2;
        this.f678ip = r13;
        writeShort(this.impl.instrs, r13, (short) r12);
        this.f678ip += 2;
    }

    public void ensureCapacity(int r5) {
        int r10 = this.f678ip + r5;
        byte[] r11 = this.impl.instrs;
        if (r10 < r11.length) goto L6;
        byte[] r12 = new byte[r11.length * 2];
        System.arraycopy(r11, 0, r12, 0, r11.length);
        CompiledST r13 = this.impl;
        r13.instrs = r12;
        Interval[] r14 = r13.sourceMap;
        Interval[] r15 = new Interval[r14.length * 2];
        System.arraycopy(r14, 0, r15, 0, r14.length);
        this.impl.sourceMap = r15;
        return;
    }

    public void func(Token r5, CommonTree r10) {
        Short r11 = Compiler.funcs.get(r10.getText());
        if (r11 != null) goto L5;
        this.errMgr.compileTimeError(ErrorType.NO_SUCH_FUNCTION, r5, r10.token);
        emit(r10, 43);
        return;
    L5:
        emit(r10, r11.shortValue());
    }

    public void indent(CommonTree r5) {
        emit1(r5, 39, r5.getText());
    }

    public void insert(int r5, short r10, String r11) {
        ensureCapacity(3);
        byte[] r12 = this.impl.instrs;
        int r13 = r5 + 3;
        System.arraycopy(r12, r5, r12, r13, this.f678ip - r5);
        int r14 = this.f678ip;
        this.f678ip = r5;
        emit1(null, r10, r11);
        this.f678ip = r14 + 3;
    L4:
        if (r13 >= this.f678ip) goto L11;
        byte[] r15 = this.impl.instrs;
        byte r16 = r15[r13];
        Bytecode.Instruction r17 = Bytecode.instructions[r16];
        if (r16 != 18) goto L8;
    L9:
        int r18 = r13 + 1;
        int r19 = BytecodeDisassembler.getShort(r15, r18);
        writeShort(this.impl.instrs, r18, (short) (r19 + 3));
    L10:
        r13 = r13 + ((r17.nopnds * 2) + 1);
        goto L4
    L8:
        if (r16 != 19) goto L10;
    }

    public void refAttr(Token r5, CommonTree r10) {
        String r11 = r10.getText();
        Map<String, FormalArgument> r12 = this.impl.formalArguments;
        if (r12 == null) goto L8;
        if (r12.get(r11) == null) goto L8;
        emit1(r10, 3, this.impl.formalArguments.get(r11).index);
        return;
    L8:
        if (Interpreter.predefinedAnonSubtemplateAttributes.contains(r11) == false) goto L10;
        this.errMgr.compileTimeError(ErrorType.REF_TO_IMPLICIT_ATTRIBUTE_OUT_OF_SCOPE, r5, r10.token);
        emit(r10, 44);
        return;
    L10:
        emit1(r10, 2, r11);
    }

    public void setOption(CommonTree r5) {
        emit1(r5, 6, Compiler.supportedOptions.get(r5.getText()).ordinal());
    }

    public void write(int r5, short r10) {
        writeShort(this.impl.instrs, r5, r10);
    }

    public void emit(CommonTree r5, short r10) {
        ensureCapacity(1);
        if (r5 == null) goto L8;
        int r11 = r5.getTokenStartIndex();
        int r12 = r5.getTokenStopIndex();
        int r13 = ((CommonToken) this.tokens.get(r11)).getStartIndex();
        int r14 = ((CommonToken) this.tokens.get(r12)).getStopIndex();
        if (r13 < 0) goto L8;
        if (r14 < 0) goto L8;
        this.impl.sourceMap[this.f678ip] = new Interval(r13, r14);
    L8:
        byte[] r15 = this.impl.instrs;
        int r16 = this.f678ip;
        this.f678ip = r16 + 1;
        r15[r16] = (byte) r10;
    }

    public void emit1(CommonTree r5, short r10, String r11) {
        emit1(r5, r10, defineString(r11));
    }

    public void emit2(CommonTree r5, short r10, String r11, int r12) {
        emit2(r5, r10, defineString(r11), r12);
    }
}
