package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nKotlinTarget.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinTarget.kt\norg/jetbrains/kotlin/descriptors/annotations/KotlinTarget\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,140:1\n3792#2:141\n4307#2,2:142\n*S KotlinDebug\n*F\n+ 1 KotlinTarget.kt\norg/jetbrains/kotlin/descriptors/annotations/KotlinTarget\n*L\n81#1:141\n81#1:142,2\n*E\n"})
public final enum KotlinTarget extends Enum<KotlinTarget> {
    private static final /* synthetic */ KotlinTarget[] $VALUES = null;
    private static final Set<KotlinTarget> ALL_TARGET_SET = null;
    public static final KotlinTarget ANNOTATION_CLASS = null;
    private static final List<KotlinTarget> ANNOTATION_CLASS_LIST = null;
    public static final KotlinTarget ANONYMOUS_FUNCTION = null;
    public static final KotlinTarget BACKING_FIELD = null;
    public static final KotlinTarget CLASS = null;
    private static final List<KotlinTarget> CLASS_LIST = null;
    public static final KotlinTarget CLASS_ONLY = null;
    public static final KotlinTarget COMPANION_OBJECT = null;
    private static final List<KotlinTarget> COMPANION_OBJECT_LIST = null;
    public static final KotlinTarget CONSTRUCTOR = null;
    public static final Companion Companion = null;
    private static final Set<KotlinTarget> DEFAULT_TARGET_SET = null;
    public static final KotlinTarget DESTRUCTURING_DECLARATION = null;
    public static final KotlinTarget ENUM_CLASS = null;
    public static final KotlinTarget ENUM_ENTRY = null;
    private static final List<KotlinTarget> ENUM_ENTRY_LIST = null;
    private static final List<KotlinTarget> ENUM_LIST = null;
    public static final KotlinTarget EXPRESSION = null;
    public static final KotlinTarget FIELD = null;
    public static final KotlinTarget FILE = null;
    private static final List<KotlinTarget> FILE_LIST = null;
    public static final KotlinTarget FUNCTION = null;
    private static final List<KotlinTarget> FUNCTION_LIST = null;
    public static final KotlinTarget INITIALIZER = null;
    public static final KotlinTarget INTERFACE = null;
    private static final List<KotlinTarget> INTERFACE_LIST = null;
    public static final KotlinTarget LAMBDA_EXPRESSION = null;
    public static final KotlinTarget LOCAL_CLASS = null;
    private static final List<KotlinTarget> LOCAL_CLASS_LIST = null;
    public static final KotlinTarget LOCAL_FUNCTION = null;
    public static final KotlinTarget LOCAL_VARIABLE = null;
    public static final KotlinTarget MEMBER_FUNCTION = null;
    public static final KotlinTarget MEMBER_PROPERTY = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITH_BACKING_FIELD = null;
    public static final KotlinTarget MEMBER_PROPERTY_WITH_DELEGATE = null;
    public static final KotlinTarget OBJECT = null;
    private static final List<KotlinTarget> OBJECT_LIST = null;
    public static final KotlinTarget OBJECT_LITERAL = null;
    public static final KotlinTarget PROPERTY = null;
    public static final KotlinTarget PROPERTY_GETTER = null;
    private static final List<KotlinTarget> PROPERTY_GETTER_LIST = null;
    public static final KotlinTarget PROPERTY_PARAMETER = null;
    public static final KotlinTarget PROPERTY_SETTER = null;
    private static final List<KotlinTarget> PROPERTY_SETTER_LIST = null;
    public static final KotlinTarget STANDALONE_OBJECT = null;
    public static final KotlinTarget STAR_PROJECTION = null;
    public static final KotlinTarget TOP_LEVEL_FUNCTION = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = null;
    public static final KotlinTarget TOP_LEVEL_PROPERTY_WITH_DELEGATE = null;
    public static final KotlinTarget TYPE = null;
    public static final KotlinTarget TYPEALIAS = null;
    public static final KotlinTarget TYPE_PARAMETER = null;
    public static final KotlinTarget TYPE_PROJECTION = null;
    private static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING = null;
    public static final KotlinTarget VALUE_PARAMETER = null;
    private static final HashMap<String, KotlinTarget> map = null;
    private final String description;
    private final boolean isDefault;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ KotlinTarget[] $values() {
        return new KotlinTarget[]{CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPE, EXPRESSION, FILE, TYPEALIAS, TYPE_PROJECTION, STAR_PROJECTION, PROPERTY_PARAMETER, CLASS_ONLY, OBJECT, STANDALONE_OBJECT, COMPANION_OBJECT, INTERFACE, ENUM_CLASS, ENUM_ENTRY, LOCAL_CLASS, LOCAL_FUNCTION, MEMBER_FUNCTION, TOP_LEVEL_FUNCTION, MEMBER_PROPERTY, MEMBER_PROPERTY_WITH_BACKING_FIELD, MEMBER_PROPERTY_WITH_DELEGATE, MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, TOP_LEVEL_PROPERTY, TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD, TOP_LEVEL_PROPERTY_WITH_DELEGATE, TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, BACKING_FIELD, INITIALIZER, DESTRUCTURING_DECLARATION, LAMBDA_EXPRESSION, ANONYMOUS_FUNCTION, OBJECT_LITERAL};
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int r5 = 0;
        CLASS = new KotlinTarget("CLASS", 0, "class", 0 == true ? 1 : 0, 2, null);
        ANNOTATION_CLASS = new KotlinTarget("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
        TYPE_PARAMETER = new KotlinTarget("TYPE_PARAMETER", 2, "type parameter", false);
        boolean r10 = false;
        int r11 = 2;
        DefaultConstructorMarker r12 = null;
        PROPERTY = new KotlinTarget("PROPERTY", 3, "property", r10, r11, r12);
        boolean r16 = false;
        int r17 = 2;
        DefaultConstructorMarker r18 = null;
        FIELD = new KotlinTarget("FIELD", 4, "field", r16, r17, r18);
        LOCAL_VARIABLE = new KotlinTarget("LOCAL_VARIABLE", 5, "local variable", r10, r11, r12);
        VALUE_PARAMETER = new KotlinTarget("VALUE_PARAMETER", 6, "value parameter", r16, r17, r18);
        CONSTRUCTOR = new KotlinTarget("CONSTRUCTOR", 7, "constructor", r10, r11, r12);
        FUNCTION = new KotlinTarget("FUNCTION", 8, "function", r16, r17, r18);
        PROPERTY_GETTER = new KotlinTarget("PROPERTY_GETTER", 9, "getter", r10, r11, r12);
        PROPERTY_SETTER = new KotlinTarget("PROPERTY_SETTER", 10, "setter", r16, r17, r18);
        TYPE = new KotlinTarget("TYPE", 11, "type usage", false);
        EXPRESSION = new KotlinTarget("EXPRESSION", 12, "expression", false);
        FILE = new KotlinTarget("FILE", 13, "file", false);
        TYPEALIAS = new KotlinTarget("TYPEALIAS", 14, "typealias", false);
        TYPE_PROJECTION = new KotlinTarget("TYPE_PROJECTION", 15, "type projection", false);
        STAR_PROJECTION = new KotlinTarget("STAR_PROJECTION", 16, "star projection", false);
        PROPERTY_PARAMETER = new KotlinTarget("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
        CLASS_ONLY = new KotlinTarget("CLASS_ONLY", 18, "class", false);
        OBJECT = new KotlinTarget("OBJECT", 19, "object", false);
        STANDALONE_OBJECT = new KotlinTarget("STANDALONE_OBJECT", 20, "standalone object", false);
        COMPANION_OBJECT = new KotlinTarget("COMPANION_OBJECT", 21, "companion object", false);
        INTERFACE = new KotlinTarget("INTERFACE", 22, "interface", false);
        ENUM_CLASS = new KotlinTarget("ENUM_CLASS", 23, "enum class", false);
        ENUM_ENTRY = new KotlinTarget("ENUM_ENTRY", 24, "enum entry", false);
        LOCAL_CLASS = new KotlinTarget("LOCAL_CLASS", 25, "local class", false);
        LOCAL_FUNCTION = new KotlinTarget("LOCAL_FUNCTION", 26, "local function", false);
        MEMBER_FUNCTION = new KotlinTarget("MEMBER_FUNCTION", 27, "member function", false);
        TOP_LEVEL_FUNCTION = new KotlinTarget("TOP_LEVEL_FUNCTION", 28, "top level function", false);
        MEMBER_PROPERTY = new KotlinTarget("MEMBER_PROPERTY", 29, "member property", false);
        MEMBER_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("MEMBER_PROPERTY_WITH_BACKING_FIELD", 30, "member property with backing field", false);
        MEMBER_PROPERTY_WITH_DELEGATE = new KotlinTarget("MEMBER_PROPERTY_WITH_DELEGATE", 31, "member property with delegate", false);
        MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 32, "member property without backing field or delegate", false);
        TOP_LEVEL_PROPERTY = new KotlinTarget("TOP_LEVEL_PROPERTY", 33, "top level property", false);
        TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 34, "top level property with backing field", false);
        TOP_LEVEL_PROPERTY_WITH_DELEGATE = new KotlinTarget("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 35, "top level property with delegate", false);
        TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new KotlinTarget("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 36, "top level property without backing field or delegate", false);
        BACKING_FIELD = new KotlinTarget("BACKING_FIELD", 37, "backing field", r10, r11, r12);
        INITIALIZER = new KotlinTarget("INITIALIZER", 38, "initializer", false);
        DESTRUCTURING_DECLARATION = new KotlinTarget("DESTRUCTURING_DECLARATION", 39, "destructuring declaration", false);
        LAMBDA_EXPRESSION = new KotlinTarget("LAMBDA_EXPRESSION", 40, "lambda expression", false);
        ANONYMOUS_FUNCTION = new KotlinTarget("ANONYMOUS_FUNCTION", 41, "anonymous function", false);
        OBJECT_LITERAL = new KotlinTarget("OBJECT_LITERAL", 42, "object literal", false);
        $VALUES = $values();
        Companion = new Companion(null);
        map = new HashMap();
        KotlinTarget[] r13 = values();
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        KotlinTarget r19 = r13[r15];
        map.put(r19.name(), r19);
        r15 = r15 + 1;
        goto L3
    L5:
        KotlinTarget[] r20 = values();
        ArrayList r21 = new ArrayList();
        int r22 = r20.length;
    L6:
        if (r5 >= r22) goto L11;
        KotlinTarget r23 = r20[r5];
        if (r23.isDefault == false) goto L10;
        r21.add(r23);
    L10:
        r5 = r5 + 1;
        goto L6
    L11:
        DEFAULT_TARGET_SET = CollectionsKt.toSet(r21);
        ALL_TARGET_SET = ArraysKt.toSet(values());
        KotlinTarget r24 = ANNOTATION_CLASS;
        KotlinTarget r25 = CLASS;
        ANNOTATION_CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{r24, r25});
        LOCAL_CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{LOCAL_CLASS, r25});
        CLASS_LIST = CollectionsKt.listOf(new KotlinTarget[]{CLASS_ONLY, r25});
        KotlinTarget r26 = COMPANION_OBJECT;
        KotlinTarget r27 = OBJECT;
        COMPANION_OBJECT_LIST = CollectionsKt.listOf(new KotlinTarget[]{r26, r27, r25});
        OBJECT_LIST = CollectionsKt.listOf(new KotlinTarget[]{STANDALONE_OBJECT, r27, r25});
        INTERFACE_LIST = CollectionsKt.listOf(new KotlinTarget[]{INTERFACE, r25});
        ENUM_LIST = CollectionsKt.listOf(new KotlinTarget[]{ENUM_CLASS, r25});
        KotlinTarget r28 = ENUM_ENTRY;
        KotlinTarget r29 = PROPERTY;
        KotlinTarget r30 = FIELD;
        ENUM_ENTRY_LIST = CollectionsKt.listOf(new KotlinTarget[]{r28, r29, r30});
        KotlinTarget r31 = PROPERTY_SETTER;
        PROPERTY_SETTER_LIST = CollectionsKt.listOf(r31);
        KotlinTarget r32 = PROPERTY_GETTER;
        PROPERTY_GETTER_LIST = CollectionsKt.listOf(r32);
        FUNCTION_LIST = CollectionsKt.listOf(FUNCTION);
        KotlinTarget r33 = FILE;
        FILE_LIST = CollectionsKt.listOf(r33);
        AnnotationUseSiteTarget r34 = AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        KotlinTarget r35 = VALUE_PARAMETER;
        USE_SITE_MAPPING = MapsKt.mapOf(new Pair[]{TuplesKt.to(r34, r35), TuplesKt.to(AnnotationUseSiteTarget.FIELD, r30), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY, r29), TuplesKt.to(AnnotationUseSiteTarget.FILE, r33), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_GETTER, r32), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_SETTER, r31), TuplesKt.to(AnnotationUseSiteTarget.RECEIVER, r35), TuplesKt.to(AnnotationUseSiteTarget.SETTER_PARAMETER, r35), TuplesKt.to(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, r30)});
    }

    private KotlinTarget(String r5, int r10, String r11, boolean r12) {
        super(r5, r10);
        this.description = r11;
        this.isDefault = r12;
    }

    public static KotlinTarget valueOf(String r5) {
        return (KotlinTarget) Enum.valueOf(KotlinTarget.class, r5);
    }

    public static KotlinTarget[] values() {
        return (KotlinTarget[]) $VALUES.clone();
    }

    public /* synthetic */ KotlinTarget(String r5, int r10, String r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = true;
    L5:
        this(r5, r10, r11, r12);
    }
}
