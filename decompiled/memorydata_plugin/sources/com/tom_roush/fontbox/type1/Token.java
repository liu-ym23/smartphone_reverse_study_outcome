package com.tom_roush.fontbox.type1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
class Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Kind f16028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Kind f16029b = null;
    static final Kind c = null;
    static final Kind d = null;
    static final Kind e = null;
    static final Kind f = null;
    static final Kind g = null;
    static final Kind h = null;
    static final Kind i = null;
    static final Kind j = null;
    static final Kind k = null;
    static final Kind l = null;
    private String m;
    private byte[] n;
    private final Kind o;

    static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind CHARSTRING = null;
        public static final Kind END_ARRAY = null;
        public static final Kind END_DICT = null;
        public static final Kind END_PROC = null;
        public static final Kind INTEGER = null;
        public static final Kind LITERAL = null;
        public static final Kind NAME = null;
        public static final Kind NONE = null;
        public static final Kind REAL = null;
        public static final Kind START_ARRAY = null;
        public static final Kind START_DICT = null;
        public static final Kind START_PROC = null;
        public static final Kind STRING = null;

        static {
            Kind r0 = new Kind("NONE", 0);
            NONE = r0;
            Kind r1 = new Kind("STRING", 1);
            STRING = r1;
            Kind r3 = new Kind("NAME", 2);
            NAME = r3;
            Kind r5 = new Kind("LITERAL", 3);
            LITERAL = r5;
            Kind r7 = new Kind("REAL", 4);
            REAL = r7;
            Kind r9 = new Kind("INTEGER", 5);
            INTEGER = r9;
            Kind r11 = new Kind("START_ARRAY", 6);
            START_ARRAY = r11;
            Kind r13 = new Kind("END_ARRAY", 7);
            END_ARRAY = r13;
            Kind r15 = new Kind("START_PROC", 8);
            START_PROC = r15;
            Kind r14 = new Kind("END_PROC", 9);
            END_PROC = r14;
            Kind r12 = new Kind("START_DICT", 10);
            START_DICT = r12;
            Kind r10 = new Kind("END_DICT", 11);
            END_DICT = r10;
            Kind r8 = new Kind("CHARSTRING", 12);
            CHARSTRING = r8;
            $VALUES = new Kind[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        }

        private Kind(String r1, int r2) {
            super(r1, r2);
        }

        public static Kind valueOf(String r2) {
            return (Kind) ZeusTransformUtils.preCheckCast(Enum.valueOf(Kind.class, r2), Kind.class, "com.obric.memorydata.plugin");
        }

        public static Kind[] values() {
            return (Kind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Kind[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f16028a = Kind.STRING;
        f16029b = Kind.NAME;
        c = Kind.LITERAL;
        d = Kind.REAL;
        e = Kind.INTEGER;
        f = Kind.START_ARRAY;
        g = Kind.END_ARRAY;
        h = Kind.START_PROC;
        i = Kind.END_PROC;
        j = Kind.CHARSTRING;
        k = Kind.START_DICT;
        l = Kind.END_DICT;
    }

    Token(char r1, Kind r2) {
        this.m = Character.toString(r1);
        this.o = r2;
    }

    Token(String r1, Kind r2) {
        this.m = r1;
        this.o = r2;
    }

    Token(byte[] r1, Kind r2) {
        this.n = r1;
        this.o = r2;
    }

    public String a() {
        return this.m;
    }

    public Kind b() {
        return this.o;
    }

    public int c() {
        return (int) Float.parseFloat(this.m);
    }

    public float d() {
        return Float.parseFloat(this.m);
    }

    public boolean e() {
        return this.m.equals("true");
    }

    public byte[] f() {
        return this.n;
    }

    public String toString() {
        if (this.o != j) goto L7;
        StringBuilder r2 = new StringBuilder().append("Token[kind=CHARSTRING, data=").append(this.n.length);
        String r0 = " bytes]";
    L6:
        return r2.append(r0).toString();
    L7:
        r2 = new StringBuilder().append("Token[kind=").append(this.o).append(", text=").append(this.m);
        r0 = "]";
        goto L6
    }
}
