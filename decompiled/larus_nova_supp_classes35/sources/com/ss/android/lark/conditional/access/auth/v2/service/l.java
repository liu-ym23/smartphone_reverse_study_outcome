package com.ss.android.lark.conditional.access.auth.v2.service;

import android.os.MessageQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements MessageQueue.IdleHandler {
    public final /* synthetic */ PolicyCacheService a;

    public l(PolicyCacheService r1) {
        this.a = r1;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.a.i();
        return false;
    }
}
