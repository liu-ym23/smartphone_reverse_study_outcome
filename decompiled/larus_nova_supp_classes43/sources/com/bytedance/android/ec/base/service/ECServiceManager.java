package com.bytedance.android.ec.base.service;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECServiceManager {
    public static volatile boolean a;
    public static final ConcurrentHashMap<Class<?>, Object> b = null;
    public static final Lazy c = null;

    static {
        b = new ConcurrentHashMap();
        c = LazyKt.lazy(ECServiceManager$DEFAULT_SERVICE$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.bytedance.android.ec.sdk.initalizer.ECInitializer");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.sdk.initalizer.ECInitializer");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.sdk.initalizer.ECInitializer");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.bytedance.android.ec.sdk.initalizer.ECInitializer");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.sdk.initalizer.ECInitializer");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.sdk.initalizer.ECInitializer");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.ec.sdk.initalizer.ECInitializer");
    }

    public static Object b(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Object r10 = b.get(r1);
        if ((r10 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r10;
    }

    public static Object c(Class r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Object r0 = b.get(r10);
        if (r0 == null) goto L5;
    L9:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return ((ConcurrentHashMap) c.getValue()).get(r10);
    L5:
        if (a == true) goto L9;
        a = true;
        Class r1 = a();     // Catch: Exception -> L12
        r1.getDeclaredMethod("init", new Class[0]).invoke(r1.newInstance(), new Object[0]);     // Catch: Exception -> L12
    L8:
        r0 = b.get(r10);
        goto L9
    }

    public static boolean d(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        if (b.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void f(Map r10) {
        Intrinsics.checkNotNullParameter(r10, "services");
        ArrayList r0 = new ArrayList(r10.size());
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        Map.Entry r1 = (Map.Entry) r11.next();
        ConcurrentHashMap<Class<?>, Object> r12 = b;
        if (r12.contains(r1.getKey()) == false) goto L16;
        Object r13 = r12.get(r1.getKey());
        Class<?> r14 = null;
        if (r13 == null) goto L10;
        Class<?> r15 = r13.getClass();
    L11:
        Object r16 = r1.getValue();
        if (r16 == null) goto L15;
        r14 = r16.getClass();
    L15:
        if (Intrinsics.areEqual(r15, r14) == false) goto L16;
    L17:
        r0.add(Unit.INSTANCE);
        goto L4
    L10:
        r15 = null;
    L16:
        r12.put((Class<?>) r1.getKey(), r1.getValue());
        goto L17
    }

    public static void e(Class r1, Object r10) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        b.put(r1, r10);
    }
}
