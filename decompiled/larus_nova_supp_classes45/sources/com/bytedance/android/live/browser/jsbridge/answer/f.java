package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements l {
    public final /* synthetic */ h a;
    public final /* synthetic */ String b;
    public final /* synthetic */ IBDXBridgeContext c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ tlc.d b;

        public a(f r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tlc.d r5 = (tlc.d) r4;
            h r6 = this.a.a;
            tlc.d r0 = this.b;
            h.a(r6, r0, r0.getMessageMethod(), this.a.c);
        }
    }

    public f(h r1, String r2, IBDXBridgeContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onMessage(tlc.d r5) {
        ALogger.i(this.a.d, "receive message msg! key: " + this.b + ", msgId: " + r5.getMessageId() + ", msgMethod: " + r5.getMessageMethod());
        Observable.just(r5).observeOn(Schedulers.io()).subscribe(new a(this, r5));
    }
}
