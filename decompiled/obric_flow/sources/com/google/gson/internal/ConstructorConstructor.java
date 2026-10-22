package com.google.gson.internal;

import ai.j0;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public static final class InstanceCreatorConstructor<T> implements ObjectConstructor<T> {
        private final InstanceCreator<T> instanceCreator;
        private final Type type;

        public InstanceCreatorConstructor(InstanceCreator<T> r5, Type r10) {
            this.instanceCreator = r5;
            this.type = r10;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return this.instanceCreator.createInstance(this.type);
        }
    }

    public static final class ThrowingObjectConstructor<T> implements ObjectConstructor<T> {
        private final String exceptionMessage;

        public ThrowingObjectConstructor(String r5) {
            this.exceptionMessage = r5;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(this.exceptionMessage);
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> r5, boolean r10, List<ReflectionAccessFilter> r11) {
        this.instanceCreators = r5;
        this.useJdkUnsafe = r10;
        this.reflectionFilters = r11;
    }

    public static /* synthetic */ Object a(Class r5) {
        return lambda$newUnsafeAllocator$4(r5);
    }

    public static /* synthetic */ Object b(Type r5) {
        return lambda$newSpecialCollectionConstructor$1(r5);
    }

    public static /* synthetic */ Map c() {
        return lambda$newMapConstructor$3();
    }

    public static String checkInstantiable(Class<?> r5) {
        int r10 = r5.getModifiers();
        if (Modifier.isInterface(r10) == false) goto L7;
        return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(r5.getName());
    L7:
        if (Modifier.isAbstract(r10) == true) goto L9;
        return null;
    L9:
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + r5.getName() + "\nSee " + TroubleshootingGuide.createUrl("r8-abstract-class");
    }

    public static /* synthetic */ Object d(Type r5) {
        return lambda$newSpecialCollectionConstructor$0(r5);
    }

    public static /* synthetic */ Object e(Constructor r5) {
        return lambda$newDefaultConstructor$2(r5);
    }

    private static boolean hasStringKeyType(Type r5) {
        if ((r5 instanceof ParameterizedType) == true) goto L5;
        return true;
    L5:
        Type[] r10 = ((ParameterizedType) r5).getActualTypeArguments();
        if (r10.length != 0) goto L9;
        return false;
    L9:
        if (GsonTypes.getRawType(r10[0]) != String.class) goto L12;
        return true;
    L12:
        return false;
    }

    private static /* synthetic */ Object lambda$newDefaultConstructor$2(Constructor r5) {
        return r5.newInstance(null);
    L5:
        e = move-exception;
        throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
    L11:
        e = move-exception;
        throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(r5) + "' with no args", e);
    L8:
        e = move-exception;
        throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(r5) + "' with no args", e.getCause());
    }

    private static /* synthetic */ Map lambda$newMapConstructor$3() {
        return new LinkedTreeMap();
    }

    private static /* synthetic */ Object lambda$newSpecialCollectionConstructor$0(Type r5) {
        if ((r5 instanceof ParameterizedType) == false) goto L11;
        Type r10 = ((ParameterizedType) r5).getActualTypeArguments()[0];
        if ((r10 instanceof Class) == false) goto L9;
        return EnumSet.noneOf((Class) r10);
    L9:
        throw new JsonIOException(j0.m("Invalid EnumSet type: ", r5));
    L11:
        throw new JsonIOException(j0.m("Invalid EnumSet type: ", r5));
    }

    private static /* synthetic */ Object lambda$newSpecialCollectionConstructor$1(Type r5) {
        if ((r5 instanceof ParameterizedType) == false) goto L11;
        Type r10 = ((ParameterizedType) r5).getActualTypeArguments()[0];
        if ((r10 instanceof Class) == false) goto L9;
        return new EnumMap((Class) r10);
    L9:
        throw new JsonIOException(j0.m("Invalid EnumMap type: ", r5));
    L11:
        throw new JsonIOException(j0.m("Invalid EnumMap type: ", r5));
    }

    private static /* synthetic */ Object lambda$newUnsafeAllocator$4(Class r5) {
        return UnsafeAllocator.INSTANCE.newInstance(r5);
    L4:
        e = move-exception;
        throw new RuntimeException("Unable to create instance of " + r5 + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
    }

    private static ObjectConstructor<? extends Collection<?>> newCollectionConstructor(Class<?> r5) {
        if (r5.isAssignableFrom(ArrayList.class) == false) goto L7;
        return new com.bytedance.ai.resource.core.net.a(5);
    L7:
        if (r5.isAssignableFrom(LinkedHashSet.class) == false) goto L11;
        return new com.bytedance.ai.resource.core.net.a(8);
    L11:
        if (r5.isAssignableFrom(TreeSet.class) == false) goto L15;
        return new com.bytedance.ai.resource.core.net.a(9);
    L15:
        if (r5.isAssignableFrom(ArrayDeque.class) == true) goto L17;
        return null;
    L17:
        return new com.bytedance.ai.resource.core.net.a(10);
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> r5, ReflectionAccessFilter.FilterResult r10) {
        if (Modifier.isAbstract(r5.getModifiers()) == false) goto L25;
        return null;
    L25:
        Constructor<? super T> r11 = r5.getDeclaredConstructor(null);     // Catch: NoSuchMethodException -> L24
        ReflectionAccessFilter.FilterResult r12 = ReflectionAccessFilter.FilterResult.ALLOW;
        if (r10 != r12) goto L9;
    L17:
        if (r10 != r12) goto L23;
        String r13 = ReflectionHelper.tryMakeAccessible(r11);
        if (r13 == null) goto L23;
        return new ThrowingObjectConstructor(r13);
    L23:
        return new androidx.core.view.inputmethod.a(r11, 6);
    L9:
        if (ReflectionAccessFilterHelper.canAccess(r11, null) == false) goto L16;
        if (r10 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L17;
        if (Modifier.isPublic(r11.getModifiers()) == true) goto L17;
    L16:
        return new ThrowingObjectConstructor("Unable to invoke no-args constructor of " + r5 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
    L24:
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type r5, Class<? super T> r10) {
        if (Collection.class.isAssignableFrom(r10) == false) goto L7;
        return (ObjectConstructor<T>) newCollectionConstructor(r10);
    L7:
        if (Map.class.isAssignableFrom(r10) == true) goto L9;
        return null;
    L9:
        return (ObjectConstructor<T>) newMapConstructor(r5, r10);
    }

    private static ObjectConstructor<? extends Map<?, Object>> newMapConstructor(Type r5, Class<?> r10) {
        if (r10.isAssignableFrom(LinkedTreeMap.class) == false) goto L9;
        if (hasStringKeyType(r5) == false) goto L9;
        return new com.bytedance.ai.resource.core.net.a(11);
    L9:
        if (r10.isAssignableFrom(LinkedHashMap.class) == false) goto L13;
        return new com.bytedance.ai.resource.core.net.a(12);
    L13:
        if (r10.isAssignableFrom(TreeMap.class) == false) goto L17;
        return new com.bytedance.ai.resource.core.net.a(13);
    L17:
        if (r10.isAssignableFrom(ConcurrentHashMap.class) == false) goto L21;
        return new com.bytedance.ai.resource.core.net.a(6);
    L21:
        if (r10.isAssignableFrom(ConcurrentSkipListMap.class) == true) goto L23;
        return null;
    L23:
        return new com.bytedance.ai.resource.core.net.a(7);
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(final Type r5, Class<? super T> r10) {
        if (EnumSet.class.isAssignableFrom(r10) == false) goto L7;
        final int r11 = 0;
        return new a(r11, r5);
    L7:
        if (r10 != EnumMap.class) goto L10;
        final int r12 = 1;
        return new a(r12, r5);
    L10:
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Class<? super T> r5) {
        if (this.useJdkUnsafe == true) goto L5;
        String r10 = "Unable to create instance of " + r5 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        if (r5.getDeclaredConstructors().length != 0) goto L10;
        r10 = j0.j(r10, " Or adjust your R8 configuration to keep the no-args constructor of the class.");
    L10:
        return new ThrowingObjectConstructor(r10);
    L5:
        return new androidx.core.view.inputmethod.a(r5, 7);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> r5) {
        return get(r5, true);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> r5, boolean r10) {
        Type r11 = r5.getType();
        Class<? super T> r12 = r5.getRawType();
        InstanceCreator<?> r13 = this.instanceCreators.get(r11);
        if (r13 != null) goto L5;
        InstanceCreator<?> r14 = this.instanceCreators.get(r12);
        if (r14 != null) goto L9;
        ObjectConstructor<T> r15 = newSpecialCollectionConstructor(r11, r12);
        if (r15 == null) goto L13;
        return r15;
    L13:
        ReflectionAccessFilter.FilterResult r16 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r12);
        ObjectConstructor<T> r17 = newDefaultConstructor(r12, r16);
        if (r17 == null) goto L16;
        return r17;
    L16:
        ObjectConstructor<T> r18 = newDefaultImplementationConstructor(r11, r12);
        if (r18 == null) goto L19;
        return r18;
    L19:
        String r19 = checkInstantiable(r12);
        if (r19 == null) goto L24;
        return new ThrowingObjectConstructor(r19);
    L24:
        if (r10 == true) goto L28;
        return new ThrowingObjectConstructor("Unable to create instance of " + r12 + "; Register an InstanceCreator or a TypeAdapter for this type.");
    L28:
        if (r16 == ReflectionAccessFilter.FilterResult.ALLOW) goto L32;
        return new ThrowingObjectConstructor("Unable to create instance of " + r12 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    L32:
        return newUnsafeAllocator(r12);
    L9:
        return new InstanceCreatorConstructor(r14, r11);
    L5:
        return new InstanceCreatorConstructor(r13, r11);
    }
}
