package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum AnnotationArgumentsRenderingPolicy extends Enum<AnnotationArgumentsRenderingPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
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
        NO_ARGUMENTS = new AnnotationArgumentsRenderingPolicy("NO_ARGUMENTS", 0, false, false, 3, null);
        UNLESS_EMPTY = new AnnotationArgumentsRenderingPolicy("UNLESS_EMPTY", 1, true, false, 2, null);
        ALWAYS_PARENTHESIZED = new AnnotationArgumentsRenderingPolicy("ALWAYS_PARENTHESIZED", 2, true, true);
        AnnotationArgumentsRenderingPolicy[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
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

    public static AnnotationArgumentsRenderingPolicy valueOf(String r1) {
        return (AnnotationArgumentsRenderingPolicy) a.a(AnnotationArgumentsRenderingPolicy.class, r1);
    }

    private AnnotationArgumentsRenderingPolicy(String r1, int r2, boolean r3, boolean r4) {
        super(r1, r2);
        this.includeAnnotationArguments = r3;
        this.includeEmptyAnnotationArguments = r4;
    }

    public /* synthetic */ AnnotationArgumentsRenderingPolicy(String r2, int r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 2) == 0) goto L8;
        r5 = false;
    L8:
        this(r2, r3, r4, r5);
    }
}
