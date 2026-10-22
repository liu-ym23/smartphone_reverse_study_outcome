package com.bytedance.bdinstall;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class s0$a implements e0 {
    public final /* synthetic */ s0 a;

    public s0$a(s0 r1) {
        this.a = r1;
    }

    public final void a(n0 r3) {
        s0 r4 = this.a;
        Object r0 = r4.a;
        monitor-enter(r0);
        r4.b = true;     // Catch: Throwable -> L8
        r4.a.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
