package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

/* JADX INFO: loaded from: classes.dex */
public class Bytecode {
    public static final short INSTR_ADD = 25;
    public static final short INSTR_AND = 38;
    public static final short INSTR_ARGS = 21;
    public static final short INSTR_BR = 18;
    public static final short INSTR_BRF = 19;
    public static final short INSTR_DEDENT = 40;
    public static final short INSTR_FALSE = 46;
    public static final short INSTR_FIRST = 27;
    public static final short INSTR_INDENT = 39;
    public static final short INSTR_LAST = 28;
    public static final short INSTR_LENGTH = 33;
    public static final short INSTR_LIST = 24;
    public static final short INSTR_LOAD_ATTR = 2;
    public static final short INSTR_LOAD_LOCAL = 3;
    public static final short INSTR_LOAD_PROP = 4;
    public static final short INSTR_LOAD_PROP_IND = 5;
    public static final short INSTR_LOAD_STR = 1;
    public static final short INSTR_MAP = 15;
    public static final short INSTR_NEW = 8;
    public static final short INSTR_NEWLINE = 41;
    public static final short INSTR_NEW_BOX_ARGS = 10;
    public static final short INSTR_NEW_IND = 9;
    public static final short INSTR_NOOP = 42;
    public static final short INSTR_NOT = 36;
    public static final short INSTR_NULL = 44;
    public static final short INSTR_OPTIONS = 20;
    public static final short INSTR_OR = 37;
    public static final short INSTR_PASSTHRU = 22;
    public static final short INSTR_POP = 43;
    public static final short INSTR_REST = 29;
    public static final short INSTR_REVERSE = 35;
    public static final short INSTR_ROT_MAP = 16;
    public static final short INSTR_STORE_ARG = 7;
    public static final short INSTR_STORE_OPTION = 6;
    public static final short INSTR_STRIP = 31;
    public static final short INSTR_STRLEN = 34;
    public static final short INSTR_SUPER_NEW = 11;
    public static final short INSTR_SUPER_NEW_BOX_ARGS = 12;
    public static final short INSTR_TOSTR = 26;
    public static final short INSTR_TRIM = 32;
    public static final short INSTR_TRUE = 45;
    public static final short INSTR_TRUNC = 30;
    public static final short INSTR_WRITE = 13;
    public static final short INSTR_WRITE_LOCAL = 48;
    public static final short INSTR_WRITE_OPT = 14;
    public static final short INSTR_WRITE_STR = 47;
    public static final short INSTR_ZIP_MAP = 17;
    public static final short MAX_BYTECODE = 48;
    public static final int MAX_OPNDS = 2;
    public static final int OPND_SIZE_IN_BYTES = 2;
    public static Instruction[] instructions;

    public static class Instruction {
        public String name;
        public int nopnds;
        public OperandType[] type;

        public Instruction(String r5) {
            OperandType r10 = OperandType.NONE;
            this(r5, r10, r10);
            this.nopnds = 0;
        }

        public Instruction(String r5, OperandType r10) {
            this(r5, r10, OperandType.NONE);
            this.nopnds = 1;
        }

        public Instruction(String r5, OperandType r10, OperandType r11) {
            this.type = new OperandType[]{r10, r11};
            this.name = r5;
            this.nopnds = 2;
        }
    }

    public static final enum OperandType extends Enum<OperandType> {
        private static final /* synthetic */ OperandType[] $VALUES = null;
        public static final OperandType ADDR = null;
        public static final OperandType INT = null;
        public static final OperandType NONE = null;
        public static final OperandType STRING = null;

        static {
            OperandType r5 = new OperandType("NONE", 0);
            NONE = r5;
            OperandType r10 = new OperandType("STRING", 1);
            STRING = r10;
            OperandType r11 = new OperandType("ADDR", 2);
            ADDR = r11;
            OperandType r12 = new OperandType("INT", 3);
            INT = r12;
            $VALUES = new OperandType[]{r5, r10, r11, r12};
        }

        private OperandType(String r5, int r10) {
            super(r5, r10);
        }

        public static OperandType valueOf(String r5) {
            return (OperandType) Enum.valueOf(OperandType.class, r5);
        }

        public static OperandType[] values() {
            return (OperandType[]) $VALUES.clone();
        }
    }

    static {
        OperandType r15 = OperandType.STRING;
        Instruction r5 = new Instruction("load_str", r15);
        Instruction r10 = new Instruction("load_attr", r15);
        OperandType r14 = OperandType.INT;
        Instruction r11 = new Instruction("load_local", r14);
        Instruction r12 = new Instruction("load_prop", r15);
        Instruction r13 = new Instruction("load_prop_ind");
        Instruction r16 = new Instruction("store_option", r14);
        Instruction r17 = new Instruction("store_arg", r15);
        Instruction r18 = new Instruction("new", r15, r14);
        Instruction r19 = new Instruction("new_ind", r14);
        Instruction r20 = new Instruction("new_box_args", r15);
        Instruction r21 = new Instruction("super_new", r15, r14);
        Instruction r22 = new Instruction("super_new_box_args", r15);
        Instruction r23 = new Instruction("write");
        Instruction r24 = new Instruction("write_opt");
        Instruction r25 = new Instruction("map");
        Instruction r26 = new Instruction("rot_map", r14);
        Instruction r27 = new Instruction("zip_map", r14);
        OperandType r28 = OperandType.ADDR;
        instructions = new Instruction[]{null, r5, r10, r11, r12, r13, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, new Instruction("br", r28), new Instruction("brf", r28), new Instruction("options"), new Instruction("args"), new Instruction("passthru", r15), null, new Instruction("list"), new Instruction("add"), new Instruction("tostr"), new Instruction("first"), new Instruction("last"), new Instruction("rest"), new Instruction("trunc"), new Instruction("strip"), new Instruction("trim"), new Instruction("length"), new Instruction("strlen"), new Instruction("reverse"), new Instruction("not"), new Instruction("or"), new Instruction("and"), new Instruction("indent", r15), new Instruction("dedent"), new Instruction("newline"), new Instruction("noop"), new Instruction("pop"), new Instruction("null"), new Instruction("true"), new Instruction("false"), new Instruction("write_str", r15), new Instruction("write_local", r14)};
    }

    public Bytecode() {
    }
}
