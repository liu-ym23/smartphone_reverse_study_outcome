package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.larus.apm.impl.protector.RunnableProtector;
import f52.i;
import f52.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Runnable {
    public final /* synthetic */ PSTopContainer a;
    public final /* synthetic */ f52.c b;

    public b(PSTopContainer r1, j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        PSTopContainer r0 = this.a;
        f52.c r1 = this.b;
        if (r0.b == true) goto L6;
        PSTopContainer.p("request show after destroy. " + PSTopContainer.m(r1));
        return;
    L6:
        if (r1.f() != ConflictStrategy.INTERRUPT) goto L9;
        PSTopContainer.p("priorityLowerStrategy cannot be INTERRUPT. " + PSTopContainer.m(r1));
    L23:
        boolean r2 = false;
    L24:
        if (r2 == true) goto L27;
        r1.a(DiscardReason.INVALID);
        return;
    L27:
        if (r0.g(r1) == false) goto L32;
        f52.c r3 = r0.a;
        if (r3 == null) goto L47;
        r3.e(r1, r0);
        return;
    L47:
        return;
    L32:
        if (r1.getStartTimestamp() <= 0) goto L41;
        long r6 = r1.getStartTimestamp() - System.currentTimeMillis();
        if (r6 <= 0) goto L37;
        r0.i(r1, r1.getStartTimestamp(), r6);
        return;
    L37:
        if (((-r6) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) > r1.l()) goto L39;
        r0.w(new PSTopContainer.a(r1, r1.getStartTimestamp()));
        return;
    L39:
        i.a("view is expired. " + PSTopContainer.m(r1));
        r1.a(DiscardReason.EXPIRED);
        return;
    L41:
        if (r1.getDelayTime() <= 0) goto L43;
        long r4 = 1000 * ((long) r1.getDelayTime());
        r0.i(r1, System.currentTimeMillis() + r4, r4);
        return;
    L43:
        r0.w(new PSTopContainer.a(r1, System.currentTimeMillis()));
        return;
    L9:
        if (r1.d() != ConflictStrategy.DISCARD) goto L12;
        PSTopContainer.p("priorityHigherStrategy cannot be DISCARD. " + PSTopContainer.m(r1));
        goto L23
    L12:
        if (r1.getEndTimestamp() <= 0) goto L14;
    L16:
        int r5 = r1.getType().getPriority();
        if (r5 >= 0) goto L19;
    L22:
        PSTopContainer.p("invalid priority " + r1.getType().getPriority() + ". " + PSTopContainer.m(r1));
        goto L23
    L19:
        if (100 < r5) goto L22;
        r2 = true;
        goto L24
    L14:
        if (r1.getDuration() >= 0) goto L16;
        PSTopContainer.p("neither endTimestamp nor duration is provided. " + PSTopContainer.m(r1));
        goto L23
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
