package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static void a() {
        if (dc.a.j() == true) goto L5;
        return;
    L5:
        if ((Thread.currentThread() instanceof io.reactivex.internal.schedulers.f) == true) goto L10;
        if (dc.a.l() == true) goto L10;
        return;
    L10:
        throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
    }
}
