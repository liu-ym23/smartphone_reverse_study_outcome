package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b'\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'¨\u0006("}, d2 = {"Lcom/google/devtools/ksp/symbol/Modifier;", "", "PUBLIC", "PRIVATE", "INTERNAL", "PROTECTED", "IN", "OUT", "OVERRIDE", "LATEINIT", "ENUM", "SEALED", "ANNOTATION", "DATA", "INNER", "FUN", "VALUE", "SUSPEND", "TAILREC", "OPERATOR", "INFIX", "INLINE", "EXTERNAL", "ABSTRACT", "FINAL", "OPEN", "CONST", "VARARG", "NOINLINE", "CROSSINLINE", "REIFIED", "EXPECT", "ACTUAL", "JAVA_DEFAULT", "JAVA_NATIVE", "JAVA_STATIC", "JAVA_STRICT", "JAVA_SYNCHRONIZED", "JAVA_TRANSIENT", "JAVA_VOLATILE", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Modifier extends Enum<Modifier> {
    public static final Modifier ABSTRACT = null;
    public static final Modifier ACTUAL = null;
    public static final Modifier ANNOTATION = null;
    public static final Modifier CONST = null;
    public static final Modifier CROSSINLINE = null;
    public static final Modifier DATA = null;
    public static final Modifier ENUM = null;
    public static final Modifier EXPECT = null;
    public static final Modifier EXTERNAL = null;
    public static final Modifier FINAL = null;
    public static final Modifier FUN = null;
    public static final Modifier IN = null;
    public static final Modifier INFIX = null;
    public static final Modifier INLINE = null;
    public static final Modifier INNER = null;
    public static final Modifier INTERNAL = null;
    public static final Modifier JAVA_DEFAULT = null;
    public static final Modifier JAVA_NATIVE = null;
    public static final Modifier JAVA_STATIC = null;
    public static final Modifier JAVA_STRICT = null;
    public static final Modifier JAVA_SYNCHRONIZED = null;
    public static final Modifier JAVA_TRANSIENT = null;
    public static final Modifier JAVA_VOLATILE = null;
    public static final Modifier LATEINIT = null;
    public static final Modifier NOINLINE = null;
    public static final Modifier OPEN = null;
    public static final Modifier OPERATOR = null;
    public static final Modifier OUT = null;
    public static final Modifier OVERRIDE = null;
    public static final Modifier PRIVATE = null;
    public static final Modifier PROTECTED = null;
    public static final Modifier PUBLIC = null;
    public static final Modifier REIFIED = null;
    public static final Modifier SEALED = null;
    public static final Modifier SUSPEND = null;
    public static final Modifier TAILREC = null;
    public static final Modifier VALUE = null;
    public static final Modifier VARARG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Modifier[] f9453a = null;

    static {
        Modifier r5 = new Modifier("PUBLIC", 0);
        PUBLIC = r5;
        Modifier r10 = new Modifier("PRIVATE", 1);
        PRIVATE = r10;
        Modifier r11 = new Modifier("INTERNAL", 2);
        INTERNAL = r11;
        Modifier r12 = new Modifier("PROTECTED", 3);
        PROTECTED = r12;
        Modifier r13 = new Modifier("IN", 4);
        IN = r13;
        Modifier r14 = new Modifier("OUT", 5);
        OUT = r14;
        Modifier r15 = new Modifier("OVERRIDE", 6);
        OVERRIDE = r15;
        Modifier r16 = new Modifier("LATEINIT", 7);
        LATEINIT = r16;
        Modifier r17 = new Modifier("ENUM", 8);
        ENUM = r17;
        Modifier r18 = new Modifier("SEALED", 9);
        SEALED = r18;
        Modifier r19 = new Modifier("ANNOTATION", 10);
        ANNOTATION = r19;
        Modifier r110 = new Modifier("DATA", 11);
        DATA = r110;
        Modifier r111 = new Modifier("INNER", 12);
        INNER = r111;
        Modifier r112 = new Modifier("FUN", 13);
        FUN = r112;
        Modifier r113 = new Modifier("VALUE", 14);
        VALUE = r113;
        Modifier r114 = new Modifier("SUSPEND", 15);
        SUSPEND = r114;
        Modifier r115 = new Modifier("TAILREC", 16);
        TAILREC = r115;
        Modifier r116 = new Modifier("OPERATOR", 17);
        OPERATOR = r116;
        Modifier r117 = new Modifier("INFIX", 18);
        INFIX = r117;
        Modifier r118 = new Modifier("INLINE", 19);
        INLINE = r118;
        Modifier r119 = new Modifier("EXTERNAL", 20);
        EXTERNAL = r119;
        Modifier r120 = new Modifier("ABSTRACT", 21);
        ABSTRACT = r120;
        Modifier r121 = new Modifier("FINAL", 22);
        FINAL = r121;
        Modifier r122 = new Modifier("OPEN", 23);
        OPEN = r122;
        Modifier r123 = new Modifier("CONST", 24);
        CONST = r123;
        Modifier r124 = new Modifier("VARARG", 25);
        VARARG = r124;
        Modifier r125 = new Modifier("NOINLINE", 26);
        NOINLINE = r125;
        Modifier r126 = new Modifier("CROSSINLINE", 27);
        CROSSINLINE = r126;
        Modifier r127 = new Modifier("REIFIED", 28);
        REIFIED = r127;
        Modifier r128 = new Modifier("EXPECT", 29);
        EXPECT = r128;
        Modifier r129 = new Modifier("ACTUAL", 30);
        ACTUAL = r129;
        Modifier r130 = new Modifier("JAVA_DEFAULT", 31);
        JAVA_DEFAULT = r130;
        Modifier r131 = new Modifier("JAVA_NATIVE", 32);
        JAVA_NATIVE = r131;
        Modifier r132 = new Modifier("JAVA_STATIC", 33);
        JAVA_STATIC = r132;
        Modifier r133 = new Modifier("JAVA_STRICT", 34);
        JAVA_STRICT = r133;
        Modifier r134 = new Modifier("JAVA_SYNCHRONIZED", 35);
        JAVA_SYNCHRONIZED = r134;
        Modifier r135 = new Modifier("JAVA_TRANSIENT", 36);
        JAVA_TRANSIENT = r135;
        Modifier r136 = new Modifier("JAVA_VOLATILE", 37);
        JAVA_VOLATILE = r136;
        f9453a = new Modifier[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136};
    }

    public static Modifier valueOf(String r5) {
        return (Modifier) Enum.valueOf(Modifier.class, r5);
    }

    public static Modifier[] values() {
        return (Modifier[]) f9453a.clone();
    }
}
