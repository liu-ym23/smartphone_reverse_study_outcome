package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final enum AnnotationArgumentsRenderingPolicy extends Enum<AnnotationArgumentsRenderingPolicy> {
    private static final /* synthetic */ AnnotationArgumentsRenderingPolicy[] $VALUES = null;
    public static final AnnotationArgumentsRenderingPolicy ALWAYS_PARENTHESIZED = null;
    public static final AnnotationArgumentsRenderingPolicy NO_ARGUMENTS = null;
    public static final AnnotationArgumentsRenderingPolicy UNLESS_EMPTY = null;
    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    private static final /* synthetic */ AnnotationArgumentsRenderingPolicy[] $values() {
        return new AnnotationArgumentsRenderingPolicy[]{NO_ARGUMENTS, UNLESS_EMPTY, ALWAYS_PARENTHESIZED};
    }

    static {
        String r5 = "NO_ARGUMENTS";
        int r10 = 0;
        boolean r11 = false;
        boolean r12 = false;
        NO_ARGUMENTS = new AnnotationArgumentsRenderingPolicy(r5, r10, r11, r12, 3, null);
        String r13 = "UNLESS_EMPTY";
        int r14 = 1;
        boolean r15 = true;
        boolean r16 = false;
        UNLESS_EMPTY = new AnnotationArgumentsRenderingPolicy(r13, r14, r15, r16, 2, null);
        ALWAYS_PARENTHESIZED = new AnnotationArgumentsRenderingPolicy("ALWAYS_PARENTHESIZED", 2, true, true);
        $VALUES = $values();
    }

    private AnnotationArgumentsRenderingPolicy(String r5, int r10, boolean r11, boolean r12) {
        super(r5, r10);
        this.includeAnnotationArguments = r11;
        this.includeEmptyAnnotationArguments = r12;
    }

    public static AnnotationArgumentsRenderingPolicy valueOf(String r5) {
        return (AnnotationArgumentsRenderingPolicy) Enum.valueOf(AnnotationArgumentsRenderingPolicy.class, r5);
    }

    public static AnnotationArgumentsRenderingPolicy[] values() {
        return (AnnotationArgumentsRenderingPolicy[]) $VALUES.clone();
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    public /* synthetic */ AnnotationArgumentsRenderingPolicy(String r5, int r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = false;
    L8:
        this(r5, r10, r11, r12);
    }
}
