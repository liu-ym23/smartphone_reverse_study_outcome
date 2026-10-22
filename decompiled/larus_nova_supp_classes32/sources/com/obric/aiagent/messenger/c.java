package com.obric.aiagent.messenger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ ObricIPCImpl a;

    public /* synthetic */ c(ObricIPCImpl r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricIPCImpl r0 = this.a;
        int r1 = ObricIPCImpl.c;
        r0.a();
    }
}
