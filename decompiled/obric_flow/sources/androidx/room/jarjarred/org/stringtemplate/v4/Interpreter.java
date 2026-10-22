package androidx.room.jarjarred.org.stringtemplate.v4;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.BytecodeDisassembler;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.CompiledST;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.Compiler;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.FormalArgument;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.EvalExprEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.EvalTemplateEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.IndentEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.InterpEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ArrayIterator;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Interval;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.STNoSuchAttributeException;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.STNoSuchPropertyException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class Interpreter {
    public static final int DEFAULT_OPERAND_STACK_SIZE = 100;
    public static final Set<String> predefinedAnonSubtemplateAttributes = null;
    public static boolean trace;
    public boolean debug;
    ErrorManager errMgr;
    protected List<InterpEvent> events;
    protected List<String> executeTrace;
    STGroup group;
    Locale locale;
    int nwline;
    Object[] operands;

    /* JADX INFO: renamed from: sp, reason: collision with root package name */
    int f676sp;

    public static class ArgumentsMap extends HashMap<String, Object> {
        public ArgumentsMap() {
        }
    }

    public static class ObjectList extends ArrayList<Object> {
        public ObjectList() {
        }
    }

    public static final enum Option extends Enum<Option> {
        private static final /* synthetic */ Option[] $VALUES = null;
        public static final Option ANCHOR = null;
        public static final Option FORMAT = null;
        public static final Option NULL = null;
        public static final Option SEPARATOR = null;
        public static final Option WRAP = null;

        static {
            Option r5 = new Option("ANCHOR", 0);
            ANCHOR = r5;
            Option r10 = new Option("FORMAT", 1);
            FORMAT = r10;
            Option r11 = new Option("NULL", 2);
            NULL = r11;
            Option r12 = new Option("SEPARATOR", 3);
            SEPARATOR = r12;
            Option r13 = new Option("WRAP", 4);
            WRAP = r13;
            $VALUES = new Option[]{r5, r10, r11, r12, r13};
        }

        private Option(String r5, int r10) {
            super(r5, r10);
        }

        public static Option valueOf(String r5) {
            return (Option) Enum.valueOf(Option.class, r5);
        }

        public static Option[] values() {
            return (Option[]) $VALUES.clone();
        }
    }

    static {
        predefinedAnonSubtemplateAttributes = new AnonymousClass1();
        trace = false;
    }

    public Interpreter(STGroup r5, boolean r10) {
        this(r5, Locale.getDefault(), r5.errMgr, r10);
    }

    public static List<ST> getEnclosingInstanceStack(InstanceScope r5, boolean r10) {
        LinkedList r11 = new LinkedList();
    L3:
        if (r5 == null) goto L8;
        if (r10 == false) goto L6;
        r11.add(0, r5.f675st);
    L7:
        r5 = r5.parent;
        goto L3
    L6:
        r11.add(r5.f675st);
        goto L7
    L8:
        return r11;
    }

    public static String getEnclosingInstanceStackString(InstanceScope r5) {
        List<ST> r10 = getEnclosingInstanceStack(r5, true);
        StringBuilder r11 = new StringBuilder();
        Iterator<ST> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L10;
        ST r14 = r12.next();
        if (r13 <= 0) goto L8;
        r11.append(" ");
    L8:
        r11.append(r14.getName());
        r13 = r13 + 1;
        goto L4
    L10:
        return r11.toString();
    }

    public static List<EvalTemplateEvent> getEvalTemplateEventStack(InstanceScope r5, boolean r10) {
        LinkedList r11 = new LinkedList();
    L3:
        if (r5 == null) goto L9;
        EvalTemplateEvent r12 = (EvalTemplateEvent) j0.e(r5.events, 1);
        if (r10 == false) goto L7;
        r11.add(0, r12);
    L8:
        r5 = r5.parent;
        goto L3
    L7:
        r11.add(r12);
        goto L8
    L9:
        return r11;
    }

    public static List<InstanceScope> getScopeStack(InstanceScope r5, boolean r10) {
        LinkedList r11 = new LinkedList();
    L3:
        if (r5 == null) goto L8;
        if (r10 == false) goto L6;
        r11.add(0, r5);
    L7:
        r5 = r5.parent;
        goto L3
    L6:
        r11.add(r5);
        goto L7
    L8:
        return r11;
    }

    public static int getShort(byte[] r5, int r10) {
        int r11 = r5[r10] & UByte.MAX_VALUE;
        return (r5[r10 + 1] & UByte.MAX_VALUE) | (r11 << 8);
    }

    public int _exec(STWriter r19, InstanceScope r20) {
        ST r10 = r20.f675st;
        int r11 = r19.index();
        byte[] r12 = r10.impl.instrs;
        int r5 = 0;
        short r13 = 0;
        int r14 = 0;
    L3:
        boolean r15 = true;
        if (r5 >= r10.impl.codeSize) goto L113;
        if (trace == false) goto L8;
    L9:
        trace(r20, r5);
    L10:
        short r16 = r12[r5];
        r20.f674ip = r5;
        int r17 = r5 + 1;
        Object r18 = null;
        switch(r16) {
            case 1: goto L110;
            case 2: goto L103;
            case 3: goto L98;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            case 8: goto L93;
            case 9: goto L92;
            case 10: goto L91;
            case 11: goto L90;
            case 12: goto L89;
            case 13: goto L88;
            case 14: goto L87;
            case 15: goto L86;
            case 16: goto L80;
            case 17: goto L76;
            case 18: goto L75;
            case 19: goto L72;
            case 20: goto L71;
            case 21: goto L70;
            case 22: goto L69;
            case 23: goto L12;
            case 24: goto L68;
            case 25: goto L67;
            case 26: goto L66;
            case 27: goto L65;
            case 28: goto L64;
            case 29: goto L63;
            case 30: goto L62;
            case 31: goto L61;
            case 32: goto L57;
            case 33: goto L56;
            case 34: goto L51;
            case 35: goto L50;
            case 36: goto L49;
            case 37: goto L42;
            case 38: goto L35;
            case 39: goto L34;
            case 40: goto L33;
            case 41: goto L21;
            case 42: goto L13;
            case 43: goto L19;
            case 44: goto L18;
            case 45: goto L17;
            case 46: goto L16;
            case 47: goto L14;
            default: goto L12;
        };
    L12:
        this.errMgr.internalError(r10, j0.f(r5, r16, "invalid bytecode @ ", ": "), null);
        r10.impl.dump();
    L13:
        int r21 = r17;
        short r110 = r16;
    L74:
        r5 = r21;
    L111:
        r13 = r110;
        goto L3
    L14:
        r5 = r5 + 3;
        int r22 = writeObjectNoOptions(r19, r20, r10.impl.strings[getShort(r12, r17)]);
        r14 = r14 + r22;
        this.nwline += r22;
    L15:
        r110 = r16;
        goto L111
    L16:
        Object[] r23 = this.operands;
        int r24 = this.f676sp + 1;
        this.f676sp = r24;
        r23[r24] = Boolean.FALSE;
        goto L13
    L17:
        Object[] r25 = this.operands;
        int r26 = this.f676sp + 1;
        this.f676sp = r26;
        r25[r26] = Boolean.TRUE;
        goto L13
    L18:
        Object[] r27 = this.operands;
        int r28 = this.f676sp + 1;
        this.f676sp = r28;
        r27[r28] = null;
        goto L13
    L19:
        this.f676sp--;
        goto L13
    L33:
        r19.popIndentation();
        goto L13
    L34:
        r5 = r5 + 3;
        indent(r19, r20, getShort(r12, r17));
        goto L15
    L35:
        Object[] r29 = this.operands;
        int r30 = this.f676sp;
        int r31 = r30 - 1;
        this.f676sp = r31;
        Object r32 = r29[r30];
        this.f676sp = r30 - 2;
        Object r33 = r29[r31];
        int r34 = r30 - 1;
        this.f676sp = r34;
        if (testAttributeTrue(r33) == true) goto L38;
    L40:
        r15 = false;
    L41:
        r29[r34] = Boolean.valueOf(r15);
        goto L13
    L38:
        if (testAttributeTrue(r32) == false) goto L40;
    L42:
        Object[] r35 = this.operands;
        int r36 = this.f676sp;
        int r37 = r36 - 1;
        this.f676sp = r37;
        Object r38 = r35[r36];
        this.f676sp = r36 - 2;
        Object r39 = r35[r37];
        int r40 = r36 - 1;
        this.f676sp = r40;
        if (testAttributeTrue(r39) == false) goto L45;
    L48:
        r35[r40] = Boolean.valueOf(r15);
        goto L13
    L45:
        if (testAttributeTrue(r38) == true) goto L48;
        r15 = false;
        goto L48
    L49:
        Object[] r41 = this.operands;
        int r42 = this.f676sp;
        r41[r42] = Boolean.valueOf(!testAttributeTrue(r41[r42]));
        goto L13
    L50:
        Object[] r43 = this.operands;
        int r44 = this.f676sp;
        r43[r44] = reverse(r20, r43[r44]);
        goto L13
    L51:
        Object[] r45 = this.operands;
        int r46 = this.f676sp;
        this.f676sp = r46 - 1;
        Object r47 = r45[r46];
        if (r47.getClass() != String.class) goto L54;
        Object[] r48 = this.operands;
        int r49 = this.f676sp + 1;
        this.f676sp = r49;
        r48[r49] = Integer.valueOf(((String) r47).length());
        goto L13
    L54:
        int r111 = r17;
        r110 = r16;
        this.errMgr.runTimeError(this, r20, ErrorType.EXPECTING_STRING, "strlen", r47.getClass().getName());
        Object[] r50 = this.operands;
        int r51 = this.f676sp + 1;
        this.f676sp = r51;
        r50[r51] = 0;
    L55:
        r21 = r111;
        goto L74
    L56:
        r111 = r17;
        r110 = r16;
        Object[] r52 = this.operands;
        int r53 = this.f676sp;
        r52[r53] = length(r52[r53]);
        goto L55
    L57:
        r111 = r17;
        r110 = r16;
        Object[] r54 = this.operands;
        int r55 = this.f676sp;
        this.f676sp = r55 - 1;
        Object r56 = r54[r55];
        if (r56.getClass() != String.class) goto L60;
        Object[] r57 = this.operands;
        int r58 = this.f676sp + 1;
        this.f676sp = r58;
        r57[r58] = ((String) r56).trim();
        goto L55
    L60:
        this.errMgr.runTimeError(this, r20, ErrorType.EXPECTING_STRING, "trim", r56.getClass().getName());
        Object[] r59 = this.operands;
        int r60 = this.f676sp + 1;
        this.f676sp = r60;
        r59[r60] = r56;
        goto L55
    L61:
        r111 = r17;
        r110 = r16;
        Object[] r61 = this.operands;
        int r62 = this.f676sp;
        r61[r62] = strip(r20, r61[r62]);
        goto L55
    L62:
        r111 = r17;
        r110 = r16;
        Object[] r63 = this.operands;
        int r64 = this.f676sp;
        r63[r64] = trunc(r20, r63[r64]);
        goto L55
    L63:
        r111 = r17;
        r110 = r16;
        Object[] r65 = this.operands;
        int r66 = this.f676sp;
        r65[r66] = rest(r20, r65[r66]);
        goto L55
    L64:
        r111 = r17;
        r110 = r16;
        Object[] r67 = this.operands;
        int r68 = this.f676sp;
        r67[r68] = last(r20, r67[r68]);
        goto L55
    L65:
        r111 = r17;
        r110 = r16;
        Object[] r69 = this.operands;
        int r70 = this.f676sp;
        r69[r70] = first(r20, r69[r70]);
        goto L55
    L66:
        r111 = r17;
        r110 = r16;
        Object[] r71 = this.operands;
        int r72 = this.f676sp;
        r71[r72] = toString(r19, r20, r71[r72]);
        goto L55
    L67:
        r111 = r17;
        r110 = r16;
        Object[] r73 = this.operands;
        int r74 = this.f676sp;
        int r75 = r74 - 1;
        this.f676sp = r75;
        addToList(r20, (ObjectList) r73[r75], r73[r74]);
        goto L55
    L68:
        r111 = r17;
        r110 = r16;
        Object[] r76 = this.operands;
        int r77 = this.f676sp + 1;
        this.f676sp = r77;
        r76[r77] = new ObjectList();
        goto L55
    L69:
        r110 = r16;
        r5 = r5 + 3;
        passthru(r20, r10.impl.strings[getShort(r12, r17)], (ArgumentsMap) this.operands[this.f676sp]);
        goto L111
    L70:
        r21 = r17;
        r110 = r16;
        Object[] r78 = this.operands;
        int r79 = this.f676sp + 1;
        this.f676sp = r79;
        r78[r79] = new ArgumentsMap();
        goto L74
    L71:
        r21 = r17;
        r110 = r16;
        Object[] r80 = this.operands;
        int r81 = this.f676sp + 1;
        this.f676sp = r81;
        r80[r81] = new Object[Compiler.NUM_OPTIONS];
        goto L74
    L72:
        r110 = r16;
        r21 = getShort(r12, r17);
        r5 = r5 + 3;
        Object[] r82 = this.operands;
        int r83 = this.f676sp;
        this.f676sp = r83 - 1;
        if (testAttributeTrue(r82[r83]) == true) goto L111;
    L75:
        r110 = r16;
        r5 = getShort(r12, r17);
        goto L111
    L76:
        r110 = r16;
        Object[] r84 = this.operands;
        int r85 = this.f676sp;
        this.f676sp = r85 - 1;
        ST r86 = (ST) r84[r85];
        int r87 = getShort(r12, r17);
        r5 = r5 + 3;
        ObjectList r88 = new ObjectList();
        int r89 = r87 - 1;
    L77:
        if (r89 < 0) goto L79;
        r88.add(this.operands[this.f676sp - r89]);
        r89 = r89 - 1;
        goto L77
    L79:
        int r90 = this.f676sp - r87;
        Object[] r91 = this.operands;
        int r92 = r90 + 1;
        this.f676sp = r92;
        r91[r92] = zip_map(r20, r88, r86);
        goto L111
    L80:
        r110 = r16;
        int r93 = getShort(r12, r17);
        r5 = r5 + 3;
        ArrayList r94 = new ArrayList();
        int r95 = r93 - 1;
    L81:
        if (r95 < 0) goto L83;
        r94.add((ST) this.operands[this.f676sp - r95]);
        r95 = r95 - 1;
        goto L81
    L83:
        int r96 = this.f676sp - r93;
        Object[] r97 = this.operands;
        this.f676sp = r96 - 1;
        Object r98 = r97[r96];
        if (r98 == null) goto L111;
        rot_map(r20, r98, r94);
        goto L111
    L86:
        r21 = r17;
        r110 = r16;
        Object[] r99 = this.operands;
        int r100 = this.f676sp;
        int r101 = r100 - 1;
        this.f676sp = r101;
        ST r102 = (ST) r99[r100];
        this.f676sp = r100 - 2;
        map(r20, r99[r101], r102);
        goto L74
    L87:
        r21 = r17;
        r110 = r16;
        Object[] r103 = this.operands;
        int r104 = this.f676sp;
        int r105 = r104 - 1;
        this.f676sp = r105;
        Object[] r106 = (Object[]) r103[r104];
        this.f676sp = r104 - 2;
        int r107 = writeObjectWithOptions(r19, r20, r103[r105], r106);
        r14 = r14 + r107;
        this.nwline += r107;
        goto L74
    L88:
        r21 = r17;
        r110 = r16;
        Object[] r108 = this.operands;
        int r109 = this.f676sp;
        this.f676sp = r109 - 1;
        int r112 = writeObjectNoOptions(r19, r20, r108[r109]);
        r14 = r14 + r112;
        this.nwline += r112;
        goto L74
    L89:
        r110 = r16;
        r5 = r5 + 3;
        String r113 = r10.impl.strings[getShort(r12, r17)];
        Object[] r114 = this.operands;
        int r115 = this.f676sp;
        this.f676sp = r115 - 1;
        super_new(r20, r113, (ArgumentsMap) r114[r115]);
        goto L111
    L90:
        r110 = r16;
        String r116 = r10.impl.strings[getShort(r12, r17)];
        int r117 = getShort(r12, r5 + 3);
        r5 = r5 + 5;
        super_new(r20, r116, r117);
        goto L111
    L91:
        r110 = r16;
        r5 = r5 + 3;
        String r118 = r10.impl.strings[getShort(r12, r17)];
        Object[] r119 = this.operands;
        int r120 = this.f676sp;
        this.f676sp = r120 - 1;
        Map<String, Object> r121 = (ArgumentsMap) r119[r120];
        ST r122 = r10.groupThatCreatedThisInstance.getEmbeddedInstanceOf(this, r20, r118);
        storeArgs(r20, r121, r122);
        Object[] r123 = this.operands;
        int r124 = this.f676sp + 1;
        this.f676sp = r124;
        r123[r124] = r122;
        goto L111
    L92:
        r110 = r16;
        int r125 = getShort(r12, r17);
        r5 = r5 + 3;
        ST r126 = r10.groupThatCreatedThisInstance.getEmbeddedInstanceOf(this, r20, (String) this.operands[this.f676sp - r125]);
        storeArgs(r20, r125, r126);
        int r127 = this.f676sp - r125;
        Object[] r128 = this.operands;
        this.f676sp = r127;
        r128[r127] = r126;
        goto L111
    L93:
        r110 = r16;
        String r129 = r10.impl.strings[getShort(r12, r17)];
        int r130 = getShort(r12, r5 + 3);
        r5 = r5 + 5;
        ST r131 = r10.groupThatCreatedThisInstance.getEmbeddedInstanceOf(this, r20, r129);
        storeArgs(r20, r130, r131);
        int r132 = this.f676sp - r130;
        Object[] r133 = this.operands;
        int r134 = r132 + 1;
        this.f676sp = r134;
        r133[r134] = r131;
        goto L111
    L94:
        r110 = r16;
        String r135 = r10.impl.strings[getShort(r12, r17)];
        r5 = r5 + 3;
        Object[] r136 = this.operands;
        int r137 = this.f676sp;
        int r138 = r137 - 1;
        this.f676sp = r138;
        ((ArgumentsMap) r136[r138]).put(r135, r136[r137]);
        goto L111
    L95:
        r110 = r16;
        int r139 = getShort(r12, r17);
        r5 = r5 + 3;
        Object[] r140 = this.operands;
        int r141 = this.f676sp;
        int r142 = r141 - 1;
        this.f676sp = r142;
        ((Object[]) r140[r142])[r139] = r140[r141];
        goto L111
    L96:
        r21 = r17;
        r110 = r16;
        Object[] r143 = this.operands;
        int r144 = this.f676sp;
        int r145 = r144 - 1;
        this.f676sp = r145;
        r143[r145] = getObjectProperty(r19, r20, r143[r145], r143[r144]);
        goto L74
    L97:
        r110 = r16;
        int r146 = getShort(r12, r17);
        r5 = r5 + 3;
        Object[] r147 = this.operands;
        int r148 = this.f676sp;
        this.f676sp = r148 - 1;
        Object r149 = r147[r148];
        Object r150 = r10.impl.strings[r146];
        this.f676sp = r148;
        r147[r148] = getObjectProperty(r19, r20, r149, r150);
        goto L111
    L98:
        r110 = r16;
        r5 = r5 + 3;
        Object r151 = r10.locals[getShort(r12, r17)];
        if (r151 == ST.EMPTY_ATTR) goto L102;
        r18 = r151;
    L102:
        Object[] r152 = this.operands;
        int r153 = this.f676sp + 1;
        this.f676sp = r153;
        r152[r153] = r18;
        goto L111
    L103:
        r110 = r16;
        r5 = r5 + 3;
        String r154 = r10.impl.strings[getShort(r12, r17)];
        Object r155 = getAttribute(r20, r154);     // Catch: STNoSuchAttributeException -> L108
        if (r155 == ST.EMPTY_ATTR) goto L109;
        r18 = r155;
    L109:
        Object[] r156 = this.operands;
        int r157 = this.f676sp + 1;
        this.f676sp = r157;
        r156[r157] = r18;
    L108:
        this.errMgr.runTimeError(this, r20, ErrorType.NO_SUCH_ATTRIBUTE, r154);
        goto L109
    L110:
        r110 = r16;
        load_str(r10, r17);
        r5 = r5 + 3;
        goto L111
    L21:
        if (r13 != 41) goto L23;
    L29:
        r19.write(Misc.newline);     // Catch: IOException -> L27
    L30:
        this.nwline = 0;     // Catch: IOException -> L27
        goto L13
    L23:
        if (r13 == 39) goto L29;
        if (this.nwline <= 0) goto L30;
    L27:
        e = move-exception;
        this.errMgr.IOError(r10, ErrorType.WRITE_IO_ERROR, e);
        goto L13
    L8:
        if (this.debug == false) goto L10;
    L113:
        if (this.debug == false) goto L115;
        trackDebugEvent(r20, new EvalTemplateEvent(r20, r11, r19.index() - 1));
    L115:
        return r14;
    }

    public void addToList(InstanceScope r5, List<Object> r10, Object r11) {
        Object r12 = convertAnythingIteratableToIterator(r5, r11);
        if ((r12 instanceof Iterator) == false) goto L8;
        Iterator r13 = (Iterator) r12;
    L6:
        if (r13.hasNext() == false) goto L11;
        r10.add(r13.next());
        goto L6
    L11:
        return;
    L8:
        r10.add(r12);
    }

    public Object convertAnythingIteratableToIterator(InstanceScope r5, Object r10) {
        Object r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Collection) == false) goto L9;
        r11 = ((Collection) r10).iterator();
    L20:
        if (r11 != null) goto L22;
        return r10;
    L22:
        return r11;
    L9:
        if ((r10 instanceof Object[]) == false) goto L12;
        r11 = Arrays.asList((Object[]) r10).iterator();
        goto L20
    L12:
        if (r10.getClass().isArray() == false) goto L15;
        r11 = new ArrayIterator(r10);
        goto L20
    L15:
        if ((r10 instanceof Map) == false) goto L20;
        if (r5.f675st.groupThatCreatedThisInstance.iterateAcrossValues == false) goto L19;
        r11 = ((Map) r10).values().iterator();
        goto L20
    L19:
        r11 = ((Map) r10).keySet().iterator();
        goto L20
    }

    public Iterator<?> convertAnythingToIterator(InstanceScope r5, Object r10) {
        Object r11 = convertAnythingIteratableToIterator(r5, r10);
        if ((r11 instanceof Iterator) == true) goto L5;
        ST.AttributeList r12 = new ST.AttributeList(1);
        r12.add(r11);
        return r12.iterator();
    L5:
        return (Iterator) r11;
    }

    public int exec(STWriter r5, InstanceScope r10) {
        ST r11 = r10.f675st;
        if (trace == false) goto L10;
        System.out.println("exec(" + r11.getName() + ")");
    L10:
        setDefaultArguments(r5, r10);     // Catch: Exception -> L7
        return _exec(r5, r10);
    L7:
        e = move-exception;
        StringWriter r12 = new StringWriter();
        PrintWriter r13 = new PrintWriter(r12);
        e.printStackTrace(r13);
        r13.flush();
        this.errMgr.runTimeError(this, r10, ErrorType.INTERNAL_ERROR, "internal error: " + r12.toString());
        return 0;
    }

    public Object first(InstanceScope r5, Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = convertAnythingIteratableToIterator(r5, r10);
        if ((r11 instanceof Iterator) == false) goto L11;
        Iterator r12 = (Iterator) r11;
        if (r12.hasNext() == true) goto L10;
        return r10;
    L10:
        return r12.next();
    L11:
        return r10;
    }

    public Object getAttribute(InstanceScope r5, String r10) {
        InstanceScope r11 = r5;
    L3:
        if (r11 == null) goto L12;
        ST r12 = r11.f675st;
        Map<String, FormalArgument> r13 = r12.impl.formalArguments;
        if (r13 == null) goto L7;
        FormalArgument r14 = r13.get(r10);
    L8:
        if (r14 != null) goto L10;
        r11 = r11.parent;
        goto L3
    L10:
        return r12.locals[r14.index];
    L7:
        r14 = null;
        goto L8
    L12:
        Object r15 = getDictionary(r5.f675st.impl.nativeGroup, r10);
        if (r15 == null) goto L16;
        return r15;
    L16:
        throw new STNoSuchAttributeException(r10, r5);
    }

    public Object getDictionary(STGroup r5, String r10) {
        if (r5.isDictionary(r10) == true) goto L5;
        List<STGroup> r11 = r5.imports;
        if (r11 == null) goto L14;
        Iterator<STGroup> r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L19;
        Object r13 = getDictionary(r12.next(), r10);
        if (r13 == null) goto L10;
        return r13;
    L19:
        return null;
    L14:
        return null;
    L5:
        return r5.rawGetDictionary(r10);
    }

    public List<InterpEvent> getEvents() {
        return this.events;
    }

    public List<String> getExecutionTrace() {
        return this.executeTrace;
    }

    public int getExprStartChar(InstanceScope r5) {
        Interval r10 = r5.f675st.impl.sourceMap[r5.f674ip];
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.f683a;
    }

    public int getExprStopChar(InstanceScope r5) {
        Interval r10 = r5.f675st.impl.sourceMap[r5.f674ip];
        if (r10 != null) goto L5;
        return -1;
    L5:
        return r10.f684b;
    }

    public Object getObjectProperty(STWriter r10, InstanceScope r11, Object r12, Object r13) {
        if (r12 != null) goto L11;
        this.errMgr.runTimeError(this, r11, ErrorType.NO_SUCH_PROPERTY, "null." + r13);
        return null;
    L11:
        ST r5 = r11.f675st;     // Catch: STNoSuchPropertyException -> L8
        return r5.groupThatCreatedThisInstance.getModelAdaptor(r12.getClass()).getProperty(this, r5, r12, r13, toString(r10, r11, r13));
    L8:
        e = move-exception;
        this.errMgr.runTimeError(this, r11, ErrorType.NO_SUCH_PROPERTY, e, r12.getClass().getName() + "." + r13);
        return null;
    }

    public void indent(STWriter r10, InstanceScope r11, int r12) {
        String r13 = r11.f675st.impl.strings[r12];
        if (this.debug == false) goto L5;
        int r5 = r10.index();
        trackDebugEvent(r11, new IndentEvent(r11, r5, (r13.length() + r5) - 1, getExprStartChar(r11), getExprStopChar(r11)));
    L5:
        r10.pushIndentation(r13);
    }

    public Object last(InstanceScope r5, Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof List) == false) goto L10;
        return j0.e((List) r10, 1);
    L10:
        if (r10.getClass().isArray() == true) goto L12;
        Object r11 = convertAnythingIteratableToIterator(r5, r10);
        if ((r11 instanceof Iterator) == false) goto L19;
        Iterator r12 = (Iterator) r11;
    L17:
        if (r12.hasNext() == false) goto L19;
        r10 = r12.next();
    L19:
        return r10;
    L12:
        return Array.get(r10, Array.getLength(r10) - 1);
    }

    public Object length(Object r5) {
        int r10 = 0;
        if (r5 != null) goto L7;
        return 0;
    L7:
        if ((r5 instanceof Map) == false) goto L10;
        r10 = ((Map) r5).size();
    L26:
        return Integer.valueOf(r10);
    L10:
        if ((r5 instanceof Collection) == false) goto L13;
        r10 = ((Collection) r5).size();
        goto L26
    L13:
        if ((r5 instanceof Object[]) == false) goto L16;
        r10 = ((Object[]) r5).length;
        goto L26
    L16:
        if (r5.getClass().isArray() == false) goto L19;
        r10 = Array.getLength(r5);
        goto L26
    L19:
        if ((r5 instanceof Iterator) == false) goto L24;
        Iterator r11 = (Iterator) r5;
    L22:
        if (r11.hasNext() == false) goto L26;
        r11.next();
        r10 = r10 + 1;
        goto L22
    L24:
        r10 = 1;
        goto L26
    }

    public void load_str(ST r5, int r10) {
        int r11 = getShort(r5.impl.instrs, r10);
        Object[] r12 = this.operands;
        int r13 = this.f676sp + 1;
        this.f676sp = r13;
        r12[r13] = r5.impl.strings[r11];
    }

    public void map(InstanceScope r5, Object r10, final ST r11) {
        rot_map(r5, r10, new AnonymousClass2(this, r11));
    }

    public void passthru(InstanceScope r10, String r11, Map<String, Object> r12) {
        CompiledST r13 = this.group.lookupTemplate(r11);
        if (r13 != null) goto L5;
        return;
    L5:
        Map<String, FormalArgument> r14 = r13.formalArguments;
        if (r14 != null) goto L8;
        return;
    L8:
        Iterator<FormalArgument> r15 = r14.values().iterator();
    L10:
        if (r15.hasNext() == false) goto L25;
        FormalArgument r5 = r15.next();
        if (r12.containsKey(r5.name) == true) goto L10;
        Object r16 = getAttribute(r10, r5.name);     // Catch: STNoSuchAttributeException -> L22
        Object r17 = ST.EMPTY_ATTR;     // Catch: STNoSuchAttributeException -> L22
        if (r16 != r17) goto L19;
        if (r5.defaultValueToken != null) goto L19;
        r12.put(r5.name, null);     // Catch: STNoSuchAttributeException -> L22
    L19:
        if (r16 == r17) goto L10;
        r12.put(r5.name, r16);     // Catch: STNoSuchAttributeException -> L22
    L23:
        if (r5.defaultValueToken != null) goto L10;
        this.errMgr.runTimeError(this, r10, ErrorType.NO_SUCH_ATTRIBUTE_PASS_THROUGH, r5.name);
        r12.put(r5.name, null);
        goto L10
    }

    public void printForTrace(StringBuilder r5, InstanceScope r10, Object r11) {
        if ((r11 instanceof ST) == false) goto L9;
        ST r12 = (ST) r11;
        if (r12.impl != null) goto L7;
        r5.append("bad-template()");
        return;
    L7:
        r5.append(" " + r12.impl.name + "()");
        return;
    L9:
        Object r13 = convertAnythingIteratableToIterator(r10, r11);
        if ((r13 instanceof Iterator) == false) goto L16;
        Iterator r14 = (Iterator) r13;
        r5.append(" [");
    L13:
        if (r14.hasNext() == false) goto L15;
        printForTrace(r5, r10, r14.next());
        goto L13
    L15:
        r5.append(" ]");
        return;
    L16:
        r5.append(" " + r13);
    }

    public Object rest(InstanceScope r5, Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof List) == false) goto L12;
        List r11 = (List) r10;
        if (r11.size() > 1) goto L11;
        return null;
    L11:
        return r11.subList(1, r11.size());
    L12:
        Object r12 = convertAnythingIteratableToIterator(r5, r10);
        if ((r12 instanceof Iterator) == false) goto L22;
        ArrayList r13 = new ArrayList();
        Iterator r14 = (Iterator) r12;
        if (r14.hasNext() == true) goto L17;
        return null;
    L17:
        r14.next();
    L19:
        if (r14.hasNext() == false) goto L21;
        r13.add(r14.next());
        goto L19
    L21:
        return r13;
    L22:
        return null;
    }

    public Object reverse(InstanceScope r5, Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = convertAnythingIteratableToIterator(r5, r10);
        if ((r11 instanceof Iterator) == false) goto L12;
        LinkedList r12 = new LinkedList();
        Iterator r13 = (Iterator) r11;
    L9:
        if (r13.hasNext() == false) goto L11;
        r12.add(0, r13.next());
        goto L9
    L11:
        return r12;
    L12:
        return r11;
    }

    public void rot_map(InstanceScope r5, Object r10, List<ST> r11) {
        if (r10 != null) goto L6;
        Object[] r12 = this.operands;
        int r13 = this.f676sp + 1;
        this.f676sp = r13;
        r12[r13] = null;
        return;
    L6:
        Object r14 = convertAnythingIteratableToIterator(r5, r10);
        if ((r14 instanceof Iterator) == false) goto L9;
        List<ST> r15 = rot_map_iterator(r5, (Iterator) r14, r11);
        Object[] r16 = this.operands;
        int r17 = this.f676sp + 1;
        this.f676sp = r17;
        r16[r17] = r15;
        return;
    L9:
        ST r18 = r11.get(0);
        ST r19 = this.group.createStringTemplateInternally(r18);
        if (r19 == null) goto L15;
        setFirstArgument(r5, r19, r14);
        if (r19.impl.isAnonSubtemplate == false) goto L14;
        r19.rawSetAttribute("i0", 0);
        r19.rawSetAttribute("i", 1);
    L14:
        Object[] r20 = this.operands;
        int r21 = this.f676sp + 1;
        this.f676sp = r21;
        r20[r21] = r19;
        return;
    L15:
        Object[] r22 = this.operands;
        int r23 = this.f676sp + 1;
        this.f676sp = r23;
        r22[r23] = null;
    }

    public List<ST> rot_map_iterator(InstanceScope r10, Iterator<?> r11, List<ST> r12) {
        ArrayList r5 = new ArrayList();
        int r13 = 0;
        int r14 = 1;
        int r15 = 0;
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r16 = r11.next();
        if (r16 == null) goto L7;
        int r17 = r13 % r12.size();
        r13 = r13 + 1;
        ST r18 = this.group.createStringTemplateInternally(r12.get(r17));
        setFirstArgument(r10, r18, r16);
        if (r18.impl.isAnonSubtemplate == false) goto L11;
        r18.rawSetAttribute("i0", Integer.valueOf(r15));
        r18.rawSetAttribute("i", Integer.valueOf(r14));
    L11:
        r5.add(r18);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L4
    L7:
        r5.add(null);
        goto L4
    L12:
        return r5;
    }

    public void setDefaultArguments(STWriter r10, InstanceScope r11) {
        ST r5 = r11.f675st;
        CompiledST r12 = r5.impl;
        Map<String, FormalArgument> r13 = r12.formalArguments;
        if (r13 != null) goto L5;
        return;
    L5:
        if (r12.numberOfArgsWithDefaultValues == 0) goto L42;
        Iterator<FormalArgument> r14 = r13.values().iterator();
    L9:
        if (r14.hasNext() == false) goto L43;
        FormalArgument r15 = r14.next();
        if (r5.locals[r15.index] != ST.EMPTY_ATTR) goto L9;
        Token r16 = r15.defaultValueToken;
        if (r16 == null) goto L9;
        if (r16.getType() == 4) goto L17;
        r5.rawSetAttribute(r15.name, r15.defaultValue);
        goto L9
    L17:
        CompiledST r17 = r15.compiledDefaultValue;
        if (r17 != null) goto L20;
        r17 = new CompiledST();
    L20:
        ST r18 = this.group.createStringTemplateInternally(r17);
        r18.groupThatCreatedThisInstance = this.group;
        String r19 = r15.defaultValueToken.getText();
        if (r19.startsWith("{" + this.group.delimiterStartChar + "(") == false) goto L25;
        if (r19.endsWith(")" + this.group.delimiterStopChar + "}") == false) goto L25;
        r5.rawSetAttribute(r15.name, toString(r10, new InstanceScope(r11, r5), r18));
    L25:
        r5.rawSetAttribute(r15.name, r18);
        goto L9
    L43:
        return;
    }

    public void setFirstArgument(InstanceScope r10, ST r11, Object r12) {
        CompiledST r5 = r11.impl;
        if (r5.hasFormalArgs == true) goto L9;
        if (r5.formalArguments != null) goto L9;
        r11.add(ST.IMPLICIT_ARG_NAME, r12);
        return;
    L9:
        if (r5.formalArguments != null) goto L12;
        this.errMgr.runTimeError(this, r10, ErrorType.ARGUMENT_COUNT_MISMATCH, 1, r11.impl.name, 0);
        return;
    L12:
        r11.locals[0] = r12;
    }

    public void storeArgs(InstanceScope r13, Map<String, Object> r14, ST r15) {
        CompiledST r5 = r15.impl;
        if (r5.hasFormalArgs == false) goto L29;
        Map<String, FormalArgument> r10 = r5.formalArguments;
        if (r10 != null) goto L7;
        r10 = Collections.emptyMap();
    L7:
        Iterator<Map.Entry<String, FormalArgument>> r11 = r10.entrySet().iterator();
    L8:
        boolean r12 = true;
        int r16 = 0;
        if (r11.hasNext() == false) goto L19;
        Map.Entry<String, FormalArgument> r17 = r11.next();
        if (r17.getValue().defaultValueToken != null) goto L8;
        if (r17.getValue().defaultValue != null) goto L8;
        if (r14 == null) goto L18;
        if (r14.containsKey(r17.getKey()) == true) goto L8;
    L18:
        boolean r18 = true;
    L20:
        if (r14 != null) goto L22;
    L24:
        r12 = r18;
    L25:
        if (r12 == false) goto L29;
        if (r14 == null) goto L28;
        r16 = r14.size();
    L28:
        this.errMgr.runTimeError(this, r13, ErrorType.ARGUMENT_COUNT_MISMATCH, Integer.valueOf(r16), r15.impl.name, Integer.valueOf(r10.size()));
        goto L29
    L22:
        if (r14.size() <= r10.size()) goto L24;
    L19:
        r18 = false;
    L29:
        if (r14 == null) goto L51;
        Iterator<Map.Entry<String, Object>> r19 = r14.entrySet().iterator();
    L32:
        if (r19.hasNext() == false) goto L76;
        Map.Entry<String, Object> r20 = r19.next();
        CompiledST r21 = r15.impl;
        if (r21.hasFormalArgs == false) goto L35;
        Map<String, FormalArgument> r22 = r21.formalArguments;
        if (r22 == null) goto L50;
        if (r22.containsKey(r20.getKey()) == false) goto L50;
        r15.rawSetAttribute(r20.getKey(), r20.getValue());
    L50:
        this.errMgr.runTimeError(this, r13, ErrorType.NO_SUCH_ATTRIBUTE, r20.getKey());
        goto L32
    L35:
        Map<String, FormalArgument> r23 = r21.formalArguments;
        if (r23 != null) goto L38;
    L52:
        r15.impl = r15.impl.clone();     // Catch: CloneNotSupportedException -> L43
        r15.add(r20.getKey(), r20.getValue());     // Catch: CloneNotSupportedException -> L43
    L43:
        this.errMgr.runTimeError(this, r13, ErrorType.NO_SUCH_ATTRIBUTE, r20.getKey());
        goto L32
    L38:
        if (r23.containsKey(r20.getKey()) == false) goto L52;
        r15.rawSetAttribute(r20.getKey(), r20.getValue());
        goto L32
    L76:
        return;
    }

    public Object strip(InstanceScope r5, Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Object r11 = convertAnythingIteratableToIterator(r5, r10);
        if ((r11 instanceof Iterator) == false) goto L14;
        ArrayList r12 = new ArrayList();
        Iterator r13 = (Iterator) r11;
    L9:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        if (r14 == null) goto L9;
        r12.add(r14);
        goto L9
    L13:
        return r12;
    L14:
        return r11;
    }

    public void super_new(InstanceScope r5, String r10, int r11) {
        ST r12 = r5.f675st;
        CompiledST r13 = r12.impl.nativeGroup.lookupImportedTemplate(r10);
        if (r13 != null) goto L5;
        this.errMgr.runTimeError(this, r5, ErrorType.NO_IMPORTED_TEMPLATE, r10);
        ST r14 = r12.groupThatCreatedThisInstance.createStringTemplateInternally(new CompiledST());
    L6:
        storeArgs(r5, r11, r14);
        int r15 = this.f676sp - r11;
        Object[] r16 = this.operands;
        int r17 = r15 + 1;
        this.f676sp = r17;
        r16[r17] = r14;
        return;
    L5:
        r14 = r13.nativeGroup.getEmbeddedInstanceOf(this, r5, r10);
        r14.groupThatCreatedThisInstance = this.group;
        goto L6
    }

    public boolean testAttributeTrue(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof Boolean) == false) goto L10;
        return ((Boolean) r5).booleanValue();
    L10:
        if ((r5 instanceof Collection) == false) goto L16;
        if (((Collection) r5).size() > 0) goto L14;
        return false;
    L14:
        return true;
    L16:
        if ((r5 instanceof Map) == false) goto L22;
        if (((Map) r5).size() > 0) goto L20;
        return false;
    L20:
        return true;
    L22:
        if ((r5 instanceof Iterator) == true) goto L24;
        return true;
    L24:
        return ((Iterator) r5).hasNext();
    }

    public String toString(STWriter r5, InstanceScope r10, Object r11) {
        if (r11 != null) goto L4;
        return null;
    L4:
        if (r11.getClass() == String.class) goto L6;
        StringWriter r12 = new StringWriter();
        STWriter r13 = (STWriter) r5.getClass().getConstructor(new Class[]{Writer.class}).newInstance(new Object[]{r12});     // Catch: Exception -> L10
    L12:
        if (this.debug == true) goto L14;
    L16:
        writeObjectNoOptions(r13, r10, r11);
        return r12.toString();
    L14:
        if (r10.earlyEval == true) goto L16;
        InstanceScope r14 = new InstanceScope(r10, r10.f675st);
        r14.earlyEval = true;
        r10 = r14;
    L10:
        r13 = new AutoIndentWriter(r12);
        this.errMgr.runTimeError(this, r10, ErrorType.WRITER_CTOR_ISSUE, r5.getClass().getSimpleName());
        goto L12
    L6:
        return (String) r11;
    }

    public void trace(InstanceScope r10, int r11) {
        ST r5 = r10.f675st;
        StringBuilder r12 = new StringBuilder();
        BytecodeDisassembler r13 = new BytecodeDisassembler(r5.impl);
        StringBuilder r14 = new StringBuilder();
        r13.disassembleInstruction(r14, r11);
        String r15 = j0.q(new StringBuilder(), r5.impl.name, ":");
        if (Misc.referenceEquals(r5.impl.name, ST.UNKNOWN_NAME) == false) goto L5;
        r15 = "";
    L5:
        r12.append(String.format("%-40s", new Object[]{r15 + r14}));
        r12.append("\tstack=[");
        int r16 = 0;
    L7:
        if (r16 > this.f676sp) goto L9;
        printForTrace(r12, r10, this.operands[r16]);
        r16 = r16 + 1;
        goto L7
    L9:
        r12.append(" ], calls=");
        r12.append(getEnclosingInstanceStackString(r10));
        r12.append(", sp=" + this.f676sp + ", nw=" + this.nwline);
        String r17 = r12.toString();
        if (this.debug == false) goto L13;
        this.executeTrace.add(r17);
    L13:
        if (trace == false) goto L17;
        System.out.println(r17);
        return;
    }

    public void trackDebugEvent(InstanceScope r5, InterpEvent r10) {
        this.events.add(r10);
        r5.events.add(r10);
        if ((r10 instanceof EvalTemplateEvent) == false) goto L8;
        InstanceScope r11 = r5.parent;
        if (r11 == null) goto L9;
        r11.childEvalTemplateEvents.add((EvalTemplateEvent) r10);
        return;
    L9:
        return;
    }

    public Object trunc(InstanceScope r5, Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof List) == false) goto L12;
        List r11 = (List) r10;
        if (r11.size() > 1) goto L11;
        return null;
    L11:
        return r11.subList(0, r11.size() - 1);
    L12:
        Object r12 = convertAnythingIteratableToIterator(r5, r10);
        if ((r12 instanceof Iterator) == false) goto L21;
        ArrayList r13 = new ArrayList();
        Iterator r14 = (Iterator) r12;
    L16:
        if (r14.hasNext() == false) goto L20;
        Object r15 = r14.next();
        if (r14.hasNext() == false) goto L16;
        r13.add(r15);
        goto L16
    L20:
        return r13;
    L21:
        return null;
    }

    public int writeIterator(STWriter r10, InstanceScope r11, Object r12, String[] r13) throws IOException {
        int r5 = 0;
        if (r12 != null) goto L5;
        return 0;
    L5:
        Iterator r14 = (Iterator) r12;
        if (r13 == null) goto L8;
        String r15 = r13[Option.SEPARATOR.ordinal()];
    L9:
        boolean r16 = false;
    L11:
        if (r14.hasNext() == false) goto L23;
        Object r17 = r14.next();
        if (r16 == false) goto L19;
        if (r15 == null) goto L19;
        if (r17 == null) goto L17;
    L18:
        r5 = r5 + r10.writeSeparator(r15);
        goto L19
    L17:
        if (r13[Option.NULL.ordinal()] != null) goto L18;
    L19:
        int r18 = writeObject(r10, r11, r17, r13);
        if (r18 <= 0) goto L22;
        r16 = true;
    L22:
        r5 = r5 + r18;
        goto L11
    L23:
        return r5;
    L8:
        r15 = null;
        goto L9
    }

    public int writeObject(STWriter r5, InstanceScope r10, Object r11, String[] r12) {
        Object r13 = r11;
        if (r11 != null) goto L10;
        if (r12 == null) goto L8;
        Option r14 = Option.NULL;
        if (r12[r14.ordinal()] == null) goto L8;
        r13 = r12[r14.ordinal()];
    L8:
        return 0;
    L10:
        if ((r13 instanceof ST) == false) goto L20;
        InstanceScope r15 = new InstanceScope(r10, (ST) r13);
        if (r12 == null) goto L34;
        Option r16 = Option.WRAP;
        if (r12[r16.ordinal()] == null) goto L34;
        r5.writeWrap(r12[r16.ordinal()]);     // Catch: IOException -> L17
    L17:
        e = move-exception;
        this.errMgr.IOError(r15.f675st, ErrorType.WRITE_IO_ERROR, e);
    L34:
        return exec(r5, r15);
    L20:
        Object r17 = convertAnythingIteratableToIterator(r10, r13);
    L25:
        e = move-exception;
        this.errMgr.IOError(r10.f675st, ErrorType.WRITE_IO_ERROR, e, r17);
        return 0;
    L22:
        if ((r17 instanceof Iterator) == false) goto L27;
        int r18 = writeIterator(r5, r10, r17, r12);     // Catch: IOException -> L25
    L35:
        return r18;
    L27:
        r18 = writePOJO(r5, r10, r17, r12);     // Catch: IOException -> L25
        goto L35
    }

    public int writeObjectNoOptions(STWriter r10, InstanceScope r11, Object r12) {
        int r5 = r10.index();
        int r13 = writeObject(r10, r11, r12, null);
        if (this.debug == false) goto L5;
        trackDebugEvent(r11, new EvalExprEvent(r11, r5, r10.index() - 1, getExprStartChar(r11), getExprStopChar(r11)));
    L5:
        return r13;
    }

    public int writeObjectWithOptions(STWriter r10, InstanceScope r11, Object r12, Object[] r13) {
        int r5 = r10.index();
        if (r13 == null) goto L8;
        String[] r14 = new String[r13.length];
        int r15 = 0;
    L6:
        if (r15 >= Compiler.NUM_OPTIONS) goto L9;
        r14[r15] = toString(r10, r11, r13[r15]);
        r15 = r15 + 1;
    L9:
        if (r13 != null) goto L11;
    L13:
        int r16 = writeObject(r10, r11, r12, r14);
        if (r13 == null) goto L19;
        if (r13[Option.ANCHOR.ordinal()] == null) goto L19;
        r10.popAnchorPoint();
    L19:
        if (this.debug == false) goto L21;
        trackDebugEvent(r11, new EvalExprEvent(r11, r5, r10.index() - 1, getExprStartChar(r11), getExprStopChar(r11)));
    L21:
        return r16;
    L11:
        if (r13[Option.ANCHOR.ordinal()] == null) goto L13;
        r10.pushAnchorPoint();
        goto L13
    L8:
        r14 = null;
        goto L9
    }

    public int writePOJO(STWriter r5, InstanceScope r10, Object r11, String[] r12) throws IOException {
        if (r12 == null) goto L4;
        String r13 = r12[Option.FORMAT.ordinal()];
    L5:
        AttributeRenderer r14 = r10.f675st.impl.nativeGroup.getAttributeRenderer(r11.getClass());
        if (r14 == null) goto L8;
        String r15 = r14.toString(r11, r13, this.locale);
    L9:
        if (r12 == null) goto L14;
        Option r16 = Option.WRAP;
        if (r12[r16.ordinal()] == null) goto L14;
        return r5.write(r15, r12[r16.ordinal()]);
    L14:
        return r5.write(r15);
    L8:
        r15 = r11.toString();
        goto L9
    L4:
        r13 = null;
        goto L5
    }

    public ST.AttributeList zip_map(InstanceScope r11, List<Object> r12, ST r13) {
        if (r12 == null) goto L39;
        if (r13 == null) goto L39;
        if (r12.size() == 0) goto L39;
        int r5 = 0;
    L10:
        if (r5 >= r12.size()) goto L15;
        Object r10 = r12.get(r5);
        if (r10 == null) goto L14;
        r12.set(r5, convertAnythingToIterator(r11, r10));
    L14:
        r5 = r5 + 1;
        goto L10
    L15:
        int r14 = r12.size();
        CompiledST r15 = r13.impl;
        Map<String, FormalArgument> r16 = r15.formalArguments;
        if (r15.hasFormalArgs == false) goto L38;
        if (r16 == null) goto L38;
        String[] r17 = (String[]) r16.keySet().toArray(new String[r16.size()]);
        int r18 = r17.length;
        if (r13.isAnonSubtemplate() == false) goto L22;
        r18 = r18 - predefinedAnonSubtemplateAttributes.size();
    L22:
        if (r18 == r14) goto L24;
        this.errMgr.runTimeError(this, r11, ErrorType.MAP_ARGUMENT_COUNT_MISMATCH, Integer.valueOf(r14), Integer.valueOf(r18));
        int r19 = Math.min(r17.length, r14);
        String[] r110 = new String[r19];
        System.arraycopy(r17, 0, r110, 0, r19);
        int r20 = r19;
        String[] r21 = r110;
    L25:
        ST.AttributeList r22 = new ST.AttributeList();
        int r111 = 0;
    L26:
        ST r23 = this.group.createStringTemplateInternally(r13);
        r23.rawSetAttribute("i0", Integer.valueOf(r111));
        r111 = r111 + 1;
        r23.rawSetAttribute("i", Integer.valueOf(r111));
        int r24 = 0;
        int r25 = 0;
    L27:
        if (r24 >= r20) goto L35;
        Iterator r26 = (Iterator) r12.get(r24);
        if (r26 != null) goto L31;
    L33:
        r25 = r25 + 1;
    L34:
        r24 = r24 + 1;
        goto L27
    L31:
        if (r26.hasNext() == false) goto L33;
        r23.rawSetAttribute(r21[r24], r26.next());
        goto L34
    L35:
        if (r25 == r20) goto L36;
        r22.add(r23);
        goto L26
    L36:
        return r22;
    L24:
        r20 = r14;
        r21 = r17;
    L38:
        this.errMgr.runTimeError(this, r11, ErrorType.MISSING_FORMAL_ARGUMENTS);
    L39:
        return null;
    }

    public Interpreter(STGroup r5, Locale r10, boolean r11) {
        this(r5, r10, r5.errMgr, r11);
    }

    public Interpreter(STGroup r5, ErrorManager r10, boolean r11) {
        this(r5, Locale.getDefault(), r10, r11);
    }

    public Interpreter(STGroup r5, Locale r10, ErrorManager r11, boolean r12) {
        this.operands = new Object[100];
        this.f676sp = -1;
        this.nwline = 0;
        this.group = r5;
        this.locale = r10;
        this.errMgr = r11;
        this.debug = r12;
        if (r12 == false) goto L6;
        this.events = new ArrayList();
        this.executeTrace = new ArrayList();
        return;
    }

    public void super_new(InstanceScope r5, String r10, Map<String, Object> r11) {
        ST r12 = r5.f675st;
        CompiledST r13 = r12.impl.nativeGroup.lookupImportedTemplate(r10);
        if (r13 != null) goto L5;
        this.errMgr.runTimeError(this, r5, ErrorType.NO_IMPORTED_TEMPLATE, r10);
        ST r14 = r12.groupThatCreatedThisInstance.createStringTemplateInternally(new CompiledST());
    L6:
        storeArgs(r5, r11, r14);
        Object[] r15 = this.operands;
        int r16 = this.f676sp + 1;
        this.f676sp = r16;
        r15[r16] = r14;
        return;
    L5:
        r14 = r13.nativeGroup.createStringTemplateInternally(r13);
        r14.groupThatCreatedThisInstance = this.group;
        goto L6
    }

    public void storeArgs(InstanceScope r13, int r14, ST r15) {
        if (r14 <= 0) goto L8;
        CompiledST r5 = r15.impl;
        if (r5.hasFormalArgs == true) goto L8;
        if (r5.formalArguments != null) goto L8;
        r15.add(ST.IMPLICIT_ARG_NAME, null);
    L8:
        Map<String, FormalArgument> r10 = r15.impl.formalArguments;
        int r11 = 0;
        if (r10 == null) goto L11;
        int r12 = r10.size();
    L12:
        int r16 = this.f676sp - (r14 - 1);
        int r17 = Math.min(r14, r12);
        if (r15.impl.isAnonSubtemplate == false) goto L16;
        r12 = r12 - predefinedAnonSubtemplateAttributes.size();
    L16:
        if (r14 < (r12 - r15.impl.numberOfArgsWithDefaultValues)) goto L18;
        if (r14 > r12) goto L18;
    L19:
        Map<String, FormalArgument> r18 = r15.impl.formalArguments;
        if (r18 != null) goto L22;
        return;
    L22:
        Iterator<String> r19 = r18.keySet().iterator();
    L23:
        if (r11 >= r17) goto L25;
        r15.rawSetAttribute(r19.next(), this.operands[r16 + r11]);
        r11 = r11 + 1;
        goto L23
    L25:
        return;
    L18:
        this.errMgr.runTimeError(this, r13, ErrorType.ARGUMENT_COUNT_MISMATCH, Integer.valueOf(r14), r15.impl.name, Integer.valueOf(r12));
        goto L19
    L11:
        r12 = 0;
        goto L12
    }
}
