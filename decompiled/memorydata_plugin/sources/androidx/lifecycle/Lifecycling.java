package androidx.lifecycle;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u001e\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0014\u0010\u0015\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0001H\u0007J\u0014\u0010\u001a\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/lifecycle/Lifecycling;", "", "()V", "GENERATED_CALLBACK", "", "REFLECTIVE_CALLBACK", "callbackCache", "", "Ljava/lang/Class;", "classToAdapters", "", "Ljava/lang/reflect/Constructor;", "Landroidx/lifecycle/GeneratedAdapter;", "createGeneratedAdapter", "constructor", "object", "generatedConstructor", "klass", "getAdapterName", "", "className", "getObserverConstructorType", "isLifecycleParent", "", "lifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "resolveObserverCallbackType", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    public static final Lifecycling INSTANCE = null;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static final Map<Class<?>, Integer> callbackCache = null;
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> classToAdapters = null;

    static {
        INSTANCE = new Lifecycling();
        callbackCache = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
        classToAdapters = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private Lifecycling() {
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> r3, Object r4) {
        GeneratedAdapter r5 = r3.newInstance(new Object[]{r4});     // Catch: InvocationTargetException -> L5 InstantiationException -> L8 IllegalAccessException -> L11
        Intrinsics.checkNotNullExpressionValue(r5, "{\n            constructo…tance(`object`)\n        }");     // Catch: InvocationTargetException -> L5 InstantiationException -> L8 IllegalAccessException -> L11
        return (GeneratedAdapter) ZeusTransformUtils.preCheckCast(r5, GeneratedAdapter.class, "com.obric.memorydata.plugin");
    L11:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> r6) {
        Package r0 = r6.getPackage();     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        String r1 = r6.getCanonicalName();     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        if (r0 == null) goto L6;
        String r2 = r0.getName();     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
    L7:
        Intrinsics.checkNotNullExpressionValue(r2, "fullPackage");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        Intrinsics.checkNotNullExpressionValue(r1, ActivityLifecycle.NAME);     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        r1 = r1.substring(r2.length() + 1);     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).substring(startIndex)");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
    L14:
        Intrinsics.checkNotNullExpressionValue(r1, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        String r4 = getAdapterName(r1);     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L21;
        r4 = r2 + '.' + r4;     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
    L21:
        Class r7 = ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        Constructor<? extends GeneratedAdapter> r8 = r7.getDeclaredConstructor(new Class[]{r6});     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
        if (r8.isAccessible() == true) goto L32;
        r8.setAccessible(true);     // Catch: NoSuchMethodException -> L25 ClassNotFoundException -> L28
    L33:
        return r8;
    L32:
        return r8;
    L17:
        r5 = false;
        goto L18
    L10:
        r3 = false;
        goto L11
    L6:
        r2 = "";
    L28:
        return null;
    L25:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final String getAdapterName(String r7) {
        Intrinsics.checkNotNullParameter(r7, "className");
        return StringsKt.replace$default(r7, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int getObserverConstructorType(Class<?> r5) {
        Map<Class<?>, Integer> r0 = callbackCache;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(r5), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        int r4 = resolveObserverCallbackType(r5);
        r0.put(r5, Integer.valueOf(r4));
        return r4;
    L5:
        return r1.intValue();
    }

    private final boolean isLifecycleParent(Class<?> r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (LifecycleObserver.class.isAssignableFrom(r1) == false) goto L6;
        return true;
    }

    @JvmStatic
    public static final LifecycleEventObserver lifecycleEventObserver(Object r8) {
        Intrinsics.checkNotNullParameter(r8, "object");
        boolean r0 = ZeusTransformUtils.instanceOf(r8, LifecycleEventObserver.class);
        boolean r1 = ZeusTransformUtils.instanceOf(r8, DefaultLifecycleObserver.class);
        if (r0 == false) goto L9;
        if (r1 == false) goto L9;
        Object r2 = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) ZeusTransformUtils.preCheckCast(r8, DefaultLifecycleObserver.class, "com.obric.memorydata.plugin"), (LifecycleEventObserver) ZeusTransformUtils.preCheckCast(r8, LifecycleEventObserver.class, "com.obric.memorydata.plugin"));
    L6:
        Object r9 = ZeusTransformUtils.preCheckCast(r2, LifecycleEventObserver.class, "com.obric.memorydata.plugin");
    L8:
        return (LifecycleEventObserver) r9;
    L9:
        if (r1 == false) goto L11;
        r2 = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) ZeusTransformUtils.preCheckCast(r8, DefaultLifecycleObserver.class, "com.obric.memorydata.plugin"), null);
        goto L6
    L11:
        if (r0 == false) goto L13;
    L12:
        r9 = ZeusTransformUtils.preCheckCast(r8, LifecycleEventObserver.class, "com.obric.memorydata.plugin");
        goto L8
    L13:
        Class<?> r3 = r8.getClass();
        Lifecycling r4 = INSTANCE;
        if (r4.getObserverConstructorType(r3) != 2) goto L22;
        List<Constructor<? extends GeneratedAdapter>> r5 = classToAdapters.get(r3);
        Intrinsics.checkNotNull(r5);
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        int r7 = 0;
        if (r6.size() != 1) goto L18;
        r2 = new SingleGeneratedAdapterObserver(r4.createGeneratedAdapter((Constructor) ZeusTransformUtils.preCheckCast(r6.get(0), Constructor.class, "com.obric.memorydata.plugin"), r8));
        goto L6
    L18:
        int r10 = r6.size();
        GeneratedAdapter[] r11 = new GeneratedAdapter[r10];
    L19:
        if (r7 >= r10) goto L21;
        r11[r7] = INSTANCE.createGeneratedAdapter((Constructor) ZeusTransformUtils.preCheckCast(r6.get(r7), Constructor.class, "com.obric.memorydata.plugin"), r8);
        r7 = r7 + 1;
        goto L19
    L21:
        r8 = new CompositeGeneratedAdaptersObserver(r11);
        goto L12
    L22:
        r2 = new ReflectiveGenericLifecycleObserver(r8);
        goto L6
    }

    private final int resolveObserverCallbackType(Class<?> r10) {
        if (r10.getCanonicalName() != null) goto L5;
        return 1;
    L5:
        Constructor<? extends GeneratedAdapter> r0 = generatedConstructor(r10);
        if (r0 == null) goto L10;
        classToAdapters.put(r10, CollectionsKt.listOf(r0));
        return 2;
    L10:
        if (ClassesInfoCache.sInstance.hasLifecycleMethods(r10) == false) goto L12;
        return 1;
    L12:
        Class<? super Object> r1 = r10.getSuperclass();
        List<Constructor<? extends GeneratedAdapter>> r3 = null;
        if (isLifecycleParent(r1) == false) goto L18;
        Intrinsics.checkNotNullExpressionValue(r1, "superclass");
        if (getObserverConstructorType(r1) != 1) goto L17;
        return 1;
    L17:
        List<Constructor<? extends GeneratedAdapter>> r2 = classToAdapters.get(r1);
        Intrinsics.checkNotNull(r2);
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
    L18:
        Class<?>[] r4 = r10.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(r4, "klass.interfaces");
        int r5 = 0;
        int r6 = r4.length;
    L19:
        if (r5 >= r6) goto L30;
        Class<?> r7 = r4[r5];
        if (isLifecycleParent(r7) == false) goto L29;
        Intrinsics.checkNotNullExpressionValue(r7, "intrface");
        if (getObserverConstructorType(r7) == 1) goto L25;
        if (r3 != null) goto L28;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L28:
        List<Constructor<? extends GeneratedAdapter>> r8 = classToAdapters.get(r7);
        Intrinsics.checkNotNull(r8);
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"));
        goto L29
    L25:
        return 1;
    L29:
        r5 = r5 + 1;
        goto L19
    L30:
        if (r3 == null) goto L33;
        classToAdapters.put(r10, r3);
        return 2;
    L33:
        return 1;
    }
}
