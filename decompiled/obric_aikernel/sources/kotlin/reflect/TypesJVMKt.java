package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1549#3:232\n1620#3,3:233\n1549#3:236\n1620#3,3:237\n1549#3:240\n1620#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n"})
public final class TypesJVMKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[KVariance.values().length];
            r10[KVariance.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[KVariance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public static final /* synthetic */ Type access$computeJavaType(KType r10, boolean r11) {
        return computeJavaType(r10, r11);
    }

    public static final /* synthetic */ String access$typeToString(Type r10) {
        return typeToString(r10);
    }

    @ExperimentalStdlibApi
    private static final Type computeJavaType(KType r10, boolean r11) {
        KClassifier r12 = r10.getClassifier();
        if ((r12 instanceof KTypeParameter) == false) goto L7;
        return new TypeVariableImpl((KTypeParameter) r12);
    L7:
        if ((r12 instanceof KClass) == false) goto L46;
        KClass r13 = (KClass) r12;
        if (r11 == false) goto L11;
        Class r14 = JvmClassMappingKt.getJavaObjectType(r13);
    L12:
        List<KTypeProjection> r15 = r10.getArguments();
        if (r15.isEmpty() == false) goto L16;
        return r14;
    L16:
        if (r14.isArray() == false) goto L44;
        if (r14.getComponentType().isPrimitive() == false) goto L20;
        return r14;
    L20:
        KTypeProjection r16 = (KTypeProjection) CollectionsKt.singleOrNull(r15);
        if (r16 == null) goto L42;
        KVariance r17 = r16.component1();
        KType r18 = r16.component2();
        if (r17 != null) goto L25;
        int r19 = -1;
    L26:
        if (r19 != (-1)) goto L28;
        return r14;
    L28:
        if (r19 != 1) goto L30;
        return r14;
    L30:
        if (r19 != 2) goto L32;
    L36:
        Intrinsics.checkNotNull(r18);
        Type r20 = computeJavaType$default(r18, false, 1, null);
        if ((r20 instanceof Class) == false) goto L40;
        return r14;
    L40:
        return new GenericArrayTypeImpl(r20);
    L32:
        if (r19 == 3) goto L36;
        throw new NoWhenBranchMatchedException();
    L25:
        r19 = WhenMappings.$EnumSwitchMapping$0[r17.ordinal()];
        goto L26
    L42:
        throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + r10);
    L44:
        return createPossiblyInnerType(r14, r15);
    L11:
        r14 = JvmClassMappingKt.getJavaClass(r13);
        goto L12
    L46:
        throw new UnsupportedOperationException("Unsupported type classifier: " + r10);
    }

    static /* synthetic */ Type computeJavaType$default(KType r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        return computeJavaType(r10, r11);
    }

    @ExperimentalStdlibApi
    private static final Type createPossiblyInnerType(Class<?> r10, List<KTypeProjection> r11) {
        Class<?> r12 = r10.getDeclaringClass();
        if (r12 != null) goto L11;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r14 = r11.iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        r13.add(getJavaType((KTypeProjection) r14.next()));
        goto L6
    L9:
        return new ParameterizedTypeImpl(r10, null, r13);
    L11:
        if (Modifier.isStatic(r10.getModifiers()) == false) goto L18;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r16 = r11.iterator();
    L14:
        if (r16.hasNext() == false) goto L17;
        r15.add(getJavaType((KTypeProjection) r16.next()));
        goto L14
    L17:
        return new ParameterizedTypeImpl(r10, r12, r15);
    L18:
        int r17 = r10.getTypeParameters().length;
        Type r18 = createPossiblyInnerType(r12, r11.subList(r17, r11.size()));
        List<KTypeProjection> r19 = r11.subList(0, r17);
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator<T> r21 = r19.iterator();
    L20:
        if (r21.hasNext() == false) goto L23;
        r20.add(getJavaType((KTypeProjection) r21.next()));
        goto L20
    L23:
        return new ParameterizedTypeImpl(r10, r18, r20);
    }

    public static final Type getJavaType(KType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof KTypeBase) == false) goto L8;
        Type r11 = ((KTypeBase) r10).getJavaType();
        if (r11 == null) goto L8;
        return r11;
    L8:
        return computeJavaType$default(r10, false, 1, null);
    }

    private static final Type getJavaType(KTypeProjection r10) {
        KVariance r11 = r10.getVariance();
        if (r11 == null) goto L5;
        KType r12 = r10.getType();
        Intrinsics.checkNotNull(r12);
        int r13 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        if (r13 == 1) goto L17;
        if (r13 == 2) goto L19;
        if (r13 != 3) goto L14;
        return new WildcardTypeImpl(computeJavaType(r12, true), null);
    L14:
        throw new NoWhenBranchMatchedException();
    L19:
        return computeJavaType(r12, true);
    L17:
        return new WildcardTypeImpl(null, computeJavaType(r12, true));
    L5:
        return WildcardTypeImpl.Companion.getSTAR();
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void getJavaType$annotations(KType r10) {
    }

    @ExperimentalStdlibApi
    private static /* synthetic */ void getJavaType$annotations(KTypeProjection r10) {
    }

    private static final String typeToString(Type r10) {
        if ((r10 instanceof Class) == false) goto L10;
        Class r11 = (Class) r10;
        if (r11.isArray() == false) goto L7;
        Sequence r12 = SequencesKt.generateSequence(r10, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        String r13 = ((Class) SequencesKt.last(r12)).getName() + StringsKt.repeat("[]", SequencesKt.count(r12));
    L8:
        Intrinsics.checkNotNullExpressionValue(r13, "{\n        if (type.isArr…   } else type.name\n    }");
        return r13;
    L7:
        r13 = r11.getName();
        goto L8
    L10:
        return r10.toString();
    }
}
