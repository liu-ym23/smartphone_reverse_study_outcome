package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements Runnable {
    public final /* synthetic */ PkPs a;

    public g(PkPs r1) {
        this.a = r1;
    }

    public final void a() {
        h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r0 = this.a.a;
        if (r0 == null) goto L19;
        com.bytedance.android.live.messagewindow.framework.process.a r1 = (com.bytedance.android.live.messagewindow.framework.process.a) r0.d();
        if (r1 == null) goto L19;
        y61.b r2 = r1.b;
        if (r2 == null) goto L19;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r3 = r2.monitor();
        if (r3 == null) goto L19;
        CardAlogParamsBuilder r4 = new CardAlogParamsBuilder();
        r4.c("PkPs runnable run");
        int r6 = 0;
        Pair[] r5 = {TuplesKt.to("task", String.valueOf(this.a.g)), TuplesKt.to("skipProcessNext", Boolean.valueOf(this.a.h))};
    L11:
        if (r6 >= 2) goto L18;
        Pair r7 = r5[r6];
        if (r7 == null) goto L17;
        Object r8 = r7.getSecond();
        if (r8 == null) goto L17;
        r4.a((String) r7.getFirst(), r8);
    L17:
        r6 = r6 + 1;
        goto L11
    L18:
        Unit r9 = Unit.INSTANCE;
        r3.d(r4.b());
    L19:
        PkPs r10 = this.a;
        if (r10.h == true) goto L29;
        r10.e();
        PkPs r11 = this.a;
        r11.h = true;
        r11.g = null;
        Disposable r12 = r11.f;
        if (r12 == null) goto L30;
        r12.dispose();
        return;
    L30:
        return;
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
}
