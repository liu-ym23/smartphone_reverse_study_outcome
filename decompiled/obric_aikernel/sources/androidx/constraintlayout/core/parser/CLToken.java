package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLToken extends CLElement {
    int index;
    char[] tokenFalse;
    char[] tokenNull;
    char[] tokenTrue;
    Type type;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.parser.CLToken$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = null;

        static {
            int[] r10 = new int[Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = r10;
            r10[Type.TRUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.FALSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.NULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[Type.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FALSE = null;
        public static final Type NULL = null;
        public static final Type TRUE = null;
        public static final Type UNKNOWN = null;

        static {
            Type r10 = new Type("UNKNOWN", 0);
            UNKNOWN = r10;
            Type r11 = new Type("TRUE", 1);
            TRUE = r11;
            Type r12 = new Type("FALSE", 2);
            FALSE = r12;
            Type r13 = new Type("NULL", 3);
            NULL = r13;
            $VALUES = new Type[]{r10, r11, r12, r13};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public CLToken(char[] r10) {
        super(r10);
        this.index = 0;
        this.type = Type.UNKNOWN;
        this.tokenTrue = "true".toCharArray();
        this.tokenFalse = "false".toCharArray();
        this.tokenNull = "null".toCharArray();
    }

    public static CLElement allocate(char[] r10) {
        return new CLToken(r10);
    }

    public boolean getBoolean() {
        Type r10 = this.type;
        if (r10 != Type.TRUE) goto L7;
        return true;
    L7:
        if (r10 != Type.FALSE) goto L11;
        return false;
    L11:
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.type;
    }

    public boolean isNull() {
        if (this.type != Type.NULL) goto L7;
        return true;
    L7:
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r10, int r11) {
        StringBuilder r12 = new StringBuilder();
        addIndent(r12, r10);
        r12.append(content());
        return r12.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (CLParser.DEBUG == false) goto L7;
        return "<" + content() + ">";
    L7:
        return content();
    }

    public boolean validate(char r10, long r11) {
        int r12 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[this.type.ordinal()];
        boolean r13 = false;
        if (r12 != 1) goto L5;
        char[] r14 = this.tokenTrue;
        int r15 = this.index;
        if (r14[r15] != r10) goto L38;
        r13 = true;
    L38:
        if (r13 == true) goto L40;
    L42:
        this.index++;
        return r13;
    L40:
        if ((r15 + 1) != r14.length) goto L42;
    L27:
        setEnd(r11);
        goto L42
    L5:
        if (r12 != 2) goto L7;
        char[] r16 = this.tokenFalse;
        int r17 = this.index;
        if (r16[r17] != r10) goto L31;
        r13 = true;
    L31:
        if (r13 == false) goto L42;
        if ((r17 + 1) != r16.length) goto L42;
    L7:
        if (r12 != 3) goto L9;
        char[] r18 = this.tokenNull;
        int r19 = this.index;
        if (r18[r19] != r10) goto L24;
        r13 = true;
    L24:
        if (r13 == false) goto L42;
        if ((r19 + 1) != r18.length) goto L42;
    L9:
        if (r12 != 4) goto L42;
        char[] r20 = this.tokenTrue;
        int r21 = this.index;
        if (r20[r21] != r10) goto L16;
        Type r22 = Type.TRUE;
    L14:
        this.type = r22;
        r13 = true;
        goto L42
    L16:
        if (this.tokenFalse[r21] != r10) goto L19;
        r22 = Type.FALSE;
        goto L14
    L19:
        if (this.tokenNull[r21] != r10) goto L42;
        r22 = Type.NULL;
        goto L14
    }
}
