package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.subjects.PublishSubject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements l {
    public final /* synthetic */ f a;
    public final /* synthetic */ PublishSubject b;

    public g(f r1, PublishSubject r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onMessage(tlc.d r3) {
        this.b.onNext(GsonProtectorUtils.toJsonTree(this.a.f, r3).getAsJsonObject());
    }
}
