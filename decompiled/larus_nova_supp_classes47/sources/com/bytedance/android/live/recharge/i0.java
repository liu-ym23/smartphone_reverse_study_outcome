package com.bytedance.android.live.recharge;

import com.bytedance.android.live.recharge.utils.ApiResult;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0<T> implements Consumer {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ long b;

    public i0(a0 r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        int r0 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.c(this.b, ApiResult.RESPONSE_FAILD.getValue());
        this.a.R.onNext(4);
        this.a.R.onNext(8);
        ReplaySubject<Throwable> r1 = this.a.D;
        r1.onNext((Throwable) r4);
    }
}
