package com.bytedance.android.live.browser.jsbridge.prefetch;

import android.view.View;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a.c a;

    public c(a.c r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Pair r6 = (Pair) r5;
        JSONObject r0 = (JSONObject) r6.component1();
        Object r7 = r6.component2();
        a r1 = this.a.a;
        View r2 = r1.b;
        if (r2 == null) goto L6;
        if (r7 == null) goto L6;
        r1.g.updateData(r2, r7, true);
    L6:
        this.a.a.j(r0);
    }
}
