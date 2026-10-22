package com.bytedance.android.live.search.impl.search;

import android.util.Pair;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Pair r5 = (Pair) r4;
        if (r5 == null) goto L5;
        List r0 = (List) r5.first;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (((List) r5.first).isEmpty() == true) goto L20;
        Object r1 = r5.second;
        if (r1 == null) goto L22;
        JsonObject r2 = ((FeedExtra) r1).getLogPb();
        if (r2 == null) goto L21;
        Iterator<T> r6 = ((Iterable) r5.first).iterator();
    L16:
        if (r6.hasNext() == false) goto L23;
        FeedItem r3 = (FeedItem) r6.next();
        r3.logPb = r2.toString();
        this.a.getClass();
        e.a(r3);
        goto L16
    L23:
        return;
    L21:
        return;
    L22:
        return;
    L20:
        return;
    L5:
        r0 = null;
        goto L6
    }
}
