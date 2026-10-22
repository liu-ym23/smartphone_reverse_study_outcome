package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.hardware.SensorManager;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f8<T> implements Consumer {
    public final /* synthetic */ g8 a;

    public f8(g8 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        g8 r5 = this.a;
        SensorManager r0 = r5.a;
        if (r0 == null) goto L9;
        if (fna.g.d() == true) goto L7;
        r0.unregisterListener(r5);
        goto L9
    L7:
        r0.unregisterListener(r5);
        ona.b.c(new ona.a(r5.hashCode(), null));
    L9:
        if (this.a.c == true) goto L12;
        JSONObject r6 = new JSONObject();
        r6.put("code", 0);
        this.a.finishWithResult(r6);
        return;
    }
}
