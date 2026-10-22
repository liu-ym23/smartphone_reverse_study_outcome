package com.bytedance.badger.utils;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class D extends Lambda implements Function0 {
    public static final D a = null;

    static {
        a = new D();
    }

    public D() {
        super(0);
    }

    public Object invoke() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("Badger-VivoId-Transfer");
        ThreadMethodProxy.start(r0);
        return r0;
    }
}
