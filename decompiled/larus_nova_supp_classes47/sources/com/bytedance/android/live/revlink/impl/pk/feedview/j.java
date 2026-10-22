package com.bytedance.android.live.revlink.impl.pk.feedview;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ FeedPkLynxWidget a;

    public j(FeedPkLynxWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Pair r7 = (Pair) r6;
        FeedPkLynxWidget r0 = this.a;
        if (r0.v(r0.n, (String) r7.getFirst()) == false) goto L5;
        FeedPkLynxWidget r1 = this.a;
        r1.x(r1.m, FeedPkLynxWidget.s(), ((JSONObject) r7.getSecond()).toString());
    L5:
        Iterator<String> r2 = this.a.b.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L16;
        String r3 = r2.next();
        FeedPkLynxWidget r4 = this.a;
        if (r4.v(r4.b.get(r3), (String) r7.getFirst()) == false) goto L7;
        if (this.a.f.contains(r3) == false) goto L7;
        ArrayList r5 = this.a.e.get(r3);
        if (r5 != null) goto L15;
        r5 = new ArrayList();
        this.a.e.put(r3, (ArrayList<JSONObject>) r5);
    L15:
        r5.add(r7.getSecond());
        goto L7
    }
}
