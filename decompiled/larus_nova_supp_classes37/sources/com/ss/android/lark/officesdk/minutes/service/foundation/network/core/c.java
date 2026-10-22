package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final l a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final ConcurrentHashMap<Class<?>, Object> c;
    public final Lazy d;
    public final MmNetRequestHandler e;
    public final d f;

    public static final class a {
    }

    static {
    }

    public c(l r2, MinutesUCCImpl r3) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        Intrinsics.checkNotNullParameter(r3, "userContext");
        this.a = r2;
        this.b = r3;
        this.c = new ConcurrentHashMap();
        this.d = LazyKt.lazy(MmNetHandler$scope$2.INSTANCE);
        this.e = new MmNetRequestHandler(r2, r3);
        this.f = new d(r2, r3);
    }
}
