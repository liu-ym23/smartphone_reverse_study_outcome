package com.google.common.cache;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f8690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f8692c;
    public final /* synthetic */ com.google.common.util.concurrent.w0 d;
    public final /* synthetic */ LocalCache$Segment e;

    public a0(LocalCache$Segment r5, Object r10, int r11, y r12, com.google.common.util.concurrent.w0 r13) {
        this.e = r5;
        this.f8690a = r10;
        this.f8691b = r11;
        this.f8692c = r12;
        this.d = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y r5 = this.f8692c;
        this.e.getAndRecordStats(this.f8690a, this.f8691b, r5, this.d);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        q0.f8742v.log(Level.WARNING, "Exception thrown during refresh", th);
        r5.f8778b.k(th);
    }
}
