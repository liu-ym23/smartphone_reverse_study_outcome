package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeQualifiers {
    public static final Companion Companion = null;
    private static final JavaTypeQualifiers NONE = null;
    private final boolean definitelyNotNull;
    private final boolean isNullabilityQualifierForWarning;
    private final MutabilityQualifier mutability;
    private final NullabilityQualifier nullability;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.access$getNONE$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        NullabilityQualifier r5 = null;
        MutabilityQualifier r10 = null;
        boolean r11 = false;
        boolean r12 = false;
        NONE = new JavaTypeQualifiers(r5, r10, r11, r12, 8, null);
    }

    public JavaTypeQualifiers(NullabilityQualifier r5, MutabilityQualifier r10, boolean r11, boolean r12) {
        this.nullability = r5;
        this.mutability = r10;
        this.definitelyNotNull = r11;
        this.isNullabilityQualifierForWarning = r12;
    }

    public static final /* synthetic */ JavaTypeQualifiers access$getNONE$cp() {
        return NONE;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier r5, MutabilityQualifier r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        r12 = false;
    L5:
        this(r5, r10, r11, r12);
    }
}
