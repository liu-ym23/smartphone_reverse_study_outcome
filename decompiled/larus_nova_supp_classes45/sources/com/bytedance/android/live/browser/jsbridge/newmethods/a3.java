package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.webkit.WebView;
import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.network.impl.interceptor.RequestInterceptorConstants;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public Disposable a;
    public final WebView b;

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public a3(WebView r1) {
        this.b = r1;
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
        Logger.d("FetchMethod", "build url is " + r0.build());
        return r0.build();
    }

    public final void invoke(Object r11, CallContext r12) throws Exception {
        JSONObject r13 = (JSONObject) r11;
        final String r1 = r13.optString(LiveSlardarConstants.EXTRA_KEY_URL, "");
        String r2 = r13.optString("method", "get").toLowerCase();
        final JSONObject r3 = r13.optJSONObject("headers");
        final JSONObject r4 = r13.optJSONObject("params");
        final JSONObject r14 = r13.optJSONObject("data");
        if (r4 != null) goto L28;
        r4 = new JSONObject();
    L28:
        r4.put("live_request_from_jsb", 1);     // Catch: JSONException -> L7
    L26:
        IMiddleWareHostContext r5 = jc1.k.f(IMiddleWareHostContext.class);     // Catch: JSONException -> L22
        if (r5 == null) goto L24;
        Map r6 = r5.getFEParamExtra();     // Catch: JSONException -> L22
        if (r6 == null) goto L24;
        Iterator r7 = r6.keySet().iterator();     // Catch: JSONException -> L22
    L15:
        if (r7.hasNext() == false) goto L24;
        String r8 = (String) r7.next();     // Catch: JSONException -> L22
        String r9 = (String) r6.get(r8);     // Catch: JSONException -> L22
        if (mz.c.b(r8) == true) goto L15;
        if (mz.c.b(r9) == true) goto L15;
        r4.put(r8, r9);     // Catch: JSONException -> L22
    L24:
        Single.just(r2).subscribeOn(Schedulers.io()).map(new y2(r1, r4, r3, r14)).observeOn(AndroidSchedulers.mainThread()).subscribe(new z2(this, r12, r1, r2));
        return;
    L22:
        e = move-exception;
        ALogger.e("FetchMethod", e);
    L7:
        e = move-exception;
        ALogger.e("FetchMethod", e);
        goto L26
    }
}
