package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z0 implements vlc.l {
    public final /* synthetic */ b1 a;
    public final /* synthetic */ CallContext b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ z0 a;
        public final /* synthetic */ tlc.d b;

        public a(z0 r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tlc.d r5 = (tlc.d) r4;
            b1 r6 = this.a.a;
            tlc.d r0 = this.b;
            b1.j(r6, r0, r0.getMessageMethod(), this.a.b);
        }
    }

    public z0(b1 r1, CallContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onMessage(tlc.d r5) {
        ALogger.i(this.a.a, "receive wrds v2 msg! key: " + r5.getMessageMethod() + " get dataSync, msgId: " + r5.getMessageId() + ", isFromWrds: " + com.ss.ugc.live.sdk.msg.utils.a.b(r5));
        Observable.just(r5).observeOn(Schedulers.io()).subscribe(new a(this, r5));
    }
}
