package kotlin.reflect.jvm.internal.impl.builtins;

import ai.j0;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.apm.ApmAgent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
    public static final Name ENUM_ENTRIES = null;

    @JvmField
    public static final Name ENUM_VALUES = null;

    @JvmField
    public static final Name ENUM_VALUE_OF = null;

    @JvmField
    public static final Name HASHCODE_NAME = null;
    public static final StandardNames INSTANCE = null;

    @JvmField
    public static final FqName KOTLIN_INTERNAL_FQ_NAME = null;

    @JvmField
    public static final FqName KOTLIN_REFLECT_FQ_NAME = null;

    @JvmField
    public static final Name NEXT_CHAR = null;
    private static final FqName NON_EXISTENT_CLASS = null;

    @JvmField
    public static final List<String> PREFIXES = null;

    @JvmField
    public static final FqName RANGES_PACKAGE_FQ_NAME = null;

    @JvmField
    public static final FqName RESULT_FQ_NAME = null;

    @JvmField
    public static final FqName TEXT_PACKAGE_FQ_NAME = null;

    @SourceDebugExtension({"SMAP\nStandardNames.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardNames.kt\norg/jetbrains/kotlin/builtins/StandardNames$FqNames\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,295:1\n11670#2,3:296\n11670#2,3:299\n*S KotlinDebug\n*F\n+ 1 StandardNames.kt\norg/jetbrains/kotlin/builtins/StandardNames$FqNames\n*L\n191#1:296,3\n195#1:299,3\n*E\n"})
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
        public static final FqName accessibleLateinitPropertyLiteral = null;

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
            FqNames r5 = new FqNames();
            INSTANCE = r5;
            any = r5.fqNameUnsafe("Any");
            nothing = r5.fqNameUnsafe("Nothing");
            cloneable = r5.fqNameUnsafe("Cloneable");
            suppress = r5.fqName("Suppress");
            unit = r5.fqNameUnsafe("Unit");
            charSequence = r5.fqNameUnsafe("CharSequence");
            string = r5.fqNameUnsafe("String");
            array = r5.fqNameUnsafe("Array");
            _boolean = r5.fqNameUnsafe("Boolean");
            _char = r5.fqNameUnsafe("Char");
            _byte = r5.fqNameUnsafe("Byte");
            _short = r5.fqNameUnsafe("Short");
            _int = r5.fqNameUnsafe("Int");
            _long = r5.fqNameUnsafe("Long");
            _float = r5.fqNameUnsafe("Float");
            _double = r5.fqNameUnsafe("Double");
            number = r5.fqNameUnsafe("Number");
            _enum = r5.fqNameUnsafe("Enum");
            functionSupertype = r5.fqNameUnsafe("Function");
            throwable = r5.fqName("Throwable");
            comparable = r5.fqName("Comparable");
            intRange = r5.rangesFqName("IntRange");
            longRange = r5.rangesFqName("LongRange");
            deprecated = r5.fqName(ApmAgent.TAG_DEPRECATED);
            deprecatedSinceKotlin = r5.fqName("DeprecatedSinceKotlin");
            deprecationLevel = r5.fqName("DeprecationLevel");
            replaceWith = r5.fqName("ReplaceWith");
            extensionFunctionType = r5.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = r5.fqName("ContextFunctionTypeParams");
            FqName r10 = r5.fqName("ParameterName");
            parameterName = r10;
            parameterNameClassId = ClassId.topLevel(r10);
            annotation = r5.fqName("Annotation");
            FqName r11 = r5.annotationName("Target");
            target = r11;
            targetClassId = ClassId.topLevel(r11);
            annotationTarget = r5.annotationName("AnnotationTarget");
            annotationRetention = r5.annotationName("AnnotationRetention");
            FqName r12 = r5.annotationName("Retention");
            retention = r12;
            retentionClassId = ClassId.topLevel(r12);
            FqName r13 = r5.annotationName("Repeatable");
            repeatable = r13;
            repeatableClassId = ClassId.topLevel(r13);
            mustBeDocumented = r5.annotationName("MustBeDocumented");
            unsafeVariance = r5.fqName("UnsafeVariance");
            publishedApi = r5.fqName("PublishedApi");
            accessibleLateinitPropertyLiteral = r5.internalName("AccessibleLateinitPropertyLiteral");
            iterator = r5.collectionsFqName("Iterator");
            iterable = r5.collectionsFqName("Iterable");
            collection = r5.collectionsFqName("Collection");
            list = r5.collectionsFqName("List");
            listIterator = r5.collectionsFqName("ListIterator");
            set = r5.collectionsFqName("Set");
            FqName r14 = r5.collectionsFqName("Map");
            map = r14;
            mapEntry = r14.child(Name.identifier("Entry"));
            mutableIterator = r5.collectionsFqName("MutableIterator");
            mutableIterable = r5.collectionsFqName("MutableIterable");
            mutableCollection = r5.collectionsFqName("MutableCollection");
            mutableList = r5.collectionsFqName("MutableList");
            mutableListIterator = r5.collectionsFqName("MutableListIterator");
            mutableSet = r5.collectionsFqName("MutableSet");
            FqName r15 = r5.collectionsFqName("MutableMap");
            mutableMap = r15;
            mutableMapEntry = r15.child(Name.identifier("MutableEntry"));
            kClass = reflect("KClass");
            kCallable = reflect("KCallable");
            kProperty0 = reflect("KProperty0");
            kProperty1 = reflect("KProperty1");
            kProperty2 = reflect("KProperty2");
            kMutableProperty0 = reflect("KMutableProperty0");
            kMutableProperty1 = reflect("KMutableProperty1");
            kMutableProperty2 = reflect("KMutableProperty2");
            FqNameUnsafe r16 = reflect("KProperty");
            kPropertyFqName = r16;
            kMutablePropertyFqName = reflect("KMutableProperty");
            kProperty = ClassId.topLevel(r16.toSafe());
            kDeclarationContainer = reflect("KDeclarationContainer");
            FqName r17 = r5.fqName("UByte");
            uByteFqName = r17;
            FqName r18 = r5.fqName("UShort");
            uShortFqName = r18;
            FqName r19 = r5.fqName("UInt");
            uIntFqName = r19;
            FqName r20 = r5.fqName("ULong");
            uLongFqName = r20;
            uByte = ClassId.topLevel(r17);
            uShort = ClassId.topLevel(r18);
            uInt = ClassId.topLevel(r19);
            uLong = ClassId.topLevel(r20);
            uByteArrayFqName = r5.fqName("UByteArray");
            uShortArrayFqName = r5.fqName("UShortArray");
            uIntArrayFqName = r5.fqName("UIntArray");
            uLongArrayFqName = r5.fqName("ULongArray");
            HashSet r21 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r22 = PrimitiveType.values();
            int r23 = r22.length;
            int r24 = 0;
            int r25 = 0;
        L3:
            if (r25 >= r23) goto L5;
            r21.add(r22[r25].getTypeName());
            r25 = r25 + 1;
            goto L3
        L5:
            primitiveTypeShortNames = r21;
            HashSet r26 = CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r27 = PrimitiveType.values();
            int r28 = r27.length;
            int r29 = 0;
        L6:
            if (r29 >= r28) goto L8;
            r26.add(r27[r29].getArrayTypeName());
            r29 = r29 + 1;
            goto L6
        L8:
            primitiveArrayTypeShortNames = r26;
            HashMap r30 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r31 = PrimitiveType.values();
            int r32 = r31.length;
            int r33 = 0;
        L9:
            if (r33 >= r32) goto L11;
            PrimitiveType r34 = r31[r33];
            r30.put(INSTANCE.fqNameUnsafe(r34.getTypeName().asString()), r34);
            r33 = r33 + 1;
            goto L9
        L11:
            fqNameToPrimitiveType = r30;
            HashMap r35 = CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            PrimitiveType[] r36 = PrimitiveType.values();
            int r37 = r36.length;
        L12:
            if (r24 >= r37) goto L14;
            PrimitiveType r38 = r36[r24];
            r35.put(INSTANCE.fqNameUnsafe(r38.getArrayTypeName().asString()), r38);
            r24 = r24 + 1;
            goto L12
        L14:
            arrayClassFqNameToPrimitiveType = r35;
        }

        private FqNames() {
        }

        private final FqName annotationName(String r5) {
            return StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(r5));
        }

        private final FqName collectionsFqName(String r5) {
            return StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(r5));
        }

        private final FqName fqName(String r5) {
            return StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(r5));
        }

        private final FqNameUnsafe fqNameUnsafe(String r5) {
            return fqName(r5).toUnsafe();
        }

        private final FqName internalName(String r5) {
            return StandardNames.KOTLIN_INTERNAL_FQ_NAME.child(Name.identifier(r5));
        }

        private final FqNameUnsafe rangesFqName(String r5) {
            return StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(r5)).toUnsafe();
        }

        @JvmStatic
        public static final FqNameUnsafe reflect(String r5) {
            Intrinsics.checkNotNullParameter(r5, "simpleName");
            return StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(r5)).toUnsafe();
        }
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
        CHAR_CODE = Name.identifier("code");
        NEXT_CHAR = Name.identifier("nextChar");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = Name.identifier("count");
        DYNAMIC_FQ_NAME = new FqName("<dynamic>");
        FqName r10 = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = r10;
        COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
        CONTINUATION_INTERFACE_FQ_NAME = r10.child(Name.identifier("Continuation"));
        RESULT_FQ_NAME = new FqName("kotlin.Result");
        FqName r11 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = r11;
        PREFIXES = kotlin.collections.CollectionsKt.listOf(new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
        Name r5 = Name.identifier("kotlin");
        BUILT_INS_PACKAGE_NAME = r5;
        FqName r12 = FqName.topLevel(r5);
        BUILT_INS_PACKAGE_FQ_NAME = r12;
        FqName r13 = r12.child(Name.identifier("annotation"));
        ANNOTATION_PACKAGE_FQ_NAME = r13;
        FqName r14 = r12.child(Name.identifier("collections"));
        COLLECTIONS_PACKAGE_FQ_NAME = r14;
        FqName r15 = r12.child(Name.identifier("ranges"));
        RANGES_PACKAGE_FQ_NAME = r15;
        TEXT_PACKAGE_FQ_NAME = r12.child(Name.identifier(MessageIndication.CONTENT_TYPE_TEXT));
        FqName r16 = r12.child(Name.identifier("internal"));
        KOTLIN_INTERNAL_FQ_NAME = r16;
        NON_EXISTENT_CLASS = new FqName("error.NonExistentClass");
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(new FqName[]{r12, r14, r15, r13, r11, r16, r10});
    }

    private StandardNames() {
    }

    @JvmStatic
    public static final ClassId getFunctionClassId(int r5) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(r5)));
    }

    @JvmStatic
    public static final String getFunctionName(int r5) {
        return j0.g(r5, "Function");
    }

    @JvmStatic
    public static final FqName getPrimitiveFqName(PrimitiveType r5) {
        Intrinsics.checkNotNullParameter(r5, "primitiveType");
        return BUILT_INS_PACKAGE_FQ_NAME.child(r5.getTypeName());
    }

    @JvmStatic
    public static final String getSuspendFunctionName(int r5) {
        return FunctionClassKind.SuspendFunction.getClassNamePrefix() + r5;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(FqNameUnsafe r5) {
        Intrinsics.checkNotNullParameter(r5, "arrayFqName");
        if (FqNames.arrayClassFqNameToPrimitiveType.get(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
