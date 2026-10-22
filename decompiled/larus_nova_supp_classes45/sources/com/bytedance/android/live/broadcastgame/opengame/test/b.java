package com.bytedance.android.live.broadcastgame.opengame.test;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ OpenGameTestHelper a;

    public b(OpenGameTestHelper r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        if (((Boolean) r1).booleanValue() == false) goto L7;
        OpenGameTestFloatBall r2 = this.a.b;
        if (r2 == null) goto L11;
        r2.setVisible();
        return;
    L11:
        return;
    L7:
        OpenGameTestFloatBall r3 = this.a.b;
        if (r3 == null) goto L13;
        r3.setGone();
        return;
    }
}
