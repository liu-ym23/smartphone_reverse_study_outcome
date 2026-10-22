package com.obric.assistant.provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ CameraAutoSendProvider a;

    public /* synthetic */ b(CameraAutoSendProvider r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final CameraAutoSendProvider r0 = this.a;
        int r1 = CameraAutoSendProvider.a;
        com.obric.assistant.spi.keyguard.a.a(new c(r0), new d(), null, false, 28);
    }
}
