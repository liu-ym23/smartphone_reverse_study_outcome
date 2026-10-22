package kotlin.jvm.internal;

import ai.j0;
import androidx.room.compiler.processing.ksp.KspArrayType;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.4")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\bH\u0002J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\f\u0010\"\u001a\u00020\u001e*\u00020\u0006H\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006*"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "platformTypeUpperBound", "flags", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getFlags$kotlin_stdlib$annotations", "()V", "getFlags$kotlin_stdlib", "()I", "()Z", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "convertPrimitiveToWrapper", "equals", "other", "", "hashCode", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TypeReference implements KType {
    public static final Companion Companion = null;
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final int flags;
    private final KType platformTypeUpperBound;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/TypeReference$Companion;", "", "()V", "IS_MARKED_NULLABLE", "", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[KVariance.values().length];
            r5[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @SinceKotlin(version = "1.6")
    public TypeReference(KClassifier r5, List<KTypeProjection> r10, KType r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "classifier");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        this.classifier = r5;
        this.arguments = r10;
        this.platformTypeUpperBound = r11;
        this.flags = r12;
    }

    public static final /* synthetic */ String access$asString(TypeReference r5, KTypeProjection r10) {
        return r5.asString(r10);
    }

    private final String asString(boolean r11) {
        KClassifier r5 = getClassifier();
        Class<?> r10 = null;
        if ((r5 instanceof KClass) == false) goto L5;
        KClass r12 = (KClass) r5;
    L6:
        if (r12 == null) goto L8;
        r10 = JvmClassMappingKt.getJavaClass(r12);
    L8:
        if (r10 != null) goto L11;
        String r13 = getClassifier().toString();
    L21:
        String r14 = "";
        if (getArguments().isEmpty() == false) goto L24;
        String r15 = "";
    L26:
        if (isMarkedNullable() == false) goto L28;
        r14 = "?";
    L28:
        String r16 = j0.D(r13, r15, r14);
        KType r17 = this.platformTypeUpperBound;
        if ((r17 instanceof TypeReference) == false) goto L38;
        String r18 = ((TypeReference) r17).asString(true);
        if (Intrinsics.areEqual(r18, r16) == false) goto L34;
        return r16;
    L34:
        if (Intrinsics.areEqual(r18, r16 + '?') == false) goto L37;
        return r16 + '!';
    L37:
        return "(" + r16 + ".." + r18 + ')';
    L38:
        return r16;
    L24:
        r15 = CollectionsKt.q(getArguments(), ", ", "<", ">", 0, null, new TypeReference$asString$args$1(this), 24);
        goto L26
    L11:
        if ((this.flags & 4) == 0) goto L14;
        r13 = "kotlin.Nothing";
        goto L21
    L14:
        if (r10.isArray() == false) goto L16;
        r13 = getArrayClassName(r10);
        goto L21
    L16:
        if (r11 == true) goto L18;
    L20:
        r13 = r10.getName();
        goto L21
    L18:
        if (r10.isPrimitive() == false) goto L20;
        KClassifier r19 = getClassifier();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        r13 = JvmClassMappingKt.getJavaObjectType((KClass) r19).getName();
        goto L21
    L5:
        r12 = null;
        goto L6
    }

    private final String getArrayClassName(Class<?> r5) {
        if (Intrinsics.areEqual(r5, boolean[].class) == false) goto L6;
        return "kotlin.BooleanArray";
    L6:
        if (Intrinsics.areEqual(r5, char[].class) == false) goto L9;
        return "kotlin.CharArray";
    L9:
        if (Intrinsics.areEqual(r5, byte[].class) == false) goto L12;
        return "kotlin.ByteArray";
    L12:
        if (Intrinsics.areEqual(r5, short[].class) == false) goto L15;
        return "kotlin.ShortArray";
    L15:
        if (Intrinsics.areEqual(r5, int[].class) == false) goto L18;
        return "kotlin.IntArray";
    L18:
        if (Intrinsics.areEqual(r5, float[].class) == false) goto L21;
        return "kotlin.FloatArray";
    L21:
        if (Intrinsics.areEqual(r5, long[].class) == false) goto L24;
        return "kotlin.LongArray";
    L24:
        if (Intrinsics.areEqual(r5, double[].class) == false) goto L26;
        return "kotlin.DoubleArray";
    L26:
        return KspArrayType.KOTLIN_ARRAY_Q_NAME;
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof TypeReference) == false) goto L13;
        TypeReference r10 = (TypeReference) r5;
        if (Intrinsics.areEqual(getClassifier(), r10.getClassifier()) == false) goto L13;
        if (Intrinsics.areEqual(getArguments(), r10.getArguments()) == false) goto L13;
        if (Intrinsics.areEqual(this.platformTypeUpperBound, r10.platformTypeUpperBound) == false) goto L13;
        if (this.flags != r10.flags) goto L13;
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
        int r5 = getClassifier().hashCode() * 31;
        int r10 = (getArguments().hashCode() + r5) * 31;
        return Integer.hashCode(this.flags) + r10;
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        if ((this.flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return j0.q(new StringBuilder(), asString(false), " (Kotlin reflection is not available)");
    }

    public TypeReference(KClassifier r5, List<KTypeProjection> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "classifier");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        this(r5, r10, null, r11 ? 1 : 0);
    }

    private final String asString(KTypeProjection r5) {
        if (r5.getVariance() != null) goto L6;
        return XPath.WILDCARD;
    L6:
        KType r10 = r5.getType();
        if ((r10 instanceof TypeReference) == false) goto L9;
        TypeReference r11 = (TypeReference) r10;
    L11:
        if (r11 == null) goto L14;
        String r12 = r11.asString(true);
        if (r12 == null) goto L14;
    L15:
        KVariance r13 = r5.getVariance();
        int r14 = WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        if (r14 != 1) goto L18;
        return r12;
    L18:
        if (r14 == 2) goto L25;
        if (r14 != 3) goto L23;
        return "out ".concat(r12);
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        return "in ".concat(r12);
    L14:
        r12 = String.valueOf(r5.getType());
        goto L15
    L9:
        r11 = null;
        goto L11
    }
}
