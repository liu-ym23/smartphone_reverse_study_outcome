package com.bytedance.android.live.revlink.impl.control;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ CreateLinkLynxWidget a;

    public a(CreateLinkLynxWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        zy0.b r0 = this.a.b;
        if (r0 == null) goto L11;
        xy0.a<?> r1 = r0.g();
        if (r1 == null) goto L12;
        if (r4 == null) goto L8;
        JSONObject r5 = (JSONObject) r4.getSecond();
    L9:
        r1.sendJsEvent("H5_revenueInteractData", String.valueOf(r5));
        return;
    L8:
        r5 = null;
        goto L9
    L12:
        return;
    }
}
