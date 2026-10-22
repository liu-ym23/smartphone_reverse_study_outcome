package kotlin.reflect.jvm.internal.impl.builtins;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class StandardNames {

    @JvmField
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME = null;

    @JvmField
    public static final Name BACKING_FIELD = null;

    @JvmField
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME = null;

    @JvmField
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES = null;

    @JvmField
    public static final Name BUILT_INS_PACKAGE_NAME = null;

    @JvmField
    public static final Name CHAR_CODE = null;

    @JvmField
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME = null;

    @JvmField
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = null;

    @JvmField
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME = null;

    @JvmField
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = null;

    @JvmField
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = null;

    @JvmField
    public static final FqName COROUTINES_PACKAGE_FQ_NAME = null;

    @JvmField
    public static final String DATA_CLASS_COMPONENT_PREFIX = null;

    @JvmField
    public static final Name DATA_CLASS_COPY = null;

    @JvmField
    public static final Name DEFAULT_VALUE_PARAMETER = null;

    @JvmField
    public static final FqName DYNAMIC_FQ_NAME = null;

    @JvmField
    public static final Name ENUM_VALUES = null;

    @JvmField
    public static final Name ENUM_VALUE_OF = null;

    @JvmField
    public static final Name HASHCODE_NAME = null;
    public static final StandardNames INSTANCE = null;
    private static final FqName KOTLIN_INTERNAL_FQ_NAME = null;

    @JvmField
    public static final FqName KOTLIN_REFLECT_FQ_NAME = null;

    @JvmField
    public static final List<String> PREFIXES = null;

    @JvmField
    public static final FqName RANGES_PACKAGE_FQ_NAME = null;

    @JvmField
    public static final FqName RESULT_FQ_NAME = null;

    @JvmField
    public static final FqName TEXT_PACKAGE_FQ_NAME = null;

    public static final class FqNames {
        public static final FqNames INSTANCE = null;

        @JvmField
        public static final FqNameUnsafe _boolean = null;

        @JvmField
        public static final FqNameUnsafe _byte = null;

        @JvmField
        public static final FqNameUnsafe _char = null;

        @JvmField
        public static final FqNameUnsafe _double = null;

        @JvmField
        public static final FqNameUnsafe _enum = null;

        @JvmField
        public static final FqNameUnsafe _float = null;

        @JvmField
        public static final FqNameUnsafe _int = null;

        @JvmField
        public static final FqNameUnsafe _long = null;

        @JvmField
        public static final FqNameUnsafe _short = null;

        @JvmField
        public static final FqName annotation = null;

        @JvmField
        public static final FqName annotationRetention = null;

        @JvmField
        public static final FqName annotationTarget = null;

        @JvmField
        public static final FqNameUnsafe any = null;

        @JvmField
        public static final FqNameUnsafe array = null;

        @JvmField
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType = null;

        @JvmField
        public static final FqNameUnsafe charSequence = null;

        @JvmField
        public static final FqNameUnsafe cloneable = null;

        @JvmField
        public static final FqName collection = null;

        @JvmField
        public static final FqName comparable = null;

        @JvmField
        public static final FqName contextFunctionTypeParams = null;

        @JvmField
        public static final FqName deprecated = null;

        @JvmField
        public static final FqName deprecatedSinceKotlin = null;

        @JvmField
        public static final FqName deprecationLevel = null;

        @JvmField
        public static final FqName extensionFunctionType = null;

        @JvmField
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType = null;

        @JvmField
        public static final FqNameUnsafe functionSupertype = null;

        @JvmField
        public static final FqNameUnsafe intRange = null;

        @JvmField
        public static final FqName iterable = null;

        @JvmField
        public static final FqName iterator = null;

        @JvmField
        public static final FqNameUnsafe kCallable = null;

        @JvmField
        public static final FqNameUnsafe kClass = null;

        @JvmField
        public static final FqNameUnsafe kDeclarationContainer = null;

        @JvmField
        public static final FqNameUnsafe kMutableProperty0 = null;

        @JvmField
        public static final FqNameUnsafe kMutableProperty1 = null;

        @JvmField
        public static final FqNameUnsafe kMutableProperty2 = null;

        @JvmField
        public static final FqNameUnsafe kMutablePropertyFqName = null;

        @JvmField
        public static final ClassId kProperty = null;

        @JvmField
        public static final FqNameUnsafe kProperty0 = null;

        @JvmField
        public static final FqNameUnsafe kProperty1 = null;

        @JvmField
        public static final FqNameUnsafe kProperty2 = null;

        @JvmField
        public static final FqNameUnsafe kPropertyFqName = null;

        @JvmField
        public static final FqName list = null;

        @JvmField
        public static final FqName listIterator = null;

        @JvmField
        public static final FqNameUnsafe longRange = null;

        @JvmField
        public static final FqName map = null;

        @JvmField
        public static final FqName mapEntry = null;

        @JvmField
        public static final FqName mustBeDocumented = null;

        @JvmField
        public static final FqName mutableCollection = null;

        @JvmField
        public static final FqName mutableIterable = null;

        @JvmField
        public static final FqName mutableIterator = null;

        @JvmField
        public static final FqName mutableList = null;

        @JvmField
        public static final FqName mutableListIterator = null;

        @JvmField
        public static final FqName mutableMap = null;

        @JvmField
        public static final FqName mutableMapEntry = null;

        @JvmField
        public static final FqName mutableSet = null;

        @JvmField
        public static final FqNameUnsafe nothing = null;

        @JvmField
        public static final FqNameUnsafe number = null;

        @JvmField
        public static final FqName parameterName = null;

        @JvmField
        public static final ClassId parameterNameClassId = null;

        @JvmField
        public static final Set<Name> primitiveArrayTypeShortNames = null;

        @JvmField
        public static final Set<Name> primitiveTypeShortNames = null;

        @JvmField
        public static final FqName publishedApi = null;

        @JvmField
        public static final FqName repeatable = null;

        @JvmField
        public static final ClassId repeatableClassId = null;

        @JvmField
        public static final FqName replaceWith = null;

        @JvmField
        public static final FqName retention = null;

        @JvmField
        public static final ClassId retentionClassId = null;

        @JvmField
        public static final FqName set = null;

        @JvmField
        public static final FqNameUnsafe string = null;

        @JvmField
        public static final FqName suppress = null;

        @JvmField
        public static final FqName target = null;

        @JvmField
        public static final ClassId targetClassId = null;

        @JvmField
        public static final FqName throwable = null;

        @JvmField
        public static final ClassId uByte = null;

        @JvmField
        public static final FqName uByteArrayFqName = null;

        @JvmField
        public static final FqName uByteFqName = null;

        @JvmField
        public static final ClassId uInt = null;

        @JvmField
        public static final FqName uIntArrayFqName = null;

        @JvmField
        public static final FqName uIntFqName = null;

        @JvmField
        public static final ClassId uLong = null;

        @JvmField
        public static final FqName uLongArrayFqName = null;

        @JvmField
        public static final FqName uLongFqName = null;

        @JvmField
        public static final ClassId uShort = null;

        @JvmField
        public static final FqName uShortArrayFqName = null;

        @JvmField
        public static final FqName uShortFqName = null;

        @JvmField
        public static final FqNameUnsafe unit = null;

        @JvmField
        public static final FqName unsafeVariance = null;

        static {
            FqNames r10 = new FqNames();
            INSTANCE = r10;
            any = r10.fqNameUnsafe("Any");
            nothing = r10.fqNameUnsafe("Nothing");
            cloneable = r10.fqNameUnsafe("Cloneable");
            suppress = r10.fqName("Suppress");
            unit = r10.fqNameUnsafe("Unit");
            charSequence = r10.fqNameUnsafe("CharSequence");
            string = r10.fqNameUnsafe("String");
            array = r10.fqNameUnsafe("Array");
            _boolean = r10.fqNameUnsafe("Boolean");
            _char = r10.fqNameUnsafe("Char");
            _byte = r10.fqNameUnsafe("Byte");
            _short = r10.fqNameUnsafe("Short");
            _int = r10.fqNameUnsafe("Int");
            _long = r10.fqNameUnsafe("Long");
            _float = r10.fqNameUnsafe("Float");
            _double = r10.fqNameUnsafe("Double");
            number = r10.fqNameUnsafe("Number");
            _enum = r10.fqNameUnsafe("Enum");
            functionSupertype = r10.fqNameUnsafe("Function");
            throwable = r10.fqName("Throwable");
            comparable = r10.fqName("Comparable");
            intRange = r10.rangesFqName("IntRange");
            longRange = r10.rangesFqName("LongRange");
            deprecated = r10.fqName("Deprecated");
            deprecatedSinceKotlin = r10.fqName("DeprecatedSinceKotlin");
            deprecationLevel = r10.fqName("DeprecationLevel");
            replaceWith = r10.fqName("ReplaceWith");
            extensionFunctionType = r10.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = r10.fqName("ContextFunctionTypeParams");
            FqName r11 = r10.fqName("ParameterName");
            parameterName = r11;
            ClassId r12 = ClassId.topLevel(r11);
            Intrinsics.checkNotNullExpressionValue(r12, "topLevel(parameterName)");
            parameterNameClassId = r12;
            annotation = r10.fqName("Annotation");
            FqName r13 = r10.annotationName("Target");
            target = r13;
            ClassId r14 = ClassId.topLevel(r13);
            Intrinsics.checkNotNullExpressionValue(r14, "topLevel(target)");
            targetClassId = r14;
            annotationTarget = r10.annotationName("AnnotationTarget");
            annotationRetention = r10.annotationName("AnnotationRetention");
            FqName r15 = r10.annotationName("Retention");
            retention = r15;
            ClassId r16 = ClassId.topLevel(r15);
            Intrinsics.checkNotNullExpressionValue(r16, "topLevel(retention)");
            retentionClassId = r16;
            FqName r17 = r10.annotationName("Repeatable");
            repeatable = r17;
            ClassId r18 = ClassId.topLevel(r17);
            Intrinsics.checkNotNullExpressionValue(r18, "topLevel(repeatable)");
            repeatableClassId = r18;
            mustBeDocumented = r10.annotationName("MustBeDocumented");
            unsafeVariance = r10.fqName("UnsafeVariance");
            publishedApi = r10.fqName("PublishedApi");
            iterator = r10.collectionsFqName("Iterator");
            iterable = r10.collectionsFqName("Iterable");
            collection = r10.collectionsFqName("Collection");
            list = r10.collectionsFqName("List");
            listIterator = r10.collectionsFqName("ListIterator");
            set = r10.collectionsFqName("Set");
            FqName r19 = r10.collectionsFqName("Map");
            map = r19;
            FqName r20 = r19.child(Name.identifier("Entry"));
            Intrinsics.checkNotNullExpressionValue(r20, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = r20;
            mutableIterator = r10.collectionsFqName("MutableIterator");
            mutableIterable = r10.collectionsFqName("MutableIterable");
            mutableCollection = r10.collectionsFqName("MutableCollection");
            mutableList = r10.collectionsFqName("MutableList");
            mutableListIterator = r10.collectionsFqName("MutableListIterator");
            mutableSet = r10.collectionsFqName("MutableSet");
            FqName r21 = r10.collectionsFqName("MutableMap");
            mutableMap = r21;
            FqName r22 = r21.child(Name.identifier("MutableEntry"));
            Intrinsics.checkNotNullExpressionValue(r22, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = r22;
            kClass = reflect("KClass");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            FqNameUnsafe r23 = reflect("KProperty");
            kPropertyFqName = r23;
            kMutablePropertyFqName = reflect("KMutableProperty");
            ClassId r24 = ClassId.topLevel(r23.toSafe());
            Intrinsics.checkNotNullExpressionValue(r24, "topLevel(kPropertyFqName.toSafe())");
            kProperty = r24;
            kDeclarationContainer = reflect("KDeclarationContainer");
            FqName r25 = r10.fqName("UByte");
            uByteFqName = r25;
            FqName r26 = r10.fqName("UShort");
            uShortFqName = r26;
            FqName r27 = r10.fqName("UInt");
            uIntFqName = r27;
            FqName r28 = r10.fqName("ULong");
            uLongFqName = r28;
            ClassId r29 = ClassId.topLevel(r25);
            Intrinsics.checkNotNullExpressionValue(r29, "topLevel(uByteFqName)");
            uByte = r29;
            ClassId r30 = ClassId.topLevel(r26);
            Intrinsics.checkNotNullExpressionValue(r30, "topLevel(uShortFqName)");
            uShort = r30;
            ClassId r31 = ClassId.topLevel(r27);
            Intrinsics.checkNotNullExpressionValue(r31, "topLevel(uIntFqName)");
            uInt = r31;
            ClassId r32 = ClassId.topLevel(r28);
            Intrinsics.checkNotNullExpressionValue(r32, "topLevel(uLongFqName)");
            uLong = r32;
            uByteArrayFqName = r10.fqName("UByteArray");
            uShortArrayFqName = r10.fqName("UShortArray");
            uIntArrayFqName = r10.fqName("UIntArray");
            uLongArrayFqName = r10.fqName("ULongArray");
            HashSet r33 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r34 = PrimitiveType.values();
            int r35 = r34.length;
            int r36 = 0;
            int r37 = 0;
        L3:
            if (r37 >= r35) goto L5;
            r33.add(r34[r37].getTypeName());
            r37 = r37 + 1;
            goto L3
        L5:
            primitiveTypeShortNames = r33;
            HashSet r38 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r39 = PrimitiveType.values();
            int r40 = r39.length;
            int r41 = 0;
        L6:
            if (r41 >= r40) goto L8;
            r38.add(r39[r41].getArrayTypeName());
            r41 = r41 + 1;
            goto L6
        L8:
            primitiveArrayTypeShortNames = r38;
            HashMap r42 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r43 = PrimitiveType.values();
            int r44 = r43.length;
            int r45 = 0;
        L9:
            if (r45 >= r44) goto L11;
            PrimitiveType r46 = r43[r45];
            FqNames r47 = INSTANCE;
            String r48 = r46.getTypeName().asString();
            Intrinsics.checkNotNullExpressionValue(r48, "primitiveType.typeName.asString()");
            r42.put(r47.fqNameUnsafe(r48), r46);
            r45 = r45 + 1;
            goto L9
        L11:
            fqNameToPrimitiveType = r42;
            HashMap r49 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r50 = PrimitiveType.values();
            int r51 = r50.length;
        L12:
            if (r36 >= r51) goto L14;
            PrimitiveType r52 = r50[r36];
            FqNames r53 = INSTANCE;
            String r54 = r52.getArrayTypeName().asString();
            Intrinsics.checkNotNullExpressionValue(r54, "primitiveType.arrayTypeName.asString()");
            r49.put(r53.fqNameUnsafe(r54), r52);
            r36 = r36 + 1;
            goto L12
        L14:
            arrayClassFqNameToPrimitiveType = r49;
        }

        private FqNames() {
        }

        private final FqName annotationName(String r10) {
            FqName r11 = StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(r10));
            Intrinsics.checkNotNullExpressionValue(r11, "ANNOTATION_PACKAGE_FQ_NA…e.identifier(simpleName))");
            return r11;
        }

        private final FqName collectionsFqName(String r10) {
            FqName r11 = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(r10));
            Intrinsics.checkNotNullExpressionValue(r11, "COLLECTIONS_PACKAGE_FQ_N…e.identifier(simpleName))");
            return r11;
        }

        private final FqName fqName(String r10) {
            FqName r11 = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(r10));
            Intrinsics.checkNotNullExpressionValue(r11, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(simpleName))");
            return r11;
        }

        private final FqNameUnsafe fqNameUnsafe(String r10) {
            FqNameUnsafe r11 = fqName(r10).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(r11, "fqName(simpleName).toUnsafe()");
            return r11;
        }

        private final FqNameUnsafe rangesFqName(String r10) {
            FqNameUnsafe r11 = StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(r10)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(r11, "RANGES_PACKAGE_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return r11;
        }

        @JvmStatic
        public static final FqNameUnsafe reflect(String r10) {
            Intrinsics.checkNotNullParameter(r10, "simpleName");
            FqNameUnsafe r11 = StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(r10)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(r11, "KOTLIN_REFLECT_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return r11;
        }
    }

    static {
        INSTANCE = new StandardNames();
        Name r10 = Name.identifier("field");
        Intrinsics.checkNotNullExpressionValue(r10, "identifier(\"field\")");
        BACKING_FIELD = r10;
        Name r11 = Name.identifier(EventBody.KEY_VALUE);
        Intrinsics.checkNotNullExpressionValue(r11, "identifier(\"value\")");
        DEFAULT_VALUE_PARAMETER = r11;
        Name r12 = Name.identifier("values");
        Intrinsics.checkNotNullExpressionValue(r12, "identifier(\"values\")");
        ENUM_VALUES = r12;
        Name r13 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(r13, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = r13;
        Name r14 = Name.identifier("copy");
        Intrinsics.checkNotNullExpressionValue(r14, "identifier(\"copy\")");
        DATA_CLASS_COPY = r14;
        DATA_CLASS_COMPONENT_PREFIX = "component";
        Name r15 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(r15, "identifier(\"hashCode\")");
        HASHCODE_NAME = r15;
        Name r16 = Name.identifier("code");
        Intrinsics.checkNotNullExpressionValue(r16, "identifier(\"code\")");
        CHAR_CODE = r16;
        Name r17 = Name.identifier(CommonConsts.COUNT_TYPE);
        Intrinsics.checkNotNullExpressionValue(r17, "identifier(\"count\")");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = r17;
        DYNAMIC_FQ_NAME = new FqName("<dynamic>");
        FqName r18 = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = r18;
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
        FqName r19 = r18.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(r19, "COROUTINES_PACKAGE_FQ_NA…entifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME = r19;
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        FqName r20 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = r20;
        PREFIXES = kotlin.collections.CollectionsKt.listOf(new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        Name r21 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(r21, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = r21;
        FqName r22 = FqName.topLevel(r21);
        Intrinsics.checkNotNullExpressionValue(r22, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = r22;
        FqName r23 = r22.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(r23, "BUILT_INS_PACKAGE_FQ_NAM…identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = r23;
        FqName r24 = r22.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(r24, "BUILT_INS_PACKAGE_FQ_NAM…dentifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = r24;
        FqName r25 = r22.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(r25, "BUILT_INS_PACKAGE_FQ_NAM…ame.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = r25;
        FqName r26 = r22.child(Name.identifier("text"));
        Intrinsics.checkNotNullExpressionValue(r26, "BUILT_INS_PACKAGE_FQ_NAM…(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = r26;
        FqName r27 = r22.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(r27, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(\"internal\"))");
        KOTLIN_INTERNAL_FQ_NAME = r27;
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(new FqName[]{r22, r24, r25, r23, r20, r27, r18});
    }

    private StandardNames() {
    }

    @JvmStatic
    public static final ClassId getFunctionClassId(int r10) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(r10)));
    }

    @JvmStatic
    public static final String getFunctionName(int r10) {
        return "Function" + r10;
    }

    @JvmStatic
    public static final FqName getPrimitiveFqName(PrimitiveType r10) {
        Intrinsics.checkNotNullParameter(r10, "primitiveType");
        FqName r11 = BUILT_INS_PACKAGE_FQ_NAME.child(r10.getTypeName());
        Intrinsics.checkNotNullExpressionValue(r11, "BUILT_INS_PACKAGE_FQ_NAM…d(primitiveType.typeName)");
        return r11;
    }

    @JvmStatic
    public static final String getSuspendFunctionName(int r10) {
        return FunctionClassKind.SuspendFunction.getClassNamePrefix() + r10;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(FqNameUnsafe r10) {
        Intrinsics.checkNotNullParameter(r10, "arrayFqName");
        if (FqNames.arrayClassFqNameToPrimitiveType.get(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
