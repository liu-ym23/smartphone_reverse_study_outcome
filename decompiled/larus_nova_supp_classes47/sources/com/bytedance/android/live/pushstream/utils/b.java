package com.bytedance.android.live.pushstream.utils;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import org.json.JSONObject;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends PthreadHandlerThreadV2 implements d0.a.a {
    public final d0.a.a c;
    public Handler d;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLooperPrepared() {
        super/*android.os.HandlerThread*/.onLooperPrepared();
        this.d = new Handler(getLooper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(d0.a.a r2) {
        super("LogMonitorAsynWrapper");
        this.c = r2;
        ThreadMethodProxy.start(this);
    }

    public final void a(final String r3, final JSONObject r4) {
        Handler r0 = this.d;
        if (r0 == null) goto L6;
        r0.post(new a(this, r3, r4));
        return;
    }
}
