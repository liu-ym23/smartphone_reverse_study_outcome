package com.bytedance.android.livesdk.gift.platform.business.config;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public final HashMap<GiftConfigKey, Object> a;
    public final ConcurrentHashMap<Class<?>, p> b;

    public j() {
        this.a = new HashMap();
        this.b = new ConcurrentHashMap();
    }

    public final <T extends p> T d(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        ConcurrentHashMap<Class<?>, p> r0 = this.b;
        T r1 = r0.get(r3);
        if (r1 != null) goto L8;
        r1 = r3.newInstance();
        p r4 = r0.putIfAbsent(r3, r1);
        if (r4 == null) goto L8;
        r1 = r4;
    L8:
        if (r1 == null) goto L12;
        return (T) r1;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public final void a(Class r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "strategy");
        this.b.put(r2, r3);
    }

    public final void b(GiftConfigKey r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.put(r2, r3);
    }

    public final <V> V c(GiftConfigKey r2, V r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Object r4 = this.a.get(r2);
        if ((r4 instanceof Object) == true) goto L5;
        r4 = null;
    L5:
        if (r4 != null) goto L8;
        return r3;
    L8:
        return (V) r4;
    }
}
