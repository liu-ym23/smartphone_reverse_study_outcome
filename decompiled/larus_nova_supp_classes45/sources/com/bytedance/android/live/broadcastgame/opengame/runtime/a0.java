package com.bytedance.android.live.broadcastgame.opengame.runtime;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a0 {
    public Runnable a;
    public boolean b;

    public a0() {
    }

    public final void a(d.b r2) {
        this.a = r2;
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.b == false) goto L11;
        if (r2 == null) goto L8;
        r2.run();
    L8:
        a(null);
        return;
    }
}
