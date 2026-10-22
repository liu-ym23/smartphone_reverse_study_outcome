package com.larus.call_plugins_doubao_common.manager;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ ValueAnimator a;

    public /* synthetic */ d(ValueAnimator r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ValueAnimator r0 = this.a;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }
}
