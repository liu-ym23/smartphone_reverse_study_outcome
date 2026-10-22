package kotlin.jvm.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00103R \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR \u0010=\u001a\b\u0012\u0004\u0012\u00020>0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0097\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0014\u001a\u0004\bD\u0010E¨\u0006P"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", EventBody.KEY_VALUE, "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ClassReference implements ClassBasedDeclarationContainer, KClass<Object> {
    public static final Companion Companion = null;
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES = null;
    private static final HashMap<String, String> classFqNames = null;
    private static final HashMap<String, String> primitiveFqNames = null;
    private static final HashMap<String, String> primitiveWrapperFqNames = null;
    private static final Map<String, String> simpleNames = null;
    private final Class<?> jClass;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", EventBody.KEY_VALUE, "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String getClassQualifiedName(Class<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "jClass");
            String r0 = null;
            if (r3.isAnonymousClass() == false) goto L6;
            return null;
        L6:
            if (r3.isLocalClass() == false) goto L9;
            return null;
        L9:
            if (r3.isArray() == false) goto L17;
            Class<?> r2 = r3.getComponentType();
            if (r2.isPrimitive() == false) goto L15;
            String r4 = (String) ZeusTransformUtils.preCheckCast(ClassReference.access$getClassFqNames$cp().get(r2.getName()), String.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L15;
            r0 = r4 + "Array";
        L15:
            if (r0 != null) goto L21;
            return "kotlin.Array";
        L21:
            return r0;
        L17:
            String r1 = (String) ZeusTransformUtils.preCheckCast(ClassReference.access$getClassFqNames$cp().get(r3.getName()), String.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L20;
            return r1;
        L20:
            return r3.getCanonicalName();
        }

        public final String getClassSimpleName(Class<?> r6) {
            Intrinsics.checkNotNullParameter(r6, "jClass");
            String r1 = null;
            if (r6.isAnonymousClass() == false) goto L6;
        L28:
            return r1;
        L6:
            if (r6.isLocalClass() == false) goto L16;
            String r5 = r6.getSimpleName();
            Method r0 = r6.getEnclosingMethod();
            if (r0 == null) goto L11;
            Intrinsics.checkNotNull(r5);
            String r2 = StringsKt.substringAfter$default(r5, r0.getName() + Typography.dollar, null, 2, null);
            if (r2 == null) goto L11;
            return r2;
        L11:
            Constructor<?> r7 = r6.getEnclosingConstructor();
            Intrinsics.checkNotNull(r5);
            if (r7 == null) goto L31;
            return StringsKt.substringAfter$default(r5, r7.getName() + Typography.dollar, null, 2, null);
        L31:
            return StringsKt.substringAfter$default(r5, Typography.dollar, null, 2, null);
        L16:
            if (r6.isArray() == false) goto L24;
            Class<?> r8 = r6.getComponentType();
            if (r8.isPrimitive() == false) goto L22;
            String r9 = (String) ZeusTransformUtils.preCheckCast(ClassReference.access$getSimpleNames$cp().get(r8.getName()), String.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L22;
            r1 = r9 + "Array";
        L22:
            if (r1 != null) goto L28;
            return "Array";
        L24:
            String r3 = (String) ZeusTransformUtils.preCheckCast(ClassReference.access$getSimpleNames$cp().get(r6.getName()), String.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L27;
            return r3;
        L27:
            return r6.getSimpleName();
        }

        public final boolean isInstance(Object r3, Class<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "jClass");
            Map r2 = ClassReference.access$getFUNCTION_CLASSES$cp();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r2.get(r4), Integer.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L7;
            return TypeIntrinsics.isFunctionOfArity(r3, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue());
        L7:
            if (r4.isPrimitive() == false) goto L10;
            r4 = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(r4));
        L10:
            return ZeusTransformUtils.instanceOf(r4, r3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new Companion(null);
        int r3 = 0;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Object r5 = r1.next();
        int r7 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r2.add(TuplesKt.to((Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.memorydata.plugin"), Integer.valueOf(r3)));
        r3 = r7;
        goto L4
    L9:
        FUNCTION_CLASSES = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        HashMap<String, String> r4 = new HashMap();
        r4.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        r4.put("char", "kotlin.Char");
        r4.put("byte", "kotlin.Byte");
        r4.put("short", "kotlin.Short");
        r4.put("int", "kotlin.Int");
        r4.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        r4.put("long", "kotlin.Long");
        r4.put("double", "kotlin.Double");
        primitiveFqNames = r4;
        HashMap<String, String> r6 = new HashMap();
        r6.put("java.lang.Boolean", "kotlin.Boolean");
        r6.put("java.lang.Character", "kotlin.Char");
        r6.put("java.lang.Byte", "kotlin.Byte");
        r6.put("java.lang.Short", "kotlin.Short");
        r6.put("java.lang.Integer", "kotlin.Int");
        r6.put("java.lang.Float", "kotlin.Float");
        r6.put("java.lang.Long", "kotlin.Long");
        r6.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = r6;
        HashMap<String, String> r8 = new HashMap();
        r8.put("java.lang.Object", "kotlin.Any");
        r8.put("java.lang.String", "kotlin.String");
        r8.put("java.lang.CharSequence", "kotlin.CharSequence");
        r8.put("java.lang.Throwable", "kotlin.Throwable");
        r8.put("java.lang.Cloneable", "kotlin.Cloneable");
        r8.put("java.lang.Number", "kotlin.Number");
        r8.put("java.lang.Comparable", "kotlin.Comparable");
        r8.put("java.lang.Enum", "kotlin.Enum");
        r8.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        r8.put("java.lang.Iterable", "kotlin.collections.Iterable");
        r8.put("java.util.Iterator", "kotlin.collections.Iterator");
        r8.put("java.util.Collection", "kotlin.collections.Collection");
        r8.put("java.util.List", "kotlin.collections.List");
        r8.put("java.util.Set", "kotlin.collections.Set");
        r8.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        r8.put("java.util.Map", "kotlin.collections.Map");
        r8.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        r8.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        r8.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        r8.putAll((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        r8.putAll((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin"));
        Collection<String> r9 = r4.values();
        Intrinsics.checkNotNullExpressionValue(r9, "<get-values>(...)");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        Object r11 = r10.next();
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder().append("kotlin.jvm.internal.");
        Intrinsics.checkNotNull(r13);
        Pair r15 = TuplesKt.to(r14.append(StringsKt.substringAfterLast$default(r13, '.', null, 2, null)).append("CompanionObject").toString(), r13 + ".Companion");
        r12.put(r15.getFirst(), r15.getSecond());
        goto L11
    L13:
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<Class<? extends Function<?>>, Integer>> r17 = FUNCTION_CLASSES.entrySet().iterator();
    L15:
        if (r17.hasNext() == false) goto L17;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r8.put(((Class) ZeusTransformUtils.preCheckCast(r18.getKey(), Class.class, "com.obric.memorydata.plugin")).getName(), "kotlin.Function" + ((Number) ZeusTransformUtils.preCheckCast(r18.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L15
    L17:
        classFqNames = r8;
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r20 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r19.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r19.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r21.hasNext() == false) goto L21;
        Object r22 = r21.next();
        r20.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r22, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), StringsKt.substringAfterLast$default((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r22, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), String.class, "com.obric.memorydata.plugin"), '.', null, 2, null));
        goto L19
    L21:
        simpleNames = r20;
    }

    public ClassReference(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "jClass");
        this.jClass = r2;
    }

    public static final /* synthetic */ HashMap access$getClassFqNames$cp() {
        return classFqNames;
    }

    public static final /* synthetic */ Map access$getFUNCTION_CLASSES$cp() {
        return FUNCTION_CLASSES;
    }

    public static final /* synthetic */ Map access$getSimpleNames$cp() {
        return simpleNames;
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    public static /* synthetic */ void getSupertypes$annotations() {
    }

    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    public static /* synthetic */ void getVisibility$annotations() {
    }

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isFun$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public static /* synthetic */ void isValue$annotations() {
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ClassReference.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType((KClass) ZeusTransformUtils.preCheckCast(this, KClass.class, "com.obric.memorydata.plugin")), JvmClassMappingKt.getJavaObjectType((KClass) ZeusTransformUtils.preCheckCast(r3, KClass.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KDeclarationContainer, kotlin.reflect.KClass
    public Collection<KCallable<?>> getMembers() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public Object getObjectInstance() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return Companion.getClassQualifiedName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return Companion.getClassSimpleName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType((KClass) ZeusTransformUtils.preCheckCast(this, KClass.class, "com.obric.memorydata.plugin")).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object r2) {
        return Companion.isInstance(r2, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        error();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
