package com.squareup.kotlinpoet;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b$\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0¨\u00061"}, d2 = {"Lcom/squareup/kotlinpoet/KModifier;", "", "Lcom/squareup/kotlinpoet/KModifier$Target;", "target", "", "checkTarget$kotlinpoet", "(Lcom/squareup/kotlinpoet/KModifier$Target;)V", "checkTarget", "", "keyword", "Ljava/lang/String;", "getKeyword$kotlinpoet", "()Ljava/lang/String;", "", "targets", "[Lcom/squareup/kotlinpoet/KModifier$Target;", "Target", "PUBLIC", "PROTECTED", "PRIVATE", "INTERNAL", "EXPECT", "ACTUAL", "FINAL", "OPEN", "ABSTRACT", "SEALED", "CONST", "EXTERNAL", "OVERRIDE", "LATEINIT", "TAILREC", "VARARG", "SUSPEND", "INNER", "ENUM", "ANNOTATION", "VALUE", "FUN", "COMPANION", "INLINE", "NOINLINE", "CROSSINLINE", "REIFIED", "INFIX", "OPERATOR", "DATA", "IN", "OUT", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KModifier extends Enum<KModifier> {
    public static final KModifier ABSTRACT = null;
    public static final KModifier ACTUAL = null;
    public static final KModifier ANNOTATION = null;
    public static final KModifier COMPANION = null;
    public static final KModifier CONST = null;
    public static final KModifier CROSSINLINE = null;
    public static final KModifier DATA = null;
    public static final KModifier ENUM = null;
    public static final KModifier EXPECT = null;
    public static final KModifier EXTERNAL = null;
    public static final KModifier FINAL = null;
    public static final KModifier FUN = null;
    public static final KModifier IN = null;
    public static final KModifier INFIX = null;
    public static final KModifier INLINE = null;
    public static final KModifier INNER = null;
    public static final KModifier INTERNAL = null;
    public static final KModifier LATEINIT = null;
    public static final KModifier NOINLINE = null;
    public static final KModifier OPEN = null;
    public static final KModifier OPERATOR = null;
    public static final KModifier OUT = null;
    public static final KModifier OVERRIDE = null;
    public static final KModifier PRIVATE = null;
    public static final KModifier PROTECTED = null;
    public static final KModifier PUBLIC = null;
    public static final KModifier REIFIED = null;
    public static final KModifier SEALED = null;
    public static final KModifier SUSPEND = null;
    public static final KModifier TAILREC = null;
    public static final KModifier VALUE = null;
    public static final KModifier VARARG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KModifier[] f15068a = null;
    private final String keyword;
    private final Target[] targets;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/squareup/kotlinpoet/KModifier$Target;", "", "CLASS", "VARIANCE_ANNOTATION", "PARAMETER", "TYPE_PARAMETER", "FUNCTION", "PROPERTY", "INTERFACE", "kotlinpoet"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Target extends Enum<Target> {
        public static final Target CLASS = null;
        public static final Target FUNCTION = null;
        public static final Target INTERFACE = null;
        public static final Target PARAMETER = null;
        public static final Target PROPERTY = null;
        public static final Target TYPE_PARAMETER = null;
        public static final Target VARIANCE_ANNOTATION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Target[] f15069a = null;

        static {
            Target r5 = new Target("CLASS", 0);
            CLASS = r5;
            Target r10 = new Target("VARIANCE_ANNOTATION", 1);
            VARIANCE_ANNOTATION = r10;
            Target r11 = new Target("PARAMETER", 2);
            PARAMETER = r11;
            Target r12 = new Target("TYPE_PARAMETER", 3);
            TYPE_PARAMETER = r12;
            Target r13 = new Target("FUNCTION", 4);
            FUNCTION = r13;
            Target r14 = new Target("PROPERTY", 5);
            PROPERTY = r14;
            Target r15 = new Target("INTERFACE", 6);
            INTERFACE = r15;
            f15069a = new Target[]{r5, r10, r11, r12, r13, r14, r15};
        }

        public static Target valueOf(String r5) {
            return (Target) Enum.valueOf(Target.class, r5);
        }

        public static Target[] values() {
            return (Target[]) f15069a.clone();
        }
    }

    static {
        Target r5 = Target.PROPERTY;
        KModifier r10 = new KModifier("PUBLIC", 0, "public", new Target[]{r5});
        PUBLIC = r10;
        KModifier r11 = new KModifier("PROTECTED", 1, "protected", new Target[]{r5});
        PROTECTED = r11;
        KModifier r12 = new KModifier("PRIVATE", 2, "private", new Target[]{r5});
        PRIVATE = r12;
        KModifier r13 = new KModifier("INTERNAL", 3, "internal", new Target[]{r5});
        INTERNAL = r13;
        Target r14 = Target.CLASS;
        Target r15 = Target.FUNCTION;
        KModifier r16 = new KModifier("EXPECT", 4, "expect", new Target[]{r14, r15, r5});
        EXPECT = r16;
        KModifier r17 = new KModifier("ACTUAL", 5, "actual", new Target[]{r14, r15, r5});
        ACTUAL = r17;
        KModifier r18 = new KModifier("FINAL", 6, "final", new Target[]{r14, r15, r5});
        FINAL = r18;
        KModifier r19 = new KModifier("OPEN", 7, "open", new Target[]{r14, r15, r5});
        OPEN = r19;
        KModifier r110 = new KModifier("ABSTRACT", 8, "abstract", new Target[]{r14, r15, r5});
        ABSTRACT = r110;
        KModifier r111 = new KModifier("SEALED", 9, "sealed", new Target[]{r14});
        SEALED = r111;
        KModifier r112 = new KModifier("CONST", 10, "const", new Target[]{r5});
        CONST = r112;
        KModifier r113 = new KModifier("EXTERNAL", 11, "external", new Target[]{r14, r15, r5});
        EXTERNAL = r113;
        KModifier r114 = new KModifier("OVERRIDE", 12, "override", new Target[]{r15, r5});
        OVERRIDE = r114;
        KModifier r115 = new KModifier("LATEINIT", 13, "lateinit", new Target[]{r5});
        LATEINIT = r115;
        KModifier r116 = new KModifier("TAILREC", 14, "tailrec", new Target[]{r15});
        TAILREC = r116;
        Target r20 = Target.PARAMETER;
        KModifier r117 = new KModifier("VARARG", 15, "vararg", new Target[]{r20});
        VARARG = r117;
        KModifier r118 = new KModifier("SUSPEND", 16, "suspend", new Target[]{r15});
        SUSPEND = r118;
        KModifier r119 = new KModifier("INNER", 17, "inner", new Target[]{r14});
        INNER = r119;
        KModifier r120 = new KModifier("ENUM", 18, "enum", new Target[]{r14});
        ENUM = r120;
        KModifier r121 = new KModifier("ANNOTATION", 19, "annotation", new Target[]{r14});
        ANNOTATION = r121;
        KModifier r122 = new KModifier("VALUE", 20, "value", new Target[]{r14});
        VALUE = r122;
        KModifier r123 = new KModifier("FUN", 21, "fun", new Target[]{Target.INTERFACE});
        FUN = r123;
        KModifier r124 = new KModifier("COMPANION", 22, "companion", new Target[]{r14});
        COMPANION = r124;
        KModifier r125 = new KModifier("INLINE", 23, "inline", new Target[]{r15});
        INLINE = r125;
        KModifier r126 = new KModifier("NOINLINE", 24, "noinline", new Target[]{r20});
        NOINLINE = r126;
        KModifier r127 = new KModifier("CROSSINLINE", 25, "crossinline", new Target[]{r20});
        CROSSINLINE = r127;
        KModifier r128 = new KModifier("REIFIED", 26, "reified", new Target[]{Target.TYPE_PARAMETER});
        REIFIED = r128;
        KModifier r129 = new KModifier("INFIX", 27, "infix", new Target[]{r15});
        INFIX = r129;
        KModifier r130 = new KModifier("OPERATOR", 28, "operator", new Target[]{r15});
        OPERATOR = r130;
        KModifier r131 = new KModifier("DATA", 29, "data", new Target[]{r14});
        DATA = r131;
        Target r21 = Target.VARIANCE_ANNOTATION;
        KModifier r132 = new KModifier("IN", 30, "in", new Target[]{r21});
        IN = r132;
        KModifier r133 = new KModifier("OUT", 31, "out", new Target[]{r21});
        OUT = r133;
        f15068a = new KModifier[]{r10, r11, r12, r13, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133};
    }

    public KModifier(String r5, int r10, String r11, Target... r12) {
        super(r5, r10);
        this.keyword = r11;
        this.targets = r12;
    }

    public static KModifier valueOf(String r5) {
        return (KModifier) Enum.valueOf(KModifier.class, r5);
    }

    public static KModifier[] values() {
        return (KModifier[]) f15068a.clone();
    }

    public final void checkTarget$kotlinpoet(Target r5) {
        Intrinsics.checkNotNullParameter(r5, "target");
        if (ArraysKt.contains(this.targets, r5) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("unexpected modifier " + this + " for " + r5).toString());
    }

    public final String getKeyword$kotlinpoet() {
        return this.keyword;
    }
}
