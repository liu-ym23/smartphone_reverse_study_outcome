package kotlin.reflect.jvm.internal.impl.load.java;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = null;
    public static final BuiltinSpecialProperties INSTANCE = null;
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = null;
    private static final Set<FqName> SPECIAL_FQ_NAMES = null;
    private static final Set<Name> SPECIAL_SHORT_NAMES = null;

    static {
        INSTANCE = new BuiltinSpecialProperties();
        FqNameUnsafe r10 = StandardNames.FqNames._enum;
        FqName r11 = StandardNames.FqNames.map;
        Map<FqName, Name> r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(r10, ActivityLifecycle.NAME), Name.identifier(ActivityLifecycle.NAME)), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(r10, "ordinal"), Name.identifier("ordinal")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.collection, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r11, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r11, "keys"), Name.identifier("keySet")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r11, "values"), Name.identifier("values")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r11, "entries"), Name.identifier("entrySet"))});
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = r12;
        Set<Map.Entry<FqName, Name>> r13 = r12.entrySet();
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.add(new Pair(((FqName) r16.getKey()).shortName(), r16.getValue()));
        goto L4
    L6:
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r14.iterator();
    L8:
        if (r18.hasNext() == false) goto L13;
        Pair r19 = (Pair) r18.next();
        Name r20 = (Name) r19.getSecond();
        Object r21 = r17.get(r20);
        if (r21 != null) goto L12;
        r21 = new ArrayList();
        r17.put(r20, r21);
    L12:
        ((List) r21).add((Name) r19.getFirst());
        goto L8
    L13:
        LinkedHashMap r22 = new LinkedHashMap(MapsKt.mapCapacity(r17.size()));
        Iterator r23 = r17.entrySet().iterator();
    L15:
        if (r23.hasNext() == false) goto L17;
        Map.Entry r24 = (Map.Entry) r23.next();
        r22.put(r24.getKey(), CollectionsKt.distinct((Iterable) r24.getValue()));
        goto L15
    L17:
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = r22;
        Set<FqName> r25 = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = r25;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator<T> r27 = r25.iterator();
    L19:
        if (r27.hasNext() == false) goto L21;
        r26.add(((FqName) r27.next()).shortName());
        goto L19
    L21:
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet(r26);
    }

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name r10) {
        Intrinsics.checkNotNullParameter(r10, "name1");
        List<Name> r11 = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return CollectionsKt.emptyList();
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }
}
