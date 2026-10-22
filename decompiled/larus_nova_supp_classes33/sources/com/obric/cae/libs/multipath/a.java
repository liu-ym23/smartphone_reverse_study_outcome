package com.obric.cae.libs.multipath;

import android.os.IBinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements IBinder.DeathRecipient {
    public final /* synthetic */ CaeMultipathClient a;

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        CaeMultipathClient r0 = this.a;
        r0.a = null;
        r0.c.sendEmptyMessage(1);
    }

    public a(CaeMultipathClient r1) {
        this.a = r1;
    }
}
