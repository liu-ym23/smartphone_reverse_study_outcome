package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.network.impl.interceptor.RequestInterceptorConstants;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "fetchPb")
public final class d3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public Disposable a;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public d3() {
    }

    public static List<NameValuePair> k(JSONObject r5) {
        ArrayList r0 = new ArrayList();
        if (r5 == null) goto L8;
        Iterator<String> r1 = r5.keys();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();
        r0.add(new NameValuePair(r2, r5.optString(r2, "")));
    L8:
        return r0;
    }

    public static String j(String r2, JSONObject r3) {
        UrlBuilder r0 = new UrlBuilder(r2);
        Iterator r4 = ((ArrayList) RequestInterceptorConstants.b(k(r3))).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        NameValuePair r5 = (NameValuePair) r4.next();
        r0.addParam(r5.getName(), r5.getValue());
        goto L4
    L6:
        Logger.d("FetchPbMethod", "build url is " + r0.build());
        return r0.build();
    }

    public final void invoke(Object r6, CallContext r7) throws Exception {
        JSONObject r8 = (JSONObject) r6;
        final String r0 = r8.optString(LiveSlardarConstants.EXTRA_KEY_URL, "");
        String r1 = r8.optString("method", "get").toLowerCase();
        if (r8.optJSONObject("headers") == null) goto L5;
        final JSONObject r2 = r8.optJSONObject("headers");
    L6:
        final JSONObject r3 = r8.optJSONObject("params");
        final JSONObject r9 = r8.optJSONObject("data");
        if (r2 == null) goto L9;
        l30.i.b(r2, r7);
    L9:
        Single.just(r1).subscribeOn(Schedulers.io()).map(new b3(r0, r2, r3, r9)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c3(this));
        return;
    L5:
        r2 = new JSONObject();
        goto L6
    }
}
