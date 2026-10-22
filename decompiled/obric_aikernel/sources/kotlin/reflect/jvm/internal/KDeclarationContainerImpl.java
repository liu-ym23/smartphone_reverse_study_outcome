package kotlin.reflect.jvm.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = null;
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = null;
    private static final Regex LOCAL_PROPERTY_SIGNATURE = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.access$getLOCAL_PROPERTY_SIGNATURE$cp();
        }
    }

    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final ReflectProperties.LazySoftVal moduleData$delegate;
        final /* synthetic */ KDeclarationContainerImpl this$0;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        }

        public Data(final KDeclarationContainerImpl r10) {
            this.this$0 = r10;
            this.moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$moduleData$2(r10));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RuntimeModuleData getModuleData() {
            T r10 = this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(r10, "<get-moduleData>(...)");
            return (RuntimeModuleData) r10;
        }
    }

    protected static final enum MemberBelonginess extends Enum<MemberBelonginess> {
        private static final /* synthetic */ MemberBelonginess[] $VALUES = null;
        public static final MemberBelonginess DECLARED = null;
        public static final MemberBelonginess INHERITED = null;

        private static final /* synthetic */ MemberBelonginess[] $values() {
            return new MemberBelonginess[]{DECLARED, INHERITED};
        }

        static {
            DECLARED = new MemberBelonginess("DECLARED", 0);
            INHERITED = new MemberBelonginess("INHERITED", 1);
            $VALUES = $values();
        }

        private MemberBelonginess(String r10, int r11) {
            super(r10, r11);
        }

        public static MemberBelonginess valueOf(String r10) {
            return (MemberBelonginess) Enum.valueOf(MemberBelonginess.class, r10);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[]) $VALUES.clone();
        }

        public final boolean accept(CallableMemberDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "member");
            boolean r11 = r10.getKind().isReal();
            if (this != DECLARED) goto L5;
            boolean r12 = true;
        L6:
            if (r11 != r12) goto L9;
            return true;
        L9:
            return false;
        L5:
            r12 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT_CONSTRUCTOR_MARKER = DefaultConstructorMarker.class;
        LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");
    }

    public KDeclarationContainerImpl() {
    }

    public static final /* synthetic */ Regex access$getLOCAL_PROPERTY_SIGNATURE$cp() {
        return LOCAL_PROPERTY_SIGNATURE;
    }

    private final void addParametersAndMasks(List<Class<?>> r10, String r11, boolean r12) {
        List<Class<?>> r13 = loadParameterTypes(r11);
        r10.addAll(r13);
        int r14 = ((r13.size() + 32) - 1) / 32;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        Class<?> r16 = Integer.TYPE;
        Intrinsics.checkNotNullExpressionValue(r16, "TYPE");
        r10.add(r16);
        r15 = r15 + 1;
        goto L3
    L5:
        if (r12 == false) goto L7;
        Class<?> r17 = DEFAULT_CONSTRUCTOR_MARKER;
        r10.remove(r17);
        Intrinsics.checkNotNullExpressionValue(r17, "DEFAULT_CONSTRUCTOR_MARKER");
    L8:
        r10.add(r17);
        return;
    L7:
        r17 = Object.class;
        goto L8
    }

    private final List<Class<?>> loadParameterTypes(String r10) {
        ArrayList r11 = new ArrayList();
        int r12 = 1;
    L4:
        if (r10.charAt(r12) == ')') goto L18;
        int r13 = r12;
    L7:
        if (r10.charAt(r13) != '[') goto L9;
        r13 = r13 + 1;
        goto L7
    L9:
        char r14 = r10.charAt(r13);
        if (StringsKt.contains$default("VZCBSIFJD", r14, false, 2, null) == false) goto L13;
        int r15 = r13 + 1;
    L15:
        r11.add(parseType(r10, r12, r15));
        r12 = r15;
        goto L4
    L13:
        if (r14 != 'L') goto L17;
        r15 = StringsKt.indexOf$default(r10, ';', r12, false, 4, null) + 1;
        goto L15
    L17:
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + r10);
    L18:
        return r11;
    }

    private final Class<?> loadReturnType(String r10) {
        return parseType(r10, StringsKt.indexOf$default(r10, ')', 0, false, 6, null) + 1, r10.length());
    }

    private final Method lookupMethod(Class<?> r11, String r12, Class<?>[] r13, Class<?> r14, boolean r15) {
        if (r15 == false) goto L5;
        r13[0] = r11;
    L5:
        Method r10 = tryGetMethod(r11, r12, r13, r14);
        if (r10 == null) goto L8;
        return r10;
    L8:
        Class<? super Object> r16 = r11.getSuperclass();
        if (r16 == null) goto L13;
        Method r17 = lookupMethod(r16, r12, r13, r14, r15);
        if (r17 == null) goto L13;
        return r17;
    L13:
        Class<?>[] r18 = r11.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(r18, "interfaces");
        int r19 = r18.length;
        int r20 = 0;
    L14:
        if (r20 >= r19) goto L25;
        Class<?> r21 = r18[r20];
        Intrinsics.checkNotNullExpressionValue(r21, "superInterface");
        Method r22 = lookupMethod(r21, r12, r13, r14, r15);
        if (r22 != null) goto L17;
        if (r15 == false) goto L24;
        Class<?> r23 = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(r21), r21.getName() + "$DefaultImpls");
        if (r23 == null) goto L24;
        r13[0] = r21;
        Method r24 = tryGetMethod(r23, r12, r13, r14);
        if (r24 == null) goto L24;
        return r24;
    L24:
        r20 = r20 + 1;
        goto L14
    L17:
        return r22;
    L25:
        return null;
    }

    private final Class<?> parseType(String r10, int r11, int r12) {
        char r13 = r10.charAt(r11);
        if (r13 != 'L') goto L7;
        ClassLoader r14 = ReflectClassUtilKt.getSafeClassLoader(getJClass());
        String r15 = r10.substring(r11 + 1, r12 - 1);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String…ing(startIndex, endIndex)");
        Class<?> r16 = r14.loadClass(StringsKt.replace$default(r15, '/', '.', false, 4, null));
        String r17 = "jClass.safeClassLoader.l…d - 1).replace('/', '.'))";
    L5:
        Intrinsics.checkNotNullExpressionValue(r16, r17);
        return r16;
    L7:
        if (r13 != '[') goto L10;
        return UtilKt.createArrayType(parseType(r10, r11 + 1, r12));
    L10:
        if (r13 != 'V') goto L13;
        r16 = Void.TYPE;
        r17 = "TYPE";
        goto L5
    L13:
        if (r13 != 'Z') goto L16;
        return Boolean.TYPE;
    L16:
        if (r13 != 'C') goto L19;
        return Character.TYPE;
    L19:
        if (r13 != 'B') goto L22;
        return Byte.TYPE;
    L22:
        if (r13 != 'S') goto L25;
        return Short.TYPE;
    L25:
        if (r13 != 'I') goto L28;
        return Integer.TYPE;
    L28:
        if (r13 != 'F') goto L31;
        return Float.TYPE;
    L31:
        if (r13 != 'J') goto L34;
        return Long.TYPE;
    L34:
        if (r13 != 'D') goto L38;
        return Double.TYPE;
    L38:
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + r10);
    }

    private final Constructor<?> tryGetConstructor(Class<?> r10, List<? extends Class<?>> r11) {
        Object[] r12 = r11.toArray(new Class[0]);     // Catch: NoSuchMethodException -> L5
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: NoSuchMethodException -> L5
        Class[] r13 = (Class[]) r12;     // Catch: NoSuchMethodException -> L5
        return r10.getDeclaredConstructor((Class[]) Arrays.copyOf(r13, r13.length));
    L5:
        return null;
    }

    private final Method tryGetMethod(Class<?> r10, String r11, Class<?>[] r12, Class<?> r13) {
        Method r14 = r10.getDeclaredMethod(r11, (Class[]) Arrays.copyOf(r12, r12.length));     // Catch: NoSuchMethodException -> L20
        if (Intrinsics.areEqual(r14.getReturnType(), r13) == true) goto L19;
        Method[] r15 = r10.getDeclaredMethods();     // Catch: NoSuchMethodException -> L20
        Intrinsics.checkNotNullExpressionValue(r15, "declaredMethods");     // Catch: NoSuchMethodException -> L20
        int r16 = r15.length;     // Catch: NoSuchMethodException -> L20
        int r17 = 0;
    L7:
        if (r17 >= r16) goto L27;
        Method r18 = r15[r17];     // Catch: NoSuchMethodException -> L20
        if (Intrinsics.areEqual(r18.getName(), r11) == true) goto L11;
    L15:
        boolean r19 = false;
    L16:
        if (r19 == true) goto L25;
        r17 = r17 + 1;
        goto L7
    L25:
        return r18;
    L11:
        if (Intrinsics.areEqual(r18.getReturnType(), r13) == false) goto L15;
        if (Arrays.equals(r18.getParameterTypes(), r12) == false) goto L15;
        r19 = true;
        goto L16
    L27:
        return null;
    L19:
        return r14;
    L26:
        return null;
    }

    public final Constructor<?> findConstructorBySignature(String r10) {
        Intrinsics.checkNotNullParameter(r10, "desc");
        return tryGetConstructor(getJClass(), loadParameterTypes(r10));
    }

    public final Constructor<?> findDefaultConstructor(String r10) {
        Intrinsics.checkNotNullParameter(r10, "desc");
        Class<?> r11 = getJClass();
        ArrayList r12 = new ArrayList();
        addParametersAndMasks(r12, r10, true);
        Unit r13 = Unit.INSTANCE;
        return tryGetConstructor(r11, r12);
    }

    public final Method findDefaultMethod(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "desc");
        if (Intrinsics.areEqual(r10, "<init>") == false) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();
        if (r12 == false) goto L9;
        r13.add(getJClass());
    L9:
        addParametersAndMasks(r13, r11, false);
        Class<?> r14 = getMethodOwner();
        String r15 = r10 + "$default";
        Object[] r16 = r13.toArray(new Class[0]);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return lookupMethod(r14, r15, (Class[]) r16, loadReturnType(r11), r12);
    }

    public final FunctionDescriptor findFunctionDescriptor(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r13, "signature");
        if (Intrinsics.areEqual(r12, "<init>") == false) goto L5;
        Collection<FunctionDescriptor> r10 = CollectionsKt.toList(getConstructorDescriptors());
    L6:
        Collection<FunctionDescriptor> r11 = r10;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r11.iterator();
    L8:
        if (r15.hasNext() == false) goto L12;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) r16).asString(), r13) == false) goto L8;
        r14.add(r16);
        goto L8
    L12:
        boolean r17 = true;
        if (r14.size() == 1) goto L24;
        String r18 = CollectionsKt.joinToString$default(r11, "\n", null, null, 0, null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30, null);
        StringBuilder r19 = new StringBuilder();
        r19.append("Function '");
        r19.append(r12);
        r19.append("' (JVM signature: ");
        r19.append(r13);
        r19.append(") not resolved in ");
        r19.append(this);
        r19.append(':');
        if (r18.length() == 0) goto L18;
        r17 = false;
    L18:
        if (r17 == false) goto L20;
        String r110 = " no members found";
    L21:
        r19.append(r110);
        throw new KotlinReflectionInternalError(r19.toString());
    L20:
        r110 = '\n' + r18;
        goto L21
    L24:
        return (FunctionDescriptor) CollectionsKt.single(r14);
    L5:
        Name r20 = Name.identifier(r12);
        Intrinsics.checkNotNullExpressionValue(r20, "identifier(name)");
        r10 = getFunctions(r20);
        goto L6
    }

    public final Method findMethodBySignature(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "desc");
        if (Intrinsics.areEqual(r10, "<init>") == false) goto L5;
        return null;
    L5:
        Object[] r12 = loadParameterTypes(r11).toArray(new Class[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Class<?>[] r13 = (Class[]) r12;
        Class<?> r14 = loadReturnType(r11);
        Method r15 = lookupMethod(getMethodOwner(), r10, r13, r14, false);
        if (r15 == null) goto L9;
        return r15;
    L9:
        if (getMethodOwner().isInterface() == false) goto L13;
        Method r16 = lookupMethod(Object.class, r10, r13, r14, false);
        if (r16 == null) goto L13;
        return r16;
    L13:
        return null;
    }

    public final PropertyDescriptor findPropertyDescriptor(String r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r21, "signature");
        MatchResult r10 = LOCAL_PROPERTY_SIGNATURE.matchEntire(r21);
        boolean r11 = true;
        if (r10 == null) goto L9;
        String r12 = r10.getDestructured().getMatch().getGroupValues().get(1);
        PropertyDescriptor r13 = getLocalProperty(Integer.parseInt(r12));
        if (r13 == null) goto L8;
        return r13;
    L8:
        throw new KotlinReflectionInternalError("Local property #" + r12 + " not found in " + getJClass());
    L9:
        Name r14 = Name.identifier(r20);
        Intrinsics.checkNotNullExpressionValue(r14, "identifier(name)");
        Collection<PropertyDescriptor> r15 = getProperties(r14);
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L11:
        if (r17.hasNext() == false) goto L16;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) r18).asString(), r21) == false) goto L11;
        r16.add(r18);
        goto L11
    L16:
        if (r16.isEmpty() == true) goto L42;
        if (r16.size() == 1) goto L40;
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r22 = r16.iterator();
    L21:
        if (r22.hasNext() == false) goto L26;
        Object r110 = r22.next();
        DescriptorVisibility r111 = ((PropertyDescriptor) r110).getVisibility();
        Object r112 = r19.get(r111);
        if (r112 != null) goto L25;
        r112 = new ArrayList();
        r19.put(r111, r112);
    L25:
        ((List) r112).add(r110);
        goto L21
    L26:
        Collection r23 = MapsKt.toSortedMap(r19, KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2.INSTANCE).values();
        Intrinsics.checkNotNullExpressionValue(r23, "properties\n             …\n                }.values");
        List r24 = (List) CollectionsKt.last(r23);
        if (r24.size() != 1) goto L31;
        Intrinsics.checkNotNullExpressionValue(r24, "mostVisibleProperties");
        Object r25 = CollectionsKt.first(r24);
    L30:
        return (PropertyDescriptor) r25;
    L31:
        Name r26 = Name.identifier(r20);
        Intrinsics.checkNotNullExpressionValue(r26, "identifier(name)");
        String r27 = CollectionsKt.joinToString$default(getProperties(r26), "\n", null, null, 0, null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30, null);
        StringBuilder r28 = new StringBuilder();
        r28.append("Property '");
        r28.append(r20);
        r28.append("' (JVM signature: ");
        r28.append(r21);
        r28.append(") not resolved in ");
        r28.append(this);
        r28.append(':');
        if (r27.length() == 0) goto L35;
        r11 = false;
    L35:
        if (r11 == false) goto L37;
        String r29 = " no members found";
    L38:
        r28.append(r29);
        throw new KotlinReflectionInternalError(r28.toString());
    L37:
        r29 = '\n' + r27;
        goto L38
    L40:
        r25 = CollectionsKt.single(r16);
        goto L30
    L42:
        throw new KotlinReflectionInternalError("Property '" + r20 + "' (JVM signature: " + r21 + ") not resolved in " + this);
    }

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name r10);

    public abstract PropertyDescriptor getLocalProperty(int r10);

    protected final Collection<KCallableImpl<?>> getMembers(MemberScope r10, MemberBelonginess r11) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "belonginess");
        CreateKCallableVisitor r12 = new KDeclarationContainerImpl$getMembers$visitor$1(this);
        Collection r13 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r10, null, null, 3, null);
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L16;
        DeclarationDescriptor r16 = (DeclarationDescriptor) r15.next();
        if ((r16 instanceof CallableMemberDescriptor) == false) goto L12;
        CallableMemberDescriptor r17 = (CallableMemberDescriptor) r16;
        if (Intrinsics.areEqual(r17.getVisibility(), DescriptorVisibilities.INVISIBLE_FAKE) == true) goto L12;
        if (r11.accept(r17) == false) goto L12;
        KCallableImpl r18 = (KCallableImpl) r16.accept(r12, Unit.INSTANCE);
    L13:
        if (r18 == null) goto L4;
        r14.add(r18);
    L12:
        r18 = null;
        goto L13
    L16:
        return CollectionsKt.toList(r14);
    }

    protected Class<?> getMethodOwner() {
        Class<?> r10 = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (r10 == null) goto L5;
        return r10;
    L5:
        return getJClass();
    }

    public abstract Collection<PropertyDescriptor> getProperties(Name r10);
}
