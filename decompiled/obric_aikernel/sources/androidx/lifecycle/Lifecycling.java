package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    public static final Lifecycling INSTANCE = null;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static final Map<Class<?>, Integer> callbackCache = null;
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> classToAdapters = null;

    static {
        INSTANCE = new Lifecycling();
        callbackCache = new HashMap();
        classToAdapters = new HashMap();
    }

    private Lifecycling() {
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> r10, Object r11) {
        GeneratedAdapter r12 = r10.newInstance(new Object[]{r11});     // Catch: InvocationTargetException -> L5 InstantiationException -> L8 IllegalAccessException -> L11
        Intrinsics.checkNotNullExpressionValue(r12, "{\n            constructo…tance(`object`)\n        }");     // Catch: InvocationTargetException -> L5 InstantiationException -> L8 IllegalAccessException -> L11
        return r12;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> r10) {
        Package r11 = r10.getPackage();     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        String r12 = r10.getCanonicalName();     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        if (r11 == null) goto L5;
        String r13 = r11.getName();     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, "fullPackage");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        if (r13.length() != 0) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == true) goto L13;
        Intrinsics.checkNotNullExpressionValue(r12, ActivityLifecycle.NAME);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        r12 = r12.substring(r13.length() + 1);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).substring(startIndex)");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
    L13:
        Intrinsics.checkNotNullExpressionValue(r12, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        String r15 = getAdapterName(r12);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        if (r13.length() != 0) goto L16;
        boolean r16 = true;
    L17:
        if (r16 == true) goto L20;
        r15 = r13 + '.' + r15;     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
    L20:
        Class<?> r17 = Class.forName(r15);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        Constructor r18 = r17.getDeclaredConstructor(new Class[]{r10});     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        if (r18.isAccessible() == true) goto L31;
        r18.setAccessible(true);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
    L32:
        return r18;
    L31:
        return r18;
    L16:
        r16 = false;
        goto L17
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = "";
    L27:
        return null;
    L24:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @JvmStatic
    public static final String getAdapterName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "className");
        return StringsKt.replace$default(r10, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int getObserverConstructorType(Class<?> r10) {
        Map<Class<?>, Integer> r11 = callbackCache;
        Integer r12 = r11.get(r10);
        if (r12 != null) goto L5;
        int r13 = resolveObserverCallbackType(r10);
        r11.put(r10, Integer.valueOf(r13));
        return r13;
    L5:
        return r12.intValue();
    }

    private final boolean isLifecycleParent(Class<?> r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (LifecycleObserver.class.isAssignableFrom(r10) == false) goto L6;
        return true;
    }

    @JvmStatic
    public static final LifecycleEventObserver lifecycleEventObserver(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "object");
        boolean r11 = r10 instanceof LifecycleEventObserver;
        boolean r12 = r10 instanceof DefaultLifecycleObserver;
        if (r11 == false) goto L7;
        if (r12 == false) goto L7;
        return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) r10, (LifecycleEventObserver) r10);
    L7:
        if (r12 == true) goto L9;
        if (r11 == true) goto L12;
        Class<?> r13 = r10.getClass();
        Lifecycling r14 = INSTANCE;
        if (r14.getObserverConstructorType(r13) != 2) goto L25;
        List<Constructor<? extends GeneratedAdapter>> r15 = classToAdapters.get(r13);
        Intrinsics.checkNotNull(r15);
        List<Constructor<? extends GeneratedAdapter>> r16 = r15;
        int r17 = 0;
        if (r16.size() == 1) goto L18;
        int r18 = r16.size();
        GeneratedAdapter[] r19 = new GeneratedAdapter[r18];
    L20:
        if (r17 >= r18) goto L23;
        r19[r17] = INSTANCE.createGeneratedAdapter(r16.get(r17), r10);
        r17 = r17 + 1;
        goto L20
    L23:
        return new CompositeGeneratedAdaptersObserver(r19);
    L18:
        return new SingleGeneratedAdapterObserver(r14.createGeneratedAdapter(r16.get(0), r10));
    L25:
        return new ReflectiveGenericLifecycleObserver(r10);
    L12:
        return (LifecycleEventObserver) r10;
    L9:
        return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) r10, null);
    }

    private final int resolveObserverCallbackType(Class<?> r10) {
        if (r10.getCanonicalName() != null) goto L5;
        return 1;
    L5:
        Constructor<? extends GeneratedAdapter> r11 = generatedConstructor(r10);
        if (r11 == null) goto L10;
        classToAdapters.put(r10, CollectionsKt.listOf(r11));
        return 2;
    L10:
        if (ClassesInfoCache.sInstance.hasLifecycleMethods(r10) == false) goto L12;
        return 1;
    L12:
        Class<? super Object> r12 = r10.getSuperclass();
        ArrayList r13 = null;
        if (isLifecycleParent(r12) == false) goto L18;
        Intrinsics.checkNotNullExpressionValue(r12, "superclass");
        if (getObserverConstructorType(r12) != 1) goto L17;
        return 1;
    L17:
        List<Constructor<? extends GeneratedAdapter>> r14 = classToAdapters.get(r12);
        Intrinsics.checkNotNull(r14);
        r13 = new ArrayList(r14);
    L18:
        Class<?>[] r15 = r10.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(r15, "klass.interfaces");
        int r16 = 0;
        int r17 = r15.length;
    L19:
        if (r16 >= r17) goto L30;
        Class<?> r18 = r15[r16];
        if (isLifecycleParent(r18) == false) goto L29;
        Intrinsics.checkNotNullExpressionValue(r18, "intrface");
        if (getObserverConstructorType(r18) == 1) goto L25;
        if (r13 != null) goto L28;
        r13 = new ArrayList();
    L28:
        List<Constructor<? extends GeneratedAdapter>> r19 = classToAdapters.get(r18);
        Intrinsics.checkNotNull(r19);
        r13.addAll(r19);
        goto L29
    L25:
        return 1;
    L29:
        r16 = r16 + 1;
        goto L19
    L30:
        if (r13 == null) goto L33;
        classToAdapters.put(r10, r13);
        return 2;
    L33:
        return 1;
    }
}
