package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x0 implements SingleObserver<Object> {
    public final /* synthetic */ z0 a;

    public final void onSuccess(Object r1) {
    }

    public x0(z0 r1) {
        this.a = r1;
    }

    public final void onError(Throwable r2) {
        com.bytedance.android.live.core.utils.f2.b(2131919867, 0);
    }

    public final void onSubscribe(Disposable r2) {
        this.a.s.add(r2);
    }
}
