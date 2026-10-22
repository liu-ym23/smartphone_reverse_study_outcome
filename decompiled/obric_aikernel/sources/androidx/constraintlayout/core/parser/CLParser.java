package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLParser {
    static boolean DEBUG = false;
    private boolean hasComment;
    private int lineNumber;
    private String mContent;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.parser.CLParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = null;

        static {
            int[] r10 = new int[TYPE.values().length];
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE = r10;
            r10[TYPE.OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.KEY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[TYPE.TOKEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE ARRAY = null;
        public static final TYPE KEY = null;
        public static final TYPE NUMBER = null;
        public static final TYPE OBJECT = null;
        public static final TYPE STRING = null;
        public static final TYPE TOKEN = null;
        public static final TYPE UNKNOWN = null;

        static {
            TYPE r10 = new TYPE("UNKNOWN", 0);
            UNKNOWN = r10;
            TYPE r11 = new TYPE("OBJECT", 1);
            OBJECT = r11;
            TYPE r12 = new TYPE("ARRAY", 2);
            ARRAY = r12;
            TYPE r13 = new TYPE("NUMBER", 3);
            NUMBER = r13;
            TYPE r14 = new TYPE("STRING", 4);
            STRING = r14;
            TYPE r15 = new TYPE("KEY", 5);
            KEY = r15;
            TYPE r16 = new TYPE("TOKEN", 6);
            TOKEN = r16;
            $VALUES = new TYPE[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private TYPE(String r10, int r11) {
            super(r10, r11);
        }

        public static TYPE valueOf(String r10) {
            return (TYPE) Enum.valueOf(TYPE.class, r10);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }
    }

    static {
    }

    public CLParser(String r10) {
        this.hasComment = false;
        this.mContent = r10;
    }

    private CLElement createElement(CLElement r10, int r11, TYPE r12, boolean r13, char[] r14) {
        if (DEBUG == false) goto L6;
        System.out.println("CREATE " + r12 + " at " + r14[r11]);
    L6:
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLParser$TYPE[r12.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L7:
        CLElement r15 = null;
    L15:
        if (r15 != null) goto L17;
        return null;
    L17:
        r15.setLine(this.lineNumber);
        if (r13 == false) goto L21;
        r15.setStart(r11);
    L21:
        if ((r10 instanceof CLContainer) == false) goto L23;
        r15.setContainer((CLContainer) r10);
    L23:
        return r15;
    L8:
        r15 = CLToken.allocate(r14);
        goto L15
    L9:
        r15 = CLKey.allocate(r14);
        goto L15
    L10:
        r15 = CLNumber.allocate(r14);
        goto L15
    L11:
        r15 = CLString.allocate(r14);
        goto L15
    L12:
        r15 = CLArray.allocate(r14);
    L14:
        r11 = r11 + 1;
        goto L15
    L13:
        r15 = CLObject.allocate(r14);
        goto L14
    }

    private CLElement getNextJsonElement(int r10, char r11, CLElement r12, char[] r13) {
        if (r11 != '\t') goto L5;
        return r12;
    L5:
        if (r11 != '\n') goto L7;
        return r12;
    L7:
        if (r11 != '\r') goto L9;
        return r12;
    L9:
        if (r11 != ' ') goto L11;
        return r12;
    L11:
        if (r11 == '\"') goto L43;
        if (r11 == '\'') goto L43;
        if (r11 == '[') goto L59;
        if (r11 != ']') goto L19;
    L40:
        r12.setEnd(r10 - 1);
        CLElement r14 = r12.getContainer();
        r14.setEnd(r10);
        return r14;
    L19:
        if (r11 == '{') goto L57;
        if (r11 == '}') goto L40;
        switch(r11) {
            case 43: goto L56;
            case 44: goto L51;
            case 45: goto L56;
            case 46: goto L56;
            case 47: goto L33;
            case 48: goto L56;
            case 49: goto L56;
            case 50: goto L56;
            case 51: goto L56;
            case 52: goto L56;
            case 53: goto L56;
            case 54: goto L56;
            case 55: goto L56;
            case 56: goto L56;
            case 57: goto L56;
            case 58: goto L51;
            default: goto L24;
        };
    L33:
        int r15 = r10 + 1;
        if (r15 < r13.length) goto L36;
        return r12;
    L36:
        if (r13[r15] != '/') goto L54;
        this.hasComment = true;
        return r12;
    L54:
        return r12;
    L51:
        return r12;
    L24:
        if ((r12 instanceof CLContainer) == false) goto L52;
        if ((r12 instanceof CLObject) == true) goto L52;
        CLElement r16 = createElement(r12, r10, TYPE.TOKEN, true, r13);
        CLToken r17 = (CLToken) r16;
        if (r17.validate(r11, r10) == false) goto L31;
        return r16;
    L31:
        throw new CLParsingException("incorrect token <" + r11 + "> at line " + this.lineNumber, r17);
    L52:
        return createElement(r12, r10, TYPE.KEY, true, r13);
    L56:
        return createElement(r12, r10, TYPE.NUMBER, true, r13);
    L57:
        return createElement(r12, r10, TYPE.OBJECT, true, r13);
    L59:
        return createElement(r12, r10, TYPE.ARRAY, true, r13);
    L43:
        if ((r12 instanceof CLObject) == false) goto L46;
        return createElement(r12, r10, TYPE.KEY, true, r13);
    L46:
        return createElement(r12, r10, TYPE.STRING, true, r13);
    }

    public static CLObject parse(String r10) {
        return new CLParser(r10).parse();
    }

    public CLObject parse() {
        char[] r10 = this.mContent.toCharArray();
        int r11 = r10.length;
        int r12 = 1;
        this.lineNumber = 1;
        boolean r13 = false;
        int r14 = 0;
    L4:
        if (r14 >= r11) goto L11;
        char r15 = r10[r14];
        if (r15 == '{') goto L12;
        if (r15 != '\n') goto L10;
        this.lineNumber++;
    L10:
        r14 = r14 + 1;
    L12:
        if (r14 == (-1)) goto L99;
        CLObject r16 = CLObject.allocate(r10);
        r16.setLine(this.lineNumber);
        r16.setStart(r14);
        int r17 = r14 + 1;
        CLElement r18 = r16;
    L14:
        if (r17 >= r11) goto L86;
        char r19 = r10[r17];
        if (r19 != '\n') goto L19;
        this.lineNumber += r12;
    L19:
        if (this.hasComment == false) goto L22;
        if (r19 != '\n') goto L85;
        this.hasComment = r13;
    L85:
        r17 = r17 + 1;
        r12 = 1;
        r13 = false;
    L22:
        if (r18 == null) goto L86;
        if (r18.isDone() == false) goto L28;
    L26:
        r18 = getNextJsonElement(r17, r19, r18, r10);
    L79:
        if (r18.isDone() == false) goto L85;
        if ((r18 instanceof CLKey) == true) goto L83;
    L84:
        r18 = r18.getContainer();
        goto L85
    L83:
        if (((CLKey) r18).mElements.size() <= 0) goto L85;
    L28:
        if ((r18 instanceof CLObject) == false) goto L32;
        if (r19 != '}') goto L26;
    L40:
        r18.setEnd(r17 - 1);
        goto L79
    L32:
        if ((r18 instanceof CLArray) == false) goto L35;
        if (r19 != ']') goto L26;
    L35:
        boolean r110 = r18 instanceof CLString;
        if (r110 == false) goto L42;
        long r111 = r18.start;
        if (r10[(int) r111] != r19) goto L79;
        r18.setStart(r111 + 1);
        goto L40
    L42:
        if ((r18 instanceof CLToken) == false) goto L49;
        CLToken r112 = (CLToken) r18;
        if (r112.validate(r19, r17) == true) goto L49;
        throw new CLParsingException("parsing incorrect token " + r112.content() + " at line " + this.lineNumber, r112);
    L49:
        if ((r18 instanceof CLKey) == true) goto L51;
        if (r110 == true) goto L51;
    L58:
        if (r18.isDone() == true) goto L79;
        if (r19 == '}') goto L72;
        if (r19 == ']') goto L72;
        if (r19 == ',') goto L72;
        if (r19 == ' ') goto L72;
        if (r19 == '\t') goto L72;
        if (r19 == '\r') goto L72;
        if (r19 == '\n') goto L72;
        if (r19 != ':') goto L79;
    L72:
        long r20 = r17 - 1;
        r18.setEnd(r20);
        if (r19 == '}') goto L75;
        if (r19 != ']') goto L79;
    L75:
        r18 = r18.getContainer();
        r18.setEnd(r20);
        if ((r18 instanceof CLKey) == false) goto L79;
        r18 = r18.getContainer();
        r18.setEnd(r20);
    L51:
        long r21 = r18.start;
        char r113 = r10[(int) r21];
        if (r113 != '\'') goto L54;
    L55:
        if (r113 != r19) goto L58;
        r18.setStart(r21 + 1);
        r18.setEnd(r17 - 1);
        goto L58
    L54:
        if (r113 != '\"') goto L58;
    L86:
        if (r18 == null) goto L95;
        if (r18.isDone() == true) goto L95;
        if ((r18 instanceof CLString) == false) goto L93;
        r18.setStart(((int) r18.start) + 1);
    L93:
        r18.setEnd(r11 - 1);
        r18 = r18.getContainer();
    L95:
        if (DEBUG == false) goto L97;
        System.out.println("Root: " + r16.toJSON());
    L97:
        return r16;
    L99:
        throw new CLParsingException("invalid json content", null);
    L11:
        r14 = -1;
        goto L12
    }
}
