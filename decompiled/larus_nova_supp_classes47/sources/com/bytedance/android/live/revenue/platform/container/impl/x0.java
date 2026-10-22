package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x0 implements w0 {
    public final LinkedHashMap<String, y> a;
    public final Map<String, u> b;
    public final Class<?> c;
    public final Class<? extends com.bytedance.android.scope.j> d;

    @Override // com.bytedance.android.live.revenue.platform.container.impl.w0
    public final Map<String, u> a() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.w0
    public final Class<? extends com.bytedance.android.scope.j> b() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.w0
    public final y c(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "interfaceId");
        Intrinsics.checkNotNullParameter(r13, "methodId");
        if (this.a.isEmpty() == false) goto L18;
        Iterator<Map.Entry<String, u>> r0 = this.b.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L18;
        Map.Entry<String, u> r2 = r0.next();
        u r3 = r2.getValue();
        ArrayList r4 = new ArrayList();
        Method[] r5 = r3.b.getDeclaredMethods();
        int r6 = r5.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L13;
        Method r8 = r5[r7];
        BindsRpc r9 = r8.getAnnotation(BindsRpc.class);
        if (r9 == null) goto L12;
        r4.add(new y(r9.rpcName(), r8));
    L12:
        r7 = r7 + 1;
        goto L8
    L13:
        Iterator r10 = r4.iterator();
    L15:
        if (r10.hasNext() == false) goto L6;
        y r14 = (y) r10.next();
        this.a.put(r2.getValue().a + '.' + r14.a, r14);
    L18:
        return this.a.get(r12 + '.' + r13);
    }

    public x0(Map<String, u> r2, Class<?> r3, Class<? extends com.bytedance.android.scope.j> r4) {
        Intrinsics.checkNotNullParameter(r2, "interfaceInfos");
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        Intrinsics.checkNotNullParameter(r4, "scopeCls");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new LinkedHashMap();
    }
}
