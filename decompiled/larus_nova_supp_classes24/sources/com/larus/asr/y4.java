package com.larus.asr;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class y4 extends CountDownTimer {
    public final /* synthetic */ x4 a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        x4.a(this.a, 0);
        this.a.h.invoke();
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r2) {
        this.a.getClass();
        x4.a(this.a, r2);
    }

    public y4(x4 r1, long r2, long r4) {
        this.a = r1;
        super(r2, r4);
    }
}
