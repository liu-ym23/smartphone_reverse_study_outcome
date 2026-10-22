package com.obric.assistant.card.manager;

import android.os.CountDownTimer;
import android.os.Handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends CountDownTimer {
    public final /* synthetic */ String a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        a.b.remove(this.a);
        a.a.remove(this.a);
        Handler r0 = a.d;
        final String r1 = this.a;
        r0.post(new b(r1));
        a.b(this.a, 1);
    }

    public d(String r5) {
        this.a = r5;
        super(5000, 1000);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(final long r4) {
        Long r0 = Long.valueOf(r4);
        a.b.put(this.a, r0);
        Handler r1 = a.d;
        final String r2 = this.a;
        r1.post(new c(r2, r4));
    }
}
