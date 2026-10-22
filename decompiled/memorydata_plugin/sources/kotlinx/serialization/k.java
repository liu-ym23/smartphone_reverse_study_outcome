package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.internal.aj;
import kotlinx.serialization.internal.al;
import kotlinx.serialization.internal.au;
import kotlinx.serialization.internal.aw;
import kotlinx.serialization.internal.bl;
import kotlinx.serialization.internal.bm;
import kotlinx.serialization.internal.bu;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0014\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a \u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0001\u001a7\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\tH\u0001¢\u0006\u0002\u0010\n\u001a\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0006\b\u0000\u0010\f\u0018\u0001H\u0086\b\u001a\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00012\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f\u001aE\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00010\u0013H\u0002¢\u0006\u0002\b\u0015\u001a7\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00010\u0013H\u0002¢\u0006\u0002\b\u0017\u001a1\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\f0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\b\u001b\u001a@\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\r\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00010\u0013H\u0000\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u0007H\u0007\u001a\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0006\b\u0000\u0010\f\u0018\u0001*\u00020\u0005H\u0086\b\u001a\u001a\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f\u001a+\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002¢\u0006\u0002\b \u001a$\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u0001\"\b\b\u0000\u0010\f*\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u0007H\u0007\u001a\u001c\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f\u001a2\u0010!\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\u0018\u00010\u0013*\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u001f\u001a\u00020\u001aH\u0000¨\u0006\""}, d2 = {"noCompiledSerializer", "Lkotlinx/serialization/KSerializer;", "forClass", "", "module", "Lkotlinx/serialization/modules/SerializersModule;", "kClass", "Lkotlin/reflect/KClass;", "argSerializers", "", "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "serializer", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KType;", "serializerOrNull", "builtinParametrizedSerializer", "typeArguments", "", "serializers", "builtinParametrizedSerializer$SerializersKt__SerializersKt", "compiledParametrizedSerializer", "compiledParametrizedSerializer$SerializersKt__SerializersKt", "nullable", "shouldBeNullable", "", "nullable$SerializersKt__SerializersKt", "parametrizedSerializerOrNull", "types", "serializerByKTypeImpl", "failOnMissingTypeArgSerializer", "serializerByKTypeImpl$SerializersKt__SerializersKt", "serializersForParameters", "kotlinx-serialization-core"}, k = 5, mv = {1, 7, 1}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
final /* synthetic */ class k {
    public static final List<c<Object>> a(kotlinx.serialization.modules.d r3, List<? extends KType> r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r6, "typeArguments");
        if (r5 == false) goto L8;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L6:
        if (r9.hasNext() == false) goto L17;
        r8.add(j.a(r3, (KType) ZeusTransformUtils.preCheckCast(r9.next(), KType.class, "com.obric.memorydata.plugin")));
    L17:
        return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    L8:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        c<Object> r0 = j.b(r3, (KType) ZeusTransformUtils.preCheckCast(r11.next(), KType.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L13;
        r8.add(r0);
        goto L10
    L13:
        return null;
    }

    public static final <T> c<T> a(KClass<T> r2) {
        KClass r3 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        c<T> r0 = bl.a(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return bu.a(r3);
    }

    private static final c<? extends Object> a(KClass<Object> r2, List<? extends c<Object>> r3) {
        KClass r4 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        Object[] r5 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new c[0]);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        c[] r6 = (c[]) ZeusTransformUtils.preCheckCast(r5, c[].class, "com.obric.memorydata.plugin");
        return bl.a(r4, (c[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r6, r6.length), c[].class, "com.obric.memorydata.plugin"));
    }

    public static final c<? extends Object> a(KClass<Object> r2, List<? extends KType> r3, List<? extends c<Object>> r4) {
        KClass r5 = (KClass) ZeusTransformUtils.wrapperContextForParams(r2, KClass.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "types");
        Intrinsics.checkNotNullParameter(r7, "serializers");
        c<? extends Object> r8 = b(r5, r6, r7);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return a(r5, r7);
    }

    private static final <T> c<T> a(c<T> r2, boolean r3) {
        c<T> r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        if (r3 == true) goto L5;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return r4;
    L5:
        return kotlinx.serialization.a.a.a(r4);
    }

    public static final c<Object> a(kotlinx.serialization.modules.d r2, KType r3) {
        KType r4 = (KType) ZeusTransformUtils.wrapperContextForParams(r3, KType.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "type");
        c<Object> r5 = a(r2, r4, true);
        if (r5 == null) goto L5;
        return r5;
    L5:
        bl.b(bm.a(r4));
        throw new KotlinNothingValueException();
    }

    private static final c<Object> a(kotlinx.serialization.modules.d r7, KType r8, boolean r9) {
        KType r10 = (KType) ZeusTransformUtils.wrapperContextForParams(r8, KType.class, "com.obric.memorydata.plugin");
        KClass<Object> r0 = bm.a(r10);
        boolean r2 = r10.isMarkedNullable();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r10.getArguments(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        KType r6 = ((KTypeProjection) ZeusTransformUtils.preCheckCast(r5.next(), KTypeProjection.class, "com.obric.memorydata.plugin")).getType();
        if (r6 == null) goto L9;
        r4.add(r6);
        goto L4
    L9:
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + r10).toString());
    L10:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == false) goto L13;
        c<Object> r1 = i.a(r0, r2);
    L21:
        if (r1 == null) goto L24;
        return r1;
    L24:
        if (r11.isEmpty() == false) goto L26;
        c<? extends Object> r12 = kotlinx.serialization.modules.d.a(r7, r0, null, 2, null);
    L33:
        if (r12 != null) goto L35;
        return null;
    L35:
        return a(r12, r2);
    L26:
        List<c<Object>> r13 = j.a(r7, r11, r9);
        if (r13 != null) goto L29;
        return null;
    L29:
        c<? extends Object> r14 = j.a(r0, r11, r13);
        if (r14 != null) goto L32;
        r12 = r7.a(r0, r13);
        goto L33
    L32:
        r12 = r14;
        goto L33
    L13:
        Object r15 = i.a(r0, r11, r2);
        if (r9 == false) goto L19;
        if (Result.m1427isFailureimpl(r15) == false) goto L20;
        r15 = null;
    L20:
        r1 = (c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin");
        goto L21
    L19:
        if (Result.m1424exceptionOrNullimpl(r15) == null) goto L20;
        return null;
    }

    private static final c<? extends Object> b(KClass<Object> r4, List<? extends KType> r5, List<? extends c<Object>> r6) {
        KClass r7 = (KClass) ZeusTransformUtils.wrapperContextForParams(r4, KClass.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Collection.class)) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L17;
        Object r10 = new kotlinx.serialization.internal.f((c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"));
    L53:
        return (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin");
    L17:
        if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(HashSet.class)) == false) goto L20;
        r10 = new al((c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"));
        goto L53
    L20:
        if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Set.class)) == false) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == false) goto L25;
        boolean r11 = true;
    L26:
        if (r11 == false) goto L29;
        r10 = new aw((c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"));
        goto L53
    L29:
        if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(HashMap.class)) == false) goto L32;
        r10 = new aj((c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r9.get(1), c.class, "com.obric.memorydata.plugin"));
        goto L53
    L32:
        if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Map.class)) == false) goto L34;
        boolean r12 = true;
    L35:
        if (r12 == false) goto L37;
        boolean r13 = true;
    L38:
        if (r13 == false) goto L41;
        r10 = new au((c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r9.get(1), c.class, "com.obric.memorydata.plugin"));
        goto L53
    L41:
        if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Map.Entry.class)) == false) goto L44;
        return kotlinx.serialization.a.a.b((c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r9.get(1), c.class, "com.obric.memorydata.plugin"));
    L44:
        if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Pair.class)) == false) goto L47;
        return kotlinx.serialization.a.a.a((c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r9.get(1), c.class, "com.obric.memorydata.plugin"));
    L47:
        if (Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Triple.class)) == false) goto L50;
        return kotlinx.serialization.a.a.a((c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r9.get(1), c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r9.get(2), c.class, "com.obric.memorydata.plugin"));
    L50:
        if (bl.c(r7) == false) goto L52;
        KClassifier r14 = ((KType) ZeusTransformUtils.preCheckCast(r8.get(0), KType.class, "com.obric.memorydata.plugin")).getClassifier();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        return kotlinx.serialization.a.a.a((KClass) ZeusTransformUtils.preCheckCast(r14, KClass.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r9.get(0), c.class, "com.obric.memorydata.plugin"));
    L52:
        r10 = null;
        goto L53
    L37:
        r13 = Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(LinkedHashMap.class));
        goto L38
    L34:
        r12 = Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Map.class));
        goto L35
    L25:
        r11 = Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(LinkedHashSet.class));
        goto L26
    L22:
        r3 = Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(Set.class));
        goto L23
    L11:
        r2 = Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(ArrayList.class));
        goto L13
    L8:
        r1 = Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(List.class));
        goto L9
    L5:
        r0 = Intrinsics.areEqual(r7, Reflection.getOrCreateKotlinClass(List.class));
        goto L6
    }

    public static final c<Object> b(kotlinx.serialization.modules.d r2, KType r3) {
        KType r4 = (KType) ZeusTransformUtils.wrapperContextForParams(r3, KType.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "type");
        return a(r2, r4, false);
    }
}
