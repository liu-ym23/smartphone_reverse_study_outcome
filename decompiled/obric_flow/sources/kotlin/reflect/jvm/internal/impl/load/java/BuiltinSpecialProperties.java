package kotlin.reflect.jvm.internal.impl.load.java;

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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBuiltinSpecialProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/BuiltinSpecialProperties\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,42:1\n1549#2:43\n1620#2,3:44\n1490#2:47\n1520#2,3:48\n1523#2,3:58\n1238#2,4:63\n1549#2:67\n1620#2,3:68\n361#3,7:51\n442#3:61\n392#3:62\n*S KotlinDebug\n*F\n+ 1 BuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/BuiltinSpecialProperties\n*L\n27#1:43\n27#1:44,3\n28#1:47\n28#1:48,3\n28#1:58,3\n29#1:63,4\n34#1:67\n34#1:68,3\n28#1:51,7\n29#1:61\n29#1:62\n*E\n"})
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = null;
    public static final BuiltinSpecialProperties INSTANCE = null;
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = null;
    private static final Set<FqName> SPECIAL_FQ_NAMES = null;
    private static final Set<Name> SPECIAL_SHORT_NAMES = null;

    static {
        INSTANCE = new BuiltinSpecialProperties();
        FqNameUnsafe r5 = StandardNames.FqNames._enum;
        Pair r10 = TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(r5, "name"), Name.identifier("name"));
        Pair r11 = TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(r5, "ordinal"), Name.identifier("ordinal"));
        Pair r12 = TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(StandardNames.FqNames.collection, "size"), Name.identifier("size"));
        FqName r13 = StandardNames.FqNames.map;
        Map<FqName, Name> r14 = MapsKt.mapOf(new Pair[]{r10, r11, r12, TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r13, "size"), Name.identifier("size")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$childSafe(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r13, "keys"), Name.identifier("keySet")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r13, "values"), Name.identifier("values")), TuplesKt.to(BuiltinSpecialPropertiesKt.access$child(r13, "entries"), Name.identifier("entrySet"))});
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = r14;
        Set<Map.Entry<FqName, Name>> r15 = r14.entrySet();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        Map.Entry r18 = (Map.Entry) r17.next();
        r16.add(new Pair(((FqName) r18.getKey()).shortName(), r18.getValue()));
        goto L4
    L6:
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r16.iterator();
    L8:
        if (r20.hasNext() == false) goto L13;
        Pair r21 = (Pair) r20.next();
        Name r22 = (Name) r21.getSecond();
        Object r23 = r19.get(r22);
        if (r23 != null) goto L12;
        r23 = new ArrayList();
        r19.put(r22, r23);
    L12:
        ((List) r23).add((Name) r21.getFirst());
        goto L8
    L13:
        LinkedHashMap r24 = new LinkedHashMap(MapsKt.mapCapacity(r19.size()));
        Iterator r25 = r19.entrySet().iterator();
    L15:
        if (r25.hasNext() == false) goto L17;
        Map.Entry r26 = (Map.Entry) r25.next();
        r24.put(r26.getKey(), CollectionsKt.distinct((Iterable) r26.getValue()));
        goto L15
    L17:
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = r24;
        Set<FqName> r27 = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = r27;
        Set<FqName> r28 = r27;
        ArrayList r29 = new ArrayList(CollectionsKt.h(r28));
        Iterator<T> r30 = r28.iterator();
    L19:
        if (r30.hasNext() == false) goto L21;
        r29.add(((FqName) r30.next()).shortName());
        goto L19
    L21:
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet(r29);
    }

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name r5) {
        Intrinsics.checkNotNullParameter(r5, "name1");
        List<Name> r10 = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(r5);
        if (r10 == null) goto L5;
        return r10;
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
