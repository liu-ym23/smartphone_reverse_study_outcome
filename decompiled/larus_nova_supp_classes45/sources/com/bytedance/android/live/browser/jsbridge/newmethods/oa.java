package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class oa implements vlc.l {
    public final /* synthetic */ wa a;
    public final /* synthetic */ String b;
    public final /* synthetic */ CallContext c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ oa a;
        public final /* synthetic */ tlc.d b;

        public a(oa r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tlc.d r5 = (tlc.d) r4;
            wa r6 = this.a.a;
            tlc.d r0 = this.b;
            wa.k(r6, r0, r0.getMessageMethod(), this.a.c);
        }
    }

    public oa(wa r1, String r2, CallContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onMessage(tlc.d r5) {
        ALogger.i(this.a.a, "receive wrds v2 msg! key: " + this.b + " get dataSync, msgId: " + r5.getMessageId() + ", msgMethod: " + r5.getMessageMethod() + " isFromWrds: " + com.ss.ugc.live.sdk.msg.utils.a.b(r5));
        Observable.just(r5).observeOn(Schedulers.io()).subscribe(new a(this, r5));
    }
}
