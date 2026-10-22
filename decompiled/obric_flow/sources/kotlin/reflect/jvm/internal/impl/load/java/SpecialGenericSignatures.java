package kotlin.reflect.jvm.internal.impl.load.java;

import ai.j0;
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
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSpecialGenericSignatures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialGenericSignatures.kt\norg/jetbrains/kotlin/load/java/SpecialGenericSignatures\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,146:1\n1549#2:147\n1620#2,3:148\n1549#2:151\n1620#2,3:152\n1549#2:155\n1620#2,3:156\n1238#2,4:162\n1549#2:166\n1620#2,3:167\n1549#2:170\n1620#2,3:171\n1238#2,4:177\n1549#2:181\n1620#2,3:182\n1549#2:185\n1620#2,3:186\n1208#2,2:189\n1238#2,4:191\n13#3:159\n13#3:174\n457#4:160\n403#4:161\n457#4:175\n403#4:176\n*S KotlinDebug\n*F\n+ 1 SpecialGenericSignatures.kt\norg/jetbrains/kotlin/load/java/SpecialGenericSignatures\n*L\n54#1:147\n54#1:148,3\n56#1:151\n56#1:152,3\n57#1:155\n57#1:156,3\n95#1:162,4\n101#1:166\n101#1:167,3\n102#1:170\n102#1:171,3\n126#1:177,4\n128#1:181\n128#1:182,3\n132#1:185\n132#1:186,3\n133#1:189,2\n133#1:191,4\n60#1:159\n111#1:174\n95#1:160\n95#1:161\n126#1:175\n126#1:176\n*E\n"})
public class SpecialGenericSignatures {
    public static final Companion Companion = null;
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES = null;
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = null;
    private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES = null;
    private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES = null;
    private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES = null;
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = null;
    private static final Map<Name, Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = null;
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = null;
    private static final List<Name> ORIGINAL_SHORT_NAMES = null;
    private static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE = null;
    private static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP = null;
    private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME = null;

    public static final class Companion {

        public static final class NameAndSignature {
            private final Name name;
            private final String signature;

            public NameAndSignature(Name r5, String r10) {
                Intrinsics.checkNotNullParameter(r5, "name");
                Intrinsics.checkNotNullParameter(r10, "signature");
                this.name = r5;
                this.signature = r10;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof NameAndSignature) == true) goto L8;
                return false;
            L8:
                NameAndSignature r10 = (NameAndSignature) r5;
                if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.signature, r10.signature) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final Name getName() {
                return this.name;
            }

            public final String getSignature() {
                return this.signature;
            }

            public int hashCode() {
                int r5 = this.name.hashCode() * 31;
                return this.signature.hashCode() + r5;
            }

            public String toString() {
                StringBuilder r5 = new StringBuilder("NameAndSignature(name=");
                r5.append(this.name);
                r5.append(", signature=");
                return j0.p(r5, this.signature, ')');
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ NameAndSignature access$method(Companion r5, String r10, String r11, String r12, String r13) {
            return r5.method(r10, r11, r12, r13);
        }

        private final NameAndSignature method(String r5, String r10, String r11, String r12) {
            return new NameAndSignature(Name.identifier(r10), SignatureBuildingComponents.INSTANCE.signature(r5, r10 + '(' + r11 + ')' + r12));
        }

        public final Name getBuiltinFunctionNamesByJvmName(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "name");
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(r5);
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp();
        }

        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp();
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp();
        }

        public final Map<Name, Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp();
        }

        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.access$getORIGINAL_SHORT_NAMES$cp();
        }

        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.access$getREMOVE_AT_NAME_AND_SIGNATURE$cp();
        }

        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp();
        }

        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp();
        }

        public final boolean getSameAsRenamedInJvmBuiltin(Name r5) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(r5);
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String r5) {
            Intrinsics.checkNotNullParameter(r5, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(r5) == false) goto L7;
            return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
        L7:
            if (((TypeSafeBarrierDescription) MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), r5)) != TypeSafeBarrierDescription.NULL) goto L10;
            return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
        L10:
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        private Companion() {
        }
    }

    public static final enum SpecialSignatureInfo extends Enum<SpecialSignatureInfo> {
        private static final /* synthetic */ SpecialSignatureInfo[] $VALUES = null;
        public static final SpecialSignatureInfo OBJECT_PARAMETER_GENERIC = null;
        public static final SpecialSignatureInfo OBJECT_PARAMETER_NON_GENERIC = null;
        public static final SpecialSignatureInfo ONE_COLLECTION_PARAMETER = null;
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        private static final /* synthetic */ SpecialSignatureInfo[] $values() {
            return new SpecialSignatureInfo[]{ONE_COLLECTION_PARAMETER, OBJECT_PARAMETER_NON_GENERIC, OBJECT_PARAMETER_GENERIC};
        }

        static {
            ONE_COLLECTION_PARAMETER = new SpecialSignatureInfo("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
            OBJECT_PARAMETER_NON_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
            OBJECT_PARAMETER_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
            $VALUES = $values();
        }

        private SpecialSignatureInfo(String r5, int r10, String r11, boolean r12) {
            super(r5, r10);
            this.valueParametersSignature = r11;
            this.isObjectReplacedWithTypeParameter = r12;
        }

        public static SpecialSignatureInfo valueOf(String r5) {
            return (SpecialSignatureInfo) Enum.valueOf(SpecialSignatureInfo.class, r5);
        }

        public static SpecialSignatureInfo[] values() {
            return (SpecialSignatureInfo[]) $VALUES.clone();
        }
    }

    public static final enum TypeSafeBarrierDescription extends Enum<TypeSafeBarrierDescription> {
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES = null;
        public static final TypeSafeBarrierDescription FALSE = null;
        public static final TypeSafeBarrierDescription INDEX = null;
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = null;
        public static final TypeSafeBarrierDescription NULL = null;
        private final Object defaultValue;

        public static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            public MAP_GET_OR_DEFAULT(String r5, int r10) {
                DefaultConstructorMarker r11 = null;
                super(r5, r10, r11, r11);
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        static {
            NULL = new TypeSafeBarrierDescription("NULL", 0, null);
            INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
            FALSE = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
            MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
            $VALUES = $values();
        }

        public /* synthetic */ TypeSafeBarrierDescription(String r5, int r10, Object r11, DefaultConstructorMarker r12) {
            this(r5, r10, r11);
        }

        public static TypeSafeBarrierDescription valueOf(String r5) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, r5);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }

        private TypeSafeBarrierDescription(String r5, int r10, Object r11) {
            super(r5, r10);
            this.defaultValue = r11;
        }
    }

    static {
        Companion = new Companion(null);
        Set r5 = SetsKt.setOf(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = (String) r11.next();
        r10.add(Companion.access$method(Companion, "java/util/Collection", r12, "Ljava/util/Collection;", JvmPrimitiveType.BOOLEAN.getDesc()));
        goto L4
    L6:
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = r10;
        ArrayList r13 = new ArrayList(CollectionsKt.h(r10));
        Iterator r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(((Companion.NameAndSignature) r14.next()).getSignature());
        goto L8
    L10:
        ERASED_COLLECTION_PARAMETER_SIGNATURES = r13;
        List<Companion.NameAndSignature> r15 = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        r16.add(((Companion.NameAndSignature) r17.next()).getName().asString());
        goto L12
    L14:
        ERASED_COLLECTION_PARAMETER_NAMES = r16;
        SignatureBuildingComponents r18 = SignatureBuildingComponents.INSTANCE;
        Companion r19 = Companion;
        String r20 = r18.javaUtil("Collection");
        JvmPrimitiveType r21 = JvmPrimitiveType.BOOLEAN;
        Companion.NameAndSignature r22 = Companion.access$method(r19, r20, "contains", "Ljava/lang/Object;", r21.getDesc());
        TypeSafeBarrierDescription r23 = TypeSafeBarrierDescription.FALSE;
        Pair r24 = TuplesKt.to(r22, r23);
        Pair r25 = TuplesKt.to(Companion.access$method(r19, r18.javaUtil("Collection"), "remove", "Ljava/lang/Object;", r21.getDesc()), r23);
        Pair r110 = TuplesKt.to(Companion.access$method(r19, r18.javaUtil("Map"), "containsKey", "Ljava/lang/Object;", r21.getDesc()), r23);
        Pair r111 = TuplesKt.to(Companion.access$method(r19, r18.javaUtil("Map"), "containsValue", "Ljava/lang/Object;", r21.getDesc()), r23);
        Pair r26 = TuplesKt.to(Companion.access$method(r19, r18.javaUtil("Map"), "remove", "Ljava/lang/Object;Ljava/lang/Object;", r21.getDesc()), r23);
        Pair r112 = TuplesKt.to(Companion.access$method(r19, r18.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT);
        Companion.NameAndSignature r27 = Companion.access$method(r19, r18.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription r113 = TypeSafeBarrierDescription.NULL;
        Pair r114 = TuplesKt.to(r27, r113);
        Pair r115 = TuplesKt.to(Companion.access$method(r19, r18.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), r113);
        String r28 = r18.javaUtil("List");
        JvmPrimitiveType r116 = JvmPrimitiveType.INT;
        Companion.NameAndSignature r29 = Companion.access$method(r19, r28, "indexOf", "Ljava/lang/Object;", r116.getDesc());
        TypeSafeBarrierDescription r30 = TypeSafeBarrierDescription.INDEX;
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> r31 = MapsKt.mapOf(new Pair[]{r24, r25, r110, r111, r26, r112, r114, r115, TuplesKt.to(r29, r30), TuplesKt.to(Companion.access$method(r19, r18.javaUtil("List"), "lastIndexOf", "Ljava/lang/Object;", r116.getDesc()), r30)});
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = r31;
        LinkedHashMap r32 = new LinkedHashMap(MapsKt.mapCapacity(r31.size()));
        Iterator<T> r33 = r31.entrySet().iterator();
    L16:
        if (r33.hasNext() == false) goto L18;
        Map.Entry r34 = (Map.Entry) r33.next();
        r32.put(((Companion.NameAndSignature) r34.getKey()).getSignature(), r34.getValue());
        goto L16
    L18:
        SIGNATURE_TO_DEFAULT_VALUES_MAP = r32;
        Set r35 = SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        ArrayList r36 = new ArrayList(CollectionsKt.h(r35));
        Iterator r37 = r35.iterator();
    L20:
        if (r37.hasNext() == false) goto L22;
        r36.add(((Companion.NameAndSignature) r37.next()).getName());
        goto L20
    L22:
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet(r36);
        ArrayList r38 = new ArrayList(CollectionsKt.h(r35));
        Iterator r39 = r35.iterator();
    L24:
        if (r39.hasNext() == false) goto L26;
        r38.add(((Companion.NameAndSignature) r39.next()).getSignature());
        goto L24
    L26:
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet(r38);
        Companion r40 = Companion;
        JvmPrimitiveType r41 = JvmPrimitiveType.INT;
        Companion.NameAndSignature r42 = Companion.access$method(r40, "java/util/List", "removeAt", r41.getDesc(), "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = r42;
        SignatureBuildingComponents r43 = SignatureBuildingComponents.INSTANCE;
        Map<Companion.NameAndSignature, Name> r44 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Companion.access$method(r40, r43.javaLang("Number"), "toByte", "", JvmPrimitiveType.BYTE.getDesc()), Name.identifier("byteValue")), TuplesKt.to(Companion.access$method(r40, r43.javaLang("Number"), "toShort", "", JvmPrimitiveType.SHORT.getDesc()), Name.identifier("shortValue")), TuplesKt.to(Companion.access$method(r40, r43.javaLang("Number"), "toInt", "", r41.getDesc()), Name.identifier("intValue")), TuplesKt.to(Companion.access$method(r40, r43.javaLang("Number"), "toLong", "", JvmPrimitiveType.LONG.getDesc()), Name.identifier("longValue")), TuplesKt.to(Companion.access$method(r40, r43.javaLang("Number"), "toFloat", "", JvmPrimitiveType.FLOAT.getDesc()), Name.identifier("floatValue")), TuplesKt.to(Companion.access$method(r40, r43.javaLang("Number"), "toDouble", "", JvmPrimitiveType.DOUBLE.getDesc()), Name.identifier("doubleValue")), TuplesKt.to(r42, Name.identifier("remove")), TuplesKt.to(Companion.access$method(r40, r43.javaLang("CharSequence"), "get", r41.getDesc(), JvmPrimitiveType.CHAR.getDesc()), Name.identifier("charAt"))});
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = r44;
        LinkedHashMap r45 = new LinkedHashMap(MapsKt.mapCapacity(r44.size()));
        Iterator<T> r46 = r44.entrySet().iterator();
    L28:
        if (r46.hasNext() == false) goto L30;
        Map.Entry r47 = (Map.Entry) r46.next();
        r45.put(((Companion.NameAndSignature) r47.getKey()).getSignature(), r47.getValue());
        goto L28
    L30:
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = r45;
        Set<Companion.NameAndSignature> r48 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        ArrayList r49 = new ArrayList(CollectionsKt.h(r48));
        Iterator<T> r50 = r48.iterator();
    L32:
        if (r50.hasNext() == false) goto L34;
        r49.add(((Companion.NameAndSignature) r50.next()).getName());
        goto L32
    L34:
        ORIGINAL_SHORT_NAMES = r49;
        Set<Map.Entry<Companion.NameAndSignature, Name>> r51 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        ArrayList r52 = new ArrayList(CollectionsKt.h(r51));
        Iterator<T> r53 = r51.iterator();
    L36:
        if (r53.hasNext() == false) goto L38;
        Map.Entry r54 = (Map.Entry) r53.next();
        r52.add(new Pair(((Companion.NameAndSignature) r54.getKey()).getName(), r54.getValue()));
        goto L36
    L38:
        LinkedHashMap r55 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.h(r52)), 16));
        Iterator r56 = r52.iterator();
    L40:
        if (r56.hasNext() == false) goto L42;
        Pair r57 = (Pair) r56.next();
        r55.put((Name) r57.getSecond(), (Name) r57.getFirst());
        goto L40
    L42:
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = r55;
    }

    public SpecialGenericSignatures() {
    }

    public static final /* synthetic */ List access$getERASED_COLLECTION_PARAMETER_SIGNATURES$cp() {
        return ERASED_COLLECTION_PARAMETER_SIGNATURES;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SHORT_NAMES$cp() {
        return ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    }

    public static final /* synthetic */ Set access$getERASED_VALUE_PARAMETERS_SIGNATURES$cp() {
        return ERASED_VALUE_PARAMETERS_SIGNATURES;
    }

    public static final /* synthetic */ Map access$getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP$cp() {
        return JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    }

    public static final /* synthetic */ List access$getORIGINAL_SHORT_NAMES$cp() {
        return ORIGINAL_SHORT_NAMES;
    }

    public static final /* synthetic */ Companion.NameAndSignature access$getREMOVE_AT_NAME_AND_SIGNATURE$cp() {
        return REMOVE_AT_NAME_AND_SIGNATURE;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_DEFAULT_VALUES_MAP$cp() {
        return SIGNATURE_TO_DEFAULT_VALUES_MAP;
    }

    public static final /* synthetic */ Map access$getSIGNATURE_TO_JVM_REPRESENTATION_NAME$cp() {
        return SIGNATURE_TO_JVM_REPRESENTATION_NAME;
    }
}
