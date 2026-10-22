package com.obric.aikernel.api;

import android.os.Process;
import com.obric.aikernel.api.security.CertProvisionFeature;
import com.obric.aikernel.api.security.e;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function1<? super Class<?>, ? extends d> f4432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<Class<?>, d> f4433c;

    static {
        f4431a = new b();
        f4432b = DefaultFeatureProvider.f4428a.a();
        f4433c = new ConcurrentHashMap();
    }

    private b() {
    }

    public final com.obric.aikernel.api.base.a a() {
        return (com.obric.aikernel.api.base.a) g(com.obric.aikernel.api.base.a.class);
    }

    public final CertProvisionFeature b() {
        return (CertProvisionFeature) g(CertProvisionFeature.class);
    }

    public final com.obric.aikernel.api.security.a c() {
        return (com.obric.aikernel.api.security.a) g(com.obric.aikernel.api.security.a.class);
    }

    public final com.obric.aikernel.api.base.c d() {
        return (com.obric.aikernel.api.base.c) g(com.obric.aikernel.api.base.c.class);
    }

    public final com.obric.aikernel.api.security.b e() {
        return (com.obric.aikernel.api.security.b) g(com.obric.aikernel.api.security.b.class);
    }

    public final c7.a f() {
        return (c7.a) g(c7.a.class);
    }

    public final <T extends d> T g(Class<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        T r11 = (T) f4433c.get(r10);
        if (r11 != null) goto L27;
        monitor-enter(this);
        r11 = (T) f4433c.get(r10);     // Catch: Throwable -> L24
        if (r11 != null) goto L22;
        Function1<? super Class<?>, ? extends d> r12 = f4432b;     // Catch: Throwable -> L24
        if (c.b(r10, f4433c.get(r10)) == false) goto L11;
        AIKLog.INSTANCE.w("FeatureManager", "first AppConfigs init process=" + Process.myProcessName() + " getterKind=" + c.a(r12, DefaultFeatureProvider.f4428a.a()) + " getterId=" + System.identityHashCode(r12) + " cacheSize=" + f4433c.size() + " stack=" + ExceptionsKt.stackTraceToString(new IllegalStateException("first AppConfigs init")));     // Catch: Throwable -> L24
    L11:
        if (f4432b != null) goto L13;
        AIKLog.INSTANCE.w("FeatureManager", "try init " + r10.getSimpleName() + " but feature getter not set. \n" + ExceptionsKt.stackTraceToString(new IllegalAccessError()));     // Catch: Throwable -> L24
    L13:
        int r13 = 0;
        if (r12 == null) goto L17;
        d r14 = r12.invoke(r10);     // Catch: Throwable -> L24
        if (r14 == null) goto L17;
    L18:
        AIKLog r15 = AIKLog.INSTANCE;     // Catch: Throwable -> L24
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L24
        r16.append("inited ");     // Catch: Throwable -> L24
        r16.append(r14);     // Catch: Throwable -> L24
        r16.append(" of ");     // Catch: Throwable -> L24
        r16.append(r10.getSimpleName());     // Catch: Throwable -> L24
        r16.append(" from ");     // Catch: Throwable -> L24
        Function1<? super Class<?>, ? extends d> r17 = f4432b;     // Catch: Throwable -> L24
        if (r17 == null) goto L21;
        r13 = r17.hashCode();     // Catch: Throwable -> L24
    L21:
        r16.append(r13);     // Catch: Throwable -> L24
        r15.i("FeatureManager", r16.toString());     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type T of com.obric.aikernel.api.FeatureManager.getOrCreate$lambda$3$lambda$2$lambda$1");     // Catch: Throwable -> L24
        d r18 = (d) r14;     // Catch: Throwable -> L24
        f4433c.put(r10, (d) r14);     // Catch: Throwable -> L24
        r11 = (T) r14;     // Catch: Throwable -> L24
    L17:
        AIKLog.INSTANCE.w("FeatureManager", r10.getSimpleName() + " impl not set, fallback to default impl");     // Catch: Throwable -> L24
        r14 = r10.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
    L24:
        th = move-exception;
        throw th;
    L27:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type T of com.obric.aikernel.api.FeatureManager.getOrCreate");
        return r11;
    }

    public final com.obric.aikernel.api.base.d h() {
        return (com.obric.aikernel.api.base.d) g(com.obric.aikernel.api.base.d.class);
    }

    public final d7.a i() {
        return (d7.a) g(d7.a.class);
    }

    public final e j() {
        return (e) g(e.class);
    }

    public final void k(Function1<? super Class<?>, ? extends d> r10) {
        f4432b = r10;
    }
}
