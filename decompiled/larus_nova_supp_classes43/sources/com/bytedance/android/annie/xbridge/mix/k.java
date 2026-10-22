package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public final Collection<y6.a> a;
    public final ConcurrentHashMap<y6.a, Map<String, Object>> b;
    public final ConcurrentHashMap<String, Object> c;
    public boolean d;

    /* JADX WARN: Multi-variable type inference failed */
    public k(Collection<? extends y6.a> r10) {
        Intrinsics.checkNotNullParameter(r10, "mFactoryCollection");
        this.a = r10;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    public final IDLXBridgeMethod a(m16.b r10, String r11) {
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
        if (r12 == null) goto L14;
        return r12;
    L14:
        if (this.d == true) goto L24;
        if (r0 == null) goto L22;
        Iterator<T> r13 = this.a.iterator();
    L18:
        if (r13.hasNext() == false) goto L22;
        y6.a r14 = (y6.a) r13.next();
        if (r14 == null) goto L18;
        b(r14, r14.e(r0));
        b(r14, r14.d(r0));
        b(r14, r14.l(r0));
        b(r14, r14.k(r0));
        b(r14, r14.o(r0));
        b(r14, r14.n(r0));
    L22:
        this.d = true;
    L24:
        if (com.bytedance.ies.bullet.service.base.h.t() == false) goto L28;
        Object r15 = this.c.get(r11);
        if (r15 == null) goto L34;
        IDLXBridgeMethod r16 = t.b(r11, r15, r10);
    L35:
        if (r16 == null) goto L37;
        return r16;
    L37:
        return null;
    L34:
        r16 = null;
        goto L35
    L28:
        Iterator<Map.Entry<y6.a, Map<String, Object>>> r17 = this.b.entrySet().iterator();
    L30:
        if (r17.hasNext() == false) goto L34;
        Object r18 = r17.next().getValue().get(r11);
        if (r18 == null) goto L30;
        r16 = t.b(r11, r18, r10);
        goto L35
    L7:
        r12 = null;
    L10:
        r12 = null;
        goto L11
    }

    public final void b(y6.a r10, Map<String, ? extends Object> r11) {
        if (com.bytedance.ies.bullet.service.base.h.t() == false) goto L6;
        this.c.putAll(r11);
        return;
    L6:
        if (this.b.containsKey(r10) == true) goto L8;
        this.b.put(r10, new LinkedHashMap());
    L8:
        Map<String, Object> r12 = this.b.get(r10);
        if (r12 == null) goto L13;
        r12.putAll(r11);
        return;
    }
}
