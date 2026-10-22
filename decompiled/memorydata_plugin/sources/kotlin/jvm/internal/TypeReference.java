package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: classes6.dex */
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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KVariance.values().length];
            r0[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TypeReference(KClassifier r3, List<KTypeProjection> r4, KType r5, int r6) {
        KClassifier r7 = (KClassifier) ZeusTransformUtils.wrapperContextForParams(r3, KClassifier.class, "com.obric.memorydata.plugin");
        List<KTypeProjection> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        KType r9 = (KType) ZeusTransformUtils.wrapperContextForParams(r5, KType.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "classifier");
        Intrinsics.checkNotNullParameter(r8, "arguments");
        this.classifier = r7;
        this.arguments = r8;
        this.platformTypeUpperBound = r9;
        this.flags = r6;
    }

    public TypeReference(KClassifier r3, List<KTypeProjection> r4, boolean r5) {
        KClassifier r6 = (KClassifier) ZeusTransformUtils.wrapperContextForParams(r3, KClassifier.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "classifier");
        Intrinsics.checkNotNullParameter(r7, "arguments");
        this(r6, r7, null, r5 ? 1 : 0);
    }

    public static final /* synthetic */ String access$asString(TypeReference r0, KTypeProjection r1) {
        return r0.asString(r1);
    }

    private final String asString(KTypeProjection r3) {
        if (r3.getVariance() != null) goto L6;
        return "*";
    L6:
        KType r0 = r3.getType();
        if (ZeusTransformUtils.instanceOf(r0, TypeReference.class) == false) goto L9;
        TypeReference r2 = (TypeReference) ZeusTransformUtils.preCheckCast(r0, TypeReference.class, "com.obric.memorydata.plugin");
    L11:
        if (r2 == null) goto L14;
        String r4 = r2.asString(true);
        if (r4 == null) goto L14;
    L15:
        KVariance r5 = r3.getVariance();
        int r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r6 != 1) goto L18;
        return r4;
    L18:
        if (r6 != 2) goto L20;
        StringBuilder r7 = new StringBuilder();
        String r1 = "in ";
    L26:
        return r7.append(r1).append(r4).toString();
    L20:
        if (r6 != 3) goto L23;
        r7 = new StringBuilder();
        r1 = "out ";
        goto L26
    L23:
        throw new NoWhenBranchMatchedException();
    L14:
        r4 = String.valueOf(r3.getType());
        goto L15
    L9:
        r2 = null;
        goto L11
    }

    private final String asString(boolean r15) {
        KClassifier r1 = getClassifier();
        Class<?> r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, KClass.class) == false) goto L5;
        KClass r2 = (KClass) ZeusTransformUtils.preCheckCast(r1, KClass.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 == null) goto L8;
        r3 = JvmClassMappingKt.getJavaClass(r2);
    L8:
        if (r3 != null) goto L11;
        String r16 = getClassifier().toString();
    L21:
        String r4 = "";
        if (getArguments().isEmpty() == false) goto L24;
        String r5 = "";
    L26:
        if (isMarkedNullable() == false) goto L28;
        r4 = "?";
    L28:
        String r17 = r16 + r5 + r4;
        KType r14 = this.platformTypeUpperBound;
        if (ZeusTransformUtils.instanceOf(r14, TypeReference.class) == false) goto L39;
        String r18 = ((TypeReference) ZeusTransformUtils.preCheckCast(r14, TypeReference.class, "com.obric.memorydata.plugin")).asString(true);
        if (Intrinsics.areEqual(r18, r17) == false) goto L34;
        return r17;
    L34:
        if (Intrinsics.areEqual(r18, r17 + '?') == false) goto L36;
        StringBuilder r19 = new StringBuilder().append(r17);
        char r110 = '!';
    L38:
        return r19.append(r110).toString();
    L36:
        r19 = new StringBuilder().append('(').append(r17).append("..").append(r18);
        r110 = ')';
        goto L38
    L39:
        return r17;
    L24:
        r5 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(getArguments(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("<", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(">", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(new TypeReference$asString$args$1(this), Function1.class, "com.obric.memorydata.plugin"), 24, null);
        goto L26
    L11:
        if ((this.flags & 4) == 0) goto L14;
        r16 = "kotlin.Nothing";
        goto L21
    L14:
        if (r3.isArray() == false) goto L16;
        r16 = getArrayClassName(r3);
        goto L21
    L16:
        if (r15 == true) goto L18;
    L20:
        r16 = r3.getName();
        goto L21
    L18:
        if (r3.isPrimitive() == false) goto L20;
        KClassifier r111 = getClassifier();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        r16 = JvmClassMappingKt.getJavaObjectType((KClass) ZeusTransformUtils.preCheckCast(r111, KClass.class, "com.obric.memorydata.plugin")).getName();
        goto L21
    L5:
        r2 = null;
        goto L6
    }

    private final String getArrayClassName(Class<?> r1) {
        if (Intrinsics.areEqual(r1, boolean[].class) == false) goto L6;
        return "kotlin.BooleanArray";
    L6:
        if (Intrinsics.areEqual(r1, char[].class) == false) goto L9;
        return "kotlin.CharArray";
    L9:
        if (Intrinsics.areEqual(r1, byte[].class) == false) goto L12;
        return "kotlin.ByteArray";
    L12:
        if (Intrinsics.areEqual(r1, short[].class) == false) goto L15;
        return "kotlin.ShortArray";
    L15:
        if (Intrinsics.areEqual(r1, int[].class) == false) goto L18;
        return "kotlin.IntArray";
    L18:
        if (Intrinsics.areEqual(r1, float[].class) == false) goto L21;
        return "kotlin.FloatArray";
    L21:
        if (Intrinsics.areEqual(r1, long[].class) == false) goto L24;
        return "kotlin.LongArray";
    L24:
        if (Intrinsics.areEqual(r1, double[].class) == false) goto L26;
        return "kotlin.DoubleArray";
    L26:
        return "kotlin.Array";
    }

    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, TypeReference.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (Intrinsics.areEqual(getClassifier(), ((TypeReference) ZeusTransformUtils.preCheckCast(r5, TypeReference.class, "com.obric.memorydata.plugin")).getClassifier()) == false) goto L13;
        if (Intrinsics.areEqual(getArguments(), ((TypeReference) ZeusTransformUtils.preCheckCast(r5, TypeReference.class, "com.obric.memorydata.plugin")).getArguments()) == false) goto L13;
        if (Intrinsics.areEqual(this.platformTypeUpperBound, ((TypeReference) ZeusTransformUtils.preCheckCast(r5, TypeReference.class, "com.obric.memorydata.plugin")).platformTypeUpperBound) == false) goto L13;
        if (this.flags != ((TypeReference) ZeusTransformUtils.preCheckCast(r5, TypeReference.class, "com.obric.memorydata.plugin")).flags) goto L13;
        return true;
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
