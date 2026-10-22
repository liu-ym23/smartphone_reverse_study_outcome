package com.bytedance.android.annie.service;

import a9.h;
import com.bytedance.android.annie.bridge.j;
import com.bytedance.android.annie.bridge.k;
import com.bytedance.android.annie.bridge.r;
import com.bytedance.android.annie.param.n;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.network.DefaultAnnieNetworkService;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.android.annie.service.network.i;
import com.bytedance.android.annie.service.prefetch.m;
import com.bytedance.android.annie.service.prefetch.p;
import com.bytedance.android.annie.service.resource.f;
import com.bytedance.android.annie.service.userinfo.IUserInfoService;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.agilelogger.ALog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k9.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import p9.g;
import w9.b;
import x8.c;
import x8.d;
import y9.l;
import y9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieNGServiceCenter {
    public static final AnnieNGServiceCenter a = null;
    public static final Lazy b = null;
    public static final Object c = null;

    public AnnieNGServiceCenter() {
    }

    static {
        a = new AnnieNGServiceCenter();
        b = LazyKt.lazy(AnnieNGServiceCenter$mServiceMap$2.INSTANCE);
        c = new Object();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r10 = Class.forName("com.bytedance.android.annie.business.AnnieMixGlueService");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.annie.business.AnnieMixGlueService");     // Catch: Throwable -> L8
    L7:
        return r10;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.annie.business.AnnieMixGlueService");
    L12:
        throw th;
    L34:
        Class<?> r11 = Class.forName("com.bytedance.android.annie.business.AnnieMixGlueService");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.annie.business.AnnieMixGlueService");     // Catch: Throwable -> L17
    L16:
        return r11;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.annie.business.AnnieMixGlueService");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.annie.business.AnnieMixGlueService");
    }

    public static Map c() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(d.class, new c());
        r0.put(f.class, new com.bytedance.android.annie.service.resource.c());
        r0.put(p.class, new m());
        r0.put(ILatchService.class, new com.bytedance.android.annie.service.latch.a());
        r0.put(IAnnieBusinessLatchService.class, new com.bytedance.android.annie.service.business.latch.a());
        r0.put(w9.c.class, new b());
        r0.put(x9.b.class, new x9.a());
        r0.put(IAnnieNetworkService.class, new DefaultAnnieNetworkService());
        r0.put(da.b.class, new da.a());
        r0.put(o.class, new l());
        r0.put(z9.b.class, new z9.a());
        r0.put(e.class, new k9.b());
        r0.put(n9.b.class, new n9.a());
        r0.put(l9.b.class, new l9.a());
        r0.put(f9.b.class, new f9.a());
        r0.put(g.class, new p9.c());
        r0.put(w8.c.class, new w8.a());
        r0.put(e9.b.class, new e9.a());
        r0.put(r9.d.class, new r9.b());
        r0.put(r9.c.class, new r9.a());
        r0.put(k9.c.class, new k9.a());
        r0.put(t9.c.class, new t9.a());
        r0.put(c9.d.class, new c9.b());
        r0.put(com.bytedance.android.annie.param.m.class, new com.bytedance.android.annie.param.e());
        r0.put(n.class, new com.bytedance.android.annie.param.f());
        r0.put(p9.f.class, new p9.b());
        r0.put(com.bytedance.android.annie.bridge.o.class, new k());
        r0.put(r.class, new com.bytedance.android.annie.bridge.l());
        r0.put(com.bytedance.android.annie.service.resource.e.class, new com.bytedance.android.annie.service.resource.b());
        r0.put(com.bytedance.android.annie.bridge.n.class, new j());
        r0.put(aa.b.class, new aa.a());
        r0.put(v9.c.class, new v9.a());
        r0.put(y8.c.class, new y8.b());
        r0.put(m9.c.class, new m9.b());
        r0.put(m9.d.class, new m9.a());
        r0.put(q9.b.class, new q9.a());
        r0.put(u9.c.class, new u9.a());
        r0.put(IUserInfoService.class, new com.bytedance.android.annie.service.userinfo.a());
        r0.put(o9.b.class, new o9.a());
        r0.put(ba.b.class, new ba.a());
        r0.put(h.class, new a9.b());
        r0.put(ca.b.class, new ca.a());
        r0.put(i.class, new com.bytedance.android.annie.service.network.f());
        r0.put(y9.n.class, new y9.k());
        r0.put(i9.d.class, new i9.b());
        r0.put(i9.c.class, new i9.a());
        r0.put(d9.b.class, new d9.a());
        r0.put(com.bytedance.android.annie.param.l.class, new com.bytedance.android.annie.param.d());
        r0.put(b9.b.class, new b9.a());
        r0.put(com.bytedance.android.annie.xbridge.mix.f.class, new com.bytedance.android.annie.xbridge.mix.d());
        r0.put(g9.b.class, new g9.a());
        return r0;
    }

    public static ConcurrentHashMap d() {
        return (ConcurrentHashMap) b.getValue();
    }

    public static void e() {
        Object r0 = c;
        monitor-enter(r0);
        Map r1 = (Map) d().get("default");     // Catch: Throwable -> L13
        if (r1 == null) goto L10;
        Iterator r10 = ((LinkedHashMap) c()).entrySet().iterator();     // Catch: Throwable -> L13
    L8:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r11 = (Map.Entry) r10.next();     // Catch: Throwable -> L13
        r1.put(r11.getKey(), r11.getValue());     // Catch: Throwable -> L13
    L10:
        a.b();     // Catch: Throwable -> L13
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void b() {
        f(a9.i.class, a9.j.a, "default");
        f(o.class, new y9.j(), "default");
        f(p9.e.class, p9.a.a, "default");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = a().newInstance();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.android.annie.service.business.IAnnieBusinessGlueService");     // Catch: Throwable -> L5
        a.f(b9.b.class, (b9.b) r1, "default");     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L13;
        ALog.e("AnnieNGServiceCenter", "register annieMixGlueService Failure: " + r11.getMessage());
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final <T extends a> void f(Class<? extends a> r10, T r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "obj");
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        if (com.bytedance.android.annie.ng.g.f.contains(r12) == true) goto L7;
        ALog.e("AnnieNGServiceCenter", "未注册的bizKey");
        return;
    L7:
        if (d().get("default") == null) goto L10;
        Object r13 = d().get("default");
        Intrinsics.checkNotNull(r13);
        if (((Map) r13).isEmpty() == true) goto L10;
    L25:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L19
        if (d().get(r12) != null) goto L14;
        ConcurrentHashMap r15 = d();     // Catch: Throwable -> L19
        LinkedHashMap r16 = new LinkedHashMap();     // Catch: Throwable -> L19
        r16.put(r10, r11);     // Catch: Throwable -> L19
        r15.put(r12, r16);     // Catch: Throwable -> L19
    L17:
        HybridLogger r17 = HybridLogger.a;     // Catch: Throwable -> L19
        HybridLogger.m("AnnieNGServiceCenter", "service type is: " + r10 + " service is: " + r11 + "  has registered to '" + r12 + "' group with AnnieNGServiceCenter@" + hashCode(), null, null, 12);     // Catch: Throwable -> L19
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L27;
        ALog.e("AnnieNGServiceCenter", "service type is: " + r10 + " service is: " + r11 + "  registered Failure to " + r12 + " group with AnnieNGServiceCenter, message is " + r19.getMessage());
        return;
    L27:
        return;
    L14:
        Map r20 = (Map) d().get(r12);     // Catch: Throwable -> L19
        if (r20 == null) goto L17;
        r20.put(r10, r11);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        e();
        goto L25
    }
}
