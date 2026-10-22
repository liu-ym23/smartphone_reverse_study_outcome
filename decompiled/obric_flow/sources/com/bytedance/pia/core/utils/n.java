package com.bytedance.pia.core.utils;

import android.util.Log;
import android.webkit.ValueCallback;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7159b;

    public /* synthetic */ n(Object r5, int r10) {
        this.f7158a = r10;
        this.f7159b = r5;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r5) {
        switch(this.f7158a) {
            case 0: goto L13;
            default: goto L4;
        };
    L4:
        String r10 = (String) r5;
        zi.a r11 = (zi.a) this.f7159b;
        r11.getClass();
        JSONArray r12 = new JSONArray(new JSONObject("{a=" + r10 + '}').optString("a", ""));     // Catch: Exception -> L10
        int r13 = r12.length();     // Catch: Exception -> L10
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L24;
        r11.h(r12.getJSONObject(r14).toString());     // Catch: Exception -> L10
        r14 = r14 + 1;
        goto L7
        goto L23
    L24:
        return;
    L10:
        e = move-exception;
        Log.e("JsBridge", "e =" + e);     // Catch: JSONException -> L17
        return;
    L23:
        return;
    L13:
        String r15 = (String) r5;
        mh.i r16 = (mh.i) this.f7159b;
        if (r16 == null) goto L25;
        r16.accept(r15);
        return;
    }
}
