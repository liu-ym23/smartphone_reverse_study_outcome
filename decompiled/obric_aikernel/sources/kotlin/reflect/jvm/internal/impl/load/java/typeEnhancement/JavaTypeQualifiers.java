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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.access$getNONE$cp();
        }
    }

    static {
        Companion = new Companion(null);
        NONE = new JavaTypeQualifiers(null, null, false, false, 8, null);
    }

    public JavaTypeQualifiers(NullabilityQualifier r10, MutabilityQualifier r11, boolean r12, boolean r13) {
        this.nullability = r10;
        this.mutability = r11;
        this.definitelyNotNull = r12;
        this.isNullabilityQualifierForWarning = r13;
    }

    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier r10, MutabilityQualifier r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = false;
    L5:
        this(r10, r11, r12, r13);
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
}
