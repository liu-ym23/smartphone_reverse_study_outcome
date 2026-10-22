package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements vlc.l {
    public final /* synthetic */ CallContext a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ tlc.d b;

        public a(d r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tlc.d r5 = (tlc.d) r4;
            int r0 = com.bytedance.android.live.browser.jsbridge.d.a;
            String r1 = null;
            if ((r5 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L5;
            r5 = null;
        L5:
            com.bytedance.android.live.base.model.message.t r6 = (com.bytedance.android.live.base.model.message.t) r5;
            if (r6 == null) goto L8;
            r1 = r6.getMessageMethod();
        L8:
            String r7 = com.bytedance.android.live.browser.jsbridge.d.b(r1);
            this.b.setMessageMethod(r7);
            JSONObject r2 = new JSONObject();
            r2.put("data_v2", GsonProtectorUtils.toJson(GsonHelper.getLynxWorkaround(), this.b));
            r2.put("messageType", r7);
            this.a.a.b("H5_commonMessage", r2);
        }
    }

    public d(CallContext r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r3) {
        Observable.just(r3).observeOn(Schedulers.io()).subscribe(new a(this, r3));
    }
}
