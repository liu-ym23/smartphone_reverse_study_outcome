package com.tencent.open.web.security;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.open.c.d;
import com.tencent.open.log.SLog;
import com.tencent.qqmusic.third.api.contract.Keys;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class c extends com.tencent.open.b.a {
    private String d;

    public void a() {
        SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    private void b(String r4) {
        WebView r0 = (WebView) ((com.tencent.open.b.a) this).a.get();
        if (r0 == null) goto L6;
        StringBuffer r1 = new StringBuffer("javascript:if(!!");
        r1.append(this.d);
        r1.append("){");
        r1.append(this.d);
        r1.append("(");
        r1.append(r4);
        r1.append(")}");
        String r5 = r1.toString();
        SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + r5);
        r0.loadUrl(r5);
        return;
    }

    public void a(String r5) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + r5);
        JSONObject r0 = new JSONObject();
        if (d.a == true) goto L5;
        int r1 = -4;
    L12:
        r0.put(ChameleonOpenTracker.ParamKey.RESULT, r1);     // Catch: JSONException -> L8
        r0.put("sn", ((com.tencent.open.b.a) this).b);     // Catch: JSONException -> L8
        r0.put(Keys.API_RETURN_KEY_DATA, r5);     // Catch: JSONException -> L8
    L10:
        b(r0.toString());
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L5:
        r1 = 0;
        goto L12
    }

    public void a(Object r3) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + r3);
    }

    public c(WebView r1, long r2, String r4, String r5) {
        super(r1, r2, r4);
        this.d = r5;
    }
}
