package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Action {
    public final /* synthetic */ sh6.b a;
    public final /* synthetic */ c b;

    public b(sh6.b r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        s22.e r0 = (s22.e) sh6.c.b(this.a);
        if (r0 == null) goto L6;
        r0.removeListener(this.b);
        return;
    }
}
