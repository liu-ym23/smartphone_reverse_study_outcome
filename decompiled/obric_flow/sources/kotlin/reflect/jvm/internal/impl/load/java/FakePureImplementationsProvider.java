package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nFakePureImplementationsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FakePureImplementationsProvider.kt\norg/jetbrains/kotlin/load/java/FakePureImplementationsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,38:1\n1285#2,4:39\n11335#3:43\n11670#3,3:44\n125#4:47\n152#4,3:48\n*S KotlinDebug\n*F\n+ 1 FakePureImplementationsProvider.kt\norg/jetbrains/kotlin/load/java/FakePureImplementationsProvider\n*L\n18#1:39,4\n36#1:43\n36#1:44,3\n32#1:47\n32#1:48,3\n*E\n"})
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE = null;
    private static final Map<ClassId, ClassId> pureImplementationsClassIds = null;
    private static final Map<FqName, FqName> pureImplementationsFqNames = null;

    static {
        FakePureImplementationsProvider r5 = new FakePureImplementationsProvider();
        INSTANCE = r5;
        LinkedHashMap r10 = new LinkedHashMap();
        pureImplementationsClassIds = r10;
        StandardClassIds r11 = StandardClassIds.INSTANCE;
        r5.implementedWith(r11.getMutableList(), r5.fqNameListOf(new String[]{"java.util.ArrayList", "java.util.LinkedList"}));
        r5.implementedWith(r11.getMutableSet(), r5.fqNameListOf(new String[]{"java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"}));
        r5.implementedWith(r11.getMutableMap(), r5.fqNameListOf(new String[]{"java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"}));
        r5.implementedWith(ClassId.topLevel(new FqName("java.util.function.Function")), r5.fqNameListOf(new String[]{"java.util.function.UnaryOperator"}));
        r5.implementedWith(ClassId.topLevel(new FqName("java.util.function.BiFunction")), r5.fqNameListOf(new String[]{"java.util.function.BinaryOperator"}));
        ArrayList r12 = new ArrayList(r10.size());
        Iterator r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Map.Entry r14 = (Map.Entry) r13.next();
        ClassId r15 = (ClassId) r14.getKey();
        ClassId r16 = (ClassId) r14.getValue();
        r12.add(TuplesKt.to(r15.asSingleFqName(), r16.asSingleFqName()));
        goto L4
    L6:
        pureImplementationsFqNames = MapsKt.toMap(r12);
    }

    private FakePureImplementationsProvider() {
    }

    private final List<ClassId> fqNameListOf(String... r5) {
        ArrayList r10 = new ArrayList(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(ClassId.topLevel(new FqName(r5[r12])));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    private final void implementedWith(ClassId r5, List<ClassId> r10) {
        Map<ClassId, ClassId> r11 = pureImplementationsClassIds;
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Object r13 = r12.next();
        ClassId r14 = (ClassId) r13;
        r11.put((ClassId) r13, r5);
        goto L4
    }

    public final FqName getPurelyImplementedInterface(FqName r5) {
        Intrinsics.checkNotNullParameter(r5, "classFqName");
        return pureImplementationsFqNames.get(r5);
    }
}
