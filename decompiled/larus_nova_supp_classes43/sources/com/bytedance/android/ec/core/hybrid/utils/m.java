package com.bytedance.android.ec.core.hybrid.utils;

import android.os.SystemClock;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;

    public m(long r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void accept(Object r10) {
        String r11 = (String) r10;
        String r0 = new JSONObject(r11).optJSONObject(com.bytedance.android.ec.core.event.a.KEY_LOG_PB).optString("env");     // Catch: Exception -> L8
        if (r0 == null) goto L5;
    L6:
        JSONObject r1 = p.a;
        Single.fromCallable(new o(r0, SystemClock.elapsedRealtime() - this.a)).subscribeOn(Schedulers.io()).subscribe();
        p.e(new q(r11, 1), this.b);
        p.a();
        return;
    L5:
        r0 = "";
        goto L6
    }
}
