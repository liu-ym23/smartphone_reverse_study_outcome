package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.Logger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class k implements ThreadFactory {
    public static final String b = null;
    public final String a;

    static {
        b = k.class.getSimpleName();
    }

    public k() {
        this.a = "ttnet-io";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(b, "creating newThread " + this.a);
    L6:
        return new PthreadThreadV2(new a(this, r4), this.a);
    }
}
