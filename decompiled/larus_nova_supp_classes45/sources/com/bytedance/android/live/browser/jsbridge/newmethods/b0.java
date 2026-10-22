package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "addRedDot")
public final class b0 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("item")
        String item;

        @SerializedName("type")
        String type;

        public a() {
        }
    }

    public b0() {
    }

    public final Object invoke(Object r3, CallContext r4) throws Exception {
        a r5 = (a) r3;
        if (TextUtils.equals(r5.type, NewBroadcastMonitor.STAGE.TOOLBAR) == false) goto L8;
        if (TextUtils.equals(r5.item, "gift") == false) goto L14;
        xs2.b.a().post(new zg1.g0(1, 1));
        return null;
    L14:
        return null;
    L8:
        if (TextUtils.equals(r5.type, "gift_panel") == true) goto L10;
        return null;
    L10:
        if (TextUtils.equals(r5.item, "prop") == false) goto L17;
        xs2.b.a().post(new zg1.g0(2, 1));
        return null;
    L17:
        return null;
    }
}
