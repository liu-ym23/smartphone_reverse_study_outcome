package kotlin.jvm.internal;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00103R \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR \u0010=\u001a\b\u0012\u0004\u0012\u00020>0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0097\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0014\u001a\u0004\bD\u0010E¨\u0006P"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Companion Companion = null;
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES = null;
    private static final HashMap<String, String> classFqNames = null;
    private static final HashMap<String, String> primitiveFqNames = null;
    private static final HashMap<String, String> primitiveWrapperFqNames = null;
    private static final Map<String, String> simpleNames = null;
    private final Class<?> jClass;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final String getClassQualifiedName(Class<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "jClass");
            String r1 = null;
            if (r3.isAnonymousClass() == false) goto L6;
            return null;
        L6:
            if (r3.isLocalClass() == false) goto L9;
            return null;
        L9:
            if (r3.isArray() == false) goto L17;
            Class<?> r4 = r3.getComponentType();
            if (r4.isPrimitive() == false) goto L15;
            String r5 = (String) ClassReference.access$getClassFqNames$cp().get(r4.getName());
            if (r5 == null) goto L15;
            r1 = r5.concat("Array");
        L15:
            if (r1 != null) goto L21;
            return "kotlin.Array";
        L21:
            return r1;
        L17:
            String r2 = (String) ClassReference.access$getClassFqNames$cp().get(r3.getName());
            if (r2 == null) goto L20;
            return r2;
        L20:
            return r3.getCanonicalName();
        }

        public final String getClassSimpleName(Class<?> r7) {
            Intrinsics.checkNotNullParameter(r7, "jClass");
            String r1 = null;
            if (r7.isAnonymousClass() == false) goto L6;
            return null;
        L6:
            if (r7.isLocalClass() == false) goto L18;
            String r0 = r7.getSimpleName();
            Method r2 = r7.getEnclosingMethod();
            if (r2 == null) goto L13;
            Intrinsics.checkNotNull(r0);
            String r3 = StringsKt.substringAfter$default(r0, r2.getName() + '$', null, 2, null);
            if (r3 == null) goto L13;
        L30:
            return r3;
        L13:
            Constructor<?> r8 = r7.getEnclosingConstructor();
            if (r8 == null) goto L16;
            Intrinsics.checkNotNull(r0);
            return StringsKt.substringAfter$default(r0, r8.getName() + '$', null, 2, null);
        L16:
            Intrinsics.checkNotNull(r0);
            return StringsKt.substringAfter$default(r0, '$', null, 2, null);
        L18:
            if (r7.isArray() == false) goto L26;
            Class<?> r9 = r7.getComponentType();
            r3 = "Array";
            if (r9.isPrimitive() == false) goto L24;
            String r10 = (String) ClassReference.access$getSimpleNames$cp().get(r9.getName());
            if (r10 == null) goto L24;
            r1 = r10.concat("Array");
        L24:
            if (r1 == null) goto L30;
            return r1;
        L26:
            String r4 = (String) ClassReference.access$getSimpleNames$cp().get(r7.getName());
            if (r4 == null) goto L29;
            return r4;
        L29:
            return r7.getSimpleName();
        }

        public final boolean isInstance(Object r3, Class<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "jClass");
            Map r0 = ClassReference.access$getFUNCTION_CLASSES$cp();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer r1 = (Integer) r0.get(r4);
            if (r1 == null) goto L7;
            return TypeIntrinsics.isFunctionOfArity(r3, r1.intValue());
        L7:
            if (r4.isPrimitive() == false) goto L10;
            r4 = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(r4));
        L10:
            return r4.isInstance(r3);
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new Companion(null);
        int r3 = 0;
        List r0 = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Object r5 = r1.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r2.add(TuplesKt.to((Class) r5, Integer.valueOf(r3)));
        r3 = r6;
        goto L4
    L9:
        FUNCTION_CLASSES = MapsKt.toMap(r2);
        HashMap<String, String> r4 = new HashMap();
        r4.put("boolean", "kotlin.Boolean");
        r4.put("char", "kotlin.Char");
        r4.put("byte", "kotlin.Byte");
        r4.put("short", "kotlin.Short");
        r4.put("int", "kotlin.Int");
        r4.put("float", "kotlin.Float");
        r4.put("long", "kotlin.Long");
        r4.put("double", "kotlin.Double");
        primitiveFqNames = r4;
        HashMap<String, String> r7 = new HashMap();
        r7.put("java.lang.Boolean", "kotlin.Boolean");
        r7.put("java.lang.Character", "kotlin.Char");
        r7.put("java.lang.Byte", "kotlin.Byte");
        r7.put("java.lang.Short", "kotlin.Short");
        r7.put("java.lang.Integer", "kotlin.Int");
        r7.put("java.lang.Float", "kotlin.Float");
        r7.put("java.lang.Long", "kotlin.Long");
        r7.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = r7;
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
        r8.putAll(r4);
        r8.putAll(r7);
        Iterator<T> r9 = r4.values().iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        String r10 = (String) r9.next();
        StringBuilder r11 = new StringBuilder("kotlin.jvm.internal.");
        Intrinsics.checkNotNull(r10);
        r11.append(StringsKt.substringAfterLast$default(r10, '.', null, 2, null));
        r11.append("CompanionObject");
        Pair r12 = TuplesKt.to(r11.toString(), r10 + ".Companion");
        r8.put(r12.getFirst(), r12.getSecond());
        goto L11
    L13:
        Iterator<Map.Entry<Class<? extends Function<?>>, Integer>> r13 = FUNCTION_CLASSES.entrySet().iterator();
    L15:
        if (r13.hasNext() == false) goto L17;
        Map.Entry<Class<? extends Function<?>>, Integer> r14 = r13.next();
        Class<? extends Function<?>> r15 = r14.getKey();
        int r16 = r14.getValue().intValue();
        r8.put(r15.getName(), "kotlin.Function" + r16);
        goto L15
    L17:
        classFqNames = r8;
        LinkedHashMap r17 = new LinkedHashMap(MapsKt.mapCapacity(r8.size()));
        Iterator r18 = r8.entrySet().iterator();
    L19:
        if (r18.hasNext() == false) goto L21;
        Map.Entry r19 = (Map.Entry) r18.next();
        r17.put(r19.getKey(), StringsKt.substringAfterLast$default((String) r19.getValue(), '.', null, 2, null));
        goto L19
    L21:
        simpleNames = r17;
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    public String getQualifiedName() {
        return Companion.getClassQualifiedName(getJClass());
    }

    public String getSimpleName() {
        return Companion.getClassSimpleName(getJClass());
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }

    public List<Annotation> getAnnotations() {
        error();
        throw new KotlinNothingValueException();
    }

    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw new KotlinNothingValueException();
    }

    public Collection<KCallable<?>> getMembers() {
        error();
        throw new KotlinNothingValueException();
    }

    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw new KotlinNothingValueException();
    }

    public Object getObjectInstance() {
        error();
        throw new KotlinNothingValueException();
    }

    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw new KotlinNothingValueException();
    }

    public List<KType> getSupertypes() {
        error();
        throw new KotlinNothingValueException();
    }

    public List<KTypeParameter> getTypeParameters() {
        error();
        throw new KotlinNothingValueException();
    }

    public KVisibility getVisibility() {
        error();
        throw new KotlinNothingValueException();
    }

    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public boolean isAbstract() {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isCompanion() {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isData() {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isFinal() {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isFun() {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isInner() {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isOpen() {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isSealed() {
        error();
        throw new KotlinNothingValueException();
    }

    public boolean isValue() {
        error();
        throw new KotlinNothingValueException();
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

    public Class<?> getJClass() {
        return this.jClass;
    }

    public ClassReference(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "jClass");
        this.jClass = r2;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ClassReference) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) r2)) == false) goto L7;
        return true;
    }

    public boolean isInstance(Object r3) {
        return Companion.isInstance(r3, getJClass());
    }
}
