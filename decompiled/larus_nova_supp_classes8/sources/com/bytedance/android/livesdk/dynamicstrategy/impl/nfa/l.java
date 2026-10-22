package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import android.util.LongSparseArray;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements k {
    public final LongSparseArray<m> a;
    public long b;
    public Disposable c;
    public final String d;

    public l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        this.d = r2;
        this.a = new LongSparseArray();
    }

    public final void b(m r9) {
        Intrinsics.checkNotNullParameter(r9, "task");
        int r0 = b.a;
        b.d("Room(" + this.d + ") NfaTimerManager Add Task: [" + r9.a + ',' + r9.b + "]}");
        this.a.put(r9.b, r9);
        Disposable r1 = this.c;
        if (r1 != null) goto L5;
    L6:
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.c = AndroidSchedulers.mainThread().scheduleDirect(new n(r9.a, r9.b, r9.c, this), r9.b - System.nanoTime(), TimeUnit.NANOSECONDS);
        this.b = r9.b;
        return;
    L5:
        if (this.b > r9.b) goto L6;
    }

    public final void c(m r6) {
        Intrinsics.checkNotNullParameter(r6, "task");
        int r0 = b.a;
        b.d("Room(" + this.d + ") NfaTimerManager Remove Task: [" + r6.a + ',' + r6.b + "}] waitingRunnableTime:" + this.b);
        long r1 = r6.b;
        if (r1 != this.b) goto L8;
        Disposable r2 = this.c;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        a(r6.a, this.b);
        return;
    L8:
        this.a.remove(r1);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.k
    public final void a(String r15, long r16) {
        Intrinsics.checkNotNullParameter(r15, "runnableName");
        int r3 = b.a;
        StringBuilder r4 = new StringBuilder("Room(");
        r4.append(this.d);
        r4.append(") NfaTimerManager onRunnableFinished: [");
        r4.append(r15);
        r4.append(',');
        r4.append(r16);
        r4.append(',');
        if (this.a.indexOfKey(r16) < 0) goto L5;
        boolean r5 = true;
    L6:
        r4.append(r5);
        r4.append("}]");
        b.d(r4.toString());
        if (this.a.indexOfKey(r16) >= 0) goto L9;
        return;
    L9:
        this.a.remove(r16);
        this.c = null;
        this.b = 0;
        if (this.a.size() <= 0) goto L19;
        long r10 = this.a.keyAt(0);
        long r12 = r10 - System.nanoTime();
        m r1 = this.a.get(r10);
        if (r1 == null) goto L20;
        b.d("Room(" + this.d + ") NfaTimerManager Next   Runnable: [" + r1.a + ',' + r1.b + ',' + r12 + "}]");
        n r7 = new n(r1.a, r10, r1.c, this);
        if (r12 <= 0) goto L16;
        Disposable r0 = AndroidSchedulers.mainThread().scheduleDirect(r7, r12, TimeUnit.NANOSECONDS);
    L17:
        this.c = r0;
        this.b = r10;
        return;
    L16:
        r0 = AndroidSchedulers.mainThread().scheduleDirect(r7);
        goto L17
    L20:
        return;
    L19:
        return;
    L5:
        r5 = false;
        goto L6
    }
}
