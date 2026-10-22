package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

/* JADX INFO: loaded from: classes3.dex */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE = null;
    private static final Map<ClassId, ClassId> pureImplementationsClassIds = null;
    private static final Map<FqName, FqName> pureImplementationsFqNames = null;

    static {
        FakePureImplementationsProvider r10 = new FakePureImplementationsProvider();
        INSTANCE = r10;
        LinkedHashMap r11 = new LinkedHashMap();
        pureImplementationsClassIds = r11;
        StandardClassIds r12 = StandardClassIds.INSTANCE;
        r10.implementedWith(r12.getMutableList(), r10.fqNameListOf(new String[]{"java.util.ArrayList", "java.util.LinkedList"}));
        r10.implementedWith(r12.getMutableSet(), r10.fqNameListOf(new String[]{"java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"}));
        r10.implementedWith(r12.getMutableMap(), r10.fqNameListOf(new String[]{"java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"}));
        ClassId r13 = ClassId.topLevel(new FqName("java.util.function.Function"));
        Intrinsics.checkNotNullExpressionValue(r13, "topLevel(FqName(\"java.util.function.Function\"))");
        r10.implementedWith(r13, r10.fqNameListOf(new String[]{"java.util.function.UnaryOperator"}));
        ClassId r14 = ClassId.topLevel(new FqName("java.util.function.BiFunction"));
        Intrinsics.checkNotNullExpressionValue(r14, "topLevel(FqName(\"java.util.function.BiFunction\"))");
        r10.implementedWith(r14, r10.fqNameListOf(new String[]{"java.util.function.BinaryOperator"}));
        ArrayList r15 = new ArrayList(r11.size());
        Iterator r16 = r11.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        Map.Entry r17 = (Map.Entry) r16.next();
        ClassId r18 = (ClassId) r17.getKey();
        ClassId r19 = (ClassId) r17.getValue();
        r15.add(TuplesKt.to(r18.asSingleFqName(), r19.asSingleFqName()));
        goto L4
    L6:
        pureImplementationsFqNames = MapsKt.toMap(r15);
    }

    private FakePureImplementationsProvider() {
    }

    private final List<ClassId> fqNameListOf(String... r10) {
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(ClassId.topLevel(new FqName(r10[r13])));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    private final void implementedWith(ClassId r10, List<ClassId> r11) {
        Map<ClassId, ClassId> r12 = pureImplementationsClassIds;
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Object r14 = r13.next();
        ClassId r15 = (ClassId) r14;
        r12.put((ClassId) r14, r10);
        goto L4
    }

    public final FqName getPurelyImplementedInterface(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "classFqName");
        return pureImplementationsFqNames.get(r10);
    }
}
