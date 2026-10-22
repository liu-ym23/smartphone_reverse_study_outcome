package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.tools.kcp.aio.runtime.BindsService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v0 implements t {
    public final Class<? extends com.bytedance.android.scope.j> a;
    public final e33.l b;

    @Override // com.bytedance.android.live.revenue.platform.container.impl.t
    public final Class<?> a() {
        e33.l r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "$this$serviceCls");
        KClass r1 = (KClass) CollectionsKt.firstOrNull(r0.b);
        Intrinsics.checkNotNull(r1);
        return JvmClassMappingKt.getJavaClass(r1);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.t
    public final x0 b() {
        ArrayList r0 = new ArrayList();
        List r1 = this.b.b;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(JvmClassMappingKt.getJavaClass((KClass) r3.next()));
        goto L4
    L6:
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        Class r5 = (Class) r4.next();
        BindsService r6 = r5.getAnnotation(BindsService.class);
        if (r6 == null) goto L8;
        String r7 = r6.serviceFullName();
        if (r7 == null) goto L8;
        r0.add(new u(r7, r5));
        goto L8
    L14:
        LinkedHashMap r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r9 = r0.iterator();
    L16:
        if (r9.hasNext() == false) goto L19;
        Object r10 = r9.next();
        r8.put(((u) r10).a, r10);
        goto L16
    L19:
        return new x0(r8, a(), this.a);
    }

    public v0(Class<? extends com.bytedance.android.scope.j> r2, e33.l r3) {
        Intrinsics.checkNotNullParameter(r2, "scopeCls");
        Intrinsics.checkNotNullParameter(r3, "serviceDesc");
        this.a = r2;
        this.b = r3;
    }
}
