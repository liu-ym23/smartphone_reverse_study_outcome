package com.larksuite.rucket.impl.base.push;

import com.squareup.wire.WireEnum;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final ConcurrentHashMap<Object, a<?>> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static a a(WireEnum r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "command");
        Intrinsics.checkNotNullParameter(r3, "action");
        ConcurrentHashMap<Object, a<?>> r0 = a;
        a<?> r1 = r0.get(r2);
        if (r1 != null) goto L8;
        r1 = (a) r3.invoke();
        a<?> r4 = r0.putIfAbsent(r2, r1);
        if (r4 == null) goto L8;
        r1 = r4;
    L8:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larksuite.rucket.impl.base.push.BasePushRucketJob<T of com.larksuite.rucket.impl.base.push.PushCache.getOrPut>");
        return r1;
    }
}
