package com.larus.account.base.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ MultiAccountServiceImpl a;
    public final /* synthetic */ q38.b b;

    public /* synthetic */ x(MultiAccountServiceImpl r1, q38.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MultiAccountServiceImpl r0 = this.a;
        q38.b r1 = this.b;
        int r2 = MultiAccountServiceImpl.f;
        r0.a(r1, null);
    }
}
