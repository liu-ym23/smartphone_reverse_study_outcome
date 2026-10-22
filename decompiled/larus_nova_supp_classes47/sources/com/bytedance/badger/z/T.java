package com.bytedance.badger.z;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class T extends Lambda implements Function0 {
    public static final T a = null;

    static {
        a = new T();
    }

    public T() {
        super(0);
    }

    public Object invoke() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("Badger-Callback-Handler");
        ThreadMethodProxy.start(r0);
        return r0;
    }
}
