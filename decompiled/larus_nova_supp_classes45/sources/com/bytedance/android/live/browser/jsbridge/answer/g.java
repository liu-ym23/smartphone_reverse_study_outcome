package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements wlc.b {
    public final /* synthetic */ h a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ IBDXBridgeContext c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            IStreamMessage r5 = (IStreamMessage) r4;
            h.a(this.a.a, r5, r5.getMessageMethod(), this.a.c);
        }
    }

    public final void Rk(IStreamMessage r5) {
        if (r5 == null) goto L5;
        ALogger.i(this.a.d, "receive stream Message! key: " + ((String) this.b.element) + ", msgId: " + r5.getMessageId() + ", Listener: " + hashCode() + '}');
        Observable.just(r5).observeOn(Schedulers.io()).subscribe(new a(this));
        return;
    }

    public g(h r1, Ref.ObjectRef r2, IBDXBridgeContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
