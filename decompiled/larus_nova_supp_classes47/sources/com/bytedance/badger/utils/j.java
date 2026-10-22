package com.bytedance.badger.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
class j extends ResultReceiver {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ Runnable b;
    public final /* synthetic */ o c;
    public final /* synthetic */ x d;

    public j(x r1, Handler r2, AtomicBoolean r3, q r4, com.bytedance.badger.z.g0 r5) {
        this.d = r1;
        this.a = r3;
        this.b = r4;
        this.c = r5;
        super(r2);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r4, Bundle r5) {
        if (this.a.compareAndSet(false, true) == true) goto L6;
        com.bytedance.badger.e.g("OppoIDHelper", "fetch# onReceiveResult completed, code=" + r4);
        return;
    L6:
        this.d.b.removeCallbacks(this.b);
        if (r5 == null) goto L15;
        String r0 = x.f;
        if (r5.containsKey(r0) == false) goto L15;
        JSONObject r6 = new JSONObject(r5.getString(r0));     // Catch: Exception -> L13
        ((com.bytedance.badger.z.g0) this.c).b(r6.optString(x.g, ""));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        o r7 = this.c;
        p r1 = new p(-9006, e.toString());
    L16:
        ((com.bytedance.badger.z.g0) r7).a(r1);
        return;
    L15:
        r7 = this.c;
        r1 = new p(r4, null);
        goto L16
    }
}
