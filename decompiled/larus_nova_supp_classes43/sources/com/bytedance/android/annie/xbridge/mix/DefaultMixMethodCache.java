package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DefaultMixMethodCache {
    public final Lazy a;
    public final ConcurrentHashMap<String, com.bytedance.ies.web.jsbridge2.f.b> b;
    public final ConcurrentHashMap<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> c;
    public final ConcurrentHashMap<String, n56.c> d;

    public DefaultMixMethodCache() {
        this.a = LazyKt.lazy(DefaultMixMethodCache$externalMethodCache$2.INSTANCE);
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public final void f(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.b.remove(r10);
        this.c.remove(r10);
        this.d.remove(r10);
    }

    public final IDLXBridgeMethod a(String r10, m16.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "contextProviderFactory");
        Map r1 = (Map) this.a.getValue();
        if (r1 == null) goto L7;
        boolean r12 = true;
        if (r1.containsKey(r10) != true) goto L7;
    L8:
        z6.a r13 = null;
        if (r12 == false) goto L28;
        Map r0 = (Map) this.a.getValue();
        if (r0 == null) goto L45;
        Object r14 = r0.get(r10);
        if (r14 == null) goto L45;
        if ((r14 instanceof com.bytedance.ies.web.jsbridge2.f.b) == false) goto L26;
        com.bytedance.ies.web.jsbridge2.f r15 = ((com.bytedance.ies.web.jsbridge2.f.b) r14).a();
        if (((HybridFragment) r11.c(HybridFragment.class)) == null) goto L24;
        if ((r15 instanceof z6.a) == false) goto L21;
        r13 = (z6.a) r15;
    L21:
        if (r13 == null) goto L24;
        r13.a();
    L24:
        return t.b(r10, r15, r11);
    L26:
        return t.b(r10, r14, r11);
    L45:
        return null;
    L28:
        if (this.b.containsKey(r10) == false) goto L34;
        com.bytedance.ies.web.jsbridge2.f.b r16 = this.b.get(r10);
        if (r16 == null) goto L45;
        int r17 = com.bytedance.ies.bullet.base.bridge.i.a;
        return com.bytedance.ies.bullet.base.bridge.i.a(n.a(r10, r16.a(), r11));
    L34:
        if (this.c.containsKey(r10) == false) goto L40;
        com.bytedance.ies.web.jsbridge2.g<?, ?> r18 = this.c.get(r10);
        if (r18 == null) goto L45;
        int r19 = com.bytedance.ies.bullet.base.bridge.i.a;
        return com.bytedance.ies.bullet.base.bridge.i.a(n.b(r10, r18, r11));
    L40:
        if (this.d.containsKey(r10) == false) goto L45;
        n56.c r20 = this.d.get(r10);
        if (r20 == null) goto L45;
        int r21 = com.bytedance.ies.bullet.base.bridge.i.a;
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r20, "methodInstance");
        Intrinsics.checkNotNullParameter(r11, "contextProviderFactory");
        return com.bytedance.ies.bullet.base.bridge.i.b(new XBridgeConvertUtilsKt$getIJavaMethodToXBridge$1(r10, r11, r20));
    L7:
        r12 = false;
        goto L8
    }

    public final void b(String r10, com.bytedance.ies.web.jsbridge2.f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        this.b.put(r10, r11);
    }

    public final <P, R> void c(String r10, com.bytedance.ies.web.jsbridge2.g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        this.c.put(r10, r11);
    }

    public final void d(String r10, n56.c r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        this.d.put(r10, r11);
    }

    public final void e(JSBridgeManager r10, IHybridComponent r11) {
        Intrinsics.checkNotNullParameter(r10, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r11, "hybridComponent");
        ((f) Annie.getService$default(f.class, null, 2, null)).B(r10, r11);
    }
}
