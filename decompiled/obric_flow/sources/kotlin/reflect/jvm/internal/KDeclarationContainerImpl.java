package kotlin.reflect.jvm.internal;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
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
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\b \u0018\u0000 <2\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u0012\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020%H&J\"\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0\u00042\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0004J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0019\u001a\u00020\"H&J\u001a\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010/\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00100\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%H\u0002JE\u00103\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0002\u00108J(\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015*\u0006\u0012\u0002\b\u00030\t2\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0.H\u0002J=\u0010:\u001a\u0004\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0010\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t052\n\u00106\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0002\u0010;R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKDeclarationContainerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KDeclarationContainerImpl.kt\nkotlin/reflect/jvm/internal/KDeclarationContainerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,296:1\n1603#2,9:297\n1855#2:306\n1856#2:308\n1612#2:309\n766#2:310\n857#2,2:311\n1477#2:313\n1502#2,3:314\n1505#2,3:324\n766#2:327\n857#2,2:328\n1#3:307\n1#3:330\n361#4,7:317\n1282#5,2:331\n37#6,2:333\n37#6,2:335\n37#6,2:337\n*S KotlinDebug\n*F\n+ 1 KDeclarationContainerImpl.kt\nkotlin/reflect/jvm/internal/KDeclarationContainerImpl\n*L\n56#1:297,9\n56#1:306\n56#1:308\n56#1:309\n81#1:310\n81#1:311,2\n101#1:313\n101#1:314,3\n101#1:324,3\n123#1:327\n123#1:328,2\n56#1:307\n101#1:317,7\n179#1:331,2\n189#1:333,2\n197#1:335,2\n221#1:337,2\n*E\n"})
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = null;
    private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = null;
    private static final Regex LOCAL_PROPERTY_SIGNATURE = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.access$getLOCAL_PROPERTY_SIGNATURE$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public abstract class Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
        private final ReflectProperties.LazySoftVal moduleData$delegate;
        final /* synthetic */ KDeclarationContainerImpl this$0;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        }

        public Data(final KDeclarationContainerImpl r5) {
            this.this$0 = r5;
            this.moduleData$delegate = ReflectProperties.lazySoft(new KDeclarationContainerImpl$Data$moduleData$2(r5));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final RuntimeModuleData getModuleData() {
            return (RuntimeModuleData) this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum MemberBelonginess extends Enum<MemberBelonginess> {
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

        private MemberBelonginess(String r5, int r10) {
            super(r5, r10);
        }

        public static MemberBelonginess valueOf(String r5) {
            return (MemberBelonginess) Enum.valueOf(MemberBelonginess.class, r5);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[]) $VALUES.clone();
        }

        public final boolean accept(CallableMemberDescriptor r5) {
            Intrinsics.checkNotNullParameter(r5, "member");
            boolean r10 = r5.getKind().isReal();
            if (this != DECLARED) goto L5;
            boolean r11 = true;
        L6:
            if (r10 == r11) goto L8;
            return false;
        L8:
            return true;
        L5:
            r11 = false;
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

    public static /* synthetic */ int accessor$KDeclarationContainerImpl$lambda0(Function2 r5, Object r10, Object r11) {
        return findPropertyDescriptor$lambda$3(r5, r10, r11);
    }

    private final void addParametersAndMasks(List<Class<?>> r5, String r10, boolean r11) {
        List<Class<?>> r12 = loadParameterTypes(r10);
        r5.addAll(r12);
        int r13 = (r12.size() + 31) / 32;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r5.add(Integer.TYPE);
        r14 = r14 + 1;
        goto L3
    L5:
        if (r11 == false) goto L7;
        Class<?> r15 = DEFAULT_CONSTRUCTOR_MARKER;
        r5.remove(r15);
        r5.add(r15);
        return;
    L7:
        r5.add(Object.class);
    }

    private static final int findPropertyDescriptor$lambda$3(Function2 r5, Object r10, Object r11) {
        Intrinsics.checkNotNullParameter(r5, "$tmp0");
        return ((Number) r5.mo2invoke(r10, r11)).intValue();
    }

    private final List<Class<?>> loadParameterTypes(String r10) {
        ArrayList r5 = new ArrayList();
        int r11 = 1;
    L4:
        if (r10.charAt(r11) == ')') goto L18;
        int r12 = r11;
    L7:
        if (r10.charAt(r12) != '[') goto L9;
        r12 = r12 + 1;
        goto L7
    L9:
        char r13 = r10.charAt(r12);
        if (StringsKt.f("VZCBSIFJD", r13) == false) goto L13;
        int r14 = r12 + 1;
    L15:
        r5.add(parseType(r10, r11, r14));
        r11 = r14;
        goto L4
    L13:
        if (r13 != 'L') goto L17;
        r14 = StringsKt.q(r10, ';', r11, 4) + 1;
        goto L15
    L17:
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: ".concat(r10));
    L18:
        return r5;
    }

    private final Class<?> loadReturnType(String r5) {
        return parseType(r5, StringsKt.q(r5, ')', 0, 6) + 1, r5.length());
    }

    private final Method lookupMethod(Class<?> r11, String r12, Class<?>[] r13, Class<?> r14, boolean r15) {
        if (r15 == false) goto L5;
        r13[0] = r11;
    L5:
        Method r5 = tryGetMethod(r11, r12, r13, r14);
        if (r5 == null) goto L8;
        return r5;
    L8:
        Class<? super Object> r10 = r11.getSuperclass();
        if (r10 == null) goto L13;
        Method r16 = lookupMethod(r10, r12, r13, r14, r15);
        if (r16 == null) goto L13;
        return r16;
    L13:
        Class<?>[] r17 = r11.getInterfaces();
        int r18 = r17.length;
        int r19 = 0;
    L14:
        if (r19 >= r18) goto L25;
        Class<?> r20 = r17[r19];
        Method r21 = lookupMethod(r20, r12, r13, r14, r15);
        if (r21 != null) goto L17;
        if (r15 == false) goto L24;
        Class<?> r22 = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(r20), r20.getName().concat("$DefaultImpls"));
        if (r22 == null) goto L24;
        r13[0] = r20;
        Method r23 = tryGetMethod(r22, r12, r13, r14);
        if (r23 == null) goto L24;
        return r23;
    L24:
        r19 = r19 + 1;
        goto L14
    L17:
        return r21;
    L25:
        return null;
    }

    private final Class<?> parseType(String r5, int r10, int r11) {
        char r12 = r5.charAt(r10);
        if (r12 != 'L') goto L6;
        return ReflectClassUtilKt.getSafeClassLoader(getJClass()).loadClass(StringsKt.E(r5.substring(r10 + 1, r11 - 1), '/', '.'));
    L6:
        if (r12 != '[') goto L9;
        return UtilKt.createArrayType(parseType(r5, r10 + 1, r11));
    L9:
        if (r12 != 'V') goto L12;
        return Void.TYPE;
    L12:
        if (r12 != 'Z') goto L15;
        return Boolean.TYPE;
    L15:
        if (r12 != 'C') goto L18;
        return Character.TYPE;
    L18:
        if (r12 != 'B') goto L21;
        return Byte.TYPE;
    L21:
        if (r12 != 'S') goto L24;
        return Short.TYPE;
    L24:
        if (r12 != 'I') goto L27;
        return Integer.TYPE;
    L27:
        if (r12 != 'F') goto L30;
        return Float.TYPE;
    L30:
        if (r12 != 'J') goto L33;
        return Long.TYPE;
    L33:
        if (r12 != 'D') goto L37;
        return Double.TYPE;
    L37:
        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: ".concat(r5));
    }

    private final Constructor<?> tryGetConstructor(Class<?> r5, List<? extends Class<?>> r10) {
        Class[] r11 = (Class[]) r10.toArray(new Class[0]);     // Catch: NoSuchMethodException -> L5
        return r5.getDeclaredConstructor((Class[]) Arrays.copyOf(r11, r11.length));
    L5:
        return null;
    }

    private final Method tryGetMethod(Class<?> r5, String r10, Class<?>[] r11, Class<?> r12) {
        Method r13 = r5.getDeclaredMethod(r10, (Class[]) Arrays.copyOf(r11, r11.length));     // Catch: NoSuchMethodException -> L17
        if (Intrinsics.areEqual(r13.getReturnType(), r12) == true) goto L16;
        Method[] r14 = r5.getDeclaredMethods();     // Catch: NoSuchMethodException -> L17
        int r15 = r14.length;     // Catch: NoSuchMethodException -> L17
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L27;
        Method r17 = r14[r16];     // Catch: NoSuchMethodException -> L17
        if (Intrinsics.areEqual(r17.getName(), r10) == false) goto L15;
        if (Intrinsics.areEqual(r17.getReturnType(), r12) == false) goto L15;
        if (Arrays.equals(r17.getParameterTypes(), r11) == false) goto L15;
        return r17;
    L15:
        r16 = r16 + 1;
        goto L7
    L27:
        return null;
    L16:
        return r13;
    L26:
        return null;
    }

    public final Constructor<?> findConstructorBySignature(String r5) {
        Intrinsics.checkNotNullParameter(r5, "desc");
        return tryGetConstructor(getJClass(), loadParameterTypes(r5));
    }

    public final Constructor<?> findDefaultConstructor(String r5) {
        Intrinsics.checkNotNullParameter(r5, "desc");
        Class<?> r10 = getJClass();
        ArrayList r11 = new ArrayList();
        addParametersAndMasks(r11, r5, true);
        Unit r12 = Unit.INSTANCE;
        return tryGetConstructor(r10, r11);
    }

    public final Method findDefaultMethod(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "desc");
        if (Intrinsics.areEqual(r10, "<init>") == false) goto L6;
        return null;
    L6:
        ArrayList r5 = new ArrayList();
        if (r12 == false) goto L9;
        r5.add(getJClass());
    L9:
        addParametersAndMasks(r5, r11, false);
        return lookupMethod(getMethodOwner(), j0.j(r10, "$default"), (Class[]) r5.toArray(new Class[0]), loadReturnType(r11), r12);
    }

    public final FunctionDescriptor findFunctionDescriptor(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "signature");
        if (Intrinsics.areEqual(r10, "<init>") == false) goto L5;
        Collection<FunctionDescriptor> r5 = CollectionsKt.toList(getConstructorDescriptors());
    L6:
        Collection<FunctionDescriptor> r12 = r5;
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L13;
        Object r15 = r14.next();
        RuntimeTypeMapper r16 = RuntimeTypeMapper.INSTANCE;
        if (Intrinsics.areEqual(r16.mapSignature((FunctionDescriptor) r15).asString(), r11) == false) goto L8;
        r13.add(r15);
        goto L8
    L13:
        if (r13.size() == 1) goto L21;
        String r17 = CollectionsKt.q(r12, "\n", null, null, 0, null, KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1.INSTANCE, 30);
        StringBuilder r18 = a.y("Function '", r10, "' (JVM signature: ", r11, ") not resolved in ");
        r18.append(this);
        r18.append(':');
        if (r17.length() != 0) goto L17;
        String r19 = " no members found";
    L18:
        r18.append(r19);
        throw new KotlinReflectionInternalError(r18.toString());
    L17:
        r19 = "\n".concat(r17);
        goto L18
    L21:
        return (FunctionDescriptor) CollectionsKt.single(r13);
    L5:
        r5 = getFunctions(Name.identifier(r10));
        goto L6
    }

    public final Method findMethodBySignature(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "desc");
        if (Intrinsics.areEqual(r10, "<init>") == false) goto L5;
        return null;
    L5:
        Class<?>[] r5 = (Class[]) loadParameterTypes(r11).toArray(new Class[0]);
        Class<?> r12 = loadReturnType(r11);
        Method r13 = lookupMethod(getMethodOwner(), r10, r5, r12, false);
        if (r13 == null) goto L9;
        return r13;
    L9:
        if (getMethodOwner().isInterface() == false) goto L13;
        Method r14 = lookupMethod(Object.class, r10, r5, r12, false);
        if (r14 == null) goto L13;
        return r14;
    L13:
        return null;
    }

    public final PropertyDescriptor findPropertyDescriptor(String r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "name");
        Intrinsics.checkNotNullParameter(r19, "signature");
        MatchResult r5 = LOCAL_PROPERTY_SIGNATURE.matchEntire(r19);
        if (r5 == null) goto L9;
        String r10 = r5.getDestructured().getMatch().getGroupValues().get(1);
        PropertyDescriptor r11 = getLocalProperty(Integer.parseInt(r10));
        if (r11 == null) goto L7;
        return r11;
    L7:
        StringBuilder r12 = j0.x("Local property #", r10, " not found in ");
        r12.append(getJClass());
        throw new KotlinReflectionInternalError(r12.toString());
    L9:
        Collection<PropertyDescriptor> r13 = getProperties(Name.identifier(r18));
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L11:
        if (r15.hasNext() == false) goto L16;
        Object r16 = r15.next();
        RuntimeTypeMapper r17 = RuntimeTypeMapper.INSTANCE;
        if (Intrinsics.areEqual(r17.mapPropertySignature((PropertyDescriptor) r16).asString(), r19) == false) goto L11;
        r14.add(r16);
        goto L11
    L16:
        if (r14.isEmpty() == false) goto L18;
        StringBuilder r20 = a.y("Property '", r18, "' (JVM signature: ", r19, ") not resolved in ");
        r20.append(this);
        throw new KotlinReflectionInternalError(r20.toString());
    L18:
        if (r14.size() == 1) goto L37;
        LinkedHashMap r21 = new LinkedHashMap();
        Iterator r22 = r14.iterator();
    L21:
        if (r22.hasNext() == false) goto L26;
        Object r23 = r22.next();
        DescriptorVisibility r110 = ((PropertyDescriptor) r23).getVisibility();
        Object r111 = r21.get(r110);
        if (r111 != null) goto L25;
        r111 = new ArrayList();
        r21.put(r110, r111);
    L25:
        ((List) r111).add(r23);
        goto L21
    L26:
        final KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2 r24 = KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2.INSTANCE;
        List r25 = (List) CollectionsKt.last(MapsKt.e(r21, new KDeclarationContainerImpl$$Lambda$0(r24)).values());
        if (r25.size() == 1) goto L29;
        String r26 = CollectionsKt.q(getProperties(Name.identifier(r18)), "\n", null, null, 0, null, KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1.INSTANCE, 30);
        StringBuilder r27 = a.y("Property '", r18, "' (JVM signature: ", r19, ") not resolved in ");
        r27.append(this);
        r27.append(':');
        if (r26.length() != 0) goto L33;
        String r28 = " no members found";
    L34:
        r27.append(r28);
        throw new KotlinReflectionInternalError(r27.toString());
    L33:
        r28 = "\n".concat(r26);
        goto L34
    L29:
        return (PropertyDescriptor) CollectionsKt.first(r25);
    L37:
        return (PropertyDescriptor) CollectionsKt.single(r14);
    }

    public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();

    public abstract Collection<FunctionDescriptor> getFunctions(Name r5);

    public abstract PropertyDescriptor getLocalProperty(int r5);

    public final Collection<KCallableImpl<?>> getMembers(MemberScope r10, MemberBelonginess r11) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "belonginess");
        CreateKCallableVisitor r5 = new KDeclarationContainerImpl$getMembers$visitor$1(this);
        Collection r12 = ResolutionScope.DefaultImpls.getContributedDescriptors$default(r10, null, null, 3, null);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L16;
        DeclarationDescriptor r15 = (DeclarationDescriptor) r14.next();
        if ((r15 instanceof CallableMemberDescriptor) == false) goto L12;
        CallableMemberDescriptor r16 = (CallableMemberDescriptor) r15;
        if (Intrinsics.areEqual(r16.getVisibility(), DescriptorVisibilities.INVISIBLE_FAKE) == true) goto L12;
        if (r11.accept(r16) == false) goto L12;
        KCallableImpl r17 = (KCallableImpl) r15.accept(r5, Unit.INSTANCE);
    L13:
        if (r17 == null) goto L4;
        r13.add(r17);
    L12:
        r17 = null;
        goto L13
    L16:
        return CollectionsKt.toList(r13);
    }

    public Class<?> getMethodOwner() {
        Class<?> r5 = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (r5 == null) goto L5;
        return r5;
    L5:
        return getJClass();
    }

    public abstract Collection<PropertyDescriptor> getProperties(Name r5);
}
