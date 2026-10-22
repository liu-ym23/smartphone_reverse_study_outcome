package com.larus.call_plugins_doubao_common.manager;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ ValueAnimator b;

    public /* synthetic */ h(ValueAnimator r1, ValueAnimator r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ValueAnimator r0 = this.a;
        ValueAnimator r1 = this.b;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        r1.start();
    }
}
