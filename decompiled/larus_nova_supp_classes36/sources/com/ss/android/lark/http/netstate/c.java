package com.ss.android.lark.http.netstate;

import android.os.Handler;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public volatile NetworkUtils.NetworkType a;
    public final AtomicReference<Handler> b;
    public final Set<com.ss.android.lark.http.netstate.a> c;

    public static class a {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public c() {
        this.b = new AtomicReference(null);
        this.c = Collections.newSetFromMap(new ConcurrentHashMap());
        this.a = NetworkUtils.NetworkType.UNKNOWN;
    }

    public final void a(com.ss.android.lark.http.netstate.a r3) {
        if (r3 == null) goto L7;
        this.c.add(r3);
        if (this.a == NetworkUtils.NetworkType.UNKNOWN) goto L8;
        r3.a(this.a);
        return;
    L8:
        return;
    }

    public final void b(final NetworkUtils.NetworkType r6) {
        Log.i("NetworkStateManager", "updateNetworkType new type:" + r6 + ", current type:" + this.a);
        if (this.a.getValue() == r6.getValue()) goto L5;
    L6:
        this.a = r6;
        Handler r0 = this.b.get();
        if (r0 != null) goto L19;
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("NetworkStateManager");
        ThreadMethodProxy.start(r1);
        Handler r2 = new Handler(r1.getLooper());
        AtomicReference<Handler> r3 = this.b;
    L11:
        if (r3.compareAndSet(null, r2) == true) goto L12;
        if (r3.get() == null) goto L11;
        boolean r4 = false;
    L16:
        if (r4 == false) goto L18;
        Log.i("NetworkStateManager", "initHandlerThread done!");
        r0 = r2;
        goto L19
    L18:
        r1.quitSafely();
        r0 = this.b.get();
        goto L19
    L12:
        r4 = true;
    L19:
        r0.post(new b(this, r6));
        return;
    L5:
        if (this.a == NetworkUtils.NetworkType.UNKNOWN) goto L6;
    }
}
