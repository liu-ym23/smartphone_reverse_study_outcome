package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.ILiveCoreService;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z2 implements SingleObserver<JSONObject> {
    public final /* synthetic */ CallContext a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ a3 d;

    public final void onError(Throwable r8) {
        this.d.finishWithFailure(r8);
        WebView r2 = this.d.b;
        String r3 = this.b;
        String r4 = this.c;
        IBrowserService r0 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r0 == null) goto L6;
        r0.webViewMonitorHelper().a(r2, r3, r4, -1, r8.getMessage());
        return;
    }

    public final void onSubscribe(Disposable r2) {
        this.d.a = r2;
    }

    public final void onSuccess(Object r9) {
        JSONObject r11 = (JSONObject) r9;
        JSONObject r0 = new JSONObject();
        int r4 = r11.optInt("status_code");     // Catch: JSONException -> L10
        RequestError r1 = new RequestError();     // Catch: JSONException -> L10
        ((ILiveCoreService) jc1.k.f(ILiveCoreService.class)).minorInterceptOld(null, r4, "live_detail", r1, null);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r1.alert) == true) goto L8;
        Activity r2 = ContextUtil.contextToActivity(this.a.getContext());     // Catch: JSONException -> L10
        if (r2 == null) goto L8;
        ExceptionUtils.displayAlert(r2, r1.alert, com.bytedance.android.live.core.utils.s1.B(2131915969));     // Catch: JSONException -> L10
    L8:
        r0.put("raw", r11);     // Catch: JSONException -> L10
        this.d.finishWithResult(r0);     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        this.d.finishWithFailure(e);
        WebView r3 = this.d.b;
        String r5 = this.b;
        String r6 = this.c;
        IBrowserService r7 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r7 == null) goto L17;
        r7.webViewMonitorHelper().a(r3, r5, r6, -1, e.getMessage());
        return;
    }

    public z2(a3 r1, CallContext r2, String r3, String r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
