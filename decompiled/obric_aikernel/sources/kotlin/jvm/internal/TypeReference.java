package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.4")
public final class TypeReference implements KType {
    public static final Companion Companion = null;
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final int flags;
    private final KType platformTypeUpperBound;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[KVariance.values().length];
            r10[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @SinceKotlin(version = "1.6")
    public TypeReference(KClassifier r10, List<KTypeProjection> r11, KType r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "classifier");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        this.classifier = r10;
        this.arguments = r11;
        this.platformTypeUpperBound = r12;
        this.flags = r13;
    }

    public TypeReference(KClassifier r10, List<KTypeProjection> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "classifier");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        this(r10, r11, null, r12 ? 1 : 0);
    }

    public static final /* synthetic */ String access$asString(TypeReference r10, KTypeProjection r11) {
        return r10.asString(r11);
    }

    private final String asString(KTypeProjection r10) {
        if (r10.getVariance() != null) goto L6;
        return "*";
    L6:
        KType r11 = r10.getType();
        if ((r11 instanceof TypeReference) == false) goto L9;
        TypeReference r12 = (TypeReference) r11;
    L11:
        if (r12 == null) goto L14;
        String r13 = r12.asString(true);
        if (r13 == null) goto L14;
    L15:
        KVariance r14 = r10.getVariance();
        int r15 = WhenMappings.$EnumSwitchMapping$0[r14.ordinal()];
        if (r15 != 1) goto L18;
        return r13;
    L18:
        if (r15 != 2) goto L20;
        StringBuilder r16 = new StringBuilder();
        String r17 = "in ";
    L25:
        r16.append(r17);
        r16.append(r13);
        return r16.toString();
    L20:
        if (r15 != 3) goto L23;
        r16 = new StringBuilder();
        r17 = "out ";
        goto L25
    L23:
        throw new NoWhenBranchMatchedException();
    L14:
        r13 = String.valueOf(r10.getType());
        goto L15
    L9:
        r12 = null;
        goto L11
    }

    private final String asString(boolean r12) {
        KClassifier r10 = getClassifier();
        Class<?> r11 = null;
        if ((r10 instanceof KClass) == false) goto L5;
        KClass r13 = (KClass) r10;
    L6:
        if (r13 == null) goto L8;
        r11 = JvmClassMappingKt.getJavaClass(r13);
    L8:
        if (r11 != null) goto L11;
        String r14 = getClassifier().toString();
    L21:
        String r15 = "";
        if (getArguments().isEmpty() == false) goto L24;
        String r16 = "";
    L26:
        if (isMarkedNullable() == false) goto L28;
        r15 = "?";
    L28:
        String r17 = r14 + r16 + r15;
        KType r18 = this.platformTypeUpperBound;
        if ((r18 instanceof TypeReference) == false) goto L38;
        String r19 = ((TypeReference) r18).asString(true);
        if (Intrinsics.areEqual(r19, r17) == false) goto L34;
        return r17;
    L34:
        if (Intrinsics.areEqual(r19, r17 + '?') == false) goto L37;
        return r17 + '!';
    L37:
        return '(' + r17 + ".." + r19 + ')';
    L38:
        return r17;
    L24:
        r16 = CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new TypeReference$asString$args$1(this), 24, null);
        goto L26
    L11:
        if ((this.flags & 4) == 0) goto L14;
        r14 = "kotlin.Nothing";
        goto L21
    L14:
        if (r11.isArray() == false) goto L16;
        r14 = getArrayClassName(r11);
        goto L21
    L16:
        if (r12 == true) goto L18;
    L20:
        r14 = r11.getName();
        goto L21
    L18:
        if (r11.isPrimitive() == false) goto L20;
        KClassifier r110 = getClassifier();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        r14 = JvmClassMappingKt.getJavaObjectType((KClass) r110).getName();
        goto L21
    L5:
        r13 = null;
        goto L6
    }

    private final String getArrayClassName(Class<?> r10) {
        if (Intrinsics.areEqual(r10, boolean[].class) == false) goto L6;
        return "kotlin.BooleanArray";
    L6:
        if (Intrinsics.areEqual(r10, char[].class) == false) goto L9;
        return "kotlin.CharArray";
    L9:
        if (Intrinsics.areEqual(r10, byte[].class) == false) goto L12;
        return "kotlin.ByteArray";
    L12:
        if (Intrinsics.areEqual(r10, short[].class) == false) goto L15;
        return "kotlin.ShortArray";
    L15:
        if (Intrinsics.areEqual(r10, int[].class) == false) goto L18;
        return "kotlin.IntArray";
    L18:
        if (Intrinsics.areEqual(r10, float[].class) == false) goto L21;
        return "kotlin.FloatArray";
    L21:
        if (Intrinsics.areEqual(r10, long[].class) == false) goto L24;
        return "kotlin.LongArray";
    L24:
        if (Intrinsics.areEqual(r10, double[].class) == false) goto L26;
        return "kotlin.DoubleArray";
    L26:
        return "kotlin.Array";
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof TypeReference) == false) goto L13;
        TypeReference r11 = (TypeReference) r10;
        if (Intrinsics.areEqual(getClassifier(), r11.getClassifier()) == false) goto L13;
        if (Intrinsics.areEqual(getArguments(), r11.getArguments()) == false) goto L13;
        if (Intrinsics.areEqual(this.platformTypeUpperBound, r11.platformTypeUpperBound) == false) goto L13;
        if (this.flags != r11.flags) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.classifier;
    }

    public final int getFlags$kotlin_stdlib() {
        return this.flags;
    }

    public final KType getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.hashCode(this.flags);
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        if ((this.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return asString(false) + " (Kotlin reflection is not available)";
    }
}
