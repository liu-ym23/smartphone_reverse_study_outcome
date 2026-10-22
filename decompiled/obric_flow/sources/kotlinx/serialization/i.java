package kotlinx.serialization;

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
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.f1;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.internal.i1;
import kotlinx.serialization.internal.o1;
import kotlinx.serialization.internal.p0;
import kotlinx.serialization.internal.z0;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class i {
    public static final c a(KClass r5, List r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "serializers");
        Intrinsics.checkNotNullParameter(r11, "elementClassifierIfArray");
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Collection.class)) == false) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L11;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L16;
        c r15 = new kotlinx.serialization.internal.d((c) r10.get(0), 0);
    L53:
        if (r15 != null) goto L56;
        c[] r16 = (c[]) r10.toArray(new c[0]);
        return z0.d(r5, (c[]) Arrays.copyOf(r16, r16.length));
    L56:
        return r15;
    L16:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(HashSet.class)) == false) goto L19;
        r15 = new kotlinx.serialization.internal.d((c) r10.get(0), 1);
        goto L53
    L19:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Set.class)) == false) goto L21;
        boolean r17 = true;
    L22:
        if (r17 == false) goto L24;
        boolean r18 = true;
    L25:
        if (r18 == false) goto L28;
        r15 = new kotlinx.serialization.internal.d((c) r10.get(0), 2);
        goto L53
    L28:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(HashMap.class)) == false) goto L31;
        r15 = new d0((c) r10.get(0), (c) r10.get(1), 0);
        goto L53
    L31:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Map.class)) == false) goto L33;
        boolean r19 = true;
    L34:
        if (r19 == false) goto L36;
        boolean r20 = true;
    L37:
        if (r20 == false) goto L40;
        r15 = new d0((c) r10.get(0), (c) r10.get(1), 1);
        goto L53
    L40:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Map.Entry.class)) == false) goto L44;
        c r21 = (c) r10.get(0);
        c r22 = (c) r10.get(1);
        Intrinsics.checkNotNullParameter(r21, "keySerializer");
        Intrinsics.checkNotNullParameter(r22, "valueSerializer");
        c r23 = new p0(r21, r22, 0);
    L42:
        r15 = r23;
        goto L53
    L44:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Pair.class)) == false) goto L47;
        c r24 = (c) r10.get(0);
        c r25 = (c) r10.get(1);
        Intrinsics.checkNotNullParameter(r24, "keySerializer");
        Intrinsics.checkNotNullParameter(r25, "valueSerializer");
        r23 = new p0(r24, r25, 1);
        goto L42
    L47:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Triple.class)) == false) goto L49;
        c r26 = (c) r10.get(0);
        c r27 = (c) r10.get(1);
        c r28 = (c) r10.get(2);
        Intrinsics.checkNotNullParameter(r26, "aSerializer");
        Intrinsics.checkNotNullParameter(r27, "bSerializer");
        Intrinsics.checkNotNullParameter(r28, "cSerializer");
        r15 = new o1(r26, r27, r28);
        goto L53
    L49:
        Intrinsics.checkNotNullParameter(r5, "rootClass");
        if (JvmClassMappingKt.getJavaClass(r5).isArray() == false) goto L52;
        Object r29 = r11.invoke();
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        KClass r30 = (KClass) r29;
        c r31 = (c) r10.get(0);
        Intrinsics.checkNotNullParameter(r30, "kClass");
        Intrinsics.checkNotNullParameter(r31, "elementSerializer");
        r23 = new g1(r30, r31);
        goto L42
    L52:
        r15 = null;
        goto L53
    L36:
        r20 = Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(LinkedHashMap.class));
        goto L37
    L33:
        r19 = Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Map.class));
        goto L34
    L24:
        r18 = Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(LinkedHashSet.class));
        goto L25
    L21:
        r17 = Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Set.class));
        goto L22
    L11:
        r14 = Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(ArrayList.class));
        goto L13
    L8:
        r13 = Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(List.class));
        goto L9
    L5:
        r12 = Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(List.class));
        goto L6
    }

    public static final c b(jk.a r10, KType r11, boolean r12) {
        KClass r5 = z0.g(r11);
        boolean r13 = r11.isMarkedNullable();
        List<KTypeProjection> r14 = r11.getArguments();
        final ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L11;
        KType r17 = ((KTypeProjection) r16.next()).getType();
        if (r17 == null) goto L9;
        r15.add(r17);
        goto L4
    L9:
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + r11).toString());
    L11:
        if (r15.isEmpty() == false) goto L19;
        i1 r18 = h.f19248a;
        Intrinsics.checkNotNullParameter(r5, "clazz");
        if (r13 == true) goto L18;
        c r19 = h.f19248a.b(r5);
        if (r19 != null) goto L27;
        r19 = null;
    L27:
        if (r19 == null) goto L30;
        return r19;
    L30:
        if (r15.isEmpty() == false) goto L36;
        List r20 = CollectionsKt.emptyList();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "kClass");
        Intrinsics.checkNotNullParameter(r20, "typeArgumentsSerializers");
        if (((Map) r10.f18349a).get(r5) != null) goto L35;
    L33:
        c r21 = null;
    L46:
        if (r21 == null) goto L53;
        if (r13 == true) goto L54;
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return r21;
    L54:
        return du.a.a(r21);
    L53:
        return null;
    L35:
        throw new ClassCastException();
    L36:
        ArrayList r22 = d(r10, r15, r12);
        if (r22 != null) goto L39;
        return null;
    L39:
        r21 = a(r5, r22, new SerializersKt__SerializersKt$serializerByKTypeImpl$contextualSerializer$1(r15));
        if (r21 != null) goto L46;
        Intrinsics.checkNotNullParameter(r5, "kClass");
        Intrinsics.checkNotNullParameter(r22, "typeArgumentsSerializers");
        if (((Map) r10.f18349a).get(r5) == null) goto L33;
        throw new ClassCastException();
    L18:
        r19 = h.f19249b.b(r5);
        goto L27
    L19:
        i1 r23 = h.f19248a;
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r15, "types");
        if (r13 == true) goto L22;
        Object r24 = h.f19250c.b(r5, r15);
    L24:
        if (Result.m130isFailureimpl(r24) == false) goto L26;
        r24 = null;
    L26:
        r19 = (c) r24;
        goto L27
    L22:
        r24 = h.d.b(r5, r15);
        goto L24
    }

    public static final c c(KClass r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        c r10 = z0.d(r5, new c[0]);
        if (r10 != null) goto L6;
        Map r11 = f1.f19281a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return (c) f1.f19281a.get(r5);
    L6:
        return r10;
    }

    public static final ArrayList d(jk.a r5, List r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeArguments");
        if (r11 == false) goto L15;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r10));
        Iterator r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L23;
        KType r14 = (KType) r13.next();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r14, "type");
        c r15 = b(r5, r14, true);
        if (r15 == null) goto L9;
        r12.add(r15);
        goto L6
    L9:
        KClass r16 = z0.g(r14);
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r16, "<this>");
        String r17 = r16.getSimpleName();
        if (r17 != null) goto L13;
        r17 = "<local class name not available>";
    L13:
        throw new SerializationException(androidx.constraintlayout.motion.widget.a.q(r17, "className", "Serializer for class '", r17, "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n"));
    L23:
        return r12;
    L15:
        r12 = new ArrayList(CollectionsKt.h(r10));
        Iterator r18 = r10.iterator();
    L17:
        if (r18.hasNext() == false) goto L23;
        KType r19 = (KType) r18.next();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r19, "type");
        c r20 = b(r5, r19, false);
        if (r20 == null) goto L20;
        r12.add(r20);
        goto L17
    L20:
        return null;
    }
}
