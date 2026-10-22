package com.obric.memorydata.sdk.awareness;

import android.os.IBinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class f implements IBinder.DeathRecipient {
    public final /* synthetic */ h a;
    public final /* synthetic */ IBinder b;

    public /* synthetic */ f(h r1, IBinder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        h r0 = this.a;
        IBinder r1 = this.b;
        tka.c.b("ContextAwareness", "ContextAwarenessService died", null);
        e.a.getClass();
        e.c(r0, r1);
    }
}
