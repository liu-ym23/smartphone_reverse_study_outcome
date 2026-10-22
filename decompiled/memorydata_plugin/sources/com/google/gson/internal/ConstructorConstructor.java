package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> r3, boolean r4, List<ReflectionAccessFilter> r5) {
        Map<Type, InstanceCreator<?>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List<ReflectionAccessFilter> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.instanceCreators = r6;
        this.useJdkUnsafe = r4;
        this.reflectionFilters = r7;
    }

    static String checkInstantiable(Class<?> r2) {
        int r0 = r2.getModifiers();
        if (Modifier.isInterface(r0) == false) goto L8;
        StringBuilder r1 = new StringBuilder();
        String r3 = "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
    L6:
        return r1.append(r3).append(r2.getName()).toString();
    L8:
        if (Modifier.isAbstract(r0) == false) goto L10;
        r1 = new StringBuilder();
        r3 = "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ";
        goto L6
    L10:
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> r4, ReflectionAccessFilter.FilterResult r5) {
        if (Modifier.isAbstract(r4.getModifiers()) == false) goto L5;
        return null;
    L5:
        boolean r0 = false;
        final Constructor<? super T> r2 = r4.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L27
        if (r5 != ReflectionAccessFilter.FilterResult.ALLOW) goto L10;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L20;
        final String r6 = "Unable to invoke no-args constructor of " + r4 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
        return new AnonymousClass7(r6);
    L20:
        if (r5 != ReflectionAccessFilter.FilterResult.ALLOW) goto L26;
        final String r7 = ReflectionHelper.tryMakeAccessible(r2);
        if (r7 == null) goto L26;
        return new AnonymousClass8(r7);
    L26:
        return new AnonymousClass9(r2);
    L10:
        if (ReflectionAccessFilterHelper.canAccess(r2, null) == false) goto L16;
        if (r5 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L15;
        if (Modifier.isPublic(r2.getModifiers()) == false) goto L16;
    L27:
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type r2, Class<? super T> r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (Collection.class.isAssignableFrom(r3) == false) goto L19;
        if (SortedSet.class.isAssignableFrom(r3) == false) goto L9;
        return new AnonymousClass10();
    L9:
        if (Set.class.isAssignableFrom(r3) == false) goto L13;
        return new AnonymousClass11();
    L13:
        if (Queue.class.isAssignableFrom(r3) == false) goto L17;
        return new AnonymousClass12();
    L17:
        return new AnonymousClass13();
    L19:
        if (Map.class.isAssignableFrom(r3) == true) goto L21;
        return null;
    L21:
        if (ConcurrentNavigableMap.class.isAssignableFrom(r3) == false) goto L25;
        return new AnonymousClass14();
    L25:
        if (ConcurrentMap.class.isAssignableFrom(r3) == false) goto L29;
        return new AnonymousClass15();
    L29:
        if (SortedMap.class.isAssignableFrom(r3) == false) goto L33;
        return new AnonymousClass16();
    L33:
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L39;
        if (String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments()[0]).getRawType()) == true) goto L39;
        return new AnonymousClass17();
    L39:
        return new AnonymousClass18();
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type r2, Class<? super T> r3) {
        final Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (EnumSet.class.isAssignableFrom(r3) == false) goto L7;
        return new AnonymousClass5(r4);
    L7:
        if (r3 == EnumMap.class) goto L9;
        return null;
    L9:
        return new AnonymousClass6(r4);
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Class<? super T> r3) {
        if (this.useJdkUnsafe == true) goto L5;
        final String r4 = "Unable to create instance of " + r3 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        return new AnonymousClass20(this, r4);
    L5:
        return new AnonymousClass19(this, r3);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> r5) {
        final Type r0 = r5.getType();
        Class<? super T> r6 = r5.getRawType();
        final InstanceCreator r1 = (InstanceCreator) ZeusTransformUtils.preCheckCast(this.instanceCreators.get(r0), InstanceCreator.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        final InstanceCreator r2 = (InstanceCreator) ZeusTransformUtils.preCheckCast(this.instanceCreators.get(r6), InstanceCreator.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        ObjectConstructor<T> r3 = newSpecialCollectionConstructor(r0, r6);
        if (r3 == null) goto L13;
        return r3;
    L13:
        ReflectionAccessFilter.FilterResult r4 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r6);
        ObjectConstructor<T> r7 = newDefaultConstructor(r6, r4);
        if (r7 == null) goto L16;
        return r7;
    L16:
        ObjectConstructor<T> r8 = newDefaultImplementationConstructor(r0, r6);
        if (r8 == null) goto L19;
        return r8;
    L19:
        final String r9 = checkInstantiable(r6);
        if (r9 == null) goto L24;
        return new AnonymousClass3(this, r9);
    L24:
        if (r4 == ReflectionAccessFilter.FilterResult.ALLOW) goto L26;
        final String r10 = "Unable to create instance of " + r6 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new AnonymousClass4(this, r10);
    L26:
        return newUnsafeAllocator(r6);
    L9:
        return new AnonymousClass2(this, r2, r0);
    L5:
        return new AnonymousClass1(this, r1, r0);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
