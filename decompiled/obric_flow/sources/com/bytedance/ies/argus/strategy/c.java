package com.bytedance.ies.argus.strategy;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f5138a;

    public c(fj.a r5) {
        Intrinsics.checkNotNullParameter(r5, "contextProvider");
        a();
        new ConcurrentHashMap();
        this.f5138a = LazyKt.lazy(new ContainerStrategyEngine$statelessHandler$2(this));
    }

    public static f a() {
        com.bytedance.ies.argus.strategy.provider.client.a r5 = new com.bytedance.ies.argus.strategy.provider.client.a(5);
        com.bytedance.ies.argus.strategy.provider.client.b r10 = new com.bytedance.ies.argus.strategy.provider.client.b();
        com.bytedance.ies.argus.strategy.provider.client.d r11 = new com.bytedance.ies.argus.strategy.provider.client.d();
        com.bytedance.ies.argus.strategy.provider.client.c r12 = new com.bytedance.ies.argus.strategy.provider.client.c();
        com.bytedance.ies.argus.strategy.provider.client.a r13 = new com.bytedance.ies.argus.strategy.provider.client.a(3);
        new LinkedHashMap();
        return new f(new j(CollectionsKt.listOf(new fb.a[]{r5, r10, r11, r12, r13, new com.bytedance.ies.argus.strategy.provider.client.a(1), new com.bytedance.ies.argus.strategy.provider.client.a(2), new com.bytedance.ies.argus.strategy.provider.client.a(6)})));
    }
}
