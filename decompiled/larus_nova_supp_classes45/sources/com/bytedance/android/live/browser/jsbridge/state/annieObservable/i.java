package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.subjects.PublishSubject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements l {
    public final /* synthetic */ h a;
    public final /* synthetic */ PublishSubject b;

    public i(h r1, PublishSubject r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onMessage(tlc.d r3) {
        this.b.onNext(GsonProtectorUtils.toJsonTree(this.a.d, r3).getAsJsonObject());
    }
}
