package com.obric.assistant.interaction.impl.essentialtask.ipc;

import android.os.IBinder;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements IBinder.DeathRecipient {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Job c;

    public /* synthetic */ a(int r1, String r2, Job r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        EssentialTaskIPCProvider.a(this.a, this.b, this.c);
    }
}
