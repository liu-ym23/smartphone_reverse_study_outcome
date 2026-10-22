package kotlin.reflect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KVariance.values().length];
            r0[KVariance.IN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KVariance.INVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final /* synthetic */ Type access$computeJavaType(KType r2, boolean r3) {
        return computeJavaType((KType) ZeusTransformUtils.wrapperContextForParams(r2, KType.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final /* synthetic */ String access$typeToString(Type r2) {
        return typeToString((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Class, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9, types: [kotlin.reflect.GenericArrayTypeImpl] */
    private static final Type computeJavaType(KType r4, boolean r5) {
        KType r6 = (KType) ZeusTransformUtils.wrapperContextForParams(r4, KType.class, "com.obric.memorydata.plugin");
        KClassifier r0 = r6.getClassifier();
        if (ZeusTransformUtils.instanceOf(r0, KTypeParameter.class) == false) goto L8;
        Object r7 = ZeusTransformUtils.preCheckCast(new TypeVariableImpl((KTypeParameter) ZeusTransformUtils.preCheckCast(r0, KTypeParameter.class, "com.obric.memorydata.plugin")), Type.class, "com.obric.memorydata.plugin");
    L6:
        return (Type) r7;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, KClass.class) == false) goto L47;
        if (r5 == false) goto L11;
        Object r8 = JvmClassMappingKt.getJavaObjectType((KClass) ZeusTransformUtils.preCheckCast(r0, KClass.class, "com.obric.memorydata.plugin"));
    L12:
        List<KTypeProjection> r1 = r6.getArguments();
        if (r1.isEmpty() == false) goto L16;
    L14:
        r7 = ZeusTransformUtils.preCheckCast(r8, Type.class, "com.obric.memorydata.plugin");
        goto L6
    L16:
        if (r8.isArray() == false) goto L45;
        if (r8.getComponentType().isPrimitive() == true) goto L14;
        KTypeProjection r2 = (KTypeProjection) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(r1), KTypeProjection.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L43;
        KVariance r9 = r2.component1();
        KType r3 = r2.component2();
        if (r9 != null) goto L25;
        int r10 = -1;
    L26:
        if (r10 == (-1)) goto L41;
        if (r10 == 1) goto L41;
        if (r10 != 2) goto L32;
    L36:
        Intrinsics.checkNotNull(r3);
        Type r11 = computeJavaType$default(r3, false, 1, null);
        if (ZeusTransformUtils.instanceOf(r11, Class.class) == true) goto L41;
        r8 = new GenericArrayTypeImpl(r11);
        goto L41
    L32:
        if (r10 == 3) goto L36;
        throw new NoWhenBranchMatchedException();
    L41:
        return (Type) ZeusTransformUtils.preCheckCast(r8, Type.class, "com.obric.memorydata.plugin");
    L25:
        r10 = WhenMappings.$EnumSwitchMapping$0[r9.ordinal()];
        goto L26
    L43:
        throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + r6);
    L45:
        return createPossiblyInnerType(r8, r1);
    L11:
        r8 = JvmClassMappingKt.getJavaClass((KClass) ZeusTransformUtils.preCheckCast(r0, KClass.class, "com.obric.memorydata.plugin"));
        goto L12
    L47:
        throw new UnsupportedOperationException("Unsupported type classifier: " + r6);
    }

    static /* synthetic */ Type computeJavaType$default(KType r1, boolean r2, int r3, Object r4) {
        KType r5 = (KType) ZeusTransformUtils.wrapperContextForParams(r1, KType.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = false;
    L6:
        return computeJavaType(r5, r2);
    }

    private static final Type createPossiblyInnerType(Class<?> r5, List<KTypeProjection> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Class<?> r0 = r5.getDeclaringClass();
        if (r0 != null) goto L12;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        r2.add(getJavaType((KTypeProjection) ZeusTransformUtils.preCheckCast(r9.next(), KTypeProjection.class, "com.obric.memorydata.plugin")));
        goto L6
    L8:
        ParameterizedTypeImpl r3 = new ParameterizedTypeImpl(r5, null, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
    L10:
        return (Type) ZeusTransformUtils.preCheckCast(r3, Type.class, "com.obric.memorydata.plugin");
    L12:
        if (Modifier.isStatic(r5.getModifiers()) == false) goto L18;
        Type r1 = (Type) ZeusTransformUtils.preCheckCast(r0, Type.class, "com.obric.memorydata.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L17;
        r4.add(getJavaType((KTypeProjection) ZeusTransformUtils.preCheckCast(r11.next(), KTypeProjection.class, "com.obric.memorydata.plugin")));
        goto L15
    L17:
        r3 = new ParameterizedTypeImpl(r5, r1, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));
        goto L10
    L18:
        int r12 = r5.getTypeParameters().length;
        Type r13 = createPossiblyInnerType(r0, r7.subList(r12, r7.size()));
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r7.subList(0, r12), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L20:
        if (r16.hasNext() == false) goto L22;
        r15.add(getJavaType((KTypeProjection) ZeusTransformUtils.preCheckCast(r16.next(), KTypeProjection.class, "com.obric.memorydata.plugin")));
        goto L20
    L22:
        r3 = new ParameterizedTypeImpl(r5, r13, (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    public static final Type getJavaType(KType r3) {
        KType r4 = (KType) ZeusTransformUtils.wrapperContextForParams(r3, KType.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, KTypeBase.class) == false) goto L8;
        Type r0 = ((KTypeBase) ZeusTransformUtils.preCheckCast(r4, KTypeBase.class, "com.obric.memorydata.plugin")).getJavaType();
        if (r0 == null) goto L8;
        return r0;
    L8:
        return computeJavaType$default(r4, false, 1, null);
    }

    private static final Type getJavaType(KTypeProjection r5) {
        KVariance r0 = r5.getVariance();
        if (r0 == null) goto L5;
        KType r6 = r5.getType();
        Intrinsics.checkNotNull(r6);
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L9;
        WildcardTypeImpl r2 = new WildcardTypeImpl(null, computeJavaType(r6, true));
    L18:
        return (Type) ZeusTransformUtils.preCheckCast(r2, Type.class, "com.obric.memorydata.plugin");
    L9:
        if (r1 == 2) goto L19;
        if (r1 != 3) goto L14;
        r2 = new WildcardTypeImpl(computeJavaType(r6, true), null);
        goto L18
    L14:
        throw new NoWhenBranchMatchedException();
    L19:
        return computeJavaType(r6, true);
    L5:
        return (Type) ZeusTransformUtils.preCheckCast(WildcardTypeImpl.Companion.getSTAR(), Type.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void getJavaType$annotations(KType r2) {
        KType r3 = (KType) ZeusTransformUtils.wrapperContextForParams(r2, KType.class, "com.obric.memorydata.plugin");
    }

    private static /* synthetic */ void getJavaType$annotations(KTypeProjection r0) {
    }

    private static final String typeToString(Type r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L10;
        if (((Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.memorydata.plugin")).isArray() == false) goto L7;
        Sequence r6 = SequencesKt.generateSequence(r5, (Function1) ZeusTransformUtils.preCheckCast(TypesJVMKt$typeToString$unwrap$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        String r7 = ((Class) ZeusTransformUtils.preCheckCast(SequencesKt.last(r6), Class.class, "com.obric.memorydata.plugin")).getName() + StringsKt.repeat((CharSequence) ZeusTransformUtils.preCheckCast(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, CharSequence.class, "com.obric.memorydata.plugin"), SequencesKt.count(r6));
    L8:
        Intrinsics.checkNotNull(r7);
        return r7;
    L7:
        r7 = ((Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.memorydata.plugin")).getName();
        goto L8
    L10:
        return r5.toString();
    }
}
