package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.lang.reflect.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(s<T> r3, Class<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$bindLifecycle");
        Intrinsics.checkNotNullParameter(r4, "clazz");
        if (r4.isInterface() == false) goto L7;
        r3.C(Proxy.newProxyInstance(r4.getClassLoader(), new Class[]{r4}, new i(r3.getListeners())));
        return;
    L7:
        throw new Exception("LiftCycleDelegate should delegate interface");
    }
}
