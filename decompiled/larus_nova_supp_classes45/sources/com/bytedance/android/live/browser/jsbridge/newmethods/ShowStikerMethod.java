package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openFaceStickerPanel")
public final class ShowStikerMethod extends com.bytedance.ies.web.jsbridge2.g<Params, Object> {

    public static final class Params {
        public Params() {
        }
    }

    public ShowStikerMethod() {
    }

    public final Object invoke(Object r1, CallContext r2) throws Exception {
        Params r3 = (Params) r1;
        xs2.b.a().post(new zg1.c2());
        return null;
    }
}
