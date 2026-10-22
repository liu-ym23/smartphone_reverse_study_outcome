package kotlin.reflect.jvm.internal.impl.builtins;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class StandardNames {
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME = null;
    public static final Name BACKING_FIELD = null;
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME = null;
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES = null;
    public static final Name BUILT_INS_PACKAGE_NAME = null;
    public static final Name CHAR_CODE = null;
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME = null;
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = null;
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME = null;
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = null;
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = null;
    public static final FqName COROUTINES_PACKAGE_FQ_NAME = null;
    public static final String DATA_CLASS_COMPONENT_PREFIX = null;
    public static final Name DATA_CLASS_COPY = null;
    public static final Name DEFAULT_VALUE_PARAMETER = null;
    public static final FqName DYNAMIC_FQ_NAME = null;
    public static final Name ENUM_ENTRIES = null;
    public static final Name ENUM_VALUES = null;
    public static final Name ENUM_VALUE_OF = null;
    public static final Name EQUALS_NAME = null;
    public static final Name HASHCODE_NAME = null;
    public static final Name IMPLICIT_LAMBDA_PARAMETER_NAME = null;
    public static final StandardNames INSTANCE = null;
    public static final FqName KOTLIN_INTERNAL_FQ_NAME = null;
    public static final FqName KOTLIN_REFLECT_FQ_NAME = null;
    public static final Name MAIN = null;
    public static final Name NAME = null;
    public static final Name NEXT_CHAR = null;
    private static final FqName NON_EXISTENT_CLASS = null;
    public static final List<String> PREFIXES = null;
    public static final FqName RANGES_PACKAGE_FQ_NAME = null;
    public static final FqName RESULT_FQ_NAME = null;
    public static final FqName TEXT_PACKAGE_FQ_NAME = null;
    public static final Name TO_STRING_NAME = null;

    public static final class FqNames {
        public static final FqNames INSTANCE = null;
        public static final FqNameUnsafe _boolean = null;
        public static final FqNameUnsafe _byte = null;
        public static final FqNameUnsafe _char = null;
        public static final FqNameUnsafe _double = null;
        public static final FqNameUnsafe _enum = null;
        public static final FqNameUnsafe _float = null;
        public static final FqNameUnsafe _int = null;
        public static final FqNameUnsafe _long = null;
        public static final FqNameUnsafe _short = null;
        public static final FqName accessibleLateinitPropertyLiteral = null;
        public static final FqName annotation = null;
        public static final FqName annotationRetention = null;
        public static final FqName annotationTarget = null;
        public static final FqNameUnsafe any = null;
        public static final FqNameUnsafe array = null;
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType = null;
        public static final FqNameUnsafe charSequence = null;
        public static final FqNameUnsafe cloneable = null;
        public static final FqName collection = null;
        public static final FqName comparable = null;
        public static final FqName contextFunctionTypeParams = null;
        public static final FqName deprecated = null;
        public static final FqName deprecatedSinceKotlin = null;
        public static final FqName deprecationLevel = null;
        public static final FqName extensionFunctionType = null;
        public static final FqNameUnsafe findAssociatedObject = null;
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType = null;
        public static final FqNameUnsafe functionSupertype = null;
        public static final FqNameUnsafe intRange = null;
        public static final FqName iterable = null;
        public static final FqName iterator = null;
        public static final FqNameUnsafe kCallable = null;
        public static final FqNameUnsafe kClass = null;
        public static final FqNameUnsafe kDeclarationContainer = null;
        public static final FqNameUnsafe kMutableProperty0 = null;
        public static final FqNameUnsafe kMutableProperty1 = null;
        public static final FqNameUnsafe kMutableProperty2 = null;
        public static final FqNameUnsafe kMutablePropertyFqName = null;
        public static final ClassId kProperty = null;
        public static final FqNameUnsafe kProperty0 = null;
        public static final FqNameUnsafe kProperty1 = null;
        public static final FqNameUnsafe kProperty2 = null;
        public static final FqNameUnsafe kPropertyFqName = null;
        public static final FqNameUnsafe kType = null;
        public static final FqName list = null;
        public static final FqName listIterator = null;
        public static final FqNameUnsafe longRange = null;
        public static final FqName map = null;
        public static final FqName mapEntry = null;
        public static final FqName mustBeDocumented = null;
        public static final FqName mutableCollection = null;
        public static final FqName mutableIterable = null;
        public static final FqName mutableIterator = null;
        public static final FqName mutableList = null;
        public static final FqName mutableListIterator = null;
        public static final FqName mutableMap = null;
        public static final FqName mutableMapEntry = null;
        public static final FqName mutableSet = null;
        public static final FqNameUnsafe nothing = null;
        public static final FqNameUnsafe number = null;
        public static final FqName parameterName = null;
        public static final ClassId parameterNameClassId = null;
        public static final FqName platformDependent = null;
        public static final ClassId platformDependentClassId = null;
        public static final Set<Name> primitiveArrayTypeShortNames = null;
        public static final Set<Name> primitiveTypeShortNames = null;
        public static final FqName publishedApi = null;
        public static final FqName repeatable = null;
        public static final ClassId repeatableClassId = null;
        public static final FqName replaceWith = null;
        public static final FqName retention = null;
        public static final ClassId retentionClassId = null;
        public static final FqName set = null;
        public static final FqNameUnsafe string = null;
        public static final FqName suppress = null;
        public static final FqName target = null;
        public static final ClassId targetClassId = null;
        public static final FqName throwable = null;
        public static final ClassId uByte = null;
        public static final FqName uByteArrayFqName = null;
        public static final FqName uByteFqName = null;
        public static final ClassId uInt = null;
        public static final FqName uIntArrayFqName = null;
        public static final FqName uIntFqName = null;
        public static final ClassId uLong = null;
        public static final FqName uLongArrayFqName = null;
        public static final FqName uLongFqName = null;
        public static final ClassId uShort = null;
        public static final FqName uShortArrayFqName = null;
        public static final FqName uShortFqName = null;
        public static final FqNameUnsafe unit = null;
        public static final FqName unsafeVariance = null;

        private FqNames() {
        }

        static {
            FqNames r0 = new FqNames();
            INSTANCE = r0;
            any = r0.fqNameUnsafe("Any");
            nothing = r0.fqNameUnsafe("Nothing");
            cloneable = r0.fqNameUnsafe("Cloneable");
            suppress = r0.fqName("Suppress");
            unit = r0.fqNameUnsafe("Unit");
            charSequence = r0.fqNameUnsafe("CharSequence");
            string = r0.fqNameUnsafe("String");
            array = r0.fqNameUnsafe("Array");
            _boolean = r0.fqNameUnsafe("Boolean");
            _char = r0.fqNameUnsafe("Char");
            _byte = r0.fqNameUnsafe("Byte");
            _short = r0.fqNameUnsafe("Short");
            _int = r0.fqNameUnsafe("Int");
            _long = r0.fqNameUnsafe("Long");
            _float = r0.fqNameUnsafe("Float");
            _double = r0.fqNameUnsafe("Double");
            number = r0.fqNameUnsafe("Number");
            _enum = r0.fqNameUnsafe("Enum");
            functionSupertype = r0.fqNameUnsafe("Function");
            throwable = r0.fqName("Throwable");
            comparable = r0.fqName("Comparable");
            intRange = r0.rangesFqName("IntRange");
            longRange = r0.rangesFqName("LongRange");
            deprecated = r0.fqName("Deprecated");
            deprecatedSinceKotlin = r0.fqName("DeprecatedSinceKotlin");
            deprecationLevel = r0.fqName("DeprecationLevel");
            replaceWith = r0.fqName("ReplaceWith");
            extensionFunctionType = r0.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = r0.fqName("ContextFunctionTypeParams");
            FqName r1 = r0.fqName("ParameterName");
            parameterName = r1;
            ClassId.Companion r2 = ClassId.Companion;
            parameterNameClassId = r2.topLevel(r1);
            annotation = r0.fqName("Annotation");
            FqName r3 = r0.annotationName("Target");
            target = r3;
            targetClassId = r2.topLevel(r3);
            annotationTarget = r0.annotationName("AnnotationTarget");
            annotationRetention = r0.annotationName("AnnotationRetention");
            FqName r4 = r0.annotationName("Retention");
            retention = r4;
            retentionClassId = r2.topLevel(r4);
            FqName r5 = r0.annotationName("Repeatable");
            repeatable = r5;
            repeatableClassId = r2.topLevel(r5);
            mustBeDocumented = r0.annotationName("MustBeDocumented");
            unsafeVariance = r0.fqName("UnsafeVariance");
            publishedApi = r0.fqName("PublishedApi");
            accessibleLateinitPropertyLiteral = r0.internalName("AccessibleLateinitPropertyLiteral");
            FqName r6 = new FqName("kotlin.internal.PlatformDependent");
            platformDependent = r6;
            platformDependentClassId = r2.topLevel(r6);
            iterator = r0.collectionsFqName("Iterator");
            iterable = r0.collectionsFqName("Iterable");
            collection = r0.collectionsFqName("Collection");
            list = r0.collectionsFqName("List");
            listIterator = r0.collectionsFqName("ListIterator");
            set = r0.collectionsFqName("Set");
            FqName r7 = r0.collectionsFqName("Map");
            map = r7;
            mapEntry = r7.child(Name.identifier("Entry"));
            mutableIterator = r0.collectionsFqName("MutableIterator");
            mutableIterable = r0.collectionsFqName("MutableIterable");
            mutableCollection = r0.collectionsFqName("MutableCollection");
            mutableList = r0.collectionsFqName("MutableList");
            mutableListIterator = r0.collectionsFqName("MutableListIterator");
            mutableSet = r0.collectionsFqName("MutableSet");
            FqName r8 = r0.collectionsFqName("MutableMap");
            mutableMap = r8;
            mutableMapEntry = r8.child(Name.identifier("MutableEntry"));
            kClass = reflect("KClass");
            kType = reflect("KType");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            FqNameUnsafe r9 = reflect("KProperty");
            kPropertyFqName = r9;
            kMutablePropertyFqName = reflect("KMutableProperty");
            kProperty = r2.topLevel(r9.toSafe());
            kDeclarationContainer = reflect("KDeclarationContainer");
            findAssociatedObject = reflect("findAssociatedObject");
            FqName r10 = r0.fqName("UByte");
            uByteFqName = r10;
            FqName r11 = r0.fqName("UShort");
            uShortFqName = r11;
            FqName r12 = r0.fqName("UInt");
            uIntFqName = r12;
            FqName r13 = r0.fqName("ULong");
            uLongFqName = r13;
            uByte = r2.topLevel(r10);
            uShort = r2.topLevel(r11);
            uInt = r2.topLevel(r12);
            uLong = r2.topLevel(r13);
            uByteArrayFqName = r0.fqName("UByteArray");
            uShortArrayFqName = r0.fqName("UShortArray");
            uIntArrayFqName = r0.fqName("UIntArray");
            uLongArrayFqName = r0.fqName("ULongArray");
            HashSet r14 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r15 = PrimitiveType.values();
            int r16 = r15.length;
            int r17 = 0;
            int r18 = 0;
        L3:
            if (r18 >= r16) goto L5;
            r14.add(r15[r18].getTypeName());
            r18 = r18 + 1;
            goto L3
        L5:
            primitiveTypeShortNames = r14;
            HashSet r19 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r20 = PrimitiveType.values();
            int r21 = r20.length;
            int r22 = 0;
        L6:
            if (r22 >= r21) goto L8;
            r19.add(r20[r22].getArrayTypeName());
            r22 = r22 + 1;
            goto L6
        L8:
            primitiveArrayTypeShortNames = r19;
            HashMap r23 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r24 = PrimitiveType.values();
            int r25 = r24.length;
            int r26 = 0;
        L9:
            if (r26 >= r25) goto L11;
            PrimitiveType r27 = r24[r26];
            r23.put(INSTANCE.fqNameUnsafe(r27.getTypeName().asString()), r27);
            r26 = r26 + 1;
            goto L9
        L11:
            fqNameToPrimitiveType = r23;
            HashMap r28 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r29 = PrimitiveType.values();
            int r30 = r29.length;
        L12:
            if (r17 >= r30) goto L14;
            PrimitiveType r31 = r29[r17];
            r28.put(INSTANCE.fqNameUnsafe(r31.getArrayTypeName().asString()), r31);
            r17 = r17 + 1;
            goto L12
        L14:
            arrayClassFqNameToPrimitiveType = r28;
        }

        private final FqName annotationName(String r2) {
            return StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(r2));
        }

        private final FqName collectionsFqName(String r2) {
            return StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(r2));
        }

        private final FqName fqName(String r2) {
            return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(r2));
        }

        private final FqNameUnsafe fqNameUnsafe(String r1) {
            return fqName(r1).toUnsafe();
        }

        private final FqName internalName(String r2) {
            return StandardNames.KOTLIN_INTERNAL_FQ_NAME.child(Name.identifier(r2));
        }

        private final FqNameUnsafe rangesFqName(String r2) {
            return StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(r2)).toUnsafe();
        }

        @JvmStatic
        public static final FqNameUnsafe reflect(String r1) {
            Intrinsics.checkNotNullParameter(r1, "simpleName");
            return StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(r1)).toUnsafe();
        }
    }

    private StandardNames() {
    }

    static {
        INSTANCE = new StandardNames();
        BACKING_FIELD = Name.identifier("field");
        DEFAULT_VALUE_PARAMETER = Name.identifier("value");
        ENUM_VALUES = Name.identifier("values");
        ENUM_ENTRIES = Name.identifier("entries");
        ENUM_VALUE_OF = Name.identifier("valueOf");
        DATA_CLASS_COPY = Name.identifier("copy");
        DATA_CLASS_COMPONENT_PREFIX = "component";
        HASHCODE_NAME = Name.identifier("hashCode");
        TO_STRING_NAME = Name.identifier("toString");
        EQUALS_NAME = Name.identifier("equals");
        CHAR_CODE = Name.identifier("code");
        NAME = Name.identifier(DBDefinition.NAME);
        MAIN = Name.identifier("main");
        NEXT_CHAR = Name.identifier("nextChar");
        IMPLICIT_LAMBDA_PARAMETER_NAME = Name.identifier("it");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = Name.identifier(EffectConfiguration.KEY_COUNT);
        DYNAMIC_FQ_NAME = new FqName("<dynamic>");
        FqName r0 = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = r0;
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
        CONTINUATION_INTERFACE_FQ_NAME = r0.child(Name.identifier("Continuation"));
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        FqName r1 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = r1;
        PREFIXES = kotlin.collections.CollectionsKt.listOf(new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        Name r2 = Name.identifier("kotlin");
        BUILT_INS_PACKAGE_NAME = r2;
        FqName r3 = FqName.topLevel(r2);
        BUILT_INS_PACKAGE_FQ_NAME = r3;
        FqName r4 = r3.child(Name.identifier("annotation"));
        ANNOTATION_PACKAGE_FQ_NAME = r4;
        FqName r5 = r3.child(Name.identifier("collections"));
        COLLECTIONS_PACKAGE_FQ_NAME = r5;
        FqName r6 = r3.child(Name.identifier("ranges"));
        RANGES_PACKAGE_FQ_NAME = r6;
        TEXT_PACKAGE_FQ_NAME = r3.child(Name.identifier("text"));
        FqName r7 = r3.child(Name.identifier("internal"));
        KOTLIN_INTERNAL_FQ_NAME = r7;
        NON_EXISTENT_CLASS = new FqName("error.NonExistentClass");
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(new FqName[]{r3, r5, r6, r4, r1, r7, r0});
    }

    @JvmStatic
    public static final ClassId getFunctionClassId(int r2) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(r2)));
    }

    @JvmStatic
    public static final String getFunctionName(int r2) {
        return "Function" + r2;
    }

    @JvmStatic
    public static final FqName getPrimitiveFqName(PrimitiveType r1) {
        Intrinsics.checkNotNullParameter(r1, "primitiveType");
        return BUILT_INS_PACKAGE_FQ_NAME.child(r1.getTypeName());
    }

    @JvmStatic
    public static final String getSuspendFunctionName(int r2) {
        return FunctionTypeKind.SuspendFunction.INSTANCE.getClassNamePrefix() + r2;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(FqNameUnsafe r1) {
        Intrinsics.checkNotNullParameter(r1, "arrayFqName");
        if (FqNames.arrayClassFqNameToPrimitiveType.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
