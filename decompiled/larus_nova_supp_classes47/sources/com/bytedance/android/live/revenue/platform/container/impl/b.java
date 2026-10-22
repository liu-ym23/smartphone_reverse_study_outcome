package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends m implements com.bytedance.android.scope.o {
    public final Map<Method, RpcMethodImpl<?>> f;
    public final CompositeDisposable g;
    public final vy0.c h;
    public final zh6.c i;

    public final void onStart() {
        Iterator r0 = ((List) c.b.getValue(null, c.a[0])).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        this.i.i1(r1);
        goto L4
    L6:
        com.bytedance.revenue.platform.api.core.rx.f.a(this.h.O3(new JsDriverBridgeFactory()), this.g);
    }

    public final void onStop() {
        this.g.dispose();
    }

    public b(vy0.c r2, zh6.c r3) {
        Intrinsics.checkNotNullParameter(r2, "hybridService");
        Intrinsics.checkNotNullParameter(r3, "hostGlobalMessageManager");
        this.h = r2;
        this.i = r3;
        this.f = new LinkedHashMap();
        this.g = new CompositeDisposable();
    }

    @Override // ny0.a
    public final <SERVICE> SERVICE x(KClass<SERVICE> r7, CenterServiceType r8) {
        Intrinsics.checkNotNullParameter(r7, "service");
        Intrinsics.checkNotNullParameter(r8, "centerServiceType");
        LinkedHashMap r0 = (LinkedHashMap) this.c;
        SERVICE r1 = (SERVICE) r0.get(r7);
        if (r1 != null) goto L13;
        Class r2 = JvmClassMappingKt.getJavaClass(r7);
        BindsService r3 = r2.getAnnotation(BindsService.class);
        if (r3 == null) goto L7;
        String r4 = r3.serviceFullName();
    L8:
        Intrinsics.checkNotNull(r4);
        r1 = (SERVICE) Proxy.newProxyInstance(r2.getClassLoader(), new Class[]{r2}, new a(this, r4, r8));
        if (r1 == null) goto L12;
        r0.put(r7, r1);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type SERVICE");
    L7:
        r4 = null;
    L13:
        return r1;
    }
}
