package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y0 implements SingleObserver<i81.b> {
    public final /* synthetic */ int a;
    public final /* synthetic */ z0 b;

    public final void onError(Throwable r2) {
        com.bytedance.android.live.core.utils.f2.b(2131919867, 0);
    }

    public final void onSubscribe(Disposable r2) {
        this.b.s.add(r2);
    }

    public final void onSuccess(Object r2) {
        i81.b r3 = (i81.b) r2;
        z0 r4 = this.b;
        r4.p = true;
        r4.q = this.a;
    }

    public y0(z0 r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
