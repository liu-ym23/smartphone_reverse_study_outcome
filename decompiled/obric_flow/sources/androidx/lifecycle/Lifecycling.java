package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
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

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> r5, Object r10) {
        return r5.newInstance(new Object[]{r10});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> r5) {
        Package r10 = r5.getPackage();     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        String r11 = r5.getCanonicalName();     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        if (r10 == null) goto L7;
        String r12 = r10.getName();     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
    L9:
        if (r12.length() == 0) goto L12;
        r11 = r11.substring(r12.length() + 1);     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
    L12:
        String r13 = getAdapterName(r11);     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        if (r12.length() == 0) goto L16;
        r13 = r12 + '.' + r13;     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
    L16:
        Class<?> r14 = Class.forName(r13);     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        Constructor r15 = r14.getDeclaredConstructor(new Class[]{r5});     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
        if (r15.isAccessible() == true) goto L26;
        r15.setAccessible(true);     // Catch: NoSuchMethodException -> L5 ClassNotFoundException -> L22
    L27:
        return r15;
    L26:
        return r15;
    L7:
        r12 = "";
    L22:
        return null;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @JvmStatic
    public static final String getAdapterName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "className");
        return StringsKt.F(r5, ".", "_") + "_LifecycleAdapter";
    }

    private final int getObserverConstructorType(Class<?> r5) {
        Map<Class<?>, Integer> r10 = callbackCache;
        Integer r11 = r10.get(r5);
        if (r11 != null) goto L5;
        int r12 = resolveObserverCallbackType(r5);
        r10.put(r5, Integer.valueOf(r12));
        return r12;
    L5:
        return r11.intValue();
    }

    private final boolean isLifecycleParent(Class<?> r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (LifecycleObserver.class.isAssignableFrom(r5) == false) goto L6;
        return true;
    }

    @JvmStatic
    public static final LifecycleEventObserver lifecycleEventObserver(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "object");
        boolean r5 = r10 instanceof LifecycleEventObserver;
        boolean r11 = r10 instanceof DefaultLifecycleObserver;
        if (r5 == false) goto L7;
        if (r11 == false) goto L7;
        return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) r10, (LifecycleEventObserver) r10);
    L7:
        if (r11 == true) goto L9;
        if (r5 == true) goto L12;
        Class<?> r12 = r10.getClass();
        Lifecycling r13 = INSTANCE;
        if (r13.getObserverConstructorType(r12) != 2) goto L25;
        List<Constructor<? extends GeneratedAdapter>> r14 = classToAdapters.get(r12);
        Intrinsics.checkNotNull(r14);
        List<Constructor<? extends GeneratedAdapter>> r15 = r14;
        int r16 = 0;
        if (r15.size() == 1) goto L18;
        int r17 = r15.size();
        GeneratedAdapter[] r18 = new GeneratedAdapter[r17];
    L20:
        if (r16 >= r17) goto L23;
        r18[r16] = INSTANCE.createGeneratedAdapter(r15.get(r16), r10);
        r16 = r16 + 1;
        goto L20
    L23:
        return new CompositeGeneratedAdaptersObserver(r18);
    L18:
        return new SingleGeneratedAdapterObserver(r13.createGeneratedAdapter(r15.get(0), r10));
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
        Constructor<? extends GeneratedAdapter> r5 = generatedConstructor(r10);
        if (r5 == null) goto L10;
        classToAdapters.put(r10, CollectionsKt.listOf(r5));
        return 2;
    L10:
        if (ClassesInfoCache.sInstance.hasLifecycleMethods(r10) == false) goto L12;
        return 1;
    L12:
        Class<? super Object> r11 = r10.getSuperclass();
        if (isLifecycleParent(r11) == true) goto L15;
        ArrayList r12 = null;
    L19:
        Class<?>[] r13 = r10.getInterfaces();
        int r14 = r13.length;
        int r15 = 0;
    L20:
        if (r15 >= r14) goto L31;
        Class<?> r16 = r13[r15];
        if (isLifecycleParent(r16) == false) goto L30;
        if (getObserverConstructorType(r16) == 1) goto L26;
        if (r12 != null) goto L29;
        r12 = new ArrayList();
    L29:
        List<Constructor<? extends GeneratedAdapter>> r17 = classToAdapters.get(r16);
        Intrinsics.checkNotNull(r17);
        r12.addAll(r17);
        goto L30
    L26:
        return 1;
    L30:
        r15 = r15 + 1;
        goto L20
    L31:
        if (r12 == null) goto L34;
        classToAdapters.put(r10, r12);
        return 2;
    L34:
        return 1;
    L15:
        if (getObserverConstructorType(r11) != 1) goto L17;
        return 1;
    L17:
        List<Constructor<? extends GeneratedAdapter>> r18 = classToAdapters.get(r11);
        Intrinsics.checkNotNull(r18);
        r12 = new ArrayList(r18);
        goto L19
    }
}
