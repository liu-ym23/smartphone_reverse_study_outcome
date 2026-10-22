package com.larus.common.pollingconfig.impl;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import s09.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ PollingConfigImpl a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Triple d;

    public /* synthetic */ b(PollingConfigImpl r1, int r2, long r3, Triple r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PollingConfigImpl r0 = this.a;
        int r2 = this.b;
        long r3 = this.c;
        Triple r6 = this.d;
        int r1 = PollingConfigImpl.s;
        FLogger.a.i("PollingConfigImpl", "notifySuccess listeners:" + r0.i.size());
        a r4 = new a(r0.d, r0.e);
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r7 = r0.i.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        s09.b r8 = (s09.b) r7.next();
        long r9 = SystemClock.elapsedRealtime();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        r8.a(r4);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        r5.put(r8.getUniqueId(), Long.valueOf(SystemClock.elapsedRealtime() - r9));
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L11:
        r0.k(true, r2, r3, r5, r6, null);
    }
}
