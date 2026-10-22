package com.obric.cae.libs.multipath;

import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class a implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaeMultipathClient f5427a;

    public a(CaeMultipathClient r8) {
        this.f5427a = r8;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        Log.w("CaeMultipathClient", "Service binder died, reconnecting...");
        CaeMultipathClient r8 = this.f5427a;
        r8.f5422a = null;
        r8.f5424c.sendEmptyMessage(1);
    }
}
