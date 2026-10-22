package com.bytedance.common.wschannel.server;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3929a;

    public a(b r8) {
        this.f3929a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r8 = this.f3929a;
        Thread.currentThread().setName("MessageDispatcher");     // Catch: Throwable -> L12
    L4:
        Thread.currentThread();     // Catch: Throwable -> L12
        if (Thread.interrupted() == true) goto L14;
        b.f3930h.getAndSet(true);     // Catch: Throwable -> L12
        b.a(r8, (WsChannelService.a) r8.f3935e.take());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
    L14:
        b.f3930h.getAndSet(false);
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L14
    }
}
