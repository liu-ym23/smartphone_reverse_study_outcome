package juc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
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
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.modules.i;
import kuc.a;
import nuc.a1;
import nuc.a2;
import nuc.c1;
import nuc.f;
import nuc.i1;
import nuc.n2;
import nuc.o0;
import nuc.q0;
import nuc.w1;
import nuc.z1;
import nuc.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v {
    public static final d<Object> c(KType r1) {
        Intrinsics.checkNotNullParameter(r1, EffectConfiguration.KEY_TYPE);
        return d(i.a, r1);
    }

    @InternalSerializationApi
    public static final <T> d<T> e(KClass<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        d<T> r1 = z1.a(r2, new d[0]);
        if (r1 != null) goto L6;
        Map<KClass<? extends Object>, d<? extends Object>> r3 = n2.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (d) n2.a.get(r2);
    L6:
        return r1;
    }

    public static final d<?> a(kotlinx.serialization.modules.d r1, KClass<?> r2) {
        Intrinsics.checkNotNullParameter(r1, "module");
        Intrinsics.checkNotNullParameter(r2, "kClass");
        d<?> r3 = kotlinx.serialization.modules.d.c(r1, r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        a2.d(r2);
        throw null;
    }

    public static final d<Object> d(kotlinx.serialization.modules.d r2, KType r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, EffectConfiguration.KEY_TYPE);
        d<Object> r4 = x.a(r2, r3, true);
        if (r4 == null) goto L5;
        return r4;
    L5:
        KClass<Object> r5 = a2.c(r3);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        a2.d(r5);
        throw null;
    }

    public static final d<? extends Object> b(KClass<Object> r5, List<? extends d<Object>> r6, Function0<? extends KClassifier> r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "serializers");
        Intrinsics.checkNotNullParameter(r7, "elementClassifierIfArray");
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Collection.class)) == false) goto L5;
    L47:
        q0 r8 = new f((d) ListProtector.get(r6, 0));
    L48:
        if (r8 != null) goto L51;
        d[] r9 = (d[]) r6.toArray(new d[0]);
        return z1.a(r5, (d[]) Arrays.copyOf(r9, r9.length));
    L51:
        return r8;
    L5:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(List.class)) == true) goto L47;
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(List.class)) == true) goto L47;
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(ArrayList.class)) == true) goto L47;
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(HashSet.class)) == false) goto L15;
        r8 = new q0((d) ListProtector.get(r6, 0));
        goto L48
    L15:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Set.class)) == false) goto L17;
    L46:
        r8 = new c1((d) ListProtector.get(r6, 0));
        goto L48
    L17:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Set.class)) == true) goto L46;
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(LinkedHashSet.class)) == true) goto L46;
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(HashMap.class)) == false) goto L25;
        r8 = new o0((d) ListProtector.get(r6, 0), (d) ListProtector.get(r6, 1));
        goto L48
    L25:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Map.class)) == false) goto L27;
    L45:
        r8 = new a1((d) ListProtector.get(r6, 0), (d) ListProtector.get(r6, 1));
        goto L48
    L27:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Map.class)) == true) goto L45;
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(LinkedHashMap.class)) == true) goto L45;
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Map.Entry.class)) == false) goto L36;
        d r10 = (d) ListProtector.get(r6, 0);
        d r0 = (d) ListProtector.get(r6, 1);
        Intrinsics.checkNotNullParameter(r10, "keySerializer");
        Intrinsics.checkNotNullParameter(r0, "valueSerializer");
        q0 r2 = new i1(r10, r0);
    L34:
        r8 = r2;
        goto L48
    L36:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Pair.class)) == false) goto L39;
        d r11 = (d) ListProtector.get(r6, 0);
        d r1 = (d) ListProtector.get(r6, 1);
        Intrinsics.checkNotNullParameter(r11, "keySerializer");
        Intrinsics.checkNotNullParameter(r1, "valueSerializer");
        r2 = new w1(r11, r1);
        goto L34
    L39:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(Triple.class)) == false) goto L41;
        d r12 = (d) ListProtector.get(r6, 0);
        d r3 = (d) ListProtector.get(r6, 1);
        d r4 = (d) ListProtector.get(r6, 2);
        Intrinsics.checkNotNullParameter(r12, "aSerializer");
        Intrinsics.checkNotNullParameter(r3, "bSerializer");
        Intrinsics.checkNotNullParameter(r4, "cSerializer");
        r8 = new z2(r12, r3, r4);
        goto L48
    L41:
        Intrinsics.checkNotNullParameter(r5, "rootClass");
        if (JvmClassMappingKt.getJavaClass(r5).isArray() == false) goto L44;
        Object r13 = r7.invoke();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        r8 = a.a((KClass) r13, (d) ListProtector.get(r6, 0));
        goto L48
    L44:
        r8 = null;
        goto L48
    }

    public static final List<d<Object>> f(kotlinx.serialization.modules.d r3, List<? extends KType> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "typeArguments");
        if (r5 == false) goto L8;
        List<? extends KType> r6 = r4;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        r7.add(d(r3, (KType) r8.next()));
    L16:
        return r7;
    L8:
        List<? extends KType> r9 = r4;
        r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L16;
        KType r1 = (KType) r10.next();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r1, EffectConfiguration.KEY_TYPE);
        d r2 = x.a(r3, r1, false);
        if (r2 == null) goto L13;
        r7.add(r2);
        goto L10
    L13:
        return null;
    }
}
