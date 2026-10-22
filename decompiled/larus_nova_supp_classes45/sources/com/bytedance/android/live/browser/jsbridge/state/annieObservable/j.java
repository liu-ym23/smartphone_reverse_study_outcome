package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements wlc.b {
    public final /* synthetic */ h a;
    public final /* synthetic */ PublishSubject b;

    public j(h r1, PublishSubject r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void Rk(IStreamMessage r3) {
        this.b.onNext(GsonProtectorUtils.toJsonTree(this.a.d, r3).getAsJsonObject());
    }
}
