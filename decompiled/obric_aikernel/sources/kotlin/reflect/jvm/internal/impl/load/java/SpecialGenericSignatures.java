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
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
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

            public NameAndSignature(Name r10, String r11) {
                Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
                Intrinsics.checkNotNullParameter(r11, "signature");
                this.name = r10;
                this.signature = r11;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof NameAndSignature) == true) goto L8;
                return false;
            L8:
                NameAndSignature r11 = (NameAndSignature) r10;
                if (Intrinsics.areEqual(this.name, r11.name) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.signature, r11.signature) == true) goto L14;
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
                return (this.name.hashCode() * 31) + this.signature.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + ')';
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ NameAndSignature access$method(Companion r10, String r11, String r12, String r13, String r14) {
            return r10.method(r11, r12, r13, r14);
        }

        private final NameAndSignature method(String r10, String r11, String r12, String r13) {
            Name r14 = Name.identifier(r11);
            Intrinsics.checkNotNullExpressionValue(r14, "identifier(name)");
            return new NameAndSignature(r14, SignatureBuildingComponents.INSTANCE.signature(r10, r11 + '(' + r12 + ')' + r13));
        }

        public final Name getBuiltinFunctionNamesByJvmName(Name r10) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(r10);
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

        public final boolean getSameAsRenamedInJvmBuiltin(Name r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(r10);
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String r10) {
            Intrinsics.checkNotNullParameter(r10, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(r10) == false) goto L7;
            return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
        L7:
            if (((TypeSafeBarrierDescription) MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), r10)) != TypeSafeBarrierDescription.NULL) goto L10;
            return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
        L10:
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
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

        private SpecialSignatureInfo(String r10, int r11, String r12, boolean r13) {
            super(r10, r11);
            this.valueParametersSignature = r12;
            this.isObjectReplacedWithTypeParameter = r13;
        }

        public static SpecialSignatureInfo valueOf(String r10) {
            return (SpecialSignatureInfo) Enum.valueOf(SpecialSignatureInfo.class, r10);
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

        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String r10, int r11) {
                DefaultConstructorMarker r12 = null;
                super(r10, r11, r12, r12);
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

        private TypeSafeBarrierDescription(String r10, int r11, Object r12) {
            super(r10, r11);
            this.defaultValue = r12;
        }

        public /* synthetic */ TypeSafeBarrierDescription(String r10, int r11, Object r12, DefaultConstructorMarker r13) {
            this(r10, r11, r12);
        }

        public static TypeSafeBarrierDescription valueOf(String r10) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, r10);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }
    }

    static {
        Companion = new Companion(null);
        Set r10 = SetsKt.setOf(new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = (String) r12.next();
        Companion r14 = Companion;
        String r15 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(r15, "BOOLEAN.desc");
        r11.add(Companion.access$method(r14, "java/util/Collection", r13, "Ljava/util/Collection;", r15));
        goto L4
    L6:
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = r11;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r17 = r11.iterator();
    L8:
        if (r17.hasNext() == false) goto L10;
        r16.add(((Companion.NameAndSignature) r17.next()).getSignature());
        goto L8
    L10:
        ERASED_COLLECTION_PARAMETER_SIGNATURES = r16;
        List<Companion.NameAndSignature> r18 = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L12:
        if (r20.hasNext() == false) goto L14;
        r19.add(((Companion.NameAndSignature) r20.next()).getName().asString());
        goto L12
    L14:
        ERASED_COLLECTION_PARAMETER_NAMES = r19;
        SignatureBuildingComponents r21 = SignatureBuildingComponents.INSTANCE;
        Companion r22 = Companion;
        String r23 = r21.javaUtil("Collection");
        JvmPrimitiveType r24 = JvmPrimitiveType.BOOLEAN;
        String r25 = r24.getDesc();
        Intrinsics.checkNotNullExpressionValue(r25, "BOOLEAN.desc");
        Companion.NameAndSignature r26 = Companion.access$method(r22, r23, "contains", "Ljava/lang/Object;", r25);
        TypeSafeBarrierDescription r27 = TypeSafeBarrierDescription.FALSE;
        String r28 = r21.javaUtil("Collection");
        String r29 = r24.getDesc();
        Intrinsics.checkNotNullExpressionValue(r29, "BOOLEAN.desc");
        String r110 = r21.javaUtil("Map");
        String r111 = r24.getDesc();
        Intrinsics.checkNotNullExpressionValue(r111, "BOOLEAN.desc");
        String r112 = r21.javaUtil("Map");
        String r113 = r24.getDesc();
        Intrinsics.checkNotNullExpressionValue(r113, "BOOLEAN.desc");
        String r114 = r21.javaUtil("Map");
        String r30 = r24.getDesc();
        Intrinsics.checkNotNullExpressionValue(r30, "BOOLEAN.desc");
        Companion.NameAndSignature r31 = Companion.access$method(r22, r21.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription r115 = TypeSafeBarrierDescription.NULL;
        String r116 = r21.javaUtil("List");
        JvmPrimitiveType r117 = JvmPrimitiveType.INT;
        String r32 = r117.getDesc();
        Intrinsics.checkNotNullExpressionValue(r32, "INT.desc");
        Companion.NameAndSignature r33 = Companion.access$method(r22, r116, "indexOf", "Ljava/lang/Object;", r32);
        TypeSafeBarrierDescription r34 = TypeSafeBarrierDescription.INDEX;
        String r35 = r21.javaUtil("List");
        String r36 = r117.getDesc();
        Intrinsics.checkNotNullExpressionValue(r36, "INT.desc");
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> r37 = MapsKt.mapOf(new Pair[]{TuplesKt.to(r26, r27), TuplesKt.to(Companion.access$method(r22, r28, "remove", "Ljava/lang/Object;", r29), r27), TuplesKt.to(Companion.access$method(r22, r110, "containsKey", "Ljava/lang/Object;", r111), r27), TuplesKt.to(Companion.access$method(r22, r112, "containsValue", "Ljava/lang/Object;", r113), r27), TuplesKt.to(Companion.access$method(r22, r114, "remove", "Ljava/lang/Object;Ljava/lang/Object;", r30), r27), TuplesKt.to(Companion.access$method(r22, r21.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(r31, r115), TuplesKt.to(Companion.access$method(r22, r21.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), r115), TuplesKt.to(r33, r34), TuplesKt.to(Companion.access$method(r22, r35, "lastIndexOf", "Ljava/lang/Object;", r36), r34)});
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = r37;
        LinkedHashMap r38 = new LinkedHashMap(MapsKt.mapCapacity(r37.size()));
        Iterator<T> r39 = r37.entrySet().iterator();
    L16:
        if (r39.hasNext() == false) goto L18;
        Map.Entry r40 = (Map.Entry) r39.next();
        r38.put(((Companion.NameAndSignature) r40.getKey()).getSignature(), r40.getValue());
        goto L16
    L18:
        SIGNATURE_TO_DEFAULT_VALUES_MAP = r38;
        Set r41 = SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator r43 = r41.iterator();
    L20:
        if (r43.hasNext() == false) goto L22;
        r42.add(((Companion.NameAndSignature) r43.next()).getName());
        goto L20
    L22:
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet(r42);
        ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator r45 = r41.iterator();
    L24:
        if (r45.hasNext() == false) goto L26;
        r44.add(((Companion.NameAndSignature) r45.next()).getSignature());
        goto L24
    L26:
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet(r44);
        Companion r46 = Companion;
        JvmPrimitiveType r47 = JvmPrimitiveType.INT;
        String r48 = r47.getDesc();
        Intrinsics.checkNotNullExpressionValue(r48, "INT.desc");
        Companion.NameAndSignature r49 = Companion.access$method(r46, "java/util/List", "removeAt", r48, "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = r49;
        SignatureBuildingComponents r50 = SignatureBuildingComponents.INSTANCE;
        String r118 = r50.javaLang("Number");
        String r119 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(r119, "BYTE.desc");
        String r51 = r50.javaLang("Number");
        String r120 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r120, "SHORT.desc");
        String r52 = r50.javaLang("Number");
        String r53 = r47.getDesc();
        Intrinsics.checkNotNullExpressionValue(r53, "INT.desc");
        String r54 = r50.javaLang("Number");
        String r55 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(r55, "LONG.desc");
        String r56 = r50.javaLang("Number");
        String r57 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(r57, "FLOAT.desc");
        String r58 = r50.javaLang("Number");
        String r59 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(r59, "DOUBLE.desc");
        String r60 = r50.javaLang("CharSequence");
        String r61 = r47.getDesc();
        Intrinsics.checkNotNullExpressionValue(r61, "INT.desc");
        String r62 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(r62, "CHAR.desc");
        Map<Companion.NameAndSignature, Name> r63 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Companion.access$method(r46, r118, "toByte", "", r119), Name.identifier("byteValue")), TuplesKt.to(Companion.access$method(r46, r51, "toShort", "", r120), Name.identifier("shortValue")), TuplesKt.to(Companion.access$method(r46, r52, "toInt", "", r53), Name.identifier("intValue")), TuplesKt.to(Companion.access$method(r46, r54, "toLong", "", r55), Name.identifier("longValue")), TuplesKt.to(Companion.access$method(r46, r56, "toFloat", "", r57), Name.identifier("floatValue")), TuplesKt.to(Companion.access$method(r46, r58, "toDouble", "", r59), Name.identifier("doubleValue")), TuplesKt.to(r49, Name.identifier("remove")), TuplesKt.to(Companion.access$method(r46, r60, "get", r61, r62), Name.identifier("charAt"))});
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = r63;
        LinkedHashMap r64 = new LinkedHashMap(MapsKt.mapCapacity(r63.size()));
        Iterator<T> r65 = r63.entrySet().iterator();
    L28:
        if (r65.hasNext() == false) goto L30;
        Map.Entry r66 = (Map.Entry) r65.next();
        r64.put(((Companion.NameAndSignature) r66.getKey()).getSignature(), r66.getValue());
        goto L28
    L30:
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = r64;
        Set<Companion.NameAndSignature> r67 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        ArrayList r68 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r67, 10));
        Iterator<T> r69 = r67.iterator();
    L32:
        if (r69.hasNext() == false) goto L34;
        r68.add(((Companion.NameAndSignature) r69.next()).getName());
        goto L32
    L34:
        ORIGINAL_SHORT_NAMES = r68;
        Set<Map.Entry<Companion.NameAndSignature, Name>> r70 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        ArrayList r71 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r70, 10));
        Iterator<T> r72 = r70.iterator();
    L36:
        if (r72.hasNext() == false) goto L38;
        Map.Entry r73 = (Map.Entry) r72.next();
        r71.add(new Pair(((Companion.NameAndSignature) r73.getKey()).getName(), r73.getValue()));
        goto L36
    L38:
        LinkedHashMap r74 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r71, 10)), 16));
        Iterator r75 = r71.iterator();
    L40:
        if (r75.hasNext() == false) goto L42;
        Pair r76 = (Pair) r75.next();
        r74.put((Name) r76.getSecond(), (Name) r76.getFirst());
        goto L40
    L42:
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = r74;
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
