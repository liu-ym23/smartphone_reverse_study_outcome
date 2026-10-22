package com.bytedance.android.live.effect;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements com.bytedance.android.live.core.log.c {
    public final /* synthetic */ h a;
    public final /* synthetic */ String b;

    public i(h r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "effect sql, duration of " + this.b + ": " + (System.currentTimeMillis() - this.a.a) + ", thread: " + ThreadMethodProxy.currentThread().getName();
    }
}
