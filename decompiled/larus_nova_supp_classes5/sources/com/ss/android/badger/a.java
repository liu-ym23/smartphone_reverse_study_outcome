package com.ss.android.badger;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements com.bytedance.badger.d {
    public a() {
    }

    public final void b(List<? extends Pair<String, ? extends JSONObject>> r3) {
        Iterator r4 = ((ArrayList) r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Pair r0 = (Pair) r4.next();
        com.bytedance.sdk.account.monitor.a.a((String) r0.component1(), (JSONObject) r0.component2());
        goto L4
    }

    public final void a(String r1, JSONObject r2) {
        com.bytedance.sdk.account.monitor.a.a(r1, r2);
    }

    public final void d(String r1, String r2) {
        tb7.a.a(r1, r2);
    }

    public final void e(String r1, String r2) {
        tb7.a.b(r1, r2);
    }

    public final void i(String r1, String r2) {
        tb7.a.d(r1, r2);
    }

    public final void w(String r1, String r2) {
        tb7.a.e(r1, r2);
    }

    public final void e(String r1, String r2, Throwable r3) {
        tb7.a.c(r1, r2, r3);
    }

    public final void i(String r2, String r3, Throwable r4) {
        tb7.a.d(r2, r3 + "\n" + Log.getStackTraceString(r4));
    }

    public final void w(String r1, String r2, Throwable r3) {
        tb7.a.f(r1, r2, r3);
    }
}
