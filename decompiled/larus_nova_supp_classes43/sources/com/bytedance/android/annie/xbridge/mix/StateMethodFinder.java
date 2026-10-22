package com.bytedance.android.annie.xbridge.mix;

import android.util.LruCache;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class StateMethodFinder extends MethodFinder {
    public final m16.b d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public k i;
    public final LruCache<String, IDLXBridgeMethod> j;

    public final String f() {
        return "webcast";
    }

    public final void j() {
        super.j();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        Iterator r10 = ((List) this.f.getValue()).iterator();     // Catch: Throwable -> L19
    L5:
        if (r10.hasNext() == false) goto L7;
        ((com.bytedance.ies.web.jsbridge2.f) r10.next()).terminateActualProxy();     // Catch: Throwable -> L19
        goto L5
    L7:
        ((List) this.f.getValue()).clear();     // Catch: Throwable -> L19
        Iterator r11 = ((List) this.g.getValue()).iterator();     // Catch: Throwable -> L19
    L9:
        if (r11.hasNext() == false) goto L11;
        ((com.bytedance.ies.bullet.core.kit.bridge.j) r11.next()).release();     // Catch: Throwable -> L19
        goto L9
    L11:
        ((List) this.g.getValue()).clear();     // Catch: Throwable -> L19
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L17;
        k r12 = this.i;     // Catch: Throwable -> L19
        if (r12 == null) goto L16;
        r12.c.clear();     // Catch: Throwable -> L19
    L16:
        this.i = null;     // Catch: Throwable -> L19
    L17:
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L22:
        if (Result.exceptionOrNull-impl(r13) == null) goto L24;
        ((List) this.f.getValue()).clear();
        ((List) this.g.getValue()).clear();
    L24:
        ((ConcurrentHashMap) this.h.getValue()).clear();
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L40;
        e r0 = t.a;
        Intrinsics.checkNotNullParameter(this, "finder");
        Iterator r14 = ((CopyOnWriteArraySet) t.c).iterator();
    L28:
        if (r14.hasNext() == false) goto L41;
        WeakReference r15 = (WeakReference) r14.next();
        if (Intrinsics.areEqual(r15.get(), this) == false) goto L28;
        ((CopyOnWriteArraySet) t.c).remove(r15);
        return;
    L41:
        return;
    L40:
        return;
    L19:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public StateMethodFinder(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        this.d = r10;
        this.e = LazyKt.lazy(StateMethodFinder$creatorClassCacheWithBiz$2.INSTANCE);
        this.f = LazyKt.lazy(StateMethodFinder$statefulMethods$2.INSTANCE);
        this.g = LazyKt.lazy(StateMethodFinder$jsb2BridgeMethods$2.INSTANCE);
        this.h = LazyKt.lazy(StateMethodFinder$highStatelessJSBInstances$2.INSTANCE);
        e r0 = t.a;
        this.i = new k(t.b);
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L5;
        Intrinsics.checkNotNullParameter(this, "finder");
        Collection<WeakReference<StateMethodFinder>> r11 = t.c;
        CopyOnWriteArraySet r12 = (CopyOnWriteArraySet) r11;
        r12.add(new WeakReference(this));
    L5:
        this.j = new LruCache(100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class k(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r11 = Class.forName(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class<?> r12 = Class.forName(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    public final boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bizId");
        return Intrinsics.areEqual(r10, "webcast");
    }

    public final IDLXBridgeMethod h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Class<?> r1 = l(r10, "webcast");     // Catch: Throwable -> L28
        boolean r11 = true;
        if (r1 != null) goto L20;
        r1 = l(r10, "webcast_sdk");     // Catch: Throwable -> L28
        if (r1 != null) goto L20;
        Map r12 = x26.a.a;     // Catch: Throwable -> L28
        w26.g r13 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L28
        if (r13 == null) goto L14;
        w26.e r14 = (w26.e) r13.n0(w26.e.class);     // Catch: Throwable -> L28
        if (r14 == null) goto L14;
        Boolean r15 = r14.e0();     // Catch: Throwable -> L28
        if (r15 == null) goto L14;
        r11 = r15.booleanValue();     // Catch: Throwable -> L28
    L14:
        if (r11 == false) goto L18;
        k r16 = this.i;     // Catch: Throwable -> L28
        if (r16 != null) goto L32;
        return null;
    L32:
        return r16.a(this.d, r10);
    L18:
        e r17 = t.a;     // Catch: Throwable -> L28
        return t.a(this.d, r10);
    L20:
        Method r18 = r1.getDeclaredMethod("create", new Class[]{m16.b.class});     // Catch: Throwable -> L28
        r18.setAccessible(true);     // Catch: Throwable -> L28
        Object r19 = r18.invoke(null, new Object[]{this.d});     // Catch: Throwable -> L28
        if ((r19 instanceof com.bytedance.ies.bullet.core.kit.bridge.j) == false) goto L25;
        ((List) this.g.getValue()).add(r19);     // Catch: Throwable -> L28
        int r20 = com.bytedance.ies.bullet.base.bridge.i.a;     // Catch: Throwable -> L28
        return com.bytedance.ies.bullet.base.bridge.i.a((com.bytedance.ies.bullet.service.base.bridge.b) r19);
    L25:
        if ((r19 instanceof com.bytedance.ies.bullet.core.kit.bridge.c) == false) goto L29;
        int r21 = com.bytedance.ies.bullet.base.bridge.i.a;     // Catch: Throwable -> L28
        return com.bytedance.ies.bullet.base.bridge.i.b((IBridgeMethod) r19);
    L29:
        return null;
    }

    public final IDLXBridgeMethod d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bizId");
        Intrinsics.checkNotNullParameter(r11, "methodName");
        com.bytedance.ies.web.jsbridge2.f.b r0 = m.a.get(r11);
        if (r0 == null) goto L6;
        com.bytedance.ies.web.jsbridge2.f r12 = r0.a();
        ((List) this.f.getValue()).add(r12);
        int r1 = com.bytedance.ies.bullet.base.bridge.i.a;
        return com.bytedance.ies.bullet.base.bridge.i.a(n.a(r11, r12, this.d));
    L6:
        com.bytedance.ies.web.jsbridge2.g r13 = (com.bytedance.ies.web.jsbridge2.g) ((ConcurrentHashMap) this.h.getValue()).get(r11);
        if (r13 == null) goto L10;
        int r14 = com.bytedance.ies.bullet.base.bridge.i.a;
        return com.bytedance.ies.bullet.base.bridge.i.a(n.b(r11, r13, this.d));
    L10:
        IDLXBridgeMethod r15 = g().a(r10, r11);
        if (r15 == null) goto L14;
        return r15;
    L14:
        if (b(r10) == true) goto L16;
        return null;
    L16:
        IDLXBridgeMethod r16 = h(r11);
        if (r16 != null) goto L19;
        return null;
    L19:
        if ((r16 instanceof com.bytedance.sdk.xbridge.cn.protocol.h) == false) goto L22;
        g().b(r10, r16);
    L22:
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.ENABLE_ANNIEX_STATEFUL_JSB_CACHE.a(), Boolean.TRUE) == false) goto L24;
        this.j.put(r16.toString(), r16);
    L24:
        return r16;
    }

    public final Class<?> l(String r19, String r20) {
        if (((ConcurrentHashMap) this.e.getValue()).get(r20) != null) goto L5;
        ConcurrentHashMap r1 = new ConcurrentHashMap(100);
        ((ConcurrentHashMap) this.e.getValue()).put(r20, r1);
    L6:
        ConcurrentHashMap r10 = r1;
        Class<?> r11 = (Class) r10.get(r19);
        Class r12 = MethodFinder.c;
        if (r11 != null) goto L14;
        int r13 = com.bytedance.sdk.xbridge.cn.protocol.a.a;
        Intrinsics.checkNotNullParameter(r19, "methodName");
        Intrinsics.checkNotNullParameter("webcast", "prefix");
        Intrinsics.checkNotNullParameter(r20, "biz");
        StringBuilder r14 = new StringBuilder("com.bytedance.xbridge.cn.gen.");
        String r17 = StringsKt.replace$default(r19, ".", "_", false, 4, null);
        String r15 = StringsKt.replace$default(r20, ".", "_", false, 4, null);
        StringCompanionObject r16 = StringCompanionObject.INSTANCE;
        r14.append(String.format("%s_Creator_%s_%s", Arrays.copyOf(new Object[]{"webcast", r17, r15}, 3)));
        Class<?> r18 = k(r14.toString());     // Catch: Throwable -> L11
        r10.put(r19, r18);     // Catch: Throwable -> L11
        return r18;
    L11:
        r10.put(r19, r12);
        return null;
    L14:
        if (Intrinsics.areEqual(r11, r12) == false) goto L16;
        return null;
    L16:
        return r11;
    L5:
        Object r21 = ((ConcurrentHashMap) this.e.getValue()).get(r20);
        Intrinsics.checkNotNull(r21);
        r1 = (ConcurrentHashMap) r21;
        goto L6
    }
}
