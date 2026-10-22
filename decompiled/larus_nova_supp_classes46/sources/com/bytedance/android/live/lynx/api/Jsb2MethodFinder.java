package com.bytedance.android.live.lynx.api;

import com.bytedance.android.annie.xbridge.mix.n;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.sdk.xbridge.cn.protocol.i;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class Jsb2MethodFinder extends a {
    public final i e;
    public m16.b f;
    public final Lazy g;
    public final Lazy h;
    public final String i;

    public final String f() {
        return "annie_live_finder";
    }

    public Jsb2MethodFinder() {
        this.e = new i();
        this.g = LazyKt.lazy(Jsb2MethodFinder$statefulMethodProviderMap$2.INSTANCE);
        this.h = LazyKt.lazy(Jsb2MethodFinder$statefulMethods$2.INSTANCE);
        this.i = "webcast";
    }

    public final void j() {
        super.j();
        Iterator r0 = ((CopyOnWriteArrayList) this.h.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).terminateActualProxy();
        goto L4
    L6:
        ((CopyOnWriteArrayList) this.h.getValue()).clear();
        this.e.c();
        ((ConcurrentHashMap) this.g.getValue()).clear();
    }

    public final IDLXBridgeMethod h(String r3) {
        Intrinsics.checkNotNullParameter(r3, "methodName");
        if (Intrinsics.areEqual((Boolean) xa1.a.c.getValue(), Boolean.TRUE) == false) goto L18;
        if (((ConcurrentHashMap) this.g.getValue()).containsKey(r3) == false) goto L16;
        f.b r0 = (f.b) ((ConcurrentHashMap) this.g.getValue()).get(r3);
        if (r0 == null) goto L13;
        f r1 = r0.a();
        ((CopyOnWriteArrayList) this.h.getValue()).add(r1);
        int r2 = com.bytedance.ies.bullet.base.bridge.i.a;
        m16.b r4 = this.f;
        if (r4 != null) goto L12;
        r4 = new m16.b();
    L12:
        return com.bytedance.ies.bullet.base.bridge.i.a(n.a(r3, r1, r4));
    L13:
        return null;
    L16:
        return this.e.a(this.i, r3);
    L18:
        return this.e.a(this.i, r3);
    }

    public IDLXBridgeMethod d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        Intrinsics.checkNotNullParameter(r3, "methodName");
        return h(r3);
    }

    @Override // com.bytedance.android.live.lynx.api.a
    public final void k(String r4, f.b r5, m16.b r6) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "method");
        if (Intrinsics.areEqual((Boolean) xa1.a.c.getValue(), Boolean.TRUE) == false) goto L7;
        if (r6 == null) goto L6;
        this.f = r6;
    L6:
        ((ConcurrentHashMap) this.g.getValue()).put(r4, r5);
        return;
    L7:
        f r7 = r5.a();
        ((CopyOnWriteArrayList) this.h.getValue()).add(r7);
        i r0 = this.e;
        String r1 = this.i;
        int r2 = com.bytedance.ies.bullet.base.bridge.i.a;
        if (r6 != null) goto L10;
        r6 = new m16.b();
    L10:
        r0.b(r1, com.bytedance.ies.bullet.base.bridge.i.a(n.a(r4, r7, r6)));
    }

    @Override // com.bytedance.android.live.lynx.api.a
    public <P, R> void l(String r4, g<P, R> r5, m16.b r6) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "method");
        i r0 = this.e;
        String r1 = this.i;
        int r2 = com.bytedance.ies.bullet.base.bridge.i.a;
        if (r6 != null) goto L5;
        r6 = new m16.b();
    L5:
        r0.b(r1, com.bytedance.ies.bullet.base.bridge.i.a(n.b(r4, r5, r6)));
    }
}
