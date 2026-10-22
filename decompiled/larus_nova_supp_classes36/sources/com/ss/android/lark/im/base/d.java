package com.ss.android.lark.im.base;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final Map<ImExtensionType, List<Class<?>>> a = null;
    public static final Map<ImExtensionType, List<?>> b = null;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static List a(ImExtensionType r4, Class r5) {
        ArrayList r0 = new ArrayList();
        List r6 = (List) ((ConcurrentHashMap) a).get(r4);
        if (r6 == null) goto L11;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L11;
        Class<?> r1 = (Class) r7.next();
        if (r5.isAssignableFrom(r1) == true) goto L9;
        Log.e("ImExtensionManager", r5.getCanonicalName() + " is not assignable from " + r1.getCanonicalName());
        goto L6
    L9:
        Object r2 = r1.newInstance();
        Intrinsics.checkNotNull(r2);
        r0.add(r2);
    L11:
        return r0;
    }

    public static List b(ImExtensionType r2, Class r3) {
        Intrinsics.checkNotNullParameter(r2, "extensionType");
        Intrinsics.checkNotNullParameter(r3, "factoryClass");
        c r0 = ((ImBaseBizModule) ImBaseBizModule.c.getValue()).a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("extensionDependency");
        r0 = null;
    L6:
        r0.b();
        ConcurrentHashMap r1 = (ConcurrentHashMap) b;
        List r4 = (List) r1.get(r2);
        if (r4 != null) goto L9;
        r4 = a(r2, r3);
        r1.put(r2, r4);
    L9:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.collections.List<T of com.ss.android.lark.im.base.ImExtensionManager.getCachedFactories>");
        return r4;
    }

    public static List c(ImExtensionType r1, Class r2) {
        Intrinsics.checkNotNullParameter(r1, "extensionType");
        Intrinsics.checkNotNullParameter(r2, "factoryClass");
        c r0 = ((ImBaseBizModule) ImBaseBizModule.c.getValue()).a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("extensionDependency");
        r0 = null;
    L6:
        r0.b();
        List r3 = a(r1, r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.List<T of com.ss.android.lark.im.base.ImExtensionManager.getFactoriesWithNewInstances>");
        return r3;
    }

    public static void d(ImExtensionType r2, Class r3) {
        Intrinsics.checkNotNullParameter(r2, "extensionType");
        Intrinsics.checkNotNullParameter(r3, "factoryClass");
        ConcurrentHashMap r0 = (ConcurrentHashMap) a;
        List r1 = (List) r0.get(r2);
        if (r1 != null) goto L5;
        r1 = new CopyOnWriteArrayList();
        r0.put(r2, r1);
    L5:
        r1.add(r3);
    }
}
