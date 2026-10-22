package com.obric.cae.smartNetwork.AppQoEManager;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements IBinder.DeathRecipient {
    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        AIMediaEventsConsumer.a();
    }
}
