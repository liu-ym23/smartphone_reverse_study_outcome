package com.obric.assistant.util;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ p b;
    public final /* synthetic */ long c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;

    public final void a() {
        long r0 = this.a;
        p r2 = this.b;
        if (r0 == r2.k) goto L5;
    L16:
        r2.r = null;
        return;
    L5:
        if (r2.q == null) goto L16;
        long r1 = RangesKt.coerceAtLeast(this.c - SystemClock.uptimeMillis(), 0);
        if (r1 > 0) goto L11;
        this.b.r = null;
        return;
    L11:
        FLogger.a.i("AutoDismissDelegate", "dismiss countdown, ownerId=" + this.b.e + ", generation=" + this.a + ", remainingSeconds=" + (((r1 + 1000) - 1) / 1000) + ", initial=" + this.d + ", reason=" + this.e);
        if (r1 <= 1000) goto L14;
        this.b.g.postDelayed(this, 1000);
        return;
    L14:
        this.b.r = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public q(long r1, p r3, long r4, boolean r6, String r7) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
