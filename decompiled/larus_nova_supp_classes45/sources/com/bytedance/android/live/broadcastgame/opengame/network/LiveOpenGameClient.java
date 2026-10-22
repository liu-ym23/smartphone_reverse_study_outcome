package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveOpenGameClient {
    public static final Lazy d = null;
    public static final Lazy e = null;
    public final ConcurrentHashMap<Class<?>, Object> a;
    public final Lazy b;
    public final com.bytedance.android.live.a c;

    public static final class a {
        public static LiveOpenGameClient a() {
            return (LiveOpenGameClient) LiveOpenGameClient.d.getValue();
        }
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        d = LazyKt.lazy(r0, LiveOpenGameClient$Companion$instance$2.INSTANCE);
        e = LazyKt.lazy(r0, LiveOpenGameClient$Companion$commonInstance$2.INSTANCE);
    }

    public LiveOpenGameClient(RetrofitProvider r1) {
        this.c = r1;
        this.a = new ConcurrentHashMap();
        this.b = LazyKt.lazy(LiveOpenGameClient$hasCheckOpenApiServiceSet$2.INSTANCE);
    }

    public final <T> T a(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "cls");
        LocalTestManager.a(new Class[]{wy.a.class});
        if (this.a.contains(r4) == true) goto L10;
        ConcurrentHashMap<Class<?>, Object> r0 = this.a;
        Object r1 = this.c.getRetrofitInstance().create(r4);
        if (r1 == null) goto L8;
        r0.putIfAbsent(r4, r1);
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L10:
        return (T) this.a.get(r4);
    }
}
