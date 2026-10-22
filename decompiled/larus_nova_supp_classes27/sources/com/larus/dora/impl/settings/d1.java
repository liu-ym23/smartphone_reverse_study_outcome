package com.larus.dora.impl.settings;

import android.os.CountDownTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d1 extends CountDownTimer {
    public final /* synthetic */ Function0<Unit> a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
    }

    public d1(Function0<Unit> r5) {
        this.a = r5;
        super(2000, 1000);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r1) {
        if (DoraSetting.b == false) goto L6;
        this.a.invoke();
        cancel();
        return;
    }
}
