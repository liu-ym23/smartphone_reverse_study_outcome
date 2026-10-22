package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001a+\u0010S\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\u001a!\u0010V\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010W\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010X\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a\u001c\u0010Y\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a-\u0010[\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\",\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"(\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\"$\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013\",\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\",\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"B\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\",\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\">\u0010#\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\",\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\"\u0010+\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010.\",\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001c\u00102\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00105\"\u001c\u00106\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00105\",\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"B\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\",\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\">\u0010@\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"6\u0010C\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\u0015\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010F\",\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\",\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030K0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\",\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020O*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010R¨\u0006\\"}, d2 = {"allSuperclasses", "", "Lkotlin/reflect/KClass;", "getAllSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "getAllSupertypes$annotations", "getAllSupertypes", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", ExifInterface.GPS_DIRECTION_TRUE, "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "defaultType", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "getFunctions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberProperties", "getMemberProperties$annotations", "getMemberProperties", "primaryConstructor", "getPrimaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", "base", "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@JvmName(name = "KClasses")
@SourceDebugExtension({"SMAP\nKClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClasses.kt\nkotlin/reflect/full/KClasses\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,281:1\n288#2,2:282\n288#2,2:284\n800#2,11:286\n800#2,11:297\n766#2:308\n857#2,2:309\n766#2:311\n857#2,2:312\n800#2,11:314\n766#2:325\n857#2,2:326\n766#2:328\n857#2,2:329\n766#2:331\n857#2,2:332\n766#2:334\n857#2,2:335\n766#2:337\n857#2,2:338\n766#2:340\n857#2,2:341\n766#2:343\n857#2,2:344\n1603#2,9:346\n1855#2:355\n1856#2:357\n1612#2:358\n1549#2:359\n1620#2,3:360\n661#2,4:363\n1726#2,3:367\n665#2,7:370\n1549#2:377\n1620#2,3:378\n1#3:356\n*S KotlinDebug\n*F\n+ 1 KClasses.kt\nkotlin/reflect/full/KClasses\n*L\n36#1:282,2\n47#1:284,2\n89#1:286,11\n96#1:297,11\n103#1:308\n103#1:309,2\n110#1:311\n110#1:312,2\n119#1:314,11\n126#1:325\n126#1:326,2\n133#1:328\n133#1:329,2\n141#1:331\n141#1:332,2\n148#1:334\n148#1:335,2\n155#1:337\n155#1:338,2\n162#1:340\n162#1:341,2\n169#1:343\n169#1:344,2\n184#1:346,9\n184#1:355\n184#1:357\n184#1:358\n223#1:359\n223#1:360,3\n276#1:363,4\n276#1:367,3\n276#1:370,7\n200#1:377\n200#1:378,3\n184#1:356\n*E\n"})
public final class KClasses {
    private static final Iterable _get_allSupertypes_$lambda$14(KType r10) {
        KClassifier r5 = r10.getClassifier();
        if ((r5 instanceof KClass) == false) goto L5;
        KClass r11 = (KClass) r5;
    L6:
        if (r11 == null) goto L21;
        List<KType> r12 = r11.getSupertypes();
        if (r10.getArguments().isEmpty() == true) goto L24;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        TypeSubstitutor r13 = TypeSubstitutor.create(((KTypeImpl) r10).getType());
        ArrayList r14 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r15 = r12.iterator();
    L12:
        if (r15.hasNext() == false) goto L19;
        KType r16 = (KType) r15.next();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        KotlinType r17 = r13.substitute(((KTypeImpl) r16).getType(), Variance.INVARIANT);
        if (r17 == null) goto L17;
        r14.add(new KTypeImpl(r17, null, 2, null));
        goto L12
    L17:
        throw new KotlinReflectionInternalError("Type substitution failed: " + r16 + " (" + r10 + ')');
    L19:
        return r14;
    L24:
        return r12;
    L21:
        throw new KotlinReflectionInternalError("Supertype not a class: " + r10);
    L5:
        r11 = null;
        goto L6
    }

    public static /* synthetic */ Iterable accessor$KClasses$lambda0(KType r5) {
        return _get_allSupertypes_$lambda$14(r5);
    }

    public static /* synthetic */ Iterable accessor$KClasses$lambda1(KProperty1 r5, KClass r10) {
        return isSubclassOf$lambda$16(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <T> T cast(KClass<T> r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isInstance(r10) == false) goto L7;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
        return r10;
    L7:
        throw new TypeCastException("Value cannot be cast to " + r5.getQualifiedName());
    }

    @SinceKotlin(version = "1.1")
    public static final <T> T createInstance(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r5 = r10.getConstructors().iterator();
        T r11 = null;
        boolean r12 = false;
        T r13 = null;
    L4:
        if (r5.hasNext() == false) goto L19;
        T r14 = r5.next();
        List<KParameter> r15 = ((KFunction) r14).getParameters();
        if (r15 != null) goto L8;
    L10:
        Iterator<T> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L16;
        if (((KParameter) r16.next()).isOptional() == true) goto L12;
    L16:
        if (r12 == true) goto L22;
        r12 = true;
        r13 = r14;
    L22:
        KFunction r17 = (KFunction) r11;
        if (r17 == null) goto L27;
        return (T) r17.callBy(MapsKt.emptyMap());
    L27:
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + r10);
    L8:
        if (r15.isEmpty() == false) goto L10;
    L19:
        if (r12 == false) goto L22;
        r11 = r13;
        goto L22
    }

    public static final Collection<KClass<?>> getAllSuperclasses(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KType> r10 = getAllSupertypes(r5);
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        KType r13 = (KType) r12.next();
        KClassifier r14 = r13.getClassifier();
        if ((r14 instanceof KClass) == false) goto L8;
        KClass r15 = (KClass) r14;
    L9:
        if (r15 == null) goto L12;
        r11.add(r15);
        goto L4
    L12:
        throw new KotlinReflectionInternalError("Supertype not a class: " + r13);
    L8:
        r15 = null;
        goto L9
    L13:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass r5) {
    }

    public static final Collection<KType> getAllSupertypes(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return (Collection) DFS.dfs(r5.getSupertypes(), KClasses$$Lambda$0.INSTANCE, new DFS.VisitedWithSet(), new KClasses$allSupertypes$2());
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getAllSupertypes$annotations(KClass r5) {
    }

    public static final KClass<?> getCompanionObject(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<T> r10 = r5.getNestedClasses().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r11 = r10.next();
        KClass r12 = (KClass) r11;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        if (((KClassImpl) r12).getDescriptor().isCompanionObject() == false) goto L4;
    L10:
        return (KClass) r11;
    L8:
        r11 = null;
        goto L10
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObject$annotations(KClass r5) {
    }

    public static final Object getCompanionObjectInstance(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KClass<?> r10 = getCompanionObject(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getObjectInstance();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass r5) {
    }

    public static final Collection<KFunction<?>> getDeclaredFunctions(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl.Data) ((KClassImpl) r5).getData().invoke()).getDeclaredMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if ((r13 instanceof KFunction) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass r5) {
    }

    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl.Data) ((KClassImpl) r5).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isExtension(r14) == false) goto L4;
        if ((r14 instanceof KFunction) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass r5) {
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl) r5).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        T r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isExtension(r14) == false) goto L4;
        if ((r14 instanceof KProperty2) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass r5) {
    }

    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl.Data) ((KClassImpl) r5).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isNotExtension(r14) == false) goto L4;
        if ((r14 instanceof KFunction) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass r5) {
    }

    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl) r5).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        T r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isNotExtension(r14) == false) goto L4;
        if ((r14 instanceof KProperty1) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass r5) {
    }

    public static final Collection<KCallable<?>> getDeclaredMembers(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((KClassImpl.Data) ((KClassImpl) r5).getData().invoke()).getDeclaredMembers();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDeclaredMembers$annotations(KClass r5) {
    }

    public static final KType getDefaultType(final KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new KTypeImpl(((KClassImpl) r5).getDescriptor().getDefaultType(), new KClasses$defaultType$1(r5));
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getDefaultType$annotations(KClass r5) {
    }

    public static final Collection<KFunction<?>> getFunctions(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallable<?>> r10 = r5.getMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if ((r13 instanceof KFunction) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getFunctions$annotations(KClass r5) {
    }

    public static final Collection<KFunction<?>> getMemberExtensionFunctions(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl.Data) ((KClassImpl) r5).getData().invoke()).getAllNonStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isExtension(r14) == false) goto L4;
        if ((r14 instanceof KFunction) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass r5) {
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl) r5).getData().invoke().getAllNonStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        T r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isExtension(r14) == false) goto L4;
        if ((r14 instanceof KProperty2) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass r5) {
    }

    public static final Collection<KFunction<?>> getMemberFunctions(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl.Data) ((KClassImpl) r5).getData().invoke()).getAllNonStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isNotExtension(r14) == false) goto L4;
        if ((r14 instanceof KFunction) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberFunctions$annotations(KClass r5) {
    }

    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl) r5).getData().invoke().getAllNonStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        T r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isNotExtension(r14) == false) goto L4;
        if ((r14 instanceof KProperty1) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getMemberProperties$annotations(KClass r5) {
    }

    public static final <T> KFunction<T> getPrimaryConstructor(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<T> r10 = ((KClassImpl) r5).getConstructors().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        T r11 = r10.next();
        KFunction r12 = (KFunction) r11;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
        FunctionDescriptor r13 = ((KFunctionImpl) r12).getDescriptor();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
        if (((ConstructorDescriptor) r13).isPrimary() == false) goto L4;
    L10:
        return (KFunction) r11;
    L8:
        r11 = null;
        goto L10
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass r5) {
    }

    public static final Collection<KFunction<?>> getStaticFunctions(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl.Data) ((KClassImpl) r5).getData().invoke()).getAllStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if ((r13 instanceof KFunction) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticFunctions$annotations(KClass r5) {
    }

    public static final Collection<KProperty0<?>> getStaticProperties(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Collection<KCallableImpl<?>> r10 = ((KClassImpl.Data) ((KClassImpl) r5).getData().invoke()).getAllStaticMembers();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        Object r13 = r12.next();
        KCallableImpl r14 = (KCallableImpl) r13;
        if (isNotExtension(r14) == false) goto L4;
        if ((r14 instanceof KProperty0) == false) goto L4;
        r11.add(r13);
        goto L4
    L10:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStaticProperties$annotations(KClass r5) {
    }

    public static final List<KClass<?>> getSuperclasses(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List<KType> r10 = r5.getSupertypes();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        KClassifier r13 = ((KType) r12.next()).getClassifier();
        if ((r13 instanceof KClass) == false) goto L8;
        KClass r14 = (KClass) r13;
    L9:
        if (r14 == null) goto L4;
        r11.add(r14);
        goto L4
    L8:
        r14 = null;
        goto L9
    L11:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getSuperclasses$annotations(KClass r5) {
    }

    private static final boolean isExtension(KCallableImpl<?> r5) {
        if (r5.getDescriptor().getExtensionReceiverParameter() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNotExtension(KCallableImpl<?> r5) {
        return !isExtension(r5);
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSubclassOf(KClass<?> r5, final KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "base");
        if (Intrinsics.areEqual(r5, r10) == true) goto L8;
        List r11 = CollectionsKt.listOf(r5);
        final AnonymousClass1 r12 = AnonymousClass1.INSTANCE;
        if (DFS.ifAny(r11, new KClasses$$Lambda$1(r12), new AnonymousClass2(r10)).booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    }

    private static final Iterable isSubclassOf$lambda$16(KProperty1 r5, KClass r10) {
        Intrinsics.checkNotNullParameter(r5, "$tmp0");
        return (Iterable) r5.invoke(r10);
    }

    @SinceKotlin(version = "1.1")
    public static final boolean isSuperclassOf(KClass<?> r5, KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "derived");
        return isSubclassOf(r10, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <T> T safeCast(KClass<T> r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isInstance(r10) == false) goto L5;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
        return r10;
    L5:
        return null;
    }
}
