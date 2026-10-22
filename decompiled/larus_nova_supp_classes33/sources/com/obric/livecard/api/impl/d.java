package com.obric.livecard.api.impl;

import android.os.IBinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements IBinder.DeathRecipient {
    public final /* synthetic */ IslandImpl a;

    public /* synthetic */ d(IslandImpl r1) {
        this.a = r1;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        IslandImpl.a(this.a);
    }
}
