package com.bytedance.android.live.browser.jsbridge.newmethods;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c3 implements SingleObserver<String> {
    public final /* synthetic */ d3 a;

    public c3(d3 r1) {
        this.a = r1;
    }

    public final void onError(Throwable r2) {
        this.a.finishWithFailure(r2);
    }

    public final void onSubscribe(Disposable r2) {
        this.a.a = r2;
    }

    public final void onSuccess(Object r3) {
        String r4 = (String) r3;
        JSONObject r0 = new JSONObject();
        r0.put("raw", r4);     // Catch: JSONException -> L5
        this.a.finishWithResult(r0);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        this.a.finishWithFailure(e);
    }
}
