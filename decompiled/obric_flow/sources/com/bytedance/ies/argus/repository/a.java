package com.bytedance.ies.argus.repository;

import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final Lazy d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m.b f5132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5133c;

    static {
        d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ArgusConfigManager$Companion$instance$2.f5130a);
    }

    public a() {
        this.f5131a = new LinkedHashMap();
        Lazy r5 = com.bytedance.ies.argus.base.a.f5012b;
        kotlinx.coroutines.internal.c r10 = jm.c.b().f5013a;
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r10, "scope");
        m.b r11 = new m.b(5);
        new CopyOnWriteArrayList();
        this.f5132b = r11;
        Intrinsics.checkNotNullParameter(jm.c.b().f5013a, "scope");
        new CopyOnWriteArrayList();
        Intrinsics.checkNotNullParameter(jm.c.b().f5013a, "scope");
        new CopyOnWriteArrayList();
        this.f5133c = -1;
    }
}
