package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1557#3:232\n1628#3,3:233\n1557#3:236\n1628#3,3:237\n1557#3:240\n1628#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n"})
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[KVariance.values().length];
            r5[KVariance.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[KVariance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public static final /* synthetic */ Type access$computeJavaType(KType r5, boolean r10) {
        return computeJavaType(r5, r10);
    }

    public static final /* synthetic */ String access$typeToString(Type r5) {
        return typeToString(r5);
    }

    @ExperimentalStdlibApi
    private static final Type computeJavaType(KType r5, boolean r10) {
        KClassifier r11 = r5.getClassifier();
        if ((r11 instanceof KTypeParameter) == false) goto L7;
        return new TypeVariableImpl((KTypeParameter) r11);
    L7:
        if ((r11 instanceof KClass) == false) goto L46;
        KClass r12 = (KClass) r11;
        if (r10 == false) goto L11;
        Class r13 = JvmClassMappingKt.getJavaObjectType(r12);
    L12:
        List<KTypeProjection> r14 = r5.getArguments();
        if (r14.isEmpty() == false) goto L16;
        return r13;
    L16:
        if (r13.isArray() == false) goto L44;
        if (r13.getComponentType().isPrimitive() == false) goto L20;
        return r13;
    L20:
        KTypeProjection r15 = (KTypeProjection) CollectionsKt.singleOrNull(r14);
        if (r15 == null) goto L42;
        KVariance r16 = r15.component1();
        KType r17 = r15.component2();
        if (r16 != null) goto L25;
        int r18 = -1;
    L26:
        if (r18 != (-1)) goto L28;
        return r13;
    L28:
        if (r18 != 1) goto L30;
        return r13;
    L30:
        if (r18 != 2) goto L32;
    L36:
        Intrinsics.checkNotNull(r17);
        Type r19 = computeJavaType$default(r17, false, 1, null);
        if ((r19 instanceof Class) == false) goto L40;
        return r13;
    L40:
        return new GenericArrayTypeImpl(r19);
    L32:
        if (r18 == 3) goto L36;
        throw new NoWhenBranchMatchedException();
    L25:
        r18 = WhenMappings.$EnumSwitchMapping$0[r16.ordinal()];
        goto L26
    L42:
        throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + r5);
    L44:
        return createPossiblyInnerType(r13, r14);
    L11:
        r13 = JvmClassMappingKt.getJavaClass(r12);
        goto L12
    L46:
        throw new UnsupportedOperationException("Unsupported type classifier: " + r5);
    }

    public static /* synthetic */ Type computeJavaType$default(KType r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = false;
    L6:
        return computeJavaType(r5, r10);
    }

    @ExperimentalStdlibApi
    private static final Type createPossiblyInnerType(Class<?> r5, List<KTypeProjection> r10) {
        Class<?> r11 = r5.getDeclaringClass();
        if (r11 != null) goto L11;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        r12.add(getJavaType((KTypeProjection) r13.next()));
        goto L6
    L9:
        return new ParameterizedTypeImpl(r5, null, r12);
    L11:
        if (Modifier.isStatic(r5.getModifiers()) == false) goto L18;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r15 = r10.iterator();
    L14:
        if (r15.hasNext() == false) goto L17;
        r14.add(getJavaType((KTypeProjection) r15.next()));
        goto L14
    L17:
        return new ParameterizedTypeImpl(r5, r11, r14);
    L18:
        int r16 = r5.getTypeParameters().length;
        Type r17 = createPossiblyInnerType(r11, r10.subList(r16, r10.size()));
        List<KTypeProjection> r18 = r10.subList(0, r16);
        ArrayList r19 = new ArrayList(CollectionsKt.h(r18));
        Iterator<T> r20 = r18.iterator();
    L20:
        if (r20.hasNext() == false) goto L23;
        r19.add(getJavaType((KTypeProjection) r20.next()));
        goto L20
    L23:
        return new ParameterizedTypeImpl(r5, r17, r19);
    }

    public static final Type getJavaType(KType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KTypeBase) == false) goto L8;
        Type r10 = ((KTypeBase) r5).getJavaType();
        if (r10 == null) goto L8;
        return r10;
    L8:
        return computeJavaType$default(r5, false, 1, null);
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void getJavaType$annotations(KType r5) {
    }

    private static final String typeToString(Type r5) {
        if ((r5 instanceof Class) == false) goto L10;
        Class r10 = (Class) r5;
        if (r10.isArray() == false) goto L7;
        Sequence r11 = SequencesKt.generateSequence(r5, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        String r12 = ((Class) SequencesKt.last(r11)).getName() + StringsKt.D(SequencesKt.count(r11), "[]");
    L8:
        Intrinsics.checkNotNull(r12);
        return r12;
    L7:
        r12 = r10.getName();
        goto L8
    L10:
        return r5.toString();
    }

    @ExperimentalStdlibApi
    private static /* synthetic */ void getJavaType$annotations(KTypeProjection r5) {
    }

    private static final Type getJavaType(KTypeProjection r5) {
        KVariance r10 = r5.getVariance();
        if (r10 == null) goto L5;
        KType r11 = r5.getType();
        Intrinsics.checkNotNull(r11);
        int r12 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r12 == 1) goto L17;
        if (r12 == 2) goto L19;
        if (r12 != 3) goto L14;
        return new WildcardTypeImpl(computeJavaType(r11, true), null);
    L14:
        throw new NoWhenBranchMatchedException();
    L19:
        return computeJavaType(r11, true);
    L17:
        return new WildcardTypeImpl(null, computeJavaType(r11, true));
    L5:
        return WildcardTypeImpl.Companion.getSTAR();
    }
}
