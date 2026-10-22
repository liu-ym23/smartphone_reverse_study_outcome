package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ia implements vlc.l {
    public final /* synthetic */ CallContext a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ia a;
        public final /* synthetic */ tlc.d b;

        public a(ia r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            int r0 = com.bytedance.android.live.browser.jsbridge.d.a;
            String r8 = com.bytedance.android.live.browser.jsbridge.d.b(((tlc.d) r7).getMessageMethod());
            this.b.setMessageMethod(r8);
            JSONObject r1 = new JSONObject();
            String r2 = GsonProtectorUtils.toJson(GsonHelper.getLynxWorkaround(), this.b);
            JSONObject r3 = new JSONObject();
            r3.put("data_v2", r2);
            r3.put("messageType", r8);
            r1.put("data", r3);
            r1.put("data_v2", r2);
            r1.put("messageType", r8);
            this.a.a.b("H5_commonMessage", r1);
        }
    }

    public ia(CallContext r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r3) {
        Observable.just(r3).observeOn(Schedulers.io()).subscribe(new a(this, r3));
    }
}
