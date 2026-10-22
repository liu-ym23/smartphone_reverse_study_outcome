package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t {
    public static e a;
    public static final ConcurrentLinkedQueue<y6.a> b = null;
    public static final Collection<WeakReference<StateMethodFinder>> c = null;
    public static final ConcurrentHashMap<y6.a, Map<String, Object>> d = null;
    public static final ConcurrentHashMap<String, Integer> e = null;

    static {
        b = new ConcurrentLinkedQueue();
        c = new CopyOnWriteArraySet();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
    }

    @Deprecated(message = "该方法已经废弃，只作为实验兜底。findMethod 不走该单例的实现，已经使用实例级别的实现 MethodFactoryHolder.findMethodByManager")
    public static IDLXBridgeMethod a(m16.b r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        Intrinsics.checkNotNullParameter(r11, "methodName");
        JSBridgeManager r0 = (JSBridgeManager) r10.c(JSBridgeManager.class);
        if ((r0 instanceof JSBridgeManager) == false) goto L10;
        DefaultMixMethodCache r1 = r0.v;
        if (r1 == null) goto L7;
        IDLXBridgeMethod r12 = r1.a(r11, r10);
    L8:
        if (r12 == null) goto L10;
    L11:
        if (r12 == null) goto L13;
        return r12;
    L13:
        if (r0 == null) goto L23;
        Iterator<y6.a> r13 = b.iterator();
    L16:
        if (r13.hasNext() == false) goto L23;
        y6.a r14 = r13.next();
        if (r14 == null) goto L16;
        if (d.containsKey(r14) == true) goto L16;
        c(r14, r14.e(r0));
        c(r14, r14.d(r0));
        c(r14, r14.l(r0));
        c(r14, r14.k(r0));
        c(r14, r14.o(r0));
        c(r14, r14.n(r0));
    L23:
        Iterator<Map.Entry<y6.a, Map<String, Object>>> r15 = d.entrySet().iterator();
    L25:
        if (r15.hasNext() == false) goto L29;
        Object r16 = r15.next().getValue().get(r11);
        if (r16 == null) goto L25;
        IDLXBridgeMethod r17 = b(r11, r16, r10);
    L30:
        if (r17 == null) goto L32;
        return r17;
    L32:
        return null;
    L29:
        r17 = null;
        goto L30
    L7:
        r12 = null;
    L10:
        r12 = null;
        goto L11
    }

    public static void c(y6.a r10, Map r11) {
        ConcurrentHashMap<y6.a, Map<String, Object>> r0 = d;
        if (r0.containsKey(r10) == true) goto L5;
        r0.put(r10, new LinkedHashMap());
    L5:
        Map<String, Object> r12 = r0.get(r10);
        if (r12 == null) goto L9;
        r12.putAll(r11);
        return;
    }

    public static IDLXBridgeMethod b(String r10, Object r11, m16.b r12) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "method");
        Intrinsics.checkNotNullParameter(r12, "contextProviderFactory");
        if ((r11 instanceof n56.c) == false) goto L7;
        int r13 = com.bytedance.ies.bullet.base.bridge.i.a;
        n56.c r14 = (n56.c) r11;
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r14, "methodInstance");
        Intrinsics.checkNotNullParameter(r12, "contextProviderFactory");
        return com.bytedance.ies.bullet.base.bridge.i.b(new XBridgeConvertUtilsKt$getIJavaMethodToXBridge$1(r10, r12, r14));
    L7:
        if ((r11 instanceof com.bytedance.ies.web.jsbridge2.g) == false) goto L11;
        int r0 = com.bytedance.ies.bullet.base.bridge.i.a;
        return com.bytedance.ies.bullet.base.bridge.i.a(n.b(r10, (com.bytedance.ies.web.jsbridge2.g) r11, r12));
    L11:
        if ((r11 instanceof com.bytedance.ies.web.jsbridge2.f) == false) goto L15;
        int r1 = com.bytedance.ies.bullet.base.bridge.i.a;
        return com.bytedance.ies.bullet.base.bridge.i.a(n.a(r10, (com.bytedance.ies.web.jsbridge2.f) r11, r12));
    L15:
        if ((r11 instanceof com.bytedance.ies.web.jsbridge2.f.b) == false) goto L18;
        int r15 = com.bytedance.ies.bullet.base.bridge.i.a;
        return com.bytedance.ies.bullet.base.bridge.i.a(n.a(r10, ((com.bytedance.ies.web.jsbridge2.f.b) r11).a(), r12));
    L18:
        return null;
    }
}
