package com.bytedance.android.live.openplatform.impl.base.utils;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveOpenPlatformClient {
    public static final Lazy c = null;
    public static final Lazy d = null;
    public final ConcurrentHashMap<Class<?>, Object> a;
    public final com.bytedance.android.live.a b;

    public static final class a {
        public static LiveOpenPlatformClient a() {
            return (LiveOpenPlatformClient) LiveOpenPlatformClient.d.getValue();
        }

        public static LiveOpenPlatformClient b() {
            return (LiveOpenPlatformClient) LiveOpenPlatformClient.c.getValue();
        }
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        c = LazyKt.lazy(r0, LiveOpenPlatformClient$Companion$instance$2.INSTANCE);
        d = LazyKt.lazy(r0, LiveOpenPlatformClient$Companion$commonInstance$2.INSTANCE);
    }

    public LiveOpenPlatformClient(RetrofitProvider r1) {
        this.b = r1;
        this.a = new ConcurrentHashMap();
    }

    public final <T> T a(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "cls");
        if (this.a.contains(r3) == true) goto L10;
        ConcurrentHashMap<Class<?>, Object> r0 = this.a;
        Object r1 = this.b.getRetrofitInstance().create(r3);
        if (r1 == null) goto L8;
        r0.putIfAbsent(r3, r1);
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L10:
        return (T) this.a.get(r3);
    }
}
