package com.google.errorprone.annotations;

/* JADX INFO: loaded from: classes2.dex */
public final enum Modifier extends Enum<Modifier> {
    public static final Modifier ABSTRACT = null;
    public static final Modifier DEFAULT = null;
    public static final Modifier FINAL = null;
    public static final Modifier NATIVE = null;
    public static final Modifier PRIVATE = null;
    public static final Modifier PROTECTED = null;
    public static final Modifier PUBLIC = null;
    public static final Modifier STATIC = null;
    public static final Modifier STRICTFP = null;
    public static final Modifier SYNCHRONIZED = null;
    public static final Modifier TRANSIENT = null;
    public static final Modifier VOLATILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Modifier[] f9458a = null;

    static {
        Modifier r5 = new Modifier("PUBLIC", 0);
        PUBLIC = r5;
        Modifier r10 = new Modifier("PROTECTED", 1);
        PROTECTED = r10;
        Modifier r11 = new Modifier("PRIVATE", 2);
        PRIVATE = r11;
        Modifier r12 = new Modifier("ABSTRACT", 3);
        ABSTRACT = r12;
        Modifier r13 = new Modifier("DEFAULT", 4);
        DEFAULT = r13;
        Modifier r14 = new Modifier("STATIC", 5);
        STATIC = r14;
        Modifier r15 = new Modifier("FINAL", 6);
        FINAL = r15;
        Modifier r16 = new Modifier("TRANSIENT", 7);
        TRANSIENT = r16;
        Modifier r17 = new Modifier("VOLATILE", 8);
        VOLATILE = r17;
        Modifier r18 = new Modifier("SYNCHRONIZED", 9);
        SYNCHRONIZED = r18;
        Modifier r19 = new Modifier("NATIVE", 10);
        NATIVE = r19;
        Modifier r110 = new Modifier("STRICTFP", 11);
        STRICTFP = r110;
        f9458a = new Modifier[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
    }

    public static Modifier valueOf(String r5) {
        return (Modifier) Enum.valueOf(Modifier.class, r5);
    }

    public static Modifier[] values() {
        return (Modifier[]) f9458a.clone();
    }
}
