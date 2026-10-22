package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ka implements vlc.l {
    public final /* synthetic */ CallContext a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ka a;
        public final /* synthetic */ tlc.d b;

        public a(ka r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            BaseMessage r5 = (tlc.d) r4;
            JSONObject r0 = new JSONObject();
            r0.put("data_v2", GsonProtectorUtils.toJson(GsonHelper.getLynxWorkaround(), this.b));
            if ((r5 instanceof BaseMessage) == true) goto L5;
            BaseMessage r1 = null;
        L6:
            BaseMessage r2 = r1;
            if (r2 == null) goto L10;
            String r3 = r2.getMessageMethod();
            if (r3 == null) goto L10;
        L11:
            r0.put("messageType", com.bytedance.android.live.browser.jsbridge.d.b(r3));
            this.a.a.b("H5_commonMessage", r0);
            return;
        L10:
            r3 = r5.getMessageMethod();
            goto L11
        L5:
            r1 = r5;
            goto L6
        }
    }

    public ka(CallContext r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r3) {
        Observable.just(r3).observeOn(Schedulers.io()).subscribe(new a(this, r3));
    }
}
