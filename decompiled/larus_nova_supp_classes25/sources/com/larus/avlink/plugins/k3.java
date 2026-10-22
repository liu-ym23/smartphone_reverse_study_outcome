package com.larus.avlink.plugins;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k3 extends k4 {
    public final /* synthetic */ DoraTaskPlugin a;

    public k3(DoraTaskPlugin r1) {
        this.a = r1;
    }

    @Override // com.larus.avlink.plugins.k4
    public final void d(int r3) {
        if (r3 != 1) goto L5;
        this.a.t.d(false);
        return;
    L5:
        if (r3 != 2) goto L11;
        this.a.t.d(true);
        return;
    }
}
